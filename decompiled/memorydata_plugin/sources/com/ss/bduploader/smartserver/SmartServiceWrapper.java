package com.ss.bduploader.smartserver;

import android.text.TextUtils;
import android.util.Log;
import com.ss.ugc.clientai.core.api.SmartInputData;
import com.ss.ugc.clientai.core.api.SmartOutputData;
import com.ss.ugc.clientai.core.api.SmartService;
import com.ss.ugc.clientai.core.api.SmartServiceConfig;
import com.ss.ugc.clientai.core.api.SmartServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SmartServiceWrapper implements SmartServiceInterface {
    public static final int KEY_IS_MLSDK_ENGINE_TYPE = 1000;
    public static final int KEY_IS_MLSDK_OUTPUT_TYPE = 1002;
    public static final int KEY_IS_MLSDK_SERVICE_NAME = 1001;
    public static final int KEY_IS_MLSDK_URL = 1003;
    public static final int KeyIsIntelligentClassification = 1;
    public static final int KeyIsIntelligentRegression = 0;
    private String mIntelligentURL;
    private String mMLSDKEngineType;
    private String mMLSDKOutputType;
    private SmartService mMLSDKService;
    private String mMLSDKServiceName;

    public SmartServiceWrapper() {
        this.mMLSDKEngineType = "";
        this.mMLSDKServiceName = "";
        this.mMLSDKOutputType = "";
        this.mIntelligentURL = "";
    }

    private float parseIntelligentInputFloat(JSONObject r1, String r2, int r3) {
        if (r3 != 1) goto L5;
        double r0 = r1.getJSONObject("optimized_info").getDouble(r2);     // Catch: Exception -> L7
    L6:
        return (float) r0;
    L5:
        r0 = r1.getDouble(r2);     // Catch: Exception -> L7
    L7:
        return 0.0f;
    }

    private String parseIntelligentInputString(JSONObject r1, String r2, int r3) {
        if (r3 != 1) goto L5;
        String r0 = r1.getJSONObject("optimized_info").getString(r2);     // Catch: Exception -> L7
    L9:
        return r0;
    L5:
        r0 = r1.getString(r2);     // Catch: Exception -> L7
    L7:
        return "";
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void configServer() {
        if (TextUtils.isEmpty(this.mMLSDKEngineType) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.mMLSDKOutputType) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.mMLSDKServiceName) == false) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.mIntelligentURL) == true) goto L19;
        SmartService r0 = SmartServiceManager.instance().getCommonService(this.mMLSDKServiceName);
        this.mMLSDKService = r0;
        if (r0 == null) goto L18;
        Log.d("intelligent_wrapper", "service valid");
        SmartServiceConfig r1 = new SmartServiceConfig(this.mMLSDKServiceName);
        Map r2 = r1.configMap();
        r2.put("engineType", this.mMLSDKEngineType);
        r2.put("outputType", this.mMLSDKOutputType);
        r2.put("packageUrl", this.mIntelligentURL);
        this.mMLSDKService.configService(r1);
        return;
    L18:
        return;
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public int getIntelligentInput(JSONObject r10, SmartInputData r11) {
        SmartInputData r12 = (SmartInputData) ZeusTransformUtils.wrapperContextForParams(r11, SmartInputData.class, "com.obric.memorydata.plugin");
        Log.d("intelligent_speedtest", "speed test input info is " + r10);
        Map r13 = r12.inputMap();
        if (r10.getJSONObject("optimized_info") == null) goto L26;
        if (r10.getInt("origin_speed_test") <= 0) goto L26;
        Log.d("intelligent_speedtest", "input is valid");
        r13.put("origin_speed_test", Float.valueOf(parseIntelligentInputFloat(r10, "origin_speed_test", 0)));
        r13.put("init_rtt", Double.valueOf(((double) parseIntelligentInputFloat(r10, "init_rtt", 1)) / 1000.0d));
        r13.put("close_rtt", Double.valueOf(((double) parseIntelligentInputFloat(r10, "close_rtt", 1)) / 1000.0d));
        r13.put("mss", Float.valueOf(parseIntelligentInputFloat(r10, "mss", 1)));
        r13.put("inner_time", Double.valueOf(((double) parseIntelligentInputFloat(r10, "inner", 1)) / 1000.0d));
        r13.put("origin_time", Double.valueOf(((double) parseIntelligentInputFloat(r10, "origin", 1)) / 1000.0d));
        String r0 = parseIntelligentInputString(r10, "apply_start", 0);
        String r4 = parseIntelligentInputString(r10, "apply_end", 0);
        if (r4.isEmpty() == true) goto L26;
        if (r0.isEmpty() == true) goto L26;
        float r1 = Long.valueOf(r4).longValue() - Long.valueOf(r0).longValue();
        if (r1 >= 0.0f) goto L16;
        return -1;
    L16:
        Log.d("intelligent_speedtest", "apply duration is valid");
        r13.put("apply_duration", Float.valueOf(r1));
        String r9 = parseIntelligentInputString(r10, "node_type", 0);
        r9.hashCode();
        if (r9.equals("Origin") == false) goto L19;
        float r14 = 2.0f;
    L22:
        Float r15 = Float.valueOf(r14);
    L23:
        r13.put("node_type", r15);
        return 0;
    L19:
        if (r9.equals("Edge") == true) goto L21;
        r15 = Float.valueOf(0.0f);
        goto L23
    L21:
        r14 = 1.0f;
    L26:
        return -1;
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void preloadEnv() {
        SmartService r0 = this.mMLSDKService;
        if (r0 == null) goto L6;
        r0.preloadEnv();
        return;
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void runAsync(Map r2, SmartServiceListener r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        SmartServiceListener r4 = (SmartServiceListener) ZeusTransformUtils.wrapperContextForParams(r3, SmartServiceListener.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public float runAsyncJsonObject(JSONObject r1, SmartServiceListener r2) {
        SmartServiceListener r0 = (SmartServiceListener) ZeusTransformUtils.wrapperContextForParams(r2, SmartServiceListener.class, "com.obric.memorydata.plugin");
        return 0.0f;
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public float runSync(Map r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Log.d("intelligent_wrapper", "syncMap" + r7);
        SmartInputData r0 = new SmartInputData();
        Map r1 = r0.inputMap();
        Iterator r2 = r7.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Object r3 = r2.next();
        r1.put(r3, r7.get(r3));
        goto L4
    L6:
        SmartService r8 = this.mMLSDKService;
        if (r8 != null) goto L9;
    L17:
        return -1.0f;
    L9:
        if (r8.enable() == false) goto L17;
        SmartOutputData r5 = this.mMLSDKService.runSync(r0);
        if (r5 == null) goto L17;
        if (r5.success() == false) goto L17;
        if (r5.getValue() == null) goto L17;
        return r5.getValue().floatValue();
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public float runSyncJsonObject(JSONObject r1) {
        return 0.0f;
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public boolean serviceEnabled() {
        SmartService r0 = this.mMLSDKService;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.enable() == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void setIntValue(int r1, int r2) {
    }

    @Override // com.ss.bduploader.smartserver.SmartServiceInterface
    public void setStringValue(int r1, String r2) {
        switch(r1) {
            case 1000: goto L7;
            case 1001: goto L6;
            case 1002: goto L5;
            case 1003: goto L4;
            default: goto L12;
        };
    L4:
        this.mIntelligentURL = r2;
        return;
    L5:
        this.mMLSDKOutputType = r2;
        return;
    L6:
        this.mMLSDKServiceName = r2;
        return;
    L7:
        this.mMLSDKEngineType = r2;
        return;
    }
}
