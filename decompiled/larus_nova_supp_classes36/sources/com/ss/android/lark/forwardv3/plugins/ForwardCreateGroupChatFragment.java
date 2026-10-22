package com.ss.android.lark.forwardv3.plugins;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.ss.android.lark.base.fragment.BaseForsetiFragment;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModelFactory;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.NavPicker;
import com.ss.android.lark.picker.config.NavPickerConfig;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.statistics.PickerStatistics;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0004!$'*\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0014H\u0002J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00109\u001a\u000200H\u0002J\n\u0010:\u001a\u0004\u0018\u000104H\u0002J\u0010\u0010;\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0014H\u0002J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u000200H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0004\n\u0002\u0010+¨\u0006A"}, d2 = {"Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment;", "Lcom/ss/android/lark/base/fragment/BaseForsetiFragment;", "forwardTemplate", "Lcom/ss/android/lark/forwardv3/configuration/ForwardTemplateNew;", "callback", "Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatPlugin$CreateGroupChatCallBack;", "<init>", "(Lcom/ss/android/lark/forwardv3/configuration/ForwardTemplateNew;Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatPlugin$CreateGroupChatCallBack;)V", "getForwardTemplate", "()Lcom/ss/android/lark/forwardv3/configuration/ForwardTemplateNew;", "getCallback", "()Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatPlugin$CreateGroupChatCallBack;", "navPicker", "Lcom/ss/android/lark/picker/NavPicker;", "loadingToast", "Lcom/larksuite/component/universe_design/toast/UDToastImpl;", "viewModel", "Lcom/ss/android/lark/forwardv3/viewmodel/ForwardV3ViewModel;", "selectedChat", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/ArrayList;", "getSelectedChat", "()Ljava/util/ArrayList;", "setSelectedChat", "(Ljava/util/ArrayList;)V", "clickThrottle", "Lcom/ss/android/lark/forwardv3/utils/ForwardClickThrottle;", "getClickThrottle", "()Lcom/ss/android/lark/forwardv3/utils/ForwardClickThrottle;", "clickThrottle$delegate", "Lkotlin/Lazy;", "pickerListener", "com/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$pickerListener$1", "Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$pickerListener$1;", "cancelListener", "com/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$cancelListener$1", "Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$cancelListener$1;", "confirmListener", "com/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$confirmListener$1", "Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$confirmListener$1;", "pickerItemConsumer", "com/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$pickerItemConsumer$1", "Lcom/ss/android/lark/forwardv3/plugins/ForwardCreateGroupChatFragment$pickerItemConsumer$1;", "isSelf", "", "data", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initWindowInsets", "initPicker", "dealBusinessConsumeClick", "getNavPickerConfig", "Lcom/ss/android/lark/picker/config/NavPickerConfig;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "onDestroy", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardCreateGroupChatFragment extends BaseForsetiFragment {
    public static final /* synthetic */ int r = 0;
    public final ForwardTemplateNew g;
    public final ForwardCreateGroupChatPlugin.a h;
    public NavPicker i;
    public com.larksuite.component.universe_design.toast.c j;
    public ForwardV3ViewModel k;
    public final ArrayList<SearchBaseInfo> l;
    public final Lazy m;
    public final e n;
    public final c o;
    public final ForwardCreateGroupChatFragment$confirmListener$1 p;
    public final d q;

    public final void onDestroy() {
        super/*com.ss.android.lark.base.fragment.BaseFragment*/.onDestroy();
        com.larksuite.component.universe_design.toast.c r0 = this.j;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.j = null;
    }

    public static final /* synthetic */ Context U90(ForwardCreateGroupChatFragment r0) {
        return ((BaseFragment) r0).mContext;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        ForwardV3ViewModel r4 = (ForwardV3ViewModel) new ViewModelProvider(this, new ForwardV3ViewModelFactory(this.g)).get(ForwardV3ViewModel.class);
        this.k = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r4 = null;
    L5:
        r4.init();
        Intrinsics.checkNotNullParameter(this, "<this>");
        WindowInsetsUtils.b(this).o(true);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new AnonymousClass1(this));
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.ss.android.lark.forwardv3.plugins.ForwardCreateGroupChatFragment$confirmListener$1] */
    public ForwardCreateGroupChatFragment(ForwardTemplateNew r2, ForwardCreateGroupChatPlugin.b.a r3) {
        Intrinsics.checkNotNullParameter(r2, "forwardTemplate");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.g = r2;
        this.h = r3;
        this.l = new ArrayList();
        this.m = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ForwardCreateGroupChatFragment$clickThrottle$2.INSTANCE);
        this.n = new e(this);
        this.o = new c(this);
        this.p = new ForwardCreateGroupChatFragment$confirmListener$1(this);
        this.q = new d(this);
    }

    public static final boolean V90(ForwardCreateGroupChatFragment r0, SearchBaseInfo r1) {
        r0.getClass();
        if ((r1 instanceof SearchChatterInfo) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(ForwardModuleV3.a().getLoginUserId(), ((SearchChatterInfo) r1).getId()) == false) goto L7;
        return true;
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        FragmentActivity r8 = getActivity();
        if (r8 == null) goto L6;
        NavPicker r9 = new NavPicker(r8, null, 2, null);
        r9.scene(PickerStatistics.Scene.ImCreateAndForward);
        NavPickerConfig r10 = new NavPickerConfig(new Dependency(r8, getChildFragmentManager()), new Permissions(CollectionsKt.listOf(new ActionType[]{ActionType.INVITE_SAME_CHAT, ActionType.SHARE_MESSAGE_SELECT_USER})));
        r10.navigation(new ForwardCreateGroupChatFragment$getNavPickerConfig$navPickerConfig$1$1(this));
        r10.extra(new ForwardCreateGroupChatFragment$getNavPickerConfig$navPickerConfig$1$2(this));
        r10.searcher(new ForwardCreateGroupChatFragment$getNavPickerConfig$navPickerConfig$1$3(this));
        r10.addressBook(ForwardCreateGroupChatFragment$getNavPickerConfig$navPickerConfig$1$4.INSTANCE);
        r9.init(r10);
        this.i = r9;
    L6:
        return this.i;
    }
}
