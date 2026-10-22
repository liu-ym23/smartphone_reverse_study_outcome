package com.bytedance.rpc.serialize.wire;

import com.bytedance.rpc.internal.RpcUtils;
import com.bytedance.rpc.serialize.AbstractDeserializer;
import com.bytedance.rpc.transport.TransportInput;
import com.bytedance.rpc.wire.WireAdapter;
import com.squareup.wire.ProtoAdapter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class WirePbDeserializer extends AbstractDeserializer {
    public WirePbDeserializer(TransportInput r3, Type r4) {
        super((TransportInput) ZeusTransformUtils.wrapperContextForParams(r3, TransportInput.class, "com.obric.memorydata.plugin"), (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.rpc.serialize.AbstractDeserializer
    public Object parser(TransportInput r2, Type r3) {
        TransportInput r1 = (TransportInput) ZeusTransformUtils.wrapperContextForParams(r2, TransportInput.class, "com.obric.memorydata.plugin");
        ProtoAdapter r4 = WireAdapter.getAdapter((Class) ZeusTransformUtils.preCheckCast((Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.memorydata.plugin"), Class.class, "com.obric.memorydata.plugin"));
        InputStream r5 = r1.in();
        Object r6 = r4.decode(r5);     // Catch: Throwable -> L6 IOException -> L8
        RpcUtils.closeSilently(r5);
        return r6;
    L6:
        th = move-exception;
        RpcUtils.closeSilently(r5);
        throw th;
    L8:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L6
    }
}
