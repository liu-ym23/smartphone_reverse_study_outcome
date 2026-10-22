package com.larus.photopicker.v2.impl;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$3"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class Injection$provideViewModel$$inlined$viewModels$default$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ Function0 $ownerProducer;
    final /* synthetic */ Fragment $this_viewModels;

    public Injection$provideViewModel$$inlined$viewModels$default$2(Function0 r1, Fragment r2) {
        this.$ownerProducer = r1;
        this.$this_viewModels = r2;
        super(0);
    }

    public final ViewModelProvider.Factory invoke() {
        Object r0 = this.$ownerProducer.invoke();
        ViewModelProvider.Factory r2 = null;
        if ((r0 instanceof HasDefaultViewModelProviderFactory) == false) goto L5;
        HasDefaultViewModelProviderFactory r1 = (HasDefaultViewModelProviderFactory) r0;
    L6:
        if (r1 == null) goto L9;
        r2 = r1.getDefaultViewModelProviderFactory();
    L9:
        if (r2 == null) goto L11;
        return r2;
    L11:
        return this.$this_viewModels.getDefaultViewModelProviderFactory();
    L5:
        r1 = null;
        goto L6
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m15invoke() {
        return invoke();
    }
}
