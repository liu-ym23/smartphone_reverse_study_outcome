package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MessageFilter extends Message<MessageFilter, Builder> {
    public static final ProtoAdapter<MessageFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class AttachmentFilter extends Message<AttachmentFilter, Builder> {
        public static final ProtoAdapter<AttachmentFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> minclude_attachment_types;

        public static final class Builder extends Message.Builder<AttachmentFilter, Builder> {
            public List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> minclude_attachment_types;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AttachmentFilter m2694build() {
                return new AttachmentFilter(this.minclude_attachment_types, super.buildUnknownFields());
            }

            public Builder() {
                this.minclude_attachment_types = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2694build();
            }

            public Builder include_attachment_types(List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> r1) {
                Internal.checkElementsNotNull(r1);
                this.minclude_attachment_types = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_AttachmentFilter extends ProtoAdapter<AttachmentFilter> {
            public ProtoAdapter_AttachmentFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, AttachmentFilter.class);
            }

            public AttachmentFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L7;
                r0.minclude_attachment_types.add((com.ss.android.lark.pb.entities.Message.MessageAttachmentType) com.ss.android.lark.pb.entities.Message.MessageAttachmentType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L12:
                r9.endMessage(r1);
                return r0.m2694build();
            }

            public int encodedSize(AttachmentFilter r4) {
                return com.ss.android.lark.pb.entities.Message.MessageAttachmentType.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.minclude_attachment_types) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2695decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((AttachmentFilter) r1);
            }

            public void encode(ProtoWriter r4, AttachmentFilter r5) throws IOException {
                com.ss.android.lark.pb.entities.Message.MessageAttachmentType.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.minclude_attachment_types);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (AttachmentFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AttachmentFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2693newBuilder() {
            Builder r0 = new Builder();
            r0.minclude_attachment_types = Internal.copyOf("minclude_attachment_types", this.minclude_attachment_types);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return AttachmentFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2693newBuilder();
        }

        public AttachmentFilter(List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> r2) {
            this(r2, ByteString.EMPTY);
        }

        public AttachmentFilter(List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.minclude_attachment_types = Internal.immutableCopyOf("minclude_attachment_types", r2);
        }
    }

    public static final class Builder extends Message.Builder<MessageFilter, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MessageFilter m2696build() {
            return new MessageFilter(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2696build();
        }
    }

    public static final class ChatTypeFilter extends Message<ChatTypeFilter, Builder> {
        public static final ProtoAdapter<ChatTypeFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ChatFilterType mchat_filter_type;

        public static final class Builder extends Message.Builder<ChatTypeFilter, Builder> {
            public ChatFilterType mchat_filter_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ChatTypeFilter m2698build() {
                return new ChatTypeFilter(this.mchat_filter_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2698build();
            }

            public Builder chat_filter_type(ChatFilterType r1) {
                this.mchat_filter_type = r1;
                return this;
            }
        }

        public static final enum ChatFilterType extends Enum<ChatFilterType> implements WireEnum {
            private static final /* synthetic */ ChatFilterType[] $VALUES = null;
            public static final ProtoAdapter<ChatFilterType> ADAPTER = null;
            public static final ChatFilterType DEFAULT = null;
            public static final ChatFilterType GROUP_CHAT = null;
            public static final ChatFilterType P2P_CHAT = null;
            private final int value;

            static {
                ChatFilterType r0 = new ChatFilterType("DEFAULT", 0, 0);
                DEFAULT = r0;
                ChatFilterType r1 = new ChatFilterType("GROUP_CHAT", 1, 1);
                GROUP_CHAT = r1;
                ChatFilterType r3 = new ChatFilterType("P2P_CHAT", 2, 2);
                P2P_CHAT = r3;
                $VALUES = new ChatFilterType[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(ChatFilterType.class);
            }

            public static ChatFilterType[] values() {
                return (ChatFilterType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static ChatFilterType fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return P2P_CHAT;
            L12:
                return GROUP_CHAT;
            L14:
                return DEFAULT;
            }

            public static ChatFilterType valueOf(String r1) {
                return (ChatFilterType) a.a(ChatFilterType.class, r1);
            }

            private ChatFilterType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_ChatTypeFilter extends ProtoAdapter<ChatTypeFilter> {
            public ProtoAdapter_ChatTypeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatTypeFilter.class);
            }

            public ChatTypeFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L7;
                r0.mchat_filter_type = (ChatFilterType) ChatFilterType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L12:
                r9.endMessage(r1);
                return r0.m2698build();
            }

            public int encodedSize(ChatTypeFilter r4) {
                ChatFilterType r0 = r4.mchat_filter_type;
                if (r0 == null) goto L5;
                int r1 = ChatFilterType.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2699decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ChatTypeFilter) r1);
            }

            public void encode(ProtoWriter r4, ChatTypeFilter r5) throws IOException {
                ChatFilterType r0 = r5.mchat_filter_type;
                if (r0 == null) goto L5;
                ChatFilterType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ChatTypeFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatTypeFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2697newBuilder() {
            Builder r0 = new Builder();
            r0.mchat_filter_type = this.mchat_filter_type;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ChatTypeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2697newBuilder();
        }

        public ChatTypeFilter(ChatFilterType r2) {
            this(r2, ByteString.EMPTY);
        }

        public ChatTypeFilter(ChatFilterType r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mchat_filter_type = r2;
        }
    }

    public static final class FromUserFilter extends Message<FromUserFilter, Builder> {
        public static final ProtoAdapter<FromUserFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> muser_ids;

        public static final class Builder extends Message.Builder<FromUserFilter, Builder> {
            public List<String> muser_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public FromUserFilter m2701build() {
                return new FromUserFilter(this.muser_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.muser_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2701build();
            }

            public Builder user_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.muser_ids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_FromUserFilter extends ProtoAdapter<FromUserFilter> {
            public ProtoAdapter_FromUserFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, FromUserFilter.class);
            }

            public FromUserFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.muser_ids.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2701build();
            }

            public int encodedSize(FromUserFilter r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.muser_ids) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2702decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((FromUserFilter) r1);
            }

            public void encode(ProtoWriter r4, FromUserFilter r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.muser_ids);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (FromUserFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FromUserFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2700newBuilder() {
            Builder r0 = new Builder();
            r0.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return FromUserFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2700newBuilder();
        }

        public FromUserFilter(List<String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public FromUserFilter(List<String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.muser_ids = Internal.immutableCopyOf("muser_ids", r2);
        }
    }

    public static final class InChatFilter extends Message<InChatFilter, Builder> {
        public static final ProtoAdapter<InChatFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mgroup_chat_ids;
        public final List<String> mp2p_chatter_ids;

        public static final class Builder extends Message.Builder<InChatFilter, Builder> {
            public List<String> mgroup_chat_ids;
            public List<String> mp2p_chatter_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public InChatFilter m2704build() {
                return new InChatFilter(this.mgroup_chat_ids, this.mp2p_chatter_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mgroup_chat_ids = Internal.newMutableList();
                this.mp2p_chatter_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2704build();
            }

            public Builder group_chat_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mgroup_chat_ids = r1;
                return this;
            }

            public Builder p2p_chatter_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mp2p_chatter_ids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_InChatFilter extends ProtoAdapter<InChatFilter> {
            public ProtoAdapter_InChatFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, InChatFilter.class);
            }

            public InChatFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mgroup_chat_ids.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mp2p_chatter_ids.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2704build();
            }

            public int encodedSize(InChatFilter r5) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                return (r0.asRepeated().encodedSizeWithTag(1, r5.mgroup_chat_ids) + r0.asRepeated().encodedSizeWithTag(2, r5.mp2p_chatter_ids)) + r5.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2705decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((InChatFilter) r1);
            }

            public void encode(ProtoWriter r5, InChatFilter r6) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.asRepeated().encodeWithTag(r5, 1, r6.mgroup_chat_ids);
                r0.asRepeated().encodeWithTag(r5, 2, r6.mp2p_chatter_ids);
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (InChatFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_InChatFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2703newBuilder() {
            Builder r0 = new Builder();
            r0.mgroup_chat_ids = Internal.copyOf("mgroup_chat_ids", this.mgroup_chat_ids);
            r0.mp2p_chatter_ids = Internal.copyOf("mp2p_chatter_ids", this.mp2p_chatter_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return InChatFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2703newBuilder();
        }

        public InChatFilter(List<String> r2, List<String> r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public InChatFilter(List<String> r2, List<String> r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mgroup_chat_ids = Internal.immutableCopyOf("mgroup_chat_ids", r2);
            this.mp2p_chatter_ids = Internal.immutableCopyOf("mp2p_chatter_ids", r3);
        }
    }

    public static final class MatchScopeFilter extends Message<MatchScopeFilter, Builder> {
        public static final ProtoAdapter<MatchScopeFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<ScopeType> mscope_types;

        public static final class Builder extends Message.Builder<MatchScopeFilter, Builder> {
            public List<ScopeType> mscope_types;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MatchScopeFilter m2707build() {
                return new MatchScopeFilter(this.mscope_types, super.buildUnknownFields());
            }

            public Builder() {
                this.mscope_types = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2707build();
            }

            public Builder scope_types(List<ScopeType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mscope_types = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MatchScopeFilter extends ProtoAdapter<MatchScopeFilter> {
            public ProtoAdapter_MatchScopeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, MatchScopeFilter.class);
            }

            public MatchScopeFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L7;
                r0.mscope_types.add((ScopeType) ScopeType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L12:
                r9.endMessage(r1);
                return r0.m2707build();
            }

            public int encodedSize(MatchScopeFilter r4) {
                return ScopeType.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mscope_types) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2708decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MatchScopeFilter) r1);
            }

            public void encode(ProtoWriter r4, MatchScopeFilter r5) throws IOException {
                ScopeType.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mscope_types);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MatchScopeFilter) r2);
            }
        }

        public static final enum ScopeType extends Enum<ScopeType> implements WireEnum {
            private static final /* synthetic */ ScopeType[] $VALUES = null;
            public static final ProtoAdapter<ScopeType> ADAPTER = null;
            public static final ScopeType AT_ALL = null;
            public static final ScopeType AT_ME = null;
            public static final ScopeType BLOCK_BOT_MESSAGE = null;
            public static final ScopeType BLOCK_USER_MESSAGE = null;
            public static final ScopeType DEFAULT = null;
            private final int value;

            static {
                ScopeType r0 = new ScopeType("DEFAULT", 0, 0);
                DEFAULT = r0;
                ScopeType r1 = new ScopeType("AT_ME", 1, 1);
                AT_ME = r1;
                ScopeType r3 = new ScopeType("BLOCK_BOT_MESSAGE", 2, 2);
                BLOCK_BOT_MESSAGE = r3;
                ScopeType r5 = new ScopeType("BLOCK_USER_MESSAGE", 3, 3);
                BLOCK_USER_MESSAGE = r5;
                ScopeType r7 = new ScopeType("AT_ALL", 4, 4);
                AT_ALL = r7;
                $VALUES = new ScopeType[]{r0, r1, r3, r5, r7};
                ADAPTER = ProtoAdapter.newEnumAdapter(ScopeType.class);
            }

            public static ScopeType[] values() {
                return (ScopeType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static ScopeType fromValue(int r1) {
                if (r1 == 0) goto L22;
                if (r1 == 1) goto L20;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L16;
                if (r1 == 4) goto L14;
                return null;
            L14:
                return AT_ALL;
            L16:
                return BLOCK_USER_MESSAGE;
            L18:
                return BLOCK_BOT_MESSAGE;
            L20:
                return AT_ME;
            L22:
                return DEFAULT;
            }

            public static ScopeType valueOf(String r1) {
                return (ScopeType) a.a(ScopeType.class, r1);
            }

            private ScopeType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MatchScopeFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2706newBuilder() {
            Builder r0 = new Builder();
            r0.mscope_types = Internal.copyOf("mscope_types", this.mscope_types);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MatchScopeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2706newBuilder();
        }

        public MatchScopeFilter(List<ScopeType> r2) {
            this(r2, ByteString.EMPTY);
        }

        public MatchScopeFilter(List<ScopeType> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mscope_types = Internal.immutableCopyOf("mscope_types", r2);
        }
    }

    public static final class MessageTypeFilter extends Message<MessageTypeFilter, Builder> {
        public static final ProtoAdapter<MessageTypeFilter> ADAPTER = null;
        public static final Boolean DEFAULT_IS_URL = null;
        private static final long serialVersionUID = 0;
        public final Boolean mis_url;
        public final com.ss.android.lark.pb.entities.Message.Type mmessage_type;

        public static final class Builder extends Message.Builder<MessageTypeFilter, Builder> {
            public Boolean mis_url;
            public com.ss.android.lark.pb.entities.Message.Type mmessage_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MessageTypeFilter m2710build() {
                return new MessageTypeFilter(this.mmessage_type, this.mis_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2710build();
            }

            public Builder is_url(Boolean r1) {
                this.mis_url = r1;
                return this;
            }

            public Builder message_type(com.ss.android.lark.pb.entities.Message.Type r1) {
                this.mmessage_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageTypeFilter extends ProtoAdapter<MessageTypeFilter> {
            public ProtoAdapter_MessageTypeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageTypeFilter.class);
            }

            public MessageTypeFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mis_url = Boolean.FALSE;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mmessage_type = (com.ss.android.lark.pb.entities.Message.Type) com.ss.android.lark.pb.entities.Message.Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mis_url = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L15:
                r9.endMessage(r1);
                return r0.m2710build();
            }

            public int encodedSize(MessageTypeFilter r5) {
                com.ss.android.lark.pb.entities.Message.Type r0 = r5.mmessage_type;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = com.ss.android.lark.pb.entities.Message.Type.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r5.mis_url;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2711decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MessageTypeFilter) r1);
            }

            public void encode(ProtoWriter r4, MessageTypeFilter r5) throws IOException {
                com.ss.android.lark.pb.entities.Message.Type r0 = r5.mmessage_type;
                if (r0 == null) goto L5;
                com.ss.android.lark.pb.entities.Message.Type.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mis_url;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MessageTypeFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageTypeFilter();
            DEFAULT_IS_URL = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2709newBuilder() {
            Builder r0 = new Builder();
            r0.mmessage_type = this.mmessage_type;
            r0.mis_url = this.mis_url;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MessageTypeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2709newBuilder();
        }

        public MessageTypeFilter(com.ss.android.lark.pb.entities.Message.Type r2, Boolean r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public MessageTypeFilter(com.ss.android.lark.pb.entities.Message.Type r2, Boolean r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mmessage_type = r2;
            this.mis_url = r3;
        }
    }

    public static final class ProtoAdapter_MessageFilter extends ProtoAdapter<MessageFilter> {
        public ProtoAdapter_MessageFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageFilter.class);
        }

        public MessageFilter decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L6;
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L6:
            r7.endMessage(r1);
            return r0.m2696build();
        }

        public int encodedSize(MessageFilter r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2712decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MessageFilter) r1);
        }

        public void encode(ProtoWriter r1, MessageFilter r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MessageFilter) r2);
        }
    }

    public static final class TimeFilter extends Message<TimeFilter, Builder> {
        public static final ProtoAdapter<TimeFilter> ADAPTER = null;
        public static final Long DEFAULT_CUSTOMIZED_END_TIME = null;
        public static final Long DEFAULT_CUSTOMIZED_START_TIME = null;
        private static final long serialVersionUID = 0;
        public final Long mcustomized_end_time;
        public final Long mcustomized_start_time;
        public final TimeFilterType mtime_range_type;

        public static final class Builder extends Message.Builder<TimeFilter, Builder> {
            public Long mcustomized_end_time;
            public Long mcustomized_start_time;
            public TimeFilterType mtime_range_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TimeFilter m2714build() {
                return new TimeFilter(this.mtime_range_type, this.mcustomized_start_time, this.mcustomized_end_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2714build();
            }

            public Builder customized_end_time(Long r1) {
                this.mcustomized_end_time = r1;
                return this;
            }

            public Builder customized_start_time(Long r1) {
                this.mcustomized_start_time = r1;
                return this;
            }

            public Builder time_range_type(TimeFilterType r1) {
                this.mtime_range_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TimeFilter extends ProtoAdapter<TimeFilter> {
            public ProtoAdapter_TimeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, TimeFilter.class);
            }

            public TimeFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mcustomized_start_time = 0L;
                r0.mcustomized_end_time = 0L;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mtime_range_type = (TimeFilterType) TimeFilterType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mcustomized_start_time = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mcustomized_end_time = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L18:
                r9.endMessage(r1);
                return r0.m2714build();
            }

            public int encodedSize(TimeFilter r6) {
                TimeFilterType r0 = r6.mtime_range_type;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = TimeFilterType.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Long r3 = r6.mcustomized_start_time;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Long r7 = r6.mcustomized_end_time;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
            L14:
                return (r5 + r1) + r6.unknownFields().size();
            L9:
                r4 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2715decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TimeFilter) r1);
            }

            public void encode(ProtoWriter r4, TimeFilter r5) throws IOException {
                TimeFilterType r0 = r5.mtime_range_type;
                if (r0 == null) goto L5;
                TimeFilterType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Long r1 = r5.mcustomized_start_time;
                if (r1 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
            L8:
                Long r2 = r5.mcustomized_end_time;
                if (r2 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TimeFilter) r2);
            }
        }

        public static final enum TimeFilterType extends Enum<TimeFilterType> implements WireEnum {
            private static final /* synthetic */ TimeFilterType[] $VALUES = null;
            public static final ProtoAdapter<TimeFilterType> ADAPTER = null;
            public static final TimeFilterType CUSTOMIZED = null;
            public static final TimeFilterType DEFAULT = null;
            public static final TimeFilterType ONE_DAY = null;
            public static final TimeFilterType ONE_MONTH = null;
            public static final TimeFilterType ONE_WEEK = null;
            public static final TimeFilterType THREE_MONTH = null;
            private final int value;

            static {
                TimeFilterType r0 = new TimeFilterType("DEFAULT", 0, 0);
                DEFAULT = r0;
                TimeFilterType r1 = new TimeFilterType("ONE_DAY", 1, 1);
                ONE_DAY = r1;
                TimeFilterType r3 = new TimeFilterType("ONE_WEEK", 2, 2);
                ONE_WEEK = r3;
                TimeFilterType r5 = new TimeFilterType("ONE_MONTH", 3, 3);
                ONE_MONTH = r5;
                TimeFilterType r7 = new TimeFilterType("THREE_MONTH", 4, 4);
                THREE_MONTH = r7;
                TimeFilterType r9 = new TimeFilterType("CUSTOMIZED", 5, 5);
                CUSTOMIZED = r9;
                $VALUES = new TimeFilterType[]{r0, r1, r3, r5, r7, r9};
                ADAPTER = ProtoAdapter.newEnumAdapter(TimeFilterType.class);
            }

            public static TimeFilterType[] values() {
                return (TimeFilterType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static TimeFilterType fromValue(int r1) {
                if (r1 == 0) goto L26;
                if (r1 == 1) goto L24;
                if (r1 == 2) goto L22;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L18;
                if (r1 == 5) goto L16;
                return null;
            L16:
                return CUSTOMIZED;
            L18:
                return THREE_MONTH;
            L20:
                return ONE_MONTH;
            L22:
                return ONE_WEEK;
            L24:
                return ONE_DAY;
            L26:
                return DEFAULT;
            }

            public static TimeFilterType valueOf(String r1) {
                return (TimeFilterType) a.a(TimeFilterType.class, r1);
            }

            private TimeFilterType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimeFilter();
            DEFAULT_CUSTOMIZED_START_TIME = 0L;
            DEFAULT_CUSTOMIZED_END_TIME = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2713newBuilder() {
            Builder r0 = new Builder();
            r0.mtime_range_type = this.mtime_range_type;
            r0.mcustomized_start_time = this.mcustomized_start_time;
            r0.mcustomized_end_time = this.mcustomized_end_time;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TimeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2713newBuilder();
        }

        public TimeFilter(TimeFilterType r2, Long r3, Long r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public TimeFilter(TimeFilterType r2, Long r3, Long r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mtime_range_type = r2;
            this.mcustomized_start_time = r3;
            this.mcustomized_end_time = r4;
        }
    }

    public static final class WithUserFilter extends Message<WithUserFilter, Builder> {
        public static final ProtoAdapter<WithUserFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> muser_ids;

        public static final class Builder extends Message.Builder<WithUserFilter, Builder> {
            public List<String> muser_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public WithUserFilter m2717build() {
                return new WithUserFilter(this.muser_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.muser_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2717build();
            }

            public Builder user_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.muser_ids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_WithUserFilter extends ProtoAdapter<WithUserFilter> {
            public ProtoAdapter_WithUserFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, WithUserFilter.class);
            }

            public WithUserFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.muser_ids.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2717build();
            }

            public int encodedSize(WithUserFilter r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.muser_ids) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2718decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((WithUserFilter) r1);
            }

            public void encode(ProtoWriter r4, WithUserFilter r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.muser_ids);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (WithUserFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_WithUserFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2716newBuilder() {
            Builder r0 = new Builder();
            r0.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return WithUserFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2716newBuilder();
        }

        public WithUserFilter(List<String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public WithUserFilter(List<String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.muser_ids = Internal.immutableCopyOf("muser_ids", r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageFilter();
    }

    public MessageFilter() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2692newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MessageFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2692newBuilder();
    }

    public MessageFilter(ByteString r2) {
        super(ADAPTER, r2);
    }
}
