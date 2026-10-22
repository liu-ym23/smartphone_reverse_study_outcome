package com.bytedance.apm6.java_alloc.model;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.log.Logger;
import com.obric.aikernel.request.track.ApiPerfDetails;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public ReportInfo(String r3, int r4, int r5, int r6, String r7, List<StackTraceElement> r8) {
        List<StackTraceElement> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        this.className = r3;
        this.count = r4;
        this.bytes = r5;
        this.exceptionType = r6;
        this.scene = r7;
        this.tracebacks = r9;
    }

    private static String combineStacks(List<StackTraceElement> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder();
        int r1 = r10.size();
        int r2 = r1 / 2;
        if (r1 <= 128) goto L5;
        int r4 = (r1 - 128) / 2;
        int r5 = r2 - r4;
        int r6 = r2 + (r1 - r4);
        r2 = r5;
    L7:
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.i(TAG, "traceSize: " + r1);
    L9:
        int r7 = 0;
    L11:
        if (r7 >= r2) goto L13;
        r0.append("at ").append(r10.get(r7)).append("\n");
        r7 = r7 + 1;
        goto L11
    L13:
        if (r1 <= 128) goto L15;
        r0.append("... skip ").append(r1 - 128).append(" lines\n");
    L15:
        if (r6 >= r1) goto L18;
        r0.append("at ").append(r10.get(r6)).append("\n");
        r6 = r6 + 1;
        goto L15
    L18:
        return r0.toString();
    L5:
        r6 = r2;
        goto L7
    }

    public JSONObject packJson(JSONObject r6) {
        JSONObject r0 = new JSONObject();
        r0.put("object_class", this.className);     // Catch: JSONException -> L8
        r0.put(CommonConsts.COUNT_TYPE, this.count);     // Catch: JSONException -> L8
        r0.put("size", this.bytes);     // Catch: JSONException -> L8
        r0.put(ApiPerfDetails.exceptionType, this.exceptionType);     // Catch: JSONException -> L8
        String r1 = combineStacks(this.tracebacks);     // Catch: JSONException -> L8
        r0.put("stack", r1);     // Catch: JSONException -> L8
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.i(TAG, "stacks: " + r1);     // Catch: JSONException -> L8
    L6:
        r6.put("alloc_scene", this.scene);     // Catch: JSONException -> L8
        r0.put("filters", r6);     // Catch: JSONException -> L8
        return r0;
    L8:
        return null;
    }
}
