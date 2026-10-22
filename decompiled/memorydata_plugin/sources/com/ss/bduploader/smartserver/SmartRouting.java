package com.ss.bduploader.smartserver;

import android.util.Log;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SmartRouting extends SmartAbstract {
    private static final String ENGINE_TYPE = "mlsdk";
    private static final String OUTPUT_TYPE = "regression";
    private static final String SERVER_NAME = "smart_upload_tcp_quic";
    private SmartServiceInterface mIntelligentService;
    private String mIntelligentURL;

    public SmartRouting() {
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

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void configServer() {
        Log.d("intelligent_routing", "config_server engine_type: mlsdk outputType: regression service name: smart_upload_tcp_quic engineType: mlsdk model_url: " + this.mIntelligentURL);
        this.mIntelligentService.setStringValue(1000, ENGINE_TYPE);
        this.mIntelligentService.setStringValue(1001, SERVER_NAME);
        this.mIntelligentService.setStringValue(1002, OUTPUT_TYPE);
        this.mIntelligentService.setStringValue(1003, this.mIntelligentURL);
        this.mIntelligentService.configServer();
    }

    public Map getIntelligentInput(JSONObject r11) {
        Log.d("intelligent_routing", "speed test input info is " + r11);
        HashMap r2 = new HashMap();
        if (r11.getInt("est_file_size") <= 0) goto L12;
        if (r11.getJSONObject("optimized_info") == null) goto L12;
        if (r11.getInt("origin_speed_test") <= 0) goto L12;
        Log.d("intelligent_routing", "input is valid");
        r2.put("origin_speed_test", Float.valueOf(parseIntelligentInputFloat(r11, "origin_speed_test", 0)));
        r2.put("speed_test_protocol", Float.valueOf(parseIntelligentInputFloat(r11, "speed_test_protocol", 0)));
        r2.put("init_rtt", Double.valueOf(((double) parseIntelligentInputFloat(r11, "init_rtt", 1)) / 1000.0d));
        r2.put("close_rtt", Double.valueOf(((double) parseIntelligentInputFloat(r11, "close_rtt", 1)) / 1000.0d));
        r2.put("mss", Float.valueOf(parseIntelligentInputFloat(r11, "mss", 1)));
        r2.put("inner_time", Double.valueOf(((double) parseIntelligentInputFloat(r11, "inner", 1)) / 1000.0d));
        r2.put("origin_time", Double.valueOf(((double) parseIntelligentInputFloat(r11, "origin", 1)) / 1000.0d));
        Log.d("intelligent_routing", "grab file_size info");
        r2.put("est_file_size", Float.valueOf(parseIntelligentInputFloat(r11, "est_file_size", 0)));
        return r2;
    L12:
        return null;
    }

    public Map getIntelligentInputTTNet(JSONObject r20) {
        Log.d("intelligent_routing", "routing ttnet input info is " + r20);
        HashMap r4 = new HashMap();
    L38:
        e = move-exception;
        Log.e(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, String.valueOf(e));
        return null;
    L4:
        if (r20.getInt("est_file_size") > 0) goto L6;
        return null;
    L6:
        if (r20.getJSONObject("tcp_domain") != null) goto L8;
        return null;
    L8:
        if (r20.getJSONObject("quic_domain") == null) goto L48;
        List r6 = Arrays.asList(new String[]{"tcp", "quic"});     // Catch: Exception -> L38
        List r7 = Arrays.asList(new String[]{"SeverSpeed", "speed", "duration", "routing_request_log.timing.detailed_duration.inner", "routing_request_log.timing.detailed_duration.send", "routing_request_log.timing.detailed_duration.ttfb", "routing_request_log.timing.request.duration"});     // Catch: Exception -> L38
        List r8 = Arrays.asList(new String[]{"routing_request_log.nqe.http_rtt", "routing_request_log.nqe.tcp_rtt", "routing_request_log.nqe.downlink_throughput", "routing_request_log.nqe.real_net_type", "routing_request_log.nqe.effective_net_type"});     // Catch: Exception -> L38
        int r10 = 0;
    L13:
        if (r10 >= r6.size()) goto L26;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r6.get(r10), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L38
        JSONObject r14 = r20.getJSONObject(r11 + "_domain");     // Catch: Exception -> L38
        Iterator r15 = r7.iterator();     // Catch: Exception -> L38
    L16:
        if (r15.hasNext() == false) goto L25;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L38
        String[] r9 = r5.split("\\.");     // Catch: Exception -> L38
        List r17 = r6;
        List r18 = r7;
        String r12 = r11 + "_" + r9[r9.length - 1].toLowerCase(Locale.US);     // Catch: Exception -> L38
        if (r5.equals("duration") == false) goto L20;
        r12 = r12 + "_bd";     // Catch: Exception -> L38
    L20:
        float r13 = getValueForKey(r14, r5);     // Catch: Exception -> L38
        if (r13 == (-1.0f)) goto L22;
        r4.put(r12, Float.valueOf(r13));     // Catch: Exception -> L38
        r6 = r17;
        r7 = r18;
        goto L16
    L22:
        return null;
    L25:
        r10 = r10 + 1;     // Catch: Exception -> L38
        goto L13
    L26:
        Iterator r16 = r8.iterator();     // Catch: Exception -> L38
    L28:
        if (r16.hasNext() == false) goto L30;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L38
        String[] r21 = r19.split("\\.");     // Catch: Exception -> L38
        r4.put(r21[r21.length - 1].toLowerCase(Locale.US), Float.valueOf(getValueForKey(r20.getJSONObject("tcp_domain"), r19)));     // Catch: Exception -> L38
        goto L28
    L30:
        float r0 = parseIntelligentInputFloat(r20, "est_file_size", 0);     // Catch: Exception -> L38
        if (r0 > 0.0f) goto L34;
        return null;
    L34:
        r4.put("est_file_size", Float.valueOf(r0));     // Catch: Exception -> L38
        return r4;
    L48:
        return null;
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void init() {
        this.mIntelligentService = new SmartServiceWrapper();
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void parseUrl(String r5) {
        JSONObject r0 = new JSONObject(r5);     // Catch: Exception -> L4
        Log.d("intelligent_routing", "parse url" + r5);     // Catch: Exception -> L4
        this.mIntelligentURL = r0.getString("intelligent_model_url");     // Catch: Exception -> L4
        return;
    L4:
        this.mIntelligentURL = "";
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public float predictSpeedSync(JSONObject r7) {
        Log.d("intelligent_routing", "predict float value intelligent");
        if (this.mIntelligentService.serviceEnabled() == false) goto L18;
        Log.d("intelligent_speedtest", "service is valid");
        Map r3 = new HashMap();
        if (r7.getInt("routing_using_vcn") != 1) goto L9;
        r3 = getIntelligentInput(r7);     // Catch: Exception -> L16
    L11:
        if (r3 != null) goto L15;
        Log.d("intelligent_speedtest", "input processing invalid");
        return -1.0f;
    L15:
        return this.mIntelligentService.runSync(r3);
    L9:
        if (r7.getInt("routing_using_vcn") != 0) goto L11;
        r3 = getIntelligentInputTTNet(r7);     // Catch: Exception -> L16
        goto L11
    L19:
        return -1.0f;
    L18:
        return -1.0f;
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void preloadEnv() {
        SmartServiceInterface r0 = this.mIntelligentService;
        if (r0 == null) goto L6;
        r0.preloadEnv();
        return;
    }

    @Override // com.ss.bduploader.smartserver.SmartAbstract
    public void setUrl(String r1) {
        this.mIntelligentURL = r1;
    }
}
