package com.ss.android.lark.forwardv3.forward.mediaforward;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class MediaForwardRepository_Factory implements Factory<h> {
    private final Provider<l> rustClientProvider;

    public h get() {
        return newInstance((l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m629get() {
        return get();
    }

    public MediaForwardRepository_Factory(Provider<l> r1) {
        this.rustClientProvider = r1;
    }

    public static MediaForwardRepository_Factory create(Provider<l> r1) {
        return new MediaForwardRepository_Factory(r1);
    }

    public static h newInstance(l r1) {
        return new h(r1);
    }
}
