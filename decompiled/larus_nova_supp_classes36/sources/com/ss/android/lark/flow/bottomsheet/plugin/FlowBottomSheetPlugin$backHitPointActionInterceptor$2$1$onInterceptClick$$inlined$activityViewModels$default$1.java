package com.ss.android.lark.flow.bottomsheet.plugin;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStore;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$1"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowBottomSheetPlugin$backHitPointActionInterceptor$2$1$onInterceptClick$$inlined$activityViewModels$default$1 extends Lambda implements Function0<ViewModelStore> {
    final /* synthetic */ Fragment $this_activityViewModels;

    public FlowBottomSheetPlugin$backHitPointActionInterceptor$2$1$onInterceptClick$$inlined$activityViewModels$default$1(Fragment r1) {
        this.$this_activityViewModels = r1;
        super(0);
    }

    public final ViewModelStore invoke() {
        return this.$this_activityViewModels.requireActivity().getViewModelStore();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m7invoke() {
        return invoke();
    }
}
