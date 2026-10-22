package com.ss.android.lark.flow.bottomsheet.plugin;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.biz.component.ChatBaseComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.bottomsheet.BottomSheetViewModel;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ FlowBottomSheetPlugin a;
    public final /* synthetic */ Fragment b;

    public c(FlowBottomSheetPlugin r1, Fragment r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r4) {
        if (((ChatWindowOpenViewModel.InitializeState) r4) != ChatWindowOpenViewModel.InitializeState.INITIALIZED) goto L20;
        FlowBottomSheetPlugin r5 = this.a;
        if (r5.n == true) goto L24;
        r5.n = true;
        ChatBaseComponent.a r6 = r5.i;
        Lazy r0 = null;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
        r6 = null;
    L10:
        final Fragment r7 = r6.getFragment();
        if (r7 == null) goto L13;
        r0 = FragmentViewModelLazyKt.createViewModelLazy(r7, Reflection.getOrCreateKotlinClass(BottomSheetViewModel.class), new FlowBottomSheetPlugin$initViewModel$1$1$onChanged$$inlined$activityViewModels$default$1(r7), new FlowBottomSheetPlugin$initViewModel$1$1$onChanged$$inlined$activityViewModels$default$2(r7));
    L13:
        if (r0 == null) goto L21;
        BottomSheetViewModel r8 = (BottomSheetViewModel) r0.getValue();
        if (r8 == null) goto L22;
        MutableLiveData r9 = r8.getState();
        if (r9 == null) goto L23;
        r9.observe(this.b.getViewLifecycleOwner(), new b(this.a));
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L24:
        return;
    }
}
