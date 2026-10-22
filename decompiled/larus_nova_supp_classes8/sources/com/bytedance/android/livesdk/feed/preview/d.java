package com.bytedance.android.livesdk.feed.preview;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ LiveFeedPreview a;
    public final /* synthetic */ LifecycleOwner b;

    public d(LiveFeedPreview r1, LifecycleOwner r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r2) {
        if (((String) r2) == null) goto L7;
        LiveFeedPreview r3 = this.a;
        int r0 = LiveFeedPreview.h;
        r3.getClass();
        return;
    }
}
