package com.suite.lark.platform.feature.forward.doubao;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.lark.pb.basic.v1.ActionType;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.KeyboardUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.forwardv3.ExternalForwardSendMode;
import com.ss.android.lark.forwardv3.ForwardModuleV3;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.doubao.DoubaoWorkSearchResultAdapterKt;
import com.ss.android.lark.forwardv3.messageforward.MergeMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.OneByOneMessageForwardContent;
import com.ss.android.lark.forwardv3.messageforward.SingleMessageForwardContent;
import com.ss.android.lark.forwardv3.utils.ConfigUtils;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModel;
import com.ss.android.lark.forwardv3.viewmodel.ForwardV3ViewModelFactory;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.SearchResultAdapter;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u001bH\u0002J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u0017H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0013H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\u0010\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020%H\u0002J\b\u00101\u001a\u00020\u0017H\u0002J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u000204H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/DoubaoForwardFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "forwardTemplateNew", "Lcom/ss/android/lark/forwardv3/configuration/ForwardTemplateNew;", "viewModel", "Lcom/ss/android/lark/forwardv3/viewmodel/ForwardV3ViewModel;", "chatPicker", "Lcom/ss/android/lark/forwardv3/dependency/IForwardChatPicker;", "confirmBtn", "Landroid/widget/TextView;", "closeBtn", "Landroid/widget/ImageView;", "activityStartTime", "", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "emptyViewLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "installSearchEmptyViewFix", "pickerContainer", "installSearchEmptyViewFixWithRetry", "remaining", "", "clampEmptyViewIntoParent", "emptyView", "initViewModel", "templateNew", "initChatPicker", "dealBusinessConsumeClick", "", "data", "observeViewModel", "updateConfirmButton", "selectedCount", "hideKeyboardAfterPick", "errorToast", "errorMsg", "", "Companion", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class DoubaoForwardFragment extends BaseFragment {
    public ForwardTemplateNew d;
    public ForwardV3ViewModel e;
    public tib.e f;
    public TextView g;
    public ImageView h;
    public long i;
    public IGetDataCallback<List<SearchBaseInfo>> j;
    public q k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ DoubaoForwardFragment a;

        public b(DoubaoForwardFragment r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [android.content.Context, com.suite.lark.platform.feature.forward.doubao.ForwardDoubaoActivity] */
        /* JADX WARN: Type inference failed for: r2v6 */
        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ForwardDoubaoActivity r3 = this.a.getActivity();
            if ((r3 instanceof ForwardDoubaoActivity) == false) goto L5;
            ?? r4 = r3;
        L6:
            if (r4 == 0) goto L9;
            KeyboardUtils.hideKeyboard(r4);
            r4.finish();
            return;
        L9:
            return;
        L5:
            r4 = 0;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ DoubaoForwardFragment a;

        public c(DoubaoForwardFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            ForwardV3ViewModel r8 = this.a.e;
            View r0 = null;
            if (r8 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r8 = null;
        L5:
            List<SearchBaseInfo> r9 = r8.getSelectedItemList();
            if (r9.isEmpty() == false) goto L8;
            return;
        L8:
            FragmentActivity r1 = this.a.getActivity();
            if ((r1 instanceof ForwardDoubaoActivity) == false) goto L11;
            FragmentActivity r2 = (ForwardDoubaoActivity) r1;
        L12:
            if (r2 == null) goto L29;
            Intrinsics.checkNotNullParameter(r9, "items");
            Fragment r10 = r2.getSupportFragmentManager().findFragmentById(2131373275);
            if (r10 != null) goto L17;
            return;
        L17:
            if (r2.getSupportFragmentManager().findFragmentByTag("DoubaoForwardConfirmFragment") == null) goto L19;
            Log.w("ForwardDoubaoActivity", "openConfirmFragment skip: already attached");
            return;
        L19:
            KeyboardUtils.hideKeyboard(r2);
            DoubaoForwardConfirmFragment r3 = new DoubaoForwardConfirmFragment();
            FragmentTransaction r11 = r2.getSupportFragmentManager().beginTransaction().hide(r10);
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r11, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "DoubaoForwardConfirmFragment", 2131373275) == true) goto L23;
            r11 = r11.add(2131373275, r3, "DoubaoForwardConfirmFragment");
        L23:
            r11.addToBackStack("DoubaoForwardConfirmFragment").commitAllowingStateLoss();
            r2.o = true;
            View r12 = r2.l;
            if (r12 != null) goto L26;
            Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        L27:
            r0.post(new d0(r2));
            return;
        L26:
            r0 = r12;
            goto L27
        L29:
            return;
        L11:
            r2 = null;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.suite.lark.platform.feature.forward.doubao.DoubaoForwardFragment$onActivityCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.suite.lark.platform.feature.forward.doubao.DoubaoForwardFragment$onActivityCreated$1", f = "DoubaoForwardFragment.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoubaoForwardFragment this$0;

        public AnonymousClass1(DoubaoForwardFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ForwardV3ViewModel r5 = this.this$0.e;
            if (r5 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r5 = null;
        L11:
            this.label = 1;
            if (r5.asyncLoadMessageParams(this) != r0) goto L15;
            return r0;
        }
    }

    static {
    }

    public final void onDestroyView() {
        q r0 = this.k;
        if (r0 == null) goto L9;
        View r1 = getView();
        if (r1 == null) goto L9;
        View r2 = r1.findViewById(2131385568);
        if (r2 == null) goto L9;
        r2.removeOnLayoutChangeListener(r0);
    L9:
        this.k = null;
        tib.e r3 = this.f;
        if (r3 == null) goto L12;
        r3.destroy();
    L12:
        super.onDestroyView();
    }

    public DoubaoForwardFragment() {
    }

    public final void T90(int r6) {
        if (r6 <= 0) goto L4;
        boolean r0 = true;
    L5:
        TextView r1 = this.g;
        TextView r3 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        r1 = null;
    L8:
        r1.setEnabled(r0);
        TextView r2 = this.g;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        r2 = null;
    L11:
        r2.setCompoundDrawables(null, null, null, null);
        TextView r4 = this.g;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        r4 = null;
    L14:
        Context r5 = requireContext();
        if (r0 == false) goto L17;
        int r7 = 2131102049;
    L18:
        r4.setTextColor(ContextCompat.getColor(r5, r7));
        TextView r8 = this.g;
        if (r8 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
    L22:
        if (r6 <= 0) goto L24;
        String r9 = y9c.d.j(2131892073, "count", String.valueOf(r6));
    L25:
        r3.setText(r9);
        return;
    L24:
        r9 = y9c.d.h(2131891625);
        goto L25
    L21:
        r3 = r8;
        goto L22
    L17:
        r7 = 2131108723;
        goto L18
    L4:
        r0 = false;
        goto L5
    }

    public final void onActivityCreated(Bundle r31) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onActivityCreated(r31);
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        ForwardTemplateNew r2 = (ForwardTemplateNew) r1.getParcelable("key_intent_forward_template_new");
    L6:
        if (r2 != null) goto L11;
        Log.e("DoubaoForwardFragment", "ForwardTemplateNew is null, finish");
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L86;
        r3.finish();
        return;
    L86:
        return;
    L11:
        Bundle r4 = getArguments();
        if (r4 == null) goto L14;
        long r5 = r4.getLong("activity_start_time");
    L15:
        this.i = r5;
        this.d = r2;
        ForwardV3ViewModel r6 = (ForwardV3ViewModel) new ViewModelProvider(requireActivity(), new ForwardV3ViewModelFactory(r2)).get(ForwardV3ViewModel.class);
        this.e = r6;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L18:
        r6.init();
        m r11 = new m(this);
        n r10 = new n(this);
        ForwardV3ViewModel r7 = this.e;
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L21:
        ConfigUtils.b r8 = r7.getSearchPickerParams();
        k r14 = new k(this);
        l r12 = new l(this);
        int r9 = 0;
        boolean r13 = com.ss.android.lark.forwardv3.utils.b.a("im.forward.disabledoubaosearch", false);
        Log.i("FGUtils", "FG key: im.forward.disabledoubaosearch: " + r13);
        if (r13 == true) goto L40;
        Intent r15 = requireActivity().getIntent();
        if (r15 == null) goto L26;
        String r16 = r15.getStringExtra("extra_external_forward_send_mode");
    L27:
        ExternalForwardSendMode[] r17 = ExternalForwardSendMode.values();
        int r18 = r17.length;
    L28:
        if (r9 >= r18) goto L33;
        ExternalForwardSendMode r19 = r17[r9];
        if (Intrinsics.areEqual(r19.name(), r16) == true) goto L34;
        r9 = r9 + 1;
    L34:
        if (r19 != null) goto L36;
        r19 = ExternalForwardSendMode.DOUBAO_ENTRY;
    L36:
        ForwardTemplateNew r20 = this.d;
        if (r20 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("forwardTemplateNew");
        r20 = null;
    L39:
        com.ss.android.lark.forwardv3.doubao.d r21 = DoubaoWorkSearchResultAdapterKt.a(r20.getForwardTargetConfig().c, r19, ForwardModuleV3.a());
    L41:
        tib.e r22 = this.f;
        if (r22 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        tib.e r23 = null;
    L45:
        if (r21 == null) goto L47;
        Boolean r110 = Boolean.valueOf(r21.a);
    L48:
        if (r21 == null) goto L50;
        SearchResultAdapter r24 = r21.b;
    L51:
        List r111 = CollectionsKt.listOf(ActionType.SHARE_MESSAGE_SELECT_USER);
        ForwardV3ViewModel r25 = this.e;
        if (r25 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r25 = null;
    L54:
        boolean r26 = !r25.getDefaultSingleSelectMode();
        ForwardV3ViewModel r27 = this.e;
        if (r27 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r27 = null;
    L57:
        boolean r28 = r27.getEnableChatPreview();
        ForwardTemplateNew r29 = this.d;
        if (r29 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("forwardTemplateNew");
        r29 = null;
    L60:
        IncludeConfig r30 = r29.getForwardTargetConfig().d;
        ForwardTemplateNew r32 = this.d;
        if (r32 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("forwardTemplateNew");
        r32 = null;
    L63:
        boolean r112 = r32.getForwardTargetConfig().c;
        r23.g(new tib.b("forward_doubao", r111, Boolean.valueOf(r26), Boolean.valueOf(r28), Boolean.TRUE, r10, r11, r12, new tib.d(r8.a, r8.b, r8.c, r8.d, r8.e, r8.f), r30, r112, r14, null, null, r110, r24, 1262640));
        tib.e r33 = this.f;
        if (r33 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
        r33 = null;
    L66:
        r33.e();
        ForwardV3ViewModel r34 = this.e;
        if (r34 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r34 = null;
    L69:
        r34.getSelectedItem().observe(getViewLifecycleOwner(), new s(this));
        ForwardV3ViewModel r35 = this.e;
        if (r35 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r35 = null;
    L72:
        r35.getRecommendData().observe(getViewLifecycleOwner(), new t(this));
        ForwardV3ViewModel r36 = this.e;
        if (r36 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r36 = null;
    L75:
        IForwardContent r37 = r36.getForwardContent();
        if ((r37 instanceof SingleMessageForwardContent) == false) goto L78;
        return;
    L78:
        if ((r37 instanceof MergeMessageForwardContent) == false) goto L80;
        return;
    L80:
        if ((r37 instanceof OneByOneMessageForwardContent) == true) goto L89;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L89:
        return;
    L50:
        r24 = null;
        goto L51
    L47:
        r110 = null;
        goto L48
    L44:
        r23 = r22;
        goto L45
    L33:
        r19 = null;
        goto L34
    L26:
        r16 = null;
        goto L27
    L40:
        r21 = null;
        goto L41
    L14:
        r5 = 0;
        goto L15
    L5:
        r2 = null;
        goto L6
    }

    public static final void S90(DoubaoForwardFragment r3, View r4) {
        r3.getClass();
        Object r5 = r4.getParent();
        if ((r5 instanceof View) == false) goto L5;
        View r6 = (View) r5;
    L6:
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.getHeight() > 0) goto L11;
        return;
    L11:
        if (r4.getHeight() <= 0) goto L26;
        float r0 = r6.getPaddingTop();
        float r7 = (r6.getHeight() - r6.getPaddingBottom()) - r4.getHeight();
        if (r7 <= r0) goto L27;
        float r1 = r4.getTop() + r4.getTranslationY();
        float r8 = RangesKt.coerceIn(r1, r0, r7);
        if (r8 != r1) goto L19;
        boolean r2 = true;
    L20:
        if (r2 == true) goto L24;
        r4.setTranslationY(r4.getTranslationY() + (r8 - r1));
        return;
    L24:
        return;
    L19:
        r2 = false;
        goto L20
    L27:
        return;
    L26:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r6, "inflater");
        View r9 = r6.inflate(2131561203, r7, false);
        this.g = (TextView) r9.findViewById(2131373242);
        ImageView r10 = (ImageView) r9.findViewById(2131373237);
        this.h = r10;
        tib.e r1 = null;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
        r10 = null;
    L5:
        r10.setImageResource(2131254124);
        ImageView r11 = this.h;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
        r11 = null;
    L8:
        r11.setOnClickListener(new b(this));
        TextView r12 = this.g;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
        r12 = null;
    L11:
        r12.setOnClickListener(new c(this));
        ViewGroup r13 = (ViewGroup) r9.findViewById(2131373236);
        r13.removeAllViews();
        tib.c r14 = ForwardModuleV3.a().createForwardChatPicker(requireContext());
        r13.addView(r14.a, new ViewGroup.LayoutParams(-1, -1));
        tib.e r15 = r14.b;
        this.f = r15;
        if (r15 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("chatPicker");
    L15:
        r1.setConsumeResultLayoutClickWhenEmpty(true);
        Intrinsics.checkNotNull(r13);
        View r16 = r13.findViewById(2131385568);
        if (r16 == null) goto L22;
        r16.setOnClickListener(o.a);
        q r17 = new q(this);
        q r2 = this.k;
        if (r2 == null) goto L21;
        r16.removeOnLayoutChangeListener(r2);
    L21:
        this.k = r17;
        r16.addOnLayoutChangeListener(r17);
        r16.post(new p(this, r16));
    L22:
        T90(0);
        return r9;
    L14:
        r1 = r15;
        goto L15
    }
}
