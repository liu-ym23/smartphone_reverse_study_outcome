package com.ss.bduploader.smartserver;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SmartSpeedTest extends SmartAbstract {
    private static final String ENGINE_TYPE = "mlsdk";
    private static final String OUTPUT_TYPE = "regression";
    private static final String SERVER_NAME = "smart_upload_speed";
    private SmartServiceInterface mIntelligentService;
    private String mIntelligentURL;
    private int mSpeedTestUseVCN;

    public SmartSpeedTest() {
        this.mSpeedTestUseVCN = -1;
        this.mIntelligentURL = "";
    }

    private float getValueForKey(JSONObject r3, String r4) {
        String[] r2 = r4.split("\\.");
        int r5 = 0;
    L15:
    L13:
        Log.e("intelligent_routing", "value of key" + r2 + "invalid" + r3);
        return -1.0f;
    L5:
        if (r5 >= (r2.length - 1)) goto L7;
        r3 = r3.getJSONObject(r2[r5]);     // Catch: Exception -> L13
        r5 = r5 + 1;     // Catch: Exception -> L13
        goto L15
    L7:
        String r6 = r2[r2.length - 1];     // Catch: Exception -> L13
        if (r3.has(r6) == true) goto L10;
        return -1.0f;
    L10:
        return (float) r3.getDouble(r6);
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

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void configServer() {
        this.mIntelligentService.setStringValue(1000, ENGINE_TYPE);
        this.mIntelligentService.setStringValue(1001, SERVER_NAME);
        this.mIntelligentService.setStringValue(1002, OUTPUT_TYPE);
        this.mIntelligentService.setStringValue(1003, this.mIntelligentURL);
        this.mIntelligentService.configServer();
    }

    public Map getIntelligentInput(JSONObject r10) {
        Log.d("intelligent_speedtest", "speed test input info is " + r10);
        HashMap r1 = new HashMap();
        if (r10.getJSONObject("optimized_info") == null) goto L26;
        if (r10.getInt("origin_speed_test") <= 0) goto L26;
        r1.put("origin_speed_test", Float.valueOf(parseIntelligentInputFloat(r10, "origin_speed_test", 0)));
        r1.put("init_rtt", Double.valueOf(((double) parseIntelligentInputFloat(r10, "init_rtt", 1)) / 1000.0d));
        r1.put("close_rtt", Double.valueOf(((double) parseIntelligentInputFloat(r10, "close_rtt", 1)) / 1000.0d));
        r1.put("mss", Float.valueOf(parseIntelligentInputFloat(r10, "mss", 1)));
        r1.put("inner_time", Double.valueOf(((double) parseIntelligentInputFloat(r10, "inner", 1)) / 1000.0d));
        r1.put("origin_time", Double.valueOf(((double) parseIntelligentInputFloat(r10, "origin", 1)) / 1000.0d));
        String r0 = parseIntelligentInputString(r10, "apply_start", 0);
        String r4 = parseIntelligentInputString(r10, "apply_end", 0);
        if (r4.isEmpty() == true) goto L26;
        if (r0.isEmpty() == true) goto L26;
        float r2 = Long.valueOf(r4).longValue() - Long.valueOf(r0).longValue();
        if (r2 >= 0.0f) goto L16;
        return null;
    L16:
        r1.put("apply_duration", Float.valueOf(r2));
        String r9 = parseIntelligentInputString(r10, "node_type", 0);
        r9.hashCode();
        if (r9.equals("Origin") == false) goto L19;
        float r11 = 2.0f;
    L22:
        Float r12 = Float.valueOf(r11);
    L23:
        r1.put("node_type", r12);
        return r1;
    L19:
        if (r9.equals("Edge") == true) goto L21;
        r12 = Float.valueOf(0.0f);
        goto L23
    L21:
        r11 = 1.0f;
    L26:
        return null;
    }

    public Map getIntelligentInputTTNet(JSONObject r15) {
        Log.d("intelligent_speed_ttnet", "info is " + r15);
        HashMap r0 = new HashMap();
        if (r15.getJSONObject("speedtest_request_log") == null) goto L26;
        if (r15.getInt("origin_speed_test") <= 0) goto L26;
        String r2 = parseIntelligentInputString(r15, "apply_start", 0);     // Catch: Exception -> L27
        String r3 = parseIntelligentInputString(r15, "apply_end", 0);     // Catch: Exception -> L27
        if (r3.isEmpty() == true) goto L26;
        if (r2.isEmpty() == true) goto L26;
        float r4 = Long.valueOf(r3).longValue() - Long.valueOf(r2).longValue();     // Catch: Exception -> L27
        if (r4 >= 0.0f) goto L16;
        return null;
    L16:
        r0.put("apply_duration", Float.valueOf(r4));     // Catch: Exception -> L27
        Iterator r5 = Arrays.asList(new String[]{"origin_speed_test", "speedtest_request_log.timing.detailed_duration.send", "speedtest_request_log.timing.detailed_duration.inner", "speedtest_request_log.timing.detailed_duration.ttfb", "speedtest_request_log.timing.request.duration", "speedtest_request_log.nqe.http_rtt", "speedtest_request_log.nqe.tcp_rtt", "speedtest_request_log.nqe.downlink_throughput", "speedtest_request_log.nqe.real_net_type", "speedtest_request_log.nqe.effective_net_type"}).iterator();     // Catch: Exception -> L27
    L18:
        if (r5.hasNext() == false) goto L24;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L27
        String[] r7 = r6.split("\\.");     // Catch: Exception -> L27
        String r8 = r7[r7.length - 1].toLowerCase(Locale.US);     // Catch: Exception -> L27
        float r9 = getValueForKey(r15, r6);     // Catch: Exception -> L27
        if (r9 == (-1.0f)) goto L21;
        r0.put(r8, Float.valueOf(r9));     // Catch: Exception -> L27
    L21:
        return null;
    L24:
        Log.d("intelligent_ttnet", "result" + r0);
        return r0;
    L26:
        return null;
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void init() {
        this.mIntelligentService = new SmartServiceWrapper();
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void parseUrl(String r2) {
        this.mIntelligentURL = new JSONObject(r2).getString("intelligent_model_url");     // Catch: Exception -> L4
        return;
    L4:
        this.mIntelligentURL = "";
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public float predictSpeedSync(JSONObject r4) {
        if (this.mIntelligentService.serviceEnabled() == true) goto L5;
        return -1.0f;
    L5:
        if (this.mSpeedTestUseVCN != 1) goto L7;
        Map r5 = getIntelligentInput(r4);
    L8:
        if (r5 != null) goto L12;
        Log.d("intelligent_speedtest", "input processing invalid");
        return -1.0f;
    L12:
        return this.mIntelligentService.runSync(r5);
    L7:
        r5 = getIntelligentInputTTNet(r4);
        goto L8
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void preloadEnv() {
        SmartServiceInterface r0 = this.mIntelligentService;
        if (r0 == null) goto L6;
        r0.preloadEnv();
        return;
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void setSpeedTestUseVCN(int r1) {
        this.mSpeedTestUseVCN = r1;
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void setUrl(String r1) {
        this.mIntelligentURL = r1;
    }
}
