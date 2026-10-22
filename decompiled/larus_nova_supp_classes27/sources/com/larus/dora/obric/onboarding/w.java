package com.larus.dora.obric.onboarding;

import com.larus.dora.impl.databinding.ObricDoraGOnboardingBottomBtnLayoutBinding;
import com.larus.dora.impl.databinding.ObricDoraGOnboardingFragmentV2Binding;
import com.obric.oui.button.OButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w {
    public static final String b(int r1) {
        int r0 = com.larus.utils.j0.a;
        return com.larus.utils.j0.d(r1);
    }

    public static final void a(ObricDoraGOnboardingFragmentV2Binding r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ObricDoraGOnboardingBottomBtnLayoutBinding r4 = r1.d;
        com.larus.utils.e1.x(r4.a);
        com.larus.utils.e1.x(r4.c);
        OButton r0 = r4.d;
        if (r2 == null) goto L5;
        r0.setText(r2);
    L5:
        if (r3 == false) goto L7;
        Intrinsics.checkNotNull(r0);
        d69.a.a(r0);
    L8:
        com.larus.utils.e1.x(r4.f);
        j19.c.d(r4.b);
        return;
    L7:
        Intrinsics.checkNotNull(r0);
        d69.a.b(r0, false);
        goto L8
    }
}
