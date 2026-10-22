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
public final class BannerMaterialCollection extends Message<BannerMaterialCollection, Builder> {
    public static final ProtoAdapter<BannerMaterialCollection> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<BannerMaterial> mbanners;

    public static final class Builder extends Message.Builder<BannerMaterialCollection, Builder> {
        public List<BannerMaterial> mbanners;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BannerMaterialCollection m2420build() {
            return new BannerMaterialCollection(this.mbanners, super.buildUnknownFields());
        }

        public Builder() {
            this.mbanners = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2420build();
        }

        public Builder banners(List<BannerMaterial> r1) {
            Internal.checkElementsNotNull(r1);
            this.mbanners = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerMaterialCollection extends ProtoAdapter<BannerMaterialCollection> {
        public ProtoAdapter_BannerMaterialCollection() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerMaterialCollection.class);
        }

        public BannerMaterialCollection decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.mbanners.add((BannerMaterial) BannerMaterial.ADAPTER.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.m2420build();
        }

        public int encodedSize(BannerMaterialCollection r4) {
            return BannerMaterial.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mbanners) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2421decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BannerMaterialCollection) r1);
        }

        public void encode(ProtoWriter r4, BannerMaterialCollection r5) throws IOException {
            BannerMaterial.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mbanners);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BannerMaterialCollection) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerMaterialCollection();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2419newBuilder() {
        Builder r0 = new Builder();
        r0.mbanners = Internal.copyOf("mbanners", this.mbanners);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BannerMaterialCollection.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2419newBuilder();
    }

    public BannerMaterialCollection(List<BannerMaterial> r2) {
        this(r2, ByteString.EMPTY);
    }

    public BannerMaterialCollection(List<BannerMaterial> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mbanners = Internal.immutableCopyOf("mbanners", r2);
    }
}
