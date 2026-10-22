package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImageSet extends com.squareup.wire.Message<ImageSet, Builder> {
    public static final ProtoAdapter<ImageSet> ADAPTER = null;
    public static final String DEFAULT_IMAGE_KEY = "";
    public static final String DEFAULT_KEY = "";
    private static final long serialVersionUID = 0;
    public final Image mcover;
    public final String mimage_key;
    public final Image mintact;
    public final String mkey;
    public final Image mmiddle;
    public final Image mmiddle_mp4;
    public final Image mmiddle_webp;
    public final Image morigin;
    public final Image mthumbnail;
    public final Image mthumbnail_webp;

    public static final class Builder extends com.squareup.wire.Message.Builder<ImageSet, Builder> {
        public Image mcover;
        public String mimage_key;
        public Image mintact;
        public String mkey;
        public Image mmiddle;
        public Image mmiddle_mp4;
        public Image mmiddle_webp;
        public Image morigin;
        public Image mthumbnail;
        public Image mthumbnail_webp;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ImageSet m1280build() {
            return new ImageSet(this.mkey, this.morigin, this.mthumbnail, this.mimage_key, this.mmiddle, this.mthumbnail_webp, this.mmiddle_webp, this.mmiddle_mp4, this.mcover, this.mintact, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1280build();
        }

        public Builder cover(Image r1) {
            this.mcover = r1;
            return this;
        }

        public Builder image_key(String r1) {
            this.mimage_key = r1;
            return this;
        }

        public Builder intact(Image r1) {
            this.mintact = r1;
            return this;
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder middle(Image r1) {
            this.mmiddle = r1;
            return this;
        }

        public Builder middle_mp4(Image r1) {
            this.mmiddle_mp4 = r1;
            return this;
        }

        public Builder middle_webp(Image r1) {
            this.mmiddle_webp = r1;
            return this;
        }

        public Builder origin(Image r1) {
            this.morigin = r1;
            return this;
        }

        public Builder thumbnail(Image r1) {
            this.mthumbnail = r1;
            return this;
        }

        public Builder thumbnail_webp(Image r1) {
            this.mthumbnail_webp = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ImageSet extends ProtoAdapter<ImageSet> {
        public ProtoAdapter_ImageSet() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageSet.class);
        }

        public ImageSet decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mkey = "";
            r0.mimage_key = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r0.mintact = (Image) Image.ADAPTER.decode(r7);
            goto L3
        L8:
            r0.mcover = (Image) Image.ADAPTER.decode(r7);
            goto L3
        L9:
            r0.mmiddle_mp4 = (Image) Image.ADAPTER.decode(r7);
            goto L3
        L10:
            r0.mmiddle_webp = (Image) Image.ADAPTER.decode(r7);
            goto L3
        L11:
            r0.mthumbnail_webp = (Image) Image.ADAPTER.decode(r7);
            goto L3
        L12:
            r0.mmiddle = (Image) Image.ADAPTER.decode(r7);
            goto L3
        L13:
            r0.mimage_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            r0.mthumbnail = (Image) Image.ADAPTER.decode(r7);
            goto L3
        L15:
            r0.morigin = (Image) Image.ADAPTER.decode(r7);
            goto L3
        L16:
            r0.mkey = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L17:
            r7.endMessage(r1);
            return r0.m1280build();
        }

        public int encodedSize(ImageSet r6) {
            String r0 = r6.mkey;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Image r3 = r6.morigin;
            if (r3 == null) goto L9;
            int r4 = Image.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Image r7 = r6.mthumbnail;
            if (r7 == null) goto L13;
            int r8 = Image.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mimage_key;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Image r13 = r6.mmiddle;
            if (r13 == null) goto L21;
            int r14 = Image.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Image r16 = r6.mthumbnail_webp;
            if (r16 == null) goto L25;
            int r17 = Image.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Image r19 = r6.mmiddle_webp;
            if (r19 == null) goto L29;
            int r20 = Image.ADAPTER.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            Image r22 = r6.mmiddle_mp4;
            if (r22 == null) goto L33;
            int r23 = Image.ADAPTER.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            Image r25 = r6.mcover;
            if (r25 == null) goto L37;
            int r26 = Image.ADAPTER.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            Image r28 = r6.mintact;
            if (r28 == null) goto L42;
            r1 = Image.ADAPTER.encodedSizeWithTag(10, r28);
        L42:
            return (r27 + r1) + r6.unknownFields().size();
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1281decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ImageSet) r1);
        }

        public void encode(ProtoWriter r4, ImageSet r5) throws IOException {
            String r0 = r5.mkey;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Image r1 = r5.morigin;
            if (r1 == null) goto L8;
            Image.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            Image r2 = r5.mthumbnail;
            if (r2 == null) goto L11;
            Image.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mimage_key;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            Image r6 = r5.mmiddle;
            if (r6 == null) goto L17;
            Image.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            Image r7 = r5.mthumbnail_webp;
            if (r7 == null) goto L20;
            Image.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            Image r8 = r5.mmiddle_webp;
            if (r8 == null) goto L23;
            Image.ADAPTER.encodeWithTag(r4, 7, r8);
        L23:
            Image r9 = r5.mmiddle_mp4;
            if (r9 == null) goto L26;
            Image.ADAPTER.encodeWithTag(r4, 8, r9);
        L26:
            Image r10 = r5.mcover;
            if (r10 == null) goto L29;
            Image.ADAPTER.encodeWithTag(r4, 9, r10);
        L29:
            Image r11 = r5.mintact;
            if (r11 == null) goto L32;
            Image.ADAPTER.encodeWithTag(r4, 10, r11);
        L32:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ImageSet) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageSet();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1279newBuilder() {
        Builder r0 = new Builder();
        r0.mkey = this.mkey;
        r0.morigin = this.morigin;
        r0.mthumbnail = this.mthumbnail;
        r0.mimage_key = this.mimage_key;
        r0.mmiddle = this.mmiddle;
        r0.mthumbnail_webp = this.mthumbnail_webp;
        r0.mmiddle_webp = this.mmiddle_webp;
        r0.mmiddle_mp4 = this.mmiddle_mp4;
        r0.mcover = this.mcover;
        r0.mintact = this.mintact;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ImageSet.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1279newBuilder();
    }

    public ImageSet(String r13, Image r14, Image r15, String r16, Image r17, Image r18, Image r19, Image r20, Image r21, Image r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public ImageSet(String r2, Image r3, Image r4, String r5, Image r6, Image r7, Image r8, Image r9, Image r10, Image r11, ByteString r12) {
        super(ADAPTER, r12);
        this.mkey = r2;
        this.morigin = r3;
        this.mthumbnail = r4;
        this.mimage_key = r5;
        this.mmiddle = r6;
        this.mthumbnail_webp = r7;
        this.mmiddle_webp = r8;
        this.mmiddle_mp4 = r9;
        this.mcover = r10;
        this.mintact = r11;
    }
}
