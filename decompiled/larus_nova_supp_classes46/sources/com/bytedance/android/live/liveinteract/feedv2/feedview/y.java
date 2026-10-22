package com.bytedance.android.live.liveinteract.feedv2.feedview;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

    public y(MultiLinkCommonVoiceFeedPreview r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        this.a.V0 = (Boolean) r2;
    }
}
