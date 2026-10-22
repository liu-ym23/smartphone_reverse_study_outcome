package com.ss.android.lark.dynamicconfig.v2.interfaces;

import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.bytedance.lark.pb.basic.v1.InitSDKRequest;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import jcb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IGlobalDomainConfigService {

    @Retention(RetentionPolicy.SOURCE)
    public @interface DomainAlias {
        public static final String API = "api";
        public static final String APPLINK = "applink";
        public static final String APPLINK_PEER = "applink_peer";
        public static final String BASIC_MODE = "basic_mode";
        public static final String BYTE_CERT = "byte_cert";
        public static final String CDN = "cdn";
        public static final String CJ_HONGBAO = "cj_hongbao";
        public static final String COLLABORATIVE_LIST = "group_more_collaborativelist";
        public static final String CONTACT = "contact";
        public static final String CSC_OCIC = "csc_ocic";
        public static final String DETECT_DOCS_API = "detect_docs_api";
        public static final String DEVICE = "device";
        public static final String DOCS = "docs";
        public static final String DOCS_ACCOUNT_DELETE_NOTICE = "docs_account_delete_notice";
        public static final String DOCS_API = "docs_api";
        public static final String DOCS_DRIVE = "docs_drive";
        public static final String DOCS_FEED = "docs_feed";
        public static final String DOCS_FE_RESOURCE_HOTFIX = "docs_fe_resource_hotfix";
        public static final String DOCS_FRONTIER = "docs_frontier";
        public static final String DOCS_HOME = "docs_home";
        public static final String DOCS_LONG = "docs_long";
        public static final String DOCS_MAIN_DOMAIN = "docs_main_domain";
        public static final String DOCS_PEER = "docs_peer";
        public static final String DRIVE = "drive";
        public static final String EMAIL = "email";
        public static final String EMAIL_BFF = "email_bff";
        public static final String EMAIL_COVER_CDN_PATH = "mail_cover_cdn_path";
        public static final String EMM = "emm";
        public static final String EMS_OA = "ems_oa";
        public static final String FEISHU_PRE_RTC = "feishu_pre_rtc";
        public static final String FEISHU_RTC = "feishu_rtc";
        public static final String FEISHU_TEST_GAUSS_RTC = "feishu_test_gauss_rtc";
        public static final String FEISHU_TEST_PRE_RTC = "feishu_test_pre_rtc";
        public static final String FEISHU_TEST_RTC = "feishu_test_rtc";
        public static final String FILE = "file";
        public static final String GECKO = "gecko";
        public static final String GO = "go";
        public static final String GROUP_QR_CODE = "group_qr_code";
        public static final String HELPDESK = "helpdesk";
        public static final String HELP_CENTER = "help_center";
        public static final String HELP_DOCUMENT = "help_document";
        public static final String HTTPDNS = "httpdns";
        public static final String INTERNAL_API = "internal_api";
        public static final String LARK_PRE_RTC = "lark_pre_rtc";
        public static final String LARK_RTC = "lark_rtc";
        public static final String LARK_TEST_GAUSS_RTC = "lark_test_gauss_rtc";
        public static final String LARK_TEST_PRE_RTC = "lark_test_pre_rtc";
        public static final String LARK_TEST_RTC = "lark_test_rtc";
        public static final String LOG = "log";
        public static final String LONG = "long";
        public static final String LONG_RTC = "long_rtc";
        public static final String MG_MEEGO = "mg_meego";
        public static final String MG_PROJECT = "mg_project";
        public static final String MINA = "mina";
        public static final String MOCK_GATEWAY = "mock_gateway";
        public static final String MP_APPLINK = "mp_applink";
        public static final String MP_CONFIG = "mp_config";
        public static final String MP_REFER = "mp_refer";
        public static final String MP_TT = "mp_tt";
        public static final String NTP = "ntp";
        public static final String OAPI = "oapi";
        public static final String OPEN = "open";
        public static final String OPEN_API_LOGIN = "open_api_login";
        public static final String OPEN_APPCENTER1 = "open_appcenter1";
        public static final String OPEN_APPCENTER2 = "open_appcenter2";
        public static final String OPEN_APPCENTER3 = "open_appcenter3";
        public static final String OPEN_APPCENTER_CARDJUMP = "open_appcenter_cardjump";
        public static final String OPEN_APPLINK_SCHEMA_ENABLE_HOST = "open_applink_schema_enable_host";
        public static final String OPEN_APPSTORE = "open_appstore";
        public static final String OPEN_APP_FEED = "open_app_feed";
        public static final String OPEN_APP_INTERFACE = "open_app_interface";
        public static final String OPEN_JSSDK_CONFIG = "open_jssdk_config";
        public static final String OPEN_MOMENT = "open_moment";
        public static final String OPEN_MSG_CARD = "open_msg_card";
        public static final String OPEN_PKM = "open_pkm";
        public static final String PANO = "pano";
        public static final String PASSPORT = "passport";
        public static final String PASSPORT_ACCOUNTS = "passport_accounts";
        public static final String PASSPORT_TURING = "passport_turing";
        public static final String PEOPLE = "people";
        public static final String PRIVACY = "privacy";
        public static final String RTC_DECISION = "rtc_decision";
        public static final String RTC_DEFAULTIPS = "rtc_defaultips";
        public static final String RTC_FRONTIER = "rtc_frontier";
        public static final String RTC_LOG_REPORT = "rtc_log_report";
        public static final String RTC_RESOURCE_MANAGER = "rtc_resource_manager";
        public static final String SECURITY_AND_COMPLIANCE = "security_and_compliance";
        public static final String SECURITY_LOGIN_RESTRICTION = "security_login_restriction";
        public static final String SECURITY_WEB = "security_web";
        public static final String SENTRY = "sentry";
        public static final String SHORT_RTC = "short_rtc";
        public static final String SLARDAR_LOG_COLLECT = "slardar_log_collect";
        public static final String SUITE_ADMIN = "suite_admin";
        public static final String SUITE_ANDROID_HOTFIX = "suite_android_hotfix";
        public static final String SUITE_APPCONFIG = "suite_appconfig";
        public static final String SUITE_IMAGE_CDN = "suite_image_cdn";
        public static final String SUITE_MAIN_DOMAIN = "suite_main_domain";
        public static final String SUITE_PAN_CDN = "suite_pan_cdn";
        public static final String SUITE_REPORT = "suite_report";
        public static final String SUITE_SAFETYNET = "suite_safetynet";
        public static final String SUITE_SECSDK = "suite_secsdk";
        public static final String SUITE_SECURITY_LINK = "suite_security_link";
        public static final String SUITE_TKLOG = "suite_tklog";
        public static final String TNS_REPORT = "tns_report";
        public static final String TNS_REPORT_FEISHU = "tns_report_feishu";
        public static final String TNS_REPORT_LARK = "tns_report_lark";
        public static final String TTNET_HTTPDNS = "ttnet_httpdns";
        public static final String TTNET_NETLOG = "ttnet_netlog";
        public static final String TTNET_TNC = "ttnet_tnc";
        public static final String TTPUSH = "ttpush";
        public static final String TTWEBVIEW_SETTING_HOST = "ttwebview_settings_host";
        public static final String TT_ABTEST = "tt_abtest";
        public static final String TT_APPLOG = "tt_applog";
        public static final String TT_CDN = "tt_cdn";
        public static final String TT_DNS_SERVER_HOST = "tt_dns_server_host";
        public static final String TT_ET = "tt_et";
        public static final String TT_GOOGLE_DNS = "tt_google_dns";
        public static final String TT_GRAYLOG = "tt_graylog";
        public static final String TT_MUSICAL = "tt_musical";
        public static final String TT_NPTH = "tt_npth";
        public static final String TT_SLARDAR = "tt_slardar";
        public static final String TT_SLARDAR_CRASH_HOST_IOS = "tt_slardar_crash_host_ios";
        public static final String TT_SLARDAR_EXCEPTION = "tt_slardar_exception";
        public static final String TT_SLARDAR_EXCEPTION_HOST_IOS = "tt_slardar_exception_host_ios";
        public static final String TT_SLARDAR_REPORT = "tt_slardar_report";
        public static final String TT_SLARDAR_SETTING = "tt_slardar_setting";
        public static final String TT_TEA = "tt_tea";
        public static final String UG_ACTIVITY = "ug_activity";
        public static final String VC_MM = "vc_mm";
        public static final String VC_PRIVACY = "vc_privacy";
        public static final String VC_WEB = "vc_web";
        public static final String VOD = "vod";
        public static final String VPN = "vpn";
    }

    List<String> A(String r1, String r2);

    void K0(String r1, InitSDKRequest.EnvType r2, String r3, String r4, DomainSettings r5);

    void Yb(String r1, a r2);

    String e0(String r1, String r2);

    String f0();

    void h0(Map<String, List<String>> r1);

    Map<String, List<String>> o0(String r1);

    List<String> p0(String r1, int r2, String r3, String r4);

    void preload();

    void sd(String r1, a r2);
}
