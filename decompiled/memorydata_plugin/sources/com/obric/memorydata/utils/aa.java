package com.obric.memorydata.utils;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0003*\u0004\u0018\u00010\u0003\u001a\f\u0010\u0002\u001a\u00020\u0004*\u0004\u0018\u00010\u0004\u001a\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"TAG", "", "deepCopyBestEffort", "Lorg/json/JSONObject;", "Lorg/json/JSONArray;", "deepCopyJsonValueBestEffort", "", EventBody.KEY_VALUE, "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class aa {
    private static final Object a(Object r2) {
        if (r2 == null) goto L14;
        if (r2 == JSONObject.NULL) goto L14;
        if (ZeusTransformUtils.instanceOf(r2, JSONObject.class) == false) goto L10;
        return a((JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.memorydata.plugin"));
    L10:
        if (ZeusTransformUtils.instanceOf(r2, JSONArray.class) == true) goto L12;
        return r2;
    L12:
        return a((JSONArray) ZeusTransformUtils.preCheckCast(r2, JSONArray.class, "com.obric.memorydata.plugin"));
    L14:
        return JSONObject.NULL;
    }

    public static final JSONArray a(JSONArray r4) {
        if (r4 == null) goto L4;
        JSONArray r0 = new JSONArray();
        int r1 = r4.length();     // Catch: Exception -> L10
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        r0.put(a(r4.opt(r2)));     // Catch: Exception -> L10
        r2 = r2 + 1;
    L12:
        return r0;
    L10:
        e = move-exception;
        RunLog.INSTANCE.warn("JsonDeepCopy", "JSONArray deep copy failed, return partial copy", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L12
    L4:
        return new JSONArray();
    }

    public static final JSONObject a(JSONObject r5) {
        if (r5 == null) goto L5;
        JSONObject r1 = new JSONObject();
        Iterator<String> r2 = r5.keys();     // Catch: Exception -> L12
    L9:
        if (r2.hasNext() == false) goto L14;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        r1.put(r3, a(r5.opt(r3)));     // Catch: Exception -> L12
    L14:
        return r1;
    L12:
        e = move-exception;
        RunLog.INSTANCE.warn("JsonDeepCopy", "JSONObject deep copy failed, return partial copy", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L14
    L5:
        return new JSONObject();
    }
}
