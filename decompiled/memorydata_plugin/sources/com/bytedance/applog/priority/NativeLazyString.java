package com.bytedance.applog.priority;

import com.bytedance.applog.priority.original.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NativeLazyString {
    private final u<JSONObject> loader;

    public NativeLazyString(u<JSONObject> r3) {
        this.loader = (u) ZeusTransformUtils.wrapperContextForParams(r3, u.class, "com.obric.memorydata.plugin");
    }

    public String getValue() {
        return ((JSONObject) ZeusTransformUtils.preCheckCast(this.loader.load(), JSONObject.class, "com.obric.memorydata.plugin")).toString();
    }
}
