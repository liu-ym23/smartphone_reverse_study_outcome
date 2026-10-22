package com.larus.bmhome.chat.component.title;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "androidx/fragment/app/FragmentViewModelLazyKt$viewModels$3"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatTitleComponent$titleQuotaModel_delegate$lambda$15$$inlined$viewModels$default$3 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ Function0 $ownerProducer;
    final /* synthetic */ Fragment $this_viewModels;

    public ChatTitleComponent$titleQuotaModel_delegate$lambda$15$$inlined$viewModels$default$3(Function0 r1, Fragment r2) {
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
    public /* bridge */ /* synthetic */ Object m80invoke() {
        return invoke();
    }
}
