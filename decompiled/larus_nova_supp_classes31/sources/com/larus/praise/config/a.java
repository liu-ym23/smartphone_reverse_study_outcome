package com.larus.praise.config;

import android.app.Activity;
import android.content.Context;
import com.ixigua.lib.track.TrackParams;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.network.HttpConst;
import com.larus.search.api.IBrowserService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ds9.h;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a implements y57.a {

    /* JADX INFO: renamed from: com.larus.praise.config.a$a, reason: collision with other inner class name */
    public static final class C0013a {
    }

    static {
    }

    public a() {
    }

    public final void a() {
    }

    public final void b() {
    }

    public final void d() {
    }

    public final String getAppId() {
        return String.valueOf(AppHost.a.getAppId());
    }

    public final String getHost() {
        HttpConst.a.getClass();
        return HttpConst.x;
    }

    public final String getPackageName() {
        String r0 = AppHost.a.getApplication().getPackageName();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final Activity getTopActivity() {
        return AppHost.a.a().getCurrentActivity();
    }

    public final void c(Context r3) {
        if (r3 == null) goto L7;
        IBrowserService r0 = (IBrowserService) ServiceManager.get().getService(IBrowserService.class);
        if (r0 == null) goto L8;
        HttpConst.a.getClass();
        r0.j(r3, HttpConst.E);
        return;
    L8:
        return;
    }

    public final void onEvent(String r7, JSONObject r8) {
        String r0 = cs9.a.a;
        int r1 = h.a;
        String r2 = cs9.a.a;
        String r3 = cs9.a.b;
        Intrinsics.checkNotNullParameter(r8, "params");
        boolean r4 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L11;
        r8.put("scene", r2);
    L11:
        if (r3 != null) goto L13;
    L16:
        if (r4 == true) goto L19;
        r8.put("message_id", r3);
    L19:
        switch(r7.hashCode()) {
            case 319288017: goto L42;
            case 319638801: goto L34;
            case 841578353: goto L30;
            case 1304211044: goto L26;
            case 1680087751: goto L22;
            default: goto L45;
        };
    L45:
        IApplog.a.reportEvent(r7, r8);
        return;
    L22:
        if (r7.equals("evaluate_jump_market") == false) goto L45;
        Intrinsics.checkNotNullParameter(r8, "params");
        TrackParams r9 = new TrackParams().merge(r8);
        by7.a r10 = new by7.a("evaluate_jump_market");
        r10.a.merge(r9);
        r10.b();
        return;
    L26:
        if (r7.equals("evaluate_pop_close") == false) goto L45;
        Intrinsics.checkNotNullParameter(r8, "params");
        TrackParams r11 = new TrackParams().merge(r8);
        by7.a r12 = new by7.a("evaluate_pop_close");
        r12.a.merge(r11);
        r12.b();
        return;
    L30:
        if (r7.equals("evaluate_pop_bad") == false) goto L45;
        Intrinsics.checkNotNullParameter(r8, "params");
        TrackParams r13 = new TrackParams().merge(r8);
        by7.a r14 = new by7.a("evaluate_pop_bad");
        r14.a.merge(r13);
        r14.b();
        return;
    L34:
        if (r7.equals("evaluate_pop_show") == false) goto L45;
        Intrinsics.checkNotNullParameter(r8, "params");
        r8.put("is_system", "0");     // Catch: JSONException -> L38
    L40:
        TrackParams r15 = new TrackParams().merge(r8);
        by7.a r16 = new by7.a("evaluate_pop_show");
        r16.a.merge(r15);
        r16.b();
        return;
    L38:
        e = move-exception;
        FLogger.a.e("EvaluateEventHelper", "error in EvaluateEventHelper evaluatePopShow " + e.getLocalizedMessage());
        goto L40
    L42:
        if (r7.equals("evaluate_pop_good") == false) goto L45;
        Intrinsics.checkNotNullParameter(r8, "params");
        TrackParams r17 = new TrackParams().merge(r8);
        by7.a r18 = new by7.a("evaluate_pop_good");
        r18.a.merge(r17);
        r18.b();
        return;
    L13:
        if (r3.length() == 0) goto L16;
        r4 = false;
        goto L16
    L5:
        if (r2.length() == 0) goto L8;
        r5 = false;
        goto L9
    }
}
