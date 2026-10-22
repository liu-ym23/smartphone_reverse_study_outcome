package com.bytedance.android.live.liveinteract.interactivesong.impl;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r1) {
        Boolean r2 = (Boolean) r1;
        InteractiveSongContext.Companion.getClass();
        InteractiveSongContext.access$getMicSeatTaskExecutors$cp().clear();
    }
}
