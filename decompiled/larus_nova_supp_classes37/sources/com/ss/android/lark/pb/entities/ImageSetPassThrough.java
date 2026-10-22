package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImageSetPassThrough extends com.squareup.wire.Message<ImageSetPassThrough, Builder> {
    public static final ProtoAdapter<ImageSetPassThrough> ADAPTER = null;
    public static final Integer DEFAULT_FILE_TYPE = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final Integer DEFAULT_HEIGHT = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_URL = "";
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final Crypto mcrypto;
    public final Integer mfile_type;
    public final String mfs_unit;
    public final Integer mheight;
    public final String mkey;
    public final String murl;
    public final Integer mwidth;

    public static final class Builder extends com.squareup.wire.Message.Builder<ImageSetPassThrough, Builder> {
        public Crypto mcrypto;
        public Integer mfile_type;
        public String mfs_unit;
        public Integer mheight;
        public String mkey;
        public String murl;
        public Integer mwidth;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ImageSetPassThrough m1283build() {
            String r0 = this.mkey;
            if (r0 == null) goto L7;
            return new ImageSetPassThrough(this.mkey, this.mfs_unit, this.murl, this.mcrypto, this.mfile_type, this.mwidth, this.mheight, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mkey"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1283build();
        }

        public Builder crypto(Crypto r1) {
            this.mcrypto = r1;
            return this;
        }

        public Builder file_type(Integer r1) {
            this.mfile_type = r1;
            return this;
        }

        public Builder fs_unit(String r1) {
            this.mfs_unit = r1;
            return this;
        }

        public Builder height(Integer r1) {
            this.mheight = r1;
            return this;
        }

        public Builder key(String r1) {
            this.mkey = r1;
            return this;
        }

        public Builder url(String r1) {
            this.murl = r1;
            return this;
        }

        public Builder width(Integer r1) {
            this.mwidth = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ImageSetPassThrough extends ProtoAdapter<ImageSetPassThrough> {
        public ProtoAdapter_ImageSetPassThrough() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageSetPassThrough.class);
        }

        public ImageSetPassThrough decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mkey = "";
            r0.mfs_unit = "";
            r0.murl = "";
            r0.mfile_type = 0;
            r0.mwidth = 0;
            r0.mheight = 0;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L14;
            switch(r3) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r0.mheight = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L8:
            r0.mwidth = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L9:
            r0.mfile_type = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L10:
            r0.mcrypto = (Crypto) Crypto.ADAPTER.decode(r7);
            goto L3
        L11:
            r0.murl = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mfs_unit = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            r0.mkey = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r1);
            return r0.m1283build();
        }

        public int encodedSize(ImageSetPassThrough r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r6.mkey);
            String r2 = r6.mfs_unit;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r7 = r6.murl;
            if (r7 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(3, r7);
        L10:
            int r9 = r5 + r8;
            Crypto r10 = r6.mcrypto;
            if (r10 == null) goto L13;
            int r11 = Crypto.ADAPTER.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            Integer r13 = r6.mfile_type;
            if (r13 == null) goto L17;
            int r14 = ProtoAdapter.INT32.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            Integer r16 = r6.mwidth;
            if (r16 == null) goto L21;
            int r17 = ProtoAdapter.INT32.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            Integer r19 = r6.mheight;
            if (r19 == null) goto L26;
            r3 = ProtoAdapter.INT32.encodedSizeWithTag(7, r19);
        L26:
            return (r18 + r3) + r6.unknownFields().size();
        L21:
            r17 = 0;
            goto L22
        L17:
            r14 = 0;
            goto L18
        L13:
            r11 = 0;
            goto L14
        L9:
            r8 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1284decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ImageSetPassThrough) r1);
        }

        public void encode(ProtoWriter r4, ImageSetPassThrough r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mkey);
            String r1 = r5.mfs_unit;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 2, r1);
        L5:
            String r2 = r5.murl;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r4, 3, r2);
        L8:
            Crypto r3 = r5.mcrypto;
            if (r3 == null) goto L11;
            Crypto.ADAPTER.encodeWithTag(r4, 4, r3);
        L11:
            Integer r6 = r5.mfile_type;
            if (r6 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r4, 5, r6);
        L14:
            Integer r7 = r5.mwidth;
            if (r7 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r4, 6, r7);
        L17:
            Integer r8 = r5.mheight;
            if (r8 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r4, 7, r8);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ImageSetPassThrough) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageSetPassThrough();
        DEFAULT_FILE_TYPE = 0;
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1282newBuilder() {
        Builder r0 = new Builder();
        r0.mkey = this.mkey;
        r0.mfs_unit = this.mfs_unit;
        r0.murl = this.murl;
        r0.mcrypto = this.mcrypto;
        r0.mfile_type = this.mfile_type;
        r0.mwidth = this.mwidth;
        r0.mheight = this.mheight;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ImageSetPassThrough.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1282newBuilder();
    }

    public ImageSetPassThrough(String r10, String r11, String r12, Crypto r13, Integer r14, Integer r15, Integer r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public ImageSetPassThrough(String r2, String r3, String r4, Crypto r5, Integer r6, Integer r7, Integer r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mkey = r2;
        this.mfs_unit = r3;
        this.murl = r4;
        this.mcrypto = r5;
        this.mfile_type = r6;
        this.mwidth = r7;
        this.mheight = r8;
    }
}
