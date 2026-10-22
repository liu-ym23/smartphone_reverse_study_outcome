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
public final class CheckWithdrawPickEntitiesInChatRequest extends Message<CheckWithdrawPickEntitiesInChatRequest, Builder> {
    public static final ProtoAdapter<CheckWithdrawPickEntitiesInChatRequest> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final List<PickEntities> mpick_entities;

    public static final class Builder extends Message.Builder<CheckWithdrawPickEntitiesInChatRequest, Builder> {
        public String mchat_id;
        public List<PickEntities> mpick_entities;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public CheckWithdrawPickEntitiesInChatRequest m878build() {
            String r0 = this.mchat_id;
            if (r0 == null) goto L7;
            return new CheckWithdrawPickEntitiesInChatRequest(this.mchat_id, this.mpick_entities, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mchat_id"});
        }

        public Builder() {
            this.mpick_entities = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m878build();
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder pick_entities(List<PickEntities> r1) {
            Internal.checkElementsNotNull(r1);
            this.mpick_entities = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckWithdrawPickEntitiesInChatRequest extends ProtoAdapter<CheckWithdrawPickEntitiesInChatRequest> {
        public ProtoAdapter_CheckWithdrawPickEntitiesInChatRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckWithdrawPickEntitiesInChatRequest.class);
        }

        public CheckWithdrawPickEntitiesInChatRequest decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mpick_entities.add((PickEntities) PickEntities.ADAPTER.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m878build();
        }

        public int encodedSize(CheckWithdrawPickEntitiesInChatRequest r5) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r5.mchat_id) + PickEntities.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mpick_entities)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m879decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((CheckWithdrawPickEntitiesInChatRequest) r1);
        }

        public void encode(ProtoWriter r4, CheckWithdrawPickEntitiesInChatRequest r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mchat_id);
            PickEntities.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mpick_entities);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (CheckWithdrawPickEntitiesInChatRequest) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CheckWithdrawPickEntitiesInChatRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m877newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.mpick_entities = Internal.copyOf("mpick_entities", this.mpick_entities);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return CheckWithdrawPickEntitiesInChatRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m877newBuilder();
    }

    public CheckWithdrawPickEntitiesInChatRequest(String r2, List<PickEntities> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public CheckWithdrawPickEntitiesInChatRequest(String r2, List<PickEntities> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mchat_id = r2;
        this.mpick_entities = Internal.immutableCopyOf("mpick_entities", r3);
    }
}
