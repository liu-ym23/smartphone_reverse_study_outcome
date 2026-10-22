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
public final class RequestBody extends Message<RequestBody, Builder> {
    public static final ProtoAdapter<RequestBody> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("bizExampleRequest")
    @WireField(adapter = "com.obric.matrix.proto.BizExampleRequest#ADAPTER", tag = 100000)
    public final BizExampleRequest bizExampleRequest;

    @SerializedName("decodeLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.DecodeLocationRequest#ADAPTER", tag = 102003)
    public final DecodeLocationRequest decodeLocationRequest;

    @SerializedName("genericNetworkRequest")
    @WireField(adapter = "com.obric.matrix.proto.GenericNetworkRequest#ADAPTER", tag = 112003)
    public final GenericNetworkRequest genericNetworkRequest;

    @SerializedName("getIntersectFencesRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetIntersectFencesRequest#ADAPTER", tag = 102004)
    public final GetIntersectFencesRequest getIntersectFencesRequest;

    @SerializedName("getLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetLocationRequest#ADAPTER", tag = 102001)
    public final GetLocationRequest getLocationRequest;

    @SerializedName("getTTNetParametersRequest")
    @WireField(adapter = "com.obric.matrix.proto.GetTTNetParametersRequest#ADAPTER", tag = 112004)
    public final GetTTNetParametersRequest getTTNetParametersRequest;

    @SerializedName("onePartyCommonNetworkRequest")
    @WireField(adapter = "com.obric.matrix.proto.OnePartyCommonNetworkRequest#ADAPTER", tag = 112001)
    public final OnePartyCommonNetworkRequest onePartyCommonNetworkRequest;

    @SerializedName("picoLinksCallback")
    @WireField(adapter = "com.obric.matrix.proto.PicoLinksCallback#ADAPTER", tag = 111002)
    public final PicoLinksCallback picoLinksCallback;

    @SerializedName("refreshLocationRequest")
    @WireField(adapter = "com.obric.matrix.proto.RefreshLocationRequest#ADAPTER", tag = 102002)
    public final RefreshLocationRequest refreshLocationRequest;

    @SerializedName("sendApplogEventRequest")
    @WireField(adapter = "com.obric.matrix.proto.SendApplogEventRequest#ADAPTER", tag = 112002)
    public final SendApplogEventRequest sendApplogEventRequest;

    @SerializedName("sendWsMessageRequest")
    @WireField(adapter = "com.obric.matrix.proto.SendWsMessageRequest#ADAPTER", tag = 101001)
    public final SendWsMessageRequest sendWsMessageRequest;

    @SerializedName("startPicoLinksRequest")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksRequest#ADAPTER", tag = 111001)
    public final StartPicoLinksRequest startPicoLinksRequest;

    @SerializedName("subscribeWsMsgByBroadCastRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByBroadCastRequest#ADAPTER", tag = 101006)
    public final SubscribeWsMsgByBroadCastRequest subscribeWsMsgByBroadCastRequest;

    @SerializedName("subscribeWsMsgByCallBackRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByCallBackRequest#ADAPTER", tag = 101005)
    public final SubscribeWsMsgByCallBackRequest subscribeWsMsgByCallBackRequest;

    @SerializedName("subscribeWsMsgByProviderRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByProviderRequest#ADAPTER", tag = 101004)
    public final SubscribeWsMsgByProviderRequest subscribeWsMsgByProviderRequest;

    @SerializedName("subscribeWsMsgRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgRequest#ADAPTER", tag = 101002)
    public final SubscribeWsMsgRequest subscribeWsMsgRequest;

    @SerializedName("subscribeWsStatusRequest")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsStatusRequest#ADAPTER", tag = 101003)
    public final SubscribeWsStatusRequest subscribeWsStatusRequest;

    public static final class Builder extends Message.Builder<RequestBody, Builder> {
        public BizExampleRequest bizExampleRequest;
        public DecodeLocationRequest decodeLocationRequest;
        public GenericNetworkRequest genericNetworkRequest;
        public GetIntersectFencesRequest getIntersectFencesRequest;
        public GetLocationRequest getLocationRequest;
        public GetTTNetParametersRequest getTTNetParametersRequest;
        public OnePartyCommonNetworkRequest onePartyCommonNetworkRequest;
        public PicoLinksCallback picoLinksCallback;
        public RefreshLocationRequest refreshLocationRequest;
        public SendApplogEventRequest sendApplogEventRequest;
        public SendWsMessageRequest sendWsMessageRequest;
        public StartPicoLinksRequest startPicoLinksRequest;
        public SubscribeWsMsgByBroadCastRequest subscribeWsMsgByBroadCastRequest;
        public SubscribeWsMsgByCallBackRequest subscribeWsMsgByCallBackRequest;
        public SubscribeWsMsgByProviderRequest subscribeWsMsgByProviderRequest;
        public SubscribeWsMsgRequest subscribeWsMsgRequest;
        public SubscribeWsStatusRequest subscribeWsStatusRequest;

        public Builder() {
        }

        public Builder bizExampleRequest(BizExampleRequest r5) {
            this.bizExampleRequest = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder decodeLocationRequest(DecodeLocationRequest r5) {
            this.decodeLocationRequest = r5;
            return this;
        }

        public Builder genericNetworkRequest(GenericNetworkRequest r5) {
            this.genericNetworkRequest = r5;
            return this;
        }

        public Builder getIntersectFencesRequest(GetIntersectFencesRequest r5) {
            this.getIntersectFencesRequest = r5;
            return this;
        }

        public Builder getLocationRequest(GetLocationRequest r5) {
            this.getLocationRequest = r5;
            return this;
        }

        public Builder getTTNetParametersRequest(GetTTNetParametersRequest r5) {
            this.getTTNetParametersRequest = r5;
            return this;
        }

        public Builder onePartyCommonNetworkRequest(OnePartyCommonNetworkRequest r5) {
            this.onePartyCommonNetworkRequest = r5;
            return this;
        }

        public Builder picoLinksCallback(PicoLinksCallback r5) {
            this.picoLinksCallback = r5;
            return this;
        }

        public Builder refreshLocationRequest(RefreshLocationRequest r5) {
            this.refreshLocationRequest = r5;
            return this;
        }

        public Builder sendApplogEventRequest(SendApplogEventRequest r5) {
            this.sendApplogEventRequest = r5;
            return this;
        }

        public Builder sendWsMessageRequest(SendWsMessageRequest r5) {
            this.sendWsMessageRequest = r5;
            return this;
        }

        public Builder startPicoLinksRequest(StartPicoLinksRequest r5) {
            this.startPicoLinksRequest = r5;
            return this;
        }

        public Builder subscribeWsMsgByBroadCastRequest(SubscribeWsMsgByBroadCastRequest r5) {
            this.subscribeWsMsgByBroadCastRequest = r5;
            return this;
        }

        public Builder subscribeWsMsgByCallBackRequest(SubscribeWsMsgByCallBackRequest r5) {
            this.subscribeWsMsgByCallBackRequest = r5;
            return this;
        }

        public Builder subscribeWsMsgByProviderRequest(SubscribeWsMsgByProviderRequest r5) {
            this.subscribeWsMsgByProviderRequest = r5;
            return this;
        }

        public Builder subscribeWsMsgRequest(SubscribeWsMsgRequest r5) {
            this.subscribeWsMsgRequest = r5;
            return this;
        }

        public Builder subscribeWsStatusRequest(SubscribeWsStatusRequest r5) {
            this.subscribeWsStatusRequest = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public RequestBody build() {
            return new RequestBody(this.bizExampleRequest, this.sendWsMessageRequest, this.subscribeWsMsgRequest, this.subscribeWsStatusRequest, this.subscribeWsMsgByProviderRequest, this.subscribeWsMsgByCallBackRequest, this.subscribeWsMsgByBroadCastRequest, this.getLocationRequest, this.refreshLocationRequest, this.decodeLocationRequest, this.getIntersectFencesRequest, this.startPicoLinksRequest, this.picoLinksCallback, this.onePartyCommonNetworkRequest, this.sendApplogEventRequest, this.genericNetworkRequest, this.getTTNetParametersRequest, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_RequestBody extends ProtoAdapter<RequestBody> {
        public ProtoAdapter_RequestBody() {
            super(FieldEncoding.LENGTH_DELIMITED, RequestBody.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RequestBody decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, RequestBody r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RequestBody r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RequestBody redact(RequestBody r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RequestBody decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L29;
            if (r12 != 100000) goto L7;
            r5.bizExampleRequest(BizExampleRequest.ADAPTER.decode(r10));
            goto L3
        L7:
            switch(r12) {
                case 101001: goto L27;
                case 101002: goto L26;
                case 101003: goto L25;
                case 101004: goto L24;
                case 101005: goto L23;
                case 101006: goto L22;
                default: goto L8;
            };
        L22:
            r5.subscribeWsMsgByBroadCastRequest(SubscribeWsMsgByBroadCastRequest.ADAPTER.decode(r10));
            goto L3
        L23:
            r5.subscribeWsMsgByCallBackRequest(SubscribeWsMsgByCallBackRequest.ADAPTER.decode(r10));
            goto L3
        L24:
            r5.subscribeWsMsgByProviderRequest(SubscribeWsMsgByProviderRequest.ADAPTER.decode(r10));
            goto L3
        L25:
            r5.subscribeWsStatusRequest(SubscribeWsStatusRequest.ADAPTER.decode(r10));
            goto L3
        L26:
            r5.subscribeWsMsgRequest(SubscribeWsMsgRequest.ADAPTER.decode(r10));
            goto L3
        L27:
            r5.sendWsMessageRequest(SendWsMessageRequest.ADAPTER.decode(r10));
            goto L3
        L8:
            switch(r12) {
                case 102001: goto L21;
                case 102002: goto L20;
                case 102003: goto L19;
                case 102004: goto L18;
                default: goto L9;
            };
        L18:
            r5.getIntersectFencesRequest(GetIntersectFencesRequest.ADAPTER.decode(r10));
            goto L3
        L19:
            r5.decodeLocationRequest(DecodeLocationRequest.ADAPTER.decode(r10));
            goto L3
        L20:
            r5.refreshLocationRequest(RefreshLocationRequest.ADAPTER.decode(r10));
            goto L3
        L21:
            r5.getLocationRequest(GetLocationRequest.ADAPTER.decode(r10));
            goto L3
        L9:
            switch(r12) {
                case 111001: goto L17;
                case 111002: goto L16;
                default: goto L10;
            };
        L16:
            r5.picoLinksCallback(PicoLinksCallback.ADAPTER.decode(r10));
            goto L3
        L17:
            r5.startPicoLinksRequest(StartPicoLinksRequest.ADAPTER.decode(r10));
            goto L3
        L10:
            switch(r12) {
                case 112001: goto L15;
                case 112002: goto L14;
                case 112003: goto L13;
                case 112004: goto L12;
                default: goto L11;
            };
        L12:
            r5.getTTNetParametersRequest(GetTTNetParametersRequest.ADAPTER.decode(r10));
            goto L3
        L13:
            r5.genericNetworkRequest(GenericNetworkRequest.ADAPTER.decode(r10));
            goto L3
        L14:
            r5.sendApplogEventRequest(SendApplogEventRequest.ADAPTER.decode(r10));
            goto L3
        L15:
            r5.onePartyCommonNetworkRequest(OnePartyCommonNetworkRequest.ADAPTER.decode(r10));
            goto L3
        L11:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L29:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, RequestBody r10) throws IOException {
            BizExampleRequest.ADAPTER.encodeWithTag(r5, 100000, r10.bizExampleRequest);
            SendWsMessageRequest.ADAPTER.encodeWithTag(r5, 101001, r10.sendWsMessageRequest);
            SubscribeWsMsgRequest.ADAPTER.encodeWithTag(r5, 101002, r10.subscribeWsMsgRequest);
            SubscribeWsStatusRequest.ADAPTER.encodeWithTag(r5, 101003, r10.subscribeWsStatusRequest);
            SubscribeWsMsgByProviderRequest.ADAPTER.encodeWithTag(r5, 101004, r10.subscribeWsMsgByProviderRequest);
            SubscribeWsMsgByCallBackRequest.ADAPTER.encodeWithTag(r5, 101005, r10.subscribeWsMsgByCallBackRequest);
            SubscribeWsMsgByBroadCastRequest.ADAPTER.encodeWithTag(r5, 101006, r10.subscribeWsMsgByBroadCastRequest);
            GetLocationRequest.ADAPTER.encodeWithTag(r5, 102001, r10.getLocationRequest);
            RefreshLocationRequest.ADAPTER.encodeWithTag(r5, 102002, r10.refreshLocationRequest);
            DecodeLocationRequest.ADAPTER.encodeWithTag(r5, 102003, r10.decodeLocationRequest);
            GetIntersectFencesRequest.ADAPTER.encodeWithTag(r5, 102004, r10.getIntersectFencesRequest);
            StartPicoLinksRequest.ADAPTER.encodeWithTag(r5, 111001, r10.startPicoLinksRequest);
            PicoLinksCallback.ADAPTER.encodeWithTag(r5, 111002, r10.picoLinksCallback);
            OnePartyCommonNetworkRequest.ADAPTER.encodeWithTag(r5, 112001, r10.onePartyCommonNetworkRequest);
            SendApplogEventRequest.ADAPTER.encodeWithTag(r5, 112002, r10.sendApplogEventRequest);
            GenericNetworkRequest.ADAPTER.encodeWithTag(r5, 112003, r10.genericNetworkRequest);
            GetTTNetParametersRequest.ADAPTER.encodeWithTag(r5, 112004, r10.getTTNetParametersRequest);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RequestBody r5) {
            int r10 = BizExampleRequest.ADAPTER.encodedSizeWithTag(100000, r5.bizExampleRequest);
            int r11 = SendWsMessageRequest.ADAPTER.encodedSizeWithTag(101001, r5.sendWsMessageRequest) + r10;
            int r12 = SubscribeWsMsgRequest.ADAPTER.encodedSizeWithTag(101002, r5.subscribeWsMsgRequest) + r11;
            int r13 = SubscribeWsStatusRequest.ADAPTER.encodedSizeWithTag(101003, r5.subscribeWsStatusRequest) + r12;
            int r14 = SubscribeWsMsgByProviderRequest.ADAPTER.encodedSizeWithTag(101004, r5.subscribeWsMsgByProviderRequest) + r13;
            int r15 = SubscribeWsMsgByCallBackRequest.ADAPTER.encodedSizeWithTag(101005, r5.subscribeWsMsgByCallBackRequest) + r14;
            int r16 = SubscribeWsMsgByBroadCastRequest.ADAPTER.encodedSizeWithTag(101006, r5.subscribeWsMsgByBroadCastRequest) + r15;
            int r17 = GetLocationRequest.ADAPTER.encodedSizeWithTag(102001, r5.getLocationRequest) + r16;
            int r18 = RefreshLocationRequest.ADAPTER.encodedSizeWithTag(102002, r5.refreshLocationRequest) + r17;
            int r19 = DecodeLocationRequest.ADAPTER.encodedSizeWithTag(102003, r5.decodeLocationRequest) + r18;
            int r20 = GetIntersectFencesRequest.ADAPTER.encodedSizeWithTag(102004, r5.getIntersectFencesRequest) + r19;
            int r21 = StartPicoLinksRequest.ADAPTER.encodedSizeWithTag(111001, r5.startPicoLinksRequest) + r20;
            int r22 = PicoLinksCallback.ADAPTER.encodedSizeWithTag(111002, r5.picoLinksCallback) + r21;
            int r23 = OnePartyCommonNetworkRequest.ADAPTER.encodedSizeWithTag(112001, r5.onePartyCommonNetworkRequest) + r22;
            int r24 = SendApplogEventRequest.ADAPTER.encodedSizeWithTag(112002, r5.sendApplogEventRequest) + r23;
            int r25 = GenericNetworkRequest.ADAPTER.encodedSizeWithTag(112003, r5.genericNetworkRequest) + r24;
            int r26 = GetTTNetParametersRequest.ADAPTER.encodedSizeWithTag(112004, r5.getTTNetParametersRequest) + r25;
            return r5.unknownFields().size() + r26;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public RequestBody redact2(RequestBody r5) {
            Builder r10 = r5.newBuilder();
            BizExampleRequest r11 = r10.bizExampleRequest;
            if (r11 == null) goto L5;
            r10.bizExampleRequest = BizExampleRequest.ADAPTER.redact(r11);
        L5:
            SendWsMessageRequest r12 = r10.sendWsMessageRequest;
            if (r12 == null) goto L8;
            r10.sendWsMessageRequest = SendWsMessageRequest.ADAPTER.redact(r12);
        L8:
            SubscribeWsMsgRequest r13 = r10.subscribeWsMsgRequest;
            if (r13 == null) goto L11;
            r10.subscribeWsMsgRequest = SubscribeWsMsgRequest.ADAPTER.redact(r13);
        L11:
            SubscribeWsStatusRequest r14 = r10.subscribeWsStatusRequest;
            if (r14 == null) goto L14;
            r10.subscribeWsStatusRequest = SubscribeWsStatusRequest.ADAPTER.redact(r14);
        L14:
            SubscribeWsMsgByProviderRequest r15 = r10.subscribeWsMsgByProviderRequest;
            if (r15 == null) goto L17;
            r10.subscribeWsMsgByProviderRequest = SubscribeWsMsgByProviderRequest.ADAPTER.redact(r15);
        L17:
            SubscribeWsMsgByCallBackRequest r16 = r10.subscribeWsMsgByCallBackRequest;
            if (r16 == null) goto L20;
            r10.subscribeWsMsgByCallBackRequest = SubscribeWsMsgByCallBackRequest.ADAPTER.redact(r16);
        L20:
            SubscribeWsMsgByBroadCastRequest r17 = r10.subscribeWsMsgByBroadCastRequest;
            if (r17 == null) goto L23;
            r10.subscribeWsMsgByBroadCastRequest = SubscribeWsMsgByBroadCastRequest.ADAPTER.redact(r17);
        L23:
            GetLocationRequest r18 = r10.getLocationRequest;
            if (r18 == null) goto L26;
            r10.getLocationRequest = GetLocationRequest.ADAPTER.redact(r18);
        L26:
            RefreshLocationRequest r19 = r10.refreshLocationRequest;
            if (r19 == null) goto L29;
            r10.refreshLocationRequest = RefreshLocationRequest.ADAPTER.redact(r19);
        L29:
            DecodeLocationRequest r20 = r10.decodeLocationRequest;
            if (r20 == null) goto L32;
            r10.decodeLocationRequest = DecodeLocationRequest.ADAPTER.redact(r20);
        L32:
            GetIntersectFencesRequest r21 = r10.getIntersectFencesRequest;
            if (r21 == null) goto L35;
            r10.getIntersectFencesRequest = GetIntersectFencesRequest.ADAPTER.redact(r21);
        L35:
            StartPicoLinksRequest r22 = r10.startPicoLinksRequest;
            if (r22 == null) goto L38;
            r10.startPicoLinksRequest = StartPicoLinksRequest.ADAPTER.redact(r22);
        L38:
            PicoLinksCallback r23 = r10.picoLinksCallback;
            if (r23 == null) goto L41;
            r10.picoLinksCallback = PicoLinksCallback.ADAPTER.redact(r23);
        L41:
            OnePartyCommonNetworkRequest r24 = r10.onePartyCommonNetworkRequest;
            if (r24 == null) goto L44;
            r10.onePartyCommonNetworkRequest = OnePartyCommonNetworkRequest.ADAPTER.redact(r24);
        L44:
            SendApplogEventRequest r25 = r10.sendApplogEventRequest;
            if (r25 == null) goto L47;
            r10.sendApplogEventRequest = SendApplogEventRequest.ADAPTER.redact(r25);
        L47:
            GenericNetworkRequest r26 = r10.genericNetworkRequest;
            if (r26 == null) goto L50;
            r10.genericNetworkRequest = GenericNetworkRequest.ADAPTER.redact(r26);
        L50:
            GetTTNetParametersRequest r27 = r10.getTTNetParametersRequest;
            if (r27 == null) goto L53;
            r10.getTTNetParametersRequest = GetTTNetParametersRequest.ADAPTER.redact(r27);
        L53:
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RequestBody();
    }

    public RequestBody(BizExampleRequest r20, SendWsMessageRequest r21, SubscribeWsMsgRequest r22, SubscribeWsStatusRequest r23, SubscribeWsMsgByProviderRequest r24, SubscribeWsMsgByCallBackRequest r25, SubscribeWsMsgByBroadCastRequest r26, GetLocationRequest r27, RefreshLocationRequest r28, DecodeLocationRequest r29, GetIntersectFencesRequest r30, StartPicoLinksRequest r31, PicoLinksCallback r32, OnePartyCommonNetworkRequest r33, SendApplogEventRequest r34, GenericNetworkRequest r35, GetTTNetParametersRequest r36) {
        this(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof RequestBody) == true) goto L8;
        return false;
    L8:
        RequestBody r10 = (RequestBody) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L46;
        if (Internal.equals(this.bizExampleRequest, r10.bizExampleRequest) == false) goto L46;
        if (Internal.equals(this.sendWsMessageRequest, r10.sendWsMessageRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgRequest, r10.subscribeWsMsgRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsStatusRequest, r10.subscribeWsStatusRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgByProviderRequest, r10.subscribeWsMsgByProviderRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgByCallBackRequest, r10.subscribeWsMsgByCallBackRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgByBroadCastRequest, r10.subscribeWsMsgByBroadCastRequest) == false) goto L46;
        if (Internal.equals(this.getLocationRequest, r10.getLocationRequest) == false) goto L46;
        if (Internal.equals(this.refreshLocationRequest, r10.refreshLocationRequest) == false) goto L46;
        if (Internal.equals(this.decodeLocationRequest, r10.decodeLocationRequest) == false) goto L46;
        if (Internal.equals(this.getIntersectFencesRequest, r10.getIntersectFencesRequest) == false) goto L46;
        if (Internal.equals(this.startPicoLinksRequest, r10.startPicoLinksRequest) == false) goto L46;
        if (Internal.equals(this.picoLinksCallback, r10.picoLinksCallback) == false) goto L46;
        if (Internal.equals(this.onePartyCommonNetworkRequest, r10.onePartyCommonNetworkRequest) == false) goto L46;
        if (Internal.equals(this.sendApplogEventRequest, r10.sendApplogEventRequest) == false) goto L46;
        if (Internal.equals(this.genericNetworkRequest, r10.genericNetworkRequest) == false) goto L46;
        if (Internal.equals(this.getTTNetParametersRequest, r10.getTTNetParametersRequest) == false) goto L46;
        return true;
    L46:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L73;
        int r10 = unknownFields().hashCode() * 37;
        BizExampleRequest r11 = this.bizExampleRequest;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        SendWsMessageRequest r15 = this.sendWsMessageRequest;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        SubscribeWsMsgRequest r18 = this.subscribeWsMsgRequest;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        SubscribeWsStatusRequest r21 = this.subscribeWsStatusRequest;
        if (r21 == null) goto L19;
        int r22 = r21.hashCode();
    L20:
        int r23 = (r20 + r22) * 37;
        SubscribeWsMsgByProviderRequest r24 = this.subscribeWsMsgByProviderRequest;
        if (r24 == null) goto L23;
        int r25 = r24.hashCode();
    L24:
        int r26 = (r23 + r25) * 37;
        SubscribeWsMsgByCallBackRequest r27 = this.subscribeWsMsgByCallBackRequest;
        if (r27 == null) goto L27;
        int r28 = r27.hashCode();
    L28:
        int r29 = (r26 + r28) * 37;
        SubscribeWsMsgByBroadCastRequest r30 = this.subscribeWsMsgByBroadCastRequest;
        if (r30 == null) goto L31;
        int r31 = r30.hashCode();
    L32:
        int r32 = (r29 + r31) * 37;
        GetLocationRequest r33 = this.getLocationRequest;
        if (r33 == null) goto L35;
        int r34 = r33.hashCode();
    L36:
        int r35 = (r32 + r34) * 37;
        RefreshLocationRequest r36 = this.refreshLocationRequest;
        if (r36 == null) goto L39;
        int r37 = r36.hashCode();
    L40:
        int r38 = (r35 + r37) * 37;
        DecodeLocationRequest r39 = this.decodeLocationRequest;
        if (r39 == null) goto L43;
        int r40 = r39.hashCode();
    L44:
        int r41 = (r38 + r40) * 37;
        GetIntersectFencesRequest r42 = this.getIntersectFencesRequest;
        if (r42 == null) goto L47;
        int r43 = r42.hashCode();
    L48:
        int r44 = (r41 + r43) * 37;
        StartPicoLinksRequest r45 = this.startPicoLinksRequest;
        if (r45 == null) goto L51;
        int r46 = r45.hashCode();
    L52:
        int r47 = (r44 + r46) * 37;
        PicoLinksCallback r48 = this.picoLinksCallback;
        if (r48 == null) goto L55;
        int r49 = r48.hashCode();
    L56:
        int r50 = (r47 + r49) * 37;
        OnePartyCommonNetworkRequest r51 = this.onePartyCommonNetworkRequest;
        if (r51 == null) goto L59;
        int r52 = r51.hashCode();
    L60:
        int r53 = (r50 + r52) * 37;
        SendApplogEventRequest r54 = this.sendApplogEventRequest;
        if (r54 == null) goto L63;
        int r55 = r54.hashCode();
    L64:
        int r56 = (r53 + r55) * 37;
        GenericNetworkRequest r57 = this.genericNetworkRequest;
        if (r57 == null) goto L67;
        int r58 = r57.hashCode();
    L68:
        int r59 = (r56 + r58) * 37;
        GetTTNetParametersRequest r60 = this.getTTNetParametersRequest;
        if (r60 == null) goto L71;
        r12 = r60.hashCode();
    L71:
        int r61 = r59 + r12;
        this.hashCode = r61;
        return r61;
    L67:
        r58 = 0;
        goto L68
    L63:
        r55 = 0;
        goto L64
    L59:
        r52 = 0;
        goto L60
    L55:
        r49 = 0;
        goto L56
    L51:
        r46 = 0;
        goto L52
    L47:
        r43 = 0;
        goto L48
    L43:
        r40 = 0;
        goto L44
    L39:
        r37 = 0;
        goto L40
    L35:
        r34 = 0;
        goto L36
    L31:
        r31 = 0;
        goto L32
    L27:
        r28 = 0;
        goto L28
    L23:
        r25 = 0;
        goto L24
    L19:
        r22 = 0;
        goto L20
    L15:
        r19 = 0;
        goto L16
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L73:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.bizExampleRequest == null) goto L6;
        r5.append(", bizExampleRequest=");
        r5.append(this.bizExampleRequest);
    L6:
        if (this.sendWsMessageRequest == null) goto L9;
        r5.append(", sendWsMessageRequest=");
        r5.append(this.sendWsMessageRequest);
    L9:
        if (this.subscribeWsMsgRequest == null) goto L12;
        r5.append(", subscribeWsMsgRequest=");
        r5.append(this.subscribeWsMsgRequest);
    L12:
        if (this.subscribeWsStatusRequest == null) goto L15;
        r5.append(", subscribeWsStatusRequest=");
        r5.append(this.subscribeWsStatusRequest);
    L15:
        if (this.subscribeWsMsgByProviderRequest == null) goto L18;
        r5.append(", subscribeWsMsgByProviderRequest=");
        r5.append(this.subscribeWsMsgByProviderRequest);
    L18:
        if (this.subscribeWsMsgByCallBackRequest == null) goto L21;
        r5.append(", subscribeWsMsgByCallBackRequest=");
        r5.append(this.subscribeWsMsgByCallBackRequest);
    L21:
        if (this.subscribeWsMsgByBroadCastRequest == null) goto L24;
        r5.append(", subscribeWsMsgByBroadCastRequest=");
        r5.append(this.subscribeWsMsgByBroadCastRequest);
    L24:
        if (this.getLocationRequest == null) goto L27;
        r5.append(", getLocationRequest=");
        r5.append(this.getLocationRequest);
    L27:
        if (this.refreshLocationRequest == null) goto L30;
        r5.append(", refreshLocationRequest=");
        r5.append(this.refreshLocationRequest);
    L30:
        if (this.decodeLocationRequest == null) goto L33;
        r5.append(", decodeLocationRequest=");
        r5.append(this.decodeLocationRequest);
    L33:
        if (this.getIntersectFencesRequest == null) goto L36;
        r5.append(", getIntersectFencesRequest=");
        r5.append(this.getIntersectFencesRequest);
    L36:
        if (this.startPicoLinksRequest == null) goto L39;
        r5.append(", startPicoLinksRequest=");
        r5.append(this.startPicoLinksRequest);
    L39:
        if (this.picoLinksCallback == null) goto L42;
        r5.append(", picoLinksCallback=");
        r5.append(this.picoLinksCallback);
    L42:
        if (this.onePartyCommonNetworkRequest == null) goto L45;
        r5.append(", onePartyCommonNetworkRequest=");
        r5.append(this.onePartyCommonNetworkRequest);
    L45:
        if (this.sendApplogEventRequest == null) goto L48;
        r5.append(", sendApplogEventRequest=");
        r5.append(this.sendApplogEventRequest);
    L48:
        if (this.genericNetworkRequest == null) goto L51;
        r5.append(", genericNetworkRequest=");
        r5.append(this.genericNetworkRequest);
    L51:
        if (this.getTTNetParametersRequest == null) goto L54;
        r5.append(", getTTNetParametersRequest=");
        r5.append(this.getTTNetParametersRequest);
    L54:
        return a.s(r5, 0, 2, "RequestBody{", '}');
    }

    public RequestBody(BizExampleRequest r5, SendWsMessageRequest r10, SubscribeWsMsgRequest r11, SubscribeWsStatusRequest r12, SubscribeWsMsgByProviderRequest r13, SubscribeWsMsgByCallBackRequest r14, SubscribeWsMsgByBroadCastRequest r15, GetLocationRequest r16, RefreshLocationRequest r17, DecodeLocationRequest r18, GetIntersectFencesRequest r19, StartPicoLinksRequest r110, PicoLinksCallback r111, OnePartyCommonNetworkRequest r112, SendApplogEventRequest r113, GenericNetworkRequest r114, GetTTNetParametersRequest r20, ByteString r21) {
        super(ADAPTER, r21);
        this.bizExampleRequest = r5;
        this.sendWsMessageRequest = r10;
        this.subscribeWsMsgRequest = r11;
        this.subscribeWsStatusRequest = r12;
        this.subscribeWsMsgByProviderRequest = r13;
        this.subscribeWsMsgByCallBackRequest = r14;
        this.subscribeWsMsgByBroadCastRequest = r15;
        this.getLocationRequest = r16;
        this.refreshLocationRequest = r17;
        this.decodeLocationRequest = r18;
        this.getIntersectFencesRequest = r19;
        this.startPicoLinksRequest = r110;
        this.picoLinksCallback = r111;
        this.onePartyCommonNetworkRequest = r112;
        this.sendApplogEventRequest = r113;
        this.genericNetworkRequest = r114;
        this.getTTNetParametersRequest = r20;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.bizExampleRequest = this.bizExampleRequest;
        r5.sendWsMessageRequest = this.sendWsMessageRequest;
        r5.subscribeWsMsgRequest = this.subscribeWsMsgRequest;
        r5.subscribeWsStatusRequest = this.subscribeWsStatusRequest;
        r5.subscribeWsMsgByProviderRequest = this.subscribeWsMsgByProviderRequest;
        r5.subscribeWsMsgByCallBackRequest = this.subscribeWsMsgByCallBackRequest;
        r5.subscribeWsMsgByBroadCastRequest = this.subscribeWsMsgByBroadCastRequest;
        r5.getLocationRequest = this.getLocationRequest;
        r5.refreshLocationRequest = this.refreshLocationRequest;
        r5.decodeLocationRequest = this.decodeLocationRequest;
        r5.getIntersectFencesRequest = this.getIntersectFencesRequest;
        r5.startPicoLinksRequest = this.startPicoLinksRequest;
        r5.picoLinksCallback = this.picoLinksCallback;
        r5.onePartyCommonNetworkRequest = this.onePartyCommonNetworkRequest;
        r5.sendApplogEventRequest = this.sendApplogEventRequest;
        r5.genericNetworkRequest = this.genericNetworkRequest;
        r5.getTTNetParametersRequest = this.getTTNetParametersRequest;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
