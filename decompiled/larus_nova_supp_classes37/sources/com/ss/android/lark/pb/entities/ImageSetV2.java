package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ImageSetV2 extends com.squareup.wire.Message<ImageSetV2, Builder> {
    public static final ProtoAdapter<ImageSetV2> ADAPTER = null;
    public static final String DEFAULT_FS_UNIT = "";
    public static final String DEFAULT_IMAGE_KEY = "";
    public static final ByteString DEFAULT_INLINE_PREVIEW = null;
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final Long DEFAULT_SCENE_ID = null;
    private static final long serialVersionUID = 0;
    public final Crypto mcrypto;
    public final String mfs_unit;
    public final String mimage_key;
    public final List<ImageAttribute> mimages;
    public final ByteString minline_preview;
    public final Boolean mis_destroyed;
    public final Long mscene_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<ImageSetV2, Builder> {
        public Crypto mcrypto;
        public String mfs_unit;
        public String mimage_key;
        public List<ImageAttribute> mimages;
        public ByteString minline_preview;
        public Boolean mis_destroyed;
        public Long mscene_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ImageSetV2 m1286build() {
            return new ImageSetV2(this.mimage_key, this.mfs_unit, this.mcrypto, this.mimages, this.minline_preview, this.mis_destroyed, this.mscene_id, super.buildUnknownFields());
        }

        public Builder() {
            this.mimages = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1286build();
        }

        public Builder crypto(Crypto r1) {
            this.mcrypto = r1;
            return this;
        }

        public Builder fs_unit(String r1) {
            this.mfs_unit = r1;
            return this;
        }

        public Builder image_key(String r1) {
            this.mimage_key = r1;
            return this;
        }

        public Builder images(List<ImageAttribute> r1) {
            Internal.checkElementsNotNull(r1);
            this.mimages = r1;
            return this;
        }

        public Builder inline_preview(ByteString r1) {
            this.minline_preview = r1;
            return this;
        }

        public Builder is_destroyed(Boolean r1) {
            this.mis_destroyed = r1;
            return this;
        }

        public Builder scene_id(Long r1) {
            this.mscene_id = r1;
            return this;
        }
    }

    public static final class ImageAttribute extends com.squareup.wire.Message<ImageAttribute, Builder> {
        public static final ProtoAdapter<ImageAttribute> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ImageBaseAttribute mattribute;
        public final ImageCropType mtype;

        public static final class Builder extends com.squareup.wire.Message.Builder<ImageAttribute, Builder> {
            public ImageBaseAttribute mattribute;
            public ImageCropType mtype;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ImageAttribute m1288build() {
                ImageCropType r0 = this.mtype;
                if (r0 == null) goto L9;
                if (this.mattribute == null) goto L9;
                return new ImageAttribute(this.mtype, this.mattribute, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "mtype", this.mattribute, "mattribute"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1288build();
            }

            public Builder attribute(ImageBaseAttribute r1) {
                this.mattribute = r1;
                return this;
            }

            public Builder type(ImageCropType r1) {
                this.mtype = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ImageAttribute extends ProtoAdapter<ImageAttribute> {
            public ProtoAdapter_ImageAttribute() {
                super(FieldEncoding.LENGTH_DELIMITED, ImageAttribute.class);
            }

            public ImageAttribute decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mtype = (ImageCropType) ImageCropType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mattribute = (ImageBaseAttribute) ImageBaseAttribute.ADAPTER.decode(r9);
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L15:
                r9.endMessage(r1);
                return r0.m1288build();
            }

            public int encodedSize(ImageAttribute r5) {
                return (ImageCropType.ADAPTER.encodedSizeWithTag(1, r5.mtype) + ImageBaseAttribute.ADAPTER.encodedSizeWithTag(2, r5.mattribute)) + r5.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1289decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ImageAttribute) r1);
            }

            public void encode(ProtoWriter r4, ImageAttribute r5) throws IOException {
                ImageCropType.ADAPTER.encodeWithTag(r4, 1, r5.mtype);
                ImageBaseAttribute.ADAPTER.encodeWithTag(r4, 2, r5.mattribute);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ImageAttribute) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ImageAttribute();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1287newBuilder() {
            Builder r0 = new Builder();
            r0.mtype = this.mtype;
            r0.mattribute = this.mattribute;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ImageAttribute.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1287newBuilder();
        }

        public ImageAttribute(ImageCropType r2, ImageBaseAttribute r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public ImageAttribute(ImageCropType r2, ImageBaseAttribute r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mtype = r2;
            this.mattribute = r3;
        }
    }

    public static final class ProtoAdapter_ImageSetV2 extends ProtoAdapter<ImageSetV2> {
        public ProtoAdapter_ImageSetV2() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageSetV2.class);
        }

        public ImageSetV2 decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mimage_key = "";
            r0.mfs_unit = "";
            r0.minline_preview = ByteString.EMPTY;
            r0.mis_destroyed = Boolean.FALSE;
            r0.mscene_id = 0L;
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
            r0.mscene_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            r0.mis_destroyed = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L9:
            r0.minline_preview = (ByteString) ProtoAdapter.BYTES.decode(r7);
            goto L3
        L10:
            r0.mimages.add((ImageAttribute) ImageAttribute.ADAPTER.decode(r7));
            goto L3
        L11:
            r0.mcrypto = (Crypto) Crypto.ADAPTER.decode(r7);
            goto L3
        L12:
            r0.mfs_unit = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L13:
            r0.mimage_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L14:
            r7.endMessage(r1);
            return r0.m1286build();
        }

        public int encodedSize(ImageSetV2 r6) {
            String r0 = r6.mimage_key;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mfs_unit;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Crypto r7 = r6.mcrypto;
            if (r7 == null) goto L13;
            int r8 = Crypto.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = (r5 + r8) + ImageAttribute.ADAPTER.asRepeated().encodedSizeWithTag(4, r6.mimages);
            ByteString r10 = r6.minline_preview;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.BYTES.encodedSizeWithTag(5, r10);
        L18:
            int r12 = r9 + r11;
            Boolean r13 = r6.mis_destroyed;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r13);
        L22:
            int r15 = r12 + r14;
            Long r16 = r6.mscene_id;
            if (r16 == null) goto L26;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(7, r16);
        L26:
            return (r15 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m1290decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ImageSetV2) r1);
        }

        public void encode(ProtoWriter r4, ImageSetV2 r5) throws IOException {
            String r0 = r5.mimage_key;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mfs_unit;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            Crypto r2 = r5.mcrypto;
            if (r2 == null) goto L11;
            Crypto.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            ImageAttribute.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mimages);
            ByteString r3 = r5.minline_preview;
            if (r3 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r4, 5, r3);
        L14:
            Boolean r6 = r5.mis_destroyed;
            if (r6 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r6);
        L17:
            Long r7 = r5.mscene_id;
            if (r7 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r4, 7, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ImageSetV2) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageSetV2();
        DEFAULT_INLINE_PREVIEW = ByteString.EMPTY;
        DEFAULT_IS_DESTROYED = Boolean.FALSE;
        DEFAULT_SCENE_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1285newBuilder() {
        Builder r0 = new Builder();
        r0.mimage_key = this.mimage_key;
        r0.mfs_unit = this.mfs_unit;
        r0.mcrypto = this.mcrypto;
        r0.mimages = Internal.copyOf("mimages", this.mimages);
        r0.minline_preview = this.minline_preview;
        r0.mis_destroyed = this.mis_destroyed;
        r0.mscene_id = this.mscene_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ImageSetV2.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1285newBuilder();
    }

    public ImageSetV2(String r10, String r11, Crypto r12, List<ImageAttribute> r13, ByteString r14, Boolean r15, Long r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public ImageSetV2(String r2, String r3, Crypto r4, List<ImageAttribute> r5, ByteString r6, Boolean r7, Long r8, ByteString r9) {
        super(ADAPTER, r9);
        this.mimage_key = r2;
        this.mfs_unit = r3;
        this.mcrypto = r4;
        this.mimages = Internal.immutableCopyOf("mimages", r5);
        this.minline_preview = r6;
        this.mis_destroyed = r7;
        this.mscene_id = r8;
    }
}
