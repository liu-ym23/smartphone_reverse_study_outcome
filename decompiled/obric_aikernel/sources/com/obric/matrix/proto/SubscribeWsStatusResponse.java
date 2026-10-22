package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import d6.c;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class SubscribeWsStatusResponse extends Message<SubscribeWsStatusResponse, a> {
    public static final ProtoAdapter<SubscribeWsStatusResponse> ADAPTER = null;
    public static final Integer DEFAULT_CHANNELID = null;
    public static final Integer DEFAULT_CHANNELTYPE = null;
    public static final Integer DEFAULT_CONNECTIONSTATE = null;
    public static final Boolean DEFAULT_ISCONNECTED = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @c("channelId")
    public final Integer channelId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @c("channelType")
    public final Integer channelType;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @c("connectionState")
    public final Integer connectionState;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    @c("isConnected")
    public final Boolean isConnected;

    public static final class a extends Message.Builder<SubscribeWsStatusResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f6127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f6128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f6129c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Boolean f6130d;

        public a() {
            this.f6127a = 0;
            this.f6128b = 0;
            this.f6129c = 0;
            this.f6130d = Boolean.FALSE;
        }

        public SubscribeWsStatusResponse a() {
            return new SubscribeWsStatusResponse(this.f6127a, this.f6128b, this.f6129c, this.f6130d, super.buildUnknownFields());
        }

        public a b(Integer r10) {
            this.f6129c = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r10) {
            this.f6127a = r10;
            return this;
        }

        public a d(Integer r10) {
            this.f6128b = r10;
            return this;
        }

        public a e(Boolean r10) {
            this.f6130d = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<SubscribeWsStatusResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsStatusResponse.class);
        }

        public SubscribeWsStatusResponse a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L18;
            if (r13 != 1) goto L8;
            r11.c(ProtoAdapter.INT32.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L10;
            r11.d(ProtoAdapter.INT32.decode(r10));
            goto L3
        L10:
            if (r13 != 3) goto L12;
            r11.b(ProtoAdapter.INT32.decode(r10));
            goto L3
        L12:
            if (r13 != 4) goto L13;
            r11.e(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L13:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L18:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, SubscribeWsStatusResponse r11) {
            ProtoAdapter<Integer> r12 = ProtoAdapter.INT32;
            r12.encodeWithTag(r10, 1, r11.channelType);
            r12.encodeWithTag(r10, 2, r11.connectionState);
            r12.encodeWithTag(r10, 3, r11.channelId);
            ProtoAdapter.BOOL.encodeWithTag(r10, 4, r11.isConnected);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(SubscribeWsStatusResponse r10) {
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            return (((r11.encodedSizeWithTag(1, r10.channelType) + r11.encodedSizeWithTag(2, r10.connectionState)) + r11.encodedSizeWithTag(3, r10.channelId)) + ProtoAdapter.BOOL.encodedSizeWithTag(4, r10.isConnected)) + r10.unknownFields().size();
        }

        public SubscribeWsStatusResponse d(SubscribeWsStatusResponse r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsStatusResponse decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, SubscribeWsStatusResponse r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsStatusResponse r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsStatusResponse redact(SubscribeWsStatusResponse r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_CHANNELTYPE = 0;
        DEFAULT_CONNECTIONSTATE = 0;
        DEFAULT_CHANNELID = 0;
        DEFAULT_ISCONNECTED = Boolean.FALSE;
    }

    public SubscribeWsStatusResponse(Integer r10, Integer r11, Integer r12, Boolean r13) {
        this(r10, r11, r12, r13, ByteString.EMPTY);
    }

    public SubscribeWsStatusResponse(Integer r10, Integer r11, Integer r12, Boolean r13, ByteString r14) {
        super(ADAPTER, r14);
        this.channelType = r10;
        this.connectionState = r11;
        this.channelId = r12;
        this.isConnected = r13;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SubscribeWsStatusResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsStatusResponse r11 = (SubscribeWsStatusResponse) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L20;
        if (Internal.equals(this.channelType, r11.channelType) == false) goto L20;
        if (Internal.equals(this.connectionState, r11.connectionState) == false) goto L20;
        if (Internal.equals(this.channelId, r11.channelId) == false) goto L20;
        if (Internal.equals(this.isConnected, r11.isConnected) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L21;
        int r11 = unknownFields().hashCode() * 37;
        Integer r12 = this.channelType;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Integer r16 = this.connectionState;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        Integer r19 = this.channelId;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (r18 + r20) * 37;
        Boolean r22 = this.isConnected;
        if (r22 == null) goto L19;
        r13 = r22.hashCode();
    L19:
        int r23 = r21 + r13;
        this.hashCode = r23;
        return r23;
    L15:
        r20 = 0;
        goto L16
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L21:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f6127a = this.channelType;
        r10.f6128b = this.connectionState;
        r10.f6129c = this.channelId;
        r10.f6130d = this.isConnected;
        r10.addUnknownFields(unknownFields());
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.channelType == null) goto L6;
        r10.append(", channelType=");
        r10.append(this.channelType);
    L6:
        if (this.connectionState == null) goto L9;
        r10.append(", connectionState=");
        r10.append(this.connectionState);
    L9:
        if (this.channelId == null) goto L12;
        r10.append(", channelId=");
        r10.append(this.channelId);
    L12:
        if (this.isConnected == null) goto L14;
        r10.append(", isConnected=");
        r10.append(this.isConnected);
    L14:
        StringBuilder r11 = r10.replace(0, 2, "SubscribeWsStatusResponse{");
        r11.append('}');
        return r11.toString();
    }
}
