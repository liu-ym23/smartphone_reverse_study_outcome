package com.bytedance.common.wschannel.model;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.event.EnsureReportData;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
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
            public String f1344a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f1345b;

            public a() {
            }

            public ExtendedEntry a() {
                String r10 = this.f1344a;
                if (r10 == null) goto L9;
                if (this.f1345b == null) goto L9;
                return new ExtendedEntry(this.f1344a, this.f1345b, buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r10, "key", this.f1345b, EventBody.KEY_VALUE});
            }

            public a b(String r10) {
                this.f1344a = r10;
                return this;
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return a();
            }

            public a c(String r10) {
                this.f1345b = r10;
                return this;
            }
        }

        private static final class b extends ProtoAdapter<ExtendedEntry> {
            b() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtendedEntry.class);
            }

            public ExtendedEntry a(ProtoReader r10) {
                a r11 = new a();
                long r12 = r10.beginMessage();
            L3:
                int r13 = r10.nextTag();
                if (r13 == (-1)) goto L12;
                if (r13 != 1) goto L8;
                r11.b(ProtoAdapter.STRING.decode(r10));
                goto L3
            L8:
                if (r13 != 2) goto L9;
                r11.c(ProtoAdapter.STRING.decode(r10));
                goto L3
            L9:
                FieldEncoding r14 = r10.peekFieldEncoding();
                r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
                goto L3
            L12:
                r10.endMessage(r12);
                return r11.a();
            }

            public void b(ProtoWriter r10, ExtendedEntry r11) {
                ProtoAdapter<String> r12 = ProtoAdapter.STRING;
                r12.encodeWithTag(r10, 1, r11.key);
                r12.encodeWithTag(r10, 2, r11.value);
                r10.writeBytes(r11.unknownFields());
            }

            public int c(ExtendedEntry r10) {
                ProtoAdapter<String> r11 = ProtoAdapter.STRING;
                return (r11.encodedSizeWithTag(1, r10.key) + r11.encodedSizeWithTag(2, r10.value)) + r10.unknownFields().size();
            }

            public ExtendedEntry d(ExtendedEntry r10) {
                a r11 = r10.newBuilder();
                r11.clearUnknownFields();
                return r11.a();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ExtendedEntry decode(ProtoReader r10) {
                return a(r10);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, ExtendedEntry r11) {
                b(r10, r11);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ExtendedEntry r10) {
                return c(r10);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ExtendedEntry redact(ExtendedEntry r10) {
                return d(r10);
            }
        }

        static {
            ADAPTER = new b();
        }

        public ExtendedEntry(String r10, String r11) {
            this(r10, r11, ByteString.EMPTY);
        }

        public ExtendedEntry(String r10, String r11, ByteString r12) {
            super(ADAPTER, r12);
            this.key = r10;
            this.value = r11;
        }

        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof ExtendedEntry) == true) goto L8;
            return false;
        L8:
            ExtendedEntry r11 = (ExtendedEntry) r10;
            if (Internal.equals(unknownFields(), r11.unknownFields()) == false) goto L16;
            if (Internal.equals(this.key, r11.key) == false) goto L16;
            if (Internal.equals(this.value, r11.value) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            int r10 = this.hashCode;
            if (r10 != 0) goto L13;
            int r11 = unknownFields().hashCode() * 37;
            String r12 = this.key;
            int r13 = 0;
            if (r12 == null) goto L7;
            int r14 = r12.hashCode();
        L8:
            int r15 = (r11 + r14) * 37;
            String r16 = this.value;
            if (r16 == null) goto L11;
            r13 = r16.hashCode();
        L11:
            int r17 = r15 + r13;
            this.hashCode = r17;
            return r17;
        L7:
            r14 = 0;
            goto L8
        L13:
            return r10;
        }

        @Override // com.squareup.wire.Message
        public a newBuilder() {
            a r10 = new a();
            r10.f1344a = this.key;
            r10.f1345b = this.value;
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
            if (this.key == null) goto L6;
            r10.append(", key=");
            r10.append(this.key);
        L6:
            if (this.value == null) goto L8;
            r10.append(", value=");
            r10.append(this.value);
        L8:
            StringBuilder r11 = r10.replace(0, 2, "ExtendedEntry{");
            r11.append('}');
            return r11.toString();
        }
    }

    public static final class a extends Message.Builder<Frame, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f1346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f1347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f1348c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f1349d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<ExtendedEntry> f1350e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f1351f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f1352g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ByteString f1353h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f1354i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f1355j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f1356k;

        public a() {
            this.f1350e = Internal.newMutableList();
        }

        public Frame a() {
            Long r10 = this.f1346a;
            if (r10 == null) goto L13;
            if (this.f1347b == null) goto L13;
            if (this.f1348c == null) goto L13;
            if (this.f1349d == null) goto L13;
            return new Frame(this.f1346a, this.f1347b, this.f1348c, this.f1349d, this.f1350e, this.f1351f, this.f1352g, this.f1353h, this.f1354i, this.f1355j, this.f1356k, buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r10, "seqid", this.f1347b, "logid", this.f1348c, "service", this.f1349d, EnsureReportData.METHOD});
        }

        public a b(List<ExtendedEntry> r10) {
            Internal.checkElementsNotNull(r10);
            this.f1350e = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Long r10) {
            this.f1347b = r10;
            return this;
        }

        public a d(String r10) {
            this.f1354i = r10;
            return this;
        }

        public a e(Integer r10) {
            this.f1349d = r10;
            return this;
        }

        public a f(String r10) {
            this.f1356k = r10;
            return this;
        }

        public a g(ByteString r10) {
            this.f1353h = r10;
            return this;
        }

        public a h(String r10) {
            this.f1351f = r10;
            return this;
        }

        public a i(String r10) {
            this.f1352g = r10;
            return this;
        }

        public a j(Long r10) {
            this.f1346a = r10;
            return this;
        }

        public a k(String r10) {
            this.f1355j = r10;
            return this;
        }

        public a l(Integer r10) {
            this.f1348c = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<Frame> {
        b() {
            super(FieldEncoding.LENGTH_DELIMITED, Frame.class);
        }

        public Frame a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L18;
            switch(r13) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r11.f(ProtoAdapter.STRING.decode(r10));
            goto L3
        L8:
            r11.k(ProtoAdapter.STRING.decode(r10));
            goto L3
        L9:
            r11.d(ProtoAdapter.STRING.decode(r10));
            goto L3
        L10:
            r11.g(ProtoAdapter.BYTES.decode(r10));
            goto L3
        L11:
            r11.i(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            r11.h(ProtoAdapter.STRING.decode(r10));
            goto L3
        L13:
            r11.f1350e.add(ExtendedEntry.ADAPTER.decode(r10));
            goto L3
        L14:
            r11.e(ProtoAdapter.INT32.decode(r10));
            goto L3
        L15:
            r11.l(ProtoAdapter.INT32.decode(r10));
            goto L3
        L16:
            r11.c(ProtoAdapter.UINT64.decode(r10));
            goto L3
        L17:
            r11.j(ProtoAdapter.UINT64.decode(r10));
            goto L3
        L6:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L18:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, Frame r11) {
            ProtoAdapter<Long> r12 = ProtoAdapter.UINT64;
            r12.encodeWithTag(r10, 1, r11.seqid);
            r12.encodeWithTag(r10, 2, r11.logid);
            ProtoAdapter<Integer> r13 = ProtoAdapter.INT32;
            r13.encodeWithTag(r10, 3, r11.service);
            r13.encodeWithTag(r10, 4, r11.method);
            if (r11.headers == null) goto L5;
            ExtendedEntry.ADAPTER.asRepeated().encodeWithTag(r10, 5, r11.headers);
        L5:
            String r14 = r11.payload_encoding;
            if (r14 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r10, 6, r14);
        L8:
            String r15 = r11.payload_type;
            if (r15 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r10, 7, r15);
        L11:
            ByteString r16 = r11.payload;
            if (r16 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r10, 8, r16);
        L14:
            String r17 = r11.logidnew;
            if (r17 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r10, 9, r17);
        L17:
            String r18 = r11.serverTiming;
            if (r18 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r10, 10, r18);
        L20:
            String r19 = r11.msgId;
            if (r19 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r10, 11, r19);
        L23:
            r10.writeBytes(r11.unknownFields());
        }

        public int c(Frame r10) {
            ProtoAdapter<Long> r11 = ProtoAdapter.UINT64;
            int r12 = r11.encodedSizeWithTag(1, r10.seqid) + r11.encodedSizeWithTag(2, r10.logid);
            ProtoAdapter<Integer> r13 = ProtoAdapter.INT32;
            int r14 = ((r12 + r13.encodedSizeWithTag(3, r10.service)) + r13.encodedSizeWithTag(4, r10.method)) + ExtendedEntry.ADAPTER.asRepeated().encodedSizeWithTag(5, r10.headers);
            String r15 = r10.payload_encoding;
            int r16 = 0;
            if (r15 == null) goto L5;
            int r17 = ProtoAdapter.STRING.encodedSizeWithTag(6, r15);
        L6:
            int r18 = r14 + r17;
            String r19 = r10.payload_type;
            if (r19 == null) goto L9;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
        L10:
            int r21 = r18 + r20;
            ByteString r22 = r10.payload;
            if (r22 == null) goto L13;
            int r23 = ProtoAdapter.BYTES.encodedSizeWithTag(8, r22);
        L14:
            int r24 = r21 + r23;
            String r25 = r10.logidnew;
            if (r25 == null) goto L17;
            int r26 = ProtoAdapter.STRING.encodedSizeWithTag(9, r25);
        L18:
            int r27 = r24 + r26;
            String r28 = r10.serverTiming;
            if (r28 == null) goto L21;
            int r29 = ProtoAdapter.STRING.encodedSizeWithTag(10, r28);
        L22:
            int r30 = r27 + r29;
            String r31 = r10.msgId;
            if (r31 == null) goto L26;
            r16 = ProtoAdapter.STRING.encodedSizeWithTag(11, r31);
        L26:
            return (r30 + r16) + r10.unknownFields().size();
        L21:
            r29 = 0;
            goto L22
        L17:
            r26 = 0;
            goto L18
        L13:
            r23 = 0;
            goto L14
        L9:
            r20 = 0;
            goto L10
        L5:
            r17 = 0;
            goto L6
        }

        public Frame d(Frame r10) {
            a r11 = r10.newBuilder();
            Internal.redactElements(r11.f1350e, ExtendedEntry.ADAPTER);
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Frame decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, Frame r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Frame r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Frame redact(Frame r10) {
            return d(r10);
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

    public Frame(Long r14, Long r15, Integer r16, Integer r17, List<ExtendedEntry> r18, String r19, String r20, ByteString r21, String r22, String r23, String r24) {
        this(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, ByteString.EMPTY);
    }

    public Frame(Long r10, Long r11, Integer r12, Integer r13, List<ExtendedEntry> r14, String r15, String r16, ByteString r17, String r18, String r19, String r110, ByteString r111) {
        super(ADAPTER, r111);
        this.seqid = r10;
        this.logid = r11;
        this.service = r12;
        this.method = r13;
        this.headers = Internal.immutableCopyOf("headers", r14);
        this.payload_encoding = r15;
        this.payload_type = r16;
        this.payload = r17;
        this.logidnew = r18;
        this.serverTiming = r19;
        this.msgId = r110;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Frame) == true) goto L8;
        return false;
    L8:
        Frame r11 = (Frame) r10;
        if (Internal.equals(unknownFields(), r11.unknownFields()) == false) goto L34;
        if (Internal.equals(this.seqid, r11.seqid) == false) goto L34;
        if (Internal.equals(this.logid, r11.logid) == false) goto L34;
        if (Internal.equals(this.service, r11.service) == false) goto L34;
        if (Internal.equals(this.method, r11.method) == false) goto L34;
        if (Internal.equals(this.headers, r11.headers) == false) goto L34;
        if (Internal.equals(this.payload_encoding, r11.payload_encoding) == false) goto L34;
        if (Internal.equals(this.payload_type, r11.payload_type) == false) goto L34;
        if (Internal.equals(this.payload, r11.payload) == false) goto L34;
        if (Internal.equals(this.logidnew, r11.logidnew) == false) goto L34;
        if (Internal.equals(this.serverTiming, r11.serverTiming) == false) goto L34;
        if (Internal.equals(this.msgId, r11.msgId) == false) goto L34;
        return true;
    L34:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L49;
        int r11 = unknownFields().hashCode() * 37;
        Long r12 = this.seqid;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Long r16 = this.logid;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        Integer r19 = this.service;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (r18 + r20) * 37;
        Integer r22 = this.method;
        if (r22 == null) goto L19;
        int r23 = r22.hashCode();
    L20:
        int r24 = (r21 + r23) * 37;
        List<ExtendedEntry> r25 = this.headers;
        if (r25 == null) goto L23;
        int r26 = r25.hashCode();
    L24:
        int r27 = (r24 + r26) * 37;
        String r28 = this.payload_encoding;
        if (r28 == null) goto L27;
        int r29 = r28.hashCode();
    L28:
        int r30 = (r27 + r29) * 37;
        String r31 = this.payload_type;
        if (r31 == null) goto L31;
        int r32 = r31.hashCode();
    L32:
        int r33 = (r30 + r32) * 37;
        ByteString r34 = this.payload;
        if (r34 == null) goto L35;
        int r35 = r34.hashCode();
    L36:
        int r36 = (r33 + r35) * 37;
        String r37 = this.logidnew;
        if (r37 == null) goto L39;
        int r38 = r37.hashCode();
    L40:
        int r39 = (r36 + r38) * 37;
        String r40 = this.serverTiming;
        if (r40 == null) goto L43;
        int r41 = r40.hashCode();
    L44:
        int r42 = (r39 + r41) * 37;
        String r43 = this.msgId;
        if (r43 == null) goto L47;
        r13 = r43.hashCode();
    L47:
        int r44 = r42 + r13;
        this.hashCode = r44;
        return r44;
    L43:
        r41 = 0;
        goto L44
    L39:
        r38 = 0;
        goto L40
    L35:
        r35 = 0;
        goto L36
    L31:
        r32 = 0;
        goto L32
    L27:
        r29 = 0;
        goto L28
    L23:
        r26 = 1;
        goto L24
    L19:
        r23 = 0;
        goto L20
    L15:
        r20 = 0;
        goto L16
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L49:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f1346a = this.seqid;
        r10.f1347b = this.logid;
        r10.f1348c = this.service;
        r10.f1349d = this.method;
        r10.f1350e = Internal.copyOf("headers", this.headers);
        r10.f1351f = this.payload_encoding;
        r10.f1352g = this.payload_type;
        r10.f1353h = this.payload;
        r10.f1354i = this.logidnew;
        r10.f1355j = this.serverTiming;
        r10.f1356k = this.msgId;
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
        if (this.seqid == null) goto L6;
        r10.append(", seqid=");
        r10.append(this.seqid);
    L6:
        if (this.logid == null) goto L9;
        r10.append(", logid=");
        r10.append(this.logid);
    L9:
        if (this.service == null) goto L12;
        r10.append(", service=");
        r10.append(this.service);
    L12:
        if (this.method == null) goto L15;
        r10.append(", method=");
        r10.append(this.method);
    L15:
        if (this.headers == null) goto L18;
        r10.append(", headers=");
        r10.append(this.headers);
    L18:
        if (this.payload_encoding == null) goto L21;
        r10.append(", payload_encoding=");
        r10.append(this.payload_encoding);
    L21:
        if (this.payload_type == null) goto L24;
        r10.append(", payload_type=");
        r10.append(this.payload_type);
    L24:
        if (this.payload == null) goto L27;
        r10.append(", payload=");
        r10.append(this.payload);
    L27:
        if (this.logidnew == null) goto L30;
        r10.append(", logidnew=");
        r10.append(this.logidnew);
    L30:
        if (this.serverTiming == null) goto L33;
        r10.append(", serverTiming=");
        r10.append(this.serverTiming);
    L33:
        if (this.msgId == null) goto L35;
        r10.append(", msgId=");
        r10.append(this.msgId);
    L35:
        StringBuilder r11 = r10.replace(0, 2, "Frame{");
        r11.append('}');
        return r11.toString();
    }
}
