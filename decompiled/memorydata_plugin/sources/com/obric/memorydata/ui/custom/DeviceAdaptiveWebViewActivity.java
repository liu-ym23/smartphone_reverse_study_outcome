package com.obric.memorydata.ui.custom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.constants.Constants;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseActivity;
import com.obric.memorydata.ui.NavigationBarScheme;
import com.obric.memorydata.ui.g;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.window.permission.WebViewActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0005H\u0014J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0002¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/ui/custom/DeviceAdaptiveWebViewActivity;", "Lcom/obric/oui/window/permission/WebViewActivity;", "<init>", "()V", "applyDeviceThemeOverlay", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "disableHorizontalScroll", "addCutOffBackground", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "setCutOffHeight", "cutOffView", "Landroid/view/View;", "containerHeight", "", "getStatusBarHeight", "findWebView", "Landroid/webkit/WebView;", "view", "Companion", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeviceAdaptiveWebViewActivity extends WebViewActivity {
    public static final a Companion = null;
    private static final String EXTRA_TITLE = "extra_title";
    private static final String EXTRA_URL = "extra_url";
    private static final String TAG = "DeviceAdaptiveWebView";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/ui/custom/DeviceAdaptiveWebViewActivity$Companion;", "", "<init>", "()V", "TAG", "", "EXTRA_URL", "EXTRA_TITLE", Constants.LAUNCH_TAG, "", "context", "Landroid/content/Context;", "url", "title", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final void a(Context r3, String r4, String r5) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r4, "url");
            Intrinsics.checkNotNullParameter(r5, "title");
            Intent r6 = new Intent(r2, DeviceAdaptiveWebViewActivity.class);
            r6.putExtra(DeviceAdaptiveWebViewActivity.EXTRA_URL, r4);
            r6.putExtra(DeviceAdaptiveWebViewActivity.EXTRA_TITLE, r5);
            ZeusTransformUtils.startActivity(r2, r6, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/ui/custom/DeviceAdaptiveWebViewActivity$addCutOffBackground$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f12993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ DeviceAdaptiveWebViewActivity f12994b;
        final /* synthetic */ View c;

        b(View r3, DeviceAdaptiveWebViewActivity r4, View r5) {
            DeviceAdaptiveWebViewActivity r6 = (DeviceAdaptiveWebViewActivity) ZeusTransformUtils.wrapperContextForParams(r4, DeviceAdaptiveWebViewActivity.class, "com.obric.memorydata.plugin");
            this.f12993a = r3;
            this.f12994b = r6;
            this.c = r5;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f12993a.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.memorydata.plugin"));
            DeviceAdaptiveWebViewActivity.access$setCutOffHeight(this.f12994b, this.c, this.f12993a.getHeight());
        }
    }

    static {
        Companion = new a(null);
    }

    public DeviceAdaptiveWebViewActivity() {
    }

    public static final /* synthetic */ void access$setCutOffHeight(DeviceAdaptiveWebViewActivity r2, View r3, int r4) {
        ((DeviceAdaptiveWebViewActivity) ZeusTransformUtils.wrapperContextForParams(r2, DeviceAdaptiveWebViewActivity.class, "com.obric.memorydata.plugin")).setCutOffHeight(r3, r4);
    }

    private final void addCutOffBackground(OFloatingTitleBar r8) {
        View r1 = r8.getChildAt(0);
        if (ZeusTransformUtils.instanceOf(r1, FrameLayout.class) == false) goto L5;
        FrameLayout r2 = (FrameLayout) ZeusTransformUtils.preCheckCast(r1, FrameLayout.class, "com.obric.memorydata.plugin");
    L6:
        if (r2 == null) goto L19;
        View r3 = new View((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"));
        r3.setId(View.generateViewId());
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, 0);
        r4.gravity = 48;
        r2.addView(r3, 0, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        TypedValue r0 = new TypedValue();
        if (getTheme().resolveAttribute(ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarCutoffAreaColor, "attr", "OFloatingTitleBarCutoffAreaColor"), r0, true) == false) goto L10;
        r3.setBackgroundColor(r0.data);
    L11:
        View r5 = r8.findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container"));
        if (r5 != null) goto L15;
        r5 = (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin");
    L15:
        if (r5.getHeight() <= 0) goto L17;
        setCutOffHeight(r3, r5.getHeight());
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "addCutOffBackground: injected into inner FrameLayout", false, 4, null);
        return;
    L17:
        r5.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(new b(r5, this, r3), ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.memorydata.plugin"));
        goto L18
    L10:
        r3.setBackgroundResource(ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_1, TypedValues.Custom.S_COLOR, "oui_basic_bg_base_1"));
        goto L11
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "addCutOffBackground: inner FrameLayout not found!", null, 4, null);
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final void applyDeviceThemeOverlay() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), BaseActivity.TAG, "applyDeviceThemeOverlay ...", false, 4, null);
        String r0 = DeviceInfoState.INSTANCE.getDeviceModel();
        int r1 = r0.hashCode();
        if (r1 == (-2002884275)) goto L17;
        if (r1 == (-1048984789)) goto L13;
        if (r1 == 1328894480) goto L10;
    L18:
        int r2 = R.style.DeviceOverlay_Pacific;
        String r3 = "DeviceOverlay_Pacific";
    L19:
        int r4 = ZeusTransformUtils.mapRes(r2, "style", r3);
        getTheme().applyStyle(r4, true);
        return;
    L10:
        if (r0.equals("nerida-lite") == false) goto L18;
    L15:
        r2 = R.style.DeviceOverlay_Nerida;
        r3 = "DeviceOverlay_Nerida";
        goto L19
    L13:
        if (r0.equals("nerida") == true) goto L15;
    L17:
        if (r0.equals("Genesis-R") == false) goto L18;
        r2 = R.style.DeviceOverlay_GenesisR;
        r3 = "DeviceOverlay_GenesisR";
        goto L19
    }

    private final void disableHorizontalScroll() {
        View r0 = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(r0, "getDecorView(...)");
        WebView r1 = findWebView(r0);
        if (r1 == null) goto L5;
        r1.setHorizontalScrollBarEnabled(false);
        r1.getSettings().setSupportZoom(false);
        r1.getSettings().setBuiltInZoomControls(false);
        r1.getSettings().setUseWideViewPort(true);
        r1.getSettings().setLoadWithOverviewMode(true);
        r1.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "disableHorizontalScroll: WebView found, disabled horizontal scroll & enabled wide viewport", false, 4, null);
    L5:
        View r8 = getWindow().getDecorView().findViewById(android.R.id.content);
        if (r8 == null) goto L8;
        r8.setOverScrollMode(2);
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "disableHorizontalScroll: completed", false, 4, null);
    }

    private final WebView findWebView(View r6) {
        if (ZeusTransformUtils.instanceOf(r6, WebView.class) == false) goto L7;
        return (WebView) ZeusTransformUtils.preCheckCast(r6, WebView.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L14;
        int r0 = 0;
        int r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildCount();
    L9:
        if (r0 >= r2) goto L18;
        View r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.memorydata.plugin")).getChildAt(r0);
        Intrinsics.checkNotNullExpressionValue(r3, "getChildAt(...)");
        WebView r4 = findWebView(r3);
        if (r4 != null) goto L12;
        r0 = r0 + 1;
        goto L9
    L12:
        return r4;
    L18:
        return null;
    L14:
        return null;
    }

    private final int getStatusBarHeight() {
        int r1 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), "status_bar_height", "dimen", "android", "com.obric.memorydata.plugin");
        if (r1 > 0) goto L7;
        return 0;
    L7:
        return ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r1);
    }

    /* JADX INFO: renamed from: lambda$wZWN7rPaz_NB2ekxvnnuSdD7t-8, reason: not valid java name */
    public static /* synthetic */ Unit m1211lambda$wZWN7rPaz_NB2ekxvnnuSdD7t8(DeviceAdaptiveWebViewActivity r0) {
        return onCreate$lambda$0(r0);
    }

    @JvmStatic
    public static final void launch(Context r2, String r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Companion.a(r5, r3, r4);
    }

    private static final Unit onCreate$lambda$0(DeviceAdaptiveWebViewActivity r2) {
        ((DeviceAdaptiveWebViewActivity) ZeusTransformUtils.wrapperContextForParams(r2, DeviceAdaptiveWebViewActivity.class, "com.obric.memorydata.plugin")).onBackPressed();
        return Unit.INSTANCE;
    }

    private final void setCutOffHeight(View r7, int r8) {
        int r6 = getStatusBarHeight() + r8;
        r7.getLayoutParams().height = r6;
        r7.requestLayout();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "addCutOffBackground: set height=" + r6, false, 4, null);
    }

    @Override // com.obric.oui.window.permission.WebViewActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r10) {
        applyDeviceThemeOverlay();
        super.onCreate(r10);
        Window r11 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r11, "getWindow(...)");
        g.a(r11, NavigationBarScheme.B1);
        OFloatingTitleBar r12 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.web_activity_title_bar, OaidModel.KEY_ID, "web_activity_title_bar")), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L5;
        r12.setFloatingTransitionEnabled(true);
        com.obric.memorydata.ui.custom.a.a(r12, new $$Lambda$DeviceAdaptiveWebViewActivity$wZWN7rPaz_NB2ekxvnnuSdD7t8(this));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onCreate: reloadStartAction applied", false, 4, null);
        addCutOffBackground(r12);
    L6:
        disableHorizontalScroll();
        View r13 = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(r13, "getDecorView(...)");
        WebView r9 = findWebView(r13);
        if (r9 == null) goto L10;
        g.a((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.memorydata.plugin"), 0, 1, null);
        return;
    L10:
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "onCreate: titleBar not found", false, 4, null);
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "not login, finish activity", false, 4, null);
        finish();
        return;
    }
}
