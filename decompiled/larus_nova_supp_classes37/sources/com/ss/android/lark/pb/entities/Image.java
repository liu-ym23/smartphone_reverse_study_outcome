package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class Image extends com.squareup.wire.Message<Image, Builder> {
    public static final ProtoAdapter<Image> ADAPTER = null;
    public static final String DEFAULT_ETAG = "";
    public static final String DEFAULT_FS_UNIT = "";
    public static final Integer DEFAULT_HEIGHT = null;
    public static final String DEFAULT_KEY = "";
    public static final Integer DEFAULT_SECURE_HEIGHT = null;
    public static final String DEFAULT_SECURE_KEY = "";
    public static final Integer DEFAULT_SECURE_WIDTH = null;
    public static final Integer DEFAULT_SIZE = null;
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final Crypto mcrypto;
    public final String metag;
    public final String mfs_unit;
    public final Integer mheight;
    public final String mkey;
    public final Map<String, String> mparams;
    public final Integer msecure_height;
    public final String msecure_key;
    public final List<String> msecure_urls;
    public final Integer msecure_width;
    public final Integer msize;
    public final List<String> murls;
    public final Integer mwidth;

    public static final class Builder extends com.squareup.wire.Message.Builder<Image, Builder> {
        public Crypto mcrypto;
        public String metag;
        public String mfs_unit;
        public Integer mheight;
        public String mkey;
        public Map<String, String> mparams;
        public Integer msecure_height;
        public String msecure_key;
        public List<String> msecure_urls;
        public Integer msecure_width;
        public Integer msize;
        public List<String> murls;
        public Integer mwidth;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public Image m1274build() {
            return new Image(this.mkey, this.murls, this.mwidth, this.mheight, this.msecure_key, this.msecure_urls, this.msecure_width, this.msecure_height, this.mcrypto, this.msize, this.mfs_unit, this.mparams, this.metag, super.buildUnknownFields());
        }

        public Builder() {
            this.murls = Internal.newMutableList();
            this.msecure_urls = Internal.newMutableList();
            this.mparams = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1274build();
        }

        public Builder crypto(Crypto r1) {
            this.mcrypto = r1;
            return this;
        }

        public Builder etag(String r1) {
            this.metag = r1;
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

        public Builder params(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mparams = r1;
            return this;
        }

        public Builder secure_height(Integer r1) {
            this.msecure_height = r1;
            return this;
        }

        public Builder secure_key(String r1) {
            this.msecure_key = r1;
            return this;
        }

        public Builder secure_urls(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.msecure_urls = r1;
            return this;
        }

        public Builder secure_width(Integer r1) {
            this.msecure_width = r1;
            return this;
        }

        public Builder size(Integer r1) {
            this.msize = r1;
            return this;
        }

        public Builder urls(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.murls = r1;
            return this;
        }

        public Builder width(Integer r1) {
            this.mwidth = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Image extends ProtoAdapter<Image> {
        private final ProtoAdapter<Map<String, String>> mparams;

        public ProtoAdapter_Image() {
            super(FieldEncoding.LENGTH_DELIMITED, Image.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mparams = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public Image decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mkey = "";
            r0.mwidth = 0;
            r0.mheight = 0;
            r0.msecure_key = "";
            r0.msecure_width = 0;
            r0.msecure_height = 0;
            r0.msize = 0;
            r0.mfs_unit = "";
            r0.metag = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L20;
            switch(r3) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L7:
            r0.metag = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            r0.mparams.putAll((Map) this.mparams.decode(r7));
            goto L3
        L9:
            r0.mfs_unit = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.msize = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L11:
            r0.mcrypto = (Crypto) Crypto.ADAPTER.decode(r7);
            goto L3
        L12:
            r0.msecure_height = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L13:
            r0.msecure_width = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L14:
            r0.msecure_urls.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L15:
            r0.msecure_key = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L16:
            r0.mheight = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L17:
            r0.mwidth = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L18:
            r0.murls.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L19:
            r0.mkey = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L20:
            r7.endMessage(r1);
            return r0.m1274build();
        }

        public int encodedSize(Image r7) {
            String r0 = r7.mkey;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            ProtoAdapter r3 = ProtoAdapter.STRING;
            int r4 = r2 + r3.asRepeated().encodedSizeWithTag(2, r7.murls);
            Integer r5 = r7.mwidth;
            if (r5 == null) goto L9;
            int r6 = ProtoAdapter.INT32.encodedSizeWithTag(3, r5);
        L10:
            int r8 = r4 + r6;
            Integer r9 = r7.mheight;
            if (r9 == null) goto L13;
            int r10 = ProtoAdapter.INT32.encodedSizeWithTag(4, r9);
        L14:
            int r11 = r8 + r10;
            String r12 = r7.msecure_key;
            if (r12 == null) goto L17;
            int r13 = r3.encodedSizeWithTag(5, r12);
        L18:
            int r14 = (r11 + r13) + r3.asRepeated().encodedSizeWithTag(6, r7.msecure_urls);
            Integer r15 = r7.msecure_width;
            if (r15 == null) goto L21;
            int r16 = ProtoAdapter.INT32.encodedSizeWithTag(7, r15);
        L22:
            int r17 = r14 + r16;
            Integer r18 = r7.msecure_height;
            if (r18 == null) goto L25;
            int r19 = ProtoAdapter.INT32.encodedSizeWithTag(8, r18);
        L26:
            int r20 = r17 + r19;
            Crypto r21 = r7.mcrypto;
            if (r21 == null) goto L29;
            int r22 = Crypto.ADAPTER.encodedSizeWithTag(9, r21);
        L30:
            int r23 = r20 + r22;
            Integer r24 = r7.msize;
            if (r24 == null) goto L33;
            int r25 = ProtoAdapter.INT32.encodedSizeWithTag(10, r24);
        L34:
            int r26 = r23 + r25;
            String r27 = r7.mfs_unit;
            if (r27 == null) goto L37;
            int r28 = r3.encodedSizeWithTag(11, r27);
        L38:
            int r29 = (r26 + r28) + this.mparams.encodedSizeWithTag(12, r7.mparams);
            String r30 = r7.metag;
            if (r30 == null) goto L42;
            r1 = r3.encodedSizeWithTag(13, r30);
        L42:
            return (r29 + r1) + r7.unknownFields().size();
        L37:
            r28 = 0;
            goto L38
        L33:
            r25 = 0;
            goto L34
        L29:
            r22 = 0;
            goto L30
        L25:
            r19 = 0;
            goto L26
        L21:
            r16 = 0;
            goto L22
        L17:
            r13 = 0;
            goto L18
        L13:
            r10 = 0;
            goto L14
        L9:
            r6 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1275decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Image) r1);
        }

        public void encode(ProtoWriter r5, Image r6) throws IOException {
            String r0 = r6.mkey;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r5, 1, r0);
        L5:
            ProtoAdapter r1 = ProtoAdapter.STRING;
            r1.asRepeated().encodeWithTag(r5, 2, r6.murls);
            Integer r2 = r6.mwidth;
            if (r2 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r5, 3, r2);
        L8:
            Integer r3 = r6.mheight;
            if (r3 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r5, 4, r3);
        L11:
            String r4 = r6.msecure_key;
            if (r4 == null) goto L14;
            r1.encodeWithTag(r5, 5, r4);
        L14:
            r1.asRepeated().encodeWithTag(r5, 6, r6.msecure_urls);
            Integer r7 = r6.msecure_width;
            if (r7 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r5, 7, r7);
        L17:
            Integer r8 = r6.msecure_height;
            if (r8 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r5, 8, r8);
        L20:
            Crypto r9 = r6.mcrypto;
            if (r9 == null) goto L23;
            Crypto.ADAPTER.encodeWithTag(r5, 9, r9);
        L23:
            Integer r10 = r6.msize;
            if (r10 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r5, 10, r10);
        L26:
            String r11 = r6.mfs_unit;
            if (r11 == null) goto L29;
            r1.encodeWithTag(r5, 11, r11);
        L29:
            this.mparams.encodeWithTag(r5, 12, r6.mparams);
            String r12 = r6.metag;
            if (r12 == null) goto L32;
            r1.encodeWithTag(r5, 13, r12);
        L32:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Image) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Image();
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
        DEFAULT_SECURE_WIDTH = 0;
        DEFAULT_SECURE_HEIGHT = 0;
        DEFAULT_SIZE = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1273newBuilder() {
        Builder r0 = new Builder();
        r0.mkey = this.mkey;
        r0.murls = Internal.copyOf("murls", this.murls);
        r0.mwidth = this.mwidth;
        r0.mheight = this.mheight;
        r0.msecure_key = this.msecure_key;
        r0.msecure_urls = Internal.copyOf("msecure_urls", this.msecure_urls);
        r0.msecure_width = this.msecure_width;
        r0.msecure_height = this.msecure_height;
        r0.mcrypto = this.mcrypto;
        r0.msize = this.msize;
        r0.mfs_unit = this.mfs_unit;
        r0.mparams = Internal.copyOf("mparams", this.mparams);
        r0.metag = this.metag;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return Image.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1273newBuilder();
    }

    public Image(String r16, List<String> r17, Integer r18, Integer r19, String r20, List<String> r21, Integer r22, Integer r23, Crypto r24, Integer r25, String r26, Map<String, String> r27, String r28) {
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
    }

    public Image(String r2, List<String> r3, Integer r4, Integer r5, String r6, List<String> r7, Integer r8, Integer r9, Crypto r10, Integer r11, String r12, Map<String, String> r13, String r14, ByteString r15) {
        super(ADAPTER, r15);
        this.mkey = r2;
        this.murls = Internal.immutableCopyOf("murls", r3);
        this.mwidth = r4;
        this.mheight = r5;
        this.msecure_key = r6;
        this.msecure_urls = Internal.immutableCopyOf("msecure_urls", r7);
        this.msecure_width = r8;
        this.msecure_height = r9;
        this.mcrypto = r10;
        this.msize = r11;
        this.mfs_unit = r12;
        this.mparams = Internal.immutableCopyOf("mparams", r13);
        this.metag = r14;
    }
}
