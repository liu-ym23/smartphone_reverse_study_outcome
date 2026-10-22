package com.ss.android.lark.pb.usearch;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Chat;
import com.ss.android.lark.pb.entities.DocSortRuleType;
import com.ss.android.lark.pb.entities.DocType;
import com.ss.android.lark.pb.entities.FileType;
import com.ss.android.lark.pb.entities.GroupSortRuleType;
import com.ss.android.lark.pb.entities.UserGroupSceneType;
import com.ss.android.lark.pb.entities.UserGroupType;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class UniversalFilters extends Message<UniversalFilters, Builder> {
    public static final ProtoAdapter<UniversalFilters> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class BannerFilter extends Message<BannerFilter, Builder> {
        public static final ProtoAdapter<BannerFilter> ADAPTER = null;
        public static final Boolean DEFAULT_CAN_SUPPORT_V2 = null;
        private static final long serialVersionUID = 0;
        public final List<BannerActionType> mbanner_actions;
        public final Boolean mcan_support_v2;
        public final SearchTabName msearch_tab;

        public static final class Builder extends Message.Builder<BannerFilter, Builder> {
            public List<BannerActionType> mbanner_actions;
            public Boolean mcan_support_v2;
            public SearchTabName msearch_tab;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public BannerFilter m2880build() {
                SearchTabName r0 = this.msearch_tab;
                if (r0 == null) goto L7;
                return new BannerFilter(this.msearch_tab, this.mcan_support_v2, this.mbanner_actions, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "msearch_tab"});
            }

            public Builder() {
                this.mbanner_actions = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2880build();
            }

            public Builder banner_actions(List<BannerActionType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mbanner_actions = r1;
                return this;
            }

            public Builder can_support_v2(Boolean r1) {
                this.mcan_support_v2 = r1;
                return this;
            }

            public Builder search_tab(SearchTabName r1) {
                this.msearch_tab = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_BannerFilter extends ProtoAdapter<BannerFilter> {
            public ProtoAdapter_BannerFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, BannerFilter.class);
            }

            public BannerFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mcan_support_v2 = Boolean.FALSE;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.msearch_tab = (SearchTabName) SearchTabName.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mcan_support_v2 = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mbanner_actions.add((BannerActionType) BannerActionType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r1);
                return r0.m2880build();
            }

            public int encodedSize(BannerFilter r5) {
                int r0 = SearchTabName.ADAPTER.encodedSizeWithTag(1, r5.msearch_tab);
                Boolean r1 = r5.mcan_support_v2;
                if (r1 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r1);
            L7:
                return ((r0 + r2) + BannerActionType.ADAPTER.asRepeated().encodedSizeWithTag(3, r5.mbanner_actions)) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2881decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((BannerFilter) r1);
            }

            public void encode(ProtoWriter r4, BannerFilter r5) throws IOException {
                SearchTabName.ADAPTER.encodeWithTag(r4, 1, r5.msearch_tab);
                Boolean r0 = r5.mcan_support_v2;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r0);
            L5:
                BannerActionType.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mbanner_actions);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (BannerFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BannerFilter();
            DEFAULT_CAN_SUPPORT_V2 = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2879newBuilder() {
            Builder r0 = new Builder();
            r0.msearch_tab = this.msearch_tab;
            r0.mcan_support_v2 = this.mcan_support_v2;
            r0.mbanner_actions = Internal.copyOf("mbanner_actions", this.mbanner_actions);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return BannerFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2879newBuilder();
        }

        public BannerFilter(SearchTabName r2, Boolean r3, List<BannerActionType> r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public BannerFilter(SearchTabName r2, Boolean r3, List<BannerActionType> r4, ByteString r5) {
            super(ADAPTER, r5);
            this.msearch_tab = r2;
            this.mcan_support_v2 = r3;
            this.mbanner_actions = Internal.immutableCopyOf("mbanner_actions", r4);
        }
    }

    public static final class BotFilter extends Message<BotFilter, Builder> {
        public static final ProtoAdapter<BotFilter> ADAPTER = null;
        public static final Boolean DEFAULT_HAVE_CHATTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mchat_ids;
        public final Boolean mhave_chatter;

        public static final class Builder extends Message.Builder<BotFilter, Builder> {
            public List<String> mchat_ids;
            public Boolean mhave_chatter;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public BotFilter m2883build() {
                return new BotFilter(this.mchat_ids, this.mhave_chatter, super.buildUnknownFields());
            }

            public Builder() {
                this.mchat_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2883build();
            }

            public Builder chat_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_ids = r1;
                return this;
            }

            public Builder have_chatter(Boolean r1) {
                this.mhave_chatter = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_BotFilter extends ProtoAdapter<BotFilter> {
            public ProtoAdapter_BotFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, BotFilter.class);
            }

            public BotFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mhave_chatter = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mchat_ids.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mhave_chatter = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2883build();
            }

            public int encodedSize(BotFilter r5) {
                int r0 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r5.mchat_ids);
                Boolean r1 = r5.mhave_chatter;
                if (r1 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r1);
            L7:
                return (r0 + r2) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2884decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((BotFilter) r1);
            }

            public void encode(ProtoWriter r4, BotFilter r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.mchat_ids);
                Boolean r0 = r5.mhave_chatter;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (BotFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_BotFilter();
            DEFAULT_HAVE_CHATTER = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2882newBuilder() {
            Builder r0 = new Builder();
            r0.mchat_ids = Internal.copyOf("mchat_ids", this.mchat_ids);
            r0.mhave_chatter = this.mhave_chatter;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return BotFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2882newBuilder();
        }

        public BotFilter(List<String> r2, Boolean r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public BotFilter(List<String> r2, Boolean r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mchat_ids = Internal.immutableCopyOf("mchat_ids", r2);
            this.mhave_chatter = r3;
        }
    }

    public static final class Builder extends Message.Builder<UniversalFilters, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UniversalFilters m2885build() {
            return new UniversalFilters(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2885build();
        }
    }

    public static final class ChatInfo extends Message<ChatInfo, Builder> {
        public static final ProtoAdapter<ChatInfo> ADAPTER = null;
        public static final String DEFAULT_CHAT_ID = "";
        private static final long serialVersionUID = 0;
        public final String mchat_id;
        public final ChatType mchat_type;

        public static final class Builder extends Message.Builder<ChatInfo, Builder> {
            public String mchat_id;
            public ChatType mchat_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ChatInfo m2887build() {
                return new ChatInfo(this.mchat_id, this.mchat_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2887build();
            }

            public Builder chat_id(String r1) {
                this.mchat_id = r1;
                return this;
            }

            public Builder chat_type(ChatType r1) {
                this.mchat_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ChatInfo extends ProtoAdapter<ChatInfo> {
            public ProtoAdapter_ChatInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, ChatInfo.class);
            }

            public ChatInfo decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mchat_id = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mchat_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mchat_type = (ChatType) ChatType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L15:
                r9.endMessage(r1);
                return r0.m2887build();
            }

            public int encodedSize(ChatInfo r5) {
                String r0 = r5.mchat_id;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                ChatType r3 = r5.mchat_type;
                if (r3 == null) goto L10;
                r1 = ChatType.ADAPTER.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2888decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ChatInfo) r1);
            }

            public void encode(ProtoWriter r4, ChatInfo r5) throws IOException {
                String r0 = r5.mchat_id;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                ChatType r1 = r5.mchat_type;
                if (r1 == null) goto L8;
                ChatType.ADAPTER.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ChatInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ChatInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2886newBuilder() {
            Builder r0 = new Builder();
            r0.mchat_id = this.mchat_id;
            r0.mchat_type = this.mchat_type;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2886newBuilder();
        }

        public ChatInfo(String r2, ChatType r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public ChatInfo(String r2, ChatType r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mchat_id = r2;
            this.mchat_type = r3;
        }
    }

    public static final enum ChatType extends Enum<ChatType> implements WireEnum {
        private static final /* synthetic */ ChatType[] $VALUES = null;
        public static final ProtoAdapter<ChatType> ADAPTER = null;
        public static final ChatType GROUP_CHAT = null;
        public static final ChatType P2P_CHAT = null;
        private final int value;

        static {
            ChatType r0 = new ChatType("GROUP_CHAT", 0, 1);
            GROUP_CHAT = r0;
            ChatType r1 = new ChatType("P2P_CHAT", 1, 2);
            P2P_CHAT = r1;
            $VALUES = new ChatType[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(ChatType.class);
        }

        public static ChatType[] values() {
            return (ChatType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ChatType fromValue(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return null;
        L9:
            return P2P_CHAT;
        L11:
            return GROUP_CHAT;
        }

        public static ChatType valueOf(String r1) {
            return (ChatType) a.a(ChatType.class, r1);
        }

        private ChatType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class CommonFilter extends Message<CommonFilter, Builder> {
        public static final ProtoAdapter<CommonFilter> ADAPTER = null;
        public static final String DEFAULT_CHAT_ID = "";
        public static final Boolean DEFAULT_ENABLE_EXTENDED_SEARCH = null;
        public static final Boolean DEFAULT_INCLUDE_OUTER_TENANT = null;
        public static final String DEFAULT_IN_TEAM_ID = "";
        public static final Boolean DEFAULT_USE_EXTENDED_SEARCH_V2 = null;
        public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
        public static final FieldOptions FIELD_OPTIONS_MFROM_USER_IDS = null;
        public static final FieldOptions FIELD_OPTIONS_MIN_CHAT_IDS = null;
        public static final FieldOptions FIELD_OPTIONS_MWITH_USER_IDS = null;
        private static final long serialVersionUID = 0;
        public final String mchat_id;
        public final List<ChatInfo> mchat_infos;
        public final Boolean menable_extended_search;
        public final List<String> mfrom_user_ids;
        public final List<String> min_chat_ids;
        public final String min_team_id;
        public final Boolean minclude_outer_tenant;
        public final List<SearchQABizType> msearch_qa_biz_type;
        public final TimeRange mtime_range;
        public final Boolean muse_extended_search_v2;
        public final List<String> mwith_user_ids;

        public static final class Builder extends Message.Builder<CommonFilter, Builder> {
            public String mchat_id;
            public List<ChatInfo> mchat_infos;
            public Boolean menable_extended_search;
            public List<String> mfrom_user_ids;
            public List<String> min_chat_ids;
            public String min_team_id;
            public Boolean minclude_outer_tenant;
            public List<SearchQABizType> msearch_qa_biz_type;
            public TimeRange mtime_range;
            public Boolean muse_extended_search_v2;
            public List<String> mwith_user_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CommonFilter m2890build() {
                return new CommonFilter(this.minclude_outer_tenant, this.mchat_id, this.mfrom_user_ids, this.min_chat_ids, this.mtime_range, this.min_team_id, this.mwith_user_ids, this.menable_extended_search, this.muse_extended_search_v2, this.mchat_infos, this.msearch_qa_biz_type, super.buildUnknownFields());
            }

            public Builder() {
                this.mfrom_user_ids = Internal.newMutableList();
                this.min_chat_ids = Internal.newMutableList();
                this.mwith_user_ids = Internal.newMutableList();
                this.mchat_infos = Internal.newMutableList();
                this.msearch_qa_biz_type = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2890build();
            }

            public Builder chat_id(String r1) {
                this.mchat_id = r1;
                return this;
            }

            public Builder chat_infos(List<ChatInfo> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_infos = r1;
                return this;
            }

            public Builder enable_extended_search(Boolean r1) {
                this.menable_extended_search = r1;
                return this;
            }

            public Builder from_user_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfrom_user_ids = r1;
                return this;
            }

            public Builder in_chat_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.min_chat_ids = r1;
                return this;
            }

            public Builder in_team_id(String r1) {
                this.min_team_id = r1;
                return this;
            }

            public Builder include_outer_tenant(Boolean r1) {
                this.minclude_outer_tenant = r1;
                return this;
            }

            public Builder search_qa_biz_type(List<SearchQABizType> r1) {
                Internal.checkElementsNotNull(r1);
                this.msearch_qa_biz_type = r1;
                return this;
            }

            public Builder time_range(TimeRange r1) {
                this.mtime_range = r1;
                return this;
            }

            public Builder use_extended_search_v2(Boolean r1) {
                this.muse_extended_search_v2 = r1;
                return this;
            }

            public Builder with_user_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mwith_user_ids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_CommonFilter extends ProtoAdapter<CommonFilter> {
            public ProtoAdapter_CommonFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, CommonFilter.class);
            }

            public CommonFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.minclude_outer_tenant = Boolean.TRUE;
                r0.mchat_id = "";
                r0.min_team_id = "";
                Boolean r1 = Boolean.FALSE;
                r0.menable_extended_search = r1;
                r0.muse_extended_search_v2 = r1;
                long r2 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L21;
                switch(r3) {
                    case 1: goto L20;
                    case 2: goto L19;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L15;
                    case 7: goto L14;
                    case 8: goto L13;
                    case 9: goto L12;
                    case 10: goto L11;
                    case 11: goto L23;
                    default: goto L6;
                };
            L23:
                r0.msearch_qa_biz_type.add((SearchQABizType) SearchQABizType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r0.mchat_infos.add((ChatInfo) ChatInfo.ADAPTER.decode(r9));
                goto L3
            L12:
                r0.muse_extended_search_v2 = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L13:
                r0.menable_extended_search = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L14:
                r0.mwith_user_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L15:
                r0.min_team_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L16:
                r0.mtime_range = (TimeRange) TimeRange.ADAPTER.decode(r9);
                goto L3
            L17:
                r0.min_chat_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L18:
                r0.mfrom_user_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L19:
                r0.mchat_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L20:
                r0.minclude_outer_tenant = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L21:
                r9.endMessage(r2);
                return r0.m2890build();
            }

            public int encodedSize(CommonFilter r7) {
                Boolean r0 = r7.minclude_outer_tenant;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r7.mchat_id;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                ProtoAdapter r6 = ProtoAdapter.STRING;
                int r8 = (r5 + r6.asRepeated().encodedSizeWithTag(3, r7.mfrom_user_ids)) + r6.asRepeated().encodedSizeWithTag(4, r7.min_chat_ids);
                TimeRange r9 = r7.mtime_range;
                if (r9 == null) goto L13;
                int r10 = TimeRange.ADAPTER.encodedSizeWithTag(5, r9);
            L14:
                int r11 = r8 + r10;
                String r12 = r7.min_team_id;
                if (r12 == null) goto L17;
                int r13 = r6.encodedSizeWithTag(6, r12);
            L18:
                int r14 = (r11 + r13) + r6.asRepeated().encodedSizeWithTag(7, r7.mwith_user_ids);
                Boolean r15 = r7.menable_extended_search;
                if (r15 == null) goto L21;
                int r16 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r15);
            L22:
                int r17 = r14 + r16;
                Boolean r18 = r7.muse_extended_search_v2;
                if (r18 == null) goto L26;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r18);
            L26:
                return (((r17 + r1) + ChatInfo.ADAPTER.asRepeated().encodedSizeWithTag(10, r7.mchat_infos)) + SearchQABizType.ADAPTER.asRepeated().encodedSizeWithTag(11, r7.msearch_qa_biz_type)) + r7.unknownFields().size();
            L21:
                r16 = 0;
                goto L22
            L17:
                r13 = 0;
                goto L18
            L13:
                r10 = 0;
                goto L14
            L9:
                r4 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2891decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CommonFilter) r1);
            }

            public void encode(ProtoWriter r5, CommonFilter r6) throws IOException {
                Boolean r0 = r6.minclude_outer_tenant;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r5, 1, r0);
            L5:
                String r1 = r6.mchat_id;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r5, 2, r1);
            L8:
                ProtoAdapter r2 = ProtoAdapter.STRING;
                r2.asRepeated().encodeWithTag(r5, 3, r6.mfrom_user_ids);
                r2.asRepeated().encodeWithTag(r5, 4, r6.min_chat_ids);
                TimeRange r3 = r6.mtime_range;
                if (r3 == null) goto L11;
                TimeRange.ADAPTER.encodeWithTag(r5, 5, r3);
            L11:
                String r4 = r6.min_team_id;
                if (r4 == null) goto L14;
                r2.encodeWithTag(r5, 6, r4);
            L14:
                r2.asRepeated().encodeWithTag(r5, 7, r6.mwith_user_ids);
                Boolean r7 = r6.menable_extended_search;
                if (r7 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r5, 8, r7);
            L17:
                Boolean r8 = r6.muse_extended_search_v2;
                if (r8 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r5, 9, r8);
            L20:
                ChatInfo.ADAPTER.asRepeated().encodeWithTag(r5, 10, r6.mchat_infos);
                SearchQABizType.ADAPTER.asRepeated().encodeWithTag(r5, 11, r6.msearch_qa_biz_type);
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CommonFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CommonFilter();
            FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().id("chat_id").build();
            FIELD_OPTIONS_MFROM_USER_IDS = new FieldOptions.Builder().id("user_id").build();
            FIELD_OPTIONS_MIN_CHAT_IDS = new FieldOptions.Builder().id("chat_id").build();
            FIELD_OPTIONS_MWITH_USER_IDS = new FieldOptions.Builder().id("user_id").build();
            DEFAULT_INCLUDE_OUTER_TENANT = Boolean.TRUE;
            Boolean r0 = Boolean.FALSE;
            DEFAULT_ENABLE_EXTENDED_SEARCH = r0;
            DEFAULT_USE_EXTENDED_SEARCH_V2 = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2889newBuilder() {
            Builder r0 = new Builder();
            r0.minclude_outer_tenant = this.minclude_outer_tenant;
            r0.mchat_id = this.mchat_id;
            r0.mfrom_user_ids = Internal.copyOf("mfrom_user_ids", this.mfrom_user_ids);
            r0.min_chat_ids = Internal.copyOf("min_chat_ids", this.min_chat_ids);
            r0.mtime_range = this.mtime_range;
            r0.min_team_id = this.min_team_id;
            r0.mwith_user_ids = Internal.copyOf("mwith_user_ids", this.mwith_user_ids);
            r0.menable_extended_search = this.menable_extended_search;
            r0.muse_extended_search_v2 = this.muse_extended_search_v2;
            r0.mchat_infos = Internal.copyOf("mchat_infos", this.mchat_infos);
            r0.msearch_qa_biz_type = Internal.copyOf("msearch_qa_biz_type", this.msearch_qa_biz_type);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CommonFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2889newBuilder();
        }

        public CommonFilter(Boolean r14, String r15, List<String> r16, List<String> r17, TimeRange r18, String r19, List<String> r20, Boolean r21, Boolean r22, List<ChatInfo> r23, List<SearchQABizType> r24) {
            this(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, ByteString.EMPTY);
        }

        public CommonFilter(Boolean r2, String r3, List<String> r4, List<String> r5, TimeRange r6, String r7, List<String> r8, Boolean r9, Boolean r10, List<ChatInfo> r11, List<SearchQABizType> r12, ByteString r13) {
            super(ADAPTER, r13);
            this.minclude_outer_tenant = r2;
            this.mchat_id = r3;
            this.mfrom_user_ids = Internal.immutableCopyOf("mfrom_user_ids", r4);
            this.min_chat_ids = Internal.immutableCopyOf("min_chat_ids", r5);
            this.mtime_range = r6;
            this.min_team_id = r7;
            this.mwith_user_ids = Internal.immutableCopyOf("mwith_user_ids", r8);
            this.menable_extended_search = r9;
            this.muse_extended_search_v2 = r10;
            this.mchat_infos = Internal.immutableCopyOf("mchat_infos", r11);
            this.msearch_qa_biz_type = Internal.immutableCopyOf("msearch_qa_biz_type", r12);
        }
    }

    public static final class CustomizationFilter extends Message<CustomizationFilter, Builder> {
        public static final ProtoAdapter<CustomizationFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final Map<String, Templates> mtemplates;

        public static final class Builder extends Message.Builder<CustomizationFilter, Builder> {
            public Map<String, Templates> mtemplates;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CustomizationFilter m2893build() {
                return new CustomizationFilter(this.mtemplates, super.buildUnknownFields());
            }

            public Builder() {
                this.mtemplates = Internal.newMutableMap();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2893build();
            }

            public Builder templates(Map<String, Templates> r1) {
                Internal.checkElementsNotNull(r1);
                this.mtemplates = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_CustomizationFilter extends ProtoAdapter<CustomizationFilter> {
            private final ProtoAdapter<Map<String, Templates>> mtemplates;

            public ProtoAdapter_CustomizationFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, CustomizationFilter.class);
                this.mtemplates = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Templates.ADAPTER);
            }

            public CustomizationFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mtemplates.putAll((Map) this.mtemplates.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2893build();
            }

            public int encodedSize(CustomizationFilter r4) {
                return this.mtemplates.encodedSizeWithTag(1, r4.mtemplates) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2894decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CustomizationFilter) r1);
            }

            public void encode(ProtoWriter r4, CustomizationFilter r5) throws IOException {
                this.mtemplates.encodeWithTag(r4, 1, r5.mtemplates);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CustomizationFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomizationFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2892newBuilder() {
            Builder r0 = new Builder();
            r0.mtemplates = Internal.copyOf("mtemplates", this.mtemplates);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CustomizationFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2892newBuilder();
        }

        public CustomizationFilter(Map<String, Templates> r2) {
            this(r2, ByteString.EMPTY);
        }

        public CustomizationFilter(Map<String, Templates> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mtemplates = Internal.immutableCopyOf("mtemplates", r2);
        }
    }

    public static final class DepartmentFilter extends Message<DepartmentFilter, Builder> {
        public static final ProtoAdapter<DepartmentFilter> ADAPTER = null;
        public static final Boolean DEFAULT_ADDABLE_AS_USER = null;
        public static final Boolean DEFAULT_B2B_ENABLED = null;
        private static final long serialVersionUID = 0;
        public final Boolean maddable_as_user;
        public final Boolean mb2b_enabled;

        public static final class Builder extends Message.Builder<DepartmentFilter, Builder> {
            public Boolean maddable_as_user;
            public Boolean mb2b_enabled;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DepartmentFilter m2896build() {
                return new DepartmentFilter(this.maddable_as_user, this.mb2b_enabled, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2896build();
            }

            public Builder addable_as_user(Boolean r1) {
                this.maddable_as_user = r1;
                return this;
            }

            public Builder b2b_enabled(Boolean r1) {
                this.mb2b_enabled = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DepartmentFilter extends ProtoAdapter<DepartmentFilter> {
            public ProtoAdapter_DepartmentFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, DepartmentFilter.class);
            }

            public DepartmentFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.maddable_as_user = r1;
                r0.mb2b_enabled = r1;
                long r2 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.maddable_as_user = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mb2b_enabled = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r2);
                return r0.m2896build();
            }

            public int encodedSize(DepartmentFilter r5) {
                Boolean r0 = r5.maddable_as_user;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r5.mb2b_enabled;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2897decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DepartmentFilter) r1);
            }

            public void encode(ProtoWriter r4, DepartmentFilter r5) throws IOException {
                Boolean r0 = r5.maddable_as_user;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mb2b_enabled;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DepartmentFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DepartmentFilter();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_ADDABLE_AS_USER = r0;
            DEFAULT_B2B_ENABLED = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2895newBuilder() {
            Builder r0 = new Builder();
            r0.maddable_as_user = this.maddable_as_user;
            r0.mb2b_enabled = this.mb2b_enabled;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DepartmentFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2895newBuilder();
        }

        public DepartmentFilter(Boolean r2, Boolean r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public DepartmentFilter(Boolean r2, Boolean r3, ByteString r4) {
            super(ADAPTER, r4);
            this.maddable_as_user = r2;
            this.mb2b_enabled = r3;
        }
    }

    public static final class DocFilter extends Message<DocFilter, Builder> {
        public static final ProtoAdapter<DocFilter> ADAPTER = null;
        public static final Boolean DEFAULT_CROSS_LANGUAGE = null;
        public static final Boolean DEFAULT_ENABLE_EXTENDED_SEARCH = null;
        public static final Long DEFAULT_ENDTIME = null;
        public static final Boolean DEFAULT_ONLYCOMMENT = null;
        public static final Boolean DEFAULT_ONLYTITLE = null;
        public static final Long DEFAULT_OPENTIME = null;
        public static final Boolean DEFAULT_SEARCH_FAVOURITE = null;
        public static final Boolean DEFAULT_USE_EXTENDED_SEARCH_V2 = null;
        public static final FieldOptions FIELD_OPTIONS_MCHAT_IDS = null;
        public static final FieldOptions FIELD_OPTIONS_MCREATOR_IDS = null;
        public static final FieldOptions FIELD_OPTIONS_MFROM_IDS = null;
        public static final FieldOptions FIELD_OPTIONS_MORIGINAL_CREATOR_IDS = null;
        public static final FieldOptions FIELD_OPTIONS_MSHARER_IDS = null;
        private static final long serialVersionUID = 0;
        public final List<String> mchat_ids;
        public final List<ChatInfo> mchat_infos;
        public final TimeRange mcreate_time_range;
        public final List<String> mcreator_ids;
        public final Boolean mcross_language;
        public final Boolean menable_extended_search;
        public final Long mendTime;
        public final List<FileType> mfile_types;
        public final List<String> mfolder_tokens;
        public final List<String> mfrom_ids;
        public final List<String> mobj_ids;
        public final Boolean monlyComment;
        public final Boolean monlyTitle;
        public final Long mopenTime;
        public final List<String> moriginal_creator_ids;
        public final Map<String, SearchSourceIDs> msearchSourceIDs;
        public final Boolean msearch_favourite;
        public final List<String> msharer_ids;
        public final DocSortRuleType msortType;
        public final TimeRange mtime_range;
        public final List<DocType> mtype;
        public final Boolean muse_extended_search_v2;

        public static final class Builder extends Message.Builder<DocFilter, Builder> {
            public List<String> mchat_ids;
            public List<ChatInfo> mchat_infos;
            public TimeRange mcreate_time_range;
            public List<String> mcreator_ids;
            public Boolean mcross_language;
            public Boolean menable_extended_search;
            public Long mendTime;
            public List<FileType> mfile_types;
            public List<String> mfolder_tokens;
            public List<String> mfrom_ids;
            public List<String> mobj_ids;
            public Boolean monlyComment;
            public Boolean monlyTitle;
            public Long mopenTime;
            public List<String> moriginal_creator_ids;
            public Map<String, SearchSourceIDs> msearchSourceIDs;
            public Boolean msearch_favourite;
            public List<String> msharer_ids;
            public DocSortRuleType msortType;
            public TimeRange mtime_range;
            public List<DocType> mtype;
            public Boolean muse_extended_search_v2;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DocFilter m2899build() {
                return new DocFilter(this.mcreator_ids, this.mchat_ids, this.mtype, this.monlyTitle, this.mopenTime, this.mendTime, this.msharer_ids, this.monlyComment, this.msortType, this.mfrom_ids, this.mfile_types, this.mfolder_tokens, this.msearch_favourite, this.mcross_language, this.menable_extended_search, this.muse_extended_search_v2, this.mtime_range, this.mchat_infos, this.msearchSourceIDs, this.mcreate_time_range, this.mobj_ids, this.moriginal_creator_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mcreator_ids = Internal.newMutableList();
                this.mchat_ids = Internal.newMutableList();
                this.mtype = Internal.newMutableList();
                this.msharer_ids = Internal.newMutableList();
                this.mfrom_ids = Internal.newMutableList();
                this.mfile_types = Internal.newMutableList();
                this.mfolder_tokens = Internal.newMutableList();
                this.mchat_infos = Internal.newMutableList();
                this.msearchSourceIDs = Internal.newMutableMap();
                this.mobj_ids = Internal.newMutableList();
                this.moriginal_creator_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2899build();
            }

            public Builder chat_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_ids = r1;
                return this;
            }

            public Builder chat_infos(List<ChatInfo> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_infos = r1;
                return this;
            }

            public Builder create_time_range(TimeRange r1) {
                this.mcreate_time_range = r1;
                return this;
            }

            public Builder creator_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcreator_ids = r1;
                return this;
            }

            public Builder cross_language(Boolean r1) {
                this.mcross_language = r1;
                return this;
            }

            public Builder enable_extended_search(Boolean r1) {
                this.menable_extended_search = r1;
                return this;
            }

            public Builder endTime(Long r1) {
                this.mendTime = r1;
                return this;
            }

            public Builder file_types(List<FileType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfile_types = r1;
                return this;
            }

            public Builder folder_tokens(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfolder_tokens = r1;
                return this;
            }

            public Builder from_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfrom_ids = r1;
                return this;
            }

            public Builder obj_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mobj_ids = r1;
                return this;
            }

            public Builder onlyComment(Boolean r1) {
                this.monlyComment = r1;
                return this;
            }

            public Builder onlyTitle(Boolean r1) {
                this.monlyTitle = r1;
                return this;
            }

            public Builder openTime(Long r1) {
                this.mopenTime = r1;
                return this;
            }

            public Builder original_creator_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.moriginal_creator_ids = r1;
                return this;
            }

            public Builder searchSourceIDs(Map<String, SearchSourceIDs> r1) {
                Internal.checkElementsNotNull(r1);
                this.msearchSourceIDs = r1;
                return this;
            }

            public Builder search_favourite(Boolean r1) {
                this.msearch_favourite = r1;
                return this;
            }

            public Builder sharer_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.msharer_ids = r1;
                return this;
            }

            public Builder sortType(DocSortRuleType r1) {
                this.msortType = r1;
                return this;
            }

            public Builder time_range(TimeRange r1) {
                this.mtime_range = r1;
                return this;
            }

            public Builder type(List<DocType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mtype = r1;
                return this;
            }

            public Builder use_extended_search_v2(Boolean r1) {
                this.muse_extended_search_v2 = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DocFilter extends ProtoAdapter<DocFilter> {
            private final ProtoAdapter<Map<String, SearchSourceIDs>> msearchSourceIDs;

            public ProtoAdapter_DocFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, DocFilter.class);
                this.msearchSourceIDs = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, SearchSourceIDs.ADAPTER);
            }

            public DocFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.monlyTitle = r1;
                r0.mopenTime = 0L;
                r0.mendTime = 0L;
                r0.monlyComment = r1;
                r0.msearch_favourite = r1;
                r0.mcross_language = r1;
                r0.menable_extended_search = r1;
                r0.muse_extended_search_v2 = r1;
                long r2 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L38;
                switch(r3) {
                    case 1: goto L37;
                    case 2: goto L36;
                    case 3: goto L42;
                    case 4: goto L31;
                    case 5: goto L30;
                    case 6: goto L29;
                    case 7: goto L28;
                    case 8: goto L27;
                    case 9: goto L40;
                    case 10: goto L22;
                    case 11: goto L44;
                    case 12: goto L17;
                    case 13: goto L16;
                    case 14: goto L15;
                    case 15: goto L14;
                    case 16: goto L13;
                    case 17: goto L6;
                    case 18: goto L12;
                    case 19: goto L11;
                    case 20: goto L10;
                    case 21: goto L9;
                    case 22: goto L8;
                    case 23: goto L7;
                    default: goto L6;
                };
            L40:
                r0.msortType = (DocSortRuleType) DocSortRuleType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
            L25:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L42:
                r0.mtype.add((DocType) DocType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
            L34:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L44:
                r0.mfile_types.add((FileType) FileType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.moriginal_creator_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L8:
                r0.mobj_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L9:
                r0.mcreate_time_range = (TimeRange) TimeRange.ADAPTER.decode(r9);
                goto L3
            L10:
                r0.msearchSourceIDs.putAll((Map) this.msearchSourceIDs.decode(r9));
                goto L3
            L11:
                r0.mchat_infos.add((ChatInfo) ChatInfo.ADAPTER.decode(r9));
                goto L3
            L12:
                r0.mtime_range = (TimeRange) TimeRange.ADAPTER.decode(r9);
                goto L3
            L13:
                r0.muse_extended_search_v2 = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L14:
                r0.menable_extended_search = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L15:
                r0.mcross_language = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L16:
                r0.msearch_favourite = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L17:
                r0.mfolder_tokens.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L22:
                r0.mfrom_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L27:
                r0.monlyComment = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L28:
                r0.msharer_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L29:
                r0.mendTime = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L30:
                r0.mopenTime = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L31:
                r0.monlyTitle = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L36:
                r0.mchat_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L37:
                r0.mcreator_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L38:
                r9.endMessage(r2);
                return r0.m2899build();
            }

            public int encodedSize(DocFilter r7) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = (r0.asRepeated().encodedSizeWithTag(1, r7.mcreator_ids) + r0.asRepeated().encodedSizeWithTag(2, r7.mchat_ids)) + DocType.ADAPTER.asRepeated().encodedSizeWithTag(3, r7.mtype);
                Boolean r2 = r7.monlyTitle;
                int r3 = 0;
                if (r2 == null) goto L5;
                int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r2);
            L6:
                int r5 = r1 + r4;
                Long r6 = r7.mopenTime;
                if (r6 == null) goto L9;
                int r8 = ProtoAdapter.INT64.encodedSizeWithTag(5, r6);
            L10:
                int r9 = r5 + r8;
                Long r10 = r7.mendTime;
                if (r10 == null) goto L13;
                int r11 = ProtoAdapter.INT64.encodedSizeWithTag(6, r10);
            L14:
                int r12 = (r9 + r11) + r0.asRepeated().encodedSizeWithTag(7, r7.msharer_ids);
                Boolean r13 = r7.monlyComment;
                if (r13 == null) goto L17;
                int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r13);
            L18:
                int r15 = r12 + r14;
                DocSortRuleType r16 = r7.msortType;
                if (r16 == null) goto L21;
                int r17 = DocSortRuleType.ADAPTER.encodedSizeWithTag(9, r16);
            L22:
                int r18 = (((r15 + r17) + r0.asRepeated().encodedSizeWithTag(10, r7.mfrom_ids)) + FileType.ADAPTER.asRepeated().encodedSizeWithTag(11, r7.mfile_types)) + r0.asRepeated().encodedSizeWithTag(12, r7.mfolder_tokens);
                Boolean r19 = r7.msearch_favourite;
                if (r19 == null) goto L25;
                int r20 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r19);
            L26:
                int r21 = r18 + r20;
                Boolean r22 = r7.mcross_language;
                if (r22 == null) goto L29;
                int r23 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r22);
            L30:
                int r24 = r21 + r23;
                Boolean r25 = r7.menable_extended_search;
                if (r25 == null) goto L33;
                int r26 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r25);
            L34:
                int r27 = r24 + r26;
                Boolean r28 = r7.muse_extended_search_v2;
                if (r28 == null) goto L37;
                int r29 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r28);
            L38:
                int r30 = r27 + r29;
                TimeRange r31 = r7.mtime_range;
                if (r31 == null) goto L41;
                int r32 = TimeRange.ADAPTER.encodedSizeWithTag(18, r31);
            L42:
                int r33 = ((r30 + r32) + ChatInfo.ADAPTER.asRepeated().encodedSizeWithTag(19, r7.mchat_infos)) + this.msearchSourceIDs.encodedSizeWithTag(20, r7.msearchSourceIDs);
                TimeRange r34 = r7.mcreate_time_range;
                if (r34 == null) goto L46;
                r3 = TimeRange.ADAPTER.encodedSizeWithTag(21, r34);
            L46:
                return (((r33 + r3) + r0.asRepeated().encodedSizeWithTag(22, r7.mobj_ids)) + r0.asRepeated().encodedSizeWithTag(23, r7.moriginal_creator_ids)) + r7.unknownFields().size();
            L41:
                r32 = 0;
                goto L42
            L37:
                r29 = 0;
                goto L38
            L33:
                r26 = 0;
                goto L34
            L29:
                r23 = 0;
                goto L30
            L25:
                r20 = 0;
                goto L26
            L21:
                r17 = 0;
                goto L22
            L17:
                r14 = 0;
                goto L18
            L13:
                r11 = 0;
                goto L14
            L9:
                r8 = 0;
                goto L10
            L5:
                r4 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2900decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DocFilter) r1);
            }

            public void encode(ProtoWriter r5, DocFilter r6) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.asRepeated().encodeWithTag(r5, 1, r6.mcreator_ids);
                r0.asRepeated().encodeWithTag(r5, 2, r6.mchat_ids);
                DocType.ADAPTER.asRepeated().encodeWithTag(r5, 3, r6.mtype);
                Boolean r1 = r6.monlyTitle;
                if (r1 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r5, 4, r1);
            L5:
                Long r2 = r6.mopenTime;
                if (r2 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r5, 5, r2);
            L8:
                Long r3 = r6.mendTime;
                if (r3 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r5, 6, r3);
            L11:
                r0.asRepeated().encodeWithTag(r5, 7, r6.msharer_ids);
                Boolean r4 = r6.monlyComment;
                if (r4 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r5, 8, r4);
            L14:
                DocSortRuleType r7 = r6.msortType;
                if (r7 == null) goto L17;
                DocSortRuleType.ADAPTER.encodeWithTag(r5, 9, r7);
            L17:
                r0.asRepeated().encodeWithTag(r5, 10, r6.mfrom_ids);
                FileType.ADAPTER.asRepeated().encodeWithTag(r5, 11, r6.mfile_types);
                r0.asRepeated().encodeWithTag(r5, 12, r6.mfolder_tokens);
                Boolean r8 = r6.msearch_favourite;
                if (r8 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r5, 13, r8);
            L20:
                Boolean r9 = r6.mcross_language;
                if (r9 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r5, 14, r9);
            L23:
                Boolean r10 = r6.menable_extended_search;
                if (r10 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r5, 15, r10);
            L26:
                Boolean r11 = r6.muse_extended_search_v2;
                if (r11 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r5, 16, r11);
            L29:
                TimeRange r12 = r6.mtime_range;
                if (r12 == null) goto L32;
                TimeRange.ADAPTER.encodeWithTag(r5, 18, r12);
            L32:
                ChatInfo.ADAPTER.asRepeated().encodeWithTag(r5, 19, r6.mchat_infos);
                this.msearchSourceIDs.encodeWithTag(r5, 20, r6.msearchSourceIDs);
                TimeRange r13 = r6.mcreate_time_range;
                if (r13 == null) goto L35;
                TimeRange.ADAPTER.encodeWithTag(r5, 21, r13);
            L35:
                r0.asRepeated().encodeWithTag(r5, 22, r6.mobj_ids);
                r0.asRepeated().encodeWithTag(r5, 23, r6.moriginal_creator_ids);
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DocFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocFilter();
            FIELD_OPTIONS_MCREATOR_IDS = new FieldOptions.Builder().id("user_id").build();
            FIELD_OPTIONS_MCHAT_IDS = new FieldOptions.Builder().id("chat_id").build();
            FIELD_OPTIONS_MSHARER_IDS = new FieldOptions.Builder().id("user_id").build();
            FIELD_OPTIONS_MFROM_IDS = new FieldOptions.Builder().id("user_id").build();
            FIELD_OPTIONS_MORIGINAL_CREATOR_IDS = new FieldOptions.Builder().id("user_id").build();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_ONLYTITLE = r0;
            DEFAULT_OPENTIME = 0L;
            DEFAULT_ENDTIME = 0L;
            DEFAULT_ONLYCOMMENT = r0;
            DEFAULT_SEARCH_FAVOURITE = r0;
            DEFAULT_CROSS_LANGUAGE = r0;
            DEFAULT_ENABLE_EXTENDED_SEARCH = r0;
            DEFAULT_USE_EXTENDED_SEARCH_V2 = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2898newBuilder() {
            Builder r0 = new Builder();
            r0.mcreator_ids = Internal.copyOf("mcreator_ids", this.mcreator_ids);
            r0.mchat_ids = Internal.copyOf("mchat_ids", this.mchat_ids);
            r0.mtype = Internal.copyOf("mtype", this.mtype);
            r0.monlyTitle = this.monlyTitle;
            r0.mopenTime = this.mopenTime;
            r0.mendTime = this.mendTime;
            r0.msharer_ids = Internal.copyOf("msharer_ids", this.msharer_ids);
            r0.monlyComment = this.monlyComment;
            r0.msortType = this.msortType;
            r0.mfrom_ids = Internal.copyOf("mfrom_ids", this.mfrom_ids);
            r0.mfile_types = Internal.copyOf("mfile_types", this.mfile_types);
            r0.mfolder_tokens = Internal.copyOf("mfolder_tokens", this.mfolder_tokens);
            r0.msearch_favourite = this.msearch_favourite;
            r0.mcross_language = this.mcross_language;
            r0.menable_extended_search = this.menable_extended_search;
            r0.muse_extended_search_v2 = this.muse_extended_search_v2;
            r0.mtime_range = this.mtime_range;
            r0.mchat_infos = Internal.copyOf("mchat_infos", this.mchat_infos);
            r0.msearchSourceIDs = Internal.copyOf("msearchSourceIDs", this.msearchSourceIDs);
            r0.mcreate_time_range = this.mcreate_time_range;
            r0.mobj_ids = Internal.copyOf("mobj_ids", this.mobj_ids);
            r0.moriginal_creator_ids = Internal.copyOf("moriginal_creator_ids", this.moriginal_creator_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DocFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2898newBuilder();
        }

        public DocFilter(List<String> r25, List<String> r26, List<DocType> r27, Boolean r28, Long r29, Long r30, List<String> r31, Boolean r32, DocSortRuleType r33, List<String> r34, List<FileType> r35, List<String> r36, Boolean r37, Boolean r38, Boolean r39, Boolean r40, TimeRange r41, List<ChatInfo> r42, Map<String, SearchSourceIDs> r43, TimeRange r44, List<String> r45, List<String> r46) {
            this(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, ByteString.EMPTY);
        }

        public DocFilter(List<String> r4, List<String> r5, List<DocType> r6, Boolean r7, Long r8, Long r9, List<String> r10, Boolean r11, DocSortRuleType r12, List<String> r13, List<FileType> r14, List<String> r15, Boolean r16, Boolean r17, Boolean r18, Boolean r19, TimeRange r20, List<ChatInfo> r21, Map<String, SearchSourceIDs> r22, TimeRange r23, List<String> r24, List<String> r25, ByteString r26) {
            super(ADAPTER, r26);
            this.mcreator_ids = Internal.immutableCopyOf("mcreator_ids", r4);
            this.mchat_ids = Internal.immutableCopyOf("mchat_ids", r5);
            this.mtype = Internal.immutableCopyOf("mtype", r6);
            this.monlyTitle = r7;
            this.mopenTime = r8;
            this.mendTime = r9;
            this.msharer_ids = Internal.immutableCopyOf("msharer_ids", r10);
            this.monlyComment = r11;
            this.msortType = r12;
            this.mfrom_ids = Internal.immutableCopyOf("mfrom_ids", r13);
            this.mfile_types = Internal.immutableCopyOf("mfile_types", r14);
            this.mfolder_tokens = Internal.immutableCopyOf("mfolder_tokens", r15);
            this.msearch_favourite = r16;
            this.mcross_language = r17;
            this.menable_extended_search = r18;
            this.muse_extended_search_v2 = r19;
            this.mtime_range = r20;
            this.mchat_infos = Internal.immutableCopyOf("mchat_infos", r21);
            this.msearchSourceIDs = Internal.immutableCopyOf("msearchSourceIDs", r22);
            this.mcreate_time_range = r23;
            this.mobj_ids = Internal.immutableCopyOf("mobj_ids", r24);
            this.moriginal_creator_ids = Internal.immutableCopyOf("moriginal_creator_ids", r25);
        }
    }

    public static final class GroupChatFilter extends Message<GroupChatFilter, Builder> {
        public static final ProtoAdapter<GroupChatFilter> ADAPTER = null;
        public static final Boolean DEFAULT_ADDABLE_AS_USER = null;
        public static final Boolean DEFAULT_CLOSE_SEARCH_BY_USER = null;
        public static final Boolean DEFAULT_NEED_FROZEN_CHAT = null;
        public static final Boolean DEFAULT_SEARCH_CRYPTO = null;
        public static final Boolean DEFAULT_SEARCH_SHIELD = null;
        public static final FieldOptions FIELD_OPTIONS_MCHAT_MEMBER_IDS = null;
        public static final FieldOptions FIELD_OPTIONS_MEXCLUDED_CHAT_IDS = null;
        public static final FieldOptions FIELD_OPTIONS_MRECENT_ACTIVE_CHAT_IDS = null;
        private static final long serialVersionUID = 0;
        public final Boolean maddable_as_user;
        public final List<String> mchat_member_ids;
        public final List<Chat.ChatMode> mchat_modes;
        public final Boolean mclose_search_by_user;
        public final List<String> mexcluded_chat_ids;
        public final Boolean mneed_frozen_chat;
        public final List<String> mrecent_active_chat_ids;
        public final Boolean msearch_crypto;
        public final Boolean msearch_shield;
        public final List<SearchType> msearch_types;
        public final GroupSortRuleType msortType;

        public static final class Builder extends Message.Builder<GroupChatFilter, Builder> {
            public Boolean maddable_as_user;
            public List<String> mchat_member_ids;
            public List<Chat.ChatMode> mchat_modes;
            public Boolean mclose_search_by_user;
            public List<String> mexcluded_chat_ids;
            public Boolean mneed_frozen_chat;
            public List<String> mrecent_active_chat_ids;
            public Boolean msearch_crypto;
            public Boolean msearch_shield;
            public List<SearchType> msearch_types;
            public GroupSortRuleType msortType;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public GroupChatFilter m2902build() {
                return new GroupChatFilter(this.msearch_types, this.mchat_member_ids, this.mexcluded_chat_ids, this.msearch_crypto, this.maddable_as_user, this.msortType, this.mrecent_active_chat_ids, this.msearch_shield, this.mclose_search_by_user, this.mneed_frozen_chat, this.mchat_modes, super.buildUnknownFields());
            }

            public Builder() {
                this.msearch_types = Internal.newMutableList();
                this.mchat_member_ids = Internal.newMutableList();
                this.mexcluded_chat_ids = Internal.newMutableList();
                this.mrecent_active_chat_ids = Internal.newMutableList();
                this.mchat_modes = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2902build();
            }

            public Builder addable_as_user(Boolean r1) {
                this.maddable_as_user = r1;
                return this;
            }

            public Builder chat_member_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_member_ids = r1;
                return this;
            }

            public Builder chat_modes(List<Chat.ChatMode> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_modes = r1;
                return this;
            }

            public Builder close_search_by_user(Boolean r1) {
                this.mclose_search_by_user = r1;
                return this;
            }

            public Builder excluded_chat_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mexcluded_chat_ids = r1;
                return this;
            }

            public Builder need_frozen_chat(Boolean r1) {
                this.mneed_frozen_chat = r1;
                return this;
            }

            public Builder recent_active_chat_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mrecent_active_chat_ids = r1;
                return this;
            }

            public Builder search_crypto(Boolean r1) {
                this.msearch_crypto = r1;
                return this;
            }

            public Builder search_shield(Boolean r1) {
                this.msearch_shield = r1;
                return this;
            }

            public Builder search_types(List<SearchType> r1) {
                Internal.checkElementsNotNull(r1);
                this.msearch_types = r1;
                return this;
            }

            public Builder sortType(GroupSortRuleType r1) {
                this.msortType = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_GroupChatFilter extends ProtoAdapter<GroupChatFilter> {
            public ProtoAdapter_GroupChatFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, GroupChatFilter.class);
            }

            public GroupChatFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.msearch_crypto = r1;
                r0.maddable_as_user = r1;
                r0.msearch_shield = r1;
                r0.mclose_search_by_user = r1;
                r0.mneed_frozen_chat = r1;
                long r2 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L24;
                switch(r3) {
                    case 1: goto L23;
                    case 2: goto L22;
                    case 3: goto L21;
                    case 4: goto L20;
                    case 5: goto L19;
                    case 6: goto L28;
                    case 7: goto L14;
                    case 8: goto L13;
                    case 9: goto L12;
                    case 10: goto L11;
                    case 11: goto L26;
                    default: goto L6;
                };
            L26:
                r0.mchat_modes.add((Chat.ChatMode) Chat.ChatMode.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L28:
                r0.msortType = (GroupSortRuleType) GroupSortRuleType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                r0.mneed_frozen_chat = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L12:
                r0.mclose_search_by_user = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L13:
                r0.msearch_shield = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L14:
                r0.mrecent_active_chat_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L19:
                r0.maddable_as_user = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L20:
                r0.msearch_crypto = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L21:
                r0.mexcluded_chat_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L22:
                r0.mchat_member_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L23:
                r0.msearch_types.add((SearchType) SearchType.ADAPTER.decode(r9));
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L24:
                r9.endMessage(r2);
                return r0.m2902build();
            }

            public int encodedSize(GroupChatFilter r7) {
                int r0 = SearchType.ADAPTER.asRepeated().encodedSizeWithTag(1, r7.msearch_types);
                ProtoAdapter r1 = ProtoAdapter.STRING;
                int r2 = (r0 + r1.asRepeated().encodedSizeWithTag(2, r7.mchat_member_ids)) + r1.asRepeated().encodedSizeWithTag(3, r7.mexcluded_chat_ids);
                Boolean r3 = r7.msearch_crypto;
                int r4 = 0;
                if (r3 == null) goto L5;
                int r5 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r3);
            L6:
                int r6 = r2 + r5;
                Boolean r8 = r7.maddable_as_user;
                if (r8 == null) goto L9;
                int r9 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r8);
            L10:
                int r10 = r6 + r9;
                GroupSortRuleType r11 = r7.msortType;
                if (r11 == null) goto L13;
                int r12 = GroupSortRuleType.ADAPTER.encodedSizeWithTag(6, r11);
            L14:
                int r13 = (r10 + r12) + r1.asRepeated().encodedSizeWithTag(7, r7.mrecent_active_chat_ids);
                Boolean r14 = r7.msearch_shield;
                if (r14 == null) goto L17;
                int r15 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r14);
            L18:
                int r16 = r13 + r15;
                Boolean r17 = r7.mclose_search_by_user;
                if (r17 == null) goto L21;
                int r18 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r17);
            L22:
                int r19 = r16 + r18;
                Boolean r20 = r7.mneed_frozen_chat;
                if (r20 == null) goto L26;
                r4 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r20);
            L26:
                return ((r19 + r4) + Chat.ChatMode.ADAPTER.asRepeated().encodedSizeWithTag(11, r7.mchat_modes)) + r7.unknownFields().size();
            L21:
                r18 = 0;
                goto L22
            L17:
                r15 = 0;
                goto L18
            L13:
                r12 = 0;
                goto L14
            L9:
                r9 = 0;
                goto L10
            L5:
                r5 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2903decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((GroupChatFilter) r1);
            }

            public void encode(ProtoWriter r5, GroupChatFilter r6) throws IOException {
                SearchType.ADAPTER.asRepeated().encodeWithTag(r5, 1, r6.msearch_types);
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.asRepeated().encodeWithTag(r5, 2, r6.mchat_member_ids);
                r0.asRepeated().encodeWithTag(r5, 3, r6.mexcluded_chat_ids);
                Boolean r1 = r6.msearch_crypto;
                if (r1 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r5, 4, r1);
            L5:
                Boolean r2 = r6.maddable_as_user;
                if (r2 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r5, 5, r2);
            L8:
                GroupSortRuleType r3 = r6.msortType;
                if (r3 == null) goto L11;
                GroupSortRuleType.ADAPTER.encodeWithTag(r5, 6, r3);
            L11:
                r0.asRepeated().encodeWithTag(r5, 7, r6.mrecent_active_chat_ids);
                Boolean r4 = r6.msearch_shield;
                if (r4 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r5, 8, r4);
            L14:
                Boolean r7 = r6.mclose_search_by_user;
                if (r7 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r5, 9, r7);
            L17:
                Boolean r8 = r6.mneed_frozen_chat;
                if (r8 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r5, 10, r8);
            L20:
                Chat.ChatMode.ADAPTER.asRepeated().encodeWithTag(r5, 11, r6.mchat_modes);
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (GroupChatFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_GroupChatFilter();
            FIELD_OPTIONS_MCHAT_MEMBER_IDS = new FieldOptions.Builder().id("user_id").build();
            FIELD_OPTIONS_MEXCLUDED_CHAT_IDS = new FieldOptions.Builder().id("chat_id").build();
            FIELD_OPTIONS_MRECENT_ACTIVE_CHAT_IDS = new FieldOptions.Builder().id("chat_id").build();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_SEARCH_CRYPTO = r0;
            DEFAULT_ADDABLE_AS_USER = r0;
            DEFAULT_SEARCH_SHIELD = r0;
            DEFAULT_CLOSE_SEARCH_BY_USER = r0;
            DEFAULT_NEED_FROZEN_CHAT = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2901newBuilder() {
            Builder r0 = new Builder();
            r0.msearch_types = Internal.copyOf("msearch_types", this.msearch_types);
            r0.mchat_member_ids = Internal.copyOf("mchat_member_ids", this.mchat_member_ids);
            r0.mexcluded_chat_ids = Internal.copyOf("mexcluded_chat_ids", this.mexcluded_chat_ids);
            r0.msearch_crypto = this.msearch_crypto;
            r0.maddable_as_user = this.maddable_as_user;
            r0.msortType = this.msortType;
            r0.mrecent_active_chat_ids = Internal.copyOf("mrecent_active_chat_ids", this.mrecent_active_chat_ids);
            r0.msearch_shield = this.msearch_shield;
            r0.mclose_search_by_user = this.mclose_search_by_user;
            r0.mneed_frozen_chat = this.mneed_frozen_chat;
            r0.mchat_modes = Internal.copyOf("mchat_modes", this.mchat_modes);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return GroupChatFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2901newBuilder();
        }

        public GroupChatFilter(List<SearchType> r14, List<String> r15, List<String> r16, Boolean r17, Boolean r18, GroupSortRuleType r19, List<String> r20, Boolean r21, Boolean r22, Boolean r23, List<Chat.ChatMode> r24) {
            this(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, ByteString.EMPTY);
        }

        public GroupChatFilter(List<SearchType> r2, List<String> r3, List<String> r4, Boolean r5, Boolean r6, GroupSortRuleType r7, List<String> r8, Boolean r9, Boolean r10, Boolean r11, List<Chat.ChatMode> r12, ByteString r13) {
            super(ADAPTER, r13);
            this.msearch_types = Internal.immutableCopyOf("msearch_types", r2);
            this.mchat_member_ids = Internal.immutableCopyOf("mchat_member_ids", r3);
            this.mexcluded_chat_ids = Internal.immutableCopyOf("mexcluded_chat_ids", r4);
            this.msearch_crypto = r5;
            this.maddable_as_user = r6;
            this.msortType = r7;
            this.mrecent_active_chat_ids = Internal.immutableCopyOf("mrecent_active_chat_ids", r8);
            this.msearch_shield = r9;
            this.mclose_search_by_user = r10;
            this.mneed_frozen_chat = r11;
            this.mchat_modes = Internal.immutableCopyOf("mchat_modes", r12);
        }
    }

    public static final class KnowledgeQAFilter extends Message<KnowledgeQAFilter, Builder> {
        public static final ProtoAdapter<KnowledgeQAFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<SceneInfo> mscene_info;

        public static final class Builder extends Message.Builder<KnowledgeQAFilter, Builder> {
            public List<SceneInfo> mscene_info;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public KnowledgeQAFilter m2905build() {
                return new KnowledgeQAFilter(this.mscene_info, super.buildUnknownFields());
            }

            public Builder() {
                this.mscene_info = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2905build();
            }

            public Builder scene_info(List<SceneInfo> r1) {
                Internal.checkElementsNotNull(r1);
                this.mscene_info = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_KnowledgeQAFilter extends ProtoAdapter<KnowledgeQAFilter> {
            public ProtoAdapter_KnowledgeQAFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, KnowledgeQAFilter.class);
            }

            public KnowledgeQAFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mscene_info.add((SceneInfo) SceneInfo.ADAPTER.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2905build();
            }

            public int encodedSize(KnowledgeQAFilter r4) {
                return SceneInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mscene_info) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2906decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((KnowledgeQAFilter) r1);
            }

            public void encode(ProtoWriter r4, KnowledgeQAFilter r5) throws IOException {
                SceneInfo.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mscene_info);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (KnowledgeQAFilter) r2);
            }
        }

        public static final class SceneInfo extends Message<SceneInfo, Builder> {
            public static final ProtoAdapter<SceneInfo> ADAPTER = null;
            public static final Integer DEFAULT_ASK_SCENE = null;
            public static final String DEFAULT_OBJECT_ID = "";
            private static final long serialVersionUID = 0;
            public final Integer mask_scene;
            public final String mobject_id;

            public static final class Builder extends Message.Builder<SceneInfo, Builder> {
                public Integer mask_scene;
                public String mobject_id;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public SceneInfo m2908build() {
                    return new SceneInfo(this.mask_scene, this.mobject_id, super.buildUnknownFields());
                }

                public Builder() {
                }

                public /* bridge */ /* synthetic */ Message build() {
                    return m2908build();
                }

                public Builder ask_scene(Integer r1) {
                    this.mask_scene = r1;
                    return this;
                }

                public Builder object_id(String r1) {
                    this.mobject_id = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_SceneInfo extends ProtoAdapter<SceneInfo> {
                public ProtoAdapter_SceneInfo() {
                    super(FieldEncoding.LENGTH_DELIMITED, SceneInfo.class);
                }

                public SceneInfo decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.mask_scene = 0;
                    r0.mobject_id = "";
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L12;
                    if (r3 != 1) goto L8;
                    r0.mask_scene = (Integer) ProtoAdapter.INT32.decode(r7);
                    goto L3
                L8:
                    if (r3 != 2) goto L9;
                    r0.mobject_id = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L9:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L12:
                    r7.endMessage(r1);
                    return r0.m2908build();
                }

                public int encodedSize(SceneInfo r5) {
                    Integer r0 = r5.mask_scene;
                    int r1 = 0;
                    if (r0 == null) goto L5;
                    int r2 = ProtoAdapter.INT32.encodedSizeWithTag(1, r0);
                L6:
                    String r3 = r5.mobject_id;
                    if (r3 == null) goto L10;
                    r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
                L10:
                    return (r2 + r1) + r5.unknownFields().size();
                L5:
                    r2 = 0;
                    goto L6
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m2909decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((SceneInfo) r1);
                }

                public void encode(ProtoWriter r4, SceneInfo r5) throws IOException {
                    Integer r0 = r5.mask_scene;
                    if (r0 == null) goto L5;
                    ProtoAdapter.INT32.encodeWithTag(r4, 1, r0);
                L5:
                    String r1 = r5.mobject_id;
                    if (r1 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
                L8:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (SceneInfo) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_SceneInfo();
                DEFAULT_ASK_SCENE = 0;
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m2907newBuilder() {
                Builder r0 = new Builder();
                r0.mask_scene = this.mask_scene;
                r0.mobject_id = this.mobject_id;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return SceneInfo.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return m2907newBuilder();
            }

            public SceneInfo(Integer r2, String r3) {
                this(r2, r3, ByteString.EMPTY);
            }

            public SceneInfo(Integer r2, String r3, ByteString r4) {
                super(ADAPTER, r4);
                this.mask_scene = r2;
                this.mobject_id = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_KnowledgeQAFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2904newBuilder() {
            Builder r0 = new Builder();
            r0.mscene_info = Internal.copyOf("mscene_info", this.mscene_info);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return KnowledgeQAFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2904newBuilder();
        }

        public KnowledgeQAFilter(List<SceneInfo> r2) {
            this(r2, ByteString.EMPTY);
        }

        public KnowledgeQAFilter(List<SceneInfo> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mscene_info = Internal.immutableCopyOf("mscene_info", r2);
        }
    }

    public static final class MessageFileFilter extends Message<MessageFileFilter, Builder> {
        public static final ProtoAdapter<MessageFileFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mchat_ids;
        public final List<String> mcreator_ids;
        public final TimeRange mtime_range;

        public static final class Builder extends Message.Builder<MessageFileFilter, Builder> {
            public List<String> mchat_ids;
            public List<String> mcreator_ids;
            public TimeRange mtime_range;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MessageFileFilter m2911build() {
                return new MessageFileFilter(this.mtime_range, this.mcreator_ids, this.mchat_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mcreator_ids = Internal.newMutableList();
                this.mchat_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2911build();
            }

            public Builder chat_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_ids = r1;
                return this;
            }

            public Builder creator_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcreator_ids = r1;
                return this;
            }

            public Builder time_range(TimeRange r1) {
                this.mtime_range = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MessageFileFilter extends ProtoAdapter<MessageFileFilter> {
            public ProtoAdapter_MessageFileFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageFileFilter.class);
            }

            public MessageFileFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mtime_range = (TimeRange) TimeRange.ADAPTER.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mcreator_ids.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mchat_ids.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m2911build();
            }

            public int encodedSize(MessageFileFilter r6) {
                TimeRange r0 = r6.mtime_range;
                if (r0 == null) goto L5;
                int r1 = TimeRange.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                ProtoAdapter r2 = ProtoAdapter.STRING;
                return ((r1 + r2.asRepeated().encodedSizeWithTag(2, r6.mcreator_ids)) + r2.asRepeated().encodedSizeWithTag(3, r6.mchat_ids)) + r6.unknownFields().size();
            L5:
                r1 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2912decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MessageFileFilter) r1);
            }

            public void encode(ProtoWriter r5, MessageFileFilter r6) throws IOException {
                TimeRange r0 = r6.mtime_range;
                if (r0 == null) goto L5;
                TimeRange.ADAPTER.encodeWithTag(r5, 1, r0);
            L5:
                ProtoAdapter r1 = ProtoAdapter.STRING;
                r1.asRepeated().encodeWithTag(r5, 2, r6.mcreator_ids);
                r1.asRepeated().encodeWithTag(r5, 3, r6.mchat_ids);
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MessageFileFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageFileFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2910newBuilder() {
            Builder r0 = new Builder();
            r0.mtime_range = this.mtime_range;
            r0.mcreator_ids = Internal.copyOf("mcreator_ids", this.mcreator_ids);
            r0.mchat_ids = Internal.copyOf("mchat_ids", this.mchat_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MessageFileFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2910newBuilder();
        }

        public MessageFileFilter(TimeRange r2, List<String> r3, List<String> r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public MessageFileFilter(TimeRange r2, List<String> r3, List<String> r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mtime_range = r2;
            this.mcreator_ids = Internal.immutableCopyOf("mcreator_ids", r3);
            this.mchat_ids = Internal.immutableCopyOf("mchat_ids", r4);
        }
    }

    public static final class MessageFilter extends Message<MessageFilter, Builder> {
        public static final ProtoAdapter<MessageFilter> ADAPTER = null;
        public static final Boolean DEFAULT_IS_AT_ALL = null;
        public static final String DEFAULT_LAST_MESSAGE_ID = "";
        private static final long serialVersionUID = 0;
        public final List<String> mchat_ids;
        public final ChatType mchat_type;
        public final List<String> mcreator_ids;
        public final List<FromType> mexcluded_from_types;
        public final List<FromType> mfrom_types;
        public final List<String> minclude_at_user_ids;
        public final List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> minclude_attachment_types;
        public final Boolean mis_at_all;
        public final String mlast_message_id;
        public final List<com.ss.android.lark.pb.entities.Message.Type> mmessage_types;
        public final List<String> mreceiver_ids;
        public final List<SearchType> msearch_types;
        public final TimeRange mtime_range;
        public final List<String> mwith_user_ids;

        public static final class Builder extends Message.Builder<MessageFilter, Builder> {
            public List<String> mchat_ids;
            public ChatType mchat_type;
            public List<String> mcreator_ids;
            public List<FromType> mexcluded_from_types;
            public List<FromType> mfrom_types;
            public List<String> minclude_at_user_ids;
            public List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> minclude_attachment_types;
            public Boolean mis_at_all;
            public String mlast_message_id;
            public List<com.ss.android.lark.pb.entities.Message.Type> mmessage_types;
            public List<String> mreceiver_ids;
            public List<SearchType> msearch_types;
            public TimeRange mtime_range;
            public List<String> mwith_user_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MessageFilter m2914build() {
                return new MessageFilter(this.mtime_range, this.mcreator_ids, this.mchat_ids, this.msearch_types, this.mmessage_types, this.minclude_at_user_ids, this.mfrom_types, this.mexcluded_from_types, this.mreceiver_ids, this.mchat_type, this.mwith_user_ids, this.minclude_attachment_types, this.mis_at_all, this.mlast_message_id, super.buildUnknownFields());
            }

            public Builder() {
                this.mcreator_ids = Internal.newMutableList();
                this.mchat_ids = Internal.newMutableList();
                this.msearch_types = Internal.newMutableList();
                this.mmessage_types = Internal.newMutableList();
                this.minclude_at_user_ids = Internal.newMutableList();
                this.mfrom_types = Internal.newMutableList();
                this.mexcluded_from_types = Internal.newMutableList();
                this.mreceiver_ids = Internal.newMutableList();
                this.mwith_user_ids = Internal.newMutableList();
                this.minclude_attachment_types = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2914build();
            }

            public Builder chat_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_ids = r1;
                return this;
            }

            public Builder chat_type(ChatType r1) {
                this.mchat_type = r1;
                return this;
            }

            public Builder creator_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcreator_ids = r1;
                return this;
            }

            public Builder excluded_from_types(List<FromType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mexcluded_from_types = r1;
                return this;
            }

            public Builder from_types(List<FromType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfrom_types = r1;
                return this;
            }

            public Builder include_at_user_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.minclude_at_user_ids = r1;
                return this;
            }

            public Builder include_attachment_types(List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> r1) {
                Internal.checkElementsNotNull(r1);
                this.minclude_attachment_types = r1;
                return this;
            }

            public Builder is_at_all(Boolean r1) {
                this.mis_at_all = r1;
                return this;
            }

            public Builder last_message_id(String r1) {
                this.mlast_message_id = r1;
                return this;
            }

            public Builder message_types(List<com.ss.android.lark.pb.entities.Message.Type> r1) {
                Internal.checkElementsNotNull(r1);
                this.mmessage_types = r1;
                return this;
            }

            public Builder receiver_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mreceiver_ids = r1;
                return this;
            }

            public Builder search_types(List<SearchType> r1) {
                Internal.checkElementsNotNull(r1);
                this.msearch_types = r1;
                return this;
            }

            public Builder time_range(TimeRange r1) {
                this.mtime_range = r1;
                return this;
            }

            public Builder with_user_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mwith_user_ids = r1;
                return this;
            }
        }

        public static final enum ChatType extends Enum<ChatType> implements WireEnum {
            private static final /* synthetic */ ChatType[] $VALUES = null;
            public static final ProtoAdapter<ChatType> ADAPTER = null;
            public static final ChatType GROUP_CHAT = null;
            public static final ChatType P2P_CHAT = null;
            private final int value;

            static {
                ChatType r0 = new ChatType("GROUP_CHAT", 0, 1);
                GROUP_CHAT = r0;
                ChatType r1 = new ChatType("P2P_CHAT", 1, 2);
                P2P_CHAT = r1;
                $VALUES = new ChatType[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(ChatType.class);
            }

            public static ChatType[] values() {
                return (ChatType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static ChatType fromValue(int r1) {
                if (r1 == 1) goto L11;
                if (r1 == 2) goto L9;
                return null;
            L9:
                return P2P_CHAT;
            L11:
                return GROUP_CHAT;
            }

            public static ChatType valueOf(String r1) {
                return (ChatType) a.a(ChatType.class, r1);
            }

            private ChatType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final enum FromType extends Enum<FromType> implements WireEnum {
            private static final /* synthetic */ FromType[] $VALUES = null;
            public static final ProtoAdapter<FromType> ADAPTER = null;
            public static final FromType BOT = null;
            public static final FromType DOUBAO = null;
            public static final FromType USER = null;
            private final int value;

            static {
                FromType r0 = new FromType("BOT", 0, 1);
                BOT = r0;
                FromType r1 = new FromType("USER", 1, 2);
                USER = r1;
                FromType r4 = new FromType("DOUBAO", 2, 3);
                DOUBAO = r4;
                $VALUES = new FromType[]{r0, r1, r4};
                ADAPTER = ProtoAdapter.newEnumAdapter(FromType.class);
            }

            public static FromType[] values() {
                return (FromType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static FromType fromValue(int r1) {
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L13;
                if (r1 == 3) goto L11;
                return null;
            L11:
                return DOUBAO;
            L13:
                return USER;
            L15:
                return BOT;
            }

            public static FromType valueOf(String r1) {
                return (FromType) a.a(FromType.class, r1);
            }

            private FromType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_MessageFilter extends ProtoAdapter<MessageFilter> {
            public ProtoAdapter_MessageFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, MessageFilter.class);
            }

            public MessageFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mis_at_all = Boolean.FALSE;
                r0.mlast_message_id = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L39;
                switch(r3) {
                    case 1: goto L38;
                    case 2: goto L37;
                    case 3: goto L36;
                    case 4: goto L51;
                    case 5: goto L43;
                    case 6: goto L27;
                    case 7: goto L47;
                    case 8: goto L45;
                    case 9: goto L18;
                    case 10: goto L49;
                    case 11: goto L13;
                    case 12: goto L6;
                    case 13: goto L41;
                    case 14: goto L8;
                    case 15: goto L7;
                    default: goto L6;
                };
            L41:
                r0.minclude_attachment_types.add((com.ss.android.lark.pb.entities.Message.MessageAttachmentType) com.ss.android.lark.pb.entities.Message.MessageAttachmentType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
            L11:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L43:
                r0.mmessage_types.add((com.ss.android.lark.pb.entities.Message.Type) com.ss.android.lark.pb.entities.Message.Type.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L30
            L30:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L45:
                r0.mexcluded_from_types.add((FromType) FromType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L47:
                r0.mfrom_types.add((FromType) FromType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
            L25:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L49:
                r0.mchat_type = (ChatType) ChatType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L51:
                r0.msearch_types.add((SearchType) SearchType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
            L34:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mlast_message_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                r0.mis_at_all = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L13:
                r0.mwith_user_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L18:
                r0.mreceiver_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L27:
                r0.minclude_at_user_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L36:
                r0.mchat_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L37:
                r0.mcreator_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L38:
                r0.mtime_range = (TimeRange) TimeRange.ADAPTER.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L39:
                r9.endMessage(r1);
                return r0.m2914build();
            }

            public int encodedSize(MessageFilter r8) {
                TimeRange r0 = r8.mtime_range;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = TimeRange.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                ProtoAdapter r3 = ProtoAdapter.STRING;
                int r4 = ((((r2 + r3.asRepeated().encodedSizeWithTag(2, r8.mcreator_ids)) + r3.asRepeated().encodedSizeWithTag(3, r8.mchat_ids)) + SearchType.ADAPTER.asRepeated().encodedSizeWithTag(4, r8.msearch_types)) + com.ss.android.lark.pb.entities.Message.Type.ADAPTER.asRepeated().encodedSizeWithTag(5, r8.mmessage_types)) + r3.asRepeated().encodedSizeWithTag(6, r8.minclude_at_user_ids);
                ProtoAdapter<FromType> r5 = FromType.ADAPTER;
                int r6 = ((r4 + r5.asRepeated().encodedSizeWithTag(7, r8.mfrom_types)) + r5.asRepeated().encodedSizeWithTag(8, r8.mexcluded_from_types)) + r3.asRepeated().encodedSizeWithTag(9, r8.mreceiver_ids);
                ChatType r7 = r8.mchat_type;
                if (r7 == null) goto L9;
                int r9 = ChatType.ADAPTER.encodedSizeWithTag(10, r7);
            L10:
                int r10 = ((r6 + r9) + r3.asRepeated().encodedSizeWithTag(11, r8.mwith_user_ids)) + com.ss.android.lark.pb.entities.Message.MessageAttachmentType.ADAPTER.asRepeated().encodedSizeWithTag(13, r8.minclude_attachment_types);
                Boolean r11 = r8.mis_at_all;
                if (r11 == null) goto L13;
                int r12 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r11);
            L14:
                int r13 = r10 + r12;
                String r14 = r8.mlast_message_id;
                if (r14 == null) goto L18;
                r1 = r3.encodedSizeWithTag(15, r14);
            L18:
                return (r13 + r1) + r8.unknownFields().size();
            L13:
                r12 = 0;
                goto L14
            L9:
                r9 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2915decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MessageFilter) r1);
            }

            public void encode(ProtoWriter r6, MessageFilter r7) throws IOException {
                TimeRange r0 = r7.mtime_range;
                if (r0 == null) goto L5;
                TimeRange.ADAPTER.encodeWithTag(r6, 1, r0);
            L5:
                ProtoAdapter r1 = ProtoAdapter.STRING;
                r1.asRepeated().encodeWithTag(r6, 2, r7.mcreator_ids);
                r1.asRepeated().encodeWithTag(r6, 3, r7.mchat_ids);
                SearchType.ADAPTER.asRepeated().encodeWithTag(r6, 4, r7.msearch_types);
                com.ss.android.lark.pb.entities.Message.Type.ADAPTER.asRepeated().encodeWithTag(r6, 5, r7.mmessage_types);
                r1.asRepeated().encodeWithTag(r6, 6, r7.minclude_at_user_ids);
                ProtoAdapter<FromType> r2 = FromType.ADAPTER;
                r2.asRepeated().encodeWithTag(r6, 7, r7.mfrom_types);
                r2.asRepeated().encodeWithTag(r6, 8, r7.mexcluded_from_types);
                r1.asRepeated().encodeWithTag(r6, 9, r7.mreceiver_ids);
                ChatType r3 = r7.mchat_type;
                if (r3 == null) goto L8;
                ChatType.ADAPTER.encodeWithTag(r6, 10, r3);
            L8:
                r1.asRepeated().encodeWithTag(r6, 11, r7.mwith_user_ids);
                com.ss.android.lark.pb.entities.Message.MessageAttachmentType.ADAPTER.asRepeated().encodeWithTag(r6, 13, r7.minclude_attachment_types);
                Boolean r4 = r7.mis_at_all;
                if (r4 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r6, 14, r4);
            L11:
                String r5 = r7.mlast_message_id;
                if (r5 == null) goto L14;
                r1.encodeWithTag(r6, 15, r5);
            L14:
                r6.writeBytes(r7.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MessageFilter) r2);
            }
        }

        public static final enum SearchType extends Enum<SearchType> implements WireEnum {
            private static final /* synthetic */ SearchType[] $VALUES = null;
            public static final ProtoAdapter<SearchType> ADAPTER = null;
            public static final SearchType PIN = null;
            public static final SearchType UNKNOWN = null;
            private final int value;

            static {
                SearchType r0 = new SearchType("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                SearchType r1 = new SearchType("PIN", 1, 1);
                PIN = r1;
                $VALUES = new SearchType[]{r0, r1};
                ADAPTER = ProtoAdapter.newEnumAdapter(SearchType.class);
            }

            public static SearchType[] values() {
                return (SearchType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static SearchType fromValue(int r1) {
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L8;
                return null;
            L8:
                return PIN;
            L10:
                return UNKNOWN;
            }

            public static SearchType valueOf(String r1) {
                return (SearchType) a.a(SearchType.class, r1);
            }

            private SearchType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MessageFilter();
            DEFAULT_IS_AT_ALL = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2913newBuilder() {
            Builder r0 = new Builder();
            r0.mtime_range = this.mtime_range;
            r0.mcreator_ids = Internal.copyOf("mcreator_ids", this.mcreator_ids);
            r0.mchat_ids = Internal.copyOf("mchat_ids", this.mchat_ids);
            r0.msearch_types = Internal.copyOf("msearch_types", this.msearch_types);
            r0.mmessage_types = Internal.copyOf("mmessage_types", this.mmessage_types);
            r0.minclude_at_user_ids = Internal.copyOf("minclude_at_user_ids", this.minclude_at_user_ids);
            r0.mfrom_types = Internal.copyOf("mfrom_types", this.mfrom_types);
            r0.mexcluded_from_types = Internal.copyOf("mexcluded_from_types", this.mexcluded_from_types);
            r0.mreceiver_ids = Internal.copyOf("mreceiver_ids", this.mreceiver_ids);
            r0.mchat_type = this.mchat_type;
            r0.mwith_user_ids = Internal.copyOf("mwith_user_ids", this.mwith_user_ids);
            r0.minclude_attachment_types = Internal.copyOf("minclude_attachment_types", this.minclude_attachment_types);
            r0.mis_at_all = this.mis_at_all;
            r0.mlast_message_id = this.mlast_message_id;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MessageFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2913newBuilder();
        }

        public MessageFilter(TimeRange r17, List<String> r18, List<String> r19, List<SearchType> r20, List<com.ss.android.lark.pb.entities.Message.Type> r21, List<String> r22, List<FromType> r23, List<FromType> r24, List<String> r25, ChatType r26, List<String> r27, List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> r28, Boolean r29, String r30) {
            this(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, ByteString.EMPTY);
        }

        public MessageFilter(TimeRange r4, List<String> r5, List<String> r6, List<SearchType> r7, List<com.ss.android.lark.pb.entities.Message.Type> r8, List<String> r9, List<FromType> r10, List<FromType> r11, List<String> r12, ChatType r13, List<String> r14, List<com.ss.android.lark.pb.entities.Message.MessageAttachmentType> r15, Boolean r16, String r17, ByteString r18) {
            super(ADAPTER, r18);
            this.mtime_range = r4;
            this.mcreator_ids = Internal.immutableCopyOf("mcreator_ids", r5);
            this.mchat_ids = Internal.immutableCopyOf("mchat_ids", r6);
            this.msearch_types = Internal.immutableCopyOf("msearch_types", r7);
            this.mmessage_types = Internal.immutableCopyOf("mmessage_types", r8);
            this.minclude_at_user_ids = Internal.immutableCopyOf("minclude_at_user_ids", r9);
            this.mfrom_types = Internal.immutableCopyOf("mfrom_types", r10);
            this.mexcluded_from_types = Internal.immutableCopyOf("mexcluded_from_types", r11);
            this.mreceiver_ids = Internal.immutableCopyOf("mreceiver_ids", r12);
            this.mchat_type = r13;
            this.mwith_user_ids = Internal.immutableCopyOf("mwith_user_ids", r14);
            this.minclude_attachment_types = Internal.immutableCopyOf("minclude_attachment_types", r15);
            this.mis_at_all = r16;
            this.mlast_message_id = r17;
        }
    }

    public static final class MyAIFilter extends Message<MyAIFilter, Builder> {
        public static final ProtoAdapter<MyAIFilter> ADAPTER = null;
        public static final Boolean DEFAULT_MUST_BE_ON_BOARD = null;
        public static final Boolean DEFAULT_MUST_HAVE_CHAT = null;
        private static final long serialVersionUID = 0;
        public final Boolean mmust_be_on_board;
        public final Boolean mmust_have_chat;

        public static final class Builder extends Message.Builder<MyAIFilter, Builder> {
            public Boolean mmust_be_on_board;
            public Boolean mmust_have_chat;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MyAIFilter m2917build() {
                return new MyAIFilter(this.mmust_have_chat, this.mmust_be_on_board, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2917build();
            }

            public Builder must_be_on_board(Boolean r1) {
                this.mmust_be_on_board = r1;
                return this;
            }

            public Builder must_have_chat(Boolean r1) {
                this.mmust_have_chat = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_MyAIFilter extends ProtoAdapter<MyAIFilter> {
            public ProtoAdapter_MyAIFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, MyAIFilter.class);
            }

            public MyAIFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.mmust_have_chat = r1;
                r0.mmust_be_on_board = r1;
                long r2 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mmust_have_chat = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mmust_be_on_board = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r2);
                return r0.m2917build();
            }

            public int encodedSize(MyAIFilter r5) {
                Boolean r0 = r5.mmust_have_chat;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r5.mmust_be_on_board;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2918decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MyAIFilter) r1);
            }

            public void encode(ProtoWriter r4, MyAIFilter r5) throws IOException {
                Boolean r0 = r5.mmust_have_chat;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mmust_be_on_board;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MyAIFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MyAIFilter();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_MUST_HAVE_CHAT = r0;
            DEFAULT_MUST_BE_ON_BOARD = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2916newBuilder() {
            Builder r0 = new Builder();
            r0.mmust_have_chat = this.mmust_have_chat;
            r0.mmust_be_on_board = this.mmust_be_on_board;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MyAIFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2916newBuilder();
        }

        public MyAIFilter(Boolean r2, Boolean r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public MyAIFilter(Boolean r2, Boolean r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mmust_have_chat = r2;
            this.mmust_be_on_board = r3;
        }
    }

    public static final class NewUserGroupFilter extends Message<NewUserGroupFilter, Builder> {
        public static final ProtoAdapter<NewUserGroupFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Namespace> mnamespaces;
        public final List<UserGroupType> muser_group_types;

        public static final class Builder extends Message.Builder<NewUserGroupFilter, Builder> {
            public List<Namespace> mnamespaces;
            public List<UserGroupType> muser_group_types;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public NewUserGroupFilter m2920build() {
                return new NewUserGroupFilter(this.muser_group_types, this.mnamespaces, super.buildUnknownFields());
            }

            public Builder() {
                this.muser_group_types = Internal.newMutableList();
                this.mnamespaces = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2920build();
            }

            public Builder namespaces(List<Namespace> r1) {
                Internal.checkElementsNotNull(r1);
                this.mnamespaces = r1;
                return this;
            }

            public Builder user_group_types(List<UserGroupType> r1) {
                Internal.checkElementsNotNull(r1);
                this.muser_group_types = r1;
                return this;
            }
        }

        public static final class Namespace extends Message<Namespace, Builder> {
            public static final ProtoAdapter<Namespace> ADAPTER = null;
            public static final String DEFAULT_NAME = "";
            private static final long serialVersionUID = 0;
            public final String mname;
            public final List<UserGroupSceneType> mvisibility_types;

            public static final class Builder extends Message.Builder<Namespace, Builder> {
                public String mname;
                public List<UserGroupSceneType> mvisibility_types;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public Namespace m2922build() {
                    return new Namespace(this.mname, this.mvisibility_types, super.buildUnknownFields());
                }

                public Builder() {
                    this.mvisibility_types = Internal.newMutableList();
                }

                public /* bridge */ /* synthetic */ Message build() {
                    return m2922build();
                }

                public Builder name(String r1) {
                    this.mname = r1;
                    return this;
                }

                public Builder visibility_types(List<UserGroupSceneType> r1) {
                    Internal.checkElementsNotNull(r1);
                    this.mvisibility_types = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_Namespace extends ProtoAdapter<Namespace> {
                public ProtoAdapter_Namespace() {
                    super(FieldEncoding.LENGTH_DELIMITED, Namespace.class);
                }

                public Namespace decode(ProtoReader r9) throws IOException {
                    Builder r0 = new Builder();
                    r0.mname = "";
                    long r1 = r9.beginMessage();
                L3:
                    int r3 = r9.nextTag();
                    if (r3 == (-1)) goto L15;
                    if (r3 != 1) goto L8;
                    r0.mname = (String) ProtoAdapter.STRING.decode(r9);
                    goto L3
                L8:
                    if (r3 != 2) goto L9;
                    r0.mvisibility_types.add((UserGroupSceneType) UserGroupSceneType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
                L12:
                    e = move-exception;
                    r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                    goto L3
                L9:
                    FieldEncoding r4 = r9.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                    goto L3
                L15:
                    r9.endMessage(r1);
                    return r0.m2922build();
                }

                public int encodedSize(Namespace r5) {
                    String r0 = r5.mname;
                    if (r0 == null) goto L5;
                    int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
                L7:
                    return (r1 + UserGroupSceneType.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mvisibility_types)) + r5.unknownFields().size();
                L5:
                    r1 = 0;
                    goto L7
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m2923decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((Namespace) r1);
                }

                public void encode(ProtoWriter r4, Namespace r5) throws IOException {
                    String r0 = r5.mname;
                    if (r0 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
                L5:
                    UserGroupSceneType.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mvisibility_types);
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (Namespace) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Namespace();
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m2921newBuilder() {
                Builder r0 = new Builder();
                r0.mname = this.mname;
                r0.mvisibility_types = Internal.copyOf("mvisibility_types", this.mvisibility_types);
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return Namespace.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return m2921newBuilder();
            }

            public Namespace(String r2, List<UserGroupSceneType> r3) {
                this(r2, r3, ByteString.EMPTY);
            }

            public Namespace(String r2, List<UserGroupSceneType> r3, ByteString r4) {
                super(ADAPTER, r4);
                this.mname = r2;
                this.mvisibility_types = Internal.immutableCopyOf("mvisibility_types", r3);
            }
        }

        public static final class ProtoAdapter_NewUserGroupFilter extends ProtoAdapter<NewUserGroupFilter> {
            public ProtoAdapter_NewUserGroupFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, NewUserGroupFilter.class);
            }

            public NewUserGroupFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.muser_group_types.add((UserGroupType) UserGroupType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mnamespaces.add((Namespace) Namespace.ADAPTER.decode(r9));
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L15:
                r9.endMessage(r1);
                return r0.m2920build();
            }

            public int encodedSize(NewUserGroupFilter r5) {
                return (UserGroupType.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.muser_group_types) + Namespace.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mnamespaces)) + r5.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2924decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((NewUserGroupFilter) r1);
            }

            public void encode(ProtoWriter r4, NewUserGroupFilter r5) throws IOException {
                UserGroupType.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.muser_group_types);
                Namespace.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mnamespaces);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (NewUserGroupFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_NewUserGroupFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2919newBuilder() {
            Builder r0 = new Builder();
            r0.muser_group_types = Internal.copyOf("muser_group_types", this.muser_group_types);
            r0.mnamespaces = Internal.copyOf("mnamespaces", this.mnamespaces);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return NewUserGroupFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2919newBuilder();
        }

        public NewUserGroupFilter(List<UserGroupType> r2, List<Namespace> r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public NewUserGroupFilter(List<UserGroupType> r2, List<Namespace> r3, ByteString r4) {
            super(ADAPTER, r4);
            this.muser_group_types = Internal.immutableCopyOf("muser_group_types", r2);
            this.mnamespaces = Internal.immutableCopyOf("mnamespaces", r3);
        }
    }

    public static final class PhoenixFilter extends Message<PhoenixFilter, Builder> {
        public static final ProtoAdapter<PhoenixFilter> ADAPTER = null;
        public static final Boolean DEFAULT_ONLYTITLE = null;
        public static final Boolean DEFAULT_ONLY_COMMENT = null;
        public static final Long DEFAULT_OPENENDTIME = null;
        public static final Long DEFAULT_OPENSTARTTIME = null;
        public static final Boolean DEFAULT_SEARCH_FAVOURITE = null;
        private static final long serialVersionUID = 0;
        public final List<String> mchat_ids;
        public final List<String> mcreator_ids;
        public final List<FileType> mfile_types;
        public final List<String> mfrom_ids;
        public final Boolean monlyTitle;
        public final Boolean monly_comment;
        public final Long mopenEndTime;
        public final Long mopenStartTime;
        public final Boolean msearch_favourite;
        public final List<String> msharer_ids;
        public final DocSortRuleType msortType;
        public final List<String> mspace_ids;
        public final List<DocType> mtype;

        public static final class Builder extends Message.Builder<PhoenixFilter, Builder> {
            public List<String> mchat_ids;
            public List<String> mcreator_ids;
            public List<FileType> mfile_types;
            public List<String> mfrom_ids;
            public Boolean monlyTitle;
            public Boolean monly_comment;
            public Long mopenEndTime;
            public Long mopenStartTime;
            public Boolean msearch_favourite;
            public List<String> msharer_ids;
            public DocSortRuleType msortType;
            public List<String> mspace_ids;
            public List<DocType> mtype;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public PhoenixFilter m2926build() {
                return new PhoenixFilter(this.mcreator_ids, this.mchat_ids, this.mtype, this.monlyTitle, this.mopenStartTime, this.mopenEndTime, this.msharer_ids, this.monly_comment, this.msortType, this.mfrom_ids, this.mfile_types, this.msearch_favourite, this.mspace_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mcreator_ids = Internal.newMutableList();
                this.mchat_ids = Internal.newMutableList();
                this.mtype = Internal.newMutableList();
                this.msharer_ids = Internal.newMutableList();
                this.mfrom_ids = Internal.newMutableList();
                this.mfile_types = Internal.newMutableList();
                this.mspace_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2926build();
            }

            public Builder chat_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_ids = r1;
                return this;
            }

            public Builder creator_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcreator_ids = r1;
                return this;
            }

            public Builder file_types(List<FileType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfile_types = r1;
                return this;
            }

            public Builder from_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfrom_ids = r1;
                return this;
            }

            public Builder onlyTitle(Boolean r1) {
                this.monlyTitle = r1;
                return this;
            }

            public Builder only_comment(Boolean r1) {
                this.monly_comment = r1;
                return this;
            }

            public Builder openEndTime(Long r1) {
                this.mopenEndTime = r1;
                return this;
            }

            public Builder openStartTime(Long r1) {
                this.mopenStartTime = r1;
                return this;
            }

            public Builder search_favourite(Boolean r1) {
                this.msearch_favourite = r1;
                return this;
            }

            public Builder sharer_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.msharer_ids = r1;
                return this;
            }

            public Builder sortType(DocSortRuleType r1) {
                this.msortType = r1;
                return this;
            }

            public Builder space_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mspace_ids = r1;
                return this;
            }

            public Builder type(List<DocType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mtype = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_PhoenixFilter extends ProtoAdapter<PhoenixFilter> {
            public ProtoAdapter_PhoenixFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, PhoenixFilter.class);
            }

            public PhoenixFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.monlyTitle = r1;
                r0.mopenStartTime = 0L;
                r0.mopenEndTime = 0L;
                r0.monly_comment = r1;
                r0.msearch_favourite = r1;
                long r2 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L29;
                switch(r3) {
                    case 1: goto L28;
                    case 2: goto L27;
                    case 3: goto L31;
                    case 4: goto L22;
                    case 5: goto L21;
                    case 6: goto L20;
                    case 7: goto L19;
                    case 8: goto L18;
                    case 9: goto L35;
                    case 10: goto L13;
                    case 11: goto L33;
                    case 12: goto L8;
                    case 13: goto L7;
                    default: goto L6;
                };
            L31:
                r0.mtype.add((DocType) DocType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
            L25:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L33:
                r0.mfile_types.add((FileType) FileType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
            L11:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L35:
                r0.msortType = (DocSortRuleType) DocSortRuleType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mspace_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L8:
                r0.msearch_favourite = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L13:
                r0.mfrom_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L18:
                r0.monly_comment = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L19:
                r0.msharer_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L20:
                r0.mopenEndTime = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L21:
                r0.mopenStartTime = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L22:
                r0.monlyTitle = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L27:
                r0.mchat_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L28:
                r0.mcreator_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L29:
                r9.endMessage(r2);
                return r0.m2926build();
            }

            public int encodedSize(PhoenixFilter r7) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = (r0.asRepeated().encodedSizeWithTag(1, r7.mcreator_ids) + r0.asRepeated().encodedSizeWithTag(2, r7.mchat_ids)) + DocType.ADAPTER.asRepeated().encodedSizeWithTag(3, r7.mtype);
                Boolean r2 = r7.monlyTitle;
                int r3 = 0;
                if (r2 == null) goto L5;
                int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r2);
            L6:
                int r5 = r1 + r4;
                Long r6 = r7.mopenStartTime;
                if (r6 == null) goto L9;
                int r8 = ProtoAdapter.INT64.encodedSizeWithTag(5, r6);
            L10:
                int r9 = r5 + r8;
                Long r10 = r7.mopenEndTime;
                if (r10 == null) goto L13;
                int r11 = ProtoAdapter.INT64.encodedSizeWithTag(6, r10);
            L14:
                int r12 = (r9 + r11) + r0.asRepeated().encodedSizeWithTag(7, r7.msharer_ids);
                Boolean r13 = r7.monly_comment;
                if (r13 == null) goto L17;
                int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r13);
            L18:
                int r15 = r12 + r14;
                DocSortRuleType r16 = r7.msortType;
                if (r16 == null) goto L21;
                int r17 = DocSortRuleType.ADAPTER.encodedSizeWithTag(9, r16);
            L22:
                int r18 = ((r15 + r17) + r0.asRepeated().encodedSizeWithTag(10, r7.mfrom_ids)) + FileType.ADAPTER.asRepeated().encodedSizeWithTag(11, r7.mfile_types);
                Boolean r19 = r7.msearch_favourite;
                if (r19 == null) goto L26;
                r3 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r19);
            L26:
                return ((r18 + r3) + r0.asRepeated().encodedSizeWithTag(13, r7.mspace_ids)) + r7.unknownFields().size();
            L21:
                r17 = 0;
                goto L22
            L17:
                r14 = 0;
                goto L18
            L13:
                r11 = 0;
                goto L14
            L9:
                r8 = 0;
                goto L10
            L5:
                r4 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2927decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((PhoenixFilter) r1);
            }

            public void encode(ProtoWriter r5, PhoenixFilter r6) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.asRepeated().encodeWithTag(r5, 1, r6.mcreator_ids);
                r0.asRepeated().encodeWithTag(r5, 2, r6.mchat_ids);
                DocType.ADAPTER.asRepeated().encodeWithTag(r5, 3, r6.mtype);
                Boolean r1 = r6.monlyTitle;
                if (r1 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r5, 4, r1);
            L5:
                Long r2 = r6.mopenStartTime;
                if (r2 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r5, 5, r2);
            L8:
                Long r3 = r6.mopenEndTime;
                if (r3 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r5, 6, r3);
            L11:
                r0.asRepeated().encodeWithTag(r5, 7, r6.msharer_ids);
                Boolean r4 = r6.monly_comment;
                if (r4 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r5, 8, r4);
            L14:
                DocSortRuleType r7 = r6.msortType;
                if (r7 == null) goto L17;
                DocSortRuleType.ADAPTER.encodeWithTag(r5, 9, r7);
            L17:
                r0.asRepeated().encodeWithTag(r5, 10, r6.mfrom_ids);
                FileType.ADAPTER.asRepeated().encodeWithTag(r5, 11, r6.mfile_types);
                Boolean r8 = r6.msearch_favourite;
                if (r8 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r5, 12, r8);
            L20:
                r0.asRepeated().encodeWithTag(r5, 13, r6.mspace_ids);
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (PhoenixFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_PhoenixFilter();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_ONLYTITLE = r0;
            DEFAULT_OPENSTARTTIME = 0L;
            DEFAULT_OPENENDTIME = 0L;
            DEFAULT_ONLY_COMMENT = r0;
            DEFAULT_SEARCH_FAVOURITE = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2925newBuilder() {
            Builder r0 = new Builder();
            r0.mcreator_ids = Internal.copyOf("mcreator_ids", this.mcreator_ids);
            r0.mchat_ids = Internal.copyOf("mchat_ids", this.mchat_ids);
            r0.mtype = Internal.copyOf("mtype", this.mtype);
            r0.monlyTitle = this.monlyTitle;
            r0.mopenStartTime = this.mopenStartTime;
            r0.mopenEndTime = this.mopenEndTime;
            r0.msharer_ids = Internal.copyOf("msharer_ids", this.msharer_ids);
            r0.monly_comment = this.monly_comment;
            r0.msortType = this.msortType;
            r0.mfrom_ids = Internal.copyOf("mfrom_ids", this.mfrom_ids);
            r0.mfile_types = Internal.copyOf("mfile_types", this.mfile_types);
            r0.msearch_favourite = this.msearch_favourite;
            r0.mspace_ids = Internal.copyOf("mspace_ids", this.mspace_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return PhoenixFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2925newBuilder();
        }

        public PhoenixFilter(List<String> r16, List<String> r17, List<DocType> r18, Boolean r19, Long r20, Long r21, List<String> r22, Boolean r23, DocSortRuleType r24, List<String> r25, List<FileType> r26, Boolean r27, List<String> r28) {
            this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
        }

        public PhoenixFilter(List<String> r2, List<String> r3, List<DocType> r4, Boolean r5, Long r6, Long r7, List<String> r8, Boolean r9, DocSortRuleType r10, List<String> r11, List<FileType> r12, Boolean r13, List<String> r14, ByteString r15) {
            super(ADAPTER, r15);
            this.mcreator_ids = Internal.immutableCopyOf("mcreator_ids", r2);
            this.mchat_ids = Internal.immutableCopyOf("mchat_ids", r3);
            this.mtype = Internal.immutableCopyOf("mtype", r4);
            this.monlyTitle = r5;
            this.mopenStartTime = r6;
            this.mopenEndTime = r7;
            this.msharer_ids = Internal.immutableCopyOf("msharer_ids", r8);
            this.monly_comment = r9;
            this.msortType = r10;
            this.mfrom_ids = Internal.immutableCopyOf("mfrom_ids", r11);
            this.mfile_types = Internal.immutableCopyOf("mfile_types", r12);
            this.msearch_favourite = r13;
            this.mspace_ids = Internal.immutableCopyOf("mspace_ids", r14);
        }
    }

    public static final class ProtoAdapter_UniversalFilters extends ProtoAdapter<UniversalFilters> {
        public ProtoAdapter_UniversalFilters() {
            super(FieldEncoding.LENGTH_DELIMITED, UniversalFilters.class);
        }

        public UniversalFilters decode(ProtoReader r7) throws IOException {
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
            return r0.m2885build();
        }

        public int encodedSize(UniversalFilters r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2928decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UniversalFilters) r1);
        }

        public void encode(ProtoWriter r1, UniversalFilters r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UniversalFilters) r2);
        }
    }

    public static final class SearchSourceIDs extends Message<SearchSourceIDs, Builder> {
        public static final ProtoAdapter<SearchSourceIDs> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mids;

        public static final class Builder extends Message.Builder<SearchSourceIDs, Builder> {
            public List<String> mids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SearchSourceIDs m2930build() {
                return new SearchSourceIDs(this.mids, super.buildUnknownFields());
            }

            public Builder() {
                this.mids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2930build();
            }

            public Builder ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SearchSourceIDs extends ProtoAdapter<SearchSourceIDs> {
            public ProtoAdapter_SearchSourceIDs() {
                super(FieldEncoding.LENGTH_DELIMITED, SearchSourceIDs.class);
            }

            public SearchSourceIDs decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mids.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2930build();
            }

            public int encodedSize(SearchSourceIDs r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.mids) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2931decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SearchSourceIDs) r1);
            }

            public void encode(ProtoWriter r4, SearchSourceIDs r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.mids);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SearchSourceIDs) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SearchSourceIDs();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2929newBuilder() {
            Builder r0 = new Builder();
            r0.mids = Internal.copyOf("mids", this.mids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SearchSourceIDs.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2929newBuilder();
        }

        public SearchSourceIDs(List<String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public SearchSourceIDs(List<String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mids = Internal.immutableCopyOf("mids", r2);
        }
    }

    public static final class SearchType extends Message<SearchType, Builder> {
        public static final ProtoAdapter<SearchType> ADAPTER = null;
        public static final Boolean DEFAULT_IS_CROSS_TENANT = null;
        public static final Boolean DEFAULT_IS_JOINED = null;
        public static final Boolean DEFAULT_IS_PUBLIC = null;
        private static final long serialVersionUID = 0;
        public final Boolean mis_cross_tenant;
        public final Boolean mis_joined;
        public final Boolean mis_public;

        public static final class Builder extends Message.Builder<SearchType, Builder> {
            public Boolean mis_cross_tenant;
            public Boolean mis_joined;
            public Boolean mis_public;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SearchType m2933build() {
                return new SearchType(this.mis_joined, this.mis_public, this.mis_cross_tenant, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2933build();
            }

            public Builder is_cross_tenant(Boolean r1) {
                this.mis_cross_tenant = r1;
                return this;
            }

            public Builder is_joined(Boolean r1) {
                this.mis_joined = r1;
                return this;
            }

            public Builder is_public(Boolean r1) {
                this.mis_public = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SearchType extends ProtoAdapter<SearchType> {
            public ProtoAdapter_SearchType() {
                super(FieldEncoding.LENGTH_DELIMITED, SearchType.class);
            }

            public SearchType decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.mis_joined = r1;
                r0.mis_public = r1;
                r0.mis_cross_tenant = r1;
                long r2 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mis_joined = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mis_public = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mis_cross_tenant = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r2);
                return r0.m2933build();
            }

            public int encodedSize(SearchType r6) {
                Boolean r0 = r6.mis_joined;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r6.mis_public;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                Boolean r7 = r6.mis_cross_tenant;
                if (r7 == null) goto L14;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m2934decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SearchType) r1);
            }

            public void encode(ProtoWriter r4, SearchType r5) throws IOException {
                Boolean r0 = r5.mis_joined;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mis_public;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                Boolean r2 = r5.mis_cross_tenant;
                if (r2 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SearchType) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SearchType();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_IS_JOINED = r0;
            DEFAULT_IS_PUBLIC = r0;
            DEFAULT_IS_CROSS_TENANT = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2932newBuilder() {
            Builder r0 = new Builder();
            r0.mis_joined = this.mis_joined;
            r0.mis_public = this.mis_public;
            r0.mis_cross_tenant = this.mis_cross_tenant;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SearchType.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2932newBuilder();
        }

        public SearchType(Boolean r2, Boolean r3, Boolean r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public SearchType(Boolean r2, Boolean r3, Boolean r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mis_joined = r2;
            this.mis_public = r3;
            this.mis_cross_tenant = r4;
        }
    }

    public static final class SlashCommandFilter extends Message<SlashCommandFilter, Builder> {
        public static final ProtoAdapter<SlashCommandFilter> ADAPTER = null;
        public static final String DEFAULT_COMMAND_ID = "";
        public static final Boolean DEFAULT_ENABLE_SLASH_COMMAND_FILTER = null;
        private static final long serialVersionUID = 0;
        public final String mcommand_id;
        public final Boolean menable_slash_command_filter;
        public final List<String> mextras;
        public final List<CommandFilter> mfilters;
        public final List<CommandSorter> msorters;

        public static final class Builder extends Message.Builder<SlashCommandFilter, Builder> {
            public String mcommand_id;
            public Boolean menable_slash_command_filter;
            public List<String> mextras;
            public List<CommandFilter> mfilters;
            public List<CommandSorter> msorters;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SlashCommandFilter m2936build() {
                String r0 = this.mcommand_id;
                if (r0 == null) goto L7;
                return new SlashCommandFilter(this.mcommand_id, this.mextras, this.mfilters, this.menable_slash_command_filter, this.msorters, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "mcommand_id"});
            }

            public Builder() {
                this.mextras = Internal.newMutableList();
                this.mfilters = Internal.newMutableList();
                this.msorters = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2936build();
            }

            public Builder command_id(String r1) {
                this.mcommand_id = r1;
                return this;
            }

            public Builder enable_slash_command_filter(Boolean r1) {
                this.menable_slash_command_filter = r1;
                return this;
            }

            public Builder extras(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mextras = r1;
                return this;
            }

            public Builder filters(List<CommandFilter> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfilters = r1;
                return this;
            }

            public Builder sorters(List<CommandSorter> r1) {
                Internal.checkElementsNotNull(r1);
                this.msorters = r1;
                return this;
            }
        }

        public static final class CommandFilter extends Message<CommandFilter, Builder> {
            public static final ProtoAdapter<CommandFilter> ADAPTER = null;
            public static final String DEFAULT_FILTER_ID = "";
            private static final long serialVersionUID = 0;
            public final String mfilter_id;
            public final TimeRange mtime_range;
            public final List<String> mvalues;

            public static final class Builder extends Message.Builder<CommandFilter, Builder> {
                public String mfilter_id;
                public TimeRange mtime_range;
                public List<String> mvalues;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public CommandFilter m2938build() {
                    String r0 = this.mfilter_id;
                    if (r0 == null) goto L7;
                    return new CommandFilter(this.mfilter_id, this.mvalues, this.mtime_range, super.buildUnknownFields());
                L7:
                    throw Internal.missingRequiredFields(new Object[]{r0, "mfilter_id"});
                }

                public Builder() {
                    this.mvalues = Internal.newMutableList();
                }

                public /* bridge */ /* synthetic */ Message build() {
                    return m2938build();
                }

                public Builder filter_id(String r1) {
                    this.mfilter_id = r1;
                    return this;
                }

                public Builder time_range(TimeRange r1) {
                    this.mtime_range = r1;
                    return this;
                }

                public Builder values(List<String> r1) {
                    Internal.checkElementsNotNull(r1);
                    this.mvalues = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_CommandFilter extends ProtoAdapter<CommandFilter> {
                public ProtoAdapter_CommandFilter() {
                    super(FieldEncoding.LENGTH_DELIMITED, CommandFilter.class);
                }

                public CommandFilter decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.mfilter_id = "";
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L15;
                    if (r3 != 1) goto L8;
                    r0.mfilter_id = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L8:
                    if (r3 != 2) goto L10;
                    r0.mvalues.add((String) ProtoAdapter.STRING.decode(r7));
                    goto L3
                L10:
                    if (r3 != 3) goto L11;
                    r0.mtime_range = (TimeRange) TimeRange.ADAPTER.decode(r7);
                    goto L3
                L11:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L15:
                    r7.endMessage(r1);
                    return r0.m2938build();
                }

                public int encodedSize(CommandFilter r5) {
                    ProtoAdapter r0 = ProtoAdapter.STRING;
                    int r1 = r0.encodedSizeWithTag(1, r5.mfilter_id) + r0.asRepeated().encodedSizeWithTag(2, r5.mvalues);
                    TimeRange r2 = r5.mtime_range;
                    if (r2 == null) goto L5;
                    int r3 = TimeRange.ADAPTER.encodedSizeWithTag(3, r2);
                L7:
                    return (r1 + r3) + r5.unknownFields().size();
                L5:
                    r3 = 0;
                    goto L7
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m2939decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((CommandFilter) r1);
                }

                public void encode(ProtoWriter r4, CommandFilter r5) throws IOException {
                    ProtoAdapter r0 = ProtoAdapter.STRING;
                    r0.encodeWithTag(r4, 1, r5.mfilter_id);
                    r0.asRepeated().encodeWithTag(r4, 2, r5.mvalues);
                    TimeRange r1 = r5.mtime_range;
                    if (r1 == null) goto L5;
                    TimeRange.ADAPTER.encodeWithTag(r4, 3, r1);
                L5:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (CommandFilter) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_CommandFilter();
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m2937newBuilder() {
                Builder r0 = new Builder();
                r0.mfilter_id = this.mfilter_id;
                r0.mvalues = Internal.copyOf("mvalues", this.mvalues);
                r0.mtime_range = this.mtime_range;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return CommandFilter.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return m2937newBuilder();
            }

            public CommandFilter(String r2, List<String> r3, TimeRange r4) {
                this(r2, r3, r4, ByteString.EMPTY);
            }

            public CommandFilter(String r2, List<String> r3, TimeRange r4, ByteString r5) {
                super(ADAPTER, r5);
                this.mfilter_id = r2;
                this.mvalues = Internal.immutableCopyOf("mvalues", r3);
                this.mtime_range = r4;
            }
        }

        public static final class CommandSorter extends Message<CommandSorter, Builder> {
            public static final ProtoAdapter<CommandSorter> ADAPTER = null;
            public static final Boolean DEFAULT_ASC = null;
            public static final String DEFAULT_FIELD = "";
            private static final long serialVersionUID = 0;
            public final Boolean masc;
            public final String mfield;

            public static final class Builder extends Message.Builder<CommandSorter, Builder> {
                public Boolean masc;
                public String mfield;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public CommandSorter m2941build() {
                    String r0 = this.mfield;
                    if (r0 == null) goto L7;
                    return new CommandSorter(this.mfield, this.masc, super.buildUnknownFields());
                L7:
                    throw Internal.missingRequiredFields(new Object[]{r0, "mfield"});
                }

                public Builder() {
                }

                public /* bridge */ /* synthetic */ Message build() {
                    return m2941build();
                }

                public Builder asc(Boolean r1) {
                    this.masc = r1;
                    return this;
                }

                public Builder field(String r1) {
                    this.mfield = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_CommandSorter extends ProtoAdapter<CommandSorter> {
                public ProtoAdapter_CommandSorter() {
                    super(FieldEncoding.LENGTH_DELIMITED, CommandSorter.class);
                }

                public CommandSorter decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    r0.mfield = "";
                    r0.masc = Boolean.FALSE;
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L12;
                    if (r3 != 1) goto L8;
                    r0.mfield = (String) ProtoAdapter.STRING.decode(r7);
                    goto L3
                L8:
                    if (r3 != 2) goto L9;
                    r0.masc = (Boolean) ProtoAdapter.BOOL.decode(r7);
                    goto L3
                L9:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L12:
                    r7.endMessage(r1);
                    return r0.m2941build();
                }

                public int encodedSize(CommandSorter r5) {
                    int r0 = ProtoAdapter.STRING.encodedSizeWithTag(1, r5.mfield);
                    Boolean r1 = r5.masc;
                    if (r1 == null) goto L5;
                    int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r1);
                L7:
                    return (r0 + r2) + r5.unknownFields().size();
                L5:
                    r2 = 0;
                    goto L7
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m2942decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((CommandSorter) r1);
                }

                public void encode(ProtoWriter r4, CommandSorter r5) throws IOException {
                    ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.mfield);
                    Boolean r0 = r5.masc;
                    if (r0 == null) goto L5;
                    ProtoAdapter.BOOL.encodeWithTag(r4, 2, r0);
                L5:
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (CommandSorter) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_CommandSorter();
                DEFAULT_ASC = Boolean.FALSE;
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m2940newBuilder() {
                Builder r0 = new Builder();
                r0.mfield = this.mfield;
                r0.masc = this.masc;
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return CommandSorter.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return m2940newBuilder();
            }

            public CommandSorter(String r2, Boolean r3) {
                this(r2, r3, ByteString.EMPTY);
            }

            public CommandSorter(String r2, Boolean r3, ByteString r4) {
                super(ADAPTER, r4);
                this.mfield = r2;
                this.masc = r3;
            }
        }

        public static final class ProtoAdapter_SlashCommandFilter extends ProtoAdapter<SlashCommandFilter> {
            public ProtoAdapter_SlashCommandFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, SlashCommandFilter.class);
            }

            public SlashCommandFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mcommand_id = "";
                r0.menable_slash_command_filter = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L21;
                if (r3 != 1) goto L8;
                r0.mcommand_id = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mextras.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mfilters.add((CommandFilter) CommandFilter.ADAPTER.decode(r7));
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.menable_slash_command_filter = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.msorters.add((CommandSorter) CommandSorter.ADAPTER.decode(r7));
                goto L3
            L15:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L21:
                r7.endMessage(r1);
                return r0.m2936build();
            }

            public int encodedSize(SlashCommandFilter r5) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = (r0.encodedSizeWithTag(1, r5.mcommand_id) + r0.asRepeated().encodedSizeWithTag(2, r5.mextras)) + CommandFilter.ADAPTER.asRepeated().encodedSizeWithTag(3, r5.mfilters);
                Boolean r2 = r5.menable_slash_command_filter;
                if (r2 == null) goto L5;
                int r3 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r2);
            L7:
                return ((r1 + r3) + CommandSorter.ADAPTER.asRepeated().encodedSizeWithTag(5, r5.msorters)) + r5.unknownFields().size();
            L5:
                r3 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2943decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SlashCommandFilter) r1);
            }

            public void encode(ProtoWriter r4, SlashCommandFilter r5) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r4, 1, r5.mcommand_id);
                r0.asRepeated().encodeWithTag(r4, 2, r5.mextras);
                CommandFilter.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mfilters);
                Boolean r1 = r5.menable_slash_command_filter;
                if (r1 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 4, r1);
            L5:
                CommandSorter.ADAPTER.asRepeated().encodeWithTag(r4, 5, r5.msorters);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SlashCommandFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SlashCommandFilter();
            DEFAULT_ENABLE_SLASH_COMMAND_FILTER = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2935newBuilder() {
            Builder r0 = new Builder();
            r0.mcommand_id = this.mcommand_id;
            r0.mextras = Internal.copyOf("mextras", this.mextras);
            r0.mfilters = Internal.copyOf("mfilters", this.mfilters);
            r0.menable_slash_command_filter = this.menable_slash_command_filter;
            r0.msorters = Internal.copyOf("msorters", this.msorters);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SlashCommandFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2935newBuilder();
        }

        public SlashCommandFilter(String r8, List<String> r9, List<CommandFilter> r10, Boolean r11, List<CommandSorter> r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public SlashCommandFilter(String r2, List<String> r3, List<CommandFilter> r4, Boolean r5, List<CommandSorter> r6, ByteString r7) {
            super(ADAPTER, r7);
            this.mcommand_id = r2;
            this.mextras = Internal.immutableCopyOf("mextras", r3);
            this.mfilters = Internal.immutableCopyOf("mfilters", r4);
            this.menable_slash_command_filter = r5;
            this.msorters = Internal.immutableCopyOf("msorters", r6);
        }
    }

    public static final class Templates extends Message<Templates, Builder> {
        public static final ProtoAdapter<Templates> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mversions;

        public static final class Builder extends Message.Builder<Templates, Builder> {
            public List<String> mversions;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Templates m2945build() {
                return new Templates(this.mversions, super.buildUnknownFields());
            }

            public Builder() {
                this.mversions = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2945build();
            }

            public Builder versions(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mversions = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Templates extends ProtoAdapter<Templates> {
            public ProtoAdapter_Templates() {
                super(FieldEncoding.LENGTH_DELIMITED, Templates.class);
            }

            public Templates decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mversions.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2945build();
            }

            public int encodedSize(Templates r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.mversions) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2946decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Templates) r1);
            }

            public void encode(ProtoWriter r4, Templates r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.mversions);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Templates) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Templates();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2944newBuilder() {
            Builder r0 = new Builder();
            r0.mversions = Internal.copyOf("mversions", this.mversions);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Templates.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2944newBuilder();
        }

        public Templates(List<String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public Templates(List<String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mversions = Internal.immutableCopyOf("mversions", r2);
        }
    }

    public static final class TimeRange extends Message<TimeRange, Builder> {
        public static final ProtoAdapter<TimeRange> ADAPTER = null;
        public static final Long DEFAULT_END_TIME = null;
        public static final Long DEFAULT_START_TIME = null;
        private static final long serialVersionUID = 0;
        public final Long mend_time;
        public final Long mstart_time;

        public static final class Builder extends Message.Builder<TimeRange, Builder> {
            public Long mend_time;
            public Long mstart_time;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TimeRange m2948build() {
                return new TimeRange(this.mstart_time, this.mend_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2948build();
            }

            public Builder end_time(Long r1) {
                this.mend_time = r1;
                return this;
            }

            public Builder start_time(Long r1) {
                this.mstart_time = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_TimeRange extends ProtoAdapter<TimeRange> {
            public ProtoAdapter_TimeRange() {
                super(FieldEncoding.LENGTH_DELIMITED, TimeRange.class);
            }

            public TimeRange decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mstart_time = 0L;
                r0.mend_time = 0L;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mstart_time = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mend_time = (Long) ProtoAdapter.INT64.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2948build();
            }

            public int encodedSize(TimeRange r5) {
                Long r0 = r5.mstart_time;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
            L6:
                Long r3 = r5.mend_time;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2949decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TimeRange) r1);
            }

            public void encode(ProtoWriter r4, TimeRange r5) throws IOException {
                Long r0 = r5.mstart_time;
                if (r0 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
            L5:
                Long r1 = r5.mend_time;
                if (r1 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (TimeRange) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimeRange();
            DEFAULT_START_TIME = 0L;
            DEFAULT_END_TIME = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2947newBuilder() {
            Builder r0 = new Builder();
            r0.mstart_time = this.mstart_time;
            r0.mend_time = this.mend_time;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TimeRange.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2947newBuilder();
        }

        public TimeRange(Long r2, Long r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public TimeRange(Long r2, Long r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mstart_time = r2;
            this.mend_time = r3;
        }
    }

    public static final class URLFilter extends Message<URLFilter, Builder> {
        public static final ProtoAdapter<URLFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mchat_ids;
        public final List<String> mcreator_ids;
        public final TimeRange mtime_range;
        public final List<String> mwith_user_ids;

        public static final class Builder extends Message.Builder<URLFilter, Builder> {
            public List<String> mchat_ids;
            public List<String> mcreator_ids;
            public TimeRange mtime_range;
            public List<String> mwith_user_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public URLFilter m2951build() {
                return new URLFilter(this.mtime_range, this.mcreator_ids, this.mchat_ids, this.mwith_user_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mcreator_ids = Internal.newMutableList();
                this.mchat_ids = Internal.newMutableList();
                this.mwith_user_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2951build();
            }

            public Builder chat_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_ids = r1;
                return this;
            }

            public Builder creator_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcreator_ids = r1;
                return this;
            }

            public Builder time_range(TimeRange r1) {
                this.mtime_range = r1;
                return this;
            }

            public Builder with_user_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mwith_user_ids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_URLFilter extends ProtoAdapter<URLFilter> {
            public ProtoAdapter_URLFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, URLFilter.class);
            }

            public URLFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mtime_range = (TimeRange) TimeRange.ADAPTER.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mcreator_ids.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mchat_ids.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.mwith_user_ids.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L13:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L18:
                r7.endMessage(r1);
                return r0.m2951build();
            }

            public int encodedSize(URLFilter r6) {
                TimeRange r0 = r6.mtime_range;
                if (r0 == null) goto L5;
                int r1 = TimeRange.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                ProtoAdapter r2 = ProtoAdapter.STRING;
                return (((r1 + r2.asRepeated().encodedSizeWithTag(2, r6.mcreator_ids)) + r2.asRepeated().encodedSizeWithTag(3, r6.mchat_ids)) + r2.asRepeated().encodedSizeWithTag(4, r6.mwith_user_ids)) + r6.unknownFields().size();
            L5:
                r1 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2952decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((URLFilter) r1);
            }

            public void encode(ProtoWriter r5, URLFilter r6) throws IOException {
                TimeRange r0 = r6.mtime_range;
                if (r0 == null) goto L5;
                TimeRange.ADAPTER.encodeWithTag(r5, 1, r0);
            L5:
                ProtoAdapter r1 = ProtoAdapter.STRING;
                r1.asRepeated().encodeWithTag(r5, 2, r6.mcreator_ids);
                r1.asRepeated().encodeWithTag(r5, 3, r6.mchat_ids);
                r1.asRepeated().encodeWithTag(r5, 4, r6.mwith_user_ids);
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (URLFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_URLFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2950newBuilder() {
            Builder r0 = new Builder();
            r0.mtime_range = this.mtime_range;
            r0.mcreator_ids = Internal.copyOf("mcreator_ids", this.mcreator_ids);
            r0.mchat_ids = Internal.copyOf("mchat_ids", this.mchat_ids);
            r0.mwith_user_ids = Internal.copyOf("mwith_user_ids", this.mwith_user_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return URLFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2950newBuilder();
        }

        public URLFilter(TimeRange r7, List<String> r8, List<String> r9, List<String> r10) {
            this(r7, r8, r9, r10, ByteString.EMPTY);
        }

        public URLFilter(TimeRange r2, List<String> r3, List<String> r4, List<String> r5, ByteString r6) {
            super(ADAPTER, r6);
            this.mtime_range = r2;
            this.mcreator_ids = Internal.immutableCopyOf("mcreator_ids", r3);
            this.mchat_ids = Internal.immutableCopyOf("mchat_ids", r4);
            this.mwith_user_ids = Internal.immutableCopyOf("mwith_user_ids", r5);
        }
    }

    public static final class UserFilter extends Message<UserFilter, Builder> {
        public static final ProtoAdapter<UserFilter> ADAPTER = null;
        public static final Boolean DEFAULT_EXCLUDE = null;
        public static final Boolean DEFAULT_EXCLUDE_OUTER_CONTACT = null;
        public static final Boolean DEFAULT_EXISTS_ENTERPRISE_EMAIL = null;
        public static final Boolean DEFAULT_HAVE_CHATTER = null;
        public static final Boolean DEFAULT_IS_NEED_AGENT = null;
        public static final Boolean DEFAULT_IS_RESIGNED = null;
        private static final long serialVersionUID = 0;
        public final Map<String, FieldValues> mcustom_fields;
        public final Boolean mexclude;
        public final Boolean mexclude_outer_contact;
        public final Boolean mexists_enterprise_email;
        public final Boolean mhave_chatter;
        public final List<Long> min_user_ids;
        public final Boolean mis_need_agent;
        public final Boolean mis_resigned;

        public static final class Builder extends Message.Builder<UserFilter, Builder> {
            public Map<String, FieldValues> mcustom_fields;
            public Boolean mexclude;
            public Boolean mexclude_outer_contact;
            public Boolean mexists_enterprise_email;
            public Boolean mhave_chatter;
            public List<Long> min_user_ids;
            public Boolean mis_need_agent;
            public Boolean mis_resigned;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public UserFilter m2954build() {
                return new UserFilter(this.mis_resigned, this.mhave_chatter, this.mcustom_fields, this.mexclude, this.mexclude_outer_contact, this.mexists_enterprise_email, this.min_user_ids, this.mis_need_agent, super.buildUnknownFields());
            }

            public Builder() {
                this.mcustom_fields = Internal.newMutableMap();
                this.min_user_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2954build();
            }

            public Builder custom_fields(Map<String, FieldValues> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcustom_fields = r1;
                return this;
            }

            public Builder exclude(Boolean r1) {
                this.mexclude = r1;
                return this;
            }

            public Builder exclude_outer_contact(Boolean r1) {
                this.mexclude_outer_contact = r1;
                return this;
            }

            public Builder exists_enterprise_email(Boolean r1) {
                this.mexists_enterprise_email = r1;
                return this;
            }

            public Builder have_chatter(Boolean r1) {
                this.mhave_chatter = r1;
                return this;
            }

            public Builder in_user_ids(List<Long> r1) {
                Internal.checkElementsNotNull(r1);
                this.min_user_ids = r1;
                return this;
            }

            public Builder is_need_agent(Boolean r1) {
                this.mis_need_agent = r1;
                return this;
            }

            public Builder is_resigned(Boolean r1) {
                this.mis_resigned = r1;
                return this;
            }
        }

        public static final class FieldValues extends Message<FieldValues, Builder> {
            public static final ProtoAdapter<FieldValues> ADAPTER = null;
            private static final long serialVersionUID = 0;
            public final List<String> mvalues;

            public static final class Builder extends Message.Builder<FieldValues, Builder> {
                public List<String> mvalues;

                /* JADX INFO: renamed from: build, reason: collision with other method in class */
                public FieldValues m2956build() {
                    return new FieldValues(this.mvalues, super.buildUnknownFields());
                }

                public Builder() {
                    this.mvalues = Internal.newMutableList();
                }

                public /* bridge */ /* synthetic */ Message build() {
                    return m2956build();
                }

                public Builder values(List<String> r1) {
                    Internal.checkElementsNotNull(r1);
                    this.mvalues = r1;
                    return this;
                }
            }

            public static final class ProtoAdapter_FieldValues extends ProtoAdapter<FieldValues> {
                public ProtoAdapter_FieldValues() {
                    super(FieldEncoding.LENGTH_DELIMITED, FieldValues.class);
                }

                public FieldValues decode(ProtoReader r7) throws IOException {
                    Builder r0 = new Builder();
                    long r1 = r7.beginMessage();
                L3:
                    int r3 = r7.nextTag();
                    if (r3 == (-1)) goto L9;
                    if (r3 != 1) goto L7;
                    r0.mvalues.add((String) ProtoAdapter.STRING.decode(r7));
                    goto L3
                L7:
                    FieldEncoding r4 = r7.peekFieldEncoding();
                    r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                    goto L3
                L9:
                    r7.endMessage(r1);
                    return r0.m2956build();
                }

                public int encodedSize(FieldValues r4) {
                    return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.mvalues) + r4.unknownFields().size();
                }

                /* JADX INFO: renamed from: decode, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m2957decode(ProtoReader r1) throws IOException {
                    return decode(r1);
                }

                public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                    return encodedSize((FieldValues) r1);
                }

                public void encode(ProtoWriter r4, FieldValues r5) throws IOException {
                    ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.mvalues);
                    r4.writeBytes(r5.unknownFields());
                }

                public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                    encode(r1, (FieldValues) r2);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_FieldValues();
            }

            /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
            public Builder m2955newBuilder() {
                Builder r0 = new Builder();
                r0.mvalues = Internal.copyOf("mvalues", this.mvalues);
                r0.addUnknownFields(unknownFields());
                return r0;
            }

            public String toString() {
                return FieldValues.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return m2955newBuilder();
            }

            public FieldValues(List<String> r2) {
                this(r2, ByteString.EMPTY);
            }

            public FieldValues(List<String> r2, ByteString r3) {
                super(ADAPTER, r3);
                this.mvalues = Internal.immutableCopyOf("mvalues", r2);
            }
        }

        public static final class ProtoAdapter_UserFilter extends ProtoAdapter<UserFilter> {
            private final ProtoAdapter<Map<String, FieldValues>> mcustom_fields;

            public ProtoAdapter_UserFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, UserFilter.class);
                this.mcustom_fields = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, FieldValues.ADAPTER);
            }

            public UserFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.mis_resigned = r1;
                r0.mhave_chatter = r1;
                r0.mexclude = r1;
                r0.mexclude_outer_contact = r1;
                r0.mexists_enterprise_email = r1;
                r0.mis_need_agent = r1;
                long r2 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                switch(r3) {
                    case 1: goto L14;
                    case 2: goto L13;
                    case 3: goto L12;
                    case 4: goto L11;
                    case 5: goto L10;
                    case 6: goto L9;
                    case 7: goto L8;
                    case 8: goto L7;
                    default: goto L6;
                };
            L7:
                r0.mis_need_agent = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L8:
                r0.min_user_ids.add((Long) ProtoAdapter.INT64.decode(r7));
                goto L3
            L9:
                r0.mexists_enterprise_email = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L10:
                r0.mexclude_outer_contact = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L11:
                r0.mexclude = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L12:
                r0.mcustom_fields.putAll((Map) this.mcustom_fields.decode(r7));
                goto L3
            L13:
                r0.mhave_chatter = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L14:
                r0.mis_resigned = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L6:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r2);
                return r0.m2954build();
            }

            public int encodedSize(UserFilter r6) {
                Boolean r0 = r6.mis_resigned;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L6:
                Boolean r3 = r6.mhave_chatter;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
            L10:
                int r5 = (r2 + r4) + this.mcustom_fields.encodedSizeWithTag(3, r6.mcustom_fields);
                Boolean r7 = r6.mexclude;
                if (r7 == null) goto L13;
                int r8 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r7);
            L14:
                int r9 = r5 + r8;
                Boolean r10 = r6.mexclude_outer_contact;
                if (r10 == null) goto L17;
                int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r10);
            L18:
                int r12 = r9 + r11;
                Boolean r13 = r6.mexists_enterprise_email;
                if (r13 == null) goto L21;
                int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r13);
            L22:
                int r15 = (r12 + r14) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(7, r6.min_user_ids);
                Boolean r16 = r6.mis_need_agent;
                if (r16 == null) goto L26;
                r1 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r16);
            L26:
                return (r15 + r1) + r6.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Object m2958decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((UserFilter) r1);
            }

            public void encode(ProtoWriter r4, UserFilter r5) throws IOException {
                Boolean r0 = r5.mis_resigned;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                Boolean r1 = r5.mhave_chatter;
                if (r1 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
            L8:
                this.mcustom_fields.encodeWithTag(r4, 3, r5.mcustom_fields);
                Boolean r2 = r5.mexclude;
                if (r2 == null) goto L11;
                ProtoAdapter.BOOL.encodeWithTag(r4, 4, r2);
            L11:
                Boolean r3 = r5.mexclude_outer_contact;
                if (r3 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r4, 5, r3);
            L14:
                Boolean r6 = r5.mexists_enterprise_email;
                if (r6 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r4, 6, r6);
            L17:
                ProtoAdapter.INT64.asRepeated().encodeWithTag(r4, 7, r5.min_user_ids);
                Boolean r7 = r5.mis_need_agent;
                if (r7 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r4, 8, r7);
            L20:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (UserFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserFilter();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_IS_RESIGNED = r0;
            DEFAULT_HAVE_CHATTER = r0;
            DEFAULT_EXCLUDE = r0;
            DEFAULT_EXCLUDE_OUTER_CONTACT = r0;
            DEFAULT_EXISTS_ENTERPRISE_EMAIL = r0;
            DEFAULT_IS_NEED_AGENT = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2953newBuilder() {
            Builder r0 = new Builder();
            r0.mis_resigned = this.mis_resigned;
            r0.mhave_chatter = this.mhave_chatter;
            r0.mcustom_fields = Internal.copyOf("mcustom_fields", this.mcustom_fields);
            r0.mexclude = this.mexclude;
            r0.mexclude_outer_contact = this.mexclude_outer_contact;
            r0.mexists_enterprise_email = this.mexists_enterprise_email;
            r0.min_user_ids = Internal.copyOf("min_user_ids", this.min_user_ids);
            r0.mis_need_agent = this.mis_need_agent;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return UserFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2953newBuilder();
        }

        public UserFilter(Boolean r11, Boolean r12, Map<String, FieldValues> r13, Boolean r14, Boolean r15, Boolean r16, List<Long> r17, Boolean r18) {
            this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
        }

        public UserFilter(Boolean r2, Boolean r3, Map<String, FieldValues> r4, Boolean r5, Boolean r6, Boolean r7, List<Long> r8, Boolean r9, ByteString r10) {
            super(ADAPTER, r10);
            this.mis_resigned = r2;
            this.mhave_chatter = r3;
            this.mcustom_fields = Internal.immutableCopyOf("mcustom_fields", r4);
            this.mexclude = r5;
            this.mexclude_outer_contact = r6;
            this.mexists_enterprise_email = r7;
            this.min_user_ids = Internal.immutableCopyOf("min_user_ids", r8);
            this.mis_need_agent = r9;
        }
    }

    public static final class WikiFilter extends Message<WikiFilter, Builder> {
        public static final ProtoAdapter<WikiFilter> ADAPTER = null;
        public static final Boolean DEFAULT_CROSS_LANGUAGE = null;
        public static final Boolean DEFAULT_ENABLE_EXTENDED_SEARCH = null;
        public static final Boolean DEFAULT_ONLYTITLE = null;
        public static final Boolean DEFAULT_ONLY_COMMENT = null;
        public static final Long DEFAULT_OPENENDTIME = null;
        public static final Long DEFAULT_OPENSTARTTIME = null;
        public static final Boolean DEFAULT_SEARCH_FAVOURITE = null;
        public static final Boolean DEFAULT_USE_EXTENDED_SEARCH_V2 = null;
        public static final FieldOptions FIELD_OPTIONS_MCHAT_IDS = null;
        public static final FieldOptions FIELD_OPTIONS_MCREATOR_IDS = null;
        public static final FieldOptions FIELD_OPTIONS_MFROM_IDS = null;
        public static final FieldOptions FIELD_OPTIONS_MORIGINAL_CREATOR_IDS = null;
        public static final FieldOptions FIELD_OPTIONS_MSHARER_IDS = null;
        private static final long serialVersionUID = 0;
        public final List<String> mchat_ids;
        public final List<ChatInfo> mchat_infos;
        public final TimeRange mcreate_time_range;
        public final List<String> mcreator_ids;
        public final Boolean mcross_language;
        public final Boolean menable_extended_search;
        public final List<FileType> mfile_types;
        public final List<String> mfrom_ids;
        public final List<String> mobj_ids;
        public final Boolean monlyTitle;
        public final Boolean monly_comment;
        public final Long mopenEndTime;
        public final Long mopenStartTime;
        public final List<String> moriginal_creator_ids;
        public final Map<String, SearchSourceIDs> msearchSourceIDs;
        public final Boolean msearch_favourite;
        public final List<String> msharer_ids;
        public final DocSortRuleType msortType;
        public final List<String> mspace_ids;
        public final TimeRange mtime_range;
        public final List<DocType> mtype;
        public final Boolean muse_extended_search_v2;

        public static final class Builder extends Message.Builder<WikiFilter, Builder> {
            public List<String> mchat_ids;
            public List<ChatInfo> mchat_infos;
            public TimeRange mcreate_time_range;
            public List<String> mcreator_ids;
            public Boolean mcross_language;
            public Boolean menable_extended_search;
            public List<FileType> mfile_types;
            public List<String> mfrom_ids;
            public List<String> mobj_ids;
            public Boolean monlyTitle;
            public Boolean monly_comment;
            public Long mopenEndTime;
            public Long mopenStartTime;
            public List<String> moriginal_creator_ids;
            public Map<String, SearchSourceIDs> msearchSourceIDs;
            public Boolean msearch_favourite;
            public List<String> msharer_ids;
            public DocSortRuleType msortType;
            public List<String> mspace_ids;
            public TimeRange mtime_range;
            public List<DocType> mtype;
            public Boolean muse_extended_search_v2;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public WikiFilter m2960build() {
                return new WikiFilter(this.mcreator_ids, this.mchat_ids, this.mtype, this.monlyTitle, this.mopenStartTime, this.mopenEndTime, this.msharer_ids, this.monly_comment, this.msortType, this.mfrom_ids, this.mfile_types, this.msearch_favourite, this.mspace_ids, this.mcross_language, this.menable_extended_search, this.muse_extended_search_v2, this.mtime_range, this.mchat_infos, this.msearchSourceIDs, this.mcreate_time_range, this.mobj_ids, this.moriginal_creator_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mcreator_ids = Internal.newMutableList();
                this.mchat_ids = Internal.newMutableList();
                this.mtype = Internal.newMutableList();
                this.msharer_ids = Internal.newMutableList();
                this.mfrom_ids = Internal.newMutableList();
                this.mfile_types = Internal.newMutableList();
                this.mspace_ids = Internal.newMutableList();
                this.mchat_infos = Internal.newMutableList();
                this.msearchSourceIDs = Internal.newMutableMap();
                this.mobj_ids = Internal.newMutableList();
                this.moriginal_creator_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2960build();
            }

            public Builder chat_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_ids = r1;
                return this;
            }

            public Builder chat_infos(List<ChatInfo> r1) {
                Internal.checkElementsNotNull(r1);
                this.mchat_infos = r1;
                return this;
            }

            public Builder create_time_range(TimeRange r1) {
                this.mcreate_time_range = r1;
                return this;
            }

            public Builder creator_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mcreator_ids = r1;
                return this;
            }

            public Builder cross_language(Boolean r1) {
                this.mcross_language = r1;
                return this;
            }

            public Builder enable_extended_search(Boolean r1) {
                this.menable_extended_search = r1;
                return this;
            }

            public Builder file_types(List<FileType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfile_types = r1;
                return this;
            }

            public Builder from_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfrom_ids = r1;
                return this;
            }

            public Builder obj_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mobj_ids = r1;
                return this;
            }

            public Builder onlyTitle(Boolean r1) {
                this.monlyTitle = r1;
                return this;
            }

            public Builder only_comment(Boolean r1) {
                this.monly_comment = r1;
                return this;
            }

            public Builder openEndTime(Long r1) {
                this.mopenEndTime = r1;
                return this;
            }

            public Builder openStartTime(Long r1) {
                this.mopenStartTime = r1;
                return this;
            }

            public Builder original_creator_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.moriginal_creator_ids = r1;
                return this;
            }

            public Builder searchSourceIDs(Map<String, SearchSourceIDs> r1) {
                Internal.checkElementsNotNull(r1);
                this.msearchSourceIDs = r1;
                return this;
            }

            public Builder search_favourite(Boolean r1) {
                this.msearch_favourite = r1;
                return this;
            }

            public Builder sharer_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.msharer_ids = r1;
                return this;
            }

            public Builder sortType(DocSortRuleType r1) {
                this.msortType = r1;
                return this;
            }

            public Builder space_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mspace_ids = r1;
                return this;
            }

            public Builder time_range(TimeRange r1) {
                this.mtime_range = r1;
                return this;
            }

            public Builder type(List<DocType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mtype = r1;
                return this;
            }

            public Builder use_extended_search_v2(Boolean r1) {
                this.muse_extended_search_v2 = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_WikiFilter extends ProtoAdapter<WikiFilter> {
            private final ProtoAdapter<Map<String, SearchSourceIDs>> msearchSourceIDs;

            public ProtoAdapter_WikiFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, WikiFilter.class);
                this.msearchSourceIDs = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, SearchSourceIDs.ADAPTER);
            }

            public WikiFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                Boolean r1 = Boolean.FALSE;
                r0.monlyTitle = r1;
                r0.mopenStartTime = 0L;
                r0.mopenEndTime = 0L;
                r0.monly_comment = r1;
                r0.msearch_favourite = r1;
                r0.mcross_language = r1;
                r0.menable_extended_search = r1;
                r0.muse_extended_search_v2 = r1;
                long r2 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L38;
                switch(r3) {
                    case 1: goto L37;
                    case 2: goto L36;
                    case 3: goto L42;
                    case 4: goto L31;
                    case 5: goto L30;
                    case 6: goto L29;
                    case 7: goto L28;
                    case 8: goto L27;
                    case 9: goto L40;
                    case 10: goto L22;
                    case 11: goto L44;
                    case 12: goto L17;
                    case 13: goto L16;
                    case 14: goto L15;
                    case 15: goto L14;
                    case 16: goto L13;
                    case 17: goto L6;
                    case 18: goto L12;
                    case 19: goto L11;
                    case 20: goto L10;
                    case 21: goto L9;
                    case 22: goto L8;
                    case 23: goto L7;
                    default: goto L6;
                };
            L40:
                r0.msortType = (DocSortRuleType) DocSortRuleType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
            L25:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L42:
                r0.mtype.add((DocType) DocType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
            L34:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L44:
                r0.mfile_types.add((FileType) FileType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            L20:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.moriginal_creator_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L8:
                r0.mobj_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L9:
                r0.mcreate_time_range = (TimeRange) TimeRange.ADAPTER.decode(r9);
                goto L3
            L10:
                r0.msearchSourceIDs.putAll((Map) this.msearchSourceIDs.decode(r9));
                goto L3
            L11:
                r0.mchat_infos.add((ChatInfo) ChatInfo.ADAPTER.decode(r9));
                goto L3
            L12:
                r0.mtime_range = (TimeRange) TimeRange.ADAPTER.decode(r9);
                goto L3
            L13:
                r0.muse_extended_search_v2 = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L14:
                r0.menable_extended_search = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L15:
                r0.mcross_language = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L16:
                r0.mspace_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L17:
                r0.msearch_favourite = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L22:
                r0.mfrom_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L27:
                r0.monly_comment = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L28:
                r0.msharer_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L29:
                r0.mopenEndTime = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L30:
                r0.mopenStartTime = (Long) ProtoAdapter.INT64.decode(r9);
                goto L3
            L31:
                r0.monlyTitle = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L36:
                r0.mchat_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L37:
                r0.mcreator_ids.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L38:
                r9.endMessage(r2);
                return r0.m2960build();
            }

            public int encodedSize(WikiFilter r7) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = (r0.asRepeated().encodedSizeWithTag(1, r7.mcreator_ids) + r0.asRepeated().encodedSizeWithTag(2, r7.mchat_ids)) + DocType.ADAPTER.asRepeated().encodedSizeWithTag(3, r7.mtype);
                Boolean r2 = r7.monlyTitle;
                int r3 = 0;
                if (r2 == null) goto L5;
                int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r2);
            L6:
                int r5 = r1 + r4;
                Long r6 = r7.mopenStartTime;
                if (r6 == null) goto L9;
                int r8 = ProtoAdapter.INT64.encodedSizeWithTag(5, r6);
            L10:
                int r9 = r5 + r8;
                Long r10 = r7.mopenEndTime;
                if (r10 == null) goto L13;
                int r11 = ProtoAdapter.INT64.encodedSizeWithTag(6, r10);
            L14:
                int r12 = (r9 + r11) + r0.asRepeated().encodedSizeWithTag(7, r7.msharer_ids);
                Boolean r13 = r7.monly_comment;
                if (r13 == null) goto L17;
                int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r13);
            L18:
                int r15 = r12 + r14;
                DocSortRuleType r16 = r7.msortType;
                if (r16 == null) goto L21;
                int r17 = DocSortRuleType.ADAPTER.encodedSizeWithTag(9, r16);
            L22:
                int r18 = ((r15 + r17) + r0.asRepeated().encodedSizeWithTag(10, r7.mfrom_ids)) + FileType.ADAPTER.asRepeated().encodedSizeWithTag(11, r7.mfile_types);
                Boolean r19 = r7.msearch_favourite;
                if (r19 == null) goto L25;
                int r20 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r19);
            L26:
                int r21 = (r18 + r20) + r0.asRepeated().encodedSizeWithTag(13, r7.mspace_ids);
                Boolean r22 = r7.mcross_language;
                if (r22 == null) goto L29;
                int r23 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r22);
            L30:
                int r24 = r21 + r23;
                Boolean r25 = r7.menable_extended_search;
                if (r25 == null) goto L33;
                int r26 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r25);
            L34:
                int r27 = r24 + r26;
                Boolean r28 = r7.muse_extended_search_v2;
                if (r28 == null) goto L37;
                int r29 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r28);
            L38:
                int r30 = r27 + r29;
                TimeRange r31 = r7.mtime_range;
                if (r31 == null) goto L41;
                int r32 = TimeRange.ADAPTER.encodedSizeWithTag(18, r31);
            L42:
                int r33 = ((r30 + r32) + ChatInfo.ADAPTER.asRepeated().encodedSizeWithTag(19, r7.mchat_infos)) + this.msearchSourceIDs.encodedSizeWithTag(20, r7.msearchSourceIDs);
                TimeRange r34 = r7.mcreate_time_range;
                if (r34 == null) goto L46;
                r3 = TimeRange.ADAPTER.encodedSizeWithTag(21, r34);
            L46:
                return (((r33 + r3) + r0.asRepeated().encodedSizeWithTag(22, r7.mobj_ids)) + r0.asRepeated().encodedSizeWithTag(23, r7.moriginal_creator_ids)) + r7.unknownFields().size();
            L41:
                r32 = 0;
                goto L42
            L37:
                r29 = 0;
                goto L38
            L33:
                r26 = 0;
                goto L34
            L29:
                r23 = 0;
                goto L30
            L25:
                r20 = 0;
                goto L26
            L21:
                r17 = 0;
                goto L22
            L17:
                r14 = 0;
                goto L18
            L13:
                r11 = 0;
                goto L14
            L9:
                r8 = 0;
                goto L10
            L5:
                r4 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2961decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((WikiFilter) r1);
            }

            public void encode(ProtoWriter r5, WikiFilter r6) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.asRepeated().encodeWithTag(r5, 1, r6.mcreator_ids);
                r0.asRepeated().encodeWithTag(r5, 2, r6.mchat_ids);
                DocType.ADAPTER.asRepeated().encodeWithTag(r5, 3, r6.mtype);
                Boolean r1 = r6.monlyTitle;
                if (r1 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r5, 4, r1);
            L5:
                Long r2 = r6.mopenStartTime;
                if (r2 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r5, 5, r2);
            L8:
                Long r3 = r6.mopenEndTime;
                if (r3 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r5, 6, r3);
            L11:
                r0.asRepeated().encodeWithTag(r5, 7, r6.msharer_ids);
                Boolean r4 = r6.monly_comment;
                if (r4 == null) goto L14;
                ProtoAdapter.BOOL.encodeWithTag(r5, 8, r4);
            L14:
                DocSortRuleType r7 = r6.msortType;
                if (r7 == null) goto L17;
                DocSortRuleType.ADAPTER.encodeWithTag(r5, 9, r7);
            L17:
                r0.asRepeated().encodeWithTag(r5, 10, r6.mfrom_ids);
                FileType.ADAPTER.asRepeated().encodeWithTag(r5, 11, r6.mfile_types);
                Boolean r8 = r6.msearch_favourite;
                if (r8 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r5, 12, r8);
            L20:
                r0.asRepeated().encodeWithTag(r5, 13, r6.mspace_ids);
                Boolean r9 = r6.mcross_language;
                if (r9 == null) goto L23;
                ProtoAdapter.BOOL.encodeWithTag(r5, 14, r9);
            L23:
                Boolean r10 = r6.menable_extended_search;
                if (r10 == null) goto L26;
                ProtoAdapter.BOOL.encodeWithTag(r5, 15, r10);
            L26:
                Boolean r11 = r6.muse_extended_search_v2;
                if (r11 == null) goto L29;
                ProtoAdapter.BOOL.encodeWithTag(r5, 16, r11);
            L29:
                TimeRange r12 = r6.mtime_range;
                if (r12 == null) goto L32;
                TimeRange.ADAPTER.encodeWithTag(r5, 18, r12);
            L32:
                ChatInfo.ADAPTER.asRepeated().encodeWithTag(r5, 19, r6.mchat_infos);
                this.msearchSourceIDs.encodeWithTag(r5, 20, r6.msearchSourceIDs);
                TimeRange r13 = r6.mcreate_time_range;
                if (r13 == null) goto L35;
                TimeRange.ADAPTER.encodeWithTag(r5, 21, r13);
            L35:
                r0.asRepeated().encodeWithTag(r5, 22, r6.mobj_ids);
                r0.asRepeated().encodeWithTag(r5, 23, r6.moriginal_creator_ids);
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (WikiFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_WikiFilter();
            FIELD_OPTIONS_MCREATOR_IDS = new FieldOptions.Builder().id("user_id").build();
            FIELD_OPTIONS_MCHAT_IDS = new FieldOptions.Builder().id("chat_id").build();
            FIELD_OPTIONS_MSHARER_IDS = new FieldOptions.Builder().id("user_id").build();
            FIELD_OPTIONS_MFROM_IDS = new FieldOptions.Builder().id("user_id").build();
            FIELD_OPTIONS_MORIGINAL_CREATOR_IDS = new FieldOptions.Builder().id("user_id").build();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_ONLYTITLE = r0;
            DEFAULT_OPENSTARTTIME = 0L;
            DEFAULT_OPENENDTIME = 0L;
            DEFAULT_ONLY_COMMENT = r0;
            DEFAULT_SEARCH_FAVOURITE = r0;
            DEFAULT_CROSS_LANGUAGE = r0;
            DEFAULT_ENABLE_EXTENDED_SEARCH = r0;
            DEFAULT_USE_EXTENDED_SEARCH_V2 = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2959newBuilder() {
            Builder r0 = new Builder();
            r0.mcreator_ids = Internal.copyOf("mcreator_ids", this.mcreator_ids);
            r0.mchat_ids = Internal.copyOf("mchat_ids", this.mchat_ids);
            r0.mtype = Internal.copyOf("mtype", this.mtype);
            r0.monlyTitle = this.monlyTitle;
            r0.mopenStartTime = this.mopenStartTime;
            r0.mopenEndTime = this.mopenEndTime;
            r0.msharer_ids = Internal.copyOf("msharer_ids", this.msharer_ids);
            r0.monly_comment = this.monly_comment;
            r0.msortType = this.msortType;
            r0.mfrom_ids = Internal.copyOf("mfrom_ids", this.mfrom_ids);
            r0.mfile_types = Internal.copyOf("mfile_types", this.mfile_types);
            r0.msearch_favourite = this.msearch_favourite;
            r0.mspace_ids = Internal.copyOf("mspace_ids", this.mspace_ids);
            r0.mcross_language = this.mcross_language;
            r0.menable_extended_search = this.menable_extended_search;
            r0.muse_extended_search_v2 = this.muse_extended_search_v2;
            r0.mtime_range = this.mtime_range;
            r0.mchat_infos = Internal.copyOf("mchat_infos", this.mchat_infos);
            r0.msearchSourceIDs = Internal.copyOf("msearchSourceIDs", this.msearchSourceIDs);
            r0.mcreate_time_range = this.mcreate_time_range;
            r0.mobj_ids = Internal.copyOf("mobj_ids", this.mobj_ids);
            r0.moriginal_creator_ids = Internal.copyOf("moriginal_creator_ids", this.moriginal_creator_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return WikiFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2959newBuilder();
        }

        public WikiFilter(List<String> r25, List<String> r26, List<DocType> r27, Boolean r28, Long r29, Long r30, List<String> r31, Boolean r32, DocSortRuleType r33, List<String> r34, List<FileType> r35, Boolean r36, List<String> r37, Boolean r38, Boolean r39, Boolean r40, TimeRange r41, List<ChatInfo> r42, Map<String, SearchSourceIDs> r43, TimeRange r44, List<String> r45, List<String> r46) {
            this(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, ByteString.EMPTY);
        }

        public WikiFilter(List<String> r4, List<String> r5, List<DocType> r6, Boolean r7, Long r8, Long r9, List<String> r10, Boolean r11, DocSortRuleType r12, List<String> r13, List<FileType> r14, Boolean r15, List<String> r16, Boolean r17, Boolean r18, Boolean r19, TimeRange r20, List<ChatInfo> r21, Map<String, SearchSourceIDs> r22, TimeRange r23, List<String> r24, List<String> r25, ByteString r26) {
            super(ADAPTER, r26);
            this.mcreator_ids = Internal.immutableCopyOf("mcreator_ids", r4);
            this.mchat_ids = Internal.immutableCopyOf("mchat_ids", r5);
            this.mtype = Internal.immutableCopyOf("mtype", r6);
            this.monlyTitle = r7;
            this.mopenStartTime = r8;
            this.mopenEndTime = r9;
            this.msharer_ids = Internal.immutableCopyOf("msharer_ids", r10);
            this.monly_comment = r11;
            this.msortType = r12;
            this.mfrom_ids = Internal.immutableCopyOf("mfrom_ids", r13);
            this.mfile_types = Internal.immutableCopyOf("mfile_types", r14);
            this.msearch_favourite = r15;
            this.mspace_ids = Internal.immutableCopyOf("mspace_ids", r16);
            this.mcross_language = r17;
            this.menable_extended_search = r18;
            this.muse_extended_search_v2 = r19;
            this.mtime_range = r20;
            this.mchat_infos = Internal.immutableCopyOf("mchat_infos", r21);
            this.msearchSourceIDs = Internal.immutableCopyOf("msearchSourceIDs", r22);
            this.mcreate_time_range = r23;
            this.mobj_ids = Internal.immutableCopyOf("mobj_ids", r24);
            this.moriginal_creator_ids = Internal.immutableCopyOf("moriginal_creator_ids", r25);
        }
    }

    public static final class WikiSpaceFilter extends Message<WikiSpaceFilter, Builder> {
        public static final ProtoAdapter<WikiSpaceFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<FilterPaymentType> mwiki_space_payment_type;
        public final Sorter mwiki_space_sorter;
        public final List<WikiSpaceMeta.SpaceType> mwiki_space_types;

        public static final class Builder extends Message.Builder<WikiSpaceFilter, Builder> {
            public List<FilterPaymentType> mwiki_space_payment_type;
            public Sorter mwiki_space_sorter;
            public List<WikiSpaceMeta.SpaceType> mwiki_space_types;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public WikiSpaceFilter m2963build() {
                return new WikiSpaceFilter(this.mwiki_space_types, this.mwiki_space_sorter, this.mwiki_space_payment_type, super.buildUnknownFields());
            }

            public Builder() {
                this.mwiki_space_types = Internal.newMutableList();
                this.mwiki_space_payment_type = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2963build();
            }

            public Builder wiki_space_payment_type(List<FilterPaymentType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mwiki_space_payment_type = r1;
                return this;
            }

            public Builder wiki_space_sorter(Sorter r1) {
                this.mwiki_space_sorter = r1;
                return this;
            }

            public Builder wiki_space_types(List<WikiSpaceMeta.SpaceType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mwiki_space_types = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_WikiSpaceFilter extends ProtoAdapter<WikiSpaceFilter> {
            public ProtoAdapter_WikiSpaceFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, WikiSpaceFilter.class);
            }

            public WikiSpaceFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L24;
                if (r3 != 1) goto L8;
                r0.mwiki_space_types.add((WikiSpaceMeta.SpaceType) WikiSpaceMeta.SpaceType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mwiki_space_sorter = (Sorter) Sorter.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mwiki_space_payment_type.add((FilterPaymentType) FilterPaymentType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L11:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L24:
                r9.endMessage(r1);
                return r0.m2963build();
            }

            public int encodedSize(WikiSpaceFilter r5) {
                int r0 = WikiSpaceMeta.SpaceType.ADAPTER.asRepeated().encodedSizeWithTag(1, r5.mwiki_space_types);
                Sorter r1 = r5.mwiki_space_sorter;
                if (r1 == null) goto L5;
                int r2 = Sorter.ADAPTER.encodedSizeWithTag(2, r1);
            L7:
                return ((r0 + r2) + FilterPaymentType.ADAPTER.asRepeated().encodedSizeWithTag(3, r5.mwiki_space_payment_type)) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2964decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((WikiSpaceFilter) r1);
            }

            public void encode(ProtoWriter r4, WikiSpaceFilter r5) throws IOException {
                WikiSpaceMeta.SpaceType.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mwiki_space_types);
                Sorter r0 = r5.mwiki_space_sorter;
                if (r0 == null) goto L5;
                Sorter.ADAPTER.encodeWithTag(r4, 2, r0);
            L5:
                FilterPaymentType.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mwiki_space_payment_type);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (WikiSpaceFilter) r2);
            }
        }

        public static final enum Sorter extends Enum<Sorter> implements WireEnum {
            private static final /* synthetic */ Sorter[] $VALUES = null;
            public static final ProtoAdapter<Sorter> ADAPTER = null;
            public static final Sorter DEFAULT = null;
            public static final Sorter HOT = null;
            public static final Sorter NEW = null;
            private final int value;

            static {
                Sorter r0 = new Sorter("DEFAULT", 0, 0);
                DEFAULT = r0;
                Sorter r1 = new Sorter("HOT", 1, 1);
                HOT = r1;
                Sorter r3 = new Sorter("NEW", 2, 2);
                NEW = r3;
                $VALUES = new Sorter[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Sorter.class);
            }

            public static Sorter[] values() {
                return (Sorter[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Sorter fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return NEW;
            L12:
                return HOT;
            L14:
                return DEFAULT;
            }

            public static Sorter valueOf(String r1) {
                return (Sorter) a.a(Sorter.class, r1);
            }

            private Sorter(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_WikiSpaceFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2962newBuilder() {
            Builder r0 = new Builder();
            r0.mwiki_space_types = Internal.copyOf("mwiki_space_types", this.mwiki_space_types);
            r0.mwiki_space_sorter = this.mwiki_space_sorter;
            r0.mwiki_space_payment_type = Internal.copyOf("mwiki_space_payment_type", this.mwiki_space_payment_type);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return WikiSpaceFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2962newBuilder();
        }

        public WikiSpaceFilter(List<WikiSpaceMeta.SpaceType> r2, Sorter r3, List<FilterPaymentType> r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public WikiSpaceFilter(List<WikiSpaceMeta.SpaceType> r2, Sorter r3, List<FilterPaymentType> r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mwiki_space_types = Internal.immutableCopyOf("mwiki_space_types", r2);
            this.mwiki_space_sorter = r3;
            this.mwiki_space_payment_type = Internal.immutableCopyOf("mwiki_space_payment_type", r4);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UniversalFilters();
    }

    public UniversalFilters() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2878newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return UniversalFilters.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2878newBuilder();
    }

    public UniversalFilters(ByteString r2) {
        super(ADAPTER, r2);
    }
}
