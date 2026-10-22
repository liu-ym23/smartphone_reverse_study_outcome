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

        public Builder() {
            this.thirdStartTime = 0L;
            this.thirdJavaJniCallTime = 0L;
            this.matrixBindRevTime = 0L;
            this.matrixBindProcessEndTime = 0L;
            this.thirdJavaRevResResult = 0L;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder matrixBindProcessEndTime(Long r5) {
            this.matrixBindProcessEndTime = r5;
            return this;
        }

        public Builder matrixBindRevTime(Long r5) {
            this.matrixBindRevTime = r5;
            return this;
        }

        public Builder thirdJavaJniCallTime(Long r5) {
            this.thirdJavaJniCallTime = r5;
            return this;
        }

        public Builder thirdJavaRevResResult(Long r5) {
            this.thirdJavaRevResResult = r5;
            return this;
        }

        public Builder thirdStartTime(Long r5) {
            this.thirdStartTime = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public MonitorInfo build() {
            return new MonitorInfo(this.thirdStartTime, this.thirdJavaJniCallTime, this.matrixBindRevTime, this.matrixBindProcessEndTime, this.thirdJavaRevResResult, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_MonitorInfo extends ProtoAdapter<MonitorInfo> {
        public ProtoAdapter_MonitorInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MonitorInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MonitorInfo decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, MonitorInfo r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MonitorInfo r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MonitorInfo redact(MonitorInfo r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MonitorInfo decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L21;
            if (r12 != 1) goto L8;
            r5.thirdStartTime(ProtoAdapter.INT64.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L10;
            r5.thirdJavaJniCallTime(ProtoAdapter.INT64.decode(r10));
            goto L3
        L10:
            if (r12 != 3) goto L12;
            r5.matrixBindRevTime(ProtoAdapter.INT64.decode(r10));
            goto L3
        L12:
            if (r12 != 4) goto L14;
            r5.matrixBindProcessEndTime(ProtoAdapter.INT64.decode(r10));
            goto L3
        L14:
            if (r12 != 5) goto L15;
            r5.thirdJavaRevResResult(ProtoAdapter.INT64.decode(r10));
            goto L3
        L15:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L21:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, MonitorInfo r10) throws IOException {
            ProtoAdapter<Long> r11 = ProtoAdapter.INT64;
            r11.encodeWithTag(r5, 1, r10.thirdStartTime);
            r11.encodeWithTag(r5, 2, r10.thirdJavaJniCallTime);
            r11.encodeWithTag(r5, 3, r10.matrixBindRevTime);
            r11.encodeWithTag(r5, 4, r10.matrixBindProcessEndTime);
            r11.encodeWithTag(r5, 5, r10.thirdJavaRevResResult);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MonitorInfo r5) {
            ProtoAdapter<Long> r10 = ProtoAdapter.INT64;
            int r11 = r10.encodedSizeWithTag(1, r5.thirdStartTime);
            int r12 = r10.encodedSizeWithTag(2, r5.thirdJavaJniCallTime) + r11;
            int r13 = r10.encodedSizeWithTag(3, r5.matrixBindRevTime) + r12;
            int r14 = r10.encodedSizeWithTag(4, r5.matrixBindProcessEndTime) + r13;
            int r15 = r10.encodedSizeWithTag(5, r5.thirdJavaRevResResult) + r14;
            return r5.unknownFields().size() + r15;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public MonitorInfo redact2(MonitorInfo r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
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

    public MonitorInfo(Long r10, Long r11, Long r12, Long r13, Long r14) {
        this(r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof MonitorInfo) == true) goto L8;
        return false;
    L8:
        MonitorInfo r10 = (MonitorInfo) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L22;
        if (Internal.equals(this.thirdStartTime, r10.thirdStartTime) == false) goto L22;
        if (Internal.equals(this.thirdJavaJniCallTime, r10.thirdJavaJniCallTime) == false) goto L22;
        if (Internal.equals(this.matrixBindRevTime, r10.matrixBindRevTime) == false) goto L22;
        if (Internal.equals(this.matrixBindProcessEndTime, r10.matrixBindProcessEndTime) == false) goto L22;
        if (Internal.equals(this.thirdJavaRevResResult, r10.thirdJavaRevResResult) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L25;
        int r10 = unknownFields().hashCode() * 37;
        Long r11 = this.thirdStartTime;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Long r15 = this.thirdJavaJniCallTime;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        Long r18 = this.matrixBindRevTime;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        Long r21 = this.matrixBindProcessEndTime;
        if (r21 == null) goto L19;
        int r22 = r21.hashCode();
    L20:
        int r23 = (r20 + r22) * 37;
        Long r24 = this.thirdJavaRevResResult;
        if (r24 == null) goto L23;
        r12 = r24.hashCode();
    L23:
        int r25 = r23 + r12;
        this.hashCode = r25;
        return r25;
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
    L25:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.thirdStartTime == null) goto L6;
        r5.append(", thirdStartTime=");
        r5.append(this.thirdStartTime);
    L6:
        if (this.thirdJavaJniCallTime == null) goto L9;
        r5.append(", thirdJavaJniCallTime=");
        r5.append(this.thirdJavaJniCallTime);
    L9:
        if (this.matrixBindRevTime == null) goto L12;
        r5.append(", matrixBindRevTime=");
        r5.append(this.matrixBindRevTime);
    L12:
        if (this.matrixBindProcessEndTime == null) goto L15;
        r5.append(", matrixBindProcessEndTime=");
        r5.append(this.matrixBindProcessEndTime);
    L15:
        if (this.thirdJavaRevResResult == null) goto L18;
        r5.append(", thirdJavaRevResResult=");
        r5.append(this.thirdJavaRevResResult);
    L18:
        return a.s(r5, 0, 2, "MonitorInfo{", '}');
    }

    public MonitorInfo(Long r5, Long r10, Long r11, Long r12, Long r13, ByteString r14) {
        super(ADAPTER, r14);
        this.thirdStartTime = r5;
        this.thirdJavaJniCallTime = r10;
        this.matrixBindRevTime = r11;
        this.matrixBindProcessEndTime = r12;
        this.thirdJavaRevResResult = r13;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.thirdStartTime = this.thirdStartTime;
        r5.thirdJavaJniCallTime = this.thirdJavaJniCallTime;
        r5.matrixBindRevTime = this.matrixBindRevTime;
        r5.matrixBindProcessEndTime = this.matrixBindProcessEndTime;
        r5.thirdJavaRevResResult = this.thirdJavaRevResResult;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
