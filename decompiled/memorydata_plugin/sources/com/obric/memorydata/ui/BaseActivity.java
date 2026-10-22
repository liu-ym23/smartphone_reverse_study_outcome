package com.obric.memorydata.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.app.UserStateManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.bb;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBarActionHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 }2\u00020\u00012\u00020\u0002:\u0001}B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0004J\"\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0011J\b\u0010\u001b\u001a\u00020\bH\u0014J\b\u0010%\u001a\u00020\u0011H\u0004J\u0012\u0010&\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0006H\u0016J\u0012\u0010(\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001c\u0010(\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J,\u0010.\u001a\u0004\u0018\u00010+2\b\u0010/\u001a\u0004\u0018\u00010+2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\"\u0010.\u001a\u0004\u0018\u00010+2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u00020\u0011H\u0014J\u0010\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020\bH\u0016J\b\u00108\u001a\u00020\u0011H\u0014J\b\u00109\u001a\u00020\u0011H\u0014J\b\u0010:\u001a\u00020\u0011H\u0002J\u001a\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\n2\b\b\u0002\u0010=\u001a\u00020\bH\u0002J\b\u0010>\u001a\u00020\nH\u0002J\u0010\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u0006H\u0002J\u0010\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\u0006H\u0002J\u0010\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\u0006H\u0002J\f\u0010E\u001a\u00020\u0011*\u00020FH\u0002J\b\u0010G\u001a\u00020\bH\u0004J\b\u0010I\u001a\u00020\bH\u0014J\b\u0010J\u001a\u00020\bH\u0014J\b\u0010K\u001a\u00020\bH\u0014J\b\u0010L\u001a\u00020\bH\u0014J\u0012\u0010M\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010\u0018H\u0004J\b\u0010N\u001a\u00020\u0011H\u0004J\u0012\u0010O\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010P\u001a\u00020\u0011H\u0014J\b\u0010Q\u001a\u00020\u0011H\u0014J\b\u0010R\u001a\u00020\u0011H\u0004J\u001e\u0010S\u001a\u00020\u0011*\u00020T2\u0006\u0010U\u001a\u00020\b2\b\b\u0002\u0010V\u001a\u00020\bH\u0002J\b\u0010W\u001a\u00020\u0011H\u0004J\u0010\u0010X\u001a\u00020\u00112\u0006\u0010Y\u001a\u00020\nH\u0002J\u0018\u0010Z\u001a\u00020\u00112\u0006\u0010[\u001a\u00020\\2\u0006\u0010Y\u001a\u00020\nH\u0002J(\u0010]\u001a\u00020\u00112\u0006\u0010Y\u001a\u00020\n2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\u00062\u0006\u0010`\u001a\u00020\u0006H\u0002J\b\u0010a\u001a\u00020\u0011H\u0002J\u0010\u0010b\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\nH\u0002J\u0010\u0010c\u001a\u00020\u00112\u0006\u0010d\u001a\u00020eH\u0002J\u0006\u0010f\u001a\u00020\u0006J\u0012\u0010g\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0012\u0010h\u001a\u00020\u00062\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+J$\u0010i\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010+2\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00110kJ\u001e\u0010l\u001a\u00020\u00112\n\b\u0002\u0010m\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010+J0\u0010o\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010q\u001a\u00020\u00062\n\b\u0002\u0010n\u001a\u0004\u0018\u00010+J\u001a\u0010r\u001a\u00020\u00112\b\u0010s\u001a\u0004\u0018\u00010+2\b\u0010n\u001a\u0004\u0018\u00010+J\u0012\u0010t\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0010\u0010u\u001a\u00020\n2\u0006\u0010v\u001a\u00020\u0006H\u0002J(\u0010w\u001a\u00020\u00112\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010x\u001a\u00020\u00062\f\u0010y\u001a\b\u0012\u0004\u0012\u00020\u00110zH\u0004J\u0010\u0010{\u001a\u00020\b2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010|\u001a\u00020\u0011H\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\bX\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010H\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006~"}, d2 = {"Lcom/obric/memorydata/ui/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/obric/memorydata/ui/FloatingTitleBarOwner;", "<init>", "()V", "originalUiMode", "", "didPatchResources", "", "lastThemeState", "", "floatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "getCurrentFloatingTitleBar", "getCurrentFloatingTitleBarActionHost", "Lcom/obric/oui/titlebar/OFloatingTitleBarActionHost;", "registerFloatingTitleBar", "", "titleBar", "startActivityForResult", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "requestCode", "options", "Landroid/os/Bundle;", "forceLightOnResources", "restoreResources", "skipOnCreateCustomLogic", "forceLight", "getForceLight", "()Z", "setForceLight", "(Z)V", "navigationBarScheme", "Lcom/obric/memorydata/ui/NavigationBarScheme;", "getNavigationBarScheme", "()Lcom/obric/memorydata/ui/NavigationBarScheme;", "refreshNavigationBarScheme", "onCreate", "savedInstanceState", "setContentView", "layoutResID", "view", "Landroid/view/View;", TrackerImpl.PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "onCreateView", "parent", ActivityLifecycle.NAME, "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "onResume", "onWindowFocusChanged", "hasFocus", "onPause", "onDestroy", "applyDeviceThemeOverlay", "logThemeState", "stage", "onlyWhenChanged", "describeWindowBackground", "describeColor", "colorRes", "describeResource", "resourceId", "colorToHex", TypedValues.Custom.S_COLOR, "disableFontPaddingForVerification", "Landroid/widget/TextView;", "checkAgreePrivacyAndLogin", "isRequestingLogin", "needLoginCheckOnCreate", "needLoginCheckOnResume", "deferLoginCheckDispatch", "checkAdditionalPageAccess", "dispatchOnCreateLoginCheck", "dispatchOnResumeLoginCheck", "onCreateChecked", "onResumeChecked", "onResumeNotLogin", "requestLoginGuideOrFinish", "setupImmersiveStatusBars", "Landroidx/fragment/app/FragmentActivity;", "light", "isDarkMode", "setupInset", "requestNavigationModeInsetsCheck", AILabCheckPermissionTask.KEY_SOURCE, "handleNavigationModeInsets", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "refreshResourcesForNavigationMode", "hasThreeButtonNavigation", "navigationBottom", "tappableBottom", "refreshNavigationModeResources", "logNavigationModeResources", "refreshResources", "res", "Landroid/content/res/Resources;", "getStatusBarHeight", "getTitleBarContainerHeight", "getTitleBarTotalHeight", "getTitleBarTotalHeightAsync", "callback", "Lkotlin/Function1;", "setupCutOffArea", "titleBarView", "backgroundView", "setupTitleBarBackAction", "bottomView", "paddingTop", "setupBottomCutOffArea", "anchorView", "cutOffViewDiag", "cutOffVisibilityName", "visibility", "waitForViewPositioned", "maxAttempts", "action", "Lkotlin/Function0;", "isViewPositioned", "prepareSystemBar", "Companion", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class BaseActivity extends AppCompatActivity implements com.obric.memorydata.ui.b {
    public static final a Companion = null;
    public static final String TAG = "BaseActivity";
    private static Boolean lastKnownHasThreeButtonNavigation;
    private static int lastKnownThreeButtonNavigationBottom;
    private boolean didPatchResources;
    private OFloatingTitleBar floatingTitleBar;
    private boolean forceLight;
    private boolean isRequestingLogin;
    private String lastThemeState;
    private final NavigationBarScheme navigationBarScheme;
    private int originalUiMode;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0005H\u0007J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u0007R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/ui/BaseActivity$Companion;", "", "<init>", "()V", "TITLE_BAR_CONTAINER_HEIGHT_PX", "", "getTITLE_BAR_CONTAINER_HEIGHT_PX", "()I", "titleBarTopHeight", "getTitleBarTopHeight$annotations", "getTitleBarTopHeight", "TAG", "", "lastKnownHasThreeButtonNavigation", "", "Ljava/lang/Boolean;", "lastKnownThreeButtonNavigationBottom", "getLastKnownThreeButtonNavigationBottom", "nightModeStr", "uiMode", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ int a(a r0) {
            return r0.c();
        }

        private final String a(int r2) {
            int r1 = r2 & 48;
            if (r1 != 0) goto L5;
            return "NIGHT_UNDEFINED";
        L5:
            if (r1 != 16) goto L7;
            return "NIGHT_NO(亮色)";
        L7:
            if (r1 != 32) goto L13;
            return "NIGHT_YES(暗色)";
        L13:
            return "UNKNOWN(" + r1 + ')';
        }

        public static final /* synthetic */ String a(a r0, int r1) {
            return r0.a(r1);
        }

        private final int c() {
            return MathKt.roundToInt(TypedValue.applyDimension(1, 56, Resources.getSystem().getDisplayMetrics()));
        }

        public final int a() {
            return MathKt.roundToInt(TypedValue.applyDimension(1, 96, Resources.getSystem().getDisplayMetrics()));
        }

        @JvmStatic
        public final int b() {
            if (Intrinsics.areEqual(BaseActivity.access$getLastKnownHasThreeButtonNavigation$cp(), true) == true) goto L7;
            return 0;
        L7:
            return BaseActivity.access$getLastKnownThreeButtonNavigationBottom$cp();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/ui/BaseActivity$getTitleBarTotalHeightAsync$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f12975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseActivity f12976b;
        final /* synthetic */ Function1<Integer, Unit> c;

        b(View r3, BaseActivity r4, Function1<? super Integer, Unit> r5) {
            BaseActivity r6 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r4, BaseActivity.class, "com.obric.memorydata.plugin");
            Function1<Integer, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
            this.f12975a = r3;
            this.f12976b = r6;
            this.c = r7;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f12975a.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.memorydata.plugin"));
            if (this.f12975a.getHeight() <= 0) goto L5;
            int r0 = this.f12975a.getHeight();
        L6:
            int r1 = this.f12976b.getStatusBarHeight() + r0;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), BaseActivity.TAG, "getTitleBarTotalHeightAsync: after layout, total=" + r1 + "px (statusBar=" + this.f12976b.getStatusBarHeight() + "px, container=" + r0 + "px)", false, 4, null);
            this.c.invoke(Integer.valueOf(r1));
            return;
        L5:
            r0 = a.a(BaseActivity.Companion);
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/ui/BaseActivity$waitForViewPositioned$listener$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f12977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseActivity f12978b;
        final /* synthetic */ View c;
        final /* synthetic */ int d;
        final /* synthetic */ ViewTreeObserver e;
        final /* synthetic */ Function0<Unit> f;

        c(Ref.IntRef r3, BaseActivity r4, View r5, int r6, ViewTreeObserver r7, Function0<Unit> r8) {
            BaseActivity r9 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r4, BaseActivity.class, "com.obric.memorydata.plugin");
            Function0<Unit> r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
            this.f12977a = r3;
            this.f12978b = r9;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f12977a.element = this.f12977a.element + 1;
            boolean r0 = BaseActivity.access$isViewPositioned(this.f12978b, this.c);
            if (r0 == true) goto L7;
            if (this.f12977a.element >= this.d) goto L7;
            return;
        L7:
            if (this.e.isAlive() == false) goto L9;
            ViewTreeObserver r1 = this.e;
        L10:
            r1.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(this, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.memorydata.plugin"));
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), BaseActivity.TAG, "waitForViewPositioned: done, attempts=" + this.f12977a.element + ", ok=" + r0, false, 4, null);
            this.f.invoke();
            return;
        L9:
            r1 = this.c.getViewTreeObserver();
            goto L10
        }
    }

    static {
        Companion = new a(null);
    }

    public BaseActivity() {
        this.navigationBarScheme = NavigationBarScheme.B1;
    }

    public static final /* synthetic */ Boolean access$getLastKnownHasThreeButtonNavigation$cp() {
        return lastKnownHasThreeButtonNavigation;
    }

    public static final /* synthetic */ int access$getLastKnownThreeButtonNavigationBottom$cp() {
        return lastKnownThreeButtonNavigationBottom;
    }

    public static final /* synthetic */ boolean access$isViewPositioned(BaseActivity r2, View r3) {
        return ((BaseActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseActivity.class, "com.obric.memorydata.plugin")).isViewPositioned(r3);
    }

    private final void applyDeviceThemeOverlay() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "applyDeviceThemeOverlay ...", false, 4, null);
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
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        String r6 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r6, "getSimpleName(...)");
        com.obric.memorydata.ui.custom.a.a(r5, r6);
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin");
        String r9 = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(r9, "getSimpleName(...)");
        com.obric.memorydata.ui.custom.a.b(r7, r9);
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

    private static final Unit checkAgreePrivacyAndLogin$lambda$7(Intent r2, boolean r3) {
        if (r3 == false) goto L5;
        r2.addFlags(268468224);
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2, "com.obric.memorydata.plugin");
    L5:
        return Unit.INSTANCE;
    }

    private final String colorToHex(int r5) {
        StringBuilder r4 = new StringBuilder().append("0x");
        String r6 = Long.toString(((long) r5) & 4294967295L, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        return r4.append(StringsKt.padStart(r6, 8, '0')).toString();
    }

    private final String cutOffViewDiag(View r4) {
        if (r4 != null) goto L5;
        return "null";
    L5:
        int[] r0 = new int[2];
        r4.getLocationInWindow(r0);
        return r4.getClass().getSimpleName() + '@' + r0[0] + ',' + r0[1] + " size=" + r4.getWidth() + 'x' + r4.getHeight() + " visible=" + cutOffVisibilityName(r4.getVisibility()) + " alpha=" + r4.getAlpha() + " top=" + r4.getTop() + " bottom=" + r4.getBottom();
    }

    private final String cutOffVisibilityName(int r1) {
        if (r1 != 0) goto L4;
        return "VISIBLE";
    L4:
        if (r1 != 4) goto L6;
        return "INVISIBLE";
    L6:
        if (r1 != 8) goto L12;
        return "GONE";
    L12:
        return String.valueOf(r1);
    }

    private final String describeColor(int r4) {
        StringBuilder r1 = new StringBuilder().append(describeResource(r4)).append('=');
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        BaseActivity r3 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r5 = Result.m1421constructorimpl(r3.colorToHex(r3.getColor(r4)));     // Catch: Throwable -> L5
    L7:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L12;
        r5 = "error:" + r6.getClass().getSimpleName();
    L12:
        return r1.append((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin")).toString();
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final String describeResource(int r3) {
        if (r3 != 0) goto L16;
        return "none";
    L16:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        Object r2 = Result.m1421constructorimpl(ZeusTransformUtils.getResources((BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getResourceName(r3));     // Catch: Throwable -> L8
    L11:
        if (Result.m1424exceptionOrNullimpl(r2) == null) goto L15;
        StringBuilder r4 = new StringBuilder().append("0x");
        String r5 = Integer.toString(r3, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        r2 = r4.append(r5).toString();
    L15:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L8:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private final String describeWindowBackground() {
        TypedValue r1 = new TypedValue();
        boolean r4 = true;
        if (getTheme().resolveAttribute(android.R.attr.windowBackground, r1, true) == true) goto L6;
        return "not_found";
    L6:
        Object r3 = null;
        String r5 = null;
        if (r1.resourceId != 0) goto L30;
        int r0 = r1.type;
        if (28 <= r0) goto L20;
    L22:
        r4 = false;
    L23:
        if (r4 == false) goto L25;
        r5 = colorToHex(r1.data);
    L25:
        StringBuilder r2 = new StringBuilder().append(describeResource(r1.resourceId)).append(':');
        if (r5 != null) goto L29;
        r5 = colorToHex(r1.data);
    L29:
        return r2.append(r5).toString();
    L20:
        if (r0 >= 32) goto L22;
    L30:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L10
        BaseActivity r7 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        Object r8 = Result.m1421constructorimpl(r7.colorToHex(r7.getColor(r1.resourceId)));     // Catch: Throwable -> L10
    L13:
        if (Result.m1427isFailureimpl(r8) == true) goto L16;
        r3 = r8;
    L16:
        r5 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L10:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    private final void disableFontPaddingForVerification(TextView r3) {
        r3.setIncludeFontPadding(false);
        if (Build.VERSION.SDK_INT < 28) goto L6;
        r3.setFallbackLineSpacing(false);
        return;
    }

    @JvmStatic
    public static final int getLastKnownThreeButtonNavigationBottom() {
        return Companion.b();
    }

    private final int getTitleBarContainerHeight(View r8) {
        if (r8 == null) goto L4;
        Integer r0 = null;
        if (ZeusTransformUtils.instanceOf(r8, OFloatingTitleBar.class) == false) goto L20;
        View r7 = ((OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r8, OFloatingTitleBar.class, "com.obric.memorydata.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container"));
        if (r7 == null) goto L17;
        if (r7.getHeight() <= 0) goto L12;
        Integer r9 = Integer.valueOf(r7.getHeight());
    L13:
        if (r9 == null) goto L17;
        r0 = r9;
    L24:
        if (r0 != null) goto L26;
    L28:
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder().append("getTitleBarContainerHeight: view not laid out, fallback=");
        a r6 = Companion;
        IRunLog.a.a(r1, TAG, r10.append(a.a(r6)).append("px").toString(), false, 4, null);
        return a.a(r6);
    L26:
        if (r0.intValue() <= 0) goto L28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getTitleBarContainerHeight: measured=" + r0 + "px", false, 4, null);
        return r0.intValue();
    L12:
        r9 = null;
    L17:
        if (((OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r8, OFloatingTitleBar.class, "com.obric.memorydata.plugin")).getHeight() <= 0) goto L24;
        int r11 = ((OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r8, OFloatingTitleBar.class, "com.obric.memorydata.plugin")).getHeight();
    L22:
        r0 = Integer.valueOf(r11);
        goto L24
    L20:
        if (r8.getHeight() <= 0) goto L24;
        r11 = r8.getHeight();
        goto L22
    L4:
        return a.a(Companion);
    }

    public static /* synthetic */ int getTitleBarTotalHeight$default(BaseActivity r2, View r3, int r4, Object r5) {
        BaseActivity r6 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseActivity.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L10;
        if ((r4 & 1) == 0) goto L8;
        r3 = null;
    L8:
        return r6.getTitleBarTotalHeight(r3);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTitleBarTotalHeight");
    }

    private final void handleNavigationModeInsets(WindowInsetsCompat r6, String r7) {
        int r0 = r6.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int r8 = r6.getInsets(WindowInsetsCompat.Type.tappableElement()).bottom;
        int r1 = 0;
        if (r0 <= 0) goto L6;
        if (r8 <= 0) goto L6;
        boolean r2 = true;
    L7:
        Boolean r3 = lastKnownHasThreeButtonNavigation;
        lastKnownHasThreeButtonNavigation = Boolean.valueOf(r2);
        if (r2 == false) goto L10;
        r1 = r0;
    L10:
        lastKnownThreeButtonNavigationBottom = r1;
        if (r3 != null) goto L13;
        return;
    L13:
        if (Intrinsics.areEqual(r3, Boolean.valueOf(r2)) == true) goto L17;
        refreshResourcesForNavigationMode(r7, r2, r0, r8);
        return;
    L17:
        return;
    L6:
        r2 = false;
        goto L7
    }

    private final boolean isViewPositioned(View r3) {
        if (r3.isAttachedToWindow() == true) goto L6;
        return false;
    L6:
        if (r3.getWidth() > 0) goto L8;
        return false;
    L8:
        if (r3.getHeight() <= 0) goto L18;
        int[] r2 = new int[2];
        r3.getLocationOnScreen(r2);
        if (r2[0] != 0) goto L15;
        if (r2[1] != 0) goto L15;
        return false;
    L15:
        return true;
    L18:
        return false;
    }

    /* JADX INFO: renamed from: lambda$8OQd-5ZXhYyZ9FWfLiZsGCYhdFw, reason: not valid java name */
    public static /* synthetic */ Unit m1203lambda$8OQd5ZXhYyZ9FWfLiZsGCYhdFw(View r0, BaseActivity r1, int r2) {
        return setupCutOffArea$lambda$25(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$BHfuWm6FgxBvgFalfrrsIt40beg(BaseActivity r0, boolean r1) {
        return requestLoginGuideOrFinish$lambda$9(r0, r1);
    }

    public static /* synthetic */ Unit lambda$ByLhL_5A1G1DOQdq1pY8zJZ8DJk(View r0, BaseActivity r1, View r2) {
        return setupBottomCutOffArea$lambda$36(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$DcTLiCz8kzk7ZlLQT-hDVnGqrjk, reason: not valid java name */
    public static /* synthetic */ void m1204lambda$DcTLiCz8kzk7ZlLQThDVnGqrjk(BaseActivity r0, View r1) {
        setupTitleBarBackAction$lambda$26(r0, r1);
    }

    public static /* synthetic */ WindowInsetsCompat lambda$EZnCxc2C8PFRiemoSdUmfgVHNIE(BaseActivity r0, View r1, WindowInsetsCompat r2) {
        return setupImmersiveStatusBars$lambda$10(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$aNF36vW2JxRNQ-ZMkxlWZfu5_xw, reason: not valid java name */
    public static /* synthetic */ void m1205lambda$aNF36vW2JxRNQZMkxlWZfu5_xw(View r0, BaseActivity r1, String r2) {
        requestNavigationModeInsetsCheck$lambda$11(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$ejm4zIrJX6ce2w8ZCOhtK6nZOGA(BaseActivity r0, View r1, View r2, int r3, int r4) {
        return setupTitleBarBackAction$lambda$30(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$fVOivRZiGi1v-AL1ommZCGkalVs, reason: not valid java name */
    public static /* synthetic */ WindowInsetsCompat m1206lambda$fVOivRZiGi1vAL1ommZCGkalVs(BaseActivity r0, View r1, WindowInsetsCompat r2) {
        return prepareSystemBar$lambda$38(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$fvKmiNKvRdE-_g1U6hnxXn_YbMo, reason: not valid java name */
    public static /* synthetic */ void m1207lambda$fvKmiNKvRdE_g1U6hnxXn_YbMo(BaseActivity r0, boolean r1) {
        requestLoginGuideOrFinish$lambda$9$lambda$8(r0, r1);
    }

    public static /* synthetic */ void lambda$hg5z_R6qcwq13t0mGXDBx4HHlV8(BaseActivity r0, View r1, ViewTreeObserver r2, c r3, Function0 r4) {
        waitForViewPositioned$lambda$37(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$tYqS7VpYQYsPG_kavdfY7ZuiX5E(Intent r0, boolean r1) {
        return checkAgreePrivacyAndLogin$lambda$7(r0, r1);
    }

    private final void logNavigationModeResources(String r19) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new Pair[]{TuplesKt.to("activity", ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin")), TuplesKt.to("super", super.getResources()), TuplesKt.to("baseContext", ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin")), TuplesKt.to("application", ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin"))}), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r4 = new HashSet();
        ArrayList r5 = new ArrayList();
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r6 = r1.next();
        if (r4.add(Integer.valueOf(System.identityHashCode(((Pair) ZeusTransformUtils.preCheckCast(r6, Pair.class, "com.obric.memorydata.plugin")).getSecond()))) == false) goto L4;
        r5.add(r6);
        goto L4
    L8:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r7.hasNext() == false) goto L33;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r7.next(), Pair.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r2.component1(), String.class, "com.obric.memorydata.plugin");
        Resources r9 = (Resources) ZeusTransformUtils.preCheckCast(r2.component2(), Resources.class, "com.obric.memorydata.plugin");
        int r10 = ZeusTransformUtils.getIdentifier(r9, "config_navBarInteractionMode", TypedValues.Custom.S_INT, "android", "com.obric.memorydata.plugin");
        int r11 = -1;
        if (r10 != 0) goto L34;
        int r12 = -1;
    L22:
        int r13 = ZeusTransformUtils.getIdentifier(r9, "navigation_bar_height", "dimen", "android", "com.obric.memorydata.plugin");
        if (r13 == 0) goto L32;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L26
        BaseActivity r14 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        Object r15 = Result.m1421constructorimpl(Integer.valueOf(r9.getDimensionPixelSize(r13)));     // Catch: Throwable -> L26
    L29:
        if (Result.m1427isFailureimpl(r15) == false) goto L31;
        r15 = -1;
    L31:
        r11 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.memorydata.plugin")).intValue();
    L26:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L32:
        Configuration r17 = r9.getConfiguration();
        IRunLog r18 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r110 = new StringBuilder();
        r110.append("navigationModeResourceSnapshot stage=").append(r19).append(" name=").append(r8).append(" res=").append(r9.getClass().getName()).append('@').append(System.identityHashCode(r9)).append(" config=").append(System.identityHashCode(r17)).append(" orientation=").append(r17.orientation).append(" uiMode=").append(r17.uiMode).append(" densityDpi=").append(r17.densityDpi).append(" navModeId=").append(r10).append(" navMode=").append(r12).append(" navHeightId=").append(r13).append(" navHeight=");
        r110.append(r11);
        IRunLog.a.a(r18, TAG, r110.toString(), false, 4, null);
        goto L10
    L34:
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L15
        BaseActivity r21 = (BaseActivity) ZeusTransformUtils.preCheckCast(this, BaseActivity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Object r22 = Result.m1421constructorimpl(Integer.valueOf(r9.getInteger(r10)));     // Catch: Throwable -> L15
    L18:
        if (Result.m1427isFailureimpl(r22) == false) goto L20;
        r22 = -1;
    L20:
        r12 = ((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, "com.obric.memorydata.plugin")).intValue();
    L15:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r22 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    private final void logThemeState(String r9, boolean r10) {
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == true) goto L5;
        return;
    L5:
        int r1 = ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().uiMode;
        StringBuilder r2 = new StringBuilder().append("activity=").append(getClass().getSimpleName()).append(", uiMode=0x");
        String r3 = Integer.toString(r1, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
        String r4 = r2.append(r3).append(", night=").append(a.a(Companion, r1)).append(", defaultNightMode=").append(AppCompatDelegate.getDefaultNightMode()).append(", localNightMode=").append(getDelegate().getLocalNightMode()).append(", forceLight=").append(getForceLight()).append(", windowBackground=").append(describeWindowBackground()).append(", ouiBasicBgBase1=").append(describeColor(ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_1, TypedValues.Custom.S_COLOR, "oui_basic_bg_base_1"))).append(", ouiBgBase1=").append(describeColor(ZeusTransformUtils.mapRes(R.color.oui_bg_base_1, TypedValues.Custom.S_COLOR, "oui_bg_base_1"))).toString();
        if (r10 == true) goto L8;
    L10:
        this.lastThemeState = r4;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "themeState stage=" + r9 + ", " + r4, false, 4, null);
        return;
    L8:
        if (Intrinsics.areEqual(r4, this.lastThemeState) == false) goto L10;
    }

    static /* synthetic */ void logThemeState$default(BaseActivity r2, String r3, boolean r4, int r5, Object r6) {
        BaseActivity r7 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseActivity.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r4 = false;
    L7:
        r7.logThemeState(r3, r4);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logThemeState");
    }

    private static final WindowInsetsCompat prepareSystemBar$lambda$38(BaseActivity r2, View r3, WindowInsetsCompat r4) {
        BaseActivity r5 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "windowInsets");
        r5.handleNavigationModeInsets(r4, "prepareSystemBar");
        Insets r6 = r4.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(r6, "getInsets(...)");
        r3.setPadding(r6.left, 0, r6.right, 0);
        return r4;
    }

    private final void refreshNavigationModeResources() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new Resources[]{ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), super.getResources(), ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin"), ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin")}), Iterable.class, "com.obric.memorydata.plugin");
        HashSet r2 = new HashSet();
        ArrayList r3 = new ArrayList();
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r4 = r1.next();
        if (r2.add(Integer.valueOf(System.identityHashCode((Resources) ZeusTransformUtils.preCheckCast(r4, Resources.class, "com.obric.memorydata.plugin")))) == false) goto L4;
        r3.add(r4);
        goto L4
    L8:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        refreshResources((Resources) ZeusTransformUtils.preCheckCast(r5.next(), Resources.class, "com.obric.memorydata.plugin"));
        goto L10
    }

    private final void refreshResources(Resources r2) {
        r2.updateConfiguration(new Configuration(r2.getConfiguration()), r2.getDisplayMetrics());
    }

    private final void refreshResourcesForNavigationMode(String r8, boolean r9, int r10, int r11) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "refreshResourcesForNavigationMode source=" + r8 + " hasThreeButtonNavigation=" + r9 + " navigationBottom=" + r10 + " tappableBottom=" + r11, false, 4, null);
        logNavigationModeResources("beforeRefresh");
        refreshNavigationModeResources();
        logNavigationModeResources("afterRefresh");
        ViewCompat.requestApplyInsets(getWindow().getDecorView());
    }

    private static final Unit requestLoginGuideOrFinish$lambda$9(BaseActivity r2, final boolean r3) {
        final BaseActivity r4 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseActivity.class, "com.obric.memorydata.plugin");
        r4.runOnUiThread(new $$Lambda$BaseActivity$fvKmiNKvRdE_g1U6hnxXn_YbMo(r4, r3));
        return Unit.INSTANCE;
    }

    private static final void requestLoginGuideOrFinish$lambda$9$lambda$8(BaseActivity r2, boolean r3) {
        BaseActivity r4 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseActivity.class, "com.obric.memorydata.plugin");
        r4.isRequestingLogin = false;
        if (r4.isFinishing() == false) goto L5;
        return;
    L5:
        if (r4.isDestroyed() == true) goto L13;
        if (r3 == false) goto L9;
        r4.onResumeChecked();
        return;
    L9:
        r4.finish();
        return;
    }

    private final void requestNavigationModeInsetsCheck(final String r3) {
        final View r0 = getWindow().getDecorView();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.post(new $$Lambda$BaseActivity$aNF36vW2JxRNQZMkxlWZfu5_xw(r0, this, r3));
    }

    private static final void requestNavigationModeInsetsCheck$lambda$11(View r2, BaseActivity r3, String r4) {
        BaseActivity r5 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r3, BaseActivity.class, "com.obric.memorydata.plugin");
        WindowInsetsCompat r0 = ViewCompat.getRootWindowInsets(r2);
        if (r0 == null) goto L5;
        r5.handleNavigationModeInsets(r0, r4);
    L5:
        ViewCompat.requestApplyInsets(r2);
        View r6 = r5.findViewById(android.R.id.content);
        if (r6 == null) goto L9;
        ViewCompat.requestApplyInsets(r6);
        return;
    }

    private static final Unit setupBottomCutOffArea$lambda$36(View r10, BaseActivity r11, View r12) {
        BaseActivity r13 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r11, BaseActivity.class, "com.obric.memorydata.plugin");
        int[] r0 = new int[2];
        r10.getLocationOnScreen(r0);
        int r14 = r0[1];
        int r1 = ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getDisplayMetrics().heightPixels;
        int r2 = RangesKt.coerceAtLeast(r1 - r14, 0);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[CutOffDiag][BaseActivity] setupBottomCutOffArea.setHeight anchorTopY=" + r14 + ", screenHeight=" + r1 + ", targetHeight=" + r2 + " bgBefore=" + r13.cutOffViewDiag(r12), false, 4, null);
    L5:
        ViewGroup.LayoutParams r15 = r12.getLayoutParams();
        if (r15 == null) goto L11;
        r15.height = r2;
        r12.setLayoutParams(r15);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[CutOffDiag][BaseActivity] setupBottomCutOffArea.after bg=" + r13.cutOffViewDiag(r12), false, 4, null);
    L11:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void setupCutOffArea$default(BaseActivity r2, View r3, View r4, int r5, Object r6) {
        BaseActivity r7 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseActivity.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L13;
        if ((r5 & 1) == 0) goto L8;
        r3 = null;
    L8:
        if ((r5 & 2) == 0) goto L10;
        r4 = null;
    L10:
        r7.setupCutOffArea(r3, r4);
        return;
    L13:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setupCutOffArea");
    }

    private static final Unit setupCutOffArea$lambda$25(View r8, BaseActivity r9, int r10) {
        BaseActivity r11 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r9, BaseActivity.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[CutOffDiag][BaseActivity] setupCutOffArea.setHeight height=" + r10 + "px bgBefore=" + r11.cutOffViewDiag(r8), false, 4, null);
    L5:
        if (r8 == null) goto L13;
        ViewGroup.LayoutParams r0 = r8.getLayoutParams();
        if (r0 == null) goto L9;
        r0.height = r10;
    L9:
        r8.setLayoutParams(r0);
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[CutOffDiag][BaseActivity] setupCutOffArea.after bg=" + r11.cutOffViewDiag(r8), false, 4, null);
    L13:
        return Unit.INSTANCE;
    }

    private final void setupImmersiveStatusBars(FragmentActivity r6, boolean r7, boolean r8) {
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r6, FragmentActivity.class, "com.obric.memorydata.plugin");
        WindowCompat.setDecorFitsSystemWindows(r9.getWindow(), false);
        r9.getWindow().setStatusBarColor(r9.getColor(ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_1, TypedValues.Custom.S_COLOR, "oui_basic_bg_base_1")));
        Window r0 = r9.getWindow();
        Intrinsics.checkNotNullExpressionValue(r0, "getWindow(...)");
        g.a(r0, getNavigationBarScheme());
        ViewCompat.setOnApplyWindowInsetsListener(r9.findViewById(android.R.id.content), new $$Lambda$BaseActivity$EZnCxc2C8PFRiemoSdUmfgVHNIE(this));
        WindowInsetsControllerCompat r5 = WindowCompat.getInsetsController(r9.getWindow(), r9.getWindow().getDecorView());
        Intrinsics.checkNotNullExpressionValue(r5, "getInsetsController(...)");
        Window r10 = r9.getWindow();
        Intrinsics.checkNotNullExpressionValue(r10, "getWindow(...)");
        if (r8 == true) goto L6;
        if (r7 == false) goto L6;
        boolean r1 = true;
    L7:
        g.a(r10, r1);
        if (r8 == false) goto L10;
        r5.setAppearanceLightStatusBars(false);
        return;
    L10:
        r5.setAppearanceLightStatusBars(r7);
        return;
    L6:
        r1 = false;
        goto L7
    }

    static /* synthetic */ void setupImmersiveStatusBars$default(BaseActivity r2, FragmentActivity r3, boolean r4, boolean r5, int r6, Object r7) {
        BaseActivity r8 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseActivity.class, "com.obric.memorydata.plugin");
        FragmentActivity r9 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 2) == 0) goto L7;
        r5 = false;
    L7:
        r8.setupImmersiveStatusBars(r9, r4, r5);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setupImmersiveStatusBars");
    }

    private static final WindowInsetsCompat setupImmersiveStatusBars$lambda$10(BaseActivity r3, View r4, WindowInsetsCompat r5) {
        BaseActivity r6 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r3, BaseActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "windowInsets");
        r6.handleNavigationModeInsets(r5, "setupImmersiveStatusBars");
        Insets r7 = r5.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(r7, "getInsets(...)");
        r4.setPadding(r7.left, r7.top, r7.right, 0);
        return r5;
    }

    public static /* synthetic */ void setupTitleBarBackAction$default(BaseActivity r2, OFloatingTitleBar r3, View r4, int r5, View r6, int r7, Object r8) {
        BaseActivity r9 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseActivity.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L16;
        if ((r7 & 2) == 0) goto L8;
        r4 = null;
    L8:
        if ((r7 & 4) == 0) goto L11;
        r5 = 0;
    L11:
        if ((r7 & 8) == 0) goto L13;
        r6 = null;
    L13:
        r9.setupTitleBarBackAction(r3, r4, r5, r6);
        return;
    L16:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setupTitleBarBackAction");
    }

    private static final void setupTitleBarBackAction$lambda$26(BaseActivity r1, View r2) {
        ((BaseActivity) ZeusTransformUtils.wrapperContextForParams(r1, BaseActivity.class, "com.obric.memorydata.plugin")).onBackPressed();
    }

    private static final Unit setupTitleBarBackAction$lambda$30(BaseActivity r8, View r9, View r10, int r11, int r12) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "setupTitleBarBackAction: totalHeight=" + r12 + "px (statusBar=" + ((BaseActivity) ZeusTransformUtils.wrapperContextForParams(r8, BaseActivity.class, "com.obric.memorydata.plugin")).getStatusBarHeight() + "px)", false, 4, null);
        if (r9 == null) goto L8;
        ViewGroup.LayoutParams r13 = r9.getLayoutParams();
        if (r13 == null) goto L7;
        r13.height = r12;
    L7:
        r9.setLayoutParams(r13);
    L8:
        if (r10 == null) goto L17;
        bb.a(r10, 0);
        bb.b(r10, r12 + r11);
        if (ZeusTransformUtils.instanceOf(r10, RecyclerView.class) == false) goto L13;
        ((RecyclerView) ZeusTransformUtils.preCheckCast(r10, RecyclerView.class, "com.obric.memorydata.plugin")).scrollToPosition(0);
        goto L17
    L13:
        if (ZeusTransformUtils.instanceOf(r10, com.obric.oui.orecyclerview.widget.RecyclerView.class) == false) goto L15;
        ((com.obric.oui.orecyclerview.widget.RecyclerView) ZeusTransformUtils.preCheckCast(r10, com.obric.oui.orecyclerview.widget.RecyclerView.class, "com.obric.memorydata.plugin")).scrollToPosition(0);
        goto L17
    L15:
        r10.scrollTo(0, 0);
    L17:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void waitForViewPositioned$default(BaseActivity r2, View r3, int r4, Function0 r5, int r6, Object r7) {
        BaseActivity r8 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r2, BaseActivity.class, "com.obric.memorydata.plugin");
        Function0<Unit> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L10;
        if ((r6 & 2) == 0) goto L7;
        r4 = 10;
    L7:
        r8.waitForViewPositioned(r3, r4, r9);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: waitForViewPositioned");
    }

    private static final void waitForViewPositioned$lambda$37(BaseActivity r6, View r7, ViewTreeObserver r8, c r9, Function0 r10) {
        BaseActivity r11 = (BaseActivity) ZeusTransformUtils.wrapperContextForParams(r6, BaseActivity.class, "com.obric.memorydata.plugin");
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        if (r11.isViewPositioned(r7) == true) goto L5;
        return;
    L5:
        if (r8.isAlive() == true) goto L8;
        r8 = r7.getViewTreeObserver();
    L8:
        r8.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(r9, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "waitForViewPositioned: resolved via post", false, 4, null);
        r12.invoke();
    }

    public boolean checkAdditionalPageAccess() {
        return true;
    }

    public final boolean checkAgreePrivacyAndLogin() {
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L10;
        final Intent r0 = getIntent();
        UserStateManager.INSTANCE.requestAgreePrivacyAndLogin((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), new $$Lambda$BaseActivity$tYqS7VpYQYsPG_kavdfY7ZuiX5E(r0));
        if (isTaskRoot() == false) goto L7;
        finishAndRemoveTask();
        return false;
    L7:
        finish();
        return false;
    L10:
        return true;
    }

    public boolean deferLoginCheckDispatch() {
        return false;
    }

    public final void dispatchOnCreateLoginCheck(Bundle r2) {
        if (checkAdditionalPageAccess() == true) goto L6;
        return;
    L6:
        if (needLoginCheckOnCreate() == true) goto L8;
    L10:
        onCreateChecked(r2);
        return;
    L8:
        if (checkAgreePrivacyAndLogin() == true) goto L10;
    }

    public final void dispatchOnResumeLoginCheck() {
        if (checkAdditionalPageAccess() == true) goto L6;
        return;
    L6:
        if (needLoginCheckOnResume() == true) goto L10;
        onResumeChecked();
        return;
    L10:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == false) goto L12;
        onResumeChecked();
        return;
    L12:
        onResumeNotLogin();
    }

    public final void forceLightOnResources() {
        Resources r0 = super.getResources();
        if ((r0.getConfiguration().uiMode & 48) == 16) goto L6;
        this.originalUiMode = r0.getConfiguration().uiMode;
        this.didPatchResources = true;
        Configuration r3 = new Configuration(r0.getConfiguration());
        r3.uiMode = (r3.uiMode & (-49)) | 16;
        r0.updateConfiguration(r3, r0.getDisplayMetrics());
        return;
    }

    public OFloatingTitleBar getCurrentFloatingTitleBar() {
        return this.floatingTitleBar;
    }

    public OFloatingTitleBarActionHost getCurrentFloatingTitleBarActionHost() {
        return null;
    }

    public boolean getForceLight() {
        return this.forceLight;
    }

    public NavigationBarScheme getNavigationBarScheme() {
        return this.navigationBarScheme;
    }

    public final int getStatusBarHeight() {
        int r1 = ZeusTransformUtils.getIdentifier(ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin"), "status_bar_height", "dimen", "android", "com.obric.memorydata.plugin");
        if (r1 <= 0) goto L6;
        return ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(r1);
    L6:
        return (int) (40 * ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDisplayMetrics().density);
    }

    public final int getTitleBarTotalHeight(View r2) {
        return getStatusBarHeight() + getTitleBarContainerHeight(r2);
    }

    public final void getTitleBarTotalHeightAsync(View r9, Function1<? super Integer, Unit> r10) {
        Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (r9 != null) goto L7;
        r11.invoke(Integer.valueOf(getStatusBarHeight() + a.a(Companion)));
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r9, OFloatingTitleBar.class) == false) goto L13;
        View r0 = ((OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r9, OFloatingTitleBar.class, "com.obric.memorydata.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, OaidModel.KEY_ID, "title_bar_container"));
        if (r0 == null) goto L13;
        r9 = r0;
    L13:
        if (r9.getHeight() <= 0) goto L15;
        int r1 = getStatusBarHeight() + r9.getHeight();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getTitleBarTotalHeightAsync: already laid out, total=" + r1 + "px (statusBar=" + getStatusBarHeight() + "px, container=" + r9.getHeight() + "px)", false, 4, null);
        r11.invoke(Integer.valueOf(r1));
        return;
    L15:
        r9.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(new b(r9, this, r11), ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.memorydata.plugin"));
    }

    public boolean needLoginCheckOnCreate() {
        return false;
    }

    public boolean needLoginCheckOnResume() {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r6) {
        if (getForceLight() == false) goto L5;
        forceLightOnResources();
    L5:
        applyDeviceThemeOverlay();
        super.onCreate(r6);
        applyDeviceThemeOverlay();
        boolean r3 = false;
        logThemeState$default(this, "onCreate", false, 2, null);
        if (skipOnCreateCustomLogic() == false) goto L9;
        return;
    L9:
        if ((ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L11;
        r3 = true;
    L11:
        setupImmersiveStatusBars((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.memorydata.plugin"), true, r3);
        if (deferLoginCheckDispatch() == true) goto L15;
        dispatchOnCreateLoginCheck(r6);
        return;
    }

    public void onCreateChecked(Bundle r1) {
    }

    @Override // androidx.fragment.app.FragmentActivity
    public View onCreateView(View r3, String r4, Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "attrs");
        View r9 = super.onCreateView(r3, r4, r7, r8);
        TextView r10 = null;
        if (r9 == null) goto L10;
        if (ZeusTransformUtils.instanceOf(r9, TextView.class) == false) goto L7;
        r10 = (TextView) ZeusTransformUtils.preCheckCast(r9, TextView.class, "com.obric.memorydata.plugin");
    L7:
        if (r10 == null) goto L11;
        disableFontPaddingForVerification(r10);
        return r9;
    L11:
        return r9;
    L10:
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public View onCreateView(String r3, Context r4, AttributeSet r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        View r8 = super.onCreateView(r3, r6, r7);
        TextView r9 = null;
        if (r8 == null) goto L10;
        if (ZeusTransformUtils.instanceOf(r8, TextView.class) == false) goto L7;
        r9 = (TextView) ZeusTransformUtils.preCheckCast(r8, TextView.class, "com.obric.memorydata.plugin");
    L7:
        if (r9 == null) goto L11;
        disableFontPaddingForVerification(r9);
        return r8;
    L11:
        return r8;
    L10:
        return null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        if (getForceLight() == false) goto L5;
        restoreResources();
    L5:
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPause() {
        if (getForceLight() == false) goto L5;
        restoreResources();
    L5:
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onResume() {
        if (getForceLight() == false) goto L5;
        forceLightOnResources();
    L5:
        super.onResume();
        logThemeState("onResume", true);
        requestNavigationModeInsetsCheck("onResume");
        if (deferLoginCheckDispatch() == true) goto L9;
        dispatchOnResumeLoginCheck();
        return;
    }

    public void onResumeChecked() {
    }

    public void onResumeNotLogin() {
        if (isTaskRoot() == false) goto L5;
        requestLoginGuideOrFinish();
        return;
    L5:
        finish();
    }

    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (r1 == false) goto L6;
        requestNavigationModeInsetsCheck("onWindowFocusChanged");
        return;
    }

    public final void prepareSystemBar() {
        getWindow().setStatusBarColor(0);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), new $$Lambda$BaseActivity$fVOivRZiGi1vAL1ommZCGkalVs(this));
    }

    public final void refreshNavigationBarScheme() {
        if (skipOnCreateCustomLogic() == true) goto L6;
        Window r0 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r0, "getWindow(...)");
        g.a(r0, getNavigationBarScheme());
        return;
    }

    public final void registerFloatingTitleBar(OFloatingTitleBar r2) {
        Intrinsics.checkNotNullParameter(r2, "titleBar");
        this.floatingTitleBar = r2;
        r2.setFloatingTransitionEnabled(true);
    }

    public final void requestLoginGuideOrFinish() {
        if (this.isRequestingLogin == false) goto L5;
        return;
    L5:
        this.isRequestingLogin = true;
        UserStateManager.INSTANCE.requestAgreePrivacyAndLogin((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), new $$Lambda$BaseActivity$BHfuWm6FgxBvgFalfrrsIt40beg(this));
    }

    public final void restoreResources() {
        if (this.didPatchResources == true) goto L5;
        return;
    L5:
        Resources r0 = super.getResources();
        Configuration r1 = new Configuration(r0.getConfiguration());
        r1.uiMode = (r1.uiMode & (-49)) | (this.originalUiMode & 48);
        r0.updateConfiguration(r1, r0.getDisplayMetrics());
        this.didPatchResources = false;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity
    public void setContentView(int r1) {
        applyDeviceThemeOverlay();
        super.setContentView(r1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity
    public void setContentView(View r1) {
        applyDeviceThemeOverlay();
        super.setContentView(r1);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity
    public void setContentView(View r1, ViewGroup.LayoutParams r2) {
        applyDeviceThemeOverlay();
        super.setContentView(r1, r2);
    }

    public void setForceLight(boolean r1) {
        this.forceLight = r1;
    }

    public final void setupBottomCutOffArea(final View r10, final View r11) {
        if (r11 == null) goto L12;
        Integer r0 = com.obric.memorydata.ui.custom.a.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarCutoffAreaColor, "attr", "OFloatingTitleBarCutoffAreaColor"));
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L10;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("[CutOffDiag][BaseActivity] setupBottomCutOffArea cutoffColor=").append(r0).append(" alpha=");
        if (r0 == null) goto L8;
        Integer r1 = Integer.valueOf(Color.alpha(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue()));
    L9:
        IRunLog.a.a(r3, TAG, r2.append(r1).append(" anchor=").append(cutOffViewDiag(r10)).append(" bgBefore=").append(cutOffViewDiag(r11)).toString(), false, 4, null);
        goto L10
    L8:
        r1 = null;
    L10:
        if (r0 == null) goto L12;
        r11.setBackgroundColor(r0.intValue());
    L12:
        if (r10 == null) goto L17;
        if (r11 == null) goto L18;
        waitForViewPositioned$default(this, r10, 0, new $$Lambda$BaseActivity$ByLhL_5A1G1DOQdq1pY8zJZ8DJk(r10, this, r11), 2, null);
        return;
    L18:
        return;
    }

    public final void setupCutOffArea(View r10, final View r11) {
        if (r11 == null) goto L12;
        Integer r0 = com.obric.memorydata.ui.custom.a.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarCutoffAreaColor, "attr", "OFloatingTitleBarCutoffAreaColor"));
        if (com.obric.memorydata.middleware.api.a.b.f11600a.a() == false) goto L10;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("[CutOffDiag][BaseActivity] setupCutOffArea cutoffColor=").append(r0).append(" alpha=");
        if (r0 == null) goto L8;
        Integer r1 = Integer.valueOf(Color.alpha(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue()));
    L9:
        IRunLog.a.a(r3, TAG, r2.append(r1).append(" title=").append(cutOffViewDiag(r10)).append(" bgBefore=").append(cutOffViewDiag(r11)).toString(), false, 4, null);
        goto L10
    L8:
        r1 = null;
    L10:
        if (r0 == null) goto L12;
        r11.setBackgroundColor(r0.intValue());
    L12:
        getTitleBarTotalHeightAsync(r10, new $$Lambda$BaseActivity$8OQd5ZXhYyZ9FWfLiZsGCYhdFw(r11, this));
    }

    public final void setupInset() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setStatusBarColor(0);
    }

    public final void setupTitleBarBackAction(OFloatingTitleBar r10, final View r11, final int r12, final View r13) {
        Intrinsics.checkNotNullParameter(r10, "titleBar");
        OFloatingTitleBar.a(r10, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$BaseActivity$DcTLiCz8kzk7ZlLQThDVnGqrjk(this), 2, null);
        if (r13 == null) goto L7;
        Integer r1 = com.obric.memorydata.ui.custom.a.c((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.OFloatingTitleBarCutoffAreaColor, "attr", "OFloatingTitleBarCutoffAreaColor"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "setupTitleBarBackAction: cutoffColor=" + r1, false, 4, null);
        if (r1 == null) goto L7;
        r13.setBackgroundColor(r1.intValue());
    L7:
        getTitleBarTotalHeightAsync((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"), new $$Lambda$BaseActivity$ejm4zIrJX6ce2w8ZCOhtK6nZOGA(this, r13, r11, r12));
    }

    public boolean skipOnCreateCustomLogic() {
        return false;
    }

    @Override // androidx.activity.ComponentActivity
    public void startActivityForResult(Intent r4, int r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, MemorySourceLinkType.INTENT);
        com.obric.memorydata.ui.c.f12990a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"), r4);
        super.startActivityForResult(r4, r5, r6);
    }

    public final void waitForViewPositioned(final View r11, int r12, Function0<Unit> r13) {
        final Function0 r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "view");
        Intrinsics.checkNotNullParameter(r14, "action");
        if (isViewPositioned(r11) == false) goto L6;
        r14.invoke();
        return;
    L6:
        Ref.IntRef r3 = new Ref.IntRef();
        final ViewTreeObserver r0 = r11.getViewTreeObserver();
        final c r9 = new c(r3, this, r11, r12, r0, r14);
        r0.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(r9, ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.memorydata.plugin"));
        r11.post(new $$Lambda$BaseActivity$hg5z_R6qcwq13t0mGXDBx4HHlV8(this, r11, r0, r9, r14));
    }
}
