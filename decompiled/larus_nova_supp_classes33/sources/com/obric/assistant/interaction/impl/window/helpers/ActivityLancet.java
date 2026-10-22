package com.obric.assistant.interaction.impl.window.helpers;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.capabilitykit.common.UiType;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class ActivityLancet {
    public static final long FINISH_DEDUP_WINDOW_MS = 800;
    public static final Map<Activity, Long> LAST_FINISH_HANDLED_MS = null;
    private static final String TAG = "ActivityLancet";

    public ActivityLancet() {
    }

    static {
        LAST_FINISH_HANDLED_MS = Collections.synchronizedMap(new WeakHashMap());
    }

    public static void postPopWindowAfterInternalActivityFinish() {
        t0.a.post(new AnonymousClass1());
    }

    public void finish() {
        Origin.callVoid();
        Object r2 = This.get();
        if ((r2 instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((r2 instanceof ChatWindowActivity) == false) goto L8;
        return;
    L8:
        FLogger r3 = FLogger.a;
        r3.i(TAG, "finish ".concat(r2.getClass().getName()));
        FragmentActivity r4 = (Activity) r2;
        long r5 = SystemClock.uptimeMillis();
        Map<Activity, Long> r6 = LAST_FINISH_HANDLED_MS;
        monitor-enter(r6);
        Long r7 = r6.get(r4);     // Catch: Throwable -> L53
        if (r7 != null) goto L13;
    L16:
        r6.put(r4, Long.valueOf(r5));     // Catch: Throwable -> L53
        monitor-exit(r6);     // Catch: Throwable -> L53
    L50:
        th = move-exception;
        FLogger.a.e(TAG, "handle onBackPressed strategy failed", th);
        return;
    L19:
        if (r4.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L23;
        r3.i(TAG, "quit !resume, current state = " + r4.getLifecycle().getCurrentState());     // Catch: Throwable -> L50
        return;
    L23:
        if (r4.isFinishing() == true) goto L27;
        r3.i(TAG, "quit !isFinishing");     // Catch: Throwable -> L50
        return;
    L27:
        if (ActivityStartBehavior.isInternalActivityConsumed(r4) == true) goto L31;
        r3.i(TAG, "quit !isInternalActivityConsumed");     // Catch: Throwable -> L50
        return;
    L31:
        if (isOnlyActivityInTask(r4) == true) goto L35;
        r3.i(TAG, "quit !isOnlyActivityInTask");     // Catch: Throwable -> L50
        return;
    L35:
        if (isExcludedActivity(r4) == false) goto L39;
        r3.i(TAG, "quit isExcludedActivity");     // Catch: Throwable -> L50
        return;
    L39:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L41;
        postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L50
        return;
    L41:
        Intent r1 = r4.getPackageManager().getLaunchIntentForPackage(r4.getPackageName());     // Catch: Throwable -> L50
        if (r1 != null) goto L44;
        return;
    L44:
        r1.addFlags(268435456);     // Catch: Throwable -> L50
        r1.addFlags(UiType.FLAG_REMOTE_CARD);     // Catch: Throwable -> L50
        r3.i(TAG, "start launcher intent after backPressed, activity=" + r4);     // Catch: Throwable -> L50
        r4.startActivity(r1);     // Catch: Throwable -> L47
        r4.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L47
    L61:
        return;
    L47:
        th = move-exception;
        FLogger.a.e(TAG, "startActivity launcher intent failed", th);     // Catch: Throwable -> L50
        return;
    L13:
        if ((r5 - r7.longValue()) >= 800) goto L16;
        monitor-exit(r6);     // Catch: Throwable -> L53
        return;
    L53:
        th = move-exception;
        throw th;
    }

    public void onDestroy() {
        Object r0 = This.get();
        if ((r0 instanceof FragmentActivity) == false) goto L7;
        FragmentActivity r2 = (FragmentActivity) r0;
        if (WindowUtils.INSTANCE.isMainBotActivity(r2) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r2);
        FLogger.a.i(TAG, "clear tracked overlays onDestroy activity = ".concat(((Activity) r0).getClass().getName()));
    L7:
        Origin.callVoid();
    }

    public static boolean isExcludedActivity(Activity r2) {
        String r0 = HomeServiceV2.a.a();     // Catch: Throwable -> L4
    L5:
        if (r0 == null) goto L11;
        if (r0.equals(r2.getClass().getName()) == false) goto L11;
        return true;
    L11:
        return ObricChatContextServiceDelegate.b.e(r2);
    L4:
        r0 = null;
        goto L5
    }

    public static boolean isOnlyActivityInTask(Activity r5) {
        int r0 = r5.getTaskId();
        if (r0 >= 0) goto L35;
        return false;
    L35:
        List r2 = AppHost.a.a().g();     // Catch: Throwable -> L32
        if (r2 == null) goto L31;
        if (r2.isEmpty() == true) goto L31;
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L29;
        Activity r4 = (Activity) r3.next();
        if (r4 == null) goto L12;
        if (r4 == r5) goto L12;
        if (r4.getTaskId() != r0) goto L12;
        if (r4.isFinishing() == true) goto L12;
        boolean r6 = r4.isDestroyed();     // Catch: Throwable -> L25
    L26:
        if (r6 == true) goto L12;
        return false;
    L25:
        r6 = false;
        goto L26
    L29:
        return true;
    L31:
        return false;
    }
}
