package com.obric.update.impl.v2;

import com.larus.utils.logger.FLogger;
import com.obric.update.api.v2.IObricUpdateService;
import com.obric.update.api.v2.ObricBannerType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class m {
    public static final /* synthetic */ int d = 0;
    public final goa.a a;
    public final goa.b b;
    public final o c;

    public static final class a {
    }

    static {
    }

    public m(goa.a r2, goa.b r3, o r4) {
        Intrinsics.checkNotNullParameter(r2, "flowContext");
        Intrinsics.checkNotNullParameter(r3, "stateHolder");
        Intrinsics.checkNotNullParameter(r4, "gateways");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final JSONObject a(String r3, String r4, String r5) {
        JSONObject r0 = new JSONObject();
        r0.put("stage", r3);
        r0.put("result", r4);
        boolean r6 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L11;
        r0.put("reason", r5);
    L11:
        IObricUpdateService r8 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        Boolean r9 = null;
        if (r8 == null) goto L14;
        String r10 = r8.m();
    L15:
        r0.put("trigger_source", r10);
        r0.put("update_state", this.b.b);
        IObricUpdateService r11 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r11 == null) goto L20;
        ObricBannerType r12 = r11.getBannerType();
        if (r12 == null) goto L20;
        int r13 = r12.getValue();
    L21:
        r0.put("banner_type", r13);
        this.c.d.getClass();     // Catch: Exception -> L24
        Boolean r14 = Boolean.valueOf(com.obric.update.impl.v2.gateway.c.b());     // Catch: Exception -> L24
    L25:
        if (r14 == null) goto L27;
        boolean r15 = r14.booleanValue();
    L28:
        r0.put("is_wifi", r15);
        this.c.d.getClass();     // Catch: Exception -> L31
        r9 = Boolean.valueOf(com.obric.update.impl.v2.gateway.c.a());     // Catch: Exception -> L31
    L32:
        if (r9 == null) goto L34;
        r6 = r9.booleanValue();
    L34:
        r0.put("is_network_available", r6);
        r0.put("is_app_foreground", this.a.a);
        r0.put("is_user_manual_download", this.a.b);
        r0.put("is_wifi_auto_download", this.a.c);
        r0.put("is_wifi_auto_interfered", this.a.d);
        r0.put("is_zeus_plugin_preinstalling", this.a.g);
        r0.put("is_downloading", this.a.e);
        return r0;
    L27:
        r15 = false;
    L24:
        r14 = null;
    L20:
        r13 = 0;
        goto L21
    L14:
        r10 = null;
        goto L15
    L5:
        if (r5.length() == 0) goto L8;
        r7 = false;
        goto L9
    }

    public final void c(String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "stage");
        Intrinsics.checkNotNullParameter(r3, "reason");
        b(r2, "blocked", r3, r4);
    }

    public static void d(m r1, String r2, String r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "stage");
        r1.b(r2, "start", r3, null);
    }

    public static void e(m r1, String r2, String r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        r3 = null;
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "stage");
        r1.b(r2, "success", r3, null);
    }

    public final void b(String r3, String r4, String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r3, "stage");
        Intrinsics.checkNotNullParameter(r4, "result");
        JSONObject r7 = a(r3, r4, r5);     // Catch: Exception -> L14
        if (r6 == null) goto L10;
        Iterator<String> r8 = r6.keys();     // Catch: Exception -> L14
        if (r8 == null) goto L10;
    L8:
        if (r8.hasNext() == false) goto L10;
        String r0 = r8.next();     // Catch: Exception -> L14
        r7.put(r0, r6.opt(r0));     // Catch: Exception -> L14
    L10:
        IObricUpdateService r9 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);     // Catch: Exception -> L14
        if (r9 == null) goto L20;
        r9.h("obric_update_pipeline", r7);     // Catch: Exception -> L14
        return;
    L20:
        return;
    L14:
        e = move-exception;
        FLogger.a.i("ObricUpdatePipelineReporter", "report error: stage=" + r3 + ",err=" + e);
    }
}
