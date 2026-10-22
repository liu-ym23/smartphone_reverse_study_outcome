package com.ss.android.lark.flow.chatthread.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.biz.im.api.page.configurator.ConfiguratorType;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.Notice;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import l3c.j;
import zsb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\f\u0010\u001d\u001a\u00020\u001b*\u00020\u001eH\u0014J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0014J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ss/android/lark/flow/chatthread/page/FlowChatThreadFragment;", "Lcom/ss/android/lark/im/base/page/BasePageFragment;", "Lcom/ss/android/lark/notification/export/IPushNotifyStrategy;", "<init>", "()V", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatAppContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "setChatAppContainer", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "viewModel", "Lcom/ss/android/lark/flow/chatthread/page/FlowChatThreadViewModel;", "getViewModel", "()Lcom/ss/android/lark/flow/chatthread/page/FlowChatThreadViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mRootView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initComponents", "Lcom/ss/android/lark/scaffold/ScaffoldScope;", "configuratorTypes", "", "Lcom/ss/android/lark/biz/im/api/page/configurator/ConfiguratorType;", "shouldNotifyPush", "", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowChatThreadFragment extends Hilt_FlowChatThreadFragment implements d {
    public static final /* synthetic */ int n = 0;

    @Inject
    public v k;
    public final Lazy l;
    public View m;

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final List<ConfiguratorType> T90() {
        return CollectionsKt.listOf(ConfiguratorType.MESSAGE_LIST);
    }

    public final v Y90() {
        v r0 = this.k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("chatAppContainer");
        return null;
    }

    public final FlowChatThreadViewModel Z90() {
        return (FlowChatThreadViewModel) this.l.getValue();
    }

    @Inject
    public FlowChatThreadFragment() {
        Function0<ViewModelProvider.Factory> r0 = new FlowChatThreadFragment$viewModel$2(this);
        final Function0<Fragment> r1 = new FlowChatThreadFragment$special$$inlined$viewModels$default$1(this);
        this.l = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FlowChatThreadViewModel.class), new FlowChatThreadFragment$special$$inlined$viewModels$default$2(r1), r0);
    }

    @Override // zsb.d
    public final boolean Cy(Notice r2) {
        Chat r0 = (Chat) Z90().getChat().getValue();
        if (r0 == null) goto L6;
        String r1 = r0.getId();
        if (r1 == null) goto L6;
    L8:
        return t0.a(r2, r1);
    L6:
        r1 = "";
        goto L8
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void V90(j r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        final FragmentActivity r0 = requireActivity();
        r4.b(new FlowChatThreadFragment$initComponents$1(this, this));
        r4.b(FlowChatThreadFragment$initComponents$2.INSTANCE);
        r4.c(2131365605, new FlowChatThreadFragment$initComponents$3(this));
        r4.c(2131365604, new FlowChatThreadFragment$initComponents$4(r0, this, this));
    }

    @Override // com.ss.android.lark.im.base.page.BasePageFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        Z90().loadChatInitData(null);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131561193, r3, false);
        this.m = r5;
        if (r5 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    L6:
        return r5;
    }
}
