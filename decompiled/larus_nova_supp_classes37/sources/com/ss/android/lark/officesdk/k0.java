package com.ss.android.lark.officesdk;

import com.ss.android.lark.officesdk.container.HiltWrapper_OfficeSDKGlobalComponent_KeySetModule;
import com.ss.android.lark.officesdk.container.HiltWrapper_OfficeSDKGlobalComponent_MapModule;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_DwarfViewModelCollectorEntryPoint;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_FactoryFactoryEntryPoint;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalEntryPoint;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalScope;
import dagger.Subcomponent;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import dagger.hilt.internal.GeneratedComponent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Subcomponent(modules = {l0.class, n0.class, HiltWrapper_OfficeSDKGlobalComponent_KeySetModule.class, HiltWrapper_OfficeSDKGlobalComponent_MapModule.class})
@OfficeSDKGlobalScope
public abstract class k0 implements DwarfSPIEntryPoint, OfficeSDKGlobalComponent, OfficeSDKGlobalComponent_DwarfViewModelCollectorEntryPoint, OfficeSDKGlobalComponent_FactoryFactoryEntryPoint, OfficeSDKGlobalEntryPoint, GeneratedComponent {
    public k0() {
    }

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_DwarfViewModelCollectorEntryPoint
    /* JADX INFO: renamed from: dwarfViewModelCollector */
    public /* bridge */ /* synthetic */ DwarfViewModelFactory.DwarfViewModelCollector mo38dwarfViewModelCollector() {
        return mo38dwarfViewModelCollector();
    }

    @Override // com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_FactoryFactoryEntryPoint
    /* JADX INFO: renamed from: factoryFactoryCollector */
    public /* bridge */ /* synthetic */ DwarfViewModelFactories.FactoryFactoryCollector mo41factoryFactoryCollector() {
        return mo41factoryFactoryCollector();
    }
}
