package com.obric.matrix.proto;

import com.bytedance.crash.event.EnsureReportData;
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
public final class SubscribeWsMsgByProviderRequest extends Message<SubscribeWsMsgByProviderRequest, a> {
    public static final ProtoAdapter<SubscribeWsMsgByProviderRequest> ADAPTER = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final Integer DEFAULT_OPT = null;
    public static final String DEFAULT_PACKAGENAME = "";
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @c(EnsureReportData.METHOD)
    public final Integer method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    @c("opt")
    public final Integer opt;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    @c("packageName")
    public final String packageName;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    @c("service")
    public final Integer service;

    public static final class a extends Message.Builder<SubscribeWsMsgByProviderRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f6114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f6115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f6116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f6117d;

        public a() {
            this.f6114a = 0;
            this.f6115b = 0;
            this.f6116c = "";
            this.f6117d = 0;
        }

        public SubscribeWsMsgByProviderRequest a() {
            return new SubscribeWsMsgByProviderRequest(this.f6114a, this.f6115b, this.f6116c, this.f6117d, super.buildUnknownFields());
        }

        public a b(Integer r10) {
            this.f6115b = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r10) {
            this.f6117d = r10;
            return this;
        }

        public a d(String r10) {
            this.f6116c = r10;
            return this;
        }

        public a e(Integer r10) {
            this.f6114a = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<SubscribeWsMsgByProviderRequest> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeWsMsgByProviderRequest.class);
        }

        public SubscribeWsMsgByProviderRequest a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L18;
            if (r13 != 1) goto L8;
            r11.e(ProtoAdapter.INT32.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L10;
            r11.b(ProtoAdapter.INT32.decode(r10));
            goto L3
        L10:
            if (r13 != 3) goto L12;
            r11.d(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            if (r13 != 4) goto L13;
            r11.c(ProtoAdapter.INT32.decode(r10));
            goto L3
        L13:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L18:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, SubscribeWsMsgByProviderRequest r11) {
            ProtoAdapter<Integer> r12 = ProtoAdapter.INT32;
            r12.encodeWithTag(r10, 1, r11.service);
            r12.encodeWithTag(r10, 2, r11.method);
            ProtoAdapter.STRING.encodeWithTag(r10, 3, r11.packageName);
            r12.encodeWithTag(r10, 4, r11.opt);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(SubscribeWsMsgByProviderRequest r10) {
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            return (((r11.encodedSizeWithTag(1, r10.service) + r11.encodedSizeWithTag(2, r10.method)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r10.packageName)) + r11.encodedSizeWithTag(4, r10.opt)) + r10.unknownFields().size();
        }

        public SubscribeWsMsgByProviderRequest d(SubscribeWsMsgByProviderRequest r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByProviderRequest decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, SubscribeWsMsgByProviderRequest r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeWsMsgByProviderRequest r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeWsMsgByProviderRequest redact(SubscribeWsMsgByProviderRequest r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_OPT = 0;
    }

    public SubscribeWsMsgByProviderRequest(Integer r10, Integer r11, String r12, Integer r13) {
        this(r10, r11, r12, r13, ByteString.EMPTY);
    }

    public SubscribeWsMsgByProviderRequest(Integer r10, Integer r11, String r12, Integer r13, ByteString r14) {
        super(ADAPTER, r14);
        this.service = r10;
        this.method = r11;
        this.packageName = r12;
        this.opt = r13;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SubscribeWsMsgByProviderRequest) == true) goto L8;
        return false;
    L8:
        SubscribeWsMsgByProviderRequest r11 = (SubscribeWsMsgByProviderRequest) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L20;
        if (Internal.equals(this.service, r11.service) == false) goto L20;
        if (Internal.equals(this.method, r11.method) == false) goto L20;
        if (Internal.equals(this.packageName, r11.packageName) == false) goto L20;
        if (Internal.equals(this.opt, r11.opt) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L21;
        int r11 = unknownFields().hashCode() * 37;
        Integer r12 = this.service;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Integer r16 = this.method;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        String r19 = this.packageName;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (r18 + r20) * 37;
        Integer r22 = this.opt;
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
        r10.f6114a = this.service;
        r10.f6115b = this.method;
        r10.f6116c = this.packageName;
        r10.f6117d = this.opt;
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
        if (this.service == null) goto L6;
        r10.append(", service=");
        r10.append(this.service);
    L6:
        if (this.method == null) goto L9;
        r10.append(", method=");
        r10.append(this.method);
    L9:
        if (this.packageName == null) goto L12;
        r10.append(", packageName=");
        r10.append(this.packageName);
    L12:
        if (this.opt == null) goto L14;
        r10.append(", opt=");
        r10.append(this.opt);
    L14:
        StringBuilder r11 = r10.replace(0, 2, "SubscribeWsMsgByProviderRequest{");
        r11.append('}');
        return r11.toString();
    }
}
