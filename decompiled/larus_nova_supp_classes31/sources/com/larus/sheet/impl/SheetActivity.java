package com.larus.sheet.impl;

import android.R;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.chat.l4;
import com.larus.office.base.OfficeBaseFragment;
import com.larus.platform.service.z2;
import com.larus.sheet.impl.viewmodel.SheetDetailViewModel;
import com.larus.sheet.sdk.api.ISheetSdkInternalService;
import com.larus.sheet.sdk.api.ISheetSdkProxyService;
import com.larus.sheet.sdk.api.orientation.FullscreenOption;
import com.larus.sheet.sdk.api.orientation.OrientationMode;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import va8.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001;B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\"\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0012H\u0014J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0002J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0019H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0012H\u0002J\n\u0010.\u001a\u0004\u0018\u00010'H\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010'2\u0006\u00100\u001a\u00020\tH\u0002J\u0012\u00101\u001a\u00020\u00122\b\b\u0002\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u0012H\u0016J\b\u00105\u001a\u00020\u0012H\u0016J\u0006\u00106\u001a\u00020\u0012J\b\u00107\u001a\u00020%H\u0016J\n\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020\u0012H\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\u0004\u0018\u00010'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006<"}, d2 = {"Lcom/larus/sheet/impl/SheetActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/larus/bmhome/chat/ITraceActivity;", "Lcom/larus/sheet/sdk/api/media/ISelectMediaBottomPage;", "Lcom/larus/sheet/sdk/api/ISupportChangeScreenConfigPage;", "Lcom/larus/sheet/sdk/api/IGetTrackInfo;", "<init>", "()V", "rootView", "Landroid/view/View;", "sheetFragment", "Lcom/larus/sheet/impl/SheetFragment;", "viewModel", "Lcom/larus/sheet/impl/viewmodel/SheetDetailViewModel;", "isLandscapeMode", "", "isPad", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "changeFullScreenMode", "addTargetArtifactType", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "adapterContentViewToStatusBarInPresentationMode", "toggleTitleBar", "states", "getOrientationMode", "", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "enterFullscreenMode", "preset", "Lcom/larus/sheet/sdk/api/orientation/FullscreenOption$Preset;", "exitFullscreenMode", "getWebViewInternal", "findWebViewRecursive", "parent", "ensureSystemBarsHidden", "option", "Lcom/larus/sheet/sdk/api/orientation/FullscreenOption;", "hideBottomPage", "onBackPressed", "onLoadFinishEventReported", "scene", "getTraceParams", "Lorg/json/JSONObject;", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetActivity extends AppCompatActivity implements l4, qw9.a, pw9.e, pw9.b {
    public static final /* synthetic */ int f = 0;
    public View a;
    public SheetFragment b;
    public SheetDetailViewModel c;
    public boolean d;
    public boolean e;

    public static final class a {
    }

    static {
    }

    @Override // qw9.a
    public final void f() {
    }

    public final String scene() {
        return "SLIDES_DETAIL_ACTIVITY";
    }

    public final void onBackPressed() {
        SheetFragment r0 = this.b;
        if (r0 == null) goto L35;
        Fragment r1 = ((OfficeBaseFragment) r0).f;
        boolean r2 = false;
        if (r1 == null) goto L13;
        t1a.b r3 = s1a.a.g(r1);
        if (r3 == null) goto L13;
        g0 r4 = r3.o(Reflection.getOrCreateKotlinClass(g0.class));
        if (r4 == null) goto L13;
        boolean r5 = true;
        if (r4.YC() != true) goto L13;
    L15:
        if (r5 == false) goto L24;
        Fragment r6 = ((OfficeBaseFragment) r0).f;
        if (r6 == null) goto L23;
        t1a.b r7 = s1a.a.g(r6);
        if (r7 == null) goto L23;
        g0 r8 = r7.o(Reflection.getOrCreateKotlinClass(g0.class));
        if (r8 == null) goto L23;
        r8.km("aisheet_detail");
    L23:
        FLogger.a.d("SheetFragment", "onBackPressed expand");
        return;
    L24:
        ISheetSdkProxyService r9 = (ISheetSdkProxyService) ServiceManager.get().getService(ISheetSdkProxyService.class);
        if (r9 == null) goto L29;
        vm9.d r10 = r9.c();
        if (r10 == null) goto L29;
        r2 = r10.onBackPressed(r0.L);
    L29:
        FLogger.a.d("SheetFragment", "onBackPressed final finish backProcessed=" + r2);
        if (r2 == true) goto L37;
        FragmentActivity r11 = r0.getActivity();
        if (r11 == null) goto L38;
        r11.finish();
        return;
    L38:
        return;
    L37:
        return;
    L13:
        r5 = false;
        goto L15
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(SheetActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    @Override // pw9.b
    public final JSONObject t9() {
        SheetFragment r0 = this.b;
        if ((r0 instanceof pw9.b) == false) goto L6;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.larus.sheet.sdk.api.IGetTrackInfo");
        return r0.t9();
    L6:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z1() {
        if (this.e == false) goto L6;
        return;
    L6:
        if (this.d == false) goto L19;
        FullscreenOption.Preset r0 = FullscreenOption.Preset.ALL_TRUE;
        FLogger.a.i("SheetActivity", "enterFullscreenMode: preset -> " + r0);
        FullscreenOption r1 = r0.toOption();
        Ref.IntRef r3 = new Ref.IntRef();
        View r4 = y1(getWindow());
        Boolean r5 = r1.getHideStatusBar();
        Boolean r6 = Boolean.TRUE;
        if (Intrinsics.areEqual(r5, r6) == false) goto L11;
        r3.element = 1028;
    L11:
        if (Intrinsics.areEqual(r1.getHideNavigationBar(), r6) == false) goto L14;
        r3.element = (r3.element | 2) | 512;
    L14:
        if (Intrinsics.areEqual(r1.getImmersive(), r6) == false) goto L16;
        r3.element |= 4096;
    L16:
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        r4.setSystemUiVisibility(r3.element);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SheetActivity$ensureSystemBarsHidden$1(r4, r3, null), 3, null);
        SheetFragment r2 = this.b;
        if (r2 == null) goto L23;
        r2.qa0(true);
        return;
    L23:
        return;
    L19:
        View r7 = y1(getWindow());
        WindowInsetsControllerCompat r8 = WindowCompat.getInsetsController(getWindow(), r7);
        r8.show(WindowInsetsCompat.Type.systemBars());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new SheetActivity$exitFullscreenMode$1(r7, r8, null), 3, null);
        SheetFragment r9 = this.b;
        if (r9 == null) goto L25;
        r9.qa0(false);
        return;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(SheetActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    @Override // pw9.e
    public final String ha() {
        if (getResources().getConfiguration().orientation != 2) goto L6;
        return OrientationMode.LANDSCAPE.getMode();
    L6:
        return OrientationMode.PORTRAIT.getMode();
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        final View r0 = findViewById(R.id.content);
        this.a = r0;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.d == true) goto L7;
    L9:
        int r1 = com.larus.utils.u.b(this);
    L10:
        int r2 = r0.getPaddingStart();
        int r3 = r0.getPaddingTop();
        int r4 = r0.getPaddingEnd();
        FLogger.a.i("updatePaddingRelative", "view:" + r0.getClass().getSimpleName() + ",source:,start:" + r2 + ",top:" + r3 + ",end:" + r4 + ",bottom:" + r1);
        r0.setPaddingRelative(r2, r3, r4, r1);
        ViewCompat.setOnApplyWindowInsetsListener(r0, new com.larus.sheet.impl.a(r0, this));
        return;
    L7:
        if (this.e == true) goto L9;
        r1 = 0;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public SheetActivity() {
    }

    public static View y1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // pw9.e
    public final void d4(int r3) {
        SheetFragment r0 = this.b;
        if ((r0 instanceof pw9.e) == false) goto L7;
        if (r0 == null) goto L8;
        r0.d4(r3);
        return;
    L8:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r7) {
        Intrinsics.checkNotNullParameter(r7, "newConfig");
        super.onConfigurationChanged(r7);
        boolean r1 = true;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L20;
        int r2 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r7 == null) goto L8;
        Integer r3 = Integer.valueOf(r7.orientation);     // Catch: Throwable -> L17
    L9:
        if (r3 != null) goto L12;
    L14:
        if (r2 != 3) goto L20;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:SheetActivity portrait");     // Catch: Throwable -> L17
        goto L20
    L12:
        if (r3.intValue() == r2) goto L20;
    L8:
        r3 = null;
    L20:
        if (r7.orientation == 2) goto L23;
        r1 = false;
    L23:
        FLogger.a.i("SheetActivity", "onConfigurationChanged: newLandscapeMode -> " + r1 + ", isLandscapeMode -> " + this.d);
        if (r1 != this.d) goto L26;
        return;
    L26:
        this.d = r1;
        z1();
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        com.larus.office.base.utils.c.a(r5, "SheetActivity");
        v19.f.a(getTheme());
        ISheetSdkInternalService r1 = (ISheetSdkInternalService) ServiceManager.get().getService(ISheetSdkInternalService.class);
        if (r1 == null) goto L13;
        r1.a();
    L13:
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r5);
        this.e = ku5.c.k(this);
        FLogger.a.i("SheetActivity", "SheetActivity.onCreate, isPad: " + this.e);
        this.c = (SheetDetailViewModel) new ViewModelProvider(this, new SavedStateViewModelFactory(getApplication(), this)).get(SheetDetailViewModel.class);
        boolean r2 = false;
        if (getResources().getConfiguration().orientation != 2) goto L16;
        boolean r6 = true;
    L17:
        this.d = r6;
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L20;
        boolean r7 = true;
    L21:
        v19.h.a = r7;
        com.larus.utils.u.e(this, true, r7);
        com.larus.utils.u.d(this);
        Window r8 = getWindow();
        if (r8 == null) goto L24;
        r8.setBackgroundDrawableResource(2131102529);
    L24:
        int r9 = Build.VERSION.SDK_INT;
        if (r9 < 28) goto L28;
        WindowManager.LayoutParams r0 = getWindow().getAttributes();
        r0.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(r0);
    L28:
        if (r9 < 29) goto L30;
        getWindow().setStatusBarContrastEnforced(false);
    L30:
        setContentView(2131561797);
        this.a = findViewById(R.id.content);
        z1();
        Intent r10 = getIntent();
        if (r10 == null) goto L33;
        Integer r11 = Integer.valueOf(r10.getIntExtra("artifact_type", -1));
    L34:
        if (r11 != null) goto L37;
    L41:
        SheetFragment r12 = new SheetFragment();
        this.b = r12;
        Bundle r3 = getIntent().getExtras();
        if (r3 == null) goto L49;
        SheetDetailViewModel r4 = this.c;
        if (r4 != null) goto L46;
    L48:
        r3.putBoolean("has_report_finish_event", r2);
        goto L49
    L46:
        if (r4.getHasReportLaunchResult() != true) goto L48;
        r2 = true;
    L49:
        r12.setArguments(r3);
        FragmentTransaction r13 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "aisheet_detail", 2131373275) == true) goto L53;
        r13 = r13.replace(2131373275, r12, "aisheet_detail");
    L53:
        r13.commitAllowingStateLoss();
        return;
    L37:
        if (r11.intValue() != (-1)) goto L41;
        Intent r14 = getIntent();
        if (r14 == null) goto L41;
        r14.putExtra("artifact_type", 12);
        goto L41
    L33:
        r11 = null;
        goto L34
    L20:
        r7 = false;
        goto L21
    L16:
        r6 = false;
        goto L17
    }

    public final void onActivityResult(int r6, int r7, Intent r8) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(r6, r7, r8);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("Router onActivityResult: requestCode -> ");
        r1.append(r6);
        r1.append(" , resultCode -> ");
        r1.append(r7);
        r1.append(" , data: ");
        xe8.a r2 = null;
        if (r8 == null) goto L5;
        Bundle r3 = r8.getExtras();
    L6:
        r1.append(r3);
        r0.i("SheetActivity", r1.toString());
        if (r8 == null) goto L30;
        Bundle r9 = r8.getExtras();
        if (r9 == null) goto L31;
        Fragment r4 = getSupportFragmentManager().findFragmentByTag("aisheet_detail");
        if (r4 == null) goto L15;
        FragmentManager r5 = r4.getChildFragmentManager();
        if (r5 == null) goto L15;
        Fragment r10 = r5.findFragmentByTag("sheet_detail_chat");
    L16:
        boolean r11 = false;
        if (r10 != null) goto L19;
    L21:
        if (r11 == true) goto L23;
        return;
    L23:
        if (r10.isDetached() == false) goto L25;
        return;
    L25:
        if ((r10 instanceof xe8.a) == false) goto L27;
        r2 = (xe8.a) r10;
    L27:
        if (r2 == null) goto L34;
        r2.Lc(r9, r6, r7);
        return;
    L34:
        return;
    L19:
        if (r10.isAdded() != true) goto L21;
        r11 = true;
    L15:
        r10 = null;
        goto L16
    L31:
        return;
    L30:
        return;
    L5:
        r3 = null;
        goto L6
    }
}
