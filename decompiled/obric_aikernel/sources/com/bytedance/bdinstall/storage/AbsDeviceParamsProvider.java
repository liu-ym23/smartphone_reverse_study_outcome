package com.bytedance.bdinstall.storage;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.migrate.MigrateDetector;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.util.HardwareUtils;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.RomUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsDeviceParamsProvider implements IInstallParameters {
    private static final String LOCAL_TEST_SUFFIX_STR = "_local";
    protected AccountCache mAccountCache;
    protected Cache mCache;
    protected final Context mContext;
    protected final String mLocalTestSuffix;
    protected final StorageSettings mSettings;
    private volatile String sDeviceId;
    protected String sOpenClientUdid;
    protected String sOpenUdid;

    AbsDeviceParamsProvider(Context r10, StorageSettings r11) {
        this.mLocalTestSuffix = createLocalTestSuffix(r11.isLocalTest());
        Context r12 = r10.getApplicationContext();
        this.mContext = r12;
        this.mSettings = r11;
        this.mCache = new SPCache(r12, r11.getSp(), r11.getOptions());
        if (MigrateDetector.isThisDeviceMigrate(r10, r11.getOptions()) == true) goto L11;
        AccountCache r13 = new AccountCache(r10, r11.getSuffix(), r11.getOptions());
        this.mAccountCache = r13;
        this.mCache.setSuccessor(r13);
        AccountCache r14 = this.mAccountCache;
        if (RomUtils.isAndroidROrHigher() == false) goto L9;
        if (RomUtils.isTargetROrHigher(r10) == true) goto L11;
    L9:
        if (r11.isNeedSharedStorage() == false) goto L11;
        buildFileCacher(r11, r14);
    L11:
        setAccount(r11.getAccount());
    }

    private String createLocalTestSuffix(boolean r10) {
        if (r10 == false) goto L4;
        return LOCAL_TEST_SUFFIX_STR;
    L4:
        return "";
    }

    protected void buildFileCacher(StorageSettings r10, Cache r11) {
    }

    public void clear(Context r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return;
    L5:
        this.sDeviceId = null;
        String r12 = Api.KEY_CLEAR_KEY_PREFIX + r11;
        SharedPreferences r13 = this.mSettings.getSp();
        if (r13.getBoolean(r12, false) == true) goto L15;
        SharedPreferences.Editor r14 = r13.edit();
        r14.putBoolean(r12, true);
        if (r13.contains("device_id") == false) goto L11;
        r14.remove("device_id");
    L11:
        if (r13.contains("install_id") == false) goto L13;
        r14.remove("install_id");
    L13:
        r14.apply();
        this.mCache.clear(Collections.singletonList("device_id"));
        return;
    }

    public AccountCache getCache() {
        return this.mAccountCache;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public String getClientUDID() {
        if (TextUtils.isEmpty(this.sOpenClientUdid) == false) goto L5;
        SharedPreferences r10 = LocalConstants.getCommonSp(this.mContext, this.mSettings.getOptions());     // Catch: Exception -> L14
        String r11 = r10.getString("clientudid", null);     // Catch: Exception -> L14
        if (Utils.isValidUDID(r11) == true) goto L10;
        r11 = UUID.randomUUID().toString();     // Catch: Exception -> L14
        SharedPreferences.Editor r12 = r10.edit();     // Catch: Exception -> L14
        r12.putString("clientudid", r11);     // Catch: Exception -> L14
        r12.apply();     // Catch: Exception -> L14
    L10:
        if (TextUtils.isEmpty(r11) == true) goto L12;
        r11 = r11 + this.mLocalTestSuffix;     // Catch: Exception -> L14
    L12:
        this.sOpenClientUdid = r11;     // Catch: Exception -> L14
        return r11;
    L14:
        e = move-exception;
        e.printStackTrace();
        return "";
    L5:
        return this.sOpenClientUdid;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public String getDeviceId() {
        if (TextUtils.isEmpty(this.sDeviceId) == false) goto L5;
        this.sDeviceId = this.mCache.loadDeviceId("", "");
        return this.sDeviceId;
    L5:
        return this.sDeviceId;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public String getOpenUdid(boolean r10) {
        if (TextUtils.isEmpty(this.sOpenUdid) == false) goto L5;
        String r11 = HardwareUtils.getSecureAndroidId(this.mContext);
        SharedPreferences r12 = LocalConstants.getCommonSp(this.mContext, this.mSettings.getOptions());
        String r13 = r12.getString("openudid", null);
        if (Utils.isValidUDID(r11) == false) goto L12;
        if (IInstallParameters.FAKE_ANDROID_ID.equals(r11) == false) goto L24;
    L12:
        if (Utils.isValidUDID(r13) == true) goto L23;
        r13 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L31
        if (r13.charAt(0) != '-') goto L16;
        r13 = r13.substring(1);     // Catch: Exception -> L31
    L16:
        int r14 = 13 - r13.length();     // Catch: Exception -> L31
        if (r14 <= 0) goto L23;
        StringBuilder r15 = new StringBuilder();     // Catch: Exception -> L31
    L19:
        if (r14 <= 0) goto L21;
        r15.append('F');     // Catch: Exception -> L31
        r14 = r14 - 1;     // Catch: Exception -> L31
        goto L19
    L21:
        r15.append(r13);     // Catch: Exception -> L31
        r11 = r15.toString();     // Catch: Exception -> L31
    L23:
        r11 = r13;
    L24:
        SharedPreferences.Editor r16 = r12.edit();
        r16.putString("openudid", r11);
        r16.apply();
        if (TextUtils.isEmpty(r11) == true) goto L28;
        r11 = r11 + this.mLocalTestSuffix;
    L28:
        if (TextUtils.isEmpty(r11) == true) goto L30;
        this.sOpenUdid = r11;
    L30:
        return r11;
    L5:
        return this.sOpenUdid;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void setAccount(Account r10) {
        AccountCache r11 = this.mAccountCache;
        if (r11 == null) goto L6;
        r11.setAccount(this.mSettings.getOptions().getAidString(), r10);
        return;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void updateDeviceId(String r10) {
        if (Utils.checkId(r10) == true) goto L5;
        return;
    L5:
        if (Utils.equal(r10, this.sDeviceId) == true) goto L10;
        this.sDeviceId = this.mCache.loadDeviceId(r10, this.sDeviceId);
        return;
    }
}
