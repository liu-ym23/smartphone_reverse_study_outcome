package com.squareup.wire;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DefaultValueProtoAdapter<E> extends ProtoAdapter<E> {
    public DefaultValueProtoAdapter(FieldEncoding r5, Class<?> r10) {
        super(r5, r10);
    }

    public abstract E decode(ProtoReader r5, E r10);
}
