package com.bytedance.rpc.serialize;

import com.bytedance.rpc.serialize.wire.WirePbDeserializer;
import com.bytedance.rpc.serialize.wire.WirePbSerializer;
import com.bytedance.rpc.transport.TransportInput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class WireSerializeFactory implements SerializeFactory {
    public WireSerializeFactory() {
    }

    @Override // com.bytedance.rpc.serialize.SerializeFactory
    public Deserializer getDeserializer(TransportInput r2, Type r3) {
        return new WirePbDeserializer((TransportInput) ZeusTransformUtils.wrapperContextForParams(r2, TransportInput.class, "com.obric.memorydata.plugin"), (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.rpc.serialize.SerializeFactory
    public SerializeType getSerializeType() {
        return SerializeType.PB;
    }

    @Override // com.bytedance.rpc.serialize.SerializeFactory
    public Serializer getSerializer(Object r1, SerializeType r2) {
        return new WirePbSerializer(r1, r2);
    }

    @Override // com.bytedance.rpc.serialize.SerializeFactory
    public boolean isReflectSupported() {
        return true;
    }
}
