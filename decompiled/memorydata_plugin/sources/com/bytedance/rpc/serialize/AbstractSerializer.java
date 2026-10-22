package com.bytedance.rpc.serialize;

import com.bytedance.rpc.RpcDataBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractSerializer implements Serializer {
    protected Object mParams;
    protected SerializeType mType;

    public AbstractSerializer(Object r1, SerializeType r2) {
        this.mParams = r1;
        this.mType = r2;
    }

    public static RpcDataBuilder.SerializerData getSerializerData(Object r2) {
        Object r3 = unpackParams(r2, true);
        if (ZeusTransformUtils.instanceOf(r3, RpcDataBuilder.class) == false) goto L7;
        return ((RpcDataBuilder) ZeusTransformUtils.preCheckCast(r3, RpcDataBuilder.class, "com.obric.memorydata.plugin")).build();
    L7:
        if (ZeusTransformUtils.instanceOf(r3, RpcDataBuilder.SerializerData.class) == true) goto L9;
        return null;
    L9:
        return (RpcDataBuilder.SerializerData) ZeusTransformUtils.preCheckCast(r3, RpcDataBuilder.SerializerData.class, "com.obric.memorydata.plugin");
    }

    public static Object unpackParams(Object r3, boolean r4) {
        if (r3 != null) goto L4;
        return r3;
    L4:
        if ((r3 instanceof Object[]) == false) goto L15;
        Object[] r0 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");
        if (r0.length != 0) goto L9;
        return null;
    L9:
        if (r4 == true) goto L13;
        if (r0.length == 1) goto L13;
        return r3;
    L13:
        return r0[0];
    L15:
        return r3;
    }

    public String getContentType() {
        return this.mType.getContentType();
    }

    @Override // com.bytedance.rpc.serialize.Serializer
    public final ByteType packet() {
        String r0 = getContentType();
        Object r1 = unpackParams(this.mParams, false);
        if (r1 != null) goto L5;
        byte[] r3 = null;
    L7:
        return new ByteType(r3, r0);
    L5:
        r3 = packet(r1, r0);
        goto L7
    }

    public abstract byte[] packet(Object r1, String r2);
}
