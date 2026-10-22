package com.bytedance.crash.monitor;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.event.EventDeliverer;
import com.bytedance.crash.service.ICrashBodyExtensionDumper;
import com.bytedance.crash.util.JSONUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    EventMonitor(@NonNull UserDataCenter r10) {
        this.mUserDataCenter = r10;
    }

    EventMonitor(@NonNull UserDataCenter r10, @NonNull String r11, @NonNull String r12, long r13, long r14, long r15) {
        this.mAppId = r11;
        this.mVersionName = r12;
        this.mVersionCode = r13;
        this.mManifestVersionCode = r15;
        this.mUpdateVersionCode = r14;
        this.mUserDataCenter = r10;
    }

    EventMonitor(@NonNull String r11, @NonNull String r12, long r13, long r15, long r17) {
        this(new UserDataCenter(), r11, r12, r13, r15, r17);
    }

    public void addAttachLongUserData(AttachUserData r10, CrashType r11) {
        this.mUserDataCenter.addAttachUserData(r10, r11);
    }

    public void addAttachUserData(AttachUserData r10, CrashType r11) {
        this.mUserDataCenter.addAttachUserData(r10, r11);
    }

    public void addTag(String r10, String r11) {
        this.mUserDataCenter.addCustomTag(r10, r11);
    }

    public void addTags(Map<? extends String, ? extends String> r10) {
        this.mUserDataCenter.addCustomTags(r10);
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

    public String getDeviceId(String r10) {
        if (TextUtils.isEmpty(this.mDeviceId) == false) goto L6;
        return r10;
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

    @NonNull
    public UserDataCenter getUserDataCenter() {
        return this.mUserDataCenter;
    }

    public long getUserId() {
        return this.mUserId;
    }

    @NonNull
    public AppVersionModel getVersion() {
        return new AppVersionModel(this.mVersionCode, this.mUpdateVersionCode, 0, this.mVersionName);
    }

    public long getVersionCode() {
        return this.mVersionCode;
    }

    public String getVersionName() {
        return this.mVersionName;
    }

    public void registerBodyHeaderDumper(ICrashBodyExtensionDumper r10) {
        this.bodyDumper = r10;
    }

    public void removeAttachLongUserData(AttachUserData r10, CrashType r11) {
        this.mUserDataCenter.removeAttachUserData(r11, r10);
    }

    public void removeAttachUserData(AttachUserData r10, CrashType r11) {
        this.mUserDataCenter.removeAttachUserData(r11, r10);
    }

    public void removeTag(String r10) {
        this.mUserDataCenter.removeCustomTag(r10);
    }

    public void reportEnsure(String r10, Throwable r11) {
        getEnsureDeliver().reportThrowable(r11, r10);
    }

    public void reportEvent(String r10, int r11, JSONObject r12, JSONObject r13) {
        getEventDeliverer().reportEvent(r10, r11, r12, r13);
    }

    public void setChannel(@NonNull String r10) {
        this.mChannel = r10;
    }

    public void setDeviceId(@NonNull String r10) {
        this.mDeviceId = r10;
    }

    public void setMPParams(Map<String, Object> r10) {
        if (r10 != null) goto L5;
        this.mMPParams = null;
        return;
    L5:
        if (this.mMPParams != null) goto L7;
        this.mMPParams = new JSONObject();
    L7:
        JSONUtils.jsonPutAll(this.mMPParams, r10);
    }

    public void setUserId(long r10) {
        this.mUserId = r10;
    }
}
