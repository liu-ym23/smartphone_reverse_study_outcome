package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.AppStatusInfo;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class AppMeta extends Message<AppMeta, Builder> {
    public static final ProtoAdapter<AppMeta> ADAPTER = null;
    public static final String DEFAULT_APP_STORE_URL = "";
    public static final String DEFAULT_APP_URL = "";
    public static final String DEFAULT_BOT_ID = "";
    public static final String DEFAULT_CLI_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_AVAILABLE = null;
    private static final long serialVersionUID = 0;
    public final List<AppStatusInfo.FeatureAbility> mapp_ability;
    public final AppExtTag mapp_ext_tag;
    public final List<AppShortcutEntity> mapp_shortcut_entities;
    public final String mapp_store_url;
    public final String mapp_url;
    public final String mbot_id;
    public final String mcli_id;
    public final String mid;
    public final Boolean mis_available;
    public final AppStatusInfo.AppUsageStatus mstatus;

    public static final class AppExtTag extends Message<AppExtTag, Builder> {
        public static final ProtoAdapter<AppExtTag> ADAPTER = null;
        public static final Boolean DEFAULT_IS_AGENT = null;
        private static final long serialVersionUID = 0;
        public final Boolean mis_agent;

        public static final class Builder extends Message.Builder<AppExtTag, Builder> {
            public Boolean mis_agent;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AppExtTag m2508build() {
                return new AppExtTag(this.mis_agent, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2508build();
            }

            public Builder is_agent(Boolean r1) {
                this.mis_agent = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_AppExtTag extends ProtoAdapter<AppExtTag> {
            public ProtoAdapter_AppExtTag() {
                super(FieldEncoding.LENGTH_DELIMITED, AppExtTag.class);
            }

            public AppExtTag decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mis_agent = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mis_agent = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2508build();
            }

            public int encodedSize(AppExtTag r4) {
                Boolean r0 = r4.mis_agent;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2509decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AppExtTag) r1);
            }

            public void encode(ProtoWriter r4, AppExtTag r5) throws IOException {
                Boolean r0 = r5.mis_agent;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AppExtTag) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AppExtTag();
            DEFAULT_IS_AGENT = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2507newBuilder() {
            Builder r0 = new Builder();
            r0.mis_agent = this.mis_agent;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AppExtTag.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2507newBuilder();
        }

        public AppExtTag(Boolean r2) {
            this(r2, ByteString.EMPTY);
        }

        public AppExtTag(Boolean r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mis_agent = r2;
        }
    }

    public static final class AppShortcutEntity extends Message<AppShortcutEntity, Builder> {
        public static final ProtoAdapter<AppShortcutEntity> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<AppShortcutItem> mAndroidShortcutItems;
        public final List<AppShortcutItem> mIOSShortcutItems;
        public final List<AppShortcutItem> mPCShortcutItems;

        public static final class Builder extends Message.Builder<AppShortcutEntity, Builder> {
            public List<AppShortcutItem> mAndroidShortcutItems;
            public List<AppShortcutItem> mIOSShortcutItems;
            public List<AppShortcutItem> mPCShortcutItems;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AppShortcutEntity m2511build() {
                return new AppShortcutEntity(this.mPCShortcutItems, this.mIOSShortcutItems, this.mAndroidShortcutItems, super.buildUnknownFields());
            }

            public Builder() {
                this.mPCShortcutItems = Internal.newMutableList();
                this.mIOSShortcutItems = Internal.newMutableList();
                this.mAndroidShortcutItems = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2511build();
            }

            public Builder AndroidShortcutItems(List<AppShortcutItem> r1) {
                Internal.checkElementsNotNull(r1);
                this.mAndroidShortcutItems = r1;
                return this;
            }

            public Builder IOSShortcutItems(List<AppShortcutItem> r1) {
                Internal.checkElementsNotNull(r1);
                this.mIOSShortcutItems = r1;
                return this;
            }

            public Builder PCShortcutItems(List<AppShortcutItem> r1) {
                Internal.checkElementsNotNull(r1);
                this.mPCShortcutItems = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_AppShortcutEntity extends ProtoAdapter<AppShortcutEntity> {
            public ProtoAdapter_AppShortcutEntity() {
                super(FieldEncoding.LENGTH_DELIMITED, AppShortcutEntity.class);
            }

            public AppShortcutEntity decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mPCShortcutItems.add((AppShortcutItem) AppShortcutItem.ADAPTER.decode(r7));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mIOSShortcutItems.add((AppShortcutItem) AppShortcutItem.ADAPTER.decode(r7));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mAndroidShortcutItems.add((AppShortcutItem) AppShortcutItem.ADAPTER.decode(r7));
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m2511build();
            }

            public int encodedSize(AppShortcutEntity r6) {
                ProtoAdapter<AppShortcutItem> r0 = AppShortcutItem.ADAPTER;
                return ((r0.asRepeated().encodedSizeWithTag(1, r6.mPCShortcutItems) + r0.asRepeated().encodedSizeWithTag(2, r6.mIOSShortcutItems)) + r0.asRepeated().encodedSizeWithTag(3, r6.mAndroidShortcutItems)) + r6.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2512decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AppShortcutEntity) r1);
            }

            public void encode(ProtoWriter r5, AppShortcutEntity r6) throws IOException {
                ProtoAdapter<AppShortcutItem> r0 = AppShortcutItem.ADAPTER;
                r0.asRepeated().encodeWithTag(r5, 1, r6.mPCShortcutItems);
                r0.asRepeated().encodeWithTag(r5, 2, r6.mIOSShortcutItems);
                r0.asRepeated().encodeWithTag(r5, 3, r6.mAndroidShortcutItems);
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AppShortcutEntity) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AppShortcutEntity();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2510newBuilder() {
            Builder r0 = new Builder();
            r0.mPCShortcutItems = Internal.copyOf("mPCShortcutItems", this.mPCShortcutItems);
            r0.mIOSShortcutItems = Internal.copyOf("mIOSShortcutItems", this.mIOSShortcutItems);
            r0.mAndroidShortcutItems = Internal.copyOf("mAndroidShortcutItems", this.mAndroidShortcutItems);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AppShortcutEntity.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2510newBuilder();
        }

        public AppShortcutEntity(List<AppShortcutItem> r2, List<AppShortcutItem> r3, List<AppShortcutItem> r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public AppShortcutEntity(List<AppShortcutItem> r2, List<AppShortcutItem> r3, List<AppShortcutItem> r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mPCShortcutItems = Internal.immutableCopyOf("mPCShortcutItems", r2);
            this.mIOSShortcutItems = Internal.immutableCopyOf("mIOSShortcutItems", r3);
            this.mAndroidShortcutItems = Internal.immutableCopyOf("mAndroidShortcutItems", r4);
        }
    }

    public static final class AppShortcutItem extends Message<AppShortcutItem, Builder> {
        public static final ProtoAdapter<AppShortcutItem> ADAPTER = null;
        public static final String DEFAULT_APP_LINK = "";
        public static final String DEFAULT_NAME = "";
        private static final long serialVersionUID = 0;
        public final String mapp_link;
        public final String mname;

        public static final class Builder extends Message.Builder<AppShortcutItem, Builder> {
            public String mapp_link;
            public String mname;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AppShortcutItem m2514build() {
                String r0 = this.mname;
                if (r0 == null) goto L9;
                if (this.mapp_link == null) goto L9;
                return new AppShortcutItem(this.mname, this.mapp_link, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r0, "mname", this.mapp_link, "mapp_link"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2514build();
            }

            public Builder app_link(String r1) {
                this.mapp_link = r1;
                return this;
            }

            public Builder name(String r1) {
                this.mname = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_AppShortcutItem extends ProtoAdapter<AppShortcutItem> {
            public ProtoAdapter_AppShortcutItem() {
                super(FieldEncoding.LENGTH_DELIMITED, AppShortcutItem.class);
            }

            public AppShortcutItem decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mname = "";
                r0.mapp_link = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mname = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mapp_link = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2514build();
            }

            public int encodedSize(AppShortcutItem r5) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                return (r0.encodedSizeWithTag(1, r5.mname) + r0.encodedSizeWithTag(2, r5.mapp_link)) + r5.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2515decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AppShortcutItem) r1);
            }

            public void encode(ProtoWriter r4, AppShortcutItem r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r4, 1, r5.mname);
                r0.encodeWithTag(r4, 2, r5.mapp_link);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AppShortcutItem) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AppShortcutItem();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2513newBuilder() {
            Builder r0 = new Builder();
            r0.mname = this.mname;
            r0.mapp_link = this.mapp_link;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AppShortcutItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2513newBuilder();
        }

        public AppShortcutItem(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public AppShortcutItem(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mname = r2;
            this.mapp_link = r3;
        }
    }

    public static final class Builder extends Message.Builder<AppMeta, Builder> {
        public List<AppStatusInfo.FeatureAbility> mapp_ability;
        public AppExtTag mapp_ext_tag;
        public List<AppShortcutEntity> mapp_shortcut_entities;
        public String mapp_store_url;
        public String mapp_url;
        public String mbot_id;
        public String mcli_id;
        public String mid;
        public Boolean mis_available;
        public AppStatusInfo.AppUsageStatus mstatus;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public AppMeta m2516build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new AppMeta(this.mid, this.mapp_store_url, this.mis_available, this.mstatus, this.mapp_ability, this.mbot_id, this.mapp_url, this.mcli_id, this.mapp_shortcut_entities, this.mapp_ext_tag, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
            this.mapp_ability = Internal.newMutableList();
            this.mapp_shortcut_entities = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2516build();
        }

        public Builder app_ability(List<AppStatusInfo.FeatureAbility> r1) {
            Internal.checkElementsNotNull(r1);
            this.mapp_ability = r1;
            return this;
        }

        public Builder app_ext_tag(AppExtTag r1) {
            this.mapp_ext_tag = r1;
            return this;
        }

        public Builder app_shortcut_entities(List<AppShortcutEntity> r1) {
            Internal.checkElementsNotNull(r1);
            this.mapp_shortcut_entities = r1;
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

        public Builder bot_id(String r1) {
            this.mbot_id = r1;
            return this;
        }

        public Builder cli_id(String r1) {
            this.mcli_id = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder is_available(Boolean r1) {
            this.mis_available = r1;
            return this;
        }

        public Builder status(AppStatusInfo.AppUsageStatus r1) {
            this.mstatus = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_AppMeta extends ProtoAdapter<AppMeta> {
        public ProtoAdapter_AppMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, AppMeta.class);
        }

        public AppMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mapp_store_url = "";
            r0.mis_available = Boolean.FALSE;
            r0.mbot_id = "";
            r0.mapp_url = "";
            r0.mcli_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L23;
            switch(r3) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L25;
                case 5: goto L27;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L25:
            r0.mstatus = (AppStatusInfo.AppUsageStatus) AppStatusInfo.AppUsageStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L27:
            r0.mapp_ability.add((AppStatusInfo.FeatureAbility) AppStatusInfo.FeatureAbility.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mapp_ext_tag = (AppExtTag) AppExtTag.ADAPTER.decode(r9);
            goto L3
        L8:
            r0.mapp_shortcut_entities.add((AppShortcutEntity) AppShortcutEntity.ADAPTER.decode(r9));
            goto L3
        L9:
            r0.mcli_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            r0.mapp_url = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            r0.mbot_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L20:
            r0.mis_available = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L21:
            r0.mapp_store_url = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L22:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L23:
            r9.endMessage(r1);
            return r0.m2516build();
        }

        public int encodedSize(AppMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            String r2 = r7.mapp_store_url;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            Boolean r6 = r7.mis_available;
            if (r6 == null) goto L9;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            AppStatusInfo.AppUsageStatus r10 = r7.mstatus;
            if (r10 == null) goto L13;
            int r11 = AppStatusInfo.AppUsageStatus.ADAPTER.encodedSizeWithTag(4, r10);
        L14:
            int r12 = (r9 + r11) + AppStatusInfo.FeatureAbility.ADAPTER.asRepeated().encodedSizeWithTag(5, r7.mapp_ability);
            String r13 = r7.mbot_id;
            if (r13 == null) goto L17;
            int r14 = r0.encodedSizeWithTag(6, r13);
        L18:
            int r15 = r12 + r14;
            String r16 = r7.mapp_url;
            if (r16 == null) goto L21;
            int r17 = r0.encodedSizeWithTag(7, r16);
        L22:
            int r18 = r15 + r17;
            String r19 = r7.mcli_id;
            if (r19 == null) goto L25;
            int r20 = r0.encodedSizeWithTag(8, r19);
        L26:
            int r21 = (r18 + r20) + AppShortcutEntity.ADAPTER.asRepeated().encodedSizeWithTag(9, r7.mapp_shortcut_entities);
            AppExtTag r22 = r7.mapp_ext_tag;
            if (r22 == null) goto L30;
            r3 = AppExtTag.ADAPTER.encodedSizeWithTag(10, r22);
        L30:
            return (r21 + r3) + r7.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2517decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((AppMeta) r1);
        }

        public void encode(ProtoWriter r5, AppMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            String r1 = r6.mapp_store_url;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 2, r1);
        L5:
            Boolean r2 = r6.mis_available;
            if (r2 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r5, 3, r2);
        L8:
            AppStatusInfo.AppUsageStatus r3 = r6.mstatus;
            if (r3 == null) goto L11;
            AppStatusInfo.AppUsageStatus.ADAPTER.encodeWithTag(r5, 4, r3);
        L11:
            AppStatusInfo.FeatureAbility.ADAPTER.asRepeated().encodeWithTag(r5, 5, r6.mapp_ability);
            String r4 = r6.mbot_id;
            if (r4 == null) goto L14;
            r0.encodeWithTag(r5, 6, r4);
        L14:
            String r7 = r6.mapp_url;
            if (r7 == null) goto L17;
            r0.encodeWithTag(r5, 7, r7);
        L17:
            String r8 = r6.mcli_id;
            if (r8 == null) goto L20;
            r0.encodeWithTag(r5, 8, r8);
        L20:
            AppShortcutEntity.ADAPTER.asRepeated().encodeWithTag(r5, 9, r6.mapp_shortcut_entities);
            AppExtTag r9 = r6.mapp_ext_tag;
            if (r9 == null) goto L23;
            AppExtTag.ADAPTER.encodeWithTag(r5, 10, r9);
        L23:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (AppMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppMeta();
        DEFAULT_IS_AVAILABLE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2506newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mapp_store_url = this.mapp_store_url;
        r0.mis_available = this.mis_available;
        r0.mstatus = this.mstatus;
        r0.mapp_ability = Internal.copyOf("mapp_ability", this.mapp_ability);
        r0.mbot_id = this.mbot_id;
        r0.mapp_url = this.mapp_url;
        r0.mcli_id = this.mcli_id;
        r0.mapp_shortcut_entities = Internal.copyOf("mapp_shortcut_entities", this.mapp_shortcut_entities);
        r0.mapp_ext_tag = this.mapp_ext_tag;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return AppMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2506newBuilder();
    }

    public AppMeta(String r13, String r14, Boolean r15, AppStatusInfo.AppUsageStatus r16, List<AppStatusInfo.FeatureAbility> r17, String r18, String r19, String r20, List<AppShortcutEntity> r21, AppExtTag r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public AppMeta(String r2, String r3, Boolean r4, AppStatusInfo.AppUsageStatus r5, List<AppStatusInfo.FeatureAbility> r6, String r7, String r8, String r9, List<AppShortcutEntity> r10, AppExtTag r11, ByteString r12) {
        super(ADAPTER, r12);
        this.mid = r2;
        this.mapp_store_url = r3;
        this.mis_available = r4;
        this.mstatus = r5;
        this.mapp_ability = Internal.immutableCopyOf("mapp_ability", r6);
        this.mbot_id = r7;
        this.mapp_url = r8;
        this.mcli_id = r9;
        this.mapp_shortcut_entities = Internal.immutableCopyOf("mapp_shortcut_entities", r10);
        this.mapp_ext_tag = r11;
    }
}
