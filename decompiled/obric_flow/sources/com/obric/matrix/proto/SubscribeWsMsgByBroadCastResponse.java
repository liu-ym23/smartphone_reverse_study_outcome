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
public final class SubscribeWsMsgByBroadCastResponse extends Message<SubscribeWsMsgByBroadCastResponse, Builder> {
    public static final ProtoAdapter<SubscribeWsMsgByBroadCastResponse> ADAPTER = null;
    public static final Boolean DEFAULT_SUBSCRIBERESULT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("subscribeResult")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean subscribeResult;

    public static final class Builder extends Message.Builder<SubscribeWsMsgByBroadCastResponse, Builder> {
        public Boolean subscribeResult;

        public Builder() {
            this.subscribeResult = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder subscribeResult(Boolean r5) {
            this.subscribeResult = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsMsgByBroadCastResponse build() {
            return new SubscribeWsMsgByBroadCastResponse(this.subscribeResult, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SubscribeWsMsgByBroadCastResponse extends ProtoAdapter<SubscribeWsMsgByBroadCastResponse> {
        public ProtoAdapter_SubscribeWsMsgByBroadCastResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByBroadCastResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByBroadCastResponse decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, SubscribeWsMsgByBroadCastResponse r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsMsgByBroadCastResponse r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByBroadCastResponse redact(SubscribeWsMsgByBroadCastResponse r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsMsgByBroadCastResponse decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L9;
            if (r12 != 1) goto L7;
            r5.subscribeResult(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L7:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L9:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, SubscribeWsMsgByBroadCastResponse r10) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r5, 1, r10.subscribeResult);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SubscribeWsMsgByBroadCastResponse r5) {
            int r10 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.subscribeResult);
            return r5.unknownFields().size() + r10;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SubscribeWsMsgByBroadCastResponse redact2(SubscribeWsMsgByBroadCastResponse r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsMsgByBroadCastResponse();
        DEFAULT_SUBSCRIBERESULT = Boolean.FALSE;
    }

    public SubscribeWsMsgByBroadCastResponse(Boolean r5) {
        this(r5, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsMsgByBroadCastResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByBroadCastResponse r10 = (SubscribeWsMsgByBroadCastResponse) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L14;
        if (Internal.equals(this.subscribeResult, r10.subscribeResult) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L10;
        int r10 = unknownFields().hashCode() * 37;
        Boolean r11 = this.subscribeResult;
        if (r11 == null) goto L7;
        int r12 = r11.hashCode();
    L8:
        int r13 = r10 + r12;
        this.hashCode = r13;
        return r13;
    L7:
        r12 = 0;
        goto L8
    L10:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.subscribeResult == null) goto L6;
        r5.append(", subscribeResult=");
        r5.append(this.subscribeResult);
    L6:
        return a.s(r5, 0, 2, "SubscribeWsMsgByBroadCastResponse{", '}');
    }

    public SubscribeWsMsgByBroadCastResponse(Boolean r5, ByteString r10) {
        super(ADAPTER, r10);
        this.subscribeResult = r5;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.subscribeResult = this.subscribeResult;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
