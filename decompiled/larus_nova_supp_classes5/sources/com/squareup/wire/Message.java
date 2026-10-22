package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    transient int cachedSerializedSize;
    protected transient int hashCode;
    private final transient ByteString unknownFields;

    public static abstract class Builder<M extends Message<M, B>, B extends Builder<M, B>> {
        transient Buffer unknownFieldsBuffer;
        transient ByteString unknownFieldsByteString;
        transient ProtoWriter unknownFieldsWriter;

        public abstract M build();

        private void prepareForNewUnknownFields() {
            if (this.unknownFieldsBuffer != null) goto L9;
            Buffer r0 = new Buffer();
            this.unknownFieldsBuffer = r0;
            ProtoWriter r1 = new ProtoWriter(r0);
            this.unknownFieldsWriter = r1;
            r1.writeBytes(this.unknownFieldsByteString);     // Catch: IOException -> L7
            this.unknownFieldsByteString = ByteString.EMPTY;
            return;
        L8:
            throw new AssertionError();
        }

        public final ByteString buildUnknownFields() {
            Buffer r0 = this.unknownFieldsBuffer;
            if (r0 == null) goto L6;
            this.unknownFieldsByteString = r0.readByteString();
            this.unknownFieldsBuffer = null;
            this.unknownFieldsWriter = null;
        L6:
            return this.unknownFieldsByteString;
        }

        public final Builder<M, B> clearUnknownFields() {
            this.unknownFieldsByteString = ByteString.EMPTY;
            Buffer r0 = this.unknownFieldsBuffer;
            if (r0 == null) goto L5;
            r0.clear();
            this.unknownFieldsBuffer = null;
        L5:
            this.unknownFieldsWriter = null;
            return this;
        }

        public Builder() {
            this.unknownFieldsByteString = ByteString.EMPTY;
        }

        public final Builder<M, B> addUnknownFields(ByteString r2) {
            if (r2.size() <= 0) goto L9;
            prepareForNewUnknownFields();
            this.unknownFieldsWriter.writeBytes(r2);     // Catch: IOException -> L7
        L8:
            throw new AssertionError();
        L9:
            return this;
        }

        public final Builder<M, B> addUnknownField(int r2, FieldEncoding r3, Object r4) {
            prepareForNewUnknownFields();
            r3.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, r2, r4);     // Catch: IOException -> L5
            return this;
        L6:
            throw new AssertionError();
        }
    }

    public abstract Builder<M, B> newBuilder();

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public String toString() {
        return this.adapter.toString(this);
    }

    public final ByteString unknownFields() {
        ByteString r0 = this.unknownFields;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ByteString.EMPTY;
    }

    public final Object writeReplace() throws ObjectStreamException {
        return new MessageSerializedForm(encode(), getClass());
    }

    public final M withoutUnknownFields() {
        return (M) newBuilder().clearUnknownFields().build();
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(OutputStream r2) throws IOException {
        this.adapter.encode(r2, this);
    }

    public final void encode(BufferedSink r2) throws IOException {
        this.adapter.encode(r2, this);
    }

    public Message(ProtoAdapter<M> r2, ByteString r3) {
        this.cachedSerializedSize = 0;
        this.hashCode = 0;
        if (r2 == null) goto L10;
        if (r3 == null) goto L8;
        this.adapter = r2;
        this.unknownFields = r3;
        return;
    L8:
        throw new NullPointerException("unknownFields == null");
    L10:
        throw new NullPointerException("adapter == null");
    }
}
