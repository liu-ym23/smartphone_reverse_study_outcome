package com.ss.android.lark.conditional.access.device.viewmodel;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DeviceDeclareViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {
        public static final DeviceDeclareViewModel_HiltModules_KeyModule_ProvideFactory a = null;

        static {
            a = new DeviceDeclareViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public DeviceDeclareViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.ss.android.lark.conditional.access.device.viewmodel.DeviceDeclareViewModel");
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m965get();
    }

    public static DeviceDeclareViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public String m965get() {
        return provide();
    }
}
