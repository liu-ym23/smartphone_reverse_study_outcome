package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BotMeta extends Message<BotMeta, Builder> {
    public static final ProtoAdapter<BotMeta> ADAPTER = null;
    public static final Integer DEFAULT_BOT_EXT_TYPE = null;
    public static final Boolean DEFAULT_CAN_JOIN_GROUP = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IN_CONTACTS = null;
    public static final Boolean DEFAULT_IS_AGENT = null;
    public static final String DEFAULT_TENANT_ID = "";
    public static final String DEFAULT_WITH_BOT_TAG = "bot";
    private static final long serialVersionUID = 0;
    public final Integer mbot_ext_type;
    public final Boolean mcan_join_group;
    public final String mchat_id;
    public final ExtraFields mextraFields;
    public final String mid;
    public final Boolean min_contacts;
    public final Boolean mis_agent;
    public final String mtenant_id;
    public final String mwith_bot_tag;

    public static final class Builder extends Message.Builder<BotMeta, Builder> {
        public Integer mbot_ext_type;
        public Boolean mcan_join_group;
        public String mchat_id;
        public ExtraFields mextraFields;
        public String mid;
        public Boolean min_contacts;
        public Boolean mis_agent;
        public String mtenant_id;
        public String mwith_bot_tag;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BotMeta m2561build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new BotMeta(this.mid, this.mtenant_id, this.mwith_bot_tag, this.min_contacts, this.mcan_join_group, this.mchat_id, this.mextraFields, this.mbot_ext_type, this.mis_agent, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2561build();
        }

        public Builder bot_ext_type(Integer r1) {
            this.mbot_ext_type = r1;
            return this;
        }

        public Builder can_join_group(Boolean r1) {
            this.mcan_join_group = r1;
            return this;
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder extraFields(ExtraFields r1) {
            this.mextraFields = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder in_contacts(Boolean r1) {
            this.min_contacts = r1;
            return this;
        }

        public Builder is_agent(Boolean r1) {
            this.mis_agent = r1;
            return this;
        }

        public Builder tenant_id(String r1) {
            this.mtenant_id = r1;
            return this;
        }

        public Builder with_bot_tag(String r1) {
            this.mwith_bot_tag = r1;
            return this;
        }
    }

    public static final class ExtraFields extends Message<ExtraFields, Builder> {
        public static final ProtoAdapter<ExtraFields> ADAPTER = null;
        public static final Boolean DEFAULT_IS_IN_CHAT = null;
        private static final long serialVersionUID = 0;
        public final Boolean mis_in_chat;

        public static final class Builder extends Message.Builder<ExtraFields, Builder> {
            public Boolean mis_in_chat;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ExtraFields m2563build() {
                return new ExtraFields(this.mis_in_chat, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2563build();
            }

            public Builder is_in_chat(Boolean r1) {
                this.mis_in_chat = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ExtraFields extends ProtoAdapter<ExtraFields> {
            public ProtoAdapter_ExtraFields() {
                super(FieldEncoding.LENGTH_DELIMITED, ExtraFields.class);
            }

            public ExtraFields decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mis_in_chat = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mis_in_chat = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2563build();
            }

            public int encodedSize(ExtraFields r4) {
                Boolean r0 = r4.mis_in_chat;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2564decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ExtraFields) r1);
            }

            public void encode(ProtoWriter r4, ExtraFields r5) throws IOException {
                Boolean r0 = r5.mis_in_chat;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ExtraFields) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ExtraFields();
            DEFAULT_IS_IN_CHAT = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2562newBuilder() {
            Builder r0 = new Builder();
            r0.mis_in_chat = this.mis_in_chat;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ExtraFields.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2562newBuilder();
        }

        public ExtraFields(Boolean r2) {
            this(r2, ByteString.EMPTY);
        }

        public ExtraFields(Boolean r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mis_in_chat = r2;
        }
    }

    public static final class ProtoAdapter_BotMeta extends ProtoAdapter<BotMeta> {
        public ProtoAdapter_BotMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, BotMeta.class);
        }

        public BotMeta decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mtenant_id = "";
            r0.mwith_bot_tag = "bot";
            Boolean r2 = Boolean.TRUE;
            r0.min_contacts = r2;
            r0.mcan_join_group = r2;
            r0.mchat_id = "";
            r0.mbot_ext_type = 0;
            r0.mis_agent = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L6;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r0.mis_agent = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            r0.mbot_ext_type = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L9:
            r0.mextraFields = (ExtraFields) ExtraFields.ADAPTER.decode(r7);
            goto L3
        L10:
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            r0.mcan_join_group = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            r0.min_contacts = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L13:
            r0.mwith_bot_tag = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L14:
            r0.mtenant_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L15:
            r0.mid = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L16:
            r7.endMessage(r1);
            return r0.m2561build();
        }

        public int encodedSize(BotMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid);
            String r2 = r7.mtenant_id;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(2, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.mwith_bot_tag;
            if (r6 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(3, r6);
        L10:
            int r9 = r5 + r8;
            Boolean r10 = r7.min_contacts;
            if (r10 == null) goto L13;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L14:
            int r12 = r9 + r11;
            Boolean r13 = r7.mcan_join_group;
            if (r13 == null) goto L17;
            int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
        L18:
            int r15 = r12 + r14;
            String r16 = r7.mchat_id;
            if (r16 == null) goto L21;
            int r17 = r0.encodedSizeWithTag(6, r16);
        L22:
            int r18 = r15 + r17;
            ExtraFields r19 = r7.mextraFields;
            if (r19 == null) goto L25;
            int r20 = ExtraFields.ADAPTER.encodedSizeWithTag(8, r19);
        L26:
            int r21 = r18 + r20;
            Integer r22 = r7.mbot_ext_type;
            if (r22 == null) goto L29;
            int r23 = ProtoAdapter.INT32.encodedSizeWithTag(9, r22);
        L30:
            int r24 = r21 + r23;
            Boolean r25 = r7.mis_agent;
            if (r25 == null) goto L34;
            r3 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r25);
        L34:
            return (r24 + r3) + r7.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2565decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BotMeta) r1);
        }

        public void encode(ProtoWriter r5, BotMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            String r1 = r6.mtenant_id;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 2, r1);
        L5:
            String r2 = r6.mwith_bot_tag;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 3, r2);
        L8:
            Boolean r3 = r6.min_contacts;
            if (r3 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r5, 4, r3);
        L11:
            Boolean r4 = r6.mcan_join_group;
            if (r4 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r5, 5, r4);
        L14:
            String r7 = r6.mchat_id;
            if (r7 == null) goto L17;
            r0.encodeWithTag(r5, 6, r7);
        L17:
            ExtraFields r8 = r6.mextraFields;
            if (r8 == null) goto L20;
            ExtraFields.ADAPTER.encodeWithTag(r5, 8, r8);
        L20:
            Integer r9 = r6.mbot_ext_type;
            if (r9 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r5, 9, r9);
        L23:
            Boolean r10 = r6.mis_agent;
            if (r10 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r5, 10, r10);
        L26:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BotMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BotMeta();
        Boolean r0 = Boolean.TRUE;
        DEFAULT_IN_CONTACTS = r0;
        DEFAULT_CAN_JOIN_GROUP = r0;
        DEFAULT_BOT_EXT_TYPE = 0;
        DEFAULT_IS_AGENT = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2560newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.mtenant_id = this.mtenant_id;
        r0.mwith_bot_tag = this.mwith_bot_tag;
        r0.min_contacts = this.min_contacts;
        r0.mcan_join_group = this.mcan_join_group;
        r0.mchat_id = this.mchat_id;
        r0.mextraFields = this.mextraFields;
        r0.mbot_ext_type = this.mbot_ext_type;
        r0.mis_agent = this.mis_agent;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BotMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2560newBuilder();
    }

    public BotMeta(String r12, String r13, String r14, Boolean r15, Boolean r16, String r17, ExtraFields r18, Integer r19, Boolean r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public BotMeta(String r2, String r3, String r4, Boolean r5, Boolean r6, String r7, ExtraFields r8, Integer r9, Boolean r10, ByteString r11) {
        super(ADAPTER, r11);
        this.mid = r2;
        this.mtenant_id = r3;
        this.mwith_bot_tag = r4;
        this.min_contacts = r5;
        this.mcan_join_group = r6;
        this.mchat_id = r7;
        this.mextraFields = r8;
        this.mbot_ext_type = r9;
        this.mis_agent = r10;
    }
}
