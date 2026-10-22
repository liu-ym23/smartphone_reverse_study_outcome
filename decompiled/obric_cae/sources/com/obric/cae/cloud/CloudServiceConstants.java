package com.obric.cae.cloud;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: loaded from: classes.dex */
public class CloudServiceConstants {

    public static class OBtSettings {
        public static final String SETTINGS_CAE_CONFIG_SOLUTION = "solution";
        public static final String SETTINGS_CAE_CONFIG_SOLUTION_VERSION = "version";
        public static final String SETTINGS_CAE_CONFIG_THREADHOLD = "threshold";
        public static final String SETTINGS_CAE_CONFIG_TYPE = "type";

        public OBtSettings() {
        }
    }

    public static class OCloud {
        public static final String BUSINESS_TYPE = "business_type";
        public static final int BUSINESS_TYPE_BT = 1;
        public static final int BUSINESS_TYPE_DEFAULT = -1;
        public static final int BUSINESS_TYPE_GPS = 3;
        public static final int BUSINESS_TYPE_NFC = 4;
        public static final int BUSINESS_TYPE_WIFI = 2;
        public static final String CATEGORY = "category";
        public static final String ERROR_CODE = "error_code";
        public static final String ERROR_COUNT = "error_count";
        public static final String ERROR_LIST = "error_list";
        public static final String ERROR_MESSAGE = "error_message";
        public static final String FIXED = "fixed";
        public static final String HEADER = "header";
        public static final String HEADER_APP_VERSION = "app_version";
        public static final String HEADER_DEVICE_ID = "device_id";
        public static final String HEADER_OS_VERSION = "os_version";
        public static final String ISSUE_ID = "issue_id";
        public static final String LAST_HAPPENED_TIME = "last_happened_time";
        public static final String MODULE = "module";
        public static final String OPTIMIZE_ITEM = "optimize_item";
        public static final int OPTIMIZE_ITEM_COMPATIBILITY = 1;
        public static final int OPTIMIZE_ITEM_POWER = 3;
        public static final int OPTIMIZE_ITEM_QOS = 2;
        public static final String PROFILE_COUNT = "profile_count";
        public static final String PROFILE_TYPE = "profile_type";
        public static final String REMOTE_CODE = "remote_cod";
        public static final String REMOTE_DEVICE_INFO = "remote_device_info";
        public static final String REMOTE_DEVICE_NAME = "remote_device_name";
        public static final String REMOTE_MAC = "remote_mac";
        public static final String SOLUTION = "solution";
        public static final String UNIQUE_ID = "unique_id";
        public static final String UPLOADED = "uploaded";
        public static final String UPLOADED_TIME = "uploaded_time";

        public OCloud() {
        }
    }

    public static class OSettings {
        public static final String CAE_CONFIG = "cae_config";
        public static final String CAE_CONFIG_MODULE = "business_type";
        public static final int CAE_CONFIG_MODULE_BT = 1;
        public static final int CAE_CONFIG_MODULE_DEFAULT = -1;
        public static final int CAE_CONFIG_MODULE_GPS = 5;
        public static final int CAE_CONFIG_MODULE_LE = 2;
        public static final int CAE_CONFIG_MODULE_NFC = 4;
        public static final String CAE_CONFIG_MODULE_OSETTINGS = "module";
        public static final String CAE_CONFIG_MODULE_SLARDAR = "business_type";
        public static final String CAE_CONFIG_MODULE_TYPE_BT = "bluetooth";
        public static final String CAE_CONFIG_MODULE_TYPE_DEFAULT = "";
        public static final String CAE_CONFIG_MODULE_TYPE_GPS = "gps";
        public static final String CAE_CONFIG_MODULE_TYPE_LE = "ble";
        public static final String CAE_CONFIG_MODULE_TYPE_NFC = "nfc";
        public static final String CAE_CONFIG_MODULE_TYPE_USER_AWARE = "user_aware";
        public static final String CAE_CONFIG_MODULE_TYPE_WIFI = "wifi";
        public static final int CAE_CONFIG_MODULE_USER_AWARE = 6;
        public static final int CAE_CONFIG_MODULE_WIFI = 3;
        private static Map<String, Integer> OSettingMap = null;
        public static final String TAG_CLOUD_CONFIG = "cloud_config";

        static {
            OSettingMap = Map.ofEntries(new Map.Entry[]{Map.entry(CAE_CONFIG_MODULE_TYPE_BT, 1), Map.entry(CAE_CONFIG_MODULE_TYPE_LE, 2), Map.entry("wifi", 3), Map.entry("nfc", 4), Map.entry(CAE_CONFIG_MODULE_TYPE_GPS, 5), Map.entry("user_aware", 6)});
        }

        public OSettings() {
        }

        public static String mapIntToString(int r8) {
            Iterator<Map.Entry<String, Integer>> r10 = OSettingMap.entrySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            Map.Entry<String, Integer> r11 = r10.next();
            if (r11.getValue().equals(Integer.valueOf(r8)) == false) goto L4;
            return r11.getKey();
        L9:
            return "";
        }

        public static int mapStringToint(String r8) {
            Optional r10 = Optional.ofNullable(r8);
            final Map<String, Integer> r11 = OSettingMap;
            Objects.requireNonNull(r11);
            Optional r12 = r10.filter(new a(r11));
            final Map<String, Integer> r13 = OSettingMap;
            Objects.requireNonNull(r13);
            return ((Integer) r12.map(new b(r13)).orElse(-1)).intValue();
        }
    }

    public static class OSlardars {
        public static final String CAE_ACTION = "com.slardaros.caeconfig";
        public static final String CAE_TEST_ACTION = "com.slardaros.test.MONITOR";

        public OSlardars() {
        }
    }

    public static class OWifiSettingsConfig {
        public static final String CAE_WIFI_CONFIG_CN_URL = "cn_url";
        public static final String CAE_WIFI_CONFIG_GLOBAL_URL = "global_url";
        public static final String CAE_WIFI_CONFIG_USE_HTTPS = "use_https";

        public OWifiSettingsConfig() {
        }
    }

    public CloudServiceConstants() {
    }
}
