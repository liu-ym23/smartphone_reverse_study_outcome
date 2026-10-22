package com.larksuite.arch.jack;

import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 176)
public final class ExtensionsKt$viewModel$5 extends Lambda implements Function0<ViewModelProvider.Factory> {
    public static final ExtensionsKt$viewModel$5 INSTANCE = null;

    static {
        INSTANCE = new ExtensionsKt$viewModel$5();
    }

    public ExtensionsKt$viewModel$5() {
        super(0);
    }

    public final ViewModelProvider.Factory invoke() {
        return new JackViewModelFactory();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m211invoke() {
        return invoke();
    }
}
