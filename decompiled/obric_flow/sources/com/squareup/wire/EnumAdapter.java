package com.squareup.wire;

import com.squareup.wire.WireEnum;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    public EnumAdapter(Class<E> r5) {
        super(FieldEncoding.VARINT, r5);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r5) throws IOException {
        return decode(r5);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, Object r10) throws IOException {
        encode(r5, (WireEnum) r10);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r5) {
        return encodedSize((WireEnum) r5);
    }

    public abstract E fromValue(int r5);

    @Override // com.squareup.wire.ProtoAdapter
    public final E decode(ProtoReader r5) throws IOException {
        int r10 = r5.readVarint32();
        E r11 = (E) fromValue(r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r10, this.javaType);
    }

    public final void encode(ProtoWriter r5, E r10) throws IOException {
        r5.writeVarint32(r10.getValue());
    }

    public final int encodedSize(E r5) {
        return ProtoWriter.varint32Size(r5.getValue());
    }
}
