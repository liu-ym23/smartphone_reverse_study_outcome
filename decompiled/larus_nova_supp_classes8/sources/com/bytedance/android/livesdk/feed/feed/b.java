package com.bytedance.android.livesdk.feed.feed;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.media.IPlayable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public final MutableLiveData<Integer> a;
    public final MutableLiveData<IPlayable> b;

    public b() {
        this.a = new MutableLiveData();
        this.b = new MutableLiveData();
    }
}
