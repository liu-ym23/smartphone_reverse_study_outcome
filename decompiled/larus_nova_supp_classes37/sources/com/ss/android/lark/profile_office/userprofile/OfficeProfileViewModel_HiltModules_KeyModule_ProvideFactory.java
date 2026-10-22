package com.ss.android.lark.profile_office.userprofile;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeProfileViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {

    public static final class a {
        public static final OfficeProfileViewModel_HiltModules_KeyModule_ProvideFactory a = null;

        static {
            a = new OfficeProfileViewModel_HiltModules_KeyModule_ProvideFactory();
        }
    }

    public OfficeProfileViewModel_HiltModules_KeyModule_ProvideFactory() {
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides("com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel");
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m3442get();
    }

    public static OfficeProfileViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public String m3442get() {
        return provide();
    }
}
