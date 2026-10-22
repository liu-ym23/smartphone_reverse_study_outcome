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

        public SubscribeWsStatusResponse build() {
            return new SubscribeWsStatusResponse(this.channelType, this.connectionState, this.channelId, this.isConnected, super.buildUnknownFields());
        }

        public Builder() {
            this.channelType = 0;
            this.connectionState = 0;
            this.channelId = 0;
            this.isConnected = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m224build() {
            return build();
        }

        public Builder channelId(Integer r1) {
            this.channelId = r1;
            return this;
        }

        public Builder channelType(Integer r1) {
            this.channelType = r1;
            return this;
        }

        public Builder connectionState(Integer r1) {
            this.connectionState = r1;
            return this;
        }

        public Builder isConnected(Boolean r1) {
            this.isConnected = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeWsStatusResponse extends ProtoAdapter<SubscribeWsStatusResponse> {
        public ProtoAdapter_SubscribeWsStatusResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsStatusResponse.class);
        }

        public SubscribeWsStatusResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.channelType((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.connectionState((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.channelId((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.isConnected((Boolean) ProtoAdapter.BOOL.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SubscribeWsStatusResponse r5) {
            ProtoAdapter r0 = ProtoAdapter.INT32;
            return (((r0.encodedSizeWithTag(1, r5.channelType) + r0.encodedSizeWithTag(2, r5.connectionState)) + r0.encodedSizeWithTag(3, r5.channelId)) + ProtoAdapter.BOOL.encodedSizeWithTag(4, r5.isConnected)) + r5.unknownFields().size();
        }

        public SubscribeWsStatusResponse redact(SubscribeWsStatusResponse r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m225decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SubscribeWsStatusResponse) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SubscribeWsStatusResponse) r1);
        }

        public void encode(ProtoWriter r4, SubscribeWsStatusResponse r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT32;
            r0.encodeWithTag(r4, 1, r5.channelType);
            r0.encodeWithTag(r4, 2, r5.connectionState);
            r0.encodeWithTag(r4, 3, r5.channelId);
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r5.isConnected);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SubscribeWsStatusResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SubscribeWsStatusResponse();
        DEFAULT_CHANNELTYPE = 0;
        DEFAULT_CONNECTIONSTATE = 0;
        DEFAULT_CHANNELID = 0;
        DEFAULT_ISCONNECTED = Boolean.FALSE;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.channelType;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.connectionState;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.channelId;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Boolean r12 = this.isConnected;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
        ((Message) this).hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.channelType = this.channelType;
        r0.connectionState = this.connectionState;
        r0.channelId = this.channelId;
        r0.isConnected = this.isConnected;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.channelType == null) goto L6;
        r0.append(", channelType=");
        r0.append(this.channelType);
    L6:
        if (this.connectionState == null) goto L9;
        r0.append(", connectionState=");
        r0.append(this.connectionState);
    L9:
        if (this.channelId == null) goto L12;
        r0.append(", channelId=");
        r0.append(this.channelId);
    L12:
        if (this.isConnected == null) goto L14;
        r0.append(", isConnected=");
        r0.append(this.isConnected);
    L14:
        StringBuilder r1 = r0.replace(0, 2, "SubscribeWsStatusResponse{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m223newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SubscribeWsStatusResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsStatusResponse r6 = (SubscribeWsStatusResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (Internal.equals(this.channelType, r6.channelType) == false) goto L19;
        if (Internal.equals(this.connectionState, r6.connectionState) == false) goto L19;
        if (Internal.equals(this.channelId, r6.channelId) == false) goto L19;
        if (Internal.equals(this.isConnected, r6.isConnected) == false) goto L19;
        return true;
    }

    public SubscribeWsStatusResponse(Integer r7, Integer r8, Integer r9, Boolean r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public SubscribeWsStatusResponse(Integer r2, Integer r3, Integer r4, Boolean r5, ByteString r6) {
        super(ADAPTER, r6);
        this.channelType = r2;
        this.connectionState = r3;
        this.channelId = r4;
        this.isConnected = r5;
    }
}
