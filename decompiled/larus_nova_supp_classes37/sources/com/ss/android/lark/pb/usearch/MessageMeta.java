package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.DocType;
import com.ss.android.lark.pb.entities.FileContent;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MessageMeta extends Message<MessageMeta, Builder> {
    public static final ProtoAdapter<MessageMeta> ADAPTER = null;
    public static final Integer DEFAULT_ATTACHMENT_COUNT = null;
    public static final Long DEFAULT_AVATAR_KEY_CHATTER_ID = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_FROM_ID = "";
    public static final String DEFAULT_FROM_TENANT_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_FILE_ACCESS_AUTH = null;
    public static final Boolean DEFAULT_IS_P2P_CHAT = null;
    public static final Boolean DEFAULT_IS_RESTRICTED = null;
    public static final Integer DEFAULT_POSITION = null;
    public static final Integer DEFAULT_ROOT_MESSAGE_POSITION = null;
    public static final Integer DEFAULT_THREAD_CHAT_POSITION = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_POSITION = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final Integer mattachment_count;
    public final List<MessageAttachment> mattachments;
    public final Long mavatar_key_chatter_id;
    public final String mchat_id;
    public final Long mcreate_time;
    public final Map<Integer, MessageBehavior> mdisabled_action;
    public final List<DocExtraInfo> mdoc_extra_infos;
    public final FileContent mfile_meta;
    public final String mfrom_id;
    public final String mfrom_tenant_id;
    public final String mid;
    public final Boolean mis_file_access_auth;
    public final Boolean mis_p2p_chat;
    public final Boolean mis_restricted;
    public final Integer mposition;
    public final Integer mroot_message_position;
    public final Integer mthread_chat_position;
    public final String mthread_id;
    public final com.ss.android.lark.pb.entities.Message.ThreadMessageType mthread_message_type;
    public final Integer mthread_position;
    public final com.ss.android.lark.pb.entities.Message.Type mtype;
    public final Long mupdate_time;

    public static final class Builder extends Message.Builder<MessageMeta, Builder> {
        public Integer mattachment_count;
        public List<MessageAttachment> mattachments;
        public Long mavatar_key_chatter_id;
        public String mchat_id;
        public Long mcreate_time;
        public Map<Integer, MessageBehavior> mdisabled_action;
        public List<DocExtraInfo> mdoc_extra_infos;
        public FileContent mfile_meta;
        public String mfrom_id;
        public String mfrom_tenant_id;
        public String mid;
        public Boolean mis_file_access_auth;
        public Boolean mis_p2p_chat;
        public Boolean mis_restricted;
        public Integer mposition;
        public Integer mroot_message_position;
        public Integer mthread_chat_position;
        public String mthread_id;
        public com.ss.android.lark.pb.entities.Message.ThreadMessageType mthread_message_type;
        public Integer mthread_position;
        public com.ss.android.lark.pb.entities.Message.Type mtype;
        public Long mupdate_time;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MessageMeta m2720build() {
            String r1 = this.mid;
            if (r1 == null) goto L7;
            return new MessageMeta(this.mid, this.mtype, this.mupdate_time, this.mcreate_time, this.mposition, this.mchat_id, this.mfile_meta, this.mfrom_id, this.mthread_id, this.mthread_position, this.mthread_chat_position, this.mdoc_extra_infos, this.mavatar_key_chatter_id, this.mis_p2p_chat, this.mis_file_access_auth, this.mthread_message_type, this.mroot_message_position, this.mis_restricted, this.mdisabled_action, this.mattachment_count, this.mattachments, this.mfrom_tenant_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r1, "mid"});
        }

        public Builder() {
            this.mdoc_extra_infos = Internal.newMutableList();
            this.mdisabled_action = Internal.newMutableMap();
            this.mattachments = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2720build();
        }

        public Builder attachment_count(Integer r1) {
            this.mattachment_count = r1;
            return this;
        }

        public Builder attachments(List<MessageAttachment> r1) {
            Internal.checkElementsNotNull(r1);
            this.mattachments = r1;
            return this;
        }

        public Builder avatar_key_chatter_id(Long r1) {
            this.mavatar_key_chatter_id = r1;
            return this;
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

        public Builder doc_extra_infos(List<DocExtraInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdoc_extra_infos = r1;
            return this;
        }

        public Builder file_meta(FileContent r1) {
            this.mfile_meta = r1;
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

        public Builder is_file_access_auth(Boolean r1) {
            this.mis_file_access_auth = r1;
            return this;
        }

        public Builder is_p2p_chat(Boolean r1) {
            this.mis_p2p_chat = r1;
            return this;
        }

        public Builder is_restricted(Boolean r1) {
            this.mis_restricted = r1;
            return this;
        }

        public Builder position(Integer r1) {
            this.mposition = r1;
            return this;
        }

        public Builder root_message_position(Integer r1) {
            this.mroot_message_position = r1;
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

        public Builder type(com.ss.android.lark.pb.entities.Message.Type r1) {
            this.mtype = r1;
            return this;
        }

        public Builder update_time(Long r1) {
            this.mupdate_time = r1;
            return this;
        }
    }

    public static final class DocExtraInfo extends Message<DocExtraInfo, Builder> {
        public static final ProtoAdapter<DocExtraInfo> ADAPTER = null;
        public static final String DEFAULT_NAME = "";
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final String mname;
        public final DocType mtype;
        public final String murl;

        public static final class Builder extends Message.Builder<DocExtraInfo, Builder> {
            public String mname;
            public DocType mtype;
            public String murl;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DocExtraInfo m2722build() {
                return new DocExtraInfo(this.mtype, this.murl, this.mname, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2722build();
            }

            public Builder name(String r1) {
                this.mname = r1;
                return this;
            }

            public Builder type(DocType r1) {
                this.mtype = r1;
                return this;
            }

            public Builder url(String r1) {
                this.murl = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DocExtraInfo extends ProtoAdapter<DocExtraInfo> {
            public ProtoAdapter_DocExtraInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, DocExtraInfo.class);
            }

            public DocExtraInfo decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.murl = "";
                r0.mname = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mtype = (DocType) DocType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.murl = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mname = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L18:
                r9.endMessage(r1);
                return r0.m2722build();
            }

            public int encodedSize(DocExtraInfo r6) {
                DocType r0 = r6.mtype;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = DocType.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.murl;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                String r7 = r6.mname;
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
            public /* bridge */ /* synthetic */ Object m2723decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DocExtraInfo) r1);
            }

            public void encode(ProtoWriter r4, DocExtraInfo r5) throws IOException {
                DocType r0 = r5.mtype;
                if (r0 == null) goto L5;
                DocType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.murl;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                String r2 = r5.mname;
                if (r2 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DocExtraInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocExtraInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2721newBuilder() {
            Builder r0 = new Builder();
            r0.mtype = this.mtype;
            r0.murl = this.murl;
            r0.mname = this.mname;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DocExtraInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2721newBuilder();
        }

        public DocExtraInfo(DocType r2, String r3, String r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public DocExtraInfo(DocType r2, String r3, String r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mtype = r2;
            this.murl = r3;
            this.mname = r4;
        }
    }

    public static final class ProtoAdapter_MessageMeta extends ProtoAdapter<MessageMeta> {
        private final ProtoAdapter<Map<Integer, MessageBehavior>> mdisabled_action;

        public ProtoAdapter_MessageMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageMeta.class);
            this.mdisabled_action = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, MessageBehavior.ADAPTER);
        }

        public MessageMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mupdate_time = 0L;
            r0.mcreate_time = 0L;
            r0.mposition = 0;
            r0.mchat_id = "";
            r0.mfrom_id = "";
            r0.mthread_id = "";
            r0.mthread_position = 0;
            r0.mthread_chat_position = 0;
            r0.mavatar_key_chatter_id = 0L;
            Boolean r2 = Boolean.FALSE;
            r0.mis_p2p_chat = r2;
            r0.mis_file_access_auth = r2;
            r0.mroot_message_position = 0;
            r0.mis_restricted = r2;
            r0.mattachment_count = 0;
            r0.mfrom_tenant_id = "";
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
                case 15: goto L17;
                case 16: goto L39;
                case 17: goto L12;
                case 18: goto L11;
                case 19: goto L10;
                case 20: goto L9;
                case 21: goto L8;
                case 22: goto L7;
                default: goto L6;
            };
        L37:
            r0.mtype = (com.ss.android.lark.pb.entities.Message.Type) com.ss.android.lark.pb.entities.Message.Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L32
        L32:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L39:
            r0.mthread_message_type = (com.ss.android.lark.pb.entities.Message.ThreadMessageType) com.ss.android.lark.pb.entities.Message.ThreadMessageType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mfrom_tenant_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            r0.mattachments.add((MessageAttachment) MessageAttachment.ADAPTER.decode(r9));
            goto L3
        L9:
            r0.mattachment_count = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L10:
            r0.mdisabled_action.putAll((Map) this.mdisabled_action.decode(r9));
            goto L3
        L11:
            r0.mis_restricted = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L12:
            r0.mroot_message_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L17:
            r0.mis_file_access_auth = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L18:
            r0.mis_p2p_chat = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L19:
            r0.mavatar_key_chatter_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L20:
            r0.mdoc_extra_infos.add((DocExtraInfo) DocExtraInfo.ADAPTER.decode(r9));
            goto L3
        L21:
            r0.mthread_chat_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L22:
            r0.mthread_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L23:
            r0.mthread_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L24:
            r0.mfrom_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L25:
            r0.mfile_meta = (FileContent) FileContent.ADAPTER.decode(r9);
            goto L3
        L26:
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L27:
            r0.mposition = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L28:
            r0.mcreate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L29:
            r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L34:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L35:
            r9.endMessage(r1);
            return r0.m2720build();
        }

        public int encodedSize(MessageMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            com.ss.android.lark.pb.entities.Message.Type r2 = r7.mtype;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = com.ss.android.lark.pb.entities.Message.Type.ADAPTER.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            Long r6 = r7.mupdate_time;
            if (r6 == null) goto L9;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            Long r10 = r7.mcreate_time;
            if (r10 == null) goto L13;
            int r11 = ProtoAdapter.INT64.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            Integer r13 = r7.mposition;
            if (r13 == null) goto L17;
            int r14 = ProtoAdapter.INT32.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            String r16 = r7.mchat_id;
            if (r16 == null) goto L21;
            int r17 = r0.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            FileContent r19 = r7.mfile_meta;
            if (r19 == null) goto L25;
            int r20 = FileContent.ADAPTER.encodedSizeWithTag(7, r19);
        L26:
            int r21 = r18 + r20;
            String r22 = r7.mfrom_id;
            if (r22 == null) goto L29;
            int r23 = r0.encodedSizeWithTag(8, r22);
        L30:
            int r24 = r21 + r23;
            String r25 = r7.mthread_id;
            if (r25 == null) goto L33;
            int r26 = r0.encodedSizeWithTag(9, r25);
        L34:
            int r27 = r24 + r26;
            Integer r28 = r7.mthread_position;
            if (r28 == null) goto L37;
            int r29 = ProtoAdapter.INT32.encodedSizeWithTag(10, r28);
        L38:
            int r30 = r27 + r29;
            Integer r31 = r7.mthread_chat_position;
            if (r31 == null) goto L41;
            int r32 = ProtoAdapter.INT32.encodedSizeWithTag(11, r31);
        L42:
            int r33 = (r30 + r32) + DocExtraInfo.ADAPTER.asRepeated().encodedSizeWithTag(12, r7.mdoc_extra_infos);
            Long r34 = r7.mavatar_key_chatter_id;
            if (r34 == null) goto L45;
            int r35 = ProtoAdapter.INT64.encodedSizeWithTag(13, r34);
        L46:
            int r36 = r33 + r35;
            Boolean r37 = r7.mis_p2p_chat;
            if (r37 == null) goto L49;
            int r38 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r37);
        L50:
            int r39 = r36 + r38;
            Boolean r40 = r7.mis_file_access_auth;
            if (r40 == null) goto L53;
            int r41 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r40);
        L54:
            int r42 = r39 + r41;
            com.ss.android.lark.pb.entities.Message.ThreadMessageType r43 = r7.mthread_message_type;
            if (r43 == null) goto L57;
            int r44 = com.ss.android.lark.pb.entities.Message.ThreadMessageType.ADAPTER.encodedSizeWithTag(16, r43);
        L58:
            int r45 = r42 + r44;
            Integer r46 = r7.mroot_message_position;
            if (r46 == null) goto L61;
            int r47 = ProtoAdapter.INT32.encodedSizeWithTag(17, r46);
        L62:
            int r48 = r45 + r47;
            Boolean r49 = r7.mis_restricted;
            if (r49 == null) goto L65;
            int r50 = ProtoAdapter.BOOL.encodedSizeWithTag(18, r49);
        L66:
            int r51 = (r48 + r50) + this.mdisabled_action.encodedSizeWithTag(19, r7.mdisabled_action);
            Integer r52 = r7.mattachment_count;
            if (r52 == null) goto L69;
            int r53 = ProtoAdapter.INT32.encodedSizeWithTag(20, r52);
        L70:
            int r54 = (r51 + r53) + MessageAttachment.ADAPTER.asRepeated().encodedSizeWithTag(21, r7.mattachments);
            String r55 = r7.mfrom_tenant_id;
            if (r55 == null) goto L74;
            r3 = r0.encodedSizeWithTag(22, r55);
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
        public /* bridge */ /* synthetic */ Object m2724decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MessageMeta) r1);
        }

        public void encode(ProtoWriter r5, MessageMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            com.ss.android.lark.pb.entities.Message.Type r1 = r6.mtype;
            if (r1 == null) goto L5;
            com.ss.android.lark.pb.entities.Message.Type.ADAPTER.encodeWithTag(r5, 2, r1);
        L5:
            Long r2 = r6.mupdate_time;
            if (r2 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r5, 3, r2);
        L8:
            Long r3 = r6.mcreate_time;
            if (r3 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r5, 4, r3);
        L11:
            Integer r4 = r6.mposition;
            if (r4 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r5, 5, r4);
        L14:
            String r7 = r6.mchat_id;
            if (r7 == null) goto L17;
            r0.encodeWithTag(r5, 6, r7);
        L17:
            FileContent r8 = r6.mfile_meta;
            if (r8 == null) goto L20;
            FileContent.ADAPTER.encodeWithTag(r5, 7, r8);
        L20:
            String r9 = r6.mfrom_id;
            if (r9 == null) goto L23;
            r0.encodeWithTag(r5, 8, r9);
        L23:
            String r10 = r6.mthread_id;
            if (r10 == null) goto L26;
            r0.encodeWithTag(r5, 9, r10);
        L26:
            Integer r11 = r6.mthread_position;
            if (r11 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r5, 10, r11);
        L29:
            Integer r12 = r6.mthread_chat_position;
            if (r12 == null) goto L32;
            ProtoAdapter.INT32.encodeWithTag(r5, 11, r12);
        L32:
            DocExtraInfo.ADAPTER.asRepeated().encodeWithTag(r5, 12, r6.mdoc_extra_infos);
            Long r13 = r6.mavatar_key_chatter_id;
            if (r13 == null) goto L35;
            ProtoAdapter.INT64.encodeWithTag(r5, 13, r13);
        L35:
            Boolean r14 = r6.mis_p2p_chat;
            if (r14 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r5, 14, r14);
        L38:
            Boolean r15 = r6.mis_file_access_auth;
            if (r15 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r5, 15, r15);
        L41:
            com.ss.android.lark.pb.entities.Message.ThreadMessageType r16 = r6.mthread_message_type;
            if (r16 == null) goto L44;
            com.ss.android.lark.pb.entities.Message.ThreadMessageType.ADAPTER.encodeWithTag(r5, 16, r16);
        L44:
            Integer r17 = r6.mroot_message_position;
            if (r17 == null) goto L47;
            ProtoAdapter.INT32.encodeWithTag(r5, 17, r17);
        L47:
            Boolean r18 = r6.mis_restricted;
            if (r18 == null) goto L50;
            ProtoAdapter.BOOL.encodeWithTag(r5, 18, r18);
        L50:
            this.mdisabled_action.encodeWithTag(r5, 19, r6.mdisabled_action);
            Integer r19 = r6.mattachment_count;
            if (r19 == null) goto L53;
            ProtoAdapter.INT32.encodeWithTag(r5, 20, r19);
        L53:
            MessageAttachment.ADAPTER.asRepeated().encodeWithTag(r5, 21, r6.mattachments);
            String r20 = r6.mfrom_tenant_id;
            if (r20 == null) goto L56;
            r0.encodeWithTag(r5, 22, r20);
        L56:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MessageMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageMeta();
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_POSITION = 0;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_THREAD_CHAT_POSITION = 0;
        DEFAULT_AVATAR_KEY_CHATTER_ID = 0L;
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_P2P_CHAT = r0;
        DEFAULT_IS_FILE_ACCESS_AUTH = r0;
        DEFAULT_ROOT_MESSAGE_POSITION = 0;
        DEFAULT_IS_RESTRICTED = r0;
        DEFAULT_ATTACHMENT_COUNT = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2719newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtype = this.mtype;
        r0.mupdate_time = this.mupdate_time;
        r0.mcreate_time = this.mcreate_time;
        r0.mposition = this.mposition;
        r0.mchat_id = this.mchat_id;
        r0.mfile_meta = this.mfile_meta;
        r0.mfrom_id = this.mfrom_id;
        r0.mthread_id = this.mthread_id;
        r0.mthread_position = this.mthread_position;
        r0.mthread_chat_position = this.mthread_chat_position;
        r0.mdoc_extra_infos = Internal.copyOf("mdoc_extra_infos", this.mdoc_extra_infos);
        r0.mavatar_key_chatter_id = this.mavatar_key_chatter_id;
        r0.mis_p2p_chat = this.mis_p2p_chat;
        r0.mis_file_access_auth = this.mis_file_access_auth;
        r0.mthread_message_type = this.mthread_message_type;
        r0.mroot_message_position = this.mroot_message_position;
        r0.mis_restricted = this.mis_restricted;
        r0.mdisabled_action = Internal.copyOf("mdisabled_action", this.mdisabled_action);
        r0.mattachment_count = this.mattachment_count;
        r0.mattachments = Internal.copyOf("mattachments", this.mattachments);
        r0.mfrom_tenant_id = this.mfrom_tenant_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MessageMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2719newBuilder();
    }

    public MessageMeta(String r25, com.ss.android.lark.pb.entities.Message.Type r26, Long r27, Long r28, Integer r29, String r30, FileContent r31, String r32, String r33, Integer r34, Integer r35, List<DocExtraInfo> r36, Long r37, Boolean r38, Boolean r39, com.ss.android.lark.pb.entities.Message.ThreadMessageType r40, Integer r41, Boolean r42, Map<Integer, MessageBehavior> r43, Integer r44, List<MessageAttachment> r45, String r46) {
        this(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, ByteString.EMPTY);
    }

    public MessageMeta(String r4, com.ss.android.lark.pb.entities.Message.Type r5, Long r6, Long r7, Integer r8, String r9, FileContent r10, String r11, String r12, Integer r13, Integer r14, List<DocExtraInfo> r15, Long r16, Boolean r17, Boolean r18, com.ss.android.lark.pb.entities.Message.ThreadMessageType r19, Integer r20, Boolean r21, Map<Integer, MessageBehavior> r22, Integer r23, List<MessageAttachment> r24, String r25, ByteString r26) {
        super(ADAPTER, r26);
        this.mid = r4;
        this.mtype = r5;
        this.mupdate_time = r6;
        this.mcreate_time = r7;
        this.mposition = r8;
        this.mchat_id = r9;
        this.mfile_meta = r10;
        this.mfrom_id = r11;
        this.mthread_id = r12;
        this.mthread_position = r13;
        this.mthread_chat_position = r14;
        this.mdoc_extra_infos = Internal.immutableCopyOf("mdoc_extra_infos", r15);
        this.mavatar_key_chatter_id = r16;
        this.mis_p2p_chat = r17;
        this.mis_file_access_auth = r18;
        this.mthread_message_type = r19;
        this.mroot_message_position = r20;
        this.mis_restricted = r21;
        this.mdisabled_action = Internal.immutableCopyOf("mdisabled_action", r22);
        this.mattachment_count = r23;
        this.mattachments = Internal.immutableCopyOf("mattachments", r24);
        this.mfrom_tenant_id = r25;
    }
}
