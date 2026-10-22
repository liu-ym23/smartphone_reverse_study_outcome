package com.bytedance.crash.monitor;

import android.text.TextUtils;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class CrashListener extends EventMonitor {
    private static final ArrayList<CrashListener> sCrashListenerList = null;
    private AppVersionModel cacheAppVersion;
    protected final CacheManager mCacheManager;

    static {
        sCrashListenerList = new ArrayList();
    }

    CrashListener(UserDataCenter r2) {
        super(r2);
        sCrashListenerList.add(this);
        this.mCacheManager = new CacheManager(Global.getRootDirectory());
    }

    CrashListener(UserDataCenter r13, final String r14, final String r15, final long r16) {
        super(r13, r14, r15, r16, 0, 0);
        sCrashListenerList.add(this);
        CacheManager r1 = new CacheManager(Global.getRootDirectory(), r14);
        this.mCacheManager = r1;
        if (DefaultWorkThread.isCurrentThread() == false) goto L5;
        r1.setAppId(r14);
        r1.setVersion(r16, 0, 0, r15);
        return;
    L5:
        DefaultWorkThread.post(new AnonymousClass1(this, r14, r16, r15));
    }

    CrashListener(final String r10, final String r11, final long r12) {
        super(r10, r11, r12, 0, 0);
        sCrashListenerList.add(this);
        CacheManager r1 = new CacheManager(Global.getRootDirectory(), r10);
        this.mCacheManager = r1;
        if (DefaultWorkThread.isCurrentThread() == false) goto L5;
        r1.setAppId(r10);
        r1.setVersion(r12, 0, 0, r11);
        return;
    L5:
        DefaultWorkThread.post(new AnonymousClass2(this, r10, r12, r11));
    }

    static CrashListener getCrashListenerByAid(String r4) {
        Iterator<CrashListener> r0 = sCrashListenerList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        CrashListener r1 = (CrashListener) ZeusTransformUtils.preCheckCast(r0.next(), CrashListener.class, "com.obric.memorydata.plugin");
        if (r4.equals(r1.getAppId()) == false) goto L4;
        return r1;
    L8:
        return null;
    }

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

    public String getAppId(long r1) {
        return this.mCacheManager.getAppId(r1);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public String getChannel() {
        if (this.mChannel == null) goto L6;
        return this.mChannel;
    L6:
        return this.mCacheManager.getChannel();
    }

    public String getChannel(long r1) {
        return this.mCacheManager.getChannel(r1);
    }

    public String getDeviceId(long r1) {
        String r0 = this.mCacheManager.getDeviceId(r1);
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return "0";
    L6:
        return r0;
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public String getDeviceId(String r2) {
        if (TextUtils.isEmpty(this.mDeviceId) == false) goto L5;
        String r1 = this.mCacheManager.getDeviceId();
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return r2;
    L9:
        return r1;
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

    public long getUserId(long r1) {
        return this.mCacheManager.getUserId(r1);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public AppVersionModel getVersion() {
        AppVersionModel r0 = this.cacheAppVersion;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.mVersionName != null) goto L8;
    L10:
        AppVersionModel r1 = this.mCacheManager.getVersion();
    L11:
        this.cacheAppVersion = r1;
        return this.cacheAppVersion;
    L8:
        if (this.mVersionCode == 0) goto L10;
        r1 = new AppVersionModel(this.mVersionCode, this.mUpdateVersionCode, this.mManifestVersionCode, this.mVersionName);
        goto L11
    }

    public AppVersionModel getVersion(long r1) {
        return this.mCacheManager.getVersion(r1);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public long getVersionCode() {
        return getVersion().getVersionCode();
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public String getVersionName() {
        return getVersion().getVersionName();
    }

    public void registerANRCallback(IANRCallback r3) {
        IANRCallback r4 = (IANRCallback) ZeusTransformUtils.wrapperContextForParams(r3, IANRCallback.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.addANRCallback(r4);
    }

    public void registerAnrUploadCallback(IAnrUploadCallback r3) {
        IAnrUploadCallback r4 = (IAnrUploadCallback) ZeusTransformUtils.wrapperContextForParams(r3, IAnrUploadCallback.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.addAnrUploadCallback(r4);
    }

    public void registerCrashCallback(ICrashCallback r3, CrashType r4) {
        ICrashCallback r5 = (ICrashCallback) ZeusTransformUtils.wrapperContextForParams(r3, ICrashCallback.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.addCrashCallback(r5, r4);
    }

    public void registerCrashInfoCallback(CrashInfoCallback r1, CrashType r2) {
        this.mUserDataCenter.addCrashInfoCallback(r1, r2);
    }

    public void registerExternalSdk(int r1, String r2) {
        this.mUserDataCenter.registerSdkInfo(r1, r2);
    }

    public void registerHprofCallback(IOOMCallback r3) {
        IOOMCallback r4 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r3, IOOMCallback.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.addHprofCallback(r4);
    }

    public void registerInnerSdk(String r1, String r2) {
        this.mUserDataCenter.registerInnerSdkInfo(r1, r2);
    }

    public void registerOOMCallback(IOOMCallback r3) {
        IOOMCallback r4 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r3, IOOMCallback.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.addOOMCallback(r4);
    }

    public void registerPreANRCallback(IPreANRCallback r3) {
        IPreANRCallback r4 = (IPreANRCallback) ZeusTransformUtils.wrapperContextForParams(r3, IPreANRCallback.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.addPreANRCallback(r4);
    }

    public void removeHprofCallback(IOOMCallback r3) {
        IOOMCallback r4 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r3, IOOMCallback.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.removeHprofCallback(r4);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public void setChannel(String r1) {
        this.mChannel = r1;
        this.mCacheManager.setChannel(r1);
    }

    public void setCrashFilter(ICrashFilter r3) {
        ICrashFilter r4 = (ICrashFilter) ZeusTransformUtils.wrapperContextForParams(r3, ICrashFilter.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.setCrashFilter(r4);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public void setDeviceId(String r1) {
        this.mDeviceId = r1;
        this.mCacheManager.setDeviceId(r1);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public void setUserId(long r1) {
        this.mUserId = r1;
        this.mCacheManager.setUserId(r1);
    }

    public void unregisterCrashCallback(ICrashCallback r3, CrashType r4) {
        ICrashCallback r5 = (ICrashCallback) ZeusTransformUtils.wrapperContextForParams(r3, ICrashCallback.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.removeCrashCallback(r5, r4);
    }

    public void unregisterOOMCallback(IOOMCallback r2, CrashType r3) {
        IOOMCallback r4 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r2, IOOMCallback.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.removeOOMCallback(r4);
    }

    public void unregisterPreANRCallback(IPreANRCallback r3) {
        IPreANRCallback r4 = (IPreANRCallback) ZeusTransformUtils.wrapperContextForParams(r3, IPreANRCallback.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.removePreANRCallback(r4);
    }
}
