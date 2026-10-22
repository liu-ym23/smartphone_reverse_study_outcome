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

        public RequestBody build() {
            return new RequestBody(this.bizExampleRequest, this.sendWsMessageRequest, this.subscribeWsMsgRequest, this.subscribeWsStatusRequest, this.subscribeWsMsgByProviderRequest, this.subscribeWsMsgByCallBackRequest, this.subscribeWsMsgByBroadCastRequest, this.getLocationRequest, this.refreshLocationRequest, this.decodeLocationRequest, this.getIntersectFencesRequest, this.startPicoLinksRequest, this.picoLinksCallback, this.onePartyCommonNetworkRequest, this.sendApplogEventRequest, this.genericNetworkRequest, this.getTTNetParametersRequest, super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m152build() {
            return build();
        }

        public Builder bizExampleRequest(BizExampleRequest r1) {
            this.bizExampleRequest = r1;
            return this;
        }

        public Builder decodeLocationRequest(DecodeLocationRequest r1) {
            this.decodeLocationRequest = r1;
            return this;
        }

        public Builder genericNetworkRequest(GenericNetworkRequest r1) {
            this.genericNetworkRequest = r1;
            return this;
        }

        public Builder getIntersectFencesRequest(GetIntersectFencesRequest r1) {
            this.getIntersectFencesRequest = r1;
            return this;
        }

        public Builder getLocationRequest(GetLocationRequest r1) {
            this.getLocationRequest = r1;
            return this;
        }

        public Builder getTTNetParametersRequest(GetTTNetParametersRequest r1) {
            this.getTTNetParametersRequest = r1;
            return this;
        }

        public Builder onePartyCommonNetworkRequest(OnePartyCommonNetworkRequest r1) {
            this.onePartyCommonNetworkRequest = r1;
            return this;
        }

        public Builder picoLinksCallback(PicoLinksCallback r1) {
            this.picoLinksCallback = r1;
            return this;
        }

        public Builder refreshLocationRequest(RefreshLocationRequest r1) {
            this.refreshLocationRequest = r1;
            return this;
        }

        public Builder sendApplogEventRequest(SendApplogEventRequest r1) {
            this.sendApplogEventRequest = r1;
            return this;
        }

        public Builder sendWsMessageRequest(SendWsMessageRequest r1) {
            this.sendWsMessageRequest = r1;
            return this;
        }

        public Builder startPicoLinksRequest(StartPicoLinksRequest r1) {
            this.startPicoLinksRequest = r1;
            return this;
        }

        public Builder subscribeWsMsgByBroadCastRequest(SubscribeWsMsgByBroadCastRequest r1) {
            this.subscribeWsMsgByBroadCastRequest = r1;
            return this;
        }

        public Builder subscribeWsMsgByCallBackRequest(SubscribeWsMsgByCallBackRequest r1) {
            this.subscribeWsMsgByCallBackRequest = r1;
            return this;
        }

        public Builder subscribeWsMsgByProviderRequest(SubscribeWsMsgByProviderRequest r1) {
            this.subscribeWsMsgByProviderRequest = r1;
            return this;
        }

        public Builder subscribeWsMsgRequest(SubscribeWsMsgRequest r1) {
            this.subscribeWsMsgRequest = r1;
            return this;
        }

        public Builder subscribeWsStatusRequest(SubscribeWsStatusRequest r1) {
            this.subscribeWsStatusRequest = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_RequestBody extends ProtoAdapter<RequestBody> {
        public ProtoAdapter_RequestBody() {
            super(FieldEncoding.LENGTH_DELIMITED, RequestBody.class);
        }

        public RequestBody decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L29;
            if (r3 != 100000) goto L7;
            r0.bizExampleRequest((BizExampleRequest) BizExampleRequest.ADAPTER.decode(r7));
            goto L3
        L7:
            switch(r3) {
                case 101001: goto L27;
                case 101002: goto L26;
                case 101003: goto L25;
                case 101004: goto L24;
                case 101005: goto L23;
                case 101006: goto L22;
                default: goto L8;
            };
        L22:
            r0.subscribeWsMsgByBroadCastRequest((SubscribeWsMsgByBroadCastRequest) SubscribeWsMsgByBroadCastRequest.ADAPTER.decode(r7));
            goto L3
        L23:
            r0.subscribeWsMsgByCallBackRequest((SubscribeWsMsgByCallBackRequest) SubscribeWsMsgByCallBackRequest.ADAPTER.decode(r7));
            goto L3
        L24:
            r0.subscribeWsMsgByProviderRequest((SubscribeWsMsgByProviderRequest) SubscribeWsMsgByProviderRequest.ADAPTER.decode(r7));
            goto L3
        L25:
            r0.subscribeWsStatusRequest((SubscribeWsStatusRequest) SubscribeWsStatusRequest.ADAPTER.decode(r7));
            goto L3
        L26:
            r0.subscribeWsMsgRequest((SubscribeWsMsgRequest) SubscribeWsMsgRequest.ADAPTER.decode(r7));
            goto L3
        L27:
            r0.sendWsMessageRequest((SendWsMessageRequest) SendWsMessageRequest.ADAPTER.decode(r7));
            goto L3
        L8:
            switch(r3) {
                case 102001: goto L21;
                case 102002: goto L20;
                case 102003: goto L19;
                case 102004: goto L18;
                default: goto L9;
            };
        L18:
            r0.getIntersectFencesRequest((GetIntersectFencesRequest) GetIntersectFencesRequest.ADAPTER.decode(r7));
            goto L3
        L19:
            r0.decodeLocationRequest((DecodeLocationRequest) DecodeLocationRequest.ADAPTER.decode(r7));
            goto L3
        L20:
            r0.refreshLocationRequest((RefreshLocationRequest) RefreshLocationRequest.ADAPTER.decode(r7));
            goto L3
        L21:
            r0.getLocationRequest((GetLocationRequest) GetLocationRequest.ADAPTER.decode(r7));
            goto L3
        L9:
            switch(r3) {
                case 111001: goto L17;
                case 111002: goto L16;
                default: goto L10;
            };
        L16:
            r0.picoLinksCallback((PicoLinksCallback) PicoLinksCallback.ADAPTER.decode(r7));
            goto L3
        L17:
            r0.startPicoLinksRequest((StartPicoLinksRequest) StartPicoLinksRequest.ADAPTER.decode(r7));
            goto L3
        L10:
            switch(r3) {
                case 112001: goto L15;
                case 112002: goto L14;
                case 112003: goto L13;
                case 112004: goto L12;
                default: goto L11;
            };
        L12:
            r0.getTTNetParametersRequest((GetTTNetParametersRequest) GetTTNetParametersRequest.ADAPTER.decode(r7));
            goto L3
        L13:
            r0.genericNetworkRequest((GenericNetworkRequest) GenericNetworkRequest.ADAPTER.decode(r7));
            goto L3
        L14:
            r0.sendApplogEventRequest((SendApplogEventRequest) SendApplogEventRequest.ADAPTER.decode(r7));
            goto L3
        L15:
            r0.onePartyCommonNetworkRequest((OnePartyCommonNetworkRequest) OnePartyCommonNetworkRequest.ADAPTER.decode(r7));
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L29:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(RequestBody r5) {
            return ((((((((((((((((BizExampleRequest.ADAPTER.encodedSizeWithTag(100000, r5.bizExampleRequest) + SendWsMessageRequest.ADAPTER.encodedSizeWithTag(101001, r5.sendWsMessageRequest)) + SubscribeWsMsgRequest.ADAPTER.encodedSizeWithTag(101002, r5.subscribeWsMsgRequest)) + SubscribeWsStatusRequest.ADAPTER.encodedSizeWithTag(101003, r5.subscribeWsStatusRequest)) + SubscribeWsMsgByProviderRequest.ADAPTER.encodedSizeWithTag(101004, r5.subscribeWsMsgByProviderRequest)) + SubscribeWsMsgByCallBackRequest.ADAPTER.encodedSizeWithTag(101005, r5.subscribeWsMsgByCallBackRequest)) + SubscribeWsMsgByBroadCastRequest.ADAPTER.encodedSizeWithTag(101006, r5.subscribeWsMsgByBroadCastRequest)) + GetLocationRequest.ADAPTER.encodedSizeWithTag(102001, r5.getLocationRequest)) + RefreshLocationRequest.ADAPTER.encodedSizeWithTag(102002, r5.refreshLocationRequest)) + DecodeLocationRequest.ADAPTER.encodedSizeWithTag(102003, r5.decodeLocationRequest)) + GetIntersectFencesRequest.ADAPTER.encodedSizeWithTag(102004, r5.getIntersectFencesRequest)) + StartPicoLinksRequest.ADAPTER.encodedSizeWithTag(111001, r5.startPicoLinksRequest)) + PicoLinksCallback.ADAPTER.encodedSizeWithTag(111002, r5.picoLinksCallback)) + OnePartyCommonNetworkRequest.ADAPTER.encodedSizeWithTag(112001, r5.onePartyCommonNetworkRequest)) + SendApplogEventRequest.ADAPTER.encodedSizeWithTag(112002, r5.sendApplogEventRequest)) + GenericNetworkRequest.ADAPTER.encodedSizeWithTag(112003, r5.genericNetworkRequest)) + GetTTNetParametersRequest.ADAPTER.encodedSizeWithTag(112004, r5.getTTNetParametersRequest)) + r5.unknownFields().size();
        }

        public RequestBody redact(RequestBody r3) {
            Builder r4 = r3.newBuilder();
            BizExampleRequest r0 = r4.bizExampleRequest;
            if (r0 == null) goto L5;
            r4.bizExampleRequest = (BizExampleRequest) BizExampleRequest.ADAPTER.redact(r0);
        L5:
            SendWsMessageRequest r1 = r4.sendWsMessageRequest;
            if (r1 == null) goto L8;
            r4.sendWsMessageRequest = (SendWsMessageRequest) SendWsMessageRequest.ADAPTER.redact(r1);
        L8:
            SubscribeWsMsgRequest r2 = r4.subscribeWsMsgRequest;
            if (r2 == null) goto L11;
            r4.subscribeWsMsgRequest = (SubscribeWsMsgRequest) SubscribeWsMsgRequest.ADAPTER.redact(r2);
        L11:
            SubscribeWsStatusRequest r5 = r4.subscribeWsStatusRequest;
            if (r5 == null) goto L14;
            r4.subscribeWsStatusRequest = (SubscribeWsStatusRequest) SubscribeWsStatusRequest.ADAPTER.redact(r5);
        L14:
            SubscribeWsMsgByProviderRequest r6 = r4.subscribeWsMsgByProviderRequest;
            if (r6 == null) goto L17;
            r4.subscribeWsMsgByProviderRequest = (SubscribeWsMsgByProviderRequest) SubscribeWsMsgByProviderRequest.ADAPTER.redact(r6);
        L17:
            SubscribeWsMsgByCallBackRequest r7 = r4.subscribeWsMsgByCallBackRequest;
            if (r7 == null) goto L20;
            r4.subscribeWsMsgByCallBackRequest = (SubscribeWsMsgByCallBackRequest) SubscribeWsMsgByCallBackRequest.ADAPTER.redact(r7);
        L20:
            SubscribeWsMsgByBroadCastRequest r8 = r4.subscribeWsMsgByBroadCastRequest;
            if (r8 == null) goto L23;
            r4.subscribeWsMsgByBroadCastRequest = (SubscribeWsMsgByBroadCastRequest) SubscribeWsMsgByBroadCastRequest.ADAPTER.redact(r8);
        L23:
            GetLocationRequest r9 = r4.getLocationRequest;
            if (r9 == null) goto L26;
            r4.getLocationRequest = (GetLocationRequest) GetLocationRequest.ADAPTER.redact(r9);
        L26:
            RefreshLocationRequest r10 = r4.refreshLocationRequest;
            if (r10 == null) goto L29;
            r4.refreshLocationRequest = (RefreshLocationRequest) RefreshLocationRequest.ADAPTER.redact(r10);
        L29:
            DecodeLocationRequest r11 = r4.decodeLocationRequest;
            if (r11 == null) goto L32;
            r4.decodeLocationRequest = (DecodeLocationRequest) DecodeLocationRequest.ADAPTER.redact(r11);
        L32:
            GetIntersectFencesRequest r12 = r4.getIntersectFencesRequest;
            if (r12 == null) goto L35;
            r4.getIntersectFencesRequest = (GetIntersectFencesRequest) GetIntersectFencesRequest.ADAPTER.redact(r12);
        L35:
            StartPicoLinksRequest r13 = r4.startPicoLinksRequest;
            if (r13 == null) goto L38;
            r4.startPicoLinksRequest = (StartPicoLinksRequest) StartPicoLinksRequest.ADAPTER.redact(r13);
        L38:
            PicoLinksCallback r14 = r4.picoLinksCallback;
            if (r14 == null) goto L41;
            r4.picoLinksCallback = (PicoLinksCallback) PicoLinksCallback.ADAPTER.redact(r14);
        L41:
            OnePartyCommonNetworkRequest r15 = r4.onePartyCommonNetworkRequest;
            if (r15 == null) goto L44;
            r4.onePartyCommonNetworkRequest = (OnePartyCommonNetworkRequest) OnePartyCommonNetworkRequest.ADAPTER.redact(r15);
        L44:
            SendApplogEventRequest r16 = r4.sendApplogEventRequest;
            if (r16 == null) goto L47;
            r4.sendApplogEventRequest = (SendApplogEventRequest) SendApplogEventRequest.ADAPTER.redact(r16);
        L47:
            GenericNetworkRequest r17 = r4.genericNetworkRequest;
            if (r17 == null) goto L50;
            r4.genericNetworkRequest = (GenericNetworkRequest) GenericNetworkRequest.ADAPTER.redact(r17);
        L50:
            GetTTNetParametersRequest r18 = r4.getTTNetParametersRequest;
            if (r18 == null) goto L53;
            r4.getTTNetParametersRequest = (GetTTNetParametersRequest) GetTTNetParametersRequest.ADAPTER.redact(r18);
        L53:
            r4.clearUnknownFields();
            return r4.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m153decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((RequestBody) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((RequestBody) r1);
        }

        public void encode(ProtoWriter r4, RequestBody r5) throws IOException {
            BizExampleRequest.ADAPTER.encodeWithTag(r4, 100000, r5.bizExampleRequest);
            SendWsMessageRequest.ADAPTER.encodeWithTag(r4, 101001, r5.sendWsMessageRequest);
            SubscribeWsMsgRequest.ADAPTER.encodeWithTag(r4, 101002, r5.subscribeWsMsgRequest);
            SubscribeWsStatusRequest.ADAPTER.encodeWithTag(r4, 101003, r5.subscribeWsStatusRequest);
            SubscribeWsMsgByProviderRequest.ADAPTER.encodeWithTag(r4, 101004, r5.subscribeWsMsgByProviderRequest);
            SubscribeWsMsgByCallBackRequest.ADAPTER.encodeWithTag(r4, 101005, r5.subscribeWsMsgByCallBackRequest);
            SubscribeWsMsgByBroadCastRequest.ADAPTER.encodeWithTag(r4, 101006, r5.subscribeWsMsgByBroadCastRequest);
            GetLocationRequest.ADAPTER.encodeWithTag(r4, 102001, r5.getLocationRequest);
            RefreshLocationRequest.ADAPTER.encodeWithTag(r4, 102002, r5.refreshLocationRequest);
            DecodeLocationRequest.ADAPTER.encodeWithTag(r4, 102003, r5.decodeLocationRequest);
            GetIntersectFencesRequest.ADAPTER.encodeWithTag(r4, 102004, r5.getIntersectFencesRequest);
            StartPicoLinksRequest.ADAPTER.encodeWithTag(r4, 111001, r5.startPicoLinksRequest);
            PicoLinksCallback.ADAPTER.encodeWithTag(r4, 111002, r5.picoLinksCallback);
            OnePartyCommonNetworkRequest.ADAPTER.encodeWithTag(r4, 112001, r5.onePartyCommonNetworkRequest);
            SendApplogEventRequest.ADAPTER.encodeWithTag(r4, 112002, r5.sendApplogEventRequest);
            GenericNetworkRequest.ADAPTER.encodeWithTag(r4, 112003, r5.genericNetworkRequest);
            GetTTNetParametersRequest.ADAPTER.encodeWithTag(r4, 112004, r5.getTTNetParametersRequest);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (RequestBody) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RequestBody();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L73;
        int r1 = unknownFields().hashCode() * 37;
        BizExampleRequest r2 = this.bizExampleRequest;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        SendWsMessageRequest r6 = this.sendWsMessageRequest;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        SubscribeWsMsgRequest r9 = this.subscribeWsMsgRequest;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        SubscribeWsStatusRequest r12 = this.subscribeWsStatusRequest;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        SubscribeWsMsgByProviderRequest r15 = this.subscribeWsMsgByProviderRequest;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        SubscribeWsMsgByCallBackRequest r18 = this.subscribeWsMsgByCallBackRequest;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        SubscribeWsMsgByBroadCastRequest r21 = this.subscribeWsMsgByBroadCastRequest;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        GetLocationRequest r24 = this.getLocationRequest;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        RefreshLocationRequest r27 = this.refreshLocationRequest;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        DecodeLocationRequest r30 = this.decodeLocationRequest;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        GetIntersectFencesRequest r33 = this.getIntersectFencesRequest;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        StartPicoLinksRequest r36 = this.startPicoLinksRequest;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        PicoLinksCallback r39 = this.picoLinksCallback;
        if (r39 == null) goto L55;
        int r40 = r39.hashCode();
    L56:
        int r41 = (r38 + r40) * 37;
        OnePartyCommonNetworkRequest r42 = this.onePartyCommonNetworkRequest;
        if (r42 == null) goto L59;
        int r43 = r42.hashCode();
    L60:
        int r44 = (r41 + r43) * 37;
        SendApplogEventRequest r45 = this.sendApplogEventRequest;
        if (r45 == null) goto L63;
        int r46 = r45.hashCode();
    L64:
        int r47 = (r44 + r46) * 37;
        GenericNetworkRequest r48 = this.genericNetworkRequest;
        if (r48 == null) goto L67;
        int r49 = r48.hashCode();
    L68:
        int r50 = (r47 + r49) * 37;
        GetTTNetParametersRequest r51 = this.getTTNetParametersRequest;
        if (r51 == null) goto L71;
        r3 = r51.hashCode();
    L71:
        int r52 = r50 + r3;
        ((Message) this).hashCode = r52;
        return r52;
    L67:
        r49 = 0;
        goto L68
    L63:
        r46 = 0;
        goto L64
    L59:
        r43 = 0;
        goto L60
    L55:
        r40 = 0;
        goto L56
    L51:
        r37 = 0;
        goto L52
    L47:
        r34 = 0;
        goto L48
    L43:
        r31 = 0;
        goto L44
    L39:
        r28 = 0;
        goto L40
    L35:
        r25 = 0;
        goto L36
    L31:
        r22 = 0;
        goto L32
    L27:
        r19 = 0;
        goto L28
    L23:
        r16 = 0;
        goto L24
    L19:
        r13 = 0;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L73:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.bizExampleRequest = this.bizExampleRequest;
        r0.sendWsMessageRequest = this.sendWsMessageRequest;
        r0.subscribeWsMsgRequest = this.subscribeWsMsgRequest;
        r0.subscribeWsStatusRequest = this.subscribeWsStatusRequest;
        r0.subscribeWsMsgByProviderRequest = this.subscribeWsMsgByProviderRequest;
        r0.subscribeWsMsgByCallBackRequest = this.subscribeWsMsgByCallBackRequest;
        r0.subscribeWsMsgByBroadCastRequest = this.subscribeWsMsgByBroadCastRequest;
        r0.getLocationRequest = this.getLocationRequest;
        r0.refreshLocationRequest = this.refreshLocationRequest;
        r0.decodeLocationRequest = this.decodeLocationRequest;
        r0.getIntersectFencesRequest = this.getIntersectFencesRequest;
        r0.startPicoLinksRequest = this.startPicoLinksRequest;
        r0.picoLinksCallback = this.picoLinksCallback;
        r0.onePartyCommonNetworkRequest = this.onePartyCommonNetworkRequest;
        r0.sendApplogEventRequest = this.sendApplogEventRequest;
        r0.genericNetworkRequest = this.genericNetworkRequest;
        r0.getTTNetParametersRequest = this.getTTNetParametersRequest;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.bizExampleRequest == null) goto L6;
        r0.append(", bizExampleRequest=");
        r0.append(this.bizExampleRequest);
    L6:
        if (this.sendWsMessageRequest == null) goto L9;
        r0.append(", sendWsMessageRequest=");
        r0.append(this.sendWsMessageRequest);
    L9:
        if (this.subscribeWsMsgRequest == null) goto L12;
        r0.append(", subscribeWsMsgRequest=");
        r0.append(this.subscribeWsMsgRequest);
    L12:
        if (this.subscribeWsStatusRequest == null) goto L15;
        r0.append(", subscribeWsStatusRequest=");
        r0.append(this.subscribeWsStatusRequest);
    L15:
        if (this.subscribeWsMsgByProviderRequest == null) goto L18;
        r0.append(", subscribeWsMsgByProviderRequest=");
        r0.append(this.subscribeWsMsgByProviderRequest);
    L18:
        if (this.subscribeWsMsgByCallBackRequest == null) goto L21;
        r0.append(", subscribeWsMsgByCallBackRequest=");
        r0.append(this.subscribeWsMsgByCallBackRequest);
    L21:
        if (this.subscribeWsMsgByBroadCastRequest == null) goto L24;
        r0.append(", subscribeWsMsgByBroadCastRequest=");
        r0.append(this.subscribeWsMsgByBroadCastRequest);
    L24:
        if (this.getLocationRequest == null) goto L27;
        r0.append(", getLocationRequest=");
        r0.append(this.getLocationRequest);
    L27:
        if (this.refreshLocationRequest == null) goto L30;
        r0.append(", refreshLocationRequest=");
        r0.append(this.refreshLocationRequest);
    L30:
        if (this.decodeLocationRequest == null) goto L33;
        r0.append(", decodeLocationRequest=");
        r0.append(this.decodeLocationRequest);
    L33:
        if (this.getIntersectFencesRequest == null) goto L36;
        r0.append(", getIntersectFencesRequest=");
        r0.append(this.getIntersectFencesRequest);
    L36:
        if (this.startPicoLinksRequest == null) goto L39;
        r0.append(", startPicoLinksRequest=");
        r0.append(this.startPicoLinksRequest);
    L39:
        if (this.picoLinksCallback == null) goto L42;
        r0.append(", picoLinksCallback=");
        r0.append(this.picoLinksCallback);
    L42:
        if (this.onePartyCommonNetworkRequest == null) goto L45;
        r0.append(", onePartyCommonNetworkRequest=");
        r0.append(this.onePartyCommonNetworkRequest);
    L45:
        if (this.sendApplogEventRequest == null) goto L48;
        r0.append(", sendApplogEventRequest=");
        r0.append(this.sendApplogEventRequest);
    L48:
        if (this.genericNetworkRequest == null) goto L51;
        r0.append(", genericNetworkRequest=");
        r0.append(this.genericNetworkRequest);
    L51:
        if (this.getTTNetParametersRequest == null) goto L53;
        r0.append(", getTTNetParametersRequest=");
        r0.append(this.getTTNetParametersRequest);
    L53:
        StringBuilder r1 = r0.replace(0, 2, "RequestBody{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m151newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof RequestBody) == true) goto L8;
        return false;
    L8:
        RequestBody r6 = (RequestBody) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L45:
        return false;
    L11:
        if (Internal.equals(this.bizExampleRequest, r6.bizExampleRequest) == false) goto L45;
        if (Internal.equals(this.sendWsMessageRequest, r6.sendWsMessageRequest) == false) goto L45;
        if (Internal.equals(this.subscribeWsMsgRequest, r6.subscribeWsMsgRequest) == false) goto L45;
        if (Internal.equals(this.subscribeWsStatusRequest, r6.subscribeWsStatusRequest) == false) goto L45;
        if (Internal.equals(this.subscribeWsMsgByProviderRequest, r6.subscribeWsMsgByProviderRequest) == false) goto L45;
        if (Internal.equals(this.subscribeWsMsgByCallBackRequest, r6.subscribeWsMsgByCallBackRequest) == false) goto L45;
        if (Internal.equals(this.subscribeWsMsgByBroadCastRequest, r6.subscribeWsMsgByBroadCastRequest) == false) goto L45;
        if (Internal.equals(this.getLocationRequest, r6.getLocationRequest) == false) goto L45;
        if (Internal.equals(this.refreshLocationRequest, r6.refreshLocationRequest) == false) goto L45;
        if (Internal.equals(this.decodeLocationRequest, r6.decodeLocationRequest) == false) goto L45;
        if (Internal.equals(this.getIntersectFencesRequest, r6.getIntersectFencesRequest) == false) goto L45;
        if (Internal.equals(this.startPicoLinksRequest, r6.startPicoLinksRequest) == false) goto L45;
        if (Internal.equals(this.picoLinksCallback, r6.picoLinksCallback) == false) goto L45;
        if (Internal.equals(this.onePartyCommonNetworkRequest, r6.onePartyCommonNetworkRequest) == false) goto L45;
        if (Internal.equals(this.sendApplogEventRequest, r6.sendApplogEventRequest) == false) goto L45;
        if (Internal.equals(this.genericNetworkRequest, r6.genericNetworkRequest) == false) goto L45;
        if (Internal.equals(this.getTTNetParametersRequest, r6.getTTNetParametersRequest) == false) goto L45;
        return true;
    }

    public RequestBody(BizExampleRequest r20, SendWsMessageRequest r21, SubscribeWsMsgRequest r22, SubscribeWsStatusRequest r23, SubscribeWsMsgByProviderRequest r24, SubscribeWsMsgByCallBackRequest r25, SubscribeWsMsgByBroadCastRequest r26, GetLocationRequest r27, RefreshLocationRequest r28, DecodeLocationRequest r29, GetIntersectFencesRequest r30, StartPicoLinksRequest r31, PicoLinksCallback r32, OnePartyCommonNetworkRequest r33, SendApplogEventRequest r34, GenericNetworkRequest r35, GetTTNetParametersRequest r36) {
        this(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, ByteString.EMPTY);
    }

    public RequestBody(BizExampleRequest r4, SendWsMessageRequest r5, SubscribeWsMsgRequest r6, SubscribeWsStatusRequest r7, SubscribeWsMsgByProviderRequest r8, SubscribeWsMsgByCallBackRequest r9, SubscribeWsMsgByBroadCastRequest r10, GetLocationRequest r11, RefreshLocationRequest r12, DecodeLocationRequest r13, GetIntersectFencesRequest r14, StartPicoLinksRequest r15, PicoLinksCallback r16, OnePartyCommonNetworkRequest r17, SendApplogEventRequest r18, GenericNetworkRequest r19, GetTTNetParametersRequest r20, ByteString r21) {
        super(ADAPTER, r21);
        this.bizExampleRequest = r4;
        this.sendWsMessageRequest = r5;
        this.subscribeWsMsgRequest = r6;
        this.subscribeWsStatusRequest = r7;
        this.subscribeWsMsgByProviderRequest = r8;
        this.subscribeWsMsgByCallBackRequest = r9;
        this.subscribeWsMsgByBroadCastRequest = r10;
        this.getLocationRequest = r11;
        this.refreshLocationRequest = r12;
        this.decodeLocationRequest = r13;
        this.getIntersectFencesRequest = r14;
        this.startPicoLinksRequest = r15;
        this.picoLinksCallback = r16;
        this.onePartyCommonNetworkRequest = r17;
        this.sendApplogEventRequest = r18;
        this.genericNetworkRequest = r19;
        this.getTTNetParametersRequest = r20;
    }
}
