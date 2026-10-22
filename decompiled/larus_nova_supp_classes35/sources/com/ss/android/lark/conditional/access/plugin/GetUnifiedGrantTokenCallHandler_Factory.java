package com.ss.android.lark.conditional.access.plugin;

import com.bytedance.lark.rustclient.api.l;
import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class GetUnifiedGrantTokenCallHandler_Factory implements Factory<a> {
    private final Provider<l> rustClientProvider;

    public a get() {
        return newInstance((l) this.rustClientProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m992get() {
        return get();
    }

    public GetUnifiedGrantTokenCallHandler_Factory(Provider<l> r1) {
        this.rustClientProvider = r1;
    }

    public static GetUnifiedGrantTokenCallHandler_Factory create(Provider<l> r1) {
        return new GetUnifiedGrantTokenCallHandler_Factory(r1);
    }

    public static a newInstance(l r1) {
        return new a(r1);
    }
}
