package com.ss.android.lark.flow.bottomsheet;

import agb.b;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class BottomSheetProviderModule_ProvideFragmentProvidersFactory implements Factory<List<com.ss.android.lark.bottomsheet.fragment.a.c>> {

    public static final class a {
        public static final BottomSheetProviderModule_ProvideFragmentProvidersFactory a = null;

        static {
            a = new BottomSheetProviderModule_ProvideFragmentProvidersFactory();
        }
    }

    public BottomSheetProviderModule_ProvideFragmentProvidersFactory() {
    }

    public static List<com.ss.android.lark.bottomsheet.fragment.a.c> provideFragmentProviders() {
        int r0 = com.ss.android.lark.flow.bottomsheet.a.a;
        return (List) Preconditions.checkNotNullFromProvides(CollectionsKt.listOf(new com.ss.android.lark.bottomsheet.fragment.a.c[]{new bgb.a(), new b(), new cgb.a()}));
    }

    public /* bridge */ /* synthetic */ Object get() {
        return m2get();
    }

    public static BottomSheetProviderModule_ProvideFragmentProvidersFactory create() {
        return a.a;
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public List<com.ss.android.lark.bottomsheet.fragment.a.c> m2get() {
        return provideFragmentProviders();
    }
}
