package com.larus.bmhome.utils;

import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b3 implements com.larus.common_ui.dialog.u {
    public b3() {
    }

    public final void cancel() {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("click_type", 0);
        Unit r2 = Unit.INSTANCE;
        r0.reportEvent("external_domain_jumper", r1);
    }
}
