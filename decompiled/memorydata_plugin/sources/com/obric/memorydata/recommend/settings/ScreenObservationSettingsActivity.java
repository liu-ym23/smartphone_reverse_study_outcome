package com.obric.memorydata.recommend.settings;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelLazy;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ActivityRecommendSettingsBinding;
import com.obric.memorydata.recommend.guide.ScreenObservationCategoryViewModel;
import com.obric.memorydata.recommend.guide.ScreenObservationGuideFeatureActivity;
import com.obric.memorydata.recommend.ui.BaseFloatingMemoryActivity;
import com.obric.memorydata.recommend.ui.rule.AppMemoryFragment;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.utils.ba;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsActivity;", "Lcom/obric/memorydata/recommend/ui/BaseFloatingMemoryActivity;", "<init>", "()V", "binding", "Lcom/obric/memorydata/recommend/databinding/ActivityRecommendSettingsBinding;", "viewModel", "Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel;", "getViewModel", "()Lcom/obric/memorydata/recommend/guide/ScreenObservationCategoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "needLoginCheckOnCreate", "", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onResumeChecked", "finish", "onBackPressed", "initViews", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenObservationSettingsActivity extends BaseFloatingMemoryActivity {
    private static final String APP_MEMORY_FRAGMENT_TAG = "screen_content_app_memory";
    public static final a Companion = null;
    private static final String SCREEN_OBSERVATION_TILE_CLASS = "com.obric.memorydata.recommend.tile.ScreenObservationTileService";
    private ActivityRecommendSettingsBinding binding;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/recommend/settings/ScreenObservationSettingsActivity$Companion;", "", "<init>", "()V", "APP_MEMORY_FRAGMENT_TAG", "", "SCREEN_OBSERVATION_TILE_CLASS", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "cleanTop", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void a(a r1, Context r2, boolean r3, int r4, Object r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            if ((r4 & 2) == 0) goto L5;
            r3 = false;
        L5:
            r1.a(r6, r3);
        }

        public final void a(Context r4, boolean r5) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intent r6 = new Intent(r3, ScreenObservationSettingsActivity.class);
            if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r3), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")) != null) goto L5;
            r6.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L5:
            if (r5 == false) goto L7;
            r6.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        L7:
            ZeusTransformUtils.startActivity(r3, r6, "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.settings.ScreenObservationSettingsActivity$initViews$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass2(Object r8) {
            super(0, r8, ScreenObservationSettingsActivity.class, "onBackPressed", "onBackPressed()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((ScreenObservationSettingsActivity) ZeusTransformUtils.preCheckCast(this.receiver, ScreenObservationSettingsActivity.class, "com.obric.memorydata.plugin")).onBackPressed();
        }
    }

    static {
        Companion = new a(null);
    }

    public ScreenObservationSettingsActivity() {
        final ComponentActivity r0 = (ComponentActivity) ZeusTransformUtils.preCheckCast(this, ComponentActivity.class, "com.obric.memorydata.plugin");
        Function0 r2 = (Function0) ZeusTransformUtils.preCheckCast(new ScreenObservationSettingsActivity$special$$inlined$viewModels$default$1(r0), Function0.class, "com.obric.memorydata.plugin");
        final Function0 r7 = null;
        this.viewModel$delegate = (Lazy) ZeusTransformUtils.preCheckCast(new ViewModelLazy(Reflection.getOrCreateKotlinClass(ScreenObservationCategoryViewModel.class), (Function0) ZeusTransformUtils.preCheckCast(new ScreenObservationSettingsActivity$special$$inlined$viewModels$default$2(r0), Function0.class, "com.obric.memorydata.plugin"), r2, (Function0) ZeusTransformUtils.preCheckCast(new ScreenObservationSettingsActivity$special$$inlined$viewModels$default$3(r7, r0), Function0.class, "com.obric.memorydata.plugin")), Lazy.class, "com.obric.memorydata.plugin");
    }

    private final ScreenObservationCategoryViewModel getViewModel() {
        return (ScreenObservationCategoryViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), ScreenObservationCategoryViewModel.class, "com.obric.memorydata.plugin");
    }

    private final void initViews(Bundle r13) {
        ActivityRecommendSettingsBinding r0 = this.binding;
        ActivityRecommendSettingsBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        OFloatingTitleBar r2 = r0.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r2, "viewTitle");
        registerFloatingTitleBar(r2);
        BaseActivity r5 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin");
        ActivityRecommendSettingsBinding r3 = this.binding;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L8:
        OFloatingTitleBar r6 = r3.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r6, "viewTitle");
        ActivityRecommendSettingsBinding r4 = this.binding;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L11:
        BaseActivity.setupTitleBarBackAction$default(r5, r6, null, 0, r4.cutOff, 6, null);
        ActivityRecommendSettingsBinding r7 = this.binding;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L14:
        getTitleBarTotalHeightAsync((View) ZeusTransformUtils.preCheckCast(r7.viewTitle, View.class, "com.obric.memorydata.plugin"), new $$Lambda$ScreenObservationSettingsActivity$0JyeBR4zkkIG26jVPss_SZbasc(this));
        ActivityRecommendSettingsBinding r8 = this.binding;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L18:
        OFloatingTitleBar r9 = r1.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r9, "viewTitle");
        com.obric.memorydata.ui.custom.a.a(r9, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), Function0.class, "com.obric.memorydata.plugin"));
        if (r13 == null) goto L21;
        return;
    L21:
        if (getSupportFragmentManager().findFragmentByTag(APP_MEMORY_FRAGMENT_TAG) != null) goto L25;
        FragmentTransaction r12 = getSupportFragmentManager().beginTransaction();
        r12.replace(ZeusTransformUtils.mapRes(R.id.app_memory_container, OaidModel.KEY_ID, "app_memory_container"), (Fragment) ZeusTransformUtils.preCheckCast(AppMemoryFragment.Companion.a(), Fragment.class, "com.obric.memorydata.plugin"), APP_MEMORY_FRAGMENT_TAG);
        r12.commit();
        return;
    L25:
        return;
    L17:
        r1 = r8;
        goto L18
    }

    private static final Unit initViews$lambda$5(ScreenObservationSettingsActivity r2, int r3) {
        ((ScreenObservationSettingsActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationSettingsActivity.class, "com.obric.memorydata.plugin")).getViewModel().getTitleBarHeight().setValue(Integer.valueOf(r3));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$0JyeBR4zkkIG26jVPss_SZbas-c, reason: not valid java name */
    public static /* synthetic */ Unit m1131lambda$0JyeBR4zkkIG26jVPss_SZbasc(ScreenObservationSettingsActivity r0, int r1) {
        return initViews$lambda$5(r0, r1);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(ZeusTransformUtils.mapRes(R.anim.host_oui_activity_close_enter, "anim", "host_oui_activity_close_enter"), ZeusTransformUtils.mapRes(R.anim.host_oui_activity_close_exit, "anim", "host_oui_activity_close_exit"));
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
        overridePendingTransition(ZeusTransformUtils.mapRes(R.anim.host_oui_activity_close_enter, "anim", "host_oui_activity_close_enter"), ZeusTransformUtils.mapRes(R.anim.host_oui_activity_close_exit, "anim", "host_oui_activity_close_exit"));
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onCreateChecked(Bundle r11) {
        com.obric.memorydata.middleware.api.logging.o r0 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.s.f11634a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r1 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        com.obric.memorydata.middleware.api.logging.g r3 = new com.obric.memorydata.middleware.api.logging.g();
        Unit r4 = Unit.INSTANCE;
        r0.a("屏幕内容设置页创建", r1, r3.a());
    L5:
        Intent r2 = getIntent();
        ActivityRecommendSettingsBinding r5 = null;
        if (r2 == null) goto L8;
        ComponentName r6 = (ComponentName) ZeusTransformUtils.preCheckCast(r2.getParcelableExtra("android.intent.extra.COMPONENT_NAME"), ComponentName.class, "com.obric.memorydata.plugin");
    L10:
        if (r6 == null) goto L24;
        if (Intrinsics.areEqual(r6.getClassName(), SCREEN_OBSERVATION_TILE_CLASS) == true) goto L24;
        com.obric.memorydata.middleware.api.logging.o r12 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.s.f11634a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r7 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L16;
        com.obric.memorydata.middleware.api.logging.g r8 = new com.obric.memorydata.middleware.api.logging.g();
        Unit r9 = Unit.INSTANCE;
        r12.a("非屏幕内容 Tile 请求跳转应用详情", r7, r8.a());
    L16:
        Intent r13 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r13.setData(Uri.fromParts("package", getPackageName(), null));
        r13.addFlags(268500992);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L19
        ZeusTransformUtils.startActivity((ScreenObservationSettingsActivity) ZeusTransformUtils.preCheckCast(this, ScreenObservationSettingsActivity.class, "com.obric.memorydata.plugin"), r13, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        finish();
        overridePendingTransition(0, 0);
        return;
    L19:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L24:
        if (MemoryService.INSTANCE.isAILabScreenMemoryEnabled() == true) goto L28;
        finish();
        return;
    L28:
        if (t.f12630a.p() == true) goto L31;
        ScreenObservationGuideFeatureActivity.a.a(ScreenObservationGuideFeatureActivity.Companion, (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), false, 2, null);
        finish();
        return;
    L31:
        prepareSystemBar();
        overridePendingTransition(ZeusTransformUtils.mapRes(R.anim.host_oui_activity_open_enter, "anim", "host_oui_activity_open_enter"), ZeusTransformUtils.mapRes(R.anim.host_oui_activity_open_exit, "anim", "host_oui_activity_open_exit"));
        ActivityRecommendSettingsBinding r15 = ActivityRecommendSettingsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r15, "inflate(...)");
        this.binding = r15;
        if (r15 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L35:
        setContentView((View) ZeusTransformUtils.preCheckCast(r5.getRoot(), View.class, "com.obric.memorydata.plugin"));
        initViews(r11);
        getLifecycle().addObserver((LifecycleObserver) ZeusTransformUtils.preCheckCast(getViewModel(), LifecycleObserver.class, "com.obric.memorydata.plugin"));
        return;
    L34:
        r5 = r15;
        goto L35
    L8:
        r6 = null;
        goto L10
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public void onResumeChecked() {
        com.obric.memorydata.middleware.api.logging.o r0 = (com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.s.f11634a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.middleware.api.logging.e r7 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        com.obric.memorydata.middleware.api.logging.g r1 = new com.obric.memorydata.middleware.api.logging.g();
        Unit r2 = Unit.INSTANCE;
        r0.a("屏幕内容设置页恢复前台", r7, r1.a());
    L5:
        getViewModel().refresh();
    }
}
