package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TemplateBannerMaterial extends Message<TemplateBannerMaterial, Builder> {
    public static final ProtoAdapter<TemplateBannerMaterial> ADAPTER = null;
    public static final String DEFAULT_BACKGROUND_COLOR = "";
    public static final Boolean DEFAULT_BANNER_CLOSEABLE = null;
    public static final String DEFAULT_BANNER_CLOSEABLE_COLOR = "";
    public static final String DEFAULT_FRAME_COLOR = "";
    public static final String DEFAULT_SUB_TITLE_COLOR = "";
    public static final String DEFAULT_TITLE_COLOR = "";
    private static final long serialVersionUID = 0;
    public final String mbackground_color;
    public final ImageElement mbackground_pic;
    public final Boolean mbanner_closeable;
    public final String mbanner_closeable_color;
    public final ImageElement mbanner_icon;
    public final String mframe_color;
    public final Layout mlayout;
    public final TextElement msub_title;
    public final String msub_title_color;
    public final List<BannerTemplateCategory> mtemplate_categories;
    public final BannerTemplateMore mtemplate_more;
    public final TextElement mtitle;
    public final String mtitle_color;

    public static final class Builder extends Message.Builder<TemplateBannerMaterial, Builder> {
        public String mbackground_color;
        public ImageElement mbackground_pic;
        public Boolean mbanner_closeable;
        public String mbanner_closeable_color;
        public ImageElement mbanner_icon;
        public String mframe_color;
        public Layout mlayout;
        public TextElement msub_title;
        public String msub_title_color;
        public List<BannerTemplateCategory> mtemplate_categories;
        public BannerTemplateMore mtemplate_more;
        public TextElement mtitle;
        public String mtitle_color;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TemplateBannerMaterial m2480build() {
            return new TemplateBannerMaterial(this.mbackground_color, this.mbanner_icon, this.mbackground_pic, this.mtitle, this.mtitle_color, this.mbanner_closeable, this.mbanner_closeable_color, this.mlayout, this.mtemplate_categories, this.mtemplate_more, this.mframe_color, this.msub_title, this.msub_title_color, super.buildUnknownFields());
        }

        public Builder() {
            this.mtemplate_categories = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2480build();
        }

        public Builder background_color(String r1) {
            this.mbackground_color = r1;
            return this;
        }

        public Builder background_pic(ImageElement r1) {
            this.mbackground_pic = r1;
            return this;
        }

        public Builder banner_closeable(Boolean r1) {
            this.mbanner_closeable = r1;
            return this;
        }

        public Builder banner_closeable_color(String r1) {
            this.mbanner_closeable_color = r1;
            return this;
        }

        public Builder banner_icon(ImageElement r1) {
            this.mbanner_icon = r1;
            return this;
        }

        public Builder frame_color(String r1) {
            this.mframe_color = r1;
            return this;
        }

        public Builder layout(Layout r1) {
            this.mlayout = r1;
            return this;
        }

        public Builder sub_title(TextElement r1) {
            this.msub_title = r1;
            return this;
        }

        public Builder sub_title_color(String r1) {
            this.msub_title_color = r1;
            return this;
        }

        public Builder template_categories(List<BannerTemplateCategory> r1) {
            Internal.checkElementsNotNull(r1);
            this.mtemplate_categories = r1;
            return this;
        }

        public Builder template_more(BannerTemplateMore r1) {
            this.mtemplate_more = r1;
            return this;
        }

        public Builder title(TextElement r1) {
            this.mtitle = r1;
            return this;
        }

        public Builder title_color(String r1) {
            this.mtitle_color = r1;
            return this;
        }
    }

    public static final enum Layout extends Enum<Layout> implements WireEnum {
        private static final /* synthetic */ Layout[] $VALUES = null;
        public static final ProtoAdapter<Layout> ADAPTER = null;
        public static final Layout STYLE1 = null;
        public static final Layout STYLE2 = null;
        public static final Layout STYLE3 = null;
        public static final Layout STYLE4 = null;
        public static final Layout UNKNOWN = null;
        private final int value;

        static {
            Layout r0 = new Layout("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Layout r1 = new Layout("STYLE1", 1, 1);
            STYLE1 = r1;
            Layout r3 = new Layout("STYLE2", 2, 2);
            STYLE2 = r3;
            Layout r5 = new Layout("STYLE3", 3, 3);
            STYLE3 = r5;
            Layout r7 = new Layout("STYLE4", 4, 4);
            STYLE4 = r7;
            $VALUES = new Layout[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(Layout.class);
        }

        public static Layout[] values() {
            return (Layout[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Layout fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return STYLE4;
        L16:
            return STYLE3;
        L18:
            return STYLE2;
        L20:
            return STYLE1;
        L22:
            return UNKNOWN;
        }

        public static Layout valueOf(String r1) {
            return (Layout) a.a(Layout.class, r1);
        }

        private Layout(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_TemplateBannerMaterial extends ProtoAdapter<TemplateBannerMaterial> {
        public ProtoAdapter_TemplateBannerMaterial() {
            super(FieldEncoding.LENGTH_DELIMITED, TemplateBannerMaterial.class);
        }

        public TemplateBannerMaterial decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mbackground_color = "";
            r0.mtitle_color = "";
            r0.mbanner_closeable = Boolean.FALSE;
            r0.mbanner_closeable_color = "";
            r0.mframe_color = "";
            r0.msub_title_color = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L23;
            switch(r3) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L25;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L25:
            r0.mlayout = (Layout) Layout.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.msub_title_color = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            r0.msub_title = (TextElement) TextElement.ADAPTER.decode(r9);
            goto L3
        L9:
            r0.mframe_color = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            r0.mtemplate_more = (BannerTemplateMore) BannerTemplateMore.ADAPTER.decode(r9);
            goto L3
        L11:
            r0.mtemplate_categories.add((BannerTemplateCategory) BannerTemplateCategory.ADAPTER.decode(r9));
            goto L3
        L16:
            r0.mbanner_closeable_color = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L17:
            r0.mbanner_closeable = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L18:
            r0.mtitle_color = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L19:
            r0.mtitle = (TextElement) TextElement.ADAPTER.decode(r9);
            goto L3
        L20:
            r0.mbackground_pic = (ImageElement) ImageElement.ADAPTER.decode(r9);
            goto L3
        L21:
            r0.mbanner_icon = (ImageElement) ImageElement.ADAPTER.decode(r9);
            goto L3
        L22:
            r0.mbackground_color = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L23:
            r9.endMessage(r1);
            return r0.m2480build();
        }

        public int encodedSize(TemplateBannerMaterial r6) {
            String r0 = r6.mbackground_color;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            ImageElement r3 = r6.mbanner_icon;
            if (r3 == null) goto L9;
            int r4 = ImageElement.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            ImageElement r7 = r6.mbackground_pic;
            if (r7 == null) goto L13;
            int r8 = ImageElement.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            TextElement r10 = r6.mtitle;
            if (r10 == null) goto L17;
            int r11 = TextElement.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mtitle_color;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Boolean r16 = r6.mbanner_closeable;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.mbanner_closeable_color;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            Layout r22 = r6.mlayout;
            if (r22 == null) goto L33;
            int r23 = Layout.ADAPTER.encodedSizeWithTag(8, r22);
        L34:
            int r24 = (r21 + r23) + BannerTemplateCategory.ADAPTER.asRepeated().encodedSizeWithTag(9, r6.mtemplate_categories);
            BannerTemplateMore r25 = r6.mtemplate_more;
            if (r25 == null) goto L37;
            int r26 = BannerTemplateMore.ADAPTER.encodedSizeWithTag(10, r25);
        L38:
            int r27 = r24 + r26;
            String r28 = r6.mframe_color;
            if (r28 == null) goto L41;
            int r29 = ProtoAdapter.STRING.encodedSizeWithTag(11, r28);
        L42:
            int r30 = r27 + r29;
            TextElement r31 = r6.msub_title;
            if (r31 == null) goto L45;
            int r32 = TextElement.ADAPTER.encodedSizeWithTag(12, r31);
        L46:
            int r33 = r30 + r32;
            String r34 = r6.msub_title_color;
            if (r34 == null) goto L50;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(13, r34);
        L50:
            return (r33 + r1) + r6.unknownFields().size();
        L45:
            r32 = 0;
            goto L46
        L41:
            r29 = 0;
            goto L42
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
        public /* bridge */ /* synthetic */ Object m2481decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TemplateBannerMaterial) r1);
        }

        public void encode(ProtoWriter r4, TemplateBannerMaterial r5) throws IOException {
            String r0 = r5.mbackground_color;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            ImageElement r1 = r5.mbanner_icon;
            if (r1 == null) goto L8;
            ImageElement.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            ImageElement r2 = r5.mbackground_pic;
            if (r2 == null) goto L11;
            ImageElement.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            TextElement r3 = r5.mtitle;
            if (r3 == null) goto L14;
            TextElement.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mtitle_color;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            Boolean r7 = r5.mbanner_closeable;
            if (r7 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r7);
        L20:
            String r8 = r5.mbanner_closeable_color;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
        L23:
            Layout r9 = r5.mlayout;
            if (r9 == null) goto L26;
            Layout.ADAPTER.encodeWithTag(r4, 8, r9);
        L26:
            BannerTemplateCategory.ADAPTER.asRepeated().encodeWithTag(r4, 9, r5.mtemplate_categories);
            BannerTemplateMore r10 = r5.mtemplate_more;
            if (r10 == null) goto L29;
            BannerTemplateMore.ADAPTER.encodeWithTag(r4, 10, r10);
        L29:
            String r11 = r5.mframe_color;
            if (r11 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r4, 11, r11);
        L32:
            TextElement r12 = r5.msub_title;
            if (r12 == null) goto L35;
            TextElement.ADAPTER.encodeWithTag(r4, 12, r12);
        L35:
            String r13 = r5.msub_title_color;
            if (r13 == null) goto L38;
            ProtoAdapter.STRING.encodeWithTag(r4, 13, r13);
        L38:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TemplateBannerMaterial) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TemplateBannerMaterial();
        DEFAULT_BANNER_CLOSEABLE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2479newBuilder() {
        Builder r0 = new Builder();
        r0.mbackground_color = this.mbackground_color;
        r0.mbanner_icon = this.mbanner_icon;
        r0.mbackground_pic = this.mbackground_pic;
        r0.mtitle = this.mtitle;
        r0.mtitle_color = this.mtitle_color;
        r0.mbanner_closeable = this.mbanner_closeable;
        r0.mbanner_closeable_color = this.mbanner_closeable_color;
        r0.mlayout = this.mlayout;
        r0.mtemplate_categories = Internal.copyOf("mtemplate_categories", this.mtemplate_categories);
        r0.mtemplate_more = this.mtemplate_more;
        r0.mframe_color = this.mframe_color;
        r0.msub_title = this.msub_title;
        r0.msub_title_color = this.msub_title_color;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TemplateBannerMaterial.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2479newBuilder();
    }

    public TemplateBannerMaterial(String r16, ImageElement r17, ImageElement r18, TextElement r19, String r20, Boolean r21, String r22, Layout r23, List<BannerTemplateCategory> r24, BannerTemplateMore r25, String r26, TextElement r27, String r28) {
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
    }

    public TemplateBannerMaterial(String r2, ImageElement r3, ImageElement r4, TextElement r5, String r6, Boolean r7, String r8, Layout r9, List<BannerTemplateCategory> r10, BannerTemplateMore r11, String r12, TextElement r13, String r14, ByteString r15) {
        super(ADAPTER, r15);
        this.mbackground_color = r2;
        this.mbanner_icon = r3;
        this.mbackground_pic = r4;
        this.mtitle = r5;
        this.mtitle_color = r6;
        this.mbanner_closeable = r7;
        this.mbanner_closeable_color = r8;
        this.mlayout = r9;
        this.mtemplate_categories = Internal.immutableCopyOf("mtemplate_categories", r10);
        this.mtemplate_more = r11;
        this.mframe_color = r12;
        this.msub_title = r13;
        this.msub_title_color = r14;
    }
}
