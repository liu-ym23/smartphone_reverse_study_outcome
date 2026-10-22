package com.obric.memorydata.recommend.ui.rule;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ActivityRuleMemoryBinding;
import com.obric.memorydata.recommend.guide.ScreenObservationCategoryViewModel;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.BaseAuthActivity;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0014J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0016H\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/RuleMemoryActivity;", "Lcom/obric/memorydata/ui/BaseAuthActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/recommend/databinding/ActivityRuleMemoryBinding;", "tabLayout", "Lcom/obric/oui/tab/OTabLayout;", "addButton", "Landroid/view/View;", "blockViewModel", "Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryContentViewModel;", "getBlockViewModel", "()Lcom/obric/memorydata/recommend/ui/rule/BlockMemoryContentViewModel;", "blockViewModel$delegate", "Lkotlin/Lazy;", "categoryViewModel", "Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel;", "getCategoryViewModel", "()Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel;", "categoryViewModel$delegate", "needLoginCheckOnCreate", "", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onResumeChecked", "initView", "toggleAddButtonVisibility", "isVisible", "initTitleBar", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "expandTouchArea", TypedValues.AttributesType.S_TARGET, "targetSizeDp", "", "observeViewModel", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RuleMemoryActivity extends BaseAuthActivity {
    public static final a Companion = null;
    public static final String TAG = "RuleMemoryActivity";
    private View addButton;
    private ActivityRuleMemoryBinding binding;
    private final Lazy blockViewModel$delegate;
    private final Lazy categoryViewModel$delegate;
    private OTabLayout tabLayout;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/RuleMemoryActivity$Companion;", "", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "TAG", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/recommend/ui/rule/RuleMemoryActivity$initView$1", "Lcom/obric/oui/tab/OTabLayoutBase$OnTabSelectedListener;", "onTabSelected", "", "tab", "Lcom/obric/oui/tab/OTabLayoutBase$Tab;", "onTabUnselected", "onTabReselected", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements OTabLayoutBase.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RuleMemoryActivity f12732a;

        b(RuleMemoryActivity r3) {
            this.f12732a = (RuleMemoryActivity) ZeusTransformUtils.wrapperContextForParams(r3, RuleMemoryActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void a(OTabLayoutBase.g r6) {
            boolean r0 = false;
            if (r6 == null) goto L5;
            int r7 = r6.c();
        L6:
            ActivityRuleMemoryBinding r1 = RuleMemoryActivity.access$getBinding$p(this.f12732a);
            ActivityRuleMemoryBinding r2 = null;
            if (r1 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r1 = null;
        L10:
            if (r1.viewPager.getCurrentItem() == r7) goto L20;
            RuleMemoryActivity r3 = this.f12732a;
            if (r7 != 1) goto L14;
            r0 = true;
        L14:
            RuleMemoryActivity.access$toggleAddButtonVisibility(r3, r0);
            ActivityRuleMemoryBinding r5 = RuleMemoryActivity.access$getBinding$p(this.f12732a);
            if (r5 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L18:
            r2.viewPager.setCurrentItem(r7);
            return;
        L17:
            r2 = r5;
            goto L18
        L20:
            return;
        L5:
            r7 = 0;
            goto L6
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void b(OTabLayoutBase.g r1) {
        }

        @Override // com.obric.oui.tab.OTabLayoutBase.c
        public void c(OTabLayoutBase.g r1) {
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/recommend/ui/rule/RuleMemoryActivity$initView$2", "Lcom/obric/oui/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "onPageSelected", "position", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends ViewPager2.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RuleMemoryActivity f12733a;

        c(RuleMemoryActivity r3) {
            this.f12733a = (RuleMemoryActivity) ZeusTransformUtils.wrapperContextForParams(r3, RuleMemoryActivity.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
        public void a(int r1) {
        }

        @Override // com.obric.oui.viewpager2.widget.ViewPager2.e
        public void b(int r5) {
            super.b(r5);
            OTabLayout r0 = RuleMemoryActivity.access$getTabLayout$p(this.f12733a);
            OTabLayout r1 = null;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            r0 = null;
        L6:
            if (r0.getSelectedTabPosition() == r5) goto L17;
            RuleMemoryActivity r2 = this.f12733a;
            boolean r3 = true;
            if (r5 == 1) goto L11;
            r3 = false;
        L11:
            RuleMemoryActivity.access$toggleAddButtonVisibility(r2, r3);
            OTabLayout r4 = RuleMemoryActivity.access$getTabLayout$p(this.f12733a);
            if (r4 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        L15:
            r1.e(r5);
            return;
        L14:
            r1 = r4;
            goto L15
        }
    }

    static {
        Companion = new a(null);
    }

    public RuleMemoryActivity() {
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new RuleMemoryActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.blockViewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(BlockMemoryContentViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new RuleMemoryActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new RuleMemoryActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
        final ComponentActivity r1 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r3 = (Function0) ZeusTransformUtils.preCheckCast(new RuleMemoryActivity$special$$inlined$viewModels$default$4(r1), Function0.class, "com.obric.memorydata.plugin");
        this.categoryViewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(ScreenObservationCategoryViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new RuleMemoryActivity$special$$inlined$viewModels$default$5(r1), Function0.class, "com.obric.memorydata.plugin"), r3, (Function0) ZeusTransformUtils.preCheckCast(new RuleMemoryActivity$special$$inlined$viewModels$default$6(r7, r1), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ ActivityRuleMemoryBinding access$getBinding$p(RuleMemoryActivity r2) {
        return ((RuleMemoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, RuleMemoryActivity.class, "com.obric.memorydata.plugin")).binding;
    }

    public static final /* synthetic */ OTabLayout access$getTabLayout$p(RuleMemoryActivity r2) {
        return ((RuleMemoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, RuleMemoryActivity.class, "com.obric.memorydata.plugin")).tabLayout;
    }

    public static final /* synthetic */ void access$toggleAddButtonVisibility(RuleMemoryActivity r2, boolean r3) {
        ((RuleMemoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, RuleMemoryActivity.class, "com.obric.memorydata.plugin")).toggleAddButtonVisibility(r3);
    }

    private final void expandTouchArea(final View r3, final int r4) {
        ViewParent r2 = r3.getParent();
        if (ZeusTransformUtils.instanceOf(r2, View.class) == false) goto L5;
        final View r5 = (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        r3.post(new $$Lambda$RuleMemoryActivity$rX6WVJmb6m1TpE6kLXLkyTnlOho(r3, r4, r5));
        return;
    L5:
        r5 = null;
        goto L6
    }

    private static final void expandTouchArea$lambda$8(View r4, int r5, View r6) {
        Rect r0 = new Rect();
        r4.getHitRect(r0);
        int r7 = MathKt.roundToInt(TypedValue.applyDimension(1, r5, Resources.getSystem().getDisplayMetrics()));
        int r1 = RangesKt.coerceAtLeast(r7 - r4.getWidth(), 0) / 2;
        int r8 = RangesKt.coerceAtLeast(r7 - r4.getHeight(), 0) / 2;
        r0.left -= r1;
        r0.right += r1;
        r0.top -= r8;
        r0.bottom += r8;
        r6.setTouchDelegate(new TouchDelegate(r0, r4));
    }

    private final BlockMemoryContentViewModel getBlockViewModel() {
        return (BlockMemoryContentViewModel) ZeusTransformUtils.preCheckCast(this.blockViewModel$delegate.getValue(), BlockMemoryContentViewModel.class, "com.obric.memorydata.plugin");
    }

    private final ScreenObservationCategoryViewModel getCategoryViewModel() {
        return (ScreenObservationCategoryViewModel) ZeusTransformUtils.preCheckCast(this.categoryViewModel$delegate.getValue(), ScreenObservationCategoryViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void initTitleBar(final OFloatingTitleBar r11) {
        registerFloatingTitleBar(r11);
        BaseActivity.setupTitleBarBackAction$default((BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin"), r11, null, 0, null, 14, null);
        r11.post(new $$Lambda$RuleMemoryActivity$BZxq6fPY4OkpZT_zfQkHUuqyG4(this, r11));
        this.addButton = OFloatingTitleBar.b(r11, ZeusTransformUtils.mapRes(R.drawable.button_add_rule_icon, "drawable", "button_add_rule_icon"), 0, null, 6, null);
        int r0 = 0;
        toggleAddButtonVisibility(false);
        OTabLayout r4 = null;
        View r2 = ZeusTransformUtils.inflate(getLayoutInflater(), ZeusTransformUtils.mapRes(R.layout.item_rule_memory_tab, "layout", "item_rule_memory_tab"), null, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.oui.tab.OTabLayout");
        OTabLayout r3 = (OTabLayout) ZeusTransformUtils.preCheckCast(r2, OTabLayout.class, "com.obric.memorydata.plugin");
        this.tabLayout = r3;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r3 = null;
    L5:
        r3.setLayoutParams(new ViewGroup.LayoutParams(-2, MathKt.roundToInt(TypedValue.applyDimension(1, 40, Resources.getSystem().getDisplayMetrics()))));
        OTabLayout r5 = this.tabLayout;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L9:
        r11.setCenterCustomView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.memorydata.plugin"));
        final Function1 r12 = new $$Lambda$RuleMemoryActivity$oP4PTeQxDZNFhYrZFZkpSxjSzA(this);
        List r6 = (List) ZeusTransformUtils.preCheckCast(getBlockViewModel().getShieldContentItems().getValue(), List.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L24;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L14;
    L16:
        Iterator r8 = r7.iterator();
    L18:
        if (r8.hasNext() == false) goto L24;
        if (ZeusTransformUtils.instanceOf((com.obric.memorydata.recommend.ui.rule.a) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.memorydata.recommend.ui.rule.a.class, "com.obric.memorydata.plugin"), com.obric.memorydata.recommend.ui.rule.a.C0686a.class) == false) goto L18;
        r0 = r0 + 1;
        if (r0 >= 0) goto L18;
        CollectionsKt.throwCountOverflow();
        goto L18
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
    L24:
        r12.invoke(Integer.valueOf(r0));
        getBlockViewModel().getShieldContentItems().observe((LifecycleOwner) ZeusTransformUtils.preCheckCast(this, LifecycleOwner.class, "com.obric.memorydata.plugin"), (Observer) ZeusTransformUtils.preCheckCast(new RuleMemoryActivity$sam$androidx_lifecycle_Observer$0(new $$Lambda$RuleMemoryActivity$BlbfaHi6NwFYK7rVqfODpsvcvsE(r12)), Observer.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        r4 = r5;
        goto L9
    }

    private static final void initTitleBar$lambda$0(RuleMemoryActivity r2, OFloatingTitleBar r3) {
        RuleMemoryActivity r4 = (RuleMemoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, RuleMemoryActivity.class, "com.obric.memorydata.plugin");
        r4.getCategoryViewModel().getTitleBarHeight().setValue(Integer.valueOf(r3.getHeight()));
        r4.getBlockViewModel().getTitleBarHeight().setValue(Integer.valueOf(r3.getHeight()));
    }

    private static final Unit initTitleBar$lambda$4(RuleMemoryActivity r3, int r4) {
        final RuleMemoryActivity r5 = (RuleMemoryActivity) ZeusTransformUtils.wrapperContextForParams(r3, RuleMemoryActivity.class, "com.obric.memorydata.plugin");
        if (r4 >= 100) goto L5;
        boolean r6 = true;
    L6:
        View r0 = r5.addButton;
        View r2 = null;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("addButton");
        r0 = null;
    L9:
        r0.setEnabled(r6);
        if (r6 == false) goto L19;
        View r7 = r5.addButton;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("addButton");
        r7 = null;
    L14:
        r7.setAlpha(1.0f);
        View r8 = r5.addButton;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("addButton");
    L18:
        r2.setOnClickListener(new $$Lambda$RuleMemoryActivity$rr_OjMVe7qKI_EzJuaLu1z8qr8(r5));
    L27:
        return Unit.INSTANCE;
    L17:
        r2 = r8;
        goto L18
    L19:
        View r9 = r5.addButton;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("addButton");
        r9 = null;
    L22:
        r9.setAlpha(0.3f);
        View r10 = r5.addButton;
        if (r10 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("addButton");
        r10 = null;
    L25:
        r10.setOnClickListener(null);
        goto L27
    L5:
        r6 = false;
        goto L6
    }

    private static final void initTitleBar$lambda$4$lambda$3(RuleMemoryActivity r10, View r11) {
        final RuleMemoryActivity r12 = (RuleMemoryActivity) ZeusTransformUtils.wrapperContextForParams(r10, RuleMemoryActivity.class, "com.obric.memorydata.plugin");
        new d((FragmentActivity) ZeusTransformUtils.preCheckCast(r12, FragmentActivity.class, "com.obric.memorydata.plugin"), false, null, null, new $$Lambda$RuleMemoryActivity$RPM8I4br4YQ15Vs3qc2FRHl7TuY(r12), false, 46, null).a();
    }

    private static final Unit initTitleBar$lambda$4$lambda$3$lambda$2(RuleMemoryActivity r2, String r3) {
        RuleMemoryActivity r4 = (RuleMemoryActivity) ZeusTransformUtils.wrapperContextForParams(r2, RuleMemoryActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "validatedContent");
        r4.getBlockViewModel().addCustomBlockContent(r3);
        return Unit.INSTANCE;
    }

    private static final Unit initTitleBar$lambda$7(Function1 r4, List r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r7);
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L5;
    L7:
        Iterator r9 = r8.iterator();
    L9:
        if (r9.hasNext() == false) goto L15;
        if (ZeusTransformUtils.instanceOf((com.obric.memorydata.recommend.ui.rule.a) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.memorydata.recommend.ui.rule.a.class, "com.obric.memorydata.plugin"), com.obric.memorydata.recommend.ui.rule.a.C0686a.class) == false) goto L9;
        r2 = r2 + 1;
        if (r2 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L15:
        r6.invoke(Integer.valueOf(r2));
        return Unit.INSTANCE;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final void initView() {
        ActivityRuleMemoryBinding r0 = this.binding;
        ActivityRuleMemoryBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r1 = r0.title;
        Intrinsics.checkNotNullExpressionValue(r1, "title");
        initTitleBar(r1);
        ActivityRuleMemoryBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        r3.viewPager.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(new f(this), RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        OTabLayout r4 = this.tabLayout;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        r4 = null;
    L11:
        r4.a((OTabLayoutBase.c) ZeusTransformUtils.preCheckCast(new b(this), OTabLayoutBase.c.class, "com.obric.memorydata.plugin"));
        ActivityRuleMemoryBinding r5 = this.binding;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L14:
        r5.viewPager.a((ViewPager2.e) ZeusTransformUtils.preCheckCast(new c(this), ViewPager2.e.class, "com.obric.memorydata.plugin"));
        ActivityRuleMemoryBinding r6 = this.binding;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L17:
        r6.viewPager.setCurrentItem(0);
        ActivityRuleMemoryBinding r7 = this.binding;
        if (r7 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        r2.viewPager.setUserInputEnabled(true);
        return;
    L20:
        r2 = r7;
        goto L21
    }

    /* JADX INFO: renamed from: lambda$BZxq6fPY4Ok-pZT_zfQkHUuqyG4, reason: not valid java name */
    public static /* synthetic */ void m1156lambda$BZxq6fPY4OkpZT_zfQkHUuqyG4(RuleMemoryActivity r0, OFloatingTitleBar r1) {
        initTitleBar$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit lambda$BlbfaHi6NwFYK7rVqfODpsvcvsE(Function1 r0, List r1) {
        return initTitleBar$lambda$7(r0, r1);
    }

    public static /* synthetic */ Unit lambda$RPM8I4br4YQ15Vs3qc2FRHl7TuY(RuleMemoryActivity r0, String r1) {
        return initTitleBar$lambda$4$lambda$3$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$oP4PTeQxD-ZNFhYrZFZkpSxjSzA, reason: not valid java name */
    public static /* synthetic */ Unit m1157lambda$oP4PTeQxDZNFhYrZFZkpSxjSzA(RuleMemoryActivity r0, int r1) {
        return initTitleBar$lambda$4(r0, r1);
    }

    public static /* synthetic */ void lambda$rX6WVJmb6m1TpE6kLXLkyTnlOho(View r0, int r1, View r2) {
        expandTouchArea$lambda$8(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$rr_OjM-Ve7qKI_EzJuaLu1z8qr8, reason: not valid java name */
    public static /* synthetic */ void m1158lambda$rr_OjMVe7qKI_EzJuaLu1z8qr8(RuleMemoryActivity r0, View r1) {
        initTitleBar$lambda$4$lambda$3(r0, r1);
    }

    private final void observeViewModel() {
    }

    private final void toggleAddButtonVisibility(boolean r10) {
        ActivityRuleMemoryBinding r0 = this.binding;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OFloatingTitleBar.c(r0.title, false, 1, null);
        if (r10 == false) goto L16;
        ActivityRuleMemoryBinding r11 = this.binding;
        if (r11 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L10:
        OFloatingTitleBar r3 = r11.title;
        View r9 = this.addButton;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("addButton");
        View r4 = null;
    L14:
        OFloatingTitleBar.a(r3, r4, 0, false, 6, null);
        return;
    L13:
        r4 = r9;
        goto L14
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
    public void onCreateChecked(Bundle r3) {
        prepareSystemBar();
        ActivityRuleMemoryBinding r4 = ActivityRuleMemoryBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        this.binding = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r4.getRoot(), View.class, "com.obric.memorydata.plugin"));
        initView();
        observeViewModel();
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onResume", false, 4, null);
        getCategoryViewModel().refresh();
    }
}
