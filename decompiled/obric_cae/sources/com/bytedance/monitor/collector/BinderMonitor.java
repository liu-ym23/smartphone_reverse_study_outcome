package com.bytedance.monitor.collector;

import a8.b;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Keep;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class BinderMonitor extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f3944a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f3945b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile int f3946c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f3947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f3948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f3949c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public StackTraceElement[] f3950d;

        public a() {
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder("{\"start\":");
            r8.append(this.f3947a);
            r8.append(",\"end\":");
            r8.append(this.f3948b);
            r8.append(",\"parcel_size\":");
            r8.append(this.f3949c);
            r8.append(",\"cost_millis\":");
            r8.append(this.f3948b - this.f3947a);
            r8.append(",\"java_stack\":\"");
            StackTraceElement[] r10 = this.f3950d;
            ArrayList r11 = BinderMonitor.f3944a;
            int r12 = 0;
            if (r10 != null) goto L5;
        L18:
            if (r10 != null) goto L20;
            String r13 = "Invalid Stack\n";
        L28:
            return android.aimedia.a.i(r8, r13, "\"}");
        L20:
            StringBuilder r14 = new StringBuilder();
            int r15 = r10.length;
            int r16 = 0;
        L21:
            if (r12 >= r15) goto L26;
            StackTraceElement r17 = r10[r12];
            r16 = r16 + 1;
            r14.append("\\tat " + r17.getClassName());
            r14.append(".");
            r14.append(r17.getMethodName());
            r14.append("(");
            r14.append(r17.getFileName());
            r14.append(BdimCategoryConstants.SEPARATOR_COLON);
            r14.append(r17.getLineNumber());
            r14.append(")\\n");
            if (r16 > 40) goto L26;
            r12 = r12 + 1;
        L26:
            r13 = r14.toString();
            goto L28
        L5:
            if (r10.length == 0) goto L18;
            int r18 = 0;
        L9:
            if (r18 >= r10.length) goto L14;
            if ("saveBinderInfo".equals(r10[r18].getMethodName()) == true) goto L15;
            r18 = r18 + 1;
        L15:
            int r19 = r18 + 1;
            if (r19 > r10.length) goto L18;
            r10 = (StackTraceElement[]) Arrays.copyOfRange(r10, r19, r10.length);
            goto L18
        L14:
            r18 = 0;
            goto L15
        }
    }

    static {
        f3944a = new ArrayList(200);
        f3945b = new Object();
        f3946c = 0;
    }

    @Keep
    private static String getStacktrace() {
        return Log.getStackTraceString(new Exception());
    }

    @Keep
    public static void saveBinderInfo(long r8, long r10, long r11) {
        StackTraceElement[] r12 = Thread.currentThread().getStackTrace();
        Object r13 = f3945b;
        monitor-enter(r13);
        ArrayList r14 = f3944a;     // Catch: Throwable -> L11
        if (r14.size() != 200) goto L7;
        a r15 = (a) r14.get(f3946c % 200);     // Catch: Throwable -> L11
        r15.f3947a = r8;     // Catch: Throwable -> L11
        r15.f3948b = r10;     // Catch: Throwable -> L11
        r15.f3949c = r11;     // Catch: Throwable -> L11
        r15.f3950d = r12;     // Catch: Throwable -> L11
    L8:
        f3946c++;     // Catch: Throwable -> L11
        monitor-exit(r13);     // Catch: Throwable -> L11
        return;
    L7:
        a r16 = new a();     // Catch: Throwable -> L11
        r16.f3947a = r8;     // Catch: Throwable -> L11
        r16.f3948b = r10;     // Catch: Throwable -> L11
        r16.f3949c = r11;     // Catch: Throwable -> L11
        r16.f3950d = r12;     // Catch: Throwable -> L11
        r14.add(r16);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // a8.b
    public final Pair<String, String> a() {
        return new Pair(null, f3944a.toString());
    L5:
        return null;
    }

    @Override // a8.b
    public final Pair<String, String> b(long r10, long r11) {
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L27
        Object r12 = f3945b;     // Catch: Throwable -> L27
        monitor-enter(r12);     // Catch: Throwable -> L27
        int r13 = 0;
    L7:
        if (r13 >= 200) goto L11;
        int r14 = ((f3946c - 1) + r13) % 200;     // Catch: Throwable -> L24
        ArrayList r15 = f3944a;     // Catch: Throwable -> L24
        if (r14 >= r15.size()) goto L11;
        r8.add(r15.get(((f3946c - 1) + r13) % 200));     // Catch: Throwable -> L24
        r13 = r13 + 1;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L11:
        monitor-exit(r12);     // Catch: Throwable -> L24
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L27
        int r17 = r8.size();     // Catch: Throwable -> L27
    L13:
        r17 = r17 - 1;     // Catch: Throwable -> L27
        if (r17 < 0) goto L23;
        a r18 = (a) r8.get(r17);     // Catch: Throwable -> L27
        if (r18.f3947a <= r11) goto L18;
    L19:
        r16.add(r18);     // Catch: Throwable -> L27
    L21:
        if (r18.f3948b >= r10) goto L13;
    L18:
        if (r18.f3948b <= r10) goto L21;
    L23:
        return new Pair(null, r16.toString());
    L27:
        return null;
    }
}
