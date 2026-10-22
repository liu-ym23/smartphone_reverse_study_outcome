package com.ss.android.lark.chat.preview.memberlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.android.file.picker.lib.v2.ui.main.FilePickerViewModel;
import com.larksuite.arch.jack.JackView;
import com.larksuite.arch.jack.JackViewModel;
import com.larksuite.arch.jack.f;
import com.larksuite.arch.jack.h;
import com.larksuite.arch.jack.i;
import com.larksuite.arch.jack.j;
import com.larksuite.arch.jack.l;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import com.ss.android.lark.widget.ptr.LKUIPtrFrameLayout;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u000f\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010$\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010/\u001a\u00020\fH\u0002J\b\u00100\u001a\u00020\fH\u0002J\b\u00101\u001a\u00020\fH\u0002J\b\u00102\u001a\u00020#H\u0002R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/ss/android/lark/chat/preview/memberlist/MemberListFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/larksuite/arch/jack/JackView;", "<init>", "()V", "emptyViewFromXml", "Lcom/larksuite/component/universe_design/emptystate/UDEmptyState;", "getEmptyViewFromXml", "()Lcom/larksuite/component/universe_design/emptystate/UDEmptyState;", "setEmptyViewFromXml", "(Lcom/larksuite/component/universe_design/emptystate/UDEmptyState;)V", "clearFromXmlViewCache", BuildConfig.FLAVOR, "onDestroyView", "viewModelFactory", "com/ss/android/lark/chat/preview/memberlist/MemberListFragment$viewModelFactory$2$1", "getViewModelFactory", "()Lcom/ss/android/lark/chat/preview/memberlist/MemberListFragment$viewModelFactory$2$1;", "viewModelFactory$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/ss/android/lark/chat/preview/memberlist/MemberListViewModel;", "getViewModel", "()Lcom/ss/android/lark/chat/preview/memberlist/MemberListViewModel;", "viewModel$delegate", "Lcom/larksuite/arch/jack/LifecycleAwareLazy;", "pullToRefresh", "Lcom/ss/android/lark/widget/ptr/LKUIPtrClassicFrameLayout;", "memberList", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "adapter", "Lcom/ss/android/lark/chat/preview/memberlist/MemberListAdapter;", "titleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "canLoadMore", BuildConfig.FLAVOR, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initViews", "initListener", "initSubscribe", "isEnterParamsAvailable", "Companion", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MemberListFragment extends BaseFragment implements JackView {
    public static final /* synthetic */ int l = 0;
    public UDEmptyState d;
    public final Lazy e;
    public final h f;
    public LKUIPtrClassicFrameLayout g;
    public CommonRecyclerView h;
    public MemberListAdapter i;
    public CommonTitleBar j;
    public boolean k;

    public static final class a {
    }

    static {
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this;
    }

    public final i getLifecycleOwnerHolder() {
        return this;
    }

    public final UDEmptyState S90() {
        View r0 = this.d;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131371607);
    L8:
        this.d = (UDEmptyState) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (UDEmptyState) r0;
    }

    public final MemberListViewModel T90() {
        return (MemberListViewModel) this.f.getValue();
    }

    public MemberListFragment() {
        this.e = LazyKt.lazy(new MemberListFragment$viewModelFactory$2(this));
        Function0<ViewModelProvider.Factory> r5 = new MemberListFragment$viewModel$2(this);
        Function0<ViewModelStore> r4 = new MemberListFragment$viewModel$3(this);
        final KClass r2 = Reflection.getOrCreateKotlinClass(MemberListViewModel.class);
        this.f = new h(r2, new MemberListFragment$special$$inlined$viewModel$default$1(r2), r4, r5, MemberListFragment$special$$inlined$viewModel$default$2.INSTANCE);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Bundle r6 = getArguments();
        boolean r0 = false;
        if (r6 == null) goto L27;
        String r1 = r6.getString("preview_id");
        String r2 = r6.getString("component_id");
        ArrayList<String> r7 = r6.getStringArrayList("chatter_id_list");
        if (r1 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L26;
        if (r2 != null) goto L14;
    L17:
        boolean r4 = true;
    L18:
        if (r4 == false) goto L26;
        if (r7 != null) goto L21;
    L24:
        boolean r8 = true;
    L25:
        if (r8 == true) goto L27;
    L21:
        if (r7.isEmpty() == true) goto L24;
        r8 = false;
        goto L25
    L14:
        if (r2.length() == 0) goto L17;
        r4 = false;
    L26:
        r0 = true;
        goto L27
    L7:
        if (r1.length() == 0) goto L10;
        r3 = false;
    L27:
        if (r0 == true) goto L30;
        requireActivity().finish();
        return;
    L30:
        T90().start();
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        LinearLayoutManager r8 = new LinearLayoutManager(requireContext(), 1, false);
        RecyclerView r9 = this.h;
        RecyclerView r0 = null;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("memberList");
        r9 = null;
    L5:
        r9.setLayoutManager(r8);
        this.i = new MemberListAdapter();
        RecyclerView r10 = this.h;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("memberList");
        r10 = null;
    L8:
        MemberListAdapter r11 = this.i;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r11 = null;
    L11:
        r10.setAdapter(r11);
        ChatWindowPtrLoadingHeader r12 = new ChatWindowPtrLoadingHeader(requireContext());
        LKUIPtrFrameLayout r13 = this.g;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("pullToRefresh");
        r13 = null;
    L14:
        r13.setKeepHeaderWhenRefresh(true);
        LKUIPtrFrameLayout r14 = this.g;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("pullToRefresh");
        r14 = null;
    L17:
        r14.setFooterView(r12);
        LKUIPtrFrameLayout r15 = this.g;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("pullToRefresh");
        r15 = null;
    L20:
        r15.addPtrUIHandler(r12);
        LKUIPtrFrameLayout r16 = this.g;
        if (r16 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("pullToRefresh");
        r16 = null;
    L23:
        r16.setForceBackWhenComplete(true);
        LKUIPtrFrameLayout r17 = this.g;
        if (r17 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("pullToRefresh");
        r17 = null;
    L26:
        r17.disableWhenHorizontalMove(true);
        LKUIPtrFrameLayout r18 = this.g;
        if (r18 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("pullToRefresh");
        r18 = null;
    L29:
        r18.setPtrHandler(new MemberListFragment$initViews$1(this));
        MemberListAdapter r19 = this.i;
        if (r19 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r19 = null;
    L32:
        b r20 = new b(this);
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "itemClickListener");
        r19.b = r20;
        RecyclerView r21 = this.h;
        if (r21 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("memberList");
    L36:
        r0.addOnScrollListener(new MemberListFragment$initListener$2(this));
        f.a.e(this, T90(), MemberListFragment$initSubscribe$1.INSTANCE, new MemberListFragment$initSubscribe$2(this));
        f.a.e(this, T90(), MemberListFragment$initSubscribe$3.INSTANCE, new MemberListFragment$initSubscribe$4(this));
        f.a.e(this, T90(), MemberListFragment$initSubscribe$5.INSTANCE, new MemberListFragment$initSubscribe$6(this));
        f.a.f(this, T90(), MemberListFragment$initSubscribe$7.INSTANCE, MemberListFragment$initSubscribe$8.INSTANCE, new MemberListFragment$initSubscribe$9(this));
        return;
    L35:
        r0 = r21;
        goto L36
    }

    public final <S extends j> com.larksuite.arch.jack.c nH(JackViewModel<S> r1, l<S> r2, Function1<? super S, Unit> r3) {
        return JackView.a.d(this, r1, r2, r3);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131561220, r3, false);
        LKUIPtrClassicFrameLayout r6 = r5.findViewById(2131383445);
        this.g = r6;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pullToRefresh");
        r6 = null;
    L5:
        r6.setEnabled(false);
        this.h = r5.findViewById(2131379847);
        this.j = r5.findViewById(2131388807);
        return r5;
    }

    public final com.larksuite.arch.jack.c Ik(JackViewModel r1, PropertyReference1Impl r2, l r3, Function1 r4) {
        return JackView.a.a(this, r1, r2, r3, r4);
    }

    public final com.larksuite.arch.jack.c Ki(JackViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, l r4, Function1 r5) {
        return JackView.a.b(this, r1, r2, r3, r4, r5);
    }

    public final com.larksuite.arch.jack.c O60(FilePickerViewModel r1, PropertyReference1Impl r2, PropertyReference1Impl r3, PropertyReference1Impl r4, l r5, Function1 r6) {
        return JackView.a.c(this, r1, r2, r3, r4, r5, r6);
    }
}
