package jjb;

import com.bytedance.lark.pb.basic.v1.LogoutReason;
import com.bytedance.lark.pb.tool.v1.MakeUserOfflineV2Request;
import com.ss.android.lark.passport.signinsdk_api.feature.context.OfficeSDKLogoutContext;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSDKLogoutContext.Action.values().length];
            r0[OfficeSDKLogoutContext.Action.SWITCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[OfficeSDKLogoutContext.Action.DOUBAO_CHANGE_BINDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[OfficeSDKLogoutContext.Action.LOGOUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final void a(MakeUserOfflineV2Request.Builder r1, j0c.e r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "context");
        OfficeSDKLogoutContext r3 = r2.c;
        if ((r3 instanceof OfficeSDKLogoutContext) == false) goto L5;
        OfficeSDKLogoutContext r4 = r3;
    L6:
        if (r4 == null) goto L23;
        OfficeSDKLogoutContext.Action r5 = r4.a;
        if (r5 == null) goto L24;
        int r6 = a.a[r5.ordinal()];
        if (r6 != 1) goto L13;
        LogoutReason r7 = LogoutReason.ChangeTenant;
    L21:
        r1.logout_reason(r7);
        return;
    L13:
        if (r6 != 2) goto L15;
        r7 = LogoutReason.BoundDoubaoAccountChanged;
        goto L21
    L15:
        if (r6 != 3) goto L18;
        r7 = LogoutReason.UserLogout;
        goto L21
    L18:
        throw new NoWhenBranchMatchedException();
    L24:
        return;
    L23:
        return;
    L5:
        r4 = null;
        goto L6
    }
}
