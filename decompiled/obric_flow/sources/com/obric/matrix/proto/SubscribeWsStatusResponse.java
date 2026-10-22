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
public final class SubscribeWsStatusResponse extends Message<SubscribeWsStatusResponse, Builder> {
    public static final ProtoAdapter<SubscribeWsStatusResponse> ADAPTER = null;
    public static final Integer DEFAULT_CHANNELID = null;
    public static final Integer DEFAULT_CHANNELTYPE = null;
    public static final Integer DEFAULT_CONNECTIONSTATE = null;
    public static final Boolean DEFAULT_ISCONNECTED = null;
    private static final long serialVersionUID = 0;

    @SerializedName("channelId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer channelId;

    @SerializedName("channelType")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer channelType;

    @SerializedName("connectionState")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer connectionState;

    @SerializedName("isConnected")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    public final Boolean isConnected;

    public static final class Builder extends Message.Builder<SubscribeWsStatusResponse, Builder> {
        public Integer channelId;
        public Integer channelType;
        public Integer connectionState;
        public Boolean isConnected;

        public Builder() {
            this.channelType = 0;
            this.connectionState = 0;
            this.channelId = 0;
            this.isConnected = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channelId(Integer r5) {
            this.channelId = r5;
            return this;
        }

        public Builder channelType(Integer r5) {
            this.channelType = r5;
            return this;
        }

        public Builder connectionState(Integer r5) {
            this.connectionState = r5;
            return this;
        }

        public Builder isConnected(Boolean r5) {
            this.isConnected = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SubscribeWsStatusResponse build() {
            return new SubscribeWsStatusResponse(this.channelType, this.connectionState, this.channelId, this.isConnected, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SubscribeWsStatusResponse extends ProtoAdapter<SubscribeWsStatusResponse> {
        public ProtoAdapter_SubscribeWsStatusResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsStatusResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsStatusResponse decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, SubscribeWsStatusResponse r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsStatusResponse r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsStatusResponse redact(SubscribeWsStatusResponse r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeWsStatusResponse decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L18;
            if (r12 != 1) goto L8;
            r5.channelType(ProtoAdapter.INT32.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L10;
            r5.connectionState(ProtoAdapter.INT32.decode(r10));
            goto L3
        L10:
            if (r12 != 3) goto L12;
            r5.channelId(ProtoAdapter.INT32.decode(r10));
            goto L3
        L12:
            if (r12 != 4) goto L13;
            r5.isConnected(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L13:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L18:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, SubscribeWsStatusResponse r10) throws IOException {
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            r11.encodeWithTag(r5, 1, r10.channelType);
            r11.encodeWithTag(r5, 2, r10.connectionState);
            r11.encodeWithTag(r5, 3, r10.channelId);
            ProtoAdapter.BOOL.encodeWithTag(r5, 4, r10.isConnected);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SubscribeWsStatusResponse r5) {
            ProtoAdapter<Integer> r10 = ProtoAdapter.INT32;
            int r11 = r10.encodedSizeWithTag(1, r5.channelType);
            int r12 = r10.encodedSizeWithTag(2, r5.connectionState) + r11;
            int r13 = r10.encodedSizeWithTag(3, r5.channelId) + r12;
            int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r5.isConnected) + r13;
            return r5.unknownFields().size() + r14;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SubscribeWsStatusResponse redact2(SubscribeWsStatusResponse r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsStatusResponse();
        DEFAULT_CHANNELTYPE = 0;
        DEFAULT_CONNECTIONSTATE = 0;
        DEFAULT_CHANNELID = 0;
        DEFAULT_ISCONNECTED = Boolean.FALSE;
    }

    public SubscribeWsStatusResponse(Integer r10, Integer r11, Integer r12, Boolean r13) {
        this(r10, r11, r12, r13, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsStatusResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsStatusResponse r10 = (SubscribeWsStatusResponse) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L20;
        if (Internal.equals(this.channelType, r10.channelType) == false) goto L20;
        if (Internal.equals(this.connectionState, r10.connectionState) == false) goto L20;
        if (Internal.equals(this.channelId, r10.channelId) == false) goto L20;
        if (Internal.equals(this.isConnected, r10.isConnected) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L21;
        int r10 = unknownFields().hashCode() * 37;
        Integer r11 = this.channelType;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Integer r15 = this.connectionState;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        Integer r18 = this.channelId;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        Boolean r21 = this.isConnected;
        if (r21 == null) goto L19;
        r12 = r21.hashCode();
    L19:
        int r22 = r20 + r12;
        this.hashCode = r22;
        return r22;
    L15:
        r19 = 0;
        goto L16
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L21:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.channelType == null) goto L6;
        r5.append(", channelType=");
        r5.append(this.channelType);
    L6:
        if (this.connectionState == null) goto L9;
        r5.append(", connectionState=");
        r5.append(this.connectionState);
    L9:
        if (this.channelId == null) goto L12;
        r5.append(", channelId=");
        r5.append(this.channelId);
    L12:
        if (this.isConnected == null) goto L15;
        r5.append(", isConnected=");
        r5.append(this.isConnected);
    L15:
        return a.s(r5, 0, 2, "SubscribeWsStatusResponse{", '}');
    }

    public SubscribeWsStatusResponse(Integer r5, Integer r10, Integer r11, Boolean r12, ByteString r13) {
        super(ADAPTER, r13);
        this.channelType = r5;
        this.connectionState = r10;
        this.channelId = r11;
        this.isConnected = r12;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.channelType = this.channelType;
        r5.connectionState = this.connectionState;
        r5.channelId = this.channelId;
        r5.isConnected = this.isConnected;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
