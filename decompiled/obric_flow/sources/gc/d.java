package gc;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.kit.resourceloader.g;
import com.bytedance.ies.bullet.service.base.a0;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import h.f;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SharedPreferences f17083a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList f17084b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f17085c = null;

    static {
        Application r5 = g.f5452b;
        if (r5 == null) goto L7;
        Context r10 = r5.getApplicationContext();
        if (r10 == null) goto L7;
        SharedPreferences r11 = r10.getSharedPreferences("resourceloader_sp", 0);
    L8:
        f17083a = r11;
        ArrayList r12 = new ArrayList();
        r12.add("fe_lynx_group");
        r12.add("fe_app_lynx");
        r12.add("fe_lynx_knowledge");
        f17084b = r12;
        f17085c = "geckoResourceFirstLoad: ";
        return;
    L7:
        r11 = null;
        goto L8
    }

    public static final void a(JSONObject r5, a0 r10) {
        if (f17084b.contains(r10.s) == false) goto L14;
        SharedPreferences r11 = f17083a;
        if (r11 != null) goto L8;
        dc.b.b("sp is null");
        return;
    L8:
        boolean r12 = r11.getBoolean(r10.s, false);
        String r13 = f17085c;
        if (r12 == true) goto L12;
        r11.edit().putBoolean(r10.s, true).apply();
        r5.put("res_first_try_fetch", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        dc.b.a(r13 + "first load！");
        return;
    L12:
        r5.put("res_first_try_fetch", "0");
        dc.b.a(r13 + "loaded！");
        return;
    }

    public static void b(wc.e r10, a0 r11, wc.g r12, long r13) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "resInfo");
        Intrinsics.checkNotNullParameter(r12, "taskConfig");
        f.b(new c(r11, r12, r10, r13, SystemClock.elapsedRealtime()), f.g);
    }

    public static void c(wc.e r10, a0 r11, wc.g r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "resInfo");
        Intrinsics.checkNotNullParameter(r12, "taskConfig");
        Intrinsics.checkNotNullParameter(r13, "errorMessage");
        f.b(new b(r11, r12, r10, r13, SystemClock.elapsedRealtime()), f.g);
    }

    public static void d(wc.e r10, wc.g r11, a0 r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, "taskConfig");
        Intrinsics.checkNotNullParameter(r12, "resInfo");
        Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_STATUS);
        f.b(new com.bytedance.ies.bullet.lynx.resource.b(r12, r10, r11, r13, 2), f.g);
    }

    public static final boolean e(wc.g r5) {
        ConcurrentHashMap r10 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r11 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r11 == null) goto L7;
        xc.f r12 = (xc.f) r11.a(xc.f.class);
        if (r12 == null) goto L7;
        boolean r13 = r12.g();
    L9:
        if (r5.f22853w != null) goto L11;
    L15:
        return false;
    L11:
        if (r5.f22854x == null) goto L15;
        if (r13 == false) goto L15;
        return true;
    L7:
        r13 = false;
        goto L9
    }
}
