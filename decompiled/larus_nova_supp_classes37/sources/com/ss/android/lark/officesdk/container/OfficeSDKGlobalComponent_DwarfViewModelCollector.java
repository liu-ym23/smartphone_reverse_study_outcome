package com.ss.android.lark.officesdk.container;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeSDKGlobalComponent_DwarfViewModelCollector implements DwarfViewModelFactory.DwarfViewModelCollector {
    private final Map<String, Object> assistedFactories;
    private final Map<String, Provider<ViewModel>> factories;

    public Map<String, Object> getDwarfViewModelAssistedMap() {
        return this.assistedFactories;
    }

    public Map<String, Provider<ViewModel>> getDwarfViewModelMap() {
        return this.factories;
    }

    @Inject
    public OfficeSDKGlobalComponent_DwarfViewModelCollector(Map<String, Provider<ViewModel>> r1, Map<String, Object> r2) {
        this.factories = r1;
        this.assistedFactories = r2;
    }
}
