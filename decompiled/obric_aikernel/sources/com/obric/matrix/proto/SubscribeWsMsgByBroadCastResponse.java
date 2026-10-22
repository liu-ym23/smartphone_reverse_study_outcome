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
public final class SubscribeWsMsgByBroadCastResponse extends Message<SubscribeWsMsgByBroadCastResponse, a> {
    public static final ProtoAdapter<SubscribeWsMsgByBroadCastResponse> ADAPTER = null;
    public static final Boolean DEFAULT_SUBSCRIBERESULT = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    @c("subscribeResult")
    public final Boolean subscribeResult;

    public static final class a extends Message.Builder<SubscribeWsMsgByBroadCastResponse, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f6108a;

        public a() {
            this.f6108a = Boolean.FALSE;
        }

        public SubscribeWsMsgByBroadCastResponse a() {
            return new SubscribeWsMsgByBroadCastResponse(this.f6108a, super.buildUnknownFields());
        }

        public a b(Boolean r10) {
            this.f6108a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<SubscribeWsMsgByBroadCastResponse> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByBroadCastResponse.class);
        }

        public SubscribeWsMsgByBroadCastResponse a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L9;
            if (r13 != 1) goto L7;
            r11.b(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L7:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L9:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, SubscribeWsMsgByBroadCastResponse r11) {
            ProtoAdapter.BOOL.encodeWithTag(r10, 1, r11.subscribeResult);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(SubscribeWsMsgByBroadCastResponse r10) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r10.subscribeResult) + r10.unknownFields().size();
        }

        public SubscribeWsMsgByBroadCastResponse d(SubscribeWsMsgByBroadCastResponse r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByBroadCastResponse decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, SubscribeWsMsgByBroadCastResponse r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsMsgByBroadCastResponse r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByBroadCastResponse redact(SubscribeWsMsgByBroadCastResponse r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SUBSCRIBERESULT = Boolean.FALSE;
    }

    public SubscribeWsMsgByBroadCastResponse(Boolean r10) {
        this(r10, ByteString.EMPTY);
    }

    public SubscribeWsMsgByBroadCastResponse(Boolean r10, ByteString r11) {
        super(ADAPTER, r11);
        this.subscribeResult = r10;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SubscribeWsMsgByBroadCastResponse) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByBroadCastResponse r11 = (SubscribeWsMsgByBroadCastResponse) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L14;
        if (Internal.equals(this.subscribeResult, r11.subscribeResult) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L10;
        int r11 = unknownFields().hashCode() * 37;
        Boolean r12 = this.subscribeResult;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = r11 + r13;
        this.hashCode = r14;
        return r14;
    L7:
        r13 = 0;
        goto L8
    L10:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f6108a = this.subscribeResult;
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
        if (this.subscribeResult == null) goto L5;
        r10.append(", subscribeResult=");
        r10.append(this.subscribeResult);
    L5:
        StringBuilder r11 = r10.replace(0, 2, "SubscribeWsMsgByBroadCastResponse{");
        r11.append('}');
        return r11.toString();
    }
}
