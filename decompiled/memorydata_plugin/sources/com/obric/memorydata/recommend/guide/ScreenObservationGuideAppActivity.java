package com.obric.memorydata.recommend.guide;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ActivityGuideAppBinding;
import com.obric.memorydata.recommend.settings.ScreenObservationSettingsActivity;
import com.obric.memorydata.recommend.settings.k;
import com.obric.memorydata.recommend.settings.r;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.memorydata.ui.h;
import com.obric.memorydata.utils.bb;
import com.obric.oui.button.OButton;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.z;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
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
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.j;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u0016H\u0014J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0014J\b\u0010\u001e\u001a\u00020\u001aH\u0014J\b\u0010\u001f\u001a\u00020\u001aH\u0014J\b\u0010 \u001a\u00020\u001aH\u0016J\b\u0010!\u001a\u00020\u001aH\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u001aH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/memorydata/recommend/guide/ScreenObservationGuideAppActivity;", "Lcom/obric/memorydata/ui/BaseActivity;", "<init>", "()V", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "binding", "Lcom/obric/memorydata/recommend/databinding/ActivityGuideAppBinding;", "adapter", "Lcom/obric/memorydata/recommend/guide/HeaderFooterWrapper;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "categoryAdapter", "Lcom/obric/memorydata/recommend/guide/GuideAppFlattenAdapter;", "viewModel", "Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel;", "getViewModel", "()Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isNeedRefreshOnResume", "", "needLoginCheckOnCreate", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onResumeChecked", "onPause", "onDestroy", "finish", "onBackPressed", "initTitleBar", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "initViews", "observeState", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenObservationGuideAppActivity extends BaseActivity {
    public static final a Companion = null;
    private static final String TAG = "ScreenObservationGuideAppActivity";
    private e<RecyclerView.v> adapter;
    private ActivityGuideAppBinding binding;
    private com.obric.memorydata.recommend.guide.a categoryAdapter;
    private boolean isNeedRefreshOnResume;
    private final NavigationBarScheme navigationBarScheme;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/guide/ScreenObservationGuideAppActivity$Companion;", "", "<init>", "()V", "TAG", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "cleanTop", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.guide.ScreenObservationGuideAppActivity$observeState$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.guide.ScreenObservationGuideAppActivity$observeState$1", f = "ScreenObservationGuideAppActivity.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ScreenObservationGuideAppActivity this$0;

        AnonymousClass1(ScreenObservationGuideAppActivity r3, Continuation<? super AnonymousClass1> r4) {
            ScreenObservationGuideAppActivity r5 = (ScreenObservationGuideAppActivity) ZeusTransformUtils.wrapperContextForParams(r3, ScreenObservationGuideAppActivity.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r5;
            super(2, r6);
        }

        private static final boolean invokeSuspend$lambda$0(k r0, k r1) {
            if (r0.d() != r1.d()) goto L5;
            return true;
        L5:
            return false;
        }

        public static /* synthetic */ boolean lambda$8484y0FBmhrX90_mtSjXoeWmNTI(k r0, k r1) {
            return invokeSuspend$lambda$0(r0, r1);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            i r7 = kotlinx.coroutines.flow.k.a((i) ZeusTransformUtils.preCheckCast(ScreenObservationGuideAppActivity.access$getViewModel(this.this$0).getState(), i.class, "com.obric.memorydata.plugin"), $$Lambda$ScreenObservationGuideAppActivity$observeState$1$8484y0FBmhrX90_mtSjXoeWmNTI.INSTANCE);
            final ScreenObservationGuideAppActivity r4 = this.this$0;
            j r2 = (j) ZeusTransformUtils.preCheckCast(new C06701(r4), j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public ScreenObservationGuideAppActivity() {
        this.navigationBarScheme = NavigationBarScheme.A;
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new ScreenObservationGuideAppActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.viewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(ScreenObservationCategoryViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new ScreenObservationGuideAppActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new ScreenObservationGuideAppActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ com.obric.memorydata.recommend.guide.a access$getCategoryAdapter$p(ScreenObservationGuideAppActivity r2) {
        return ((ScreenObservationGuideAppActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationGuideAppActivity.class, "com.obric.memorydata.plugin")).categoryAdapter;
    }

    public static final /* synthetic */ ScreenObservationCategoryViewModel access$getViewModel(ScreenObservationGuideAppActivity r2) {
        return ((ScreenObservationGuideAppActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationGuideAppActivity.class, "com.obric.memorydata.plugin")).getViewModel();
    }

    private final ScreenObservationCategoryViewModel getViewModel() {
        return (ScreenObservationCategoryViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), ScreenObservationCategoryViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void initTitleBar(OFloatingTitleBar r10) {
        registerFloatingTitleBar(r10);
        BaseActivity r2 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin");
        ActivityGuideAppBinding r9 = this.binding;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L5:
        BaseActivity.setupTitleBarBackAction$default(r2, r10, (View) ZeusTransformUtils.preCheckCast(r9.rvAppList, View.class, "com.obric.memorydata.plugin"), MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())), null, 8, null);
    }

    private final void initViews() {
        ActivityGuideAppBinding r0 = this.binding;
        z r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r1 = r0.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r1, "viewTitle");
        initTitleBar(r1);
        ActivityGuideAppBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        r3.rvAppList.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.recommend.guide.a r4 = new com.obric.memorydata.recommend.guide.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), new $$Lambda$ScreenObservationGuideAppActivity$R17d5yYyaFVezqpitTpsnqFhpZc(this));
        r4.a($$Lambda$ScreenObservationGuideAppActivity$n0Zb7_6HP6KGqPXo5qYL3r0TKBo.INSTANCE);
        e<RecyclerView.v> r5 = new e((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r4, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        LayoutInflater r6 = getLayoutInflater();
        int r7 = ZeusTransformUtils.mapRes(R.layout.item_guide_app_header, "layout", "item_guide_app_header");
        ActivityGuideAppBinding r8 = this.binding;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L11:
        View r9 = ZeusTransformUtils.inflate(r6, r7, (ViewGroup) ZeusTransformUtils.preCheckCast(r8.rvAppList, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r9, "inflate(...)");
        r5.a(r9);
        ActivityGuideAppBinding r10 = this.binding;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L14:
        r10.barGuideNext.setButtons(CollectionsKt.listOf(com.obric.oui.c.e.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.style.OStyleV2_OButton_L_Standard_Primary, "style", "OStyleV2_OButton_L_Standard_Primary"), new $$Lambda$ScreenObservationGuideAppActivity$iccih_xtsqNHyQz3uRrrYUVC7lg(this))));
        ActivityGuideAppBinding r11 = this.binding;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L17:
        r11.barGuideNext.post(new $$Lambda$ScreenObservationGuideAppActivity$SpPERtJdtCGyvjJ1EHk4FnQDsco(this));
        ActivityGuideAppBinding r12 = this.binding;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L20:
        RecyclerView r13 = r12.rvAppList;
        this.adapter = r5;
        r13.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r5, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        ActivityGuideAppBinding r14 = this.binding;
        if (r14 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L23:
        RecyclerView.e r15 = r14.rvAppList.getItemAnimator();
        if (ZeusTransformUtils.instanceOf(r15, z.class) == false) goto L26;
        r2 = (z) ZeusTransformUtils.preCheckCast(r15, z.class, "com.obric.memorydata.plugin");
    L26:
        if (r2 == null) goto L28;
        r2.a(false);
    L28:
        this.categoryAdapter = r4;
    }

    private static final Unit initViews$lambda$0(ScreenObservationGuideAppActivity r2, Set r3, boolean r4) {
        ScreenObservationGuideAppActivity r5 = (ScreenObservationGuideAppActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationGuideAppActivity.class, "com.obric.memorydata.plugin");
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "packageNames");
        r5.getViewModel().processIntent((r) ZeusTransformUtils.preCheckCast(new r.a(r6, r4), r.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final Unit initViews$lambda$1(ViewGroup.MarginLayoutParams r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "layoutParams");
        float r0 = 12;
        int r1 = MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics()));
        if (r6 != 0) goto L5;
        float r7 = TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics());
    L6:
        r5.setMargins(r1, MathKt.roundToInt(r7), MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics())));
        return Unit.INSTANCE;
    L5:
        r7 = TypedValue.applyDimension(1, 20, Resources.getSystem().getDisplayMetrics());
        goto L6
    }

    private static final OButton initViews$lambda$4(ScreenObservationGuideAppActivity r9, Context r10, int r11, int r12) {
        final ScreenObservationGuideAppActivity r13 = (ScreenObservationGuideAppActivity) ZeusTransformUtils.wrapperContextForParams(r9, ScreenObservationGuideAppActivity.class, "com.obric.memorydata.plugin");
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "styledContext");
        OButton r14 = new OButton(r2, null, 0, 0, null, 28, null);
        r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(r13.getString(ZeusTransformUtils.mapRes(R.string.screen_observation_guide_app_finish, TypedValues.Custom.S_STRING, "screen_observation_guide_app_finish")), CharSequence.class, "com.obric.memorydata.plugin"));
        r14.setLayoutParams(new ViewGroup.LayoutParams(-1, r12));
        r14.setOnClickListener(new $$Lambda$ScreenObservationGuideAppActivity$CrdZ7lHzu9nyq9t78b6VzhTA4Nk(r13));
        return r14;
    }

    private static final void initViews$lambda$4$lambda$3$lambda$2(ScreenObservationGuideAppActivity r5, View r6) {
        ScreenObservationGuideAppActivity r7 = (ScreenObservationGuideAppActivity) ZeusTransformUtils.wrapperContextForParams(r5, ScreenObservationGuideAppActivity.class, "com.obric.memorydata.plugin");
        ScreenObservationSettingsActivity.a.a(ScreenObservationSettingsActivity.Companion, (Context) ZeusTransformUtils.preCheckCast(r7, Context.class, "com.obric.memorydata.plugin"), false, 2, null);
        ZeusTransformUtils.setResult(r7, -1, "com.obric.memorydata.plugin");
        r7.finish();
    }

    private static final void initViews$lambda$5(ScreenObservationGuideAppActivity r7) {
        ScreenObservationGuideAppActivity r8 = (ScreenObservationGuideAppActivity) ZeusTransformUtils.wrapperContextForParams(r7, ScreenObservationGuideAppActivity.class, "com.obric.memorydata.plugin");
        ActivityGuideAppBinding r0 = r8.binding;
        ActivityGuideAppBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView r1 = r0.rvAppList;
        Intrinsics.checkNotNullExpressionValue(r1, "rvAppList");
        View r3 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
        ActivityGuideAppBinding r4 = r8.binding;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L8:
        bb.c(r3, r4.barGuideNext.getHeight() + MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())));
        ActivityGuideAppBinding r9 = r8.binding;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        r2.rvAppList.scrollToPosition(0);
        return;
    L11:
        r2 = r9;
        goto L12
    }

    public static /* synthetic */ void lambda$CrdZ7lHzu9nyq9t78b6VzhTA4Nk(ScreenObservationGuideAppActivity r0, View r1) {
        initViews$lambda$4$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ Unit lambda$R17d5yYyaFVezqpitTpsnqFhpZc(ScreenObservationGuideAppActivity r0, Set r1, boolean r2) {
        return initViews$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$SpPERtJdtCGyvjJ1EHk4FnQDsco(ScreenObservationGuideAppActivity r0) {
        initViews$lambda$5(r0);
    }

    public static /* synthetic */ OButton lambda$iccih_xtsqNHyQz3uRrrYUVC7lg(ScreenObservationGuideAppActivity r0, Context r1, int r2, int r3) {
        return initViews$lambda$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$n0Zb7_6HP6KGqPXo5qYL3r0TKBo(ViewGroup.MarginLayoutParams r0, int r1) {
        return initViews$lambda$1(r0, r1);
    }

    private final void observeState() {
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public void finish() {
        super.finish();
        ZeusTransformUtils.setResult(this, -1, "com.obric.memorydata.plugin");
        h.f13009a.c((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public NavigationBarScheme getNavigationBarScheme() {
        return this.navigationBarScheme;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean needLoginCheckOnCreate() {
        return true;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean needLoginCheckOnResume() {
        return true;
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        super.onBackPressed();
        h.f13009a.c((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onCreate", false, 4, null);
        prepareSystemBar();
        h.f13009a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"));
        ActivityGuideAppBinding r10 = ActivityGuideAppBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r10, "inflate(...)");
        this.binding = r10;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r10.getRoot(), View.class, "com.obric.memorydata.plugin"));
        initViews();
        observeState();
        this.isNeedRefreshOnResume = false;
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        MemoryService.INSTANCE.clearAppIconCache();
    }

    @Override // com.obric.memorydata.ui.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onPause() {
        super.onPause();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onPause", false, 4, null);
        this.isNeedRefreshOnResume = true;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onResume", false, 4, null);
        if (this.isNeedRefreshOnResume == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onResume refresh", false, 4, null);
        getViewModel().refresh();
        return;
    }
}
