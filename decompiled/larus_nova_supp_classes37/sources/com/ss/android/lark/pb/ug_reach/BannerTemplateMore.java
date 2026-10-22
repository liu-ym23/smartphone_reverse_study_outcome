package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BannerTemplateMore extends Message<BannerTemplateMore, Builder> {
    public static final ProtoAdapter<BannerTemplateMore> ADAPTER = null;
    public static final String DEFAULT_BACKGROUND_COLOR = "";
    public static final String DEFAULT_FRAME_COLOR = "";
    private static final long serialVersionUID = 0;
    public final String mbackground_color;
    public final ImageElement mcontent_pic;
    public final String mframe_color;
    public final TextElement mlink;
    public final TextElement mname;

    public static final class Builder extends Message.Builder<BannerTemplateMore, Builder> {
        public String mbackground_color;
        public ImageElement mcontent_pic;
        public String mframe_color;
        public TextElement mlink;
        public TextElement mname;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BannerTemplateMore m2426build() {
            return new BannerTemplateMore(this.mbackground_color, this.mcontent_pic, this.mname, this.mlink, this.mframe_color, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2426build();
        }

        public Builder background_color(String r1) {
            this.mbackground_color = r1;
            return this;
        }

        public Builder content_pic(ImageElement r1) {
            this.mcontent_pic = r1;
            return this;
        }

        public Builder frame_color(String r1) {
            this.mframe_color = r1;
            return this;
        }

        public Builder link(TextElement r1) {
            this.mlink = r1;
            return this;
        }

        public Builder name(TextElement r1) {
            this.mname = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerTemplateMore extends ProtoAdapter<BannerTemplateMore> {
        public ProtoAdapter_BannerTemplateMore() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerTemplateMore.class);
        }

        public BannerTemplateMore decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mbackground_color = "";
            r0.mframe_color = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mbackground_color = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mcontent_pic = (ImageElement) ImageElement.ADAPTER.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mname = (TextElement) TextElement.ADAPTER.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mlink = (TextElement) TextElement.ADAPTER.decode(r7);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mframe_color = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m2426build();
        }

        public int encodedSize(BannerTemplateMore r6) {
            String r0 = r6.mbackground_color;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            ImageElement r3 = r6.mcontent_pic;
            if (r3 == null) goto L9;
            int r4 = ImageElement.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            TextElement r7 = r6.mname;
            if (r7 == null) goto L13;
            int r8 = TextElement.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            TextElement r10 = r6.mlink;
            if (r10 == null) goto L17;
            int r11 = TextElement.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mframe_color;
            if (r13 == null) goto L22;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            return (r12 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2427decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BannerTemplateMore) r1);
        }

        public void encode(ProtoWriter r4, BannerTemplateMore r5) throws IOException {
            String r0 = r5.mbackground_color;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            ImageElement r1 = r5.mcontent_pic;
            if (r1 == null) goto L8;
            ImageElement.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            TextElement r2 = r5.mname;
            if (r2 == null) goto L11;
            TextElement.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            TextElement r3 = r5.mlink;
            if (r3 == null) goto L14;
            TextElement.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mframe_color;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BannerTemplateMore) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerTemplateMore();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2425newBuilder() {
        Builder r0 = new Builder();
        r0.mbackground_color = this.mbackground_color;
        r0.mcontent_pic = this.mcontent_pic;
        r0.mname = this.mname;
        r0.mlink = this.mlink;
        r0.mframe_color = this.mframe_color;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BannerTemplateMore.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2425newBuilder();
    }

    public BannerTemplateMore(String r8, ImageElement r9, TextElement r10, TextElement r11, String r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public BannerTemplateMore(String r2, ImageElement r3, TextElement r4, TextElement r5, String r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mbackground_color = r2;
        this.mcontent_pic = r3;
        this.mname = r4;
        this.mlink = r5;
        this.mframe_color = r6;
    }
}
