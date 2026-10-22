package com.ss.bduploader.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public abstract class BDVNetClient {
    public static final int METHOD_GET = 0;
    public static final int METHOD_POST = 1;

    public interface CompletionListener {
        void onCompletion(JSONObject r1, Error r2);
    }

    public BDVNetClient() {
    }

    public void cancel() {
    }

    public void startTask(String r1, CompletionListener r2) {
        CompletionListener r0 = (CompletionListener) ZeusTransformUtils.wrapperContextForParams(r2, CompletionListener.class, "com.obric.memorydata.plugin");
    }

    public void startTask(String r1, Map<String, String> r2, CompletionListener r3) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        CompletionListener r4 = (CompletionListener) ZeusTransformUtils.wrapperContextForParams(r3, CompletionListener.class, "com.obric.memorydata.plugin");
    }

    public void startTask(String r1, Map<String, String> r2, JSONObject r3, int r4, CompletionListener r5) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        CompletionListener r6 = (CompletionListener) ZeusTransformUtils.wrapperContextForParams(r5, CompletionListener.class, "com.obric.memorydata.plugin");
    }
}
