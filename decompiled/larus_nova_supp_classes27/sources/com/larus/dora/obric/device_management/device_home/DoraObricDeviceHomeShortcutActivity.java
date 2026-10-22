package com.larus.dora.obric.device_management.device_home;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002¨\u0006\u001b"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricDeviceHomeShortcutActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "continueEntry", "openAssistantPrerequisiteFlow", "openDeviceHome", "reorderExistingDeviceManagementPageToFront", "", "moveExistingDeviceTaskToFront", "openDeviceHomeWithShortcutEntry", "isRestorableDeviceManagementActivity", "activity", "Landroid/app/Activity;", "buildReorderIntent", "isValidShortcutIntent", "isDesktopShortcutIntent", "finishWithoutAnimation", "finishShortcutTask", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricDeviceHomeShortcutActivity extends ComponentActivity {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static boolean a() {
            if (AppHost.a.isOversea() == true) goto L13;
            ISecPrivacyService.a.getClass();
            ISecPrivacyService r0 = ISecPrivacyService.a.a();
            if (r0 != null) goto L7;
        L9:
            boolean r1 = false;
        L10:
            if (r1 == true) goto L13;
            boolean r2 = false;
        L14:
            if (r2 == true) goto L16;
            return false;
        L16:
            if (AccountService.a.isLogin().booleanValue() == false) goto L20;
            return true;
        L20:
            return false;
        L7:
            if (r0.h() != true) goto L9;
            r1 = true;
        L13:
            r2 = true;
            goto L14
        }

        public static Uri c() {
            return UriProtector.parse("//flow/dora/obric_device_home").buildUpon().appendQueryParameter("is_from_outer", "true").appendQueryParameter("start_from", "desktop_shortcut").appendQueryParameter(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "desktop_shortcut").build();
        }

        public static Intent b(Context r2, Intent r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intent r0 = new Intent(r2, DoraObricDeviceHomeActivity.class);
            r0.setAction("android.intent.action.VIEW");
            int r4 = DoraObricDeviceHomeShortcutActivity.a;
            r0.setData(c());
            r0.addFlags(335544320);
            if (r3 == null) goto L7;
            Bundle r5 = r3.getExtras();
            if (r5 == null) goto L7;
            r0.putExtras(r5);
        L7:
            r0.putExtra("start_from", "desktop_shortcut");
            r0.putExtra(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "desktop_shortcut");
            return r0;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A1() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        startActivity(a.b(this, getIntent()));     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L12;
        g49.d.b("DoraObricHomeShortcut", "openDeviceHome failed, message=" + r2.getMessage());
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0112 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DoraObricDeviceHomeShortcutActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L48
        if (r6 != null) goto L13;
    L16:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L48
        monitor-exit(r5);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r2.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L51;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(2097152);     // Catch: Throwable -> L45
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*android.app.Activity*/.onStop();
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void w1() {
        if (a.a() == true) goto L21;
        g49.d.d("DoraObricHomeShortcut", "shortcut entry prerequisites are not satisfied");
        g49.d.d("DoraObricHomeShortcut", "openAssistantPrerequisiteFlow");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L12
        int r1 = DoraObricDeviceHomePrivacyGateActivity.c;     // Catch: Throwable -> L12
        Intent r2 = getIntent();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(this, "context");     // Catch: Throwable -> L12
        Intent r3 = new Intent(this, DoraObricDeviceHomePrivacyGateActivity.class);     // Catch: Throwable -> L12
        if (r2 == null) goto L10;
        Bundle r4 = r2.getExtras();     // Catch: Throwable -> L12
        if (r4 == null) goto L10;
        r3.putExtras(r4);     // Catch: Throwable -> L12
    L10:
        r3.putExtra("start_from", "desktop_shortcut");     // Catch: Throwable -> L12
        r3.putExtra(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "desktop_shortcut");     // Catch: Throwable -> L12
        startActivity(r3);     // Catch: Throwable -> L12
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L18;
        g49.d.b("DoraObricHomeShortcut", "openAssistantPrerequisiteFlow failed, message=" + r6.getMessage());
    L18:
        if (isFinishing() == true) goto L110;
        finish();
        overridePendingTransition(0, 0);
        return;
    L110:
        return;
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L21:
        com.larus.dora.impl.device.s0 r8 = com.larus.dora.impl.device.s0.a;
        Bundle r9 = getIntent().getExtras();
        r8.getClass();
        if (com.larus.dora.impl.device.s0.b("//flow/dora/obric_device_home", r9) == true) goto L27;
        g49.d.d("DoraObricHomeShortcut", "shortcut entry denied by device management route policy");
        com.larus.dora.impl.device.s0.c(this, "//flow/dora/obric_device_home", getIntent().getExtras());
        if (isFinishing() == true) goto L111;
        finish();
        overridePendingTransition(0, 0);
        return;
    L111:
        return;
    L27:
        g49.d.d("DoraObricHomeShortcut", "shortcut entry opens Obric device home");
        g49.d.d("DoraObricHomeShortcut", "openDeviceHome taskId=" + getTaskId());
        Iterator r10 = CollectionsKt.asReversed(AppHost.a.a().g()).iterator();
    L28:
        boolean r11 = true;
        Object r12 = null;
        if (r10.hasNext() == false) goto L38;
        Object r13 = r10.next();
        Activity r14 = (Activity) r13;
        if (r14.getTaskId() == getTaskId()) goto L33;
    L35:
        boolean r15 = false;
    L36:
        if (r15 == false) goto L28;
    L39:
        Activity r16 = (Activity) r13;
        if (r16 != null) goto L43;
        boolean r17 = false;
    L47:
        if (r17 == true) goto L90;
        Iterator r18 = CollectionsKt.asReversed(AppHost.a.a().g()).iterator();
    L50:
        if (r18.hasNext() == false) goto L59;
        Object r20 = r18.next();
        Activity r21 = (Activity) r20;
        if (r21.getTaskId() != getTaskId()) goto L54;
    L56:
        boolean r22 = false;
    L57:
        if (r22 == false) goto L50;
    L60:
        Activity r23 = (Activity) r20;
        if (r23 != null) goto L64;
    L85:
        r11 = false;
    L86:
        if (r11 == true) goto L90;
        A1();
        goto L90
    L64:
        if ((r23 instanceof DoraObricDeviceHomeActivity) == false) goto L66;
        A1();
        goto L86
    L66:
        Object r24 = getSystemService("activity");
        if ((r24 instanceof ActivityManager) == false) goto L69;
        ActivityManager r25 = (ActivityManager) r24;
    L70:
        if (r25 == null) goto L85;
        List<ActivityManager.AppTask> r26 = r25.getAppTasks();
        if (r26 == null) goto L85;
        Iterator<T> r27 = r26.iterator();
    L75:
        if (r27.hasNext() == false) goto L82;
        Object r28 = r27.next();
        if (((ActivityManager.AppTask) r28).getTaskInfo().id != r23.getTaskId()) goto L79;
        boolean r30 = true;
    L80:
        if (r30 == false) goto L75;
        r12 = r28;
        goto L82
    L79:
        r30 = false;
    L82:
        ActivityManager.AppTask r31 = (ActivityManager.AppTask) r12;
        if (r31 == null) goto L85;
        g49.d.d("DoraObricHomeShortcut", "move existing device task to front taskId=" + r23.getTaskId() + " activity=" + r23.getClass().getName());
        r31.moveToFront();
        finishAndRemoveTask();
        goto L86
    L69:
        r25 = null;
        goto L70
    L54:
        if (y1(r21) == false) goto L56;
        r22 = true;
        goto L57
    L59:
        r20 = null;
    L90:
        if (isFinishing() == true) goto L112;
        finish();
        overridePendingTransition(0, 0);
        return;
    L112:
        return;
    L43:
        if ((r16 instanceof DoraObricDeviceHomeActivity) == false) goto L45;
        A1();
    L46:
        r17 = true;
        goto L47
    L45:
        g49.d.d("DoraObricHomeShortcut", "reorder existing device management page=".concat(r16.getClass().getName()));
        Intent r32 = new Intent();
        r32.setComponent(r16.getComponentName());
        r32.setFlags(537001984);
        startActivity(r32);
        goto L46
    L33:
        if (y1(r14) == false) goto L35;
        r15 = true;
        goto L36
    L38:
        r13 = null;
        goto L39
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x1() {
        if (isFinishing() == false) goto L6;
        return;
    L6:
        if (isTaskRoot() == false) goto L8;
        finishAndRemoveTask();
    L9:
        overridePendingTransition(0, 0);
        return;
    L8:
        moveTaskToBack(true);
        finish();
        goto L9
    }

    public DoraObricDeviceHomeShortcutActivity() {
    }

    public static boolean z1(Intent r6) {
        if (r6 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r6.getAction(), "android.intent.action.VIEW") == true) goto L8;
        return false;
    L8:
        Uri r1 = r6.getData();
        if (r1 == null) goto L15;
        String r2 = r1.toString();
        if (r2 == null) goto L15;
        if (StringsKt.startsWith$default(r2, "//flow/dora/obric_device_home", false, 2, null) != true) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
    L24:
        return true;
    L18:
        if (Intrinsics.areEqual(r6.getStringExtra("start_from"), "desktop_shortcut") == true) goto L20;
    L22:
        boolean r7 = false;
    L23:
        if (r7 == true) goto L24;
        return false;
    L20:
        if (Intrinsics.areEqual(r6.getStringExtra(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD), "desktop_shortcut") == false) goto L22;
        r7 = true;
    L15:
        r3 = false;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        if (com.larus.platform.service.z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r3);
        if (z1(getIntent()) == true) goto L20;
        StringBuilder r4 = new StringBuilder("ignore invalid shortcut intent action=");
        Intent r0 = getIntent();
        Uri r1 = null;
        if (r0 == null) goto L15;
        String r2 = r0.getAction();
    L16:
        r4.append(r2);
        r4.append(" data=");
        Intent r5 = getIntent();
        if (r5 == null) goto L19;
        r1 = r5.getData();
    L19:
        r4.append(r1);
        g49.d.d("DoraObricHomeShortcut", r4.toString());
        x1();
        return;
    L15:
        r2 = null;
        goto L16
    L20:
        w1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNewIntent(Intent r3) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        super.onNewIntent(r3);
        setIntent(r3);
        if (z1(r3) == true) goto L6;
        g49.d.d("DoraObricHomeShortcut", "ignore invalid shortcut intent action=" + r3.getAction() + " data=" + r3.getData());
        x1();
        return;
    L6:
        w1();
    }

    public final boolean y1(Activity r6) {
        if (r6 != this) goto L5;
        return false;
    L5:
        if ((r6 instanceof DoraObricDeviceHomeShortcutActivity) == false) goto L7;
        return false;
    L7:
        if (StringsKt.startsWith$default(r6.getClass().getName(), "com.larus.dora.obric.device_management.", false, 2, null) == true) goto L9;
        return false;
    L9:
        if (r6.isFinishing() == false) goto L11;
        return false;
    L11:
        if (r6.isDestroyed() == true) goto L18;
        return true;
    L18:
        return false;
    }
}
