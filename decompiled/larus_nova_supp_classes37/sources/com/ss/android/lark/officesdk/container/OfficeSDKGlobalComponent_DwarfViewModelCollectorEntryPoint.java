package com.ss.android.lark.officesdk.container;

import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactory;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public interface OfficeSDKGlobalComponent_DwarfViewModelCollectorEntryPoint extends DwarfViewModelFactory.DwarfViewModelCollectorEntryPoint {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent_DwarfViewModelCollectorEntryPoint$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ DwarfViewModelFactory.DwarfViewModelCollector $default$dwarfViewModelCollector(OfficeSDKGlobalComponent_DwarfViewModelCollectorEntryPoint r0) {
            return r0.dwarfViewModelCollector();
        }
    }

    OfficeSDKGlobalComponent_DwarfViewModelCollector dwarfViewModelCollector();

    /* JADX INFO: renamed from: dwarfViewModelCollector, reason: collision with other method in class */
    /* bridge */ /* synthetic */ DwarfViewModelFactory.DwarfViewModelCollector mo38dwarfViewModelCollector();
}
