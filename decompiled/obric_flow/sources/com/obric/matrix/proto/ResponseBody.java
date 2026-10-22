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

        public Builder() {
        }

        public Builder bizExampleResponse(BizExampleResponse r5) {
            this.bizExampleResponse = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder decodeLocationResponse(DecodeLocationResponse r5) {
            this.decodeLocationResponse = r5;
            return this;
        }

        public Builder genericNetworkResponse(GenericNetworkResponse r5) {
            this.genericNetworkResponse = r5;
            return this;
        }

        public Builder getIntersectFencesResponse(GetIntersectFencesResponse r5) {
            this.getIntersectFencesResponse = r5;
            return this;
        }

        public Builder getLocationResponse(GetLocationResponse r5) {
            this.getLocationResponse = r5;
            return this;
        }

        public Builder getTTNetParametersResponse(GetTTNetParametersResponse r5) {
            this.getTTNetParametersResponse = r5;
            return this;
        }

        public Builder onePartyCommonNetworkResponse(OnePartyCommonNetworkResponse r5) {
            this.onePartyCommonNetworkResponse = r5;
            return this;
        }

        public Builder refreshLocationResponse(RefreshLocationResponse r5) {
            this.refreshLocationResponse = r5;
            return this;
        }

        public Builder sendApplogEventResponse(SendApplogEventResponse r5) {
            this.sendApplogEventResponse = r5;
            return this;
        }

        public Builder sendWsMessageResponse(SendWsMessageResponse r5) {
            this.sendWsMessageResponse = r5;
            return this;
        }

        public Builder startPicoLinksResponse(StartPicoLinksResponse r5) {
            this.startPicoLinksResponse = r5;
            return this;
        }

        public Builder subscribeWsMsgByBroadCastResponse(SubscribeWsMsgByBroadCastResponse r5) {
            this.subscribeWsMsgByBroadCastResponse = r5;
            return this;
        }

        public Builder subscribeWsMsgByCallBackResponse(SubscribeWsMsgByCallBackResponse r5) {
            this.subscribeWsMsgByCallBackResponse = r5;
            return this;
        }

        public Builder subscribeWsMsgByProviderResponse(SubscribeWsMsgByProviderResponse r5) {
            this.subscribeWsMsgByProviderResponse = r5;
            return this;
        }

        public Builder subscribeWsMsgResponse(SubscribeWsMsgResponse r5) {
            this.subscribeWsMsgResponse = r5;
            return this;
        }

        public Builder subscribeWsStatusResponse(SubscribeWsStatusResponse r5) {
            this.subscribeWsStatusResponse = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public ResponseBody build() {
            return new ResponseBody(this.bizExampleResponse, this.sendWsMessageResponse, this.subscribeWsMsgResponse, this.subscribeWsStatusResponse, this.subscribeWsMsgByProviderResponse, this.subscribeWsMsgByCallBackResponse, this.subscribeWsMsgByBroadCastResponse, this.getLocationResponse, this.refreshLocationResponse, this.decodeLocationResponse, this.getIntersectFencesResponse, this.startPicoLinksResponse, this.onePartyCommonNetworkResponse, this.sendApplogEventResponse, this.genericNetworkResponse, this.getTTNetParametersResponse, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_ResponseBody extends ProtoAdapter<ResponseBody> {
        public ProtoAdapter_ResponseBody() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseBody.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResponseBody decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, ResponseBody r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ResponseBody r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ResponseBody redact(ResponseBody r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ResponseBody decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L29;
            if (r12 != 100000) goto L8;
            r5.bizExampleResponse(BizExampleResponse.ADAPTER.decode(r10));
            goto L3
        L8:
            if (r12 != 111001) goto L9;
            r5.startPicoLinksResponse(StartPicoLinksResponse.ADAPTER.decode(r10));
            goto L3
        L9:
            switch(r12) {
                case 101001: goto L26;
                case 101002: goto L25;
                case 101003: goto L24;
                case 101004: goto L23;
                case 101005: goto L22;
                case 101006: goto L21;
                default: goto L10;
            };
        L21:
            r5.subscribeWsMsgByBroadCastResponse(SubscribeWsMsgByBroadCastResponse.ADAPTER.decode(r10));
            goto L3
        L22:
            r5.subscribeWsMsgByCallBackResponse(SubscribeWsMsgByCallBackResponse.ADAPTER.decode(r10));
            goto L3
        L23:
            r5.subscribeWsMsgByProviderResponse(SubscribeWsMsgByProviderResponse.ADAPTER.decode(r10));
            goto L3
        L24:
            r5.subscribeWsStatusResponse(SubscribeWsStatusResponse.ADAPTER.decode(r10));
            goto L3
        L25:
            r5.subscribeWsMsgResponse(SubscribeWsMsgResponse.ADAPTER.decode(r10));
            goto L3
        L26:
            r5.sendWsMessageResponse(SendWsMessageResponse.ADAPTER.decode(r10));
            goto L3
        L10:
            switch(r12) {
                case 102001: goto L20;
                case 102002: goto L19;
                case 102003: goto L18;
                case 102004: goto L17;
                default: goto L11;
            };
        L17:
            r5.getIntersectFencesResponse(GetIntersectFencesResponse.ADAPTER.decode(r10));
            goto L3
        L18:
            r5.decodeLocationResponse(DecodeLocationResponse.ADAPTER.decode(r10));
            goto L3
        L19:
            r5.refreshLocationResponse(RefreshLocationResponse.ADAPTER.decode(r10));
            goto L3
        L20:
            r5.getLocationResponse(GetLocationResponse.ADAPTER.decode(r10));
            goto L3
        L11:
            switch(r12) {
                case 112001: goto L16;
                case 112002: goto L15;
                case 112003: goto L14;
                case 112004: goto L13;
                default: goto L12;
            };
        L13:
            r5.getTTNetParametersResponse(GetTTNetParametersResponse.ADAPTER.decode(r10));
            goto L3
        L14:
            r5.genericNetworkResponse(GenericNetworkResponse.ADAPTER.decode(r10));
            goto L3
        L15:
            r5.sendApplogEventResponse(SendApplogEventResponse.ADAPTER.decode(r10));
            goto L3
        L16:
            r5.onePartyCommonNetworkResponse(OnePartyCommonNetworkResponse.ADAPTER.decode(r10));
            goto L3
        L12:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L29:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, ResponseBody r10) throws IOException {
            BizExampleResponse.ADAPTER.encodeWithTag(r5, 100000, r10.bizExampleResponse);
            SendWsMessageResponse.ADAPTER.encodeWithTag(r5, 101001, r10.sendWsMessageResponse);
            SubscribeWsMsgResponse.ADAPTER.encodeWithTag(r5, 101002, r10.subscribeWsMsgResponse);
            SubscribeWsStatusResponse.ADAPTER.encodeWithTag(r5, 101003, r10.subscribeWsStatusResponse);
            SubscribeWsMsgByProviderResponse.ADAPTER.encodeWithTag(r5, 101004, r10.subscribeWsMsgByProviderResponse);
            SubscribeWsMsgByCallBackResponse.ADAPTER.encodeWithTag(r5, 101005, r10.subscribeWsMsgByCallBackResponse);
            SubscribeWsMsgByBroadCastResponse.ADAPTER.encodeWithTag(r5, 101006, r10.subscribeWsMsgByBroadCastResponse);
            GetLocationResponse.ADAPTER.encodeWithTag(r5, 102001, r10.getLocationResponse);
            RefreshLocationResponse.ADAPTER.encodeWithTag(r5, 102002, r10.refreshLocationResponse);
            DecodeLocationResponse.ADAPTER.encodeWithTag(r5, 102003, r10.decodeLocationResponse);
            GetIntersectFencesResponse.ADAPTER.encodeWithTag(r5, 102004, r10.getIntersectFencesResponse);
            StartPicoLinksResponse.ADAPTER.encodeWithTag(r5, 111001, r10.startPicoLinksResponse);
            OnePartyCommonNetworkResponse.ADAPTER.encodeWithTag(r5, 112001, r10.onePartyCommonNetworkResponse);
            SendApplogEventResponse.ADAPTER.encodeWithTag(r5, 112002, r10.sendApplogEventResponse);
            GenericNetworkResponse.ADAPTER.encodeWithTag(r5, 112003, r10.genericNetworkResponse);
            GetTTNetParametersResponse.ADAPTER.encodeWithTag(r5, 112004, r10.getTTNetParametersResponse);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ResponseBody r5) {
            int r10 = BizExampleResponse.ADAPTER.encodedSizeWithTag(100000, r5.bizExampleResponse);
            int r11 = SendWsMessageResponse.ADAPTER.encodedSizeWithTag(101001, r5.sendWsMessageResponse) + r10;
            int r12 = SubscribeWsMsgResponse.ADAPTER.encodedSizeWithTag(101002, r5.subscribeWsMsgResponse) + r11;
            int r13 = SubscribeWsStatusResponse.ADAPTER.encodedSizeWithTag(101003, r5.subscribeWsStatusResponse) + r12;
            int r14 = SubscribeWsMsgByProviderResponse.ADAPTER.encodedSizeWithTag(101004, r5.subscribeWsMsgByProviderResponse) + r13;
            int r15 = SubscribeWsMsgByCallBackResponse.ADAPTER.encodedSizeWithTag(101005, r5.subscribeWsMsgByCallBackResponse) + r14;
            int r16 = SubscribeWsMsgByBroadCastResponse.ADAPTER.encodedSizeWithTag(101006, r5.subscribeWsMsgByBroadCastResponse) + r15;
            int r17 = GetLocationResponse.ADAPTER.encodedSizeWithTag(102001, r5.getLocationResponse) + r16;
            int r18 = RefreshLocationResponse.ADAPTER.encodedSizeWithTag(102002, r5.refreshLocationResponse) + r17;
            int r19 = DecodeLocationResponse.ADAPTER.encodedSizeWithTag(102003, r5.decodeLocationResponse) + r18;
            int r20 = GetIntersectFencesResponse.ADAPTER.encodedSizeWithTag(102004, r5.getIntersectFencesResponse) + r19;
            int r21 = StartPicoLinksResponse.ADAPTER.encodedSizeWithTag(111001, r5.startPicoLinksResponse) + r20;
            int r22 = OnePartyCommonNetworkResponse.ADAPTER.encodedSizeWithTag(112001, r5.onePartyCommonNetworkResponse) + r21;
            int r23 = SendApplogEventResponse.ADAPTER.encodedSizeWithTag(112002, r5.sendApplogEventResponse) + r22;
            int r24 = GenericNetworkResponse.ADAPTER.encodedSizeWithTag(112003, r5.genericNetworkResponse) + r23;
            int r25 = GetTTNetParametersResponse.ADAPTER.encodedSizeWithTag(112004, r5.getTTNetParametersResponse) + r24;
            return r5.unknownFields().size() + r25;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public ResponseBody redact2(ResponseBody r5) {
            Builder r10 = r5.newBuilder();
            BizExampleResponse r11 = r10.bizExampleResponse;
            if (r11 == null) goto L5;
            r10.bizExampleResponse = BizExampleResponse.ADAPTER.redact(r11);
        L5:
            SendWsMessageResponse r12 = r10.sendWsMessageResponse;
            if (r12 == null) goto L8;
            r10.sendWsMessageResponse = SendWsMessageResponse.ADAPTER.redact(r12);
        L8:
            SubscribeWsMsgResponse r13 = r10.subscribeWsMsgResponse;
            if (r13 == null) goto L11;
            r10.subscribeWsMsgResponse = SubscribeWsMsgResponse.ADAPTER.redact(r13);
        L11:
            SubscribeWsStatusResponse r14 = r10.subscribeWsStatusResponse;
            if (r14 == null) goto L14;
            r10.subscribeWsStatusResponse = SubscribeWsStatusResponse.ADAPTER.redact(r14);
        L14:
            SubscribeWsMsgByProviderResponse r15 = r10.subscribeWsMsgByProviderResponse;
            if (r15 == null) goto L17;
            r10.subscribeWsMsgByProviderResponse = SubscribeWsMsgByProviderResponse.ADAPTER.redact(r15);
        L17:
            SubscribeWsMsgByCallBackResponse r16 = r10.subscribeWsMsgByCallBackResponse;
            if (r16 == null) goto L20;
            r10.subscribeWsMsgByCallBackResponse = SubscribeWsMsgByCallBackResponse.ADAPTER.redact(r16);
        L20:
            SubscribeWsMsgByBroadCastResponse r17 = r10.subscribeWsMsgByBroadCastResponse;
            if (r17 == null) goto L23;
            r10.subscribeWsMsgByBroadCastResponse = SubscribeWsMsgByBroadCastResponse.ADAPTER.redact(r17);
        L23:
            GetLocationResponse r18 = r10.getLocationResponse;
            if (r18 == null) goto L26;
            r10.getLocationResponse = GetLocationResponse.ADAPTER.redact(r18);
        L26:
            RefreshLocationResponse r19 = r10.refreshLocationResponse;
            if (r19 == null) goto L29;
            r10.refreshLocationResponse = RefreshLocationResponse.ADAPTER.redact(r19);
        L29:
            DecodeLocationResponse r20 = r10.decodeLocationResponse;
            if (r20 == null) goto L32;
            r10.decodeLocationResponse = DecodeLocationResponse.ADAPTER.redact(r20);
        L32:
            GetIntersectFencesResponse r21 = r10.getIntersectFencesResponse;
            if (r21 == null) goto L35;
            r10.getIntersectFencesResponse = GetIntersectFencesResponse.ADAPTER.redact(r21);
        L35:
            StartPicoLinksResponse r22 = r10.startPicoLinksResponse;
            if (r22 == null) goto L38;
            r10.startPicoLinksResponse = StartPicoLinksResponse.ADAPTER.redact(r22);
        L38:
            OnePartyCommonNetworkResponse r23 = r10.onePartyCommonNetworkResponse;
            if (r23 == null) goto L41;
            r10.onePartyCommonNetworkResponse = OnePartyCommonNetworkResponse.ADAPTER.redact(r23);
        L41:
            SendApplogEventResponse r24 = r10.sendApplogEventResponse;
            if (r24 == null) goto L44;
            r10.sendApplogEventResponse = SendApplogEventResponse.ADAPTER.redact(r24);
        L44:
            GenericNetworkResponse r25 = r10.genericNetworkResponse;
            if (r25 == null) goto L47;
            r10.genericNetworkResponse = GenericNetworkResponse.ADAPTER.redact(r25);
        L47:
            GetTTNetParametersResponse r26 = r10.getTTNetParametersResponse;
            if (r26 == null) goto L50;
            r10.getTTNetParametersResponse = GetTTNetParametersResponse.ADAPTER.redact(r26);
        L50:
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ResponseBody();
    }

    public ResponseBody(BizExampleResponse r19, SendWsMessageResponse r20, SubscribeWsMsgResponse r21, SubscribeWsStatusResponse r22, SubscribeWsMsgByProviderResponse r23, SubscribeWsMsgByCallBackResponse r24, SubscribeWsMsgByBroadCastResponse r25, GetLocationResponse r26, RefreshLocationResponse r27, DecodeLocationResponse r28, GetIntersectFencesResponse r29, StartPicoLinksResponse r30, OnePartyCommonNetworkResponse r31, SendApplogEventResponse r32, GenericNetworkResponse r33, GetTTNetParametersResponse r34) {
        this(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ResponseBody) == true) goto L8;
        return false;
    L8:
        ResponseBody r10 = (ResponseBody) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L44;
        if (Internal.equals(this.bizExampleResponse, r10.bizExampleResponse) == false) goto L44;
        if (Internal.equals(this.sendWsMessageResponse, r10.sendWsMessageResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgResponse, r10.subscribeWsMsgResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsStatusResponse, r10.subscribeWsStatusResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgByProviderResponse, r10.subscribeWsMsgByProviderResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgByCallBackResponse, r10.subscribeWsMsgByCallBackResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgByBroadCastResponse, r10.subscribeWsMsgByBroadCastResponse) == false) goto L44;
        if (Internal.equals(this.getLocationResponse, r10.getLocationResponse) == false) goto L44;
        if (Internal.equals(this.refreshLocationResponse, r10.refreshLocationResponse) == false) goto L44;
        if (Internal.equals(this.decodeLocationResponse, r10.decodeLocationResponse) == false) goto L44;
        if (Internal.equals(this.getIntersectFencesResponse, r10.getIntersectFencesResponse) == false) goto L44;
        if (Internal.equals(this.startPicoLinksResponse, r10.startPicoLinksResponse) == false) goto L44;
        if (Internal.equals(this.onePartyCommonNetworkResponse, r10.onePartyCommonNetworkResponse) == false) goto L44;
        if (Internal.equals(this.sendApplogEventResponse, r10.sendApplogEventResponse) == false) goto L44;
        if (Internal.equals(this.genericNetworkResponse, r10.genericNetworkResponse) == false) goto L44;
        if (Internal.equals(this.getTTNetParametersResponse, r10.getTTNetParametersResponse) == false) goto L44;
        return true;
    L44:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L69;
        int r10 = unknownFields().hashCode() * 37;
        BizExampleResponse r11 = this.bizExampleResponse;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        SendWsMessageResponse r15 = this.sendWsMessageResponse;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        SubscribeWsMsgResponse r18 = this.subscribeWsMsgResponse;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        SubscribeWsStatusResponse r21 = this.subscribeWsStatusResponse;
        if (r21 == null) goto L19;
        int r22 = r21.hashCode();
    L20:
        int r23 = (r20 + r22) * 37;
        SubscribeWsMsgByProviderResponse r24 = this.subscribeWsMsgByProviderResponse;
        if (r24 == null) goto L23;
        int r25 = r24.hashCode();
    L24:
        int r26 = (r23 + r25) * 37;
        SubscribeWsMsgByCallBackResponse r27 = this.subscribeWsMsgByCallBackResponse;
        if (r27 == null) goto L27;
        int r28 = r27.hashCode();
    L28:
        int r29 = (r26 + r28) * 37;
        SubscribeWsMsgByBroadCastResponse r30 = this.subscribeWsMsgByBroadCastResponse;
        if (r30 == null) goto L31;
        int r31 = r30.hashCode();
    L32:
        int r32 = (r29 + r31) * 37;
        GetLocationResponse r33 = this.getLocationResponse;
        if (r33 == null) goto L35;
        int r34 = r33.hashCode();
    L36:
        int r35 = (r32 + r34) * 37;
        RefreshLocationResponse r36 = this.refreshLocationResponse;
        if (r36 == null) goto L39;
        int r37 = r36.hashCode();
    L40:
        int r38 = (r35 + r37) * 37;
        DecodeLocationResponse r39 = this.decodeLocationResponse;
        if (r39 == null) goto L43;
        int r40 = r39.hashCode();
    L44:
        int r41 = (r38 + r40) * 37;
        GetIntersectFencesResponse r42 = this.getIntersectFencesResponse;
        if (r42 == null) goto L47;
        int r43 = r42.hashCode();
    L48:
        int r44 = (r41 + r43) * 37;
        StartPicoLinksResponse r45 = this.startPicoLinksResponse;
        if (r45 == null) goto L51;
        int r46 = r45.hashCode();
    L52:
        int r47 = (r44 + r46) * 37;
        OnePartyCommonNetworkResponse r48 = this.onePartyCommonNetworkResponse;
        if (r48 == null) goto L55;
        int r49 = r48.hashCode();
    L56:
        int r50 = (r47 + r49) * 37;
        SendApplogEventResponse r51 = this.sendApplogEventResponse;
        if (r51 == null) goto L59;
        int r52 = r51.hashCode();
    L60:
        int r53 = (r50 + r52) * 37;
        GenericNetworkResponse r54 = this.genericNetworkResponse;
        if (r54 == null) goto L63;
        int r55 = r54.hashCode();
    L64:
        int r56 = (r53 + r55) * 37;
        GetTTNetParametersResponse r57 = this.getTTNetParametersResponse;
        if (r57 == null) goto L67;
        r12 = r57.hashCode();
    L67:
        int r58 = r56 + r12;
        this.hashCode = r58;
        return r58;
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
    L69:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.bizExampleResponse == null) goto L6;
        r5.append(", bizExampleResponse=");
        r5.append(this.bizExampleResponse);
    L6:
        if (this.sendWsMessageResponse == null) goto L9;
        r5.append(", sendWsMessageResponse=");
        r5.append(this.sendWsMessageResponse);
    L9:
        if (this.subscribeWsMsgResponse == null) goto L12;
        r5.append(", subscribeWsMsgResponse=");
        r5.append(this.subscribeWsMsgResponse);
    L12:
        if (this.subscribeWsStatusResponse == null) goto L15;
        r5.append(", subscribeWsStatusResponse=");
        r5.append(this.subscribeWsStatusResponse);
    L15:
        if (this.subscribeWsMsgByProviderResponse == null) goto L18;
        r5.append(", subscribeWsMsgByProviderResponse=");
        r5.append(this.subscribeWsMsgByProviderResponse);
    L18:
        if (this.subscribeWsMsgByCallBackResponse == null) goto L21;
        r5.append(", subscribeWsMsgByCallBackResponse=");
        r5.append(this.subscribeWsMsgByCallBackResponse);
    L21:
        if (this.subscribeWsMsgByBroadCastResponse == null) goto L24;
        r5.append(", subscribeWsMsgByBroadCastResponse=");
        r5.append(this.subscribeWsMsgByBroadCastResponse);
    L24:
        if (this.getLocationResponse == null) goto L27;
        r5.append(", getLocationResponse=");
        r5.append(this.getLocationResponse);
    L27:
        if (this.refreshLocationResponse == null) goto L30;
        r5.append(", refreshLocationResponse=");
        r5.append(this.refreshLocationResponse);
    L30:
        if (this.decodeLocationResponse == null) goto L33;
        r5.append(", decodeLocationResponse=");
        r5.append(this.decodeLocationResponse);
    L33:
        if (this.getIntersectFencesResponse == null) goto L36;
        r5.append(", getIntersectFencesResponse=");
        r5.append(this.getIntersectFencesResponse);
    L36:
        if (this.startPicoLinksResponse == null) goto L39;
        r5.append(", startPicoLinksResponse=");
        r5.append(this.startPicoLinksResponse);
    L39:
        if (this.onePartyCommonNetworkResponse == null) goto L42;
        r5.append(", onePartyCommonNetworkResponse=");
        r5.append(this.onePartyCommonNetworkResponse);
    L42:
        if (this.sendApplogEventResponse == null) goto L45;
        r5.append(", sendApplogEventResponse=");
        r5.append(this.sendApplogEventResponse);
    L45:
        if (this.genericNetworkResponse == null) goto L48;
        r5.append(", genericNetworkResponse=");
        r5.append(this.genericNetworkResponse);
    L48:
        if (this.getTTNetParametersResponse == null) goto L51;
        r5.append(", getTTNetParametersResponse=");
        r5.append(this.getTTNetParametersResponse);
    L51:
        return a.s(r5, 0, 2, "ResponseBody{", '}');
    }

    public ResponseBody(BizExampleResponse r5, SendWsMessageResponse r10, SubscribeWsMsgResponse r11, SubscribeWsStatusResponse r12, SubscribeWsMsgByProviderResponse r13, SubscribeWsMsgByCallBackResponse r14, SubscribeWsMsgByBroadCastResponse r15, GetLocationResponse r16, RefreshLocationResponse r17, DecodeLocationResponse r18, GetIntersectFencesResponse r19, StartPicoLinksResponse r110, OnePartyCommonNetworkResponse r111, SendApplogEventResponse r112, GenericNetworkResponse r113, GetTTNetParametersResponse r114, ByteString r20) {
        super(ADAPTER, r20);
        this.bizExampleResponse = r5;
        this.sendWsMessageResponse = r10;
        this.subscribeWsMsgResponse = r11;
        this.subscribeWsStatusResponse = r12;
        this.subscribeWsMsgByProviderResponse = r13;
        this.subscribeWsMsgByCallBackResponse = r14;
        this.subscribeWsMsgByBroadCastResponse = r15;
        this.getLocationResponse = r16;
        this.refreshLocationResponse = r17;
        this.decodeLocationResponse = r18;
        this.getIntersectFencesResponse = r19;
        this.startPicoLinksResponse = r110;
        this.onePartyCommonNetworkResponse = r111;
        this.sendApplogEventResponse = r112;
        this.genericNetworkResponse = r113;
        this.getTTNetParametersResponse = r114;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.bizExampleResponse = this.bizExampleResponse;
        r5.sendWsMessageResponse = this.sendWsMessageResponse;
        r5.subscribeWsMsgResponse = this.subscribeWsMsgResponse;
        r5.subscribeWsStatusResponse = this.subscribeWsStatusResponse;
        r5.subscribeWsMsgByProviderResponse = this.subscribeWsMsgByProviderResponse;
        r5.subscribeWsMsgByCallBackResponse = this.subscribeWsMsgByCallBackResponse;
        r5.subscribeWsMsgByBroadCastResponse = this.subscribeWsMsgByBroadCastResponse;
        r5.getLocationResponse = this.getLocationResponse;
        r5.refreshLocationResponse = this.refreshLocationResponse;
        r5.decodeLocationResponse = this.decodeLocationResponse;
        r5.getIntersectFencesResponse = this.getIntersectFencesResponse;
        r5.startPicoLinksResponse = this.startPicoLinksResponse;
        r5.onePartyCommonNetworkResponse = this.onePartyCommonNetworkResponse;
        r5.sendApplogEventResponse = this.sendApplogEventResponse;
        r5.genericNetworkResponse = this.genericNetworkResponse;
        r5.getTTNetParametersResponse = this.getTTNetParametersResponse;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
