package com.bytedance.ai.applet.moa;

import com.bytedance.ai.applet.granting.GrantingAction;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GrantingAction.values().length];
            r0[GrantingAction.AGREED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[GrantingAction.REJECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[GrantingAction.DISMISSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final MoaStepResult a(GrantingAction r1, boolean r10) {
        int r11 = a.a[r1.ordinal()];
        if (r11 == 1) goto L15;
        if (r11 != 2) goto L7;
        if (r10 == false) goto L18;
        return MoaStepResult.REFUSED;
    L18:
        return MoaStepResult.CONTINUE;
    L7:
        if (r11 != 3) goto L10;
        return MoaStepResult.WAITING_ACTION;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return MoaStepResult.CONTINUE;
    }
}
