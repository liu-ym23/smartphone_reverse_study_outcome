package com.obric.cae.smartBluetooth;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.obric.cae.libs.bluetooth.CaeBluetoothEvent;
import com.obric.cae.log.CaeLog;
import com.obric.cae.provider.CaeProvider;
import com.obric.cae.utils.CaeProviderUtils;
import com.obric.cae.utils.CaeUtil;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SmartBluetoothDatabase {
    private static final String A2DP_JITTER_ML_SELECTION = "MAC =? AND Fence_location =?";
    private static final String ADDRESS_BASED_PREFIX = "Address_Based";
    private static final String CAE_EVENT_SELECTION = "Detail_msg =? AND MAC =?";
    private static final int FIXED = 1;
    private static final int FIXED_REPRODUCE = 2;
    private static final int MODULE_BLUETOOTH = 1;
    private static final String MODULE_BLUETOOTH_TYPE = "bluetooth";
    private static final int OPTIMIZE_ITEM_COMPATIBILITY = 1;
    private static final int OPTIMIZE_ITEM_QOS = 2;
    private static final String POST_INFO_JSON_KEY_APP_VERSION = "app_version";
    private static final String POST_INFO_JSON_KEY_BUSINESS_TYPE = "business_type";
    private static final String POST_INFO_JSON_KEY_CATEGORY = "category";
    private static final String POST_INFO_JSON_KEY_DEVICE_ID = "device_id";
    private static final String POST_INFO_JSON_KEY_ERROR_CODE = "error_code";
    private static final String POST_INFO_JSON_KEY_ERROR_COUNT = "error_count";
    private static final String POST_INFO_JSON_KEY_ERROR_LIST = "error_list";
    private static final String POST_INFO_JSON_KEY_ERROR_MESSAGE = "error_message";
    private static final String POST_INFO_JSON_KEY_ERROR_UNIQUE_ID = "unique_id";
    private static final String POST_INFO_JSON_KEY_FIXED = "fixed";
    private static final String POST_INFO_JSON_KEY_HEADER = "header";
    private static final String POST_INFO_JSON_KEY_ISSUE_ID = "issue_id";
    private static final String POST_INFO_JSON_KEY_LAST_HAPPENED_TIME = "last_happened_time";
    private static final String POST_INFO_JSON_KEY_MODULE = "module";
    private static final String POST_INFO_JSON_KEY_OPTIMIZE_ITEM = "optimize_item";
    private static final String POST_INFO_JSON_KEY_OS_VERSION = "os_version";
    private static final String POST_INFO_JSON_KEY_PROFILE_COUNT = "profile_count";
    private static final String POST_INFO_JSON_KEY_PROFILE_TYPE = "profile_type";
    private static final String POST_INFO_JSON_KEY_REMOTE_COD = "remote_cod";
    private static final String POST_INFO_JSON_KEY_REMOTE_DEVICE_INFO = "remote_device_info";
    private static final String POST_INFO_JSON_KEY_REMOTE_DEVICE_NAME = "remote_device_name";
    private static final String POST_INFO_JSON_KEY_REMOTE_MAC = "remote_mac";
    private static final String POST_INFO_JSON_KEY_SN = "sn";
    private static final String POST_INFO_JSON_KEY_SOLUTION = "solution";
    private static final String POST_INFO_JSON_KEY_UPLOADED = "uploaded";
    private static final String POST_INFO_JSON_KEY_UPLOADED_TIME = "uploaded_time";
    private static final String PROFILE_CONNECT_EVENT_SELECTION = "MAC =? AND Profile_type =?";
    private static final String SOLUTION_JSON_KEY_ADDRESS_BASED = "Address_Based";
    private static final String SOLUTION_JSON_KEY_FEATURE = "feature";
    private static final String TAG = "SmartBluetoothDatabase";
    private static final int UNFIXED = 0;
    private static final int UNUPLOADED = 0;
    private static final int UPLOADED = 1;
    private Context mContext;

    public static class A2dpJitterMlRecord {
        public String mAddress;
        public int mAutoOptimizeCount;
        public String mDeviceName;
        public String mFenceLocation;
        public String mLastOptimizeTime;
        public boolean mManualDisabled;
        public int mOptimizeCount;
        public int mSevereTriggerCount;

        public A2dpJitterMlRecord() {
        }
    }

    public SmartBluetoothDatabase(Context r8) {
        this.mContext = r8;
    }

    private String buildFieldSolution(String r8, String r10) {
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L4
        JSONArray r12 = new JSONArray();     // Catch: JSONException -> L4
        JSONObject r13 = new JSONObject();     // Catch: JSONException -> L4
        r13.put("Address_Based", r10.substring(0, 8));     // Catch: JSONException -> L4
        r12.put(r13);     // Catch: JSONException -> L4
        r11.put(r8, r12);     // Catch: JSONException -> L4
        return r11.toString();
    L4:
        e = move-exception;
        CaeLog.e(TAG, "" + e);
        return null;
    }

    private int parseInt(String r8, int r10) {
        if (r8 != null) goto L8;
        return r10;
    L8:
        return Integer.parseInt(r8);
    L6:
        CaeLog.w(TAG, "parseInt failed: ".concat(r8));
        return r10;
    }

    public String buildPostCaeInfo(CaeBluetoothEvent r13) {
        if (r13 != null) goto L6;
        CaeLog.w(TAG, "caeBluetoothEvent is null");     // Catch: JSONException -> L30
        return null;
    L6:
        String r8 = queryCaeInfoField(r13, CaeProvider.CompatibilityEntry.SOLUTION);     // Catch: JSONException -> L30
        if (r8 != null) goto L10;
        CaeLog.w(TAG, "solution is null");     // Catch: JSONException -> L30
        return null;
    L10:
        BluetoothDevice r10 = r13.getBluetoothDevice();     // Catch: JSONException -> L30
        if (r10 != null) goto L13;
    L28:
        CaeLog.w(TAG, "buildPostCaeInfo: bluetooth device or address is null");     // Catch: JSONException -> L30
        return null;
    L13:
        if (r10.getAddress() == null) goto L28;
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L30
        r11.put("business_type", "bluetooth");     // Catch: JSONException -> L30
        r11.put("optimize_item", 1);     // Catch: JSONException -> L30
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L30
        int r14 = 0;
        r12.put("device_id", 0);     // Catch: JSONException -> L30
        r12.put("os_version", "");     // Catch: JSONException -> L30
        r12.put("app_version", "1.0");     // Catch: JSONException -> L30
        r12.put(POST_INFO_JSON_KEY_SN, Build.getSerial());     // Catch: JSONException -> L30
        r11.put("header", r12);     // Catch: JSONException -> L30
        JSONObject r15 = new JSONObject();     // Catch: JSONException -> L30
        r15.put("remote_mac", r10.getAddress());     // Catch: JSONException -> L30
        BluetoothClass r16 = r10.getBluetoothClass();     // Catch: JSONException -> L30
        if (r16 == null) goto L18;
        int r17 = r16.getDeviceClass();     // Catch: JSONException -> L30
    L19:
        r15.put("remote_cod", r17);     // Catch: JSONException -> L30
        if (r10.getName() != null) goto L22;
        String r18 = "";
    L23:
        r15.put("remote_device_name", r18);     // Catch: JSONException -> L30
        r15.put("profile_count", getProfileCount(r13.getBluetoothDevice(), r13.getProfile()));     // Catch: JSONException -> L30
        r11.put("remote_device_info", r15);     // Catch: JSONException -> L30
        JSONArray r19 = new JSONArray();     // Catch: JSONException -> L30
        JSONObject r20 = new JSONObject();     // Catch: JSONException -> L30
        r20.put("unique_id", CaeUtil.getCaePostInfoHash(CaeUtil.concatByteArrays(new byte[][]{r13.getDetailMessage().getBytes(), r10.getAddress().getBytes(), CaeUtil.getCurrentTime().getBytes()})));     // Catch: JSONException -> L30
        r20.put("module", 1);     // Catch: JSONException -> L30
        r20.put("profile_type", r13.getProfile());     // Catch: JSONException -> L30
        r20.put("category", r13.getCategory());     // Catch: JSONException -> L30
        r20.put("error_code", queryCaeInfoField(r13, CaeProvider.CompatibilityEntry.ERR_CODE));     // Catch: JSONException -> L30
        r20.put("error_message", r13.getDetailMessage());     // Catch: JSONException -> L30
        String r21 = queryCaeInfoField(r13, CaeProvider.CompatibilityEntry.ERR_COUNT);     // Catch: JSONException -> L30
        if (r21 == null) goto L26;
        r14 = Integer.parseInt(r21);     // Catch: JSONException -> L30
    L26:
        r20.put("error_count", r14);     // Catch: JSONException -> L30
        r20.put("last_happened_time", queryCaeInfoField(r13, CaeProvider.CompatibilityEntry.LAST_HAPPENED_TIME));     // Catch: JSONException -> L30
        r20.put("solution", r8);     // Catch: JSONException -> L30
        r20.put("issue_id", CaeUtil.calculateBluetoothIssueId(r13));     // Catch: JSONException -> L30
        r19.put(r20);     // Catch: JSONException -> L30
        r11.put("error_list", r19);     // Catch: JSONException -> L30
        return r11.toString();
    L22:
        r18 = r10.getName();     // Catch: JSONException -> L30
        goto L23
    L18:
        r17 = 0;
    L30:
        e = move-exception;
        CaeLog.e(TAG, "" + e);
        return null;
    }

    public A2dpJitterMlRecord getA2dpJitterMlRecord(String r8, String r10) {
        A2dpJitterMlRecord r11 = null;
        if (r8 == null) goto L13;
        if (r10 == null) goto L13;
        Map<String, String> r12 = CaeProviderUtils.queryDatabaseEntry(this.mContext, CaeProviderUtils.BLUETOOTH_A2DP_JITTER_ML_URI, A2DP_JITTER_ML_SELECTION, new String[]{r8, r10});
        if (r12 != null) goto L9;
        return null;
    L9:
        r11 = new A2dpJitterMlRecord();
        r11.mAddress = r8;
        r11.mFenceLocation = r10;
        r11.mDeviceName = r12.get("Remote_Device_name");
        boolean r13 = false;
        r11.mOptimizeCount = parseInt(r12.get(CaeProvider.A2dpJitterMlEntry.OPTIMIZE_COUNT), 0);
        r11.mSevereTriggerCount = parseInt(r12.get(CaeProvider.A2dpJitterMlEntry.SEVERE_TRIGGER_COUNT), 0);
        r11.mAutoOptimizeCount = parseInt(r12.get(CaeProvider.A2dpJitterMlEntry.AUTO_OPTIMIZE_COUNT), 0);
        if (parseInt(r12.get(CaeProvider.A2dpJitterMlEntry.MANUAL_DISABLED), 0) != 1) goto L12;
        r13 = true;
    L12:
        r11.mManualDisabled = r13;
        r11.mLastOptimizeTime = r12.get(CaeProvider.A2dpJitterMlEntry.LAST_OPTIMIZE_TIME);
    L13:
        return r11;
    }

    public int getProfileCount(BluetoothDevice r8, int r10) {
        if (r8 != null) goto L5;
    L12:
        CaeLog.w(TAG, "getProfileCount: device or address is null, return 0.");
        return 0;
    L5:
        if (r8.getAddress() == null) goto L12;
        CaeLog.d(TAG, "getProfileCount: " + CaeUtil.maskMacOrBssid(r8.getAddress()) + ", profile: " + r10);
        String r11 = CaeProviderUtils.queryDatabaseKeyValue(this.mContext, CaeProviderUtils.BLUETOOTH_PROFILE_INFO_URI, PROFILE_CONNECT_EVENT_SELECTION, new String[]{r8.getAddress(), String.valueOf(r10)}, CaeProvider.ProfileInfoEntry.PROFILE_COUNT);
        if (r11 != null) goto L10;
        return 0;
    L10:
        return Integer.parseInt(r11);
    }

    public boolean isA2dpJitterMlManualDisabled(String r8, String r10) {
        A2dpJitterMlRecord r11 = getA2dpJitterMlRecord(r8, r10);
        if (r11 != null) goto L5;
    L7:
        return false;
    L5:
        if (r11.mManualDisabled == false) goto L7;
        return true;
    }

    public boolean isThresholdReached(CaeBluetoothEvent r8) {
        CaeLog.d(TAG, "isThresholdReached");
        String r10 = queryCaeInfoField(r8, CaeProvider.CompatibilityEntry.ERR_COUNT);
        if (r10 == null) goto L5;
        int r11 = Integer.parseInt(r10);
    L7:
        if (r11 < CaeUtil.getIssueCheckingThreshold(this.mContext)) goto L10;
        return true;
    L10:
        return false;
    L5:
        r11 = 0;
        goto L7
    }

    public void markA2dpJitterMlManualDisabled(String r8, String r10) {
        if (r8 == null) goto L11;
        if (r10 != null) goto L6;
        return;
    L6:
        if (getA2dpJitterMlRecord(r8, r10) != null) goto L9;
        CaeLog.w(TAG, "markA2dpJitterMlManualDisabled: record not found.");
        return;
    L9:
        CaeProviderUtils.updateDatabaseKeyType(this.mContext, CaeProviderUtils.BLUETOOTH_A2DP_JITTER_ML_URI, A2DP_JITTER_ML_SELECTION, new String[]{r8, r10}, new String[]{CaeProvider.A2dpJitterMlEntry.MANUAL_DISABLED}, new String[]{"1"});
        return;
    }

    public void markA2dpJitterMlOptimized(BluetoothDevice r20, String r21, boolean r22, boolean r23) {
        if (r20 != null) goto L5;
    L45:
        CaeLog.w(TAG, "markA2dpJitterMlOptimized: invalid args.");
        return;
    L5:
        if (r20.getAddress() == null) goto L45;
        if (r21 == null) goto L45;
        String r8 = r20.getAddress();
        A2dpJitterMlRecord r10 = getA2dpJitterMlRecord(r8, r21);
        if (r10 != null) goto L11;
        int r11 = 1;
    L13:
        if (r10 != null) goto L15;
        int r12 = 0;
    L16:
        if (r10 != null) goto L18;
        int r13 = 0;
    L19:
        if (r10 != null) goto L21;
    L23:
        int r14 = 0;
    L24:
        if (r22 == false) goto L26;
        r12 = r12 + 1;
    L26:
        if (r23 == false) goto L28;
        r13 = r13 + 1;
    L28:
        String r15 = CaeUtil.getCurrentTimeFormatted();
        String r16 = "";
        if (r10 != null) goto L35;
        CaeProviderUtils.caeEntryClass r17 = new CaeProviderUtils.caeEntryClass();
        CaeProviderUtils.BtA2dpJitterMlEntry r18 = new CaeProviderUtils.BtA2dpJitterMlEntry();
        r18.MAC = r8;
        if (r20.getName() == null) goto L34;
        r16 = r20.getName();
    L34:
        r18.Remote_Device_name = r16;
        r18.Fence_location = r21;
        r18.Optimize_count = r11;
        r18.Severe_trigger_count = r12;
        r18.Auto_optimize_count = r13;
        r18.Manual_disabled = r14;
        r18.Last_optimize_time = r15;
        r17.setData(r18);
        CaeProviderUtils.saveToDatabase(this.mContext, CaeProviderUtils.BLUETOOTH_A2DP_JITTER_ML_URI, r17);
        return;
    L35:
        Context r19 = this.mContext;
        Uri r24 = CaeProviderUtils.BLUETOOTH_A2DP_JITTER_ML_URI;
        String[] r25 = {r8, r21};
        String[] r26 = {"Remote_Device_name", CaeProvider.A2dpJitterMlEntry.OPTIMIZE_COUNT, CaeProvider.A2dpJitterMlEntry.SEVERE_TRIGGER_COUNT, CaeProvider.A2dpJitterMlEntry.AUTO_OPTIMIZE_COUNT, CaeProvider.A2dpJitterMlEntry.MANUAL_DISABLED, CaeProvider.A2dpJitterMlEntry.LAST_OPTIMIZE_TIME};
        String[] r110 = new String[6];
        if (r20.getName() == null) goto L39;
        r16 = r20.getName();
    L39:
        r110[0] = r16;
        r110[1] = String.valueOf(r11);
        r110[2] = String.valueOf(r12);
        r110[3] = String.valueOf(r13);
        if (r14 == 0) goto L42;
        String r27 = "1";
    L43:
        r110[4] = r27;
        r110[5] = r15;
        CaeProviderUtils.updateDatabaseKeyType(r19, r24, A2DP_JITTER_ML_SELECTION, r25, r26, r110);
        return;
    L42:
        r27 = "0";
        goto L43
    L21:
        if (r10.mManualDisabled == false) goto L23;
        r14 = 1;
        goto L24
    L18:
        r13 = r10.mAutoOptimizeCount;
        goto L19
    L15:
        r12 = r10.mSevereTriggerCount;
        goto L16
    L11:
        r11 = r10.mOptimizeCount + 1;
        goto L13
    }

    public String queryCaeInfoField(CaeBluetoothEvent r8, String r10) {
        if (r8 != null) goto L5;
    L12:
        return null;
    L5:
        if (r8.getBluetoothDevice() == null) goto L12;
        String r11 = r8.getBluetoothDevice().getAddress();
        if (r11 != null) goto L11;
        return null;
    L11:
        return queryCaeInfoField(r8.getDetailMessage(), r11, r10);
    }

    public boolean shouldAutoOptimizeA2dpJitterMl(String r8, String r10, int r11) {
        A2dpJitterMlRecord r12 = getA2dpJitterMlRecord(r8, r10);
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (r12.mSevereTriggerCount < r11) goto L7;
        return true;
    }

    public void storeCaeEventToDB(CaeBluetoothEvent r11) {
        String r8 = TAG;
        CaeLog.d(r8, "storeCaeEventToDB");
        if (r11 != null) goto L5;
    L29:
        CaeLog.w(r8, "storeCaeEventToDB: bluetooth device or address is null, skip store.");
        return;
    L5:
        if (r11.getBluetoothDevice() == null) goto L29;
        if (r11.getBluetoothDevice().getAddress() == null) goto L29;
        int r10 = CaeUtil.calculateBluetoothIssueId(r11);
        String r12 = r11.getBluetoothDevice().getAddress();
        Context r13 = this.mContext;
        Uri r14 = CaeProviderUtils.BLUETOOTH_COMPATIBILITY_URI;
        Map<String, String> r15 = CaeProviderUtils.queryDatabaseEntry(r13, r14, CAE_EVENT_SELECTION, new String[]{r11.getDetailMessage(), r12});
        int r16 = 0;
        if (r15 != null) goto L12;
        CaeProviderUtils.caeEntryClass r17 = new CaeProviderUtils.caeEntryClass();
        CaeProviderUtils.BtCompatibilityEntry r18 = new CaeProviderUtils.BtCompatibilityEntry();
        r18.Module = 1;
        r18.Profile_type = r11.getProfile();
        r18.Category = r11.getCategory();
        r18.MAC = r11.getBluetoothDevice().getAddress();
        BluetoothClass r19 = r11.getBluetoothDevice().getBluetoothClass();
        if (r19 == null) goto L24;
        r16 = r19.getDeviceClass();
    L24:
        r18.COD = r16;
        String r20 = r11.getBluetoothDevice().getName();
        if (r20 != null) goto L27;
        r20 = "";
    L27:
        r18.Remote_Device_name = r20;
        r18.Detail_msg = r11.getDetailMessage();
        r18.Err_count = 1;
        r18.Last_happened_time = CaeUtil.getCurrentTimeFormatted();
        r18.Issue_id = r10;
        r17.setData(r18);
        CaeProviderUtils.saveToDatabase(this.mContext, r14, r17);
        return;
    L12:
        if (r15.containsKey(CaeProvider.CompatibilityEntry.ERR_COUNT) == false) goto L14;
        int r21 = Integer.parseInt(r15.get(CaeProvider.CompatibilityEntry.ERR_COUNT));
    L16:
        if (r15.containsKey(CaeProvider.CompatibilityEntry.FIXED) == false) goto L20;
        r16 = Integer.parseInt(r15.get(CaeProvider.CompatibilityEntry.FIXED));
        if (r16 != 1) goto L20;
        CaeLog.d(r8, "fixed issue has been reproduced.");
        r16 = 2;
    L20:
        CaeProviderUtils.updateDatabaseKeyType(this.mContext, r14, CAE_EVENT_SELECTION, new String[]{r11.getDetailMessage(), r12}, new String[]{CaeProvider.CompatibilityEntry.ERR_COUNT, CaeProvider.CompatibilityEntry.FIXED, CaeProvider.CompatibilityEntry.LAST_HAPPENED_TIME}, new String[]{String.valueOf(r21 + 1), String.valueOf(r16), CaeUtil.getCurrentTimeFormatted()});
        return;
    L14:
        r21 = 0;
        goto L16
    }

    public void storeProfileConnectedEventToDB(BluetoothDevice r8, int r10) {
        String r11 = TAG;
        defpackage.b.m("storeProfileConnectedEventToDB: ", r10, r11);
        if (r8 != null) goto L5;
    L12:
        CaeLog.w(r11, "storeProfileConnectedEventToDB: device or address is null, skip.");
        return;
    L5:
        if (r8.getAddress() == null) goto L12;
        Context r12 = this.mContext;
        Uri r13 = CaeProviderUtils.BLUETOOTH_PROFILE_INFO_URI;
        String r14 = CaeProviderUtils.queryDatabaseKeyValue(r12, r13, PROFILE_CONNECT_EVENT_SELECTION, new String[]{r8.getAddress(), String.valueOf(r10)}, CaeProvider.ProfileInfoEntry.PROFILE_COUNT);
        if (r14 == null) goto L10;
        int r15 = Integer.parseInt(r14);
        CaeProviderUtils.updateDatabaseKeyType(this.mContext, r13, PROFILE_CONNECT_EVENT_SELECTION, new String[]{r8.getAddress(), String.valueOf(r10)}, new String[]{CaeProvider.ProfileInfoEntry.PROFILE_COUNT}, new String[]{String.valueOf(r15 + 1)});
        return;
    L10:
        CaeProviderUtils.caeEntryClass r16 = new CaeProviderUtils.caeEntryClass();
        CaeProviderUtils.BtProfileInfoEntry r17 = new CaeProviderUtils.BtProfileInfoEntry();
        r17.Module = 1;
        r17.Profile_count = 1;
        r17.Profile_type = r10;
        r17.MAC = r8.getAddress();
        r16.setData(r17);
        CaeProviderUtils.saveToDatabase(this.mContext, r13, r16);
    }

    public void updateCaePolicyInfoToDB(CaeBluetoothEvent r10, SmartBluetoothPolicy.PolicyProperties r11) {
        String r8 = TAG;
        CaeLog.d(r8, "updateCaePolicyInfoToDB");
        if (r10 != null) goto L5;
    L11:
        CaeLog.w(r8, "updateCaePolicyInfoToDB: bluetooth device or address is null, skip update.");
        return;
    L5:
        if (r10.getBluetoothDevice() == null) goto L11;
        if (r10.getBluetoothDevice().getAddress() == null) goto L11;
        String r12 = r11.getErrorCode();
        String r13 = r10.getBluetoothDevice().getAddress();
        String r14 = buildFieldSolution(r11.getSolution(), r10.getBluetoothDevice().getAddress());
        CaeProviderUtils.updateDatabaseKeyType(this.mContext, CaeProviderUtils.BLUETOOTH_COMPATIBILITY_URI, CAE_EVENT_SELECTION, new String[]{r10.getDetailMessage(), r13}, new String[]{CaeProvider.CompatibilityEntry.ERR_CODE, CaeProvider.CompatibilityEntry.SOLUTION}, new String[]{r12, r14});
    }

    public void updatePostResponseOKInfoToDB(CaeBluetoothEvent r20) {
        String r8 = TAG;
        CaeLog.d(r8, "updatePostResponseOKInfoToDB");
        if (r20 != null) goto L5;
    L11:
        CaeLog.w(r8, "updatePostResponseOKInfoToDB: bluetooth device or address is null, skip update.");
        return;
    L5:
        if (r20.getBluetoothDevice() == null) goto L11;
        if (r20.getBluetoothDevice().getAddress() == null) goto L11;
        String r10 = r20.getBluetoothDevice().getAddress();
        String r11 = CaeUtil.getCurrentTimeFormatted();
        CaeProviderUtils.updateDatabaseKeyType(this.mContext, CaeProviderUtils.BLUETOOTH_COMPATIBILITY_URI, CAE_EVENT_SELECTION, new String[]{r20.getDetailMessage(), r10}, new String[]{CaeProvider.CompatibilityEntry.ERR_CODE, CaeProvider.CompatibilityEntry.ERR_COUNT, CaeProvider.CompatibilityEntry.LAST_HAPPENED_TIME, CaeProvider.CompatibilityEntry.FIXED, CaeProvider.CompatibilityEntry.SOLUTION, CaeProvider.CompatibilityEntry.UPLOADED, CaeProvider.CompatibilityEntry.UPLOADED_TIME}, new String[]{null, String.valueOf(0), null, String.valueOf(1), null, String.valueOf(1), r11});
    }

    public String queryCaeInfoField(String r8, String r10, String r11) {
        defpackage.b.o("queryCaeInfoField: ", r11, TAG);
        return CaeProviderUtils.queryDatabaseKeyValue(this.mContext, CaeProviderUtils.BLUETOOTH_COMPATIBILITY_URI, CAE_EVENT_SELECTION, new String[]{r8, r10}, r11);
    }
}
