package com.bytedance.android.livesdk.chatroom.viewmodule.sharelinkpanel;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ LiveLinkShareToThirdDialogFragment a;

    public g(LiveLinkShareToThirdDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        LiveLinkShareToThirdDialogFragment r3 = this.a;
        if (r3.l == false) goto L5;
        String r0 = "cancel_choose_find_me";
    L6:
        LiveLinkShareToThirdDialogFragment.T90(r3, r0);
        LiveLinkShareToThirdDialogFragment r4 = this.a;
        boolean r1 = !r4.l;
        r4.l = r1;
        ImageView r5 = r4.f;
        if (r5 == null) goto L10;
        r5.setSelected(r1);
        return;
    L10:
        return;
    L5:
        r0 = "choose_find_me";
        goto L6
    }
}
