package com.bytedance.ai.bridge.method.device.calendar;

import com.bytedance.timon.calendar.ResultCode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public final boolean a;
    public final ResultCode b;
    public final String c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ResultCode.values().length];
            r0[ResultCode.NoPermission.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ResultCode.NoRequestPermissionInvoker.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ResultCode.ArgumentError.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ResultCode.NoAccount.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ResultCode.NotFound.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ResultCode.StoreError.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ResultCode.Unknown.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ResultCode.Success.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g) == true) goto L8;
        return false;
    L8:
        g r11 = (g) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "CalendarWriteResult(succeed=" + this.a + ", code=" + this.b + ", message=" + this.c + ')';
    }

    public g(boolean r10, ResultCode r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "code");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_MSG);
        this.a = r10;
        this.b = r11;
        this.c = r12;
    }
}
