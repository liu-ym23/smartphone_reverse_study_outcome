package com.obric.cae.userAware.poi;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class PoiAdspTraceLogger {
    public static final String FILE_NAME = "poi_adsp_trace.jsonl";
    private static final long MAX_FILE_BYTES = 5242880;
    private static final String ROTATED_FILE_NAME = "poi_adsp_trace.1.jsonl";
    private static final int SCHEMA_VERSION = 1;
    public static final String SETTINGS_GLOBAL_TRACE_ENABLED = "cae_user_aware_poi_adsp_trace_enabled";
    private static final String TAG = "PoiAdspTrace";
    private static volatile PoiAdspTraceLogger sInstance;
    private final Context mContext;
    private final File mFile;
    private final Handler mHandler;
    private final File mRotatedFile;
    private final HandlerThread mThread;

    private PoiAdspTraceLogger(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.mFile = new File(r5.getFilesDir(), FILE_NAME);
        this.mRotatedFile = new File(r5.getFilesDir(), ROTATED_FILE_NAME);
        HandlerThread r6 = new HandlerThread("PoiAdspTraceWriter");
        this.mThread = r6;
        r6.start();
        this.mHandler = new Handler(r6.getLooper());
    }

    private static void appendBundle(JSONObject r4, Bundle r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = r5.keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L20;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        Object r2 = r5.get(r1);
        if (ZeusTransformUtils.instanceOf(r2, Integer.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r2, Long.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r2, Float.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r2, Double.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == true) goto L19;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L6;
    L19:
        r4.put(toSnakeCase(r1), r2);
        goto L6
    }

    private void appendLine(String r3) {
        rotateIfNeeded(r3.length());     // Catch: IOException -> L12
        FileOutputStream r0 = new FileOutputStream(this.mFile, true);     // Catch: IOException -> L12
        r0.write(r3.getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L6
        r0.close();     // Catch: IOException -> L12
        return;
    L6:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L9
    L11:
        throw th;     // Catch: IOException -> L12
    L9:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L12
    L12:
        e = move-exception;
        a.g(TAG, "trace write failed: " + e.getMessage());
    }

    public static PoiAdspTraceLogger getInstance(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        PoiAdspTraceLogger r0 = sInstance;
        if (r0 == null) goto L6;
        return r0;
    L6:
        monitor-enter(PoiAdspTraceLogger.class);
    L17:
        th = move-exception;
        throw th;
    L8:
        if (sInstance != null) goto L14;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r1 == null) goto L13;
        r5 = r1;
    L13:
        sInstance = new PoiAdspTraceLogger(r5);     // Catch: Throwable -> L17
    L14:
        PoiAdspTraceLogger r6 = sInstance;     // Catch: Throwable -> L17
        monitor-exit(PoiAdspTraceLogger.class);     // Catch: Throwable -> L17
        return r6;
    }

    private void rotateIfNeeded(int r5) {
        if (this.mFile.exists() == true) goto L5;
        return;
    L5:
        if ((this.mFile.length() + ((long) r5)) > MAX_FILE_BYTES) goto L8;
        return;
    L8:
        if (this.mRotatedFile.exists() == false) goto L14;
        if (this.mRotatedFile.delete() == true) goto L14;
        a.g(TAG, "failed to remove old rotated trace");
        return;
    L14:
        if (this.mFile.renameTo(this.mRotatedFile) == true) goto L18;
        a.g(TAG, "failed to rotate trace");
        return;
    }

    private static String toSnakeCase(String r4) {
        StringBuilder r0 = new StringBuilder(r4.length() + 8);
        int r1 = 0;
    L4:
        if (r1 >= r4.length()) goto L12;
        char r2 = r4.charAt(r1);
        if (Character.isUpperCase(r2) == false) goto L10;
        if (r1 <= 0) goto L9;
        r0.append('_');
    L9:
        r2 = Character.toLowerCase(r2);
    L10:
        r0.append(r2);
        r1 = r1 + 1;
        goto L4
    L12:
        return r0.toString();
    }

    public void append(String r4, String r5, String r6, String r7, String r8, String r9, Bundle r10) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        JSONObject r0 = new JSONObject();
        r0.put("schema_version", 1);     // Catch: JSONException -> L12
        r0.put("record_type", r4);     // Catch: JSONException -> L12
        r0.put("upload_reason", r5);     // Catch: JSONException -> L12
        if (r6 == null) goto L9;
        r0.put("algo", r6);     // Catch: JSONException -> L12
    L9:
        r0.put("event", r7);     // Catch: JSONException -> L12
        r0.put("decision", r8);     // Catch: JSONException -> L12
        r0.put("decision_reason", r9);     // Catch: JSONException -> L12
        r0.put("ap_receive_ts_ms", System.currentTimeMillis());     // Catch: JSONException -> L12
        appendBundle(r0, r10);     // Catch: JSONException -> L12
        final String r11 = r0.toString() + "\n";
        this.mHandler.post(new $$Lambda$PoiAdspTraceLogger$fapAUf6XiK7yV1z6uvq0nUAmvNw(this, r11));
        return;
    L12:
        e = move-exception;
        a.g(TAG, "ignore malformed trace record: " + e.getMessage());
    }

    public void clear() {
        this.mHandler.post(new $$Lambda$PoiAdspTraceLogger$3dcYy2dgV1TscCsmQ0LH9TIOKak(this));
    }

    public boolean isEnabled() {
        if (Settings.Global.getInt(this.mContext.getContentResolver(), "cae_user_aware_poi_adsp_trace_enabled", 0) == 1) goto L7;
        return false;
    L7:
        return true;
    L12:
        return false;
    }

    public /* synthetic */ void lambda$append$0$PoiAdspTraceLogger(String r1) {
        appendLine(r1);
    }

    public /* synthetic */ void lambda$clear$1$PoiAdspTraceLogger() {
        if (this.mFile.exists() == false) goto L8;
        if (this.mFile.delete() == true) goto L8;
        a.g(TAG, "failed to delete trace file");
    L8:
        if (this.mRotatedFile.exists() == true) goto L10;
        return;
    L10:
        if (this.mRotatedFile.delete() == true) goto L14;
        a.g(TAG, "failed to delete rotated trace file");
        return;
    }
}
