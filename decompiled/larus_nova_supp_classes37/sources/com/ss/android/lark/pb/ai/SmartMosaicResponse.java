package com.ss.android.lark.pb.ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SmartMosaicResponse extends Message<SmartMosaicResponse, Builder> {
    public static final ProtoAdapter<SmartMosaicResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Polygon> mpolygons;

    public static final class Builder extends Message.Builder<SmartMosaicResponse, Builder> {
        public List<Polygon> mpolygons;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SmartMosaicResponse m773build() {
            return new SmartMosaicResponse(this.mpolygons, super.buildUnknownFields());
        }

        public Builder() {
            this.mpolygons = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m773build();
        }

        public Builder polygons(List<Polygon> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpolygons = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SmartMosaicResponse extends ProtoAdapter<SmartMosaicResponse> {
        public ProtoAdapter_SmartMosaicResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SmartMosaicResponse.class);
        }

        public SmartMosaicResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mpolygons.add((Polygon) Polygon.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m773build();
        }

        public int encodedSize(SmartMosaicResponse r4) {
            return Polygon.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mpolygons) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m774decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SmartMosaicResponse) r1);
        }

        public void encode(ProtoWriter r4, SmartMosaicResponse r5) throws IOException {
            Polygon.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mpolygons);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SmartMosaicResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SmartMosaicResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m772newBuilder() {
        Builder r0 = new Builder();
        r0.mpolygons = Internal.copyOf("mpolygons", this.mpolygons);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SmartMosaicResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m772newBuilder();
    }

    public SmartMosaicResponse(List<Polygon> r2) {
        this(r2, ByteString.EMPTY);
    }

    public SmartMosaicResponse(List<Polygon> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mpolygons = Internal.immutableCopyOf("mpolygons", r2);
    }
}
