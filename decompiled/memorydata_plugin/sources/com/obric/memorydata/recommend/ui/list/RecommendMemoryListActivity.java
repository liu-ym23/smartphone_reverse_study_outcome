package com.obric.memorydata.recommend.ui.list;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ActivityRecommendMemoryListBinding;
import com.obric.memorydata.recommend.databinding.ItemRecommendMemoryTabBinding;
import com.obric.memorydata.recommend.ui.BaseMemoryActivity;
import com.obric.memorydata.utils.ak;
import com.obric.memorydata.utils.at;
import com.obric.oui.titlebar.OCTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0014J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\u000fH\u0003J\f\u0010!\u001a\u00020\u000f*\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/RecommendMemoryListActivity;", "Lcom/obric/memorydata/recommend/ui/BaseMemoryActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/recommend/databinding/ActivityRecommendMemoryListBinding;", "shareViewModel", "Lcom/obric/memorydata/recommend/ui/list/MemoryListShareViewModel;", "getShareViewModel", "()Lcom/obric/memorydata/recommend/ui/list/MemoryListShareViewModel;", "shareViewModel$delegate", "Lkotlin/Lazy;", "needRefresh", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "finish", "onBackPressed", "initTitleBar", "titleBar", "Lcom/obric/oui/titlebar/OCTitleBar;", "onResume", "showClearDialog", "selectTab", "tab", "Lcom/obric/memorydata/recommend/ui/list/MemoryTab;", "setupViewPager", "setupTabLayout", "removeTabPadding", "Lcom/google/android/material/tabs/TabLayout;", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecommendMemoryListActivity extends BaseMemoryActivity {
    private static final String ARG_ENTITY = "entity";
    public static final a Companion = null;
    private static final String TAG = "MemoryListActivity";
    private ActivityRecommendMemoryListBinding binding;
    private boolean needRefresh;
    private final Lazy shareViewModel$delegate;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/recommend/ui/list/RecommendMemoryListActivity$Companion;", "", "<init>", "()V", "TAG", "", "ARG_ENTITY", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "entity", "Lcom/bytedance/rpc/model/kotlin/MemoryData;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/recommend/ui/list/RecommendMemoryListActivity$setupTabLayout$1$2", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabSelected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabUnselected", "onTabReselected", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements TabLayout.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TabLayout f12691a;

        b(TabLayout r1) {
            this.f12691a = r1;
        }

        @Override // com.google.android.material.tabs.TabLayout.a
        public void a(TabLayout.e r4) {
            if (r4 == null) goto L7;
            View r5 = r4.a();
            if (r5 == null) goto L8;
            TabLayout r3 = this.f12691a;
            ItemRecommendMemoryTabBinding.bind(r5).tvTab.setTextColor(ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_accent_fg, TypedValues.Custom.S_COLOR, "oui_accent_fg")));
            return;
        L8:
            return;
        }

        @Override // com.google.android.material.tabs.TabLayout.a
        public void b(TabLayout.e r4) {
            if (r4 == null) goto L7;
            View r5 = r4.a();
            if (r5 == null) goto L8;
            TabLayout r3 = this.f12691a;
            ItemRecommendMemoryTabBinding.bind(r5).tvTab.setTextColor(ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, TypedValues.Custom.S_COLOR, "oui_basic_text_3b")));
            return;
        L8:
            return;
        }

        @Override // com.google.android.material.tabs.TabLayout.a
        public void c(TabLayout.e r4) {
            if (r4 == null) goto L7;
            View r5 = r4.a();
            if (r5 == null) goto L8;
            TabLayout r3 = this.f12691a;
            ItemRecommendMemoryTabBinding.bind(r5).tvTab.setTextColor(ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_accent_fg, TypedValues.Custom.S_COLOR, "oui_accent_fg")));
            return;
        L8:
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.list.RecommendMemoryListActivity$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.ui.list.RecommendMemoryListActivity$onResume$1", f = "RecommendMemoryListActivity.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RecommendMemoryListActivity this$0;

        AnonymousClass1(RecommendMemoryListActivity r3, Continuation<? super AnonymousClass1> r4) {
            RecommendMemoryListActivity r5 = (RecommendMemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecommendMemoryListActivity.class, "com.obric.memorydata.plugin");
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
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            MemoryListShareViewModel r6 = RecommendMemoryListActivity.access$getShareViewModel(this.this$0);
            Continuation<? super Unit> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r6.refresh(r2) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public RecommendMemoryListActivity() {
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new RecommendMemoryListActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.shareViewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(MemoryListShareViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new RecommendMemoryListActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new RecommendMemoryListActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ MemoryListShareViewModel access$getShareViewModel(RecommendMemoryListActivity r2) {
        return ((RecommendMemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r2, RecommendMemoryListActivity.class, "com.obric.memorydata.plugin")).getShareViewModel();
    }

    private final MemoryListShareViewModel getShareViewModel() {
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(this.shareViewModel$delegate.getValue(), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private static final void initTitleBar$lambda$0(RecommendMemoryListActivity r1, View r2) {
        ((RecommendMemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r1, RecommendMemoryListActivity.class, "com.obric.memorydata.plugin")).showClearDialog();
    }

    public static /* synthetic */ void lambda$3dF1DQ_UVu8tLgam7UzoIZQThlE(RecommendMemoryListActivity r0, TabLayout r1, TabLayout.e r2, int r3) {
        setupTabLayout$lambda$8$lambda$7(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$5QT8g9bMCzbmL2VtOiR10Qa6W1k(RecommendMemoryListActivity r0, DialogInterface r1, int r2) {
        return showClearDialog$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$Q9xswFLCb09ju_vXv0QPLTijUno(RecommendMemoryListActivity r0, View r1) {
        initTitleBar$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$lH-u9wY7LaDCFkvJyMxqDc2xb5U, reason: not valid java name */
    public static /* synthetic */ Unit m1146lambda$lHu9wY7LaDCFkvJyMxqDc2xb5U(DialogInterface r0, int r1) {
        return showClearDialog$lambda$1(r0, r1);
    }

    private final void removeTabPadding(TabLayout r4) {
        View r5 = r4.getChildAt(0);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5, ViewGroup.class, "com.obric.memorydata.plugin");
        int r0 = r6.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r6.getChildAt(r1).setPadding(0, 0, 0, 0);
        r1 = r1 + 1;
        goto L3
    }

    private final void selectTab(MemoryTab r1) {
        ActivityRecommendMemoryListBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        TabLayout r2 = r0.tabMemory;
        r2.c(r2.a(r1.ordinal()));
    }

    private final void setupTabLayout() {
        ActivityRecommendMemoryListBinding r0 = this.binding;
        ActivityRecommendMemoryListBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        final TabLayout r2 = r0.tabMemory;
        ActivityRecommendMemoryListBinding r4 = this.binding;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        new TabLayoutMediator(r2, r1.viewPagerMemory, new $$Lambda$RecommendMemoryListActivity$3dF1DQ_UVu8tLgam7UzoIZQThlE(this, r2)).a();
        r2.a((TabLayout.b) ZeusTransformUtils.preCheckCast(new b(r2), TabLayout.b.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r2);
        removeTabPadding(r2);
        return;
    L8:
        r1 = r4;
        goto L9
    }

    private static final void setupTabLayout$lambda$8$lambda$7(RecommendMemoryListActivity r4, TabLayout r5, TabLayout.e r6, int r7) {
        RecommendMemoryListActivity r8 = (RecommendMemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r4, RecommendMemoryListActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "tab");
        ItemRecommendMemoryTabBinding r9 = ItemRecommendMemoryTabBinding.inflate(r8.getLayoutInflater());
        r9.tvTab.setText((CharSequence) ZeusTransformUtils.preCheckCast(MemoryTab.Companion.a(r7).getText(), CharSequence.class, "com.obric.memorydata.plugin"));
        r9.tvTab.setTextColor(ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3b, TypedValues.Custom.S_COLOR, "oui_basic_text_3b")));
        r6.a((View) ZeusTransformUtils.preCheckCast(r9.getRoot(), View.class, "com.obric.memorydata.plugin"));
    }

    private final void setupViewPager() {
        MemoryFragmentAdapter r0 = new MemoryFragmentAdapter(this);
        ActivityRecommendMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L5:
        ViewPager2 r4 = r3.viewPagerMemory;
        r4.setUserInputEnabled(false);
        r4.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r0, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        r4.setOffscreenPageLimit(1);
    }

    private final void showClearDialog() {
        ActivityRecommendMemoryListBinding r1 = this.binding;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r2, "getContext(...)");
        com.obric.oui.dialog.v2.alert.a r6 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(new com.obric.oui.dialog.v2.alert.b(r2).b(false).a(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_clear_title, TypedValues.Custom.S_STRING, "recommend_memory_general_clear_title")).b(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_clear_description, TypedValues.Custom.S_STRING, "recommend_memory_general_clear_description")).a(true).b((CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_clear_notice_cancel, TypedValues.Custom.S_STRING, "recommend_memory_general_clear_notice_cancel")), CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$RecommendMemoryListActivity$lHu9wY7LaDCFkvJyMxqDc2xb5U.INSTANCE).a((CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_clear_notice_confirm, TypedValues.Custom.S_STRING, "recommend_memory_general_clear_notice_confirm")), CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$RecommendMemoryListActivity$5QT8g9bMCzbmL2VtOiR10Qa6W1k(this)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r6.setCanceledOnTouchOutside(true);
        r6.setCancelable(true);
        r6.show();
    }

    private static final Unit showClearDialog$lambda$1(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        r3.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit showClearDialog$lambda$2(RecommendMemoryListActivity r7, DialogInterface r8, int r9) {
        RecommendMemoryListActivity r10 = (RecommendMemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r7, RecommendMemoryListActivity.class, "com.obric.memorydata.plugin");
        DialogInterface r11 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r8, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "dialog");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r10, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new RecommendMemoryListActivity$showClearDialog$2$1(r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        r11.dismiss();
        return Unit.INSTANCE;
    }

    public void finish() {
        super.finish();
        com.obric.common.oea.style.scene.transition.a.b((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"), TransitionAnimStyle.Standard);
    }

    @Override // com.obric.memorydata.recommend.ui.BaseMemoryActivity
    public void initTitleBar(OCTitleBar r4) {
        Intrinsics.checkNotNullParameter(r4, "titleBar");
        super.initTitleBar(r4);
        r4.a(ZeusTransformUtils.mapRes(R.drawable.ic_recommend_memory_clear, "drawable", "ic_recommend_memory_clear")).setOnClickListener(new $$Lambda$RecommendMemoryListActivity$Q9xswFLCb09ju_vXv0QPLTijUno(this));
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        super.onBackPressed();
        com.obric.common.oea.style.scene.transition.a.b((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"), TransitionAnimStyle.Standard);
    }

    @Override // com.obric.memorydata.recommend.ui.BaseMemoryActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        if (ak.f13164a.a() == false) goto L6;
        finish();
        return;
    L6:
        com.obric.common.oea.style.scene.transition.a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"), TransitionAnimStyle.Standard);
        ActivityRecommendMemoryListBinding r6 = ActivityRecommendMemoryListBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r6, "inflate(...)");
        this.binding = r6;
        ActivityRecommendMemoryListBinding r1 = null;
        if (r6 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L9:
        setContentView((View) ZeusTransformUtils.preCheckCast(r6.getRoot(), View.class, "com.obric.memorydata.plugin"));
        ActivityRecommendMemoryListBinding r7 = this.binding;
        if (r7 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L13:
        OCTitleBar r8 = r1.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r8, "viewTitle");
        initTitleBar(r8);
        setupViewPager();
        setupTabLayout();
        selectTab(MemoryTab.SHORT);
        return;
    L12:
        r1 = r7;
        goto L13
    }

    @Override // androidx.activity.ComponentActivity
    public void onNewIntent(Intent r1) {
        super.onNewIntent(r1);
        setIntent(r1);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        RunLog.INSTANCE.debug(TAG, "onResume needRefresh=" + this.needRefresh);
        if (this.needRefresh == false) goto L5;
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin")), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L5:
        this.needRefresh = true;
    }
}
