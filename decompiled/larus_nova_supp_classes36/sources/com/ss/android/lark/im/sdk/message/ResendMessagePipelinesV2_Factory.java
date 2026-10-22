package com.ss.android.lark.im.sdk.message;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ResendMessagePipelinesV2_Factory implements Factory<b> {
    private final Provider<l> rustClientProvider;

    public b get() {
        return newInstance((l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m730get() {
        return get();
    }

    public ResendMessagePipelinesV2_Factory(Provider<l> r1) {
        this.rustClientProvider = r1;
    }

    public static ResendMessagePipelinesV2_Factory create(Provider<l> r1) {
        return new ResendMessagePipelinesV2_Factory(r1);
    }

    public static b newInstance(l r1) {
        return new b(r1);
    }
}
