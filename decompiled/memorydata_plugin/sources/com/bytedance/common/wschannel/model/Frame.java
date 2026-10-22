package com.bytedance.common.wschannel.model;

import com.bytedance.crash.entity.EventBody;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class Frame extends Message<Frame, a> {
    public static final ProtoAdapter<Frame> ADAPTER = null;
    public static final Long DEFAULT_LOGID = null;
    public static final String DEFAULT_LOGIDNEW = "";
    public static final Integer DEFAULT_METHOD = null;
    public static final String DEFAULT_MSGID = "";
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_PAYLOAD_ENCODING = "";
    public static final String DEFAULT_PAYLOAD_TYPE = "";
    public static final Long DEFAULT_SEQID = null;
    public static final String DEFAULT_SERVERTIMING = "";
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.article.wschannel.model.Frame$ExtendedEntry#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<ExtendedEntry> headers;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 2)
    public final Long logid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String logidnew;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 4)
    public final Integer method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String msgId;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String payload_encoding;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String payload_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.REQUIRED, tag = 1)
    public final Long seqid;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String serverTiming;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REQUIRED, tag = 3)
    public final Integer service;

    public static final class ExtendedEntry extends Message<ExtendedEntry, a> {
        public static final ProtoAdapter<ExtendedEntry> ADAPTER = null;
        public static final String DEFAULT_KEY = "";
        public static final String DEFAULT_VALUE = "";
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 1)
        public final String key;

        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REQUIRED, tag = 2)
        public final String value;

        public static final class a extends Message.Builder<ExtendedEntry, a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f2140a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f2141b;

            public a() {
            }

            public a a(String r1) {
                this.f2140a = r1;
                return this;
            }

            public ExtendedEntry a() {
                String r0 = this.f2140a;
                if (r0 == null) goto L9;
                if (this.f2141b == null) goto L9;
                return new ExtendedEntry(this.f2140a, this.f2141b, buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "key", this.f2141b, EventBody.KEY_VALUE});
            }

            public a b(String r1) {
                this.f2141b = r1;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            public /* synthetic */ Message build() {
                return a();
            }
        }

        private static final class b extends ProtoAdapter<ExtendedEntry> {
            b() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtendedEntry.class);
            }

            public int a(ExtendedEntry r4) {
                return (ProtoAdapter.STRING.encodedSizeWithTag(1, r4.key) + ProtoAdapter.STRING.encodedSizeWithTag(2, r4.value)) + r4.unknownFields().size();
            }

            public ExtendedEntry a(ProtoReader r6) {
                a r5 = new a();
                long r0 = r6.beginMessage();
            L3:
                int r2 = r6.nextTag();
                if (r2 == (-1)) goto L12;
                if (r2 != 1) goto L8;
                r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
                goto L3
            L8:
                if (r2 != 2) goto L9;
                r5.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
                goto L3
            L9:
                FieldEncoding r3 = r6.peekFieldEncoding();
                r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
                goto L3
            L12:
                r6.endMessage(r0);
                return r5.a();
            }

            public void a(ProtoWriter r3, ExtendedEntry r4) {
                ProtoAdapter.STRING.encodeWithTag(r3, 1, r4.key);
                ProtoAdapter.STRING.encodeWithTag(r3, 2, r4.value);
                r3.writeBytes(r4.unknownFields());
            }

            public ExtendedEntry b(ExtendedEntry r1) {
                a r0 = r1.newBuilder();
                r0.clearUnknownFields();
                return r0.a();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ ExtendedEntry decode(ProtoReader r1) {
                return a(r1);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ void encode(ProtoWriter r3, ExtendedEntry r4) {
                a(r3, (ExtendedEntry) ZeusTransformUtils.preCheckCast(r4, ExtendedEntry.class, "com.obric.memorydata.plugin"));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ int encodedSize(ExtendedEntry r3) {
                return a((ExtendedEntry) ZeusTransformUtils.preCheckCast(r3, ExtendedEntry.class, "com.obric.memorydata.plugin"));
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* synthetic */ ExtendedEntry redact(ExtendedEntry r3) {
                return b((ExtendedEntry) ZeusTransformUtils.preCheckCast(r3, ExtendedEntry.class, "com.obric.memorydata.plugin"));
            }
        }

        static {
            ADAPTER = new b();
        }

        public ExtendedEntry(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public ExtendedEntry(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.key = r2;
            this.value = r3;
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ExtendedEntry.class) == true) goto L8;
            return false;
        L8:
            ExtendedEntry r6 = (ExtendedEntry) ZeusTransformUtils.preCheckCast(r5, ExtendedEntry.class, "com.obric.memorydata.plugin");
            if (Internal.equals(unknownFields(), r6.unknownFields()) == false) goto L16;
            if (Internal.equals(this.key, r6.key) == false) goto L16;
            if (Internal.equals(this.value, r6.value) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            int r0 = this.hashCode;
            if (r0 != 0) goto L13;
            int r1 = unknownFields().hashCode() * 37;
            String r2 = this.key;
            int r3 = 0;
            if (r2 == null) goto L7;
            int r4 = r2.hashCode();
        L8:
            int r5 = (r1 + r4) * 37;
            String r6 = this.value;
            if (r6 == null) goto L11;
            r3 = r6.hashCode();
        L11:
            int r7 = r5 + r3;
            this.hashCode = r7;
            return r7;
        L7:
            r4 = 0;
            goto L8
        L13:
            return r0;
        }

        @Override // com.squareup.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.f2140a = this.key;
            r0.f2141b = this.value;
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
            if (this.key == null) goto L6;
            r0.append(", key=").append(this.key);
        L6:
            if (this.value == null) goto L9;
            r0.append(", value=").append(this.value);
        L9:
            return r0.replace(0, 2, "ExtendedEntry{").append('}').toString();
        }
    }

    public static final class a extends Message.Builder<Frame, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f2142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f2143b;
        public Integer c;
        public Integer d;
        public List<ExtendedEntry> e;
        public String f;
        public String g;
        public ByteString h;
        public String i;
        public String j;
        public String k;

        public a() {
            this.e = Internal.newMutableList();
        }

        public a a(Integer r1) {
            this.c = r1;
            return this;
        }

        public a a(Long r1) {
            this.f2142a = r1;
            return this;
        }

        public a a(String r1) {
            this.f = r1;
            return this;
        }

        public a a(List<ExtendedEntry> r3) {
            List<ExtendedEntry> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Internal.checkElementsNotNull(r4);
            this.e = r4;
            return this;
        }

        public a a(ByteString r1) {
            this.h = r1;
            return this;
        }

        public Frame a() {
            Long r0 = this.f2142a;
            if (r0 == null) goto L13;
            if (this.f2143b == null) goto L13;
            if (this.c == null) goto L13;
            if (this.d == null) goto L13;
            return new Frame(this.f2142a, this.f2143b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r0, "seqid", this.f2143b, "logid", this.c, "service", this.d, "method"});
        }

        public a b(Integer r1) {
            this.d = r1;
            return this;
        }

        public a b(Long r1) {
            this.f2143b = r1;
            return this;
        }

        public a b(String r1) {
            this.g = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a c(String r1) {
            this.i = r1;
            return this;
        }

        public a d(String r1) {
            this.j = r1;
            return this;
        }

        public a e(String r1) {
            this.k = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<Frame> {
        b() {
            super(FieldEncoding.LENGTH_DELIMITED, Frame.class);
        }

        public int a(Frame r5) {
            int r4 = (((ProtoAdapter.UINT64.encodedSizeWithTag(1, r5.seqid) + ProtoAdapter.UINT64.encodedSizeWithTag(2, r5.logid)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r5.service)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r5.method)) + ExtendedEntry.ADAPTER.asRepeated().encodedSizeWithTag(5, r5.headers);
            int r1 = 0;
            if (r5.payload_encoding == null) goto L5;
            int r0 = ProtoAdapter.STRING.encodedSizeWithTag(6, r5.payload_encoding);
        L6:
            int r6 = r4 + r0;
            if (r5.payload_type == null) goto L9;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(7, r5.payload_type);
        L10:
            int r7 = r6 + r2;
            if (r5.payload == null) goto L13;
            int r3 = ProtoAdapter.BYTES.encodedSizeWithTag(8, r5.payload);
        L14:
            int r8 = r7 + r3;
            if (r5.logidnew == null) goto L17;
            int r9 = ProtoAdapter.STRING.encodedSizeWithTag(9, r5.logidnew);
        L18:
            int r10 = r8 + r9;
            if (r5.serverTiming == null) goto L21;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(10, r5.serverTiming);
        L22:
            int r12 = r10 + r11;
            if (r5.msgId == null) goto L26;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(11, r5.msgId);
        L26:
            return (r12 + r1) + r5.unknownFields().size();
        L21:
            r11 = 0;
            goto L22
        L17:
            r9 = 0;
            goto L18
        L13:
            r3 = 0;
            goto L14
        L9:
            r2 = 0;
            goto L10
        L5:
            r0 = 0;
            goto L6
        }

        public Frame a(ProtoReader r6) {
            a r5 = new a();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L19;
            switch(r2) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                default: goto L7;
            };
        L8:
            r5.e((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            r5.d((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            r5.c((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            r5.a((ByteString) ZeusTransformUtils.preCheckCast(ProtoAdapter.BYTES.decode(r6), ByteString.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            r5.b((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L13:
            r5.a((String) ZeusTransformUtils.preCheckCast(ProtoAdapter.STRING.decode(r6), String.class, "com.obric.memorydata.plugin"));
            goto L3
        L14:
            r5.e.add(ExtendedEntry.ADAPTER.decode(r6));
            goto L3
        L15:
            r5.b((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L16:
            r5.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r6), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L17:
            r5.b((Long) ZeusTransformUtils.preCheckCast(ProtoAdapter.UINT64.decode(r6), Long.class, "com.obric.memorydata.plugin"));
            goto L3
        L18:
            r5.a((Long) ZeusTransformUtils.preCheckCast(ProtoAdapter.UINT64.decode(r6), Long.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L19:
            r6.endMessage(r0);
            return r5.a();
        }

        public void a(ProtoWriter r3, Frame r4) {
            ProtoAdapter.UINT64.encodeWithTag(r3, 1, r4.seqid);
            ProtoAdapter.UINT64.encodeWithTag(r3, 2, r4.logid);
            ProtoAdapter.INT32.encodeWithTag(r3, 3, r4.service);
            ProtoAdapter.INT32.encodeWithTag(r3, 4, r4.method);
            if (r4.headers == null) goto L6;
            ExtendedEntry.ADAPTER.asRepeated().encodeWithTag(r3, 5, r4.headers);
        L6:
            if (r4.payload_encoding == null) goto L9;
            ProtoAdapter.STRING.encodeWithTag(r3, 6, r4.payload_encoding);
        L9:
            if (r4.payload_type == null) goto L12;
            ProtoAdapter.STRING.encodeWithTag(r3, 7, r4.payload_type);
        L12:
            if (r4.payload == null) goto L15;
            ProtoAdapter.BYTES.encodeWithTag(r3, 8, r4.payload);
        L15:
            if (r4.logidnew == null) goto L18;
            ProtoAdapter.STRING.encodeWithTag(r3, 9, r4.logidnew);
        L18:
            if (r4.serverTiming == null) goto L21;
            ProtoAdapter.STRING.encodeWithTag(r3, 10, r4.serverTiming);
        L21:
            if (r4.msgId == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r3, 11, r4.msgId);
        L23:
            r3.writeBytes(r4.unknownFields());
        }

        public Frame b(Frame r2) {
            a r1 = r2.newBuilder();
            Internal.redactElements(r1.e, ExtendedEntry.ADAPTER);
            r1.clearUnknownFields();
            return r1.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Frame decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, Frame r4) {
            a(r3, (Frame) ZeusTransformUtils.preCheckCast(r4, Frame.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(Frame r3) {
            return a((Frame) ZeusTransformUtils.preCheckCast(r3, Frame.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ Frame redact(Frame r3) {
            return b((Frame) ZeusTransformUtils.preCheckCast(r3, Frame.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_SEQID = 0L;
        DEFAULT_LOGID = 0L;
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    public Frame(Long r15, Long r16, Integer r17, Integer r18, List<ExtendedEntry> r19, String r20, String r21, ByteString r22, String r23, String r24, String r25) {
        this(r15, r16, r17, r18, (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin"), r20, r21, r22, r23, r24, r25, ByteString.EMPTY);
    }

    public Frame(Long r3, Long r4, Integer r5, Integer r6, List<ExtendedEntry> r7, String r8, String r9, ByteString r10, String r11, String r12, String r13, ByteString r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r14);
        this.seqid = r3;
        this.logid = r4;
        this.service = r5;
        this.method = r6;
        this.headers = Internal.immutableCopyOf("headers", r15);
        this.payload_encoding = r8;
        this.payload_type = r9;
        this.payload = r10;
        this.logidnew = r11;
        this.serverTiming = r12;
        this.msgId = r13;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Frame.class) == true) goto L8;
        return false;
    L8:
        Frame r6 = (Frame) ZeusTransformUtils.preCheckCast(r5, Frame.class, "com.obric.memorydata.plugin");
        if (Internal.equals(unknownFields(), r6.unknownFields()) == false) goto L34;
        if (Internal.equals(this.seqid, r6.seqid) == false) goto L34;
        if (Internal.equals(this.logid, r6.logid) == false) goto L34;
        if (Internal.equals(this.service, r6.service) == false) goto L34;
        if (Internal.equals(this.method, r6.method) == false) goto L34;
        if (Internal.equals(this.headers, r6.headers) == false) goto L34;
        if (Internal.equals(this.payload_encoding, r6.payload_encoding) == false) goto L34;
        if (Internal.equals(this.payload_type, r6.payload_type) == false) goto L34;
        if (Internal.equals(this.payload, r6.payload) == false) goto L34;
        if (Internal.equals(this.logidnew, r6.logidnew) == false) goto L34;
        if (Internal.equals(this.serverTiming, r6.serverTiming) == false) goto L34;
        if (Internal.equals(this.msgId, r6.msgId) == false) goto L34;
        return true;
    L34:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L49;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.seqid;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.logid;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.service;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.method;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        List<ExtendedEntry> r15 = this.headers;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.payload_encoding;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.payload_type;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        ByteString r24 = this.payload;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        String r27 = this.logidnew;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        String r30 = this.serverTiming;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        String r33 = this.msgId;
        if (r33 == null) goto L47;
        r3 = r33.hashCode();
    L47:
        int r34 = r32 + r3;
        this.hashCode = r34;
        return r34;
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
        r16 = 1;
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
    L49:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f2142a = this.seqid;
        r0.f2143b = this.logid;
        r0.c = this.service;
        r0.d = this.method;
        r0.e = Internal.copyOf("headers", this.headers);
        r0.f = this.payload_encoding;
        r0.g = this.payload_type;
        r0.h = this.payload;
        r0.i = this.logidnew;
        r0.j = this.serverTiming;
        r0.k = this.msgId;
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
        if (this.seqid == null) goto L6;
        r0.append(", seqid=").append(this.seqid);
    L6:
        if (this.logid == null) goto L9;
        r0.append(", logid=").append(this.logid);
    L9:
        if (this.service == null) goto L12;
        r0.append(", service=").append(this.service);
    L12:
        if (this.method == null) goto L15;
        r0.append(", method=").append(this.method);
    L15:
        if (this.headers == null) goto L18;
        r0.append(", headers=").append(this.headers);
    L18:
        if (this.payload_encoding == null) goto L21;
        r0.append(", payload_encoding=").append(this.payload_encoding);
    L21:
        if (this.payload_type == null) goto L24;
        r0.append(", payload_type=").append(this.payload_type);
    L24:
        if (this.payload == null) goto L27;
        r0.append(", payload=").append(this.payload);
    L27:
        if (this.logidnew == null) goto L30;
        r0.append(", logidnew=").append(this.logidnew);
    L30:
        if (this.serverTiming == null) goto L33;
        r0.append(", serverTiming=").append(this.serverTiming);
    L33:
        if (this.msgId == null) goto L36;
        r0.append(", msgId=").append(this.msgId);
    L36:
        return r0.replace(0, 2, "Frame{").append('}').toString();
    }
}
