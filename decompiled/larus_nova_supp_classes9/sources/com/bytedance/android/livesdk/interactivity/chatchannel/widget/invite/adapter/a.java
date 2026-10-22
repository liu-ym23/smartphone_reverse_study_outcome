package com.bytedance.android.livesdk.interactivity.chatchannel.widget.invite.adapter;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.platform.depend.user.IContactActiveViewHolderWrapper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements IContactActiveViewHolderWrapper.IContactActiveCallback {
    public final /* synthetic */ InviteeUserItemViewBinder.ItemViewHolder a;

    public a(InviteeUserItemViewBinder.ItemViewHolder r1) {
        this.a = r1;
    }

    public final void onActiveChanged(boolean r3) {
        if (r3 == false) goto L4;
        this.a.c.setVisibility(0);
        this.a.c.setImageResource(2131250202);
        this.a.a.setCircleRadius(UtilityKotlinExtentionsKt.i(10));
        this.a.b.setCircleRadius(UtilityKotlinExtentionsKt.i(10));
        return;
    L4:
        this.a.c.setVisibility(8);
        this.a.a.setCircleRadius(0.0f);
        this.a.b.setCircleRadius(0.0f);
    }
}
