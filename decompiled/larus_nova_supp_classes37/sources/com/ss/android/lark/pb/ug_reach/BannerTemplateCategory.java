package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BannerTemplateCategory extends Message<BannerTemplateCategory, Builder> {
    public static final ProtoAdapter<BannerTemplateCategory> ADAPTER = null;
    public static final String DEFAULT_BACKGROUND_COLOR = "";
    public static final String DEFAULT_CTA_BACKGROUND_COLOR = "";
    public static final String DEFAULT_CTA_FRAME_COLOR = "";
    public static final String DEFAULT_CTA_SHADOW_COLOR = "";
    public static final String DEFAULT_CTA_TITLE_COLOR = "";
    public static final String DEFAULT_FRAME_COLOR = "";
    public static final Integer DEFAULT_TEMPLATE_NUM = null;
    private static final long serialVersionUID = 0;
    public final String mbackground_color;
    public final TextElement mcategory_name;
    public final String mcta_background_color;
    public final String mcta_frame_color;
    public final String mcta_shadow_color;
    public final TextElement mcta_title;
    public final String mcta_title_color;
    public final List<ImageElement> mdym_pics;
    public final String mframe_color;
    public final ImageElement mfront_pic;
    public final TextElement mlink;
    public final Integer mtemplate_num;

    public static final class Builder extends Message.Builder<BannerTemplateCategory, Builder> {
        public String mbackground_color;
        public TextElement mcategory_name;
        public String mcta_background_color;
        public String mcta_frame_color;
        public String mcta_shadow_color;
        public TextElement mcta_title;
        public String mcta_title_color;
        public List<ImageElement> mdym_pics;
        public String mframe_color;
        public ImageElement mfront_pic;
        public TextElement mlink;
        public Integer mtemplate_num;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BannerTemplateCategory m2423build() {
            return new BannerTemplateCategory(this.mbackground_color, this.mfront_pic, this.mcategory_name, this.mlink, this.mtemplate_num, this.mdym_pics, this.mcta_title, this.mcta_title_color, this.mframe_color, this.mcta_frame_color, this.mcta_background_color, this.mcta_shadow_color, super.buildUnknownFields());
        }

        public Builder() {
            this.mdym_pics = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2423build();
        }

        public Builder background_color(String r1) {
            this.mbackground_color = r1;
            return this;
        }

        public Builder category_name(TextElement r1) {
            this.mcategory_name = r1;
            return this;
        }

        public Builder cta_background_color(String r1) {
            this.mcta_background_color = r1;
            return this;
        }

        public Builder cta_frame_color(String r1) {
            this.mcta_frame_color = r1;
            return this;
        }

        public Builder cta_shadow_color(String r1) {
            this.mcta_shadow_color = r1;
            return this;
        }

        public Builder cta_title(TextElement r1) {
            this.mcta_title = r1;
            return this;
        }

        public Builder cta_title_color(String r1) {
            this.mcta_title_color = r1;
            return this;
        }

        public Builder dym_pics(List<ImageElement> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdym_pics = r1;
            return this;
        }

        public Builder frame_color(String r1) {
            this.mframe_color = r1;
            return this;
        }

        public Builder front_pic(ImageElement r1) {
            this.mfront_pic = r1;
            return this;
        }

        public Builder link(TextElement r1) {
            this.mlink = r1;
            return this;
        }

        public Builder template_num(Integer r1) {
            this.mtemplate_num = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerTemplateCategory extends ProtoAdapter<BannerTemplateCategory> {
        public ProtoAdapter_BannerTemplateCategory() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerTemplateCategory.class);
        }

        public BannerTemplateCategory decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mbackground_color = "";
            r0.mtemplate_num = 0;
            r0.mcta_title_color = "";
            r0.mframe_color = "";
            r0.mcta_frame_color = "";
            r0.mcta_background_color = "";
            r0.mcta_shadow_color = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L19;
            switch(r3) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            r0.mcta_shadow_color = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            r0.mcta_background_color = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            r0.mcta_frame_color = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.mframe_color = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            r0.mcta_title_color = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mcta_title = (TextElement) TextElement.ADAPTER.decode(r7);
            goto L3
        L13:
            r0.mdym_pics.add((ImageElement) ImageElement.ADAPTER.decode(r7));
            goto L3
        L14:
            r0.mtemplate_num = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L15:
            r0.mlink = (TextElement) TextElement.ADAPTER.decode(r7);
            goto L3
        L16:
            r0.mcategory_name = (TextElement) TextElement.ADAPTER.decode(r7);
            goto L3
        L17:
            r0.mfront_pic = (ImageElement) ImageElement.ADAPTER.decode(r7);
            goto L3
        L18:
            r0.mbackground_color = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L19:
            r7.endMessage(r1);
            return r0.m2423build();
        }

        public int encodedSize(BannerTemplateCategory r6) {
            String r0 = r6.mbackground_color;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            ImageElement r3 = r6.mfront_pic;
            if (r3 == null) goto L9;
            int r4 = ImageElement.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            TextElement r7 = r6.mcategory_name;
            if (r7 == null) goto L13;
            int r8 = TextElement.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            TextElement r10 = r6.mlink;
            if (r10 == null) goto L17;
            int r11 = TextElement.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Integer r13 = r6.mtemplate_num;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.INT32.encodedSizeWithTag(5, r13);
        L22:
            int r15 = (r12 + r14) + ImageElement.ADAPTER.asRepeated().encodedSizeWithTag(6, r6.mdym_pics);
            TextElement r16 = r6.mcta_title;
            if (r16 == null) goto L25;
            int r17 = TextElement.ADAPTER.encodedSizeWithTag(7, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.mcta_title_color;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(8, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r6.mframe_color;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(9, r22);
        L34:
            int r24 = r21 + r23;
            String r25 = r6.mcta_frame_color;
            if (r25 == null) goto L37;
            int r26 = ProtoAdapter.STRING.encodedSizeWithTag(10, r25);
        L38:
            int r27 = r24 + r26;
            String r28 = r6.mcta_background_color;
            if (r28 == null) goto L41;
            int r29 = ProtoAdapter.STRING.encodedSizeWithTag(11, r28);
        L42:
            int r30 = r27 + r29;
            String r31 = r6.mcta_shadow_color;
            if (r31 == null) goto L46;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(12, r31);
        L46:
            return (r30 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2424decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BannerTemplateCategory) r1);
        }

        public void encode(ProtoWriter r4, BannerTemplateCategory r5) throws IOException {
            String r0 = r5.mbackground_color;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            ImageElement r1 = r5.mfront_pic;
            if (r1 == null) goto L8;
            ImageElement.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            TextElement r2 = r5.mcategory_name;
            if (r2 == null) goto L11;
            TextElement.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            TextElement r3 = r5.mlink;
            if (r3 == null) goto L14;
            TextElement.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            Integer r6 = r5.mtemplate_num;
            if (r6 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r4, 5, r6);
        L17:
            ImageElement.ADAPTER.asRepeated().encodeWithTag(r4, 6, r5.mdym_pics);
            TextElement r7 = r5.mcta_title;
            if (r7 == null) goto L20;
            TextElement.ADAPTER.encodeWithTag(r4, 7, r7);
        L20:
            String r8 = r5.mcta_title_color;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r8);
        L23:
            String r9 = r5.mframe_color;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r4, 9, r9);
        L26:
            String r10 = r5.mcta_frame_color;
            if (r10 == null) goto L29;
            ProtoAdapter.STRING.encodeWithTag(r4, 10, r10);
        L29:
            String r11 = r5.mcta_background_color;
            if (r11 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r4, 11, r11);
        L32:
            String r12 = r5.mcta_shadow_color;
            if (r12 == null) goto L35;
            ProtoAdapter.STRING.encodeWithTag(r4, 12, r12);
        L35:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BannerTemplateCategory) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerTemplateCategory();
        DEFAULT_TEMPLATE_NUM = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2422newBuilder() {
        Builder r0 = new Builder();
        r0.mbackground_color = this.mbackground_color;
        r0.mfront_pic = this.mfront_pic;
        r0.mcategory_name = this.mcategory_name;
        r0.mlink = this.mlink;
        r0.mtemplate_num = this.mtemplate_num;
        r0.mdym_pics = Internal.copyOf("mdym_pics", this.mdym_pics);
        r0.mcta_title = this.mcta_title;
        r0.mcta_title_color = this.mcta_title_color;
        r0.mframe_color = this.mframe_color;
        r0.mcta_frame_color = this.mcta_frame_color;
        r0.mcta_background_color = this.mcta_background_color;
        r0.mcta_shadow_color = this.mcta_shadow_color;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BannerTemplateCategory.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2422newBuilder();
    }

    public BannerTemplateCategory(String r15, ImageElement r16, TextElement r17, TextElement r18, Integer r19, List<ImageElement> r20, TextElement r21, String r22, String r23, String r24, String r25, String r26) {
        this(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, ByteString.EMPTY);
    }

    public BannerTemplateCategory(String r2, ImageElement r3, TextElement r4, TextElement r5, Integer r6, List<ImageElement> r7, TextElement r8, String r9, String r10, String r11, String r12, String r13, ByteString r14) {
        super(ADAPTER, r14);
        this.mbackground_color = r2;
        this.mfront_pic = r3;
        this.mcategory_name = r4;
        this.mlink = r5;
        this.mtemplate_num = r6;
        this.mdym_pics = Internal.immutableCopyOf("mdym_pics", r7);
        this.mcta_title = r8;
        this.mcta_title_color = r9;
        this.mframe_color = r10;
        this.mcta_frame_color = r11;
        this.mcta_background_color = r12;
        this.mcta_shadow_color = r13;
    }
}
