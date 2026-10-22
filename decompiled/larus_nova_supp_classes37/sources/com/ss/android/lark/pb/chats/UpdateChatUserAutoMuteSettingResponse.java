package com.ss.android.lark.pb.chats;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.entities.ChatUserAutoMuteSetting;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UpdateChatUserAutoMuteSettingResponse extends Message<UpdateChatUserAutoMuteSettingResponse, Builder> {
    public static final ProtoAdapter<UpdateChatUserAutoMuteSettingResponse> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final ChatUserAutoMuteSetting muser_auto_mute;

    public static final class Builder extends Message.Builder<UpdateChatUserAutoMuteSettingResponse, Builder> {
        public Long mchat_id;
        public ChatUserAutoMuteSetting muser_auto_mute;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UpdateChatUserAutoMuteSettingResponse m917build() {
            return new UpdateChatUserAutoMuteSettingResponse(this.mchat_id, this.muser_auto_mute, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m917build();
        }

        public Builder chat_id(Long r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder user_auto_mute(ChatUserAutoMuteSetting r1) {
            this.muser_auto_mute = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateChatUserAutoMuteSettingResponse extends ProtoAdapter<UpdateChatUserAutoMuteSettingResponse> {
        public ProtoAdapter_UpdateChatUserAutoMuteSettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateChatUserAutoMuteSettingResponse.class);
        }

        public UpdateChatUserAutoMuteSettingResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.mchat_id = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.muser_auto_mute = (ChatUserAutoMuteSetting) ChatUserAutoMuteSetting.ADAPTER.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.m917build();
        }

        public int encodedSize(UpdateChatUserAutoMuteSettingResponse r5) {
            Long r0 = r5.mchat_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            ChatUserAutoMuteSetting r3 = r5.muser_auto_mute;
            if (r3 == null) goto L10;
            r1 = ChatUserAutoMuteSetting.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m918decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UpdateChatUserAutoMuteSettingResponse) r1);
        }

        public void encode(ProtoWriter r4, UpdateChatUserAutoMuteSettingResponse r5) throws IOException {
            Long r0 = r5.mchat_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            ChatUserAutoMuteSetting r1 = r5.muser_auto_mute;
            if (r1 == null) goto L8;
            ChatUserAutoMuteSetting.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UpdateChatUserAutoMuteSettingResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateChatUserAutoMuteSettingResponse();
        DEFAULT_CHAT_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m916newBuilder() {
        Builder r0 = new Builder();
        r0.mchat_id = this.mchat_id;
        r0.muser_auto_mute = this.muser_auto_mute;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UpdateChatUserAutoMuteSettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m916newBuilder();
    }

    public UpdateChatUserAutoMuteSettingResponse(Long r2, ChatUserAutoMuteSetting r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public UpdateChatUserAutoMuteSettingResponse(Long r2, ChatUserAutoMuteSetting r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mchat_id = r2;
        this.muser_auto_mute = r3;
    }
}
