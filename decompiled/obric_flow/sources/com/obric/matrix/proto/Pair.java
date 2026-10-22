package com.obric.matrix.proto;

import androidx.room.jarjarred.org.antlr.runtime.a;
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

/* JADX INFO: loaded from: classes3.dex */
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

        public Builder() {
            this._key = "";
            this._val = "";
        }

        public Builder _key(String r5) {
            this._key = r5;
            return this;
        }

        public Builder _val(String r5) {
            this._val = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.squareup.wire.Message.Builder
        public Pair build() {
            return new Pair(this._key, this._val, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Pair extends ProtoAdapter<Pair> {
        public ProtoAdapter_Pair() {
            super(FieldEncoding.LENGTH_DELIMITED, Pair.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Pair decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, Pair r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Pair r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Pair redact(Pair r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Pair decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L12;
            if (r12 != 1) goto L8;
            r5._key(ProtoAdapter.STRING.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r5._val(ProtoAdapter.STRING.decode(r10));
            goto L3
        L9:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L12:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, Pair r10) throws IOException {
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            r11.encodeWithTag(r5, 1, r10._key);
            r11.encodeWithTag(r5, 2, r10._val);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Pair r5) {
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            int r11 = r10.encodedSizeWithTag(1, r5._key);
            int r12 = r10.encodedSizeWithTag(2, r5._val) + r11;
            return r5.unknownFields().size() + r12;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Pair redact2(Pair r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Pair();
    }

    public Pair(String r5, String r10) {
        this(r5, r10, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Pair) == true) goto L8;
        return false;
    L8:
        Pair r10 = (Pair) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this._key, r10._key) == false) goto L16;
        if (Internal.equals(this._val, r10._val) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L13;
        int r10 = unknownFields().hashCode() * 37;
        String r11 = this._key;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        String r15 = this._val;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        int r16 = r14 + r12;
        this.hashCode = r16;
        return r16;
    L7:
        r13 = 0;
        goto L8
    L13:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this._key == null) goto L6;
        r5.append(", _key=");
        r5.append(this._key);
    L6:
        if (this._val == null) goto L9;
        r5.append(", _val=");
        r5.append(this._val);
    L9:
        return a.s(r5, 0, 2, "Pair{", '}');
    }

    public Pair(String r5, String r10, ByteString r11) {
        super(ADAPTER, r11);
        this._key = r5;
        this._val = r10;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5._key = this._key;
        r5._val = this._val;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
