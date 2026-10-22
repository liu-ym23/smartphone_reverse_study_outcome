package com.ss.android.lark.officesdk.container;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKGlobalComponent_DwarfViewModelCollector_Factory implements Factory<OfficeSDKGlobalComponent_DwarfViewModelCollector> {
    private final Provider<Map<String, Object>> assistedFactoriesProvider;
    private final Provider<Map<String, Provider<ViewModel>>> factoriesProvider;

    public OfficeSDKGlobalComponent_DwarfViewModelCollector get() {
        return newInstance((Map) this.factoriesProvider.get(), (Map) this.assistedFactoriesProvider.get());
    }

    /* JADX INFO: renamed from: get, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m39get() {
        return get();
    }

    public OfficeSDKGlobalComponent_DwarfViewModelCollector_Factory(Provider<Map<String, Provider<ViewModel>>> r1, Provider<Map<String, Object>> r2) {
        this.factoriesProvider = r1;
        this.assistedFactoriesProvider = r2;
    }

    public static OfficeSDKGlobalComponent_DwarfViewModelCollector_Factory create(Provider<Map<String, Provider<ViewModel>>> r1, Provider<Map<String, Object>> r2) {
        return new OfficeSDKGlobalComponent_DwarfViewModelCollector_Factory(r1, r2);
    }

    public static OfficeSDKGlobalComponent_DwarfViewModelCollector newInstance(Map<String, Provider<ViewModel>> r1, Map<String, Object> r2) {
        return new OfficeSDKGlobalComponent_DwarfViewModelCollector(r1, r2);
    }
}
