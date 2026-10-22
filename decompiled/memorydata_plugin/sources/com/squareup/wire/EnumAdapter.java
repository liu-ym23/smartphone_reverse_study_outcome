package com.squareup.wire;

import com.squareup.wire.WireEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    public EnumAdapter(Class<E> r2) {
        super(FieldEncoding.VARINT, r2);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public final E decode(ProtoReader r2) {
        int r3 = r2.readVarint32();
        E r0 = (E) fromValue(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r3, this.javaType);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) {
        return decode(r1);
    }

    public final void encode(ProtoWriter r2, E r3) {
        r2.writeVarint32(((WireEnum) ZeusTransformUtils.wrapperContextForParams(r3, WireEnum.class, "com.obric.memorydata.plugin")).getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* synthetic */ void encode(ProtoWriter r3, Object r4) {
        encode(r3, (WireEnum) ZeusTransformUtils.preCheckCast(r4, WireEnum.class, "com.obric.memorydata.plugin"));
    }

    public final int encodedSize(E r2) {
        return ProtoWriter.varint32Size(((WireEnum) ZeusTransformUtils.wrapperContextForParams(r2, WireEnum.class, "com.obric.memorydata.plugin")).getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* synthetic */ int encodedSize(Object r3) {
        return encodedSize((WireEnum) ZeusTransformUtils.preCheckCast(r3, WireEnum.class, "com.obric.memorydata.plugin"));
    }

    public abstract E fromValue(int r1);
}
