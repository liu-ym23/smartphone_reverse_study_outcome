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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class OnePartyCommonNetworkRequest extends Message<OnePartyCommonNetworkRequest, a> {
    public static final ProtoAdapter<OnePartyCommonNetworkRequest> ADAPTER = null;
    public static final Boolean DEFAULT_ADDCOMMONPARAM = null;
    public static final ByteString DEFAULT_BODY = null;
    public static final String DEFAULT_HOST = "";
    public static final NETWORK_METHOD DEFAULT_METHOD = null;
    public static final String DEFAULT_PATH = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    @c("addCommonParam")
    public final Boolean addCommonParam;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 6)
    @c("body")
    public final ByteString body;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    @c("extraMap")
    public final Map<String, String> extraMap;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    @c("fieldMap")
    public final Map<String, String> fieldMap;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    @c("headerParams")
    public final Map<String, String> headerParams;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @c("host")
    public final String host;

    @WireField(adapter = "com.obric.matrix.proto.NETWORK_METHOD#ADAPTER", label = WireField.Label.REQUIRED, tag = 3)
    @c(EnsureReportData.METHOD)
    public final NETWORK_METHOD method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @c("path")
    public final String path;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @c("queryParams")
    public final Map<String, String> queryParams;

    public static final class a extends Message.Builder<OnePartyCommonNetworkRequest, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public NETWORK_METHOD f5988c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f5989d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f5990e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ByteString f5991f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Map<String, String> f5992g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f5993h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Map<String, String> f5994i;

        public a() {
            this.f5986a = "";
            this.f5987b = "";
            this.f5988c = NETWORK_METHOD.METHOD_GET;
            this.f5991f = ByteString.EMPTY;
            this.f5993h = Boolean.FALSE;
            this.f5989d = Internal.newMutableMap();
            this.f5990e = Internal.newMutableMap();
            this.f5992g = Internal.newMutableMap();
            this.f5994i = Internal.newMutableMap();
        }

        public a a(Boolean r10) {
            this.f5993h = r10;
            return this;
        }

        public a b(ByteString r10) {
            this.f5991f = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return c();
        }

        public OnePartyCommonNetworkRequest c() {
            NETWORK_METHOD r10 = this.f5988c;
            if (r10 == null) goto L7;
            return new OnePartyCommonNetworkRequest(this.f5986a, this.f5987b, this.f5988c, this.f5989d, this.f5990e, this.f5991f, this.f5992g, this.f5993h, this.f5994i, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r10, EnsureReportData.METHOD});
        }

        public a d(String r10) {
            this.f5987b = r10;
            return this;
        }

        public a e(NETWORK_METHOD r10) {
            this.f5988c = r10;
            return this;
        }

        public a f(String r10) {
            this.f5986a = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<OnePartyCommonNetworkRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f5995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f5996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f5997c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f5998d;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, OnePartyCommonNetworkRequest.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f5995a = ProtoAdapter.newMapAdapter(r10, r10);
            this.f5996b = ProtoAdapter.newMapAdapter(r10, r10);
            this.f5997c = ProtoAdapter.newMapAdapter(r10, r10);
            this.f5998d = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public OnePartyCommonNetworkRequest a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L20;
            switch(r13) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L22;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L22:
            r11.e(NETWORK_METHOD.ADAPTER.decode(r10));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r11.addUnknownField(r13, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            Map<String, String> r14 = r11.f5994i;
            ProtoAdapter<Map<String, String>> r15 = this.f5998d;
        L13:
            r14.putAll(r15.decode(r10));
            goto L3
        L8:
            r11.a(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L9:
            r14 = r11.f5992g;
            r15 = this.f5997c;
            goto L13
        L10:
            r11.b(ProtoAdapter.BYTES.decode(r10));
            goto L3
        L11:
            r14 = r11.f5990e;
            r15 = this.f5996b;
            goto L13
        L12:
            r14 = r11.f5989d;
            r15 = this.f5995a;
            goto L13
        L18:
            r11.d(ProtoAdapter.STRING.decode(r10));
            goto L3
        L19:
            r11.f(ProtoAdapter.STRING.decode(r10));
            goto L3
        L6:
            FieldEncoding r16 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r16, r16.rawProtoAdapter().decode(r10));
            goto L3
        L20:
            r10.endMessage(r12);
            return r11.c();
        }

        public void b(ProtoWriter r10, OnePartyCommonNetworkRequest r11) {
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            r12.encodeWithTag(r10, 1, r11.path);
            r12.encodeWithTag(r10, 2, r11.host);
            NETWORK_METHOD.ADAPTER.encodeWithTag(r10, 3, r11.method);
            this.f5995a.encodeWithTag(r10, 4, r11.headerParams);
            this.f5996b.encodeWithTag(r10, 5, r11.queryParams);
            ProtoAdapter.BYTES.encodeWithTag(r10, 6, r11.body);
            this.f5997c.encodeWithTag(r10, 7, r11.fieldMap);
            ProtoAdapter.BOOL.encodeWithTag(r10, 8, r11.addCommonParam);
            this.f5998d.encodeWithTag(r10, 9, r11.extraMap);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(OnePartyCommonNetworkRequest r10) {
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            return ((((((((r11.encodedSizeWithTag(1, r10.path) + r11.encodedSizeWithTag(2, r10.host)) + NETWORK_METHOD.ADAPTER.encodedSizeWithTag(3, r10.method)) + this.f5995a.encodedSizeWithTag(4, r10.headerParams)) + this.f5996b.encodedSizeWithTag(5, r10.queryParams)) + ProtoAdapter.BYTES.encodedSizeWithTag(6, r10.body)) + this.f5997c.encodedSizeWithTag(7, r10.fieldMap)) + ProtoAdapter.BOOL.encodedSizeWithTag(8, r10.addCommonParam)) + this.f5998d.encodedSizeWithTag(9, r10.extraMap)) + r10.unknownFields().size();
        }

        public OnePartyCommonNetworkRequest d(OnePartyCommonNetworkRequest r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.c();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OnePartyCommonNetworkRequest decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, OnePartyCommonNetworkRequest r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OnePartyCommonNetworkRequest r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OnePartyCommonNetworkRequest redact(OnePartyCommonNetworkRequest r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_METHOD = NETWORK_METHOD.METHOD_GET;
        DEFAULT_BODY = ByteString.EMPTY;
        DEFAULT_ADDCOMMONPARAM = Boolean.FALSE;
    }

    public OnePartyCommonNetworkRequest(String r12, String r13, NETWORK_METHOD r14, Map<String, String> r15, Map<String, String> r16, ByteString r17, Map<String, String> r18, Boolean r19, Map<String, String> r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public OnePartyCommonNetworkRequest(String r10, String r11, NETWORK_METHOD r12, Map<String, String> r13, Map<String, String> r14, ByteString r15, Map<String, String> r16, Boolean r17, Map<String, String> r18, ByteString r19) {
        super(ADAPTER, r19);
        this.path = r10;
        this.host = r11;
        this.method = r12;
        this.headerParams = Internal.immutableCopyOf("headerParams", r13);
        this.queryParams = Internal.immutableCopyOf("queryParams", r14);
        this.body = r15;
        this.fieldMap = Internal.immutableCopyOf("fieldMap", r16);
        this.addCommonParam = r17;
        this.extraMap = Internal.immutableCopyOf("extraMap", r18);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof OnePartyCommonNetworkRequest) == true) goto L8;
        return false;
    L8:
        OnePartyCommonNetworkRequest r11 = (OnePartyCommonNetworkRequest) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L30;
        if (Internal.equals(this.path, r11.path) == false) goto L30;
        if (Internal.equals(this.host, r11.host) == false) goto L30;
        if (this.method.equals(r11.method) == false) goto L30;
        if (this.headerParams.equals(r11.headerParams) == false) goto L30;
        if (this.queryParams.equals(r11.queryParams) == false) goto L30;
        if (Internal.equals(this.body, r11.body) == false) goto L30;
        if (this.fieldMap.equals(r11.fieldMap) == false) goto L30;
        if (Internal.equals(this.addCommonParam, r11.addCommonParam) == false) goto L30;
        if (this.extraMap.equals(r11.extraMap) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L21;
        int r11 = unknownFields().hashCode() * 37;
        String r12 = this.path;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        String r16 = this.host;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (((((((r15 + r17) * 37) + this.method.hashCode()) * 37) + this.headerParams.hashCode()) * 37) + this.queryParams.hashCode()) * 37;
        ByteString r19 = this.body;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (((r18 + r20) * 37) + this.fieldMap.hashCode()) * 37;
        Boolean r22 = this.addCommonParam;
        if (r22 == null) goto L19;
        r13 = r22.hashCode();
    L19:
        int r23 = ((r21 + r13) * 37) + this.extraMap.hashCode();
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
        r10.f5986a = this.path;
        r10.f5987b = this.host;
        r10.f5988c = this.method;
        r10.f5989d = Internal.copyOf("headerParams", this.headerParams);
        r10.f5990e = Internal.copyOf("queryParams", this.queryParams);
        r10.f5991f = this.body;
        r10.f5992g = Internal.copyOf("fieldMap", this.fieldMap);
        r10.f5993h = this.addCommonParam;
        r10.f5994i = Internal.copyOf("extraMap", this.extraMap);
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
        if (this.path == null) goto L6;
        r10.append(", path=");
        r10.append(this.path);
    L6:
        if (this.host == null) goto L8;
        r10.append(", host=");
        r10.append(this.host);
    L8:
        r10.append(", method=");
        r10.append(this.method);
        Map<String, String> r11 = this.headerParams;
        if (r11 != null) goto L11;
    L13:
        Map<String, String> r12 = this.queryParams;
        if (r12 == null) goto L19;
        if (r12.isEmpty() == true) goto L19;
        r10.append(", queryParams=");
        r10.append(this.queryParams);
    L19:
        if (this.body == null) goto L21;
        r10.append(", body=");
        r10.append(this.body);
    L21:
        Map<String, String> r13 = this.fieldMap;
        if (r13 == null) goto L27;
        if (r13.isEmpty() == true) goto L27;
        r10.append(", fieldMap=");
        r10.append(this.fieldMap);
    L27:
        if (this.addCommonParam == null) goto L29;
        r10.append(", addCommonParam=");
        r10.append(this.addCommonParam);
    L29:
        Map<String, String> r14 = this.extraMap;
        if (r14 != null) goto L32;
    L34:
        StringBuilder r15 = r10.replace(0, 2, "OnePartyCommonNetworkRequest{");
        r15.append('}');
        return r15.toString();
    L32:
        if (r14.isEmpty() == true) goto L34;
        r10.append(", extraMap=");
        r10.append(this.extraMap);
        goto L34
    L11:
        if (r11.isEmpty() == true) goto L13;
        r10.append(", headerParams=");
        r10.append(this.headerParams);
        goto L13
    }
}
