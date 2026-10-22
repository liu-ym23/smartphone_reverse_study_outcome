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
public final class ResponseBody extends Message<ResponseBody, Builder> {
    public static final ProtoAdapter<ResponseBody> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("bizExampleResponse")
    @WireField(adapter = "com.obric.matrix.proto.BizExampleResponse#ADAPTER", tag = 100000)
    public final BizExampleResponse bizExampleResponse;

    @SerializedName("decodeLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.DecodeLocationResponse#ADAPTER", tag = 102003)
    public final DecodeLocationResponse decodeLocationResponse;

    @SerializedName("genericNetworkResponse")
    @WireField(adapter = "com.obric.matrix.proto.GenericNetworkResponse#ADAPTER", tag = 112003)
    public final GenericNetworkResponse genericNetworkResponse;

    @SerializedName("getIntersectFencesResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetIntersectFencesResponse#ADAPTER", tag = 102004)
    public final GetIntersectFencesResponse getIntersectFencesResponse;

    @SerializedName("getLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetLocationResponse#ADAPTER", tag = 102001)
    public final GetLocationResponse getLocationResponse;

    @SerializedName("getTTNetParametersResponse")
    @WireField(adapter = "com.obric.matrix.proto.GetTTNetParametersResponse#ADAPTER", tag = 112004)
    public final GetTTNetParametersResponse getTTNetParametersResponse;

    @SerializedName("onePartyCommonNetworkResponse")
    @WireField(adapter = "com.obric.matrix.proto.OnePartyCommonNetworkResponse#ADAPTER", tag = 112001)
    public final OnePartyCommonNetworkResponse onePartyCommonNetworkResponse;

    @SerializedName("refreshLocationResponse")
    @WireField(adapter = "com.obric.matrix.proto.RefreshLocationResponse#ADAPTER", tag = 102002)
    public final RefreshLocationResponse refreshLocationResponse;

    @SerializedName("sendApplogEventResponse")
    @WireField(adapter = "com.obric.matrix.proto.SendApplogEventResponse#ADAPTER", tag = 112002)
    public final SendApplogEventResponse sendApplogEventResponse;

    @SerializedName("sendWsMessageResponse")
    @WireField(adapter = "com.obric.matrix.proto.SendWsMessageResponse#ADAPTER", tag = 101001)
    public final SendWsMessageResponse sendWsMessageResponse;

    @SerializedName("startPicoLinksResponse")
    @WireField(adapter = "com.obric.matrix.proto.StartPicoLinksResponse#ADAPTER", tag = 111001)
    public final StartPicoLinksResponse startPicoLinksResponse;

    @SerializedName("subscribeWsMsgByBroadCastResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByBroadCastResponse#ADAPTER", tag = 101006)
    public final SubscribeWsMsgByBroadCastResponse subscribeWsMsgByBroadCastResponse;

    @SerializedName("subscribeWsMsgByCallBackResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByCallBackResponse#ADAPTER", tag = 101005)
    public final SubscribeWsMsgByCallBackResponse subscribeWsMsgByCallBackResponse;

    @SerializedName("subscribeWsMsgByProviderResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgByProviderResponse#ADAPTER", tag = 101004)
    public final SubscribeWsMsgByProviderResponse subscribeWsMsgByProviderResponse;

    @SerializedName("subscribeWsMsgResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsMsgResponse#ADAPTER", tag = 101002)
    public final SubscribeWsMsgResponse subscribeWsMsgResponse;

    @SerializedName("subscribeWsStatusResponse")
    @WireField(adapter = "com.obric.matrix.proto.SubscribeWsStatusResponse#ADAPTER", tag = 101003)
    public final SubscribeWsStatusResponse subscribeWsStatusResponse;

    public static final class Builder extends Message.Builder<ResponseBody, Builder> {
        public BizExampleResponse bizExampleResponse;
        public DecodeLocationResponse decodeLocationResponse;
        public GenericNetworkResponse genericNetworkResponse;
        public GetIntersectFencesResponse getIntersectFencesResponse;
        public GetLocationResponse getLocationResponse;
        public GetTTNetParametersResponse getTTNetParametersResponse;
        public OnePartyCommonNetworkResponse onePartyCommonNetworkResponse;
        public RefreshLocationResponse refreshLocationResponse;
        public SendApplogEventResponse sendApplogEventResponse;
        public SendWsMessageResponse sendWsMessageResponse;
        public StartPicoLinksResponse startPicoLinksResponse;
        public SubscribeWsMsgByBroadCastResponse subscribeWsMsgByBroadCastResponse;
        public SubscribeWsMsgByCallBackResponse subscribeWsMsgByCallBackResponse;
        public SubscribeWsMsgByProviderResponse subscribeWsMsgByProviderResponse;
        public SubscribeWsMsgResponse subscribeWsMsgResponse;
        public SubscribeWsStatusResponse subscribeWsStatusResponse;

        public ResponseBody build() {
            return new ResponseBody(this.bizExampleResponse, this.sendWsMessageResponse, this.subscribeWsMsgResponse, this.subscribeWsStatusResponse, this.subscribeWsMsgByProviderResponse, this.subscribeWsMsgByCallBackResponse, this.subscribeWsMsgByBroadCastResponse, this.getLocationResponse, this.refreshLocationResponse, this.decodeLocationResponse, this.getIntersectFencesResponse, this.startPicoLinksResponse, this.onePartyCommonNetworkResponse, this.sendApplogEventResponse, this.genericNetworkResponse, this.getTTNetParametersResponse, super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m158build() {
            return build();
        }

        public Builder bizExampleResponse(BizExampleResponse r1) {
            this.bizExampleResponse = r1;
            return this;
        }

        public Builder decodeLocationResponse(DecodeLocationResponse r1) {
            this.decodeLocationResponse = r1;
            return this;
        }

        public Builder genericNetworkResponse(GenericNetworkResponse r1) {
            this.genericNetworkResponse = r1;
            return this;
        }

        public Builder getIntersectFencesResponse(GetIntersectFencesResponse r1) {
            this.getIntersectFencesResponse = r1;
            return this;
        }

        public Builder getLocationResponse(GetLocationResponse r1) {
            this.getLocationResponse = r1;
            return this;
        }

        public Builder getTTNetParametersResponse(GetTTNetParametersResponse r1) {
            this.getTTNetParametersResponse = r1;
            return this;
        }

        public Builder onePartyCommonNetworkResponse(OnePartyCommonNetworkResponse r1) {
            this.onePartyCommonNetworkResponse = r1;
            return this;
        }

        public Builder refreshLocationResponse(RefreshLocationResponse r1) {
            this.refreshLocationResponse = r1;
            return this;
        }

        public Builder sendApplogEventResponse(SendApplogEventResponse r1) {
            this.sendApplogEventResponse = r1;
            return this;
        }

        public Builder sendWsMessageResponse(SendWsMessageResponse r1) {
            this.sendWsMessageResponse = r1;
            return this;
        }

        public Builder startPicoLinksResponse(StartPicoLinksResponse r1) {
            this.startPicoLinksResponse = r1;
            return this;
        }

        public Builder subscribeWsMsgByBroadCastResponse(SubscribeWsMsgByBroadCastResponse r1) {
            this.subscribeWsMsgByBroadCastResponse = r1;
            return this;
        }

        public Builder subscribeWsMsgByCallBackResponse(SubscribeWsMsgByCallBackResponse r1) {
            this.subscribeWsMsgByCallBackResponse = r1;
            return this;
        }

        public Builder subscribeWsMsgByProviderResponse(SubscribeWsMsgByProviderResponse r1) {
            this.subscribeWsMsgByProviderResponse = r1;
            return this;
        }

        public Builder subscribeWsMsgResponse(SubscribeWsMsgResponse r1) {
            this.subscribeWsMsgResponse = r1;
            return this;
        }

        public Builder subscribeWsStatusResponse(SubscribeWsStatusResponse r1) {
            this.subscribeWsStatusResponse = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ResponseBody extends ProtoAdapter<ResponseBody> {
        public ProtoAdapter_ResponseBody() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseBody.class);
        }

        public ResponseBody decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L29;
            if (r3 != 100000) goto L8;
            r0.bizExampleResponse((BizExampleResponse) BizExampleResponse.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 111001) goto L9;
            r0.startPicoLinksResponse((StartPicoLinksResponse) StartPicoLinksResponse.ADAPTER.decode(r7));
            goto L3
        L9:
            switch(r3) {
                case 101001: goto L26;
                case 101002: goto L25;
                case 101003: goto L24;
                case 101004: goto L23;
                case 101005: goto L22;
                case 101006: goto L21;
                default: goto L10;
            };
        L21:
            r0.subscribeWsMsgByBroadCastResponse((SubscribeWsMsgByBroadCastResponse) SubscribeWsMsgByBroadCastResponse.ADAPTER.decode(r7));
            goto L3
        L22:
            r0.subscribeWsMsgByCallBackResponse((SubscribeWsMsgByCallBackResponse) SubscribeWsMsgByCallBackResponse.ADAPTER.decode(r7));
            goto L3
        L23:
            r0.subscribeWsMsgByProviderResponse((SubscribeWsMsgByProviderResponse) SubscribeWsMsgByProviderResponse.ADAPTER.decode(r7));
            goto L3
        L24:
            r0.subscribeWsStatusResponse((SubscribeWsStatusResponse) SubscribeWsStatusResponse.ADAPTER.decode(r7));
            goto L3
        L25:
            r0.subscribeWsMsgResponse((SubscribeWsMsgResponse) SubscribeWsMsgResponse.ADAPTER.decode(r7));
            goto L3
        L26:
            r0.sendWsMessageResponse((SendWsMessageResponse) SendWsMessageResponse.ADAPTER.decode(r7));
            goto L3
        L10:
            switch(r3) {
                case 102001: goto L20;
                case 102002: goto L19;
                case 102003: goto L18;
                case 102004: goto L17;
                default: goto L11;
            };
        L17:
            r0.getIntersectFencesResponse((GetIntersectFencesResponse) GetIntersectFencesResponse.ADAPTER.decode(r7));
            goto L3
        L18:
            r0.decodeLocationResponse((DecodeLocationResponse) DecodeLocationResponse.ADAPTER.decode(r7));
            goto L3
        L19:
            r0.refreshLocationResponse((RefreshLocationResponse) RefreshLocationResponse.ADAPTER.decode(r7));
            goto L3
        L20:
            r0.getLocationResponse((GetLocationResponse) GetLocationResponse.ADAPTER.decode(r7));
            goto L3
        L11:
            switch(r3) {
                case 112001: goto L16;
                case 112002: goto L15;
                case 112003: goto L14;
                case 112004: goto L13;
                default: goto L12;
            };
        L13:
            r0.getTTNetParametersResponse((GetTTNetParametersResponse) GetTTNetParametersResponse.ADAPTER.decode(r7));
            goto L3
        L14:
            r0.genericNetworkResponse((GenericNetworkResponse) GenericNetworkResponse.ADAPTER.decode(r7));
            goto L3
        L15:
            r0.sendApplogEventResponse((SendApplogEventResponse) SendApplogEventResponse.ADAPTER.decode(r7));
            goto L3
        L16:
            r0.onePartyCommonNetworkResponse((OnePartyCommonNetworkResponse) OnePartyCommonNetworkResponse.ADAPTER.decode(r7));
            goto L3
        L12:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L29:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(ResponseBody r5) {
            return (((((((((((((((BizExampleResponse.ADAPTER.encodedSizeWithTag(100000, r5.bizExampleResponse) + SendWsMessageResponse.ADAPTER.encodedSizeWithTag(101001, r5.sendWsMessageResponse)) + SubscribeWsMsgResponse.ADAPTER.encodedSizeWithTag(101002, r5.subscribeWsMsgResponse)) + SubscribeWsStatusResponse.ADAPTER.encodedSizeWithTag(101003, r5.subscribeWsStatusResponse)) + SubscribeWsMsgByProviderResponse.ADAPTER.encodedSizeWithTag(101004, r5.subscribeWsMsgByProviderResponse)) + SubscribeWsMsgByCallBackResponse.ADAPTER.encodedSizeWithTag(101005, r5.subscribeWsMsgByCallBackResponse)) + SubscribeWsMsgByBroadCastResponse.ADAPTER.encodedSizeWithTag(101006, r5.subscribeWsMsgByBroadCastResponse)) + GetLocationResponse.ADAPTER.encodedSizeWithTag(102001, r5.getLocationResponse)) + RefreshLocationResponse.ADAPTER.encodedSizeWithTag(102002, r5.refreshLocationResponse)) + DecodeLocationResponse.ADAPTER.encodedSizeWithTag(102003, r5.decodeLocationResponse)) + GetIntersectFencesResponse.ADAPTER.encodedSizeWithTag(102004, r5.getIntersectFencesResponse)) + StartPicoLinksResponse.ADAPTER.encodedSizeWithTag(111001, r5.startPicoLinksResponse)) + OnePartyCommonNetworkResponse.ADAPTER.encodedSizeWithTag(112001, r5.onePartyCommonNetworkResponse)) + SendApplogEventResponse.ADAPTER.encodedSizeWithTag(112002, r5.sendApplogEventResponse)) + GenericNetworkResponse.ADAPTER.encodedSizeWithTag(112003, r5.genericNetworkResponse)) + GetTTNetParametersResponse.ADAPTER.encodedSizeWithTag(112004, r5.getTTNetParametersResponse)) + r5.unknownFields().size();
        }

        public ResponseBody redact(ResponseBody r3) {
            Builder r4 = r3.newBuilder();
            BizExampleResponse r0 = r4.bizExampleResponse;
            if (r0 == null) goto L5;
            r4.bizExampleResponse = (BizExampleResponse) BizExampleResponse.ADAPTER.redact(r0);
        L5:
            SendWsMessageResponse r1 = r4.sendWsMessageResponse;
            if (r1 == null) goto L8;
            r4.sendWsMessageResponse = (SendWsMessageResponse) SendWsMessageResponse.ADAPTER.redact(r1);
        L8:
            SubscribeWsMsgResponse r2 = r4.subscribeWsMsgResponse;
            if (r2 == null) goto L11;
            r4.subscribeWsMsgResponse = (SubscribeWsMsgResponse) SubscribeWsMsgResponse.ADAPTER.redact(r2);
        L11:
            SubscribeWsStatusResponse r5 = r4.subscribeWsStatusResponse;
            if (r5 == null) goto L14;
            r4.subscribeWsStatusResponse = (SubscribeWsStatusResponse) SubscribeWsStatusResponse.ADAPTER.redact(r5);
        L14:
            SubscribeWsMsgByProviderResponse r6 = r4.subscribeWsMsgByProviderResponse;
            if (r6 == null) goto L17;
            r4.subscribeWsMsgByProviderResponse = (SubscribeWsMsgByProviderResponse) SubscribeWsMsgByProviderResponse.ADAPTER.redact(r6);
        L17:
            SubscribeWsMsgByCallBackResponse r7 = r4.subscribeWsMsgByCallBackResponse;
            if (r7 == null) goto L20;
            r4.subscribeWsMsgByCallBackResponse = (SubscribeWsMsgByCallBackResponse) SubscribeWsMsgByCallBackResponse.ADAPTER.redact(r7);
        L20:
            SubscribeWsMsgByBroadCastResponse r8 = r4.subscribeWsMsgByBroadCastResponse;
            if (r8 == null) goto L23;
            r4.subscribeWsMsgByBroadCastResponse = (SubscribeWsMsgByBroadCastResponse) SubscribeWsMsgByBroadCastResponse.ADAPTER.redact(r8);
        L23:
            GetLocationResponse r9 = r4.getLocationResponse;
            if (r9 == null) goto L26;
            r4.getLocationResponse = (GetLocationResponse) GetLocationResponse.ADAPTER.redact(r9);
        L26:
            RefreshLocationResponse r10 = r4.refreshLocationResponse;
            if (r10 == null) goto L29;
            r4.refreshLocationResponse = (RefreshLocationResponse) RefreshLocationResponse.ADAPTER.redact(r10);
        L29:
            DecodeLocationResponse r11 = r4.decodeLocationResponse;
            if (r11 == null) goto L32;
            r4.decodeLocationResponse = (DecodeLocationResponse) DecodeLocationResponse.ADAPTER.redact(r11);
        L32:
            GetIntersectFencesResponse r12 = r4.getIntersectFencesResponse;
            if (r12 == null) goto L35;
            r4.getIntersectFencesResponse = (GetIntersectFencesResponse) GetIntersectFencesResponse.ADAPTER.redact(r12);
        L35:
            StartPicoLinksResponse r13 = r4.startPicoLinksResponse;
            if (r13 == null) goto L38;
            r4.startPicoLinksResponse = (StartPicoLinksResponse) StartPicoLinksResponse.ADAPTER.redact(r13);
        L38:
            OnePartyCommonNetworkResponse r14 = r4.onePartyCommonNetworkResponse;
            if (r14 == null) goto L41;
            r4.onePartyCommonNetworkResponse = (OnePartyCommonNetworkResponse) OnePartyCommonNetworkResponse.ADAPTER.redact(r14);
        L41:
            SendApplogEventResponse r15 = r4.sendApplogEventResponse;
            if (r15 == null) goto L44;
            r4.sendApplogEventResponse = (SendApplogEventResponse) SendApplogEventResponse.ADAPTER.redact(r15);
        L44:
            GenericNetworkResponse r16 = r4.genericNetworkResponse;
            if (r16 == null) goto L47;
            r4.genericNetworkResponse = (GenericNetworkResponse) GenericNetworkResponse.ADAPTER.redact(r16);
        L47:
            GetTTNetParametersResponse r17 = r4.getTTNetParametersResponse;
            if (r17 == null) goto L50;
            r4.getTTNetParametersResponse = (GetTTNetParametersResponse) GetTTNetParametersResponse.ADAPTER.redact(r17);
        L50:
            r4.clearUnknownFields();
            return r4.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m159decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ResponseBody) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((ResponseBody) r1);
        }

        public void encode(ProtoWriter r4, ResponseBody r5) throws IOException {
            BizExampleResponse.ADAPTER.encodeWithTag(r4, 100000, r5.bizExampleResponse);
            SendWsMessageResponse.ADAPTER.encodeWithTag(r4, 101001, r5.sendWsMessageResponse);
            SubscribeWsMsgResponse.ADAPTER.encodeWithTag(r4, 101002, r5.subscribeWsMsgResponse);
            SubscribeWsStatusResponse.ADAPTER.encodeWithTag(r4, 101003, r5.subscribeWsStatusResponse);
            SubscribeWsMsgByProviderResponse.ADAPTER.encodeWithTag(r4, 101004, r5.subscribeWsMsgByProviderResponse);
            SubscribeWsMsgByCallBackResponse.ADAPTER.encodeWithTag(r4, 101005, r5.subscribeWsMsgByCallBackResponse);
            SubscribeWsMsgByBroadCastResponse.ADAPTER.encodeWithTag(r4, 101006, r5.subscribeWsMsgByBroadCastResponse);
            GetLocationResponse.ADAPTER.encodeWithTag(r4, 102001, r5.getLocationResponse);
            RefreshLocationResponse.ADAPTER.encodeWithTag(r4, 102002, r5.refreshLocationResponse);
            DecodeLocationResponse.ADAPTER.encodeWithTag(r4, 102003, r5.decodeLocationResponse);
            GetIntersectFencesResponse.ADAPTER.encodeWithTag(r4, 102004, r5.getIntersectFencesResponse);
            StartPicoLinksResponse.ADAPTER.encodeWithTag(r4, 111001, r5.startPicoLinksResponse);
            OnePartyCommonNetworkResponse.ADAPTER.encodeWithTag(r4, 112001, r5.onePartyCommonNetworkResponse);
            SendApplogEventResponse.ADAPTER.encodeWithTag(r4, 112002, r5.sendApplogEventResponse);
            GenericNetworkResponse.ADAPTER.encodeWithTag(r4, 112003, r5.genericNetworkResponse);
            GetTTNetParametersResponse.ADAPTER.encodeWithTag(r4, 112004, r5.getTTNetParametersResponse);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ResponseBody) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ResponseBody();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L69;
        int r1 = unknownFields().hashCode() * 37;
        BizExampleResponse r2 = this.bizExampleResponse;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        SendWsMessageResponse r6 = this.sendWsMessageResponse;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        SubscribeWsMsgResponse r9 = this.subscribeWsMsgResponse;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        SubscribeWsStatusResponse r12 = this.subscribeWsStatusResponse;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        SubscribeWsMsgByProviderResponse r15 = this.subscribeWsMsgByProviderResponse;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        SubscribeWsMsgByCallBackResponse r18 = this.subscribeWsMsgByCallBackResponse;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        SubscribeWsMsgByBroadCastResponse r21 = this.subscribeWsMsgByBroadCastResponse;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        GetLocationResponse r24 = this.getLocationResponse;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        RefreshLocationResponse r27 = this.refreshLocationResponse;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        DecodeLocationResponse r30 = this.decodeLocationResponse;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        GetIntersectFencesResponse r33 = this.getIntersectFencesResponse;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        StartPicoLinksResponse r36 = this.startPicoLinksResponse;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        OnePartyCommonNetworkResponse r39 = this.onePartyCommonNetworkResponse;
        if (r39 == null) goto L55;
        int r40 = r39.hashCode();
    L56:
        int r41 = (r38 + r40) * 37;
        SendApplogEventResponse r42 = this.sendApplogEventResponse;
        if (r42 == null) goto L59;
        int r43 = r42.hashCode();
    L60:
        int r44 = (r41 + r43) * 37;
        GenericNetworkResponse r45 = this.genericNetworkResponse;
        if (r45 == null) goto L63;
        int r46 = r45.hashCode();
    L64:
        int r47 = (r44 + r46) * 37;
        GetTTNetParametersResponse r48 = this.getTTNetParametersResponse;
        if (r48 == null) goto L67;
        r3 = r48.hashCode();
    L67:
        int r49 = r47 + r3;
        ((Message) this).hashCode = r49;
        return r49;
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
    L69:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.bizExampleResponse = this.bizExampleResponse;
        r0.sendWsMessageResponse = this.sendWsMessageResponse;
        r0.subscribeWsMsgResponse = this.subscribeWsMsgResponse;
        r0.subscribeWsStatusResponse = this.subscribeWsStatusResponse;
        r0.subscribeWsMsgByProviderResponse = this.subscribeWsMsgByProviderResponse;
        r0.subscribeWsMsgByCallBackResponse = this.subscribeWsMsgByCallBackResponse;
        r0.subscribeWsMsgByBroadCastResponse = this.subscribeWsMsgByBroadCastResponse;
        r0.getLocationResponse = this.getLocationResponse;
        r0.refreshLocationResponse = this.refreshLocationResponse;
        r0.decodeLocationResponse = this.decodeLocationResponse;
        r0.getIntersectFencesResponse = this.getIntersectFencesResponse;
        r0.startPicoLinksResponse = this.startPicoLinksResponse;
        r0.onePartyCommonNetworkResponse = this.onePartyCommonNetworkResponse;
        r0.sendApplogEventResponse = this.sendApplogEventResponse;
        r0.genericNetworkResponse = this.genericNetworkResponse;
        r0.getTTNetParametersResponse = this.getTTNetParametersResponse;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.bizExampleResponse == null) goto L6;
        r0.append(", bizExampleResponse=");
        r0.append(this.bizExampleResponse);
    L6:
        if (this.sendWsMessageResponse == null) goto L9;
        r0.append(", sendWsMessageResponse=");
        r0.append(this.sendWsMessageResponse);
    L9:
        if (this.subscribeWsMsgResponse == null) goto L12;
        r0.append(", subscribeWsMsgResponse=");
        r0.append(this.subscribeWsMsgResponse);
    L12:
        if (this.subscribeWsStatusResponse == null) goto L15;
        r0.append(", subscribeWsStatusResponse=");
        r0.append(this.subscribeWsStatusResponse);
    L15:
        if (this.subscribeWsMsgByProviderResponse == null) goto L18;
        r0.append(", subscribeWsMsgByProviderResponse=");
        r0.append(this.subscribeWsMsgByProviderResponse);
    L18:
        if (this.subscribeWsMsgByCallBackResponse == null) goto L21;
        r0.append(", subscribeWsMsgByCallBackResponse=");
        r0.append(this.subscribeWsMsgByCallBackResponse);
    L21:
        if (this.subscribeWsMsgByBroadCastResponse == null) goto L24;
        r0.append(", subscribeWsMsgByBroadCastResponse=");
        r0.append(this.subscribeWsMsgByBroadCastResponse);
    L24:
        if (this.getLocationResponse == null) goto L27;
        r0.append(", getLocationResponse=");
        r0.append(this.getLocationResponse);
    L27:
        if (this.refreshLocationResponse == null) goto L30;
        r0.append(", refreshLocationResponse=");
        r0.append(this.refreshLocationResponse);
    L30:
        if (this.decodeLocationResponse == null) goto L33;
        r0.append(", decodeLocationResponse=");
        r0.append(this.decodeLocationResponse);
    L33:
        if (this.getIntersectFencesResponse == null) goto L36;
        r0.append(", getIntersectFencesResponse=");
        r0.append(this.getIntersectFencesResponse);
    L36:
        if (this.startPicoLinksResponse == null) goto L39;
        r0.append(", startPicoLinksResponse=");
        r0.append(this.startPicoLinksResponse);
    L39:
        if (this.onePartyCommonNetworkResponse == null) goto L42;
        r0.append(", onePartyCommonNetworkResponse=");
        r0.append(this.onePartyCommonNetworkResponse);
    L42:
        if (this.sendApplogEventResponse == null) goto L45;
        r0.append(", sendApplogEventResponse=");
        r0.append(this.sendApplogEventResponse);
    L45:
        if (this.genericNetworkResponse == null) goto L48;
        r0.append(", genericNetworkResponse=");
        r0.append(this.genericNetworkResponse);
    L48:
        if (this.getTTNetParametersResponse == null) goto L50;
        r0.append(", getTTNetParametersResponse=");
        r0.append(this.getTTNetParametersResponse);
    L50:
        StringBuilder r1 = r0.replace(0, 2, "ResponseBody{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m157newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResponseBody) == true) goto L8;
        return false;
    L8:
        ResponseBody r6 = (ResponseBody) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L43:
        return false;
    L11:
        if (Internal.equals(this.bizExampleResponse, r6.bizExampleResponse) == false) goto L43;
        if (Internal.equals(this.sendWsMessageResponse, r6.sendWsMessageResponse) == false) goto L43;
        if (Internal.equals(this.subscribeWsMsgResponse, r6.subscribeWsMsgResponse) == false) goto L43;
        if (Internal.equals(this.subscribeWsStatusResponse, r6.subscribeWsStatusResponse) == false) goto L43;
        if (Internal.equals(this.subscribeWsMsgByProviderResponse, r6.subscribeWsMsgByProviderResponse) == false) goto L43;
        if (Internal.equals(this.subscribeWsMsgByCallBackResponse, r6.subscribeWsMsgByCallBackResponse) == false) goto L43;
        if (Internal.equals(this.subscribeWsMsgByBroadCastResponse, r6.subscribeWsMsgByBroadCastResponse) == false) goto L43;
        if (Internal.equals(this.getLocationResponse, r6.getLocationResponse) == false) goto L43;
        if (Internal.equals(this.refreshLocationResponse, r6.refreshLocationResponse) == false) goto L43;
        if (Internal.equals(this.decodeLocationResponse, r6.decodeLocationResponse) == false) goto L43;
        if (Internal.equals(this.getIntersectFencesResponse, r6.getIntersectFencesResponse) == false) goto L43;
        if (Internal.equals(this.startPicoLinksResponse, r6.startPicoLinksResponse) == false) goto L43;
        if (Internal.equals(this.onePartyCommonNetworkResponse, r6.onePartyCommonNetworkResponse) == false) goto L43;
        if (Internal.equals(this.sendApplogEventResponse, r6.sendApplogEventResponse) == false) goto L43;
        if (Internal.equals(this.genericNetworkResponse, r6.genericNetworkResponse) == false) goto L43;
        if (Internal.equals(this.getTTNetParametersResponse, r6.getTTNetParametersResponse) == false) goto L43;
        return true;
    }

    public ResponseBody(BizExampleResponse r19, SendWsMessageResponse r20, SubscribeWsMsgResponse r21, SubscribeWsStatusResponse r22, SubscribeWsMsgByProviderResponse r23, SubscribeWsMsgByCallBackResponse r24, SubscribeWsMsgByBroadCastResponse r25, GetLocationResponse r26, RefreshLocationResponse r27, DecodeLocationResponse r28, GetIntersectFencesResponse r29, StartPicoLinksResponse r30, OnePartyCommonNetworkResponse r31, SendApplogEventResponse r32, GenericNetworkResponse r33, GetTTNetParametersResponse r34) {
        this(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, ByteString.EMPTY);
    }

    public ResponseBody(BizExampleResponse r4, SendWsMessageResponse r5, SubscribeWsMsgResponse r6, SubscribeWsStatusResponse r7, SubscribeWsMsgByProviderResponse r8, SubscribeWsMsgByCallBackResponse r9, SubscribeWsMsgByBroadCastResponse r10, GetLocationResponse r11, RefreshLocationResponse r12, DecodeLocationResponse r13, GetIntersectFencesResponse r14, StartPicoLinksResponse r15, OnePartyCommonNetworkResponse r16, SendApplogEventResponse r17, GenericNetworkResponse r18, GetTTNetParametersResponse r19, ByteString r20) {
        super(ADAPTER, r20);
        this.bizExampleResponse = r4;
        this.sendWsMessageResponse = r5;
        this.subscribeWsMsgResponse = r6;
        this.subscribeWsStatusResponse = r7;
        this.subscribeWsMsgByProviderResponse = r8;
        this.subscribeWsMsgByCallBackResponse = r9;
        this.subscribeWsMsgByBroadCastResponse = r10;
        this.getLocationResponse = r11;
        this.refreshLocationResponse = r12;
        this.decodeLocationResponse = r13;
        this.getIntersectFencesResponse = r14;
        this.startPicoLinksResponse = r15;
        this.onePartyCommonNetworkResponse = r16;
        this.sendApplogEventResponse = r17;
        this.genericNetworkResponse = r18;
        this.getTTNetParametersResponse = r19;
    }
}
