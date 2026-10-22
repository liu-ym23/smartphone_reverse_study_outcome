package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class z<T> implements Consumer {
    public final /* synthetic */ MultiLinkCommonVoiceFeedPreview a;

    public z(MultiLinkCommonVoiceFeedPreview r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        this.a.P0 = r3;
        if (vm2.c.j() == true) goto L5;
        return;
    L5:
        if (r3.booleanValue() == true) goto L9;
        InteractiveSongContext.Companion.getClass();
        InteractiveSongContext.access$getMicSeatTaskExecutors$cp().clear();
        return;
    }
}
