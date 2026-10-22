package com.bytedance.common.wschannel.model;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;
import jf.g;

/* JADX INFO: loaded from: classes.dex */
public final class Frame extends Message<Frame, a> {
    public static final ProtoAdapter<Frame> ADAPTER = null;
    public static final Long DEFAULT_LOGID = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final g DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_PAYLOAD_ENCODING = "";
    public static final String DEFAULT_PAYLOAD_TYPE = "";
    public static final Long DEFAULT_SEQID = null;
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.article.wschannel.model.Frame$ExtendedEntry#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<b> headers;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 2)
    public final Long logid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 4)
    public final Integer method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    public final g payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String payload_encoding;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String payload_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 1)
    public final Long seqid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 3)
    public final Integer service;

    public static final class a extends Message.Builder<Frame, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f3870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f3871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f3872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f3873d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<b> f3874e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f3875f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f3876g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public g f3877h;

        public a() {
            this.f3874e = Internal.newMutableList();
        }

        public final Frame a() {
            Long r8 = this.f3870a;
            if (r8 == null) goto L13;
            if (this.f3871b == null) goto L13;
            if (this.f3872c == null) goto L13;
            if (this.f3873d == null) goto L13;
            return new Frame(this.f3870a, this.f3871b, this.f3872c, this.f3873d, this.f3874e, this.f3875f, this.f3876g, this.f3877h, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r8, "seqid", this.f3871b, "logid", this.f3872c, "service", this.f3873d, BdimCategoryConstants.INTENT_KEY_METHOD});
        }

        @Override // com.squareup.wire.Message.Builder
        public final /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    public static final class b extends Message<b, a> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final C0046b f3878m = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
        public final String f3879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
        public final String f3880b;

        public static final class a extends Message.Builder<b, a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f3881a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f3882b;

            public final b a() {
                String r8 = this.f3881a;
                if (r8 == null) goto L9;
                if (this.f3882b == null) goto L9;
                return new b(this.f3881a, this.f3882b, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r8, "key", this.f3882b, "value"});
            }

            @Override // com.squareup.wire.Message.Builder
            public final /* bridge */ /* synthetic */ Message build() {
                return a();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.common.wschannel.model.Frame$b$b, reason: collision with other inner class name */
        public static final class C0046b extends ProtoAdapter<b> {
            public C0046b() {
                super(FieldEncoding.LENGTH_DELIMITED, b.class);
            }

            public static b a(ProtoReader r8) {
                a r10 = new a();
                long r11 = r8.beginMessage();
            L3:
                int r12 = r8.nextTag();
                if (r12 == (-1)) goto L12;
                if (r12 == 1) goto L7;
                if (r12 == 2) goto L10;
                FieldEncoding r13 = r8.peekFieldEncoding();
                r10.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r8));
                goto L3
            L10:
                r10.f3882b = ProtoAdapter.STRING.decode(r8);
                goto L3
            L7:
                r10.f3881a = ProtoAdapter.STRING.decode(r8);
                goto L3
            L12:
                r8.endMessage(r11);
                return r10.a();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public final /* bridge */ /* synthetic */ b decode(ProtoReader r8) {
                return a(r8);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public final void encode(ProtoWriter r8, b r10) {
                b r11 = r10;
                ProtoAdapter<String> r12 = ProtoAdapter.STRING;
                r12.encodeWithTag(r8, 1, r11.f3879a);
                r12.encodeWithTag(r8, 2, r11.f3880b);
                r8.writeBytes(r11.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public final int encodedSize(b r8) {
                b r10 = r8;
                ProtoAdapter<String> r11 = ProtoAdapter.STRING;
                int r12 = r11.encodedSizeWithTag(1, r10.f3879a);
                int r13 = r11.encodedSizeWithTag(2, r10.f3880b) + r12;
                return r10.unknownFields().l() + r13;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public final b redact(b r8) {
                b r10 = r8;
                r10.getClass();
                a r11 = new a();
                r11.f3881a = r10.f3879a;
                r11.f3882b = r10.f3880b;
                r11.addUnknownFields(r10.unknownFields());
                r11.clearUnknownFields();
                return r11.a();
            }
        }

        static {
            f3878m = new C0046b();
        }

        public b(String r8, String r10, g r11) {
            super(f3878m, r11);
            this.f3879a = r8;
            this.f3880b = r10;
        }

        public final boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r10 = (b) r8;
            if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
            if (this.f3879a.equals(r10.f3879a) == false) goto L16;
            if (this.f3880b.equals(r10.f3880b) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            int r8 = this.hashCode;
            if (r8 != 0) goto L6;
            int r10 = unknownFields().hashCode() * 37;
            int r11 = defpackage.a.b(this.f3879a, r10, 37) + this.f3880b.hashCode();
            this.hashCode = r11;
            return r11;
        L6:
            return r8;
        }

        @Override // com.squareup.wire.Message
        public final Message.Builder newBuilder() {
            a r8 = new a();
            r8.f3881a = this.f3879a;
            r8.f3882b = this.f3880b;
            r8.addUnknownFields(unknownFields());
            return r8;
        }

        @Override // com.squareup.wire.Message
        public final String toString() {
            StringBuilder r8 = android.aimedia.a.j(", key=");
            r8.append(this.f3879a);
            r8.append(", value=");
            r8.append(this.f3880b);
            return android.aimedia.a.g(r8, 0, 2, "ExtendedEntry{", '}');
        }
    }

    public static final class c extends ProtoAdapter<Frame> {
        public c() {
            super(FieldEncoding.LENGTH_DELIMITED, Frame.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final Frame decode(ProtoReader r8) {
            a r10 = new a();
            long r11 = r8.beginMessage();
        L3:
            int r12 = r8.nextTag();
            if (r12 == (-1)) goto L30;
            if (r12 == 1) goto L7;
            if (r12 == 2) goto L10;
            if (r12 == 3) goto L13;
            if (r12 == 4) goto L16;
            if (r12 == 5) goto L19;
            if (r12 == 6) goto L22;
            if (r12 == 7) goto L25;
            if (r12 == 8) goto L28;
            FieldEncoding r13 = r8.peekFieldEncoding();
            r10.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r8));
            goto L3
        L28:
            r10.f3877h = ProtoAdapter.BYTES.decode(r8);
            goto L3
        L25:
            r10.f3876g = ProtoAdapter.STRING.decode(r8);
            goto L3
        L22:
            r10.f3875f = ProtoAdapter.STRING.decode(r8);
            goto L3
        L19:
            List<b> r14 = r10.f3874e;
            b.f3878m.getClass();
            r14.add(b.C0046b.a(r8));
            goto L3
        L16:
            r10.f3873d = ProtoAdapter.INT32.decode(r8);
            goto L3
        L13:
            r10.f3872c = ProtoAdapter.INT32.decode(r8);
            goto L3
        L10:
            r10.f3871b = ProtoAdapter.UINT64.decode(r8);
            goto L3
        L7:
            r10.f3870a = ProtoAdapter.UINT64.decode(r8);
            goto L3
        L30:
            r8.endMessage(r11);
            return r10.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final void encode(ProtoWriter r8, Frame r10) {
            Frame r11 = r10;
            ProtoAdapter<Long> r12 = ProtoAdapter.UINT64;
            r12.encodeWithTag(r8, 1, r11.seqid);
            r12.encodeWithTag(r8, 2, r11.logid);
            ProtoAdapter<Integer> r13 = ProtoAdapter.INT32;
            r13.encodeWithTag(r8, 3, r11.service);
            r13.encodeWithTag(r8, 4, r11.method);
            b.f3878m.asRepeated().encodeWithTag(r8, 5, r11.headers);
            ProtoAdapter<String> r14 = ProtoAdapter.STRING;
            r14.encodeWithTag(r8, 6, r11.payload_encoding);
            r14.encodeWithTag(r8, 7, r11.payload_type);
            ProtoAdapter.BYTES.encodeWithTag(r8, 8, r11.payload);
            r8.writeBytes(r11.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final int encodedSize(Frame r8) {
            Frame r10 = r8;
            ProtoAdapter<Long> r11 = ProtoAdapter.UINT64;
            int r12 = r11.encodedSizeWithTag(1, r10.seqid);
            int r13 = r11.encodedSizeWithTag(2, r10.logid) + r12;
            ProtoAdapter<Integer> r14 = ProtoAdapter.INT32;
            int r15 = r14.encodedSizeWithTag(3, r10.service) + r13;
            int r16 = r14.encodedSizeWithTag(4, r10.method) + r15;
            int r17 = b.f3878m.asRepeated().encodedSizeWithTag(5, r10.headers) + r16;
            ProtoAdapter<String> r18 = ProtoAdapter.STRING;
            int r19 = r18.encodedSizeWithTag(6, r10.payload_encoding) + r17;
            int r20 = r18.encodedSizeWithTag(7, r10.payload_type) + r19;
            int r21 = ProtoAdapter.BYTES.encodedSizeWithTag(8, r10.payload) + r20;
            return r10.unknownFields().l() + r21;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public final Frame redact(Frame r8) {
            a r10 = r8.newBuilder();
            Internal.redactElements(r10.f3874e, b.f3878m);
            r10.clearUnknownFields();
            return r10.a();
        }
    }

    static {
        ADAPTER = new c();
        DEFAULT_SEQID = 0L;
        DEFAULT_LOGID = 0L;
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_PAYLOAD = g.f8841o;
    }

    public Frame(Long r11, Long r12, Integer r13, Integer r14, List<b> r15, String r16, String r17, g r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, g.f8841o);
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof Frame) == true) goto L8;
        return false;
    L8:
        Frame r10 = (Frame) r8;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L28;
        if (this.seqid.equals(r10.seqid) == false) goto L28;
        if (this.logid.equals(r10.logid) == false) goto L28;
        if (this.service.equals(r10.service) == false) goto L28;
        if (this.method.equals(r10.method) == false) goto L28;
        if (this.headers.equals(r10.headers) == false) goto L28;
        if (Internal.equals(this.payload_encoding, r10.payload_encoding) == false) goto L28;
        if (Internal.equals(this.payload_type, r10.payload_type) == false) goto L28;
        if (Internal.equals(this.payload, r10.payload) == false) goto L28;
        return true;
    L28:
        return false;
    }

    public int hashCode() {
        int r8 = this.hashCode;
        if (r8 != 0) goto L17;
        int r10 = (this.headers.hashCode() + ((this.method.hashCode() + ((this.service.hashCode() + ((this.logid.hashCode() + ((this.seqid.hashCode() + (unknownFields().hashCode() * 37)) * 37)) * 37)) * 37)) * 37)) * 37;
        String r11 = this.payload_encoding;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        String r15 = this.payload_type;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        g r18 = this.payload;
        if (r18 == null) goto L15;
        r12 = r18.hashCode();
    L15:
        int r19 = r17 + r12;
        this.hashCode = r19;
        return r19;
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L17:
        return r8;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r8 = new a();
        r8.f3870a = this.seqid;
        r8.f3871b = this.logid;
        r8.f3872c = this.service;
        r8.f3873d = this.method;
        r8.f3874e = Internal.copyOf("headers", this.headers);
        r8.f3875f = this.payload_encoding;
        r8.f3876g = this.payload_type;
        r8.f3877h = this.payload;
        r8.addUnknownFields(unknownFields());
        return r8;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r8 = android.aimedia.a.j(", seqid=");
        r8.append(this.seqid);
        r8.append(", logid=");
        r8.append(this.logid);
        r8.append(", service=");
        r8.append(this.service);
        r8.append(", method=");
        r8.append(this.method);
        if (this.headers.isEmpty() == true) goto L6;
        r8.append(", headers=");
        r8.append(this.headers);
    L6:
        if (this.payload_encoding == null) goto L9;
        r8.append(", payload_encoding=");
        r8.append(this.payload_encoding);
    L9:
        if (this.payload_type == null) goto L12;
        r8.append(", payload_type=");
        r8.append(this.payload_type);
    L12:
        if (this.payload == null) goto L15;
        r8.append(", payload=");
        r8.append(this.payload);
    L15:
        return android.aimedia.a.g(r8, 0, 2, "Frame{", '}');
    }

    public Frame(Long r8, Long r10, Integer r11, Integer r12, List<b> r13, String r14, String r15, g r16, g r17) {
        super(ADAPTER, r17);
        this.seqid = r8;
        this.logid = r10;
        this.service = r11;
        this.method = r12;
        this.headers = Internal.immutableCopyOf("headers", r13);
        this.payload_encoding = r14;
        this.payload_type = r15;
        this.payload = r16;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }
}
