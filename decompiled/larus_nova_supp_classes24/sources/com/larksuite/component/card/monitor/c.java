package com.larksuite.component.card.monitor;

import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends OPMonitorCode {
    public static final c a = null;
    public static final c b = null;
    public static final c c = null;

    static {
        a = new c(10003, OPMonitorLevel.TRACE, "img_key_empty");
        OPMonitorLevel r1 = OPMonitorLevel.ERROR;
        b = new c(10013, r1, "messagecard_image_load_origin_error");
        new c(10014, r1, "messagecard_url_open_unsupport");
        new c(10015, r1, "messagecard_url_open_without_triggercode_func");
        c = new c(10016, r1, "messagecard_url_open_without_triggercode");
        new c(10017, r1, "messagecard_url_open_url_invalid");
        new c(10018, r1, "messagecard_url_open_url_limt_interval");
        new c(10019, r1, "messagecard_request_not_allow");
        new c(10020, r1, "messagecard_request_in_last_process");
        new c(10021, r1, "messagecard_request_response_fail");
        new c(10022, OPMonitorLevel.NORMAL, "messagecard_request_response_success");
    }

    public c(int r2, OPMonitorLevel r3, String r4) {
        super("client.open_platform.card", r2, r3, r4);
    }
}
