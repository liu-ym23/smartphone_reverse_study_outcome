package com.squareup.wire;

import com.squareup.wire.WireEnum;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    public EnumAdapter(Class<E> r8) {
        super(FieldEncoding.VARINT, r8);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public final E decode(ProtoReader r8) {
        int r10 = r8.readVarint32();
        E r11 = (E) fromValue(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r10, this.javaType);
    }

    public final void encode(ProtoWriter r8, E r10) {
        r8.writeVarint32(r10.getValue());
    }

    public final int encodedSize(E r8) {
        return ProtoWriter.varint32Size(r8.getValue());
    }

    public abstract E fromValue(int r8);

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r8) {
        return decode(r8);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r8, Object r10) {
        encode(r8, (WireEnum) r10);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r8) {
        return encodedSize((WireEnum) r8);
    }
}
