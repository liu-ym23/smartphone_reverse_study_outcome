package com.bytedance.android.live.liveinteract.feedv2.feedview;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p<T> implements Consumer {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

    public p(MultiLinkCommonVoiceFeedPreview r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        MultiLinkCommonVoiceFeedPreview.x(this.a).printALogger("MultiLinkCommonVoiceFeedPreview", this.a.hashCode(), ((Throwable) r5).toString(), true);
    }
}
