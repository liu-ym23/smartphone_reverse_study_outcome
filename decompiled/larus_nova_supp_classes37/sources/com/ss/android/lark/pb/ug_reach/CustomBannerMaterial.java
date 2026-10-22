package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class CustomBannerMaterial extends Message<CustomBannerMaterial, Builder> {
    public static final ProtoAdapter<CustomBannerMaterial> ADAPTER = null;
    public static final String DEFAULT_DATA = "";
    public static final String DEFAULT_LAYOUT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mdata;
    public final String mlayout_name;

    public static final class Builder extends Message.Builder<CustomBannerMaterial, Builder> {
        public String mdata;
        public String mlayout_name;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CustomBannerMaterial m2438build() {
            return new CustomBannerMaterial(this.mlayout_name, this.mdata, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2438build();
        }

        public Builder data(String r1) {
            this.mdata = r1;
            return this;
        }

        public Builder layout_name(String r1) {
            this.mlayout_name = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomBannerMaterial extends ProtoAdapter<CustomBannerMaterial> {
        public ProtoAdapter_CustomBannerMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomBannerMaterial.class);
        }

        public CustomBannerMaterial decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mlayout_name = "";
            r0.mdata = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mlayout_name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mdata = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m2438build();
        }

        public int encodedSize(CustomBannerMaterial r5) {
            String r0 = r5.mlayout_name;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mdata;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2439decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CustomBannerMaterial) r1);
        }

        public void encode(ProtoWriter r4, CustomBannerMaterial r5) throws IOException {
            String r0 = r5.mlayout_name;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mdata;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CustomBannerMaterial) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomBannerMaterial();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2437newBuilder() {
        Builder r0 = new Builder();
        r0.mlayout_name = this.mlayout_name;
        r0.mdata = this.mdata;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CustomBannerMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2437newBuilder();
    }

    public CustomBannerMaterial(String r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public CustomBannerMaterial(String r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mlayout_name = r2;
        this.mdata = r3;
    }
}
