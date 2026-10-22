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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class OnePartyCommonNetworkResponse extends Message<OnePartyCommonNetworkResponse, a> {
    public static final ProtoAdapter<OnePartyCommonNetworkResponse> ADAPTER = null;
    public static final String DEFAULT_BODY = "";
    public static final Boolean DEFAULT_ISSUCCEED = null;
    public static final String DEFAULT_SERVERLOGID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("body")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String body;

    @SerializedName("extraMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> extraMap;

    @SerializedName("isSucceed")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean isSucceed;

    @SerializedName("serverLogId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String serverLogId;

    public static final class a extends Message.Builder<OnePartyCommonNetworkResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f8187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8188b;
        public String c;
        public Map<String, String> d;

        public a() {
            this.f8187a = false;
            this.f8188b = "";
            this.c = "";
            this.d = Internal.newMutableMap();
        }

        public a a(Boolean r1) {
            this.f8187a = r1;
            return this;
        }

        public a a(String r1) {
            this.f8188b = r1;
            return this;
        }

        public OnePartyCommonNetworkResponse a() {
            return new OnePartyCommonNetworkResponse(this.f8187a, this.f8188b, this.c, this.d, super.buildUnknownFields());
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

    private static final class b extends ProtoAdapter<OnePartyCommonNetworkResponse> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8189a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, OnePartyCommonNetworkResponse.class);
            this.f8189a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(OnePartyCommonNetworkResponse r5) {
            return (((ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.isSucceed) + ProtoAdapter.STRING.encodedSizeWithTag(2, r5.body)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r5.serverLogId)) + this.f8189a.encodedSizeWithTag(4, r5.extraMap)) + r5.unknownFields().size();
        }

        public OnePartyCommonNetworkResponse a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r8), Boolean.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.d.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8189a.decode(r8), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L13:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L18:
            r8.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, OnePartyCommonNetworkResponse r5) {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.isSucceed);
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r5.body);
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r5.serverLogId);
            this.f8189a.encodeWithTag(r4, 4, r5.extraMap);
            r4.writeBytes(r5.unknownFields());
        }

        public OnePartyCommonNetworkResponse b(OnePartyCommonNetworkResponse r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ OnePartyCommonNetworkResponse decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, OnePartyCommonNetworkResponse r4) {
            a(r3, (OnePartyCommonNetworkResponse) ZeusTransformUtils.preCheckCast(r4, OnePartyCommonNetworkResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(OnePartyCommonNetworkResponse r3) {
            return a((OnePartyCommonNetworkResponse) ZeusTransformUtils.preCheckCast(r3, OnePartyCommonNetworkResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ OnePartyCommonNetworkResponse redact(OnePartyCommonNetworkResponse r3) {
            return b((OnePartyCommonNetworkResponse) ZeusTransformUtils.preCheckCast(r3, OnePartyCommonNetworkResponse.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_ISSUCCEED = false;
    }

    public OnePartyCommonNetworkResponse(Boolean r7, String r8, String r9, Map<String, String> r10) {
        this(r7, r8, r9, (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public OnePartyCommonNetworkResponse(Boolean r3, String r4, String r5, Map<String, String> r6, ByteString r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r7);
        this.isSucceed = r3;
        this.body = r4;
        this.serverLogId = r5;
        this.extraMap = Internal.immutableCopyOf("extraMap", r8);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OnePartyCommonNetworkResponse.class) == true) goto L8;
        return false;
    L8:
        OnePartyCommonNetworkResponse r6 = (OnePartyCommonNetworkResponse) ZeusTransformUtils.preCheckCast(r5, OnePartyCommonNetworkResponse.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L20;
        if (Internal.equals(this.isSucceed, r6.isSucceed) == false) goto L20;
        if (Internal.equals(this.body, r6.body) == false) goto L20;
        if (Internal.equals(this.serverLogId, r6.serverLogId) == false) goto L20;
        if (this.extraMap.equals(r6.extraMap) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.isSucceed;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.body;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.serverLogId;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = ((r8 + r3) * 37) + this.extraMap.hashCode();
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8187a = this.isSucceed;
        r0.f8188b = this.body;
        r0.c = this.serverLogId;
        r0.d = Internal.copyOf("extraMap", this.extraMap);
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
        if (this.isSucceed == null) goto L6;
        r0.append(", isSucceed=").append(this.isSucceed);
    L6:
        if (this.body == null) goto L9;
        r0.append(", body=").append(this.body);
    L9:
        if (this.serverLogId == null) goto L11;
        r0.append(", serverLogId=").append(this.serverLogId);
    L11:
        Map<String, String> r1 = this.extraMap;
        if (r1 == null) goto L17;
        if (r1.isEmpty() == true) goto L17;
        r0.append(", extraMap=").append(this.extraMap);
    L17:
        return r0.replace(0, 2, "OnePartyCommonNetworkResponse{").append('}').toString();
    }
}
