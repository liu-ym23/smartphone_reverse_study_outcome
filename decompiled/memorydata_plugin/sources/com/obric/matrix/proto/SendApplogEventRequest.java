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
public final class SendApplogEventRequest extends Message<SendApplogEventRequest, a> {
    public static final ProtoAdapter<SendApplogEventRequest> ADAPTER = null;
    public static final String DEFAULT_APPID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("appid")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String appid;

    @SerializedName("eventMap")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> eventMap;

    public static final class a extends Message.Builder<SendApplogEventRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f8224b;

        public a() {
            this.f8223a = "";
            this.f8224b = Internal.newMutableMap();
        }

        public a a(String r1) {
            this.f8223a = r1;
            return this;
        }

        public SendApplogEventRequest a() {
            return new SendApplogEventRequest(this.f8223a, this.f8224b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<SendApplogEventRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8225a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SendApplogEventRequest.class);
            this.f8225a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(SendApplogEventRequest r4) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r4.appid) + this.f8225a.encodedSizeWithTag(2, r4.eventMap)) + r4.unknownFields().size();
        }

        public SendApplogEventRequest a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r8), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.f8224b.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8225a.decode(r8), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L12:
            r8.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, SendApplogEventRequest r5) {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.appid);
            this.f8225a.encodeWithTag(r4, 2, r5.eventMap);
            r4.writeBytes(r5.unknownFields());
        }

        public SendApplogEventRequest b(SendApplogEventRequest r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SendApplogEventRequest decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, SendApplogEventRequest r4) {
            a(r3, (SendApplogEventRequest) ZeusTransformUtils.preCheckCast(r4, SendApplogEventRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(SendApplogEventRequest r3) {
            return a((SendApplogEventRequest) ZeusTransformUtils.preCheckCast(r3, SendApplogEventRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SendApplogEventRequest redact(SendApplogEventRequest r3) {
            return b((SendApplogEventRequest) ZeusTransformUtils.preCheckCast(r3, SendApplogEventRequest.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public SendApplogEventRequest(String r3, Map<String, String> r4) {
        this(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public SendApplogEventRequest(String r3, Map<String, String> r4, ByteString r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r5);
        this.appid = r3;
        this.eventMap = Internal.immutableCopyOf("eventMap", r6);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SendApplogEventRequest.class) == true) goto L8;
        return false;
    L8:
        SendApplogEventRequest r6 = (SendApplogEventRequest) ZeusTransformUtils.preCheckCast(r5, SendApplogEventRequest.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.appid, r6.appid) == false) goto L16;
        if (this.eventMap.equals(r6.eventMap) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.appid;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.eventMap.hashCode();
        this.hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8223a = this.appid;
        r0.f8224b = Internal.copyOf("eventMap", this.eventMap);
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
        if (this.appid == null) goto L5;
        r0.append(", appid=").append(this.appid);
    L5:
        Map<String, String> r1 = this.eventMap;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", eventMap=").append(this.eventMap);
    L11:
        return r0.replace(0, 2, "SendApplogEventRequest{").append('}').toString();
    }
}
