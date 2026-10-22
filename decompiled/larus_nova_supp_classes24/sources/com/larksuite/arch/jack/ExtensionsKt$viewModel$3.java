package com.larksuite.arch.jack;

import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class ExtensionsKt$viewModel$3 extends Lambda implements Function0<ViewModelStore> {
    final /* synthetic */ ViewModelStoreOwner $this_viewModel;

    public ExtensionsKt$viewModel$3(ViewModelStoreOwner r1) {
        this.$this_viewModel = r1;
        super(0);
    }

    public final ViewModelStore invoke() {
        return this.$this_viewModel.getViewModelStore();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m209invoke() {
        return invoke();
    }
}
