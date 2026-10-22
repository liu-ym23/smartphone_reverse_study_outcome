package com.ss.android.lark.pb.usearch;

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
public final class CustomizationMeta extends Message<CustomizationMeta, Builder> {
    public static final ProtoAdapter<CustomizationMeta> ADAPTER = null;
    public static final String DEFAULT_DATA_SOURCE_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_NEED_STICKY_POST = null;
    public static final String DEFAULT_RENDER_CONTENT = "";
    public static final String DEFAULT_TEMPLATE_NAME = "";
    private static final long serialVersionUID = 0;
    public final CardType mcard_type;
    public final String mdata_source_id;
    public final String mid;
    public final Boolean mneed_sticky_post;
    public final String mrender_content;
    public final String mtemplate_name;

    public static final class Builder extends Message.Builder<CustomizationMeta, Builder> {
        public CardType mcard_type;
        public String mdata_source_id;
        public String mid;
        public Boolean mneed_sticky_post;
        public String mrender_content;
        public String mtemplate_name;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CustomizationMeta m2576build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new CustomizationMeta(this.mid, this.mrender_content, this.mdata_source_id, this.mtemplate_name, this.mcard_type, this.mneed_sticky_post, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2576build();
        }

        public Builder card_type(CardType r1) {
            this.mcard_type = r1;
            return this;
        }

        public Builder data_source_id(String r1) {
            this.mdata_source_id = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder need_sticky_post(Boolean r1) {
            this.mneed_sticky_post = r1;
            return this;
        }

        public Builder render_content(String r1) {
            this.mrender_content = r1;
            return this;
        }

        public Builder template_name(String r1) {
            this.mtemplate_name = r1;
            return this;
        }
    }

    public static final enum CardType extends Enum<CardType> implements WireEnum {
        private static final /* synthetic */ CardType[] $VALUES = null;
        public static final ProtoAdapter<CardType> ADAPTER = null;
        public static final CardType ASL_LYNX = null;
        public static final CardType BLOCK = null;
        private final int value;

        static {
            CardType r0 = new CardType("ASL_LYNX", 0, 0);
            ASL_LYNX = r0;
            CardType r1 = new CardType("BLOCK", 1, 1);
            BLOCK = r1;
            $VALUES = new CardType[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(CardType.class);
        }

        public static CardType[] values() {
            return (CardType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static CardType fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return BLOCK;
        L10:
            return ASL_LYNX;
        }

        public static CardType valueOf(String r1) {
            return (CardType) a.a(CardType.class, r1);
        }

        private CardType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_CustomizationMeta extends ProtoAdapter<CustomizationMeta> {
        public ProtoAdapter_CustomizationMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomizationMeta.class);
        }

        public CustomizationMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mrender_content = "";
            r0.mdata_source_id = "";
            r0.mtemplate_name = "";
            r0.mneed_sticky_post = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L18;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r0.mcard_type = (CardType) CardType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mneed_sticky_post = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L12:
            r0.mtemplate_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.mdata_source_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.mrender_content = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L16:
            r9.endMessage(r1);
            return r0.m2576build();
        }

        public int encodedSize(CustomizationMeta r6) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r6.mid);
            String r2 = r6.mrender_content;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r7 = r6.mdata_source_id;
            if (r7 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(3, r7);
        L10:
            int r9 = r5 + r8;
            String r10 = r6.mtemplate_name;
            if (r10 == null) goto L13;
            int r11 = r0.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            CardType r13 = r6.mcard_type;
            if (r13 == null) goto L17;
            int r14 = CardType.ADAPTER.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            Boolean r16 = r6.mneed_sticky_post;
            if (r16 == null) goto L22;
            r3 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r16);
        L22:
            return (r15 + r3) + r6.unknownFields().size();
        L17:
            r14 = 0;
            goto L18
        L13:
            r11 = 0;
            goto L14
        L9:
            r8 = 0;
            goto L10
        L5:
            r4 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2577decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CustomizationMeta) r1);
        }

        public void encode(ProtoWriter r4, CustomizationMeta r5) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 1, r5.mid);
            String r1 = r5.mrender_content;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 2, r1);
        L5:
            String r2 = r5.mdata_source_id;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r4, 3, r2);
        L8:
            String r3 = r5.mtemplate_name;
            if (r3 == null) goto L11;
            r0.encodeWithTag(r4, 4, r3);
        L11:
            CardType r6 = r5.mcard_type;
            if (r6 == null) goto L14;
            CardType.ADAPTER.encodeWithTag(r4, 5, r6);
        L14:
            Boolean r7 = r5.mneed_sticky_post;
            if (r7 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r7);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CustomizationMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomizationMeta();
        DEFAULT_NEED_STICKY_POST = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2575newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mrender_content = this.mrender_content;
        r0.mdata_source_id = this.mdata_source_id;
        r0.mtemplate_name = this.mtemplate_name;
        r0.mcard_type = this.mcard_type;
        r0.mneed_sticky_post = this.mneed_sticky_post;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CustomizationMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2575newBuilder();
    }

    public CustomizationMeta(String r9, String r10, String r11, String r12, CardType r13, Boolean r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public CustomizationMeta(String r2, String r3, String r4, String r5, CardType r6, Boolean r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mid = r2;
        this.mrender_content = r3;
        this.mdata_source_id = r4;
        this.mtemplate_name = r5;
        this.mcard_type = r6;
        this.mneed_sticky_post = r7;
    }
}
