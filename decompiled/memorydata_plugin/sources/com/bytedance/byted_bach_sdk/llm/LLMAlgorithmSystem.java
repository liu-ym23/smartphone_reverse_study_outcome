package com.bytedance.byted_bach_sdk.llm;

import android.graphics.Bitmap;
import com.bytedance.byted_bach_sdk.BachAlgorithmSystem;
import com.bytedance.byted_bach_sdk.buffer.BachAlgorithmOutput;
import com.bytedance.byted_bach_sdk.buffer.BachObject;
import com.bytedance.byted_bach_sdk.buffer.BachTensorResult;
import com.bytedance.byted_bach_sdk.input.BachBitmapInput;
import com.bytedance.byted_bach_sdk.input.BachGeneralInput;
import com.bytedance.byted_bach_sdk.input.BachMultiInput;
import com.bytedance.byted_bach_sdk.listener.BachAlgorithmMessage;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LLMAlgorithmSystem extends BachAlgorithmSystem {
    private static final String DEFAULT_LLM_RESULT_KEY = "llm_result";
    private static final String DEFAULT_NODE_NAME = "nh_script_0";
    private static final String DEFAULT_PROFILE_DATA_KEY = "profile_data";
    private static final String DEFAULT_VIT_RESULT_KEY = "vit_result";
    private String m_outputName;
    private final HashMap<String, BachAlgorithmOutput> m_results;

    public LLMAlgorithmSystem(BachAlgorithmSystem.BachInitConfig r1) {
        super(r1);
        this.m_outputName = DEFAULT_NODE_NAME;
        this.m_results = new HashMap();
    }

    private BachAlgorithmOutput getOutput(String r2) {
        if (this.m_results.containsKey(r2) == true) goto L5;
        BachAlgorithmOutput r0 = getResult(r2);
        if (r0 == null) goto L9;
        this.m_results.put(r2, r0);
    L9:
        return r0;
    L5:
        return (BachAlgorithmOutput) ZeusTransformUtils.preCheckCast(this.m_results.get(r2), BachAlgorithmOutput.class, "com.obric.memorydata.plugin");
    }

    private static native void nativeSetLLMEngineFactory(LLMEngineFactory r0);

    public static void setLLMEngineFactory(LLMEngineFactory r0) {
        nativeSetLLMEngineFactory(r0);
    }

    public void enableProfiling(boolean r3) {
        setIntParam(this.m_outputName, "open_profiling", r3 ? 1 : 0);
    }

    public BachAlgorithmSystem.BachErrorCode execute(Bitmap r4, String r5) {
        if (r4 == null) goto L4;
        this.m_results.clear();
        if (r5 == null) goto L12;
        if (r5.isEmpty() == true) goto L12;
        setStringParam(this.m_outputName, Params.PROMPT, r5);
        BachMultiInput r0 = new BachMultiInput();
        r0.addBachInput(BachMultiInput.SRC_DATA_SLOT, new BachBitmapInput(r4));
        BachGeneralInput r6 = new BachGeneralInput();
        r6.addInput(Params.PROMPT, r5);
        r0.addBachInput(BachMultiInput.SRC_ARRAY_SLOT, r6);
        return execute(r0);
    L12:
        return execute(new BachBitmapInput(r4));
    L4:
        return execute(r5);
    }

    public BachAlgorithmSystem.BachErrorCode execute(String r3) {
        if (r3 != null) goto L4;
    L8:
        System.err.println("invalid prompt param");
        return BachAlgorithmSystem.BachErrorCode.INTERNAL_ERROR;
    L4:
        if (r3.isEmpty() == true) goto L8;
        this.m_results.clear();
        setStringParam(this.m_outputName, Params.PROMPT, r3);
        BachGeneralInput r0 = new BachGeneralInput();
        r0.addInput(Params.PROMPT, r3);
        return execute(r0);
    }

    public String getLLMResult() {
        return getLLMResult(this.m_outputName);
    }

    public String getLLMResult(String r2) {
        BachAlgorithmOutput r1 = getOutput(r2);
        if (r1 != null) goto L5;
        return "";
    L5:
        if (r1.m_dataMap.length <= 0) goto L14;
        HashMap<String, BachObject> r3 = r1.m_dataMap[0];
        if (r3 != null) goto L9;
        return "";
    L9:
        if (r3.containsKey(DEFAULT_LLM_RESULT_KEY) == true) goto L11;
        return "";
    L11:
        return ((BachObject) ZeusTransformUtils.preCheckCast(r3.get(DEFAULT_LLM_RESULT_KEY), BachObject.class, "com.obric.memorydata.plugin")).valueResult.stringVal;
    L14:
        return "";
    }

    public String getProfileData() {
        return getProfileData(this.m_outputName);
    }

    public String getProfileData(String r2) {
        BachAlgorithmOutput r1 = getOutput(r2);
        if (r1 != null) goto L5;
        return "";
    L5:
        if (r1.m_dataMap.length <= 0) goto L14;
        HashMap<String, BachObject> r3 = r1.m_dataMap[0];
        if (r3 != null) goto L9;
        return "";
    L9:
        if (r3.containsKey(DEFAULT_PROFILE_DATA_KEY) == true) goto L11;
        return "";
    L11:
        return ((BachObject) ZeusTransformUtils.preCheckCast(r3.get(DEFAULT_PROFILE_DATA_KEY), BachObject.class, "com.obric.memorydata.plugin")).valueResult.stringVal;
    L14:
        return "";
    }

    public BachTensorResult getVITResult() {
        return getVITResult(this.m_outputName);
    }

    public BachTensorResult getVITResult(String r2) {
        BachAlgorithmOutput r1 = getOutput(r2);
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.m_dataMap.length <= 0) goto L14;
        HashMap<String, BachObject> r3 = r1.m_dataMap[0];
        if (r3 != null) goto L9;
        return null;
    L9:
        if (r3.containsKey(DEFAULT_VIT_RESULT_KEY) == true) goto L11;
        return null;
    L11:
        return ((BachObject) ZeusTransformUtils.preCheckCast(r3.get(DEFAULT_VIT_RESULT_KEY), BachObject.class, "com.obric.memorydata.plugin")).tensorResult;
    L14:
        return null;
    }

    @Override // com.bytedance.byted_bach_sdk.BachAlgorithmSystem
    public void parseExtraInfo(String r5) {
        if (r5.endsWith(".json") == false) goto L43;
        File r0 = new File(r5);
        if (r0.exists() == true) goto L7;
    L22:
        System.err.printf("invalid json path %s", new Object[]{r5});
        return;
    L7:
        if (r0.isFile() == false) goto L22;
        FileInputStream r6 = new FileInputStream(r0);     // Catch: IOException -> L19
        byte[] r1 = new byte[(int) r0.length()];     // Catch: Throwable -> L13
        r6.read(r1);     // Catch: Throwable -> L13
        String r2 = new String(r1, StandardCharsets.UTF_8);     // Catch: Throwable -> L13
        r6.close();     // Catch: IOException -> L19
        r5 = r2;
        goto L43
    L13:
        th = move-exception;
        r6.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: IOException -> L19
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L43:
        JSONObject r7 = new JSONObject(r5).optJSONObject(WsConstants.KEY_EXTRA);     // Catch: JSONException -> L40
        if (r7 != null) goto L27;
        return;
    L27:
        JSONArray r8 = r7.optJSONArray("output");     // Catch: JSONException -> L40
        if (r8 != null) goto L30;
        return;
    L30:
        if (r8.length() == 0) goto L50;
        JSONObject r9 = r8.optJSONObject(0);     // Catch: JSONException -> L40
        if (r9 != null) goto L35;
        return;
    L35:
        String r10 = r9.optString(ActivityLifecycle.NAME);     // Catch: JSONException -> L40
        if (r10.isEmpty() == true) goto L51;
        this.m_outputName = r10;     // Catch: JSONException -> L40
        return;
    L51:
        return;
    L50:
        return;
    L40:
        e = move-exception;
        e.printStackTrace();
    }

    public void resetLLMEngine(String r3) {
        if (r3 != null) goto L4;
    L5:
        r3 = "llm";
    L6:
        BachAlgorithmMessage r0 = new BachAlgorithmMessage(101);
        r0.addInput("subtype", r3);
        r0.addInput("action", "reset");
        sendMessage(this.m_outputName, r0);
        return;
    L4:
        if (r3.isEmpty() == false) goto L6;
        goto L5
    }

    public void setInitModelConfig(String r3, String r4) {
        setStringParam(this.m_outputName, r3 + "_initConfig", r4);
    }

    public void setRuntimeModelParams(String r3, String r4) {
        setStringParam(this.m_outputName, r3 + "_runtimeParams", r4);
    }

    public void stopLLMEngine(String r3) {
        if (r3 != null) goto L4;
    L5:
        r3 = "llm";
    L6:
        BachAlgorithmMessage r0 = new BachAlgorithmMessage(100);
        r0.addInput("subtype", r3);
        r0.addInput("action", "stop_inference");
        sendMessage(this.m_outputName, r0);
        return;
    L4:
        if (r3.isEmpty() == false) goto L6;
        goto L5
    }
}
