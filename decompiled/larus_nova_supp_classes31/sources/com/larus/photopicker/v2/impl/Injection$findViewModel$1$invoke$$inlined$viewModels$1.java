package com.larus.photopicker.v2.impl;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$2"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class Injection$findViewModel$1$invoke$$inlined$viewModels$1 extends Lambda implements Function0<ViewModelStore> {
    final /* synthetic */ Function0 $ownerProducer;

    public Injection$findViewModel$1$invoke$$inlined$viewModels$1(Function0 r1) {
        this.$ownerProducer = r1;
        super(0);
    }

    public final ViewModelStore invoke() {
        return ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m12invoke() {
        return invoke();
    }
}
