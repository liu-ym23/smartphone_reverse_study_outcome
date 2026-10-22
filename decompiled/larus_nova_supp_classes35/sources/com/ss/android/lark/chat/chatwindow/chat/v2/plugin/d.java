package com.ss.android.lark.chat.chatwindow.chat.v2.plugin;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ StatusBarPlugin b;

    public d(Fragment r1, StatusBarPlugin r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r4) {
        if (((ChatWindowOpenViewModel.InitializeState) r4) != ChatWindowOpenViewModel.InitializeState.INITIALIZED) goto L7;
        final Fragment r5 = this.a;
        ((BottomSheetViewModel) FragmentViewModelLazyKt.createViewModelLazy(r5, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new StatusBarPlugin$initViewModel$1$1$onChanged$$inlined$activityViewModels$default$1(r5), new StatusBarPlugin$initViewModel$1$1$onChanged$$inlined$activityViewModels$default$2(r5)).getValue()).getState().observe(this.a.getViewLifecycleOwner(), new c(this.b));
        return;
    }
}
