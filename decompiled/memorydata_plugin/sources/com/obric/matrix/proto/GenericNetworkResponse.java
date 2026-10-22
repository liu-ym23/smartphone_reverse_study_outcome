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
public final class GenericNetworkResponse extends Message<GenericNetworkResponse, a> {
    public static final ProtoAdapter<GenericNetworkResponse> ADAPTER = null;
    public static final String DEFAULT_BODY = "";
    public static final Boolean DEFAULT_ISSUCCEED = null;
    public static final String DEFAULT_SERVERLOGID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("body")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
    public final String body;

    @SerializedName("isSucceed")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.REQUIRED, tag = 1)
    public final Boolean isSucceed;

    @SerializedName("serverLogId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 3)
    public final String serverLogId;

    public static final class a extends Message.Builder<GenericNetworkResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f8166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8167b;
        public String c;

        public a() {
            this.f8166a = false;
            this.f8167b = "";
            this.c = "";
        }

        public a a(Boolean r1) {
            this.f8166a = r1;
            return this;
        }

        public a a(String r1) {
            this.f8167b = r1;
            return this;
        }

        public GenericNetworkResponse a() {
            Boolean r0 = this.f8166a;
            if (r0 == null) goto L11;
            if (this.f8167b == null) goto L11;
            if (this.c == null) goto L11;
            return new GenericNetworkResponse(this.f8166a, this.f8167b, this.c, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r0, "isSucceed", this.f8167b, "body", this.c, "serverLogId"});
        }

        public a b(String r1) {
            this.c = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<GenericNetworkResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, GenericNetworkResponse.class);
        }

        public int a(GenericNetworkResponse r4) {
            return ((ProtoAdapter.BOOL.encodedSizeWithTag(1, r4.isSucceed) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.body)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r4.serverLogId)) + r4.unknownFields().size();
        }

        public GenericNetworkResponse a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L15;
            if (r2 != 1) goto L8;
            r5.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r6), Boolean.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r2 != 2) goto L10;
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            if (r2 != 3) goto L11;
            r5.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L15:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, GenericNetworkResponse r4) {
            ProtoAdapter.BOOL.encodeWithTag(r3, 1, r4.isSucceed);
            ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.body);
            ProtoAdapter.STRING.encodeWithTag(r3, 3, r4.serverLogId);
            r3.writeBytes(r4.unknownFields());
        }

        public GenericNetworkResponse b(GenericNetworkResponse r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ GenericNetworkResponse decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, GenericNetworkResponse r4) {
            a(r3, (GenericNetworkResponse) ZeusTransformUtils.preCheckCast(r4, GenericNetworkResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(GenericNetworkResponse r3) {
            return a((GenericNetworkResponse) ZeusTransformUtils.preCheckCast(r3, GenericNetworkResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ GenericNetworkResponse redact(GenericNetworkResponse r3) {
            return b((GenericNetworkResponse) ZeusTransformUtils.preCheckCast(r3, GenericNetworkResponse.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_ISSUCCEED = false;
    }

    public GenericNetworkResponse(Boolean r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public GenericNetworkResponse(Boolean r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.isSucceed = r2;
        this.body = r3;
        this.serverLogId = r4;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, GenericNetworkResponse.class) == true) goto L8;
        return false;
    L8:
        GenericNetworkResponse r6 = (GenericNetworkResponse) ZeusTransformUtils.preCheckCast(r5, GenericNetworkResponse.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L18;
        if (this.isSucceed.equals(r6.isSucceed) == false) goto L18;
        if (this.body.equals(r6.body) == false) goto L18;
        if (this.serverLogId.equals(r6.serverLogId) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (((((unknownFields().hashCode() * 37) + this.isSucceed.hashCode()) * 37) + this.body.hashCode()) * 37) + this.serverLogId.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8166a = this.isSucceed;
        r0.f8167b = this.body;
        r0.c = this.serverLogId;
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
        r0.append(", isSucceed=").append(this.isSucceed);
        r0.append(", body=").append(this.body);
        r0.append(", serverLogId=").append(this.serverLogId);
        return r0.replace(0, 2, "GenericNetworkResponse{").append('}').toString();
    }
}
