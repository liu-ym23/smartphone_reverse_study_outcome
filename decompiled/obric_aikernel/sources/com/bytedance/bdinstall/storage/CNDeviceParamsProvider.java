package com.bytedance.bdinstall.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.util.HardwareUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.SensitiveUtils;
import com.bytedance.bdinstall.util.StringEncryptUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public final class CNDeviceParamsProvider extends AbsDeviceParamsProvider {
    private volatile String[] sAccid;
    private volatile String sSerialNumber;
    private volatile String sUdid;
    private volatile JSONArray sUdidList;

    CNDeviceParamsProvider(Context r10, StorageSettings r11) {
        super(r10, r11);
    }

    private static String getKey() {
        String r10 = Api.KEY_EXTERNAL_DERECTORY_DEVICE_PARAMETER + StringEncryptUtils.getBytedanceString();
        return new String(new char[]{r10.charAt(1), r10.charAt(3), r10.charAt(1), r10.charAt(11), r10.charAt(15), r10.charAt(10), r10.charAt(8), r10.charAt(17), r10.charAt(9), r10.charAt(9), r10.charAt(12), r10.charAt(13), r10.charAt(13), r10.charAt(5), r10.charAt(18), r10.charAt(13), r10.charAt(14), r10.charAt(11), r10.charAt(4), r10.charAt(19), r10.charAt(7)}).substring(2, 18);
    }

    @Override // com.bytedance.bdinstall.storage.AbsDeviceParamsProvider
    protected void buildFileCacher(StorageSettings r11, Cache r12) {
        String r10 = getKey();
        boolean r13 = !r11.isAnonymous();
        ExternalCache r14 = new ExternalCache(this.mContext, r13, Environment.getExternalStorageDirectory().getPath() + StringEncryptUtils.base64DecodeToString("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U=") + this.mLocalTestSuffix, r11.getFileName(), r10, r11.getOptions().getAidString());     // Catch: Exception -> L5
        r12.setSuccessor(r14);     // Catch: Exception -> L5
        r12 = r14;
    L12:
        r12.setSuccessor(new ExternalCache(this.mContext, r13, Environment.getExternalStorageDirectory().getPath() + "/" + StringEncryptUtils.getBytedanceString() + this.mLocalTestSuffix, r11.getFileName(), r10, r11.getOptions().getAidString()));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void clearAll() {
        this.mCache.clear(Arrays.asList(new String[]{"openudid", "clientudid", "serial_number", "sim_serial_number", SstLoader.KEY_UDID, "device_id", "install_id"}));
    }

    @Override // com.bytedance.bdinstall.storage.AbsDeviceParamsProvider, com.bytedance.bdinstall.service.IInstallParameters
    public String getClientUDID() {
        if (TextUtils.isEmpty(this.sOpenClientUdid) == false) goto L5;
        SharedPreferences r10 = LocalConstants.getCommonSp(this.mContext, this.mSettings.getOptions());     // Catch: Exception -> L23
        String r11 = null;
        String r12 = r10.getString("clientudid", null);     // Catch: Exception -> L23
        if (Utils.isValidUDID(r12) == true) goto L15;
        r12 = UUID.randomUUID().toString();     // Catch: Exception -> L23
        AccountCache r13 = this.mAccountCache;     // Catch: Exception -> L23
        if (r13 == null) goto L12;
        r11 = r13.loadClientUdid(null, r12);     // Catch: Exception -> L23
    L12:
        if (Utils.isValidUDID(r11) == false) goto L14;
        r12 = r11;
    L14:
        SharedPreferences.Editor r14 = r10.edit();     // Catch: Exception -> L23
        r14.putString("clientudid", r12);     // Catch: Exception -> L23
        r14.apply();     // Catch: Exception -> L23
    L19:
        if (TextUtils.isEmpty(r12) == true) goto L21;
        r12 = r12 + this.mLocalTestSuffix;     // Catch: Exception -> L23
    L21:
        this.sOpenClientUdid = r12;     // Catch: Exception -> L23
        return r12;
    L15:
        AccountCache r15 = this.mAccountCache;     // Catch: Exception -> L23
        if (r15 == null) goto L19;
        r15.loadClientUdid(r12, null);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
        return "";
    L5:
        return this.sOpenClientUdid;
    }

    @Override // com.bytedance.bdinstall.storage.AbsDeviceParamsProvider, com.bytedance.bdinstall.service.IInstallParameters
    public String getOpenUdid(boolean r10) {
        if (TextUtils.isEmpty(this.sOpenUdid) == false) goto L5;
        String r11 = HardwareUtils.getSecureAndroidId(this.mContext);
        SharedPreferences r12 = LocalConstants.getCommonSp(this.mContext, this.mSettings.getOptions());
        String r13 = null;
        String r14 = r12.getString("openudid", null);
        if (Utils.isValidUDID(r11) == false) goto L18;
        if (IInstallParameters.FAKE_ANDROID_ID.equals(r11) == true) goto L18;
        if (Utils.isValidUDID(r14) == false) goto L15;
        String r15 = this.mCache.loadOpenUdid(r11, r14);     // Catch: Exception -> L47
    L16:
        r11 = r15;
        goto L41
    L15:
        r15 = this.mCache.loadOpenUdid(null, r11);     // Catch: Exception -> L47
    L18:
        if (Utils.isValidUDID(r14) == true) goto L36;
        r14 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L47
        if (r14.charAt(0) != '-') goto L22;
        r14 = r14.substring(1);     // Catch: Exception -> L47
    L22:
        int r16 = 13 - r14.length();     // Catch: Exception -> L47
        if (r16 <= 0) goto L28;
        StringBuilder r17 = new StringBuilder();     // Catch: Exception -> L47
    L25:
        if (r16 <= 0) goto L27;
        r17.append('F');     // Catch: Exception -> L47
        r16 = r16 - 1;     // Catch: Exception -> L47
        goto L25
    L27:
        r17.append(r14);     // Catch: Exception -> L47
        r14 = r17.toString();     // Catch: Exception -> L47
    L28:
        if (r10 == false) goto L35;
        AccountCache r18 = this.mAccountCache;     // Catch: Exception -> L47
        if (r18 == null) goto L33;
        r13 = r18.loadOpenUdid(null, r14);     // Catch: Exception -> L47
    L33:
        if (Utils.isValidUDID(r13) == false) goto L35;
        r14 = r13;
    L35:
        SharedPreferences.Editor r19 = r12.edit();     // Catch: Exception -> L47
        r19.putString("openudid", r14);     // Catch: Exception -> L47
        r19.apply();     // Catch: Exception -> L47
    L39:
        r11 = r14;
        goto L41
    L36:
        AccountCache r20 = this.mAccountCache;     // Catch: Exception -> L47
        if (r20 == null) goto L39;
        r20.loadOpenUdid(r14, null);     // Catch: Exception -> L47
    L41:
        if (TextUtils.isEmpty(r11) == true) goto L44;
        r11 = r11 + this.mLocalTestSuffix;
    L44:
        if (TextUtils.isEmpty(r11) == true) goto L46;
        this.sOpenUdid = r11;
    L46:
        return r11;
    L5:
        return this.sOpenUdid;
    }

    public String getSerialNumber() {
        if (TextUtils.isEmpty(this.sSerialNumber) == true) goto L15;
        return this.sSerialNumber;
    L15:
        String r10 = this.mCache.loadSerialNumber(null, SensitiveUtils.getSerialNumber(this.mContext, this.mSettings.getOptions()));     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r10) == true) goto L10;
        r10 = r10 + this.mLocalTestSuffix;     // Catch: Exception -> L12
    L10:
        this.sSerialNumber = r10;     // Catch: Exception -> L12
        return r10;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String[] getSimSerialNumbers() {
        if (this.sAccid == null) goto L20;
        if (this.sAccid.length <= 0) goto L20;
        return this.sAccid;
    L20:
        String[] r10 = this.mCache.loadAccId(null, SensitiveUtils.getSimSerialNumbers(this.mContext, this.mSettings.getOptions()));     // Catch: Exception -> L17
        int r11 = 0;
        if (r10 != null) goto L13;
        r10 = new String[0];     // Catch: Exception -> L17
    L13:
        if (r11 >= r10.length) goto L15;
        r10[r11] = r10[r11] + this.mLocalTestSuffix;     // Catch: Exception -> L17
        r11 = r11 + 1;     // Catch: Exception -> L17
        goto L13
    L15:
        this.sAccid = r10;     // Catch: Exception -> L17
        return r10;
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String getUdId() {
        if (TextUtils.isEmpty(this.sUdid) == true) goto L15;
        return this.sUdid;
    L15:
        String r10 = this.mCache.loadUdid(null, SensitiveUtils.getDeviceIdWithCache(this.mContext, this.mSettings.getOptions()));     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r10) == true) goto L10;
        r10 = r10 + this.mLocalTestSuffix;     // Catch: Exception -> L12
    L10:
        this.sUdid = r10;     // Catch: Exception -> L12
        return r10;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public JSONArray getUdIdList() {
        if (this.sUdidList != null) goto L5;
        this.sUdidList = SensitiveUtils.getMultiImei(this.mContext, this.mSettings.getOptions());     // Catch: Exception -> L8
        return this.sUdidList;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        return this.sUdidList;
    }
}
