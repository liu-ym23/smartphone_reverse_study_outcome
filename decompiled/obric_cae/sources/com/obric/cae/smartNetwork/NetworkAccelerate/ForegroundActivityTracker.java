package com.obric.cae.smartNetwork.NetworkAccelerate;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluateObserver;
import ha.m;
import ha.p;
import ha.s;
import ha.u;
import ia.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l6.a;

/* JADX INFO: loaded from: classes2.dex */
public final class ForegroundActivityTracker {
    private static volatile String LAST_ACTIVITY = "";
    private static final String TAG = "ForegroundActivityTracker";
    private static volatile Map<String, Set<String>> sActivitiesByPkg;

    public static class WhiteItem {

        @b("acc_activities")
        List<String> activities;

        @b("package_name")
        String packageName;

        private WhiteItem() {
        }
    }

    public static class WhiteRoot {

        @b("accelerate_app_whitelist")
        List<WhiteItem> accAppWhitelist;

        private WhiteRoot() {
        }
    }

    public ForegroundActivityTracker() {
    }

    private static void ensureLoaded(Context r8) {
        if (sActivitiesByPkg == null) goto L6;
        return;
    L6:
        monitor-enter(ForegroundActivityTracker.class);
    L53:
        th = move-exception;
        throw th;
    L8:
        if (sActivitiesByPkg == null) goto L11;
        monitor-exit(ForegroundActivityTracker.class);     // Catch: Throwable -> L53
        return;
    L11:
        HashMap r10 = new HashMap();     // Catch: Throwable -> L53
        p r11 = a.z0(L4NetEvaluateObserver.getInstance(r8).getAccelerateAppWhitelistJson());     // Catch: Throwable -> L49
        if ((r11 instanceof s) == false) goto L50;
        m r12 = r11.f().q("accelerate_app_whitelist");     // Catch: Throwable -> L49
        if (r12 == null) goto L47;
        Iterator<p> r13 = r12.iterator();     // Catch: Throwable -> L49
    L18:
        if (r13.hasNext() == false) goto L50;
        p r14 = r13.next();     // Catch: Throwable -> L49
        if (r14 == null) goto L18;
        if ((r14 instanceof s) == false) goto L18;
        s r15 = r14.f();     // Catch: Throwable -> L49
        p r16 = r15.p("package_name");     // Catch: Throwable -> L49
        m r17 = r15.q("acc_activities");     // Catch: Throwable -> L49
        if (r16 == null) goto L18;
        if ((r16 instanceof u) == false) goto L18;
        if (r17 == null) goto L18;
        String r18 = r16.j();     // Catch: Throwable -> L49
        HashSet r19 = new HashSet();     // Catch: Throwable -> L49
        Iterator<p> r20 = r17.iterator();     // Catch: Throwable -> L49
    L30:
        if (r20.hasNext() == false) goto L46;
        p r21 = r20.next();     // Catch: Throwable -> L49
        if (r21 == null) goto L30;
        if ((r21 instanceof u) == false) goto L40;
        if ((r21.g().f8004a instanceof String) == false) goto L40;
    L45:
        r19.add(r21.j());     // Catch: Throwable -> L49
    L40:
        if ((r21 instanceof s) == false) goto L30;
        r21 = r21.f().p("activity");     // Catch: Throwable -> L49
        if (r21 == null) goto L30;
        if ((r21 instanceof u) == false) goto L30;
    L46:
        r10.put(r18, r19);     // Catch: Throwable -> L49
        goto L18
    L47:
        CaeLog.i(TAG, "accelerate_app_whitelist is null");     // Catch: Throwable -> L49
    L50:
        sActivitiesByPkg = r10;     // Catch: Throwable -> L53
        monitor-exit(ForegroundActivityTracker.class);     // Catch: Throwable -> L53
        return;
    L49:
        r10.clear();     // Catch: Throwable -> L53
        goto L50
    }

    private static String getTopActivityClassName(Context r8) {
        ActivityManager r10 = (ActivityManager) r8.getSystemService("activity");
        if (r10 != null) goto L18;
        return null;
    L18:
        List<ActivityManager.RunningTaskInfo> r11 = r10.getRunningTasks(1);     // Catch: Throwable -> L17
        if (r11 == null) goto L16;
        if (r11.isEmpty() == true) goto L16;
        ComponentName r12 = r11.get(0).topActivity;
        if (r12 != null) goto L15;
        return null;
    L15:
        return r12.getClassName();
    L16:
        return null;
    }

    public static boolean isForegroundActivityTarget(Context r8, String r10) {
        String r11 = getTopActivityClassName(r8);
        if (r11 == null) goto L8;
        if (r11.equals(LAST_ACTIVITY) == true) goto L8;
        CaeLog.i(TAG, "top activity: ".concat(r11));
        LAST_ACTIVITY = r11;
    L8:
        if (r11 != null) goto L10;
        return false;
    L10:
        ensureLoaded(r8);
        if (r10 != null) goto L13;
    L20:
        return false;
    L13:
        if (sActivitiesByPkg == null) goto L20;
        Set<String> r12 = sActivitiesByPkg.get(r10);
        if (r12 != null) goto L19;
        return false;
    L19:
        return r12.contains(r11);
    }
}
