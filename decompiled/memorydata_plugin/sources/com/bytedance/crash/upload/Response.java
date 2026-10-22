package com.bytedance.crash.upload;

import android.text.TextUtils;
import com.bytedance.crash.constants.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class Response {
    private int mErrorCode;
    private Map<String, List<String>> mHeaders;
    private String mMessage;
    private int mServerErrorCode;
    private JSONObject mServerJson;
    private byte[] sourceData;

    public Response(int r1) {
        this.mErrorCode = r1;
    }

    public Response(int r1, String r2) {
        this.mErrorCode = r1;
        this.mMessage = r2;
    }

    public Response(int r1, Throwable r2) {
        this.mErrorCode = r1;
        if (r2 == null) goto L6;
        this.mMessage = r2.getMessage();
        return;
    }

    public Response(int r1, JSONObject r2) {
        this.mErrorCode = r1;
        this.mServerJson = r2;
    }

    public Response(int r1, byte[] r2) {
        this.mErrorCode = r1;
        this.sourceData = r2;
    }

    public int errorCode() {
        return this.mErrorCode;
    }

    public String errorInfo() {
        return this.mMessage;
    }

    public byte[] getData() {
        return this.sourceData;
    }

    public JSONObject getServerJson() {
        return this.mServerJson;
    }

    public boolean isDrop() {
        if (this.mErrorCode != 213) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isStateOk() {
        JSONObject r1 = this.mServerJson;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.optInt("state") != 0) goto L7;
        return true;
    }

    public boolean isSuccess() {
        int r1 = this.mErrorCode;
        if (r1 != 207) goto L5;
    L7:
        return false;
    L5:
        if (r1 == 214) goto L7;
        return true;
    }

    public int serverErrorCode() {
        return this.mServerErrorCode;
    }

    public void setData(byte[] r1) {
        this.sourceData = r1;
    }

    public void setErrCode(int r1) {
        this.mErrorCode = r1;
    }

    public void setErrorInfo(String r1) {
        this.mMessage = r1;
    }

    public void setHeaders(Map<String, List<String>> r3) {
        this.mHeaders = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public void setServerErrorCode(int r1) {
        this.mServerErrorCode = r1;
    }

    public void setServerJson(JSONObject r7) {
        this.mServerJson = r7;
        String r8 = "";
        if (this.mHeaders == null) goto L14;
        new ArrayList();     // Catch: Throwable -> L22
        Iterator<Map.Entry<String, List<String>>> r1 = this.mHeaders.entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r1.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if ("Alog_quota".equalsIgnoreCase((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin")) == false) goto L8;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r3.getValue(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r4.size() <= 0) goto L8;
        r8 = (String) ZeusTransformUtils.preCheckCast(r4.get(0), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
    L14:
        this.mServerJson.putOpt("Alog_quota", r8);     // Catch: Throwable -> L22
        String r9 = this.mServerJson.optString("message");     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r9) == false) goto L17;
        return;
    L17:
        if (r9.equals("drop all data") == false) goto L19;
    L20:
        setErrCode(Constants.UPLOAD_DISASTER_DROP);     // Catch: Throwable -> L22
        return;
    L19:
        if (r9.equals("drop data") == true) goto L20;
        return;
    }

    public String toString() {
        String r0 = "Response:mErrorCode=" + this.mErrorCode + ", mServerErrorCode=" + this.mServerErrorCode;
        if (this.mServerJson != null) goto L5;
        return r0;
    L5:
        return r0 + ", mServerJson=" + this.mServerJson.toString();
    }
}
