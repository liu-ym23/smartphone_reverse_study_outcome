package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
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
public final class GeneralChatSetting extends com.squareup.wire.Message<GeneralChatSetting, Builder> {
    public static final ProtoAdapter<GeneralChatSetting> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DefDisplaySetting mdef_display_setting;
    public final DoubaoSetting mdoubao_setting;
    public final RestrictedModePermissionSetting mrestricted_mode_permission_setting;

    public static final class Builder extends com.squareup.wire.Message.Builder<GeneralChatSetting, Builder> {
        public DefDisplaySetting mdef_display_setting;
        public DoubaoSetting mdoubao_setting;
        public RestrictedModePermissionSetting mrestricted_mode_permission_setting;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GeneralChatSetting m1223build() {
            return new GeneralChatSetting(this.mrestricted_mode_permission_setting, this.mdef_display_setting, this.mdoubao_setting, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1223build();
        }

        public Builder def_display_setting(DefDisplaySetting r1) {
            this.mdef_display_setting = r1;
            return this;
        }

        public Builder doubao_setting(DoubaoSetting r1) {
            this.mdoubao_setting = r1;
            return this;
        }

        public Builder restricted_mode_permission_setting(RestrictedModePermissionSetting r1) {
            this.mrestricted_mode_permission_setting = r1;
            return this;
        }
    }

    public static final class CopyPermissionSetting extends com.squareup.wire.Message<CopyPermissionSetting, Builder> {
        public static final ProtoAdapter<CopyPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<CopyPermissionSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CopyPermissionSetting m1225build() {
                return new CopyPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1225build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum NO_MEMBER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("NO_MEMBER", 2, 2);
                NO_MEMBER = r3;
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
                return NO_MEMBER;
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

        public static final class ProtoAdapter_CopyPermissionSetting extends ProtoAdapter<CopyPermissionSetting> {
            public ProtoAdapter_CopyPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, CopyPermissionSetting.class);
            }

            public CopyPermissionSetting decode(ProtoReader r7) throws IOException {
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
                return r0.m1225build();
            }

            public int encodedSize(CopyPermissionSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1226decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CopyPermissionSetting) r1);
            }

            public void encode(ProtoWriter r1, CopyPermissionSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CopyPermissionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CopyPermissionSetting();
        }

        public CopyPermissionSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1224newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CopyPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1224newBuilder();
        }

        public CopyPermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class DoubaoSetting extends com.squareup.wire.Message<DoubaoSetting, Builder> {
        public static final ProtoAdapter<DoubaoSetting> ADAPTER = null;
        public static final Boolean DEFAULT_DOUBAO_PROACTIVE_REPLY_ENABLED = null;
        public static final Boolean DEFAULT_DOUBAO_USING_ENABLED = null;
        private static final long serialVersionUID = 0;
        public final Boolean mdoubao_proactive_reply_enabled;
        public final Boolean mdoubao_using_enabled;

        public static final class Builder extends com.squareup.wire.Message.Builder<DoubaoSetting, Builder> {
            public Boolean mdoubao_proactive_reply_enabled;
            public Boolean mdoubao_using_enabled;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DoubaoSetting m1228build() {
                return new DoubaoSetting(this.mdoubao_using_enabled, this.mdoubao_proactive_reply_enabled, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1228build();
            }

            public Builder doubao_proactive_reply_enabled(Boolean r1) {
                this.mdoubao_proactive_reply_enabled = r1;
                return this;
            }

            public Builder doubao_using_enabled(Boolean r1) {
                this.mdoubao_using_enabled = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DoubaoSetting extends ProtoAdapter<DoubaoSetting> {
            public ProtoAdapter_DoubaoSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, DoubaoSetting.class);
            }

            public DoubaoSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mdoubao_using_enabled = Boolean.TRUE;
                r0.mdoubao_proactive_reply_enabled = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mdoubao_using_enabled = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mdoubao_proactive_reply_enabled = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1228build();
            }

            public int encodedSize(DoubaoSetting r5) {
                Boolean r0 = r5.mdoubao_using_enabled;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r5.mdoubao_proactive_reply_enabled;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1229decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DoubaoSetting) r1);
            }

            public void encode(ProtoWriter r4, DoubaoSetting r5) throws IOException {
                Boolean r0 = r5.mdoubao_using_enabled;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mdoubao_proactive_reply_enabled;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DoubaoSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DoubaoSetting();
            DEFAULT_DOUBAO_USING_ENABLED = Boolean.TRUE;
            DEFAULT_DOUBAO_PROACTIVE_REPLY_ENABLED = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1227newBuilder() {
            Builder r0 = new Builder();
            r0.mdoubao_using_enabled = this.mdoubao_using_enabled;
            r0.mdoubao_proactive_reply_enabled = this.mdoubao_proactive_reply_enabled;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DoubaoSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1227newBuilder();
        }

        public DoubaoSetting(Boolean r2, Boolean r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public DoubaoSetting(Boolean r2, Boolean r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mdoubao_using_enabled = r2;
            this.mdoubao_proactive_reply_enabled = r3;
        }
    }

    public static final class DownloadPermissionSetting extends com.squareup.wire.Message<DownloadPermissionSetting, Builder> {
        public static final ProtoAdapter<DownloadPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<DownloadPermissionSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DownloadPermissionSetting m1231build() {
                return new DownloadPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1231build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum NO_MEMBER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("NO_MEMBER", 2, 2);
                NO_MEMBER = r3;
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
                return NO_MEMBER;
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

        public static final class ProtoAdapter_DownloadPermissionSetting extends ProtoAdapter<DownloadPermissionSetting> {
            public ProtoAdapter_DownloadPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, DownloadPermissionSetting.class);
            }

            public DownloadPermissionSetting decode(ProtoReader r7) throws IOException {
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
                return r0.m1231build();
            }

            public int encodedSize(DownloadPermissionSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1232decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DownloadPermissionSetting) r1);
            }

            public void encode(ProtoWriter r1, DownloadPermissionSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DownloadPermissionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DownloadPermissionSetting();
        }

        public DownloadPermissionSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1230newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DownloadPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1230newBuilder();
        }

        public DownloadPermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final enum Field extends Enum<Field> implements WireEnum {
        private static final /* synthetic */ Field[] $VALUES = null;
        public static final ProtoAdapter<Field> ADAPTER = null;
        public static final Field COPY_PERMISSION_SETTING = null;
        public static final Field DEF_DISPLAY_SETTING = null;
        public static final Field DOUBAO_SETTING_DOUBAO_ENABLE = null;
        public static final Field DOUBAO_SETTING_PROACTIVE_REPLY_ENABLE = null;
        public static final Field DOWNLOAD_PERMISSION_SETTING = null;
        public static final Field FORWARD_PERMISSION_SETTING = null;
        public static final Field ON_TIME_DEL_MSG_SETTING_ALIVE_TIME = null;
        public static final Field ON_TIME_DEL_MSG_SETTING_STATUS = null;
        public static final Field RESTRICTED_MODE_PERMISSION_SETTING = null;
        public static final Field SCREENSHOT_PERNISSION_SETTING = null;
        public static final Field UNKNOWN = null;
        public static final Field WHITE_LIST_SETTING_LEVEL = null;
        public static final Field WHITE_LIST_SETTING_USERS = null;
        private final int value;

        static {
            Field r0 = new Field("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Field r1 = new Field("RESTRICTED_MODE_PERMISSION_SETTING", 1, 1);
            RESTRICTED_MODE_PERMISSION_SETTING = r1;
            Field r3 = new Field("FORWARD_PERMISSION_SETTING", 2, 2);
            FORWARD_PERMISSION_SETTING = r3;
            Field r5 = new Field("COPY_PERMISSION_SETTING", 3, 3);
            COPY_PERMISSION_SETTING = r5;
            Field r7 = new Field("DOWNLOAD_PERMISSION_SETTING", 4, 4);
            DOWNLOAD_PERMISSION_SETTING = r7;
            Field r9 = new Field("SCREENSHOT_PERNISSION_SETTING", 5, 5);
            SCREENSHOT_PERNISSION_SETTING = r9;
            Field r11 = new Field("DEF_DISPLAY_SETTING", 6, 6);
            DEF_DISPLAY_SETTING = r11;
            Field r13 = new Field("ON_TIME_DEL_MSG_SETTING_STATUS", 7, 7);
            ON_TIME_DEL_MSG_SETTING_STATUS = r13;
            Field r15 = new Field("ON_TIME_DEL_MSG_SETTING_ALIVE_TIME", 8, 8);
            ON_TIME_DEL_MSG_SETTING_ALIVE_TIME = r15;
            Field r14 = new Field("WHITE_LIST_SETTING_LEVEL", 9, 9);
            WHITE_LIST_SETTING_LEVEL = r14;
            Field r12 = new Field("WHITE_LIST_SETTING_USERS", 10, 10);
            WHITE_LIST_SETTING_USERS = r12;
            Field r10 = new Field("DOUBAO_SETTING_DOUBAO_ENABLE", 11, 11);
            DOUBAO_SETTING_DOUBAO_ENABLE = r10;
            Field r8 = new Field("DOUBAO_SETTING_PROACTIVE_REPLY_ENABLE", 12, 12);
            DOUBAO_SETTING_PROACTIVE_REPLY_ENABLE = r8;
            $VALUES = new Field[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8};
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
                case 0: goto L30;
                case 1: goto L28;
                case 2: goto L26;
                case 3: goto L24;
                case 4: goto L22;
                case 5: goto L20;
                case 6: goto L18;
                case 7: goto L16;
                case 8: goto L14;
                case 9: goto L12;
                case 10: goto L10;
                case 11: goto L8;
                case 12: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return DOUBAO_SETTING_PROACTIVE_REPLY_ENABLE;
        L8:
            return DOUBAO_SETTING_DOUBAO_ENABLE;
        L10:
            return WHITE_LIST_SETTING_USERS;
        L12:
            return WHITE_LIST_SETTING_LEVEL;
        L14:
            return ON_TIME_DEL_MSG_SETTING_ALIVE_TIME;
        L16:
            return ON_TIME_DEL_MSG_SETTING_STATUS;
        L18:
            return DEF_DISPLAY_SETTING;
        L20:
            return SCREENSHOT_PERNISSION_SETTING;
        L22:
            return DOWNLOAD_PERMISSION_SETTING;
        L24:
            return COPY_PERMISSION_SETTING;
        L26:
            return FORWARD_PERMISSION_SETTING;
        L28:
            return RESTRICTED_MODE_PERMISSION_SETTING;
        L30:
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

    public static final class ForwardPermissionSetting extends com.squareup.wire.Message<ForwardPermissionSetting, Builder> {
        public static final ProtoAdapter<ForwardPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ForwardPermissionSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ForwardPermissionSetting m1234build() {
                return new ForwardPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1234build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum NO_MEMBER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("NO_MEMBER", 2, 2);
                NO_MEMBER = r3;
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
                return NO_MEMBER;
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

        public static final class ProtoAdapter_ForwardPermissionSetting extends ProtoAdapter<ForwardPermissionSetting> {
            public ProtoAdapter_ForwardPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ForwardPermissionSetting.class);
            }

            public ForwardPermissionSetting decode(ProtoReader r7) throws IOException {
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
                return r0.m1234build();
            }

            public int encodedSize(ForwardPermissionSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1235decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ForwardPermissionSetting) r1);
            }

            public void encode(ProtoWriter r1, ForwardPermissionSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ForwardPermissionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ForwardPermissionSetting();
        }

        public ForwardPermissionSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1233newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ForwardPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1233newBuilder();
        }

        public ForwardPermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class OnTimeDelMsgPermissionSetting extends com.squareup.wire.Message<OnTimeDelMsgPermissionSetting, Builder> {
        public static final ProtoAdapter<OnTimeDelMsgPermissionSetting> ADAPTER = null;
        public static final Long DEFAULT_ALIVE_TIME = null;
        public static final Boolean DEFAULT_STATUS = null;
        private static final long serialVersionUID = 0;
        public final Long malive_time;
        public final Boolean mstatus;

        public static final class Builder extends com.squareup.wire.Message.Builder<OnTimeDelMsgPermissionSetting, Builder> {
            public Long malive_time;
            public Boolean mstatus;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public OnTimeDelMsgPermissionSetting m1237build() {
                return new OnTimeDelMsgPermissionSetting(this.mstatus, this.malive_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1237build();
            }

            public Builder alive_time(Long r1) {
                this.malive_time = r1;
                return this;
            }

            public Builder status(Boolean r1) {
                this.mstatus = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_OnTimeDelMsgPermissionSetting extends ProtoAdapter<OnTimeDelMsgPermissionSetting> {
            public ProtoAdapter_OnTimeDelMsgPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, OnTimeDelMsgPermissionSetting.class);
            }

            public OnTimeDelMsgPermissionSetting decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mstatus = Boolean.FALSE;
                r0.malive_time = 0L;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mstatus = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.malive_time = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m1237build();
            }

            public int encodedSize(OnTimeDelMsgPermissionSetting r5) {
                Boolean r0 = r5.mstatus;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                Long r3 = r5.malive_time;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1238decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((OnTimeDelMsgPermissionSetting) r1);
            }

            public void encode(ProtoWriter r4, OnTimeDelMsgPermissionSetting r5) throws IOException {
                Boolean r0 = r5.mstatus;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                Long r1 = r5.malive_time;
                if (r1 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (OnTimeDelMsgPermissionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OnTimeDelMsgPermissionSetting();
            DEFAULT_STATUS = Boolean.FALSE;
            DEFAULT_ALIVE_TIME = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1236newBuilder() {
            Builder r0 = new Builder();
            r0.mstatus = this.mstatus;
            r0.malive_time = this.malive_time;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return OnTimeDelMsgPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1236newBuilder();
        }

        public OnTimeDelMsgPermissionSetting(Boolean r2, Long r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public OnTimeDelMsgPermissionSetting(Boolean r2, Long r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mstatus = r2;
            this.malive_time = r3;
        }
    }

    public static final class ProtoAdapter_GeneralChatSetting extends ProtoAdapter<GeneralChatSetting> {
        public ProtoAdapter_GeneralChatSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, GeneralChatSetting.class);
        }

        public GeneralChatSetting decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mrestricted_mode_permission_setting = (RestrictedModePermissionSetting) RestrictedModePermissionSetting.ADAPTER.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mdef_display_setting = (DefDisplaySetting) DefDisplaySetting.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mdoubao_setting = (DoubaoSetting) DoubaoSetting.ADAPTER.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m1223build();
        }

        public int encodedSize(GeneralChatSetting r6) {
            RestrictedModePermissionSetting r0 = r6.mrestricted_mode_permission_setting;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = RestrictedModePermissionSetting.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            DefDisplaySetting r3 = r6.mdef_display_setting;
            if (r3 == null) goto L9;
            int r4 = DefDisplaySetting.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            DoubaoSetting r7 = r6.mdoubao_setting;
            if (r7 == null) goto L14;
            r1 = DoubaoSetting.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1239decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GeneralChatSetting) r1);
        }

        public void encode(ProtoWriter r4, GeneralChatSetting r5) throws IOException {
            RestrictedModePermissionSetting r0 = r5.mrestricted_mode_permission_setting;
            if (r0 == null) goto L5;
            RestrictedModePermissionSetting.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            DefDisplaySetting r1 = r5.mdef_display_setting;
            if (r1 == null) goto L8;
            DefDisplaySetting.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            DoubaoSetting r2 = r5.mdoubao_setting;
            if (r2 == null) goto L11;
            DoubaoSetting.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GeneralChatSetting) r2);
        }
    }

    public static final class RestrictedModePermissionSetting extends com.squareup.wire.Message<RestrictedModePermissionSetting, Builder> {
        public static final ProtoAdapter<RestrictedModePermissionSetting> ADAPTER = null;
        public static final Boolean DEFAULT_STATUS = null;
        private static final long serialVersionUID = 0;
        public final CopyPermissionSetting.Enum mcopy_permission_setting;
        public final DownloadPermissionSetting.Enum mdownload_permission_setting;
        public final OnTimeDelMsgPermissionSetting mon_time_del_msg_permission_setting;
        public final ScreenshotPermissionSetting.Enum mscreenshot_permission_setting;
        public final Boolean mstatus;
        public final ForwardPermissionSetting.Enum mtransmit_permission_setting;
        public final WhiteListSetting mwhite_list_setting;

        public static final class Builder extends com.squareup.wire.Message.Builder<RestrictedModePermissionSetting, Builder> {
            public CopyPermissionSetting.Enum mcopy_permission_setting;
            public DownloadPermissionSetting.Enum mdownload_permission_setting;
            public OnTimeDelMsgPermissionSetting mon_time_del_msg_permission_setting;
            public ScreenshotPermissionSetting.Enum mscreenshot_permission_setting;
            public Boolean mstatus;
            public ForwardPermissionSetting.Enum mtransmit_permission_setting;
            public WhiteListSetting mwhite_list_setting;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public RestrictedModePermissionSetting m1241build() {
                return new RestrictedModePermissionSetting(this.mstatus, this.mtransmit_permission_setting, this.mcopy_permission_setting, this.mdownload_permission_setting, this.mscreenshot_permission_setting, this.mon_time_del_msg_permission_setting, this.mwhite_list_setting, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1241build();
            }

            public Builder copy_permission_setting(CopyPermissionSetting.Enum r1) {
                this.mcopy_permission_setting = r1;
                return this;
            }

            public Builder download_permission_setting(DownloadPermissionSetting.Enum r1) {
                this.mdownload_permission_setting = r1;
                return this;
            }

            public Builder on_time_del_msg_permission_setting(OnTimeDelMsgPermissionSetting r1) {
                this.mon_time_del_msg_permission_setting = r1;
                return this;
            }

            public Builder screenshot_permission_setting(ScreenshotPermissionSetting.Enum r1) {
                this.mscreenshot_permission_setting = r1;
                return this;
            }

            public Builder status(Boolean r1) {
                this.mstatus = r1;
                return this;
            }

            public Builder transmit_permission_setting(ForwardPermissionSetting.Enum r1) {
                this.mtransmit_permission_setting = r1;
                return this;
            }

            public Builder white_list_setting(WhiteListSetting r1) {
                this.mwhite_list_setting = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_RestrictedModePermissionSetting extends ProtoAdapter<RestrictedModePermissionSetting> {
            public ProtoAdapter_RestrictedModePermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, RestrictedModePermissionSetting.class);
            }

            public RestrictedModePermissionSetting decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mstatus = Boolean.FALSE;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L26;
                switch(r3) {
                    case 1: goto L25;
                    case 2: goto L30;
                    case 3: goto L32;
                    case 4: goto L28;
                    case 5: goto L34;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L28:
                r0.mdownload_permission_setting = (DownloadPermissionSetting.Enum) DownloadPermissionSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L30:
                r0.mtransmit_permission_setting = (ForwardPermissionSetting.Enum) ForwardPermissionSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            L23:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L32:
                r0.mcopy_permission_setting = (CopyPermissionSetting.Enum) CopyPermissionSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L34:
                r0.mscreenshot_permission_setting = (ScreenshotPermissionSetting.Enum) ScreenshotPermissionSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
            L11:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mwhite_list_setting = (WhiteListSetting) WhiteListSetting.ADAPTER.decode(r9);
                goto L3
            L8:
                r0.mon_time_del_msg_permission_setting = (OnTimeDelMsgPermissionSetting) OnTimeDelMsgPermissionSetting.ADAPTER.decode(r9);
                goto L3
            L25:
                r0.mstatus = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L26:
                r9.endMessage(r1);
                return r0.m1241build();
            }

            public int encodedSize(RestrictedModePermissionSetting r6) {
                Boolean r0 = r6.mstatus;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                ForwardPermissionSetting.Enum r3 = r6.mtransmit_permission_setting;
                if (r3 == null) goto L9;
                int r4 = ForwardPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                CopyPermissionSetting.Enum r7 = r6.mcopy_permission_setting;
                if (r7 == null) goto L13;
                int r8 = CopyPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                DownloadPermissionSetting.Enum r10 = r6.mdownload_permission_setting;
                if (r10 == null) goto L17;
                int r11 = DownloadPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                ScreenshotPermissionSetting.Enum r13 = r6.mscreenshot_permission_setting;
                if (r13 == null) goto L21;
                int r14 = ScreenshotPermissionSetting.Enum.ADAPTER.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                OnTimeDelMsgPermissionSetting r16 = r6.mon_time_del_msg_permission_setting;
                if (r16 == null) goto L25;
                int r17 = OnTimeDelMsgPermissionSetting.ADAPTER.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                WhiteListSetting r19 = r6.mwhite_list_setting;
                if (r19 == null) goto L30;
                r1 = WhiteListSetting.ADAPTER.encodedSizeWithTag(7, r19);
            L30:
                return (r18 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1242decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((RestrictedModePermissionSetting) r1);
            }

            public void encode(ProtoWriter r4, RestrictedModePermissionSetting r5) throws IOException {
                Boolean r0 = r5.mstatus;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                ForwardPermissionSetting.Enum r1 = r5.mtransmit_permission_setting;
                if (r1 == null) goto L8;
                ForwardPermissionSetting.Enum.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                CopyPermissionSetting.Enum r2 = r5.mcopy_permission_setting;
                if (r2 == null) goto L11;
                CopyPermissionSetting.Enum.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                DownloadPermissionSetting.Enum r3 = r5.mdownload_permission_setting;
                if (r3 == null) goto L14;
                DownloadPermissionSetting.Enum.ADAPTER.encodeWithTag(r4, 4, r3);
            L14:
                ScreenshotPermissionSetting.Enum r6 = r5.mscreenshot_permission_setting;
                if (r6 == null) goto L17;
                ScreenshotPermissionSetting.Enum.ADAPTER.encodeWithTag(r4, 5, r6);
            L17:
                OnTimeDelMsgPermissionSetting r7 = r5.mon_time_del_msg_permission_setting;
                if (r7 == null) goto L20;
                OnTimeDelMsgPermissionSetting.ADAPTER.encodeWithTag(r4, 6, r7);
            L20:
                WhiteListSetting r8 = r5.mwhite_list_setting;
                if (r8 == null) goto L23;
                WhiteListSetting.ADAPTER.encodeWithTag(r4, 7, r8);
            L23:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (RestrictedModePermissionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RestrictedModePermissionSetting();
            DEFAULT_STATUS = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1240newBuilder() {
            Builder r0 = new Builder();
            r0.mstatus = this.mstatus;
            r0.mtransmit_permission_setting = this.mtransmit_permission_setting;
            r0.mcopy_permission_setting = this.mcopy_permission_setting;
            r0.mdownload_permission_setting = this.mdownload_permission_setting;
            r0.mscreenshot_permission_setting = this.mscreenshot_permission_setting;
            r0.mon_time_del_msg_permission_setting = this.mon_time_del_msg_permission_setting;
            r0.mwhite_list_setting = this.mwhite_list_setting;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return RestrictedModePermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1240newBuilder();
        }

        public RestrictedModePermissionSetting(Boolean r10, ForwardPermissionSetting.Enum r11, CopyPermissionSetting.Enum r12, DownloadPermissionSetting.Enum r13, ScreenshotPermissionSetting.Enum r14, OnTimeDelMsgPermissionSetting r15, WhiteListSetting r16) {
            this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
        }

        public RestrictedModePermissionSetting(Boolean r2, ForwardPermissionSetting.Enum r3, CopyPermissionSetting.Enum r4, DownloadPermissionSetting.Enum r5, ScreenshotPermissionSetting.Enum r6, OnTimeDelMsgPermissionSetting r7, WhiteListSetting r8, ByteString r9) {
            super(ADAPTER, r9);
            this.mstatus = r2;
            this.mtransmit_permission_setting = r3;
            this.mcopy_permission_setting = r4;
            this.mdownload_permission_setting = r5;
            this.mscreenshot_permission_setting = r6;
            this.mon_time_del_msg_permission_setting = r7;
            this.mwhite_list_setting = r8;
        }
    }

    public static final class ScreenshotPermissionSetting extends com.squareup.wire.Message<ScreenshotPermissionSetting, Builder> {
        public static final ProtoAdapter<ScreenshotPermissionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<ScreenshotPermissionSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ScreenshotPermissionSetting m1244build() {
                return new ScreenshotPermissionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1244build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum ALL_MEMBERS = null;
            public static final Enum NO_MEMBER = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("ALL_MEMBERS", 1, 1);
                ALL_MEMBERS = r1;
                Enum r3 = new Enum("NO_MEMBER", 2, 2);
                NO_MEMBER = r3;
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
                return NO_MEMBER;
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

        public static final class ProtoAdapter_ScreenshotPermissionSetting extends ProtoAdapter<ScreenshotPermissionSetting> {
            public ProtoAdapter_ScreenshotPermissionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, ScreenshotPermissionSetting.class);
            }

            public ScreenshotPermissionSetting decode(ProtoReader r7) throws IOException {
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
                return r0.m1244build();
            }

            public int encodedSize(ScreenshotPermissionSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1245decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ScreenshotPermissionSetting) r1);
            }

            public void encode(ProtoWriter r1, ScreenshotPermissionSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ScreenshotPermissionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ScreenshotPermissionSetting();
        }

        public ScreenshotPermissionSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1243newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ScreenshotPermissionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1243newBuilder();
        }

        public ScreenshotPermissionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class WhiteListSetting extends com.squareup.wire.Message<WhiteListSetting, Builder> {
        public static final ProtoAdapter<WhiteListSetting> ADAPTER = null;
        public static final Boolean DEFAULT_HIT_WHITELIST = null;
        private static final long serialVersionUID = 0;
        public final List<Long> madd_user_ids;
        public final List<Long> mdel_user_ids;
        public final Boolean mhit_whitelist;
        public final LevelEnum mlevel;
        public final List<Long> muser_ids;

        public static final class Builder extends com.squareup.wire.Message.Builder<WhiteListSetting, Builder> {
            public List<Long> madd_user_ids;
            public List<Long> mdel_user_ids;
            public Boolean mhit_whitelist;
            public LevelEnum mlevel;
            public List<Long> muser_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public WhiteListSetting m1247build() {
                return new WhiteListSetting(this.mlevel, this.madd_user_ids, this.mdel_user_ids, this.muser_ids, this.mhit_whitelist, super.buildUnknownFields());
            }

            public Builder() {
                this.madd_user_ids = Internal.newMutableList();
                this.mdel_user_ids = Internal.newMutableList();
                this.muser_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1247build();
            }

            public Builder add_user_ids(List<Long> r1) {
                Internal.checkElementsNotNull(r1);
                this.madd_user_ids = r1;
                return this;
            }

            public Builder del_user_ids(List<Long> r1) {
                Internal.checkElementsNotNull(r1);
                this.mdel_user_ids = r1;
                return this;
            }

            public Builder hit_whitelist(Boolean r1) {
                this.mhit_whitelist = r1;
                return this;
            }

            public Builder level(LevelEnum r1) {
                this.mlevel = r1;
                return this;
            }

            public Builder user_ids(List<Long> r1) {
                Internal.checkElementsNotNull(r1);
                this.muser_ids = r1;
                return this;
            }
        }

        public static final enum LevelEnum extends Enum<LevelEnum> implements WireEnum {
            private static final /* synthetic */ LevelEnum[] $VALUES = null;
            public static final ProtoAdapter<LevelEnum> ADAPTER = null;
            public static final LevelEnum MEMBER_LIST = null;
            public static final LevelEnum NO_MEMBER = null;
            public static final LevelEnum ONLY_ADMIN_AND_OWNER = null;
            public static final LevelEnum UNKNOWN = null;
            private final int value;

            static {
                LevelEnum r0 = new LevelEnum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                LevelEnum r1 = new LevelEnum("NO_MEMBER", 1, 1);
                NO_MEMBER = r1;
                LevelEnum r3 = new LevelEnum("ONLY_ADMIN_AND_OWNER", 2, 2);
                ONLY_ADMIN_AND_OWNER = r3;
                LevelEnum r5 = new LevelEnum("MEMBER_LIST", 3, 3);
                MEMBER_LIST = r5;
                $VALUES = new LevelEnum[]{r0, r1, r3, r5};
                ADAPTER = ProtoAdapter.newEnumAdapter(LevelEnum.class);
            }

            public static LevelEnum[] values() {
                return (LevelEnum[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static LevelEnum fromValue(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return MEMBER_LIST;
            L14:
                return ONLY_ADMIN_AND_OWNER;
            L16:
                return NO_MEMBER;
            L18:
                return UNKNOWN;
            }

            public static LevelEnum valueOf(String r1) {
                return (LevelEnum) a.a(LevelEnum.class, r1);
            }

            private LevelEnum(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_WhiteListSetting extends ProtoAdapter<WhiteListSetting> {
            public ProtoAdapter_WhiteListSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, WhiteListSetting.class);
            }

            public WhiteListSetting decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mhit_whitelist = Boolean.FALSE;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L24;
                if (r3 != 1) goto L8;
                r0.mlevel = (LevelEnum) LevelEnum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.madd_user_ids.add((Long) ProtoAdapter.INT64.decode(r9));
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mdel_user_ids.add((Long) ProtoAdapter.INT64.decode(r9));
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.muser_ids.add((Long) ProtoAdapter.INT64.decode(r9));
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.mhit_whitelist = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L15:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L24:
                r9.endMessage(r1);
                return r0.m1247build();
            }

            public int encodedSize(WhiteListSetting r7) {
                LevelEnum r0 = r7.mlevel;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = LevelEnum.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                ProtoAdapter r3 = ProtoAdapter.INT64;
                int r4 = ((r2 + r3.asRepeated().encodedSizeWithTag(2, r7.madd_user_ids)) + r3.asRepeated().encodedSizeWithTag(3, r7.mdel_user_ids)) + r3.asRepeated().encodedSizeWithTag(4, r7.muser_ids);
                Boolean r5 = r7.mhit_whitelist;
                if (r5 == null) goto L10;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r5);
            L10:
                return (r4 + r1) + r7.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1248decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((WhiteListSetting) r1);
            }

            public void encode(ProtoWriter r5, WhiteListSetting r6) throws IOException {
                LevelEnum r0 = r6.mlevel;
                if (r0 == null) goto L5;
                LevelEnum.ADAPTER.encodeWithTag(r5, 1, r0);
            L5:
                ProtoAdapter r1 = ProtoAdapter.INT64;
                r1.asRepeated().encodeWithTag(r5, 2, r6.madd_user_ids);
                r1.asRepeated().encodeWithTag(r5, 3, r6.mdel_user_ids);
                r1.asRepeated().encodeWithTag(r5, 4, r6.muser_ids);
                Boolean r2 = r6.mhit_whitelist;
                if (r2 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r5, 5, r2);
            L8:
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (WhiteListSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_WhiteListSetting();
            DEFAULT_HIT_WHITELIST = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1246newBuilder() {
            Builder r0 = new Builder();
            r0.mlevel = this.mlevel;
            r0.madd_user_ids = Internal.copyOf("madd_user_ids", this.madd_user_ids);
            r0.mdel_user_ids = Internal.copyOf("mdel_user_ids", this.mdel_user_ids);
            r0.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r0.mhit_whitelist = this.mhit_whitelist;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return WhiteListSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1246newBuilder();
        }

        public WhiteListSetting(LevelEnum r8, List<Long> r9, List<Long> r10, List<Long> r11, Boolean r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public WhiteListSetting(LevelEnum r2, List<Long> r3, List<Long> r4, List<Long> r5, Boolean r6, ByteString r7) {
            super(ADAPTER, r7);
            this.mlevel = r2;
            this.madd_user_ids = Internal.immutableCopyOf("madd_user_ids", r3);
            this.mdel_user_ids = Internal.immutableCopyOf("mdel_user_ids", r4);
            this.muser_ids = Internal.immutableCopyOf("muser_ids", r5);
            this.mhit_whitelist = r6;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GeneralChatSetting();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1222newBuilder() {
        Builder r0 = new Builder();
        r0.mrestricted_mode_permission_setting = this.mrestricted_mode_permission_setting;
        r0.mdef_display_setting = this.mdef_display_setting;
        r0.mdoubao_setting = this.mdoubao_setting;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GeneralChatSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1222newBuilder();
    }

    public GeneralChatSetting(RestrictedModePermissionSetting r2, DefDisplaySetting r3, DoubaoSetting r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public GeneralChatSetting(RestrictedModePermissionSetting r2, DefDisplaySetting r3, DoubaoSetting r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mrestricted_mode_permission_setting = r2;
        this.mdef_display_setting = r3;
        this.mdoubao_setting = r4;
    }
}
