package com.obric.memorydata.plugin_api.stub.activity;

import android.R;
import android.content.Intent;
import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.memorydata.plugin_api.MemoryPlugin;
import com.volcengine.zeus.activity.GenerateProxyActivity;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class MemoryBaseActivity extends GenerateProxyActivity {
    public void com_obric_memorydata_plugin_api_stub_activity_MemoryBaseActivity__finish$___twin___() {
        super.finish();
    }

    public void finish() {
        com_obric_memorydata_plugin_api_stub_activity_MemoryBaseActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    public String getPluginPkgName() {
        return MemoryPlugin.PLUGIN_PKG_NAME;
    }

    public MemoryBaseActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void com_obric_memorydata_plugin_api_stub_activity_MemoryBaseActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(MemoryBaseActivity r11) {
        r11.com_obric_memorydata_plugin_api_stub_activity_MemoryBaseActivity__finish$___twin___();
        if ((r11 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((r11 instanceof ChatWindowActivity) == false) goto L8;
        return;
    L8:
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(r11.getClass().getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(r11);     // Catch: Throwable -> L53
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
        r1.addFlags(2097152);     // Catch: Throwable -> L50
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
}
