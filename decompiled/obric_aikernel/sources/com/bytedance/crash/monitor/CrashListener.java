package com.bytedance.crash.monitor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.CrashInfoCallback;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.IANRCallback;
import com.bytedance.crash.IAnrUploadCallback;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.ICrashFilter;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.crash.IPreANRCallback;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.runtime.DefaultWorkThread;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CrashListener extends EventMonitor {
    private static final ArrayList<CrashListener> sCrashListenerList = null;
    private AppVersionModel cacheAppVersion;
    protected final CacheManager mCacheManager;

    static {
        sCrashListenerList = new ArrayList();
    }

    CrashListener(@NonNull UserDataCenter r10) {
        super(r10);
        sCrashListenerList.add(this);
        this.mCacheManager = new CacheManager(Global.getRootDirectory());
    }

    CrashListener(@NonNull UserDataCenter r13, @NonNull final String r14, @NonNull final String r15, final long r16) {
        super(r13, r14, r15, r16, 0, 0);
        sCrashListenerList.add(this);
        CacheManager r10 = new CacheManager(Global.getRootDirectory(), r14);
        this.mCacheManager = r10;
        if (DefaultWorkThread.isCurrentThread() == false) goto L5;
        r10.setAppId(r14);
        r10.setVersion(r16, 0, 0, r15);
        return;
    L5:
        DefaultWorkThread.post(new AnonymousClass1(this, r14, r16, r15));
    }

    CrashListener(@NonNull final String r10, @NonNull final String r11, final long r12) {
        super(r10, r11, r12, 0, 0);
        sCrashListenerList.add(this);
        CacheManager r13 = new CacheManager(Global.getRootDirectory(), r10);
        this.mCacheManager = r13;
        if (DefaultWorkThread.isCurrentThread() == false) goto L5;
        r13.setAppId(r10);
        r13.setVersion(r12, 0, 0, r11);
        return;
    L5:
        DefaultWorkThread.post(new AnonymousClass2(this, r10, r12, r11));
    }

    @Nullable
    static CrashListener getCrashListenerByAid(String r10) {
        Iterator<CrashListener> r11 = sCrashListenerList.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        CrashListener r12 = r11.next();
        if (r10.equals(r12.getAppId()) == false) goto L4;
        return r12;
    L8:
        return null;
    }

    @NonNull
    static ArrayList<CrashListener> getCrashListenerList() {
        return sCrashListenerList;
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public String getAppId() {
        if (this.mAppId == null) goto L6;
        return this.mAppId;
    L6:
        return this.mCacheManager.getAppId();
    }

    public String getAppId(long r10) {
        return this.mCacheManager.getAppId(r10);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public String getChannel() {
        if (this.mChannel == null) goto L6;
        return this.mChannel;
    L6:
        return this.mCacheManager.getChannel();
    }

    public String getChannel(long r10) {
        return this.mCacheManager.getChannel(r10);
    }

    public String getDeviceId(long r10) {
        String r11 = this.mCacheManager.getDeviceId(r10);
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return NetConst.NOT_ENCRYPT_VERISON_CODE;
    L6:
        return r11;
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public String getDeviceId(String r10) {
        if (TextUtils.isEmpty(this.mDeviceId) == false) goto L5;
        String r11 = this.mCacheManager.getDeviceId();
        if (TextUtils.isEmpty(r11) == false) goto L9;
        return r10;
    L9:
        return r11;
    L5:
        return this.mDeviceId;
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public long getManifestVersionCode() {
        return getVersion().getManifestVersionCode();
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public long getUpdateVersionCode() {
        return getVersion().getUpdateVersionCode();
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public long getUserId() {
        if (this.mUserId == 0) goto L6;
        return this.mUserId;
    L6:
        return this.mCacheManager.getUserId();
    }

    public long getUserId(long r10) {
        return this.mCacheManager.getUserId(r10);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    @NonNull
    public AppVersionModel getVersion() {
        AppVersionModel r10 = this.cacheAppVersion;
        if (r10 == null) goto L6;
        return r10;
    L6:
        if (this.mVersionName != null) goto L8;
    L10:
        AppVersionModel r11 = this.mCacheManager.getVersion();
    L11:
        this.cacheAppVersion = r11;
        return this.cacheAppVersion;
    L8:
        if (this.mVersionCode == 0) goto L10;
        r11 = new AppVersionModel(this.mVersionCode, this.mUpdateVersionCode, this.mManifestVersionCode, this.mVersionName);
        goto L11
    }

    public AppVersionModel getVersion(long r10) {
        return this.mCacheManager.getVersion(r10);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public long getVersionCode() {
        return getVersion().getVersionCode();
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public String getVersionName() {
        return getVersion().getVersionName();
    }

    public void registerANRCallback(IANRCallback r10) {
        this.mUserDataCenter.addANRCallback(r10);
    }

    public void registerAnrUploadCallback(IAnrUploadCallback r10) {
        this.mUserDataCenter.addAnrUploadCallback(r10);
    }

    public void registerCrashCallback(ICrashCallback r10, CrashType r11) {
        this.mUserDataCenter.addCrashCallback(r10, r11);
    }

    public void registerCrashInfoCallback(CrashInfoCallback r10, CrashType r11) {
        this.mUserDataCenter.addCrashInfoCallback(r10, r11);
    }

    public void registerExternalSdk(int r10, String r11) {
        this.mUserDataCenter.registerSdkInfo(r10, r11);
    }

    public void registerHprofCallback(IOOMCallback r10) {
        this.mUserDataCenter.addHprofCallback(r10);
    }

    public void registerInnerSdk(String r10, String r11) {
        this.mUserDataCenter.registerInnerSdkInfo(r10, r11);
    }

    public void registerOOMCallback(IOOMCallback r10) {
        this.mUserDataCenter.addOOMCallback(r10);
    }

    public void registerPreANRCallback(IPreANRCallback r10) {
        this.mUserDataCenter.addPreANRCallback(r10);
    }

    public void removeHprofCallback(IOOMCallback r10) {
        this.mUserDataCenter.removeHprofCallback(r10);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public void setChannel(@NonNull String r10) {
        this.mChannel = r10;
        this.mCacheManager.setChannel(r10);
    }

    public void setCrashFilter(ICrashFilter r10) {
        this.mUserDataCenter.setCrashFilter(r10);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public void setDeviceId(@NonNull String r10) {
        this.mDeviceId = r10;
        this.mCacheManager.setDeviceId(r10);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public void setUserId(long r10) {
        this.mUserId = r10;
        this.mCacheManager.setUserId(r10);
    }

    public void unregisterCrashCallback(ICrashCallback r10, CrashType r11) {
        this.mUserDataCenter.removeCrashCallback(r10, r11);
    }

    public void unregisterOOMCallback(IOOMCallback r10, CrashType r11) {
        this.mUserDataCenter.removeOOMCallback(r10);
    }

    public void unregisterPreANRCallback(IPreANRCallback r10) {
        this.mUserDataCenter.removePreANRCallback(r10);
    }
}
