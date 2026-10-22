package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class PlatformBindInfo {
    public static final int HASH_31 = 31;

    @SerializedName("allow_sync")
    private boolean allowSync;

    @SerializedName("bind_user_name")
    private String bindUserName;

    @SerializedName("platform")
    private String platform;

    @SerializedName("publish_sync_tips_cnt")
    private int publishSyncTipsCnt;

    @SerializedName("tigger_full_sync")
    private boolean tiggerFullSync;

    public PlatformBindInfo() {
    }

    public int hashCode() {
        String r0 = this.platform;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((r2 * 31) + (this.allowSync ? 1 : 0)) * 31) + (this.tiggerFullSync ? 1 : 0)) * 31;
        String r4 = this.bindUserName;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.publishSyncTipsCnt;
    L5:
        r2 = 0;
        goto L6
    }

    public String getBindUserName() {
        return this.bindUserName;
    }

    public String getPlatform() {
        return this.platform;
    }

    public int getPublishSyncTipsCnt() {
        return this.publishSyncTipsCnt;
    }

    public boolean isAllowSync() {
        return this.allowSync;
    }

    public boolean isTiggerFullSync() {
        return this.tiggerFullSync;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L34:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L34;
        PlatformBindInfo r6 = (PlatformBindInfo) r5;
        if (this.allowSync == r6.allowSync) goto L14;
        return false;
    L14:
        if (this.tiggerFullSync == r6.tiggerFullSync) goto L17;
        return false;
    L17:
        if (this.publishSyncTipsCnt == r6.publishSyncTipsCnt) goto L19;
        return false;
    L19:
        String r2 = this.platform;
        if (r2 == null) goto L25;
        if (r2.equals(r6.platform) == false) goto L26;
    L27:
        String r3 = this.bindUserName;
        String r7 = r6.bindUserName;
        if (r3 != null) goto L35;
        if (r7 == null) goto L36;
        return false;
    L36:
        return true;
    L35:
        return r3.equals(r7);
    L26:
        return false;
    L25:
        if (r6.platform == null) goto L27;
        goto L26
    }

    public void setAllowSync(boolean r1) {
        this.allowSync = r1;
    }

    public void setBindUserName(String r1) {
        this.bindUserName = r1;
    }

    public void setPlatform(String r1) {
        this.platform = r1;
    }

    public void setPublishSyncTipsCnt(int r1) {
        this.publishSyncTipsCnt = r1;
    }

    public void setTiggerFullSync(boolean r1) {
        this.tiggerFullSync = r1;
    }
}
