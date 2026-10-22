package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.crypto.engine.HKDFHelper;
import com.bytedance.crypto.obfuscated.h;
import com.bytedance.crypto.obfuscated.i;
import com.bytedance.crypto.obfuscated.j;
import com.bytedance.crypto.obfuscated.k;
import com.bytedance.crypto.obfuscated.l;
import com.bytedance.crypto.utils.CommonUtils;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
class SensitiveData {
    public static final String DEVICE_SHARE_KEY_ALIAS = "device_share_key";
    private static final String OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX = "old_";
    private static final String TAG = "SensitiveData";
    private static final long TWO_DAY_MILLISECONDS = 172800000;
    private boolean isDataExist;
    private boolean isOldDataExist;
    private byte[] mDeviceShareKey;
    private byte[] mExtraInfo;
    private byte[] mHKDFInfo;
    private byte[] mHKDFSalt;
    private boolean mIsBdDevice;
    private long mKeyValidityPeriod;
    private long mKeyVersion;
    private byte[] mOldDeviceShareKey;
    private long mOldKeyVersion;
    private byte[] mSessionEncryptKey;

    public SensitiveData() {
        this.mIsBdDevice = true;
        this.mKeyValidityPeriod = 0;
        this.mKeyVersion = -1;
        this.isDataExist = false;
        this.isOldDataExist = false;
        this.mOldKeyVersion = -1;
    }

    private void bdDeleteSessionEncryptKey(Context r10, String r11) {
        int r12 = FrameworkSecurityCompat.deleteData(r10, r11, new Bundle());
        if (r12 == FrameworkSecurityCompat.SecretErrorCode.SUCCESS()) goto L6;
        LogUtils.e(TAG, "delete sessionEncryptKey failed, code: " + r12);
        return;
    }

    private void bdInitSessionEncryptKey(Context r10, String r11, String r12) {
        Bundle r13 = new Bundle();     // Catch: Exception -> L36
        r13.putInt(FrameworkSecurityCompat.SecretConst.BUNDLE_KEY_QUERY_MODE(), FrameworkSecurityCompat.QueryMode.PRECISE_QUERY_AND_DECRYPT());     // Catch: Exception -> L36
        FrameworkSecurityCompat.SdQueryResult r14 = FrameworkSecurityCompat.queryData(r10, r11, r13);     // Catch: Exception -> L36
        if (r14.getResultCode() != FrameworkSecurityCompat.SecretErrorCode.DATA_NOT_FOUNT()) goto L6;
    L34:
        LogUtils.i(TAG, "bd sessionEncryptKey info not exist");     // Catch: Exception -> L36
        return;
    L6:
        if (r14.getDataList().isEmpty() == true) goto L34;
        this.isDataExist = true;     // Catch: Exception -> L36
        Object r15 = r14.getDataList().get(0);     // Catch: Exception -> L36
        if (FrameworkSecurityCompat.SecretData.getSecretData(r15).isEmpty() == false) goto L12;
        LogUtils.i(TAG, "bd sessionEncryptKey exist, but get secretData failed!");     // Catch: Exception -> L36
        return;
    L12:
        byte[] r16 = CryptoUtils.hexStringToByteArray(FrameworkSecurityCompat.SecretData.getSecretData(r15));     // Catch: Exception -> L36
        this.mDeviceShareKey = r16;     // Catch: Exception -> L36
        if (r16 != null) goto L15;
    L32:
        LogUtils.i(TAG, "bd sessionEncryptKey exist, but get key failed!");     // Catch: Exception -> L36
        return;
    L15:
        if (r16.length == 0) goto L32;
        this.mExtraInfo = CryptoUtils.hexStringToByteArray(FrameworkSecurityCompat.SecretData.getExtInfo(r15));     // Catch: Exception -> L36
        this.mKeyVersion = Long.parseLong(FrameworkSecurityCompat.SecretData.getSearchInfo(r15));     // Catch: Exception -> L36
        this.mKeyValidityPeriod = Long.parseLong(FrameworkSecurityCompat.SecretData.getPublicData(r15));     // Catch: Exception -> L36
        if (CommonUtils.containsAssistantApp(r12) == false) goto L20;
        String r17 = CommonUtils.getAssistantAppPkgName(r12);     // Catch: Exception -> L36
    L21:
        LogUtils.i(TAG, "bd sessionEncryptKey pkgName:" + r17);     // Catch: Exception -> L36
        this.mHKDFInfo = TransUtils.sha256(r17.getBytes());     // Catch: Exception -> L36
        LogUtils.d(TAG, "bd sessionEncryptKey mKeyVersion:" + this.mKeyVersion);     // Catch: Exception -> L36
        LogUtils.d(TAG, "bd sessionEncryptKey mExtraInfo:" + CryptoUtils.byteArrayToHexString(this.mExtraInfo));     // Catch: Exception -> L36
        LogUtils.d(TAG, "bd sessionEncryptKey mHKDFInfo:" + CryptoUtils.byteArrayToHexString(this.mHKDFInfo));     // Catch: Exception -> L36
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L36
        String r18 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r11;     // Catch: Exception -> L36
        Bundle r19 = new Bundle();     // Catch: Exception -> L36
        r19.putInt(FrameworkSecurityCompat.SecretConst.BUNDLE_KEY_QUERY_MODE(), FrameworkSecurityCompat.QueryMode.PRECISE_QUERY_AND_DECRYPT());     // Catch: Exception -> L36
        FrameworkSecurityCompat.SdQueryResult r110 = FrameworkSecurityCompat.queryData(r10, r18, r19);     // Catch: Exception -> L36
        if (r110.getResultCode() != FrameworkSecurityCompat.SecretErrorCode.DATA_NOT_FOUNT()) goto L24;
        return;
    L24:
        if (r110.getDataList().isEmpty() == true) goto L45;
        Object r111 = r110.getDataList().get(0);     // Catch: Exception -> L36
        if ((System.currentTimeMillis() - Long.parseLong(FrameworkSecurityCompat.SecretData.getPublicData(r111))) <= TWO_DAY_MILLISECONDS) goto L30;
        deleteSensitiveDate(r10, r18);     // Catch: Exception -> L36
        LogUtils.i(TAG, "old bd sessionEncryptKey info is expired");     // Catch: Exception -> L36
        this.isOldDataExist = false;     // Catch: Exception -> L36
        return;
    L30:
        this.isOldDataExist = true;     // Catch: Exception -> L36
        this.mOldDeviceShareKey = CryptoUtils.hexStringToByteArray(FrameworkSecurityCompat.SecretData.getSecretData(r111));     // Catch: Exception -> L36
        this.mOldKeyVersion = Long.parseLong(FrameworkSecurityCompat.SecretData.getSearchInfo(r111));     // Catch: Exception -> L36
        LogUtils.w(TAG, "old key load, key version: " + this.mOldKeyVersion);     // Catch: Exception -> L36
        return;
    L45:
        return;
    L20:
        r17 = r10.getPackageName();     // Catch: Exception -> L36
    L36:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L42;
        throw ((CloudTransException) e);
    L42:
        throw new CloudTransException("initSessionEncryptKey failed", e);
    }

    private void bdSaveDeviceShareKey(Context r10, String r11, String r12) {
    L22:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L28;
        throw ((CloudTransException) e);
    L28:
        throw new CloudTransException("saveDeviceShareKey failed, ", e);
    L3:
        if (CommonUtils.containsAssistantApp(r12) == false) goto L5;
        String r13 = CommonUtils.getAssistantAppPkgName(r12);     // Catch: Exception -> L22
    L6:
        LogUtils.i(TAG, "bdSaveDeviceShareKey pkgName:" + r13);     // Catch: Exception -> L22
        this.mHKDFInfo = TransUtils.sha256(r13.getBytes());     // Catch: Exception -> L22
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L22
        Object r14 = FrameworkSecurityCompat.SecretData.newInstance();     // Catch: Exception -> L22
        FrameworkSecurityCompat.SecretData.setAlias(r14, r11);     // Catch: Exception -> L22
        FrameworkSecurityCompat.SecretData.setSecretData(r14, CryptoUtils.byteArrayToHexString(this.mDeviceShareKey));     // Catch: Exception -> L22
        FrameworkSecurityCompat.SecretData.setPublicData(r14, String.valueOf(this.mKeyValidityPeriod));     // Catch: Exception -> L22
        FrameworkSecurityCompat.SecretData.setSearchInfo(r14, String.valueOf(this.mKeyVersion));     // Catch: Exception -> L22
        FrameworkSecurityCompat.SecretData.setExtInfo(r14, CryptoUtils.byteArrayToHexString(this.mExtraInfo));     // Catch: Exception -> L22
        if (this.isDataExist == false) goto L9;
        FrameworkSecurityCompat.updateData(r10, r14, new Bundle());     // Catch: Exception -> L22
    L10:
        long r15 = this.mOldKeyVersion;     // Catch: Exception -> L22
        if (r15 < this.mKeyVersion) goto L13;
        return;
    L13:
        if (r15 > (-1)) goto L15;
        return;
    L15:
        if (this.mOldDeviceShareKey == null) goto L33;
        String r16 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r11;     // Catch: Exception -> L22
        Object r17 = FrameworkSecurityCompat.SecretData.newInstance();     // Catch: Exception -> L22
        FrameworkSecurityCompat.SecretData.setAlias(r17, r16);     // Catch: Exception -> L22
        FrameworkSecurityCompat.SecretData.setSecretData(r17, CryptoUtils.byteArrayToHexString(this.mOldDeviceShareKey));     // Catch: Exception -> L22
        FrameworkSecurityCompat.SecretData.setSearchInfo(r17, String.valueOf(this.mOldKeyVersion));     // Catch: Exception -> L22
        FrameworkSecurityCompat.SecretData.setPublicData(r17, String.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L22
        if (this.isOldDataExist == false) goto L19;
        FrameworkSecurityCompat.updateData(r10, r17, new Bundle());     // Catch: Exception -> L22
    L20:
        this.isOldDataExist = true;     // Catch: Exception -> L22
        return;
    L19:
        FrameworkSecurityCompat.addData(r10, r17, new Bundle());     // Catch: Exception -> L22
        goto L20
    L33:
        return;
    L9:
        FrameworkSecurityCompat.addData(r10, r14, new Bundle());     // Catch: Exception -> L22
        goto L10
    L5:
        r13 = r10.getPackageName();     // Catch: Exception -> L22
        goto L6
    }

    private void deleteSessionEncryptKey(Context r10, String r11) {
        Bundle r12 = new Bundle();
        j.a().getClass();
        l r13 = l.a(r10);
        r13.getClass();
        Log.i("a", "deleteData alias:" + r11);
        int r14 = 0;
        if (r12.getInt("delete_all", 0) != 1) goto L9;
        k r15 = r13.f1504a;
        String r16 = r13.f1505b.getPackageName();
        r15.getClass();
        Log.i("a", "deleteAllData, pkgName: " + r16);
        int r17 = r15.getWritableDatabase().delete("secret_item", "pkg_name =? ", new String[]{r16});
        if (r17 > 0) goto L23;
        StringBuilder r18 = new StringBuilder("delete all data failed, ret: ");
    L7:
        r18.append(r17);
        Log.e("a", r18.toString());
        r14 = -6;
    L23:
        if (r14 == 0) goto L26;
        LogUtils.e(TAG, "delete sessionEncryptKey failed, code: " + r14);
        return;
    L26:
        return;
    L9:
        if (TextUtils.isEmpty(r11) == false) goto L11;
        Log.e("a", "delete single data, alias is empty!");
        r14 = -2;
        goto L23
    L11:
        i r19 = r13.f1504a.a(r11, r13.f1505b.getPackageName());
        if (r19 != null) goto L14;
    L17:
        boolean r20 = false;
    L18:
        if (r20 == true) goto L20;
        Log.e("a", "delete single data, data not exist!");
        r14 = -5;
        goto L23
    L20:
        k r21 = r13.f1504a;
        String r22 = r13.f1505b.getPackageName();
        r21.getClass();
        Log.i("a", "deleteData, alias: " + r11 + ", pkgName: " + r22);
        r17 = r21.getWritableDatabase().delete("secret_item", "alias =? AND pkg_name =? ", new String[]{r11, r22});
        if (r17 == 1) goto L23;
        r18 = new StringBuilder("delete single data failed, ret: ");
        goto L7
    L14:
        if (TextUtils.isEmpty(r19.f1488a) == true) goto L17;
        r20 = true;
        goto L18
    }

    private void deriveSessionKey(byte[] r10) {
        if (r10 == null) goto L13;
        if (r10.length == 0) goto L13;
        LogUtils.i(TAG, "Derive session key enter.");
        byte[] r11 = new byte[32];
        new SecureRandom().nextBytes(r11);
        this.mSessionEncryptKey = HKDFHelper.deriveKey(r10, r11, this.mHKDFInfo);
        this.mHKDFSalt = r11;
        return;
    L9:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, derive session key failed", e);
    L13:
        throw new CloudTransException("deriveSessionKey failed, sek is empty!!");
    }

    private void initSessionEncryptKey(Context r11, String r12) {
        Bundle r10 = new Bundle();     // Catch: Exception -> L35
        r10.putInt("query_mode", 2);     // Catch: Exception -> L35
        h r13 = j.a().a(r11, r12, r10);     // Catch: Exception -> L35
        if (r13.f1486a != (-5)) goto L7;
    L33:
        LogUtils.i(TAG, "sessionEncryptKey info not exist");     // Catch: Exception -> L35
        return;
    L7:
        if (r13.f1487b.isEmpty() == true) goto L33;
        this.isDataExist = true;     // Catch: Exception -> L35
        if (r13.f1487b.get(0).f1493f.isEmpty() == false) goto L13;
        LogUtils.i(TAG, "sessionEncryptKey exist, but get secretData failed!");     // Catch: Exception -> L35
        return;
    L13:
        i r14 = r13.f1487b.get(0);     // Catch: Exception -> L35
        byte[] r15 = CryptoUtils.hexStringToByteArray(r14.f1493f);     // Catch: Exception -> L35
        this.mDeviceShareKey = r15;     // Catch: Exception -> L35
        if (r15 != null) goto L16;
    L31:
        LogUtils.i(TAG, "sessionEncryptKey exist, but get key failed!");     // Catch: Exception -> L35
        return;
    L16:
        if (r15.length == 0) goto L31;
        this.mExtraInfo = CryptoUtils.hexStringToByteArray(r14.f1494g);     // Catch: Exception -> L35
        this.mKeyVersion = Long.parseLong(r14.f1495h);     // Catch: Exception -> L35
        this.mKeyValidityPeriod = Long.parseLong(r14.f1491d);     // Catch: Exception -> L35
        this.mHKDFInfo = TransUtils.sha256(r11.getPackageName().getBytes());     // Catch: Exception -> L35
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L35
        String r16 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r12;     // Catch: Exception -> L35
        Bundle r17 = new Bundle();     // Catch: Exception -> L35
        r17.putInt("query_mode", 2);     // Catch: Exception -> L35
        h r18 = j.a().a(r11, r16, r17);     // Catch: Exception -> L35
        if (r18.f1486a != (-5)) goto L21;
    L29:
        this.isOldDataExist = false;     // Catch: Exception -> L35
        return;
    L21:
        if (r18.f1487b.isEmpty() == true) goto L29;
        i r19 = r18.f1487b.get(0);     // Catch: Exception -> L35
        if ((System.currentTimeMillis() - Long.parseLong(r19.f1491d)) <= TWO_DAY_MILLISECONDS) goto L27;
        deleteSensitiveDate(r11, r16);     // Catch: Exception -> L35
        LogUtils.i(TAG, "old bd sessionEncryptKey info is expired");     // Catch: Exception -> L35
        this.isOldDataExist = false;     // Catch: Exception -> L35
        return;
    L27:
        this.isOldDataExist = true;     // Catch: Exception -> L35
        this.mOldDeviceShareKey = CryptoUtils.hexStringToByteArray(r19.f1493f);     // Catch: Exception -> L35
        this.mOldKeyVersion = Long.parseLong(r19.f1495h);     // Catch: Exception -> L35
        LogUtils.w(TAG, "old key load, key version: " + this.mOldKeyVersion);     // Catch: Exception -> L35
        return;
    L35:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L41;
        throw ((CloudTransException) e);
    L41:
        throw new CloudTransException("initSessionEncryptKey failed", e);
    }

    private void saveDeviceShareKey(Context r10, String r11) {
        this.mHKDFInfo = TransUtils.sha256(r10.getPackageName().getBytes());     // Catch: Exception -> L17
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L17
        i r12 = new i();     // Catch: Exception -> L17
        r12.f1488a = r11;     // Catch: Exception -> L17
        r12.f1493f = CryptoUtils.byteArrayToHexString(this.mDeviceShareKey);     // Catch: Exception -> L17
        r12.f1495h = String.valueOf(this.mKeyVersion);     // Catch: Exception -> L17
        r12.f1491d = String.valueOf(this.mKeyValidityPeriod);     // Catch: Exception -> L17
        r12.f1494g = CryptoUtils.byteArrayToHexString(this.mExtraInfo);     // Catch: Exception -> L17
        if (this.isDataExist == false) goto L5;
        j.a().b(r10, r12, new Bundle());     // Catch: Exception -> L17
    L6:
        long r13 = this.mOldKeyVersion;     // Catch: Exception -> L17
        if (r13 < this.mKeyVersion) goto L9;
        return;
    L9:
        if (r13 > (-1)) goto L11;
        return;
    L11:
        if (this.mOldDeviceShareKey == null) goto L27;
        String r14 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r11;     // Catch: Exception -> L17
        i r15 = new i();     // Catch: Exception -> L17
        r15.f1488a = r14;     // Catch: Exception -> L17
        r15.f1493f = CryptoUtils.byteArrayToHexString(this.mOldDeviceShareKey);     // Catch: Exception -> L17
        r15.f1495h = String.valueOf(this.mOldKeyVersion);     // Catch: Exception -> L17
        r15.f1491d = String.valueOf(System.currentTimeMillis());     // Catch: Exception -> L17
        if (this.isOldDataExist == false) goto L15;
        j.a().b(r10, r15, new Bundle());     // Catch: Exception -> L17
        return;
    L15:
        j.a().a(r10, r15, new Bundle());     // Catch: Exception -> L17
        this.isOldDataExist = true;     // Catch: Exception -> L17
        return;
    L27:
        return;
    L5:
        j.a().a(r10, r12, new Bundle());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L23;
        throw ((CloudTransException) e);
    L23:
        throw new CloudTransException("saveDeviceShareKey failed, ", e);
    }

    public void deleteSensitiveDate(Context r10, String r11) {
        if (this.mIsBdDevice == false) goto L5;
        bdDeleteSessionEncryptKey(r10, r11);
        return;
    L5:
        deleteSessionEncryptKey(r10, r11);
    }

    public byte[] getDeviceShareKey() {
        return this.mDeviceShareKey;
    }

    public byte[] getExtraInfo() {
        return this.mExtraInfo;
    }

    public byte[] getHKDFInfo() {
        return this.mHKDFInfo;
    }

    public byte[] getHKDFSalt() {
        return this.mHKDFSalt;
    }

    public long getKeyValidityPeriod() {
        return this.mKeyValidityPeriod;
    }

    public long getKeyVersion() {
        return this.mKeyVersion;
    }

    public byte[] getOldDeviceShareKey() {
        return this.mOldDeviceShareKey;
    }

    public long getOldKeyVersion() {
        return this.mOldKeyVersion;
    }

    public byte[] getSessionEncryptKey() {
        return this.mSessionEncryptKey;
    }

    public boolean isOlidKeyExist() {
        return this.isOldDataExist;
    }

    public void loadSensitiveDate(Context r10, String r11, String r12, boolean r13) {
        this.mIsBdDevice = r13;
        if (r13 == false) goto L5;
        bdInitSessionEncryptKey(r10, r11, r12);
        return;
    L5:
        initSessionEncryptKey(r10, r11);
    }

    public void setDeviceShareKey(byte[] r10) {
        this.mOldDeviceShareKey = this.mDeviceShareKey;
        this.mDeviceShareKey = r10;
    }

    public void setExtraInfo(byte[] r10) {
        this.mExtraInfo = r10;
    }

    public void setKeyValidityPeriod(long r10) {
        this.mKeyValidityPeriod = r10;
    }

    public void setKeyVersion(long r10) {
        LogUtils.d(TAG, "set Key Version:" + r10 + ", old key version:" + this.mKeyVersion);
        this.mOldKeyVersion = this.mKeyVersion;
        this.mKeyVersion = r10;
    }

    public void updateSensitiveDate(Context r10, String r11, String r12) {
        if (this.mIsBdDevice == false) goto L5;
        bdSaveDeviceShareKey(r10, r11, r12);
        return;
    L5:
        saveDeviceShareKey(r10, r11);
    }
}
