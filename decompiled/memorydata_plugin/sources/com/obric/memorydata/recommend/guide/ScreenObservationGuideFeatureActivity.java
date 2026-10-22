package com.obric.memorydata.recommend.guide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ActivityGuideFeatureBinding;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.memorydata.ui.h;
import com.obric.memorydata.utils.ba;
import com.obric.memorydata.utils.bb;
import com.obric.oui.button.OButton;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\b\u0012\u00060\fR\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/recommend/guide/ScreenObservationGuideFeatureActivity;", "Lcom/obric/memorydata/ui/BaseActivity;", "<init>", "()V", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "binding", "Lcom/obric/memorydata/recommend/databinding/ActivityGuideFeatureBinding;", "adapterWrapper", "Lcom/obric/memorydata/recommend/guide/HeaderFooterWrapper;", "Lcom/obric/memorydata/recommend/guide/GuideFeatureAdapter$ViewHolder;", "Lcom/obric/memorydata/recommend/guide/GuideFeatureAdapter;", "featureAdapter", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "needLoginCheckOnCreate", "", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "finish", "onBackPressed", "initViews", "getFeatureItems", "", "Lcom/obric/memorydata/recommend/guide/GuideFeatureItem;", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenObservationGuideFeatureActivity extends BaseActivity {
    public static final a Companion = null;
    private static final String TAG = "ScreenObservationGuideFeatureActivity";
    private e<c.C0673c> adapterWrapper;
    private ActivityGuideFeatureBinding binding;
    private c featureAdapter;
    private final ActivityResultLauncher<Intent> launcher;
    private final NavigationBarScheme navigationBarScheme;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/recommend/guide/ScreenObservationGuideFeatureActivity$Companion;", "", "<init>", "()V", "TAG", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "context", "Landroid/content/Context;", "cleanTop", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
            Intent r6 = new Intent(r3, ScreenObservationGuideFeatureActivity.class);
            if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ba.b(r3), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")) != null) goto L5;
            r6.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        L5:
            if (r5 == false) goto L7;
            r6.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        L7:
            ZeusTransformUtils.startActivity(r3, r6, "com.obric.memorydata.plugin");
        }
    }

    static {
        Companion = new a(null);
    }

    public ScreenObservationGuideFeatureActivity() {
        this.navigationBarScheme = NavigationBarScheme.A;
        ActivityResultLauncher<Intent> r0 = registerForActivityResult((ActivityResultContract) ZeusTransformUtils.preCheckCast(new ActivityResultContracts.StartActivityForResult(), ActivityResultContract.class, "com.obric.memorydata.plugin"), new $$Lambda$ScreenObservationGuideFeatureActivity$xjI6qFU1ihIkHsys87tXPiLsNQk(this));
        Intrinsics.checkNotNullExpressionValue(r0, "registerForActivityResult(...)");
        this.launcher = r0;
    }

    private final List<d> getFeatureItems() {
        String r3 = getString(ZeusTransformUtils.mapRes(R.string.screen_observation_guide_feature_first_title, TypedValues.Custom.S_STRING, "screen_observation_guide_feature_first_title"));
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
        String r4 = getString(ZeusTransformUtils.mapRes(R.string.screen_observation_guide_feature_first_desc, TypedValues.Custom.S_STRING, "screen_observation_guide_feature_first_desc"));
        Intrinsics.checkNotNullExpressionValue(r4, "getString(...)");
        String r13 = getString(ZeusTransformUtils.mapRes(R.string.screen_observation_guide_feature_second_title, TypedValues.Custom.S_STRING, "screen_observation_guide_feature_second_title"));
        Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
        String r14 = getString(ZeusTransformUtils.mapRes(R.string.screen_observation_guide_feature_second_desc, TypedValues.Custom.S_STRING, "screen_observation_guide_feature_second_desc"));
        Intrinsics.checkNotNullExpressionValue(r14, "getString(...)");
        String r15 = getString(ZeusTransformUtils.mapRes(R.string.screen_observation_guide_feature_third_title, TypedValues.Custom.S_STRING, "screen_observation_guide_feature_third_title"));
        Intrinsics.checkNotNullExpressionValue(r15, "getString(...)");
        String r16 = getString(ZeusTransformUtils.mapRes(R.string.screen_observation_guide_feature_third_desc, TypedValues.Custom.S_STRING, "screen_observation_guide_feature_third_desc"));
        Intrinsics.checkNotNullExpressionValue(r16, "getString(...)");
        String r17 = getString(ZeusTransformUtils.mapRes(R.string.screen_observation_guide_feature_fourth_title, TypedValues.Custom.S_STRING, "screen_observation_guide_feature_fourth_title"));
        Intrinsics.checkNotNullExpressionValue(r17, "getString(...)");
        String r18 = getString(ZeusTransformUtils.mapRes(R.string.screen_observation_guide_feature_fourth_desc, TypedValues.Custom.S_STRING, "screen_observation_guide_feature_fourth_desc"));
        Intrinsics.checkNotNullExpressionValue(r18, "getString(...)");
        return CollectionsKt.listOf(new d[]{new d(r3, r4, null, AppInfo.OAssistant.getPackageName(), 4, null), new d(r13, r14, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.screen_observation_guide_feature_second_icon, "drawable", "screen_observation_guide_feature_second_icon")), null, 8, null), new d(r15, r16, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.screen_observation_guide_feature_third_icon, "drawable", "screen_observation_guide_feature_third_icon")), null, 8, null), new d(r17, r18, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.screen_observation_guide_feature_fourth_icon, "drawable", "screen_observation_guide_feature_fourth_icon")), null, 8, null)});
    }

    private final void initViews() {
        ActivityGuideFeatureBinding r1 = this.binding;
        ActivityGuideFeatureBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        OFloatingTitleBar r3 = r1.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r3, "viewTitle");
        registerFloatingTitleBar(r3);
        BaseActivity r6 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin");
        ActivityGuideFeatureBinding r4 = this.binding;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L8:
        OFloatingTitleBar r7 = r4.viewTitle;
        Intrinsics.checkNotNullExpressionValue(r7, "viewTitle");
        ActivityGuideFeatureBinding r5 = this.binding;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L11:
        BaseActivity.setupTitleBarBackAction$default(r6, r7, (View) ZeusTransformUtils.preCheckCast(r5.rvFeatureList, View.class, "com.obric.memorydata.plugin"), MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())), null, 8, null);
        ActivityGuideFeatureBinding r8 = this.binding;
        if (r8 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L14:
        r8.rvFeatureList.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin")), RecyclerView.h.class, "com.obric.memorydata.plugin"));
        c r9 = new c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        e<c.C0673c> r10 = new e((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r9, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        LayoutInflater r11 = getLayoutInflater();
        int r12 = ZeusTransformUtils.mapRes(R.layout.item_guide_feature_header, "layout", "item_guide_feature_header");
        ActivityGuideFeatureBinding r13 = this.binding;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L17:
        View r14 = ZeusTransformUtils.inflate(r11, r12, (ViewGroup) ZeusTransformUtils.preCheckCast(r13.rvFeatureList, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r14);
        r10.a(r14);
        ImageView r15 = (ImageView) ZeusTransformUtils.preCheckCast(r14.findViewById(ZeusTransformUtils.mapRes(R.id.iv_guide_screen_memory, OaidModel.KEY_ID, "iv_guide_screen_memory")), ImageView.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L20;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        r16.width = 288;
        r16.height = 288;
        r15.setLayoutParams(r16);
        r15.requestLayout();
    L20:
        TextView r17 = (TextView) ZeusTransformUtils.preCheckCast(r14.findViewById(ZeusTransformUtils.mapRes(R.id.view_guide_title, OaidModel.KEY_ID, "view_guide_title")), TextView.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L23;
        r17.setTextSize(0, 96.0f);
        r17.setIncludeFontPadding(false);
    L23:
        r9.b(getFeatureItems());
        ActivityGuideFeatureBinding r18 = this.binding;
        if (r18 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L26:
        r18.barGuideNext.setButtons(CollectionsKt.listOf(com.obric.oui.c.e.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.style.OStyleV2_OButton_L_Standard_Primary, "style", "OStyleV2_OButton_L_Standard_Primary"), new $$Lambda$ScreenObservationGuideFeatureActivity$foGIqbzSYFLkjxJcs97NwsHNfc(this))));
        ActivityGuideFeatureBinding r19 = this.binding;
        if (r19 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L29:
        r19.barGuideNext.post(new $$Lambda$ScreenObservationGuideFeatureActivity$ZPDt8TAEXBSftQhyEm05XnFhqFQ(this));
        ActivityGuideFeatureBinding r20 = this.binding;
        if (r20 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L33:
        r2.rvFeatureList.setAdapter((RecyclerView.Adapter) ZeusTransformUtils.preCheckCast(r10, RecyclerView.Adapter.class, "com.obric.memorydata.plugin"));
        this.adapterWrapper = r10;
        this.featureAdapter = r9;
        com.obric.memorydata.utils.icon.b r110 = com.obric.memorydata.utils.icon.b.f13229a;
        Context r111 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        View r0 = r14.findViewById(ZeusTransformUtils.mapRes(R.id.iv_guide_screen_memory, OaidModel.KEY_ID, "iv_guide_screen_memory"));
        Intrinsics.checkNotNullExpressionValue(r0, "findViewById(...)");
        com.obric.memorydata.utils.icon.b.a(r110, r111, (ImageView) ZeusTransformUtils.preCheckCast(r0, ImageView.class, "com.obric.memorydata.plugin"), null, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.ic_guide_screen_memory, "drawable", "ic_guide_screen_memory")), 4, null);
        return;
    L32:
        r2 = r20;
        goto L33
    }

    private static final OButton initViews$lambda$6(ScreenObservationGuideFeatureActivity r9, Context r10, int r11, int r12) {
        final ScreenObservationGuideFeatureActivity r13 = (ScreenObservationGuideFeatureActivity) ZeusTransformUtils.wrapperContextForParams(r9, ScreenObservationGuideFeatureActivity.class, "com.obric.memorydata.plugin");
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "styledContext");
        OButton r14 = new OButton(r2, null, 0, 0, null, 28, null);
        r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(r13.getString(ZeusTransformUtils.mapRes(R.string.screen_observation_guide_next_step, TypedValues.Custom.S_STRING, "screen_observation_guide_next_step")), CharSequence.class, "com.obric.memorydata.plugin"));
        r14.setLayoutParams(new ViewGroup.LayoutParams(-1, r12));
        r14.setOnClickListener(new $$Lambda$ScreenObservationGuideFeatureActivity$o4rQYspdvE6Rl4MVcXzL3_haN4o(r13));
        return r14;
    }

    private static final void initViews$lambda$6$lambda$5$lambda$4(ScreenObservationGuideFeatureActivity r3, View r4) {
        ScreenObservationGuideFeatureActivity r5 = (ScreenObservationGuideFeatureActivity) ZeusTransformUtils.wrapperContextForParams(r3, ScreenObservationGuideFeatureActivity.class, "com.obric.memorydata.plugin");
        r5.launcher.launch(new Intent((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.memorydata.plugin"), ScreenObservationGuidePrivacyActivity.class));
    }

    private static final void initViews$lambda$7(ScreenObservationGuideFeatureActivity r7) {
        ScreenObservationGuideFeatureActivity r8 = (ScreenObservationGuideFeatureActivity) ZeusTransformUtils.wrapperContextForParams(r7, ScreenObservationGuideFeatureActivity.class, "com.obric.memorydata.plugin");
        ActivityGuideFeatureBinding r0 = r8.binding;
        ActivityGuideFeatureBinding r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        RecyclerView r1 = r0.rvFeatureList;
        Intrinsics.checkNotNullExpressionValue(r1, "rvFeatureList");
        View r3 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
        ActivityGuideFeatureBinding r4 = r8.binding;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L8:
        bb.c(r3, r4.barGuideNext.getHeight() + MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())));
        ActivityGuideFeatureBinding r9 = r8.binding;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L12:
        r2.rvFeatureList.scrollToPosition(0);
        return;
    L11:
        r2 = r9;
        goto L12
    }

    public static /* synthetic */ void lambda$ZPDt8TAEXBSftQhyEm05XnFhqFQ(ScreenObservationGuideFeatureActivity r0) {
        initViews$lambda$7(r0);
    }

    /* JADX INFO: renamed from: lambda$f-oGIqbzSYFLkjxJcs97NwsHNfc, reason: not valid java name */
    public static /* synthetic */ OButton m1115lambda$foGIqbzSYFLkjxJcs97NwsHNfc(ScreenObservationGuideFeatureActivity r0, Context r1, int r2, int r3) {
        return initViews$lambda$6(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$o4rQYspdvE6Rl4MVcXzL3_haN4o(ScreenObservationGuideFeatureActivity r0, View r1) {
        initViews$lambda$6$lambda$5$lambda$4(r0, r1);
    }

    public static /* synthetic */ void lambda$xjI6qFU1ihIkHsys87tXPiLsNQk(ScreenObservationGuideFeatureActivity r0, ActivityResult r1) {
        launcher$lambda$0(r0, r1);
    }

    private static final void launcher$lambda$0(ScreenObservationGuideFeatureActivity r2, ActivityResult r3) {
        ScreenObservationGuideFeatureActivity r4 = (ScreenObservationGuideFeatureActivity) ZeusTransformUtils.wrapperContextForParams(r2, ScreenObservationGuideFeatureActivity.class, "com.obric.memorydata.plugin");
        if (r3.getResultCode() != (-1)) goto L6;
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
        ActivityGuideFeatureBinding r10 = ActivityGuideFeatureBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r10, "inflate(...)");
        this.binding = r10;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L5:
        setContentView((View) ZeusTransformUtils.preCheckCast(r10.getRoot(), View.class, "com.obric.memorydata.plugin"));
        initViews();
        ScreenObservationCategoryViewModel.Companion.d();
        ScreenObservationCategoryViewModel.b.a(ScreenObservationCategoryViewModel.Companion, true, null, 2, null);
    }
}
