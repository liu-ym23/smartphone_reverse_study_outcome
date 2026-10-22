package com.ss.android.lark.flow.chat.creategroup.page;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.base.view.SearchResultView;
import com.ss.android.lark.picker.base.widget.BasePicker;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.picker.doubao.LarkPicker;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u00021=\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u001aH\u0002J\b\u0010)\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\u001aH\u0016J\b\u0010/\u001a\u00020\u001aH\u0016J\b\u00103\u001a\u000204H\u0016J\"\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\u001aH\u0002R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010*\u001a\u00020+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>¨\u0006@"}, d2 = {"Lcom/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateFragmentV2;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "chatAppContainer", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "getChatAppContainer", "()Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;", "setChatAppContainer", "(Lcom/ss/android/lark/chat/chatwindow/chat/v2/push/IChatAppContainer;)V", "mPickerContainer", "Landroid/widget/FrameLayout;", "mPicker", "Lcom/ss/android/lark/picker/Picker;", "confirmBottomContainer", "Landroid/view/ViewGroup;", "mConfirmBT", "Landroid/widget/TextView;", "viewModel", "Lcom/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateViewModel;", "getViewModel", "()Lcom/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "onViewCreated", "view", "initView", "picker", "Lcom/ss/android/lark/picker/doubao/LarkPicker;", "initPicker", "initObserver", "initListener", "businessConsumeItem", "Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "getBusinessConsumeItem", "()Lcom/ss/android/lark/picker/base/view/SearchResultView$IOnBusinessConsumeItem;", "onPause", "onDestroy", "pickerListener", "com/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateFragmentV2$pickerListener$1", "Lcom/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateFragmentV2$pickerListener$1;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "setupBottomInsets", "pullerCallback", "com/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateFragmentV2$pullerCallback$1", "Lcom/ss/android/lark/flow/chat/creategroup/page/FlowGroupCreateFragmentV2$pullerCallback$1;", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowGroupCreateFragmentV2 extends Hilt_FlowGroupCreateFragmentV2 implements d0c.c {
    public static final /* synthetic */ int n = 0;

    @Inject
    public v f;
    public FrameLayout g;
    public ViewGroup h;
    public TextView i;
    public final Lazy j;
    public final b k;
    public final c l;
    public final d m;

    public static final class a {
    }

    public static final class b implements SearchResultView.IOnBusinessConsumeItem {
        public final /* synthetic */ FlowGroupCreateFragmentV2 a;

        public final boolean onBusinessConsumeItemClick(SearchBaseInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            return false;
        }

        public b(FlowGroupCreateFragmentV2 r1) {
            this.a = r1;
        }

        public final SearchResultView.CheckBoxBindStatus onBusinessBindItemCheckBox(SearchBaseInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            FlowGroupCreateFragmentV2 r0 = this.a;
            int r1 = FlowGroupCreateFragmentV2.n;
            return r0.T90().getCheckBoxBindStatus(r3);
        }
    }

    public static final class c extends BasePicker.IOnPickNotify {
        public final /* synthetic */ FlowGroupCreateFragmentV2 a;

        public final void onChanged(List<String> r2, List<SearchBaseInfo> r3) {
            Intrinsics.checkNotNullParameter(r2, "ids");
            Intrinsics.checkNotNullParameter(r3, "infoList");
        }

        public c(FlowGroupCreateFragmentV2 r1) {
            this.a = r1;
        }

        public final void onDeSelected(String r2, SearchBaseInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "info");
            FlowGroupCreateFragmentV2 r4 = this.a;
            int r0 = FlowGroupCreateFragmentV2.n;
            r4.T90().removeSelectedUser(r3);
        }

        public final void onSelected(String r2, SearchBaseInfo r3) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "info");
            FlowGroupCreateFragmentV2 r4 = this.a;
            int r0 = FlowGroupCreateFragmentV2.n;
            r4.T90().selectUser(r3);
        }
    }

    public static final class d implements com.ss.android.lark.flow.chat.creategroup.data.f {
        public final /* synthetic */ FlowGroupCreateFragmentV2 a;

        @Override // com.ss.android.lark.flow.chat.creategroup.data.f
        public final Long getChatId() {
            FlowGroupCreateFragmentV2 r0 = this.a;
            int r1 = FlowGroupCreateFragmentV2.n;
            String r2 = r0.T90().getChatId();
            if (r2 != null) goto L5;
        L8:
            boolean r3 = true;
        L10:
            if (r3 == false) goto L15;
            return null;
        L15:
            return Long.valueOf(CastLongProtector.parseLong(r2));
        L17:
            return null;
        L5:
            if (r2.length() == 0) goto L8;
            r3 = false;
            goto L10
        }

        public d(FlowGroupCreateFragmentV2 r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.creategroup.page.FlowGroupCreateFragmentV2$onActivityResult$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.ss.android.lark.flow.chat.creategroup.page.FlowGroupCreateFragmentV2$onActivityResult$1", f = "FlowGroupCreateFragmentV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Intent $data;
        int label;
        final /* synthetic */ FlowGroupCreateFragmentV2 this$0;

        public AnonymousClass1(Intent r1, FlowGroupCreateFragmentV2 r2, Continuation<? super AnonymousClass1> r3) {
            this.$data = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$data, this.this$0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            Serializable r4 = this.$data.getSerializableExtra("selectedMember");
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.collections.List<com.ss.android.lark.contact.entity.SelectedData>");
            FlowGroupCreateFragmentV2 r0 = this.this$0;
            int r1 = FlowGroupCreateFragmentV2.n;
            FlowGroupCreateViewModel r2 = r0.T90();
            r2.resetSelectedUser((List) r4);
            this.this$0.getClass();
            Intrinsics.throwUninitializedPropertyAccessException("mPicker");
            throw null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    public final FlowGroupCreateViewModel T90() {
        return (FlowGroupCreateViewModel) this.j.getValue();
    }

    @Inject
    public FlowGroupCreateFragmentV2() {
        Function0<ViewModelProvider.Factory> r0 = new FlowGroupCreateFragmentV2$viewModel$2(this);
        final Function0<Fragment> r1 = new FlowGroupCreateFragmentV2$special$$inlined$viewModels$default$1(this);
        this.j = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FlowGroupCreateViewModel.class), new FlowGroupCreateFragmentV2$special$$inlined$viewModels$default$2(r1), r0);
        this.k = new b(this);
        this.l = new c(this);
        this.m = new d(this);
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m30provideComponent() {
        return provideComponent();
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        T90().initData(getArguments());
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        this.h = (ViewGroup) r6.findViewById(2131367646);
        this.g = (FrameLayout) r6.findViewById(2131382269);
        TextView r8 = (TextView) r6.findViewById(2131367639);
        this.i = r8;
        ViewGroup r0 = null;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBT");
        r8 = null;
    L5:
        r8.setText(UIUtils.getString(getContext(), 2131890097));
        TextView r9 = this.i;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBT");
        r9 = null;
    L8:
        r9.setEnabled(false);
        final FragmentActivity r10 = getActivity();
        if ((r10 instanceof FragmentActivity) == true) goto L12;
        r10 = null;
    L12:
        if (r10 == null) goto L18;
        PickerConfig r1 = new PickerConfig(new Dependency(r10, r10.getSupportFragmentManager()), new Permissions(CollectionsKt.listOf(ActionType.INVITE_SAME_CHAT)));
        r1.extra(new FlowGroupCreateFragmentV2$initPicker$pickerConfig$1$1(r10, this));
        r1.searcher(FlowGroupCreateFragmentV2$initPicker$pickerConfig$1$2.INSTANCE);
        r1.recommendList(new FlowGroupCreateFragmentV2$initPicker$pickerConfig$1$3(this));
        LarkPicker r2 = new LarkPicker(requireContext(), null, 2, null);
        LarkPicker.attachRecommendEmptyViewConfig$default(r2, 2131238262, null, 2, null);
        r2.init(r10, r1);
        r2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        r2.setConsumeResultLayoutClickWhenEmpty(true);
        FrameLayout r11 = this.g;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mPickerContainer");
        r11 = null;
    L17:
        r11.addView(r2);
    L18:
        T90().getSelectUserCountData().observe(getViewLifecycleOwner(), new e(this));
        T90().getEnableConfirmBtn().observe(getViewLifecycleOwner(), new f(this));
        TextView r12 = this.i;
        if (r12 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mConfirmBT");
        r12 = null;
    L21:
        r12.setOnClickListener(new FlowGroupCreateFragmentV2$initListener$1(this));
        ViewGroup r13 = this.h;
        if (r13 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBottomContainer");
        r13 = null;
    L24:
        int r14 = r13.getPaddingBottom();
        ViewGroup r3 = this.h;
        if (r3 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBottomContainer");
        r3 = null;
    L27:
        ViewCompat.setOnApplyWindowInsetsListener(r3, new g(r14));
        ViewGroup r15 = this.h;
        if (r15 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBottomContainer");
    L31:
        ViewCompat.requestApplyInsets(r0);
        return;
    L30:
        r0 = r15;
        goto L31
    }

    public final void onActivityResult(int r7, int r8, Intent r9) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r7, r8, r9);
        if (r8 != (-1)) goto L10;
        if (r9 != null) goto L7;
        return;
    L7:
        if (r7 != 18) goto L11;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new AnonymousClass1(r9, this, null), 2, null);
        return;
    L11:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561194, r3, false);
    }
}
