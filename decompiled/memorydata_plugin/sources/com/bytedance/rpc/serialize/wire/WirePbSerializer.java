package com.bytedance.rpc.serialize.wire;

import com.bytedance.rpc.serialize.AbstractSerializer;
import com.bytedance.rpc.serialize.SerializeType;
import com.bytedance.rpc.wire.WireAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class WirePbSerializer extends AbstractSerializer {
    public WirePbSerializer(Object r1, SerializeType r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.rpc.serialize.AbstractSerializer
    public byte[] packet(Object r1, String r2) {
        byte[] r0 = WireAdapter.getAdapter(r1.getClass()).encode(r1);     // Catch: Throwable -> L6
        WireAdapter.getEncodeSizeMap().clear();
        return r0;
    L6:
        th = move-exception;
        WireAdapter.getEncodeSizeMap().clear();
        throw th;
    }
}
