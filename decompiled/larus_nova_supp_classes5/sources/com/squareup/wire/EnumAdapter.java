package com.squareup.wire;

import com.squareup.wire.WireEnum;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class EnumAdapter<E extends WireEnum> extends ProtoAdapter<E> {
    public abstract E fromValue(int r1);

    public EnumAdapter(Class<E> r2) {
        super(FieldEncoding.VARINT, r2);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public final E decode(ProtoReader r3) throws IOException {
        int r4 = r3.readVarint32();
        E r0 = (E) fromValue(r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new ProtoAdapter.EnumConstantNotFoundException(r4, this.javaType);
    }

    public final int encodedSize(E r1) {
        return ProtoWriter.varint32Size(r1.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r1) throws IOException {
        return decode(r1);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
        return encodedSize((WireEnum) r1);
    }

    public final void encode(ProtoWriter r1, E r2) throws IOException {
        r1.writeVarint32(r2.getValue());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
        encode(r1, (WireEnum) r2);
    }
}
