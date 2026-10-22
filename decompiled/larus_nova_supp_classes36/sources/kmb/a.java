package kmb;

import android.app.Application;
import com.bytedance.ee.bear.bizwidget.officesdk.CCMOfficeSDKAssembleFG;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.integrator.ccm.dependency.di.q;
import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static void a() {
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L5;
    L8:
        q.a();
        if (fmb.a.b == true) goto L32;
        Object r0 = fmb.a.a;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L13:
        if (fmb.a.b == true) goto L27;
        Application r1 = LarkContext.getApplication();     // Catch: Throwable -> L29
        com.bytedance.ee.bear.appsetting.c r2 = com.bytedance.ee.bear.appsetting.c.a.a;     // Catch: Throwable -> L29
        r2.a(new fmb.a.C0263a());     // Catch: Throwable -> L29
        if ("release".equals(AppInfoUtils.d(r1)) == true) goto L17;
    L20:
        boolean r3 = true;
    L21:
        if (r3 == false) goto L23;
        r2.a(new fn4.b(LarkContext.getApplication()));     // Catch: Throwable -> L29
    L23:
        r2.a(new fn4.c());     // Catch: Throwable -> L29
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L26;
        r2.a(new fmb.b());     // Catch: Throwable -> L29
    L26:
        fmb.a.b = true;     // Catch: Throwable -> L29
        goto L27
    L17:
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L20;
        r3 = false;
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L29
        return;
    L32:
        return;
    L5:
        if (CCMOfficeSDKAssembleFG.b() == true) goto L8;
        tt5.a.h("CCMInitChecker", "OfficeSDK checkAndInit, but isEnable is false");
    }
}
