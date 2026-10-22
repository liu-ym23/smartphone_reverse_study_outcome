package com.ss.android.lark.framework.assembly.featuregating;

import android.content.Context;
import com.google.gson.Gson;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.ApkUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.util.share_preference.UserSP;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import ndb.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class FeatureGatingReportTrackerTask extends AsyncLaunchTask {

    public class a implements y {

        /* JADX INFO: renamed from: com.ss.android.lark.framework.assembly.featuregating.FeatureGatingReportTrackerTask$a$a, reason: collision with other inner class name */
        public class RunnableC0080a implements Runnable {
            @Override // java.lang.Runnable
            public final void run() {
                ndb.c r0 = ndb.c.b.a;     // Catch: Throwable -> L10
                Object r1 = r0.e;     // Catch: Throwable -> L10
                monitor-enter(r1);     // Catch: Throwable -> L10
                r0.c();     // Catch: Throwable -> L7
                monitor-exit(r1);     // Catch: Throwable -> L7
            L13:
                return;
            L7:
                th = move-exception;
                throw th;     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L19;
                throw th;
            }

            public RunnableC0080a() {
            }
        }

        public a() {
        }

        public final void f(y.a r2, y.a r3) {
            if (r3.c == false) goto L5;
            return;
        L5:
            if (r2.c == false) goto L9;
            Log.i("FeatureGatingReportTrackerTask", "app change to background, updateSpBeanSet start");
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new RunnableC0080a());
            Log.i("FeatureGatingReportTrackerTask", "onActivityResumed, updateSpBeanSet start");
            return;
        }
    }

    public class b implements Runnable {
        public static void a() {
            Log.i("FeatureGatingReportTrackerTask", "enable scheduled reportTrack");
            ndb.c r0 = ndb.c.b.a;
            r0.getClass();
            String r1 = FeatureGatingModule.getDependency().getUserId();
            int r2 = ApkUtil.getAppVersionCode(FeatureGatingModule.getDependency().getContext());
            int r3 = pdb.a.b(r1).getInt("last_app_version", 0);
            pdb.a.b(r1).putInt("last_app_version", r2);
            if (r2 == r3) goto L6;
            if (r3 == 0) goto L6;
            UserSP.getInstance().remove("user_sp_fg_params");
        L11:
            boolean r4 = false;
        L13:
            if (r4 == false) goto L49;
            Log.i("FeatureGatingReportTrackerTask", "reportTrack start");
            Object r5 = r0.e;     // Catch: Exception -> L37
            monitor-enter(r5);     // Catch: Exception -> L37
            r0.c();     // Catch: Throwable -> L34
            Gson r6 = new Gson();     // Catch: Throwable -> L34
            Set r7 = ndb.c.a();     // Catch: Throwable -> L34
            HashSet r8 = new HashSet();     // Catch: Throwable -> L34
            HashSet r9 = new HashSet();     // Catch: Throwable -> L34
            Iterator r10 = ((HashSet) r7).iterator();     // Catch: Throwable -> L34
        L18:
            int r11 = 0;
        L20:
            if (r10.hasNext() == false) goto L25;
            r9.add((d) r10.next());     // Catch: Throwable -> L34
            r11 = r11 + 1;     // Catch: Throwable -> L34
            if (r11 != r0.d) goto L20;
            r8.add(r9);     // Catch: Throwable -> L34
            r9 = new HashSet();     // Catch: Throwable -> L34
            goto L18
        L25:
            if (r9.size() <= 0) goto L27;
            r8.add(r9);     // Catch: Throwable -> L34
        L27:
            Iterator r12 = r8.iterator();     // Catch: Throwable -> L34
        L29:
            if (r12.hasNext() == false) goto L31;
            String r13 = r6.toJson((Set) r12.next());     // Catch: Throwable -> L34
            JSONObject r14 = new JSONObject();     // Catch: Throwable -> L34
            r14.put("fg_params", r13);     // Catch: Throwable -> L34
            FeatureGatingModule.getDependency().sendEvent("fg_use_client", r14);     // Catch: Throwable -> L34
            Log.i("FeatureGatingTracker", "reportTrack success, params:" + r14.toString());     // Catch: Throwable -> L34
            goto L29
        L31:
            UserSP.getInstance().remove("user_sp_fg_params");     // Catch: Throwable -> L34
            pdb.a.b(FeatureGatingModule.getDependency().getUserId()).putLong("fg_report_time_stamp", System.currentTimeMillis());     // Catch: Throwable -> L34
            monitor-exit(r5);     // Catch: Throwable -> L34
        L39:
            Log.i("FeatureGatingReportTrackerTask", "reportTrack finish");
            return;
        L34:
            th = move-exception;
            throw th;     // Catch: Exception -> L37
        L37:
            e = move-exception;
            Log.e("FeatureGatingTracker", "reportTrack error", e, true);
            goto L39
        L49:
            return;
        L6:
            long r15 = pdb.a.b(r1).getLong("fg_report_time_stamp", 0);
            if (r15 != 0) goto L10;
        L12:
            r4 = true;
            goto L13
        L10:
            if ((System.currentTimeMillis() - r15) >= 3600000) goto L12;
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b() {
        }
    }

    public FeatureGatingReportTrackerTask() {
    }

    public final void a(Context r8) {
        AppLifecycle.a.a.c(new a());
        CoreThreadPool.getDefault().getScheduleThreadPool().scheduleAtFixedRate(new b(), 0, 3600000, TimeUnit.MILLISECONDS);
    }
}
