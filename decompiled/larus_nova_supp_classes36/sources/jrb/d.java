package jrb;

import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d extends OPMonitorCode {
    public static final d a = null;
    public static final d b = null;
    public static final d c = null;
    public static final d d = null;
    public static final d e = null;
    public static final d f = null;
    public static final d g = null;
    public static final d h = null;
    public static final d i = null;
    public static final d j = null;

    static {
        OPMonitorLevel r1 = OPMonitorLevel.ERROR;
        new d(AbstractNotification.NoticeType.DOCFEED, r1, "root_view_null");
        new d(10001, r1, "child_params_list_empty");
        a = new d(10002, OPMonitorLevel.WARN, "child_params_null");
        b = new d(10003, OPMonitorLevel.TRACE, "img_key_empty");
        c = new d(10004, r1, "select_person_error");
        new d(10005, r1, "bind_data_error");
        d = new d(10009, r1, "messagecard_trigger_code_fail");
        e = new d(10013, r1, "messagecard_image_load_origin_error");
        f = new d(10014, r1, "messagecard_url_open_unsupport");
        new d(10015, r1, "messagecard_url_open_without_triggercode_func");
        g = new d(10016, r1, "messagecard_url_open_without_triggercode");
        new d(10017, r1, "messagecard_url_open_url_invalid");
        new d(10018, r1, "messagecard_url_open_url_limt_interval");
        h = new d(10019, r1, "messagecard_request_not_allow");
        new d(10020, r1, "messagecard_request_in_last_process");
        i = new d(10021, r1, "messagecard_request_response_fail");
        j = new d(10022, OPMonitorLevel.NORMAL, "messagecard_request_response_success");
    }

    public d(int r2, OPMonitorLevel r3, String r4) {
        super("client.open_platform.card", r2, r3, r4);
    }
}
