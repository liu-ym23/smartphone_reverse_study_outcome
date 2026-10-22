package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import jf.d;
import jf.e;
import jf.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    transient int cachedSerializedSize;
    protected transient int hashCode;
    private final transient g unknownFields;

    public static abstract class Builder<M extends Message<M, B>, B extends Builder<M, B>> {
        transient d unknownFieldsBuffer;
        transient g unknownFieldsByteString;
        transient ProtoWriter unknownFieldsWriter;

        public Builder() {
            this.unknownFieldsByteString = g.f8841o;
        }

        private void prepareForNewUnknownFields() {
            if (this.unknownFieldsBuffer != null) goto L9;
            d r8 = new d();
            this.unknownFieldsBuffer = r8;
            ProtoWriter r10 = new ProtoWriter(r8);
            this.unknownFieldsWriter = r10;
            r10.writeBytes(this.unknownFieldsByteString);     // Catch: IOException -> L7
            this.unknownFieldsByteString = g.f8841o;
            return;
        L8:
            throw new AssertionError();
        }

        public final Builder<M, B> addUnknownField(int r8, FieldEncoding r10, Object r11) {
            prepareForNewUnknownFields();
            r10.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, r8, r11);     // Catch: IOException -> L5
            return this;
        L6:
            throw new AssertionError();
        }

        public final Builder<M, B> addUnknownFields(g r8) {
            if (r8.l() <= 0) goto L9;
            prepareForNewUnknownFields();
            this.unknownFieldsWriter.writeBytes(r8);     // Catch: IOException -> L7
        L8:
            throw new AssertionError();
        L9:
            return this;
        }

        public abstract M build();

        public final g buildUnknownFields() {
            d r8 = this.unknownFieldsBuffer;
            if (r8 == null) goto L6;
            this.unknownFieldsByteString = r8.x();
            this.unknownFieldsBuffer = null;
            this.unknownFieldsWriter = null;
        L6:
            return this.unknownFieldsByteString;
        }

        public final Builder<M, B> clearUnknownFields() {
            this.unknownFieldsByteString = g.f8841o;
            d r8 = this.unknownFieldsBuffer;
            if (r8 == null) goto L5;
            r8.a();
            this.unknownFieldsBuffer = null;
        L5:
            this.unknownFieldsWriter = null;
            return this;
        }
    }

    public Message(ProtoAdapter<M> r8, g r10) {
        this.cachedSerializedSize = 0;
        this.hashCode = 0;
        if (r8 == null) goto L10;
        if (r10 == null) goto L8;
        this.adapter = r8;
        this.unknownFields = r10;
        return;
    L8:
        throw new NullPointerException("unknownFields == null");
    L10:
        throw new NullPointerException("adapter == null");
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(OutputStream r8) {
        this.adapter.encode(r8, this);
    }

    public abstract Builder<M, B> newBuilder();

    public String toString() {
        return this.adapter.toString(this);
    }

    public final g unknownFields() {
        g r8 = this.unknownFields;
        if (r8 == null) goto L6;
        return r8;
    L6:
        return g.f8841o;
    }

    public final M withoutUnknownFields() {
        return (M) newBuilder().clearUnknownFields().build();
    }

    public final Object writeReplace() {
        return new MessageSerializedForm(encode(), getClass());
    }

    public final void encode(e r8) {
        this.adapter.encode(r8, this);
    }

    public final byte[] encode() {
        return this.adapter.encode(this);
    }
}
