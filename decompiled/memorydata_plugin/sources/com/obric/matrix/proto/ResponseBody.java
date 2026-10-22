package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class ResponseBody extends Message<ResponseBody, a> {
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

    public static final class a extends Message.Builder<ResponseBody, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BizExampleResponse f8210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SendWsMessageResponse f8211b;
        public SubscribeWsMsgResponse c;
        public SubscribeWsStatusResponse d;
        public SubscribeWsMsgByProviderResponse e;
        public SubscribeWsMsgByCallBackResponse f;
        public SubscribeWsMsgByBroadCastResponse g;
        public GetLocationResponse h;
        public RefreshLocationResponse i;
        public DecodeLocationResponse j;
        public GetIntersectFencesResponse k;
        public StartPicoLinksResponse l;
        public OnePartyCommonNetworkResponse m;
        public SendApplogEventResponse n;
        public GenericNetworkResponse o;
        public GetTTNetParametersResponse p;

        public a() {
        }

        public a a(BizExampleResponse r1) {
            this.f8210a = r1;
            return this;
        }

        public a a(DecodeLocationResponse r1) {
            this.j = r1;
            return this;
        }

        public a a(GenericNetworkResponse r1) {
            this.o = r1;
            return this;
        }

        public a a(GetIntersectFencesResponse r1) {
            this.k = r1;
            return this;
        }

        public a a(GetLocationResponse r1) {
            this.h = r1;
            return this;
        }

        public a a(GetTTNetParametersResponse r1) {
            this.p = r1;
            return this;
        }

        public a a(OnePartyCommonNetworkResponse r1) {
            this.m = r1;
            return this;
        }

        public a a(RefreshLocationResponse r1) {
            this.i = r1;
            return this;
        }

        public a a(SendApplogEventResponse r1) {
            this.n = r1;
            return this;
        }

        public a a(SendWsMessageResponse r1) {
            this.f8211b = r1;
            return this;
        }

        public a a(StartPicoLinksResponse r1) {
            this.l = r1;
            return this;
        }

        public a a(SubscribeWsMsgByBroadCastResponse r1) {
            this.g = r1;
            return this;
        }

        public a a(SubscribeWsMsgByCallBackResponse r1) {
            this.f = r1;
            return this;
        }

        public a a(SubscribeWsMsgByProviderResponse r1) {
            this.e = r1;
            return this;
        }

        public a a(SubscribeWsMsgResponse r1) {
            this.c = r1;
            return this;
        }

        public a a(SubscribeWsStatusResponse r1) {
            this.d = r1;
            return this;
        }

        public ResponseBody a() {
            return new ResponseBody(this.f8210a, this.f8211b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<ResponseBody> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, ResponseBody.class);
        }

        public int a(ResponseBody r4) {
            return (((((((((((((((BizExampleResponse.ADAPTER.encodedSizeWithTag(100000, r4.bizExampleResponse) + SendWsMessageResponse.ADAPTER.encodedSizeWithTag(101001, r4.sendWsMessageResponse)) + SubscribeWsMsgResponse.ADAPTER.encodedSizeWithTag(101002, r4.subscribeWsMsgResponse)) + SubscribeWsStatusResponse.ADAPTER.encodedSizeWithTag(101003, r4.subscribeWsStatusResponse)) + SubscribeWsMsgByProviderResponse.ADAPTER.encodedSizeWithTag(101004, r4.subscribeWsMsgByProviderResponse)) + SubscribeWsMsgByCallBackResponse.ADAPTER.encodedSizeWithTag(101005, r4.subscribeWsMsgByCallBackResponse)) + SubscribeWsMsgByBroadCastResponse.ADAPTER.encodedSizeWithTag(101006, r4.subscribeWsMsgByBroadCastResponse)) + GetLocationResponse.ADAPTER.encodedSizeWithTag(102001, r4.getLocationResponse)) + RefreshLocationResponse.ADAPTER.encodedSizeWithTag(102002, r4.refreshLocationResponse)) + DecodeLocationResponse.ADAPTER.encodedSizeWithTag(102003, r4.decodeLocationResponse)) + GetIntersectFencesResponse.ADAPTER.encodedSizeWithTag(102004, r4.getIntersectFencesResponse)) + StartPicoLinksResponse.ADAPTER.encodedSizeWithTag(111001, r4.startPicoLinksResponse)) + OnePartyCommonNetworkResponse.ADAPTER.encodedSizeWithTag(112001, r4.onePartyCommonNetworkResponse)) + SendApplogEventResponse.ADAPTER.encodedSizeWithTag(112002, r4.sendApplogEventResponse)) + GenericNetworkResponse.ADAPTER.encodedSizeWithTag(112003, r4.genericNetworkResponse)) + GetTTNetParametersResponse.ADAPTER.encodedSizeWithTag(112004, r4.getTTNetParametersResponse)) + r4.unknownFields().size();
        }

        public ResponseBody a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L29;
            if (r2 != 100000) goto L8;
            r5.a((BizExampleResponse) ZeusTransformUtils.preCheckCast(BizExampleResponse.ADAPTER.decode(r6), BizExampleResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r2 != 111001) goto L9;
            r5.a((StartPicoLinksResponse) ZeusTransformUtils.preCheckCast(StartPicoLinksResponse.ADAPTER.decode(r6), StartPicoLinksResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            switch(r2) {
                case 101001: goto L26;
                case 101002: goto L25;
                case 101003: goto L24;
                case 101004: goto L23;
                case 101005: goto L22;
                case 101006: goto L21;
                default: goto L10;
            };
        L21:
            r5.a((SubscribeWsMsgByBroadCastResponse) ZeusTransformUtils.preCheckCast(SubscribeWsMsgByBroadCastResponse.ADAPTER.decode(r6), SubscribeWsMsgByBroadCastResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L22:
            r5.a((SubscribeWsMsgByCallBackResponse) ZeusTransformUtils.preCheckCast(SubscribeWsMsgByCallBackResponse.ADAPTER.decode(r6), SubscribeWsMsgByCallBackResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L23:
            r5.a((SubscribeWsMsgByProviderResponse) ZeusTransformUtils.preCheckCast(SubscribeWsMsgByProviderResponse.ADAPTER.decode(r6), SubscribeWsMsgByProviderResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L24:
            r5.a((SubscribeWsStatusResponse) ZeusTransformUtils.preCheckCast(SubscribeWsStatusResponse.ADAPTER.decode(r6), SubscribeWsStatusResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L25:
            r5.a((SubscribeWsMsgResponse) ZeusTransformUtils.preCheckCast(SubscribeWsMsgResponse.ADAPTER.decode(r6), SubscribeWsMsgResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L26:
            r5.a((SendWsMessageResponse) ZeusTransformUtils.preCheckCast(SendWsMessageResponse.ADAPTER.decode(r6), SendWsMessageResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            switch(r2) {
                case 102001: goto L20;
                case 102002: goto L19;
                case 102003: goto L18;
                case 102004: goto L17;
                default: goto L11;
            };
        L17:
            r5.a((GetIntersectFencesResponse) ZeusTransformUtils.preCheckCast(GetIntersectFencesResponse.ADAPTER.decode(r6), GetIntersectFencesResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L18:
            r5.a((DecodeLocationResponse) ZeusTransformUtils.preCheckCast(DecodeLocationResponse.ADAPTER.decode(r6), DecodeLocationResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L19:
            r5.a((RefreshLocationResponse) ZeusTransformUtils.preCheckCast(RefreshLocationResponse.ADAPTER.decode(r6), RefreshLocationResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L20:
            r5.a((GetLocationResponse) ZeusTransformUtils.preCheckCast(GetLocationResponse.ADAPTER.decode(r6), GetLocationResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            switch(r2) {
                case 112001: goto L16;
                case 112002: goto L15;
                case 112003: goto L14;
                case 112004: goto L13;
                default: goto L12;
            };
        L13:
            r5.a((GetTTNetParametersResponse) ZeusTransformUtils.preCheckCast(GetTTNetParametersResponse.ADAPTER.decode(r6), GetTTNetParametersResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L14:
            r5.a((GenericNetworkResponse) ZeusTransformUtils.preCheckCast(GenericNetworkResponse.ADAPTER.decode(r6), GenericNetworkResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L15:
            r5.a((SendApplogEventResponse) ZeusTransformUtils.preCheckCast(SendApplogEventResponse.ADAPTER.decode(r6), SendApplogEventResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L16:
            r5.a((OnePartyCommonNetworkResponse) ZeusTransformUtils.preCheckCast(OnePartyCommonNetworkResponse.ADAPTER.decode(r6), OnePartyCommonNetworkResponse.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L29:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, ResponseBody r4) {
            BizExampleResponse.ADAPTER.encodeWithTag(r3, 100000, r4.bizExampleResponse);
            SendWsMessageResponse.ADAPTER.encodeWithTag(r3, 101001, r4.sendWsMessageResponse);
            SubscribeWsMsgResponse.ADAPTER.encodeWithTag(r3, 101002, r4.subscribeWsMsgResponse);
            SubscribeWsStatusResponse.ADAPTER.encodeWithTag(r3, 101003, r4.subscribeWsStatusResponse);
            SubscribeWsMsgByProviderResponse.ADAPTER.encodeWithTag(r3, 101004, r4.subscribeWsMsgByProviderResponse);
            SubscribeWsMsgByCallBackResponse.ADAPTER.encodeWithTag(r3, 101005, r4.subscribeWsMsgByCallBackResponse);
            SubscribeWsMsgByBroadCastResponse.ADAPTER.encodeWithTag(r3, 101006, r4.subscribeWsMsgByBroadCastResponse);
            GetLocationResponse.ADAPTER.encodeWithTag(r3, 102001, r4.getLocationResponse);
            RefreshLocationResponse.ADAPTER.encodeWithTag(r3, 102002, r4.refreshLocationResponse);
            DecodeLocationResponse.ADAPTER.encodeWithTag(r3, 102003, r4.decodeLocationResponse);
            GetIntersectFencesResponse.ADAPTER.encodeWithTag(r3, 102004, r4.getIntersectFencesResponse);
            StartPicoLinksResponse.ADAPTER.encodeWithTag(r3, 111001, r4.startPicoLinksResponse);
            OnePartyCommonNetworkResponse.ADAPTER.encodeWithTag(r3, 112001, r4.onePartyCommonNetworkResponse);
            SendApplogEventResponse.ADAPTER.encodeWithTag(r3, 112002, r4.sendApplogEventResponse);
            GenericNetworkResponse.ADAPTER.encodeWithTag(r3, 112003, r4.genericNetworkResponse);
            GetTTNetParametersResponse.ADAPTER.encodeWithTag(r3, 112004, r4.getTTNetParametersResponse);
            r3.writeBytes(r4.unknownFields());
        }

        public ResponseBody b(ResponseBody r3) {
            a r2 = r3.newBuilder();
            if (r2.f8210a == null) goto L6;
            r2.f8210a = (BizExampleResponse) ZeusTransformUtils.preCheckCast(BizExampleResponse.ADAPTER.redact(r2.f8210a), BizExampleResponse.class, "com.obric.memorydata.plugin");
        L6:
            if (r2.f8211b == null) goto L9;
            r2.f8211b = (SendWsMessageResponse) ZeusTransformUtils.preCheckCast(SendWsMessageResponse.ADAPTER.redact(r2.f8211b), SendWsMessageResponse.class, "com.obric.memorydata.plugin");
        L9:
            if (r2.c == null) goto L12;
            r2.c = (SubscribeWsMsgResponse) ZeusTransformUtils.preCheckCast(SubscribeWsMsgResponse.ADAPTER.redact(r2.c), SubscribeWsMsgResponse.class, "com.obric.memorydata.plugin");
        L12:
            if (r2.d == null) goto L15;
            r2.d = (SubscribeWsStatusResponse) ZeusTransformUtils.preCheckCast(SubscribeWsStatusResponse.ADAPTER.redact(r2.d), SubscribeWsStatusResponse.class, "com.obric.memorydata.plugin");
        L15:
            if (r2.e == null) goto L18;
            r2.e = (SubscribeWsMsgByProviderResponse) ZeusTransformUtils.preCheckCast(SubscribeWsMsgByProviderResponse.ADAPTER.redact(r2.e), SubscribeWsMsgByProviderResponse.class, "com.obric.memorydata.plugin");
        L18:
            if (r2.f == null) goto L21;
            r2.f = (SubscribeWsMsgByCallBackResponse) ZeusTransformUtils.preCheckCast(SubscribeWsMsgByCallBackResponse.ADAPTER.redact(r2.f), SubscribeWsMsgByCallBackResponse.class, "com.obric.memorydata.plugin");
        L21:
            if (r2.g == null) goto L24;
            r2.g = (SubscribeWsMsgByBroadCastResponse) ZeusTransformUtils.preCheckCast(SubscribeWsMsgByBroadCastResponse.ADAPTER.redact(r2.g), SubscribeWsMsgByBroadCastResponse.class, "com.obric.memorydata.plugin");
        L24:
            if (r2.h == null) goto L27;
            r2.h = (GetLocationResponse) ZeusTransformUtils.preCheckCast(GetLocationResponse.ADAPTER.redact(r2.h), GetLocationResponse.class, "com.obric.memorydata.plugin");
        L27:
            if (r2.i == null) goto L30;
            r2.i = (RefreshLocationResponse) ZeusTransformUtils.preCheckCast(RefreshLocationResponse.ADAPTER.redact(r2.i), RefreshLocationResponse.class, "com.obric.memorydata.plugin");
        L30:
            if (r2.j == null) goto L33;
            r2.j = (DecodeLocationResponse) ZeusTransformUtils.preCheckCast(DecodeLocationResponse.ADAPTER.redact(r2.j), DecodeLocationResponse.class, "com.obric.memorydata.plugin");
        L33:
            if (r2.k == null) goto L36;
            r2.k = (GetIntersectFencesResponse) ZeusTransformUtils.preCheckCast(GetIntersectFencesResponse.ADAPTER.redact(r2.k), GetIntersectFencesResponse.class, "com.obric.memorydata.plugin");
        L36:
            if (r2.l == null) goto L39;
            r2.l = (StartPicoLinksResponse) ZeusTransformUtils.preCheckCast(StartPicoLinksResponse.ADAPTER.redact(r2.l), StartPicoLinksResponse.class, "com.obric.memorydata.plugin");
        L39:
            if (r2.m == null) goto L42;
            r2.m = (OnePartyCommonNetworkResponse) ZeusTransformUtils.preCheckCast(OnePartyCommonNetworkResponse.ADAPTER.redact(r2.m), OnePartyCommonNetworkResponse.class, "com.obric.memorydata.plugin");
        L42:
            if (r2.n == null) goto L45;
            r2.n = (SendApplogEventResponse) ZeusTransformUtils.preCheckCast(SendApplogEventResponse.ADAPTER.redact(r2.n), SendApplogEventResponse.class, "com.obric.memorydata.plugin");
        L45:
            if (r2.o == null) goto L48;
            r2.o = (GenericNetworkResponse) ZeusTransformUtils.preCheckCast(GenericNetworkResponse.ADAPTER.redact(r2.o), GenericNetworkResponse.class, "com.obric.memorydata.plugin");
        L48:
            if (r2.p == null) goto L50;
            r2.p = (GetTTNetParametersResponse) ZeusTransformUtils.preCheckCast(GetTTNetParametersResponse.ADAPTER.redact(r2.p), GetTTNetParametersResponse.class, "com.obric.memorydata.plugin");
        L50:
            r2.clearUnknownFields();
            return r2.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ResponseBody decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, ResponseBody r4) {
            a(r3, (ResponseBody) ZeusTransformUtils.preCheckCast(r4, ResponseBody.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(ResponseBody r3) {
            return a((ResponseBody) ZeusTransformUtils.preCheckCast(r3, ResponseBody.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ ResponseBody redact(ResponseBody r3) {
            return b((ResponseBody) ZeusTransformUtils.preCheckCast(r3, ResponseBody.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
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

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ResponseBody.class) == true) goto L8;
        return false;
    L8:
        ResponseBody r6 = (ResponseBody) ZeusTransformUtils.preCheckCast(r5, ResponseBody.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L44;
        if (Internal.equals(this.bizExampleResponse, r6.bizExampleResponse) == false) goto L44;
        if (Internal.equals(this.sendWsMessageResponse, r6.sendWsMessageResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgResponse, r6.subscribeWsMsgResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsStatusResponse, r6.subscribeWsStatusResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgByProviderResponse, r6.subscribeWsMsgByProviderResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgByCallBackResponse, r6.subscribeWsMsgByCallBackResponse) == false) goto L44;
        if (Internal.equals(this.subscribeWsMsgByBroadCastResponse, r6.subscribeWsMsgByBroadCastResponse) == false) goto L44;
        if (Internal.equals(this.getLocationResponse, r6.getLocationResponse) == false) goto L44;
        if (Internal.equals(this.refreshLocationResponse, r6.refreshLocationResponse) == false) goto L44;
        if (Internal.equals(this.decodeLocationResponse, r6.decodeLocationResponse) == false) goto L44;
        if (Internal.equals(this.getIntersectFencesResponse, r6.getIntersectFencesResponse) == false) goto L44;
        if (Internal.equals(this.startPicoLinksResponse, r6.startPicoLinksResponse) == false) goto L44;
        if (Internal.equals(this.onePartyCommonNetworkResponse, r6.onePartyCommonNetworkResponse) == false) goto L44;
        if (Internal.equals(this.sendApplogEventResponse, r6.sendApplogEventResponse) == false) goto L44;
        if (Internal.equals(this.genericNetworkResponse, r6.genericNetworkResponse) == false) goto L44;
        if (Internal.equals(this.getTTNetParametersResponse, r6.getTTNetParametersResponse) == false) goto L44;
        return true;
    L44:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
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
        this.hashCode = r49;
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

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8210a = this.bizExampleResponse;
        r0.f8211b = this.sendWsMessageResponse;
        r0.c = this.subscribeWsMsgResponse;
        r0.d = this.subscribeWsStatusResponse;
        r0.e = this.subscribeWsMsgByProviderResponse;
        r0.f = this.subscribeWsMsgByCallBackResponse;
        r0.g = this.subscribeWsMsgByBroadCastResponse;
        r0.h = this.getLocationResponse;
        r0.i = this.refreshLocationResponse;
        r0.j = this.decodeLocationResponse;
        r0.k = this.getIntersectFencesResponse;
        r0.l = this.startPicoLinksResponse;
        r0.m = this.onePartyCommonNetworkResponse;
        r0.n = this.sendApplogEventResponse;
        r0.o = this.genericNetworkResponse;
        r0.p = this.getTTNetParametersResponse;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.bizExampleResponse == null) goto L6;
        r0.append(", bizExampleResponse=").append(this.bizExampleResponse);
    L6:
        if (this.sendWsMessageResponse == null) goto L9;
        r0.append(", sendWsMessageResponse=").append(this.sendWsMessageResponse);
    L9:
        if (this.subscribeWsMsgResponse == null) goto L12;
        r0.append(", subscribeWsMsgResponse=").append(this.subscribeWsMsgResponse);
    L12:
        if (this.subscribeWsStatusResponse == null) goto L15;
        r0.append(", subscribeWsStatusResponse=").append(this.subscribeWsStatusResponse);
    L15:
        if (this.subscribeWsMsgByProviderResponse == null) goto L18;
        r0.append(", subscribeWsMsgByProviderResponse=").append(this.subscribeWsMsgByProviderResponse);
    L18:
        if (this.subscribeWsMsgByCallBackResponse == null) goto L21;
        r0.append(", subscribeWsMsgByCallBackResponse=").append(this.subscribeWsMsgByCallBackResponse);
    L21:
        if (this.subscribeWsMsgByBroadCastResponse == null) goto L24;
        r0.append(", subscribeWsMsgByBroadCastResponse=").append(this.subscribeWsMsgByBroadCastResponse);
    L24:
        if (this.getLocationResponse == null) goto L27;
        r0.append(", getLocationResponse=").append(this.getLocationResponse);
    L27:
        if (this.refreshLocationResponse == null) goto L30;
        r0.append(", refreshLocationResponse=").append(this.refreshLocationResponse);
    L30:
        if (this.decodeLocationResponse == null) goto L33;
        r0.append(", decodeLocationResponse=").append(this.decodeLocationResponse);
    L33:
        if (this.getIntersectFencesResponse == null) goto L36;
        r0.append(", getIntersectFencesResponse=").append(this.getIntersectFencesResponse);
    L36:
        if (this.startPicoLinksResponse == null) goto L39;
        r0.append(", startPicoLinksResponse=").append(this.startPicoLinksResponse);
    L39:
        if (this.onePartyCommonNetworkResponse == null) goto L42;
        r0.append(", onePartyCommonNetworkResponse=").append(this.onePartyCommonNetworkResponse);
    L42:
        if (this.sendApplogEventResponse == null) goto L45;
        r0.append(", sendApplogEventResponse=").append(this.sendApplogEventResponse);
    L45:
        if (this.genericNetworkResponse == null) goto L48;
        r0.append(", genericNetworkResponse=").append(this.genericNetworkResponse);
    L48:
        if (this.getTTNetParametersResponse == null) goto L51;
        r0.append(", getTTNetParametersResponse=").append(this.getTTNetParametersResponse);
    L51:
        return r0.replace(0, 2, "ResponseBody{").append('}').toString();
    }
}
