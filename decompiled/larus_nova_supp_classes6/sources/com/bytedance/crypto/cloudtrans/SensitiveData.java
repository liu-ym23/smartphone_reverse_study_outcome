package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.security.SecureRandom;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
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

    private void bdDeleteSessionEncryptKey(Context r2, String r3) {
        int r4 = FrameworkSecurityCompat.deleteData(r2, r3, new Bundle());
        if (r4 == FrameworkSecurityCompat.SecretErrorCode.SUCCESS()) goto L6;
        LogUtils.e(TAG, "delete sessionEncryptKey failed, code: " + r4);
        return;
    }

    private void bdInitSessionEncryptKey(Context r13, String r14, String r15) {
        Bundle r6 = new Bundle();     // Catch: Exception -> L37
        r6.putInt(FrameworkSecurityCompat.SecretConst.BUNDLE_KEY_QUERY_MODE(), FrameworkSecurityCompat.QueryMode.PRECISE_QUERY_AND_DECRYPT());     // Catch: Exception -> L37
        FrameworkSecurityCompat.SdQueryResult r7 = FrameworkSecurityCompat.queryData(r13, r14, r6);     // Catch: Exception -> L37
        if (r7.getResultCode() != FrameworkSecurityCompat.SecretErrorCode.DATA_NOT_FOUNT()) goto L7;
    L35:
        LogUtils.i(TAG, "bd sessionEncryptKey info not exist");     // Catch: Exception -> L37
        return;
    L7:
        if (r7.getDataList().isEmpty() == true) goto L35;
        this.isDataExist = true;     // Catch: Exception -> L37
        Object r8 = ListProtector.get(r7.getDataList(), 0);     // Catch: Exception -> L37
        if (FrameworkSecurityCompat.SecretData.getSecretData(r8).isEmpty() == false) goto L13;
        LogUtils.i(TAG, "bd sessionEncryptKey exist, but get secretData failed!");     // Catch: Exception -> L37
        return;
    L13:
        byte[] r10 = CryptoUtils.hexStringToByteArray(FrameworkSecurityCompat.SecretData.getSecretData(r8));     // Catch: Exception -> L37
        this.mDeviceShareKey = r10;     // Catch: Exception -> L37
        if (r10 != null) goto L16;
    L33:
        LogUtils.i(TAG, "bd sessionEncryptKey exist, but get key failed!");     // Catch: Exception -> L37
        return;
    L16:
        if (r10.length == 0) goto L33;
        this.mExtraInfo = CryptoUtils.hexStringToByteArray(FrameworkSecurityCompat.SecretData.getExtInfo(r8));     // Catch: Exception -> L37
        this.mKeyVersion = CastLongProtector.parseLong(FrameworkSecurityCompat.SecretData.getSearchInfo(r8));     // Catch: Exception -> L37
        this.mKeyValidityPeriod = CastLongProtector.parseLong(FrameworkSecurityCompat.SecretData.getPublicData(r8));     // Catch: Exception -> L37
        if (CommonUtils.containsAssistantApp(r15) == false) goto L21;
        String r16 = CommonUtils.getAssistantAppPkgName(r15);     // Catch: Exception -> L37
    L22:
        LogUtils.i(TAG, "bd sessionEncryptKey pkgName:" + r16);     // Catch: Exception -> L37
        this.mHKDFInfo = TransUtils.sha256(r16.getBytes());     // Catch: Exception -> L37
        LogUtils.d(TAG, "bd sessionEncryptKey mKeyVersion:" + this.mKeyVersion);     // Catch: Exception -> L37
        LogUtils.d(TAG, "bd sessionEncryptKey mExtraInfo:" + CryptoUtils.byteArrayToHexString(this.mExtraInfo));     // Catch: Exception -> L37
        LogUtils.d(TAG, "bd sessionEncryptKey mHKDFInfo:" + CryptoUtils.byteArrayToHexString(this.mHKDFInfo));     // Catch: Exception -> L37
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L37
        String r17 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r14;     // Catch: Exception -> L37
        Bundle r18 = new Bundle();     // Catch: Exception -> L37
        r18.putInt(FrameworkSecurityCompat.SecretConst.BUNDLE_KEY_QUERY_MODE(), FrameworkSecurityCompat.QueryMode.PRECISE_QUERY_AND_DECRYPT());     // Catch: Exception -> L37
        FrameworkSecurityCompat.SdQueryResult r19 = FrameworkSecurityCompat.queryData(r13, r17, r18);     // Catch: Exception -> L37
        if (r19.getResultCode() != FrameworkSecurityCompat.SecretErrorCode.DATA_NOT_FOUNT()) goto L25;
        return;
    L25:
        if (r19.getDataList().isEmpty() == true) goto L46;
        Object r110 = ListProtector.get(r19.getDataList(), 0);     // Catch: Exception -> L37
        if ((System.currentTimeMillis() - CastLongProtector.parseLong(FrameworkSecurityCompat.SecretData.getPublicData(r110))) <= TWO_DAY_MILLISECONDS) goto L31;
        deleteSensitiveDate(r13, r17);     // Catch: Exception -> L37
        LogUtils.i(TAG, "old bd sessionEncryptKey info is expired");     // Catch: Exception -> L37
        this.isOldDataExist = false;     // Catch: Exception -> L37
        return;
    L31:
        this.isOldDataExist = true;     // Catch: Exception -> L37
        this.mOldDeviceShareKey = CryptoUtils.hexStringToByteArray(FrameworkSecurityCompat.SecretData.getSecretData(r110));     // Catch: Exception -> L37
        this.mOldKeyVersion = CastLongProtector.parseLong(FrameworkSecurityCompat.SecretData.getSearchInfo(r110));     // Catch: Exception -> L37
        LogUtils.w(TAG, "old key load, key version: " + this.mOldKeyVersion);     // Catch: Exception -> L37
        return;
    L46:
        return;
    L21:
        r16 = r13.getPackageName();     // Catch: Exception -> L37
    L37:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L43;
        throw ((CloudTransException) e);
    L43:
        throw new CloudTransException("initSessionEncryptKey failed", e);
    }

    private void bdSaveDeviceShareKey(Context r6, String r7, String r8) {
    L23:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L29;
        throw ((CloudTransException) e);
    L29:
        throw new CloudTransException("saveDeviceShareKey failed, ", e);
    L4:
        if (CommonUtils.containsAssistantApp(r8) == false) goto L6;
        String r9 = CommonUtils.getAssistantAppPkgName(r8);     // Catch: Exception -> L23
    L7:
        LogUtils.i(TAG, "bdSaveDeviceShareKey pkgName:" + r9);     // Catch: Exception -> L23
        this.mHKDFInfo = TransUtils.sha256(r9.getBytes());     // Catch: Exception -> L23
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L23
        Object r10 = FrameworkSecurityCompat.SecretData.newInstance();     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setAlias(r10, r7);     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setSecretData(r10, CryptoUtils.byteArrayToHexString(this.mDeviceShareKey));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setPublicData(r10, String.valueOf(this.mKeyValidityPeriod));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setSearchInfo(r10, String.valueOf(this.mKeyVersion));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setExtInfo(r10, CryptoUtils.byteArrayToHexString(this.mExtraInfo));     // Catch: Exception -> L23
        if (this.isDataExist == false) goto L10;
        FrameworkSecurityCompat.updateData(r6, r10, new Bundle());     // Catch: Exception -> L23
    L11:
        long r1 = this.mOldKeyVersion;     // Catch: Exception -> L23
        if (r1 < this.mKeyVersion) goto L14;
        return;
    L14:
        if (r1 > (-1)) goto L16;
        return;
    L16:
        if (this.mOldDeviceShareKey == null) goto L34;
        String r11 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r7;     // Catch: Exception -> L23
        Object r12 = FrameworkSecurityCompat.SecretData.newInstance();     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setAlias(r12, r11);     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setSecretData(r12, CryptoUtils.byteArrayToHexString(this.mOldDeviceShareKey));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setSearchInfo(r12, String.valueOf(this.mOldKeyVersion));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setPublicData(r12, String.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L23
        if (this.isOldDataExist == false) goto L20;
        FrameworkSecurityCompat.updateData(r6, r12, new Bundle());     // Catch: Exception -> L23
    L21:
        this.isOldDataExist = true;     // Catch: Exception -> L23
        return;
    L20:
        FrameworkSecurityCompat.addData(r6, r12, new Bundle());     // Catch: Exception -> L23
        goto L21
    L34:
        return;
    L10:
        FrameworkSecurityCompat.addData(r6, r10, new Bundle());     // Catch: Exception -> L23
        goto L11
    L6:
        r9 = r6.getPackageName();     // Catch: Exception -> L23
        goto L7
    }

    private void deriveSessionKey(byte[] r3) {
        if (r3 == null) goto L13;
        if (r3.length == 0) goto L13;
        LogUtils.i(TAG, "Derive session key enter.");
        byte[] r1 = new byte[32];
        new SecureRandom().nextBytes(r1);
        this.mSessionEncryptKey = HKDFHelper.deriveKey(r3, r1, this.mHKDFInfo);
        this.mHKDFSalt = r1;
        return;
    L9:
        e = move-exception;
        throw new CloudTransException("generateSharedSecret failed, derive session key failed", e);
    L13:
        throw new CloudTransException("deriveSessionKey failed, sek is empty!!");
    }

    private void saveDeviceShareKey(Context r7, String r8) {
        this.mHKDFInfo = TransUtils.sha256(r7.getPackageName().getBytes());     // Catch: Exception -> L18
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L18
        i r1 = new i();     // Catch: Exception -> L18
        r1.a = r8;     // Catch: Exception -> L18
        r1.f = CryptoUtils.byteArrayToHexString(this.mDeviceShareKey);     // Catch: Exception -> L18
        r1.h = String.valueOf(this.mKeyVersion);     // Catch: Exception -> L18
        r1.d = String.valueOf(this.mKeyValidityPeriod);     // Catch: Exception -> L18
        r1.g = CryptoUtils.byteArrayToHexString(this.mExtraInfo);     // Catch: Exception -> L18
        if (this.isDataExist == false) goto L6;
        j.a().b(r7, r1, new Bundle());     // Catch: Exception -> L18
    L7:
        long r2 = this.mOldKeyVersion;     // Catch: Exception -> L18
        if (r2 < this.mKeyVersion) goto L10;
        return;
    L10:
        if (r2 > (-1)) goto L12;
        return;
    L12:
        if (this.mOldDeviceShareKey == null) goto L28;
        String r9 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r8;     // Catch: Exception -> L18
        i r0 = new i();     // Catch: Exception -> L18
        r0.a = r9;     // Catch: Exception -> L18
        r0.f = CryptoUtils.byteArrayToHexString(this.mOldDeviceShareKey);     // Catch: Exception -> L18
        r0.h = String.valueOf(this.mOldKeyVersion);     // Catch: Exception -> L18
        r0.d = String.valueOf(System.currentTimeMillis());     // Catch: Exception -> L18
        if (this.isOldDataExist == false) goto L16;
        j.a().b(r7, r0, new Bundle());     // Catch: Exception -> L18
        return;
    L16:
        j.a().a(r7, r0, new Bundle());     // Catch: Exception -> L18
        this.isOldDataExist = true;     // Catch: Exception -> L18
        return;
    L28:
        return;
    L6:
        j.a().a(r7, r1, new Bundle());     // Catch: Exception -> L18
    L18:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L24;
        throw ((CloudTransException) e);
    L24:
        throw new CloudTransException("saveDeviceShareKey failed, ", e);
    }

    public void deleteSensitiveDate(Context r2, String r3) {
        if (this.mIsBdDevice == false) goto L5;
        bdDeleteSessionEncryptKey(r2, r3);
        return;
    L5:
        deleteSessionEncryptKey(r2, r3);
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

    public void loadSensitiveDate(Context r1, String r2, String r3, boolean r4) {
        this.mIsBdDevice = r4;
        if (r4 == false) goto L5;
        bdInitSessionEncryptKey(r1, r2, r3);
        return;
    L5:
        initSessionEncryptKey(r1, r2);
    }

    public void setDeviceShareKey(byte[] r2) {
        this.mOldDeviceShareKey = this.mDeviceShareKey;
        this.mDeviceShareKey = r2;
    }

    public void setExtraInfo(byte[] r1) {
        this.mExtraInfo = r1;
    }

    public void setKeyValidityPeriod(long r1) {
        this.mKeyValidityPeriod = r1;
    }

    public void setKeyVersion(long r4) {
        LogUtils.d(TAG, "set Key Version:" + r4 + ", old key version:" + this.mKeyVersion);
        this.mOldKeyVersion = this.mKeyVersion;
        this.mKeyVersion = r4;
    }

    public void updateSensitiveDate(Context r2, String r3, String r4) {
        if (this.mIsBdDevice == false) goto L5;
        bdSaveDeviceShareKey(r2, r3, r4);
        return;
    L5:
        saveDeviceShareKey(r2, r3);
    }

    private void deleteSessionEncryptKey(Context r7, String r8) {
        Bundle r0 = new Bundle();
        j.a().getClass();
        l r9 = l.a(r7);
        r9.getClass();
        int r2 = 0;
        if (r0.getInt("delete_all", 0) != 1) goto L8;
        k r10 = r9.a;
        String r11 = r9.b.getPackageName();
        r10.getClass();
        if (r10.getWritableDatabase().delete("secret_item", "pkg_name =? ", new String[]{r11}) > 0) goto L22;
    L6:
        r2 = -6;
    L22:
        if (r2 == 0) goto L25;
        LogUtils.e(TAG, "delete sessionEncryptKey failed, code: " + r2);
        return;
    L25:
        return;
    L8:
        if (TextUtils.isEmpty(r8) == false) goto L10;
        r2 = -2;
        goto L22
    L10:
        i r1 = r9.a.a(r8, r9.b.getPackageName());
        if (r1 != null) goto L13;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == true) goto L19;
        r2 = -5;
        goto L22
    L19:
        k r4 = r9.a;
        String r12 = r9.b.getPackageName();
        r4.getClass();
        if (r4.getWritableDatabase().delete("secret_item", "alias =? AND pkg_name =? ", new String[]{r8, r12}) == 1) goto L22;
    L13:
        if (TextUtils.isEmpty(r1.a) == true) goto L16;
        r3 = true;
        goto L17
    }

    private void initSessionEncryptKey(Context r13, String r14) {
        Bundle r3 = new Bundle();     // Catch: Exception -> L35
        r3.putInt("query_mode", 2);     // Catch: Exception -> L35
        h r4 = j.a().a(r13, r14, r3);     // Catch: Exception -> L35
        if (r4.a != (-5)) goto L7;
    L33:
        LogUtils.i(TAG, "sessionEncryptKey info not exist");     // Catch: Exception -> L35
        return;
    L7:
        if (r4.b.isEmpty() == true) goto L33;
        this.isDataExist = true;     // Catch: Exception -> L35
        if (((i) ListProtector.get(r4.b, 0)).f.isEmpty() == false) goto L13;
        LogUtils.i(TAG, "sessionEncryptKey exist, but get secretData failed!");     // Catch: Exception -> L35
        return;
    L13:
        i r5 = (i) ListProtector.get(r4.b, 0);     // Catch: Exception -> L35
        byte[] r8 = CryptoUtils.hexStringToByteArray(r5.f);     // Catch: Exception -> L35
        this.mDeviceShareKey = r8;     // Catch: Exception -> L35
        if (r8 != null) goto L16;
    L31:
        LogUtils.i(TAG, "sessionEncryptKey exist, but get key failed!");     // Catch: Exception -> L35
        return;
    L16:
        if (r8.length == 0) goto L31;
        this.mExtraInfo = CryptoUtils.hexStringToByteArray(r5.g);     // Catch: Exception -> L35
        this.mKeyVersion = CastLongProtector.parseLong(r5.h);     // Catch: Exception -> L35
        this.mKeyValidityPeriod = CastLongProtector.parseLong(r5.d);     // Catch: Exception -> L35
        this.mHKDFInfo = TransUtils.sha256(r13.getPackageName().getBytes());     // Catch: Exception -> L35
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L35
        String r15 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r14;     // Catch: Exception -> L35
        Bundle r2 = new Bundle();     // Catch: Exception -> L35
        r2.putInt("query_mode", 2);     // Catch: Exception -> L35
        h r0 = j.a().a(r13, r15, r2);     // Catch: Exception -> L35
        if (r0.a != (-5)) goto L21;
    L29:
        this.isOldDataExist = false;     // Catch: Exception -> L35
        return;
    L21:
        if (r0.b.isEmpty() == true) goto L29;
        i r1 = (i) ListProtector.get(r0.b, 0);     // Catch: Exception -> L35
        if ((System.currentTimeMillis() - CastLongProtector.parseLong(r1.d)) <= TWO_DAY_MILLISECONDS) goto L27;
        deleteSensitiveDate(r13, r15);     // Catch: Exception -> L35
        LogUtils.i(TAG, "old bd sessionEncryptKey info is expired");     // Catch: Exception -> L35
        this.isOldDataExist = false;     // Catch: Exception -> L35
        return;
    L27:
        this.isOldDataExist = true;     // Catch: Exception -> L35
        this.mOldDeviceShareKey = CryptoUtils.hexStringToByteArray(r1.f);     // Catch: Exception -> L35
        this.mOldKeyVersion = CastLongProtector.parseLong(r1.h);     // Catch: Exception -> L35
        LogUtils.w(TAG, "old key load, key version: " + this.mOldKeyVersion);     // Catch: Exception -> L35
        return;
    L35:
        e = move-exception;
        if ((e instanceof CloudTransException) == false) goto L41;
        throw ((CloudTransException) e);
    L41:
        throw new CloudTransException("initSessionEncryptKey failed", e);
    }
}
