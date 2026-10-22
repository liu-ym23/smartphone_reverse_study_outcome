package c;

import android.content.Context;
import android.util.Log;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.JsonObject;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.behavior.x0;
import com.zte.miboard.cards.express.data.ExpressRequestBean;

/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static l f1063a;

    public static synchronized l a(Context r5) {
        monitor-enter(m.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f1063a != null) goto L9;
        f1063a = (l) j0.a(r5, "https://express-api.ztems.com/logistics/").create(l.class);     // Catch: Throwable -> L7
    L9:
        l r10 = f1063a;     // Catch: Throwable -> L7
        monitor-exit(m.class);
        return r10;
    }

    public static String b(String r5) {
        return ai.j0.C("NCards: ", r5);
    }

    public static void c(Context r5, JsonObject r10) {
        r10.addProperty("miboard", "n_cards");
        r10.addProperty("pkgName", r5.getPackageName());
        r10.addProperty("product", k0.c());
        String r11 = k0.f1062c;
        if (r11 != null) goto L9;
        r11 = k0.b("ro.build.sw_internal_version", null);
        if (r11 != null) goto L8;
        r11 = "";
    L8:
        k0.f1062c = r11;
    L9:
        r10.addProperty("internal_version", r11);
    }

    public static void d(Context r5, String r10, String r11, mt.u r12) {
        l r13 = a(r5);
        JsonObject r14 = new JsonObject();
        i("ExpressNetwork", "verifyCodeParameter: ");
        c(r5, r14);
        r14.addProperty("phone", r10);
        r14.addProperty(Constant.IMEI, k0.a(r5));
        r14.addProperty("androidId", k0.a(r5));
        r14.addProperty("version", "");
        r14.addProperty("code", r11);
        r14.addProperty("timestamp", "");
        r14.addProperty("newSF", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        j0.b(r13.b(r14), r12);
    }

    public static void e(Context r5, String r10, mt.u r11) {
        i("ExpressNetwork", "deleteExpressDatas enter: ");
        l r12 = a(r5);
        JsonObject r13 = new JsonObject();
        c(r5, r13);
        r13.addProperty("version", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        r13.addProperty("mailNo", r10);
        r13.addProperty("newSF", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        j0.b(r12.d(r13), r11);
    }

    public static void f(Context r5, mt.u r10) {
        j0.b(a(r5).f(new ExpressRequestBean(s.c(r5), false, k0.a(r5), false), s.d()), r10);
    }

    public static void g(Context r5, boolean r10, mt.u r11) {
        i("ExpressNetwork", "getLimitedExpressDatas userinternet: ");
        j0.b(a(r5).h(new ExpressRequestBean(s.c(r5), r10, k0.a(r5), true), s.d()), r11);
    }

    public static void h(q0 r5) {
        mt.n r10 = mt.n.create(new x0(r5)).subscribeOn(ut.e.f22462b);
        nt.d r11 = nt.b.f20308a;
        if (r11 == null) goto L7;
        r10.observeOn(r11).subscribe(new p0(r5));
        return;
    L7:
        throw new NullPointerException("scheduler == null");
    }

    public static void i(String r5, String r10) {
        Log.d(b(r5), r10);
    }

    public static void j(String r5, String r10, Throwable r11) {
        Log.e(b(r5), r10, r11);
    }

    public static void k(Context r5, String r10, String r11, mt.u r12) {
        l r13 = a(r5);
        JsonObject r14 = new JsonObject();
        c(r5, r14);
        r14.addProperty("version", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        r14.addProperty(LynxMonitorService.KEY_PID, k0.a(r5));
        r14.addProperty("mailNo", r10);
        r14.addProperty("action", 0);
        r14.addProperty("cpCode", r11);
        r14.addProperty("newSF", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        j0.b(r13.g(r14), r12);
    }

    public static void l(String r5, String r10) {
        Log.e(b(r5), r10);
    }

    public static void m(Context r5, String r10) {
        k r11 = new k();
        l r12 = a(r5);
        JsonObject r13 = new JsonObject();
        c(r5, r13);
        r13.addProperty("phone", r10);
        r13.addProperty("version", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        r13.addProperty("newSF", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);
        j0.b(r12.c(r13), r11);
    }

    public static void n(String r5, String r10) {
        Log.w(b(r5), r10);
    }
}
