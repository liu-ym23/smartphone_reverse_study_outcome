package com.bytedance.reparo.model;

import android.text.TextUtils;
import c97.h;
import com.bytedance.reparo.core.p;
import com.google.gson.annotations.SerializedName;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class PatchFetchInfo {

    @SerializedName("update_version_code")
    private String hostAppVersion;

    @SerializedName("async_load")
    private boolean isAsyncLoad;

    @SerializedName("support_sub_process")
    private boolean isSupportSubProcess;

    @SerializedName("hotfix_id")
    private String issueId;
    private String md5;
    private String name;
    private boolean offline;

    @SerializedName("patch_id")
    private int patchId;

    @SerializedName("patch_name")
    private String patchName;
    private String url;

    @SerializedName("versioncode")
    private int versionCode;
    private boolean wifiOnly;

    public String getMd5() {
        String r0 = this.md5;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.toLowerCase();
    }

    public String toString() {
        return "{patchName = " + this.patchName + ", patchId = " + this.patchId + ", issueId = " + this.issueId + ", md5 = " + this.md5 + ", hostAppVersion = " + this.hostAppVersion + ", isAsyncLoad = " + this.isAsyncLoad + ", isSupportSubProcess = " + this.isSupportSubProcess + "}";
    }

    public PatchFetchInfo() {
        this.isAsyncLoad = true;
    }

    public int hashCode() {
        return 527 + getMd5().hashCode();
    }

    public String getHostAppVersion() {
        return this.hostAppVersion;
    }

    public String getIssueId() {
        return this.issueId;
    }

    public String getName() {
        return this.name;
    }

    public int getPatchId() {
        return this.patchId;
    }

    public String getPatchName() {
        return this.patchName;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public boolean isAsyncLoad() {
        return this.isAsyncLoad;
    }

    public boolean isOffline() {
        return this.offline;
    }

    public boolean isSupportSubProcess() {
        return this.isSupportSubProcess;
    }

    public boolean isWifiOnly() {
        return this.wifiOnly;
    }

    public p convertToUpdateRequest(File r9) {
        String r0 = getMd5();
        String r1 = String.valueOf(this.versionCode);
        String r2 = String.valueOf(this.patchId);
        String r3 = this.issueId;
        String r4 = this.hostAppVersion;
        boolean r5 = this.isAsyncLoad;
        boolean r6 = isSupportSubProcess();
        if (r9 == null) goto L15;
        if (TextUtils.isEmpty(r0) == true) goto L13;
        if (TextUtils.isEmpty(r4) == true) goto L11;
        p r7 = new p();
        r7.a = r9;
        r7.b = r0;
        r7.c = r1;
        r7.d = r2;
        r7.e = r3;
        r7.f = r4;
        r7.g = r5;
        r7.h = r6;
        return r7;
    L11:
        throw new IllegalArgumentException("host app version is empty");
    L13:
        throw new IllegalArgumentException("patch md5 is empty");
    L15:
        throw new IllegalArgumentException("patch file is null");
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L29:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L29;
        PatchFetchInfo r6 = (PatchFetchInfo) r5;
        if (TextUtils.equals(this.md5, r6.md5) == true) goto L13;
    L27:
        return false;
    L13:
        if (TextUtils.equals(this.issueId, r6.issueId) == false) goto L27;
        if (TextUtils.equals(this.hostAppVersion, r6.hostAppVersion) == false) goto L27;
        if (TextUtils.equals(this.url, r6.url) == false) goto L27;
        if (this.versionCode != r6.versionCode) goto L27;
        if (this.patchId != r6.patchId) goto L27;
        if (this.isAsyncLoad != r6.isAsyncLoad) goto L27;
        if (this.isSupportSubProcess != r6.isSupportSubProcess) goto L27;
        return true;
    }

    public void setAsyncLoad(boolean r1) {
        this.isAsyncLoad = r1;
    }

    public void setHostAppVersion(String r1) {
        this.hostAppVersion = r1;
    }

    public void setIssueId(String r1) {
        this.issueId = r1;
    }

    public void setMd5(String r1) {
        this.md5 = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setOffline(boolean r1) {
        this.offline = r1;
    }

    public void setPatchId(int r1) {
        this.patchId = r1;
    }

    public void setPatchName(String r1) {
        this.patchName = r1;
    }

    public void setSupportSubProcess(boolean r1) {
        this.isSupportSubProcess = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public void setVersionCode(int r1) {
        this.versionCode = r1;
    }

    public void setWifiOnly(boolean r1) {
        this.wifiOnly = r1;
    }

    public boolean equals(h r2) {
        return TextUtils.equals(String.valueOf(this.patchId), r2.j);
    }
}
