package com.ss.android.lark.pb.chats;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Chat;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullChangeGroupMemberAuthorizationRequest extends Message<PullChangeGroupMemberAuthorizationRequest, Builder> {
    public static final ProtoAdapter<PullChangeGroupMemberAuthorizationRequest> ADAPTER = null;
    public static final Long DEFAULT_FROM_CHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final Chat.ChatMode mchat_mode;
    public final Long mfrom_chat_id;
    public final List<PickEntities> mpick_entities;

    public static final class Builder extends Message.Builder<PullChangeGroupMemberAuthorizationRequest, Builder> {
        public Chat.ChatMode mchat_mode;
        public Long mfrom_chat_id;
        public List<PickEntities> mpick_entities;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullChangeGroupMemberAuthorizationRequest m887build() {
            return new PullChangeGroupMemberAuthorizationRequest(this.mpick_entities, this.mchat_mode, this.mfrom_chat_id, super.buildUnknownFields());
        }

        public Builder() {
            this.mpick_entities = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m887build();
        }

        public Builder chat_mode(Chat.ChatMode r1) {
            this.mchat_mode = r1;
            return this;
        }

        public Builder from_chat_id(Long r1) {
            this.mfrom_chat_id = r1;
            return this;
        }

        public Builder pick_entities(List<PickEntities> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpick_entities = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullChangeGroupMemberAuthorizationRequest extends ProtoAdapter<PullChangeGroupMemberAuthorizationRequest> {
        public ProtoAdapter_PullChangeGroupMemberAuthorizationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullChangeGroupMemberAuthorizationRequest.class);
        }

        public PullChangeGroupMemberAuthorizationRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mfrom_chat_id = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mpick_entities.add((PickEntities) PickEntities.ADAPTER.decode(r9));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mchat_mode = (Chat.ChatMode) Chat.ChatMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mfrom_chat_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m887build();
        }

        public int encodedSize(PullChangeGroupMemberAuthorizationRequest r6) {
            int r0 = PickEntities.ADAPTER.asRepeated().encodedSizeWithTag(1, r6.mpick_entities);
            Chat.ChatMode r1 = r6.mchat_mode;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = Chat.ChatMode.ADAPTER.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            Long r5 = r6.mfrom_chat_id;
            if (r5 == null) goto L10;
            r2 = ProtoAdapter.INT64.encodedSizeWithTag(3, r5);
        L10:
            return (r4 + r2) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m888decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullChangeGroupMemberAuthorizationRequest) r1);
        }

        public void encode(ProtoWriter r4, PullChangeGroupMemberAuthorizationRequest r5) throws IOException {
            PickEntities.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mpick_entities);
            Chat.ChatMode r0 = r5.mchat_mode;
            if (r0 == null) goto L5;
            Chat.ChatMode.ADAPTER.encodeWithTag(r4, 2, r0);
        L5:
            Long r1 = r5.mfrom_chat_id;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullChangeGroupMemberAuthorizationRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullChangeGroupMemberAuthorizationRequest();
        DEFAULT_FROM_CHAT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m886newBuilder() {
        Builder r0 = new Builder();
        r0.mpick_entities = Internal.copyOf("mpick_entities", this.mpick_entities);
        r0.mchat_mode = this.mchat_mode;
        r0.mfrom_chat_id = this.mfrom_chat_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullChangeGroupMemberAuthorizationRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m886newBuilder();
    }

    public PullChangeGroupMemberAuthorizationRequest(List<PickEntities> r2, Chat.ChatMode r3, Long r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public PullChangeGroupMemberAuthorizationRequest(List<PickEntities> r2, Chat.ChatMode r3, Long r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mpick_entities = Internal.immutableCopyOf("mpick_entities", r2);
        this.mchat_mode = r3;
        this.mfrom_chat_id = r4;
    }
}
