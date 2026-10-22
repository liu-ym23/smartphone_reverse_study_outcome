package com.ss.android.lark.pb.usearch;

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
public final class AdvGrammarConf extends Message<AdvGrammarConf, Builder> {
    public static final ProtoAdapter<AdvGrammarConf> ADAPTER = null;
    public static final String DEFAULT_KEY_NAME = "";
    public static final String DEFAULT_REF_APP_ID = "";
    private static final long serialVersionUID = 0;
    public final List<EnumValue> menum_values;
    public final String mkey_name;
    public final String mref_app_id;
    public final SelectorType mselector_type;

    public static final class Builder extends Message.Builder<AdvGrammarConf, Builder> {
        public List<EnumValue> menum_values;
        public String mkey_name;
        public String mref_app_id;
        public SelectorType mselector_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AdvGrammarConf m2495build() {
            String r0 = this.mkey_name;
            if (r0 == null) goto L9;
            if (this.mselector_type == null) goto L9;
            return new AdvGrammarConf(this.mkey_name, this.mselector_type, this.menum_values, this.mref_app_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mkey_name", this.mselector_type, "mselector_type"});
        }

        public Builder() {
            this.menum_values = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2495build();
        }

        public Builder enum_values(List<EnumValue> r1) {
            Internal.checkElementsNotNull(r1);
            this.menum_values = r1;
            return this;
        }

        public Builder key_name(String r1) {
            this.mkey_name = r1;
            return this;
        }

        public Builder ref_app_id(String r1) {
            this.mref_app_id = r1;
            return this;
        }

        public Builder selector_type(SelectorType r1) {
            this.mselector_type = r1;
            return this;
        }
    }

    public static final class EnumValue extends Message<EnumValue, Builder> {
        public static final ProtoAdapter<EnumValue> ADAPTER = null;
        public static final String DEFAULT_VALUE_NAME = "";
        private static final long serialVersionUID = 0;
        public final String mvalue_name;

        public static final class Builder extends Message.Builder<EnumValue, Builder> {
            public String mvalue_name;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public EnumValue m2497build() {
                return new EnumValue(this.mvalue_name, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2497build();
            }

            public Builder value_name(String r1) {
                this.mvalue_name = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_EnumValue extends ProtoAdapter<EnumValue> {
            public ProtoAdapter_EnumValue() {
                super(FieldEncoding.LENGTH_DELIMITED, EnumValue.class);
            }

            public EnumValue decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mvalue_name = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mvalue_name = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2497build();
            }

            public int encodedSize(EnumValue r4) {
                String r0 = r4.mvalue_name;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2498decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((EnumValue) r1);
            }

            public void encode(ProtoWriter r4, EnumValue r5) throws IOException {
                String r0 = r5.mvalue_name;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (EnumValue) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EnumValue();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2496newBuilder() {
            Builder r0 = new Builder();
            r0.mvalue_name = this.mvalue_name;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return EnumValue.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2496newBuilder();
        }

        public EnumValue(String r2) {
            this(r2, ByteString.EMPTY);
        }

        public EnumValue(String r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mvalue_name = r2;
        }
    }

    public static final class ProtoAdapter_AdvGrammarConf extends ProtoAdapter<AdvGrammarConf> {
        public ProtoAdapter_AdvGrammarConf() {
            super(FieldEncoding.LENGTH_DELIMITED, AdvGrammarConf.class);
        }

        public AdvGrammarConf decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mkey_name = "";
            r0.mref_app_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mkey_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mselector_type = (SelectorType) SelectorType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.menum_values.add((EnumValue) EnumValue.ADAPTER.decode(r9));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.mref_app_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m2495build();
        }

        public int encodedSize(AdvGrammarConf r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = (r0.encodedSizeWithTag(1, r6.mkey_name) + SelectorType.ADAPTER.encodedSizeWithTag(2, r6.mselector_type)) + EnumValue.ADAPTER.asRepeated().encodedSizeWithTag(3, r6.menum_values);
            String r2 = r6.mref_app_id;
            if (r2 == null) goto L5;
            int r3 = r0.encodedSizeWithTag(4, r2);
        L7:
            return (r1 + r3) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2499decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AdvGrammarConf) r1);
        }

        public void encode(ProtoWriter r5, AdvGrammarConf r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mkey_name);
            SelectorType.ADAPTER.encodeWithTag(r5, 2, r6.mselector_type);
            EnumValue.ADAPTER.asRepeated().encodeWithTag(r5, 3, r6.menum_values);
            String r1 = r6.mref_app_id;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 4, r1);
        L5:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AdvGrammarConf) r2);
        }
    }

    public static final enum SelectorType extends Enum<SelectorType> implements WireEnum {
        private static final /* synthetic */ SelectorType[] $VALUES = null;
        public static final ProtoAdapter<SelectorType> ADAPTER = null;
        public static final SelectorType CHAT_SELECTOR = null;
        public static final SelectorType ENUM_SELECTOR = null;
        public static final SelectorType MAIL_USER_SELECTOR = null;
        public static final SelectorType SEARCHABLE_SELECTOR = null;
        public static final SelectorType USER_CHAT_SELECTOR = null;
        public static final SelectorType USER_SELECTOR = null;
        private final int value;

        static {
            SelectorType r0 = new SelectorType("ENUM_SELECTOR", 0, 1);
            ENUM_SELECTOR = r0;
            SelectorType r1 = new SelectorType("SEARCHABLE_SELECTOR", 1, 2);
            SEARCHABLE_SELECTOR = r1;
            SelectorType r4 = new SelectorType("USER_SELECTOR", 2, 3);
            USER_SELECTOR = r4;
            SelectorType r6 = new SelectorType("CHAT_SELECTOR", 3, 4);
            CHAT_SELECTOR = r6;
            SelectorType r8 = new SelectorType("USER_CHAT_SELECTOR", 4, 5);
            USER_CHAT_SELECTOR = r8;
            SelectorType r10 = new SelectorType("MAIL_USER_SELECTOR", 5, 6);
            MAIL_USER_SELECTOR = r10;
            $VALUES = new SelectorType[]{r0, r1, r4, r6, r8, r10};
            ADAPTER = ProtoAdapter.newEnumAdapter(SelectorType.class);
        }

        public static SelectorType[] values() {
            return (SelectorType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SelectorType fromValue(int r0) {
            switch(r0) {
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MAIL_USER_SELECTOR;
        L8:
            return USER_CHAT_SELECTOR;
        L10:
            return CHAT_SELECTOR;
        L12:
            return USER_SELECTOR;
        L14:
            return SEARCHABLE_SELECTOR;
        L16:
            return ENUM_SELECTOR;
        }

        public static SelectorType valueOf(String r1) {
            return (SelectorType) a.a(SelectorType.class, r1);
        }

        private SelectorType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AdvGrammarConf();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2494newBuilder() {
        Builder r0 = new Builder();
        r0.mkey_name = this.mkey_name;
        r0.mselector_type = this.mselector_type;
        r0.menum_values = Internal.copyOf("menum_values", this.menum_values);
        r0.mref_app_id = this.mref_app_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AdvGrammarConf.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2494newBuilder();
    }

    public AdvGrammarConf(String r7, SelectorType r8, List<EnumValue> r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public AdvGrammarConf(String r2, SelectorType r3, List<EnumValue> r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mkey_name = r2;
        this.mselector_type = r3;
        this.menum_values = Internal.immutableCopyOf("menum_values", r4);
        this.mref_app_id = r5;
    }
}
