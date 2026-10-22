package com.obric.memorydata.recommend.guide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ActivityGuidePrivacyBinding;
import com.obric.memorydata.recommend.settings.t;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.memorydata.ui.h;
import com.obric.memorydata.utils.bb;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.window.permission.WebViewActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0012H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/recommend/guide/ScreenObservationGuidePrivacyActivity;", "Lcom/obric/memorydata/ui/BaseActivity;", "<init>", "()V", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "binding", "Lcom/obric/memorydata/recommend/databinding/ActivityGuidePrivacyBinding;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "needLoginCheckOnCreate", "", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "finish", "onBackPressed", "initTitleBar", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "initViews", "jumpToAppSelectionActivity", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenObservationGuidePrivacyActivity extends BaseActivity {
    public static final a Companion = null;
    private static final String TAG = "ScreenObservationGuidePrivacyActivity";
    private ActivityGuidePrivacyBinding binding;
    private final ActivityResultLauncher<Intent> launcher;
    private final NavigationBarScheme navigationBarScheme;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/guide/ScreenObservationGuidePrivacyActivity$Companion;", "", "<init>", "()V", "TAG", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "cleanTop", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public ScreenObservationGuidePrivacyActivity() {
        this.navigationBarScheme = NavigationBarScheme.A;
        ActivityResultLauncher<Intent> r0 = registerForActivityResult((ActivityResultContract) ZeusTransformUtils.preCheckCast(new ActivityResultContracts.StartActivityForResult(), ActivityResultContract.class, "com.obric.memorydata.plugin"), new $$Lambda$ScreenObservationGuidePrivacyActivity$BM1U3zi75F13osHHrqInQxL4Nc(this));
        Intrinsics.checkNotNullExpressionValue(r0, "registerForActivityResult(...)");
        this.launcher = r0;
    }

    private final void initTitleBar(OFloatingTitleBar r10) {
        registerFloatingTitleBar(r10);
        BaseActivity r2 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin");
        ActivityGuidePrivacyBinding r9 = this.binding;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L5:
        BaseActivity.setupTitleBarBackAction$default(r2, r10, (View) ZeusTransformUtils.preCheckCast(r9.guidePrivacyContainer, View.class, "com.obric.memorydata.plugin"), MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())), null, 8, null);
    }

    private final void initViews() {
        ActivityGuidePrivacyBinding r1 = this.binding;
        ActivityGuidePrivacyBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        OFloatingTitleBar r3 = r1.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r3, "viewTitle");
        initTitleBar(r3);
        ActivityGuidePrivacyBinding r4 = this.binding;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L8:
        r4.privacyPolicy.setOnContentClickListener(new $$Lambda$ScreenObservationGuidePrivacyActivity$EwI8TavXxsRLyXCeRd_5pYDIM(this));
        ActivityGuidePrivacyBinding r5 = this.binding;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L11:
        r5.barGuideNext.setButtons(CollectionsKt.listOf(com.obric.oui.c.e.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.style.OStyleV2_OButton_L_Standard_Primary, "style", "OStyleV2_OButton_L_Standard_Primary"), new $$Lambda$ScreenObservationGuidePrivacyActivity$LojljWQVaW0v8s8GhfIMhjH3uo(this))));
        ActivityGuidePrivacyBinding r6 = this.binding;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L14:
        r6.barGuideNext.post(new $$Lambda$ScreenObservationGuidePrivacyActivity$8ekTBQjQcbjLnvapUHFs0E0voY(this));
        ImageView r7 = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iv_privacy_icon, OaidModel.KEY_ID, "iv_privacy_icon")), ImageView.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L17;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        r8.width = 288;
        r8.height = 288;
        r7.setLayoutParams(r8);
        r7.requestLayout();
    L17:
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_privacy_title, OaidModel.KEY_ID, "tv_privacy_title")), TextView.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L20;
        r9.setTextSize(0, 96.0f);
        r9.setIncludeFontPadding(false);
    L20:
        com.obric.memorydata.utils.icon.b r10 = com.obric.memorydata.utils.icon.b.f13229a;
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        ActivityGuidePrivacyBinding r12 = this.binding;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L23:
        com.obric.memorydata.utils.icon.b.a(r10, r11, r12.listItemFirst.getIconView(), null, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.screen_observation_guide_privacy_first_icon, "drawable", "screen_observation_guide_privacy_first_icon")), 4, null);
        com.obric.memorydata.utils.icon.b r14 = com.obric.memorydata.utils.icon.b.f13229a;
        Context r15 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        ActivityGuidePrivacyBinding r13 = this.binding;
        if (r13 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L26:
        com.obric.memorydata.utils.icon.b.a(r14, r15, r13.listItemSecond.getIconView(), null, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.screen_observation_guide_privacy_second_icon, "drawable", "screen_observation_guide_privacy_second_icon")), 4, null);
        com.obric.memorydata.utils.icon.b r16 = com.obric.memorydata.utils.icon.b.f13229a;
        Context r17 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        ActivityGuidePrivacyBinding r18 = this.binding;
        if (r18 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L29:
        com.obric.memorydata.utils.icon.b.a(r16, r17, r18.listItemThird.getIconView(), null, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.screen_observation_guide_privacy_third_icon, "drawable", "screen_observation_guide_privacy_third_icon")), 4, null);
        com.obric.memorydata.utils.icon.b r19 = com.obric.memorydata.utils.icon.b.f13229a;
        Context r110 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        ActivityGuidePrivacyBinding r0 = this.binding;
        if (r0 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L33:
        com.obric.memorydata.utils.icon.b.a(r19, r110, r2.listItemFourth.getIconView(), null, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.screen_observation_guide_privacy_fourth_icon, "drawable", "screen_observation_guide_privacy_fourth_icon")), 4, null);
        return;
    L32:
        r2 = r0;
        goto L33
    }

    private static final void initViews$lambda$1(ScreenObservationGuidePrivacyActivity r6, View r7) {
        ScreenObservationGuidePrivacyActivity r8 = (ScreenObservationGuidePrivacyActivity) ZeusTransformUtils.wrapperContextForParams(r6, ScreenObservationGuidePrivacyActivity.class, "com.obric.memorydata.plugin");
        String r9 = UserSettings.INSTANCE.getGlobalMemoryPrivacyUrl();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "click privacy policy failed, url is empty", null, 4, null);
        return;
    L9:
        WebViewActivity.open((Context) ZeusTransformUtils.preCheckCast(r8, Context.class, "com.obric.memorydata.plugin"), r9, r8.getString(ZeusTransformUtils.mapRes(R.string.recommend_memory_privacy_privacy_policy, TypedValues.Custom.S_STRING, "recommend_memory_privacy_privacy_policy")), true);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private static final OButton initViews$lambda$5(ScreenObservationGuidePrivacyActivity r9, Context r10, int r11, int r12) {
        final ScreenObservationGuidePrivacyActivity r13 = (ScreenObservationGuidePrivacyActivity) ZeusTransformUtils.wrapperContextForParams(r9, ScreenObservationGuidePrivacyActivity.class, "com.obric.memorydata.plugin");
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "styledContext");
        OButton r14 = new OButton(r2, null, 0, 0, null, 28, null);
        r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(r13.getString(ZeusTransformUtils.mapRes(R.string.screen_observation_guide_privacy_accept, TypedValues.Custom.S_STRING, "screen_observation_guide_privacy_accept")), CharSequence.class, "com.obric.memorydata.plugin"));
        r14.setLayoutParams(new ViewGroup.LayoutParams(-1, r12));
        r14.setOnClickListener(new $$Lambda$ScreenObservationGuidePrivacyActivity$1a8UacxkwV9vzaz8V_JA26L9eHM(r13));
        return r14;
    }

    private static final void initViews$lambda$5$lambda$4$lambda$3(ScreenObservationGuidePrivacyActivity r2, View r3) {
        final ScreenObservationGuidePrivacyActivity r4 = (ScreenObservationGuidePrivacyActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationGuidePrivacyActivity.class, "com.obric.memorydata.plugin");
        if (ScreenObservationCategoryViewModel.Companion.e() == false) goto L5;
        r4.jumpToAppSelectionActivity();
        return;
    L5:
        ScreenObservationCategoryViewModel.Companion.a(false, new $$Lambda$ScreenObservationGuidePrivacyActivity$BEHrGDFNMeQhCN5OIXWgv3B0dIU(r4));
    }

    private static final Unit initViews$lambda$5$lambda$4$lambda$3$lambda$2(ScreenObservationGuidePrivacyActivity r2) {
        ((ScreenObservationGuidePrivacyActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationGuidePrivacyActivity.class, "com.obric.memorydata.plugin")).jumpToAppSelectionActivity();
        return Unit.INSTANCE;
    }

    private static final void initViews$lambda$6(ScreenObservationGuidePrivacyActivity r5) {
        ScreenObservationGuidePrivacyActivity r6 = (ScreenObservationGuidePrivacyActivity) ZeusTransformUtils.wrapperContextForParams(r5, ScreenObservationGuidePrivacyActivity.class, "com.obric.memorydata.plugin");
        ActivityGuidePrivacyBinding r0 = r6.binding;
        ActivityGuidePrivacyBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        ONestedScrollView r1 = r0.guidePrivacyContainer;
        Intrinsics.checkNotNullExpressionValue(r1, "guidePrivacyContainer");
        View r3 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
        ActivityGuidePrivacyBinding r7 = r6.binding;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        bb.c(r3, r2.barGuideNext.getHeight() + MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())));
        return;
    L8:
        r2 = r7;
        goto L9
    }

    private final void jumpToAppSelectionActivity() {
        t.f12630a.c(true);
        t.f12630a.a(true);
        this.launcher.launch(new Intent((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ScreenObservationGuideAppActivity.class));
    }

    /* JADX INFO: renamed from: lambda$-BM1U3zi75F13osHHrqInQxL4Nc, reason: not valid java name */
    public static /* synthetic */ void m1116lambda$BM1U3zi75F13osHHrqInQxL4Nc(ScreenObservationGuidePrivacyActivity r0, ActivityResult r1) {
        launcher$lambda$0(r0, r1);
    }

    public static /* synthetic */ void lambda$1a8UacxkwV9vzaz8V_JA26L9eHM(ScreenObservationGuidePrivacyActivity r0, View r1) {
        initViews$lambda$5$lambda$4$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$8ekTBQjQcbjLn-vapUHFs0E0voY, reason: not valid java name */
    public static /* synthetic */ void m1117lambda$8ekTBQjQcbjLnvapUHFs0E0voY(ScreenObservationGuidePrivacyActivity r0) {
        initViews$lambda$6(r0);
    }

    public static /* synthetic */ Unit lambda$BEHrGDFNMeQhCN5OIXWgv3B0dIU(ScreenObservationGuidePrivacyActivity r0) {
        return initViews$lambda$5$lambda$4$lambda$3$lambda$2(r0);
    }

    /* JADX INFO: renamed from: lambda$EwI-8TavX-xsRLyXCeRd_5pYDIM, reason: not valid java name */
    public static /* synthetic */ void m1118lambda$EwI8TavXxsRLyXCeRd_5pYDIM(ScreenObservationGuidePrivacyActivity r0, View r1) {
        initViews$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Lo-jljWQVaW0v8s8GhfIMhjH3uo, reason: not valid java name */
    public static /* synthetic */ OButton m1119lambda$LojljWQVaW0v8s8GhfIMhjH3uo(ScreenObservationGuidePrivacyActivity r0, Context r1, int r2, int r3) {
        return initViews$lambda$5(r0, r1, r2, r3);
    }

    private static final void launcher$lambda$0(ScreenObservationGuidePrivacyActivity r2, ActivityResult r3) {
        ScreenObservationGuidePrivacyActivity r4 = (ScreenObservationGuidePrivacyActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationGuidePrivacyActivity.class, "com.obric.memorydata.plugin");
        if (r3.getResultCode() != (-1)) goto L6;
        ZeusTransformUtils.setResult(r4, -1, "com.obric.memorydata.plugin");
        r4.finish();
        return;
    }

    public void finish() {
        super.finish();
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
        ActivityGuidePrivacyBinding r10 = ActivityGuidePrivacyBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r10, "inflate(...)");
        this.binding = r10;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r10.getRoot(), View.class, "com.obric.memorydata.plugin"));
        initViews();
        ScreenObservationCategoryViewModel.b.a(ScreenObservationCategoryViewModel.Companion, true, null, 2, null);
    }
}
