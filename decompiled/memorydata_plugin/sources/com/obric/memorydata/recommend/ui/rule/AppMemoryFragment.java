package com.obric.memorydata.recommend.ui.rule;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.context.task.PendingAppTypeCheckTask;
import com.obric.memorydata.recommend.databinding.FragmentAppMemoryListBinding;
import com.obric.memorydata.recommend.databinding.ItemScreenContentAppMemoryHeaderBinding;
import com.obric.memorydata.recommend.guide.ScreenObservationCategoryViewModel;
import com.obric.memorydata.recommend.settings.k;
import com.obric.memorydata.recommend.settings.r;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.BaseFragment;
import com.obric.memorydata.ui.custom.DeviceAdaptiveCardListItem;
import com.obric.memorydata.utils.bb;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.z;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import com.obric.oui.viewpager2.widget.ViewPager2;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.j;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n*\u0001\u001a\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010'\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u000fH\u0002J\u0010\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u000fH\u0002J\u0010\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020%H\u0002J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\u0015H\u0002J\b\u00103\u001a\u00020%H\u0003J\b\u00104\u001a\u00020%H\u0002J\b\u00105\u001a\u00020%H\u0016J\b\u00106\u001a\u00020%H\u0016J\b\u00107\u001a\u00020%H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001b¨\u00069"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/AppMemoryFragment;", "Lcom/obric/memorydata/ui/BaseFragment;", "<init>", "()V", "binding", "Lcom/obric/memorydata/recommend/databinding/FragmentAppMemoryListBinding;", "viewModel", "Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel;", "getViewModel", "()Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "categoryAdapter", "Lcom/obric/memorydata/recommend/guide/GuideAppFlattenAdapter;", "newMemorySetting", "Lcom/obric/oui/lisitem/OCardListItem;", "screenContentHeaderBinding", "Lcom/obric/memorydata/recommend/databinding/ItemScreenContentAppMemoryHeaderBinding;", "vp2ConflictHandler", "Lcom/obric/memorydata/recommend/ui/rule/ConflictWithViewPage2Handler;", "isScreenContentSettingsPage", "", "()Z", "screenContentSwitchListener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "appTypeCheckRefresh", "com/obric/memorydata/recommend/ui/rule/AppMemoryFragment$appTypeCheckRefresh$1", "Lcom/obric/memorydata/recommend/ui/rule/AppMemoryFragment$appTypeCheckRefresh$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupRecyclerView", "createAppListHeader", "createScreenContentHeader", "createNewMemorySettingItem", "setupNewMemorySetting", "item", "updateNewMemorySetting", "setting", "", "showDisableMemoryDialog", "updateMemorySwitchStatus", "enabled", "updateTemporaryDisabledStatus", "observeData", "onResume", "onDestroy", "onDestroyView", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppMemoryFragment extends BaseFragment {
    private static final String ARG_POSITION = "position";
    private static final String ARG_SCREEN_CONTENT_SETTINGS = "screen_content_settings";
    public static final a Companion = null;
    private static final String TAG = "AudioMemoryListFragment";
    private final b appTypeCheckRefresh;
    private FragmentAppMemoryListBinding binding;
    private com.obric.memorydata.recommend.guide.a categoryAdapter;
    private OCardListItem newMemorySetting;
    private ItemScreenContentAppMemoryHeaderBinding screenContentHeaderBinding;
    private final CompoundButton.OnCheckedChangeListener screenContentSwitchListener;
    private final Lazy viewModel$delegate;
    private e vp2ConflictHandler;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/recommend/ui/rule/AppMemoryFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_POSITION", "ARG_SCREEN_CONTENT_SETTINGS", "newScreenContentSettingsInstance", "Lcom/obric/memorydata/recommend/ui/rule/AppMemoryFragment;", "newInstance", AppMemoryFragment.ARG_POSITION, "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final AppMemoryFragment a() {
            AppMemoryFragment r3 = new AppMemoryFragment();
            Bundle r0 = new Bundle();
            r0.putBoolean(AppMemoryFragment.ARG_SCREEN_CONTENT_SETTINGS, true);
            r3.setArguments(r0);
            return r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/recommend/ui/rule/AppMemoryFragment$appTypeCheckRefresh$1", "Lcom/obric/memorydata/recommend/context/task/PendingAppTypeCheckTask$Companion$PendingAppTypeCheckObserver;", "onCheckTaskRefresh", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements PendingAppTypeCheckTask.a.InterfaceC0668a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppMemoryFragment f12715a;

        b(AppMemoryFragment r1) {
            this.f12715a = r1;
        }

        @Override // com.obric.memorydata.recommend.context.task.PendingAppTypeCheckTask.a.InterfaceC0668a
        public void a() {
            AppMemoryFragment.access$getViewModel(this.f12715a).refresh();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.ui.rule.AppMemoryFragment$observeData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.recommend.ui.rule.AppMemoryFragment$observeData$1", f = "AppMemoryFragment.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AppMemoryFragment this$0;

        AnonymousClass1(AppMemoryFragment r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
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
            ar<k> r7 = AppMemoryFragment.access$getViewModel(this.this$0).getState();
            final AppMemoryFragment r3 = this.this$0;
            j<? super k> r2 = (j) ZeusTransformUtils.preCheckCast(new C06831(r3), j.class, "com.obric.memorydata.plugin");
            Continuation<?> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public AppMemoryFragment() {
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$AppMemoryFragment$PsglRdJpZgehxjOkGaedqvmU1LA(this));
        this.screenContentSwitchListener = new $$Lambda$AppMemoryFragment$xYwaUgNJ3uu5rjzVvUpsC9nEogI(this);
        this.appTypeCheckRefresh = new b(this);
    }

    public static final /* synthetic */ com.obric.memorydata.recommend.guide.a access$getCategoryAdapter$p(AppMemoryFragment r0) {
        return r0.categoryAdapter;
    }

    public static final /* synthetic */ ScreenObservationCategoryViewModel access$getViewModel(AppMemoryFragment r0) {
        return r0.getViewModel();
    }

    public static final /* synthetic */ boolean access$isScreenContentSettingsPage(AppMemoryFragment r0) {
        return r0.isScreenContentSettingsPage();
    }

    public static final /* synthetic */ void access$updateMemorySwitchStatus(AppMemoryFragment r0, boolean r1) {
        r0.updateMemorySwitchStatus(r1);
    }

    public static final /* synthetic */ void access$updateNewMemorySetting(AppMemoryFragment r0, int r1) {
        r0.updateNewMemorySetting(r1);
    }

    public static final /* synthetic */ void access$updateTemporaryDisabledStatus(AppMemoryFragment r0) {
        r0.updateTemporaryDisabledStatus();
    }

    private final View createAppListHeader() {
        if (isScreenContentSettingsPage() == false) goto L6;
        return createScreenContentHeader();
    L6:
        return (View) ZeusTransformUtils.preCheckCast(createNewMemorySettingItem(), View.class, "com.obric.memorydata.plugin");
    }

    private final OCardListItem createNewMemorySettingItem() {
        FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "requireActivity(...)");
        OCardListItem r6 = new OCardListItem((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin"), null, 0, 6, null);
        r6.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(-1, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        r6.setCardType(0);
        OCardListItem.a(r6, 0, false, 2, null);
        r6.setDefaultCustomEndView(3);
        r6.setDefaultTailIcon(0);
        r6.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.screen_observation_new_app_default_setting_title, TypedValues.Custom.S_STRING, "screen_observation_new_app_default_setting_title")), CharSequence.class, "com.obric.memorydata.plugin"));
        r6.c(true);
        r6.d(false);
        r6.e(true);
        r6.f(true);
        setupNewMemorySetting(r6);
        return r6;
    }

    private final View createScreenContentHeader() {
        LayoutInflater r0 = getLayoutInflater();
        FragmentAppMemoryListBinding r1 = this.binding;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        ItemScreenContentAppMemoryHeaderBinding r2 = ItemScreenContentAppMemoryHeaderBinding.inflate(r0, (ViewGroup) ZeusTransformUtils.preCheckCast(r1.rvAppList, ViewGroup.class, "com.obric.memorydata.plugin"), false);
        Intrinsics.checkNotNullExpressionValue(r2, "inflate(...)");
        this.screenContentHeaderBinding = r2;
        DeviceAdaptiveCardListItem r3 = r2.newMemorySetting;
        Intrinsics.checkNotNullExpressionValue(r3, "newMemorySetting");
        setupNewMemorySetting((OCardListItem) ZeusTransformUtils.preCheckCast(r3, OCardListItem.class, "com.obric.memorydata.plugin"));
        OSwitch r4 = r2.screenObservationSwitch.getEndSwitch();
        if (r4 == null) goto L8;
        r4.setOnCheckedChangeListener(this.screenContentSwitchListener);
    L8:
        updateMemorySwitchStatus(((k) ZeusTransformUtils.preCheckCast(getViewModel().getState().c(), k.class, "com.obric.memorydata.plugin")).a());
        updateTemporaryDisabledStatus();
        LinearLayout r5 = r2.getRoot();
        Intrinsics.checkNotNullExpressionValue(r5, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin");
    }

    private final ScreenObservationCategoryViewModel getViewModel() {
        return (ScreenObservationCategoryViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), ScreenObservationCategoryViewModel.class, "com.obric.memorydata.plugin");
    }

    private final boolean isScreenContentSettingsPage() {
        Bundle r3 = getArguments();
        if (r3 == null) goto L8;
        if (r3.getBoolean(ARG_SCREEN_CONTENT_SETTINGS, false) != true) goto L8;
        return true;
    L8:
        return false;
    }

    /* JADX INFO: renamed from: lambda$71nlUySxLmzoZgu2d-5TKJsCFp0, reason: not valid java name */
    public static /* synthetic */ Unit m1154lambda$71nlUySxLmzoZgu2d5TKJsCFp0(AppMemoryFragment r0, Set r1, boolean r2) {
        return setupRecyclerView$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$C46NeXWUQlrHkgjUlH2JetZ8bAA(AppMemoryFragment r0, View r1) {
        setupNewMemorySetting$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$FRPPs7CoF1-PHmAaLqIi4NKFzTk, reason: not valid java name */
    public static /* synthetic */ Unit m1155lambda$FRPPs7CoF1PHmAaLqIi4NKFzTk(AppMemoryFragment r0, boolean r1) {
        return showDisableMemoryDialog$lambda$6(r0, r1);
    }

    public static /* synthetic */ Unit lambda$LNmDgQ8nbTqI7EuradgNKl1D3Nc(ViewGroup.MarginLayoutParams r0, int r1) {
        return setupRecyclerView$lambda$3(r0, r1);
    }

    public static /* synthetic */ ScreenObservationCategoryViewModel lambda$PsglRdJpZgehxjOkGaedqvmU1LA(AppMemoryFragment r0) {
        return viewModel_delegate$lambda$0(r0);
    }

    public static /* synthetic */ Unit lambda$wZuGX34vroqXCCFgp1UsFCfuCxY(AppMemoryFragment r0, Integer r1) {
        return observeData$lambda$8(r0, r1);
    }

    public static /* synthetic */ void lambda$xYwaUgNJ3uu5rjzVvUpsC9nEogI(AppMemoryFragment r0, CompoundButton r1, boolean r2) {
        screenContentSwitchListener$lambda$1(r0, r1, r2);
    }

    private final void observeData() {
        LifecycleOwner r0 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(r0, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope(r0), al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        getViewModel().getTitleBarHeight().observe(getViewLifecycleOwner(), (Observer) ZeusTransformUtils.preCheckCast(new AppMemoryFragment$sam$androidx_lifecycle_Observer$0(new $$Lambda$AppMemoryFragment$wZuGX34vroqXCCFgp1UsFCfuCxY(this)), Observer.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit observeData$lambda$8(AppMemoryFragment r7, Integer r8) {
        if (r8.intValue() <= 0) goto L5;
        FragmentAppMemoryListBinding r3 = null;
        if (r7.isScreenContentSettingsPage() == false) goto L15;
        FragmentAppMemoryListBinding r0 = r7.binding;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L11:
        RecyclerView r1 = r0.rvAppList;
        Intrinsics.checkNotNullExpressionValue(r1, "rvAppList");
        View r2 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
        int r9 = r8.intValue();
        FragmentAppMemoryListBinding r4 = r7.binding;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L14:
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.rvAppList.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "getContext(...)");
        bb.b(r2, r9 + com.obric.oui.common.util.h.a(r5, 16));
    L19:
        FragmentAppMemoryListBinding r10 = r7.binding;
        if (r10 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L23:
        r3.rvAppList.scrollToPosition(0);
        return Unit.INSTANCE;
    L22:
        r3 = r10;
        goto L23
    L15:
        FragmentAppMemoryListBinding r11 = r7.binding;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L18:
        RecyclerView r12 = r11.rvAppList;
        Intrinsics.checkNotNullExpressionValue(r12, "rvAppList");
        bb.b((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"), BaseActivity.Companion.a() + MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())));
        goto L19
    L5:
        return Unit.INSTANCE;
    }

    private static final void screenContentSwitchListener$lambda$1(AppMemoryFragment r1, CompoundButton r2, boolean r3) {
        if (r3 == false) goto L4;
        r1.getViewModel().processIntent((r) ZeusTransformUtils.preCheckCast(new r.f(true), r.class, "com.obric.memorydata.plugin"));
        return;
    L4:
        r1.showDisableMemoryDialog();
    }

    private final void setupNewMemorySetting(OCardListItem r2) {
        this.newMemorySetting = r2;
        r2.setOnContentClickListener(new $$Lambda$AppMemoryFragment$C46NeXWUQlrHkgjUlH2JetZ8bAA(this));
    }

    private static final void setupNewMemorySetting$lambda$5(AppMemoryFragment r2, View r3) {
        RuleMemorySettingActivity.a r4 = RuleMemorySettingActivity.Companion;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "requireContext(...)");
        r4.a(r5);
    }

    private final void setupRecyclerView() {
        FragmentAppMemoryListBinding r0 = this.binding;
        FragmentAppMemoryListBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView r1 = r0.rvAppList;
        Intrinsics.checkNotNullExpressionValue(r1, "rvAppList");
        com.obric.memorydata.ui.g.a((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        FragmentAppMemoryListBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        r3.rvAppList.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireContext(...)");
        com.obric.memorydata.recommend.guide.a r5 = new com.obric.memorydata.recommend.guide.a(r4, new $$Lambda$AppMemoryFragment$71nlUySxLmzoZgu2d5TKJsCFp0(this));
        r5.a($$Lambda$AppMemoryFragment$LNmDgQ8nbTqI7EuradgNKl1D3Nc.INSTANCE);
        com.obric.memorydata.recommend.guide.e r6 = new com.obric.memorydata.recommend.guide.e((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r5, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        r6.a(createAppListHeader());
        FragmentAppMemoryListBinding r7 = this.binding;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L11:
        r7.rvAppList.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r6, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        FragmentAppMemoryListBinding r8 = this.binding;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L14:
        RecyclerView.e r9 = r8.rvAppList.getItemAnimator();
        if (ZeusTransformUtils.instanceOf(r9, z.class) == false) goto L17;
        z r10 = (z) ZeusTransformUtils.preCheckCast(r9, z.class, "com.obric.memorydata.plugin");
    L18:
        if (r10 == null) goto L20;
        r10.a(false);
    L20:
        this.categoryAdapter = r5;
        ViewPager2 r11 = (ViewPager2) ZeusTransformUtils.preCheckCast(((FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.viewPager, OaidModel.KEY_ID, "viewPager")), ViewPager2.class, "com.obric.memorydata.plugin");
        FragmentAppMemoryListBinding r12 = this.binding;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L24:
        RecyclerView r13 = r2.rvAppList;
        Intrinsics.checkNotNullExpressionValue(r13, "rvAppList");
        this.vp2ConflictHandler = new e(r13, r11);
        return;
    L23:
        r2 = r12;
        goto L24
    L17:
        r10 = null;
        goto L18
    }

    private static final Unit setupRecyclerView$lambda$2(AppMemoryFragment r2, Set r3, boolean r4) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "packageNames");
        r2.getViewModel().processIntent((r) ZeusTransformUtils.preCheckCast(new r.a(r5, r4), r.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final Unit setupRecyclerView$lambda$3(ViewGroup.MarginLayoutParams r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "layoutParams");
        float r7 = 12;
        r5.setMargins(MathKt.roundToInt(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r7, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics())));
        return Unit.INSTANCE;
    }

    private final void showDisableMemoryDialog() {
        com.obric.memorydata.recommend.ui.b r0 = com.obric.memorydata.recommend.ui.b.f12643a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "requireContext(...)");
        r0.a(r1, new $$Lambda$AppMemoryFragment$FRPPs7CoF1PHmAaLqIi4NKFzTk(this));
    }

    private static final Unit showDisableMemoryDialog$lambda$6(AppMemoryFragment r2, boolean r3) {
        if (r3 == true) goto L5;
        r2.updateMemorySwitchStatus(((k) ZeusTransformUtils.preCheckCast(r2.getViewModel().getState().c(), k.class, "com.obric.memorydata.plugin")).a());
    L5:
        return Unit.INSTANCE;
    }

    private final void updateMemorySwitchStatus(boolean r3) {
        ItemScreenContentAppMemoryHeaderBinding r0 = this.screenContentHeaderBinding;
        if (r0 == null) goto L10;
        DeviceAdaptiveCardListItem r1 = r0.screenObservationSwitch;
        if (r1 == null) goto L11;
        OSwitch r2 = r1.getEndSwitch();
        if (r2 == null) goto L12;
        r2.setOnCheckedChangeListener(null);
        r2.setChecked(r3);
        r2.setOnCheckedChangeListener(this.screenContentSwitchListener);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void updateNewMemorySetting(int r3) {
        if (r3 != 0) goto L5;
        int r4 = R.string.screen_observation_new_app_open_all;
        String r1 = "screen_observation_new_app_open_all";
    L12:
        int r5 = ZeusTransformUtils.mapRes(r4, TypedValues.Custom.S_STRING, r1);
        OCardListItem r0 = this.newMemorySetting;
        if (r0 == null) goto L18;
        OTextView r2 = r0.getEndDetail();
        if (r2 == null) goto L19;
        r2.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(r5), CharSequence.class, "com.obric.memorydata.plugin"));
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r3 != 1) goto L7;
        r4 = R.string.screen_observation_new_app_open_custom;
        r1 = "screen_observation_new_app_open_custom";
        goto L12
    L7:
        if (r3 == 2) goto L9;
        return;
    L9:
        r4 = R.string.screen_observation_new_app_open_none;
        r1 = "screen_observation_new_app_open_none";
        goto L12
    }

    private final void updateTemporaryDisabledStatus() {
        ItemScreenContentAppMemoryHeaderBinding r0 = this.screenContentHeaderBinding;
        if (r0 != null) goto L6;
        return;
    L6:
        if (com.obric.memorydata.recommend.feature.a.f12505a.e() == false) goto L14;
        String r1 = com.obric.memorydata.recommend.feature.a.f12505a.f();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
        r0.screenObservationTemporarilyDisabledTips.setText((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.screen_observation_temporary_disabled, TypedValues.Custom.S_STRING, "screen_observation_temporary_disabled"), new Object[]{r1}), CharSequence.class, "com.obric.memorydata.plugin"));
        r0.screenObservationTemporarilyDisabledTips.setVisibility(0);
        return;
    L10:
        r2 = false;
    L14:
        r0.screenObservationTemporarilyDisabledTips.setVisibility(8);
    }

    private static final ScreenObservationCategoryViewModel viewModel_delegate$lambda$0(AppMemoryFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (ScreenObservationCategoryViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(ScreenObservationCategoryViewModel.class), ScreenObservationCategoryViewModel.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FragmentAppMemoryListBinding r4 = FragmentAppMemoryListBinding.inflate(r1, r2, false);
        Intrinsics.checkNotNullExpressionValue(r4, "inflate(...)");
        this.binding = r4;
        if (r4 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L5:
        LinearLayout r0 = r4.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MemoryService.INSTANCE.clearAppIconCache();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ItemScreenContentAppMemoryHeaderBinding r0 = this.screenContentHeaderBinding;
        if (r0 == null) goto L9;
        DeviceAdaptiveCardListItem r1 = r0.screenObservationSwitch;
        if (r1 == null) goto L9;
        OSwitch r2 = r1.getEndSwitch();
        if (r2 == null) goto L9;
        r2.setOnCheckedChangeListener(null);
    L9:
        this.screenContentHeaderBinding = null;
        this.newMemorySetting = null;
        this.categoryAdapter = null;
        e r3 = this.vp2ConflictHandler;
        if (r3 == null) goto L12;
        r3.c();
    L12:
        this.vp2ConflictHandler = null;
        PendingAppTypeCheckTask.Companion.b((PendingAppTypeCheckTask.a.InterfaceC0668a) ZeusTransformUtils.preCheckCast(this.appTypeCheckRefresh, PendingAppTypeCheckTask.a.InterfaceC0668a.class, "com.obric.memorydata.plugin"));
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isScreenContentSettingsPage() == false) goto L6;
        updateTemporaryDisabledStatus();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        setupRecyclerView();
        observeData();
        PendingAppTypeCheckTask.Companion.a((PendingAppTypeCheckTask.a.InterfaceC0668a) ZeusTransformUtils.preCheckCast(this.appTypeCheckRefresh, PendingAppTypeCheckTask.a.InterfaceC0668a.class, "com.obric.memorydata.plugin"));
    }
}
