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
public final class ChatBizContent extends com.squareup.wire.Message<ChatBizContent, Builder> {
    public static final ProtoAdapter<ChatBizContent> ADAPTER = null;
    public static final Long DEFAULT_TEAM_ID = null;
    private static final long serialVersionUID = 0;
    public final TeamChatType mteam_chat_type;
    public final Long mteam_id;
    public final Map<Long, TeamInfo> mteam_infos;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatBizContent, Builder> {
        public TeamChatType mteam_chat_type;
        public Long mteam_id;
        public Map<Long, TeamInfo> mteam_infos;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ChatBizContent m1076build() {
            return new ChatBizContent(this.mteam_id, this.mteam_chat_type, this.mteam_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.mteam_infos = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1076build();
        }

        public Builder team_chat_type(TeamChatType r1) {
            this.mteam_chat_type = r1;
            return this;
        }

        public Builder team_id(Long r1) {
            this.mteam_id = r1;
            return this;
        }

        public Builder team_infos(Map<Long, TeamInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mteam_infos = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatBizContent extends ProtoAdapter<ChatBizContent> {
        private final ProtoAdapter<Map<Long, TeamInfo>> mteam_infos;

        public ProtoAdapter_ChatBizContent() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatBizContent.class);
            this.mteam_infos = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, TeamInfo.ADAPTER);
        }

        public ChatBizContent decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mteam_id = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mteam_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mteam_chat_type = (TeamChatType) TeamChatType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mteam_infos.putAll((Map) this.mteam_infos.decode(r9));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m1076build();
        }

        public int encodedSize(ChatBizContent r5) {
            Long r0 = r5.mteam_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            TeamChatType r3 = r5.mteam_chat_type;
            if (r3 == null) goto L10;
            r1 = TeamChatType.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            return ((r2 + r1) + this.mteam_infos.encodedSizeWithTag(3, r5.mteam_infos)) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1077decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ChatBizContent) r1);
        }

        public void encode(ProtoWriter r4, ChatBizContent r5) throws IOException {
            Long r0 = r5.mteam_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            TeamChatType r1 = r5.mteam_chat_type;
            if (r1 == null) goto L8;
            TeamChatType.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            this.mteam_infos.encodeWithTag(r4, 3, r5.mteam_infos);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ChatBizContent) r2);
        }
    }

    public static final class TeamInfo extends com.squareup.wire.Message<TeamInfo, Builder> {
        public static final ProtoAdapter<TeamInfo> ADAPTER = null;
        public static final Long DEFAULT_BIND_TIME = null;
        public static final Boolean DEFAULT_DISCOVERABLE = null;
        public static final Long DEFAULT_TEAM_ID = null;
        private static final long serialVersionUID = 0;
        public final Long mbind_time;
        public final Boolean mdiscoverable;
        public final TeamChatType mteam_chat_type;
        public final Long mteam_id;

        public static final class Builder extends com.squareup.wire.Message.Builder<TeamInfo, Builder> {
            public Long mbind_time;
            public Boolean mdiscoverable;
            public TeamChatType mteam_chat_type;
            public Long mteam_id;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TeamInfo m1079build() {
                return new TeamInfo(this.mteam_id, this.mteam_chat_type, this.mbind_time, this.mdiscoverable, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return m1079build();
            }

            public Builder bind_time(Long r1) {
                this.mbind_time = r1;
                return this;
            }

            public Builder discoverable(Boolean r1) {
                this.mdiscoverable = r1;
                return this;
            }

            public Builder team_chat_type(TeamChatType r1) {
                this.mteam_chat_type = r1;
                return this;
            }

            public Builder team_id(Long r1) {
                this.mteam_id = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TeamInfo extends ProtoAdapter<TeamInfo> {
            public ProtoAdapter_TeamInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, TeamInfo.class);
            }

            public TeamInfo decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mteam_id = 0L;
                r0.mbind_time = 0L;
                r0.mdiscoverable = Boolean.FALSE;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.mteam_id = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mteam_chat_type = (TeamChatType) TeamChatType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mbind_time = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mdiscoverable = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L13:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m1079build();
            }

            public int encodedSize(TeamInfo r6) {
                Long r0 = r6.mteam_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
            L6:
                TeamChatType r3 = r6.mteam_chat_type;
                if (r3 == null) goto L9;
                int r4 = TeamChatType.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Long r7 = r6.mbind_time;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
            L14:
                int r9 = r5 + r8;
                Boolean r10 = r6.mdiscoverable;
                if (r10 == null) goto L18;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
            L18:
                return (r9 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m1080decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TeamInfo) r1);
            }

            public void encode(ProtoWriter r4, TeamInfo r5) throws IOException {
                Long r0 = r5.mteam_id;
                if (r0 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
            L5:
                TeamChatType r1 = r5.mteam_chat_type;
                if (r1 == null) goto L8;
                TeamChatType.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                Long r2 = r5.mbind_time;
                if (r2 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
            L11:
                Boolean r3 = r5.mdiscoverable;
                if (r3 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
            L14:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TeamInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TeamInfo();
            DEFAULT_TEAM_ID = 0L;
            DEFAULT_BIND_TIME = 0L;
            DEFAULT_DISCOVERABLE = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1078newBuilder() {
            Builder r0 = new Builder();
            r0.mteam_id = this.mteam_id;
            r0.mteam_chat_type = this.mteam_chat_type;
            r0.mbind_time = this.mbind_time;
            r0.mdiscoverable = this.mdiscoverable;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TeamInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return m1078newBuilder();
        }

        public TeamInfo(Long r7, TeamChatType r8, Long r9, Boolean r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public TeamInfo(Long r2, TeamChatType r3, Long r4, Boolean r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mteam_id = r2;
            this.mteam_chat_type = r3;
            this.mbind_time = r4;
            this.mdiscoverable = r5;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatBizContent();
        DEFAULT_TEAM_ID = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1075newBuilder() {
        Builder r0 = new Builder();
        r0.mteam_id = this.mteam_id;
        r0.mteam_chat_type = this.mteam_chat_type;
        r0.mteam_infos = Internal.copyOf("mteam_infos", this.mteam_infos);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ChatBizContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1075newBuilder();
    }

    public ChatBizContent(Long r2, TeamChatType r3, Map<Long, TeamInfo> r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public ChatBizContent(Long r2, TeamChatType r3, Map<Long, TeamInfo> r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mteam_id = r2;
        this.mteam_chat_type = r3;
        this.mteam_infos = Internal.immutableCopyOf("mteam_infos", r4);
    }
}
