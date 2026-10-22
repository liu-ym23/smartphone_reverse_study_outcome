package com.bytedance.common.wschannel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import x5.b;

/* JADX INFO: loaded from: classes.dex */
public class WsConstants {
    public static final String APP_STATE_ACTION = "com.bytedance.article.wschannel.appstate";
    public static final int APP_STATE_DID_ENTER_BACKGROUND_INACTIVE = 3;
    public static final int APP_STATE_DID_ENTER_FOREGROUND = 1;
    public static final int APP_STATE_WILL_ENTER_BACKGROUND = 2;
    public static final int CHANNEL_TYPE_OK = 2;
    public static final String DATA_INTENT = "DATA_INTENT";
    public static final long DEFAULT_IO_LIMIT = 10485760;
    public static final String ERROR_CODE = "error_code";
    public static final int ERROR_CODE_HEART_BEAT_TIMEOUT = 3;
    public static final int ERROR_CODE_NETWORK = 1;
    public static final int ERROR_CODE_RETRY_FAILED = 2;
    public static final int ERROR_CODE_URL_PARSE_FAILED = 4;
    public static final long EXIT_DELAY_TIME = 3000;
    public static final String KEY_APP_ID = "aid";
    public static final String KEY_APP_KEY = "app_key";
    public static final String KEY_APP_STATE = "app_state";
    public static final String KEY_APP_VERSION = "app_version";
    public static final String KEY_CHANNEL_ID = "channel_id";
    public static final String KEY_CHANNEL_TYPE = "channel_type";
    public static final String KEY_CONNECTION = "connection";
    public static final String KEY_CONNECTION_ERROR = "error";
    public static final String KEY_CONNECTION_STATE = "state";
    public static final String KEY_CONNECTION_TYPE = "type";
    public static final String KEY_CONNECTION_URL = "url";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_ENABLE_REPORT_APP_STATE = "enableAppStateChangeReport";
    public static final String KEY_EXTRA = "extra";
    public static final String KEY_FPID = "fpid";
    public static final String KEY_FRONTIER_ENABLED = "frontier_enabled";
    public static final String KEY_FRONTIER_URLS = "frontier_urls";
    public static final String KEY_INSTALL_ID = "iid";
    public static final String KEY_IO_LIMIT = "key_io_limit_size";
    public static final String KEY_NETWORK_STATE = "network_state";
    public static final String KEY_OK_IMPL_ENABLE = "key_ok_impl_enable";
    public static final String KEY_PAYLOAD = "payload";
    public static final String KEY_PAYLOAD_MD5 = "payload_md5";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_RETRY_SEND_MSG_DELAY = "key_retry_send_msg_delay";
    public static final String KEY_SDK_VERSION = "sdk_version";
    public static final String KEY_SEND_RESULT = "send_result";
    public static final String KEY_SESSION_ID = "sid";
    public static final String KEY_WS_APP = "ws_app";
    public static final String KEY_WS_APPS = "ws_apps";
    public static final int MSG_APP_STATE_CHANGE = 2;
    public static final String MSG_COUNT = "msg_count";
    public static final int MSG_INIT = 7;
    public static final int MSG_INTENT = 10123;
    public static final int MSG_NETWORK_STATE_CHANGE = 3;
    public static final int MSG_PARAMETER_CHANGE = 4;
    public static final int MSG_PLUGIN_DOWNLOAD = 6;
    public static final int MSG_RECEIVE_PAYLOAD = 40;
    public static final int MSG_REGISTER = 0;
    public static final int MSG_RELEASE_CLIENT = 8;
    public static final int MSG_RETRY_SEND_PAYLOAD = 10;
    public static final int MSG_SEND_PAYLOAD = 5;
    public static final int MSG_SEND_PAYLOAD_RESULT = 41;
    public static final int MSG_UNREGISTER = 1;
    public static final String NETWORK_STATE_ACTION = "com.bytedance.article.wschannel.networkstate";
    public static final int NETWORK_STATE_NOT_REACHABLE = 2;
    public static final int NETWORK_STATE_REACHABLE_UNKNOWN = 1;
    public static final int NETWORK_STATE_REACHABLE_VIA_WIFI = 3;
    public static final int NETWORK_STATE_REACHABLE_VIA_WWAN = 4;
    public static final int NE_2G = 2;
    public static final int NE_3G = 3;
    public static final int NE_4G = 4;
    public static final int NE_UNKNOWN = 0;
    public static final int NE_WIFI = 1;
    public static final String PING_NOT_RECEIVE_PONG_MSG = "sent ping but didn't receive pong";
    public static final int PLATFORM_ANDROID = 0;
    public static final String PUSH_CHANNEL_LOG_TYPE = "ss_lcs_v2";
    public static final String RECEIVE_CONNECTION_ACTION = "com.bytedance.article.wschannel.receive.connection";
    public static final String RECEIVE_PAYLOAD_ACTION = "com.bytedance.article.wschannel.receive.payload";
    public static final long RELEASE_DELAY = 1000;
    public static final String SALT = "f8a69f1719916z";
    public static final int SDK_VERSION = 2;
    public static final int SELF_CHANNEL = 1;
    public static final String SEND_PAYLOAD_ACTION = "com.bytedance.article.wschannel.send.payload";
    public static final String SYNC_CONNECT_STATE = "com.bytedance.article.wschannel.syncconnectstate";
    public static final int SYNC_SOCKET_STATE = 9;
    public static final int WAKE_UP_PROCESS = 11;
    private static b sListener;
    private static Map<Integer, e6.b> sStates;

    static {
        sStates = new ConcurrentHashMap();
    }

    public WsConstants() {
    }

    public static b getListener(int r8) {
        return null;
    }

    public static boolean isWsChannelConnected(int r8) {
        if (sStates.get(Integer.valueOf(r8)) != e6.b.f7131p) goto L5;
        return true;
    L5:
        return false;
    }

    public static void remove(int r8) {
        sStates.remove(Integer.valueOf(r8));
    }

    public static void setConnectionState(int r8, e6.b r10) {
        sStates.put(Integer.valueOf(r8), r10);
    }

    public static void setOnMessageReceiveListener(b r8) {
    }
}
