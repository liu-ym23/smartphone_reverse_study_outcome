package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.misc.ChattersAuthResult;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ExtendFields extends Message<ExtendFields, Builder> {
    public static final ProtoAdapter<ExtendFields> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ChattersAuthResult mauth_result;
    public final List<String> mchatters_deny_invite_same_chat;
    public final List<String> mchatters_in_chat_id;
    public final Map<String, DenyReason> mdeny_chatters;
    public final Map<String, Boolean> mdep_has_lead_perm;
    public final Map<String, ProfileFields> musers_profile_fields;

    public static final class Builder extends Message.Builder<ExtendFields, Builder> {
        public ChattersAuthResult mauth_result;
        public List<String> mchatters_deny_invite_same_chat;
        public List<String> mchatters_in_chat_id;
        public Map<String, DenyReason> mdeny_chatters;
        public Map<String, Boolean> mdep_has_lead_perm;
        public Map<String, ProfileFields> musers_profile_fields;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ExtendFields m968build() {
            return new ExtendFields(this.mchatters_in_chat_id, this.mchatters_deny_invite_same_chat, this.mdeny_chatters, this.mauth_result, this.mdep_has_lead_perm, this.musers_profile_fields, super.buildUnknownFields());
        }

        public Builder() {
            this.mchatters_in_chat_id = Internal.newMutableList();
            this.mchatters_deny_invite_same_chat = Internal.newMutableList();
            this.mdeny_chatters = Internal.newMutableMap();
            this.mdep_has_lead_perm = Internal.newMutableMap();
            this.musers_profile_fields = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m968build();
        }

        public Builder auth_result(ChattersAuthResult r1) {
            this.mauth_result = r1;
            return this;
        }

        public Builder chatters_deny_invite_same_chat(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchatters_deny_invite_same_chat = r1;
            return this;
        }

        public Builder chatters_in_chat_id(List<String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchatters_in_chat_id = r1;
            return this;
        }

        public Builder deny_chatters(Map<String, DenyReason> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdeny_chatters = r1;
            return this;
        }

        public Builder dep_has_lead_perm(Map<String, Boolean> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdep_has_lead_perm = r1;
            return this;
        }

        public Builder users_profile_fields(Map<String, ProfileFields> r1) {
            Internal.checkElementsNotNull(r1);
            this.musers_profile_fields = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ExtendFields extends ProtoAdapter<ExtendFields> {
        private final ProtoAdapter<Map<String, DenyReason>> mdeny_chatters;
        private final ProtoAdapter<Map<String, Boolean>> mdep_has_lead_perm;
        private final ProtoAdapter<Map<String, ProfileFields>> musers_profile_fields;

        public ProtoAdapter_ExtendFields() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtendFields.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mdeny_chatters = ProtoAdapter.newMapAdapter(r0, DenyReason.ADAPTER);
            this.mdep_has_lead_perm = ProtoAdapter.newMapAdapter(r0, ProtoAdapter.BOOL);
            this.musers_profile_fields = ProtoAdapter.newMapAdapter(r0, ProfileFields.ADAPTER);
        }

        public ExtendFields decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.musers_profile_fields.putAll((Map) this.musers_profile_fields.decode(r7));
            goto L3
        L8:
            r0.mdep_has_lead_perm.putAll((Map) this.mdep_has_lead_perm.decode(r7));
            goto L3
        L9:
            r0.mauth_result = (ChattersAuthResult) ChattersAuthResult.ADAPTER.decode(r7);
            goto L3
        L10:
            r0.mdeny_chatters.putAll((Map) this.mdeny_chatters.decode(r7));
            goto L3
        L11:
            r0.mchatters_deny_invite_same_chat.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            r0.mchatters_in_chat_id.add((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.m968build();
        }

        public int encodedSize(ExtendFields r5) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = (r0.asRepeated().encodedSizeWithTag(1, r5.mchatters_in_chat_id) + r0.asRepeated().encodedSizeWithTag(2, r5.mchatters_deny_invite_same_chat)) + this.mdeny_chatters.encodedSizeWithTag(3, r5.mdeny_chatters);
            ChattersAuthResult r2 = r5.mauth_result;
            if (r2 == null) goto L5;
            int r3 = ChattersAuthResult.ADAPTER.encodedSizeWithTag(4, r2);
        L7:
            return (((r1 + r3) + this.mdep_has_lead_perm.encodedSizeWithTag(5, r5.mdep_has_lead_perm)) + this.musers_profile_fields.encodedSizeWithTag(6, r5.musers_profile_fields)) + r5.unknownFields().size();
        L5:
            r3 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m969decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ExtendFields) r1);
        }

        public void encode(ProtoWriter r5, ExtendFields r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.asRepeated().encodeWithTag(r5, 1, r6.mchatters_in_chat_id);
            r0.asRepeated().encodeWithTag(r5, 2, r6.mchatters_deny_invite_same_chat);
            this.mdeny_chatters.encodeWithTag(r5, 3, r6.mdeny_chatters);
            ChattersAuthResult r1 = r6.mauth_result;
            if (r1 == null) goto L5;
            ChattersAuthResult.ADAPTER.encodeWithTag(r5, 4, r1);
        L5:
            this.mdep_has_lead_perm.encodeWithTag(r5, 5, r6.mdep_has_lead_perm);
            this.musers_profile_fields.encodeWithTag(r5, 6, r6.musers_profile_fields);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ExtendFields) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ExtendFields();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m967newBuilder() {
        Builder r0 = new Builder();
        r0.mchatters_in_chat_id = Internal.copyOf("mchatters_in_chat_id", this.mchatters_in_chat_id);
        r0.mchatters_deny_invite_same_chat = Internal.copyOf("mchatters_deny_invite_same_chat", this.mchatters_deny_invite_same_chat);
        r0.mdeny_chatters = Internal.copyOf("mdeny_chatters", this.mdeny_chatters);
        r0.mauth_result = this.mauth_result;
        r0.mdep_has_lead_perm = Internal.copyOf("mdep_has_lead_perm", this.mdep_has_lead_perm);
        r0.musers_profile_fields = Internal.copyOf("musers_profile_fields", this.musers_profile_fields);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ExtendFields.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m967newBuilder();
    }

    public ExtendFields(List<String> r9, List<String> r10, Map<String, DenyReason> r11, ChattersAuthResult r12, Map<String, Boolean> r13, Map<String, ProfileFields> r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public ExtendFields(List<String> r2, List<String> r3, Map<String, DenyReason> r4, ChattersAuthResult r5, Map<String, Boolean> r6, Map<String, ProfileFields> r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mchatters_in_chat_id = Internal.immutableCopyOf("mchatters_in_chat_id", r2);
        this.mchatters_deny_invite_same_chat = Internal.immutableCopyOf("mchatters_deny_invite_same_chat", r3);
        this.mdeny_chatters = Internal.immutableCopyOf("mdeny_chatters", r4);
        this.mauth_result = r5;
        this.mdep_has_lead_perm = Internal.immutableCopyOf("mdep_has_lead_perm", r6);
        this.musers_profile_fields = Internal.immutableCopyOf("musers_profile_fields", r7);
    }
}
