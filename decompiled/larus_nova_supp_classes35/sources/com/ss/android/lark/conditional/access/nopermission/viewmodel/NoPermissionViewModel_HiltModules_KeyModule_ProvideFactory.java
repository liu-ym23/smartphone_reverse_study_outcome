package com.ss.android.lark.conditional.access.nopermission.viewmodel;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class NoPermissionViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {
        public static final NoPermissionViewModel_HiltModules_KeyModule_ProvideFactory a = null;

        static {
            a = new NoPermissionViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public NoPermissionViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.ss.android.lark.conditional.access.nopermission.viewmodel.NoPermissionViewModel");
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m991get();
    }

    public static NoPermissionViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public String m991get() {
        return provide();
    }
}
