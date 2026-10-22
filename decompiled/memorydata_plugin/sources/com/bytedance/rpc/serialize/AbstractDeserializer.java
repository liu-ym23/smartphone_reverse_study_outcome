package com.bytedance.rpc.serialize;

import com.bytedance.rpc.transport.TransportInput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractDeserializer implements Deserializer {
    protected TransportInput mInput;
    protected Type mType;

    public AbstractDeserializer(TransportInput r3, Type r4) {
        TransportInput r5 = (TransportInput) ZeusTransformUtils.wrapperContextForParams(r3, TransportInput.class, "com.obric.memorydata.plugin");
        this.mType = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.memorydata.plugin");
        this.mInput = r5;
    }

    @Override // com.bytedance.rpc.serialize.Deserializer
    public final Object parser() {
        return parser(this.mInput, this.mType);
    }

    public abstract Object parser(TransportInput r1, Type r2);
}
