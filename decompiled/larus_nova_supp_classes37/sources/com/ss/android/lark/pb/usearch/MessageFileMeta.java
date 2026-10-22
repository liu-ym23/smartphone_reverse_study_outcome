package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.FileContent;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MessageFileMeta extends Message<MessageFileMeta, Builder> {
    public static final ProtoAdapter<MessageFileMeta> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_FILE_HIERARCHY = "";
    public static final String DEFAULT_FROM_ID = "";
    public static final String DEFAULT_FROM_TENANT_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_DESTROYED = null;
    public static final Boolean DEFAULT_IS_FILE_ACCESS_AUTH = null;
    public static final Boolean DEFAULT_IS_INNER_FILE = null;
    public static final Boolean DEFAULT_IS_RESTRICTED = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Integer DEFAULT_MESSAGE_POSITION = null;
    public static final String DEFAULT_MESSAGE_SENDER_NAME = "";
    public static final Integer DEFAULT_ROOT_MESSAGE_POSITION = null;
    public static final Long DEFAULT_SCENE_ID = null;
    public static final Integer DEFAULT_THREAD_CHAT_POSITION = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_POSITION = null;
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final Long mcreate_time;
    public final Map<Integer, MessageBehavior> mdisabled_action;
    public final String mfile_hierarchy;
    public final FileContent mfile_meta;
    public final FileType mfile_type;
    public final String mfrom_id;
    public final String mfrom_tenant_id;
    public final String mid;
    public final Boolean mis_destroyed;
    public final Boolean mis_file_access_auth;
    public final Boolean mis_inner_file;
    public final Boolean mis_restricted;
    public final String mmessage_id;
    public final Integer mmessage_position;
    public final String mmessage_sender_name;
    public final Integer mroot_message_position;
    public final Long mscene_id;
    public final Integer mthread_chat_position;
    public final String mthread_id;
    public final com.ss.android.lark.pb.entities.Message.ThreadMessageType mthread_message_type;
    public final Integer mthread_position;

    public static final class Builder extends Message.Builder<MessageFileMeta, Builder> {
        public String mchat_id;
        public Long mcreate_time;
        public Map<Integer, MessageBehavior> mdisabled_action;
        public String mfile_hierarchy;
        public FileContent mfile_meta;
        public FileType mfile_type;
        public String mfrom_id;
        public String mfrom_tenant_id;
        public String mid;
        public Boolean mis_destroyed;
        public Boolean mis_file_access_auth;
        public Boolean mis_inner_file;
        public Boolean mis_restricted;
        public String mmessage_id;
        public Integer mmessage_position;
        public String mmessage_sender_name;
        public Integer mroot_message_position;
        public Long mscene_id;
        public Integer mthread_chat_position;
        public String mthread_id;
        public com.ss.android.lark.pb.entities.Message.ThreadMessageType mthread_message_type;
        public Integer mthread_position;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MessageFileMeta m2690build() {
            String r1 = this.mid;
            if (r1 == null) goto L7;
            return new MessageFileMeta(this.mid, this.mfile_type, this.mcreate_time, this.mmessage_id, this.mmessage_position, this.mchat_id, this.mfrom_id, this.mfile_meta, this.mfile_hierarchy, this.mis_inner_file, this.mthread_id, this.mthread_position, this.mthread_chat_position, this.mis_file_access_auth, this.mthread_message_type, this.mroot_message_position, this.mis_restricted, this.mdisabled_action, this.mis_destroyed, this.mfrom_tenant_id, this.mmessage_sender_name, this.mscene_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r1, "mid"});
        }

        public Builder() {
            this.mdisabled_action = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2690build();
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder create_time(Long r1) {
            this.mcreate_time = r1;
            return this;
        }

        public Builder disabled_action(Map<Integer, MessageBehavior> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdisabled_action = r1;
            return this;
        }

        public Builder file_hierarchy(String r1) {
            this.mfile_hierarchy = r1;
            return this;
        }

        public Builder file_meta(FileContent r1) {
            this.mfile_meta = r1;
            return this;
        }

        public Builder file_type(FileType r1) {
            this.mfile_type = r1;
            return this;
        }

        public Builder from_id(String r1) {
            this.mfrom_id = r1;
            return this;
        }

        public Builder from_tenant_id(String r1) {
            this.mfrom_tenant_id = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder is_destroyed(Boolean r1) {
            this.mis_destroyed = r1;
            return this;
        }

        public Builder is_file_access_auth(Boolean r1) {
            this.mis_file_access_auth = r1;
            return this;
        }

        public Builder is_inner_file(Boolean r1) {
            this.mis_inner_file = r1;
            return this;
        }

        public Builder is_restricted(Boolean r1) {
            this.mis_restricted = r1;
            return this;
        }

        public Builder message_id(String r1) {
            this.mmessage_id = r1;
            return this;
        }

        public Builder message_position(Integer r1) {
            this.mmessage_position = r1;
            return this;
        }

        public Builder message_sender_name(String r1) {
            this.mmessage_sender_name = r1;
            return this;
        }

        public Builder root_message_position(Integer r1) {
            this.mroot_message_position = r1;
            return this;
        }

        public Builder scene_id(Long r1) {
            this.mscene_id = r1;
            return this;
        }

        public Builder thread_chat_position(Integer r1) {
            this.mthread_chat_position = r1;
            return this;
        }

        public Builder thread_id(String r1) {
            this.mthread_id = r1;
            return this;
        }

        public Builder thread_message_type(com.ss.android.lark.pb.entities.Message.ThreadMessageType r1) {
            this.mthread_message_type = r1;
            return this;
        }

        public Builder thread_position(Integer r1) {
            this.mthread_position = r1;
            return this;
        }
    }

    public static final enum FileType extends Enum<FileType> implements WireEnum {
        private static final /* synthetic */ FileType[] $VALUES = null;
        public static final ProtoAdapter<FileType> ADAPTER = null;
        public static final FileType FILE = null;
        public static final FileType FOLDER = null;
        public static final FileType UNKNOWN = null;
        private final int value;

        static {
            FileType r0 = new FileType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            FileType r1 = new FileType("FILE", 1, 1);
            FILE = r1;
            FileType r3 = new FileType("FOLDER", 2, 2);
            FOLDER = r3;
            $VALUES = new FileType[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(FileType.class);
        }

        public static FileType[] values() {
            return (FileType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FileType fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return FOLDER;
        L12:
            return FILE;
        L14:
            return UNKNOWN;
        }

        public static FileType valueOf(String r1) {
            return (FileType) a.a(FileType.class, r1);
        }

        private FileType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_MessageFileMeta extends ProtoAdapter<MessageFileMeta> {
        private final ProtoAdapter<Map<Integer, MessageBehavior>> mdisabled_action;

        public ProtoAdapter_MessageFileMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageFileMeta.class);
            this.mdisabled_action = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, MessageBehavior.ADAPTER);
        }

        public MessageFileMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mcreate_time = 0L;
            r0.mmessage_id = "";
            r0.mmessage_position = 0;
            r0.mchat_id = "";
            r0.mfrom_id = "";
            r0.mfile_hierarchy = "";
            Boolean r4 = Boolean.FALSE;
            r0.mis_inner_file = r4;
            r0.mthread_id = "";
            r0.mthread_position = 0;
            r0.mthread_chat_position = 0;
            r0.mis_file_access_auth = r4;
            r0.mroot_message_position = 0;
            r0.mis_restricted = r4;
            r0.mis_destroyed = r4;
            r0.mfrom_tenant_id = "";
            r0.mmessage_sender_name = "";
            r0.mscene_id = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L35;
            switch(r3) {
                case 1: goto L34;
                case 2: goto L37;
                case 3: goto L29;
                case 4: goto L28;
                case 5: goto L27;
                case 6: goto L26;
                case 7: goto L25;
                case 8: goto L24;
                case 9: goto L23;
                case 10: goto L22;
                case 11: goto L21;
                case 12: goto L20;
                case 13: goto L19;
                case 14: goto L18;
                case 15: goto L39;
                case 16: goto L13;
                case 17: goto L12;
                case 18: goto L11;
                case 19: goto L10;
                case 20: goto L9;
                case 21: goto L8;
                case 22: goto L7;
                default: goto L6;
            };
        L37:
            r0.mfile_type = (FileType) FileType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L32
        L32:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L39:
            r0.mthread_message_type = (com.ss.android.lark.pb.entities.Message.ThreadMessageType) com.ss.android.lark.pb.entities.Message.ThreadMessageType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mscene_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            r0.mmessage_sender_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            r0.mfrom_tenant_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            r0.mis_destroyed = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L11:
            r0.mdisabled_action.putAll((Map) this.mdisabled_action.decode(r9));
            goto L3
        L12:
            r0.mis_restricted = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L13:
            r0.mroot_message_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L18:
            r0.mis_file_access_auth = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L19:
            r0.mthread_chat_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L20:
            r0.mthread_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L21:
            r0.mthread_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L22:
            r0.mis_inner_file = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L23:
            r0.mfile_hierarchy = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L24:
            r0.mfile_meta = (FileContent) FileContent.ADAPTER.decode(r9);
            goto L3
        L25:
            r0.mfrom_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L26:
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L27:
            r0.mmessage_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L28:
            r0.mmessage_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L29:
            r0.mcreate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L34:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r5 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r5, r5.rawProtoAdapter().decode(r9));
            goto L3
        L35:
            r9.endMessage(r1);
            return r0.m2690build();
        }

        public int encodedSize(MessageFileMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            FileType r2 = r7.mfile_type;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = FileType.ADAPTER.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            Long r6 = r7.mcreate_time;
            if (r6 == null) goto L9;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            String r10 = r7.mmessage_id;
            if (r10 == null) goto L13;
            int r11 = r0.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            Integer r13 = r7.mmessage_position;
            if (r13 == null) goto L17;
            int r14 = ProtoAdapter.INT32.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            String r16 = r7.mchat_id;
            if (r16 == null) goto L21;
            int r17 = r0.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            String r19 = r7.mfrom_id;
            if (r19 == null) goto L25;
            int r20 = r0.encodedSizeWithTag(7, r19);
        L26:
            int r21 = r18 + r20;
            FileContent r22 = r7.mfile_meta;
            if (r22 == null) goto L29;
            int r23 = FileContent.ADAPTER.encodedSizeWithTag(8, r22);
        L30:
            int r24 = r21 + r23;
            String r25 = r7.mfile_hierarchy;
            if (r25 == null) goto L33;
            int r26 = r0.encodedSizeWithTag(9, r25);
        L34:
            int r27 = r24 + r26;
            Boolean r28 = r7.mis_inner_file;
            if (r28 == null) goto L37;
            int r29 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r28);
        L38:
            int r30 = r27 + r29;
            String r31 = r7.mthread_id;
            if (r31 == null) goto L41;
            int r32 = r0.encodedSizeWithTag(11, r31);
        L42:
            int r33 = r30 + r32;
            Integer r34 = r7.mthread_position;
            if (r34 == null) goto L45;
            int r35 = ProtoAdapter.INT32.encodedSizeWithTag(12, r34);
        L46:
            int r36 = r33 + r35;
            Integer r37 = r7.mthread_chat_position;
            if (r37 == null) goto L49;
            int r38 = ProtoAdapter.INT32.encodedSizeWithTag(13, r37);
        L50:
            int r39 = r36 + r38;
            Boolean r40 = r7.mis_file_access_auth;
            if (r40 == null) goto L53;
            int r41 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r40);
        L54:
            int r42 = r39 + r41;
            com.ss.android.lark.pb.entities.Message.ThreadMessageType r43 = r7.mthread_message_type;
            if (r43 == null) goto L57;
            int r44 = com.ss.android.lark.pb.entities.Message.ThreadMessageType.ADAPTER.encodedSizeWithTag(15, r43);
        L58:
            int r45 = r42 + r44;
            Integer r46 = r7.mroot_message_position;
            if (r46 == null) goto L61;
            int r47 = ProtoAdapter.INT32.encodedSizeWithTag(16, r46);
        L62:
            int r48 = r45 + r47;
            Boolean r49 = r7.mis_restricted;
            if (r49 == null) goto L65;
            int r50 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r49);
        L66:
            int r51 = (r48 + r50) + this.mdisabled_action.encodedSizeWithTag(18, r7.mdisabled_action);
            Boolean r52 = r7.mis_destroyed;
            if (r52 == null) goto L69;
            int r53 = ProtoAdapter.BOOL.encodedSizeWithTag(19, r52);
        L70:
            int r54 = r51 + r53;
            String r55 = r7.mfrom_tenant_id;
            if (r55 == null) goto L73;
            int r56 = r0.encodedSizeWithTag(20, r55);
        L74:
            int r57 = r54 + r56;
            String r58 = r7.mmessage_sender_name;
            if (r58 == null) goto L77;
            int r59 = r0.encodedSizeWithTag(21, r58);
        L78:
            int r60 = r57 + r59;
            Long r61 = r7.mscene_id;
            if (r61 == null) goto L82;
            r3 = ProtoAdapter.INT64.encodedSizeWithTag(22, r61);
        L82:
            return (r60 + r3) + r7.unknownFields().size();
        L77:
            r59 = 0;
            goto L78
        L73:
            r56 = 0;
            goto L74
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
        public /* bridge */ /* synthetic */ Object m2691decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MessageFileMeta) r1);
        }

        public void encode(ProtoWriter r5, MessageFileMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            FileType r1 = r6.mfile_type;
            if (r1 == null) goto L5;
            FileType.ADAPTER.encodeWithTag(r5, 2, r1);
        L5:
            Long r2 = r6.mcreate_time;
            if (r2 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r5, 3, r2);
        L8:
            String r3 = r6.mmessage_id;
            if (r3 == null) goto L11;
            r0.encodeWithTag(r5, 4, r3);
        L11:
            Integer r4 = r6.mmessage_position;
            if (r4 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r5, 5, r4);
        L14:
            String r7 = r6.mchat_id;
            if (r7 == null) goto L17;
            r0.encodeWithTag(r5, 6, r7);
        L17:
            String r8 = r6.mfrom_id;
            if (r8 == null) goto L20;
            r0.encodeWithTag(r5, 7, r8);
        L20:
            FileContent r9 = r6.mfile_meta;
            if (r9 == null) goto L23;
            FileContent.ADAPTER.encodeWithTag(r5, 8, r9);
        L23:
            String r10 = r6.mfile_hierarchy;
            if (r10 == null) goto L26;
            r0.encodeWithTag(r5, 9, r10);
        L26:
            Boolean r11 = r6.mis_inner_file;
            if (r11 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r5, 10, r11);
        L29:
            String r12 = r6.mthread_id;
            if (r12 == null) goto L32;
            r0.encodeWithTag(r5, 11, r12);
        L32:
            Integer r13 = r6.mthread_position;
            if (r13 == null) goto L35;
            ProtoAdapter.INT32.encodeWithTag(r5, 12, r13);
        L35:
            Integer r14 = r6.mthread_chat_position;
            if (r14 == null) goto L38;
            ProtoAdapter.INT32.encodeWithTag(r5, 13, r14);
        L38:
            Boolean r15 = r6.mis_file_access_auth;
            if (r15 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r5, 14, r15);
        L41:
            com.ss.android.lark.pb.entities.Message.ThreadMessageType r16 = r6.mthread_message_type;
            if (r16 == null) goto L44;
            com.ss.android.lark.pb.entities.Message.ThreadMessageType.ADAPTER.encodeWithTag(r5, 15, r16);
        L44:
            Integer r17 = r6.mroot_message_position;
            if (r17 == null) goto L47;
            ProtoAdapter.INT32.encodeWithTag(r5, 16, r17);
        L47:
            Boolean r18 = r6.mis_restricted;
            if (r18 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r5, 17, r18);
        L50:
            this.mdisabled_action.encodeWithTag(r5, 18, r6.mdisabled_action);
            Boolean r19 = r6.mis_destroyed;
            if (r19 == null) goto L53;
            ProtoAdapter.BOOL.encodeWithTag(r5, 19, r19);
        L53:
            String r20 = r6.mfrom_tenant_id;
            if (r20 == null) goto L56;
            r0.encodeWithTag(r5, 20, r20);
        L56:
            String r21 = r6.mmessage_sender_name;
            if (r21 == null) goto L59;
            r0.encodeWithTag(r5, 21, r21);
        L59:
            Long r22 = r6.mscene_id;
            if (r22 == null) goto L62;
            ProtoAdapter.INT64.encodeWithTag(r5, 22, r22);
        L62:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MessageFileMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageFileMeta();
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_MESSAGE_POSITION = 0;
        Boolean r2 = Boolean.FALSE;
        DEFAULT_IS_INNER_FILE = r2;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_THREAD_CHAT_POSITION = 0;
        DEFAULT_IS_FILE_ACCESS_AUTH = r2;
        DEFAULT_ROOT_MESSAGE_POSITION = 0;
        DEFAULT_IS_RESTRICTED = r2;
        DEFAULT_IS_DESTROYED = r2;
        DEFAULT_SCENE_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2689newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mfile_type = this.mfile_type;
        r0.mcreate_time = this.mcreate_time;
        r0.mmessage_id = this.mmessage_id;
        r0.mmessage_position = this.mmessage_position;
        r0.mchat_id = this.mchat_id;
        r0.mfrom_id = this.mfrom_id;
        r0.mfile_meta = this.mfile_meta;
        r0.mfile_hierarchy = this.mfile_hierarchy;
        r0.mis_inner_file = this.mis_inner_file;
        r0.mthread_id = this.mthread_id;
        r0.mthread_position = this.mthread_position;
        r0.mthread_chat_position = this.mthread_chat_position;
        r0.mis_file_access_auth = this.mis_file_access_auth;
        r0.mthread_message_type = this.mthread_message_type;
        r0.mroot_message_position = this.mroot_message_position;
        r0.mis_restricted = this.mis_restricted;
        r0.mdisabled_action = Internal.copyOf("mdisabled_action", this.mdisabled_action);
        r0.mis_destroyed = this.mis_destroyed;
        r0.mfrom_tenant_id = this.mfrom_tenant_id;
        r0.mmessage_sender_name = this.mmessage_sender_name;
        r0.mscene_id = this.mscene_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MessageFileMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2689newBuilder();
    }

    public MessageFileMeta(String r25, FileType r26, Long r27, String r28, Integer r29, String r30, String r31, FileContent r32, String r33, Boolean r34, String r35, Integer r36, Integer r37, Boolean r38, com.ss.android.lark.pb.entities.Message.ThreadMessageType r39, Integer r40, Boolean r41, Map<Integer, MessageBehavior> r42, Boolean r43, String r44, String r45, Long r46) {
        this(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, ByteString.EMPTY);
    }

    public MessageFileMeta(String r4, FileType r5, Long r6, String r7, Integer r8, String r9, String r10, FileContent r11, String r12, Boolean r13, String r14, Integer r15, Integer r16, Boolean r17, com.ss.android.lark.pb.entities.Message.ThreadMessageType r18, Integer r19, Boolean r20, Map<Integer, MessageBehavior> r21, Boolean r22, String r23, String r24, Long r25, ByteString r26) {
        super(ADAPTER, r26);
        this.mid = r4;
        this.mfile_type = r5;
        this.mcreate_time = r6;
        this.mmessage_id = r7;
        this.mmessage_position = r8;
        this.mchat_id = r9;
        this.mfrom_id = r10;
        this.mfile_meta = r11;
        this.mfile_hierarchy = r12;
        this.mis_inner_file = r13;
        this.mthread_id = r14;
        this.mthread_position = r15;
        this.mthread_chat_position = r16;
        this.mis_file_access_auth = r17;
        this.mthread_message_type = r18;
        this.mroot_message_position = r19;
        this.mis_restricted = r20;
        this.mdisabled_action = Internal.immutableCopyOf("mdisabled_action", r21);
        this.mis_destroyed = r22;
        this.mfrom_tenant_id = r23;
        this.mmessage_sender_name = r24;
        this.mscene_id = r25;
    }
}
