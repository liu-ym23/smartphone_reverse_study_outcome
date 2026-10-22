package com.bytedance.android.live.liveinteract.interact.audience.fragment;

import android.view.View;
import com.bytedance.android.livesdk.utils.f1;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ InteractAudienceContainerFragment a;

    public g(InteractAudienceContainerFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (f1.a(r3.getId()) == true) goto L14;
        InteractAudienceContainerFragment r0 = this.a;
        InteractAudienceSettingFragment r4 = new InteractAudienceSettingFragment(r0.j, r0.getContext());
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L12;
        DialogLancet.handleBlockedDialogShow(r4);
    L9:
        this.a.d.dismiss();
        return;
    L12:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L8:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
        goto L9
    }
}
