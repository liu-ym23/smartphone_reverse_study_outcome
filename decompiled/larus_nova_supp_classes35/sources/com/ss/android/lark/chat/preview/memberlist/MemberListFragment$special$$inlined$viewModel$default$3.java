package com.ss.android.lark.chat.preview.memberlist;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke", "com/larksuite/arch/jack/ExtensionsKt$viewModel$4"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class MemberListFragment$special$$inlined$viewModel$default$3 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ ViewModelStoreOwner $this_viewModel;

    public MemberListFragment$special$$inlined$viewModel$default$3(ViewModelStoreOwner r1) {
        this.$this_viewModel = r1;
        super(0);
    }

    public final ViewModelProvider.Factory invoke() {
        return this.$this_viewModel.getDefaultViewModelProviderFactory();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m667invoke() {
        return invoke();
    }
}
