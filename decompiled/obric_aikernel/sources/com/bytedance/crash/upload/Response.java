package com.bytedance.crash.upload;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.crash.constants.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Response {
    private int mErrorCode;
    private Map<String, List<String>> mHeaders;
    private String mMessage;
    private int mServerErrorCode;
    private JSONObject mServerJson;
    private byte[] sourceData;

    public Response(int r10) {
        this.mErrorCode = r10;
    }

    public Response(int r10, String r11) {
        this.mErrorCode = r10;
        this.mMessage = r11;
    }

    public Response(int r10, Throwable r11) {
        this.mErrorCode = r10;
        if (r11 == null) goto L6;
        this.mMessage = r11.getMessage();
        return;
    }

    public Response(int r10, JSONObject r11) {
        this.mErrorCode = r10;
        this.mServerJson = r11;
    }

    public Response(int r10, byte[] r11) {
        this.mErrorCode = r10;
        this.sourceData = r11;
    }

    public int errorCode() {
        return this.mErrorCode;
    }

    public String errorInfo() {
        return this.mMessage;
    }

    @Nullable
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
        JSONObject r10 = this.mServerJson;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.optInt("state") != 0) goto L7;
        return true;
    }

    public boolean isSuccess() {
        int r10 = this.mErrorCode;
        if (r10 != 207) goto L5;
    L7:
        return false;
    L5:
        if (r10 == 214) goto L7;
        return true;
    }

    public int serverErrorCode() {
        return this.mServerErrorCode;
    }

    public void setData(byte[] r10) {
        this.sourceData = r10;
    }

    public void setErrCode(int r10) {
        this.mErrorCode = r10;
    }

    public void setErrorInfo(String r10) {
        this.mMessage = r10;
    }

    public void setHeaders(Map<String, List<String>> r10) {
        this.mHeaders = r10;
    }

    public void setServerErrorCode(int r10) {
        this.mServerErrorCode = r10;
    }

    public void setServerJson(JSONObject r10) {
        this.mServerJson = r10;
        String r11 = "";
        if (this.mHeaders == null) goto L14;
        new ArrayList();     // Catch: Throwable -> L22
        Iterator<Map.Entry<String, List<String>>> r12 = this.mHeaders.entrySet().iterator();     // Catch: Throwable -> L22
    L8:
        if (r12.hasNext() == false) goto L14;
        Map.Entry<String, List<String>> r13 = r12.next();     // Catch: Throwable -> L22
        if ("Alog_quota".equalsIgnoreCase(r13.getKey()) == false) goto L8;
        List<String> r14 = r13.getValue();     // Catch: Throwable -> L22
        if (r14.size() <= 0) goto L8;
        r11 = r14.get(0);     // Catch: Throwable -> L22
    L14:
        this.mServerJson.putOpt("Alog_quota", r11);     // Catch: Throwable -> L22
        String r15 = this.mServerJson.optString("message");     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r15) == false) goto L17;
        return;
    L17:
        if (r15.equals("drop all data") == false) goto L19;
    L20:
        setErrCode(Constants.UPLOAD_DISASTER_DROP);     // Catch: Throwable -> L22
        return;
    L19:
        if (r15.equals("drop data") == true) goto L20;
        return;
    }

    public String toString() {
        String r10 = "Response:mErrorCode=" + this.mErrorCode + ", mServerErrorCode=" + this.mServerErrorCode;
        if (this.mServerJson != null) goto L5;
        return r10;
    L5:
        return r10 + ", mServerJson=" + this.mServerJson.toString();
    }
}
