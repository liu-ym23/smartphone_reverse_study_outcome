package com.ss.android.lark.integrator.security.compliance;

import dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class SCClipboardProviderGlobalOfficeSDK_Factory implements Factory<SCClipboardProviderGlobalOfficeSDK> {
    private final Provider<doc.d> clipboardServiceProvider;

    public SCClipboardProviderGlobalOfficeSDK get() {
        return newInstance((doc.d) this.clipboardServiceProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m936get() {
        return get();
    }

    public SCClipboardProviderGlobalOfficeSDK_Factory(Provider<doc.d> r1) {
        this.clipboardServiceProvider = r1;
    }

    public static SCClipboardProviderGlobalOfficeSDK_Factory create(Provider<doc.d> r1) {
        return new SCClipboardProviderGlobalOfficeSDK_Factory(r1);
    }

    public static SCClipboardProviderGlobalOfficeSDK newInstance(doc.d r1) {
        return new SCClipboardProviderGlobalOfficeSDK(r1);
    }
}
