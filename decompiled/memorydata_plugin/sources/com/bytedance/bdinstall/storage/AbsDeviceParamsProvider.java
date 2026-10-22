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
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    AbsDeviceParamsProvider(Context r5, StorageSettings r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.mLocalTestSuffix = createLocalTestSuffix(r6.isLocalTest());
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mContext = r0;
        this.mSettings = r6;
        this.mCache = new SPCache(r0, r6.getSp(), r6.getOptions());
        if (MigrateDetector.isThisDeviceMigrate(r7, r6.getOptions()) == true) goto L11;
        AccountCache r1 = new AccountCache(r7, r6.getSuffix(), r6.getOptions());
        this.mAccountCache = r1;
        this.mCache.setSuccessor(r1);
        AccountCache r2 = this.mAccountCache;
        if (RomUtils.isAndroidROrHigher() == false) goto L9;
        if (RomUtils.isTargetROrHigher(r7) == true) goto L11;
    L9:
        if (r6.isNeedSharedStorage() == false) goto L11;
        buildFileCacher(r6, r2);
    L11:
        setAccount(r6.getAccount());
    }

    private String createLocalTestSuffix(boolean r1) {
        if (r1 == false) goto L4;
        return LOCAL_TEST_SUFFIX_STR;
    L4:
        return "";
    }

    public void buildFileCacher(StorageSettings r1, Cache r2) {
    }

    public void clear(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        this.sDeviceId = null;
        String r6 = Api.KEY_CLEAR_KEY_PREFIX + r4;
        SharedPreferences r7 = this.mSettings.getSp();
        if (r7.getBoolean(r6, false) == true) goto L15;
        SharedPreferences.Editor r0 = r7.edit();
        r0.putBoolean(r6, true);
        if (r7.contains("device_id") == false) goto L11;
        r0.remove("device_id");
    L11:
        if (r7.contains("install_id") == false) goto L13;
        r0.remove("install_id");
    L13:
        r0.apply();
        this.mCache.clear(Collections.singletonList("device_id"));
        return;
    }

    public AccountCache getCache() {
        return this.mAccountCache;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public String getClientUDID() {
        if (TextUtils.isEmpty(this.sOpenClientUdid) == false) goto L5;
        SharedPreferences r1 = LocalConstants.getCommonSp(this.mContext, this.mSettings.getOptions());     // Catch: Exception -> L14
        String r2 = r1.getString("clientudid", null);     // Catch: Exception -> L14
        if (Utils.isValidUDID(r2) == true) goto L10;
        r2 = UUID.randomUUID().toString();     // Catch: Exception -> L14
        SharedPreferences.Editor r3 = r1.edit();     // Catch: Exception -> L14
        r3.putString("clientudid", r2);     // Catch: Exception -> L14
        r3.apply();     // Catch: Exception -> L14
    L10:
        if (TextUtils.isEmpty(r2) == true) goto L12;
        r2 = r2 + this.mLocalTestSuffix;     // Catch: Exception -> L14
    L12:
        this.sOpenClientUdid = r2;     // Catch: Exception -> L14
        return r2;
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
    public String getOpenUdid(boolean r7) {
        if (TextUtils.isEmpty(this.sOpenUdid) == false) goto L5;
        String r8 = HardwareUtils.getSecureAndroidId(this.mContext);
        SharedPreferences r0 = LocalConstants.getCommonSp(this.mContext, this.mSettings.getOptions());
        String r1 = r0.getString("openudid", null);
        if (Utils.isValidUDID(r8) == false) goto L12;
        if (IInstallParameters.FAKE_ANDROID_ID.equals(r8) == false) goto L24;
    L12:
        if (Utils.isValidUDID(r1) == true) goto L23;
        r1 = new BigInteger(80, new SecureRandom()).toString(16);     // Catch: Exception -> L31
        if (r1.charAt(0) != '-') goto L16;
        r1 = r1.substring(1);     // Catch: Exception -> L31
    L16:
        int r3 = 13 - r1.length();     // Catch: Exception -> L31
        if (r3 <= 0) goto L23;
        StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L31
    L19:
        if (r3 <= 0) goto L21;
        r4.append('F');     // Catch: Exception -> L31
        r3 = r3 - 1;     // Catch: Exception -> L31
        goto L19
    L21:
        r4.append(r1);     // Catch: Exception -> L31
        r8 = r4.toString();     // Catch: Exception -> L31
    L23:
        r8 = r1;
    L24:
        SharedPreferences.Editor r2 = r0.edit();
        r2.putString("openudid", r8);
        r2.apply();
        if (TextUtils.isEmpty(r8) == true) goto L28;
        r8 = r8 + this.mLocalTestSuffix;
    L28:
        if (TextUtils.isEmpty(r8) == true) goto L30;
        this.sOpenUdid = r8;
    L30:
        return r8;
    L5:
        return this.sOpenUdid;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void setAccount(Account r2) {
        AccountCache r0 = this.mAccountCache;
        if (r0 == null) goto L6;
        r0.setAccount(this.mSettings.getOptions().getAidString(), r2);
        return;
    }

    @Override // com.bytedance.bdinstall.service.IInstallParameters
    public void updateDeviceId(String r3) {
        if (Utils.checkId(r3) == true) goto L5;
        return;
    L5:
        if (Utils.equal(r3, this.sDeviceId) == true) goto L10;
        this.sDeviceId = this.mCache.loadDeviceId(r3, this.sDeviceId);
        return;
    }
}
