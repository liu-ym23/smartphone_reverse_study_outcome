package o89;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.bytedance.ai.applet.app.AppletFullScreenActivity;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.e_commerce.impl.applet.PageState;
import com.larus.settings.value.b1;
import com.larus.settings.value.e10;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q {
    public static final AtomicBoolean a = null;
    public static PageState b;
    public static Class<? extends Activity> c;
    public static long d;
    public static String e;
    public static boolean f;
    public static int g;
    public static String h;
    public static String i;
    public static final List<String> j = null;
    public static final Set<String> k = null;
    public static final Map<Activity, String> l = null;
    public static final a m = null;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r6) {
            Intrinsics.checkNotNullParameter(r6, "activity");
            AtomicBoolean r0 = q.a;
            if (q.f(r6) == false) goto L5;
            return;
        L5:
            String r1 = q.l.remove(r6);
            if (r1 != null) goto L9;
            FLogger.a.i("ECAppletStackManager", "onDestroy page not found, page_id=" + q.g + ", size=" + ((ArrayList) q.j).size());
            return;
        L9:
            Set<String> r3 = q.k;
            if (r3.remove(r1) == false) goto L14;
            FLogger.a.i("ECAppletStackManager", "onDestroy is pending recreate page, page_id=" + q.g + ", size=" + ((ArrayList) q.j).size());
            return;
        L14:
            if (q.f == false) goto L17;
            return;
        L17:
            if (r6.isFinishing() == true) goto L19;
        L23:
            FLogger r2 = FLogger.a;
            StringBuilder r4 = new StringBuilder("onDestroy, page_id=");
            r4.append(q.g);
            r4.append(", size=");
            ArrayList r5 = (ArrayList) q.j;
            r4.append(r5.size());
            r2.i("ECAppletStackManager", r4.toString());
            if (r5.isEmpty() == false) goto L27;
            c.a(r6);
            q.i();
            return;
        L27:
            return;
        L19:
            if (r6.isChangingConfigurations() == true) goto L23;
            r3.remove(r1);
            List<String> r7 = q.j;
            ((ArrayList) r7).remove(r1);
            if (Intrinsics.areEqual(q.h, r1) == false) goto L23;
            q.h = (String) CollectionsKt.lastOrNull(r7);
            goto L23
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r5) {
            Intrinsics.checkNotNullParameter(r5, "activity");
            AtomicBoolean r0 = q.a;
            if (q.f(r5) == false) goto L6;
            return;
        L6:
            if (q.a(r5) == false) goto L23;
            int r1 = c.a;
            if (r5 == null) goto L23;
            if (q.f(r5) == true) goto L23;
            if (b.c() == false) goto L23;
            int r2 = x89.a.a;
            if (Build.VERSION.SDK_INT < 30) goto L19;
            r5.setTranslucent(false);     // Catch: Throwable -> L21
        L30:
            goto L23
        L19:
            Method r3 = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);     // Catch: Throwable -> L21
            r3.setAccessible(true);     // Catch: Throwable -> L21
            r3.invoke(r5, new Object[0]);     // Catch: Throwable -> L21
        L23:
            if (q.a(r5) == true) goto L25;
            return;
        L25:
            if (r5.isFinishing() == false) goto L34;
            c.a(r5);
            if (q.f == true) goto L35;
            r.a.getClass();
            JSONObject r6 = new JSONObject();
            r6.putOpt("exit_method", "other");
            Unit r4 = Unit.INSTANCE;
            r.a("exit_doubao_apps", r6);
            return;
        L35:
            return;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            AtomicBoolean r0 = q.a;
            if (q.f(r3) == false) goto L5;
            return;
        L5:
            String r1 = (String) ((LinkedHashMap) q.l).get(r3);
            if (r1 == null) goto L9;
            q.h = r1;
            q.k.remove(r1);
            q.b(r1);
        L9:
            if (q.b == PageState.CREATED) goto L11;
            return;
        L11:
            if (q.c != null) goto L13;
        L15:
            boolean r4 = false;
        L16:
            if (r4 == false) goto L20;
            FLogger.a.i("ECAppletStackManager", "origin resumed, reset applet stack, stack=" + q.j);
            q.i();
            return;
        L20:
            return;
        L13:
            if (Intrinsics.areEqual(r3.getClass(), q.c) == false) goto L15;
            r4 = true;
            goto L16
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r12, Bundle r13) {
            Intrinsics.checkNotNullParameter(r12, "activity");
            AtomicBoolean r1 = q.a;
            if (q.f(r12) == false) goto L6;
            return;
        L6:
            if (r13 == null) goto L12;
            String r14 = r13.getString("ec_applet_page_id");
            if (r14 == null) goto L12;
            if (((ArrayList) q.j).contains(r14) == false) goto L12;
        L14:
            if (r14 == null) goto L16;
        L26:
            if (r14 != null) goto L28;
            StringBuilder r15 = new StringBuilder("ec_applet_page_");
            int r5 = q.g + 1;
            q.g = r5;
            r15.append(r5);
            r15.append('_');
            r15.append(System.currentTimeMillis());
            r14 = r15.toString();
            ((ArrayList) q.j).add(r14);
        L28:
            FLogger.a.i("ECAppletStackManager", "onCreate, page_id=" + q.g + ", size=" + ((ArrayList) q.j).size());
            q.h = r14;
            q.l.put(r12, r14);
            q.k.remove(r14);
            q.b(r14);
            if (q.i != null) goto L76;
            q.i = r14;
            q.b = PageState.CREATED;
            int r16 = c.a;
            if (r12 != null) goto L34;
        L39:
            if (r12 != null) goto L42;
        L68:
            AtomicBoolean r17 = q.a;
            q.h("created");
            return;
        L42:
            if (q.f(r12) == true) goto L68;
            if (b.c() == false) goto L68;
            int r18 = x89.a.a;
            Intrinsics.checkNotNullParameter(r12, "activity");
            if (Build.VERSION.SDK_INT < 30) goto L71;
            r12.setTranslucent(true);
        L67:
            r12.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            goto L68
        L71:
            Method r110 = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);     // Catch: Throwable -> L70
            if (r110 == null) goto L52;
            r110.setAccessible(true);     // Catch: Throwable -> L70
        L52:
            if (r110 == null) goto L54;
            Object r111 = r110.invoke(r12, new Object[0]);     // Catch: Throwable -> L70
        L55:
            Class<?>[] r0 = Activity.class.getDeclaredClasses();     // Catch: Throwable -> L70
            int r4 = r0.length;     // Catch: Throwable -> L70
            Class<?> r6 = null;
            int r7 = 0;
        L57:
            if (r7 >= r4) goto L62;
            Class<?> r8 = r0[r7];     // Catch: Throwable -> L70
            if (StringsKt.contains$default(r8.getSimpleName(), "TranslucentConversionListener", false, 2, null) == false) goto L61;
            r6 = r8;
        L61:
            r7 = r7 + 1;     // Catch: Throwable -> L70
            goto L57
        L62:
            Method r2 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{r6, ActivityOptions.class});     // Catch: Throwable -> L70
            if (r2 == null) goto L65;
            r2.setAccessible(true);     // Catch: Throwable -> L70
        L65:
            if (r2 == null) goto L67;
            r2.invoke(r12, new Object[]{null, r111});     // Catch: Throwable -> L70
            goto L67
        L54:
            r111 = null;
            goto L55
        L34:
            if (q.f(r12) == true) goto L39;
            if (b.c() == false) goto L39;
            r12.overridePendingTransition(2130772626, 0);
            goto L39
        L76:
            return;
        L16:
            if (q.b != PageState.CREATED) goto L26;
            if (q.c != null) goto L20;
        L22:
            boolean r9 = false;
        L23:
            if (r9 == false) goto L26;
            FLogger.a.i("ECAppletStackManager", "origin created, reset applet stack, stack=" + q.j);
            q.i();
            return;
        L20:
            if (Intrinsics.areEqual(r12.getClass(), q.c) == false) goto L22;
            r9 = true;
        L12:
            r14 = null;
            goto L14
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
            AtomicBoolean r0 = q.a;
            if (q.f(r2) == false) goto L5;
            return;
        L5:
            String r4 = (String) ((LinkedHashMap) q.l).get(r2);
            if (r4 == null) goto L9;
            r3.putString("ec_applet_page_id", r4);
            q.k.add(r4);
            return;
        }
    }

    public q() {
    }

    static {
        a = new AtomicBoolean(false);
        b = PageState.UNKNOWN;
        d = System.currentTimeMillis();
        j = new ArrayList();
        k = new LinkedHashSet();
        l = new LinkedHashMap();
        m = new a();
    }

    public static boolean d() {
        if (f(AppHost.a.a().getCurrentActivity()) == false) goto L7;
        return true;
    L7:
        return a.get();
    }

    public static boolean g() {
        if (f(AppHost.a.a().getCurrentActivity()) == false) goto L6;
        return false;
    L6:
        if (b != PageState.GOING) goto L8;
    L11:
        return true;
    L8:
        if (b == PageState.CREATED) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(h, i) == true) goto L11;
        return false;
    }

    public static void i() {
        FLogger.a.i("ECAppletStackManager", "reset");
        b = PageState.UNKNOWN;
        c = null;
        e = null;
        f = false;
        g = 0;
        h = null;
        i = null;
        ((ArrayList) j).clear();
        k.clear();
        ((LinkedHashMap) l).clear();
        AppHost.a.getApplication().unregisterActivityLifecycleCallbacks(m);
        p.a = null;
        p.b = false;
        a.set(false);
    }

    public static final boolean a(Activity r2) {
        String r3 = (String) ((LinkedHashMap) l).get(r2);
        if (r3 != null) goto L6;
    L10:
        return false;
    L6:
        if (b != PageState.CREATED) goto L10;
        if (Intrinsics.areEqual(r3, i) == false) goto L10;
        return true;
    }

    public static final void b(String r5) {
        List<String> r0 = j;
        ArrayList r1 = (ArrayList) r0;
        int r2 = r1.indexOf(r5);
        if (r2 >= 0) goto L5;
        return;
    L5:
        if (r2 == CollectionsKt.getLastIndex(r0)) goto L10;
        int r3 = r2 + 1;
        List r4 = CollectionsKt.toList(r1.subList(r3, r1.size()));
        r1.subList(r3, r1.size()).clear();
        k.removeAll(CollectionsKt.toSet(r4));
        FLogger.a.i("ECAppletStackManager", "trim stack to pageId=" + r5 + ", removed=" + r4 + ", size=" + r1.size());
        return;
    }

    public static void c(String r8) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        AppHost.Companion r0 = AppHost.a;
        Activity r1 = r0.a().getCurrentActivity();
        if (r1 != null) goto L5;
        return;
    L5:
        Class<? extends Activity> r2 = c;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("close applet, scene=");
        r4.append(r8);
        r4.append(", current=");
        r4.append(r1.getClass().getName());
        r4.append(", origin=");
        if (r2 == null) goto L8;
        String r5 = r2.getName();
    L9:
        r4.append(r5);
        r3.i("ECAppletStackManager", r4.toString());
        boolean r6 = true;
        if (f(r1) == false) goto L13;
        r1.moveTaskToBack(true);
        return;
    L13:
        Lazy r7 = p89.d.a;
        Set r9 = CollectionsKt.toSet(j);
        Intrinsics.checkNotNullParameter("ec_applet_page_id", "pageIdKey");
        Intrinsics.checkNotNullParameter(r9, "closingPageIds");
        p89.c r10 = p89.d.b;
        if (r10 == null) goto L20;
        r0.getApplication().unregisterActivityLifecycleCallbacks(r10);
        if (p89.d.b != r10) goto L20;
        p89.d.b = null;
    L20:
        if (r9.isEmpty() == true) goto L23;
        final p89.c r11 = new p89.c(r9);
        p89.d.b = r11;
        r0.getApplication().registerActivityLifecycleCallbacks(r11);
        ((Handler) p89.d.a.getValue()).postDelayed(new p89.b(r11), 2000);
    L23:
        f = true;
        Set r12 = ((LinkedHashMap) l).keySet();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L24:
        boolean r15 = false;
        if (r14.hasNext() == false) goto L31;
        Object r16 = r14.next();
        if (((Activity) r16).getTaskId() != r1.getTaskId()) goto L29;
        r15 = true;
    L29:
        if (r15 == false) goto L24;
        r13.add(r16);
        goto L24
    L31:
        i();
        if (r2 != null) goto L34;
        r1.finish();
    L48:
        c.a(r1);
        return;
    L34:
        if (Build.VERSION.SDK_INT >= 34) goto L36;
    L40:
        r6 = false;
    L41:
        if (r6 == false) goto L46;
        Iterator r17 = r13.iterator();
    L44:
        if (r17.hasNext() == false) goto L48;
        ((Activity) r17.next()).finish();
        goto L44
    L46:
        Intent r18 = new Intent(r1, r2);
        r18.addFlags(603979776);
        r1.startActivity(r18);
        goto L48
    L36:
        if (b.c() == false) goto L40;
        e10 r20 = e10.a;
        int r21 = l0.a;
        if (((Boolean) l0.a(Boolean.TRUE, new b1())).booleanValue() == false) goto L40;
    L8:
        r5 = null;
        goto L9
    }

    public static boolean e(ComponentName r1) {
        if (r1 == null) goto L4;
        String r2 = r1.getClassName();
    L6:
        return Intrinsics.areEqual(r2, AppletFullScreenActivity.class.getName());
    L4:
        r2 = null;
        goto L6
    }

    public static boolean f(Activity r13) {
        if (r13 != null) goto L6;
        return false;
    L6:
        if ((r13 instanceof AppletFullScreenActivity) == false) goto L8;
        return true;
    L8:
        List r1 = AppHost.a.a().g();
        if ((r1 instanceof Collection) == true) goto L11;
    L13:
        Iterator r2 = r1.iterator();
    L15:
        if (r2.hasNext() == false) goto L24;
        AppletFullScreenActivity r3 = (Activity) r2.next();
        if ((r3 instanceof AppletFullScreenActivity) == true) goto L19;
    L21:
        boolean r4 = false;
    L22:
        if (r4 == false) goto L15;
        boolean r5 = true;
    L25:
        if (r5 == false) goto L27;
        return true;
    L27:
        Object r6 = r13.getSystemService("activity");
        if ((r6 instanceof ActivityManager) == false) goto L30;
        ActivityManager r7 = (ActivityManager) r6;
    L31:
        if (r7 == null) goto L88;
        List<ActivityManager.AppTask> r8 = r7.getAppTasks();     // Catch: SecurityException -> L70
        if ((r8 instanceof Collection) == true) goto L36;
    L38:
        Iterator<T> r9 = r8.iterator();     // Catch: SecurityException -> L70
    L39:
        if (r9.hasNext() == false) goto L89;
        ActivityManager.RecentTaskInfo r10 = ((ActivityManager.AppTask) r9.next()).getTaskInfo();     // Catch: SecurityException -> L70
        if (r10 != null) goto L44;
        boolean r11 = false;
    L68:
        if (r11 == false) goto L39;
        return true;
    L44:
        int r12 = Build.VERSION.SDK_INT;     // Catch: SecurityException -> L70
        if (r12 < 29) goto L47;
        int r14 = r10.taskId;     // Catch: SecurityException -> L70
    L48:
        Intent r15 = r10.baseIntent;     // Catch: SecurityException -> L70
        if (r15 == null) goto L51;
        ComponentName r16 = r15.getComponent();     // Catch: SecurityException -> L70
    L52:
        ComponentName r17 = r10.origActivity;     // Catch: SecurityException -> L70
        if (r12 < 29) goto L55;
        ComponentName r18 = r10.baseActivity;     // Catch: SecurityException -> L70
    L57:
        if (r14 == r13.getTaskId()) goto L59;
    L65:
        r11 = false;
    L66:
        if (r11 == false) goto L68;
        FLogger.a.i("ECAppletStackManager", "isInAppletAppTask: matched AppTask, activity=" + r13.getClass().getSimpleName() + ", taskId=" + r14 + ", baseIntent=" + r16 + ", origActivity=" + r17 + ", baseActivity=" + r18);     // Catch: SecurityException -> L70
        goto L68
    L59:
        if (e(r16) == false) goto L61;
    L64:
        r11 = true;
        goto L66
    L61:
        if (e(r17) == true) goto L64;
        if (e(r18) == false) goto L65;
    L55:
        r18 = null;
        goto L57
    L51:
        r16 = null;
        goto L52
    L47:
        r14 = r10.persistentId;     // Catch: SecurityException -> L70
        goto L48
    L89:
        return false;
    L36:
        if (r8.isEmpty() == false) goto L38;
        return false;
    L70:
        e = move-exception;
        FLogger.a.w("ECAppletStackManager", "isInAppletAppTask: getAppTasks denied, taskId=" + r13.getTaskId() + ", error=" + e.getMessage());
        return false;
    L88:
        return false;
    L30:
        r7 = null;
        goto L31
    L19:
        if (r3.getTaskId() != r13.getTaskId()) goto L21;
        r4 = true;
    L24:
        r5 = false;
        goto L25
    L11:
        if (r1.isEmpty() == false) goto L13;
        goto L13
    }

    public static void h(String r6) {
        r r0 = r.a;
        String r1 = e;
        Class<? extends Activity> r2 = c;
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = r2.getName();
    L6:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "type");
        JSONObject r5 = new JSONObject();
        if (r1 == null) goto L9;
        r3 = StringsKt.substringBefore$default(r1, "?", null, 2, null);
    L9:
        r5.putOpt("url", r3);
        r5.putOpt("scene", r4);
        r5.putOpt("action_type", r6);
        IApplog.a.reportEvent("ies_ec_flow_applet_open", r5);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
