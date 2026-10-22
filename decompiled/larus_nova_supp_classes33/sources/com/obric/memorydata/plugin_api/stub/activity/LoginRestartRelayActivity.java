package com.obric.memorydata.plugin_api.stub.activity;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.capabilitykit.common.UiType;
import com.obric.memorydata.plugin_api.login.LoginRestartRelayProtocol;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nka.a;
import nka.b;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class LoginRestartRelayActivity extends Activity {
    private static final String[] MEMORY_TASK_ACTIVITY_PREFIXES = null;
    private static final int PROCESS_EXIT_POLL_COUNT = 20;
    private static final long PROCESS_EXIT_POLL_INTERVAL_MS = 50;
    private static final String TAG = "LoginRestartRelay";
    private final Handler mainHandler;

    public static /* synthetic */ void a(LoginRestartRelayActivity r0, LoginRestartRelayProtocol.RestoreRequest r1) {
        r0.lambda$onCreate$0(r1);
    }

    public static /* synthetic */ void b(LoginRestartRelayActivity r0, LoginRestartRelayProtocol.RestoreRequest r1) {
        r0.lambda$restartAndRestore$1(r1);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    public void com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity__finish$___twin___() {
        super.finish();
    }

    public void com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    public void finish() {
        com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r1) {
        com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r1);
    }

    @Override // android.app.Activity
    public void onStop() {
        com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    static {
        MEMORY_TASK_ACTIVITY_PREFIXES = new String[]{"com.obric.memorydata.memory.ui.", "com.obric.memorydata.plugin_api.stub.activity."};
    }

    private void clearOtherMemoryTasks() {
        ActivityManager r0 = (ActivityManager) getSystemService(ActivityManager.class);
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<ActivityManager.AppTask> r1 = r0.getAppTasks().iterator();
    L7:
        if (r1.hasNext() == false) goto L19;
        ActivityManager.AppTask r2 = r1.next();
        ActivityManager.RecentTaskInfo r3 = r2.getTaskInfo();     // Catch: RuntimeException -> L18
        if (r3 == null) goto L7;
        if (r3.id == getTaskId()) goto L7;
        if (isMemoryTask(r3) == false) goto L7;
        r2.finishAndRemoveTask();     // Catch: RuntimeException -> L18
        goto L7
    }

    public LoginRestartRelayActivity() {
        this.mainHandler = new Handler(Looper.getMainLooper());
    }

    private void finishRelay() {
        finish();
        overridePendingTransition(0, 0);
    }

    public static View INVOKEVIRTUAL_com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(LoginRestartRelayActivity r1) {
        r1.com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(LoginRestartRelayActivity r11) {
        r11.com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity__finish$___twin___();
        if ((r11 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((r11 instanceof ChatWindowActivity) == false) goto L8;
        return;
    L8:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(r11.getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map<Activity, Long> r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = r5.get(r11);     // Catch: Throwable -> L53
        if (r6 != null) goto L13;
    L16:
        r5.put(r11, Long.valueOf(r3));     // Catch: Throwable -> L53
        monitor-exit(r5);     // Catch: Throwable -> L53
    L50:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L19:
        if (((FragmentActivity) r11).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r2.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) r11).getLifecycle().getCurrentState());     // Catch: Throwable -> L50
        return;
    L23:
        if (r11.isFinishing() == true) goto L27;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L50
        return;
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(r11) == true) goto L31;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L50
        return;
    L31:
        if (ActivityLancet.isOnlyActivityInTask(r11) == true) goto L35;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L50
        return;
    L35:
        if (ActivityLancet.isExcludedActivity(r11) == false) goto L39;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L50
        return;
    L39:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L41;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L50
        return;
    L41:
        Intent r1 = r11.getPackageManager().getLaunchIntentForPackage(r11.getPackageName());     // Catch: Throwable -> L50
        if (r1 != null) goto L44;
        return;
    L44:
        r1.addFlags(268435456);     // Catch: Throwable -> L50
        r1.addFlags(UiType.FLAG_REMOTE_CARD);     // Catch: Throwable -> L50
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r11);     // Catch: Throwable -> L50
        r11.startActivity(r1);     // Catch: Throwable -> L47
        r11.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L47
    L61:
        return;
    L47:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L50
        return;
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    }

    private boolean isMemoryTask(ActivityManager.RecentTaskInfo r3) {
        ComponentName r0 = r3.baseActivity;
        String r1 = null;
        if (r0 != null) goto L5;
        String r2 = null;
    L7:
        if (matchesMemoryActivity(r2) == true) goto L16;
        ComponentName r4 = r3.topActivity;
        if (r4 == null) goto L13;
        r1 = r4.getClassName();
    L13:
        if (matchesMemoryActivity(r1) == true) goto L16;
        return false;
    L16:
        return true;
    L5:
        r2 = r0.getClassName();
        goto L7
    }

    private boolean isProcessRunning(int r4) {
        ActivityManager r0 = (ActivityManager) getSystemService(ActivityManager.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        List<ActivityManager.RunningAppProcessInfo> r1 = r0.getRunningAppProcesses();
        if (r1 != null) goto L8;
        return false;
    L8:
        Iterator<ActivityManager.RunningAppProcessInfo> r2 = r1.iterator();
    L10:
        if (r2.hasNext() == false) goto L15;
        if (r2.next().pid != r4) goto L10;
        return true;
    L15:
        return false;
    }

    private /* synthetic */ void lambda$onCreate$0(LoginRestartRelayProtocol.RestoreRequest r1) {
        restartAndRestore(r1);
    }

    private /* synthetic */ void lambda$restartAndRestore$1(LoginRestartRelayProtocol.RestoreRequest r2) {
        Intent r3 = r2.getIntent();
        if (r3 != null) goto L10;
    L8:
        finishRelay();
        return;
    L10:
        r3.addFlags(268435456);     // Catch: RuntimeException -> L7
        startActivity(r3);     // Catch: RuntimeException -> L7
        goto L8
    }

    private boolean matchesMemoryActivity(String r6) {
        if (r6 != null) goto L5;
    L14:
        return false;
    L5:
        if (r6.isEmpty() == true) goto L14;
        String[] r1 = MEMORY_TASK_ACTIVITY_PREFIXES;
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L14;
        if (r6.startsWith(r1[r3]) == true) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        return true;
    }

    private void restartAndRestore(final LoginRestartRelayProtocol.RestoreRequest r3) {
        int r0 = r3.getSourcePid();
        if (r0 > 0) goto L5;
    L7:
        this.mainHandler.post(new b(this, r3));
        return;
    L5:
        if (r0 == Process.myPid()) goto L7;
        Process.killProcess(r0);
        waitForProcessExit(r0);
        goto L7
    }

    private void waitForProcessExit(int r4) {
        int r0 = 0;
    L4:
        if (r0 >= 20) goto L17;
        if (isProcessRunning(r4) == false) goto L7;
        Thread.sleep(PROCESS_EXIT_POLL_INTERVAL_MS);     // Catch: InterruptedException -> L11
        r0 = r0 + 1;
    L11:
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L7:
        return;
    }

    public void com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        overridePendingTransition(0, 0);
        final LoginRestartRelayProtocol.RestoreRequest r4 = LoginRestartRelayProtocol.consume();     // Catch: RuntimeException -> L9
        if (r4 != null) goto L7;
        finishRelay();
        return;
    L7:
        clearOtherMemoryTasks();
        ThreadMethodProxy.start(new PthreadThreadV2(new a(this, r4), "memory-login-restart"));
        return;
    L9:
        finishRelay();
    }

    public static void com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(LoginRestartRelayActivity r1, Bundle r2) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(r1.getTheme());     // Catch: Throwable -> L10
    L6:
        if (f.f(r1) == false) goto L8;
        f.c(r1.getTheme());     // Catch: Throwable -> L10
    L8:
        r1.com_obric_memorydata_plugin_api_stub_activity_LoginRestartRelayActivity__onCreate$___twin___(r2);
    }
}
