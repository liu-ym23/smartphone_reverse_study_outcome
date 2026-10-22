package org.apache.poi.ss.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public class CellElapsedFormatter extends CellFormatter {
    private static final Pattern PERCENTS = null;
    private final String printfFmt;
    private final List<TimeSpec> specs;
    private TimeSpec topmost;

    /* JADX INFO: renamed from: org.apache.poi.ss.format.CellElapsedFormatter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ElapsedPartHandler implements CellFormatPart.PartHandler {
        final /* synthetic */ CellElapsedFormatter this$0;

        private ElapsedPartHandler(CellElapsedFormatter r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ElapsedPartHandler(CellElapsedFormatter r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.apache.poi.ss.format.CellFormatPart.PartHandler
        public String handlePart(Matcher r3, String r4, CellFormatType r5, StringBuffer r6) {
            int r7 = r6.length();
            char r8 = r4.charAt(0);
            if (r8 != '\n') goto L5;
            return "%n";
        L5:
            if (r8 != '\"') goto L7;
            r4 = r4.substring(1, r4.length() - 1);
        L42:
            return CellElapsedFormatter.access$200().matcher(r4).replaceAll("%%");
        L7:
            if (r8 == '*') goto L38;
            if (r8 != '0') goto L11;
        L35:
            String r9 = r4.toLowerCase(Locale.ROOT);
            CellElapsedFormatter.access$100(this.this$0, r9.charAt(0), r7, r9.length());
            return r9;
        L11:
            if (r8 != '_') goto L13;
            return null;
        L13:
            if (r8 == 'h') goto L35;
            if (r8 == 'm') goto L35;
            if (r8 == 's') goto L35;
            if (r8 == '[') goto L25;
            if (r8 != '\\') goto L42;
            r4 = r4.substring(1);
            goto L42
        L25:
            if (r4.length() < 3) goto L42;
            if (CellElapsedFormatter.access$000(this.this$0) != null) goto L32;
            String r10 = r4.toLowerCase(Locale.ROOT);
            int r11 = r10.length() - 2;
            CellElapsedFormatter r2 = this.this$0;
            CellElapsedFormatter.access$002(r2, CellElapsedFormatter.access$100(r2, r10.charAt(1), r7, r11));
            return r10.substring(1, r11 + 1);
        L32:
            throw new IllegalArgumentException("Duplicate '[' times in format");
        L38:
            if (r4.length() <= 1) goto L42;
            r4 = CellFormatPart.expandChar(r4);
            goto L42
        }
    }

    private static class TimeSpec {
        final double factor;
        final int len;
        double modBy;
        final int pos;
        final char type;

        public TimeSpec(char r1, int r2, int r3, double r4) {
            this.type = r1;
            this.pos = r2;
            this.len = r3;
            this.factor = r4;
            this.modBy = 0.0d;
        }

        public long valueFor(double r5) {
            double r0 = this.modBy;
            if (r0 != 0.0d) goto L5;
            double r6 = r5 / this.factor;
        L7:
            if (this.type != '0') goto L11;
            return Math.round(r6);
        L11:
            return (long) r6;
        L5:
            r6 = (r5 / this.factor) % r0;
            goto L7
        }
    }

    static {
        PERCENTS = Pattern.compile("%");
    }

    public CellElapsedFormatter(String r7) {
        super(r7);
        ArrayList r0 = new ArrayList();
        this.specs = r0;
        StringBuffer r8 = CellFormatPart.parseFormat(r7, CellFormatType.ELAPSED, new ElapsedPartHandler(this, null));
        ListIterator r1 = r0.listIterator(r0.size());
    L4:
        if (r1.hasPrevious() == false) goto L8;
        TimeSpec r2 = (TimeSpec) ZeusTransformUtils.preCheckCast(r1.previous(), TimeSpec.class, "com.obric.memorydata.plugin");
        r8.replace(r2.pos, r2.pos + r2.len, "%0" + r2.len + "d");
        if (r2.type == this.topmost.type) goto L4;
        r2.modBy = modFor(r2.type, r2.len);
        goto L4
    L8:
        this.printfFmt = r8.toString();
    }

    static /* synthetic */ TimeSpec access$000(CellElapsedFormatter r0) {
        return r0.topmost;
    }

    static /* synthetic */ TimeSpec access$002(CellElapsedFormatter r0, TimeSpec r1) {
        r0.topmost = r1;
        return r1;
    }

    static /* synthetic */ TimeSpec access$100(CellElapsedFormatter r0, char r1, int r2, int r3) {
        return r0.assignSpec(r1, r2, r3);
    }

    static /* synthetic */ Pattern access$200() {
        return PERCENTS;
    }

    private TimeSpec assignSpec(char r8, int r9, int r10) {
        TimeSpec r6 = new TimeSpec(r8, r9, r10, factorFor(r8, r10));
        this.specs.add(r6);
        return r6;
    }

    private static double factorFor(char r5, int r6) {
        if (r5 == '0') goto L18;
        if (r5 != 'h') goto L7;
        return 0.041666666666666664d;
    L7:
        if (r5 != 'm') goto L9;
        return 6.944444444444444E-4d;
    L9:
        if (r5 != 's') goto L12;
        return 1.1574074074074073E-5d;
    L12:
        throw new IllegalArgumentException("Uknown elapsed time spec: " + r5);
    L18:
        return 1.1574074074074073E-5d / Math.pow(10.0d, r6);
    }

    private static double modFor(char r2, int r3) {
        if (r2 == '0') goto L18;
        if (r2 != 'h') goto L7;
        return 24.0d;
    L7:
        if (r2 != 'm') goto L9;
        return 60.0d;
    L9:
        if (r2 != 's') goto L12;
        return 60.0d;
    L12:
        throw new IllegalArgumentException("Uknown elapsed time spec: " + r2);
    L18:
        return Math.pow(10.0d, r3);
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void formatValue(StringBuffer r7, Object r8) {
        double r2 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r2 >= 0.0d) goto L5;
        r7.append('-');
        r2 = -r2;
    L5:
        Long[] r9 = new Long[this.specs.size()];
        int r0 = 0;
    L7:
        if (r0 >= this.specs.size()) goto L9;
        r9[r0] = Long.valueOf(((TimeSpec) ZeusTransformUtils.preCheckCast(this.specs.get(r0), TimeSpec.class, "com.obric.memorydata.plugin")).valueFor(r2));
        r0 = r0 + 1;
        goto L7
    L9:
        Formatter r1 = new Formatter(r7, Locale.ROOT);
        r1.format(this.printfFmt, r9);     // Catch: Throwable -> L13
        r1.close();
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L18
    L20:
        throw th;
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer r1, Object r2) {
        formatValue(r1, r2);
    }
}
