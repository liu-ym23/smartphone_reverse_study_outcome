package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImageBaseAttribute extends com.squareup.wire.Message<ImageBaseAttribute, Builder> {
    public static final ProtoAdapter<ImageBaseAttribute> ADAPTER = null;
    public static final Integer DEFAULT_EXIF_ORIENTATION = null;
    public static final Integer DEFAULT_HEIGHT = null;
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final Integer mexif_orientation;
    public final Integer mheight;
    public final Integer mwidth;

    public static final class Builder extends com.squareup.wire.Message.Builder<ImageBaseAttribute, Builder> {
        public Integer mexif_orientation;
        public Integer mheight;
        public Integer mwidth;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ImageBaseAttribute m1277build() {
            Integer r0 = this.mwidth;
            if (r0 == null) goto L9;
            if (this.mheight == null) goto L9;
            return new ImageBaseAttribute(this.mwidth, this.mheight, this.mexif_orientation, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mwidth", this.mheight, "mheight"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1277build();
        }

        public Builder exif_orientation(Integer r1) {
            this.mexif_orientation = r1;
            return this;
        }

        public Builder height(Integer r1) {
            this.mheight = r1;
            return this;
        }

        public Builder width(Integer r1) {
            this.mwidth = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ImageBaseAttribute extends ProtoAdapter<ImageBaseAttribute> {
        public ProtoAdapter_ImageBaseAttribute() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageBaseAttribute.class);
        }

        public ImageBaseAttribute decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mwidth = 0;
            r0.mheight = 0;
            r0.mexif_orientation = 0;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mwidth = (Integer) ProtoAdapter.UINT32.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mheight = (Integer) ProtoAdapter.UINT32.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mexif_orientation = (Integer) ProtoAdapter.UINT32.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1277build();
        }

        public int encodedSize(ImageBaseAttribute r5) {
            ProtoAdapter r0 = ProtoAdapter.UINT32;
            int r1 = r0.encodedSizeWithTag(1, r5.mwidth) + r0.encodedSizeWithTag(2, r5.mheight);
            Integer r2 = r5.mexif_orientation;
            if (r2 == null) goto L5;
            int r3 = r0.encodedSizeWithTag(3, r2);
        L7:
            return (r1 + r3) + r5.unknownFields().size();
        L5:
            r3 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1278decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ImageBaseAttribute) r1);
        }

        public void encode(ProtoWriter r4, ImageBaseAttribute r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.UINT32;
            r0.encodeWithTag(r4, 1, r5.mwidth);
            r0.encodeWithTag(r4, 2, r5.mheight);
            Integer r1 = r5.mexif_orientation;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 3, r1);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ImageBaseAttribute) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageBaseAttribute();
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_EXIF_ORIENTATION = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1276newBuilder() {
        Builder r0 = new Builder();
        r0.mwidth = this.mwidth;
        r0.mheight = this.mheight;
        r0.mexif_orientation = this.mexif_orientation;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ImageBaseAttribute.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1276newBuilder();
    }

    public ImageBaseAttribute(Integer r2, Integer r3, Integer r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ImageBaseAttribute(Integer r2, Integer r3, Integer r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mwidth = r2;
        this.mheight = r3;
        this.mexif_orientation = r4;
    }
}
