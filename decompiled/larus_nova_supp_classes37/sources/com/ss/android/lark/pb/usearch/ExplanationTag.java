package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ExplanationTag extends Message<ExplanationTag, Builder> {
    public static final ProtoAdapter<ExplanationTag> ADAPTER = null;
    public static final String DEFAULT_TAG_TYPE = "";
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    public final TagHover mtag_hover;
    public final TagStyle mtag_style;
    public final String mtag_type;
    public final String mtext;

    public static final class Builder extends Message.Builder<ExplanationTag, Builder> {
        public TagHover mtag_hover;
        public TagStyle mtag_style;
        public String mtag_type;
        public String mtext;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ExplanationTag m2639build() {
            return new ExplanationTag(this.mtext, this.mtag_type, this.mtag_style, this.mtag_hover, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2639build();
        }

        public Builder tag_hover(TagHover r1) {
            this.mtag_hover = r1;
            return this;
        }

        public Builder tag_style(TagStyle r1) {
            this.mtag_style = r1;
            return this;
        }

        public Builder tag_type(String r1) {
            this.mtag_type = r1;
            return this;
        }

        public Builder text(String r1) {
            this.mtext = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ExplanationTag extends ProtoAdapter<ExplanationTag> {
        public ProtoAdapter_ExplanationTag() {
            super(FieldEncoding.LENGTH_DELIMITED, ExplanationTag.class);
        }

        public ExplanationTag decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mtext = "";
            r0.mtag_type = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mtext = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mtag_type = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mtag_style = (TagStyle) TagStyle.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mtag_hover = (TagHover) TagHover.ADAPTER.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m2639build();
        }

        public int encodedSize(ExplanationTag r6) {
            String r0 = r6.mtext;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mtag_type;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            TagStyle r7 = r6.mtag_style;
            if (r7 == null) goto L13;
            int r8 = TagStyle.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            TagHover r10 = r6.mtag_hover;
            if (r10 == null) goto L18;
            r1 = TagHover.ADAPTER.encodedSizeWithTag(4, r10);
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
        public /* bridge */ /* synthetic */ Object m2640decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ExplanationTag) r1);
        }

        public void encode(ProtoWriter r4, ExplanationTag r5) throws IOException {
            String r0 = r5.mtext;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mtag_type;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            TagStyle r2 = r5.mtag_style;
            if (r2 == null) goto L11;
            TagStyle.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            TagHover r3 = r5.mtag_hover;
            if (r3 == null) goto L14;
            TagHover.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ExplanationTag) r2);
        }
    }

    public static final enum TagStyle extends Enum<TagStyle> implements WireEnum {
        private static final /* synthetic */ TagStyle[] $VALUES = null;
        public static final ProtoAdapter<TagStyle> ADAPTER = null;
        public static final TagStyle CRYPTO = null;
        public static final TagStyle HELP_DESK = null;
        public static final TagStyle OFFICIAL_DOC = null;
        public static final TagStyle SHIELD = null;
        public static final TagStyle TEXT = null;
        public static final TagStyle UNKNOWN = null;
        private final int value;

        static {
            TagStyle r0 = new TagStyle("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            TagStyle r1 = new TagStyle("TEXT", 1, 1);
            TEXT = r1;
            TagStyle r3 = new TagStyle("CRYPTO", 2, 2);
            CRYPTO = r3;
            TagStyle r5 = new TagStyle("SHIELD", 3, 3);
            SHIELD = r5;
            TagStyle r7 = new TagStyle("HELP_DESK", 4, 4);
            HELP_DESK = r7;
            TagStyle r9 = new TagStyle("OFFICIAL_DOC", 5, 5);
            OFFICIAL_DOC = r9;
            $VALUES = new TagStyle[]{r0, r1, r3, r5, r7, r9};
            ADAPTER = ProtoAdapter.newEnumAdapter(TagStyle.class);
        }

        public static TagStyle[] values() {
            return (TagStyle[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static TagStyle fromValue(int r1) {
            if (r1 == 0) goto L26;
            if (r1 == 1) goto L24;
            if (r1 == 2) goto L22;
            if (r1 == 3) goto L20;
            if (r1 == 4) goto L18;
            if (r1 == 5) goto L16;
            return null;
        L16:
            return OFFICIAL_DOC;
        L18:
            return HELP_DESK;
        L20:
            return SHIELD;
        L22:
            return CRYPTO;
        L24:
            return TEXT;
        L26:
            return UNKNOWN;
        }

        public static TagStyle valueOf(String r1) {
            return (TagStyle) a.a(TagStyle.class, r1);
        }

        private TagStyle(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExplanationTag();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2638newBuilder() {
        Builder r0 = new Builder();
        r0.mtext = this.mtext;
        r0.mtag_type = this.mtag_type;
        r0.mtag_style = this.mtag_style;
        r0.mtag_hover = this.mtag_hover;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ExplanationTag.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2638newBuilder();
    }

    public ExplanationTag(String r7, String r8, TagStyle r9, TagHover r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public ExplanationTag(String r2, String r3, TagStyle r4, TagHover r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mtext = r2;
        this.mtag_type = r3;
        this.mtag_style = r4;
        this.mtag_hover = r5;
    }
}
