package ncb;

import com.ss.android.lark.chameleon.bridge.BridgeReport;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends OPMonitorCode {
    public static final c a = null;
    public static final c b = null;
    public static final c c = null;
    public static final c d = null;
    public static final c e = null;
    public static final c f = null;
    public static final c g = null;
    public static final c h = null;
    public static final c i = null;
    public static final c j = null;
    public static final c k = null;
    public static final c l = null;
    public static final c m = null;
    public static final c n = null;
    public static final c o = null;
    public static final c p = null;
    public static final c q = null;
    public static final c r = null;
    public static final c s = null;

    static {
        OPMonitorLevel r1 = OPMonitorLevel.ERROR;
        new c(10000, r1, "root_view_null");
        new c(10001, r1, "child_params_list_empty");
        new c(10002, OPMonitorLevel.WARN, "child_params_null");
        new c(BridgeReport.CODE_API_AUTH_FAILED, OPMonitorLevel.TRACE, "img_key_empty");
        new c(BridgeReport.CODE_NO_API_HANDLER, r1, "select_person_error");
        new c(BridgeReport.CODE_CALLBACKID_IS_NULL_OR_EMPTY, r1, "bind_data_error");
        new c(10014, r1, "messagecard_url_open_unsupport");
        OPMonitorLevel r2 = OPMonitorLevel.NORMAL;
        a = new c(10028, r2, "messagecard_action_data_error");
        new c(10029, r2, "messagecard_action_url_error");
        new c(10040, r2, "messagecard_loading_success");
        new c(10050, r2, "messagecard_action_result");
        new c(10051, r2, "messagecard_action_service_fail");
        b = new c(10070, r2, "messagecard_initdata_prepare");
        c = new c(10071, r2, "messagecard_template_load_start");
        d = new c(10072, r2, "messagecard_template_load_finish");
        e = new c(10073, r2, "messagecard_page_render_finish");
        f = new c(10074, r2, "messagecard_create_view_finish");
        new c(10075, r2, "messagecard_js_execute_success");
        new c(10076, r2, "messagecard_js_execute_error");
        g = new c(10077, r2, "messagecard_lynx_error");
        h = new c(10078, r2, "messagecard_render_start");
        i = new c(10060, r2, "messagecard_request_success");
        new c(10061, r2, "messagecard_request_data_error");
        j = new c(10062, r2, "messagecard_request_network_error");
        k = new c(10063, r2, "messagecard_open_url_success");
        l = new c(10064, r2, "lynx_messagecard_url_open_unsupport");
        new c(10065, r2, "lynx_messagecard_url_open_without_triggercode");
        new c(10066, r2, "messagecard_request_time_out");
        new c(10067, r2, "messagecard_card_json2pb_success");
        new c(10068, r2, "messagecard_card_json2pb_error");
        new c(10069, r2, "messagecard_send_preview_card_success");
        new c(10079, r2, "messagecard_send_preview_card_error");
        new c(10080, r2, "card_component_render");
        m = new c(10081, r2, "card_client_message_success");
        n = new c(10082, r2, "card_client_message_error");
        new c(10084, r2, "chart_render_finish");
        o = new c(10085, r2, "card_external_js_load_start");
        p = new c(10086, r2, "card_external_js_load_end");
        new c(10087, r2, "card_external_js_preload_start");
        new c(10088, r2, "card_external_js_preload_end");
        q = new c(10091, r2, "card_get_entity_success");
        r = new c(10092, r2, "card_get_entity_fail");
        s = new c(10093, r2, "card_check_diff_result");
        new c(10096, r2, "card_render_with_action_sync_data");
        new c(10097, r2, "enter_chat_with_card");
    }

    public c(int r2, OPMonitorLevel r3, String r4) {
        super("client.open_platform.card", r2, r3, r4);
    }
}
