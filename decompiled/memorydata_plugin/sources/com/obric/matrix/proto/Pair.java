package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class Pair extends Message<Pair, a> {
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

    public static final class a extends Message.Builder<Pair, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8191b;

        public a() {
            this.f8190a = "";
            this.f8191b = "";
        }

        public a a(String r1) {
            this.f8190a = r1;
            return this;
        }

        public Pair a() {
            return new Pair(this.f8190a, this.f8191b, super.buildUnknownFields());
        }

        public a b(String r1) {
            this.f8191b = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<Pair> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, Pair.class);
        }

        public int a(Pair r4) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r4._key) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4._val)) + r4.unknownFields().size();
        }

        public Pair a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L12;
            if (r2 != 1) goto L8;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L9;
            r5.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L12:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, Pair r4) {
            ProtoAdapter.STRING.encodeWithTag(r3, 1, r4._key);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4._val);
            r3.writeBytes(r4.unknownFields());
        }

        public Pair b(Pair r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Pair decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, Pair r4) {
            a(r3, (Pair) ZeusTransformUtils.preCheckCast(r4, Pair.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(Pair r3) {
            return a((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Pair redact(Pair r3) {
            return b((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public Pair(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public Pair(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this._key = r2;
        this._val = r3;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Pair.class) == true) goto L8;
        return false;
    L8:
        Pair r6 = (Pair) ZeusTransformUtils.preCheckCast(r5, Pair.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this._key, r6._key) == false) goto L16;
        if (Internal.equals(this._val, r6._val) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
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
        this.hashCode = r7;
        return r7;
    L7:
        r4 = 0;
        goto L8
    L13:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8190a = this._key;
        r0.f8191b = this._val;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this._key == null) goto L6;
        r0.append(", _key=").append(this._key);
    L6:
        if (this._val == null) goto L9;
        r0.append(", _val=").append(this._val);
    L9:
        return r0.replace(0, 2, "Pair{").append('}').toString();
    }
}
