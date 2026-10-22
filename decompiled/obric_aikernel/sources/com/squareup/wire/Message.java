package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Objects;
import okio.ByteString;
import okio.d;
import okio.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Message<M extends Message<M, B>, B extends Builder<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;
    private final transient ProtoAdapter<M> adapter;
    transient int cachedSerializedSize;
    protected transient int hashCode;
    private final transient ByteString unknownFields;

    public static abstract class Builder<M extends Message<M, B>, B extends Builder<M, B>> {
        transient d unknownFieldsBuffer;
        transient ByteString unknownFieldsByteString;
        transient ProtoWriter unknownFieldsWriter;

        protected Builder() {
            this.unknownFieldsByteString = ByteString.EMPTY;
        }

        private void prepareForNewUnknownFields() {
            if (this.unknownFieldsBuffer != null) goto L9;
            d r10 = new d();
            this.unknownFieldsBuffer = r10;
            ProtoWriter r11 = new ProtoWriter(r10);
            this.unknownFieldsWriter = r11;
            r11.writeBytes(this.unknownFieldsByteString);     // Catch: IOException -> L7
            this.unknownFieldsByteString = ByteString.EMPTY;
            return;
        L8:
            throw new AssertionError();
        }

        public final Builder<M, B> addUnknownField(int r10, FieldEncoding r11, Object r12) {
            prepareForNewUnknownFields();
            r11.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, r10, r12);     // Catch: IOException -> L5
            return this;
        L6:
            throw new AssertionError();
        }

        public final Builder<M, B> addUnknownFields(ByteString r10) {
            if (r10.size() <= 0) goto L9;
            prepareForNewUnknownFields();
            this.unknownFieldsWriter.writeBytes(r10);     // Catch: IOException -> L7
        L8:
            throw new AssertionError();
        L9:
            return this;
        }

        public abstract M build();

        public final ByteString buildUnknownFields() {
            d r10 = this.unknownFieldsBuffer;
            if (r10 == null) goto L6;
            this.unknownFieldsByteString = r10.D();
            this.unknownFieldsBuffer = null;
            this.unknownFieldsWriter = null;
        L6:
            return this.unknownFieldsByteString;
        }

        public final Builder<M, B> clearUnknownFields() {
            this.unknownFieldsByteString = ByteString.EMPTY;
            d r10 = this.unknownFieldsBuffer;
            if (r10 == null) goto L5;
            r10.f();
            this.unknownFieldsBuffer = null;
        L5:
            this.unknownFieldsWriter = null;
            return this;
        }
    }

    protected Message(ProtoAdapter<M> r10, ByteString r11) {
        this.cachedSerializedSize = 0;
        this.hashCode = 0;
        Objects.requireNonNull(r10, "adapter == null");
        Objects.requireNonNull(r11, "unknownFields == null");
        this.adapter = r10;
        this.unknownFields = r11;
    }

    public final ProtoAdapter<M> adapter() {
        return this.adapter;
    }

    public final void encode(OutputStream r10) {
        this.adapter.encode(r10, this);
    }

    public final void encode(e r10) {
        this.adapter.encode(r10, this);
    }

    public final byte[] encode() {
        return this.adapter.encode(this);
    }

    public abstract Builder<M, B> newBuilder();

    public String toString() {
        return this.adapter.toString(this);
    }

    public final ByteString unknownFields() {
        ByteString r10 = this.unknownFields;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return ByteString.EMPTY;
    }

    public final M withoutUnknownFields() {
        return (M) newBuilder().clearUnknownFields().build();
    }

    protected final Object writeReplace() {
        return new MessageSerializedForm(encode(), getClass());
    }
}
