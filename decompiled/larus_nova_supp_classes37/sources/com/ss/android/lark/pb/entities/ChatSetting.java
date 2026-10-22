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
public final class ChatSetting extends com.squareup.wire.Message<ChatSetting, Builder> {
    public static final ProtoAdapter<ChatSetting> ADAPTER = null;
    public static final Long DEFAULT_ANONYMOUS_USER_ID = null;
    public static final Boolean DEFAULT_IS_AUTO_TRANSLATE = null;
    public static final Long DEFAULT_IS_AUTO_TRANSLATE_VERSION = null;
    public static final Boolean DEFAULT_IS_HIDDEN_NICKNAME = null;
    public static final Boolean DEFAULT_IS_MUTE_AT_ALL = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final Long manonymous_user_id;
    public final ChatNameTranslateEntity mchat_name_translate;
    public final CheckMessagePositionSetting.Enum mcheck_message_position;
    public final Boolean mis_auto_translate;
    public final Long mis_auto_translate_version;
    public final Boolean mis_hidden_nickname;
    public final Boolean mis_mute_at_all;
    public final Boolean mis_remind;
    public final TypingTranslateEntity mtyping_translate;
    public final Long mupdate_time;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatSetting, Builder> {
        public Long manonymous_user_id;
        public ChatNameTranslateEntity mchat_name_translate;
        public CheckMessagePositionSetting.Enum mcheck_message_position;
        public Boolean mis_auto_translate;
        public Long mis_auto_translate_version;
        public Boolean mis_hidden_nickname;
        public Boolean mis_mute_at_all;
        public Boolean mis_remind;
        public TypingTranslateEntity mtyping_translate;
        public Long mupdate_time;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatSetting m1151build() {
            return new ChatSetting(this.mis_remind, this.mupdate_time, this.mcheck_message_position, this.mis_auto_translate, this.mis_hidden_nickname, this.mis_auto_translate_version, this.manonymous_user_id, this.mis_mute_at_all, this.mtyping_translate, this.mchat_name_translate, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1151build();
        }

        public Builder anonymous_user_id(Long r1) {
            this.manonymous_user_id = r1;
            return this;
        }

        public Builder chat_name_translate(ChatNameTranslateEntity r1) {
            this.mchat_name_translate = r1;
            return this;
        }

        public Builder check_message_position(CheckMessagePositionSetting.Enum r1) {
            this.mcheck_message_position = r1;
            return this;
        }

        public Builder is_auto_translate(Boolean r1) {
            this.mis_auto_translate = r1;
            return this;
        }

        public Builder is_auto_translate_version(Long r1) {
            this.mis_auto_translate_version = r1;
            return this;
        }

        public Builder is_hidden_nickname(Boolean r1) {
            this.mis_hidden_nickname = r1;
            return this;
        }

        public Builder is_mute_at_all(Boolean r1) {
            this.mis_mute_at_all = r1;
            return this;
        }

        public Builder is_remind(Boolean r1) {
            this.mis_remind = r1;
            return this;
        }

        public Builder typing_translate(TypingTranslateEntity r1) {
            this.mtyping_translate = r1;
            return this;
        }

        public Builder update_time(Long r1) {
            this.mupdate_time = r1;
            return this;
        }
    }

    public static final class ChatNameTranslateEntity extends com.squareup.wire.Message<ChatNameTranslateEntity, Builder> {
        public static final ProtoAdapter<ChatNameTranslateEntity> ADAPTER = null;
        public static final String DEFAULT_CHAT_NAME_TARGET_LANGUAGE = "";
        public static final Boolean DEFAULT_IS_MANUAL_TRANSLATE_CHAT_NAME = null;
        private static final long serialVersionUID = 0;
        public final String mchat_name_target_language;
        public final DisplayRule mdisplay_rule;
        public final Boolean mis_manual_translate_chat_name;

        public static final class Builder extends com.squareup.wire.Message.Builder<ChatNameTranslateEntity, Builder> {
            public String mchat_name_target_language;
            public DisplayRule mdisplay_rule;
            public Boolean mis_manual_translate_chat_name;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ChatNameTranslateEntity m1153build() {
                return new ChatNameTranslateEntity(this.mis_manual_translate_chat_name, this.mdisplay_rule, this.mchat_name_target_language, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1153build();
            }

            public Builder chat_name_target_language(String r1) {
                this.mchat_name_target_language = r1;
                return this;
            }

            public Builder display_rule(DisplayRule r1) {
                this.mdisplay_rule = r1;
                return this;
            }

            public Builder is_manual_translate_chat_name(Boolean r1) {
                this.mis_manual_translate_chat_name = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatNameTranslateEntity extends ProtoAdapter<ChatNameTranslateEntity> {
            public ProtoAdapter_ChatNameTranslateEntity() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatNameTranslateEntity.class);
            }

            public ChatNameTranslateEntity decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mis_manual_translate_chat_name = Boolean.FALSE;
                r0.mchat_name_target_language = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mis_manual_translate_chat_name = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mdisplay_rule = (DisplayRule) DisplayRule.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mchat_name_target_language = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L18:
                r9.endMessage(r1);
                return r0.m1153build();
            }

            public int encodedSize(ChatNameTranslateEntity r6) {
                Boolean r0 = r6.mis_manual_translate_chat_name;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                DisplayRule r3 = r6.mdisplay_rule;
                if (r3 == null) goto L9;
                int r4 = DisplayRule.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mchat_name_target_language;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m1154decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ChatNameTranslateEntity) r1);
            }

            public void encode(ProtoWriter r4, ChatNameTranslateEntity r5) throws IOException {
                Boolean r0 = r5.mis_manual_translate_chat_name;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                DisplayRule r1 = r5.mdisplay_rule;
                if (r1 == null) goto L8;
                DisplayRule.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mchat_name_target_language;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ChatNameTranslateEntity) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatNameTranslateEntity();
            DEFAULT_IS_MANUAL_TRANSLATE_CHAT_NAME = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1152newBuilder() {
            Builder r0 = new Builder();
            r0.mis_manual_translate_chat_name = this.mis_manual_translate_chat_name;
            r0.mdisplay_rule = this.mdisplay_rule;
            r0.mchat_name_target_language = this.mchat_name_target_language;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ChatNameTranslateEntity.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1152newBuilder();
        }

        public ChatNameTranslateEntity(Boolean r2, DisplayRule r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public ChatNameTranslateEntity(Boolean r2, DisplayRule r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mis_manual_translate_chat_name = r2;
            this.mdisplay_rule = r3;
            this.mchat_name_target_language = r4;
        }
    }

    public static final class CheckMessagePositionSetting extends com.squareup.wire.Message<CheckMessagePositionSetting, Builder> {
        public static final ProtoAdapter<CheckMessagePositionSetting> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends com.squareup.wire.Message.Builder<CheckMessagePositionSetting, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CheckMessagePositionSetting m1156build() {
                return new CheckMessagePositionSetting(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1156build();
            }
        }

        public static final enum Enum extends java.lang.Enum<Enum> implements WireEnum {
            private static final /* synthetic */ Enum[] $VALUES = null;
            public static final ProtoAdapter<Enum> ADAPTER = null;
            public static final Enum NEWEST_UNREAD = null;
            public static final Enum RECENT_LEFT = null;
            public static final Enum UNKNOWN = null;
            private final int value;

            static {
                Enum r0 = new Enum("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Enum r1 = new Enum("RECENT_LEFT", 1, 1);
                RECENT_LEFT = r1;
                Enum r3 = new Enum("NEWEST_UNREAD", 2, 2);
                NEWEST_UNREAD = r3;
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
                return NEWEST_UNREAD;
            L12:
                return RECENT_LEFT;
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

        public static final class ProtoAdapter_CheckMessagePositionSetting extends ProtoAdapter<CheckMessagePositionSetting> {
            public ProtoAdapter_CheckMessagePositionSetting() {
                super(FieldEncoding.LENGTH_DELIMITED, CheckMessagePositionSetting.class);
            }

            public CheckMessagePositionSetting decode(ProtoReader r7) throws IOException {
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
                return r0.m1156build();
            }

            public int encodedSize(CheckMessagePositionSetting r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1157decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CheckMessagePositionSetting) r1);
            }

            public void encode(ProtoWriter r1, CheckMessagePositionSetting r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CheckMessagePositionSetting) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CheckMessagePositionSetting();
        }

        public CheckMessagePositionSetting() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1155newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CheckMessagePositionSetting.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1155newBuilder();
        }

        public CheckMessagePositionSetting(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final enum Field extends Enum<Field> implements WireEnum {
        private static final /* synthetic */ Field[] $VALUES = null;
        public static final ProtoAdapter<Field> ADAPTER = null;
        public static final Field CAN_AUTO_OPEN_V1 = null;
        public static final Field CAN_AUTO_OPEN_V3 = null;
        public static final Field CHAT_NAME_TRANSLATE = null;
        public static final Field CHECK_MESSAGE_POSITION = null;
        public static final Field ENABLE_USE_TRANSLATE_ORIGINAL = null;
        public static final Field IS_AUTO_TRANSLATE = null;
        public static final Field IS_HIDDEN_NICKNAME = null;
        public static final Field IS_MUTE_AT_ALL = null;
        public static final Field IS_REMIND = null;
        public static final Field TYPING_TRANSLATE = null;
        public static final Field UNKNOWN = null;
        public static final Field UPDATE_TIME = null;
        private final int value;

        static {
            Field r0 = new Field("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Field r1 = new Field("IS_REMIND", 1, 1);
            IS_REMIND = r1;
            Field r3 = new Field("UPDATE_TIME", 2, 2);
            UPDATE_TIME = r3;
            Field r5 = new Field("CHECK_MESSAGE_POSITION", 3, 3);
            CHECK_MESSAGE_POSITION = r5;
            Field r7 = new Field("IS_AUTO_TRANSLATE", 4, 4);
            IS_AUTO_TRANSLATE = r7;
            Field r9 = new Field("IS_HIDDEN_NICKNAME", 5, 5);
            IS_HIDDEN_NICKNAME = r9;
            Field r11 = new Field("IS_MUTE_AT_ALL", 6, 6);
            IS_MUTE_AT_ALL = r11;
            Field r13 = new Field("TYPING_TRANSLATE", 7, 7);
            TYPING_TRANSLATE = r13;
            Field r15 = new Field("ENABLE_USE_TRANSLATE_ORIGINAL", 8, 8);
            ENABLE_USE_TRANSLATE_ORIGINAL = r15;
            Field r14 = new Field("CAN_AUTO_OPEN_V1", 9, 9);
            CAN_AUTO_OPEN_V1 = r14;
            Field r12 = new Field("CAN_AUTO_OPEN_V3", 10, 10);
            CAN_AUTO_OPEN_V3 = r12;
            Field r10 = new Field("CHAT_NAME_TRANSLATE", 11, 11);
            CHAT_NAME_TRANSLATE = r10;
            $VALUES = new Field[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
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
                case 0: goto L28;
                case 1: goto L26;
                case 2: goto L24;
                case 3: goto L22;
                case 4: goto L20;
                case 5: goto L18;
                case 6: goto L16;
                case 7: goto L14;
                case 8: goto L12;
                case 9: goto L10;
                case 10: goto L8;
                case 11: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return CHAT_NAME_TRANSLATE;
        L8:
            return CAN_AUTO_OPEN_V3;
        L10:
            return CAN_AUTO_OPEN_V1;
        L12:
            return ENABLE_USE_TRANSLATE_ORIGINAL;
        L14:
            return TYPING_TRANSLATE;
        L16:
            return IS_MUTE_AT_ALL;
        L18:
            return IS_HIDDEN_NICKNAME;
        L20:
            return IS_AUTO_TRANSLATE;
        L22:
            return CHECK_MESSAGE_POSITION;
        L24:
            return UPDATE_TIME;
        L26:
            return IS_REMIND;
        L28:
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

    public static final class ProtoAdapter_ChatSetting extends ProtoAdapter<ChatSetting> {
        public ProtoAdapter_ChatSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatSetting.class);
        }

        public ChatSetting decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mis_remind = Boolean.TRUE;
            r0.mupdate_time = 0L;
            Boolean r2 = Boolean.FALSE;
            r0.mis_auto_translate = r2;
            r0.mis_hidden_nickname = r2;
            r0.mis_auto_translate_version = 0L;
            r0.manonymous_user_id = 0L;
            r0.mis_mute_at_all = r2;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L20;
            switch(r3) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L22;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L22:
            r0.mcheck_message_position = (CheckMessagePositionSetting.Enum) CheckMessagePositionSetting.Enum.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mchat_name_translate = (ChatNameTranslateEntity) ChatNameTranslateEntity.ADAPTER.decode(r9);
            goto L3
        L8:
            r0.mtyping_translate = (TypingTranslateEntity) TypingTranslateEntity.ADAPTER.decode(r9);
            goto L3
        L9:
            r0.mis_mute_at_all = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L10:
            r0.manonymous_user_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L11:
            r0.mis_auto_translate_version = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L12:
            r0.mis_hidden_nickname = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L13:
            r0.mis_auto_translate = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L18:
            r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L19:
            r0.mis_remind = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L20:
            r9.endMessage(r1);
            return r0.m1151build();
        }

        public int encodedSize(ChatSetting r6) {
            Boolean r0 = r6.mis_remind;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r6.mupdate_time;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            CheckMessagePositionSetting.Enum r7 = r6.mcheck_message_position;
            if (r7 == null) goto L13;
            int r8 = CheckMessagePositionSetting.Enum.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.mis_auto_translate;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Boolean r13 = r6.mis_hidden_nickname;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Long r16 = r6.mis_auto_translate_version;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.INT64.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Long r19 = r6.manonymous_user_id;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.INT64.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            Boolean r22 = r6.mis_mute_at_all;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r22);
        L34:
            int r24 = r21 + r23;
            TypingTranslateEntity r25 = r6.mtyping_translate;
            if (r25 == null) goto L37;
            int r26 = TypingTranslateEntity.ADAPTER.encodedSizeWithTag(9, r25);
        L38:
            int r27 = r24 + r26;
            ChatNameTranslateEntity r28 = r6.mchat_name_translate;
            if (r28 == null) goto L42;
            r1 = ChatNameTranslateEntity.ADAPTER.encodedSizeWithTag(10, r28);
        L42:
            return (r27 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m1158decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatSetting) r1);
        }

        public void encode(ProtoWriter r4, ChatSetting r5) throws IOException {
            Boolean r0 = r5.mis_remind;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.mupdate_time;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            CheckMessagePositionSetting.Enum r2 = r5.mcheck_message_position;
            if (r2 == null) goto L11;
            CheckMessagePositionSetting.Enum.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            Boolean r3 = r5.mis_auto_translate;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
        L14:
            Boolean r6 = r5.mis_hidden_nickname;
            if (r6 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
        L17:
            Long r7 = r5.mis_auto_translate_version;
            if (r7 == null) goto L20;
            ProtoAdapter.INT64.encodeWithTag(r4, 6, r7);
        L20:
            Long r8 = r5.manonymous_user_id;
            if (r8 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r4, 7, r8);
        L23:
            Boolean r9 = r5.mis_mute_at_all;
            if (r9 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r4, 8, r9);
        L26:
            TypingTranslateEntity r10 = r5.mtyping_translate;
            if (r10 == null) goto L29;
            TypingTranslateEntity.ADAPTER.encodeWithTag(r4, 9, r10);
        L29:
            ChatNameTranslateEntity r11 = r5.mchat_name_translate;
            if (r11 == null) goto L32;
            ChatNameTranslateEntity.ADAPTER.encodeWithTag(r4, 10, r11);
        L32:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatSetting) r2);
        }
    }

    public static final class TypingTranslateEntity extends com.squareup.wire.Message<TypingTranslateEntity, Builder> {
        public static final ProtoAdapter<TypingTranslateEntity> ADAPTER = null;
        public static final Boolean DEFAULT_CAN_AUTO_OPEN = null;
        public static final Boolean DEFAULT_CAN_AUTO_OPEN_V1 = null;
        public static final Boolean DEFAULT_CAN_AUTO_OPEN_V3 = null;
        public static final Boolean DEFAULT_ENABLE_USE_TRANSLATE_ORIGINAL = null;
        public static final Boolean DEFAULT_IS_OPEN = null;
        public static final String DEFAULT_LOCALE = "";
        public static final Long DEFAULT_UPDATE_TIME_NS = null;
        private static final long serialVersionUID = 0;
        public final Boolean mcan_auto_open;
        public final Boolean mcan_auto_open_v1;
        public final Boolean mcan_auto_open_v3;
        public final AutoOpenCloseMode mclose_mode;
        public final Boolean menable_use_translate_original;
        public final Boolean mis_open;
        public final String mlocale;
        public final OpenMode mopen_mode;
        public final Long mupdate_time_ns;

        public static final enum AutoOpenCloseMode extends Enum<AutoOpenCloseMode> implements WireEnum {
            private static final /* synthetic */ AutoOpenCloseMode[] $VALUES = null;
            public static final ProtoAdapter<AutoOpenCloseMode> ADAPTER = null;
            public static final AutoOpenCloseMode CLOSE_DIRECTLY = null;
            public static final AutoOpenCloseMode CLOSE_NO_LONGER_OPEN = null;
            public static final AutoOpenCloseMode CLOSE_POPUP = null;
            public static final AutoOpenCloseMode CLOSE_UNKNOWN = null;
            private final int value;

            static {
                AutoOpenCloseMode r0 = new AutoOpenCloseMode("CLOSE_UNKNOWN", 0, 0);
                CLOSE_UNKNOWN = r0;
                AutoOpenCloseMode r1 = new AutoOpenCloseMode("CLOSE_DIRECTLY", 1, 1);
                CLOSE_DIRECTLY = r1;
                AutoOpenCloseMode r3 = new AutoOpenCloseMode("CLOSE_POPUP", 2, 2);
                CLOSE_POPUP = r3;
                AutoOpenCloseMode r5 = new AutoOpenCloseMode("CLOSE_NO_LONGER_OPEN", 3, 3);
                CLOSE_NO_LONGER_OPEN = r5;
                $VALUES = new AutoOpenCloseMode[]{r0, r1, r3, r5};
                ADAPTER = ProtoAdapter.newEnumAdapter(AutoOpenCloseMode.class);
            }

            public static AutoOpenCloseMode[] values() {
                return (AutoOpenCloseMode[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static AutoOpenCloseMode fromValue(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return CLOSE_NO_LONGER_OPEN;
            L14:
                return CLOSE_POPUP;
            L16:
                return CLOSE_DIRECTLY;
            L18:
                return CLOSE_UNKNOWN;
            }

            public static AutoOpenCloseMode valueOf(String r1) {
                return (AutoOpenCloseMode) a.a(AutoOpenCloseMode.class, r1);
            }

            private AutoOpenCloseMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class Builder extends com.squareup.wire.Message.Builder<TypingTranslateEntity, Builder> {
            public Boolean mcan_auto_open;
            public Boolean mcan_auto_open_v1;
            public Boolean mcan_auto_open_v3;
            public AutoOpenCloseMode mclose_mode;
            public Boolean menable_use_translate_original;
            public Boolean mis_open;
            public String mlocale;
            public OpenMode mopen_mode;
            public Long mupdate_time_ns;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TypingTranslateEntity m1160build() {
                return new TypingTranslateEntity(this.mis_open, this.mopen_mode, this.mlocale, this.mcan_auto_open, this.menable_use_translate_original, this.mupdate_time_ns, this.mcan_auto_open_v1, this.mcan_auto_open_v3, this.mclose_mode, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1160build();
            }

            public Builder can_auto_open(Boolean r1) {
                this.mcan_auto_open = r1;
                return this;
            }

            public Builder can_auto_open_v1(Boolean r1) {
                this.mcan_auto_open_v1 = r1;
                return this;
            }

            public Builder can_auto_open_v3(Boolean r1) {
                this.mcan_auto_open_v3 = r1;
                return this;
            }

            public Builder close_mode(AutoOpenCloseMode r1) {
                this.mclose_mode = r1;
                return this;
            }

            public Builder enable_use_translate_original(Boolean r1) {
                this.menable_use_translate_original = r1;
                return this;
            }

            public Builder is_open(Boolean r1) {
                this.mis_open = r1;
                return this;
            }

            public Builder locale(String r1) {
                this.mlocale = r1;
                return this;
            }

            public Builder open_mode(OpenMode r1) {
                this.mopen_mode = r1;
                return this;
            }

            public Builder update_time_ns(Long r1) {
                this.mupdate_time_ns = r1;
                return this;
            }
        }

        public static final enum OpenMode extends Enum<OpenMode> implements WireEnum {
            private static final /* synthetic */ OpenMode[] $VALUES = null;
            public static final ProtoAdapter<OpenMode> ADAPTER = null;
            public static final OpenMode AUTO = null;
            public static final OpenMode MANUAL = null;
            public static final OpenMode UNKNOWN = null;
            private final int value;

            static {
                OpenMode r0 = new OpenMode("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                OpenMode r1 = new OpenMode("MANUAL", 1, 1);
                MANUAL = r1;
                OpenMode r3 = new OpenMode("AUTO", 2, 2);
                AUTO = r3;
                $VALUES = new OpenMode[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(OpenMode.class);
            }

            public static OpenMode[] values() {
                return (OpenMode[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static OpenMode fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return AUTO;
            L12:
                return MANUAL;
            L14:
                return UNKNOWN;
            }

            public static OpenMode valueOf(String r1) {
                return (OpenMode) a.a(OpenMode.class, r1);
            }

            private OpenMode(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_TypingTranslateEntity extends ProtoAdapter<TypingTranslateEntity> {
            public ProtoAdapter_TypingTranslateEntity() {
                super(FieldEncoding.LENGTH_DELIMITED, TypingTranslateEntity.class);
            }

            public TypingTranslateEntity decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.mis_open = r1;
                r0.mlocale = "";
                Boolean r2 = Boolean.TRUE;
                r0.mcan_auto_open = r2;
                r0.menable_use_translate_original = r1;
                r0.mupdate_time_ns = 0L;
                r0.mcan_auto_open_v1 = r2;
                r0.mcan_auto_open_v3 = r2;
                long r3 = r9.beginMessage();
            L3:
                int r4 = r9.nextTag();
                if (r4 == (-1)) goto L22;
                switch(r4) {
                    case 1: goto L21;
                    case 2: goto L24;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L14;
                    case 6: goto L13;
                    case 7: goto L12;
                    case 8: goto L11;
                    case 9: goto L6;
                    case 10: goto L26;
                    default: goto L6;
                };
            L24:
                r0.mopen_mode = (OpenMode) OpenMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r0.addUnknownField(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L26:
                r0.mclose_mode = (AutoOpenCloseMode) AutoOpenCloseMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r0.addUnknownField(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r0.mcan_auto_open_v3 = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L12:
                r0.mcan_auto_open_v1 = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L13:
                r0.mupdate_time_ns = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L14:
                r0.menable_use_translate_original = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L15:
                r0.mcan_auto_open = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L16:
                r0.mlocale = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L21:
                r0.mis_open = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L6:
                FieldEncoding r5 = r9.peekFieldEncoding();
                r0.addUnknownField(r4, r5, r5.rawProtoAdapter().decode(r9));
                goto L3
            L22:
                r9.endMessage(r3);
                return r0.m1160build();
            }

            public int encodedSize(TypingTranslateEntity r6) {
                Boolean r0 = r6.mis_open;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                OpenMode r3 = r6.mopen_mode;
                if (r3 == null) goto L9;
                int r4 = OpenMode.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mlocale;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                Boolean r10 = r6.mcan_auto_open;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
            L18:
                int r12 = r9 + r11;
                Boolean r13 = r6.menable_use_translate_original;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
            L22:
                int r15 = r12 + r14;
                Long r16 = r6.mupdate_time_ns;
                if (r16 == null) goto L25;
                int r17 = ProtoAdapter.INT64.encodedSizeWithTag(6, r16);
            L26:
                int r18 = r15 + r17;
                Boolean r19 = r6.mcan_auto_open_v1;
                if (r19 == null) goto L29;
                int r20 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r19);
            L30:
                int r21 = r18 + r20;
                Boolean r22 = r6.mcan_auto_open_v3;
                if (r22 == null) goto L33;
                int r23 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r22);
            L34:
                int r24 = r21 + r23;
                AutoOpenCloseMode r25 = r6.mclose_mode;
                if (r25 == null) goto L38;
                r1 = AutoOpenCloseMode.ADAPTER.encodedSizeWithTag(10, r25);
            L38:
                return (r24 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1161decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TypingTranslateEntity) r1);
            }

            public void encode(ProtoWriter r4, TypingTranslateEntity r5) throws IOException {
                Boolean r0 = r5.mis_open;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                OpenMode r1 = r5.mopen_mode;
                if (r1 == null) goto L8;
                OpenMode.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mlocale;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                Boolean r3 = r5.mcan_auto_open;
                if (r3 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
            L14:
                Boolean r6 = r5.menable_use_translate_original;
                if (r6 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
            L17:
                Long r7 = r5.mupdate_time_ns;
                if (r7 == null) goto L20;
                ProtoAdapter.INT64.encodeWithTag(r4, 6, r7);
            L20:
                Boolean r8 = r5.mcan_auto_open_v1;
                if (r8 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r4, 7, r8);
            L23:
                Boolean r9 = r5.mcan_auto_open_v3;
                if (r9 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r4, 8, r9);
            L26:
                AutoOpenCloseMode r10 = r5.mclose_mode;
                if (r10 == null) goto L29;
                AutoOpenCloseMode.ADAPTER.encodeWithTag(r4, 10, r10);
            L29:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TypingTranslateEntity) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TypingTranslateEntity();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_IS_OPEN = r0;
            Boolean r1 = Boolean.TRUE;
            DEFAULT_CAN_AUTO_OPEN = r1;
            DEFAULT_ENABLE_USE_TRANSLATE_ORIGINAL = r0;
            DEFAULT_UPDATE_TIME_NS = 0L;
            DEFAULT_CAN_AUTO_OPEN_V1 = r1;
            DEFAULT_CAN_AUTO_OPEN_V3 = r1;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1159newBuilder() {
            Builder r0 = new Builder();
            r0.mis_open = this.mis_open;
            r0.mopen_mode = this.mopen_mode;
            r0.mlocale = this.mlocale;
            r0.mcan_auto_open = this.mcan_auto_open;
            r0.menable_use_translate_original = this.menable_use_translate_original;
            r0.mupdate_time_ns = this.mupdate_time_ns;
            r0.mcan_auto_open_v1 = this.mcan_auto_open_v1;
            r0.mcan_auto_open_v3 = this.mcan_auto_open_v3;
            r0.mclose_mode = this.mclose_mode;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TypingTranslateEntity.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1159newBuilder();
        }

        public TypingTranslateEntity(Boolean r12, OpenMode r13, String r14, Boolean r15, Boolean r16, Long r17, Boolean r18, Boolean r19, AutoOpenCloseMode r20) {
            this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
        }

        public TypingTranslateEntity(Boolean r2, OpenMode r3, String r4, Boolean r5, Boolean r6, Long r7, Boolean r8, Boolean r9, AutoOpenCloseMode r10, ByteString r11) {
            super(ADAPTER, r11);
            this.mis_open = r2;
            this.mopen_mode = r3;
            this.mlocale = r4;
            this.mcan_auto_open = r5;
            this.menable_use_translate_original = r6;
            this.mupdate_time_ns = r7;
            this.mcan_auto_open_v1 = r8;
            this.mcan_auto_open_v3 = r9;
            this.mclose_mode = r10;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatSetting();
        DEFAULT_IS_REMIND = Boolean.TRUE;
        DEFAULT_UPDATE_TIME = 0L;
        Boolean r1 = Boolean.FALSE;
        DEFAULT_IS_AUTO_TRANSLATE = r1;
        DEFAULT_IS_HIDDEN_NICKNAME = r1;
        DEFAULT_IS_AUTO_TRANSLATE_VERSION = 0L;
        DEFAULT_ANONYMOUS_USER_ID = 0L;
        DEFAULT_IS_MUTE_AT_ALL = r1;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1150newBuilder() {
        Builder r0 = new Builder();
        r0.mis_remind = this.mis_remind;
        r0.mupdate_time = this.mupdate_time;
        r0.mcheck_message_position = this.mcheck_message_position;
        r0.mis_auto_translate = this.mis_auto_translate;
        r0.mis_hidden_nickname = this.mis_hidden_nickname;
        r0.mis_auto_translate_version = this.mis_auto_translate_version;
        r0.manonymous_user_id = this.manonymous_user_id;
        r0.mis_mute_at_all = this.mis_mute_at_all;
        r0.mtyping_translate = this.mtyping_translate;
        r0.mchat_name_translate = this.mchat_name_translate;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1150newBuilder();
    }

    public ChatSetting(Boolean r13, Long r14, CheckMessagePositionSetting.Enum r15, Boolean r16, Boolean r17, Long r18, Long r19, Boolean r20, TypingTranslateEntity r21, ChatNameTranslateEntity r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public ChatSetting(Boolean r2, Long r3, CheckMessagePositionSetting.Enum r4, Boolean r5, Boolean r6, Long r7, Long r8, Boolean r9, TypingTranslateEntity r10, ChatNameTranslateEntity r11, ByteString r12) {
        super(ADAPTER, r12);
        this.mis_remind = r2;
        this.mupdate_time = r3;
        this.mcheck_message_position = r4;
        this.mis_auto_translate = r5;
        this.mis_hidden_nickname = r6;
        this.mis_auto_translate_version = r7;
        this.manonymous_user_id = r8;
        this.mis_mute_at_all = r9;
        this.mtyping_translate = r10;
        this.mchat_name_translate = r11;
    }
}
