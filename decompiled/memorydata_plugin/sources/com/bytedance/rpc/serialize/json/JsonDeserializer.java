package com.bytedance.rpc.serialize.json;

import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.rpc.serialize.AbstractDeserializer;
import com.bytedance.rpc.serialize.SerializeManager;
import com.bytedance.rpc.transport.TransportInput;
import com.google.gson.Gson;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class JsonDeserializer extends AbstractDeserializer {
    private Gson mJson;

    public JsonDeserializer(Gson r3, TransportInput r4, Type r5) {
        super((TransportInput) ZeusTransformUtils.wrapperContextForParams(r4, TransportInput.class, "com.obric.memorydata.plugin"), (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin"));
        this.mJson = r3;
    }

    @Override // com.bytedance.rpc.serialize.AbstractDeserializer
    public Object parser(TransportInput r4, Type r5) {
        TransportInput r6 = (TransportInput) ZeusTransformUtils.wrapperContextForParams(r4, TransportInput.class, "com.obric.memorydata.plugin");
        Type r7 = (Type) ZeusTransformUtils.wrapperContextForParams(r5, Type.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        InputStream r1 = null;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        String r0 = RpcUtils.CHARSET_UTF8;
        if (RpcUtils.isVisible(r6.contentType()) == false) goto L12;
        r0 = SerializeManager.parseCharset(r6.contentType(), RpcUtils.CHARSET_UTF8);
    L12:
        if (String.class != r7) goto L16;
        return RpcUtils.toString(r1, r0);
    L16:
        if (JSONObject.class != r7) goto L20;
        return new JSONObject(RpcUtils.toString(r1, r0));
    L20:
        return this.mJson.fromJson(RpcUtils.toString(r1, r0), r7);
    L5:
        r1 = r6.in();
        goto L6
    }
}
