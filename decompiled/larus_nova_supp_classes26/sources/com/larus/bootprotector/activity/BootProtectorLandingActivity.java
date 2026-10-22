package com.larus.bootprotector.activity;

import android.R;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.larus.applog.api.IApplog;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bootprotector.IBootProtectorLauncher;
import com.larus.bootprotector.activity.dialog.BootProtectorConfirmDialog;
import com.larus.bootprotector.entity.BaseExceptionInfo;
import com.larus.bootprotector.entity.LastException;
import com.larus.bootprotector.hotfix.IBootProtectorHotPatch;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.settings.provider.bootprotector.BootProtectorConfig;
import com.larus.settings.provider.bootprotector.CrashPortrait;
import com.larus.settings.provider.bootprotector.PreciseFixStategy;
import com.larus.settings.provider.bootprotector.UrgentCmd;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.larus.utils.u;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.bootprotector.ObricBootProtectorSPIServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\u0016\u0010\u001a\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0010\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\b\u0010!\u001a\u00020\u0007H\u0002J\b\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020\u0007H\u0002J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0011H\u0002J\b\u0010'\u001a\u00020\u0007H\u0014J\b\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0007H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/bootprotector/activity/BootProtectorLandingActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "lastDownloadClickTime", "", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "initBootProtectorLandingPageDependency", "showBootProtectorDialog", "onDownloadBtnClick", "gotoMarket", "", "context", "packageName", "", "onOptimizeBtnClick", "executeUrgentCmdTaskWithDelay", "delayMs", "executeUrgentCmdTaskImmediately", "executeAggressiveCleaning", "executePreciseCleaning", "urgentCmds", "", "Lcom/larus/settings/provider/bootprotector/UrgentCmd;", "matchLastExceptionWithPortrait", "requestHotFixPatch", "requestHotFixPatchInternal", "requestSettingInBootProtector", "requestSettingInBootProtectorInternal", "reportEnterBootProtectorPage", "reportClickOpt", "reportClickDownload", "success", "onStop", "skipBootProtectorPageOnNextLaunch", "onDestroy", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BootProtectorLandingActivity extends AppCompatActivity {
    public static final /* synthetic */ int b = 0;
    public long a;

    public static final class a {
    }

    static {
    }

    public static void A1() {
        nu8.a.e("BootProtectorLandingAct", "executeUrgentCmdTaskImmediately");
        IBootProtectorLauncher.a.getClass();
        IBootProtectorLauncher.a.b().b();
    }

    public static List B1() {
        e10 r0 = e10.a;
        BootProtectorConfig r1 = e10.C();
        if (r1 == null) goto L25;
        List r2 = r1.getPreciseFixStrategies();
        if (r2 == null) goto L25;
        LastException r3 = hu8.e.h();
        if (r3 != null) goto L10;
        return null;
    L10:
        Iterator r4 = r2.iterator();
    L12:
        if (r4.hasNext() == false) goto L24;
        PreciseFixStategy r5 = (PreciseFixStategy) r4.next();
        if (r5 == null) goto L16;
        CrashPortrait r6 = r5.getCrashPortrait();
    L17:
        if (r6 == null) goto L12;
        if (ku8.a.c(r3, r6) == false) goto L12;
        nu8.a.h("BootProtectorLandingAct", "matchLastExceptionWithPortrait: MATCHED !");
        List r7 = r5.getUrgentCmds();
        if (r7 != null) goto L23;
        return null;
    L23:
        return CollectionsKt.filterNotNull(r7);
    L16:
        r6 = null;
        goto L17
    L24:
        nu8.a.e("BootProtectorLandingAct", "matchLastExceptionWithPortrait: NOT MATCHED !");
    L25:
        return null;
    }

    public static void y1() {
        BaseExceptionInfo.Type r2 = null;
        String r3 = hu8.e.d();     // Catch: Throwable -> L5
        nu8.a.a("BootProtectorSettings", "getClearCacheWhiteList json string: ".concat(r3));     // Catch: Throwable -> L5
        List<String> r1 = (List) new Gson().fromJson(r3, new hu8.b().getType());     // Catch: Throwable -> L5
    L7:
        nu8.a.g(mu8.d.a(r1), "[setting] whiteList files path:");
        List<String> r0 = r1;
        if (r0 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == false) goto L16;
        r1 = au8.a.a;
    L16:
        nu8.a.g(mu8.d.a(r1), "[final] whiteList files path:");
        ju8.a.a.a(r1);
        LastException r5 = hu8.e.h();
        if (r5 == null) goto L20;
        String r6 = r5.getExceptionStackTrace();
        if (r6 == null) goto L20;
    L21:
        LastException r7 = hu8.e.h();
        if (r7 == null) goto L24;
        r2 = r7.getCrashType();
    L24:
        int r8 = au8.b.a;
        au8.b.a("bootprotector_execute_clean", com.larus.utils.f.c(new Pair[]{TuplesKt.to("strategy", "aggressive"), TuplesKt.to("white_list", hu8.e.d()), TuplesKt.to("crash_type", r2), TuplesKt.to("crash_stack", StringsKt.take(r6, 4000))}));
        return;
    L20:
        r6 = "";
        goto L21
    L10:
        if (r0.isEmpty() == true) goto L13;
        r4 = false;
    L5:
        th = move-exception;
        nu8.a.f("BootProtectorSettings", th, "getClearCacheWhiteList failed");
        r1 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C1() {
        nu8.a.e("BootProtectorLandingAct", "requestHotFixPatchInternal start");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        int r4 = fu8.b.a;     // Catch: Throwable -> L11
        Application r5 = getApplication();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r5, "application");     // Catch: Throwable -> L11
        nu8.a.e("BootProtectorHotPatch", "initHotFix");     // Catch: Throwable -> L11
        IBootProtectorHotPatch r6 = (IBootProtectorHotPatch) ServiceManager.get().getService(IBootProtectorHotPatch.class);     // Catch: Throwable -> L11
        if (r6 == null) goto L6;
        r6.b(r5);     // Catch: Throwable -> L11
    L6:
        nu8.a.e("BootProtectorHotPatch", "requestHotPatch");     // Catch: Throwable -> L11
        IBootProtectorHotPatch r0 = (IBootProtectorHotPatch) ServiceManager.get().getService(IBootProtectorHotPatch.class);     // Catch: Throwable -> L11
        if (r0 == null) goto L9;
        r0.a();     // Catch: Throwable -> L11
    L9:
        nu8.a.e("BootProtectorLandingAct", "requestHotFixPatchInternal end");     // Catch: Throwable -> L11
        hu8.a.b("bootprotector_hotfix", 1);     // Catch: Throwable -> L11
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L19;
        nu8.a.e("BootProtectorLandingAct", "requestHotFixPatch fail " + r2);
        hu8.a.b("bootprotector_hotfix", 0);
        return;
    L19:
        return;
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final void D1() {
        nu8.a.e("BootProtectorLandingAct", "requestSettingInBootProtectorInternal: start");
        SettingsManager.updateSettings(true);
        e10 r1 = e10.a;
        final BootProtectorConfig r2 = e10.C();
        nu8.a.a("BootProtectorLandingAct", "[requestSettingInBootProtectorInternal]#current bootProtectorConfig: " + r2);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BootProtectorLandingActivity$requestSettingInBootProtectorInternal$1(null), 3, null);
        SettingsManager.registerListener(new c(r2, this), false);
        nu8.a.e("BootProtectorLandingAct", "requestSettingInBootProtectorInternal: end");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F1() {
        int r0 = hu8.e.a;
        Intrinsics.checkNotNullParameter(this, "baseContext");
        hu8.e.a(this, false, "enter_boot_protector");
        hu8.a.b("current_crash_count", 0);
        nu8.a.a("BootProtectorSettings", "clearCrashCount to 0");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
        ObricBootProtectorSPIServiceDelegate.b.a();
        Intrinsics.checkNotNullParameter(this, "<this>");
        nu8.a.e("ProcessUtils", "killAllPackageProcesses");
        Intrinsics.checkNotNullParameter(this, "<this>");
        nu8.a.e("ProcessUtils", "killOtherProcesses");
        int r0 = Process.myPid();
        Object r2 = getSystemService("activity");     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L18
        List<ActivityManager.RunningAppProcessInfo> r3 = ((ActivityManager) r2).getRunningAppProcesses();     // Catch: Throwable -> L18
        if (r3 != null) goto L9;
        r3 = CollectionsKt.emptyList();     // Catch: Throwable -> L18
    L9:
        String r4 = getPackageName();     // Catch: Throwable -> L18
        Iterator<ActivityManager.RunningAppProcessInfo> r5 = r3.iterator();     // Catch: Throwable -> L18
    L10:
        if (r5.hasNext() == false) goto L22;
        ActivityManager.RunningAppProcessInfo r6 = r5.next();     // Catch: Throwable -> L18
        String r7 = r6.processName;     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L18
        if (StringsKt.startsWith$default(r7, r4, false, 2, null) == false) goto L10;
        if (r6.pid == r0) goto L10;
        nu8.a.d("Kill: " + r6.processName + " pid: " + r6.pid);     // Catch: Throwable -> L18
        Process.killProcess(r6.pid);     // Catch: Throwable -> L18
    L22:
        iu8.a.b();
        throw null;
    L18:
        th = move-exception;
        Intrinsics.checkNotNullParameter("Kill", ShareType.TEXT);
        Intrinsics.checkNotNullParameter(th, "throwable");
        FLogger r8 = FLogger.a;
        if (r8.a() == false) goto L22;
        r8.e("bootprotector", "Kill", th);
        goto L22
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0108 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        F1();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public BootProtectorLandingActivity() {
    }

    public final void attachBaseContext(Context r2) {
        super.attachBaseContext(r2);
        nu8.a.e("BootProtectorLandingAct", "attachBaseContext");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r12) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        v19.f.a(getTheme());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r12);
        nu8.a.e("BootProtectorLandingAct", "onCreate");
        if (Intrinsics.areEqual("auto_test", AppHost.a.getBuildChannel()) == false) goto L13;
        finish();
        return;
    L13:
        overridePendingTransition(0, 0);
        ActionBar r1 = getSupportActionBar();
        if (r1 == null) goto L17;
        r1.hide();
    L17:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L19;
        boolean r2 = true;
    L20:
        u.e(this, true, r2);
        u.d(this);
        setContentView(2131561779);
        IBootProtectorLauncher.a.getClass();
        IBootProtectorLauncher.a.b().a(getApplication().getBaseContext());
        IApplog.Companion r3 = IApplog.a;
        if (r3.getDeviceId().length() <= 0) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == false) goto L26;
        C1();
    L28:
        if (r3.getDeviceId().length() <= 0) goto L30;
        boolean r5 = true;
    L31:
        if (r5 == false) goto L33;
        D1();
    L34:
        ThreadMethodProxy.start(new PthreadThreadV2(new d(this), "BootProtectorLandingActivity"));
        onPostResume();
        ObricBootProtectorSPIServiceDelegate r13 = ObricBootProtectorSPIServiceDelegate.b;
        String r6 = r13.e();
        if (r6 != null) goto L37;
        r6 = getResources().getString(2131900176);
    L37:
        String r7 = r13.d();
        if (r7 != null) goto L40;
        r7 = getString(2131900174);
    L40:
        Intrinsics.checkNotNullParameter(r6, "message");
        String r8 = getString(2131900177);
        Intrinsics.checkNotNullParameter(r8, "title");
        j r9 = new j(this);
        Intrinsics.checkNotNullParameter(r9, "listener");
        boolean r14 = !r13.b();
        k r10 = new k(this);
        String r11 = getString(2131900175);
        Intrinsics.checkNotNullParameter(r10, "listener");
        int r15 = ContextCompat.getColor(this, 2131103203);
        Function0<Boolean> r16 = new b(this);
        Intrinsics.checkNotNullParameter(r16, "callback");
        BootProtectorConfirmDialog r17 = new BootProtectorConfirmDialog();
        r17.e = r8;
        r17.g = r6;
        r17.h = r7;
        r17.i = r9;
        r17.j = r14;
        r17.k = r11;
        r17.l = r15;
        r17.m = r10;
        r17.n = r16;
        FragmentManager r18 = getSupportFragmentManager();
        LandscapeRestrictionOperation r19 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        BaseExceptionInfo.Type r20 = null;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r17, null, r19);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r18, r17, r19) == false) goto L56;
    L45:
        Unit r110 = Unit.INSTANCE;
        hu8.a.b("enter_bootprotector_page", 1);
        LastException r21 = hu8.e.h();
        if (r21 == null) goto L49;
        String r22 = r21.getExceptionStackTrace();
        if (r22 == null) goto L49;
    L50:
        LastException r23 = hu8.e.h();
        if (r23 == null) goto L53;
        r20 = r23.getCrashType();
    L53:
        int r24 = au8.b.a;
        au8.b.a("enter_bootprotector_page", com.larus.utils.f.c(new Pair[]{TuplesKt.to("crash_count", Integer.valueOf(hu8.e.g())), TuplesKt.to("crash_type", r20), TuplesKt.to("crash_stack", StringsKt.take(r22, 4000))}));
        ObricBootProtectorSPIServiceDelegate.b.g();
        return;
    L49:
        r22 = "";
        goto L50
    L56:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L55
    L44:
        r17.show(r18, null);
        goto L45
    L33:
        nu8.a.b("BootProtectorLandingAct", "requestSettingInBootProtector: did is empty");
        r3.j(new i(this));
        goto L34
    L30:
        r5 = false;
        goto L31
    L26:
        nu8.a.b("BootProtectorLandingAct", "requestHotFixPatch did is empty");
        r3.j(new h(this));
        goto L28
    L23:
        r4 = false;
        goto L24
    L19:
        r2 = false;
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z1(List<UrgentCmd> r5) {
        String r6 = mu8.d.a(r5);
        nu8.a.e("BootProtectorLandingAct", "executePreciseCleaning: " + r6);
        JsonElement r7 = new JsonParser().parse(r6);     // Catch: Exception -> L7
        if (r7.isJsonArray() == false) goto L9;
        JsonArray r8 = r7.getAsJsonArray();     // Catch: Exception -> L7
        IBootProtectorLauncher.a r0 = IBootProtectorLauncher.a;     // Catch: Exception -> L7
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L7
        r0.getClass();     // Catch: Exception -> L7
        IBootProtectorLauncher.a.a(this, r8);     // Catch: Exception -> L7
    L9:
        LastException r9 = hu8.e.h();
        if (r9 == null) goto L13;
        String r10 = r9.getExceptionStackTrace();
        if (r10 == null) goto L13;
    L14:
        LastException r1 = hu8.e.h();
        if (r1 == null) goto L17;
        BaseExceptionInfo.Type r2 = r1.getCrashType();
    L18:
        int r3 = au8.b.a;
        au8.b.a("bootprotector_execute_clean", com.larus.utils.f.c(new Pair[]{TuplesKt.to("strategy", "precise"), TuplesKt.to("white_list", hu8.e.d()), TuplesKt.to("crash_type", r2), TuplesKt.to("crash_stack", StringsKt.take(r10, 4000))}));
        return;
    L17:
        r2 = null;
    L13:
        r10 = "";
    L7:
        e = move-exception;
        nu8.a.b("BootProtectorLandingAct", "executePreciseCleaning error: " + e.getMessage());
        goto L9
    }
}
