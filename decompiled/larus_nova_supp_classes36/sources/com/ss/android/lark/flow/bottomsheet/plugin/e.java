package com.ss.android.lark.flow.bottomsheet.plugin;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ FlowStatusBarPlugin b;

    public e(Fragment r1, FlowStatusBarPlugin r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r4) {
        if (((ChatWindowOpenViewModel.InitializeState) r4) != ChatWindowOpenViewModel.InitializeState.INITIALIZED) goto L7;
        final Fragment r5 = this.a;
        ((BottomSheetViewModel) FragmentViewModelLazyKt.createViewModelLazy(r5, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new FlowStatusBarPlugin$initViewModel$1$1$onChanged$$inlined$activityViewModels$default$1(r5), new FlowStatusBarPlugin$initViewModel$1$1$onChanged$$inlined$activityViewModels$default$2(r5)).getValue()).getState().observe(this.a.getViewLifecycleOwner(), new d(this.b));
        return;
    }
}
