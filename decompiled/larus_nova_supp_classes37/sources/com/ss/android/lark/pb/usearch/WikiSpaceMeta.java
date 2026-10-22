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
public final class WikiSpaceMeta extends Message<WikiSpaceMeta, Builder> {
    public static final ProtoAdapter<WikiSpaceMeta> ADAPTER = null;
    public static final String DEFAULT_COVER_COLOR_VALUE = "";
    public static final Boolean DEFAULT_COVER_IS_GRAPH_DARK = null;
    public static final String DEFAULT_COVER_KEY = "";
    public static final String DEFAULT_COVER_ORIGIN = "";
    public static final String DEFAULT_COVER_THUMBNAIL = "";
    public static final Long DEFAULT_CREATE_TENANT_ID = null;
    public static final Long DEFAULT_CREATE_UID = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final Boolean DEFAULT_IS_STAR = null;
    public static final Integer DEFAULT_MEMBER_COUNT = null;
    public static final Integer DEFAULT_NODE_COUNT = null;
    public static final String DEFAULT_PAY_AMOUNT = "";
    public static final String DEFAULT_ROOT_TOKEN = "";
    public static final String DEFAULT_SPACE_ID = "";
    public static final String DEFAULT_SPACE_NAME = "";
    private static final long serialVersionUID = 0;
    public final String mcover_color_value;
    public final Boolean mcover_is_graph_dark;
    public final String mcover_key;
    public final String mcover_origin;
    public final String mcover_thumbnail;
    public final Long mcreate_tenant_id;
    public final Long mcreate_uid;
    public final String mdescription;
    public final DisplayCreateInfo mdisplay_create_info;
    public final Boolean mis_star;
    public final Integer mmember_count;
    public final Integer mnode_count;
    public final String mpay_amount;
    public final PaymentType mpayment_type;
    public final String mroot_token;
    public final String mspace_id;
    public final String mspace_name;
    public final SpaceScope mwiki_scope;
    public final SpaceType mwiki_space_type;

    public static final class Builder extends Message.Builder<WikiSpaceMeta, Builder> {
        public String mcover_color_value;
        public Boolean mcover_is_graph_dark;
        public String mcover_key;
        public String mcover_origin;
        public String mcover_thumbnail;
        public Long mcreate_tenant_id;
        public Long mcreate_uid;
        public String mdescription;
        public DisplayCreateInfo mdisplay_create_info;
        public Boolean mis_star;
        public Integer mmember_count;
        public Integer mnode_count;
        public String mpay_amount;
        public PaymentType mpayment_type;
        public String mroot_token;
        public String mspace_id;
        public String mspace_name;
        public SpaceScope mwiki_scope;
        public SpaceType mwiki_space_type;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public WikiSpaceMeta m2981build() {
            String r1 = this.mspace_id;
            if (r1 == null) goto L7;
            return new WikiSpaceMeta(this.mspace_id, this.mspace_name, this.mdescription, this.mis_star, this.mwiki_space_type, this.mwiki_scope, this.mroot_token, this.mcover_color_value, this.mcover_is_graph_dark, this.mcover_key, this.mcover_origin, this.mcover_thumbnail, this.mmember_count, this.mnode_count, this.mcreate_uid, this.mcreate_tenant_id, this.mdisplay_create_info, this.mpayment_type, this.mpay_amount, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r1, "mspace_id"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2981build();
        }

        public Builder cover_color_value(String r1) {
            this.mcover_color_value = r1;
            return this;
        }

        public Builder cover_is_graph_dark(Boolean r1) {
            this.mcover_is_graph_dark = r1;
            return this;
        }

        public Builder cover_key(String r1) {
            this.mcover_key = r1;
            return this;
        }

        public Builder cover_origin(String r1) {
            this.mcover_origin = r1;
            return this;
        }

        public Builder cover_thumbnail(String r1) {
            this.mcover_thumbnail = r1;
            return this;
        }

        public Builder create_tenant_id(Long r1) {
            this.mcreate_tenant_id = r1;
            return this;
        }

        public Builder create_uid(Long r1) {
            this.mcreate_uid = r1;
            return this;
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder display_create_info(DisplayCreateInfo r1) {
            this.mdisplay_create_info = r1;
            return this;
        }

        public Builder is_star(Boolean r1) {
            this.mis_star = r1;
            return this;
        }

        public Builder member_count(Integer r1) {
            this.mmember_count = r1;
            return this;
        }

        public Builder node_count(Integer r1) {
            this.mnode_count = r1;
            return this;
        }

        public Builder pay_amount(String r1) {
            this.mpay_amount = r1;
            return this;
        }

        public Builder payment_type(PaymentType r1) {
            this.mpayment_type = r1;
            return this;
        }

        public Builder root_token(String r1) {
            this.mroot_token = r1;
            return this;
        }

        public Builder space_id(String r1) {
            this.mspace_id = r1;
            return this;
        }

        public Builder space_name(String r1) {
            this.mspace_name = r1;
            return this;
        }

        public Builder wiki_scope(SpaceScope r1) {
            this.mwiki_scope = r1;
            return this;
        }

        public Builder wiki_space_type(SpaceType r1) {
            this.mwiki_space_type = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_WikiSpaceMeta extends ProtoAdapter<WikiSpaceMeta> {
        public ProtoAdapter_WikiSpaceMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, WikiSpaceMeta.class);
        }

        public WikiSpaceMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mspace_id = "";
            r0.mspace_name = "";
            r0.mdescription = "";
            Boolean r2 = Boolean.FALSE;
            r0.mis_star = r2;
            r0.mroot_token = "";
            r0.mcover_color_value = "";
            r0.mcover_is_graph_dark = r2;
            r0.mcover_key = "";
            r0.mcover_origin = "";
            r0.mcover_thumbnail = "";
            r0.mmember_count = 0;
            r0.mnode_count = 0;
            r0.mcreate_uid = 0L;
            r0.mcreate_tenant_id = 0L;
            r0.mpay_amount = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L35;
            switch(r3) {
                case 1: goto L34;
                case 2: goto L33;
                case 3: goto L32;
                case 4: goto L31;
                case 5: goto L41;
                case 6: goto L37;
                case 7: goto L22;
                case 8: goto L21;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L18;
                case 12: goto L17;
                case 13: goto L16;
                case 14: goto L15;
                case 15: goto L14;
                case 16: goto L13;
                case 17: goto L12;
                case 18: goto L39;
                case 19: goto L7;
                default: goto L6;
            };
        L37:
            r0.mwiki_scope = (SpaceScope) SpaceScope.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L39:
            r0.mpayment_type = (PaymentType) PaymentType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L41:
            r0.mwiki_space_type = (SpaceType) SpaceType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mpay_amount = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            r0.mdisplay_create_info = (DisplayCreateInfo) DisplayCreateInfo.ADAPTER.decode(r9);
            goto L3
        L13:
            r0.mcreate_tenant_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L14:
            r0.mcreate_uid = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L15:
            r0.mnode_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L16:
            r0.mmember_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L17:
            r0.mcover_thumbnail = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L18:
            r0.mcover_origin = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L19:
            r0.mcover_key = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L20:
            r0.mcover_is_graph_dark = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L21:
            r0.mcover_color_value = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L22:
            r0.mroot_token = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L31:
            r0.mis_star = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L32:
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L33:
            r0.mspace_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L34:
            r0.mspace_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L35:
            r9.endMessage(r1);
            return r0.m2981build();
        }

        public int encodedSize(WikiSpaceMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mspace_id);
            String r2 = r7.mspace_name;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.mdescription;
            if (r6 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            Boolean r10 = r7.mis_star;
            if (r10 == null) goto L13;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            SpaceType r13 = r7.mwiki_space_type;
            if (r13 == null) goto L17;
            int r14 = SpaceType.ADAPTER.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            SpaceScope r16 = r7.mwiki_scope;
            if (r16 == null) goto L21;
            int r17 = SpaceScope.ADAPTER.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            String r19 = r7.mroot_token;
            if (r19 == null) goto L25;
            int r20 = r0.encodedSizeWithTag(7, r19);
        L26:
            int r21 = r18 + r20;
            String r22 = r7.mcover_color_value;
            if (r22 == null) goto L29;
            int r23 = r0.encodedSizeWithTag(8, r22);
        L30:
            int r24 = r21 + r23;
            Boolean r25 = r7.mcover_is_graph_dark;
            if (r25 == null) goto L33;
            int r26 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r25);
        L34:
            int r27 = r24 + r26;
            String r28 = r7.mcover_key;
            if (r28 == null) goto L37;
            int r29 = r0.encodedSizeWithTag(10, r28);
        L38:
            int r30 = r27 + r29;
            String r31 = r7.mcover_origin;
            if (r31 == null) goto L41;
            int r32 = r0.encodedSizeWithTag(11, r31);
        L42:
            int r33 = r30 + r32;
            String r34 = r7.mcover_thumbnail;
            if (r34 == null) goto L45;
            int r35 = r0.encodedSizeWithTag(12, r34);
        L46:
            int r36 = r33 + r35;
            Integer r37 = r7.mmember_count;
            if (r37 == null) goto L49;
            int r38 = ProtoAdapter.INT32.encodedSizeWithTag(13, r37);
        L50:
            int r39 = r36 + r38;
            Integer r40 = r7.mnode_count;
            if (r40 == null) goto L53;
            int r41 = ProtoAdapter.INT32.encodedSizeWithTag(14, r40);
        L54:
            int r42 = r39 + r41;
            Long r43 = r7.mcreate_uid;
            if (r43 == null) goto L57;
            int r44 = ProtoAdapter.INT64.encodedSizeWithTag(15, r43);
        L58:
            int r45 = r42 + r44;
            Long r46 = r7.mcreate_tenant_id;
            if (r46 == null) goto L61;
            int r47 = ProtoAdapter.INT64.encodedSizeWithTag(16, r46);
        L62:
            int r48 = r45 + r47;
            DisplayCreateInfo r49 = r7.mdisplay_create_info;
            if (r49 == null) goto L65;
            int r50 = DisplayCreateInfo.ADAPTER.encodedSizeWithTag(17, r49);
        L66:
            int r51 = r48 + r50;
            PaymentType r52 = r7.mpayment_type;
            if (r52 == null) goto L69;
            int r53 = PaymentType.ADAPTER.encodedSizeWithTag(18, r52);
        L70:
            int r54 = r51 + r53;
            String r55 = r7.mpay_amount;
            if (r55 == null) goto L74;
            r3 = r0.encodedSizeWithTag(19, r55);
        L74:
            return (r54 + r3) + r7.unknownFields().size();
        L69:
            r53 = 0;
            goto L70
        L65:
            r50 = 0;
            goto L66
        L61:
            r47 = 0;
            goto L62
        L57:
            r44 = 0;
            goto L58
        L53:
            r41 = 0;
            goto L54
        L49:
            r38 = 0;
            goto L50
        L45:
            r35 = 0;
            goto L46
        L41:
            r32 = 0;
            goto L42
        L37:
            r29 = 0;
            goto L38
        L33:
            r26 = 0;
            goto L34
        L29:
            r23 = 0;
            goto L30
        L25:
            r20 = 0;
            goto L26
        L21:
            r17 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ Object m2982decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((WikiSpaceMeta) r1);
        }

        public void encode(ProtoWriter r5, WikiSpaceMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mspace_id);
            String r1 = r6.mspace_name;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 2, r1);
        L5:
            String r2 = r6.mdescription;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 3, r2);
        L8:
            Boolean r3 = r6.mis_star;
            if (r3 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r5, 4, r3);
        L11:
            SpaceType r4 = r6.mwiki_space_type;
            if (r4 == null) goto L14;
            SpaceType.ADAPTER.encodeWithTag(r5, 5, r4);
        L14:
            SpaceScope r7 = r6.mwiki_scope;
            if (r7 == null) goto L17;
            SpaceScope.ADAPTER.encodeWithTag(r5, 6, r7);
        L17:
            String r8 = r6.mroot_token;
            if (r8 == null) goto L20;
            r0.encodeWithTag(r5, 7, r8);
        L20:
            String r9 = r6.mcover_color_value;
            if (r9 == null) goto L23;
            r0.encodeWithTag(r5, 8, r9);
        L23:
            Boolean r10 = r6.mcover_is_graph_dark;
            if (r10 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r5, 9, r10);
        L26:
            String r11 = r6.mcover_key;
            if (r11 == null) goto L29;
            r0.encodeWithTag(r5, 10, r11);
        L29:
            String r12 = r6.mcover_origin;
            if (r12 == null) goto L32;
            r0.encodeWithTag(r5, 11, r12);
        L32:
            String r13 = r6.mcover_thumbnail;
            if (r13 == null) goto L35;
            r0.encodeWithTag(r5, 12, r13);
        L35:
            Integer r14 = r6.mmember_count;
            if (r14 == null) goto L38;
            ProtoAdapter.INT32.encodeWithTag(r5, 13, r14);
        L38:
            Integer r15 = r6.mnode_count;
            if (r15 == null) goto L41;
            ProtoAdapter.INT32.encodeWithTag(r5, 14, r15);
        L41:
            Long r16 = r6.mcreate_uid;
            if (r16 == null) goto L44;
            ProtoAdapter.INT64.encodeWithTag(r5, 15, r16);
        L44:
            Long r17 = r6.mcreate_tenant_id;
            if (r17 == null) goto L47;
            ProtoAdapter.INT64.encodeWithTag(r5, 16, r17);
        L47:
            DisplayCreateInfo r18 = r6.mdisplay_create_info;
            if (r18 == null) goto L50;
            DisplayCreateInfo.ADAPTER.encodeWithTag(r5, 17, r18);
        L50:
            PaymentType r19 = r6.mpayment_type;
            if (r19 == null) goto L53;
            PaymentType.ADAPTER.encodeWithTag(r5, 18, r19);
        L53:
            String r20 = r6.mpay_amount;
            if (r20 == null) goto L56;
            r0.encodeWithTag(r5, 19, r20);
        L56:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (WikiSpaceMeta) r2);
        }
    }

    public static final enum SpaceScope extends Enum<SpaceScope> implements WireEnum {
        private static final /* synthetic */ SpaceScope[] $VALUES = null;
        public static final ProtoAdapter<SpaceScope> ADAPTER = null;
        public static final SpaceScope PRIVATE = null;
        public static final SpaceScope PUBLIC = null;
        private final int value;

        static {
            SpaceScope r0 = new SpaceScope("PRIVATE", 0, 0);
            PRIVATE = r0;
            SpaceScope r1 = new SpaceScope("PUBLIC", 1, 1);
            PUBLIC = r1;
            $VALUES = new SpaceScope[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(SpaceScope.class);
        }

        public static SpaceScope[] values() {
            return (SpaceScope[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SpaceScope fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return PUBLIC;
        L10:
            return PRIVATE;
        }

        public static SpaceScope valueOf(String r1) {
            return (SpaceScope) a.a(SpaceScope.class, r1);
        }

        private SpaceScope(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum SpaceType extends Enum<SpaceType> implements WireEnum {
        private static final /* synthetic */ SpaceType[] $VALUES = null;
        public static final ProtoAdapter<SpaceType> ADAPTER = null;
        public static final SpaceType MyLibrary = null;
        public static final SpaceType MyLibrary_Resigned = null;
        public static final SpaceType Personal = null;
        public static final SpaceType Team = null;
        private final int value;

        static {
            SpaceType r0 = new SpaceType("Team", 0, 0);
            Team = r0;
            SpaceType r1 = new SpaceType("Personal", 1, 1);
            Personal = r1;
            SpaceType r3 = new SpaceType("MyLibrary", 2, 2);
            MyLibrary = r3;
            SpaceType r5 = new SpaceType("MyLibrary_Resigned", 3, 3);
            MyLibrary_Resigned = r5;
            $VALUES = new SpaceType[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(SpaceType.class);
        }

        public static SpaceType[] values() {
            return (SpaceType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SpaceType fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return MyLibrary_Resigned;
        L14:
            return MyLibrary;
        L16:
            return Personal;
        L18:
            return Team;
        }

        public static SpaceType valueOf(String r1) {
            return (SpaceType) a.a(SpaceType.class, r1);
        }

        private SpaceType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WikiSpaceMeta();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_STAR = r0;
        DEFAULT_COVER_IS_GRAPH_DARK = r0;
        DEFAULT_MEMBER_COUNT = 0;
        DEFAULT_NODE_COUNT = 0;
        DEFAULT_CREATE_UID = 0L;
        DEFAULT_CREATE_TENANT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2980newBuilder() {
        Builder r0 = new Builder();
        r0.mspace_id = this.mspace_id;
        r0.mspace_name = this.mspace_name;
        r0.mdescription = this.mdescription;
        r0.mis_star = this.mis_star;
        r0.mwiki_space_type = this.mwiki_space_type;
        r0.mwiki_scope = this.mwiki_scope;
        r0.mroot_token = this.mroot_token;
        r0.mcover_color_value = this.mcover_color_value;
        r0.mcover_is_graph_dark = this.mcover_is_graph_dark;
        r0.mcover_key = this.mcover_key;
        r0.mcover_origin = this.mcover_origin;
        r0.mcover_thumbnail = this.mcover_thumbnail;
        r0.mmember_count = this.mmember_count;
        r0.mnode_count = this.mnode_count;
        r0.mcreate_uid = this.mcreate_uid;
        r0.mcreate_tenant_id = this.mcreate_tenant_id;
        r0.mdisplay_create_info = this.mdisplay_create_info;
        r0.mpayment_type = this.mpayment_type;
        r0.mpay_amount = this.mpay_amount;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return WikiSpaceMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2980newBuilder();
    }

    public WikiSpaceMeta(String r22, String r23, String r24, Boolean r25, SpaceType r26, SpaceScope r27, String r28, String r29, Boolean r30, String r31, String r32, String r33, Integer r34, Integer r35, Long r36, Long r37, DisplayCreateInfo r38, PaymentType r39, String r40) {
        this(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, ByteString.EMPTY);
    }

    public WikiSpaceMeta(String r4, String r5, String r6, Boolean r7, SpaceType r8, SpaceScope r9, String r10, String r11, Boolean r12, String r13, String r14, String r15, Integer r16, Integer r17, Long r18, Long r19, DisplayCreateInfo r20, PaymentType r21, String r22, ByteString r23) {
        super(ADAPTER, r23);
        this.mspace_id = r4;
        this.mspace_name = r5;
        this.mdescription = r6;
        this.mis_star = r7;
        this.mwiki_space_type = r8;
        this.mwiki_scope = r9;
        this.mroot_token = r10;
        this.mcover_color_value = r11;
        this.mcover_is_graph_dark = r12;
        this.mcover_key = r13;
        this.mcover_origin = r14;
        this.mcover_thumbnail = r15;
        this.mmember_count = r16;
        this.mnode_count = r17;
        this.mcreate_uid = r18;
        this.mcreate_tenant_id = r19;
        this.mdisplay_create_info = r20;
        this.mpayment_type = r21;
        this.mpay_amount = r22;
    }
}
