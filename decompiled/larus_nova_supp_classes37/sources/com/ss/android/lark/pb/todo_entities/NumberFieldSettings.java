package com.ss.android.lark.pb.todo_entities;

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
public final class NumberFieldSettings extends Message<NumberFieldSettings, Builder> {
    public static final ProtoAdapter<NumberFieldSettings> ADAPTER = null;
    public static final String DEFAULT_CUSTOM_SYMBOL_CHARS = "";
    public static final Integer DEFAULT_DECIMAL_COUNT = null;
    private static final long serialVersionUID = 0;
    public final String mcustom_symbol_chars;
    public final CustomSymbolPosition mcustom_symbol_position;
    public final Integer mdecimal_count;
    public final Format mformat;
    public final Separator mseparator;

    public static final class Builder extends Message.Builder<NumberFieldSettings, Builder> {
        public String mcustom_symbol_chars;
        public CustomSymbolPosition mcustom_symbol_position;
        public Integer mdecimal_count;
        public Format mformat;
        public Separator mseparator;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public NumberFieldSettings m2315build() {
            return new NumberFieldSettings(this.mformat, this.mcustom_symbol_chars, this.mcustom_symbol_position, this.mdecimal_count, this.mseparator, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2315build();
        }

        public Builder custom_symbol_chars(String r1) {
            this.mcustom_symbol_chars = r1;
            return this;
        }

        public Builder custom_symbol_position(CustomSymbolPosition r1) {
            this.mcustom_symbol_position = r1;
            return this;
        }

        public Builder decimal_count(Integer r1) {
            this.mdecimal_count = r1;
            return this;
        }

        public Builder format(Format r1) {
            this.mformat = r1;
            return this;
        }

        public Builder separator(Separator r1) {
            this.mseparator = r1;
            return this;
        }
    }

    public static final enum CustomSymbolPosition extends Enum<CustomSymbolPosition> implements WireEnum {
        private static final /* synthetic */ CustomSymbolPosition[] $VALUES = null;
        public static final ProtoAdapter<CustomSymbolPosition> ADAPTER = null;
        public static final CustomSymbolPosition LEFT = null;
        public static final CustomSymbolPosition RIGHT = null;
        private final int value;

        static {
            CustomSymbolPosition r0 = new CustomSymbolPosition("LEFT", 0, 1);
            LEFT = r0;
            CustomSymbolPosition r1 = new CustomSymbolPosition("RIGHT", 1, 2);
            RIGHT = r1;
            $VALUES = new CustomSymbolPosition[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(CustomSymbolPosition.class);
        }

        public static CustomSymbolPosition[] values() {
            return (CustomSymbolPosition[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CustomSymbolPosition fromValue(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return null;
        L9:
            return RIGHT;
        L11:
            return LEFT;
        }

        public static CustomSymbolPosition valueOf(String r1) {
            return (CustomSymbolPosition) a.a(CustomSymbolPosition.class, r1);
        }

        private CustomSymbolPosition(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Format extends Enum<Format> implements WireEnum {
        private static final /* synthetic */ Format[] $VALUES = null;
        public static final ProtoAdapter<Format> ADAPTER = null;
        public static final Format CUSTOM_SYMBOL = null;
        public static final Format NORMAL = null;
        public static final Format PERCENTAGE = null;
        public static final Format RMB = null;
        public static final Format USD = null;
        private final int value;

        static {
            Format r0 = new Format("NORMAL", 0, 0);
            NORMAL = r0;
            Format r1 = new Format("PERCENTAGE", 1, 1);
            PERCENTAGE = r1;
            Format r3 = new Format("RMB", 2, 2);
            RMB = r3;
            Format r5 = new Format("USD", 3, 3);
            USD = r5;
            Format r7 = new Format("CUSTOM_SYMBOL", 4, 1000);
            CUSTOM_SYMBOL = r7;
            $VALUES = new Format[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(Format.class);
        }

        public static Format[] values() {
            return (Format[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Format fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 1000) goto L14;
            return null;
        L14:
            return CUSTOM_SYMBOL;
        L16:
            return USD;
        L18:
            return RMB;
        L20:
            return PERCENTAGE;
        L22:
            return NORMAL;
        }

        public static Format valueOf(String r1) {
            return (Format) a.a(Format.class, r1);
        }

        private Format(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_NumberFieldSettings extends ProtoAdapter<NumberFieldSettings> {
        public ProtoAdapter_NumberFieldSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, NumberFieldSettings.class);
        }

        public NumberFieldSettings decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mcustom_symbol_chars = "";
            r0.mdecimal_count = 0;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L30;
            if (r3 != 1) goto L8;
            r0.mformat = (Format) Format.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
        L28:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mcustom_symbol_chars = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mcustom_symbol_position = (CustomSymbolPosition) CustomSymbolPosition.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mdecimal_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mseparator = (Separator) Separator.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L30:
            r9.endMessage(r1);
            return r0.m2315build();
        }

        public int encodedSize(NumberFieldSettings r6) {
            Format r0 = r6.mformat;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = Format.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mcustom_symbol_chars;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            CustomSymbolPosition r7 = r6.mcustom_symbol_position;
            if (r7 == null) goto L13;
            int r8 = CustomSymbolPosition.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Integer r10 = r6.mdecimal_count;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT32.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Separator r13 = r6.mseparator;
            if (r13 == null) goto L22;
            r1 = Separator.ADAPTER.encodedSizeWithTag(5, r13);
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
        public /* bridge */ /* synthetic */ Object m2316decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((NumberFieldSettings) r1);
        }

        public void encode(ProtoWriter r4, NumberFieldSettings r5) throws IOException {
            Format r0 = r5.mformat;
            if (r0 == null) goto L5;
            Format.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mcustom_symbol_chars;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            CustomSymbolPosition r2 = r5.mcustom_symbol_position;
            if (r2 == null) goto L11;
            CustomSymbolPosition.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            Integer r3 = r5.mdecimal_count;
            if (r3 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r3);
        L14:
            Separator r6 = r5.mseparator;
            if (r6 == null) goto L17;
            Separator.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (NumberFieldSettings) r2);
        }
    }

    public static final enum Separator extends Enum<Separator> implements WireEnum {
        private static final /* synthetic */ Separator[] $VALUES = null;
        public static final ProtoAdapter<Separator> ADAPTER = null;
        public static final Separator NO = null;
        public static final Separator THOUSAND = null;
        private final int value;

        static {
            Separator r0 = new Separator("NO", 0, 0);
            NO = r0;
            Separator r1 = new Separator("THOUSAND", 1, 1);
            THOUSAND = r1;
            $VALUES = new Separator[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(Separator.class);
        }

        public static Separator[] values() {
            return (Separator[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Separator fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return THOUSAND;
        L10:
            return NO;
        }

        public static Separator valueOf(String r1) {
            return (Separator) a.a(Separator.class, r1);
        }

        private Separator(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NumberFieldSettings();
        DEFAULT_DECIMAL_COUNT = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2314newBuilder() {
        Builder r0 = new Builder();
        r0.mformat = this.mformat;
        r0.mcustom_symbol_chars = this.mcustom_symbol_chars;
        r0.mcustom_symbol_position = this.mcustom_symbol_position;
        r0.mdecimal_count = this.mdecimal_count;
        r0.mseparator = this.mseparator;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return NumberFieldSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2314newBuilder();
    }

    public NumberFieldSettings(Format r8, String r9, CustomSymbolPosition r10, Integer r11, Separator r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public NumberFieldSettings(Format r2, String r3, CustomSymbolPosition r4, Integer r5, Separator r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mformat = r2;
        this.mcustom_symbol_chars = r3;
        this.mcustom_symbol_position = r4;
        this.mdecimal_count = r5;
        this.mseparator = r6;
    }
}
