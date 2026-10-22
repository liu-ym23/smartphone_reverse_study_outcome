package com.bytedance.crash.monitor;

import android.text.TextUtils;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.event.EventDeliverer;
import com.bytedance.crash.service.ICrashBodyExtensionDumper;
import com.bytedance.crash.util.JSONUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class EventMonitor {
    private ICrashBodyExtensionDumper bodyDumper;
    protected EnsureDeliverer ensureDeliver;
    protected EventDeliverer eventDeliverer;
    protected volatile String mAppId;
    protected volatile String mChannel;
    protected volatile String mDeviceId;
    protected JSONObject mMPParams;
    protected volatile long mManifestVersionCode;
    protected volatile long mUpdateVersionCode;
    protected final UserDataCenter mUserDataCenter;
    protected volatile long mUserId;
    protected volatile long mVersionCode;
    protected volatile String mVersionName;

    EventMonitor(UserDataCenter r1) {
        this.mUserDataCenter = r1;
    }

    EventMonitor(UserDataCenter r1, String r2, String r3, long r4, long r6, long r8) {
        this.mAppId = r2;
        this.mVersionName = r3;
        this.mVersionCode = r4;
        this.mManifestVersionCode = r8;
        this.mUpdateVersionCode = r6;
        this.mUserDataCenter = r1;
    }

    EventMonitor(String r11, String r12, long r13, long r15, long r17) {
        this(new UserDataCenter(), r11, r12, r13, r15, r17);
    }

    public void addAttachLongUserData(AttachUserData r3, CrashType r4) {
        AttachUserData r5 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r3, AttachUserData.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.addAttachUserData(r5, r4);
    }

    public void addAttachUserData(AttachUserData r3, CrashType r4) {
        AttachUserData r5 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r3, AttachUserData.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.addAttachUserData(r5, r4);
    }

    public void addTag(String r1, String r2) {
        this.mUserDataCenter.addCustomTag(r1, r2);
    }

    public void addTags(Map<? extends String, ? extends String> r3) {
        Map<? extends String, ? extends String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.addCustomTags(r4);
    }

    public String getAppId() {
        return this.mAppId;
    }

    public ICrashBodyExtensionDumper getBodyDumper() {
        return this.bodyDumper;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public Map<String, Object> getCommParams() {
        return null;
    }

    public String getDeviceId(String r2) {
        if (TextUtils.isEmpty(this.mDeviceId) == false) goto L6;
        return r2;
    L6:
        return this.mDeviceId;
    }

    public EnsureDeliverer getEnsureDeliver() {
        if (this.ensureDeliver != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.ensureDeliver != null) goto L8;
        this.ensureDeliver = new EnsureDeliverer(this);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.ensureDeliver;
    }

    public EventDeliverer getEventDeliverer() {
        if (this.eventDeliverer != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.eventDeliverer != null) goto L8;
        this.eventDeliverer = new EventDeliverer(this);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.eventDeliverer;
    }

    public JSONObject getMPParams() {
        return this.mMPParams;
    }

    public long getManifestVersionCode() {
        return this.mManifestVersionCode;
    }

    public String getTobUserId() {
        return "";
    }

    public long getUpdateVersionCode() {
        return this.mUpdateVersionCode;
    }

    public UserDataCenter getUserDataCenter() {
        return this.mUserDataCenter;
    }

    public long getUserId() {
        return this.mUserId;
    }

    public AppVersionModel getVersion() {
        return new AppVersionModel(this.mVersionCode, this.mUpdateVersionCode, 0, this.mVersionName);
    }

    public long getVersionCode() {
        return this.mVersionCode;
    }

    public String getVersionName() {
        return this.mVersionName;
    }

    public void registerBodyHeaderDumper(ICrashBodyExtensionDumper r3) {
        this.bodyDumper = (ICrashBodyExtensionDumper) ZeusTransformUtils.wrapperContextForParams(r3, ICrashBodyExtensionDumper.class, "com.obric.memorydata.plugin");
    }

    public void removeAttachLongUserData(AttachUserData r3, CrashType r4) {
        AttachUserData r5 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r3, AttachUserData.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.removeAttachUserData(r4, r5);
    }

    public void removeAttachUserData(AttachUserData r3, CrashType r4) {
        AttachUserData r5 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r3, AttachUserData.class, "com.obric.memorydata.plugin");
        this.mUserDataCenter.removeAttachUserData(r4, r5);
    }

    public void removeTag(String r1) {
        this.mUserDataCenter.removeCustomTag(r1);
    }

    public void reportEnsure(String r1, Throwable r2) {
        getEnsureDeliver().reportThrowable(r2, r1);
    }

    public void reportEvent(String r1, int r2, JSONObject r3, JSONObject r4) {
        getEventDeliverer().reportEvent(r1, r2, r3, r4);
    }

    public void setChannel(String r1) {
        this.mChannel = r1;
    }

    public void setDeviceId(String r1) {
        this.mDeviceId = r1;
    }

    public void setMPParams(Map<String, Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        this.mMPParams = null;
        return;
    L6:
        if (this.mMPParams != null) goto L8;
        this.mMPParams = new JSONObject();
    L8:
        JSONUtils.jsonPutAll(this.mMPParams, r4);
    }

    public void setUserId(long r1) {
        this.mUserId = r1;
    }
}
