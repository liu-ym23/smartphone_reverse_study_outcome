package com.squareup.wire;

import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    protected EnumAdapter(Class<E> r10) {
        super(FieldEncoding.VARINT, r10);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public final E decode(ProtoReader r10) {
        int r11 = r10.readVarint32();
        E r12 = (E) fromValue(r11);
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r11, this.javaType);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r10) {
        return decode(r10);
    }

    public final void encode(ProtoWriter r10, E r11) {
        r10.writeVarint32(r11.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Object r11) {
        encode(r10, (WireEnum) r11);
    }

    public final int encodedSize(E r10) {
        return ProtoWriter.varint32Size(r10.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r10) {
        return encodedSize((WireEnum) r10);
    }

    protected abstract E fromValue(int r10);
}
