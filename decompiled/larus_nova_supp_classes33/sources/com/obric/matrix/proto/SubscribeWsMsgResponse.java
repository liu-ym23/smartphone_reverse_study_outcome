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
public final class SubscribeWsMsgResponse extends Message<SubscribeWsMsgResponse, Builder> {
    public static final ProtoAdapter<SubscribeWsMsgResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("wsMessageInfo")
    @WireField(adapter = "com.obric.matrix.proto.WsMessageInfo#ADAPTER", tag = 1)
    public final WsMessageInfo wsMessageInfo;

    public static final class Builder extends Message.Builder<SubscribeWsMsgResponse, Builder> {
        public WsMessageInfo wsMessageInfo;

        public SubscribeWsMsgResponse build() {
            return new SubscribeWsMsgResponse(this.wsMessageInfo, super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m218build() {
            return build();
        }

        public Builder wsMessageInfo(WsMessageInfo r1) {
            this.wsMessageInfo = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeWsMsgResponse extends ProtoAdapter<SubscribeWsMsgResponse> {
        public ProtoAdapter_SubscribeWsMsgResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgResponse.class);
        }

        public SubscribeWsMsgResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.wsMessageInfo((WsMessageInfo) WsMessageInfo.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SubscribeWsMsgResponse r4) {
            return WsMessageInfo.ADAPTER.encodedSizeWithTag(1, r4.wsMessageInfo) + r4.unknownFields().size();
        }

        public SubscribeWsMsgResponse redact(SubscribeWsMsgResponse r3) {
            Builder r4 = r3.newBuilder();
            WsMessageInfo r0 = r4.wsMessageInfo;
            if (r0 == null) goto L5;
            r4.wsMessageInfo = (WsMessageInfo) WsMessageInfo.ADAPTER.redact(r0);
        L5:
            r4.clearUnknownFields();
            return r4.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m219decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SubscribeWsMsgResponse) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SubscribeWsMsgResponse) r1);
        }

        public void encode(ProtoWriter r4, SubscribeWsMsgResponse r5) throws IOException {
            WsMessageInfo.ADAPTER.encodeWithTag(r4, 1, r5.wsMessageInfo);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SubscribeWsMsgResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsMsgResponse();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        WsMessageInfo r2 = this.wsMessageInfo;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = r1 + r3;
        ((Message) this).hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.wsMessageInfo = this.wsMessageInfo;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.wsMessageInfo == null) goto L5;
        r0.append(", wsMessageInfo=");
        r0.append(this.wsMessageInfo);
    L5:
        StringBuilder r1 = r0.replace(0, 2, "SubscribeWsMsgResponse{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m217newBuilder() {
        return newBuilder();
    }

    public SubscribeWsMsgResponse(WsMessageInfo r2) {
        this(r2, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsMsgResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgResponse r6 = (SubscribeWsMsgResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (Internal.equals(this.wsMessageInfo, r6.wsMessageInfo) == false) goto L13;
        return true;
    }

    public SubscribeWsMsgResponse(WsMessageInfo r2, ByteString r3) {
        super(ADAPTER, r3);
        this.wsMessageInfo = r2;
    }
}
