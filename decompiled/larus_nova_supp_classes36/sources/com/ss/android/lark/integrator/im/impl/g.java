package com.ss.android.lark.integrator.im.impl;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.feed.app.entity.FeedFolder;
import com.ss.android.lark.feed.app.entity.FeedFolderCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements ceb.a {
    public final void c() {
    }

    public final FeedFolder a() {
        return FeedFolderCompat.INSTANCE.getMESSAGE();
    }

    public final MutableLiveData b() {
        return new MutableLiveData();
    }

    public g() {
    }
}
