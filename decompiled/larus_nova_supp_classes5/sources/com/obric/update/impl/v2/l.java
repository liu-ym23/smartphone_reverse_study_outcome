package com.obric.update.impl.v2;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void c(boolean r3) {
        JSONObject r0 = new JSONObject();
        r0.put("source", "manual_check");
        r0.put("popup_type", "find_new_version");
        r0.put("is_force_update", r3);
        Unit r4 = Unit.INSTANCE;
        a("obric_upgrade_popup_show", r0);
    }

    public static void a(String r3, JSONObject r4) {
        FLogger.a.i("ObricUpdateEventReporter", "reportUpdateEventLog called with event:" + r3);
        r4.put("version_to", com.ss.android.update.d.x().o);
        r4.put("current_version", AppHost.a.getUpdateVersionCode());
        IObricUpdateService r0 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        String r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = Integer.valueOf(r0.l());
    L6:
        r4.put("update_state", r2);
        PolarisFileWrapper r5 = com.ss.android.update.d.x().I();
        if (r5 == null) goto L9;
        r1 = r5.getName();
    L9:
        r4.put("ready_apk_path", r1);
        if (r3 == null) goto L13;
        IApplog.a.reportEvent(r3, r4);
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static void b(String r3, boolean r4) {
        JSONObject r0 = new JSONObject();
        r0.put("source", "manual_check");
        r0.put("popup_type", "find_new_version");
        r0.put("action_type", r3);
        r0.put("is_force_update", r4);
        Unit r5 = Unit.INSTANCE;
        a("obric_upgrade_popup_click", r0);
    }
}
