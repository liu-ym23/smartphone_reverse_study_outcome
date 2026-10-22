package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.livesdk.utils.r2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q {
    public static final a c = null;
    public final XplayErrorCode a;
    public final ErrorCodeException b;

    public static final class a {
        public a() {
        }

        public static q d(a r1, Integer r2, String r3) {
            r1.getClass();
            return a(XplayErrorCode.XPLAY_INTERNAL_ERROR, r2, r3, null);
        }

        public static q a(XplayErrorCode r2, Integer r3, String r4, Throwable r5) {
            Intrinsics.checkNotNullParameter(r2, "xplayErrorCode");
            if (r3 != null) goto L10;
            if (r5 != null) goto L10;
            if (r4 != null) goto L10;
            throw new IllegalArgumentException("confirm arguments");
        L10:
            return new q(r2, new ErrorCodeException(r3, r4, r5));
        }

        public static q c(a r2, Integer r3, Throwable r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = null;
        L8:
            r2.getClass();
            return a(XplayErrorCode.UNKNOWN, r3, null, r4);
        }

        public static /* synthetic */ q b(a r2, XplayErrorCode r3, Integer r4, String r5, Throwable r6, int r7) {
            if ((r7 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r7 & 4) == 0) goto L9;
            r5 = null;
        L9:
            if ((r7 & 8) == 0) goto L11;
            r6 = null;
        L11:
            r2.getClass();
            return a(r3, r4, r5, r6);
        }
    }

    static {
        c = new a();
    }

    public final int a() {
        XplayErrorCode r0 = this.a;
        if (r0 != XplayErrorCode.XPLAY_INTERNAL_ERROR) goto L8;
        ErrorCodeException r1 = this.b;
        if (r1 == null) goto L8;
        return r1.getCode();
    L8:
        return r0.getCode();
    }

    public final String b() {
        ErrorCodeException r0 = this.b;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getMsg();
    L7:
        if (r2.a(r2) == false) goto L13;
        StringBuilder r3 = new StringBuilder();
        r3.append(this.a.getErrorMsg());
        r3.append(": ");
        ErrorCodeException r4 = this.b;
        if (r4 == null) goto L11;
        r1 = r4.getMsg();
    L11:
        r3.append(r1);
        return r3.toString();
    L13:
        return this.a.getErrorMsg();
    L5:
        r2 = null;
        goto L7
    }

    public q(XplayErrorCode r1, ErrorCodeException r2) {
        this.a = r1;
        this.b = r2;
    }
}
