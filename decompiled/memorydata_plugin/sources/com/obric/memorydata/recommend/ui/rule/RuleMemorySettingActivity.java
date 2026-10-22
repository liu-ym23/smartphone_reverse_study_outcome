package com.obric.memorydata.recommend.ui.rule;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ActivityRuleMemorySettingBinding;
import com.obric.memorydata.recommend.guide.ScreenObservationCategoryViewModel;
import com.obric.memorydata.recommend.settings.k;
import com.obric.memorydata.recommend.settings.r;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.BaseAuthActivity;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.KotlinNothingValueException;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.j;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001bH\u0014J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002J\u0018\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\u000e\u0012\b\u0012\u00060\u000eR\u00020\u000f\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/RuleMemorySettingActivity;", "Lcom/obric/memorydata/ui/BaseAuthActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/recommend/databinding/ActivityRuleMemorySettingBinding;", "viewModel", "Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel;", "getViewModel", "()Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/obric/memorydata/recommend/guide/HeaderFooterWrapper;", "Lcom/obric/memorydata/recommend/ui/rule/RuleMemorySettingAdapter$CategoryListViewHolder;", "Lcom/obric/memorydata/recommend/ui/rule/RuleMemorySettingAdapter;", "contentAdapter", "openAll", "Lcom/obric/oui/lisitem/OCardListItem;", "openCustom", "openNone", "appCategoryTitle", "Landroid/view/View;", "needLoginCheckOnCreate", "", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onResumeChecked", "initView", "showCheckItems", "newMemorySetting", "", "dpToPx", "dp", "expandTouchArea", TypedValues.AttributesType.S_TARGET, "targetSizeDp", "observeViewModel", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RuleMemorySettingActivity extends BaseAuthActivity {
    public static final a Companion = null;
    private static final String TAG = "RuleMemorySettingActivity";
    private com.obric.memorydata.recommend.guide.e<g.b> adapter;
    private View appCategoryTitle;
    private ActivityRuleMemorySettingBinding binding;
    private g contentAdapter;
    private OCardListItem openAll;
    private OCardListItem openCustom;
    private OCardListItem openNone;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/RuleMemorySettingActivity$Companion;", "", "<init>", "()V", "TAG", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            ZeusTransformUtils.startActivity(r2, new Intent(r2, RuleMemorySettingActivity.class), "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.rule.RuleMemorySettingActivity$observeViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.ui.rule.RuleMemorySettingActivity$observeViewModel$1", f = "RuleMemorySettingActivity.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RuleMemorySettingActivity this$0;

        AnonymousClass1(RuleMemorySettingActivity r3, Continuation<? super AnonymousClass1> r4) {
            RuleMemorySettingActivity r5 = (RuleMemorySettingActivity) ZeusTransformUtils.wrapperContextForParams(r3, RuleMemorySettingActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r6);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            ar<k> r7 = RuleMemorySettingActivity.access$getViewModel(this.this$0).getState();
            final RuleMemorySettingActivity r3 = this.this$0;
            j<? super k> r2 = (j) ZeusTransformUtils.preCheckCast(new C06851(r3), j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public RuleMemorySettingActivity() {
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new RuleMemorySettingActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.viewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(ScreenObservationCategoryViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new RuleMemorySettingActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new RuleMemorySettingActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ ScreenObservationCategoryViewModel access$getViewModel(RuleMemorySettingActivity r2) {
        return ((RuleMemorySettingActivity) ZeusTransformUtils.wrapperContextForParams(r2, RuleMemorySettingActivity.class, "com.obric.memorydata.plugin")).getViewModel();
    }

    public static final /* synthetic */ void access$showCheckItems(RuleMemorySettingActivity r2, int r3) {
        ((RuleMemorySettingActivity) ZeusTransformUtils.wrapperContextForParams(r2, RuleMemorySettingActivity.class, "com.obric.memorydata.plugin")).showCheckItems(r3);
    }

    private final int dpToPx(int r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density) + 0.5f);
    }

    private final void expandTouchArea(final View r4, final int r5) {
        ViewParent r0 = r4.getParent();
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L5;
        final View r1 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        r4.post(new $$Lambda$RuleMemorySettingActivity$G0DGx8aDhyBfDs_TA8rgIHrmSo(r4, this, r5, r1));
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final void expandTouchArea$lambda$5(View r3, RuleMemorySettingActivity r4, int r5, View r6) {
        RuleMemorySettingActivity r7 = (RuleMemorySettingActivity) ZeusTransformUtils.wrapperContextForParams(r4, RuleMemorySettingActivity.class, "com.obric.memorydata.plugin");
        Rect r0 = new Rect();
        r3.getHitRect(r0);
        int r8 = r7.dpToPx(r5);
        int r9 = RangesKt.coerceAtLeast(r8 - r3.getWidth(), 0) / 2;
        int r10 = RangesKt.coerceAtLeast(r8 - r3.getHeight(), 0) / 2;
        r0.left -= r9;
        r0.right += r9;
        r0.top -= r10;
        r0.bottom += r10;
        r6.setTouchDelegate(new TouchDelegate(r0, r3));
    }

    private final ScreenObservationCategoryViewModel getViewModel() {
        return (ScreenObservationCategoryViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), ScreenObservationCategoryViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void initView() {
        ActivityRuleMemorySettingBinding r0 = this.binding;
        ActivityRuleMemorySettingBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r1 = r0.title;
        Intrinsics.checkNotNullExpressionValue(r1, "title");
        registerFloatingTitleBar(r1);
        BaseActivity r5 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin");
        ActivityRuleMemorySettingBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        OFloatingTitleBar r6 = r3.title;
        Intrinsics.checkNotNullExpressionValue(r6, "title");
        ActivityRuleMemorySettingBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        BaseActivity.setupTitleBarBackAction$default(r5, r6, (View) ZeusTransformUtils.preCheckCast(r4.rvAppList, View.class, "com.obric.memorydata.plugin"), MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())), null, 8, null);
        ActivityRuleMemorySettingBinding r7 = this.binding;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L14:
        r7.rvAppList.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        ActivityRuleMemorySettingBinding r8 = this.binding;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L17:
        r8.rvAppList.setItemAnimator(null);
        g r9 = new g((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), new $$Lambda$RuleMemorySettingActivity$2THVX7DFsOSxyLX6_fscUMrD2Kg(this));
        this.contentAdapter = r9;
        com.obric.memorydata.recommend.guide.e<g.b> r10 = new com.obric.memorydata.recommend.guide.e((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r9, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        LayoutInflater r11 = getLayoutInflater();
        int r12 = ZeusTransformUtils.mapRes(R.layout.item_rule_memory_setting_header, "layout", "item_rule_memory_setting_header");
        ActivityRuleMemorySettingBinding r13 = this.binding;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L20:
        View r14 = ZeusTransformUtils.inflate(r11, r12, (ViewGroup) ZeusTransformUtils.preCheckCast(r13.rvAppList, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        View r15 = r14.findViewById(ZeusTransformUtils.mapRes(R.id.openAll, OaidModel.KEY_ID, "openAll"));
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(...)");
        this.openAll = (OCardListItem) ZeusTransformUtils.preCheckCast(r15, OCardListItem.class, "com.obric.memorydata.plugin");
        View r16 = r14.findViewById(ZeusTransformUtils.mapRes(R.id.openCustom, OaidModel.KEY_ID, "openCustom"));
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(...)");
        this.openCustom = (OCardListItem) ZeusTransformUtils.preCheckCast(r16, OCardListItem.class, "com.obric.memorydata.plugin");
        View r17 = r14.findViewById(ZeusTransformUtils.mapRes(R.id.openNone, OaidModel.KEY_ID, "openNone"));
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(...)");
        this.openNone = (OCardListItem) ZeusTransformUtils.preCheckCast(r17, OCardListItem.class, "com.obric.memorydata.plugin");
        View r18 = r14.findViewById(ZeusTransformUtils.mapRes(R.id.app_category_title, OaidModel.KEY_ID, "app_category_title"));
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(...)");
        this.appCategoryTitle = r18;
        OCardListItem r19 = this.openAll;
        if (r19 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("openAll");
        r19 = null;
    L23:
        r19.setOnContentClickListener(new $$Lambda$RuleMemorySettingActivity$FyCleRaAQ5MLrI2DsfnRtAzN71Q(this));
        OCardListItem r20 = this.openCustom;
        if (r20 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("openCustom");
        r20 = null;
    L26:
        r20.setOnContentClickListener(new $$Lambda$RuleMemorySettingActivity$yoFW0sPS0ipsaaZevws_ssjnO78(this));
        OCardListItem r21 = this.openNone;
        if (r21 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("openNone");
        r21 = null;
    L29:
        r21.setOnContentClickListener(new $$Lambda$RuleMemorySettingActivity$8dqDrY3ivrlRDj2FlkXBnc32Xo(this));
        Intrinsics.checkNotNull(r14);
        r10.a(r14);
        ActivityRuleMemorySettingBinding r22 = this.binding;
        if (r22 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L33:
        RecyclerView r23 = r2.rvAppList;
        this.adapter = r10;
        r23.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r10, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        return;
    L32:
        r2 = r22;
        goto L33
    }

    private static final Unit initView$lambda$0(RuleMemorySettingActivity r2, int r3, boolean r4) {
        ((RuleMemorySettingActivity) ZeusTransformUtils.wrapperContextForParams(r2, RuleMemorySettingActivity.class, "com.obric.memorydata.plugin")).getViewModel().processIntent((r) ZeusTransformUtils.preCheckCast(new r.d(r3, r4), r.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final void initView$lambda$1(RuleMemorySettingActivity r1, View r2) {
        ((RuleMemorySettingActivity) ZeusTransformUtils.wrapperContextForParams(r1, RuleMemorySettingActivity.class, "com.obric.memorydata.plugin")).showCheckItems(0);
    }

    private static final void initView$lambda$2(RuleMemorySettingActivity r1, View r2) {
        ((RuleMemorySettingActivity) ZeusTransformUtils.wrapperContextForParams(r1, RuleMemorySettingActivity.class, "com.obric.memorydata.plugin")).showCheckItems(1);
    }

    private static final void initView$lambda$3(RuleMemorySettingActivity r1, View r2) {
        ((RuleMemorySettingActivity) ZeusTransformUtils.wrapperContextForParams(r1, RuleMemorySettingActivity.class, "com.obric.memorydata.plugin")).showCheckItems(2);
    }

    public static /* synthetic */ Unit lambda$2THVX7DFsOSxyLX6_fscUMrD2Kg(RuleMemorySettingActivity r0, int r1, boolean r2) {
        return initView$lambda$0(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$8dqDrY3iv-rlRDj2FlkXBnc32Xo, reason: not valid java name */
    public static /* synthetic */ void m1159lambda$8dqDrY3ivrlRDj2FlkXBnc32Xo(RuleMemorySettingActivity r0, View r1) {
        initView$lambda$3(r0, r1);
    }

    public static /* synthetic */ void lambda$FyCleRaAQ5MLrI2DsfnRtAzN71Q(RuleMemorySettingActivity r0, View r1) {
        initView$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$G0DGx8a-DhyBfDs_TA8rgIHrmSo, reason: not valid java name */
    public static /* synthetic */ void m1160lambda$G0DGx8aDhyBfDs_TA8rgIHrmSo(View r0, RuleMemorySettingActivity r1, int r2, View r3) {
        expandTouchArea$lambda$5(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$yoFW0sPS0ipsaaZevws_ssjnO78(RuleMemorySettingActivity r0, View r1) {
        initView$lambda$2(r0, r1);
    }

    private final void observeViewModel() {
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void showCheckItems(int r10) {
        View r7 = null;
        if (r10 == 0) goto L58;
        if (r10 != 1) goto L6;
        OCardListItem r0 = this.openAll;
        if (r0 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("openAll");
        r0 = null;
    L35:
        OCheckMark r1 = r0.getEndMark();
        if (r1 == null) goto L38;
        r1.setChecked(false);
    L38:
        OCardListItem r2 = this.openCustom;
        if (r2 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("openCustom");
        r2 = null;
    L41:
        OCheckMark r3 = r2.getEndMark();
        if (r3 == null) goto L44;
        r3.setChecked(true);
    L44:
        OCardListItem r4 = this.openNone;
        if (r4 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("openNone");
        r4 = null;
    L47:
        OCheckMark r5 = r4.getEndMark();
        if (r5 == null) goto L50;
        r5.setChecked(false);
    L50:
        g r6 = this.contentAdapter;
        if (r6 == null) goto L53;
        r6.b(getViewModel().getAllCategoryInfo());
    L53:
        View r8 = this.appCategoryTitle;
        if (r8 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("appCategoryTitle");
    L57:
        r7.setVisibility(0);
    L84:
        getViewModel().processIntent((r) ZeusTransformUtils.preCheckCast(new r.e(r10), r.class, "com.obric.memorydata.plugin"));
        return;
    L56:
        r7 = r8;
        goto L57
    L6:
        if (r10 != 2) goto L84;
        OCardListItem r9 = this.openAll;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("openAll");
        r9 = null;
    L11:
        OCheckMark r11 = r9.getEndMark();
        if (r11 == null) goto L14;
        r11.setChecked(false);
    L14:
        OCardListItem r12 = this.openCustom;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("openCustom");
        r12 = null;
    L17:
        OCheckMark r13 = r12.getEndMark();
        if (r13 == null) goto L20;
        r13.setChecked(false);
    L20:
        OCardListItem r14 = this.openNone;
        if (r14 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("openNone");
        r14 = null;
    L23:
        OCheckMark r15 = r14.getEndMark();
        if (r15 == null) goto L26;
        r15.setChecked(true);
    L26:
        g r16 = this.contentAdapter;
        if (r16 == null) goto L29;
        r16.b(CollectionsKt.emptyList());
    L29:
        View r17 = this.appCategoryTitle;
        if (r17 == null) goto L81;
    L82:
        r7 = r17;
    L83:
        r7.setVisibility(8);
    L81:
        Intrinsics.throwUninitializedPropertyAccessException("appCategoryTitle");
        goto L83
    L58:
        OCardListItem r18 = this.openAll;
        if (r18 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("openAll");
        r18 = null;
    L61:
        OCheckMark r19 = r18.getEndMark();
        if (r19 == null) goto L64;
        r19.setChecked(true);
    L64:
        OCardListItem r20 = this.openCustom;
        if (r20 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("openCustom");
        r20 = null;
    L67:
        OCheckMark r21 = r20.getEndMark();
        if (r21 == null) goto L70;
        r21.setChecked(false);
    L70:
        OCardListItem r22 = this.openNone;
        if (r22 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("openNone");
        r22 = null;
    L73:
        OCheckMark r23 = r22.getEndMark();
        if (r23 == null) goto L76;
        r23.setChecked(false);
    L76:
        g r24 = this.contentAdapter;
        if (r24 == null) goto L79;
        r24.b(CollectionsKt.emptyList());
    L79:
        r17 = this.appCategoryTitle;
        if (r17 != null) goto L82;
        goto L81
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean needLoginCheckOnCreate() {
        return true;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean needLoginCheckOnResume() {
        return true;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r5) {
        prepareSystemBar();
        ActivityRuleMemorySettingBinding r6 = ActivityRuleMemorySettingBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(...)");
        this.binding = r6;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityRuleMemorySettingBinding r7 = this.binding;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L8:
        RecyclerView r8 = r7.rvAppList;
        Intrinsics.checkNotNullExpressionValue(r8, "rvAppList");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        initView();
        observeViewModel();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onResume", false, 4, null);
        getViewModel().refresh();
    }
}
