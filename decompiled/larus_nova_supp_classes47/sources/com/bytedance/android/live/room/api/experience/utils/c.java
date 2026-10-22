package com.bytedance.android.live.room.api.experience.utils;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        if (r3 == null) goto L6;
        boolean r4 = r3.booleanValue();
        PlatformExpUtils.c = true;
        PlatformExpUtils.d = r4;
        return;
    }
}
