package com.bytedance.android.live.browser.di;

import com.bytedance.android.live.browser.IH5AssistService;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import jc1.k;
import s20.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class H5Module_ProvideWebDialogFragmentFactory implements Factory<BaseWebDialogFragment> {
    private final c module;

    public BaseWebDialogFragment get() {
        return provideWebDialogFragment(this.module);
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m475get() {
        return get();
    }

    public H5Module_ProvideWebDialogFragmentFactory(c r1) {
        this.module = r1;
    }

    public static H5Module_ProvideWebDialogFragmentFactory create(c r1) {
        return new H5Module_ProvideWebDialogFragmentFactory(r1);
    }

    public static BaseWebDialogFragment provideWebDialogFragment(c r0) {
        r0.getClass();
        IH5AssistService r1 = (IH5AssistService) k.f(IH5AssistService.class);
        if (r1 == null) goto L5;
        BaseWebDialogFragment r2 = r1.createWebDialogFragment();
    L7:
        return (BaseWebDialogFragment) Preconditions.checkNotNullFromProvides(r2);
    L5:
        r2 = null;
        goto L7
    }
}
