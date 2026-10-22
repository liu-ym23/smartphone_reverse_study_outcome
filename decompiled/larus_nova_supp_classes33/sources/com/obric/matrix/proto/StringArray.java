package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class StringArray extends Message<StringArray, Builder> {
    public static final ProtoAdapter<StringArray> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("_value")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 1)
    public final List<String> _value;

    public static final class Builder extends Message.Builder<StringArray, Builder> {
        public List<String> _value;

        public StringArray build() {
            return new StringArray(this._value, super.buildUnknownFields());
        }

        public Builder() {
            this._value = Internal.newMutableList();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m194build() {
            return build();
        }

        public Builder _value(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this._value = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_StringArray extends ProtoAdapter<StringArray> {
        public ProtoAdapter_StringArray() {
            super(FieldEncoding.LENGTH_DELIMITED, StringArray.class);
        }

        public StringArray decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0._value.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(StringArray r4) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4._value) + r4.unknownFields().size();
        }

        public StringArray redact(StringArray r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m195decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((StringArray) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((StringArray) r1);
        }

        public void encode(ProtoWriter r4, StringArray r5) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5._value);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (StringArray) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StringArray();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this._value.hashCode();
        ((Message) this).hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0._value = Internal.copyOf("_value", this._value);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<String> r1 = this._value;
        if (r1 != null) goto L5;
    L7:
        StringBuilder r2 = r0.replace(0, 2, "StringArray{");
        r2.append('}');
        return r2.toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", _value=");
        r0.append(this._value);
        goto L7
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m193newBuilder() {
        return newBuilder();
    }

    public StringArray(List<String> r2) {
        this(r2, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof StringArray) == true) goto L8;
        return false;
    L8:
        StringArray r6 = (StringArray) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this._value.equals(r6._value) == false) goto L13;
        return true;
    }

    public StringArray(List<String> r2, ByteString r3) {
        super(ADAPTER, r3);
        this._value = Internal.immutableCopyOf("_value", r2);
    }
}
