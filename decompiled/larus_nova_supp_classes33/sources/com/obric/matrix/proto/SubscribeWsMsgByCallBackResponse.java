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
public final class SubscribeWsMsgByCallBackResponse extends Message<SubscribeWsMsgByCallBackResponse, Builder> {
    public static final ProtoAdapter<SubscribeWsMsgByCallBackResponse> ADAPTER = null;
    public static final Boolean DEFAULT_SUBSCRIBERESULT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("subscribeResult")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean subscribeResult;

    public static final class Builder extends Message.Builder<SubscribeWsMsgByCallBackResponse, Builder> {
        public Boolean subscribeResult;

        public SubscribeWsMsgByCallBackResponse build() {
            return new SubscribeWsMsgByCallBackResponse(this.subscribeResult, super.buildUnknownFields());
        }

        public Builder() {
            this.subscribeResult = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m206build() {
            return build();
        }

        public Builder subscribeResult(Boolean r1) {
            this.subscribeResult = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeWsMsgByCallBackResponse extends ProtoAdapter<SubscribeWsMsgByCallBackResponse> {
        public ProtoAdapter_SubscribeWsMsgByCallBackResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByCallBackResponse.class);
        }

        public SubscribeWsMsgByCallBackResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.subscribeResult((Boolean) ProtoAdapter.BOOL.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SubscribeWsMsgByCallBackResponse r4) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r4.subscribeResult) + r4.unknownFields().size();
        }

        public SubscribeWsMsgByCallBackResponse redact(SubscribeWsMsgByCallBackResponse r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m207decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SubscribeWsMsgByCallBackResponse) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SubscribeWsMsgByCallBackResponse) r1);
        }

        public void encode(ProtoWriter r4, SubscribeWsMsgByCallBackResponse r5) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.subscribeResult);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SubscribeWsMsgByCallBackResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsMsgByCallBackResponse();
        DEFAULT_SUBSCRIBERESULT = Boolean.FALSE;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.subscribeResult;
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
        r0.subscribeResult = this.subscribeResult;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.subscribeResult == null) goto L5;
        r0.append(", subscribeResult=");
        r0.append(this.subscribeResult);
    L5:
        StringBuilder r1 = r0.replace(0, 2, "SubscribeWsMsgByCallBackResponse{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m205newBuilder() {
        return newBuilder();
    }

    public SubscribeWsMsgByCallBackResponse(Boolean r2) {
        this(r2, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsMsgByCallBackResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByCallBackResponse r6 = (SubscribeWsMsgByCallBackResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (Internal.equals(this.subscribeResult, r6.subscribeResult) == false) goto L13;
        return true;
    }

    public SubscribeWsMsgByCallBackResponse(Boolean r2, ByteString r3) {
        super(ADAPTER, r3);
        this.subscribeResult = r2;
    }
}
