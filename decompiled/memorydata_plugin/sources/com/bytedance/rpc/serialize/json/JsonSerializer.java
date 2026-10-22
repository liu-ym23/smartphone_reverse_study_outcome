package com.bytedance.rpc.serialize.json;

import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.rpc.serialize.AbstractSerializer;
import com.bytedance.rpc.serialize.SerializeManager;
import com.bytedance.rpc.serialize.SerializeType;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class JsonSerializer extends AbstractSerializer {
    private Gson mJson;

    public JsonSerializer(Gson r1, Object r2, SerializeType r3) {
        super(r2, r3);
        this.mJson = r1;
    }

    @Override // com.bytedance.rpc.serialize.AbstractSerializer
    public byte[] packet(Object r3, String r4) {
        boolean r0 = RpcUtils.isVisible(r4);
        String r1 = RpcUtils.CHARSET_UTF8;
        if (r0 == false) goto L6;
        r1 = SerializeManager.parseCharset(r4, RpcUtils.CHARSET_UTF8);
    L6:
        if (ZeusTransformUtils.instanceOf(r3, JSONObject.class) == false) goto L8;
    L13:
        String r2 = r3.toString();
    L12:
        return r2.getBytes(r1);
    L8:
        if (ZeusTransformUtils.instanceOf(r3, JsonElement.class) == true) goto L13;
        r2 = this.mJson.toJson(r3);
        goto L12
    }
}
