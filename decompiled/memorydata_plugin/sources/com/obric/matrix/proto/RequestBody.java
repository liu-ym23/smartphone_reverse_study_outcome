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
public final class RequestBody extends Message<RequestBody, a> {
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

    public static final class a extends Message.Builder<RequestBody, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BizExampleRequest f8205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SendWsMessageRequest f8206b;
        public SubscribeWsMsgRequest c;
        public SubscribeWsStatusRequest d;
        public SubscribeWsMsgByProviderRequest e;
        public SubscribeWsMsgByCallBackRequest f;
        public SubscribeWsMsgByBroadCastRequest g;
        public GetLocationRequest h;
        public RefreshLocationRequest i;
        public DecodeLocationRequest j;
        public GetIntersectFencesRequest k;
        public StartPicoLinksRequest l;
        public PicoLinksCallback m;
        public OnePartyCommonNetworkRequest n;
        public SendApplogEventRequest o;
        public GenericNetworkRequest p;
        public GetTTNetParametersRequest q;

        public a() {
        }

        public a a(BizExampleRequest r1) {
            this.f8205a = r1;
            return this;
        }

        public a a(DecodeLocationRequest r1) {
            this.j = r1;
            return this;
        }

        public a a(GenericNetworkRequest r1) {
            this.p = r1;
            return this;
        }

        public a a(GetIntersectFencesRequest r1) {
            this.k = r1;
            return this;
        }

        public a a(GetLocationRequest r1) {
            this.h = r1;
            return this;
        }

        public a a(GetTTNetParametersRequest r1) {
            this.q = r1;
            return this;
        }

        public a a(OnePartyCommonNetworkRequest r1) {
            this.n = r1;
            return this;
        }

        public a a(PicoLinksCallback r1) {
            this.m = r1;
            return this;
        }

        public a a(RefreshLocationRequest r1) {
            this.i = r1;
            return this;
        }

        public a a(SendApplogEventRequest r1) {
            this.o = r1;
            return this;
        }

        public a a(SendWsMessageRequest r1) {
            this.f8206b = r1;
            return this;
        }

        public a a(StartPicoLinksRequest r1) {
            this.l = r1;
            return this;
        }

        public a a(SubscribeWsMsgByBroadCastRequest r1) {
            this.g = r1;
            return this;
        }

        public a a(SubscribeWsMsgByCallBackRequest r1) {
            this.f = r1;
            return this;
        }

        public a a(SubscribeWsMsgByProviderRequest r1) {
            this.e = r1;
            return this;
        }

        public a a(SubscribeWsMsgRequest r1) {
            this.c = r1;
            return this;
        }

        public a a(SubscribeWsStatusRequest r1) {
            this.d = r1;
            return this;
        }

        public RequestBody a() {
            return new RequestBody(this.f8205a, this.f8206b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<RequestBody> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, RequestBody.class);
        }

        public int a(RequestBody r4) {
            return ((((((((((((((((BizExampleRequest.ADAPTER.encodedSizeWithTag(100000, r4.bizExampleRequest) + SendWsMessageRequest.ADAPTER.encodedSizeWithTag(101001, r4.sendWsMessageRequest)) + SubscribeWsMsgRequest.ADAPTER.encodedSizeWithTag(101002, r4.subscribeWsMsgRequest)) + SubscribeWsStatusRequest.ADAPTER.encodedSizeWithTag(101003, r4.subscribeWsStatusRequest)) + SubscribeWsMsgByProviderRequest.ADAPTER.encodedSizeWithTag(101004, r4.subscribeWsMsgByProviderRequest)) + SubscribeWsMsgByCallBackRequest.ADAPTER.encodedSizeWithTag(101005, r4.subscribeWsMsgByCallBackRequest)) + SubscribeWsMsgByBroadCastRequest.ADAPTER.encodedSizeWithTag(101006, r4.subscribeWsMsgByBroadCastRequest)) + GetLocationRequest.ADAPTER.encodedSizeWithTag(102001, r4.getLocationRequest)) + RefreshLocationRequest.ADAPTER.encodedSizeWithTag(102002, r4.refreshLocationRequest)) + DecodeLocationRequest.ADAPTER.encodedSizeWithTag(102003, r4.decodeLocationRequest)) + GetIntersectFencesRequest.ADAPTER.encodedSizeWithTag(102004, r4.getIntersectFencesRequest)) + StartPicoLinksRequest.ADAPTER.encodedSizeWithTag(111001, r4.startPicoLinksRequest)) + PicoLinksCallback.ADAPTER.encodedSizeWithTag(111002, r4.picoLinksCallback)) + OnePartyCommonNetworkRequest.ADAPTER.encodedSizeWithTag(112001, r4.onePartyCommonNetworkRequest)) + SendApplogEventRequest.ADAPTER.encodedSizeWithTag(112002, r4.sendApplogEventRequest)) + GenericNetworkRequest.ADAPTER.encodedSizeWithTag(112003, r4.genericNetworkRequest)) + GetTTNetParametersRequest.ADAPTER.encodedSizeWithTag(112004, r4.getTTNetParametersRequest)) + r4.unknownFields().size();
        }

        public RequestBody a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L29;
            if (r2 != 100000) goto L7;
            r5.a((BizExampleRequest) ZeusTransformUtils.preCheckCast(BizExampleRequest.ADAPTER.decode(r6), BizExampleRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            switch(r2) {
                case 101001: goto L27;
                case 101002: goto L26;
                case 101003: goto L25;
                case 101004: goto L24;
                case 101005: goto L23;
                case 101006: goto L22;
                default: goto L8;
            };
        L22:
            r5.a((SubscribeWsMsgByBroadCastRequest) ZeusTransformUtils.preCheckCast(SubscribeWsMsgByBroadCastRequest.ADAPTER.decode(r6), SubscribeWsMsgByBroadCastRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L23:
            r5.a((SubscribeWsMsgByCallBackRequest) ZeusTransformUtils.preCheckCast(SubscribeWsMsgByCallBackRequest.ADAPTER.decode(r6), SubscribeWsMsgByCallBackRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L24:
            r5.a((SubscribeWsMsgByProviderRequest) ZeusTransformUtils.preCheckCast(SubscribeWsMsgByProviderRequest.ADAPTER.decode(r6), SubscribeWsMsgByProviderRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L25:
            r5.a((SubscribeWsStatusRequest) ZeusTransformUtils.preCheckCast(SubscribeWsStatusRequest.ADAPTER.decode(r6), SubscribeWsStatusRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L26:
            r5.a((SubscribeWsMsgRequest) ZeusTransformUtils.preCheckCast(SubscribeWsMsgRequest.ADAPTER.decode(r6), SubscribeWsMsgRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L27:
            r5.a((SendWsMessageRequest) ZeusTransformUtils.preCheckCast(SendWsMessageRequest.ADAPTER.decode(r6), SendWsMessageRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            switch(r2) {
                case 102001: goto L21;
                case 102002: goto L20;
                case 102003: goto L19;
                case 102004: goto L18;
                default: goto L9;
            };
        L18:
            r5.a((GetIntersectFencesRequest) ZeusTransformUtils.preCheckCast(GetIntersectFencesRequest.ADAPTER.decode(r6), GetIntersectFencesRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L19:
            r5.a((DecodeLocationRequest) ZeusTransformUtils.preCheckCast(DecodeLocationRequest.ADAPTER.decode(r6), DecodeLocationRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L20:
            r5.a((RefreshLocationRequest) ZeusTransformUtils.preCheckCast(RefreshLocationRequest.ADAPTER.decode(r6), RefreshLocationRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L21:
            r5.a((GetLocationRequest) ZeusTransformUtils.preCheckCast(GetLocationRequest.ADAPTER.decode(r6), GetLocationRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            switch(r2) {
                case 111001: goto L17;
                case 111002: goto L16;
                default: goto L10;
            };
        L16:
            r5.a((PicoLinksCallback) ZeusTransformUtils.preCheckCast(PicoLinksCallback.ADAPTER.decode(r6), PicoLinksCallback.class, "com.obric.memorydata.plugin"));
            goto L3
        L17:
            r5.a((StartPicoLinksRequest) ZeusTransformUtils.preCheckCast(StartPicoLinksRequest.ADAPTER.decode(r6), StartPicoLinksRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            switch(r2) {
                case 112001: goto L15;
                case 112002: goto L14;
                case 112003: goto L13;
                case 112004: goto L12;
                default: goto L11;
            };
        L12:
            r5.a((GetTTNetParametersRequest) ZeusTransformUtils.preCheckCast(GetTTNetParametersRequest.ADAPTER.decode(r6), GetTTNetParametersRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L13:
            r5.a((GenericNetworkRequest) ZeusTransformUtils.preCheckCast(GenericNetworkRequest.ADAPTER.decode(r6), GenericNetworkRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L14:
            r5.a((SendApplogEventRequest) ZeusTransformUtils.preCheckCast(SendApplogEventRequest.ADAPTER.decode(r6), SendApplogEventRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L15:
            r5.a((OnePartyCommonNetworkRequest) ZeusTransformUtils.preCheckCast(OnePartyCommonNetworkRequest.ADAPTER.decode(r6), OnePartyCommonNetworkRequest.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L29:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, RequestBody r4) {
            BizExampleRequest.ADAPTER.encodeWithTag(r3, 100000, r4.bizExampleRequest);
            SendWsMessageRequest.ADAPTER.encodeWithTag(r3, 101001, r4.sendWsMessageRequest);
            SubscribeWsMsgRequest.ADAPTER.encodeWithTag(r3, 101002, r4.subscribeWsMsgRequest);
            SubscribeWsStatusRequest.ADAPTER.encodeWithTag(r3, 101003, r4.subscribeWsStatusRequest);
            SubscribeWsMsgByProviderRequest.ADAPTER.encodeWithTag(r3, 101004, r4.subscribeWsMsgByProviderRequest);
            SubscribeWsMsgByCallBackRequest.ADAPTER.encodeWithTag(r3, 101005, r4.subscribeWsMsgByCallBackRequest);
            SubscribeWsMsgByBroadCastRequest.ADAPTER.encodeWithTag(r3, 101006, r4.subscribeWsMsgByBroadCastRequest);
            GetLocationRequest.ADAPTER.encodeWithTag(r3, 102001, r4.getLocationRequest);
            RefreshLocationRequest.ADAPTER.encodeWithTag(r3, 102002, r4.refreshLocationRequest);
            DecodeLocationRequest.ADAPTER.encodeWithTag(r3, 102003, r4.decodeLocationRequest);
            GetIntersectFencesRequest.ADAPTER.encodeWithTag(r3, 102004, r4.getIntersectFencesRequest);
            StartPicoLinksRequest.ADAPTER.encodeWithTag(r3, 111001, r4.startPicoLinksRequest);
            PicoLinksCallback.ADAPTER.encodeWithTag(r3, 111002, r4.picoLinksCallback);
            OnePartyCommonNetworkRequest.ADAPTER.encodeWithTag(r3, 112001, r4.onePartyCommonNetworkRequest);
            SendApplogEventRequest.ADAPTER.encodeWithTag(r3, 112002, r4.sendApplogEventRequest);
            GenericNetworkRequest.ADAPTER.encodeWithTag(r3, 112003, r4.genericNetworkRequest);
            GetTTNetParametersRequest.ADAPTER.encodeWithTag(r3, 112004, r4.getTTNetParametersRequest);
            r3.writeBytes(r4.unknownFields());
        }

        public RequestBody b(RequestBody r3) {
            a r2 = r3.newBuilder();
            if (r2.f8205a == null) goto L6;
            r2.f8205a = (BizExampleRequest) ZeusTransformUtils.preCheckCast(BizExampleRequest.ADAPTER.redact(r2.f8205a), BizExampleRequest.class, "com.obric.memorydata.plugin");
        L6:
            if (r2.f8206b == null) goto L9;
            r2.f8206b = (SendWsMessageRequest) ZeusTransformUtils.preCheckCast(SendWsMessageRequest.ADAPTER.redact(r2.f8206b), SendWsMessageRequest.class, "com.obric.memorydata.plugin");
        L9:
            if (r2.c == null) goto L12;
            r2.c = (SubscribeWsMsgRequest) ZeusTransformUtils.preCheckCast(SubscribeWsMsgRequest.ADAPTER.redact(r2.c), SubscribeWsMsgRequest.class, "com.obric.memorydata.plugin");
        L12:
            if (r2.d == null) goto L15;
            r2.d = (SubscribeWsStatusRequest) ZeusTransformUtils.preCheckCast(SubscribeWsStatusRequest.ADAPTER.redact(r2.d), SubscribeWsStatusRequest.class, "com.obric.memorydata.plugin");
        L15:
            if (r2.e == null) goto L18;
            r2.e = (SubscribeWsMsgByProviderRequest) ZeusTransformUtils.preCheckCast(SubscribeWsMsgByProviderRequest.ADAPTER.redact(r2.e), SubscribeWsMsgByProviderRequest.class, "com.obric.memorydata.plugin");
        L18:
            if (r2.f == null) goto L21;
            r2.f = (SubscribeWsMsgByCallBackRequest) ZeusTransformUtils.preCheckCast(SubscribeWsMsgByCallBackRequest.ADAPTER.redact(r2.f), SubscribeWsMsgByCallBackRequest.class, "com.obric.memorydata.plugin");
        L21:
            if (r2.g == null) goto L24;
            r2.g = (SubscribeWsMsgByBroadCastRequest) ZeusTransformUtils.preCheckCast(SubscribeWsMsgByBroadCastRequest.ADAPTER.redact(r2.g), SubscribeWsMsgByBroadCastRequest.class, "com.obric.memorydata.plugin");
        L24:
            if (r2.h == null) goto L27;
            r2.h = (GetLocationRequest) ZeusTransformUtils.preCheckCast(GetLocationRequest.ADAPTER.redact(r2.h), GetLocationRequest.class, "com.obric.memorydata.plugin");
        L27:
            if (r2.i == null) goto L30;
            r2.i = (RefreshLocationRequest) ZeusTransformUtils.preCheckCast(RefreshLocationRequest.ADAPTER.redact(r2.i), RefreshLocationRequest.class, "com.obric.memorydata.plugin");
        L30:
            if (r2.j == null) goto L33;
            r2.j = (DecodeLocationRequest) ZeusTransformUtils.preCheckCast(DecodeLocationRequest.ADAPTER.redact(r2.j), DecodeLocationRequest.class, "com.obric.memorydata.plugin");
        L33:
            if (r2.k == null) goto L36;
            r2.k = (GetIntersectFencesRequest) ZeusTransformUtils.preCheckCast(GetIntersectFencesRequest.ADAPTER.redact(r2.k), GetIntersectFencesRequest.class, "com.obric.memorydata.plugin");
        L36:
            if (r2.l == null) goto L39;
            r2.l = (StartPicoLinksRequest) ZeusTransformUtils.preCheckCast(StartPicoLinksRequest.ADAPTER.redact(r2.l), StartPicoLinksRequest.class, "com.obric.memorydata.plugin");
        L39:
            if (r2.m == null) goto L42;
            r2.m = (PicoLinksCallback) ZeusTransformUtils.preCheckCast(PicoLinksCallback.ADAPTER.redact(r2.m), PicoLinksCallback.class, "com.obric.memorydata.plugin");
        L42:
            if (r2.n == null) goto L45;
            r2.n = (OnePartyCommonNetworkRequest) ZeusTransformUtils.preCheckCast(OnePartyCommonNetworkRequest.ADAPTER.redact(r2.n), OnePartyCommonNetworkRequest.class, "com.obric.memorydata.plugin");
        L45:
            if (r2.o == null) goto L48;
            r2.o = (SendApplogEventRequest) ZeusTransformUtils.preCheckCast(SendApplogEventRequest.ADAPTER.redact(r2.o), SendApplogEventRequest.class, "com.obric.memorydata.plugin");
        L48:
            if (r2.p == null) goto L51;
            r2.p = (GenericNetworkRequest) ZeusTransformUtils.preCheckCast(GenericNetworkRequest.ADAPTER.redact(r2.p), GenericNetworkRequest.class, "com.obric.memorydata.plugin");
        L51:
            if (r2.q == null) goto L53;
            r2.q = (GetTTNetParametersRequest) ZeusTransformUtils.preCheckCast(GetTTNetParametersRequest.ADAPTER.redact(r2.q), GetTTNetParametersRequest.class, "com.obric.memorydata.plugin");
        L53:
            r2.clearUnknownFields();
            return r2.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ RequestBody decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, RequestBody r4) {
            a(r3, (RequestBody) ZeusTransformUtils.preCheckCast(r4, RequestBody.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(RequestBody r3) {
            return a((RequestBody) ZeusTransformUtils.preCheckCast(r3, RequestBody.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ RequestBody redact(RequestBody r3) {
            return b((RequestBody) ZeusTransformUtils.preCheckCast(r3, RequestBody.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
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

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, RequestBody.class) == true) goto L8;
        return false;
    L8:
        RequestBody r6 = (RequestBody) ZeusTransformUtils.preCheckCast(r5, RequestBody.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L46;
        if (Internal.equals(this.bizExampleRequest, r6.bizExampleRequest) == false) goto L46;
        if (Internal.equals(this.sendWsMessageRequest, r6.sendWsMessageRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgRequest, r6.subscribeWsMsgRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsStatusRequest, r6.subscribeWsStatusRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgByProviderRequest, r6.subscribeWsMsgByProviderRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgByCallBackRequest, r6.subscribeWsMsgByCallBackRequest) == false) goto L46;
        if (Internal.equals(this.subscribeWsMsgByBroadCastRequest, r6.subscribeWsMsgByBroadCastRequest) == false) goto L46;
        if (Internal.equals(this.getLocationRequest, r6.getLocationRequest) == false) goto L46;
        if (Internal.equals(this.refreshLocationRequest, r6.refreshLocationRequest) == false) goto L46;
        if (Internal.equals(this.decodeLocationRequest, r6.decodeLocationRequest) == false) goto L46;
        if (Internal.equals(this.getIntersectFencesRequest, r6.getIntersectFencesRequest) == false) goto L46;
        if (Internal.equals(this.startPicoLinksRequest, r6.startPicoLinksRequest) == false) goto L46;
        if (Internal.equals(this.picoLinksCallback, r6.picoLinksCallback) == false) goto L46;
        if (Internal.equals(this.onePartyCommonNetworkRequest, r6.onePartyCommonNetworkRequest) == false) goto L46;
        if (Internal.equals(this.sendApplogEventRequest, r6.sendApplogEventRequest) == false) goto L46;
        if (Internal.equals(this.genericNetworkRequest, r6.genericNetworkRequest) == false) goto L46;
        if (Internal.equals(this.getTTNetParametersRequest, r6.getTTNetParametersRequest) == false) goto L46;
        return true;
    L46:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
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
        this.hashCode = r52;
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

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8205a = this.bizExampleRequest;
        r0.f8206b = this.sendWsMessageRequest;
        r0.c = this.subscribeWsMsgRequest;
        r0.d = this.subscribeWsStatusRequest;
        r0.e = this.subscribeWsMsgByProviderRequest;
        r0.f = this.subscribeWsMsgByCallBackRequest;
        r0.g = this.subscribeWsMsgByBroadCastRequest;
        r0.h = this.getLocationRequest;
        r0.i = this.refreshLocationRequest;
        r0.j = this.decodeLocationRequest;
        r0.k = this.getIntersectFencesRequest;
        r0.l = this.startPicoLinksRequest;
        r0.m = this.picoLinksCallback;
        r0.n = this.onePartyCommonNetworkRequest;
        r0.o = this.sendApplogEventRequest;
        r0.p = this.genericNetworkRequest;
        r0.q = this.getTTNetParametersRequest;
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
        if (this.bizExampleRequest == null) goto L6;
        r0.append(", bizExampleRequest=").append(this.bizExampleRequest);
    L6:
        if (this.sendWsMessageRequest == null) goto L9;
        r0.append(", sendWsMessageRequest=").append(this.sendWsMessageRequest);
    L9:
        if (this.subscribeWsMsgRequest == null) goto L12;
        r0.append(", subscribeWsMsgRequest=").append(this.subscribeWsMsgRequest);
    L12:
        if (this.subscribeWsStatusRequest == null) goto L15;
        r0.append(", subscribeWsStatusRequest=").append(this.subscribeWsStatusRequest);
    L15:
        if (this.subscribeWsMsgByProviderRequest == null) goto L18;
        r0.append(", subscribeWsMsgByProviderRequest=").append(this.subscribeWsMsgByProviderRequest);
    L18:
        if (this.subscribeWsMsgByCallBackRequest == null) goto L21;
        r0.append(", subscribeWsMsgByCallBackRequest=").append(this.subscribeWsMsgByCallBackRequest);
    L21:
        if (this.subscribeWsMsgByBroadCastRequest == null) goto L24;
        r0.append(", subscribeWsMsgByBroadCastRequest=").append(this.subscribeWsMsgByBroadCastRequest);
    L24:
        if (this.getLocationRequest == null) goto L27;
        r0.append(", getLocationRequest=").append(this.getLocationRequest);
    L27:
        if (this.refreshLocationRequest == null) goto L30;
        r0.append(", refreshLocationRequest=").append(this.refreshLocationRequest);
    L30:
        if (this.decodeLocationRequest == null) goto L33;
        r0.append(", decodeLocationRequest=").append(this.decodeLocationRequest);
    L33:
        if (this.getIntersectFencesRequest == null) goto L36;
        r0.append(", getIntersectFencesRequest=").append(this.getIntersectFencesRequest);
    L36:
        if (this.startPicoLinksRequest == null) goto L39;
        r0.append(", startPicoLinksRequest=").append(this.startPicoLinksRequest);
    L39:
        if (this.picoLinksCallback == null) goto L42;
        r0.append(", picoLinksCallback=").append(this.picoLinksCallback);
    L42:
        if (this.onePartyCommonNetworkRequest == null) goto L45;
        r0.append(", onePartyCommonNetworkRequest=").append(this.onePartyCommonNetworkRequest);
    L45:
        if (this.sendApplogEventRequest == null) goto L48;
        r0.append(", sendApplogEventRequest=").append(this.sendApplogEventRequest);
    L48:
        if (this.genericNetworkRequest == null) goto L51;
        r0.append(", genericNetworkRequest=").append(this.genericNetworkRequest);
    L51:
        if (this.getTTNetParametersRequest == null) goto L54;
        r0.append(", getTTNetParametersRequest=").append(this.getTTNetParametersRequest);
    L54:
        return r0.replace(0, 2, "RequestBody{").append('}').toString();
    }
}
