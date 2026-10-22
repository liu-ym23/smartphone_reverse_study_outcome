package com.ss.android.lark.conditional.access.web.viewmodel;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class BindDeviceWebViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {
        public static final BindDeviceWebViewModel_HiltModules_KeyModule_ProvideFactory a = null;

        static {
            a = new BindDeviceWebViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public BindDeviceWebViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.ss.android.lark.conditional.access.web.viewmodel.BindDeviceWebViewModel");
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m1006get();
    }

    public static BindDeviceWebViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public String m1006get() {
        return provide();
    }
}
