package j5;

import android.app.Application;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.apm.j;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18235a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f18236b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f18237c = null;
    public static final Map d = null;
    public static final Map e = null;
    public static final WeakHashMap f = null;

    static {
        f18235a = new b();
        f18236b = Collections.synchronizedMap(new ConcurrentHashMap());
        f18237c = Collections.synchronizedMap(new ConcurrentHashMap());
        d = Collections.synchronizedMap(new ConcurrentHashMap());
        e = Collections.synchronizedMap(new LinkedHashMap());
        f = new WeakHashMap();
    }

    public static String a(String r5, WebView r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "field");
        if (r5 != null) goto L5;
    L12:
        if (r10 == null) goto L17;
        Object r12 = d(r10).s().get(r11);
        if ((r12 instanceof String) == false) goto L17;
        return (String) r12;
    L17:
        return null;
    L5:
        if (r5.length() == 0) goto L12;
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        Object r13 = h(r5).get(r11);
        if ((r13 instanceof String) == true) goto L10;
        return null;
    L10:
        return (String) r13;
    }

    public static ArrayList b(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        ArrayList r5 = new ArrayList();
        Map r11 = e;
        monitor-enter(r11);
        Iterator r12 = r11.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r12.hasNext() == false) goto L14;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L12
        View r14 = (View) ((f) r13.getValue()).f18245b.get();     // Catch: Throwable -> L12
        if (r14 == null) goto L6;
        if (r14.equals(r10) != true) goto L6;
        r5.add(r13.getKey());     // Catch: Throwable -> L12
        goto L6
    L14:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r11);
        return r5;
    L12:
        th = move-exception;
        throw th;
    }

    public static ConcurrentHashMap c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        Map r10 = f18236b;
        if (r10.get(r5) != null) goto L5;
        ConcurrentHashMap r11 = new ConcurrentHashMap();
        r11.put("context", f(r5));
        r11.put("version", "9.0.0");
        r10.put(r5, r11);
    L5:
        ConcurrentHashMap r12 = (ConcurrentHashMap) r10.get(r5);
        if (r12 == null) goto L8;
        return r12;
    L8:
        return new ConcurrentHashMap();
    }

    public static x4.a d(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        CopyOnWriteArrayList r10 = new CopyOnWriteArrayList();
        Iterator r11 = b(r5).iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        String r12 = (String) r11.next();
        Intrinsics.checkNotNullParameter(r12, "monitorId");
        r10.add(h(r12));
        goto L4
    L7:
        return new x4.a(r10, 1);
    }

    public static void e(ViewGroup r10, a r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Map r5 = e;
        monitor-enter(r5);
        Iterator r12 = r5.entrySet().iterator();     // Catch: Throwable -> L12
        boolean r13 = false;
    L6:
        if (r12.hasNext() == false) goto L14;
        Map.Entry r14 = (Map.Entry) r12.next();     // Catch: Throwable -> L12
        String r15 = (String) r14.getKey();     // Catch: Throwable -> L12
        View r16 = (View) ((f) r14.getValue()).f18245b.get();     // Catch: Throwable -> L12
        if (r16 == null) goto L6;
        if (r16.equals(r10) != true) goto L6;
        r11.a(r15);     // Catch: Throwable -> L12
        r13 = true;
        goto L6
    L14:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r5);
        if (r13 == true) goto L30;
        f.put(r10, r11);
        return;
    L30:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static JSONObject f(String r10) {
        Map r5 = d;
        if (r5.get(r10) != null) goto L52;
        JSONObject r11 = new JSONObject();
        Lazy r12 = com.bytedance.android.monitorV2.constant.a.f3521a;
        Intrinsics.checkNotNullParameter("monitor_is_reinstall", STGroup.DICT_KEY);
        Application r13 = com.bytedance.android.monitorV2.constant.a.f3523c;
        boolean r14 = false;
        if (r13 == null) goto L11;
        SharedPreferences r15 = (SharedPreferences) com.bytedance.android.monitorV2.constant.a.f3521a.getValue();
        if (r15 == null) goto L11;
        r14 = r15.getBoolean("monitor_is_reinstall", false);
    L11:
        if (r14 == true) goto L22;
        Intrinsics.checkNotNullParameter("monitor_is_reinstall", STGroup.DICT_KEY);
        if (r13 == null) goto L22;
        SharedPreferences r16 = (SharedPreferences) com.bytedance.android.monitorV2.constant.a.f3521a.getValue();
        if (r16 == null) goto L22;
        SharedPreferences.Editor r17 = r16.edit();
        if (r17 == null) goto L22;
        SharedPreferences.Editor r18 = r17.putBoolean("monitor_is_reinstall", true);
        if (r18 == null) goto L22;
        r18.apply();
    L22:
        r11.put("is_reinstall", !r14);
        TimeUnit r19 = TimeUnit.MILLISECONDS;
        long r20 = System.currentTimeMillis();
        if (j.f3890h != 0) goto L25;
        j.f3890h = System.currentTimeMillis();
    L25:
        long r21 = r19.toSeconds(r20 - j.f3890h);
        if (0 > r21) goto L31;
        if (r21 >= 3) goto L31;
        String r22 = "0";
    L51:
        r11.put("app_runtime", r22);
        r5.put(r10, r11);
    L31:
        if (3 > r21) goto L36;
        if (r21 >= 5) goto L36;
        r22 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L36:
        if (5 > r21) goto L41;
        if (r21 >= 10) goto L41;
        r22 = "2";
    L41:
        if (10 > r21) goto L46;
        if (r21 >= 30) goto L46;
        r22 = "3";
    L46:
        if (30 <= r21) goto L48;
    L50:
        r22 = "5";
        goto L51
    L48:
        if (r21 >= 60) goto L50;
        r22 = "4";
    L52:
        JSONObject r23 = (JSONObject) r5.get(r10);
        if (r23 == null) goto L55;
        return r23;
    L55:
        return new JSONObject();
    }

    public static x4.a g(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        CopyOnWriteArrayList r10 = new CopyOnWriteArrayList();
        Iterator r11 = b(r5).iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        String r12 = (String) r11.next();
        Intrinsics.checkNotNullParameter(r12, "monitorId");
        r10.add(c(r12));
        goto L4
    L7:
        return new x4.a(r10, 0);
    }

    public static ConcurrentHashMap h(String r5) {
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        Map r10 = f18237c;
        if (r10.get(r5) != null) goto L5;
        r10.put(r5, new ConcurrentHashMap());
    L5:
        ConcurrentHashMap r11 = (ConcurrentHashMap) r10.get(r5);
        if (r11 == null) goto L8;
        return r11;
    L8:
        return new ConcurrentHashMap();
    }

    public static f i(String r5) {
        Intrinsics.checkNotNullParameter(r5, "monitorId");
        return (f) e.get(r5);
    }
}
