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
public final class MonitorInfo extends Message<MonitorInfo, Builder> {
    public static final ProtoAdapter<MonitorInfo> ADAPTER = null;
    public static final Long DEFAULT_MATRIXBINDPROCESSENDTIME = null;
    public static final Long DEFAULT_MATRIXBINDREVTIME = null;
    public static final Long DEFAULT_THIRDJAVAJNICALLTIME = null;
    public static final Long DEFAULT_THIRDJAVAREVRESRESULT = null;
    public static final Long DEFAULT_THIRDSTARTTIME = null;
    private static final long serialVersionUID = 0;

    @SerializedName("matrixBindProcessEndTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long matrixBindProcessEndTime;

    @SerializedName("matrixBindRevTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long matrixBindRevTime;

    @SerializedName("thirdJavaJniCallTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long thirdJavaJniCallTime;

    @SerializedName("thirdJavaRevResResult")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long thirdJavaRevResResult;

    @SerializedName("thirdStartTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long thirdStartTime;

    public static final class Builder extends Message.Builder<MonitorInfo, Builder> {
        public Long matrixBindProcessEndTime;
        public Long matrixBindRevTime;
        public Long thirdJavaJniCallTime;
        public Long thirdJavaRevResResult;
        public Long thirdStartTime;

        public MonitorInfo build() {
            return new MonitorInfo(this.thirdStartTime, this.thirdJavaJniCallTime, this.matrixBindRevTime, this.matrixBindProcessEndTime, this.thirdJavaRevResResult, super.buildUnknownFields());
        }

        public Builder() {
            this.thirdStartTime = 0L;
            this.thirdJavaJniCallTime = 0L;
            this.matrixBindRevTime = 0L;
            this.matrixBindProcessEndTime = 0L;
            this.thirdJavaRevResResult = 0L;
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m115build() {
            return build();
        }

        public Builder matrixBindProcessEndTime(Long r1) {
            this.matrixBindProcessEndTime = r1;
            return this;
        }

        public Builder matrixBindRevTime(Long r1) {
            this.matrixBindRevTime = r1;
            return this;
        }

        public Builder thirdJavaJniCallTime(Long r1) {
            this.thirdJavaJniCallTime = r1;
            return this;
        }

        public Builder thirdJavaRevResResult(Long r1) {
            this.thirdJavaRevResResult = r1;
            return this;
        }

        public Builder thirdStartTime(Long r1) {
            this.thirdStartTime = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MonitorInfo extends ProtoAdapter<MonitorInfo> {
        public ProtoAdapter_MonitorInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MonitorInfo.class);
        }

        public MonitorInfo decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.thirdStartTime((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.thirdJavaJniCallTime((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.matrixBindRevTime((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.matrixBindProcessEndTime((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.thirdJavaRevResResult((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(MonitorInfo r5) {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            return ((((r0.encodedSizeWithTag(1, r5.thirdStartTime) + r0.encodedSizeWithTag(2, r5.thirdJavaJniCallTime)) + r0.encodedSizeWithTag(3, r5.matrixBindRevTime)) + r0.encodedSizeWithTag(4, r5.matrixBindProcessEndTime)) + r0.encodedSizeWithTag(5, r5.thirdJavaRevResResult)) + r5.unknownFields().size();
        }

        public MonitorInfo redact(MonitorInfo r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m116decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MonitorInfo) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((MonitorInfo) r1);
        }

        public void encode(ProtoWriter r4, MonitorInfo r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r4, 1, r5.thirdStartTime);
            r0.encodeWithTag(r4, 2, r5.thirdJavaJniCallTime);
            r0.encodeWithTag(r4, 3, r5.matrixBindRevTime);
            r0.encodeWithTag(r4, 4, r5.matrixBindProcessEndTime);
            r0.encodeWithTag(r4, 5, r5.thirdJavaRevResResult);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MonitorInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MonitorInfo();
        DEFAULT_THIRDSTARTTIME = 0L;
        DEFAULT_THIRDJAVAJNICALLTIME = 0L;
        DEFAULT_MATRIXBINDREVTIME = 0L;
        DEFAULT_MATRIXBINDPROCESSENDTIME = 0L;
        DEFAULT_THIRDJAVAREVRESRESULT = 0L;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L25;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.thirdStartTime;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.thirdJavaJniCallTime;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Long r9 = this.matrixBindRevTime;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.matrixBindProcessEndTime;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Long r15 = this.thirdJavaRevResResult;
        if (r15 == null) goto L23;
        r3 = r15.hashCode();
    L23:
        int r16 = r14 + r3;
        ((Message) this).hashCode = r16;
        return r16;
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
    L25:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.thirdStartTime = this.thirdStartTime;
        r0.thirdJavaJniCallTime = this.thirdJavaJniCallTime;
        r0.matrixBindRevTime = this.matrixBindRevTime;
        r0.matrixBindProcessEndTime = this.matrixBindProcessEndTime;
        r0.thirdJavaRevResResult = this.thirdJavaRevResResult;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.thirdStartTime == null) goto L6;
        r0.append(", thirdStartTime=");
        r0.append(this.thirdStartTime);
    L6:
        if (this.thirdJavaJniCallTime == null) goto L9;
        r0.append(", thirdJavaJniCallTime=");
        r0.append(this.thirdJavaJniCallTime);
    L9:
        if (this.matrixBindRevTime == null) goto L12;
        r0.append(", matrixBindRevTime=");
        r0.append(this.matrixBindRevTime);
    L12:
        if (this.matrixBindProcessEndTime == null) goto L15;
        r0.append(", matrixBindProcessEndTime=");
        r0.append(this.matrixBindProcessEndTime);
    L15:
        if (this.thirdJavaRevResResult == null) goto L17;
        r0.append(", thirdJavaRevResResult=");
        r0.append(this.thirdJavaRevResResult);
    L17:
        StringBuilder r1 = r0.replace(0, 2, "MonitorInfo{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m114newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof MonitorInfo) == true) goto L8;
        return false;
    L8:
        MonitorInfo r6 = (MonitorInfo) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L21:
        return false;
    L11:
        if (Internal.equals(this.thirdStartTime, r6.thirdStartTime) == false) goto L21;
        if (Internal.equals(this.thirdJavaJniCallTime, r6.thirdJavaJniCallTime) == false) goto L21;
        if (Internal.equals(this.matrixBindRevTime, r6.matrixBindRevTime) == false) goto L21;
        if (Internal.equals(this.matrixBindProcessEndTime, r6.matrixBindProcessEndTime) == false) goto L21;
        if (Internal.equals(this.thirdJavaRevResResult, r6.thirdJavaRevResResult) == false) goto L21;
        return true;
    }

    public MonitorInfo(Long r8, Long r9, Long r10, Long r11, Long r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public MonitorInfo(Long r2, Long r3, Long r4, Long r5, Long r6, ByteString r7) {
        super(ADAPTER, r7);
        this.thirdStartTime = r2;
        this.thirdJavaJniCallTime = r3;
        this.matrixBindRevTime = r4;
        this.matrixBindProcessEndTime = r5;
        this.thirdJavaRevResResult = r6;
    }
}
