package com.bytedance.android.live.browser.webview.config;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface LiveHybridSettingKeys {
    public static final SettingKey<Boolean> ARGUS_API_PARAM_JSB_DELETE_TOKEN = null;
    public static final SettingKey<Boolean> ARGUS_DELETE_GET_XTT_TOKEN_JSB = null;
    public static final SettingKey<Boolean> ENABLE_AUTO_SHOW_FLOAT_LIVE = null;
    public static final SettingKey<Boolean> ENABLE_BOE_URL_REPLACE = null;
    public static final SettingKey<Boolean> ENABLE_HYBRID_CONTAINER_ORIENTATION_BY_SIZE = null;
    public static final SettingKey<Boolean> ENABLE_SHARE_COOKIE_URL_TO_HTTPS = null;
    public static final SettingKey<List<String>> HYBRID_SECLINK_WHITE_LIST = null;
    public static final SettingKey<Boolean> LIVE_LYNX_DYNAMIC_MESSAGE = null;
    public static final SettingKey<Boolean> LIVE_LYNX_DYNAMIC_MESSAGE_NEW_JUDGE = null;
    public static final SettingKey<Boolean> LIVE_ROMA_SDK_POLL_CONFIG = null;
    public static final SettingKey<Long> LIVE_ROMA_SDK_POLL_INTERNAL_CONFIG = null;
    public static final SettingKey<Boolean> NETWORK_JSB_ADD_X_SECURITY_ARGUS = null;
    public static final SettingKey<Boolean> OPEN_HYBRID_SECLINK_CONFIG = null;
    public static final SettingKey<Boolean> REOPEN_PERMISSION_CHECK = null;
    public static final SettingKey<List<String>> SHARE_COOKIE_URL_TO_HTTPS_LIST = null;

    static {
        Boolean r1 = Boolean.FALSE;
        Boolean r2 = Boolean.TRUE;
        OPEN_HYBRID_SECLINK_CONFIG = new SettingKey("enable_wk_seclink", "开启seclink开关配置", r1, r2);
        HYBRID_SECLINK_WHITE_LIST = new SettingKey("live_hybrid_seclink_allow_list", "seclink通过白名单", new ArrayList(), new ArrayList());
        ENABLE_SHARE_COOKIE_URL_TO_HTTPS = new SettingKey("share_cookie_url_to_https_enable", "是否开启拦截可共享cookie的http请求，并转换成https", r2, r2);
        SHARE_COOKIE_URL_TO_HTTPS_LIST = new SettingKey("share_cookie_url_to_https_list", "HTTP cookie拦截 请求白名单", new ArrayList(), new ArrayList());
        ENABLE_HYBRID_CONTAINER_ORIENTATION_BY_SIZE = new SettingKey("hybrid_container_orientation_by_size_enable", "是否开启容器通过尺寸判断横竖屏", r1, r2);
        ENABLE_BOE_URL_REPLACE = new SettingKey("enable_boe_url_replace", "是否开启BOE环境URL替换", r2, r2);
        ENABLE_AUTO_SHOW_FLOAT_LIVE = new SettingKey("enable_auto_show_float_live", "显示浮窗参数是否生效", r2, r2);
        LIVE_ROMA_SDK_POLL_CONFIG = new SettingKey("enable_roma_sdk_poll", "Roma重定向轮询开关", r1, r1);
        LIVE_ROMA_SDK_POLL_INTERNAL_CONFIG = new SettingKey("roma_sdk_poll_internal", "Roma重定向轮询间隔", 180L, 180L);
        LIVE_LYNX_DYNAMIC_MESSAGE = new SettingKey("live_lynx_dynamic_message", "是否支持lynx动态新增消息能力", r2, r2);
        LIVE_LYNX_DYNAMIC_MESSAGE_NEW_JUDGE = new SettingKey("live_lynx_dynamic_message_new_judget", "lynx动态消息消息名匹配逻辑修改", r2, r2);
        REOPEN_PERMISSION_CHECK = new SettingKey("live_lynx_sec_permission_check_reopen", "恢复安全检查", r2, r2);
        ARGUS_DELETE_GET_XTT_TOKEN_JSB = new SettingKey("argus_delete_get_xtt_token_jsb", "下线 getXTtToken JSB", r1, r1);
        ARGUS_API_PARAM_JSB_DELETE_TOKEN = new SettingKey("argus_api_param_jsb_delete_token", "删除 apiParam JSB 返回的 tt_token 字段", r1, r1);
        NETWORK_JSB_ADD_X_SECURITY_ARGUS = new SettingKey("network_jsb_add_x_security_argus", "jsb 发起的网络请求是否携带 x-security-argus", r2, r2);
    }
}
