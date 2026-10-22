package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AppStatusInfo extends com.squareup.wire.Message<AppStatusInfo, Builder> {
    public static final ProtoAdapter<AppStatusInfo> ADAPTER = null;
    public static final Long DEFAULT_APP_ID = null;
    public static final String DEFAULT_APP_STORE_URL = "";
    public static final String DEFAULT_APP_URL = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final Boolean DEFAULT_CHATABLE = null;
    public static final String DEFAULT_CLI_ID = "";
    public static final String DEFAULT_EXTRA_CONFIG = "";
    public static final Boolean DEFAULT_IS_AVAILABLE = null;
    public static final Boolean DEFAULT_IS_ISV = null;
    private static final long serialVersionUID = 0;
    public final List<FeatureAbility> mapp_ability;
    public final Long mapp_id;
    public final String mapp_store_url;
    public final String mapp_url;
    public final Image mavatar;
    public final String mavatar_key;
    public final List<BotCheckStatus> mbot_list;
    public final BotMenuDisplayStrategy mbot_menu_display_strategy;
    public final Boolean mchatable;
    public final String mcli_id;
    public final List<ExtraHitField> mextraHitFields;
    public final String mextra_config;
    public final Map<String, String> mi18n_descriptions;
    public final Map<String, String> mi18n_names;
    public final Boolean mis_available;
    public final Boolean mis_isv;
    public final AppUsageStatus mstatus;
    public final TipsContent mtips;

    public static final enum AppUsageStatus extends Enum<AppUsageStatus> implements WireEnum {
        private static final /* synthetic */ AppUsageStatus[] $VALUES = null;
        public static final ProtoAdapter<AppUsageStatus> ADAPTER = null;
        public static final AppUsageStatus APP_DELETED = null;
        public static final AppUsageStatus APP_DEVELOPER_FORBIDDEN = null;
        public static final AppUsageStatus APP_NEED_PAY_USE = null;
        public static final AppUsageStatus APP_OFFLINE = null;
        public static final AppUsageStatus APP_PLATFORM_FORBIDDEN = null;
        public static final AppUsageStatus APP_TENANT_FORBIDDEN = null;
        public static final AppUsageStatus APP_USABLE = null;
        public static final AppUsageStatus APP_USER_UNVISIBLE = null;
        private final int value;

        static {
            AppUsageStatus r0 = new AppUsageStatus("APP_USABLE", 0, 1);
            APP_USABLE = r0;
            AppUsageStatus r1 = new AppUsageStatus("APP_TENANT_FORBIDDEN", 1, 2);
            APP_TENANT_FORBIDDEN = r1;
            AppUsageStatus r4 = new AppUsageStatus("APP_PLATFORM_FORBIDDEN", 2, 3);
            APP_PLATFORM_FORBIDDEN = r4;
            AppUsageStatus r6 = new AppUsageStatus("APP_DEVELOPER_FORBIDDEN", 3, 4);
            APP_DEVELOPER_FORBIDDEN = r6;
            AppUsageStatus r8 = new AppUsageStatus("APP_OFFLINE", 4, 5);
            APP_OFFLINE = r8;
            AppUsageStatus r10 = new AppUsageStatus("APP_USER_UNVISIBLE", 5, 6);
            APP_USER_UNVISIBLE = r10;
            AppUsageStatus r12 = new AppUsageStatus("APP_NEED_PAY_USE", 6, 7);
            APP_NEED_PAY_USE = r12;
            AppUsageStatus r14 = new AppUsageStatus("APP_DELETED", 7, 8);
            APP_DELETED = r14;
            $VALUES = new AppUsageStatus[]{r0, r1, r4, r6, r8, r10, r12, r14};
            ADAPTER = ProtoAdapter.newEnumAdapter(AppUsageStatus.class);
        }

        public static AppUsageStatus[] values() {
            return (AppUsageStatus[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AppUsageStatus fromValue(int r0) {
            switch(r0) {
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L12;
                case 6: goto L10;
                case 7: goto L8;
                case 8: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return APP_DELETED;
        L8:
            return APP_NEED_PAY_USE;
        L10:
            return APP_USER_UNVISIBLE;
        L12:
            return APP_OFFLINE;
        L14:
            return APP_DEVELOPER_FORBIDDEN;
        L16:
            return APP_PLATFORM_FORBIDDEN;
        L18:
            return APP_TENANT_FORBIDDEN;
        L20:
            return APP_USABLE;
        }

        public static AppUsageStatus valueOf(String r1) {
            return (AppUsageStatus) a.a(AppUsageStatus.class, r1);
        }

        private AppUsageStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum BotMenuDisplayStrategy extends Enum<BotMenuDisplayStrategy> implements WireEnum {
        private static final /* synthetic */ BotMenuDisplayStrategy[] $VALUES = null;
        public static final ProtoAdapter<BotMenuDisplayStrategy> ADAPTER = null;
        public static final BotMenuDisplayStrategy CHAT_INPUT = null;
        public static final BotMenuDisplayStrategy CHAT_MENU = null;
        public static final BotMenuDisplayStrategy FLOATING = null;
        public static final BotMenuDisplayStrategy UNKNOWN = null;
        private final int value;

        static {
            BotMenuDisplayStrategy r0 = new BotMenuDisplayStrategy("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            BotMenuDisplayStrategy r1 = new BotMenuDisplayStrategy("CHAT_MENU", 1, 1);
            CHAT_MENU = r1;
            BotMenuDisplayStrategy r3 = new BotMenuDisplayStrategy("CHAT_INPUT", 2, 2);
            CHAT_INPUT = r3;
            BotMenuDisplayStrategy r5 = new BotMenuDisplayStrategy("FLOATING", 3, 3);
            FLOATING = r5;
            $VALUES = new BotMenuDisplayStrategy[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(BotMenuDisplayStrategy.class);
        }

        public static BotMenuDisplayStrategy[] values() {
            return (BotMenuDisplayStrategy[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static BotMenuDisplayStrategy fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return FLOATING;
        L14:
            return CHAT_INPUT;
        L16:
            return CHAT_MENU;
        L18:
            return UNKNOWN;
        }

        public static BotMenuDisplayStrategy valueOf(String r1) {
            return (BotMenuDisplayStrategy) a.a(BotMenuDisplayStrategy.class, r1);
        }

        private BotMenuDisplayStrategy(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<AppStatusInfo, Builder> {
        public List<FeatureAbility> mapp_ability;
        public Long mapp_id;
        public String mapp_store_url;
        public String mapp_url;
        public Image mavatar;
        public String mavatar_key;
        public List<BotCheckStatus> mbot_list;
        public BotMenuDisplayStrategy mbot_menu_display_strategy;
        public Boolean mchatable;
        public String mcli_id;
        public List<ExtraHitField> mextraHitFields;
        public String mextra_config;
        public Map<String, String> mi18n_descriptions;
        public Map<String, String> mi18n_names;
        public Boolean mis_available;
        public Boolean mis_isv;
        public AppUsageStatus mstatus;
        public TipsContent mtips;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AppStatusInfo m1007build() {
            return new AppStatusInfo(this.mcli_id, this.mstatus, this.mtips, this.mbot_list, this.mapp_ability, this.mapp_url, this.mi18n_names, this.mi18n_descriptions, this.mavatar_key, this.mapp_id, this.mchatable, this.mextra_config, this.mavatar, this.mapp_store_url, this.mis_isv, this.mis_available, this.mextraHitFields, this.mbot_menu_display_strategy, super.buildUnknownFields());
        }

        public Builder() {
            this.mbot_list = Internal.newMutableList();
            this.mapp_ability = Internal.newMutableList();
            this.mi18n_names = Internal.newMutableMap();
            this.mi18n_descriptions = Internal.newMutableMap();
            this.mextraHitFields = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1007build();
        }

        public Builder app_ability(List<FeatureAbility> r1) {
            Internal.checkElementsNotNull(r1);
            this.mapp_ability = r1;
            return this;
        }

        public Builder app_id(Long r1) {
            this.mapp_id = r1;
            return this;
        }

        public Builder app_store_url(String r1) {
            this.mapp_store_url = r1;
            return this;
        }

        public Builder app_url(String r1) {
            this.mapp_url = r1;
            return this;
        }

        public Builder avatar(Image r1) {
            this.mavatar = r1;
            return this;
        }

        public Builder avatar_key(String r1) {
            this.mavatar_key = r1;
            return this;
        }

        public Builder bot_list(List<BotCheckStatus> r1) {
            Internal.checkElementsNotNull(r1);
            this.mbot_list = r1;
            return this;
        }

        public Builder bot_menu_display_strategy(BotMenuDisplayStrategy r1) {
            this.mbot_menu_display_strategy = r1;
            return this;
        }

        public Builder chatable(Boolean r1) {
            this.mchatable = r1;
            return this;
        }

        public Builder cli_id(String r1) {
            this.mcli_id = r1;
            return this;
        }

        public Builder extraHitFields(List<ExtraHitField> r1) {
            Internal.checkElementsNotNull(r1);
            this.mextraHitFields = r1;
            return this;
        }

        public Builder extra_config(String r1) {
            this.mextra_config = r1;
            return this;
        }

        public Builder i18n_descriptions(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_descriptions = r1;
            return this;
        }

        public Builder i18n_names(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_names = r1;
            return this;
        }

        public Builder is_available(Boolean r1) {
            this.mis_available = r1;
            return this;
        }

        public Builder is_isv(Boolean r1) {
            this.mis_isv = r1;
            return this;
        }

        public Builder status(AppUsageStatus r1) {
            this.mstatus = r1;
            return this;
        }

        public Builder tips(TipsContent r1) {
            this.mtips = r1;
            return this;
        }
    }

    public static final enum FeatureAbility extends Enum<FeatureAbility> implements WireEnum {
        private static final /* synthetic */ FeatureAbility[] $VALUES = null;
        public static final ProtoAdapter<FeatureAbility> ADAPTER = null;
        public static final FeatureAbility BOT = null;
        public static final FeatureAbility H5 = null;
        public static final FeatureAbility LOCAL_COMPONENT = null;
        public static final FeatureAbility SMALL = null;
        private final int value;

        static {
            FeatureAbility r0 = new FeatureAbility("SMALL", 0, 1);
            SMALL = r0;
            FeatureAbility r1 = new FeatureAbility("H5", 1, 2);
            H5 = r1;
            FeatureAbility r4 = new FeatureAbility("BOT", 2, 3);
            BOT = r4;
            FeatureAbility r6 = new FeatureAbility("LOCAL_COMPONENT", 3, 4);
            LOCAL_COMPONENT = r6;
            $VALUES = new FeatureAbility[]{r0, r1, r4, r6};
            ADAPTER = ProtoAdapter.newEnumAdapter(FeatureAbility.class);
        }

        public static FeatureAbility[] values() {
            return (FeatureAbility[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FeatureAbility fromValue(int r1) {
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L17;
            if (r1 == 3) goto L15;
            if (r1 == 4) goto L13;
            return null;
        L13:
            return LOCAL_COMPONENT;
        L15:
            return BOT;
        L17:
            return H5;
        L19:
            return SMALL;
        }

        public static FeatureAbility valueOf(String r1) {
            return (FeatureAbility) a.a(FeatureAbility.class, r1);
        }

        private FeatureAbility(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_AppStatusInfo extends ProtoAdapter<AppStatusInfo> {
        private final ProtoAdapter<Map<String, String>> mi18n_descriptions;
        private final ProtoAdapter<Map<String, String>> mi18n_names;

        public ProtoAdapter_AppStatusInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, AppStatusInfo.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mi18n_names = ProtoAdapter.newMapAdapter(r0, r0);
            this.mi18n_descriptions = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public AppStatusInfo decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mcli_id = "";
            r0.mapp_url = "";
            r0.mavatar_key = "";
            r0.mapp_id = 0L;
            Boolean r2 = Boolean.FALSE;
            r0.mchatable = r2;
            r0.mextra_config = "";
            r0.mapp_store_url = "";
            r0.mis_isv = r2;
            r0.mis_available = r2;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L34;
            switch(r3) {
                case 1: goto L33;
                case 2: goto L36;
                case 3: goto L28;
                case 4: goto L27;
                case 5: goto L38;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L17;
                case 12: goto L16;
                case 13: goto L15;
                case 14: goto L14;
                case 15: goto L13;
                case 16: goto L12;
                case 17: goto L11;
                case 18: goto L40;
                default: goto L6;
            };
        L36:
            r0.mstatus = (AppUsageStatus) AppUsageStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L31
        L31:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L38:
            r0.mapp_ability.add((FeatureAbility) FeatureAbility.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L40:
            r0.mbot_menu_display_strategy = (BotMenuDisplayStrategy) BotMenuDisplayStrategy.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r0.mextraHitFields.add((ExtraHitField) ExtraHitField.ADAPTER.decode(r9));
            goto L3
        L12:
            r0.mis_available = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L13:
            r0.mis_isv = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L14:
            r0.mapp_store_url = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mavatar = (Image) Image.ADAPTER.decode(r9);
            goto L3
        L16:
            r0.mextra_config = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L17:
            r0.mchatable = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L18:
            r0.mapp_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L19:
            r0.mavatar_key = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L20:
            r0.mi18n_descriptions.putAll((Map) this.mi18n_descriptions.decode(r9));
            goto L3
        L21:
            r0.mi18n_names.putAll((Map) this.mi18n_names.decode(r9));
            goto L3
        L22:
            r0.mapp_url = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L27:
            r0.mbot_list.add((BotCheckStatus) BotCheckStatus.ADAPTER.decode(r9));
            goto L3
        L28:
            r0.mtips = (TipsContent) TipsContent.ADAPTER.decode(r9);
            goto L3
        L33:
            r0.mcli_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L34:
            r9.endMessage(r1);
            return r0.m1007build();
        }

        public int encodedSize(AppStatusInfo r6) {
            String r0 = r6.mcli_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            AppUsageStatus r3 = r6.mstatus;
            if (r3 == null) goto L9;
            int r4 = AppUsageStatus.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            TipsContent r7 = r6.mtips;
            if (r7 == null) goto L13;
            int r8 = TipsContent.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = ((r5 + r8) + BotCheckStatus.ADAPTER.asRepeated().encodedSizeWithTag(4, r6.mbot_list)) + FeatureAbility.ADAPTER.asRepeated().encodedSizeWithTag(5, r6.mapp_ability);
            String r10 = r6.mapp_url;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(6, r10);
        L18:
            int r12 = ((r9 + r11) + this.mi18n_names.encodedSizeWithTag(7, r6.mi18n_names)) + this.mi18n_descriptions.encodedSizeWithTag(8, r6.mi18n_descriptions);
            String r13 = r6.mavatar_key;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(9, r13);
        L22:
            int r15 = r12 + r14;
            Long r16 = r6.mapp_id;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.INT64.encodedSizeWithTag(10, r16);
        L26:
            int r18 = r15 + r17;
            Boolean r19 = r6.mchatable;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r6.mextra_config;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(12, r22);
        L34:
            int r24 = r21 + r23;
            Image r25 = r6.mavatar;
            if (r25 == null) goto L37;
            int r26 = Image.ADAPTER.encodedSizeWithTag(13, r25);
        L38:
            int r27 = r24 + r26;
            String r28 = r6.mapp_store_url;
            if (r28 == null) goto L41;
            int r29 = ProtoAdapter.STRING.encodedSizeWithTag(14, r28);
        L42:
            int r30 = r27 + r29;
            Boolean r31 = r6.mis_isv;
            if (r31 == null) goto L45;
            int r32 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r31);
        L46:
            int r33 = r30 + r32;
            Boolean r34 = r6.mis_available;
            if (r34 == null) goto L49;
            int r35 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r34);
        L50:
            int r36 = (r33 + r35) + ExtraHitField.ADAPTER.asRepeated().encodedSizeWithTag(17, r6.mextraHitFields);
            BotMenuDisplayStrategy r37 = r6.mbot_menu_display_strategy;
            if (r37 == null) goto L54;
            r1 = BotMenuDisplayStrategy.ADAPTER.encodedSizeWithTag(18, r37);
        L54:
            return (r36 + r1) + r6.unknownFields().size();
        L49:
            r35 = 0;
            goto L50
        L45:
            r32 = 0;
            goto L46
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
        public /* bridge */ /* synthetic */ Object m1008decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AppStatusInfo) r1);
        }

        public void encode(ProtoWriter r4, AppStatusInfo r5) throws IOException {
            String r0 = r5.mcli_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            AppUsageStatus r1 = r5.mstatus;
            if (r1 == null) goto L8;
            AppUsageStatus.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            TipsContent r2 = r5.mtips;
            if (r2 == null) goto L11;
            TipsContent.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            BotCheckStatus.ADAPTER.asRepeated().encodeWithTag(r4, 4, r5.mbot_list);
            FeatureAbility.ADAPTER.asRepeated().encodeWithTag(r4, 5, r5.mapp_ability);
            String r3 = r5.mapp_url;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r3);
        L14:
            this.mi18n_names.encodeWithTag(r4, 7, r5.mi18n_names);
            this.mi18n_descriptions.encodeWithTag(r4, 8, r5.mi18n_descriptions);
            String r6 = r5.mavatar_key;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 9, r6);
        L17:
            Long r7 = r5.mapp_id;
            if (r7 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r4, 10, r7);
        L20:
            Boolean r8 = r5.mchatable;
            if (r8 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r4, 11, r8);
        L23:
            String r9 = r5.mextra_config;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r4, 12, r9);
        L26:
            Image r10 = r5.mavatar;
            if (r10 == null) goto L29;
            Image.ADAPTER.encodeWithTag(r4, 13, r10);
        L29:
            String r11 = r5.mapp_store_url;
            if (r11 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r4, 14, r11);
        L32:
            Boolean r12 = r5.mis_isv;
            if (r12 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r4, 15, r12);
        L35:
            Boolean r13 = r5.mis_available;
            if (r13 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r4, 16, r13);
        L38:
            ExtraHitField.ADAPTER.asRepeated().encodeWithTag(r4, 17, r5.mextraHitFields);
            BotMenuDisplayStrategy r14 = r5.mbot_menu_display_strategy;
            if (r14 == null) goto L41;
            BotMenuDisplayStrategy.ADAPTER.encodeWithTag(r4, 18, r14);
        L41:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AppStatusInfo) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppStatusInfo();
        DEFAULT_APP_ID = 0L;
        Boolean r0 = Boolean.FALSE;
        DEFAULT_CHATABLE = r0;
        DEFAULT_IS_ISV = r0;
        DEFAULT_IS_AVAILABLE = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1006newBuilder() {
        Builder r0 = new Builder();
        r0.mcli_id = this.mcli_id;
        r0.mstatus = this.mstatus;
        r0.mtips = this.mtips;
        r0.mbot_list = Internal.copyOf("mbot_list", this.mbot_list);
        r0.mapp_ability = Internal.copyOf("mapp_ability", this.mapp_ability);
        r0.mapp_url = this.mapp_url;
        r0.mi18n_names = Internal.copyOf("mi18n_names", this.mi18n_names);
        r0.mi18n_descriptions = Internal.copyOf("mi18n_descriptions", this.mi18n_descriptions);
        r0.mavatar_key = this.mavatar_key;
        r0.mapp_id = this.mapp_id;
        r0.mchatable = this.mchatable;
        r0.mextra_config = this.mextra_config;
        r0.mavatar = this.mavatar;
        r0.mapp_store_url = this.mapp_store_url;
        r0.mis_isv = this.mis_isv;
        r0.mis_available = this.mis_available;
        r0.mextraHitFields = Internal.copyOf("mextraHitFields", this.mextraHitFields);
        r0.mbot_menu_display_strategy = this.mbot_menu_display_strategy;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AppStatusInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1006newBuilder();
    }

    public AppStatusInfo(String r21, AppUsageStatus r22, TipsContent r23, List<BotCheckStatus> r24, List<FeatureAbility> r25, String r26, Map<String, String> r27, Map<String, String> r28, String r29, Long r30, Boolean r31, String r32, Image r33, String r34, Boolean r35, Boolean r36, List<ExtraHitField> r37, BotMenuDisplayStrategy r38) {
        this(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, ByteString.EMPTY);
    }

    public AppStatusInfo(String r4, AppUsageStatus r5, TipsContent r6, List<BotCheckStatus> r7, List<FeatureAbility> r8, String r9, Map<String, String> r10, Map<String, String> r11, String r12, Long r13, Boolean r14, String r15, Image r16, String r17, Boolean r18, Boolean r19, List<ExtraHitField> r20, BotMenuDisplayStrategy r21, ByteString r22) {
        super(ADAPTER, r22);
        this.mcli_id = r4;
        this.mstatus = r5;
        this.mtips = r6;
        this.mbot_list = Internal.immutableCopyOf("mbot_list", r7);
        this.mapp_ability = Internal.immutableCopyOf("mapp_ability", r8);
        this.mapp_url = r9;
        this.mi18n_names = Internal.immutableCopyOf("mi18n_names", r10);
        this.mi18n_descriptions = Internal.immutableCopyOf("mi18n_descriptions", r11);
        this.mavatar_key = r12;
        this.mapp_id = r13;
        this.mchatable = r14;
        this.mextra_config = r15;
        this.mavatar = r16;
        this.mapp_store_url = r17;
        this.mis_isv = r18;
        this.mis_available = r19;
        this.mextraHitFields = Internal.immutableCopyOf("mextraHitFields", r20);
        this.mbot_menu_display_strategy = r21;
    }
}
