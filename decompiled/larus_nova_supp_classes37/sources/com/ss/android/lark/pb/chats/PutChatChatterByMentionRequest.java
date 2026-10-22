package com.ss.android.lark.pb.chats;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PutChatChatterByMentionRequest extends Message<PutChatChatterByMentionRequest, Builder> {
    public static final ProtoAdapter<PutChatChatterByMentionRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final Long DEFAULT_TRIGGER_MESSAGE_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final List<Long> mchatter_ids;
    public final Long mtrigger_message_id;

    public static final class Builder extends Message.Builder<PutChatChatterByMentionRequest, Builder> {
        public Long mchat_id;
        public List<Long> mchatter_ids;
        public Long mtrigger_message_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PutChatChatterByMentionRequest m905build() {
            Long r0 = this.mchat_id;
            if (r0 == null) goto L9;
            if (this.mtrigger_message_id == null) goto L9;
            return new PutChatChatterByMentionRequest(this.mchat_id, this.mchatter_ids, this.mtrigger_message_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "mchat_id", this.mtrigger_message_id, "mtrigger_message_id"});
        }

        public Builder() {
            this.mchatter_ids = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m905build();
        }

        public Builder chat_id(Long r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder chatter_ids(List<Long> r1) {
            Internal.checkElementsNotNull(r1);
            this.mchatter_ids = r1;
            return this;
        }

        public Builder trigger_message_id(Long r1) {
            this.mtrigger_message_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PutChatChatterByMentionRequest extends ProtoAdapter<PutChatChatterByMentionRequest> {
        public ProtoAdapter_PutChatChatterByMentionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutChatChatterByMentionRequest.class);
        }

        public PutChatChatterByMentionRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = 0L;
            r0.mtrigger_message_id = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mchat_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mchatter_ids.add((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mtrigger_message_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m905build();
        }

        public int encodedSize(PutChatChatterByMentionRequest r6) {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            return ((r0.encodedSizeWithTag(1, r6.mchat_id) + r0.asRepeated().encodedSizeWithTag(2, r6.mchatter_ids)) + r0.encodedSizeWithTag(3, r6.mtrigger_message_id)) + r6.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m906decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PutChatChatterByMentionRequest) r1);
        }

        public void encode(ProtoWriter r5, PutChatChatterByMentionRequest r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r5, 1, r6.mchat_id);
            r0.asRepeated().encodeWithTag(r5, 2, r6.mchatter_ids);
            r0.encodeWithTag(r5, 3, r6.mtrigger_message_id);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PutChatChatterByMentionRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutChatChatterByMentionRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_TRIGGER_MESSAGE_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m904newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.mchatter_ids = Internal.copyOf("mchatter_ids", this.mchatter_ids);
        r0.mtrigger_message_id = this.mtrigger_message_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PutChatChatterByMentionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m904newBuilder();
    }

    public PutChatChatterByMentionRequest(Long r2, List<Long> r3, Long r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public PutChatChatterByMentionRequest(Long r2, List<Long> r3, Long r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mchat_id = r2;
        this.mchatter_ids = Internal.immutableCopyOf("mchatter_ids", r3);
        this.mtrigger_message_id = r4;
    }
}
