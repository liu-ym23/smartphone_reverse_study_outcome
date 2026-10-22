package com.ss.bduploader;

import android.text.TextUtils;
import android.util.Log;
import com.ss.bduploader.logupload.AppLogEngineUploader;
import com.ss.bduploader.logupload.VideoEventEngineUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final enum UploadEventManager extends Enum<UploadEventManager> {
    private static final /* synthetic */ UploadEventManager[] $VALUES = null;
    private static final String TAG = "UploadEventManager";
    public static final UploadEventManager instance = null;
    private boolean mEnableUseEngineUploader;
    private VideoEventEngineUploader mEngineUploader;
    private JSONArray mJsonArray;

    static {
        UploadEventManager r0 = new UploadEventManager("instance", 0);
        instance = r0;
        $VALUES = new UploadEventManager[]{r0};
    }

    private UploadEventManager(String r1, int r2) {
        super(r1, r2);
        this.mJsonArray = new JSONArray();
        this.mEnableUseEngineUploader = true;
        setEngineUploader(AppLogEngineUploader.getInstance());
    }

    public static UploadEventManager valueOf(String r2) {
        return (UploadEventManager) ZeusTransformUtils.preCheckCast(Enum.valueOf(UploadEventManager.class, r2), UploadEventManager.class, "com.obric.memorydata.plugin");
    }

    public static UploadEventManager[] values() {
        return (UploadEventManager[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), UploadEventManager[].class, "com.obric.memorydata.plugin");
    }

    public void addEvent(JSONObject r4) {
        monitor-enter(UploadEventManager.class);
        if (r4 != null) goto L25;
    L18:
        monitor-exit(UploadEventManager.class);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L25:
        if (this.mEngineUploader != null) goto L8;
    L17:
        this.mJsonArray.put(r4);     // Catch: Throwable -> L20
        goto L18
    L8:
        if (this.mEnableUseEngineUploader == false) goto L17;
        String r1 = null;
        r1 = r4.getString("event");     // Catch: JSONException -> L12 Throwable -> L20
    L15:
        if (TextUtils.isEmpty(r1) == true) goto L18;
        this.mEngineUploader.onEventV3(r1, r4);     // Catch: Throwable -> L20
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        goto L15
    }

    public JSONArray popAllEvents() {
        JSONArray r0 = this.mJsonArray;
        monitor-enter(UploadEventManager.class);
        this.mJsonArray = new JSONArray();     // Catch: Throwable -> L7
        monitor-exit(UploadEventManager.class);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public void putEvent(JSONObject r4) {
        monitor-enter(UploadEventManager.class);
        Log.d("ttmn", "putEvent");     // Catch: Throwable -> L7
        this.mJsonArray.put(r4);     // Catch: Throwable -> L7
        monitor-exit(UploadEventManager.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void setEngineUploader(VideoEventEngineUploader r3) {
        monitor-enter(this);
        this.mEngineUploader = (VideoEventEngineUploader) ZeusTransformUtils.wrapperContextForParams(r3, VideoEventEngineUploader.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setUseEngineUploader(boolean r1) {
        this.mEnableUseEngineUploader = r1;
    }
}
