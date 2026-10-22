package com.bytedance.crypto.cloudtrans;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.crypto.a.i;
import com.bytedance.crypto.a.j;
import com.bytedance.crypto.a.k;
import com.bytedance.crypto.a.m;
import com.bytedance.crypto.a.n;
import com.bytedance.crypto.engine.HKDFHelper;
import com.bytedance.crypto.utils.CommonUtils;
import com.bytedance.crypto.utils.CryptoUtils;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.bytedance.crypto.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes2.dex */
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
        int r1 = FrameworkSecurityCompat.deleteData((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, new Bundle());
        if (r1 == FrameworkSecurityCompat.SecretErrorCode.SUCCESS()) goto L6;
        LogUtils.e(TAG, "delete sessionEncryptKey failed, code: " + r1);
        return;
    }

    private void bdInitSessionEncryptKey(Context r10, String r11, String r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Bundle r0 = new Bundle();     // Catch: Exception -> L37
        r0.putInt(FrameworkSecurityCompat.SecretConst.BUNDLE_KEY_QUERY_MODE(), FrameworkSecurityCompat.QueryMode.PRECISE_QUERY_AND_DECRYPT());     // Catch: Exception -> L37
        FrameworkSecurityCompat.SdQueryResult r1 = FrameworkSecurityCompat.queryData(r13, r11, r0);     // Catch: Exception -> L37
        if (r1.getResultCode() != FrameworkSecurityCompat.SecretErrorCode.DATA_NOT_FOUNT()) goto L7;
    L35:
        LogUtils.i(TAG, "bd sessionEncryptKey info not exist");     // Catch: Exception -> L37
        return;
    L7:
        if (r1.getDataList().isEmpty() == true) goto L35;
        this.isDataExist = true;     // Catch: Exception -> L37
        Object r2 = r1.getDataList().get(0);     // Catch: Exception -> L37
        if (FrameworkSecurityCompat.SecretData.getSecretData(r2).isEmpty() == false) goto L13;
        LogUtils.i(TAG, "bd sessionEncryptKey exist, but get secretData failed!");     // Catch: Exception -> L37
        return;
    L13:
        byte[] r5 = CryptoUtils.hexStringToByteArray(FrameworkSecurityCompat.SecretData.getSecretData(r2));     // Catch: Exception -> L37
        this.mDeviceShareKey = r5;     // Catch: Exception -> L37
        if (r5 != null) goto L16;
    L33:
        LogUtils.i(TAG, "bd sessionEncryptKey exist, but get key failed!");     // Catch: Exception -> L37
        return;
    L16:
        if (r5.length == 0) goto L33;
        this.mExtraInfo = CryptoUtils.hexStringToByteArray(FrameworkSecurityCompat.SecretData.getExtInfo(r2));     // Catch: Exception -> L37
        this.mKeyVersion = Long.parseLong(FrameworkSecurityCompat.SecretData.getSearchInfo(r2));     // Catch: Exception -> L37
        this.mKeyValidityPeriod = Long.parseLong(FrameworkSecurityCompat.SecretData.getPublicData(r2));     // Catch: Exception -> L37
        if (CommonUtils.containsAssistantApp(r12) == false) goto L21;
        String r14 = CommonUtils.getAssistantAppPkgName(r12);     // Catch: Exception -> L37
    L22:
        LogUtils.i(TAG, "bd sessionEncryptKey pkgName:" + r14);     // Catch: Exception -> L37
        this.mHKDFInfo = TransUtils.sha256(r14.getBytes());     // Catch: Exception -> L37
        LogUtils.d(TAG, "bd sessionEncryptKey mKeyVersion:" + this.mKeyVersion);     // Catch: Exception -> L37
        LogUtils.d(TAG, "bd sessionEncryptKey mExtraInfo:" + CryptoUtils.byteArrayToHexString(this.mExtraInfo));     // Catch: Exception -> L37
        LogUtils.d(TAG, "bd sessionEncryptKey mHKDFInfo:" + CryptoUtils.byteArrayToHexString(this.mHKDFInfo));     // Catch: Exception -> L37
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L37
        String r15 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r11;     // Catch: Exception -> L37
        Bundle r16 = new Bundle();     // Catch: Exception -> L37
        r16.putInt(FrameworkSecurityCompat.SecretConst.BUNDLE_KEY_QUERY_MODE(), FrameworkSecurityCompat.QueryMode.PRECISE_QUERY_AND_DECRYPT());     // Catch: Exception -> L37
        FrameworkSecurityCompat.SdQueryResult r17 = FrameworkSecurityCompat.queryData(r13, r15, r16);     // Catch: Exception -> L37
        if (r17.getResultCode() != FrameworkSecurityCompat.SecretErrorCode.DATA_NOT_FOUNT()) goto L25;
        return;
    L25:
        if (r17.getDataList().isEmpty() == true) goto L46;
        Object r18 = r17.getDataList().get(0);     // Catch: Exception -> L37
        if ((System.currentTimeMillis() - Long.parseLong(FrameworkSecurityCompat.SecretData.getPublicData(r18))) <= TWO_DAY_MILLISECONDS) goto L31;
        deleteSensitiveDate(r13, r15);     // Catch: Exception -> L37
        LogUtils.i(TAG, "old bd sessionEncryptKey info is expired");     // Catch: Exception -> L37
        this.isOldDataExist = false;     // Catch: Exception -> L37
        return;
    L31:
        this.isOldDataExist = true;     // Catch: Exception -> L37
        this.mOldDeviceShareKey = CryptoUtils.hexStringToByteArray(FrameworkSecurityCompat.SecretData.getSecretData(r18));     // Catch: Exception -> L37
        this.mOldKeyVersion = Long.parseLong(FrameworkSecurityCompat.SecretData.getSearchInfo(r18));     // Catch: Exception -> L37
        LogUtils.w(TAG, "old key load, key version: " + this.mOldKeyVersion);     // Catch: Exception -> L37
        return;
    L46:
        return;
    L21:
        r14 = r13.getPackageName();     // Catch: Exception -> L37
    L37:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, CloudTransException.class) == false) goto L43;
        throw ((CloudTransException) ZeusTransformUtils.preCheckCast(e, CloudTransException.class, "com.obric.memorydata.plugin"));
    L43:
        throw new CloudTransException("initSessionEncryptKey failed", e);
    }

    private void bdSaveDeviceShareKey(Context r7, String r8, String r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
    L23:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, CloudTransException.class) == false) goto L29;
        throw ((CloudTransException) ZeusTransformUtils.preCheckCast(e, CloudTransException.class, "com.obric.memorydata.plugin"));
    L29:
        throw new CloudTransException("saveDeviceShareKey failed, ", e);
    L4:
        if (CommonUtils.containsAssistantApp(r9) == false) goto L6;
        String r11 = CommonUtils.getAssistantAppPkgName(r9);     // Catch: Exception -> L23
    L7:
        LogUtils.i(TAG, "bdSaveDeviceShareKey pkgName:" + r11);     // Catch: Exception -> L23
        this.mHKDFInfo = TransUtils.sha256(r11.getBytes());     // Catch: Exception -> L23
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L23
        Object r12 = FrameworkSecurityCompat.SecretData.newInstance();     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setAlias(r12, r8);     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setSecretData(r12, CryptoUtils.byteArrayToHexString(this.mDeviceShareKey));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setPublicData(r12, String.valueOf(this.mKeyValidityPeriod));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setSearchInfo(r12, String.valueOf(this.mKeyVersion));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setExtInfo(r12, CryptoUtils.byteArrayToHexString(this.mExtraInfo));     // Catch: Exception -> L23
        if (this.isDataExist == false) goto L10;
        FrameworkSecurityCompat.updateData(r10, r12, new Bundle());     // Catch: Exception -> L23
    L11:
        long r2 = this.mOldKeyVersion;     // Catch: Exception -> L23
        if (r2 < this.mKeyVersion) goto L14;
        return;
    L14:
        if (r2 > (-1)) goto L16;
        return;
    L16:
        if (this.mOldDeviceShareKey == null) goto L34;
        String r13 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r8;     // Catch: Exception -> L23
        Object r14 = FrameworkSecurityCompat.SecretData.newInstance();     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setAlias(r14, r13);     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setSecretData(r14, CryptoUtils.byteArrayToHexString(this.mOldDeviceShareKey));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setSearchInfo(r14, String.valueOf(this.mOldKeyVersion));     // Catch: Exception -> L23
        FrameworkSecurityCompat.SecretData.setPublicData(r14, String.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L23
        if (this.isOldDataExist == false) goto L20;
        FrameworkSecurityCompat.updateData(r10, r14, new Bundle());     // Catch: Exception -> L23
    L21:
        this.isOldDataExist = true;     // Catch: Exception -> L23
        return;
    L20:
        FrameworkSecurityCompat.addData(r10, r14, new Bundle());     // Catch: Exception -> L23
        goto L21
    L34:
        return;
    L10:
        FrameworkSecurityCompat.addData(r10, r12, new Bundle());     // Catch: Exception -> L23
        goto L11
    L6:
        r11 = r10.getPackageName();     // Catch: Exception -> L23
        goto L7
    }

    private void deleteSessionEncryptKey(Context r8, String r9) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Bundle r10 = new Bundle();
        k.a().getClass();
        n r11 = n.a(r7);
        r11.getClass();
        Log.i("a", "deleteData alias:" + r9);
        int r2 = 0;
        if (r10.getInt("delete_all", 0) != 1) goto L9;
        m r12 = r11.f2230b;
        String r13 = r11.c.getPackageName();
        r12.getClass();
        Log.i("a", "deleteAllData, pkgName: " + r13);
        int r14 = r12.getWritableDatabase().delete("secret_item", "pkg_name =? ", new String[]{r13});
        if (r14 > 0) goto L23;
        StringBuilder r15 = new StringBuilder("delete all data failed, ret: ");
    L7:
        Log.e("a", r15.append(r14).toString());
        r2 = -6;
    L23:
        if (r2 == 0) goto L26;
        LogUtils.e(TAG, "delete sessionEncryptKey failed, code: " + r2);
        return;
    L26:
        return;
    L9:
        if (TextUtils.isEmpty(r9) == false) goto L11;
        Log.e("a", "delete single data, alias is empty!");
        r2 = -2;
        goto L23
    L11:
        j r16 = r11.f2230b.a(r9, r11.c.getPackageName());
        if (r16 != null) goto L14;
    L17:
        boolean r17 = false;
    L18:
        if (r17 == true) goto L20;
        Log.e("a", "delete single data, data not exist!");
        r2 = -5;
        goto L23
    L20:
        m r18 = r11.f2230b;
        String r19 = r11.c.getPackageName();
        r18.getClass();
        Log.i("a", "deleteData, alias: " + r9 + ", pkgName: " + r19);
        r14 = r18.getWritableDatabase().delete("secret_item", "alias =? AND pkg_name =? ", new String[]{r9, r19});
        if (r14 == 1) goto L23;
        r15 = new StringBuilder("delete single data failed, ret: ");
        goto L7
    L14:
        if (TextUtils.isEmpty(r16.f2224a) == true) goto L17;
        r17 = true;
        goto L18
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

    private void initSessionEncryptKey(Context r14, String r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        Bundle r1 = new Bundle();     // Catch: Exception -> L35
        r1.putInt("query_mode", 2);     // Catch: Exception -> L35
        i r2 = k.a().a(r16, r15, r1);     // Catch: Exception -> L35
        if (r2.f2222a != (-5)) goto L7;
    L33:
        LogUtils.i(TAG, "sessionEncryptKey info not exist");     // Catch: Exception -> L35
        return;
    L7:
        if (r2.f2223b.isEmpty() == true) goto L33;
        this.isDataExist = true;     // Catch: Exception -> L35
        if (((j) ZeusTransformUtils.preCheckCast(r2.f2223b.get(0), j.class, "com.obric.memorydata.plugin")).f.isEmpty() == false) goto L13;
        LogUtils.i(TAG, "sessionEncryptKey exist, but get secretData failed!");     // Catch: Exception -> L35
        return;
    L13:
        j r3 = (j) ZeusTransformUtils.preCheckCast(r2.f2223b.get(0), j.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L35
        byte[] r7 = CryptoUtils.hexStringToByteArray(r3.f);     // Catch: Exception -> L35
        this.mDeviceShareKey = r7;     // Catch: Exception -> L35
        if (r7 != null) goto L16;
    L31:
        LogUtils.i(TAG, "sessionEncryptKey exist, but get key failed!");     // Catch: Exception -> L35
        return;
    L16:
        if (r7.length == 0) goto L31;
        this.mExtraInfo = CryptoUtils.hexStringToByteArray(r3.g);     // Catch: Exception -> L35
        this.mKeyVersion = Long.parseLong(r3.h);     // Catch: Exception -> L35
        this.mKeyValidityPeriod = Long.parseLong(r3.d);     // Catch: Exception -> L35
        this.mHKDFInfo = TransUtils.sha256(r16.getPackageName().getBytes());     // Catch: Exception -> L35
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L35
        String r17 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r15;     // Catch: Exception -> L35
        Bundle r4 = new Bundle();     // Catch: Exception -> L35
        r4.putInt("query_mode", 2);     // Catch: Exception -> L35
        i r0 = k.a().a(r16, r17, r4);     // Catch: Exception -> L35
        if (r0.f2222a != (-5)) goto L21;
    L29:
        this.isOldDataExist = false;     // Catch: Exception -> L35
        return;
    L21:
        if (r0.f2223b.isEmpty() == true) goto L29;
        j r5 = (j) ZeusTransformUtils.preCheckCast(r0.f2223b.get(0), j.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L35
        if ((System.currentTimeMillis() - Long.parseLong(r5.d)) <= TWO_DAY_MILLISECONDS) goto L27;
        deleteSensitiveDate(r16, r17);     // Catch: Exception -> L35
        LogUtils.i(TAG, "old bd sessionEncryptKey info is expired");     // Catch: Exception -> L35
        this.isOldDataExist = false;     // Catch: Exception -> L35
        return;
    L27:
        this.isOldDataExist = true;     // Catch: Exception -> L35
        this.mOldDeviceShareKey = CryptoUtils.hexStringToByteArray(r5.f);     // Catch: Exception -> L35
        this.mOldKeyVersion = Long.parseLong(r5.h);     // Catch: Exception -> L35
        LogUtils.w(TAG, "old key load, key version: " + this.mOldKeyVersion);     // Catch: Exception -> L35
        return;
    L35:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, CloudTransException.class) == false) goto L41;
        throw ((CloudTransException) ZeusTransformUtils.preCheckCast(e, CloudTransException.class, "com.obric.memorydata.plugin"));
    L41:
        throw new CloudTransException("initSessionEncryptKey failed", e);
    }

    private void saveDeviceShareKey(Context r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        this.mHKDFInfo = TransUtils.sha256(r9.getPackageName().getBytes());     // Catch: Exception -> L18
        deriveSessionKey(this.mDeviceShareKey);     // Catch: Exception -> L18
        j r0 = new j();     // Catch: Exception -> L18
        r0.f2224a = r8;     // Catch: Exception -> L18
        r0.f = CryptoUtils.byteArrayToHexString(this.mDeviceShareKey);     // Catch: Exception -> L18
        r0.h = String.valueOf(this.mKeyVersion);     // Catch: Exception -> L18
        r0.d = String.valueOf(this.mKeyValidityPeriod);     // Catch: Exception -> L18
        r0.g = CryptoUtils.byteArrayToHexString(this.mExtraInfo);     // Catch: Exception -> L18
        if (this.isDataExist == false) goto L6;
        k.a().b(r9, r0, new Bundle());     // Catch: Exception -> L18
    L7:
        long r2 = this.mOldKeyVersion;     // Catch: Exception -> L18
        if (r2 < this.mKeyVersion) goto L10;
        return;
    L10:
        if (r2 > (-1)) goto L12;
        return;
    L12:
        if (this.mOldDeviceShareKey == null) goto L28;
        String r10 = OLD_DEVICE_SHARE_KEY_ALIAS_PREFIX + r8;     // Catch: Exception -> L18
        j r1 = new j();     // Catch: Exception -> L18
        r1.f2224a = r10;     // Catch: Exception -> L18
        r1.f = CryptoUtils.byteArrayToHexString(this.mOldDeviceShareKey);     // Catch: Exception -> L18
        r1.h = String.valueOf(this.mOldKeyVersion);     // Catch: Exception -> L18
        r1.d = String.valueOf(System.currentTimeMillis());     // Catch: Exception -> L18
        if (this.isOldDataExist == false) goto L16;
        k.a().b(r9, r1, new Bundle());     // Catch: Exception -> L18
        return;
    L16:
        k.a().a(r9, r1, new Bundle());     // Catch: Exception -> L18
        this.isOldDataExist = true;     // Catch: Exception -> L18
        return;
    L28:
        return;
    L6:
        k.a().a(r9, r0, new Bundle());     // Catch: Exception -> L18
    L18:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, CloudTransException.class) == false) goto L24;
        throw ((CloudTransException) ZeusTransformUtils.preCheckCast(e, CloudTransException.class, "com.obric.memorydata.plugin"));
    L24:
        throw new CloudTransException("saveDeviceShareKey failed, ", e);
    }

    public void deleteSensitiveDate(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.mIsBdDevice == false) goto L5;
        bdDeleteSessionEncryptKey(r5, r4);
        return;
    L5:
        deleteSessionEncryptKey(r5, r4);
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

    public void loadSensitiveDate(Context r3, String r4, String r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mIsBdDevice = r6;
        if (r6 == false) goto L5;
        bdInitSessionEncryptKey(r7, r4, r5);
        return;
    L5:
        initSessionEncryptKey(r7, r4);
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

    public void updateSensitiveDate(Context r3, String r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.mIsBdDevice == false) goto L5;
        bdSaveDeviceShareKey(r6, r4, r5);
        return;
    L5:
        saveDeviceShareKey(r6, r4);
    }
}
