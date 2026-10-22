package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ChatEntitySetting extends com.squareup.wire.Message<ChatEntitySetting, Builder> {
    public static final ProtoAdapter<ChatEntitySetting> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final AddMemberApplySetting.Enum madd_member_apply_setting;
    public final AddMemberPermissionSetting.Enum madd_member_permission_setting;
    public final AdminPostSetting.Enum madmin_post_setting;
    public final AnonymousSetting manonymous_setting;
    public final AtAllPermissionSetting.Enum mat_all_permission_setting;
    public final ChatDisplayModeSetting.Enum mchat_display_mode_setting;
    public final ChatPinPermissionSetting.Enum mchat_pin_permission_setting;
    public final ChatTabPermissionSetting.Enum mchat_tab_permission_setting;
    public final CreateUrgentSetting.Enum mcreate_urgent_setting;
    public final CreateVideoConferenceSetting.Enum mcreate_video_conference_setting;
    public final SystemMessageVisibleSetting.Enum mjoin_message_visible_setting;
    public final MessageVisibilitySetting.Enum mmessage_visibility_setting;
    public final PinPermissionSetting.Enum mpin_permission_setting;
    public final SystemMessageVisibleSetting.Enum mquit_message_visible_setting;
    public final ShareCardPermissionSetting.Enum mshare_card_permission_setting;
    public final ThreadAnonymousSetting.Enum mthread_anonymous_setting;
    public final TopNoticePermissionSetting.Enum mtop_notice_permission_setting;
    public final UserCountVisibleSetting.Enum muser_count_visible_setting;

    public static final class AddMemberApplySetting extends com.squareup.wire.Message<AddMemberApplySetting, Builder> {
        public static final ProtoAdapter<AddMemberApplySetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AddMemberApplySetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AddMemberApplySetting m1089build() {
                return new AddMemberApplySetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1089build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum NEED_APPLY = null;
            public static final Enum NO_APPLY = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("NO_APPLY", 1, 1);
                NO_APPLY = r1;
                Enum r3 = new Enum("NEED_APPLY", 2, 2);
                NEED_APPLY = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return NEED_APPLY;
            L12:
                return NO_APPLY;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_AddMemberApplySetting extends ProtoAdapter<AddMemberApplySetting> {
            public ProtoAdapter_AddMemberApplySetting() {
                super(FieldEncoding.LENGTH_DELIMITED, AddMemberApplySetting.class);
            }

            public AddMemberApplySetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1089build();
            }

            public int encodedSize(AddMemberApplySetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1090decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AddMemberApplySetting) r1);
            }

            public void encode(ProtoWriter r1, AddMemberApplySetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AddMemberApplySetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AddMemberApplySetting();
        }

        public AddMemberApplySetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1088newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AddMemberApplySetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1088newBuilder();
        }

        public AddMemberApplySetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class AddMemberPermissionSetting extends com.squareup.wire.Message<AddMemberPermissionSetting, Builder> {
        public static final ProtoAdapter<AddMemberPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AddMemberPermissionSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AddMemberPermissionSetting m1092build() {
                return new AddMemberPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1092build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_OWNER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_OWNER", 2, 2);
                ONLY_OWNER = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return ONLY_OWNER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_AddMemberPermissionSetting extends ProtoAdapter<AddMemberPermissionSetting> {
            public ProtoAdapter_AddMemberPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, AddMemberPermissionSetting.class);
            }

            public AddMemberPermissionSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1092build();
            }

            public int encodedSize(AddMemberPermissionSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1093decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AddMemberPermissionSetting) r1);
            }

            public void encode(ProtoWriter r1, AddMemberPermissionSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AddMemberPermissionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AddMemberPermissionSetting();
        }

        public AddMemberPermissionSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1091newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AddMemberPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1091newBuilder();
        }

        public AddMemberPermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class AdminPostSetting extends com.squareup.wire.Message<AdminPostSetting, Builder> {
        public static final ProtoAdapter<AdminPostSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AdminPostSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AdminPostSetting m1095build() {
                return new AdminPostSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1095build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALLOW_POST = null;
            public static final Enum BANNED_POST = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALLOW_POST", 1, 1);
                ALLOW_POST = r1;
                Enum r3 = new Enum("BANNED_POST", 2, 2);
                BANNED_POST = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return BANNED_POST;
            L12:
                return ALLOW_POST;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_AdminPostSetting extends ProtoAdapter<AdminPostSetting> {
            public ProtoAdapter_AdminPostSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, AdminPostSetting.class);
            }

            public AdminPostSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1095build();
            }

            public int encodedSize(AdminPostSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1096decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AdminPostSetting) r1);
            }

            public void encode(ProtoWriter r1, AdminPostSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AdminPostSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AdminPostSetting();
        }

        public AdminPostSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1094newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AdminPostSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1094newBuilder();
        }

        public AdminPostSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class AnonymousSetting extends com.squareup.wire.Message<AnonymousSetting, Builder> {
        public static final ProtoAdapter<AnonymousSetting> ADAPTER = null;
        public static final Boolean DEFAULT_IS_ALLOW_ANONYMOUS = null;
        public static final Boolean DEFAULT_IS_VISIBLE = null;
        private static final long serialVersionUID = 0;
        public final Boolean mis_allow_anonymous;
        public final Boolean mis_visible;

        public static final class Builder extends com.squareup.wire.Message.Builder<AnonymousSetting, Builder> {
            public Boolean mis_allow_anonymous;
            public Boolean mis_visible;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AnonymousSetting m1098build() {
                return new AnonymousSetting(this.mis_allow_anonymous, this.mis_visible, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1098build();
            }

            public Builder is_allow_anonymous(Boolean r1) {
                this.mis_allow_anonymous = r1;
                return this;
            }

            public Builder is_visible(Boolean r1) {
                this.mis_visible = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_AnonymousSetting extends ProtoAdapter<AnonymousSetting> {
            public ProtoAdapter_AnonymousSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, AnonymousSetting.class);
            }

            public AnonymousSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.mis_allow_anonymous = r1;
                r0.mis_visible = r1;
                long r2 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mis_allow_anonymous = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mis_visible = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r2);
                return r0.m1098build();
            }

            public int encodedSize(AnonymousSetting r5) {
                Boolean r0 = r5.mis_allow_anonymous;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r5.mis_visible;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1099decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AnonymousSetting) r1);
            }

            public void encode(ProtoWriter r4, AnonymousSetting r5) throws IOException {
                Boolean r0 = r5.mis_allow_anonymous;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mis_visible;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AnonymousSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AnonymousSetting();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_IS_ALLOW_ANONYMOUS = r0;
            DEFAULT_IS_VISIBLE = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1097newBuilder() {
            Builder r0 = new Builder();
            r0.mis_allow_anonymous = this.mis_allow_anonymous;
            r0.mis_visible = this.mis_visible;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AnonymousSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1097newBuilder();
        }

        public AnonymousSetting(Boolean r2, Boolean r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public AnonymousSetting(Boolean r2, Boolean r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mis_allow_anonymous = r2;
            this.mis_visible = r3;
        }
    }

    public static final class AtAllPermissionSetting extends com.squareup.wire.Message<AtAllPermissionSetting, Builder> {
        public static final ProtoAdapter<AtAllPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<AtAllPermissionSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AtAllPermissionSetting m1101build() {
                return new AtAllPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1101build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_OWNER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_OWNER", 2, 2);
                ONLY_OWNER = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return ONLY_OWNER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_AtAllPermissionSetting extends ProtoAdapter<AtAllPermissionSetting> {
            public ProtoAdapter_AtAllPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, AtAllPermissionSetting.class);
            }

            public AtAllPermissionSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1101build();
            }

            public int encodedSize(AtAllPermissionSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1102decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AtAllPermissionSetting) r1);
            }

            public void encode(ProtoWriter r1, AtAllPermissionSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AtAllPermissionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AtAllPermissionSetting();
        }

        public AtAllPermissionSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1100newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AtAllPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1100newBuilder();
        }

        public AtAllPermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatEntitySetting, Builder> {
        public AddMemberApplySetting.Enum madd_member_apply_setting;
        public AddMemberPermissionSetting.Enum madd_member_permission_setting;
        public AdminPostSetting.Enum madmin_post_setting;
        public AnonymousSetting manonymous_setting;
        public AtAllPermissionSetting.Enum mat_all_permission_setting;
        public ChatDisplayModeSetting.Enum mchat_display_mode_setting;
        public ChatPinPermissionSetting.Enum mchat_pin_permission_setting;
        public ChatTabPermissionSetting.Enum mchat_tab_permission_setting;
        public CreateUrgentSetting.Enum mcreate_urgent_setting;
        public CreateVideoConferenceSetting.Enum mcreate_video_conference_setting;
        public SystemMessageVisibleSetting.Enum mjoin_message_visible_setting;
        public MessageVisibilitySetting.Enum mmessage_visibility_setting;
        public PinPermissionSetting.Enum mpin_permission_setting;
        public SystemMessageVisibleSetting.Enum mquit_message_visible_setting;
        public ShareCardPermissionSetting.Enum mshare_card_permission_setting;
        public ThreadAnonymousSetting.Enum mthread_anonymous_setting;
        public TopNoticePermissionSetting.Enum mtop_notice_permission_setting;
        public UserCountVisibleSetting.Enum muser_count_visible_setting;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatEntitySetting m1103build() {
            return new ChatEntitySetting(this.madd_member_permission_setting, this.mat_all_permission_setting, this.mjoin_message_visible_setting, this.mquit_message_visible_setting, this.mshare_card_permission_setting, this.madd_member_apply_setting, this.mthread_anonymous_setting, this.mmessage_visibility_setting, this.manonymous_setting, this.mcreate_urgent_setting, this.mcreate_video_conference_setting, this.mpin_permission_setting, this.mtop_notice_permission_setting, this.mchat_tab_permission_setting, this.mchat_display_mode_setting, this.madmin_post_setting, this.mchat_pin_permission_setting, this.muser_count_visible_setting, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1103build();
        }

        public Builder add_member_apply_setting(AddMemberApplySetting.Enum r1) {
            this.madd_member_apply_setting = r1;
            return this;
        }

        public Builder add_member_permission_setting(AddMemberPermissionSetting.Enum r1) {
            this.madd_member_permission_setting = r1;
            return this;
        }

        public Builder admin_post_setting(AdminPostSetting.Enum r1) {
            this.madmin_post_setting = r1;
            return this;
        }

        public Builder anonymous_setting(AnonymousSetting r1) {
            this.manonymous_setting = r1;
            return this;
        }

        public Builder at_all_permission_setting(AtAllPermissionSetting.Enum r1) {
            this.mat_all_permission_setting = r1;
            return this;
        }

        public Builder chat_display_mode_setting(ChatDisplayModeSetting.Enum r1) {
            this.mchat_display_mode_setting = r1;
            return this;
        }

        public Builder chat_pin_permission_setting(ChatPinPermissionSetting.Enum r1) {
            this.mchat_pin_permission_setting = r1;
            return this;
        }

        public Builder chat_tab_permission_setting(ChatTabPermissionSetting.Enum r1) {
            this.mchat_tab_permission_setting = r1;
            return this;
        }

        public Builder create_urgent_setting(CreateUrgentSetting.Enum r1) {
            this.mcreate_urgent_setting = r1;
            return this;
        }

        public Builder create_video_conference_setting(CreateVideoConferenceSetting.Enum r1) {
            this.mcreate_video_conference_setting = r1;
            return this;
        }

        public Builder join_message_visible_setting(SystemMessageVisibleSetting.Enum r1) {
            this.mjoin_message_visible_setting = r1;
            return this;
        }

        public Builder message_visibility_setting(MessageVisibilitySetting.Enum r1) {
            this.mmessage_visibility_setting = r1;
            return this;
        }

        public Builder pin_permission_setting(PinPermissionSetting.Enum r1) {
            this.mpin_permission_setting = r1;
            return this;
        }

        public Builder quit_message_visible_setting(SystemMessageVisibleSetting.Enum r1) {
            this.mquit_message_visible_setting = r1;
            return this;
        }

        public Builder share_card_permission_setting(ShareCardPermissionSetting.Enum r1) {
            this.mshare_card_permission_setting = r1;
            return this;
        }

        public Builder thread_anonymous_setting(ThreadAnonymousSetting.Enum r1) {
            this.mthread_anonymous_setting = r1;
            return this;
        }

        public Builder top_notice_permission_setting(TopNoticePermissionSetting.Enum r1) {
            this.mtop_notice_permission_setting = r1;
            return this;
        }

        public Builder user_count_visible_setting(UserCountVisibleSetting.Enum r1) {
            this.muser_count_visible_setting = r1;
            return this;
        }
    }

    public static final class ChatDisplayModeSetting extends com.squareup.wire.Message<ChatDisplayModeSetting, Builder> {
        public static final ProtoAdapter<ChatDisplayModeSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatDisplayModeSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ChatDisplayModeSetting m1105build() {
                return new ChatDisplayModeSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1105build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum DEFAULT = null;
            public static final Enum THREAD = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("DEFAULT", 1, 1);
                DEFAULT = r1;
                Enum r3 = new Enum("THREAD", 2, 2);
                THREAD = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return THREAD;
            L12:
                return DEFAULT;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_ChatDisplayModeSetting extends ProtoAdapter<ChatDisplayModeSetting> {
            public ProtoAdapter_ChatDisplayModeSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatDisplayModeSetting.class);
            }

            public ChatDisplayModeSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1105build();
            }

            public int encodedSize(ChatDisplayModeSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1106decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ChatDisplayModeSetting) r1);
            }

            public void encode(ProtoWriter r1, ChatDisplayModeSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ChatDisplayModeSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatDisplayModeSetting();
        }

        public ChatDisplayModeSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1104newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ChatDisplayModeSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1104newBuilder();
        }

        public ChatDisplayModeSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class ChatPinPermissionSetting extends com.squareup.wire.Message<ChatPinPermissionSetting, Builder> {
        public static final ProtoAdapter<ChatPinPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatPinPermissionSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ChatPinPermissionSetting m1108build() {
                return new ChatPinPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1108build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_ChatPinPermissionSetting extends ProtoAdapter<ChatPinPermissionSetting> {
            public ProtoAdapter_ChatPinPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatPinPermissionSetting.class);
            }

            public ChatPinPermissionSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1108build();
            }

            public int encodedSize(ChatPinPermissionSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1109decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ChatPinPermissionSetting) r1);
            }

            public void encode(ProtoWriter r1, ChatPinPermissionSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ChatPinPermissionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatPinPermissionSetting();
        }

        public ChatPinPermissionSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1107newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ChatPinPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1107newBuilder();
        }

        public ChatPinPermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class ChatTabPermissionSetting extends com.squareup.wire.Message<ChatTabPermissionSetting, Builder> {
        public static final ProtoAdapter<ChatTabPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatTabPermissionSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ChatTabPermissionSetting m1111build() {
                return new ChatTabPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1111build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_ChatTabPermissionSetting extends ProtoAdapter<ChatTabPermissionSetting> {
            public ProtoAdapter_ChatTabPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatTabPermissionSetting.class);
            }

            public ChatTabPermissionSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1111build();
            }

            public int encodedSize(ChatTabPermissionSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1112decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ChatTabPermissionSetting) r1);
            }

            public void encode(ProtoWriter r1, ChatTabPermissionSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ChatTabPermissionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatTabPermissionSetting();
        }

        public ChatTabPermissionSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1110newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ChatTabPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1110newBuilder();
        }

        public ChatTabPermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class CreateUrgentSetting extends com.squareup.wire.Message<CreateUrgentSetting, Builder> {
        public static final ProtoAdapter<CreateUrgentSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<CreateUrgentSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CreateUrgentSetting m1114build() {
                return new CreateUrgentSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1114build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_CreateUrgentSetting extends ProtoAdapter<CreateUrgentSetting> {
            public ProtoAdapter_CreateUrgentSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, CreateUrgentSetting.class);
            }

            public CreateUrgentSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1114build();
            }

            public int encodedSize(CreateUrgentSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1115decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CreateUrgentSetting) r1);
            }

            public void encode(ProtoWriter r1, CreateUrgentSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CreateUrgentSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CreateUrgentSetting();
        }

        public CreateUrgentSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1113newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CreateUrgentSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1113newBuilder();
        }

        public CreateUrgentSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class CreateVideoConferenceSetting extends com.squareup.wire.Message<CreateVideoConferenceSetting, Builder> {
        public static final ProtoAdapter<CreateVideoConferenceSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<CreateVideoConferenceSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CreateVideoConferenceSetting m1117build() {
                return new CreateVideoConferenceSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1117build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_CreateVideoConferenceSetting extends ProtoAdapter<CreateVideoConferenceSetting> {
            public ProtoAdapter_CreateVideoConferenceSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, CreateVideoConferenceSetting.class);
            }

            public CreateVideoConferenceSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1117build();
            }

            public int encodedSize(CreateVideoConferenceSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1118decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CreateVideoConferenceSetting) r1);
            }

            public void encode(ProtoWriter r1, CreateVideoConferenceSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CreateVideoConferenceSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CreateVideoConferenceSetting();
        }

        public CreateVideoConferenceSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1116newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CreateVideoConferenceSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1116newBuilder();
        }

        public CreateVideoConferenceSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final enum Field extends Enum<Field> implements WireEnum {
        private static final /* synthetic */ Field[] $VALUES = null;
        public static final ProtoAdapter<Field> ADAPTER = null;
        public static final Field ADD_MEMBER_APPLY_SETTING = null;
        public static final Field ADD_MEMBER_PERMISSION_SETTING = null;
        public static final Field ADMIN_POST_SETTING = null;
        public static final Field ALLOW_ANONYMOUS_SETTING = null;
        public static final Field AT_ALL_PERMISSION_SETTING = null;
        public static final Field CHAT_DISPLAY_MODE_SETTING = null;
        public static final Field CHAT_PIN_PERMISSION_SETTING = null;
        public static final Field CHAT_TAB_PERMISSION_SETTING = null;
        public static final Field CREATE_URGENT_SETTING = null;
        public static final Field CREATE_VIDEO_CONFERENCE_SETTING = null;
        public static final Field JOIN_MESSAGE_VISIBLE_SETTING = null;
        public static final Field MESSAGE_VISIBILITY_SETTING = null;
        public static final Field PIN_PERMISSION_SETTING = null;
        public static final Field QUIT_MESSAGE_VISIBLE_SETTING = null;
        public static final Field SHARE_CARD_PERMISSION_SETTING = null;
        public static final Field THREAD_ANONYMOUS_SETTING = null;
        public static final Field TOP_NOTICE_PERMISSION_SETTING = null;
        public static final Field UNKNOWN = null;
        public static final Field USER_COUNT_VISIBLE_SETTING = null;
        private final int value;

        static {
            Field r0 = new Field("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Field r1 = new Field("ADD_MEMBER_PERMISSION_SETTING", 1, 1);
            ADD_MEMBER_PERMISSION_SETTING = r1;
            Field r3 = new Field("AT_ALL_PERMISSION_SETTING", 2, 2);
            AT_ALL_PERMISSION_SETTING = r3;
            Field r5 = new Field("JOIN_MESSAGE_VISIBLE_SETTING", 3, 3);
            JOIN_MESSAGE_VISIBLE_SETTING = r5;
            Field r7 = new Field("QUIT_MESSAGE_VISIBLE_SETTING", 4, 4);
            QUIT_MESSAGE_VISIBLE_SETTING = r7;
            Field r9 = new Field("SHARE_CARD_PERMISSION_SETTING", 5, 5);
            SHARE_CARD_PERMISSION_SETTING = r9;
            Field r11 = new Field("ADD_MEMBER_APPLY_SETTING", 6, 6);
            ADD_MEMBER_APPLY_SETTING = r11;
            Field r13 = new Field("THREAD_ANONYMOUS_SETTING", 7, 7);
            THREAD_ANONYMOUS_SETTING = r13;
            Field r15 = new Field("MESSAGE_VISIBILITY_SETTING", 8, 8);
            MESSAGE_VISIBILITY_SETTING = r15;
            Field r14 = new Field("ALLOW_ANONYMOUS_SETTING", 9, 9);
            ALLOW_ANONYMOUS_SETTING = r14;
            Field r12 = new Field("CREATE_URGENT_SETTING", 10, 10);
            CREATE_URGENT_SETTING = r12;
            Field r10 = new Field("CREATE_VIDEO_CONFERENCE_SETTING", 11, 11);
            CREATE_VIDEO_CONFERENCE_SETTING = r10;
            Field r8 = new Field("PIN_PERMISSION_SETTING", 12, 12);
            PIN_PERMISSION_SETTING = r8;
            Field r6 = new Field("TOP_NOTICE_PERMISSION_SETTING", 13, 14);
            TOP_NOTICE_PERMISSION_SETTING = r6;
            Field r4 = new Field("CHAT_TAB_PERMISSION_SETTING", 14, 15);
            CHAT_TAB_PERMISSION_SETTING = r4;
            Field r2 = new Field("CHAT_DISPLAY_MODE_SETTING", 15, 16);
            CHAT_DISPLAY_MODE_SETTING = r2;
            Field r16 = new Field("ADMIN_POST_SETTING", 16, 17);
            ADMIN_POST_SETTING = r16;
            Field r17 = new Field("CHAT_PIN_PERMISSION_SETTING", 17, 18);
            CHAT_PIN_PERMISSION_SETTING = r17;
            Field r18 = new Field("USER_COUNT_VISIBLE_SETTING", 18, 19);
            USER_COUNT_VISIBLE_SETTING = r18;
            $VALUES = new Field[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18};
            ADAPTER = ProtoAdapter.newEnumAdapter(Field.class);
        }

        public static Field[] values() {
            return (Field[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Field fromValue(int r0) {
            switch(r0) {
                case 0: goto L42;
                case 1: goto L40;
                case 2: goto L38;
                case 3: goto L36;
                case 4: goto L34;
                case 5: goto L32;
                case 6: goto L30;
                case 7: goto L28;
                case 8: goto L26;
                case 9: goto L24;
                case 10: goto L22;
                case 11: goto L20;
                case 12: goto L18;
                case 13: goto L3;
                case 14: goto L16;
                case 15: goto L14;
                case 16: goto L12;
                case 17: goto L10;
                case 18: goto L8;
                case 19: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return USER_COUNT_VISIBLE_SETTING;
        L8:
            return CHAT_PIN_PERMISSION_SETTING;
        L10:
            return ADMIN_POST_SETTING;
        L12:
            return CHAT_DISPLAY_MODE_SETTING;
        L14:
            return CHAT_TAB_PERMISSION_SETTING;
        L16:
            return TOP_NOTICE_PERMISSION_SETTING;
        L18:
            return PIN_PERMISSION_SETTING;
        L20:
            return CREATE_VIDEO_CONFERENCE_SETTING;
        L22:
            return CREATE_URGENT_SETTING;
        L24:
            return ALLOW_ANONYMOUS_SETTING;
        L26:
            return MESSAGE_VISIBILITY_SETTING;
        L28:
            return THREAD_ANONYMOUS_SETTING;
        L30:
            return ADD_MEMBER_APPLY_SETTING;
        L32:
            return SHARE_CARD_PERMISSION_SETTING;
        L34:
            return QUIT_MESSAGE_VISIBLE_SETTING;
        L36:
            return JOIN_MESSAGE_VISIBLE_SETTING;
        L38:
            return AT_ALL_PERMISSION_SETTING;
        L40:
            return ADD_MEMBER_PERMISSION_SETTING;
        L42:
            return UNKNOWN;
        }

        public static Field valueOf(String r1) {
            return (Field) a.a(Field.class, r1);
        }

        private Field(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class MessageVisibilitySetting extends com.squareup.wire.Message<MessageVisibilitySetting, Builder> {
        public static final ProtoAdapter<MessageVisibilitySetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<MessageVisibilitySetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MessageVisibilitySetting m1120build() {
                return new MessageVisibilitySetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1120build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MESSAGES = null;
            public static final Enum ONLY_NEW_MESSAGES = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MESSAGES", 1, 1);
                ALL_MESSAGES = r1;
                Enum r3 = new Enum("ONLY_NEW_MESSAGES", 2, 2);
                ONLY_NEW_MESSAGES = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return ONLY_NEW_MESSAGES;
            L12:
                return ALL_MESSAGES;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_MessageVisibilitySetting extends ProtoAdapter<MessageVisibilitySetting> {
            public ProtoAdapter_MessageVisibilitySetting() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageVisibilitySetting.class);
            }

            public MessageVisibilitySetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1120build();
            }

            public int encodedSize(MessageVisibilitySetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1121decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MessageVisibilitySetting) r1);
            }

            public void encode(ProtoWriter r1, MessageVisibilitySetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MessageVisibilitySetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageVisibilitySetting();
        }

        public MessageVisibilitySetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1119newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MessageVisibilitySetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1119newBuilder();
        }

        public MessageVisibilitySetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class PinPermissionSetting extends com.squareup.wire.Message<PinPermissionSetting, Builder> {
        public static final ProtoAdapter<PinPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<PinPermissionSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public PinPermissionSetting m1123build() {
                return new PinPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1123build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_PinPermissionSetting extends ProtoAdapter<PinPermissionSetting> {
            public ProtoAdapter_PinPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, PinPermissionSetting.class);
            }

            public PinPermissionSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1123build();
            }

            public int encodedSize(PinPermissionSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1124decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((PinPermissionSetting) r1);
            }

            public void encode(ProtoWriter r1, PinPermissionSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (PinPermissionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PinPermissionSetting();
        }

        public PinPermissionSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1122newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return PinPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1122newBuilder();
        }

        public PinPermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class ProtoAdapter_ChatEntitySetting extends ProtoAdapter<ChatEntitySetting> {
        public ProtoAdapter_ChatEntitySetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatEntitySetting.class);
        }

        public ChatEntitySetting decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L76;
            switch(r3) {
                case 1: goto L82;
                case 2: goto L96;
                case 3: goto L102;
                case 4: goto L106;
                case 5: goto L108;
                case 6: goto L80;
                case 7: goto L84;
                case 8: goto L90;
                case 9: goto L43;
                case 10: goto L78;
                case 11: goto L92;
                case 12: goto L94;
                case 13: goto L98;
                case 14: goto L104;
                case 15: goto L110;
                case 16: goto L86;
                case 17: goto L88;
                case 18: goto L100;
                default: goto L6;
            };
        L78:
            r0.mcreate_urgent_setting = (CreateUrgentSetting.Enum) CreateUrgentSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L41
        L41:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L80:
            r0.madd_member_apply_setting = (AddMemberApplySetting.Enum) AddMemberApplySetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L54
        L54:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L82:
            r0.madd_member_permission_setting = (AddMemberPermissionSetting.Enum) AddMemberPermissionSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L74
        L74:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L84:
            r0.mthread_anonymous_setting = (ThreadAnonymousSetting.Enum) ThreadAnonymousSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L50
        L50:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L86:
            r0.madmin_post_setting = (AdminPostSetting.Enum) AdminPostSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L88:
            r0.mchat_pin_permission_setting = (ChatPinPermissionSetting.Enum) ChatPinPermissionSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L90:
            r0.mmessage_visibility_setting = (MessageVisibilitySetting.Enum) MessageVisibilitySetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L46
        L46:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L92:
            r0.mcreate_video_conference_setting = (CreateVideoConferenceSetting.Enum) CreateVideoConferenceSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L37
        L37:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L94:
            r0.mpin_permission_setting = (PinPermissionSetting.Enum) PinPermissionSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L33
        L33:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L96:
            r0.mat_all_permission_setting = (AtAllPermissionSetting.Enum) AtAllPermissionSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L70
        L70:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L98:
            r0.mtop_notice_permission_setting = (TopNoticePermissionSetting.Enum) TopNoticePermissionSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L100:
            r0.muser_count_visible_setting = (UserCountVisibleSetting.Enum) UserCountVisibleSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L102:
            r0.mjoin_message_visible_setting = (SystemMessageVisibleSetting.Enum) SystemMessageVisibleSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L66
        L66:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L104:
            r0.mchat_tab_permission_setting = (ChatTabPermissionSetting.Enum) ChatTabPermissionSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L106:
            r0.mquit_message_visible_setting = (SystemMessageVisibleSetting.Enum) SystemMessageVisibleSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L62
        L62:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L108:
            r0.mshare_card_permission_setting = (ShareCardPermissionSetting.Enum) ShareCardPermissionSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L58
        L58:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L110:
            r0.mchat_display_mode_setting = (ChatDisplayModeSetting.Enum) ChatDisplayModeSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L43:
            r0.manonymous_setting = (AnonymousSetting) AnonymousSetting.ADAPTER.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L76:
            r9.endMessage(r1);
            return r0.m1103build();
        }

        public int encodedSize(ChatEntitySetting r6) {
            AddMemberPermissionSetting.Enum r0 = r6.madd_member_permission_setting;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = AddMemberPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            AtAllPermissionSetting.Enum r3 = r6.mat_all_permission_setting;
            if (r3 == null) goto L9;
            int r4 = AtAllPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            SystemMessageVisibleSetting.Enum r7 = r6.mjoin_message_visible_setting;
            if (r7 == null) goto L13;
            int r8 = SystemMessageVisibleSetting.Enum.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            SystemMessageVisibleSetting.Enum r10 = r6.mquit_message_visible_setting;
            if (r10 == null) goto L17;
            int r11 = SystemMessageVisibleSetting.Enum.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            ShareCardPermissionSetting.Enum r13 = r6.mshare_card_permission_setting;
            if (r13 == null) goto L21;
            int r14 = ShareCardPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            AddMemberApplySetting.Enum r16 = r6.madd_member_apply_setting;
            if (r16 == null) goto L25;
            int r17 = AddMemberApplySetting.Enum.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            ThreadAnonymousSetting.Enum r19 = r6.mthread_anonymous_setting;
            if (r19 == null) goto L29;
            int r20 = ThreadAnonymousSetting.Enum.ADAPTER.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            MessageVisibilitySetting.Enum r22 = r6.mmessage_visibility_setting;
            if (r22 == null) goto L33;
            int r23 = MessageVisibilitySetting.Enum.ADAPTER.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            AnonymousSetting r25 = r6.manonymous_setting;
            if (r25 == null) goto L37;
            int r26 = AnonymousSetting.ADAPTER.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            CreateUrgentSetting.Enum r28 = r6.mcreate_urgent_setting;
            if (r28 == null) goto L41;
            int r29 = CreateUrgentSetting.Enum.ADAPTER.encodedSizeWithTag(10, r28);
        L42:
            int r30 = r27 + r29;
            CreateVideoConferenceSetting.Enum r31 = r6.mcreate_video_conference_setting;
            if (r31 == null) goto L45;
            int r32 = CreateVideoConferenceSetting.Enum.ADAPTER.encodedSizeWithTag(11, r31);
        L46:
            int r33 = r30 + r32;
            PinPermissionSetting.Enum r34 = r6.mpin_permission_setting;
            if (r34 == null) goto L49;
            int r35 = PinPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(12, r34);
        L50:
            int r36 = r33 + r35;
            TopNoticePermissionSetting.Enum r37 = r6.mtop_notice_permission_setting;
            if (r37 == null) goto L53;
            int r38 = TopNoticePermissionSetting.Enum.ADAPTER.encodedSizeWithTag(13, r37);
        L54:
            int r39 = r36 + r38;
            ChatTabPermissionSetting.Enum r40 = r6.mchat_tab_permission_setting;
            if (r40 == null) goto L57;
            int r41 = ChatTabPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(14, r40);
        L58:
            int r42 = r39 + r41;
            ChatDisplayModeSetting.Enum r43 = r6.mchat_display_mode_setting;
            if (r43 == null) goto L61;
            int r44 = ChatDisplayModeSetting.Enum.ADAPTER.encodedSizeWithTag(15, r43);
        L62:
            int r45 = r42 + r44;
            AdminPostSetting.Enum r46 = r6.madmin_post_setting;
            if (r46 == null) goto L65;
            int r47 = AdminPostSetting.Enum.ADAPTER.encodedSizeWithTag(16, r46);
        L66:
            int r48 = r45 + r47;
            ChatPinPermissionSetting.Enum r49 = r6.mchat_pin_permission_setting;
            if (r49 == null) goto L69;
            int r50 = ChatPinPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(17, r49);
        L70:
            int r51 = r48 + r50;
            UserCountVisibleSetting.Enum r52 = r6.muser_count_visible_setting;
            if (r52 == null) goto L74;
            r1 = UserCountVisibleSetting.Enum.ADAPTER.encodedSizeWithTag(18, r52);
        L74:
            return (r51 + r1) + r6.unknownFields().size();
        L69:
            r50 = 0;
            goto L70
        L65:
            r47 = 0;
            goto L66
        L61:
            r44 = 0;
            goto L62
        L57:
            r41 = 0;
            goto L58
        L53:
            r38 = 0;
            goto L54
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
        public /* bridge */ /* synthetic */ Object m1125decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatEntitySetting) r1);
        }

        public void encode(ProtoWriter r4, ChatEntitySetting r5) throws IOException {
            AddMemberPermissionSetting.Enum r0 = r5.madd_member_permission_setting;
            if (r0 == null) goto L5;
            AddMemberPermissionSetting.Enum.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            AtAllPermissionSetting.Enum r1 = r5.mat_all_permission_setting;
            if (r1 == null) goto L8;
            AtAllPermissionSetting.Enum.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            SystemMessageVisibleSetting.Enum r2 = r5.mjoin_message_visible_setting;
            if (r2 == null) goto L11;
            SystemMessageVisibleSetting.Enum.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            SystemMessageVisibleSetting.Enum r3 = r5.mquit_message_visible_setting;
            if (r3 == null) goto L14;
            SystemMessageVisibleSetting.Enum.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            ShareCardPermissionSetting.Enum r6 = r5.mshare_card_permission_setting;
            if (r6 == null) goto L17;
            ShareCardPermissionSetting.Enum.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            AddMemberApplySetting.Enum r7 = r5.madd_member_apply_setting;
            if (r7 == null) goto L20;
            AddMemberApplySetting.Enum.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            ThreadAnonymousSetting.Enum r8 = r5.mthread_anonymous_setting;
            if (r8 == null) goto L23;
            ThreadAnonymousSetting.Enum.ADAPTER.encodeWithTag(r4, 7, r8);
        L23:
            MessageVisibilitySetting.Enum r9 = r5.mmessage_visibility_setting;
            if (r9 == null) goto L26;
            MessageVisibilitySetting.Enum.ADAPTER.encodeWithTag(r4, 8, r9);
        L26:
            AnonymousSetting r10 = r5.manonymous_setting;
            if (r10 == null) goto L29;
            AnonymousSetting.ADAPTER.encodeWithTag(r4, 9, r10);
        L29:
            CreateUrgentSetting.Enum r11 = r5.mcreate_urgent_setting;
            if (r11 == null) goto L32;
            CreateUrgentSetting.Enum.ADAPTER.encodeWithTag(r4, 10, r11);
        L32:
            CreateVideoConferenceSetting.Enum r12 = r5.mcreate_video_conference_setting;
            if (r12 == null) goto L35;
            CreateVideoConferenceSetting.Enum.ADAPTER.encodeWithTag(r4, 11, r12);
        L35:
            PinPermissionSetting.Enum r13 = r5.mpin_permission_setting;
            if (r13 == null) goto L38;
            PinPermissionSetting.Enum.ADAPTER.encodeWithTag(r4, 12, r13);
        L38:
            TopNoticePermissionSetting.Enum r14 = r5.mtop_notice_permission_setting;
            if (r14 == null) goto L41;
            TopNoticePermissionSetting.Enum.ADAPTER.encodeWithTag(r4, 13, r14);
        L41:
            ChatTabPermissionSetting.Enum r15 = r5.mchat_tab_permission_setting;
            if (r15 == null) goto L44;
            ChatTabPermissionSetting.Enum.ADAPTER.encodeWithTag(r4, 14, r15);
        L44:
            ChatDisplayModeSetting.Enum r16 = r5.mchat_display_mode_setting;
            if (r16 == null) goto L47;
            ChatDisplayModeSetting.Enum.ADAPTER.encodeWithTag(r4, 15, r16);
        L47:
            AdminPostSetting.Enum r17 = r5.madmin_post_setting;
            if (r17 == null) goto L50;
            AdminPostSetting.Enum.ADAPTER.encodeWithTag(r4, 16, r17);
        L50:
            ChatPinPermissionSetting.Enum r18 = r5.mchat_pin_permission_setting;
            if (r18 == null) goto L53;
            ChatPinPermissionSetting.Enum.ADAPTER.encodeWithTag(r4, 17, r18);
        L53:
            UserCountVisibleSetting.Enum r19 = r5.muser_count_visible_setting;
            if (r19 == null) goto L56;
            UserCountVisibleSetting.Enum.ADAPTER.encodeWithTag(r4, 18, r19);
        L56:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatEntitySetting) r2);
        }
    }

    public static final class ShareCardPermissionSetting extends com.squareup.wire.Message<ShareCardPermissionSetting, Builder> {
        public static final ProtoAdapter<ShareCardPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ShareCardPermissionSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ShareCardPermissionSetting m1127build() {
                return new ShareCardPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1127build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALLOWED = null;
            public static final Enum NOT_ALLOWED = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALLOWED", 1, 1);
                ALLOWED = r1;
                Enum r3 = new Enum("NOT_ALLOWED", 2, 2);
                NOT_ALLOWED = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return NOT_ALLOWED;
            L12:
                return ALLOWED;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_ShareCardPermissionSetting extends ProtoAdapter<ShareCardPermissionSetting> {
            public ProtoAdapter_ShareCardPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ShareCardPermissionSetting.class);
            }

            public ShareCardPermissionSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1127build();
            }

            public int encodedSize(ShareCardPermissionSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1128decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ShareCardPermissionSetting) r1);
            }

            public void encode(ProtoWriter r1, ShareCardPermissionSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ShareCardPermissionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ShareCardPermissionSetting();
        }

        public ShareCardPermissionSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1126newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ShareCardPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1126newBuilder();
        }

        public ShareCardPermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class SystemMessageVisibleSetting extends com.squareup.wire.Message<SystemMessageVisibleSetting, Builder> {
        public static final ProtoAdapter<SystemMessageVisibleSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<SystemMessageVisibleSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SystemMessageVisibleSetting m1130build() {
                return new SystemMessageVisibleSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1130build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum NOT_ANYONE = null;
            public static final Enum ONLY_OWNER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ONLY_OWNER", 1, 1);
                ONLY_OWNER = r1;
                Enum r3 = new Enum("ALL_MEMBERS", 2, 2);
                ALL_MEMBERS = r3;
                Enum r5 = new Enum("NOT_ANYONE", 3, 3);
                NOT_ANYONE = r5;
                $VALUES = new Enum[]{r0, r1, r3, r5};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return NOT_ANYONE;
            L14:
                return ALL_MEMBERS;
            L16:
                return ONLY_OWNER;
            L18:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_SystemMessageVisibleSetting extends ProtoAdapter<SystemMessageVisibleSetting> {
            public ProtoAdapter_SystemMessageVisibleSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, SystemMessageVisibleSetting.class);
            }

            public SystemMessageVisibleSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1130build();
            }

            public int encodedSize(SystemMessageVisibleSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1131decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SystemMessageVisibleSetting) r1);
            }

            public void encode(ProtoWriter r1, SystemMessageVisibleSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SystemMessageVisibleSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SystemMessageVisibleSetting();
        }

        public SystemMessageVisibleSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1129newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SystemMessageVisibleSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1129newBuilder();
        }

        public SystemMessageVisibleSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class ThreadAnonymousSetting extends com.squareup.wire.Message<ThreadAnonymousSetting, Builder> {
        public static final ProtoAdapter<ThreadAnonymousSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ThreadAnonymousSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ThreadAnonymousSetting m1133build() {
                return new ThreadAnonymousSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1133build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALLOWED = null;
            public static final Enum INVISIBLE = null;
            public static final Enum NOT_ALLOWED = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("INVISIBLE", 1, 1);
                INVISIBLE = r1;
                Enum r3 = new Enum("NOT_ALLOWED", 2, 2);
                NOT_ALLOWED = r3;
                Enum r5 = new Enum("ALLOWED", 3, 3);
                ALLOWED = r5;
                $VALUES = new Enum[]{r0, r1, r3, r5};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return ALLOWED;
            L14:
                return NOT_ALLOWED;
            L16:
                return INVISIBLE;
            L18:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_ThreadAnonymousSetting extends ProtoAdapter<ThreadAnonymousSetting> {
            public ProtoAdapter_ThreadAnonymousSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ThreadAnonymousSetting.class);
            }

            public ThreadAnonymousSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1133build();
            }

            public int encodedSize(ThreadAnonymousSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1134decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ThreadAnonymousSetting) r1);
            }

            public void encode(ProtoWriter r1, ThreadAnonymousSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ThreadAnonymousSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ThreadAnonymousSetting();
        }

        public ThreadAnonymousSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1132newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ThreadAnonymousSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1132newBuilder();
        }

        public ThreadAnonymousSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class TopNoticePermissionSetting extends com.squareup.wire.Message<TopNoticePermissionSetting, Builder> {
        public static final ProtoAdapter<TopNoticePermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<TopNoticePermissionSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TopNoticePermissionSetting m1136build() {
                return new TopNoticePermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1136build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_TopNoticePermissionSetting extends ProtoAdapter<TopNoticePermissionSetting> {
            public ProtoAdapter_TopNoticePermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, TopNoticePermissionSetting.class);
            }

            public TopNoticePermissionSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1136build();
            }

            public int encodedSize(TopNoticePermissionSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1137decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TopNoticePermissionSetting) r1);
            }

            public void encode(ProtoWriter r1, TopNoticePermissionSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TopNoticePermissionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TopNoticePermissionSetting();
        }

        public TopNoticePermissionSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1135newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TopNoticePermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1135newBuilder();
        }

        public TopNoticePermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class UserCountVisibleSetting extends com.squareup.wire.Message<UserCountVisibleSetting, Builder> {
        public static final ProtoAdapter<UserCountVisibleSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<UserCountVisibleSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public UserCountVisibleSetting m1139build() {
                return new UserCountVisibleSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1139build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum ONLY_MANAGER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("ONLY_MANAGER", 2, 2);
                ONLY_MANAGER = r3;
                $VALUES = new Enum[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Enum.class);
            }

            public static Enum[] values() {
                return (Enum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Enum fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return ONLY_MANAGER;
            L12:
                return ALL_MEMBERS;
            L14:
                return UNKNOWN;
            }

            public static Enum valueOf(String r1) {
                return (Enum) a.a(Enum.class, r1);
            }

            private Enum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_UserCountVisibleSetting extends ProtoAdapter<UserCountVisibleSetting> {
            public ProtoAdapter_UserCountVisibleSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, UserCountVisibleSetting.class);
            }

            public UserCountVisibleSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L6;
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L6:
                r7.endMessage(r1);
                return r0.m1139build();
            }

            public int encodedSize(UserCountVisibleSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1140decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((UserCountVisibleSetting) r1);
            }

            public void encode(ProtoWriter r1, UserCountVisibleSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (UserCountVisibleSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserCountVisibleSetting();
        }

        public UserCountVisibleSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1138newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return UserCountVisibleSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1138newBuilder();
        }

        public UserCountVisibleSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatEntitySetting();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1087newBuilder() {
        Builder r0 = new Builder();
        r0.madd_member_permission_setting = this.madd_member_permission_setting;
        r0.mat_all_permission_setting = this.mat_all_permission_setting;
        r0.mjoin_message_visible_setting = this.mjoin_message_visible_setting;
        r0.mquit_message_visible_setting = this.mquit_message_visible_setting;
        r0.mshare_card_permission_setting = this.mshare_card_permission_setting;
        r0.madd_member_apply_setting = this.madd_member_apply_setting;
        r0.mthread_anonymous_setting = this.mthread_anonymous_setting;
        r0.mmessage_visibility_setting = this.mmessage_visibility_setting;
        r0.manonymous_setting = this.manonymous_setting;
        r0.mcreate_urgent_setting = this.mcreate_urgent_setting;
        r0.mcreate_video_conference_setting = this.mcreate_video_conference_setting;
        r0.mpin_permission_setting = this.mpin_permission_setting;
        r0.mtop_notice_permission_setting = this.mtop_notice_permission_setting;
        r0.mchat_tab_permission_setting = this.mchat_tab_permission_setting;
        r0.mchat_display_mode_setting = this.mchat_display_mode_setting;
        r0.madmin_post_setting = this.madmin_post_setting;
        r0.mchat_pin_permission_setting = this.mchat_pin_permission_setting;
        r0.muser_count_visible_setting = this.muser_count_visible_setting;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatEntitySetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1087newBuilder();
    }

    public ChatEntitySetting(AddMemberPermissionSetting.Enum r21, AtAllPermissionSetting.Enum r22, SystemMessageVisibleSetting.Enum r23, SystemMessageVisibleSetting.Enum r24, ShareCardPermissionSetting.Enum r25, AddMemberApplySetting.Enum r26, ThreadAnonymousSetting.Enum r27, MessageVisibilitySetting.Enum r28, AnonymousSetting r29, CreateUrgentSetting.Enum r30, CreateVideoConferenceSetting.Enum r31, PinPermissionSetting.Enum r32, TopNoticePermissionSetting.Enum r33, ChatTabPermissionSetting.Enum r34, ChatDisplayModeSetting.Enum r35, AdminPostSetting.Enum r36, ChatPinPermissionSetting.Enum r37, UserCountVisibleSetting.Enum r38) {
        this(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, ByteString.EMPTY);
    }

    public ChatEntitySetting(AddMemberPermissionSetting.Enum r4, AtAllPermissionSetting.Enum r5, SystemMessageVisibleSetting.Enum r6, SystemMessageVisibleSetting.Enum r7, ShareCardPermissionSetting.Enum r8, AddMemberApplySetting.Enum r9, ThreadAnonymousSetting.Enum r10, MessageVisibilitySetting.Enum r11, AnonymousSetting r12, CreateUrgentSetting.Enum r13, CreateVideoConferenceSetting.Enum r14, PinPermissionSetting.Enum r15, TopNoticePermissionSetting.Enum r16, ChatTabPermissionSetting.Enum r17, ChatDisplayModeSetting.Enum r18, AdminPostSetting.Enum r19, ChatPinPermissionSetting.Enum r20, UserCountVisibleSetting.Enum r21, ByteString r22) {
        super(ADAPTER, r22);
        this.madd_member_permission_setting = r4;
        this.mat_all_permission_setting = r5;
        this.mjoin_message_visible_setting = r6;
        this.mquit_message_visible_setting = r7;
        this.mshare_card_permission_setting = r8;
        this.madd_member_apply_setting = r9;
        this.mthread_anonymous_setting = r10;
        this.mmessage_visibility_setting = r11;
        this.manonymous_setting = r12;
        this.mcreate_urgent_setting = r13;
        this.mcreate_video_conference_setting = r14;
        this.mpin_permission_setting = r15;
        this.mtop_notice_permission_setting = r16;
        this.mchat_tab_permission_setting = r17;
        this.mchat_display_mode_setting = r18;
        this.madmin_post_setting = r19;
        this.mchat_pin_permission_setting = r20;
        this.muser_count_visible_setting = r21;
    }
}
