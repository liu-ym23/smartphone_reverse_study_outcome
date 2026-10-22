package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ ChannelMemberManagerDialog a;

    public d(ChannelMemberManagerDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Boolean r5 = (Boolean) r4;
        ChannelMemberManagerDialog r6 = this.a;
        r6.c1(r6.F, r6.G, r6.H);
    }
}
