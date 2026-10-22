package com.bytedance.crash.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class UploadRequest {
    private String aid;
    private List<String> alogFiles;
    private String did;
    private String dumpFilePath;
    private boolean encrypt;
    private String processName;
    private JSONObject uploadBody;
    private String uploadUrl;

    public UploadRequest() {
    }

    public String getAid() {
        return this.aid;
    }

    public List<String> getAlogFiles() {
        return this.alogFiles;
    }

    public String getDid() {
        return this.did;
    }

    public String getDumpFilePath() {
        return this.dumpFilePath;
    }

    public String getProcessName() {
        return this.processName;
    }

    public JSONObject getUploadBody() {
        return this.uploadBody;
    }

    public String getUploadUrl() {
        return this.uploadUrl;
    }

    public boolean isEncrypt() {
        return this.encrypt;
    }

    public void setAid(String r1) {
        this.aid = r1;
    }

    public void setAlogFiles(List<String> r3) {
        this.alogFiles = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setDid(String r1) {
        this.did = r1;
    }

    public void setDumpFilePath(String r1) {
        this.dumpFilePath = r1;
    }

    public void setEncrypt(boolean r1) {
        this.encrypt = r1;
    }

    public void setProcessName(String r1) {
        this.processName = r1;
    }

    public void setUploadBody(JSONObject r1) {
        this.uploadBody = r1;
    }

    public void setUploadUrl(String r1) {
        this.uploadUrl = r1;
    }
}
