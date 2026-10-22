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
public final class ParsingInfo extends Message<ParsingInfo, Builder> {
    public static final ProtoAdapter<ParsingInfo> ADAPTER = null;
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    public final Style minfo_style;
    public final String mtext;

    public static final class Builder extends Message.Builder<ParsingInfo, Builder> {
        public Style minfo_style;
        public String mtext;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ParsingInfo m2744build() {
            return new ParsingInfo(this.mtext, this.minfo_style, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2744build();
        }

        public Builder info_style(Style r1) {
            this.minfo_style = r1;
            return this;
        }

        public Builder text(String r1) {
            this.mtext = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ParsingInfo extends ProtoAdapter<ParsingInfo> {
        public ProtoAdapter_ParsingInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ParsingInfo.class);
        }

        public ParsingInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mtext = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mtext = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.minfo_style = (Style) Style.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m2744build();
        }

        public int encodedSize(ParsingInfo r5) {
            String r0 = r5.mtext;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Style r3 = r5.minfo_style;
            if (r3 == null) goto L10;
            r1 = Style.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2745decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ParsingInfo) r1);
        }

        public void encode(ProtoWriter r4, ParsingInfo r5) throws IOException {
            String r0 = r5.mtext;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Style r1 = r5.minfo_style;
            if (r1 == null) goto L8;
            Style.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ParsingInfo) r2);
        }
    }

    public static final enum Style extends Enum<Style> implements WireEnum {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final ProtoAdapter<Style> ADAPTER = null;
        public static final Style HIGHLIGHT = null;
        public static final Style NORMAL = null;
        public static final Style STRIKETHROUGH = null;
        public static final Style UNKNOWN = null;
        private final int value;

        static {
            Style r0 = new Style("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Style r1 = new Style("HIGHLIGHT", 1, 1);
            HIGHLIGHT = r1;
            Style r3 = new Style("STRIKETHROUGH", 2, 2);
            STRIKETHROUGH = r3;
            Style r5 = new Style("NORMAL", 3, 3);
            NORMAL = r5;
            $VALUES = new Style[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(Style.class);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Style fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return NORMAL;
        L14:
            return STRIKETHROUGH;
        L16:
            return HIGHLIGHT;
        L18:
            return UNKNOWN;
        }

        public static Style valueOf(String r1) {
            return (Style) a.a(Style.class, r1);
        }

        private Style(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ParsingInfo();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2743newBuilder() {
        Builder r0 = new Builder();
        r0.mtext = this.mtext;
        r0.minfo_style = this.minfo_style;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ParsingInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2743newBuilder();
    }

    public ParsingInfo(String r2, Style r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public ParsingInfo(String r2, Style r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtext = r2;
        this.minfo_style = r3;
    }
}
