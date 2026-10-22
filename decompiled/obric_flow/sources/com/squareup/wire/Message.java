package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import nu.j;
import nu.k;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    transient int cachedSerializedSize;
    protected transient int hashCode;
    private final transient ByteString unknownFields;

    public static abstract class Builder<M extends Message<M, B>, B extends Builder<M, B>> {
        transient j unknownFieldsBuffer;
        transient ByteString unknownFieldsByteString;
        transient ProtoWriter unknownFieldsWriter;

        public Builder() {
            this.unknownFieldsByteString = ByteString.EMPTY;
        }

        private void prepareForNewUnknownFields() {
            if (this.unknownFieldsBuffer != null) goto L9;
            j r5 = new j();
            this.unknownFieldsBuffer = r5;
            ProtoWriter r10 = new ProtoWriter(r5);
            this.unknownFieldsWriter = r10;
            r10.writeBytes(this.unknownFieldsByteString);     // Catch: IOException -> L7
            this.unknownFieldsByteString = ByteString.EMPTY;
            return;
        L8:
            throw new AssertionError();
        }

        public final Builder<M, B> addUnknownField(int r5, FieldEncoding r10, Object r11) {
            prepareForNewUnknownFields();
            r10.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, r5, r11);     // Catch: IOException -> L5
            return this;
        L6:
            throw new AssertionError();
        }

        public final Builder<M, B> addUnknownFields(ByteString r5) {
            if (r5.size() <= 0) goto L9;
            prepareForNewUnknownFields();
            this.unknownFieldsWriter.writeBytes(r5);     // Catch: IOException -> L7
        L8:
            throw new AssertionError();
        L9:
            return this;
        }

        public abstract M build();

        public final ByteString buildUnknownFields() {
            j r5 = this.unknownFieldsBuffer;
            if (r5 == null) goto L6;
            this.unknownFieldsByteString = r5.v(r5.f20328b);
            this.unknownFieldsBuffer = null;
            this.unknownFieldsWriter = null;
        L6:
            return this.unknownFieldsByteString;
        }

        public final Builder<M, B> clearUnknownFields() {
            this.unknownFieldsByteString = ByteString.EMPTY;
            j r5 = this.unknownFieldsBuffer;
            if (r5 == null) goto L5;
            r5.b();
            this.unknownFieldsBuffer = null;
        L5:
            this.unknownFieldsWriter = null;
            return this;
        }
    }

    public Message(ProtoAdapter<M> r5, ByteString r10) {
        this.cachedSerializedSize = 0;
        this.hashCode = 0;
        if (r5 == null) goto L10;
        if (r10 == null) goto L8;
        this.adapter = r5;
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

    public final void encode(k r5) throws IOException {
        this.adapter.encode(r5, this);
    }

    public abstract Builder<M, B> newBuilder();

    public String toString() {
        return this.adapter.toString(this);
    }

    public final ByteString unknownFields() {
        ByteString r5 = this.unknownFields;
        if (r5 == null) goto L6;
        return r5;
    L6:
        return ByteString.EMPTY;
    }

    public final M withoutUnknownFields() {
        return (M) newBuilder().clearUnknownFields().build();
    }

    public final Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(encode(), getClass());
    }

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public final void encode(OutputStream r5) throws IOException {
        this.adapter.encode(r5, this);
    }
}
