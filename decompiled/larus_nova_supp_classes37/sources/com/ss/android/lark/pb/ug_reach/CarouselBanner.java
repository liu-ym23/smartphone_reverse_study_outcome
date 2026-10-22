package com.ss.android.lark.pb.ug_reach;

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
public final class CarouselBanner extends Message<CarouselBanner, Builder> {
    public static final ProtoAdapter<CarouselBanner> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<NormalBannerMaterial> mbanners;

    public static final class Builder extends Message.Builder<CarouselBanner, Builder> {
        public List<NormalBannerMaterial> mbanners;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CarouselBanner m2432build() {
            return new CarouselBanner(this.mbanners, super.buildUnknownFields());
        }

        public Builder() {
            this.mbanners = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2432build();
        }

        public Builder banners(List<NormalBannerMaterial> r1) {
            Internal.checkElementsNotNull(r1);
            this.mbanners = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CarouselBanner extends ProtoAdapter<CarouselBanner> {
        public ProtoAdapter_CarouselBanner() {
            super(FieldEncoding.LENGTH_DELIMITED, CarouselBanner.class);
        }

        public CarouselBanner decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mbanners.add((NormalBannerMaterial) NormalBannerMaterial.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2432build();
        }

        public int encodedSize(CarouselBanner r4) {
            return NormalBannerMaterial.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mbanners) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2433decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CarouselBanner) r1);
        }

        public void encode(ProtoWriter r4, CarouselBanner r5) throws IOException {
            NormalBannerMaterial.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mbanners);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CarouselBanner) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CarouselBanner();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2431newBuilder() {
        Builder r0 = new Builder();
        r0.mbanners = Internal.copyOf("mbanners", this.mbanners);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CarouselBanner.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2431newBuilder();
    }

    public CarouselBanner(List<NormalBannerMaterial> r2) {
        this(r2, ByteString.EMPTY);
    }

    public CarouselBanner(List<NormalBannerMaterial> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mbanners = Internal.immutableCopyOf("mbanners", r2);
    }
}
