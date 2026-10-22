package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class GetTTNetParametersRequest extends Message<GetTTNetParametersRequest, a> {
    public static final ProtoAdapter<GetTTNetParametersRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class a extends Message.Builder<GetTTNetParametersRequest, a> {
        public a() {
        }

        public GetTTNetParametersRequest a() {
            return new GetTTNetParametersRequest(super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<GetTTNetParametersRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTTNetParametersRequest.class);
        }

        public int a(GetTTNetParametersRequest r1) {
            return r1.unknownFields().size();
        }

        public GetTTNetParametersRequest a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L6;
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L6:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r1, GetTTNetParametersRequest r2) {
            r1.writeBytes(r2.unknownFields());
        }

        public GetTTNetParametersRequest b(GetTTNetParametersRequest r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ GetTTNetParametersRequest decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, GetTTNetParametersRequest r4) {
            a(r3, (GetTTNetParametersRequest) ZeusTransformUtils.preCheckCast(r4, GetTTNetParametersRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(GetTTNetParametersRequest r3) {
            return a((GetTTNetParametersRequest) ZeusTransformUtils.preCheckCast(r3, GetTTNetParametersRequest.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ GetTTNetParametersRequest redact(GetTTNetParametersRequest r3) {
            return b((GetTTNetParametersRequest) ZeusTransformUtils.preCheckCast(r3, GetTTNetParametersRequest.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public GetTTNetParametersRequest() {
        this(ByteString.EMPTY);
    }

    public GetTTNetParametersRequest(ByteString r2) {
        super(ADAPTER, r2);
    }

    public boolean equals(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, GetTTNetParametersRequest.class);
    }

    public int hashCode() {
        return unknownFields().hashCode();
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return new StringBuilder().replace(0, 2, "GetTTNetParametersRequest{").append('}').toString();
    }
}
