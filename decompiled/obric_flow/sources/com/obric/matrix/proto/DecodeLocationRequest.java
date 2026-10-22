package com.obric.matrix.proto;

import androidx.room.jarjarred.org.antlr.runtime.a;
import cn.nubia.neopush.commons.Constant;
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
public final class DecodeLocationRequest extends Message<DecodeLocationRequest, Builder> {
    public static final ProtoAdapter<DecodeLocationRequest> ADAPTER = null;
    public static final Double DEFAULT_LATITUDE = null;
    public static final Double DEFAULT_LONGITUDE = null;
    public static final String DEFAULT_PACKAGENAME = "";
    private static final long serialVersionUID = 0;

    @SerializedName(Constant.LATITUDE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 3)
    public final Double latitude;

    @SerializedName(Constant.LONGITUDE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double longitude;

    @SerializedName("packageName")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String packageName;

    public static final class Builder extends Message.Builder<DecodeLocationRequest, Builder> {
        public Double latitude;
        public Double longitude;
        public String packageName;

        public Builder() {
            this.packageName = "";
            Double r5 = Double.valueOf(0.0d);
            this.longitude = r5;
            this.latitude = r5;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder latitude(Double r5) {
            this.latitude = r5;
            return this;
        }

        public Builder longitude(Double r5) {
            this.longitude = r5;
            return this;
        }

        public Builder packageName(String r5) {
            this.packageName = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public DecodeLocationRequest build() {
            return new DecodeLocationRequest(this.packageName, this.longitude, this.latitude, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_DecodeLocationRequest extends ProtoAdapter<DecodeLocationRequest> {
        public ProtoAdapter_DecodeLocationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DecodeLocationRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DecodeLocationRequest decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, DecodeLocationRequest r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DecodeLocationRequest r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DecodeLocationRequest redact(DecodeLocationRequest r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DecodeLocationRequest decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L15;
            if (r12 != 1) goto L8;
            r5.packageName(ProtoAdapter.STRING.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L10;
            r5.longitude(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L10:
            if (r12 != 3) goto L11;
            r5.latitude(ProtoAdapter.DOUBLE.decode(r10));
            goto L3
        L11:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L15:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, DecodeLocationRequest r10) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r5, 1, r10.packageName);
            ProtoAdapter<Double> r11 = ProtoAdapter.DOUBLE;
            r11.encodeWithTag(r5, 2, r10.longitude);
            r11.encodeWithTag(r5, 3, r10.latitude);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DecodeLocationRequest r5) {
            int r10 = ProtoAdapter.STRING.encodedSizeWithTag(1, r5.packageName);
            ProtoAdapter<Double> r11 = ProtoAdapter.DOUBLE;
            int r12 = r11.encodedSizeWithTag(2, r5.longitude) + r10;
            int r13 = r11.encodedSizeWithTag(3, r5.latitude) + r12;
            return r5.unknownFields().size() + r13;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public DecodeLocationRequest redact2(DecodeLocationRequest r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DecodeLocationRequest();
        Double r5 = Double.valueOf(0.0d);
        DEFAULT_LONGITUDE = r5;
        DEFAULT_LATITUDE = r5;
    }

    public DecodeLocationRequest(String r5, Double r10, Double r11) {
        this(r5, r10, r11, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof DecodeLocationRequest) == true) goto L8;
        return false;
    L8:
        DecodeLocationRequest r10 = (DecodeLocationRequest) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L18;
        if (Internal.equals(this.packageName, r10.packageName) == false) goto L18;
        if (Internal.equals(this.longitude, r10.longitude) == false) goto L18;
        if (Internal.equals(this.latitude, r10.latitude) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L17;
        int r10 = unknownFields().hashCode() * 37;
        String r11 = this.packageName;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Double r15 = this.longitude;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        Double r18 = this.latitude;
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
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.packageName == null) goto L6;
        r5.append(", packageName=");
        r5.append(this.packageName);
    L6:
        if (this.longitude == null) goto L9;
        r5.append(", longitude=");
        r5.append(this.longitude);
    L9:
        if (this.latitude == null) goto L12;
        r5.append(", latitude=");
        r5.append(this.latitude);
    L12:
        return a.s(r5, 0, 2, "DecodeLocationRequest{", '}');
    }

    public DecodeLocationRequest(String r5, Double r10, Double r11, ByteString r12) {
        super(ADAPTER, r12);
        this.packageName = r5;
        this.longitude = r10;
        this.latitude = r11;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.packageName = this.packageName;
        r5.longitude = this.longitude;
        r5.latitude = this.latitude;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
