package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.entities.ImageSetPassThrough;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class IconInfo extends Message<IconInfo, Builder> {
    public static final ProtoAdapter<IconInfo> ADAPTER = null;
    public static final String DEFAULT_UD_IMAGE = "";
    private static final long serialVersionUID = 0;
    public final IconImageType micon_image_type;
    public final ImageSetPassThrough mimage;
    public final String mud_image;

    public static final class Builder extends Message.Builder<IconInfo, Builder> {
        public IconImageType micon_image_type;
        public ImageSetPassThrough mimage;
        public String mud_image;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public IconInfo m1961build() {
            return new IconInfo(this.micon_image_type, this.mud_image, this.mimage, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1961build();
        }

        public Builder icon_image_type(IconImageType r1) {
            this.micon_image_type = r1;
            return this;
        }

        public Builder image(ImageSetPassThrough r1) {
            this.mimage = r1;
            return this;
        }

        public Builder ud_image(String r1) {
            this.mud_image = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_IconInfo extends ProtoAdapter<IconInfo> {
        public ProtoAdapter_IconInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, IconInfo.class);
        }

        public IconInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mud_image = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.micon_image_type = (IconImageType) IconImageType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mud_image = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mimage = (ImageSetPassThrough) ImageSetPassThrough.ADAPTER.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m1961build();
        }

        public int encodedSize(IconInfo r6) {
            IconImageType r0 = r6.micon_image_type;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = IconImageType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mud_image;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ImageSetPassThrough r7 = r6.mimage;
            if (r7 == null) goto L14;
            r1 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1962decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((IconInfo) r1);
        }

        public void encode(ProtoWriter r4, IconInfo r5) throws IOException {
            IconImageType r0 = r5.micon_image_type;
            if (r0 == null) goto L5;
            IconImageType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mud_image;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            ImageSetPassThrough r2 = r5.mimage;
            if (r2 == null) goto L11;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (IconInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_IconInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1960newBuilder() {
        Builder r0 = new Builder();
        r0.micon_image_type = this.micon_image_type;
        r0.mud_image = this.mud_image;
        r0.mimage = this.mimage;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return IconInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1960newBuilder();
    }

    public IconInfo(IconImageType r2, String r3, ImageSetPassThrough r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public IconInfo(IconImageType r2, String r3, ImageSetPassThrough r4, ByteString r5) {
        super(ADAPTER, r5);
        this.micon_image_type = r2;
        this.mud_image = r3;
        this.mimage = r4;
    }
}
