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
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class Pair extends Message<Pair, Builder> {
    public static final ProtoAdapter<Pair> ADAPTER = null;
    public static final String DEFAULT__KEY = "";
    public static final String DEFAULT__VAL = "";
    private static final long serialVersionUID = 0;

    @SerializedName("_key")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String _key;

    @SerializedName("_val")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String _val;

    public static final class Builder extends Message.Builder<Pair, Builder> {
        public String _key;
        public String _val;

        public Pair build() {
            return new Pair(this._key, this._val, super.buildUnknownFields());
        }

        public Builder() {
            this._key = "";
            this._val = "";
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m131build() {
            return build();
        }

        public Builder _key(String r1) {
            this._key = r1;
            return this;
        }

        public Builder _val(String r1) {
            this._val = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Pair extends ProtoAdapter<Pair> {
        public ProtoAdapter_Pair() {
            super(FieldEncoding.LENGTH_DELIMITED, Pair.class);
        }

        public Pair decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0._key((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0._val((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(Pair r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            return (r0.encodedSizeWithTag(1, r5._key) + r0.encodedSizeWithTag(2, r5._val)) + r5.unknownFields().size();
        }

        public Pair redact(Pair r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m132decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Pair) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((Pair) r1);
        }

        public void encode(ProtoWriter r4, Pair r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5._key);
            r0.encodeWithTag(r4, 2, r5._val);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Pair) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Pair();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L13;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this._key;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this._val;
        if (r6 == null) goto L11;
        r3 = r6.hashCode();
    L11:
        int r7 = r5 + r3;
        ((Message) this).hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0._key = this._key;
        r0._val = this._val;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this._key == null) goto L6;
        r0.append(", _key=");
        r0.append(this._key);
    L6:
        if (this._val == null) goto L8;
        r0.append(", _val=");
        r0.append(this._val);
    L8:
        StringBuilder r1 = r0.replace(0, 2, "Pair{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m130newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Pair) == true) goto L8;
        return false;
    L8:
        Pair r6 = (Pair) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this._key, r6._key) == false) goto L15;
        if (Internal.equals(this._val, r6._val) == false) goto L15;
        return true;
    }

    public Pair(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Pair(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this._key = r2;
        this._val = r3;
    }
}
