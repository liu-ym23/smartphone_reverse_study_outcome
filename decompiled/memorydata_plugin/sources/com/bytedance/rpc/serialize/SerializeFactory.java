package com.bytedance.rpc.serialize;

import com.bytedance.rpc.transport.TransportInput;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public interface SerializeFactory {
    Deserializer getDeserializer(TransportInput r1, Type r2);

    SerializeType getSerializeType();

    Serializer getSerializer(Object r1, SerializeType r2);

    boolean isReflectSupported();
}
