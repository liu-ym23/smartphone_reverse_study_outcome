package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ExtendParam extends Message<ExtendParam, Builder> {
    public static final ProtoAdapter<ExtendParam> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_INVITE_SAME_CHAT_TAG = null;
    public static final Boolean DEFAULT_HAS_LEAD_PERM = null;
    public static final String DEFAULT_IN_CHAT_ID = "";
    public static final Boolean DEFAULT_IS_SECRET_CHAT = null;
    public static final Boolean DEFAULT_NEED_USERS_PROFILE_FIELDS = null;
    private static final long serialVersionUID = 0;
    public final ActionType maction_type;
    public final com.ss.android.lark.pb.misc.ActionType mbusiness_scene;
    public final Boolean mcan_invite_same_chat_tag;
    public final Boolean mhas_lead_perm;
    public final String min_chat_id;
    public final Boolean mis_secret_chat;
    public final Boolean mneed_users_profile_fields;

    public static final class Builder extends Message.Builder<ExtendParam, Builder> {
        public ActionType maction_type;
        public com.ss.android.lark.pb.misc.ActionType mbusiness_scene;
        public Boolean mcan_invite_same_chat_tag;
        public Boolean mhas_lead_perm;
        public String min_chat_id;
        public Boolean mis_secret_chat;
        public Boolean mneed_users_profile_fields;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ExtendParam m971build() {
            return new ExtendParam(this.min_chat_id, this.mcan_invite_same_chat_tag, this.mis_secret_chat, this.maction_type, this.mbusiness_scene, this.mhas_lead_perm, this.mneed_users_profile_fields, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m971build();
        }

        public Builder action_type(ActionType r1) {
            this.maction_type = r1;
            return this;
        }

        public Builder business_scene(com.ss.android.lark.pb.misc.ActionType r1) {
            this.mbusiness_scene = r1;
            return this;
        }

        public Builder can_invite_same_chat_tag(Boolean r1) {
            this.mcan_invite_same_chat_tag = r1;
            return this;
        }

        public Builder has_lead_perm(Boolean r1) {
            this.mhas_lead_perm = r1;
            return this;
        }

        public Builder in_chat_id(String r1) {
            this.min_chat_id = r1;
            return this;
        }

        public Builder is_secret_chat(Boolean r1) {
            this.mis_secret_chat = r1;
            return this;
        }

        public Builder need_users_profile_fields(Boolean r1) {
            this.mneed_users_profile_fields = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtendParam extends ProtoAdapter<ExtendParam> {
        public ProtoAdapter_ExtendParam() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtendParam.class);
        }

        public ExtendParam decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.min_chat_id = "";
            Boolean r1 = Boolean.FALSE;
            r0.mcan_invite_same_chat_tag = r1;
            r0.mis_secret_chat = r1;
            r0.mhas_lead_perm = r1;
            r0.mneed_users_profile_fields = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L20;
            switch(r3) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L24;
                case 5: goto L22;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L22:
            r0.mbusiness_scene = (com.ss.android.lark.pb.misc.ActionType) com.ss.android.lark.pb.misc.ActionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L24:
            r0.maction_type = (ActionType) ActionType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mneed_users_profile_fields = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L8:
            r0.mhas_lead_perm = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L17:
            r0.mis_secret_chat = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L18:
            r0.mcan_invite_same_chat_tag = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L19:
            r0.min_chat_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L20:
            r9.endMessage(r2);
            return r0.m971build();
        }

        public int encodedSize(ExtendParam r6) {
            String r0 = r6.min_chat_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r6.mcan_invite_same_chat_tag;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mis_secret_chat;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            ActionType r10 = r6.maction_type;
            if (r10 == null) goto L17;
            int r11 = ActionType.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            com.ss.android.lark.pb.misc.ActionType r13 = r6.mbusiness_scene;
            if (r13 == null) goto L21;
            int r14 = com.ss.android.lark.pb.misc.ActionType.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Boolean r16 = r6.mhas_lead_perm;
            if (r16 == null) goto L25;
            int r17 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            Boolean r19 = r6.mneed_users_profile_fields;
            if (r19 == null) goto L30;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r19);
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
        public /* bridge */ /* synthetic */ Object m972decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ExtendParam) r1);
        }

        public void encode(ProtoWriter r4, ExtendParam r5) throws IOException {
            String r0 = r5.min_chat_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.mcan_invite_same_chat_tag;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mis_secret_chat;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            ActionType r3 = r5.maction_type;
            if (r3 == null) goto L14;
            ActionType.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            com.ss.android.lark.pb.misc.ActionType r6 = r5.mbusiness_scene;
            if (r6 == null) goto L17;
            com.ss.android.lark.pb.misc.ActionType.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            Boolean r7 = r5.mhas_lead_perm;
            if (r7 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r7);
        L20:
            Boolean r8 = r5.mneed_users_profile_fields;
            if (r8 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r4, 7, r8);
        L23:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ExtendParam) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtendParam();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_CAN_INVITE_SAME_CHAT_TAG = r0;
        DEFAULT_IS_SECRET_CHAT = r0;
        DEFAULT_HAS_LEAD_PERM = r0;
        DEFAULT_NEED_USERS_PROFILE_FIELDS = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m970newBuilder() {
        Builder r0 = new Builder();
        r0.min_chat_id = this.min_chat_id;
        r0.mcan_invite_same_chat_tag = this.mcan_invite_same_chat_tag;
        r0.mis_secret_chat = this.mis_secret_chat;
        r0.maction_type = this.maction_type;
        r0.mbusiness_scene = this.mbusiness_scene;
        r0.mhas_lead_perm = this.mhas_lead_perm;
        r0.mneed_users_profile_fields = this.mneed_users_profile_fields;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ExtendParam.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m970newBuilder();
    }

    public ExtendParam(String r10, Boolean r11, Boolean r12, ActionType r13, com.ss.android.lark.pb.misc.ActionType r14, Boolean r15, Boolean r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public ExtendParam(String r2, Boolean r3, Boolean r4, ActionType r5, com.ss.android.lark.pb.misc.ActionType r6, Boolean r7, Boolean r8, ByteString r9) {
        super(ADAPTER, r9);
        this.min_chat_id = r2;
        this.mcan_invite_same_chat_tag = r3;
        this.mis_secret_chat = r4;
        this.maction_type = r5;
        this.mbusiness_scene = r6;
        this.mhas_lead_perm = r7;
        this.mneed_users_profile_fields = r8;
    }
}
