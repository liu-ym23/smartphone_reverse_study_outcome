package com.larus.connector;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r4, String r5) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("current_page", "chat");
        r1.put(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "chat_action_bar");
        r1.put("click_from", "action");
        r1.put("connector_id", r4);
        r1.put("connector_action", r5);
        Unit r6 = Unit.INSTANCE;
        r0.reportEvent("connector_click", r1);
    }

    public static void b(String r4, String r5, String r6) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("current_page", "chat");
        r1.put(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD, "chat_action_bar");
        r1.put("connector_id", r4);
        r1.put("connector_name", r5);
        r1.put("connector_status", r6);
        Unit r7 = Unit.INSTANCE;
        r0.reportEvent("connector_show", r1);
    }
}
