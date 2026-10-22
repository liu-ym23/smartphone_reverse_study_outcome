package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class HongbaoCover extends com.squareup.wire.Message<HongbaoCover, Builder> {
    public static final ProtoAdapter<HongbaoCover> ADAPTER = null;
    public static final String DEFAULT_COMPANY_NAME = "";
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final ImageSetPassThrough mcompany_logo;
    public final String mcompany_name;
    public final CoverType mcover_type;
    public final DisplayName mdisplay_name;
    public final ImageSetPassThrough mhead_cover;
    public final Long mid;
    public final ImageSetPassThrough mmain_cover;
    public final ImageSetPassThrough mmessage_cover;
    public final String mname;
    public final ImageSetPassThrough mselect_cover;

    public static final class Builder extends com.squareup.wire.Message.Builder<HongbaoCover, Builder> {
        public ImageSetPassThrough mcompany_logo;
        public String mcompany_name;
        public CoverType mcover_type;
        public DisplayName mdisplay_name;
        public ImageSetPassThrough mhead_cover;
        public Long mid;
        public ImageSetPassThrough mmain_cover;
        public ImageSetPassThrough mmessage_cover;
        public String mname;
        public ImageSetPassThrough mselect_cover;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public HongbaoCover m1256build() {
            return new HongbaoCover(this.mid, this.mname, this.mcover_type, this.mmain_cover, this.mmessage_cover, this.mhead_cover, this.mcompany_logo, this.mselect_cover, this.mdisplay_name, this.mcompany_name, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1256build();
        }

        public Builder company_logo(ImageSetPassThrough r1) {
            this.mcompany_logo = r1;
            return this;
        }

        public Builder company_name(String r1) {
            this.mcompany_name = r1;
            return this;
        }

        public Builder cover_type(CoverType r1) {
            this.mcover_type = r1;
            return this;
        }

        public Builder display_name(DisplayName r1) {
            this.mdisplay_name = r1;
            return this;
        }

        public Builder head_cover(ImageSetPassThrough r1) {
            this.mhead_cover = r1;
            return this;
        }

        public Builder id(Long r1) {
            this.mid = r1;
            return this;
        }

        public Builder main_cover(ImageSetPassThrough r1) {
            this.mmain_cover = r1;
            return this;
        }

        public Builder message_cover(ImageSetPassThrough r1) {
            this.mmessage_cover = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder select_cover(ImageSetPassThrough r1) {
            this.mselect_cover = r1;
            return this;
        }
    }

    public static final enum CoverType extends Enum<CoverType> implements WireEnum {
        private static final /* synthetic */ CoverType[] $VALUES = null;
        public static final ProtoAdapter<CoverType> ADAPTER = null;
        public static final CoverType CUSTOMIZE = null;
        public static final CoverType TEMPLATE = null;
        public static final CoverType UNKNOWN = null;
        private final int value;

        static {
            CoverType r0 = new CoverType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            CoverType r1 = new CoverType("TEMPLATE", 1, 1);
            TEMPLATE = r1;
            CoverType r3 = new CoverType("CUSTOMIZE", 2, 2);
            CUSTOMIZE = r3;
            $VALUES = new CoverType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(CoverType.class);
        }

        public static CoverType[] values() {
            return (CoverType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CoverType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return CUSTOMIZE;
        L12:
            return TEMPLATE;
        L14:
            return UNKNOWN;
        }

        public static CoverType valueOf(String r1) {
            return (CoverType) a.a(CoverType.class, r1);
        }

        private CoverType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class DisplayName extends com.squareup.wire.Message<DisplayName, Builder> {
        public static final ProtoAdapter<DisplayName> ADAPTER = null;
        public static final Integer DEFAULT_BG_BORDER_WIDTH = null;
        public static final String DEFAULT_DISPLAY_NAME = "";
        private static final long serialVersionUID = 0;
        public final ImageSetPassThrough mbackground_img;
        public final Integer mbg_border_width;
        public final ImageSetPassThrough mbg_img_dot_9;
        public final String mdisplay_name;

        public static final class Builder extends com.squareup.wire.Message.Builder<DisplayName, Builder> {
            public ImageSetPassThrough mbackground_img;
            public Integer mbg_border_width;
            public ImageSetPassThrough mbg_img_dot_9;
            public String mdisplay_name;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DisplayName m1258build() {
                return new DisplayName(this.mbackground_img, this.mdisplay_name, this.mbg_border_width, this.mbg_img_dot_9, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1258build();
            }

            public Builder background_img(ImageSetPassThrough r1) {
                this.mbackground_img = r1;
                return this;
            }

            public Builder bg_border_width(Integer r1) {
                this.mbg_border_width = r1;
                return this;
            }

            public Builder bg_img_dot_9(ImageSetPassThrough r1) {
                this.mbg_img_dot_9 = r1;
                return this;
            }

            public Builder display_name(String r1) {
                this.mdisplay_name = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DisplayName extends ProtoAdapter<DisplayName> {
            public ProtoAdapter_DisplayName() {
                super(FieldEncoding.LENGTH_DELIMITED, DisplayName.class);
            }

            public DisplayName decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mdisplay_name = "";
                r0.mbg_border_width = 0;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mbackground_img = (ImageSetPassThrough) ImageSetPassThrough.ADAPTER.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mdisplay_name = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mbg_border_width = (Integer) ProtoAdapter.INT32.decode(r7);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mbg_img_dot_9 = (ImageSetPassThrough) ImageSetPassThrough.ADAPTER.decode(r7);
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r1);
                return r0.m1258build();
            }

            public int encodedSize(DisplayName r6) {
                ImageSetPassThrough r0 = r6.mbackground_img;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mdisplay_name;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Integer r7 = r6.mbg_border_width;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.INT32.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                ImageSetPassThrough r10 = r6.mbg_img_dot_9;
                if (r10 == null) goto L18;
                r1 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(4, r10);
            L18:
                return (r9 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1259decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DisplayName) r1);
            }

            public void encode(ProtoWriter r4, DisplayName r5) throws IOException {
                ImageSetPassThrough r0 = r5.mbackground_img;
                if (r0 == null) goto L5;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mdisplay_name;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                Integer r2 = r5.mbg_border_width;
                if (r2 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r4, 3, r2);
            L11:
                ImageSetPassThrough r3 = r5.mbg_img_dot_9;
                if (r3 == null) goto L14;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r4, 4, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DisplayName) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DisplayName();
            DEFAULT_BG_BORDER_WIDTH = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1257newBuilder() {
            Builder r0 = new Builder();
            r0.mbackground_img = this.mbackground_img;
            r0.mdisplay_name = this.mdisplay_name;
            r0.mbg_border_width = this.mbg_border_width;
            r0.mbg_img_dot_9 = this.mbg_img_dot_9;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DisplayName.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1257newBuilder();
        }

        public DisplayName(ImageSetPassThrough r7, String r8, Integer r9, ImageSetPassThrough r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public DisplayName(ImageSetPassThrough r2, String r3, Integer r4, ImageSetPassThrough r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mbackground_img = r2;
            this.mdisplay_name = r3;
            this.mbg_border_width = r4;
            this.mbg_img_dot_9 = r5;
        }
    }

    public static final class ProtoAdapter_HongbaoCover extends ProtoAdapter<HongbaoCover> {
        public ProtoAdapter_HongbaoCover() {
            super(FieldEncoding.LENGTH_DELIMITED, HongbaoCover.class);
        }

        public HongbaoCover decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = 0L;
            r0.mname = "";
            r0.mcompany_name = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L20;
            switch(r3) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L22;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L22:
            r0.mcover_type = (CoverType) CoverType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mcompany_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            r0.mdisplay_name = (DisplayName) DisplayName.ADAPTER.decode(r9);
            goto L3
        L9:
            r0.mselect_cover = (ImageSetPassThrough) ImageSetPassThrough.ADAPTER.decode(r9);
            goto L3
        L10:
            r0.mcompany_logo = (ImageSetPassThrough) ImageSetPassThrough.ADAPTER.decode(r9);
            goto L3
        L11:
            r0.mhead_cover = (ImageSetPassThrough) ImageSetPassThrough.ADAPTER.decode(r9);
            goto L3
        L12:
            r0.mmessage_cover = (ImageSetPassThrough) ImageSetPassThrough.ADAPTER.decode(r9);
            goto L3
        L13:
            r0.mmain_cover = (ImageSetPassThrough) ImageSetPassThrough.ADAPTER.decode(r9);
            goto L3
        L18:
            r0.mname = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L19:
            r0.mid = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L20:
            r9.endMessage(r1);
            return r0.m1256build();
        }

        public int encodedSize(HongbaoCover r6) {
            Long r0 = r6.mid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mname;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            CoverType r7 = r6.mcover_type;
            if (r7 == null) goto L13;
            int r8 = CoverType.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            ImageSetPassThrough r10 = r6.mmain_cover;
            if (r10 == null) goto L17;
            int r11 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            ImageSetPassThrough r13 = r6.mmessage_cover;
            if (r13 == null) goto L21;
            int r14 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            ImageSetPassThrough r16 = r6.mhead_cover;
            if (r16 == null) goto L25;
            int r17 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            ImageSetPassThrough r19 = r6.mcompany_logo;
            if (r19 == null) goto L29;
            int r20 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            ImageSetPassThrough r22 = r6.mselect_cover;
            if (r22 == null) goto L33;
            int r23 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            DisplayName r25 = r6.mdisplay_name;
            if (r25 == null) goto L37;
            int r26 = DisplayName.ADAPTER.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            String r28 = r6.mcompany_name;
            if (r28 == null) goto L42;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(10, r28);
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
        public /* bridge */ /* synthetic */ Object m1260decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((HongbaoCover) r1);
        }

        public void encode(ProtoWriter r4, HongbaoCover r5) throws IOException {
            Long r0 = r5.mid;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mname;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            CoverType r2 = r5.mcover_type;
            if (r2 == null) goto L11;
            CoverType.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            ImageSetPassThrough r3 = r5.mmain_cover;
            if (r3 == null) goto L14;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            ImageSetPassThrough r6 = r5.mmessage_cover;
            if (r6 == null) goto L17;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            ImageSetPassThrough r7 = r5.mhead_cover;
            if (r7 == null) goto L20;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            ImageSetPassThrough r8 = r5.mcompany_logo;
            if (r8 == null) goto L23;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r4, 7, r8);
        L23:
            ImageSetPassThrough r9 = r5.mselect_cover;
            if (r9 == null) goto L26;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r4, 8, r9);
        L26:
            DisplayName r10 = r5.mdisplay_name;
            if (r10 == null) goto L29;
            DisplayName.ADAPTER.encodeWithTag(r4, 9, r10);
        L29:
            String r11 = r5.mcompany_name;
            if (r11 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r4, 10, r11);
        L32:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (HongbaoCover) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HongbaoCover();
        DEFAULT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1255newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mname = this.mname;
        r0.mcover_type = this.mcover_type;
        r0.mmain_cover = this.mmain_cover;
        r0.mmessage_cover = this.mmessage_cover;
        r0.mhead_cover = this.mhead_cover;
        r0.mcompany_logo = this.mcompany_logo;
        r0.mselect_cover = this.mselect_cover;
        r0.mdisplay_name = this.mdisplay_name;
        r0.mcompany_name = this.mcompany_name;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return HongbaoCover.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1255newBuilder();
    }

    public HongbaoCover(Long r13, String r14, CoverType r15, ImageSetPassThrough r16, ImageSetPassThrough r17, ImageSetPassThrough r18, ImageSetPassThrough r19, ImageSetPassThrough r20, DisplayName r21, String r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public HongbaoCover(Long r2, String r3, CoverType r4, ImageSetPassThrough r5, ImageSetPassThrough r6, ImageSetPassThrough r7, ImageSetPassThrough r8, ImageSetPassThrough r9, DisplayName r10, String r11, ByteString r12) {
        super(ADAPTER, r12);
        this.mid = r2;
        this.mname = r3;
        this.mcover_type = r4;
        this.mmain_cover = r5;
        this.mmessage_cover = r6;
        this.mhead_cover = r7;
        this.mcompany_logo = r8;
        this.mselect_cover = r9;
        this.mdisplay_name = r10;
        this.mcompany_name = r11;
    }
}
