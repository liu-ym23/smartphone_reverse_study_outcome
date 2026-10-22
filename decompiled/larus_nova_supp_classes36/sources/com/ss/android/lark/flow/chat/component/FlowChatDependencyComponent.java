package com.ss.android.lark.flow.chat.component;

import android.content.Context;
import android.os.Bundle;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.base.frame.FrameFragment;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowOpenViewModel;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.component.ChatDependencyComponent;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import fib.a;
import gza.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/flow/chat/component/FlowChatDependencyComponent;", "Lcom/ss/android/lark/chat/component/ChatDependencyComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "viewModel", "Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel;", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "dispatcher", "Lcom/ss/android/lark/platform/dispatcher/CompositeDispatcher;", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/ss/android/lark/biz/im/api/extension/chat_window/ChatWindowOpenViewModel;Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;Lcom/ss/android/lark/platform/dispatcher/CompositeDispatcher;)V", "exitChat", "", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowChatDependencyComponent extends ChatDependencyComponent {
    public final void h() {
        if (KeyboardUtils.isSoftShowing(getActivity()) == false) goto L5;
        KeyboardUtils.hideKeyboard(getActivity());
    L5:
        BaseFragment r0 = ((ChatDependencyComponent) this).i;
        Context r1 = r0.getContext();
        boolean r2 = false;
        if (r1 == null) goto L10;
        boolean r3 = true;
        if (ForsetiConfig.a(r1) != true) goto L10;
    L11:
        if (r3 == true) goto L13;
    L25:
        Bundle r4 = r0.getArguments();
        if (r4 == null) goto L28;
        r2 = r4.getBoolean("is_embedded", false);
    L28:
        b r5 = OfficeSDKManager.getHostGlobalService(b.class);
        if (r2 == false) goto L32;
        if (r5 == null) goto L32;
        r5.L1(getActivity());
        return;
    L32:
        getActivity().onBackPressed();
        return;
    L13:
        if (a.a() == false) goto L25;
        boolean r6 = r0 instanceof BaseFragment;
        BaseFragment r7 = null;
        if (r6 == false) goto L17;
        BaseFragment r8 = r0;
    L18:
        if (r8 != null) goto L20;
        getActivity().onBackPressed();
        return;
    L20:
        if (r6 == false) goto L22;
        r7 = r0;
    L22:
        if (r7 == null) goto L35;
        zab.a.a(r7);
        return;
    L35:
        return;
    L17:
        r8 = null;
    L10:
        r3 = false;
        goto L11
    }

    public FlowChatDependencyComponent(FrameFragment r2, ChatWindowOpenViewModel r3, v r4, com.ss.android.lark.platform.dispatcher.b r5) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "chatAppContainer");
        Intrinsics.checkNotNullParameter(r5, "dispatcher");
        super(r2, r3, r4, r5);
    }
}
