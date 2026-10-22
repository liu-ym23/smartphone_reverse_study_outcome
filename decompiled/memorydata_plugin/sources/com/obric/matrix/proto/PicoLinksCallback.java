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
public final class PicoLinksCallback extends Message<PicoLinksCallback, a> {
    public static final ProtoAdapter<PicoLinksCallback> ADAPTER = null;
    public static final Integer DEFAULT_CALLBACKID = null;
    private static final long serialVersionUID = 0;

    @SerializedName("callbackData")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, String> callbackData;

    @SerializedName("callbackId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer callbackId;

    public static final class a extends Message.Builder<PicoLinksCallback, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f8192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f8193b;

        public a() {
            this.f8192a = 0;
            this.f8193b = Internal.newMutableMap();
        }

        public a a(Integer r1) {
            this.f8192a = r1;
            return this;
        }

        public PicoLinksCallback a() {
            return new PicoLinksCallback(this.f8192a, this.f8193b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<PicoLinksCallback> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8194a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, PicoLinksCallback.class);
            this.f8194a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(PicoLinksCallback r4) {
            return (ProtoAdapter.INT32.encodedSizeWithTag(1, r4.callbackId) + this.f8194a.encodedSizeWithTag(2, r4.callbackData)) + r4.unknownFields().size();
        }

        public PicoLinksCallback a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.f8193b.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8194a.decode(r8), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L12:
            r8.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, PicoLinksCallback r5) {
            ProtoAdapter.INT32.encodeWithTag(r4, 1, r5.callbackId);
            this.f8194a.encodeWithTag(r4, 2, r5.callbackData);
            r4.writeBytes(r5.unknownFields());
        }

        public PicoLinksCallback b(PicoLinksCallback r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ PicoLinksCallback decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, PicoLinksCallback r4) {
            a(r3, (PicoLinksCallback) ZeusTransformUtils.preCheckCast(r4, PicoLinksCallback.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(PicoLinksCallback r3) {
            return a((PicoLinksCallback) ZeusTransformUtils.preCheckCast(r3, PicoLinksCallback.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ PicoLinksCallback redact(PicoLinksCallback r3) {
            return b((PicoLinksCallback) ZeusTransformUtils.preCheckCast(r3, PicoLinksCallback.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_CALLBACKID = 0;
    }

    public PicoLinksCallback(Integer r3, Map<String, String> r4) {
        this(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public PicoLinksCallback(Integer r3, Map<String, String> r4, ByteString r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r5);
        this.callbackId = r3;
        this.callbackData = Internal.immutableCopyOf("callbackData", r6);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PicoLinksCallback.class) == true) goto L8;
        return false;
    L8:
        PicoLinksCallback r6 = (PicoLinksCallback) ZeusTransformUtils.preCheckCast(r5, PicoLinksCallback.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.callbackId, r6.callbackId) == false) goto L16;
        if (this.callbackData.equals(r6.callbackData) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.callbackId;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.callbackData.hashCode();
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
        r0.f8192a = this.callbackId;
        r0.f8193b = Internal.copyOf("callbackData", this.callbackData);
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
        if (this.callbackId == null) goto L5;
        r0.append(", callbackId=").append(this.callbackId);
    L5:
        Map<String, String> r1 = this.callbackData;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", callbackData=").append(this.callbackData);
    L11:
        return r0.replace(0, 2, "PicoLinksCallback{").append('}').toString();
    }
}
