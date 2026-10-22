package com.bytedance.apm6.java_alloc.model;

import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.log.Logger;
import com.obric.aikernel.request.track.ApiPerfDetails;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ReportInfo {
    private static final int MAX_TRACE_SIZE = 128;
    private static final String TAG = "APM-Alloc-ReportInfo";
    public int bytes;
    public String className;
    public int count;
    public int exceptionType;
    private String scene;
    public List<StackTraceElement> tracebacks;

    public ReportInfo(String r10, int r11, int r12, int r13, String r14, List<StackTraceElement> r15) {
        this.className = r10;
        this.count = r11;
        this.bytes = r12;
        this.exceptionType = r13;
        this.scene = r14;
        this.tracebacks = r15;
    }

    private static String combineStacks(List<StackTraceElement> r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.size();
        int r13 = r12 / 2;
        if (r12 <= 128) goto L5;
        int r14 = (r12 - 128) / 2;
        int r15 = r13 - r14;
        int r16 = r13 + (r12 - r14);
        r13 = r15;
    L7:
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Logger.i(TAG, "traceSize: " + r12);
    L9:
        int r17 = 0;
    L11:
        if (r17 >= r13) goto L13;
        r11.append("at ");
        r11.append(r10.get(r17));
        r11.append("\n");
        r17 = r17 + 1;
        goto L11
    L13:
        if (r12 <= 128) goto L15;
        r11.append("... skip ");
        r11.append(r12 - 128);
        r11.append(" lines\n");
    L15:
        if (r16 >= r12) goto L18;
        r11.append("at ");
        r11.append(r10.get(r16));
        r11.append("\n");
        r16 = r16 + 1;
        goto L15
    L18:
        return r11.toString();
    L5:
        r16 = r13;
        goto L7
    }

    public JSONObject packJson(JSONObject r10) {
        JSONObject r11 = new JSONObject();
        r11.put("object_class", this.className);     // Catch: JSONException -> L8
        r11.put(CommonConsts.COUNT_TYPE, this.count);     // Catch: JSONException -> L8
        r11.put("size", this.bytes);     // Catch: JSONException -> L8
        r11.put(ApiPerfDetails.exceptionType, this.exceptionType);     // Catch: JSONException -> L8
        String r12 = combineStacks(this.tracebacks);     // Catch: JSONException -> L8
        r11.put("stack", r12);     // Catch: JSONException -> L8
        if (ApmBaseContext.isDebugMode() == false) goto L6;
        Logger.i(TAG, "stacks: " + r12);     // Catch: JSONException -> L8
    L6:
        r10.put("alloc_scene", this.scene);     // Catch: JSONException -> L8
        r11.put("filters", r10);     // Catch: JSONException -> L8
        return r11;
    L8:
        return null;
    }
}
