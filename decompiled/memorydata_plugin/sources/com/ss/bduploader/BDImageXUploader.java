package com.ss.bduploader;

import android.text.TextUtils;
import java.util.TreeMap;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class BDImageXUploader extends BDImageXUploaderBase {
    public BDImageXUploader() {
    }

    public void SetExtraParams(JSONObject r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 == null) goto L9;
        setStringValue(61, r5.toString());
        return;
    L9:
        return;
    }

    public void allowContinueUpload() {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _allowContinueUpload(this.mHandle);
    }

    public void allowMergeUpload() {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _mergeUpload(this.mHandle);
    }

    public void cancelUpload() {
        this.mWriteLock.lock();
        if (this.mHandle != 0) goto L6;
    L4:
        this.mWriteLock.unlock();
        return;
    L6:
        _cancelUpload(this.mHandle);
        goto L4
    }

    public void setCustomConfig(TreeMap<String, Object> r5) {
        if (this.mHandle == 0) goto L21;
        if (r5 == null) goto L22;
        JSONObject r6 = BDUploadUtil.mapToJSON(r5);
        if (r6 != null) goto L9;
        return;
    L9:
        JSONObject r0 = new JSONObject();
        r0.put("custom_config", r6);     // Catch: Throwable -> L15
        String r7 = r0.toString();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r7) == true) goto L20;
        setStringValue(63, r7);
        return;
    L20:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L22:
        return;
    }

    public void setCustomNetworkTimeoutParams(int r5, int r6, int r7, int r8, int r9) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _setIntValue(this.mHandle, 422, r5);
        _setIntValue(this.mHandle, 423, r6);
        _setIntValue(this.mHandle, 424, r7);
        _setIntValue(this.mHandle, 425, r8);
        _setIntValue(this.mHandle, BDAbstractUpload.KeyIsSDKRetryPolicy, r9);
    }

    public void setDataTransportProtocol(int r5) {
        if (this.mHandle == 0) goto L8;
        if (r5 < 0) goto L9;
        _setIntValue(this.mHandle, 411, r5);
        return;
    L9:
        return;
    }

    public void setObjectType(String r2) {
        setStringValue(54, r2);
    }

    public void setPreUpload(boolean r1) {
    }

    public void setPreUploadEncryptionMode(int r5) {
        if (this.mHandle != 0) goto L6;
        return;
    L6:
        if (r5 != 2) goto L12;
        String r0 = UUID.randomUUID().toString();
        if (r0 == null) goto L12;
        if (r0.length() <= 0) goto L12;
        _setStringValue(this.mHandle, 420, r0);
    L12:
        _setIntValue(this.mHandle, 74, r5);
    }

    public void setPreheatUploader(int r5) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _setIntValue(this.mHandle, 419, r5);
    }

    public void setPreheatUploader(boolean r5) {
        if (this.mHandle != 0) goto L5;
        return;
    L5:
        _setIntValue(this.mHandle, 419, r5 ? 1 : 0);
    }

    public void startPreHeat() {
        setPreheatUploader(2);
        start();
    }
}
