package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.view.View;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ ChatChannelInviteButtonWidget a;

    public k(ChatChannelInviteButtonWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        ChatChannelInviteButtonWidget r5 = this.a;
        View r0 = ((Widget) r5).contentView;
        int r1 = ChatChannelInviteButtonWidget.c;
        r5.yq(r0);
    }
}
