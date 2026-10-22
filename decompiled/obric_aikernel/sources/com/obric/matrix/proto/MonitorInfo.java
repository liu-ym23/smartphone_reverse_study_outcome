package com.obric.matrix.proto;

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
public final class MonitorInfo extends Message<MonitorInfo, a> {
    public static final ProtoAdapter<MonitorInfo> ADAPTER = null;
    public static final Long DEFAULT_MATRIXBINDPROCESSENDTIME = null;
    public static final Long DEFAULT_MATRIXBINDREVTIME = null;
    public static final Long DEFAULT_THIRDJAVAJNICALLTIME = null;
    public static final Long DEFAULT_THIRDJAVAREVRESRESULT = null;
    public static final Long DEFAULT_THIRDSTARTTIME = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    @c("matrixBindProcessEndTime")
    public final Long matrixBindProcessEndTime;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    @c("matrixBindRevTime")
    public final Long matrixBindRevTime;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    @c("thirdJavaJniCallTime")
    public final Long thirdJavaJniCallTime;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    @c("thirdJavaRevResResult")
    public final Long thirdJavaRevResResult;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    @c("thirdStartTime")
    public final Long thirdStartTime;

    public static final class a extends Message.Builder<MonitorInfo, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f5978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f5979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f5980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f5981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f5982e;

        public a() {
            this.f5978a = 0L;
            this.f5979b = 0L;
            this.f5980c = 0L;
            this.f5981d = 0L;
            this.f5982e = 0L;
        }

        public MonitorInfo a() {
            return new MonitorInfo(this.f5978a, this.f5979b, this.f5980c, this.f5981d, this.f5982e, super.buildUnknownFields());
        }

        public a b(Long r10) {
            this.f5981d = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Long r10) {
            this.f5980c = r10;
            return this;
        }

        public a d(Long r10) {
            this.f5979b = r10;
            return this;
        }

        public a e(Long r10) {
            this.f5982e = r10;
            return this;
        }

        public a f(Long r10) {
            this.f5978a = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<MonitorInfo> {
        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, MonitorInfo.class);
        }

        public MonitorInfo a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L21;
            if (r13 != 1) goto L8;
            r11.f(ProtoAdapter.INT64.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L10;
            r11.d(ProtoAdapter.INT64.decode(r10));
            goto L3
        L10:
            if (r13 != 3) goto L12;
            r11.c(ProtoAdapter.INT64.decode(r10));
            goto L3
        L12:
            if (r13 != 4) goto L14;
            r11.b(ProtoAdapter.INT64.decode(r10));
            goto L3
        L14:
            if (r13 != 5) goto L15;
            r11.e(ProtoAdapter.INT64.decode(r10));
            goto L3
        L15:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L21:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, MonitorInfo r11) {
            ProtoAdapter<Long> r12 = ProtoAdapter.INT64;
            r12.encodeWithTag(r10, 1, r11.thirdStartTime);
            r12.encodeWithTag(r10, 2, r11.thirdJavaJniCallTime);
            r12.encodeWithTag(r10, 3, r11.matrixBindRevTime);
            r12.encodeWithTag(r10, 4, r11.matrixBindProcessEndTime);
            r12.encodeWithTag(r10, 5, r11.thirdJavaRevResResult);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(MonitorInfo r10) {
            ProtoAdapter<Long> r11 = ProtoAdapter.INT64;
            return ((((r11.encodedSizeWithTag(1, r10.thirdStartTime) + r11.encodedSizeWithTag(2, r10.thirdJavaJniCallTime)) + r11.encodedSizeWithTag(3, r10.matrixBindRevTime)) + r11.encodedSizeWithTag(4, r10.matrixBindProcessEndTime)) + r11.encodedSizeWithTag(5, r10.thirdJavaRevResResult)) + r10.unknownFields().size();
        }

        public MonitorInfo d(MonitorInfo r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MonitorInfo decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, MonitorInfo r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MonitorInfo r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MonitorInfo redact(MonitorInfo r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_THIRDSTARTTIME = 0L;
        DEFAULT_THIRDJAVAJNICALLTIME = 0L;
        DEFAULT_MATRIXBINDREVTIME = 0L;
        DEFAULT_MATRIXBINDPROCESSENDTIME = 0L;
        DEFAULT_THIRDJAVAREVRESRESULT = 0L;
    }

    public MonitorInfo(Long r10, Long r11, Long r12, Long r13, Long r14) {
        this(r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public MonitorInfo(Long r10, Long r11, Long r12, Long r13, Long r14, ByteString r15) {
        super(ADAPTER, r15);
        this.thirdStartTime = r10;
        this.thirdJavaJniCallTime = r11;
        this.matrixBindRevTime = r12;
        this.matrixBindProcessEndTime = r13;
        this.thirdJavaRevResResult = r14;
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof MonitorInfo) == true) goto L8;
        return false;
    L8:
        MonitorInfo r11 = (MonitorInfo) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L22;
        if (Internal.equals(this.thirdStartTime, r11.thirdStartTime) == false) goto L22;
        if (Internal.equals(this.thirdJavaJniCallTime, r11.thirdJavaJniCallTime) == false) goto L22;
        if (Internal.equals(this.matrixBindRevTime, r11.matrixBindRevTime) == false) goto L22;
        if (Internal.equals(this.matrixBindProcessEndTime, r11.matrixBindProcessEndTime) == false) goto L22;
        if (Internal.equals(this.thirdJavaRevResResult, r11.thirdJavaRevResResult) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L25;
        int r11 = unknownFields().hashCode() * 37;
        Long r12 = this.thirdStartTime;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Long r16 = this.thirdJavaJniCallTime;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        Long r19 = this.matrixBindRevTime;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (r18 + r20) * 37;
        Long r22 = this.matrixBindProcessEndTime;
        if (r22 == null) goto L19;
        int r23 = r22.hashCode();
    L20:
        int r24 = (r21 + r23) * 37;
        Long r25 = this.thirdJavaRevResResult;
        if (r25 == null) goto L23;
        r13 = r25.hashCode();
    L23:
        int r26 = r24 + r13;
        this.hashCode = r26;
        return r26;
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
    L25:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f5978a = this.thirdStartTime;
        r10.f5979b = this.thirdJavaJniCallTime;
        r10.f5980c = this.matrixBindRevTime;
        r10.f5981d = this.matrixBindProcessEndTime;
        r10.f5982e = this.thirdJavaRevResResult;
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
        if (this.thirdStartTime == null) goto L6;
        r10.append(", thirdStartTime=");
        r10.append(this.thirdStartTime);
    L6:
        if (this.thirdJavaJniCallTime == null) goto L9;
        r10.append(", thirdJavaJniCallTime=");
        r10.append(this.thirdJavaJniCallTime);
    L9:
        if (this.matrixBindRevTime == null) goto L12;
        r10.append(", matrixBindRevTime=");
        r10.append(this.matrixBindRevTime);
    L12:
        if (this.matrixBindProcessEndTime == null) goto L15;
        r10.append(", matrixBindProcessEndTime=");
        r10.append(this.matrixBindProcessEndTime);
    L15:
        if (this.thirdJavaRevResResult == null) goto L17;
        r10.append(", thirdJavaRevResResult=");
        r10.append(this.thirdJavaRevResResult);
    L17:
        StringBuilder r11 = r10.replace(0, 2, "MonitorInfo{");
        r11.append('}');
        return r11.toString();
    }
}
