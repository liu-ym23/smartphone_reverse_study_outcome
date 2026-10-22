package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class BotConfig extends com.squareup.wire.Message<BotConfig, Builder> {
    public static final ProtoAdapter<BotConfig> ADAPTER = null;
    public static final Integer DEFAULT_BOT_EXT_TYPE = null;
    public static final Boolean DEFAULT_CAN_JOIN_GROUP = null;
    public static final Boolean DEFAULT_IN_CONTACTS = null;
    public static final Boolean DEFAULT_IS_AGENT = null;
    public static final String DEFAULT_WITH_BOT_TAG = "bot";
    private static final long serialVersionUID = 0;
    public final Integer mbot_ext_type;
    public final Boolean mcan_join_group;
    public final Boolean min_contacts;
    public final Boolean mis_agent;
    public final String mwith_bot_tag;

    public static final class Builder extends com.squareup.wire.Message.Builder<BotConfig, Builder> {
        public Integer mbot_ext_type;
        public Boolean mcan_join_group;
        public Boolean min_contacts;
        public Boolean mis_agent;
        public String mwith_bot_tag;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BotConfig m1028build() {
            return new BotConfig(this.mwith_bot_tag, this.min_contacts, this.mcan_join_group, this.mbot_ext_type, this.mis_agent, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1028build();
        }

        public Builder bot_ext_type(Integer r1) {
            this.mbot_ext_type = r1;
            return this;
        }

        public Builder can_join_group(Boolean r1) {
            this.mcan_join_group = r1;
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

        public Builder with_bot_tag(String r1) {
            this.mwith_bot_tag = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_BotConfig extends ProtoAdapter<BotConfig> {
        public ProtoAdapter_BotConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, BotConfig.class);
        }

        public BotConfig decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mwith_bot_tag = "bot";
            Boolean r1 = Boolean.TRUE;
            r0.min_contacts = r1;
            r0.mcan_join_group = r1;
            r0.mbot_ext_type = 0;
            r0.mis_agent = Boolean.FALSE;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mwith_bot_tag = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.min_contacts = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mcan_join_group = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mbot_ext_type = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mis_agent = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L15:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r2);
            return r0.m1028build();
        }

        public int encodedSize(BotConfig r6) {
            String r0 = r6.mwith_bot_tag;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r6.min_contacts;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mcan_join_group;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Integer r10 = r6.mbot_ext_type;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.INT32.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Boolean r13 = r6.mis_agent;
            if (r13 == null) goto L22;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
        L22:
            return (r12 + r1) + r6.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m1029decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BotConfig) r1);
        }

        public void encode(ProtoWriter r4, BotConfig r5) throws IOException {
            String r0 = r5.mwith_bot_tag;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.min_contacts;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mcan_join_group;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            Integer r3 = r5.mbot_ext_type;
            if (r3 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r3);
        L14:
            Boolean r6 = r5.mis_agent;
            if (r6 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BotConfig) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BotConfig();
        Boolean r0 = Boolean.TRUE;
        DEFAULT_IN_CONTACTS = r0;
        DEFAULT_CAN_JOIN_GROUP = r0;
        DEFAULT_BOT_EXT_TYPE = 0;
        DEFAULT_IS_AGENT = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1027newBuilder() {
        Builder r0 = new Builder();
        r0.mwith_bot_tag = this.mwith_bot_tag;
        r0.min_contacts = this.min_contacts;
        r0.mcan_join_group = this.mcan_join_group;
        r0.mbot_ext_type = this.mbot_ext_type;
        r0.mis_agent = this.mis_agent;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BotConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1027newBuilder();
    }

    public BotConfig(String r8, Boolean r9, Boolean r10, Integer r11, Boolean r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public BotConfig(String r2, Boolean r3, Boolean r4, Integer r5, Boolean r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mwith_bot_tag = r2;
        this.min_contacts = r3;
        this.mcan_join_group = r4;
        this.mbot_ext_type = r5;
        this.mis_agent = r6;
    }
}
