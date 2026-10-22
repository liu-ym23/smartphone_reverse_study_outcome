package com.ss.android.lark.pb.ug_reach;

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
public final class TextElement extends Message<TextElement, Builder> {
    public static final ProtoAdapter<TextElement> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final TextType mtype;

    public static final class Builder extends Message.Builder<TextElement, Builder> {
        public String mcontent;
        public TextType mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TextElement m2483build() {
            return new TextElement(this.mtype, this.mcontent, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2483build();
        }

        public Builder content(String r1) {
            this.mcontent = r1;
            return this;
        }

        public Builder type(TextType r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TextElement extends ProtoAdapter<TextElement> {
        public ProtoAdapter_TextElement() {
            super(FieldEncoding.LENGTH_DELIMITED, TextElement.class);
        }

        public TextElement decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mcontent = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mtype = (TextType) TextType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mcontent = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m2483build();
        }

        public int encodedSize(TextElement r5) {
            TextType r0 = r5.mtype;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = TextType.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mcontent;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2484decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TextElement) r1);
        }

        public void encode(ProtoWriter r4, TextElement r5) throws IOException {
            TextType r0 = r5.mtype;
            if (r0 == null) goto L5;
            TextType.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mcontent;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TextElement) r2);
        }
    }

    public static final enum TextType extends Enum<TextType> implements WireEnum {
        private static final /* synthetic */ TextType[] $VALUES = null;
        public static final ProtoAdapter<TextType> ADAPTER = null;
        public static final TextType HTML = null;
        public static final TextType PLAIN = null;
        public static final TextType UNKNOWN = null;
        private final int value;

        static {
            TextType r0 = new TextType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            TextType r1 = new TextType("PLAIN", 1, 1);
            PLAIN = r1;
            TextType r3 = new TextType("HTML", 2, 2);
            HTML = r3;
            $VALUES = new TextType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(TextType.class);
        }

        public static TextType[] values() {
            return (TextType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static TextType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return HTML;
        L12:
            return PLAIN;
        L14:
            return UNKNOWN;
        }

        public static TextType valueOf(String r1) {
            return (TextType) a.a(TextType.class, r1);
        }

        private TextType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TextElement();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2482newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.mcontent = this.mcontent;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TextElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2482newBuilder();
    }

    public TextElement(TextType r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public TextElement(TextType r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtype = r2;
        this.mcontent = r3;
    }
}
