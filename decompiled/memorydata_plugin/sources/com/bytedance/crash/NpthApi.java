package com.bytedance.crash;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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
        IANRInfoCallback r0 = sCallback;
        if (r0 == null) goto L6;
        addANRInfoCallbackInner(r0);
        return;
    }

    public static void addANRInfoCallback(IANRInfoCallback r2) {
        IANRInfoCallback r3 = (IANRInfoCallback) ZeusTransformUtils.wrapperContextForParams(r2, IANRInfoCallback.class, "com.obric.memorydata.plugin");
        NpthApi r0 = sImpl;
        if (r0 == null) goto L5;
        r0.addANRInfoCallbackInner(r3);
        return;
    L5:
        sCallback = r3;
    }

    public static void addCustomData(CustomDataCallback r2) {
        CustomDataCallback r3 = (CustomDataCallback) ZeusTransformUtils.wrapperContextForParams(r2, CustomDataCallback.class, "com.obric.memorydata.plugin");
        NpthApi r0 = sImpl;
        if (r0 == null) goto L6;
        r0.addCustomInner(r3);
        return;
    }

    public static void addCustomData(CustomDataCallback r2, String r3) {
        CustomDataCallback r4 = (CustomDataCallback) ZeusTransformUtils.wrapperContextForParams(r2, CustomDataCallback.class, "com.obric.memorydata.plugin");
        NpthApi r0 = sImpl;
        if (r0 == null) goto L7;
        if (r4 == null) goto L8;
        r0.addCustomInner(r4, r3);
        return;
    L8:
        return;
    }

    public static void addTags(Map<String, String> r2) {
        Map<String, String> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        NpthApi r0 = sImpl;
        if (r0 == null) goto L6;
        r0.addTagsInner(r3);
        return;
    }

    public static void checkInnerSoFile(String r1) {
        NpthApi r0 = sImpl;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.checkInnerSo(r1);
    }

    public static void checkInnerSoFile(String r1, String r2) {
        NpthApi r0 = sImpl;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.checkInnerSo(r1, r2);
    }

    public static String getByTraceID() {
        NpthApi r0 = sImpl;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0.getByTraceIDInner();
    }

    public static JSONObject getRetraceParams() {
        RetraceDataCallback r0 = sRetraceDataCallback;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getData();
    }

    public static void registerSDKVersion(String r1, String r2) {
        NpthApi r0 = sImpl;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.registerSDK(r1, r2);
    }

    public static void setRetraceData(RetraceDataCallback r2) {
        sRetraceDataCallback = (RetraceDataCallback) ZeusTransformUtils.wrapperContextForParams(r2, RetraceDataCallback.class, "com.obric.memorydata.plugin");
    }

    public static void startMonitor() {
        NpthApi r0 = sImpl;
        if (r0 == null) goto L6;
        r0.startMonitorInner();
        return;
    }

    public static void uploadKilledHistory() {
        NpthApi r0 = sImpl;
        if (r0 == null) goto L6;
        r0.uploadKilledHistoryInner();
        return;
    }

    public void addANRInfoCallbackInner(IANRInfoCallback r2) {
        IANRInfoCallback r1 = (IANRInfoCallback) ZeusTransformUtils.wrapperContextForParams(r2, IANRInfoCallback.class, "com.obric.memorydata.plugin");
    }

    public void addCustomInner(CustomDataCallback r2) {
        CustomDataCallback r1 = (CustomDataCallback) ZeusTransformUtils.wrapperContextForParams(r2, CustomDataCallback.class, "com.obric.memorydata.plugin");
    }

    public void addCustomInner(CustomDataCallback r1, String r2) {
        CustomDataCallback r0 = (CustomDataCallback) ZeusTransformUtils.wrapperContextForParams(r1, CustomDataCallback.class, "com.obric.memorydata.plugin");
    }

    public void addTagsInner(Map<String, String> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
    }

    public void checkInnerSo(String r1) {
    }

    public void checkInnerSo(String r1, String r2) {
    }

    public String getByTraceIDInner() {
        return "";
    }

    public void registerSDK(String r1, String r2) {
    }

    public void startMonitorInner() {
    }

    public void uploadKilledHistoryInner() {
    }
}
