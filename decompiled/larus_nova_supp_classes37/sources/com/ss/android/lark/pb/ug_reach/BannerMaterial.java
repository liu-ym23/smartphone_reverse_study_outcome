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
public final class BannerMaterial extends Message<BannerMaterial, Builder> {
    public static final ProtoAdapter<BannerMaterial> ADAPTER = null;
    public static final String DEFAULT_BANNER_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mbanner_name;
    public final BannerType mbanner_type;
    public final MaterialBase mbase;
    public final CarouselBanner mcarousel_banner;
    public final CustomBannerMaterial mcustom_banner;
    public final NormalBannerMaterial mnormal_banner;
    public final NormalBannerMaterial msidebar_banner;
    public final TemplateBannerMaterial mtemplate_banner;

    public static final enum BannerType extends Enum<BannerType> implements WireEnum {
        private static final /* synthetic */ BannerType[] $VALUES = null;
        public static final ProtoAdapter<BannerType> ADAPTER = null;
        public static final BannerType CAROUSEL = null;
        public static final BannerType CUSTOM = null;
        public static final BannerType NORMAL = null;
        public static final BannerType SIDEBAR = null;
        public static final BannerType TEMPLATE = null;
        public static final BannerType UNKNOWN = null;
        private final int value;

        static {
            BannerType r0 = new BannerType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            BannerType r1 = new BannerType("NORMAL", 1, 1);
            NORMAL = r1;
            BannerType r3 = new BannerType("TEMPLATE", 2, 2);
            TEMPLATE = r3;
            BannerType r5 = new BannerType("CAROUSEL", 3, 3);
            CAROUSEL = r5;
            BannerType r7 = new BannerType("SIDEBAR", 4, 4);
            SIDEBAR = r7;
            BannerType r9 = new BannerType("CUSTOM", 5, 5);
            CUSTOM = r9;
            $VALUES = new BannerType[]{r0, r1, r3, r5, r7, r9};
            ADAPTER = ProtoAdapter.newEnumAdapter(BannerType.class);
        }

        public static BannerType[] values() {
            return (BannerType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static BannerType fromValue(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return CUSTOM;
        L18:
            return SIDEBAR;
        L20:
            return CAROUSEL;
        L22:
            return TEMPLATE;
        L24:
            return NORMAL;
        L26:
            return UNKNOWN;
        }

        public static BannerType valueOf(String r1) {
            return (BannerType) a.a(BannerType.class, r1);
        }

        private BannerType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends Message.Builder<BannerMaterial, Builder> {
        public String mbanner_name;
        public BannerType mbanner_type;
        public MaterialBase mbase;
        public CarouselBanner mcarousel_banner;
        public CustomBannerMaterial mcustom_banner;
        public NormalBannerMaterial mnormal_banner;
        public NormalBannerMaterial msidebar_banner;
        public TemplateBannerMaterial mtemplate_banner;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BannerMaterial m2417build() {
            return new BannerMaterial(this.mbanner_name, this.mbanner_type, this.mbase, this.mnormal_banner, this.mtemplate_banner, this.mcarousel_banner, this.msidebar_banner, this.mcustom_banner, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2417build();
        }

        public Builder banner_name(String r1) {
            this.mbanner_name = r1;
            return this;
        }

        public Builder banner_type(BannerType r1) {
            this.mbanner_type = r1;
            return this;
        }

        public Builder base(MaterialBase r1) {
            this.mbase = r1;
            return this;
        }

        public Builder carousel_banner(CarouselBanner r1) {
            this.mcarousel_banner = r1;
            this.mnormal_banner = null;
            this.mtemplate_banner = null;
            this.msidebar_banner = null;
            this.mcustom_banner = null;
            return this;
        }

        public Builder custom_banner(CustomBannerMaterial r1) {
            this.mcustom_banner = r1;
            this.mnormal_banner = null;
            this.mtemplate_banner = null;
            this.mcarousel_banner = null;
            this.msidebar_banner = null;
            return this;
        }

        public Builder normal_banner(NormalBannerMaterial r1) {
            this.mnormal_banner = r1;
            this.mtemplate_banner = null;
            this.mcarousel_banner = null;
            this.msidebar_banner = null;
            this.mcustom_banner = null;
            return this;
        }

        public Builder sidebar_banner(NormalBannerMaterial r1) {
            this.msidebar_banner = r1;
            this.mnormal_banner = null;
            this.mtemplate_banner = null;
            this.mcarousel_banner = null;
            this.mcustom_banner = null;
            return this;
        }

        public Builder template_banner(TemplateBannerMaterial r1) {
            this.mtemplate_banner = r1;
            this.mnormal_banner = null;
            this.mcarousel_banner = null;
            this.msidebar_banner = null;
            this.mcustom_banner = null;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerMaterial extends ProtoAdapter<BannerMaterial> {
        public ProtoAdapter_BannerMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerMaterial.class);
        }

        public BannerMaterial decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mbanner_name = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            switch(r3) {
                case 1: goto L17;
                case 2: goto L20;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r0.mbanner_type = (BannerType) BannerType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.custom_banner((CustomBannerMaterial) CustomBannerMaterial.ADAPTER.decode(r9));
            goto L3
        L8:
            r0.mbase = (MaterialBase) MaterialBase.ADAPTER.decode(r9);
            goto L3
        L9:
            r0.sidebar_banner((NormalBannerMaterial) NormalBannerMaterial.ADAPTER.decode(r9));
            goto L3
        L10:
            r0.carousel_banner((CarouselBanner) CarouselBanner.ADAPTER.decode(r9));
            goto L3
        L11:
            r0.template_banner((TemplateBannerMaterial) TemplateBannerMaterial.ADAPTER.decode(r9));
            goto L3
        L12:
            r0.normal_banner((NormalBannerMaterial) NormalBannerMaterial.ADAPTER.decode(r9));
            goto L3
        L17:
            r0.mbanner_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2417build();
        }

        public int encodedSize(BannerMaterial r6) {
            String r0 = r6.mbanner_name;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            BannerType r3 = r6.mbanner_type;
            if (r3 == null) goto L9;
            int r4 = BannerType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            MaterialBase r7 = r6.mbase;
            if (r7 == null) goto L13;
            int r8 = MaterialBase.ADAPTER.encodedSizeWithTag(7, r7);
        L14:
            int r9 = r5 + r8;
            NormalBannerMaterial r10 = r6.mnormal_banner;
            if (r10 == null) goto L17;
            int r11 = NormalBannerMaterial.ADAPTER.encodedSizeWithTag(3, r10);
        L18:
            int r12 = r9 + r11;
            TemplateBannerMaterial r13 = r6.mtemplate_banner;
            if (r13 == null) goto L21;
            int r14 = TemplateBannerMaterial.ADAPTER.encodedSizeWithTag(4, r13);
        L22:
            int r15 = r12 + r14;
            CarouselBanner r16 = r6.mcarousel_banner;
            if (r16 == null) goto L25;
            int r17 = CarouselBanner.ADAPTER.encodedSizeWithTag(5, r16);
        L26:
            int r18 = r15 + r17;
            NormalBannerMaterial r19 = r6.msidebar_banner;
            if (r19 == null) goto L29;
            int r20 = NormalBannerMaterial.ADAPTER.encodedSizeWithTag(6, r19);
        L30:
            int r21 = r18 + r20;
            CustomBannerMaterial r22 = r6.mcustom_banner;
            if (r22 == null) goto L34;
            r1 = CustomBannerMaterial.ADAPTER.encodedSizeWithTag(8, r22);
        L34:
            return (r21 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2418decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BannerMaterial) r1);
        }

        public void encode(ProtoWriter r4, BannerMaterial r5) throws IOException {
            String r0 = r5.mbanner_name;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            BannerType r1 = r5.mbanner_type;
            if (r1 == null) goto L8;
            BannerType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            MaterialBase r2 = r5.mbase;
            if (r2 == null) goto L11;
            MaterialBase.ADAPTER.encodeWithTag(r4, 7, r2);
        L11:
            NormalBannerMaterial r3 = r5.mnormal_banner;
            if (r3 == null) goto L14;
            NormalBannerMaterial.ADAPTER.encodeWithTag(r4, 3, r3);
        L14:
            TemplateBannerMaterial r6 = r5.mtemplate_banner;
            if (r6 == null) goto L17;
            TemplateBannerMaterial.ADAPTER.encodeWithTag(r4, 4, r6);
        L17:
            CarouselBanner r7 = r5.mcarousel_banner;
            if (r7 == null) goto L20;
            CarouselBanner.ADAPTER.encodeWithTag(r4, 5, r7);
        L20:
            NormalBannerMaterial r8 = r5.msidebar_banner;
            if (r8 == null) goto L23;
            NormalBannerMaterial.ADAPTER.encodeWithTag(r4, 6, r8);
        L23:
            CustomBannerMaterial r9 = r5.mcustom_banner;
            if (r9 == null) goto L26;
            CustomBannerMaterial.ADAPTER.encodeWithTag(r4, 8, r9);
        L26:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BannerMaterial) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerMaterial();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2416newBuilder() {
        Builder r0 = new Builder();
        r0.mbanner_name = this.mbanner_name;
        r0.mbanner_type = this.mbanner_type;
        r0.mbase = this.mbase;
        r0.mnormal_banner = this.mnormal_banner;
        r0.mtemplate_banner = this.mtemplate_banner;
        r0.mcarousel_banner = this.mcarousel_banner;
        r0.msidebar_banner = this.msidebar_banner;
        r0.mcustom_banner = this.mcustom_banner;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BannerMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2416newBuilder();
    }

    public BannerMaterial(String r11, BannerType r12, MaterialBase r13, NormalBannerMaterial r14, TemplateBannerMaterial r15, CarouselBanner r16, NormalBannerMaterial r17, CustomBannerMaterial r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
    }

    public BannerMaterial(String r3, BannerType r4, MaterialBase r5, NormalBannerMaterial r6, TemplateBannerMaterial r7, CarouselBanner r8, NormalBannerMaterial r9, CustomBannerMaterial r10, ByteString r11) {
        super(ADAPTER, r11);
        if (Internal.countNonNull(r6, r7, r8, r9, new Object[]{r10}) > 1) goto L7;
        this.mbanner_name = r3;
        this.mbanner_type = r4;
        this.mbase = r5;
        this.mnormal_banner = r6;
        this.mtemplate_banner = r7;
        this.mcarousel_banner = r8;
        this.msidebar_banner = r9;
        this.mcustom_banner = r10;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mnormal_banner, mtemplate_banner, mcarousel_banner, msidebar_banner, mcustom_banner may be non-null");
    }
}
