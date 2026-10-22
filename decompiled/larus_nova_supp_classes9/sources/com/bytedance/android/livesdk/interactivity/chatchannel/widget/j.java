package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.view.View;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j<T> implements Consumer {
    public final /* synthetic */ ChatChannelInviteButtonWidget a;

    public j(ChatChannelInviteButtonWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        com.bytedance.android.livesdk.interactivity.api.base.d r4 = (com.bytedance.android.livesdk.interactivity.api.base.d) r3;
        ChatChannelInviteButtonWidget r5 = this.a;
        View r0 = ((Widget) r5).contentView;
        int r1 = ChatChannelInviteButtonWidget.c;
        r5.yq(r0);
    }
}
