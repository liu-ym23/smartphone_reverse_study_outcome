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
public final class DecodeLocationResponse extends Message<DecodeLocationResponse, a> {
    public static final ProtoAdapter<DecodeLocationResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("locationInfo")
    @WireField(adapter = "com.obric.matrix.proto.LocationInfo#ADAPTER", tag = 1)
    public final LocationInfo locationInfo;

    public static final class a extends Message.Builder<DecodeLocationResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LocationInfo f8158a;

        public a() {
        }

        public a a(LocationInfo r1) {
            this.f8158a = r1;
            return this;
        }

        public DecodeLocationResponse a() {
            return new DecodeLocationResponse(this.f8158a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<DecodeLocationResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, DecodeLocationResponse.class);
        }

        public int a(DecodeLocationResponse r3) {
            return LocationInfo.ADAPTER.encodedSizeWithTag(1, r3.locationInfo) + r3.unknownFields().size();
        }

        public DecodeLocationResponse a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L9;
            if (r2 != 1) goto L7;
            r5.a((LocationInfo) ZeusTransformUtils.preCheckCast(LocationInfo.ADAPTER.decode(r6), LocationInfo.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L9:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, DecodeLocationResponse r4) {
            LocationInfo.ADAPTER.encodeWithTag(r3, 1, r4.locationInfo);
            r3.writeBytes(r4.unknownFields());
        }

        public DecodeLocationResponse b(DecodeLocationResponse r3) {
            a r2 = r3.newBuilder();
            if (r2.f8158a == null) goto L5;
            r2.f8158a = (LocationInfo) ZeusTransformUtils.preCheckCast(LocationInfo.ADAPTER.redact(r2.f8158a), LocationInfo.class, "com.obric.memorydata.plugin");
        L5:
            r2.clearUnknownFields();
            return r2.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ DecodeLocationResponse decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, DecodeLocationResponse r4) {
            a(r3, (DecodeLocationResponse) ZeusTransformUtils.preCheckCast(r4, DecodeLocationResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(DecodeLocationResponse r3) {
            return a((DecodeLocationResponse) ZeusTransformUtils.preCheckCast(r3, DecodeLocationResponse.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ DecodeLocationResponse redact(DecodeLocationResponse r3) {
            return b((DecodeLocationResponse) ZeusTransformUtils.preCheckCast(r3, DecodeLocationResponse.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public DecodeLocationResponse(LocationInfo r2) {
        this(r2, ByteString.EMPTY);
    }

    public DecodeLocationResponse(LocationInfo r2, ByteString r3) {
        super(ADAPTER, r3);
        this.locationInfo = r2;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DecodeLocationResponse.class) == true) goto L8;
        return false;
    L8:
        DecodeLocationResponse r6 = (DecodeLocationResponse) ZeusTransformUtils.preCheckCast(r5, DecodeLocationResponse.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (Internal.equals(this.locationInfo, r6.locationInfo) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        LocationInfo r2 = this.locationInfo;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = r1 + r3;
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
        r0.f8158a = this.locationInfo;
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
        if (this.locationInfo == null) goto L6;
        r0.append(", locationInfo");
    L6:
        return r0.replace(0, 2, "DecodeLocationResponse{").append('}').toString();
    }
}
