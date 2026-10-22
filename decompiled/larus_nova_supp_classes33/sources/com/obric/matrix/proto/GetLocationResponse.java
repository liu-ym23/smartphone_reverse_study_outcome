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
public final class GetLocationResponse extends Message<GetLocationResponse, Builder> {
    public static final ProtoAdapter<GetLocationResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("locationInfo")
    @WireField(adapter = "com.obric.matrix.proto.LocationInfo#ADAPTER", tag = 1)
    public final LocationInfo locationInfo;

    public static final class Builder extends Message.Builder<GetLocationResponse, Builder> {
        public LocationInfo locationInfo;

        public GetLocationResponse build() {
            return new GetLocationResponse(this.locationInfo, super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m102build() {
            return build();
        }

        public Builder locationInfo(LocationInfo r1) {
            this.locationInfo = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetLocationResponse extends ProtoAdapter<GetLocationResponse> {
        public ProtoAdapter_GetLocationResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetLocationResponse.class);
        }

        public GetLocationResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.locationInfo((LocationInfo) LocationInfo.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(GetLocationResponse r4) {
            return LocationInfo.ADAPTER.encodedSizeWithTag(1, r4.locationInfo) + r4.unknownFields().size();
        }

        public GetLocationResponse redact(GetLocationResponse r3) {
            Builder r4 = r3.newBuilder();
            LocationInfo r0 = r4.locationInfo;
            if (r0 == null) goto L5;
            r4.locationInfo = (LocationInfo) LocationInfo.ADAPTER.redact(r0);
        L5:
            r4.clearUnknownFields();
            return r4.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m103decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetLocationResponse) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((GetLocationResponse) r1);
        }

        public void encode(ProtoWriter r4, GetLocationResponse r5) throws IOException {
            LocationInfo.ADAPTER.encodeWithTag(r4, 1, r5.locationInfo);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetLocationResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetLocationResponse();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        LocationInfo r2 = this.locationInfo;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = r1 + r3;
        ((Message) this).hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.locationInfo = this.locationInfo;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.locationInfo == null) goto L5;
        r0.append(", locationInfo=");
        r0.append(this.locationInfo);
    L5:
        StringBuilder r1 = r0.replace(0, 2, "GetLocationResponse{");
        r1.append('}');
        return r1.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m101newBuilder() {
        return newBuilder();
    }

    public GetLocationResponse(LocationInfo r2) {
        this(r2, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetLocationResponse) == true) goto L8;
        return false;
    L8:
        GetLocationResponse r6 = (GetLocationResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (Internal.equals(this.locationInfo, r6.locationInfo) == false) goto L13;
        return true;
    }

    public GetLocationResponse(LocationInfo r2, ByteString r3) {
        super(ADAPTER, r3);
        this.locationInfo = r2;
    }
}
