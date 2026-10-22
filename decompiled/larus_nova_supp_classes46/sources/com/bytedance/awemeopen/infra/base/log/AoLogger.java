package com.bytedance.awemeopen.infra.base.log;

import android.app.Application;
import android.os.Process;
import android.util.Log;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.awemeopen.infra.base.debug.AoDebug;
import com.bytedance.awemeopen.infra.util.ToastUtils;
import com.bytedance.awemeopen.servicesapi.log.AoLogService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoLogger {
    public static int a;
    public static final Lazy b = null;

    public interface a {
        void a();
    }

    public static final class b implements a {
        @Override // com.bytedance.awemeopen.infra.base.log.AoLogger.a
        public final void a() {
        }

        public b(String r1) {
        }
    }

    public static final class c implements a {
        @Override // com.bytedance.awemeopen.infra.base.log.AoLogger.a
        public final void a() {
        }

        public c(String r1) {
        }
    }

    public static final class d implements a {
        @Override // com.bytedance.awemeopen.infra.base.log.AoLogger.a
        public final void a() {
        }

        public d(String r1) {
        }
    }

    public static final class e implements a {
        @Override // com.bytedance.awemeopen.infra.base.log.AoLogger.a
        public final void a() {
        }

        public e(String r1) {
        }
    }

    public static final class f implements a {
        @Override // com.bytedance.awemeopen.infra.base.log.AoLogger.a
        public final void a() {
        }

        public f(String r1) {
        }
    }

    static {
        b = LazyKt.lazy(AoLogger$enableLogcatPrint$2.INSTANCE);
    }

    public static boolean e() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    public static AoLogService f() {
        int r0 = j64.b.a;
        return j64.b.a(AoLogService.class);
    }

    public static String a(Object[] r6) {
        StringBuilder r0 = new StringBuilder();
        if (AoDebug.b() == false) goto L21;
        StackTraceElement[] r1 = new Throwable().getStackTrace();
        String r4 = "unknown";
        String r5 = "";
        if (r1.length <= 2) goto L16;
        StackTraceElement r2 = r1[2];
        if (r2 == null) goto L16;
        String r3 = r2.getMethodName();
        if (r3 == null) goto L12;
        r4 = r3;
    L12:
        int r7 = r2.getLineNumber();
        String r8 = r2.getFileName();
        if (r8 == null) goto L17;
        r5 = r8;
    L17:
        r0.append(r5);
        r0.append(" (");
        if (a > 0) goto L20;
        a = Process.myPid();
    L20:
        r0.append(a);
        r0.append(") [");
        r0.append(r4);
        r0.append(':');
        r0.append(r7);
        r0.append(']');
    L16:
        r7 = -1;
    L21:
        int r9 = r6.length;
        int r10 = 0;
    L22:
        if (r10 >= r9) goto L32;
        Object r11 = r6[r10];
        r0.append(' ');
        if (r11 != null) goto L26;
        r0.append("null");
    L30:
        r10 = r10 + 1;
        goto L22
    L26:
        if ((r11 instanceof Throwable) == false) goto L28;
        r0.append(Log.getStackTraceString((Throwable) r11));
        goto L30
    L28:
        r0.append(r11);
        goto L30
    L32:
        return r0.toString();
    }

    public static String d(String r4) {
        if (r4 != null) goto L6;
        return "ao_";
    L6:
        if (StringsKt.startsWith$default(r4, "ao_", false, 2, null) == false) goto L8;
        return r4;
    L8:
        return "ao_".concat(r4);
    }

    @JvmStatic
    public static final void i(Object... r3) {
        Intrinsics.checkNotNullParameter("AoAppMonitor", "tag");
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        String r0 = d("AoAppMonitor");
        String r4 = a(r3);
        if (AoDebug.c() == true) goto L5;
    L7:
        f().e(r0, r4);
        if (AoDebug.c() == false) goto L11;
        Application r1 = y54.a.a();
        Lazy r2 = ToastUtils.a;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r4, "text");
        ToastUtils.d(r1, r4, 1, null);
        return;
    L11:
        return;
    L5:
        if (e() == false) goto L7;
        k(r4, new com.bytedance.awemeopen.infra.base.log.a(r0));
        goto L7
    }

    @JvmStatic
    public static final void j(Throwable r1) {
        if (AoDebug.c() == false) goto L6;
        r1.printStackTrace();
        return;
    }

    @JvmStatic
    public static final void b(String r1, Object... r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        String r3 = d(r1);
        String r4 = a(r2);
        if (AoDebug.c() == true) goto L5;
    L7:
        f().d(r3, r4);
        return;
    L5:
        if (e() == false) goto L7;
        k(r4, new b(r3));
        goto L7
    }

    @JvmStatic
    public static final void c(String r1, Object... r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        String r3 = d(r1);
        String r4 = a(r2);
        if (AoDebug.c() == true) goto L5;
    L7:
        f().e(r3, r4);
        return;
    L5:
        if (e() == false) goto L7;
        k(r4, new c(r3));
        goto L7
    }

    @JvmStatic
    public static final void g(String r1, Object... r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        String r3 = d(r1);
        String r4 = a(r2);
        if (AoDebug.c() == true) goto L5;
    L7:
        f().i(r3, r4);
        return;
    L5:
        if (e() == false) goto L7;
        k(r4, new d(r3));
        goto L7
    }

    @JvmStatic
    public static final void h(String r2, Object... r3) {
        Intrinsics.checkNotNullParameter(r3, MultiLinkOpenSource.MESSAGE);
        String r4 = d(r2);
        String r0 = a(r3);
        if (AoDebug.c() == true) goto L5;
    L7:
        f().e(r4, r0);
        if (AoDebug.c() == true) goto L10;
        return;
    L10:
        if (r3.length <= 0) goto L17;
        Object r5 = r3[r3.length - 1];
        if ((r5 instanceof Throwable) == false) goto L18;
        Throwable r6 = (Throwable) r5;
        r6.printStackTrace();
        throw new RuntimeException(r6);
    L18:
        return;
    L17:
        return;
    L5:
        if (e() == false) goto L7;
        k(r0, new e(r4));
        goto L7
    }

    public static void k(String r7, a r8) {
        int r0 = r7.length();
        if (r0 > 3800) goto L6;
        r8.a();
        return;
    L6:
        String r2 = "<continue_" + ((System.nanoTime() / ((long) 100)) % ((long) 100000)) + '>';
        StringBuilder r4 = new StringBuilder((r2.length() * 2) + 3800);
        ArrayList r1 = new ArrayList((r0 / 3800) + 1);
        int r5 = 0;
    L7:
        if (r5 >= r0) goto L16;
        r4.setLength(0);
        if (r5 <= 0) goto L11;
        r4.append(r2);
    L11:
        int r6 = r5 + 3800;
        if (r6 < r0) goto L14;
        r4.append(r7, r5, r0);
    L15:
        r1.add(r4.toString());
        r5 = r6;
        goto L7
    L14:
        r4.append(r7, r5, r6);
        r4.append(r2);
        goto L15
    L16:
        Iterator r9 = r1.iterator();
    L18:
        if (r9.hasNext() == false) goto L20;
        String r3 = (String) r9.next();
        r8.a();
        goto L18
    }

    @JvmStatic
    public static final void l(String r1, Object... r2) {
        Intrinsics.checkNotNullParameter(r2, MultiLinkOpenSource.MESSAGE);
        String r3 = d(r1);
        String r4 = a(r2);
        if (AoDebug.c() == true) goto L5;
    L7:
        f().w(r3, r4);
        return;
    L5:
        if (e() == false) goto L7;
        k(r4, new f(r3));
        goto L7
    }
}
