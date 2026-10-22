package com.bytedance.bdlocation.exception;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationException extends Exception {
    public static final String ERROR_ABNORMAL_NETWORK = "34";
    public static final String ERROR_AMAP_CLIENT = "76";
    public static final String ERROR_AMAP_FAIL = "22";
    public static final String ERROR_ANDROID_VERSION_TOO_LOW = "104";
    public static final String ERROR_BACKGROUND_LOCATE = "36";
    public static final String ERROR_BEACON_ADVERTISING = "100";
    public static final String ERROR_BEACON_INFO_NULL = "98";
    public static final String ERROR_BEACON_NOT_ALLOW_USE = "96";
    public static final String ERROR_BEACON_START_ADVERTISING = "108";
    public static final String ERROR_BELOW_MIN_UPDATE_INTERVAL = "124";
    public static final String ERROR_BLUETOOTh_NOT_AVAILABLE = "106";
    public static final String ERROR_BOOT_NO_CERT_LOCATE = "54";
    public static final String ERROR_BPEA_CERT_CAST = "82";
    public static final String ERROR_BPEA_CERT_NULL = "88";
    public static final String ERROR_BPEA_WITHOUT_CERT = "90";
    public static final String ERROR_BYTE_CONTINUOUS_CLIENT = "148";
    public static final String ERROR_BYTE_DISABLE_USE_WIFI = "44";
    public static final String ERROR_BYTE_FAIL = "42";
    public static final String ERROR_BYTE_NO_CHANGE_WIFI_STATE_PERMISSION = "48";
    public static final String ERROR_BYTE_NO_FINE_LOCATION_PERMISSION = "46";
    public static final String ERROR_BYTE_OPTION_NULL = "68";
    public static final String ERROR_BYTE_SCAN_RESULT_IS_EMPTY = "50";
    public static final String ERROR_CODE_EXCEPTION = "132";
    public static final String ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED = "134";
    public static final String ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED = "136";
    public static final String ERROR_CONNECT_GOOGLE_FAIL = "32";
    public static final String ERROR_CONTEXT_NULL = "126";
    public static final String ERROR_DEVICE_LOCATION_DISABLE = "86";
    public static final String ERROR_DISPUTED_AREA = "38";
    public static final String ERROR_DOWNGRADE_LOCATION = "138";
    public static final String ERROR_EXTRA_DATA_SCAN_FAILED = "140";
    public static final String ERROR_GET_GEOCODE = "78";
    public static final String ERROR_GOOGLE_FAIL = "84";
    public static final String ERROR_INIT_LOCATION = "80";
    public static final String ERROR_JSON_CONVERT = "66";
    public static final String ERROR_LIGHT_LOCATION_GET_CURRENT_STATION = "118";
    public static final String ERROR_LIGHT_LOCATION_IN_CACHE = "144";
    public static final String ERROR_LIGHT_LOCATION_UPLOAD_EXCEPTION = "122";
    public static final String ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO = "120";
    public static final String ERROR_LIGHT_LOCATION_WHEN_MOCK_ENABLED = "152";
    public static final String ERROR_LIGHT_LOCATION_WIFI_LIST_ALREADY_UPLOAD = "128";
    public static final String ERROR_LOCATION_IS_NULL = "26";
    public static final String ERROR_LOCATION_NO_PROVIDER = "150";
    public static final String ERROR_LOCATION_OPTION = "92";
    public static final String ERROR_LOCATION_UPLOAD = "74";
    public static final String ERROR_LOG_ID_CACHE_ENTITY = "142";
    public static final String ERROR_MULTI_THREAD_LOCATE = "40";
    public static final String ERROR_NETWORK_REQUEST = "70";
    public static final String ERROR_NO_BYTE_IMPL = "52";
    public static final String ERROR_NO_DATA = "130";
    public static final String ERROR_NO_LOCATE = "60";
    public static final String ERROR_NO_LOCATION = "146";
    public static final String ERROR_PROVIDER_DISABLED = "62";
    public static final String ERROR_RESTRICTED_MODE_ON = "64";
    public static final String ERROR_SDK_NO_PERMISSION = "30";
    public static final String ERROR_SDK_START_FAIL = "28";
    public static final String ERROR_SHAKE_BPEA_CERT_CHECK = "58";
    public static final String ERROR_SHAKE_UPLOAD = "56";
    public static final String ERROR_START_ADVERTISING_FAILED = "94";
    public static final String ERROR_TIMEOUT = "0";
    public static final String ERROR_TMAP_BAD_JSON = "112";
    public static final String ERROR_TMAP_CLIENT = "110";
    public static final String ERROR_TMAP_FAIL = "116";
    public static final String ERROR_TMAP_WGS84 = "114";
    public static final String ERROR_UID_IS_EMPTY = "102";
    public static final String ERROR_UNKNOWN = "24";
    public static final String ERROR_WIFI_UPLOAD = "72";
    public static final String SUCCESS = "200";
    private final List<Throwable> causes;
    private final String code;
    private final String detailMessage;
    private final Map<String, String> extra;
    private final int isAssembleError;
    private LocationOption option;
    private final String sdkName;

    public BDLocationException(String r8, String r10, String r11) {
        this(r8, r10, r11, new HashMap(), Collections.emptyList(), 0);
    }

    private void addRootCauses(Throwable r8, List<Throwable> r10) {
        if ((r8 instanceof BDLocationException) == false) goto L12;
        Iterator<Throwable> r11 = ((BDLocationException) r8).getCauses().iterator();
    L6:
        if (r11.hasNext() == false) goto L21;
        Throwable r12 = r11.next();
        addRootCauses(r12, r10);
        if ((r12 instanceof BDLocationException) == false) goto L6;
        if (((BDLocationException) r12).isAssembleError != 0) goto L6;
        r10.add(r12);
        goto L6
    L21:
        return;
    L12:
        r10.add(r8);
    }

    public BDLocationException addExtra(String r8, String r10) {
        this.extra.put(r8, r10);
        return this;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    public String getCode() {
        if (this.isAssembleError == 0) goto L5;
        Iterator<Throwable> r8 = getRootCauses().iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        Throwable r10 = r8.next();
        if ((r10 instanceof BDLocationException) == false) goto L8;
        return ((BDLocationException) r10).getCode();
    L12:
        return "";
    L5:
        return this.code;
    }

    public String getDetailMessage() {
        return this.detailMessage;
    }

    public String getExtra(String r8) {
        return this.extra.get(r8);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuffer r8 = new StringBuffer(71);
        String r10 = "";
        if (TextUtils.isEmpty(this.detailMessage) == false) goto L5;
        String r11 = "";
    L6:
        r8.append(r11);
        if (TextUtils.isEmpty(this.code) == false) goto L9;
        String r12 = "";
    L10:
        r8.append(r12);
        if (TextUtils.isEmpty(this.sdkName) == false) goto L13;
        String r13 = "";
    L14:
        r8.append(r13);
        if (getExtra().size() == 0) goto L18;
        r10 = "错误描述: " + getExtra() + '\n';
    L18:
        r8.append(r10);
        List<Throwable> r14 = getRootCauses();
        if (r14.isEmpty() == false) goto L23;
        return r8.toString();
    L23:
        if (r14.size() != 1) goto L25;
        String r15 = "There was 1 cause:\n";
    L26:
        r8.append(r15);
        Iterator<Throwable> r16 = r14.iterator();
    L28:
        if (r16.hasNext() == false) goto L31;
        Throwable r17 = r16.next();
        r8.append(r17.getClass().getName());
        r8.append("\n(");
        r8.append(r17.getMessage());
        r8.append(")\n");
        goto L28
    L31:
        return r8.toString();
    L25:
        r8.append("There were ");
        r8.append(r14.size());
        r15 = " causes:\n";
        goto L26
    L13:
        r13 = "SdkName: " + this.sdkName + '\n';
        goto L14
    L9:
        r12 = "错误码: " + this.code + '\n';
        goto L10
    L5:
        r11 = "错误信息: " + this.detailMessage + '\n';
        goto L6
    }

    public LocationOption getOption() {
        return this.option;
    }

    public List<Throwable> getRootCauses() {
        ArrayList r8 = new ArrayList();
        addRootCauses(this, r8);
        return r8;
    }

    public String getSdkName() {
        if (this.isAssembleError == 0) goto L5;
        Iterator<Throwable> r8 = getRootCauses().iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        Throwable r10 = r8.next();
        if ((r10 instanceof BDLocationException) == false) goto L8;
        return ((BDLocationException) r10).getSdkName();
    L12:
        return "";
    L5:
        return this.sdkName;
    }

    public void setOption(LocationOption r8) {
        this.option = r8;
    }

    public BDLocationException(String r8, String r10, String r11, Map<String, String> r12, List<Throwable> r13, int r14) {
        this.detailMessage = r8;
        this.sdkName = r10;
        this.code = r11;
        this.extra = r12;
        this.causes = r13;
        this.isAssembleError = r14;
    }

    public Map<String, String> getExtra() {
        if (this.isAssembleError == 0) goto L5;
        HashMap r8 = new HashMap(0);
        Iterator<Throwable> r10 = getRootCauses().iterator();
    L8:
        if (r10.hasNext() == false) goto L16;
        Throwable r11 = r10.next();
        if ((r11 instanceof BDLocationException) == false) goto L8;
        return ((BDLocationException) r11).getExtra();
    L16:
        return r8;
    L5:
        return this.extra;
    }

    public BDLocationException(Throwable r8, String r10, String r11) {
        this("", r10, r11, new HashMap(), Collections.singletonList(r8), 0);
    }

    public BDLocationException(List<Throwable> r8) {
        this("定位失败", "", "", new HashMap(), r8, 1);
    }
}
