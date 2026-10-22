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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class NullableMap extends Message<NullableMap, Builder> {
    public static final ProtoAdapter<NullableMap> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("_value")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, String> _value;

    public static final class Builder extends Message.Builder<NullableMap, Builder> {
        public Map<String, String> _value;

        public NullableMap build() {
            return new NullableMap(this._value, super.buildUnknownFields());
        }

        public Builder() {
            this._value = Internal.newMutableMap();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m122build() {
            return build();
        }

        public Builder _value(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this._value = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_NullableMap extends ProtoAdapter<NullableMap> {
        private final ProtoAdapter<Map<String, String>> _value;

        public ProtoAdapter_NullableMap() {
            super(FieldEncoding.LENGTH_DELIMITED, NullableMap.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this._value = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public NullableMap decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0._value.putAll((Map) this._value.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(NullableMap r4) {
            return this._value.encodedSizeWithTag(1, r4._value) + r4.unknownFields().size();
        }

        public NullableMap redact(NullableMap r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m123decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((NullableMap) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((NullableMap) r1);
        }

        public void encode(ProtoWriter r4, NullableMap r5) throws IOException {
            this._value.encodeWithTag(r4, 1, r5._value);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (NullableMap) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NullableMap();
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
        Map<String, String> r1 = this._value;
        if (r1 != null) goto L5;
    L7:
        StringBuilder r2 = r0.replace(0, 2, "NullableMap{");
        r2.append('}');
        return r2.toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", _value=");
        r0.append(this._value);
        goto L7
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m121newBuilder() {
        return newBuilder();
    }

    public NullableMap(Map<String, String> r2) {
        this(r2, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof NullableMap) == true) goto L8;
        return false;
    L8:
        NullableMap r6 = (NullableMap) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this._value.equals(r6._value) == false) goto L13;
        return true;
    }

    public NullableMap(Map<String, String> r2, ByteString r3) {
        super(ADAPTER, r3);
        this._value = Internal.immutableCopyOf("_value", r2);
    }
}
