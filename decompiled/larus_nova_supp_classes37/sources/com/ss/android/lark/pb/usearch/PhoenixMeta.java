package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.DocType;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PhoenixMeta extends Message<PhoenixMeta, Builder> {
    public static final ProtoAdapter<PhoenixMeta> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_EDIT_USER_ID = "";
    public static final String DEFAULT_EDIT_USER_NAME = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
    public static final Long DEFAULT_LAST_OPEN_TIME = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final String DEFAULT_OWNER_ID = "";
    public static final String DEFAULT_OWNER_NAME = "";
    public static final Integer DEFAULT_POSITION = null;
    public static final Long DEFAULT_SPACE_ID = null;
    public static final String DEFAULT_SPACE_NAME = "";
    public static final Integer DEFAULT_THREAD_CHAT_POSITION = null;
    public static final String DEFAULT_THREAD_ID = "";
    public static final Integer DEFAULT_THREAD_POSITION = null;
    public static final String DEFAULT_TOKEN = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final Long mcreate_time;
    public final String medit_user_id;
    public final String medit_user_name;
    public final String mid;
    public final Boolean mis_cross_tenant;
    public final Long mlast_open_time;
    public final String mmessage_id;
    public final String mowner_id;
    public final String mowner_name;
    public final Integer mposition;
    public final Long mspace_id;
    public final String mspace_name;
    public final Integer mthread_chat_position;
    public final String mthread_id;
    public final Integer mthread_position;
    public final String mtoken;
    public final DocType mtype;
    public final Long mupdate_time;
    public final String murl;

    public static final class Builder extends Message.Builder<PhoenixMeta, Builder> {
        public String mchat_id;
        public Long mcreate_time;
        public String medit_user_id;
        public String medit_user_name;
        public String mid;
        public Boolean mis_cross_tenant;
        public Long mlast_open_time;
        public String mmessage_id;
        public String mowner_id;
        public String mowner_name;
        public Integer mposition;
        public Long mspace_id;
        public String mspace_name;
        public Integer mthread_chat_position;
        public String mthread_id;
        public Integer mthread_position;
        public String mtoken;
        public DocType mtype;
        public Long mupdate_time;
        public String murl;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PhoenixMeta m2750build() {
            String r1 = this.mid;
            if (r1 == null) goto L7;
            return new PhoenixMeta(this.mid, this.mtype, this.mupdate_time, this.mis_cross_tenant, this.mchat_id, this.mposition, this.mthread_id, this.mthread_position, this.mthread_chat_position, this.mmessage_id, this.mcreate_time, this.mlast_open_time, this.medit_user_id, this.medit_user_name, this.murl, this.mspace_id, this.mspace_name, this.mtoken, this.mowner_id, this.mowner_name, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r1, "mid"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2750build();
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder create_time(Long r1) {
            this.mcreate_time = r1;
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

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder is_cross_tenant(Boolean r1) {
            this.mis_cross_tenant = r1;
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

    public static final class ProtoAdapter_PhoenixMeta extends ProtoAdapter<PhoenixMeta> {
        public ProtoAdapter_PhoenixMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, PhoenixMeta.class);
        }

        public PhoenixMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mupdate_time = 0L;
            r0.mis_cross_tenant = Boolean.FALSE;
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
            r0.mspace_id = 0L;
            r0.mspace_name = "";
            r0.mtoken = "";
            r0.mowner_id = "";
            r0.mowner_name = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L30;
            switch(r3) {
                case 1: goto L29;
                case 2: goto L32;
                case 3: goto L24;
                case 4: goto L23;
                case 5: goto L22;
                case 6: goto L21;
                case 7: goto L20;
                case 8: goto L19;
                case 9: goto L18;
                case 10: goto L17;
                case 11: goto L16;
                case 12: goto L15;
                case 13: goto L14;
                case 14: goto L13;
                case 15: goto L12;
                case 16: goto L6;
                case 17: goto L11;
                case 18: goto L10;
                case 19: goto L9;
                case 20: goto L8;
                case 21: goto L7;
                default: goto L6;
            };
        L32:
            r0.mtype = (DocType) DocType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mowner_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            r0.mowner_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            r0.mtoken = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            r0.mspace_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            r0.mspace_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L12:
            r0.murl = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.medit_user_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L14:
            r0.medit_user_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mlast_open_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L16:
            r0.mcreate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L17:
            r0.mmessage_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L18:
            r0.mthread_chat_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L19:
            r0.mthread_position = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L20:
            r0.mthread_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L21:
            r0.mposition = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L22:
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L23:
            r0.mis_cross_tenant = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L24:
            r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L29:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L30:
            r9.endMessage(r1);
            return r0.m2750build();
        }

        public int encodedSize(PhoenixMeta r7) {
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
            Long r46 = r7.mspace_id;
            if (r46 == null) goto L61;
            int r47 = ProtoAdapter.INT64.encodedSizeWithTag(17, r46);
        L62:
            int r48 = r45 + r47;
            String r49 = r7.mspace_name;
            if (r49 == null) goto L65;
            int r50 = r0.encodedSizeWithTag(18, r49);
        L66:
            int r51 = r48 + r50;
            String r52 = r7.mtoken;
            if (r52 == null) goto L69;
            int r53 = r0.encodedSizeWithTag(19, r52);
        L70:
            int r54 = r51 + r53;
            String r55 = r7.mowner_id;
            if (r55 == null) goto L73;
            int r56 = r0.encodedSizeWithTag(20, r55);
        L74:
            int r57 = r54 + r56;
            String r58 = r7.mowner_name;
            if (r58 == null) goto L78;
            r3 = r0.encodedSizeWithTag(21, r58);
        L78:
            return (r57 + r3) + r7.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2751decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PhoenixMeta) r1);
        }

        public void encode(ProtoWriter r5, PhoenixMeta r6) throws IOException {
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
            Long r17 = r6.mspace_id;
            if (r17 == null) goto L47;
            ProtoAdapter.INT64.encodeWithTag(r5, 17, r17);
        L47:
            String r18 = r6.mspace_name;
            if (r18 == null) goto L50;
            r0.encodeWithTag(r5, 18, r18);
        L50:
            String r19 = r6.mtoken;
            if (r19 == null) goto L53;
            r0.encodeWithTag(r5, 19, r19);
        L53:
            String r20 = r6.mowner_id;
            if (r20 == null) goto L56;
            r0.encodeWithTag(r5, 20, r20);
        L56:
            String r21 = r6.mowner_name;
            if (r21 == null) goto L59;
            r0.encodeWithTag(r5, 21, r21);
        L59:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PhoenixMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PhoenixMeta();
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_IS_CROSS_TENANT = Boolean.FALSE;
        DEFAULT_POSITION = 0;
        DEFAULT_THREAD_POSITION = 0;
        DEFAULT_THREAD_CHAT_POSITION = 0;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_LAST_OPEN_TIME = 0L;
        DEFAULT_SPACE_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2749newBuilder() {
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
        r0.mspace_id = this.mspace_id;
        r0.mspace_name = this.mspace_name;
        r0.mtoken = this.mtoken;
        r0.mowner_id = this.mowner_id;
        r0.mowner_name = this.mowner_name;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PhoenixMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2749newBuilder();
    }

    public PhoenixMeta(String r23, DocType r24, Long r25, Boolean r26, String r27, Integer r28, String r29, Integer r30, Integer r31, String r32, Long r33, Long r34, String r35, String r36, String r37, Long r38, String r39, String r40, String r41, String r42) {
        this(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, ByteString.EMPTY);
    }

    public PhoenixMeta(String r4, DocType r5, Long r6, Boolean r7, String r8, Integer r9, String r10, Integer r11, Integer r12, String r13, Long r14, Long r15, String r16, String r17, String r18, Long r19, String r20, String r21, String r22, String r23, ByteString r24) {
        super(ADAPTER, r24);
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
        this.mspace_id = r19;
        this.mspace_name = r20;
        this.mtoken = r21;
        this.mowner_id = r22;
        this.mowner_name = r23;
    }
}
