package com.larus.dora.obric.onboarding;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r1 implements m69.e {
    public final /* synthetic */ ObricDoraGOnboardingWelcomeStateFragment a;

    public r1(ObricDoraGOnboardingWelcomeStateFragment r1) {
        this.a = r1;
    }

    @Override // m69.e
    public final void a(String r3) {
        if (r3 == null) goto L16;
        String r4 = StringsKt.trim(r3).toString();
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        r4 = null;
    L12:
        if (r4 == null) goto L18;
        this.a.H0 = r4;
        g49.d.d("ObricDoraGOnboardingWelcomeStateFragment", "video query onAsrResultChanged, textLength=" + r4.length());
        return;
    L18:
        return;
    L8:
        r0 = false;
        goto L9
    }
}
