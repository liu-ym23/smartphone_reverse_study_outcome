package com.bytedance.android.live.broadcastgame.opengame;

import android.util.Log;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.network.CustomApiServerException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q {
    public static final /* synthetic */ int a = 0;

    public q() {
    }

    static {
    }

    public static /* synthetic */ void h(String r1) {
        g(r1, "");
    }

    public static void a(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        ALogger.d("OpenPlatformLog", "是否可以显示调试悬浮球: " + r2 + "，原因: " + r3);
    }

    public static void b(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        ALogger.d("OpenPlatformLog", "是否可调试当前小插件: " + r2 + "，原因: " + r3);
    }

    public static void c(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r2, LiveSlardarConstants.EXTRA_KEY_URL);
        ALogger.d("OpenPlatformLog", r1 + " 刷新: " + r2);
    }

    public static void e(String r1, Object... r2) {
        Intrinsics.checkNotNullParameter(r2, "messages");
        d(6, r1, r2);
    }

    public static void f(String r1, Object... r2) {
        Intrinsics.checkNotNullParameter(r2, "messages");
        d(4, r1, r2);
    }

    public static void g(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "log");
        Intrinsics.checkNotNullParameter(r2, "subTag");
        if (r2.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r3 = "OpenPlatformLog/".concat(r2);
    L9:
        ALogger.d(r3, r1);
        return;
    L8:
        r3 = "OpenPlatformLog";
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public static void k(String r1, Object... r2) {
        Intrinsics.checkNotNullParameter(r2, "messages");
        d(5, r1, r2);
    }

    public static void d(int r11, String r12, Object[] r13) {
        if (r12 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        String r14 = "OpenPlatformLog";
    L13:
        if (r13.length != 0) goto L15;
        boolean r3 = true;
    L16:
        String r4 = "";
        if (r3 == true) goto L56;
        if (r13.length != 1) goto L27;
        Object r15 = r13[0];
        if (r15 == null) goto L56;
        String r16 = r15.toString();
        if (r16 == null) goto L56;
        r4 = r16;
        goto L56
    L27:
        StringBuilder r5 = new StringBuilder();
        Object r6 = ArraysKt.lastOrNull(r13);
        if (r6 != null) goto L30;
    L36:
        int r7 = r13.length;
        int r8 = 0;
        int r9 = 0;
    L37:
        if (r8 >= r7) goto L54;
        Object r17 = r13[r8];
        int r18 = r9 + 1;
        if (r4.length() <= 0) goto L41;
        boolean r19 = true;
    L42:
        if (r19 == true) goto L44;
    L47:
        if (r17 != null) goto L49;
        r5.append("null");
    L53:
        r8 = r8 + 1;
        r9 = r18;
        goto L37
    L49:
        if ((r17 instanceof Throwable) == false) goto L51;
        r5.append(Log.getStackTraceString((Throwable) r17));
        goto L53
    L51:
        r5.append(r17);
        goto L53
    L44:
        if (r9 == (r13.length - 1)) goto L53;
        if (r9 == 0) goto L47;
        r5.append(r4);
        goto L47
    L41:
        r19 = false;
        goto L42
    L54:
        r4 = r5.toString();
        goto L56
    L30:
        if ((r6 instanceof Delimiter) == false) goto L32;
        String r21 = ((Delimiter) r6).getValue();
    L33:
        if (r21 == null) goto L36;
        r4 = r21;
        goto L36
    L32:
        r21 = "";
    L56:
        if (r11 != 4) goto L58;
        ALogger.i(r14, r4);
        return;
    L58:
        if (r11 != 5) goto L60;
        ALogger.w(r14, r4);
        return;
    L60:
        if (r11 != 6) goto L73;
        ALogger.e(r14, r4);
        return;
    L73:
        return;
    L15:
        r3 = false;
        goto L16
    L11:
        r14 = "OpenPlatformLog/" + r12;
        goto L13
    L5:
        if (r12.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static void i(Throwable r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "t");
        Intrinsics.checkNotNullParameter(r4, "subTag");
        Intrinsics.checkNotNullParameter(r5, "info");
        if ((r3 instanceof CustomApiServerException) == false) goto L6;
        g(r5 + " Api Error. LogId: " + ((CustomApiServerException) r3).getXTtLogId() + " Msg: " + r3.getMessage() + " StatusCode: " + r3 + '.', r4);
        return;
    L6:
        if ((r3 instanceof NetworkErrorException) == false) goto L8;
        g(r5 + ' ' + r3 + ", statusCode: " + ((NetworkErrorException) r3).statusCode + " msg: " + r3.getMessage(), r4);
        return;
    L8:
        g(r5 + ' ' + r3 + " msg: " + r3.getMessage(), r4);
    }

    public static /* synthetic */ void j(Throwable r2, String r3, int r4) {
        String r1 = "";
        if ((r4 & 2) == 0) goto L6;
        r3 = "";
    L6:
        if ((r4 & 4) != 0) goto L9;
        r1 = null;
    L9:
        i(r2, r3, r1);
    }
}
