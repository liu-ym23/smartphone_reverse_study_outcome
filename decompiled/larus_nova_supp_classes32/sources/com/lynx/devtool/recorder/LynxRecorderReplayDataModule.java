package com.lynx.devtool.recorder;

import android.content.Context;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.PiperData;
import com.lynx.tasm.base.LLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxRecorderReplayDataModule extends LynxModule {
    private static final String TAG = "LynxRecorderReplayDataModule";
    private JSONObject mCallbackData;
    private JSONArray mFunctionCall;
    private JSONArray mJsbIgnoredInfo;
    private JSONObject mJsbSettings;
    private JSONObject mSharedData;

    private String getJsbIgnoredInfo() {
        JSONArray r0 = this.mJsbIgnoredInfo;
        if (r0 != null) goto L5;
        LLog.e("TestBench", "getJsbIgnoredInfo  error: download File failed");
        return "[]";
    L5:
        return r0.toString();
    }

    private String getJsbSettings() {
        JSONObject r0 = this.mJsbSettings;
        if (r0 != null) goto L5;
        LLog.e("TestBench", "getJsbSettings  error: download File failed");
        return "{}";
    L5:
        return r0.toString();
    }

    private String getRecordData() {
        String r1 = "Record Time";
        String r4 = "Params";
        String r5 = "RecordMillisecond";
        JSONObject r6 = new JSONObject();
        int r8 = 0;
    L46:
        if (r8 >= this.mFunctionCall.length()) goto L39;
        JSONObject r9 = JSONArrayProtectorUtils.getJSONObject(this.mFunctionCall, r8);     // Catch: JSONException -> L40
        String r10 = JSONObjectProtectorUtils.getString(r9, "Module Name");     // Catch: JSONException -> L40
        if (r6.has(r10) == true) goto L8;
        r6.put(r10, new JSONArray());     // Catch: JSONException -> L40
    L8:
        JSONObject r11 = new JSONObject();     // Catch: JSONException -> L40
        Object r12 = JSONObjectProtectorUtils.getString(r9, "Method Name");     // Catch: JSONException -> L40
        long r13 = CastLongProtector.parseLong(JSONObjectProtectorUtils.getString(r9, r1)) * 1000;     // Catch: JSONException -> L40
        if (r9.has(r5) == false) goto L11;
        r13 = JSONObjectProtectorUtils.getLong(r9, r5);     // Catch: JSONException -> L40
    L11:
        JSONObject r7 = JSONObjectProtectorUtils.getJSONObject(r9, r4);     // Catch: JSONException -> L40
        JSONArray r15 = JSONObjectProtectorUtils.getJSONArray(r7, "callback");     // Catch: JSONException -> L15
    L16:
        StringBuffer r14 = new StringBuffer();     // Catch: JSONException -> L40
        JSONObject r21 = r6;
        JSONArray r16 = new JSONArray();     // Catch: JSONException -> L40
        if (r15 == null) goto L32;
        int r17 = 0;
    L20:
        if (r17 >= r15.length()) goto L31;
        JSONObject r0 = JSONObjectProtectorUtils.getJSONObject(this.mCallbackData, JSONArrayProtectorUtils.getString(r15, r17));     // Catch: JSONException -> L23
    L24:
        if (r0 == null) goto L30;
        long r24 = CastLongProtector.parseLong(JSONObjectProtectorUtils.getString(r0, r1)) * 1000;     // Catch: JSONException -> L40
        if (r9.has(r5) == false) goto L28;
        r24 = JSONObjectProtectorUtils.getLong(r0, r5);     // Catch: JSONException -> L40
    L28:
        JSONObject r18 = new JSONObject();     // Catch: JSONException -> L40
        r18.put("Value", JSONObjectProtectorUtils.getJSONObject(r0, r4));     // Catch: JSONException -> L40
        r18.put("Delay", r24 - r13);     // Catch: JSONException -> L40
        r16.put(r17, r18);     // Catch: JSONException -> L40
    L30:
        r14.append(JSONArrayProtectorUtils.getString(r15, r17));     // Catch: JSONException -> L40
        r14.append("_");     // Catch: JSONException -> L40
        r17 = r17 + 1;     // Catch: JSONException -> L40
        LynxRecorderReplayDataModule this = this;
        r4 = r4;
        r1 = r1;
        r5 = r5;
    L23:
        r0 = null;
        goto L24
    L31:
        String r26 = r1;
        String r2 = r4;
        String r27 = r5;
    L34:
        if (r9.has("SyncAttributes") == false) goto L36;
        r11.put("SyncAttributes", JSONObjectProtectorUtils.getJSONObject(r9, "SyncAttributes"));     // Catch: JSONException -> L40
    L36:
        r11.put("Method Name", r12);     // Catch: JSONException -> L40
        r11.put(r2, r7);     // Catch: JSONException -> L40
        r11.put("Callback", r16);     // Catch: JSONException -> L40
        r11.put("Label", r14.toString());     // Catch: JSONException -> L40
        JSONObjectProtectorUtils.getJSONArray(r21, r10).put(r11);     // Catch: JSONException -> L40
        r8 = r8 + 1;
        r6 = r21;
        r4 = r2;
        r1 = r26;
        r5 = r27;
        goto L46
    L32:
        r26 = r1;
        r2 = r4;
        r27 = r5;
    L15:
        r15 = null;
        goto L16
    L39:
        return r6.toString();
    L40:
        LLog.e("TestBench", "Record file format error!");
        return "{}";
    }

    public LynxRecorderReplayDataModule(Context r1) {
        super(r1);
    }

    @LynxMethod
    public void getData(Callback r6) {
        JSONObject r0 = new JSONObject();
        r0.put("RecordData", getRecordData());     // Catch: JSONException -> L5
        r0.put("JsbIgnoredInfo", getJsbIgnoredInfo());     // Catch: JSONException -> L5
        r0.put("JsbSettings", getJsbSettings());     // Catch: JSONException -> L5
    L6:
        r6.invoke(new Object[]{r0.toString()});
        return;
    L5:
        LLog.e("TestBench", "Record file format error!");
        r6.invoke(new Object[]{"{}"});
        goto L6
    }

    @LynxMethod
    public PiperData getSharedData(String r4) {
        HashMap r0 = new HashMap();
        JSONObject r1 = this.mSharedData;     // Catch: JSONException -> L7
        if (r1 == null) goto L8;
        Object r5 = r1.get(r4);     // Catch: JSONException -> L7
    L9:
        r0.put("value", r5);
        return new PiperData(r0, false);
    L8:
        r5 = null;
    L7:
        LLog.e("LynxRecorder", "SharedData with key: " + r4 + " not found!");
        goto L8
    }

    public LynxRecorderReplayDataModule(Context r1, Object r2) {
        super(r1);
        LynxRecorderReplayDataProvider r3 = (LynxRecorderReplayDataProvider) r2;
        this.mFunctionCall = r3.getFunctionCall();
        this.mCallbackData = r3.getCallbackData();
        this.mJsbIgnoredInfo = r3.getJsbIgnoredInfo();
        this.mJsbSettings = r3.getJsbSettings();
        this.mSharedData = r3.getSharedData();
    }
}
