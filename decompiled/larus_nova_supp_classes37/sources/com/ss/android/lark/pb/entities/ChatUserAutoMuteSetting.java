package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ChatUserAutoMuteSetting extends com.squareup.wire.Message<ChatUserAutoMuteSetting, Builder> {
    public static final ProtoAdapter<ChatUserAutoMuteSetting> ADAPTER = null;
    public static final Boolean DEFAULT_SHOW_TOP_BANNER = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, AutoMuteConfig> mbot_auto_mutes;
    public final AutoMuteConfig mlarge_chat_auto_mute;
    public final NoticeType mnotice_type;
    public final Boolean mshow_top_banner;
    public final Long mupdate_time;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatUserAutoMuteSetting, Builder> {
        public Map<Long, AutoMuteConfig> mbot_auto_mutes;
        public AutoMuteConfig mlarge_chat_auto_mute;
        public NoticeType mnotice_type;
        public Boolean mshow_top_banner;
        public Long mupdate_time;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatUserAutoMuteSetting m1169build() {
            return new ChatUserAutoMuteSetting(this.mlarge_chat_auto_mute, this.mbot_auto_mutes, this.mnotice_type, this.mupdate_time, this.mshow_top_banner, super.buildUnknownFields());
        }

        public Builder() {
            this.mbot_auto_mutes = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1169build();
        }

        public Builder bot_auto_mutes(Map<Long, AutoMuteConfig> r1) {
            Internal.checkElementsNotNull(r1);
            this.mbot_auto_mutes = r1;
            return this;
        }

        public Builder large_chat_auto_mute(AutoMuteConfig r1) {
            this.mlarge_chat_auto_mute = r1;
            return this;
        }

        public Builder notice_type(NoticeType r1) {
            this.mnotice_type = r1;
            return this;
        }

        public Builder show_top_banner(Boolean r1) {
            this.mshow_top_banner = r1;
            return this;
        }

        public Builder update_time(Long r1) {
            this.mupdate_time = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatUserAutoMuteSetting extends ProtoAdapter<ChatUserAutoMuteSetting> {
        private final ProtoAdapter<Map<Long, AutoMuteConfig>> mbot_auto_mutes;

        public ProtoAdapter_ChatUserAutoMuteSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatUserAutoMuteSetting.class);
            this.mbot_auto_mutes = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, AutoMuteConfig.ADAPTER);
        }

        public ChatUserAutoMuteSetting decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mupdate_time = 0L;
            r0.mshow_top_banner = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.mlarge_chat_auto_mute = (AutoMuteConfig) AutoMuteConfig.ADAPTER.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mbot_auto_mutes.putAll((Map) this.mbot_auto_mutes.decode(r9));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mnotice_type = (NoticeType) NoticeType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.mupdate_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.mshow_top_banner = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.m1169build();
        }

        public int encodedSize(ChatUserAutoMuteSetting r6) {
            AutoMuteConfig r0 = r6.mlarge_chat_auto_mute;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = AutoMuteConfig.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            int r3 = r2 + this.mbot_auto_mutes.encodedSizeWithTag(2, r6.mbot_auto_mutes);
            NoticeType r4 = r6.mnotice_type;
            if (r4 == null) goto L9;
            int r5 = NoticeType.ADAPTER.encodedSizeWithTag(3, r4);
        L10:
            int r7 = r3 + r5;
            Long r8 = r6.mupdate_time;
            if (r8 == null) goto L13;
            int r9 = ProtoAdapter.INT64.encodedSizeWithTag(4, r8);
        L14:
            int r10 = r7 + r9;
            Boolean r11 = r6.mshow_top_banner;
            if (r11 == null) goto L18;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r11);
        L18:
            return (r10 + r1) + r6.unknownFields().size();
        L13:
            r9 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1170decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatUserAutoMuteSetting) r1);
        }

        public void encode(ProtoWriter r4, ChatUserAutoMuteSetting r5) throws IOException {
            AutoMuteConfig r0 = r5.mlarge_chat_auto_mute;
            if (r0 == null) goto L5;
            AutoMuteConfig.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            this.mbot_auto_mutes.encodeWithTag(r4, 2, r5.mbot_auto_mutes);
            NoticeType r1 = r5.mnotice_type;
            if (r1 == null) goto L8;
            NoticeType.ADAPTER.encodeWithTag(r4, 3, r1);
        L8:
            Long r2 = r5.mupdate_time;
            if (r2 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r4, 4, r2);
        L11:
            Boolean r3 = r5.mshow_top_banner;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r3);
        L14:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatUserAutoMuteSetting) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatUserAutoMuteSetting();
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_SHOW_TOP_BANNER = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1168newBuilder() {
        Builder r0 = new Builder();
        r0.mlarge_chat_auto_mute = this.mlarge_chat_auto_mute;
        r0.mbot_auto_mutes = Internal.copyOf("mbot_auto_mutes", this.mbot_auto_mutes);
        r0.mnotice_type = this.mnotice_type;
        r0.mupdate_time = this.mupdate_time;
        r0.mshow_top_banner = this.mshow_top_banner;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatUserAutoMuteSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1168newBuilder();
    }

    public ChatUserAutoMuteSetting(AutoMuteConfig r8, Map<Long, AutoMuteConfig> r9, NoticeType r10, Long r11, Boolean r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public ChatUserAutoMuteSetting(AutoMuteConfig r2, Map<Long, AutoMuteConfig> r3, NoticeType r4, Long r5, Boolean r6, ByteString r7) {
        super(ADAPTER, r7);
        this.mlarge_chat_auto_mute = r2;
        this.mbot_auto_mutes = Internal.immutableCopyOf("mbot_auto_mutes", r3);
        this.mnotice_type = r4;
        this.mupdate_time = r5;
        this.mshow_top_banner = r6;
    }
}
