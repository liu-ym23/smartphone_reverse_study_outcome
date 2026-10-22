package com.obric.aiproactive.ui.entry;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiproactive.ui.util.AiProactiveUiModeController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lcom/obric/aiproactive/ui/entry/ProactiveHistoryActivity;", "Lcom/obric/aiproactive/ui/entry/BaseProactiveActivity;", "<init>", "()V", "needLoginCheckOnCreate", "", "needLoginCheckOnResume", "onCreateChecked", "", "savedInstanceState", "Landroid/os/Bundle;", "onResumeChecked", "ensureHistoryFragmentAttached", InfoRequestQPSOptTraceLogger.REASON, "", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveHistoryActivity extends BaseProactiveActivity {
    private static final a Companion = null;
    private static final String TAG = "ProactiveHistoryActivity";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiproactive/ui/entry/ProactiveHistoryActivity$Companion;", "", "<init>", "()V", "TAG", "", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public ProactiveHistoryActivity() {
    }

    private final void ensureHistoryFragmentAttached(String r13) {
        Fragment r0 = getSupportFragmentManager().findFragmentById(ZeusTransformUtils.mapRes(R.id.fragment_container, OaidModel.KEY_ID, "fragment_container"));
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r14 = new StringBuilder().append("ensureHistoryFragmentAttached reason=").append(r13).append(" existingFragment=");
        if (r0 == null) goto L7;
        Class<?> r1 = r0.getClass();
        if (r1 == null) goto L7;
        String r2 = r1.getName();
    L8:
        IRunLog.a.a(r6, TAG, r14.append(r2).append(" uiMode=").append(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().uiMode).append(" isStateSaved=").append(getSupportFragmentManager().isStateSaved()).toString(), false, 4, null);
        if (r0 == null) goto L11;
        return;
    L11:
        if (getSupportFragmentManager().isStateSaved() == true) goto L16;
        getSupportFragmentManager().beginTransaction().replace(ZeusTransformUtils.mapRes(R.id.fragment_container, OaidModel.KEY_ID, "fragment_container"), (Fragment) ZeusTransformUtils.preCheckCast(new AllFeedPageFragment(), Fragment.class, "com.obric.memorydata.plugin")).commitNowAllowingStateLoss();
        return;
    L16:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public static /* synthetic */ WindowInsets lambda$TTs4BmgRFf4BcEG1Smhi_bN44QY(View r0, View r1, View r2, View r3, WindowInsets r4) {
        return onCreateChecked$lambda$5(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$rEwjo2wHvcJVPoky9r-Zu8onfaM, reason: not valid java name */
    public static /* synthetic */ void m290lambda$rEwjo2wHvcJVPoky9rZu8onfaM(ProactiveHistoryActivity r0, View r1) {
        onCreateChecked$lambda$1(r0, r1);
    }

    private static final void onCreateChecked$lambda$1(ProactiveHistoryActivity r1, View r2) {
        ((ProactiveHistoryActivity) ZeusTransformUtils.wrapperContextForParams(r1, ProactiveHistoryActivity.class, "com.obric.memorydata.plugin")).finish();
    }

    private static final WindowInsets onCreateChecked$lambda$5(View r2, View r3, View r4, View r5, WindowInsets r6) {
        Intrinsics.checkNotNullParameter(r5, "<unused var>");
        Intrinsics.checkNotNullParameter(r6, "insets");
        int r7 = WindowInsetsCompat.toWindowInsetsCompat(r6).getInsets(WindowInsetsCompat.Type.statusBars()).top;
        int r0 = ((int) com.obric.oui.common.util.h.a(64.0f)) + r7;
        ViewGroup.LayoutParams r1 = r2.getLayoutParams();
        r1.height = r0;
        r2.setLayoutParams(r1);
        ViewGroup.LayoutParams r8 = r3.getLayoutParams();
        r8.height = r0;
        r3.setLayoutParams(r8);
        ViewGroup.LayoutParams r9 = r4.getLayoutParams();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r10.topMargin = r7 + ((int) com.obric.oui.common.util.h.a(8.0f));
        r4.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r10, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        return r6;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public boolean needLoginCheckOnCreate() {
        return true;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public boolean needLoginCheckOnResume() {
        return true;
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public void onCreateChecked(Bundle r5) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
        AiProactiveUiModeController r6 = AiProactiveUiModeController.f6869a;
        Configuration r0 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration();
        Intrinsics.checkNotNullExpressionValue(r0, "getConfiguration(...)");
        boolean r7 = !r6.b(r0);
        WindowInsetsControllerCompat r1 = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        r1.setAppearanceLightStatusBars(r7);
        r1.setAppearanceLightNavigationBars(r7);
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_proactive_history, "layout", "activity_proactive_history"));
        final View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.btn_back_container, OaidModel.KEY_ID, "btn_back_container"));
        final View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.top_blur_view, OaidModel.KEY_ID, "top_blur_view"));
        final View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.top_cut_off, OaidModel.KEY_ID, "top_cut_off"));
        r8.setOnClickListener(new $$Lambda$ProactiveHistoryActivity$rEwjo2wHvcJVPoky9rZu8onfaM(this));
        getWindow().getDecorView().setOnApplyWindowInsetsListener(new $$Lambda$ProactiveHistoryActivity$TTs4BmgRFf4BcEG1Smhi_bN44QY(r2, r3, r8));
        ensureHistoryFragmentAttached("onCreate");
        Intent r4 = getIntent();
        if (r4 == null) goto L5;
        String r9 = r4.getStringExtra("enter_from");
    L6:
        com.obric.aiproactive.ui.util.h.f6884a.b("proactive_all", "home", com.obric.aiproactive.ui.util.n.a(r9), "click");
        return;
    L5:
        r9 = null;
        goto L6
    }

    @Override // com.obric.aiproactive.ui.entry.BaseProactiveActivity
    public void onResumeChecked() {
        ensureHistoryFragmentAttached("onResume");
    }
}
