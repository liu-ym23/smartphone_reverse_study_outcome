package com.ss.android.lark.passport.signinsdk_api.feature.listener.logout;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/logout/LogoutSceneKey;", "", "Companion", "passport-base-api_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public @interface LogoutSceneKey {
    public static final String ADMIN_KICKOUT_WIPE = "admin_kickout_wipe";
    public static final String BASE_ACTIVITY = "base_activity_check_login";
    public static final a Companion = null;
    public static final String DEBUGGER_LOGOUT = "debug_logout";
    public static final String DPOP = "dpop";
    public static final String IDP_REFRESH_TOKEN_INVALID_BROWSER = "idp_refresh_token_invalid_browser";
    public static final String IDP_REFRESH_TOKEN_INVALID_INIT = "idp_refresh_token_invalid_init";
    public static final String IM_CHAT_WINDOW_CHECK_LOGIN_VALID = "im_chat_window_check_logout";
    public static final String IM_SIMPLE_MODE_JS_LOGOUT = "im_simple_mode_js_logout";
    public static final String IM_THREAD_WINDOW_CHECK_LOGIN_VALID = "im_thread_window_check_logout";
    public static final String KA_ALCHEMY_LOGOUT = "ka_alchemy_logout";
    public static final String KA_EMM_SDK_LOGOUT = "ka_emm_sdk_logout";
    public static final String OPEN_PLATFORM_JS_API_IDPIDENTITY_INVALID = "js_api_idpidentity_invalid";
    public static final String OPEN_PLATFORM_JS_API_LOGOUT = "biz_js_api_logout";
    public static final String PASSPORT_ENCRYPT_KEY_EMPTY = "passport_encrypt_key_empty";
    public static final String PASSPORT_LONG_TIME_NO_LOGIN_SWITCH_FAIL = "passport_rust_pipeline_timeout";
    public static final String PASSPORT_OFFLINE_LOGOUT = "passport_offline_logout";
    public static final String PASSPORT_SESSION_INVALID_EMPTY_RESPONSE = "passport_session_invalid_empty_response";
    public static final String PASSPORT_SESSION_RISK_DIALOG = "passport_risk_dialog";
    public static final String PASSPORT_SWITCH_NEXT_VALID_USER_FAIL = "passport_auto_switch_user_failed";
    public static final String PASSPORT_SWITCH_USER_EXCLUDE_LOGIN = "passport_multi_ka_tenant";
    public static final String PASSPORT_SWITCH_USER_RETRY_FAIL = "passport_switch_user_rollback_failed";
    public static final String PASSPORT_USER_LOGOUT_MANUALLY = "passport_user_manually";
    public static final String SECURITY_ACCESS_CONTROL_LOGOUT = "access_condition_logout";
    public static final String SECURITY_APP_LOCK_LOGOUT = "applock_logout";
    public static final String SECURITY_REMOTE_DATA_ERASE = "IAM-SecurityRemoteDataErase";
    public static final String SECURITY_USER_IP_LIMIT_LOGOUT = "tenant_restriction_logout";
    public static final String SETTING_DATA_DEEP_ERASER = "im_setting_data_deep_eraser";

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.a;
    }
}
