package com.ss.android.lark.pb.usearch;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.DocType;
import com.ss.android.lark.pb.entities.Icon;
import com.ss.android.lark.pb.entities.TagData;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DocMeta extends Message<DocMeta, Builder> {
    public static final ProtoAdapter<DocMeta> ADAPTER = null;
    public static final Integer DEFAULT_BITABLE_BIZ_TYPE = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final Long DEFAULT_EDIT_TIME = null;
    public static final String DEFAULT_EDIT_USER_ID = "";
    public static final String DEFAULT_EDIT_USER_NAME = "";
    public static final Long DEFAULT_FILE_SIZE = null;
    public static final String DEFAULT_FILE_TYPE = "";
    public static final String DEFAULT_ICON_INFO = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_RESTRICTED = null;
    public static final Boolean DEFAULT_IS_SHARE_FOLDER = null;
    public static final Long DEFAULT_LAST_OPEN_TIME = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_MESSAGE_SENDER_NAME = "";
    public static final String DEFAULT_MIAODA_APP_ID = "";
    public static final String DEFAULT_ORI_ID = "";
    public static final String DEFAULT_ORI_TOKEN = "";
    public static final String DEFAULT_OWNER_ID = "";
    public static final String DEFAULT_OWNER_NAME = "";
    public static final Integer DEFAULT_POSITION = null;
    public static final Integer DEFAULT_ROOT_MESSAGE_POSITION = null;
    public static final Integer DEFAULT_THREAD_CHAT_POSITION = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_POSITION = null;
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final String DEFAULT_URL = "";
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MEDIT_USER_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MMESSAGE_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MOWNER_ID = null;
    private static final long serialVersionUID = 0;
    public final Integer mbitable_biz_type;
    public final String mchat_id;
    public final Long mcreate_time;
    public final Map<Integer, MessageBehavior> mdisabled_action;
    public final Long medit_time;
    public final String medit_user_id;
    public final String medit_user_name;
    public final Long mfile_size;
    public final String mfile_type;
    public final Icon micon;
    public final String micon_info;
    public final String mid;
    public final Boolean mis_cross_tenant;
    public final Boolean mis_restricted;
    public final Boolean mis_share_folder;
    public final Long mlast_open_time;
    public final String mmessage_id;
    public final String mmessage_sender_name;
    public final String mmiaoda_app_id;
    public final String mori_id;
    public final String mori_token;
    public final DocType mori_type;
    public final String mowner_id;
    public final String mowner_name;
    public final Integer mposition;
    public final TagData mrelation_tag;
    public final Integer mroot_message_position;
    public final Integer mthread_chat_position;
    public final String mthread_id;
    public final com.ss.android.lark.pb.entities.Message.ThreadMessageType mthread_message_type;
    public final Integer mthread_position;
    public final String mtoken;
    public final DocType mtype;
    public final Long mupdate_time;
    public final String murl;

    public static final class Builder extends Message.Builder<DocMeta, Builder> {
        public Integer mbitable_biz_type;
        public String mchat_id;
        public Long mcreate_time;
        public Map<Integer, MessageBehavior> mdisabled_action;
        public Long medit_time;
        public String medit_user_id;
        public String medit_user_name;
        public Long mfile_size;
        public String mfile_type;
        public Icon micon;
        public String micon_info;
        public String mid;
        public Boolean mis_cross_tenant;
        public Boolean mis_restricted;
        public Boolean mis_share_folder;
        public Long mlast_open_time;
        public String mmessage_id;
        public String mmessage_sender_name;
        public String mmiaoda_app_id;
        public String mori_id;
        public String mori_token;
        public DocType mori_type;
        public String mowner_id;
        public String mowner_name;
        public Integer mposition;
        public TagData mrelation_tag;
        public Integer mroot_message_position;
        public Integer mthread_chat_position;
        public String mthread_id;
        public com.ss.android.lark.pb.entities.Message.ThreadMessageType mthread_message_type;
        public Integer mthread_position;
        public String mtoken;
        public DocType mtype;
        public Long mupdate_time;
        public String murl;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DocMeta m2591build() {
            String r1 = this.mid;
            if (r1 == null) goto L7;
            return new DocMeta(this.mid, this.mtype, this.mupdate_time, this.murl, this.mowner_name, this.mowner_id, this.mmessage_id, this.mposition, this.mis_cross_tenant, this.mcreate_time, this.mlast_open_time, this.medit_user_id, this.medit_user_name, this.mchat_id, this.mthread_id, this.mthread_position, this.mthread_chat_position, this.micon, this.mtoken, this.mis_share_folder, this.mfile_size, this.mrelation_tag, this.mis_restricted, this.mdisabled_action, this.mori_id, this.mori_type, this.mori_token, this.micon_info, this.mthread_message_type, this.mroot_message_position, this.medit_time, this.mmessage_sender_name, this.mfile_type, this.mbitable_biz_type, this.mmiaoda_app_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r1, "mid"});
        }

        public Builder() {
            this.mdisabled_action = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2591build();
        }

        public Builder bitable_biz_type(Integer r1) {
            this.mbitable_biz_type = r1;
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

        public Builder edit_time(Long r1) {
            this.medit_time = r1;
            return this;
        }

        public Builder edit_user_id(String r1) {
            this.medit_user_id = r1;
            return this;
        }

        public Builder edit_user_name(String r1) {
            this.medit_user_name = r1;
            return this;
        }

        public Builder file_size(Long r1) {
            this.mfile_size = r1;
            return this;
        }

        public Builder file_type(String r1) {
            this.mfile_type = r1;
            return this;
        }

        public Builder icon(Icon r1) {
            this.micon = r1;
            return this;
        }

        public Builder icon_info(String r1) {
            this.micon_info = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder is_cross_tenant(Boolean r1) {
            this.mis_cross_tenant = r1;
            return this;
        }

        public Builder is_restricted(Boolean r1) {
            this.mis_restricted = r1;
            return this;
        }

        public Builder is_share_folder(Boolean r1) {
            this.mis_share_folder = r1;
            return this;
        }

        public Builder last_open_time(Long r1) {
            this.mlast_open_time = r1;
            return this;
        }

        public Builder message_id(String r1) {
            this.mmessage_id = r1;
            return this;
        }

        public Builder message_sender_name(String r1) {
            this.mmessage_sender_name = r1;
            return this;
        }

        public Builder miaoda_app_id(String r1) {
            this.mmiaoda_app_id = r1;
            return this;
        }

        public Builder ori_id(String r1) {
            this.mori_id = r1;
            return this;
        }

        public Builder ori_token(String r1) {
            this.mori_token = r1;
            return this;
        }

        public Builder ori_type(DocType r1) {
            this.mori_type = r1;
            return this;
        }

        public Builder owner_id(String r1) {
            this.mowner_id = r1;
            return this;
        }

        public Builder owner_name(String r1) {
            this.mowner_name = r1;
            return this;
        }

        public Builder position(Integer r1) {
            this.mposition = r1;
            return this;
        }

        public Builder relation_tag(TagData r1) {
            this.mrelation_tag = r1;
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

        public Builder token(String r1) {
            this.mtoken = r1;
            return this;
        }

        public Builder type(DocType r1) {
            this.mtype = r1;
            return this;
        }

        public Builder update_time(Long r1) {
            this.mupdate_time = r1;
            return this;
        }

        public Builder url(String r1) {
            this.murl = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DocMeta extends ProtoAdapter<DocMeta> {
        private final ProtoAdapter<Map<Integer, MessageBehavior>> mdisabled_action;

        public ProtoAdapter_DocMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, DocMeta.class);
            this.mdisabled_action = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, MessageBehavior.ADAPTER);
        }

        public DocMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mupdate_time = 0L;
            r0.murl = "";
            r0.mowner_name = "";
            r0.mowner_id = "";
            r0.mmessage_id = "";
            r0.mposition = 0;
            Boolean r4 = Boolean.FALSE;
            r0.mis_cross_tenant = r4;
            r0.mcreate_time = 0L;
            r0.mlast_open_time = 0L;
            r0.medit_user_id = "";
            r0.medit_user_name = "";
            r0.mchat_id = "";
            r0.mthread_id = "";
            r0.mthread_position = 0;
            r0.mthread_chat_position = 0;
            r0.mtoken = "";
            r0.mis_share_folder = r4;
            r0.mfile_size = 0L;
            r0.mis_restricted = r4;
            r0.mori_id = "";
            r0.mori_token = "";
            r0.micon_info = "";
            r0.mroot_message_position = 0;
            r0.medit_time = 0L;
            r0.mmessage_sender_name = "";
            r0.mfile_type = "";
            r0.mbitable_biz_type = 0;
            r0.mmiaoda_app_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L51;
            switch(r3) {
                case 1: goto L50;
                case 2: goto L53;
                case 3: goto L45;
                case 4: goto L44;
                case 5: goto L43;
                case 6: goto L42;
                case 7: goto L41;
                case 8: goto L40;
                case 9: goto L39;
                case 10: goto L38;
                case 11: goto L37;
                case 12: goto L36;
                case 13: goto L35;
                case 14: goto L34;
                case 15: goto L33;
                case 16: goto L32;
                case 17: goto L31;
                case 18: goto L30;
                case 19: goto L29;
                case 20: goto L28;
                case 21: goto L27;
                case 22: goto L26;
                case 23: goto L25;
                case 24: goto L24;
                case 25: goto L23;
                case 26: goto L55;
                case 27: goto L18;
                case 28: goto L17;
                case 29: goto L57;
                case 30: goto L12;
                case 31: goto L11;
                case 32: goto L10;
                case 33: goto L9;
                case 34: goto L8;
                case 35: goto L7;
                default: goto L6;
            };
        L53:
            r0.mtype = (DocType) DocType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L48
        L48:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L55:
            r0.mori_type = (DocType) DocType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L57:
            r0.mthread_message_type = (com.ss.android.lark.pb.entities.Message.ThreadMessageType) com.ss.android.lark.pb.entities.Message.ThreadMessageType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mmiaoda_app_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            r0.mbitable_biz_type = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L9:
            r0.mfile_type = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            r0.mmessage_sender_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            r0.medit_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L12:
            r0.mroot_message_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L17:
            r0.micon_info = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L18:
            r0.mori_token = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L23:
            r0.mori_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L24:
            r0.mdisabled_action.putAll((Map) this.mdisabled_action.decode(r9));
            goto L3
        L25:
            r0.mis_restricted = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L26:
            r0.mrelation_tag = (TagData) TagData.ADAPTER.decode(r9);
            goto L3
        L27:
            r0.mfile_size = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L28:
            r0.mis_share_folder = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L29:
            r0.mtoken = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L30:
            r0.micon = (Icon) Icon.ADAPTER.decode(r9);
            goto L3
        L31:
            r0.mthread_chat_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L32:
            r0.mthread_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L33:
            r0.mthread_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L34:
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L35:
            r0.medit_user_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L36:
            r0.medit_user_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L37:
            r0.mlast_open_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L38:
            r0.mcreate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L39:
            r0.mis_cross_tenant = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L40:
            r0.mposition = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L41:
            r0.mmessage_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L42:
            r0.mowner_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L43:
            r0.mowner_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L44:
            r0.murl = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L45:
            r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L50:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r5 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r5, r5.rawProtoAdapter().decode(r9));
            goto L3
        L51:
            r9.endMessage(r1);
            return r0.m2591build();
        }

        public int encodedSize(DocMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            DocType r2 = r7.mtype;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = DocType.ADAPTER.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            Long r6 = r7.mupdate_time;
            if (r6 == null) goto L9;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            String r10 = r7.murl;
            if (r10 == null) goto L13;
            int r11 = r0.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            String r13 = r7.mowner_name;
            if (r13 == null) goto L17;
            int r14 = r0.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            String r16 = r7.mowner_id;
            if (r16 == null) goto L21;
            int r17 = r0.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            String r19 = r7.mmessage_id;
            if (r19 == null) goto L25;
            int r20 = r0.encodedSizeWithTag(7, r19);
        L26:
            int r21 = r18 + r20;
            Integer r22 = r7.mposition;
            if (r22 == null) goto L29;
            int r23 = ProtoAdapter.INT32.encodedSizeWithTag(8, r22);
        L30:
            int r24 = r21 + r23;
            Boolean r25 = r7.mis_cross_tenant;
            if (r25 == null) goto L33;
            int r26 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r25);
        L34:
            int r27 = r24 + r26;
            Long r28 = r7.mcreate_time;
            if (r28 == null) goto L37;
            int r29 = ProtoAdapter.INT64.encodedSizeWithTag(10, r28);
        L38:
            int r30 = r27 + r29;
            Long r31 = r7.mlast_open_time;
            if (r31 == null) goto L41;
            int r32 = ProtoAdapter.INT64.encodedSizeWithTag(11, r31);
        L42:
            int r33 = r30 + r32;
            String r34 = r7.medit_user_id;
            if (r34 == null) goto L45;
            int r35 = r0.encodedSizeWithTag(12, r34);
        L46:
            int r36 = r33 + r35;
            String r37 = r7.medit_user_name;
            if (r37 == null) goto L49;
            int r38 = r0.encodedSizeWithTag(13, r37);
        L50:
            int r39 = r36 + r38;
            String r40 = r7.mchat_id;
            if (r40 == null) goto L53;
            int r41 = r0.encodedSizeWithTag(14, r40);
        L54:
            int r42 = r39 + r41;
            String r43 = r7.mthread_id;
            if (r43 == null) goto L57;
            int r44 = r0.encodedSizeWithTag(15, r43);
        L58:
            int r45 = r42 + r44;
            Integer r46 = r7.mthread_position;
            if (r46 == null) goto L61;
            int r47 = ProtoAdapter.INT32.encodedSizeWithTag(16, r46);
        L62:
            int r48 = r45 + r47;
            Integer r49 = r7.mthread_chat_position;
            if (r49 == null) goto L65;
            int r50 = ProtoAdapter.INT32.encodedSizeWithTag(17, r49);
        L66:
            int r51 = r48 + r50;
            Icon r52 = r7.micon;
            if (r52 == null) goto L69;
            int r53 = Icon.ADAPTER.encodedSizeWithTag(18, r52);
        L70:
            int r54 = r51 + r53;
            String r55 = r7.mtoken;
            if (r55 == null) goto L73;
            int r56 = r0.encodedSizeWithTag(19, r55);
        L74:
            int r57 = r54 + r56;
            Boolean r58 = r7.mis_share_folder;
            if (r58 == null) goto L77;
            int r59 = ProtoAdapter.BOOL.encodedSizeWithTag(20, r58);
        L78:
            int r60 = r57 + r59;
            Long r61 = r7.mfile_size;
            if (r61 == null) goto L81;
            int r62 = ProtoAdapter.INT64.encodedSizeWithTag(21, r61);
        L82:
            int r63 = r60 + r62;
            TagData r64 = r7.mrelation_tag;
            if (r64 == null) goto L85;
            int r65 = TagData.ADAPTER.encodedSizeWithTag(22, r64);
        L86:
            int r66 = r63 + r65;
            Boolean r67 = r7.mis_restricted;
            if (r67 == null) goto L89;
            int r68 = ProtoAdapter.BOOL.encodedSizeWithTag(23, r67);
        L90:
            int r69 = (r66 + r68) + this.mdisabled_action.encodedSizeWithTag(24, r7.mdisabled_action);
            String r70 = r7.mori_id;
            if (r70 == null) goto L93;
            int r71 = r0.encodedSizeWithTag(25, r70);
        L94:
            int r72 = r69 + r71;
            DocType r73 = r7.mori_type;
            if (r73 == null) goto L97;
            int r74 = DocType.ADAPTER.encodedSizeWithTag(26, r73);
        L98:
            int r75 = r72 + r74;
            String r76 = r7.mori_token;
            if (r76 == null) goto L101;
            int r77 = r0.encodedSizeWithTag(27, r76);
        L102:
            int r78 = r75 + r77;
            String r79 = r7.micon_info;
            if (r79 == null) goto L105;
            int r80 = r0.encodedSizeWithTag(28, r79);
        L106:
            int r81 = r78 + r80;
            com.ss.android.lark.pb.entities.Message.ThreadMessageType r82 = r7.mthread_message_type;
            if (r82 == null) goto L109;
            int r83 = com.ss.android.lark.pb.entities.Message.ThreadMessageType.ADAPTER.encodedSizeWithTag(29, r82);
        L110:
            int r84 = r81 + r83;
            Integer r85 = r7.mroot_message_position;
            if (r85 == null) goto L113;
            int r86 = ProtoAdapter.INT32.encodedSizeWithTag(30, r85);
        L114:
            int r87 = r84 + r86;
            Long r88 = r7.medit_time;
            if (r88 == null) goto L117;
            int r89 = ProtoAdapter.INT64.encodedSizeWithTag(31, r88);
        L118:
            int r90 = r87 + r89;
            String r91 = r7.mmessage_sender_name;
            if (r91 == null) goto L121;
            int r92 = r0.encodedSizeWithTag(32, r91);
        L122:
            int r93 = r90 + r92;
            String r94 = r7.mfile_type;
            if (r94 == null) goto L125;
            int r95 = r0.encodedSizeWithTag(33, r94);
        L126:
            int r96 = r93 + r95;
            Integer r97 = r7.mbitable_biz_type;
            if (r97 == null) goto L129;
            int r98 = ProtoAdapter.INT32.encodedSizeWithTag(34, r97);
        L130:
            int r99 = r96 + r98;
            String r100 = r7.mmiaoda_app_id;
            if (r100 == null) goto L134;
            r3 = r0.encodedSizeWithTag(35, r100);
        L134:
            return (r99 + r3) + r7.unknownFields().size();
        L129:
            r98 = 0;
            goto L130
        L125:
            r95 = 0;
            goto L126
        L121:
            r92 = 0;
            goto L122
        L117:
            r89 = 0;
            goto L118
        L113:
            r86 = 0;
            goto L114
        L109:
            r83 = 0;
            goto L110
        L105:
            r80 = 0;
            goto L106
        L101:
            r77 = 0;
            goto L102
        L97:
            r74 = 0;
            goto L98
        L93:
            r71 = 0;
            goto L94
        L89:
            r68 = 0;
            goto L90
        L85:
            r65 = 0;
            goto L86
        L81:
            r62 = 0;
            goto L82
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
        public /* bridge */ /* synthetic */ Object m2592decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DocMeta) r1);
        }

        public void encode(ProtoWriter r5, DocMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            DocType r1 = r6.mtype;
            if (r1 == null) goto L5;
            DocType.ADAPTER.encodeWithTag(r5, 2, r1);
        L5:
            Long r2 = r6.mupdate_time;
            if (r2 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r5, 3, r2);
        L8:
            String r3 = r6.murl;
            if (r3 == null) goto L11;
            r0.encodeWithTag(r5, 4, r3);
        L11:
            String r4 = r6.mowner_name;
            if (r4 == null) goto L14;
            r0.encodeWithTag(r5, 5, r4);
        L14:
            String r7 = r6.mowner_id;
            if (r7 == null) goto L17;
            r0.encodeWithTag(r5, 6, r7);
        L17:
            String r8 = r6.mmessage_id;
            if (r8 == null) goto L20;
            r0.encodeWithTag(r5, 7, r8);
        L20:
            Integer r9 = r6.mposition;
            if (r9 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r5, 8, r9);
        L23:
            Boolean r10 = r6.mis_cross_tenant;
            if (r10 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r5, 9, r10);
        L26:
            Long r11 = r6.mcreate_time;
            if (r11 == null) goto L29;
            ProtoAdapter.INT64.encodeWithTag(r5, 10, r11);
        L29:
            Long r12 = r6.mlast_open_time;
            if (r12 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r5, 11, r12);
        L32:
            String r13 = r6.medit_user_id;
            if (r13 == null) goto L35;
            r0.encodeWithTag(r5, 12, r13);
        L35:
            String r14 = r6.medit_user_name;
            if (r14 == null) goto L38;
            r0.encodeWithTag(r5, 13, r14);
        L38:
            String r15 = r6.mchat_id;
            if (r15 == null) goto L41;
            r0.encodeWithTag(r5, 14, r15);
        L41:
            String r16 = r6.mthread_id;
            if (r16 == null) goto L44;
            r0.encodeWithTag(r5, 15, r16);
        L44:
            Integer r17 = r6.mthread_position;
            if (r17 == null) goto L47;
            ProtoAdapter.INT32.encodeWithTag(r5, 16, r17);
        L47:
            Integer r18 = r6.mthread_chat_position;
            if (r18 == null) goto L50;
            ProtoAdapter.INT32.encodeWithTag(r5, 17, r18);
        L50:
            Icon r19 = r6.micon;
            if (r19 == null) goto L53;
            Icon.ADAPTER.encodeWithTag(r5, 18, r19);
        L53:
            String r20 = r6.mtoken;
            if (r20 == null) goto L56;
            r0.encodeWithTag(r5, 19, r20);
        L56:
            Boolean r21 = r6.mis_share_folder;
            if (r21 == null) goto L59;
            ProtoAdapter.BOOL.encodeWithTag(r5, 20, r21);
        L59:
            Long r22 = r6.mfile_size;
            if (r22 == null) goto L62;
            ProtoAdapter.INT64.encodeWithTag(r5, 21, r22);
        L62:
            TagData r23 = r6.mrelation_tag;
            if (r23 == null) goto L65;
            TagData.ADAPTER.encodeWithTag(r5, 22, r23);
        L65:
            Boolean r24 = r6.mis_restricted;
            if (r24 == null) goto L68;
            ProtoAdapter.BOOL.encodeWithTag(r5, 23, r24);
        L68:
            this.mdisabled_action.encodeWithTag(r5, 24, r6.mdisabled_action);
            String r25 = r6.mori_id;
            if (r25 == null) goto L71;
            r0.encodeWithTag(r5, 25, r25);
        L71:
            DocType r26 = r6.mori_type;
            if (r26 == null) goto L74;
            DocType.ADAPTER.encodeWithTag(r5, 26, r26);
        L74:
            String r27 = r6.mori_token;
            if (r27 == null) goto L77;
            r0.encodeWithTag(r5, 27, r27);
        L77:
            String r28 = r6.micon_info;
            if (r28 == null) goto L80;
            r0.encodeWithTag(r5, 28, r28);
        L80:
            com.ss.android.lark.pb.entities.Message.ThreadMessageType r29 = r6.mthread_message_type;
            if (r29 == null) goto L83;
            com.ss.android.lark.pb.entities.Message.ThreadMessageType.ADAPTER.encodeWithTag(r5, 29, r29);
        L83:
            Integer r30 = r6.mroot_message_position;
            if (r30 == null) goto L86;
            ProtoAdapter.INT32.encodeWithTag(r5, 30, r30);
        L86:
            Long r31 = r6.medit_time;
            if (r31 == null) goto L89;
            ProtoAdapter.INT64.encodeWithTag(r5, 31, r31);
        L89:
            String r32 = r6.mmessage_sender_name;
            if (r32 == null) goto L92;
            r0.encodeWithTag(r5, 32, r32);
        L92:
            String r33 = r6.mfile_type;
            if (r33 == null) goto L95;
            r0.encodeWithTag(r5, 33, r33);
        L95:
            Integer r34 = r6.mbitable_biz_type;
            if (r34 == null) goto L98;
            ProtoAdapter.INT32.encodeWithTag(r5, 34, r34);
        L98:
            String r35 = r6.mmiaoda_app_id;
            if (r35 == null) goto L101;
            r0.encodeWithTag(r5, 35, r35);
        L101:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DocMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocMeta();
        FIELD_OPTIONS_MOWNER_ID = new FieldOptions.Builder().id("user_id").build();
        FIELD_OPTIONS_MMESSAGE_ID = new FieldOptions.Builder().id("message_id").build();
        FIELD_OPTIONS_MEDIT_USER_ID = new FieldOptions.Builder().id("user_id").build();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().id("chat_id").build();
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_POSITION = 0;
        Boolean r2 = Boolean.FALSE;
        DEFAULT_IS_CROSS_TENANT = r2;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_LAST_OPEN_TIME = 0L;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_THREAD_CHAT_POSITION = 0;
        DEFAULT_IS_SHARE_FOLDER = r2;
        DEFAULT_FILE_SIZE = 0L;
        DEFAULT_IS_RESTRICTED = r2;
        DEFAULT_ROOT_MESSAGE_POSITION = 0;
        DEFAULT_EDIT_TIME = 0L;
        DEFAULT_BITABLE_BIZ_TYPE = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2590newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtype = this.mtype;
        r0.mupdate_time = this.mupdate_time;
        r0.murl = this.murl;
        r0.mowner_name = this.mowner_name;
        r0.mowner_id = this.mowner_id;
        r0.mmessage_id = this.mmessage_id;
        r0.mposition = this.mposition;
        r0.mis_cross_tenant = this.mis_cross_tenant;
        r0.mcreate_time = this.mcreate_time;
        r0.mlast_open_time = this.mlast_open_time;
        r0.medit_user_id = this.medit_user_id;
        r0.medit_user_name = this.medit_user_name;
        r0.mchat_id = this.mchat_id;
        r0.mthread_id = this.mthread_id;
        r0.mthread_position = this.mthread_position;
        r0.mthread_chat_position = this.mthread_chat_position;
        r0.micon = this.micon;
        r0.mtoken = this.mtoken;
        r0.mis_share_folder = this.mis_share_folder;
        r0.mfile_size = this.mfile_size;
        r0.mrelation_tag = this.mrelation_tag;
        r0.mis_restricted = this.mis_restricted;
        r0.mdisabled_action = Internal.copyOf("mdisabled_action", this.mdisabled_action);
        r0.mori_id = this.mori_id;
        r0.mori_type = this.mori_type;
        r0.mori_token = this.mori_token;
        r0.micon_info = this.micon_info;
        r0.mthread_message_type = this.mthread_message_type;
        r0.mroot_message_position = this.mroot_message_position;
        r0.medit_time = this.medit_time;
        r0.mmessage_sender_name = this.mmessage_sender_name;
        r0.mfile_type = this.mfile_type;
        r0.mbitable_biz_type = this.mbitable_biz_type;
        r0.mmiaoda_app_id = this.mmiaoda_app_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DocMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2590newBuilder();
    }

    public DocMeta(String r38, DocType r39, Long r40, String r41, String r42, String r43, String r44, Integer r45, Boolean r46, Long r47, Long r48, String r49, String r50, String r51, String r52, Integer r53, Integer r54, Icon r55, String r56, Boolean r57, Long r58, TagData r59, Boolean r60, Map<Integer, MessageBehavior> r61, String r62, DocType r63, String r64, String r65, com.ss.android.lark.pb.entities.Message.ThreadMessageType r66, Integer r67, Long r68, String r69, String r70, Integer r71, String r72) {
        this(r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, ByteString.EMPTY);
    }

    public DocMeta(String r4, DocType r5, Long r6, String r7, String r8, String r9, String r10, Integer r11, Boolean r12, Long r13, Long r14, String r15, String r16, String r17, String r18, Integer r19, Integer r20, Icon r21, String r22, Boolean r23, Long r24, TagData r25, Boolean r26, Map<Integer, MessageBehavior> r27, String r28, DocType r29, String r30, String r31, com.ss.android.lark.pb.entities.Message.ThreadMessageType r32, Integer r33, Long r34, String r35, String r36, Integer r37, String r38, ByteString r39) {
        super(ADAPTER, r39);
        this.mid = r4;
        this.mtype = r5;
        this.mupdate_time = r6;
        this.murl = r7;
        this.mowner_name = r8;
        this.mowner_id = r9;
        this.mmessage_id = r10;
        this.mposition = r11;
        this.mis_cross_tenant = r12;
        this.mcreate_time = r13;
        this.mlast_open_time = r14;
        this.medit_user_id = r15;
        this.medit_user_name = r16;
        this.mchat_id = r17;
        this.mthread_id = r18;
        this.mthread_position = r19;
        this.mthread_chat_position = r20;
        this.micon = r21;
        this.mtoken = r22;
        this.mis_share_folder = r23;
        this.mfile_size = r24;
        this.mrelation_tag = r25;
        this.mis_restricted = r26;
        this.mdisabled_action = Internal.immutableCopyOf("mdisabled_action", r27);
        this.mori_id = r28;
        this.mori_type = r29;
        this.mori_token = r30;
        this.micon_info = r31;
        this.mthread_message_type = r32;
        this.mroot_message_position = r33;
        this.medit_time = r34;
        this.mmessage_sender_name = r35;
        this.mfile_type = r36;
        this.mbitable_biz_type = r37;
        this.mmiaoda_app_id = r38;
    }
}
