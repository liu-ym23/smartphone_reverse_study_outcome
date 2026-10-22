package com.ss.android.lark.pb.usearch;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.DocType;
import com.ss.android.lark.pb.entities.TagData;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class WikiMeta extends Message<WikiMeta, Builder> {
    public static final ProtoAdapter<WikiMeta> ADAPTER = null;
    public static final Integer DEFAULT_BITABLE_BIZ_TYPE = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_DOC_URL = "";
    public static final Long DEFAULT_EDIT_TIME = null;
    public static final String DEFAULT_EDIT_USER_ID = "";
    public static final String DEFAULT_EDIT_USER_NAME = "";
    public static final Long DEFAULT_FILE_SIZE = null;
    public static final String DEFAULT_FILE_TYPE = "";
    public static final String DEFAULT_ICON_INFO = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Boolean DEFAULT_IS_RESTRICTED = null;
    public static final Long DEFAULT_LAST_OPEN_TIME = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_MESSAGE_SENDER_NAME = "";
    public static final String DEFAULT_ORI_ID = "";
    public static final String DEFAULT_ORI_TOKEN = "";
    public static final String DEFAULT_OWNER_ID = "";
    public static final String DEFAULT_OWNER_NAME = "";
    public static final Integer DEFAULT_POSITION = null;
    public static final Integer DEFAULT_ROOT_MESSAGE_POSITION = null;
    public static final Long DEFAULT_SPACE_ID = null;
    public static final String DEFAULT_SPACE_NAME = "";
    public static final Integer DEFAULT_THREAD_CHAT_POSITION = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_POSITION = null;
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final String DEFAULT_URL = "";
    public static final String DEFAULT_WIKI_TOKEN = "";
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MEDIT_USER_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MMESSAGE_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MOWNER_ID = null;
    private static final long serialVersionUID = 0;
    public final Integer mbitable_biz_type;
    public final String mchat_id;
    public final Long mcreate_time;
    public final Map<Integer, MessageBehavior> mdisabled_action;
    public final String mdoc_url;
    public final Long medit_time;
    public final String medit_user_id;
    public final String medit_user_name;
    public final Long mfile_size;
    public final String mfile_type;
    public final String micon_info;
    public final String mid;
    public final Boolean mis_cross_tenant;
    public final Boolean mis_restricted;
    public final Long mlast_open_time;
    public final String mmessage_id;
    public final String mmessage_sender_name;
    public final String mori_id;
    public final String mori_token;
    public final DocType mori_type;
    public final String mowner_id;
    public final String mowner_name;
    public final Integer mposition;
    public final TagData mrelation_tag;
    public final Integer mroot_message_position;
    public final Long mspace_id;
    public final String mspace_name;
    public final Integer mthread_chat_position;
    public final String mthread_id;
    public final com.ss.android.lark.pb.entities.Message.ThreadMessageType mthread_message_type;
    public final Integer mthread_position;
    public final String mtoken;
    public final DocType mtype;
    public final Long mupdate_time;
    public final String murl;
    public final String mwiki_token;

    public static final class Builder extends Message.Builder<WikiMeta, Builder> {
        public Integer mbitable_biz_type;
        public String mchat_id;
        public Long mcreate_time;
        public Map<Integer, MessageBehavior> mdisabled_action;
        public String mdoc_url;
        public Long medit_time;
        public String medit_user_id;
        public String medit_user_name;
        public Long mfile_size;
        public String mfile_type;
        public String micon_info;
        public String mid;
        public Boolean mis_cross_tenant;
        public Boolean mis_restricted;
        public Long mlast_open_time;
        public String mmessage_id;
        public String mmessage_sender_name;
        public String mori_id;
        public String mori_token;
        public DocType mori_type;
        public String mowner_id;
        public String mowner_name;
        public Integer mposition;
        public TagData mrelation_tag;
        public Integer mroot_message_position;
        public Long mspace_id;
        public String mspace_name;
        public Integer mthread_chat_position;
        public String mthread_id;
        public com.ss.android.lark.pb.entities.Message.ThreadMessageType mthread_message_type;
        public Integer mthread_position;
        public String mtoken;
        public DocType mtype;
        public Long mupdate_time;
        public String murl;
        public String mwiki_token;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public WikiMeta m2978build() {
            String r1 = this.mid;
            if (r1 == null) goto L7;
            return new WikiMeta(this.mid, this.mtype, this.mupdate_time, this.mis_cross_tenant, this.mchat_id, this.mposition, this.mthread_id, this.mthread_position, this.mthread_chat_position, this.mmessage_id, this.mcreate_time, this.mlast_open_time, this.medit_user_id, this.medit_user_name, this.murl, this.mdoc_url, this.mspace_id, this.mspace_name, this.mtoken, this.mowner_id, this.mowner_name, this.mfile_size, this.mrelation_tag, this.mis_restricted, this.mdisabled_action, this.mori_id, this.mori_type, this.mori_token, this.micon_info, this.mthread_message_type, this.mroot_message_position, this.medit_time, this.mmessage_sender_name, this.mwiki_token, this.mfile_type, this.mbitable_biz_type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r1, "mid"});
        }

        public Builder() {
            this.mdisabled_action = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2978build();
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

        public Builder doc_url(String r1) {
            this.mdoc_url = r1;
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

        public Builder space_id(Long r1) {
            this.mspace_id = r1;
            return this;
        }

        public Builder space_name(String r1) {
            this.mspace_name = r1;
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

        public Builder wiki_token(String r1) {
            this.mwiki_token = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_WikiMeta extends ProtoAdapter<WikiMeta> {
        private final ProtoAdapter<Map<Integer, MessageBehavior>> mdisabled_action;

        public ProtoAdapter_WikiMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, WikiMeta.class);
            this.mdisabled_action = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, MessageBehavior.ADAPTER);
        }

        public WikiMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mupdate_time = 0L;
            Boolean r3 = Boolean.FALSE;
            r0.mis_cross_tenant = r3;
            r0.mchat_id = "";
            r0.mposition = 0;
            r0.mthread_id = "";
            r0.mthread_position = 0;
            r0.mthread_chat_position = 0;
            r0.mmessage_id = "";
            r0.mcreate_time = 0L;
            r0.mlast_open_time = 0L;
            r0.medit_user_id = "";
            r0.medit_user_name = "";
            r0.murl = "";
            r0.mdoc_url = "";
            r0.mspace_id = 0L;
            r0.mspace_name = "";
            r0.mtoken = "";
            r0.mowner_id = "";
            r0.mowner_name = "";
            r0.mfile_size = 0L;
            r0.mis_restricted = r3;
            r0.mori_id = "";
            r0.mori_token = "";
            r0.micon_info = "";
            r0.mroot_message_position = 0;
            r0.medit_time = 0L;
            r0.mmessage_sender_name = "";
            r0.mwiki_token = "";
            r0.mfile_type = "";
            r0.mbitable_biz_type = 0;
            long r1 = r9.beginMessage();
        L3:
            int r4 = r9.nextTag();
            if (r4 == (-1)) goto L52;
            switch(r4) {
                case 1: goto L51;
                case 2: goto L58;
                case 3: goto L46;
                case 4: goto L45;
                case 5: goto L44;
                case 6: goto L43;
                case 7: goto L42;
                case 8: goto L41;
                case 9: goto L40;
                case 10: goto L39;
                case 11: goto L38;
                case 12: goto L37;
                case 13: goto L36;
                case 14: goto L35;
                case 15: goto L34;
                case 16: goto L33;
                case 17: goto L32;
                case 18: goto L31;
                case 19: goto L30;
                case 20: goto L29;
                case 21: goto L28;
                case 22: goto L27;
                case 23: goto L26;
                case 24: goto L25;
                case 25: goto L24;
                case 26: goto L23;
                case 27: goto L54;
                case 28: goto L18;
                case 29: goto L17;
                case 30: goto L56;
                case 31: goto L12;
                case 32: goto L11;
                case 33: goto L10;
                case 34: goto L9;
                case 35: goto L8;
                case 36: goto L7;
                default: goto L6;
            };
        L54:
            r0.mori_type = (DocType) DocType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r0.addUnknownField(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L56:
            r0.mthread_message_type = (com.ss.android.lark.pb.entities.Message.ThreadMessageType) com.ss.android.lark.pb.entities.Message.ThreadMessageType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L58:
            r0.mtype = (DocType) DocType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L49
        L49:
            e = move-exception;
            r0.addUnknownField(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mbitable_biz_type = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L8:
            r0.mfile_type = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            r0.mwiki_token = (String) ProtoAdapter.STRING.decode(r9);
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
            r0.mowner_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L29:
            r0.mowner_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L30:
            r0.mtoken = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L31:
            r0.mspace_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L32:
            r0.mspace_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L33:
            r0.mdoc_url = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L34:
            r0.murl = (String) ProtoAdapter.STRING.decode(r9);
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
            r0.mmessage_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L40:
            r0.mthread_chat_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L41:
            r0.mthread_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L42:
            r0.mthread_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L43:
            r0.mposition = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L44:
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L45:
            r0.mis_cross_tenant = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L46:
            r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L51:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r5 = r9.peekFieldEncoding();
            r0.addUnknownField(r4, r5, r5.rawProtoAdapter().decode(r9));
            goto L3
        L52:
            r9.endMessage(r1);
            return r0.m2978build();
        }

        public int encodedSize(WikiMeta r7) {
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
            Boolean r10 = r7.mis_cross_tenant;
            if (r10 == null) goto L13;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            String r13 = r7.mchat_id;
            if (r13 == null) goto L17;
            int r14 = r0.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            Integer r16 = r7.mposition;
            if (r16 == null) goto L21;
            int r17 = ProtoAdapter.INT32.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            String r19 = r7.mthread_id;
            if (r19 == null) goto L25;
            int r20 = r0.encodedSizeWithTag(7, r19);
        L26:
            int r21 = r18 + r20;
            Integer r22 = r7.mthread_position;
            if (r22 == null) goto L29;
            int r23 = ProtoAdapter.INT32.encodedSizeWithTag(8, r22);
        L30:
            int r24 = r21 + r23;
            Integer r25 = r7.mthread_chat_position;
            if (r25 == null) goto L33;
            int r26 = ProtoAdapter.INT32.encodedSizeWithTag(9, r25);
        L34:
            int r27 = r24 + r26;
            String r28 = r7.mmessage_id;
            if (r28 == null) goto L37;
            int r29 = r0.encodedSizeWithTag(10, r28);
        L38:
            int r30 = r27 + r29;
            Long r31 = r7.mcreate_time;
            if (r31 == null) goto L41;
            int r32 = ProtoAdapter.INT64.encodedSizeWithTag(11, r31);
        L42:
            int r33 = r30 + r32;
            Long r34 = r7.mlast_open_time;
            if (r34 == null) goto L45;
            int r35 = ProtoAdapter.INT64.encodedSizeWithTag(12, r34);
        L46:
            int r36 = r33 + r35;
            String r37 = r7.medit_user_id;
            if (r37 == null) goto L49;
            int r38 = r0.encodedSizeWithTag(13, r37);
        L50:
            int r39 = r36 + r38;
            String r40 = r7.medit_user_name;
            if (r40 == null) goto L53;
            int r41 = r0.encodedSizeWithTag(14, r40);
        L54:
            int r42 = r39 + r41;
            String r43 = r7.murl;
            if (r43 == null) goto L57;
            int r44 = r0.encodedSizeWithTag(15, r43);
        L58:
            int r45 = r42 + r44;
            String r46 = r7.mdoc_url;
            if (r46 == null) goto L61;
            int r47 = r0.encodedSizeWithTag(16, r46);
        L62:
            int r48 = r45 + r47;
            Long r49 = r7.mspace_id;
            if (r49 == null) goto L65;
            int r50 = ProtoAdapter.INT64.encodedSizeWithTag(17, r49);
        L66:
            int r51 = r48 + r50;
            String r52 = r7.mspace_name;
            if (r52 == null) goto L69;
            int r53 = r0.encodedSizeWithTag(18, r52);
        L70:
            int r54 = r51 + r53;
            String r55 = r7.mtoken;
            if (r55 == null) goto L73;
            int r56 = r0.encodedSizeWithTag(19, r55);
        L74:
            int r57 = r54 + r56;
            String r58 = r7.mowner_id;
            if (r58 == null) goto L77;
            int r59 = r0.encodedSizeWithTag(20, r58);
        L78:
            int r60 = r57 + r59;
            String r61 = r7.mowner_name;
            if (r61 == null) goto L81;
            int r62 = r0.encodedSizeWithTag(21, r61);
        L82:
            int r63 = r60 + r62;
            Long r64 = r7.mfile_size;
            if (r64 == null) goto L85;
            int r65 = ProtoAdapter.INT64.encodedSizeWithTag(22, r64);
        L86:
            int r66 = r63 + r65;
            TagData r67 = r7.mrelation_tag;
            if (r67 == null) goto L89;
            int r68 = TagData.ADAPTER.encodedSizeWithTag(23, r67);
        L90:
            int r69 = r66 + r68;
            Boolean r70 = r7.mis_restricted;
            if (r70 == null) goto L93;
            int r71 = ProtoAdapter.BOOL.encodedSizeWithTag(24, r70);
        L94:
            int r72 = (r69 + r71) + this.mdisabled_action.encodedSizeWithTag(25, r7.mdisabled_action);
            String r73 = r7.mori_id;
            if (r73 == null) goto L97;
            int r74 = r0.encodedSizeWithTag(26, r73);
        L98:
            int r75 = r72 + r74;
            DocType r76 = r7.mori_type;
            if (r76 == null) goto L101;
            int r77 = DocType.ADAPTER.encodedSizeWithTag(27, r76);
        L102:
            int r78 = r75 + r77;
            String r79 = r7.mori_token;
            if (r79 == null) goto L105;
            int r80 = r0.encodedSizeWithTag(28, r79);
        L106:
            int r81 = r78 + r80;
            String r82 = r7.micon_info;
            if (r82 == null) goto L109;
            int r83 = r0.encodedSizeWithTag(29, r82);
        L110:
            int r84 = r81 + r83;
            com.ss.android.lark.pb.entities.Message.ThreadMessageType r85 = r7.mthread_message_type;
            if (r85 == null) goto L113;
            int r86 = com.ss.android.lark.pb.entities.Message.ThreadMessageType.ADAPTER.encodedSizeWithTag(30, r85);
        L114:
            int r87 = r84 + r86;
            Integer r88 = r7.mroot_message_position;
            if (r88 == null) goto L117;
            int r89 = ProtoAdapter.INT32.encodedSizeWithTag(31, r88);
        L118:
            int r90 = r87 + r89;
            Long r91 = r7.medit_time;
            if (r91 == null) goto L121;
            int r92 = ProtoAdapter.INT64.encodedSizeWithTag(32, r91);
        L122:
            int r93 = r90 + r92;
            String r94 = r7.mmessage_sender_name;
            if (r94 == null) goto L125;
            int r95 = r0.encodedSizeWithTag(33, r94);
        L126:
            int r96 = r93 + r95;
            String r97 = r7.mwiki_token;
            if (r97 == null) goto L129;
            int r98 = r0.encodedSizeWithTag(34, r97);
        L130:
            int r99 = r96 + r98;
            String r100 = r7.mfile_type;
            if (r100 == null) goto L133;
            int r101 = r0.encodedSizeWithTag(35, r100);
        L134:
            int r102 = r99 + r101;
            Integer r103 = r7.mbitable_biz_type;
            if (r103 == null) goto L138;
            r3 = ProtoAdapter.INT32.encodedSizeWithTag(36, r103);
        L138:
            return (r102 + r3) + r7.unknownFields().size();
        L133:
            r101 = 0;
            goto L134
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
        public /* bridge */ /* synthetic */ Object m2979decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((WikiMeta) r1);
        }

        public void encode(ProtoWriter r5, WikiMeta r6) throws IOException {
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
            Boolean r3 = r6.mis_cross_tenant;
            if (r3 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r5, 4, r3);
        L11:
            String r4 = r6.mchat_id;
            if (r4 == null) goto L14;
            r0.encodeWithTag(r5, 5, r4);
        L14:
            Integer r7 = r6.mposition;
            if (r7 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r5, 6, r7);
        L17:
            String r8 = r6.mthread_id;
            if (r8 == null) goto L20;
            r0.encodeWithTag(r5, 7, r8);
        L20:
            Integer r9 = r6.mthread_position;
            if (r9 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r5, 8, r9);
        L23:
            Integer r10 = r6.mthread_chat_position;
            if (r10 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r5, 9, r10);
        L26:
            String r11 = r6.mmessage_id;
            if (r11 == null) goto L29;
            r0.encodeWithTag(r5, 10, r11);
        L29:
            Long r12 = r6.mcreate_time;
            if (r12 == null) goto L32;
            ProtoAdapter.INT64.encodeWithTag(r5, 11, r12);
        L32:
            Long r13 = r6.mlast_open_time;
            if (r13 == null) goto L35;
            ProtoAdapter.INT64.encodeWithTag(r5, 12, r13);
        L35:
            String r14 = r6.medit_user_id;
            if (r14 == null) goto L38;
            r0.encodeWithTag(r5, 13, r14);
        L38:
            String r15 = r6.medit_user_name;
            if (r15 == null) goto L41;
            r0.encodeWithTag(r5, 14, r15);
        L41:
            String r16 = r6.murl;
            if (r16 == null) goto L44;
            r0.encodeWithTag(r5, 15, r16);
        L44:
            String r17 = r6.mdoc_url;
            if (r17 == null) goto L47;
            r0.encodeWithTag(r5, 16, r17);
        L47:
            Long r18 = r6.mspace_id;
            if (r18 == null) goto L50;
            ProtoAdapter.INT64.encodeWithTag(r5, 17, r18);
        L50:
            String r19 = r6.mspace_name;
            if (r19 == null) goto L53;
            r0.encodeWithTag(r5, 18, r19);
        L53:
            String r20 = r6.mtoken;
            if (r20 == null) goto L56;
            r0.encodeWithTag(r5, 19, r20);
        L56:
            String r21 = r6.mowner_id;
            if (r21 == null) goto L59;
            r0.encodeWithTag(r5, 20, r21);
        L59:
            String r22 = r6.mowner_name;
            if (r22 == null) goto L62;
            r0.encodeWithTag(r5, 21, r22);
        L62:
            Long r23 = r6.mfile_size;
            if (r23 == null) goto L65;
            ProtoAdapter.INT64.encodeWithTag(r5, 22, r23);
        L65:
            TagData r24 = r6.mrelation_tag;
            if (r24 == null) goto L68;
            TagData.ADAPTER.encodeWithTag(r5, 23, r24);
        L68:
            Boolean r25 = r6.mis_restricted;
            if (r25 == null) goto L71;
            ProtoAdapter.BOOL.encodeWithTag(r5, 24, r25);
        L71:
            this.mdisabled_action.encodeWithTag(r5, 25, r6.mdisabled_action);
            String r26 = r6.mori_id;
            if (r26 == null) goto L74;
            r0.encodeWithTag(r5, 26, r26);
        L74:
            DocType r27 = r6.mori_type;
            if (r27 == null) goto L77;
            DocType.ADAPTER.encodeWithTag(r5, 27, r27);
        L77:
            String r28 = r6.mori_token;
            if (r28 == null) goto L80;
            r0.encodeWithTag(r5, 28, r28);
        L80:
            String r29 = r6.micon_info;
            if (r29 == null) goto L83;
            r0.encodeWithTag(r5, 29, r29);
        L83:
            com.ss.android.lark.pb.entities.Message.ThreadMessageType r30 = r6.mthread_message_type;
            if (r30 == null) goto L86;
            com.ss.android.lark.pb.entities.Message.ThreadMessageType.ADAPTER.encodeWithTag(r5, 30, r30);
        L86:
            Integer r31 = r6.mroot_message_position;
            if (r31 == null) goto L89;
            ProtoAdapter.INT32.encodeWithTag(r5, 31, r31);
        L89:
            Long r32 = r6.medit_time;
            if (r32 == null) goto L92;
            ProtoAdapter.INT64.encodeWithTag(r5, 32, r32);
        L92:
            String r33 = r6.mmessage_sender_name;
            if (r33 == null) goto L95;
            r0.encodeWithTag(r5, 33, r33);
        L95:
            String r34 = r6.mwiki_token;
            if (r34 == null) goto L98;
            r0.encodeWithTag(r5, 34, r34);
        L98:
            String r35 = r6.mfile_type;
            if (r35 == null) goto L101;
            r0.encodeWithTag(r5, 35, r35);
        L101:
            Integer r36 = r6.mbitable_biz_type;
            if (r36 == null) goto L104;
            ProtoAdapter.INT32.encodeWithTag(r5, 36, r36);
        L104:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (WikiMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WikiMeta();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().id("chat_id").build();
        FIELD_OPTIONS_MMESSAGE_ID = new FieldOptions.Builder().id("message_id").build();
        FIELD_OPTIONS_MEDIT_USER_ID = new FieldOptions.Builder().id("user_id").build();
        FIELD_OPTIONS_MOWNER_ID = new FieldOptions.Builder().id("user_id").build();
        DEFAULT_UPDATE_TIME = 0L;
        Boolean r1 = Boolean.FALSE;
        DEFAULT_IS_CROSS_TENANT = r1;
        DEFAULT_POSITION = 0;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_THREAD_CHAT_POSITION = 0;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_LAST_OPEN_TIME = 0L;
        DEFAULT_SPACE_ID = 0L;
        DEFAULT_FILE_SIZE = 0L;
        DEFAULT_IS_RESTRICTED = r1;
        DEFAULT_ROOT_MESSAGE_POSITION = 0;
        DEFAULT_EDIT_TIME = 0L;
        DEFAULT_BITABLE_BIZ_TYPE = 0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2977newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtype = this.mtype;
        r0.mupdate_time = this.mupdate_time;
        r0.mis_cross_tenant = this.mis_cross_tenant;
        r0.mchat_id = this.mchat_id;
        r0.mposition = this.mposition;
        r0.mthread_id = this.mthread_id;
        r0.mthread_position = this.mthread_position;
        r0.mthread_chat_position = this.mthread_chat_position;
        r0.mmessage_id = this.mmessage_id;
        r0.mcreate_time = this.mcreate_time;
        r0.mlast_open_time = this.mlast_open_time;
        r0.medit_user_id = this.medit_user_id;
        r0.medit_user_name = this.medit_user_name;
        r0.murl = this.murl;
        r0.mdoc_url = this.mdoc_url;
        r0.mspace_id = this.mspace_id;
        r0.mspace_name = this.mspace_name;
        r0.mtoken = this.mtoken;
        r0.mowner_id = this.mowner_id;
        r0.mowner_name = this.mowner_name;
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
        r0.mwiki_token = this.mwiki_token;
        r0.mfile_type = this.mfile_type;
        r0.mbitable_biz_type = this.mbitable_biz_type;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return WikiMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2977newBuilder();
    }

    public WikiMeta(String r39, DocType r40, Long r41, Boolean r42, String r43, Integer r44, String r45, Integer r46, Integer r47, String r48, Long r49, Long r50, String r51, String r52, String r53, String r54, Long r55, String r56, String r57, String r58, String r59, Long r60, TagData r61, Boolean r62, Map<Integer, MessageBehavior> r63, String r64, DocType r65, String r66, String r67, com.ss.android.lark.pb.entities.Message.ThreadMessageType r68, Integer r69, Long r70, String r71, String r72, String r73, Integer r74) {
        this(r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, ByteString.EMPTY);
    }

    public WikiMeta(String r4, DocType r5, Long r6, Boolean r7, String r8, Integer r9, String r10, Integer r11, Integer r12, String r13, Long r14, Long r15, String r16, String r17, String r18, String r19, Long r20, String r21, String r22, String r23, String r24, Long r25, TagData r26, Boolean r27, Map<Integer, MessageBehavior> r28, String r29, DocType r30, String r31, String r32, com.ss.android.lark.pb.entities.Message.ThreadMessageType r33, Integer r34, Long r35, String r36, String r37, String r38, Integer r39, ByteString r40) {
        super(ADAPTER, r40);
        this.mid = r4;
        this.mtype = r5;
        this.mupdate_time = r6;
        this.mis_cross_tenant = r7;
        this.mchat_id = r8;
        this.mposition = r9;
        this.mthread_id = r10;
        this.mthread_position = r11;
        this.mthread_chat_position = r12;
        this.mmessage_id = r13;
        this.mcreate_time = r14;
        this.mlast_open_time = r15;
        this.medit_user_id = r16;
        this.medit_user_name = r17;
        this.murl = r18;
        this.mdoc_url = r19;
        this.mspace_id = r20;
        this.mspace_name = r21;
        this.mtoken = r22;
        this.mowner_id = r23;
        this.mowner_name = r24;
        this.mfile_size = r25;
        this.mrelation_tag = r26;
        this.mis_restricted = r27;
        this.mdisabled_action = Internal.immutableCopyOf("mdisabled_action", r28);
        this.mori_id = r29;
        this.mori_type = r30;
        this.mori_token = r31;
        this.micon_info = r32;
        this.mthread_message_type = r33;
        this.mroot_message_position = r34;
        this.medit_time = r35;
        this.mmessage_sender_name = r36;
        this.mwiki_token = r37;
        this.mfile_type = r38;
        this.mbitable_biz_type = r39;
    }
}
