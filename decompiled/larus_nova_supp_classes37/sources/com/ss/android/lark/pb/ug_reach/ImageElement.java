package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImageElement extends Message<ImageElement, Builder> {
    public static final ProtoAdapter<ImageElement> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final CdnImageElement mcdn_image;
    public final RawImageElement mraw_image;
    public final ImageType mtype;

    public static final class Builder extends Message.Builder<ImageElement, Builder> {
        public CdnImageElement mcdn_image;
        public RawImageElement mraw_image;
        public ImageType mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ImageElement m2444build() {
            return new ImageElement(this.mtype, this.mraw_image, this.mcdn_image, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2444build();
        }

        public Builder cdn_image(CdnImageElement r1) {
            this.mcdn_image = r1;
            this.mraw_image = null;
            return this;
        }

        public Builder raw_image(RawImageElement r1) {
            this.mraw_image = r1;
            this.mcdn_image = null;
            return this;
        }

        public Builder type(ImageType r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final enum ImageType extends Enum<ImageType> implements WireEnum {
        private static final /* synthetic */ ImageType[] $VALUES = null;
        public static final ProtoAdapter<ImageType> ADAPTER = null;
        public static final ImageType ENCRYPTED_BYTES = null;
        public static final ImageType ENCRYPTED_CDN_URL = null;
        public static final ImageType RAW_BYTES = null;
        public static final ImageType RAW_CDN_URL = null;
        public static final ImageType UNKNOWN = null;
        private final int value;

        static {
            ImageType r0 = new ImageType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ImageType r1 = new ImageType("RAW_BYTES", 1, 1);
            RAW_BYTES = r1;
            ImageType r3 = new ImageType("ENCRYPTED_BYTES", 2, 2);
            ENCRYPTED_BYTES = r3;
            ImageType r5 = new ImageType("RAW_CDN_URL", 3, 3);
            RAW_CDN_URL = r5;
            ImageType r7 = new ImageType("ENCRYPTED_CDN_URL", 4, 4);
            ENCRYPTED_CDN_URL = r7;
            $VALUES = new ImageType[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(ImageType.class);
        }

        public static ImageType[] values() {
            return (ImageType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ImageType fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return ENCRYPTED_CDN_URL;
        L16:
            return RAW_CDN_URL;
        L18:
            return ENCRYPTED_BYTES;
        L20:
            return RAW_BYTES;
        L22:
            return UNKNOWN;
        }

        public static ImageType valueOf(String r1) {
            return (ImageType) a.a(ImageType.class, r1);
        }

        private ImageType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_ImageElement extends ProtoAdapter<ImageElement> {
        public ProtoAdapter_ImageElement() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageElement.class);
        }

        public ImageElement decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mtype = (ImageType) ImageType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.raw_image((RawImageElement) RawImageElement.ADAPTER.decode(r9));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.cdn_image((CdnImageElement) CdnImageElement.ADAPTER.decode(r9));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2444build();
        }

        public int encodedSize(ImageElement r6) {
            ImageType r0 = r6.mtype;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ImageType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            RawImageElement r3 = r6.mraw_image;
            if (r3 == null) goto L9;
            int r4 = RawImageElement.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            CdnImageElement r7 = r6.mcdn_image;
            if (r7 == null) goto L14;
            r1 = CdnImageElement.ADAPTER.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m2445decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ImageElement) r1);
        }

        public void encode(ProtoWriter r4, ImageElement r5) throws IOException {
            ImageType r0 = r5.mtype;
            if (r0 == null) goto L5;
            ImageType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            RawImageElement r1 = r5.mraw_image;
            if (r1 == null) goto L8;
            RawImageElement.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            CdnImageElement r2 = r5.mcdn_image;
            if (r2 == null) goto L11;
            CdnImageElement.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ImageElement) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageElement();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2443newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.mraw_image = this.mraw_image;
        r0.mcdn_image = this.mcdn_image;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ImageElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2443newBuilder();
    }

    public ImageElement(ImageType r2, RawImageElement r3, CdnImageElement r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ImageElement(ImageType r2, RawImageElement r3, CdnImageElement r4, ByteString r5) {
        super(ADAPTER, r5);
        if (Internal.countNonNull(r3, r4) > 1) goto L7;
        this.mtype = r2;
        this.mraw_image = r3;
        this.mcdn_image = r4;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mraw_image, mcdn_image may be non-null");
    }
}
