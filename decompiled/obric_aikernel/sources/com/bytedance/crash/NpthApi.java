package com.bytedance.crash;

import androidx.annotation.Nullable;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NpthApi {
    private static IANRInfoCallback sCallback;
    private static NpthApi sImpl;
    private static RetraceDataCallback sRetraceDataCallback;

    public interface CustomDataCallback {
        Map<String, String> getData();
    }

    public interface IANRInfoCallback {
        File getFile();
    }

    public interface RetraceDataCallback {
        JSONObject getData();
    }

    static {
    }

    NpthApi() {
        sImpl = this;
        IANRInfoCallback r10 = sCallback;
        if (r10 == null) goto L6;
        addANRInfoCallbackInner(r10);
        return;
    }

    public static void addANRInfoCallback(IANRInfoCallback r10) {
        NpthApi r11 = sImpl;
        if (r11 == null) goto L5;
        r11.addANRInfoCallbackInner(r10);
        return;
    L5:
        sCallback = r10;
    }

    public static void addCustomData(CustomDataCallback r10) {
        NpthApi r11 = sImpl;
        if (r11 == null) goto L6;
        r11.addCustomInner(r10);
        return;
    }

    public static void addCustomData(CustomDataCallback r10, String r11) {
        NpthApi r12 = sImpl;
        if (r12 == null) goto L7;
        if (r10 == null) goto L8;
        r12.addCustomInner(r10, r11);
        return;
    L8:
        return;
    }

    public static void addTags(Map<String, String> r10) {
        NpthApi r11 = sImpl;
        if (r11 == null) goto L6;
        r11.addTagsInner(r10);
        return;
    }

    public static void checkInnerSoFile(String r10) {
        NpthApi r11 = sImpl;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.checkInnerSo(r10);
    }

    public static void checkInnerSoFile(String r10, String r11) {
        NpthApi r12 = sImpl;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.checkInnerSo(r10, r11);
    }

    public static String getByTraceID() {
        NpthApi r10 = sImpl;
        if (r10 != null) goto L7;
        return "";
    L7:
        return r10.getByTraceIDInner();
    }

    @Nullable
    public static JSONObject getRetraceParams() {
        RetraceDataCallback r10 = sRetraceDataCallback;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.getData();
    }

    public static void registerSDKVersion(String r10, String r11) {
        NpthApi r12 = sImpl;
        if (r12 != null) goto L5;
        return;
    L5:
        r12.registerSDK(r10, r11);
    }

    public static void setRetraceData(RetraceDataCallback r10) {
        sRetraceDataCallback = r10;
    }

    public static void startMonitor() {
        NpthApi r10 = sImpl;
        if (r10 == null) goto L6;
        r10.startMonitorInner();
        return;
    }

    public static void uploadKilledHistory() {
        NpthApi r10 = sImpl;
        if (r10 == null) goto L6;
        r10.uploadKilledHistoryInner();
        return;
    }

    protected void addANRInfoCallbackInner(IANRInfoCallback r10) {
    }

    protected void addCustomInner(CustomDataCallback r10) {
    }

    protected void addCustomInner(CustomDataCallback r10, String r11) {
    }

    protected void addTagsInner(Map<String, String> r10) {
    }

    protected void checkInnerSo(String r10) {
    }

    protected void checkInnerSo(String r10, String r11) {
    }

    protected String getByTraceIDInner() {
        return "";
    }

    protected void registerSDK(String r10, String r11) {
    }

    protected void startMonitorInner() {
    }

    protected void uploadKilledHistoryInner() {
    }
}
