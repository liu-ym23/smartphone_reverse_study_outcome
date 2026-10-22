package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BannerText extends Message<BannerText, Builder> {
    public static final ProtoAdapter<BannerText> ADAPTER = null;
    public static final String DEFAULT_HEAD_ICON = "";
    public static final String DEFAULT_RICH_TEXT = "";
    public static final String DEFAULT_TAIL_ICON = "";
    private static final long serialVersionUID = 0;
    public final String mhead_icon;
    public final String mrich_text;
    public final String mtail_icon;
    public final BannerTextType mtext_type;

    public static final class Builder extends Message.Builder<BannerText, Builder> {
        public String mhead_icon;
        public String mrich_text;
        public String mtail_icon;
        public BannerTextType mtext_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BannerText m2558build() {
            return new BannerText(this.mrich_text, this.mhead_icon, this.mtail_icon, this.mtext_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2558build();
        }

        public Builder head_icon(String r1) {
            this.mhead_icon = r1;
            return this;
        }

        public Builder rich_text(String r1) {
            this.mrich_text = r1;
            return this;
        }

        public Builder tail_icon(String r1) {
            this.mtail_icon = r1;
            return this;
        }

        public Builder text_type(BannerTextType r1) {
            this.mtext_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerText extends ProtoAdapter<BannerText> {
        public ProtoAdapter_BannerText() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerText.class);
        }

        public BannerText decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mrich_text = "";
            r0.mhead_icon = "";
            r0.mtail_icon = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mrich_text = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mhead_icon = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mtail_icon = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mtext_type = (BannerTextType) BannerTextType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m2558build();
        }

        public int encodedSize(BannerText r6) {
            String r0 = r6.mrich_text;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mhead_icon;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mtail_icon;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            BannerTextType r10 = r6.mtext_type;
            if (r10 == null) goto L18;
            r1 = BannerTextType.ADAPTER.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m2559decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BannerText) r1);
        }

        public void encode(ProtoWriter r4, BannerText r5) throws IOException {
            String r0 = r5.mrich_text;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mhead_icon;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mtail_icon;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            BannerTextType r3 = r5.mtext_type;
            if (r3 == null) goto L14;
            BannerTextType.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BannerText) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerText();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2557newBuilder() {
        Builder r0 = new Builder();
        r0.mrich_text = this.mrich_text;
        r0.mhead_icon = this.mhead_icon;
        r0.mtail_icon = this.mtail_icon;
        r0.mtext_type = this.mtext_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BannerText.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2557newBuilder();
    }

    public BannerText(String r7, String r8, String r9, BannerTextType r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public BannerText(String r2, String r3, String r4, BannerTextType r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mrich_text = r2;
        this.mhead_icon = r3;
        this.mtail_icon = r4;
        this.mtext_type = r5;
    }
}
