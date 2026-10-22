package com.bytedance.apm6.java_alloc;

import android.os.Build;
import androidx.annotation.NonNull;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import t4.a;

/* JADX INFO: loaded from: classes.dex */
public class JavaAllocReporter {
    private static final Charset US_ASCII = null;
    private final ReportInfoReader reportInfoReader;

    /* JADX INFO: renamed from: com.bytedance.apm6.java_alloc.JavaAllocReporter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class AllocThrowable extends Throwable {
        private final StackTraceElement[] elements;
        private final String msg;

        public AllocThrowable(String r10, StackTraceElement[] r11) {
            this.msg = r10;
            this.elements = r11;
        }

        @Override // java.lang.Throwable
        @NonNull
        public synchronized Throwable fillInStackTrace() {
            monitor-enter(this);
            monitor-exit(this);
            return this;
        }

        @Override // java.lang.Throwable
        @NonNull
        public StackTraceElement[] getStackTrace() {
            return this.elements;
        }

        @Override // java.lang.Throwable
        public String toString() {
            return this.msg;
        }
    }

    public static class ReportInfoReader implements IRecordReader {
        private JavaAllocConfig currentConfig;
        private long endTime;
        private String scene;
        private long startTime;
        private final ReportTraceReader traceReader;

        public ReportInfoReader() {
            this.traceReader = new ReportTraceReader(null);
        }

        @Override // com.bytedance.apm6.java_alloc.IRecordReader
        public void onHeadInfo(String r10, long r11, long r12, int r13, JavaAllocConfig r14, long r15, long r16) {
            this.currentConfig = r14;
            this.startTime = r15;
            this.endTime = r16;
            this.scene = r10;
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Logger.d("JavaAllocReporter", "report totalObjectsCount: " + r11 + ", totalBytes: " + r12 + ", recordCount: " + r13);
            return;
        }

        @Override // com.bytedance.apm6.java_alloc.IRecordReader
        public boolean onItem(String r10, int r11, int r12, Trace r13, int r14) {
            r13.onTrace(this.traceReader);
            if (ReportTraceReader.access$100(this.traceReader).size() <= 0) goto L5;
            reportCustom(r10, r11, r12, ReportTraceReader.access$100(this.traceReader), r14);
        L5:
            this.traceReader.clear();
            return true;
        }

        void reportCustom(String r10, int r11, int r12, List<StackTraceElement> r13, int r14) {
            StackTraceElement[] r15 = (StackTraceElement[]) r13.toArray(new StackTraceElement[0]);
            if (r14 != 1) goto L5;
            String r16 = "HighFrequency";
        L6:
            AllocThrowable r17 = new AllocThrowable("java_alloc(" + r16 + ") class: " + r10, r15);
            if (ApmBaseContext.isDebugMode() == false) goto L9;
            Logger.d("JavaAllocReporter", "report class: " + r10 + ", java_alloc count: " + r11 + ", bytes: " + r12 + ", trace: " + ReportTraceReader.access$200(this.traceReader).toString());
        L9:
            HashMap r18 = new HashMap();
            r18.put("java_alloc_count", String.valueOf(r11));
            r18.put("java_alloc_size", String.valueOf(r12));
            r18.put("java_alloc_sample", String.valueOf(this.currentConfig.collect_per_thousand_alloc));
            r18.put("java_alloc_count_threshold", String.valueOf(this.currentConfig.threshold_alloc_frequency));
            r18.put("java_alloc_size_threshold", String.valueOf(this.currentConfig.threshold_alloc_size));
            r18.put("java_alloc_duration", String.valueOf(this.endTime - this.startTime));
            r18.put("java_alloc_scene", this.scene);
            a.e(r17, "java_alloc", r18);
            return;
        L5:
            r16 = "LargeObject";
            goto L6
        }
    }

    private static class ReportTraceReader implements ITraceReader {
        private final char[] charArrayBuffer;
        private final List<StackTraceElement> elements;
        private final StringBuilder result;

        private ReportTraceReader() {
            this.elements = new ArrayList();
            this.result = new StringBuilder();
            this.charArrayBuffer = new char[4096];
        }

        /* synthetic */ ReportTraceReader(AnonymousClass1 r10) {
            this();
        }

        static /* synthetic */ List access$100(ReportTraceReader r10) {
            return r10.elements;
        }

        static /* synthetic */ StringBuilder access$200(ReportTraceReader r10) {
            return r10.result;
        }

        public void clear() {
            this.elements.clear();
            this.result.setLength(0);
        }

        @Override // com.bytedance.apm6.java_alloc.ITraceReader
        public boolean onItem(byte[] r10, int r11, byte[] r12, int r13, int r14) {
            if (ApmBaseContext.isDebugMode() == false) goto L5;
            StringBuilder r15 = this.result;
            r15.append("  at ");
            r15.append(JavaAllocReporter.convertAscii(r10, this.charArrayBuffer, r11), 0, r11);
            r15.append('(');
            r15.append(JavaAllocReporter.convertAscii(r12, this.charArrayBuffer, r13), 0, r13);
            r15.append(':');
            r15.append(r14);
            r15.append(")\n");
        L5:
            String r16 = String.valueOf(JavaAllocReporter.convertAscii(r10, this.charArrayBuffer, r11), 0, r11);
            String r17 = String.valueOf(JavaAllocReporter.convertAscii(r12, this.charArrayBuffer, r13), 0, r13);
            int r18 = r16.lastIndexOf(46);
            this.elements.add(new StackTraceElement(r16.substring(0, r18), r16.substring(r18 + 1, r11), r17, r14));
            return true;
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        Charset r10 = StandardCharsets.US_ASCII;
    L6:
        US_ASCII = r10;
        return;
    L5:
        r10 = Charset.forName("US-ASCII");
        goto L6
    }

    public JavaAllocReporter() {
        this.reportInfoReader = new ReportInfoReader();
    }

    static char[] convertAscii(byte[] r10, char[] r11, int r12) {
        int r13 = 0;
        if (r12 <= r11.length) goto L8;
        int r14 = r12 - r11.length;
    L6:
        if (r13 >= r11.length) goto L10;
        r11[r13] = (char) (r10[r13 + r14] & 255);
        r13 = r13 + 1;
    L10:
        return r11;
    L8:
        if (r13 >= r12) goto L10;
        r11[r13] = (char) (r10[r13] & 255);
        r13 = r13 + 1;
        goto L8
    }

    public void report() {
        JavaAllocCollector.getInstance().getReportInfo(this.reportInfoReader);
    }
}
