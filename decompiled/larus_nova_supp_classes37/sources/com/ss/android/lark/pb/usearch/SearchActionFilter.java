package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SearchActionFilter extends Message<SearchActionFilter, Builder> {
    public static final ProtoAdapter<SearchActionFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final MessageFilter.ChatTypeFilter mchat_type_filter;
    public final DocsFilter.ContainerTypeFilter mdocs_container_type;
    public final DocsFilter.FromUserFilter mdocs_from_user;
    public final DocsFilter.InChatFilter mdocs_in_chat;
    public final DocsFilter.InFolderFilter mdocs_in_folder;
    public final DocsFilter.MatchTypeFilter mdocs_match_type;
    public final DocsFilter.ObjectTypeFilter mdocs_object_type;
    public final DocsFilter.OpenTimeRangeFilter mdocs_open_time_range;
    public final DocsFilter.OwnerFilter mdocs_owner;
    public final DocsFilter.SharerFilter mdocs_sharer;
    public final DocsFilter.Sorter mdocs_sorter;
    public final DocsFilter.EnableExtendedSearch menable_extended_search;
    public final GroupChatFilter.IncludeUserFilter mgroup_chat_include_user;
    public final GroupChatFilter.SearchTypeFilter mgroup_chat_search_type;
    public final GroupChatFilter.SortRuleFilter mgroup_chat_sort_type;
    public final MessageFilter.AttachmentFilter mmessage_attachment;
    public final MessageFilter.FromUserFilter mmessage_from_user;
    public final MessageFilter.InChatFilter mmessage_in_chat;
    public final MessageFilter.MatchScopeFilter mmessage_match_scope;
    public final MessageFilter.TimeFilter mmessage_time_range;
    public final MessageFilter.MessageTypeFilter mmessage_type;
    public final MessageFilter.WithUserFilter mmessage_with_user;
    public final OpenSearchFilter.OpenSearchSortFilter mopen_search_sort_filter;
    public final SmartSearchFilter.FromUserFilter msmart_search_from_user;
    public final SmartSearchFilter.InChatFilter msmart_search_in_chat;
    public final SmartSearchFilter.TimeRangeFilter msmart_search_time_range;
    public final SmartSearchFilter.WithUserFilter msmart_search_with_user;
    public final DocsFilter.InWikiSpaceFilter mwikis_in_wiki_space;

    public static final class Builder extends Message.Builder<SearchActionFilter, Builder> {
        public MessageFilter.ChatTypeFilter mchat_type_filter;
        public DocsFilter.ContainerTypeFilter mdocs_container_type;
        public DocsFilter.FromUserFilter mdocs_from_user;
        public DocsFilter.InChatFilter mdocs_in_chat;
        public DocsFilter.InFolderFilter mdocs_in_folder;
        public DocsFilter.MatchTypeFilter mdocs_match_type;
        public DocsFilter.ObjectTypeFilter mdocs_object_type;
        public DocsFilter.OpenTimeRangeFilter mdocs_open_time_range;
        public DocsFilter.OwnerFilter mdocs_owner;
        public DocsFilter.SharerFilter mdocs_sharer;
        public DocsFilter.Sorter mdocs_sorter;
        public DocsFilter.EnableExtendedSearch menable_extended_search;
        public GroupChatFilter.IncludeUserFilter mgroup_chat_include_user;
        public GroupChatFilter.SearchTypeFilter mgroup_chat_search_type;
        public GroupChatFilter.SortRuleFilter mgroup_chat_sort_type;
        public MessageFilter.AttachmentFilter mmessage_attachment;
        public MessageFilter.FromUserFilter mmessage_from_user;
        public MessageFilter.InChatFilter mmessage_in_chat;
        public MessageFilter.MatchScopeFilter mmessage_match_scope;
        public MessageFilter.TimeFilter mmessage_time_range;
        public MessageFilter.MessageTypeFilter mmessage_type;
        public MessageFilter.WithUserFilter mmessage_with_user;
        public OpenSearchFilter.OpenSearchSortFilter mopen_search_sort_filter;
        public SmartSearchFilter.FromUserFilter msmart_search_from_user;
        public SmartSearchFilter.InChatFilter msmart_search_in_chat;
        public SmartSearchFilter.TimeRangeFilter msmart_search_time_range;
        public SmartSearchFilter.WithUserFilter msmart_search_with_user;
        public DocsFilter.InWikiSpaceFilter mwikis_in_wiki_space;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SearchActionFilter m2807build() {
            return new SearchActionFilter(this.msmart_search_from_user, this.msmart_search_in_chat, this.msmart_search_time_range, this.msmart_search_with_user, this.mmessage_time_range, this.mmessage_from_user, this.mmessage_in_chat, this.mmessage_type, this.mmessage_match_scope, this.mchat_type_filter, this.mmessage_with_user, this.mmessage_attachment, this.mgroup_chat_search_type, this.mgroup_chat_include_user, this.mgroup_chat_sort_type, this.mdocs_from_user, this.mdocs_owner, this.mdocs_sharer, this.mdocs_container_type, this.mdocs_object_type, this.mdocs_open_time_range, this.mdocs_match_type, this.mdocs_in_chat, this.mdocs_sorter, this.mdocs_in_folder, this.mwikis_in_wiki_space, this.menable_extended_search, this.mopen_search_sort_filter, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2807build();
        }

        public Builder chat_type_filter(MessageFilter.ChatTypeFilter r1) {
            this.mchat_type_filter = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_container_type(DocsFilter.ContainerTypeFilter r1) {
            this.mdocs_container_type = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_from_user(DocsFilter.FromUserFilter r1) {
            this.mdocs_from_user = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_in_chat(DocsFilter.InChatFilter r1) {
            this.mdocs_in_chat = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_in_folder(DocsFilter.InFolderFilter r1) {
            this.mdocs_in_folder = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_match_type(DocsFilter.MatchTypeFilter r1) {
            this.mdocs_match_type = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_object_type(DocsFilter.ObjectTypeFilter r1) {
            this.mdocs_object_type = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_open_time_range(DocsFilter.OpenTimeRangeFilter r1) {
            this.mdocs_open_time_range = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_owner(DocsFilter.OwnerFilter r1) {
            this.mdocs_owner = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_sharer(DocsFilter.SharerFilter r1) {
            this.mdocs_sharer = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder docs_sorter(DocsFilter.Sorter r1) {
            this.mdocs_sorter = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder enable_extended_search(DocsFilter.EnableExtendedSearch r1) {
            this.menable_extended_search = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder group_chat_include_user(GroupChatFilter.IncludeUserFilter r1) {
            this.mgroup_chat_include_user = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder group_chat_search_type(GroupChatFilter.SearchTypeFilter r1) {
            this.mgroup_chat_search_type = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder group_chat_sort_type(GroupChatFilter.SortRuleFilter r1) {
            this.mgroup_chat_sort_type = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_attachment(MessageFilter.AttachmentFilter r1) {
            this.mmessage_attachment = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_from_user(MessageFilter.FromUserFilter r1) {
            this.mmessage_from_user = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_in_chat(MessageFilter.InChatFilter r1) {
            this.mmessage_in_chat = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_match_scope(MessageFilter.MatchScopeFilter r1) {
            this.mmessage_match_scope = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_time_range(MessageFilter.TimeFilter r1) {
            this.mmessage_time_range = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_type(MessageFilter.MessageTypeFilter r1) {
            this.mmessage_type = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder message_with_user(MessageFilter.WithUserFilter r1) {
            this.mmessage_with_user = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder open_search_sort_filter(OpenSearchFilter.OpenSearchSortFilter r1) {
            this.mopen_search_sort_filter = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            return this;
        }

        public Builder smart_search_from_user(SmartSearchFilter.FromUserFilter r1) {
            this.msmart_search_from_user = r1;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder smart_search_in_chat(SmartSearchFilter.InChatFilter r1) {
            this.msmart_search_in_chat = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder smart_search_time_range(SmartSearchFilter.TimeRangeFilter r1) {
            this.msmart_search_time_range = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder smart_search_with_user(SmartSearchFilter.WithUserFilter r1) {
            this.msmart_search_with_user = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.mwikis_in_wiki_space = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }

        public Builder wikis_in_wiki_space(DocsFilter.InWikiSpaceFilter r1) {
            this.mwikis_in_wiki_space = r1;
            this.msmart_search_from_user = null;
            this.msmart_search_in_chat = null;
            this.msmart_search_time_range = null;
            this.msmart_search_with_user = null;
            this.mmessage_time_range = null;
            this.mmessage_from_user = null;
            this.mmessage_in_chat = null;
            this.mmessage_type = null;
            this.mmessage_match_scope = null;
            this.mchat_type_filter = null;
            this.mmessage_with_user = null;
            this.mmessage_attachment = null;
            this.mgroup_chat_search_type = null;
            this.mgroup_chat_include_user = null;
            this.mgroup_chat_sort_type = null;
            this.mdocs_from_user = null;
            this.mdocs_owner = null;
            this.mdocs_sharer = null;
            this.mdocs_container_type = null;
            this.mdocs_object_type = null;
            this.mdocs_open_time_range = null;
            this.mdocs_match_type = null;
            this.mdocs_in_chat = null;
            this.mdocs_sorter = null;
            this.mdocs_in_folder = null;
            this.menable_extended_search = null;
            this.mopen_search_sort_filter = null;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchActionFilter extends ProtoAdapter<SearchActionFilter> {
        public ProtoAdapter_SearchActionFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchActionFilter.class);
        }

        public SearchActionFilter decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L47;
            if (r3 != 1) goto L8;
            r0.smart_search_from_user((SmartSearchFilter.FromUserFilter) SmartSearchFilter.FromUserFilter.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.smart_search_in_chat((SmartSearchFilter.InChatFilter) SmartSearchFilter.InChatFilter.ADAPTER.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.smart_search_time_range((SmartSearchFilter.TimeRangeFilter) SmartSearchFilter.TimeRangeFilter.ADAPTER.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.smart_search_with_user((SmartSearchFilter.WithUserFilter) SmartSearchFilter.WithUserFilter.ADAPTER.decode(r7));
            goto L3
        L14:
            if (r3 != 44) goto L15;
            r0.open_search_sort_filter((OpenSearchFilter.OpenSearchSortFilter) OpenSearchFilter.OpenSearchSortFilter.ADAPTER.decode(r7));
            goto L3
        L15:
            switch(r3) {
                case 11: goto L41;
                case 12: goto L40;
                case 13: goto L39;
                case 14: goto L38;
                case 15: goto L37;
                case 16: goto L36;
                case 17: goto L35;
                case 18: goto L34;
                default: goto L16;
            };
        L34:
            r0.message_attachment((MessageFilter.AttachmentFilter) MessageFilter.AttachmentFilter.ADAPTER.decode(r7));
            goto L3
        L35:
            r0.message_with_user((MessageFilter.WithUserFilter) MessageFilter.WithUserFilter.ADAPTER.decode(r7));
            goto L3
        L36:
            r0.chat_type_filter((MessageFilter.ChatTypeFilter) MessageFilter.ChatTypeFilter.ADAPTER.decode(r7));
            goto L3
        L37:
            r0.message_match_scope((MessageFilter.MatchScopeFilter) MessageFilter.MatchScopeFilter.ADAPTER.decode(r7));
            goto L3
        L38:
            r0.message_type((MessageFilter.MessageTypeFilter) MessageFilter.MessageTypeFilter.ADAPTER.decode(r7));
            goto L3
        L39:
            r0.message_in_chat((MessageFilter.InChatFilter) MessageFilter.InChatFilter.ADAPTER.decode(r7));
            goto L3
        L40:
            r0.message_from_user((MessageFilter.FromUserFilter) MessageFilter.FromUserFilter.ADAPTER.decode(r7));
            goto L3
        L41:
            r0.message_time_range((MessageFilter.TimeFilter) MessageFilter.TimeFilter.ADAPTER.decode(r7));
            goto L3
        L16:
            switch(r3) {
                case 21: goto L33;
                case 22: goto L32;
                case 23: goto L31;
                default: goto L17;
            };
        L31:
            r0.group_chat_sort_type((GroupChatFilter.SortRuleFilter) GroupChatFilter.SortRuleFilter.ADAPTER.decode(r7));
            goto L3
        L32:
            r0.group_chat_include_user((GroupChatFilter.IncludeUserFilter) GroupChatFilter.IncludeUserFilter.ADAPTER.decode(r7));
            goto L3
        L33:
            r0.group_chat_search_type((GroupChatFilter.SearchTypeFilter) GroupChatFilter.SearchTypeFilter.ADAPTER.decode(r7));
            goto L3
        L17:
            switch(r3) {
                case 31: goto L30;
                case 32: goto L29;
                case 33: goto L28;
                case 34: goto L27;
                case 35: goto L26;
                case 36: goto L25;
                case 37: goto L24;
                case 38: goto L23;
                case 39: goto L22;
                case 40: goto L21;
                case 41: goto L20;
                case 42: goto L19;
                default: goto L18;
            };
        L19:
            r0.enable_extended_search((DocsFilter.EnableExtendedSearch) DocsFilter.EnableExtendedSearch.ADAPTER.decode(r7));
            goto L3
        L20:
            r0.wikis_in_wiki_space((DocsFilter.InWikiSpaceFilter) DocsFilter.InWikiSpaceFilter.ADAPTER.decode(r7));
            goto L3
        L21:
            r0.docs_in_folder((DocsFilter.InFolderFilter) DocsFilter.InFolderFilter.ADAPTER.decode(r7));
            goto L3
        L22:
            r0.docs_sorter((DocsFilter.Sorter) DocsFilter.Sorter.ADAPTER.decode(r7));
            goto L3
        L23:
            r0.docs_in_chat((DocsFilter.InChatFilter) DocsFilter.InChatFilter.ADAPTER.decode(r7));
            goto L3
        L24:
            r0.docs_match_type((DocsFilter.MatchTypeFilter) DocsFilter.MatchTypeFilter.ADAPTER.decode(r7));
            goto L3
        L25:
            r0.docs_open_time_range((DocsFilter.OpenTimeRangeFilter) DocsFilter.OpenTimeRangeFilter.ADAPTER.decode(r7));
            goto L3
        L26:
            r0.docs_object_type((DocsFilter.ObjectTypeFilter) DocsFilter.ObjectTypeFilter.ADAPTER.decode(r7));
            goto L3
        L27:
            r0.docs_container_type((DocsFilter.ContainerTypeFilter) DocsFilter.ContainerTypeFilter.ADAPTER.decode(r7));
            goto L3
        L28:
            r0.docs_sharer((DocsFilter.SharerFilter) DocsFilter.SharerFilter.ADAPTER.decode(r7));
            goto L3
        L29:
            r0.docs_owner((DocsFilter.OwnerFilter) DocsFilter.OwnerFilter.ADAPTER.decode(r7));
            goto L3
        L30:
            r0.docs_from_user((DocsFilter.FromUserFilter) DocsFilter.FromUserFilter.ADAPTER.decode(r7));
            goto L3
        L18:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L47:
            r7.endMessage(r1);
            return r0.m2807build();
        }

        public int encodedSize(SearchActionFilter r6) {
            SmartSearchFilter.FromUserFilter r0 = r6.msmart_search_from_user;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = SmartSearchFilter.FromUserFilter.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            SmartSearchFilter.InChatFilter r3 = r6.msmart_search_in_chat;
            if (r3 == null) goto L9;
            int r4 = SmartSearchFilter.InChatFilter.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            SmartSearchFilter.TimeRangeFilter r7 = r6.msmart_search_time_range;
            if (r7 == null) goto L13;
            int r8 = SmartSearchFilter.TimeRangeFilter.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            SmartSearchFilter.WithUserFilter r10 = r6.msmart_search_with_user;
            if (r10 == null) goto L17;
            int r11 = SmartSearchFilter.WithUserFilter.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            MessageFilter.TimeFilter r13 = r6.mmessage_time_range;
            if (r13 == null) goto L21;
            int r14 = MessageFilter.TimeFilter.ADAPTER.encodedSizeWithTag(11, r13);
        L22:
            int r15 = r12 + r14;
            MessageFilter.FromUserFilter r16 = r6.mmessage_from_user;
            if (r16 == null) goto L25;
            int r17 = MessageFilter.FromUserFilter.ADAPTER.encodedSizeWithTag(12, r16);
        L26:
            int r18 = r15 + r17;
            MessageFilter.InChatFilter r19 = r6.mmessage_in_chat;
            if (r19 == null) goto L29;
            int r20 = MessageFilter.InChatFilter.ADAPTER.encodedSizeWithTag(13, r19);
        L30:
            int r21 = r18 + r20;
            MessageFilter.MessageTypeFilter r22 = r6.mmessage_type;
            if (r22 == null) goto L33;
            int r23 = MessageFilter.MessageTypeFilter.ADAPTER.encodedSizeWithTag(14, r22);
        L34:
            int r24 = r21 + r23;
            MessageFilter.MatchScopeFilter r25 = r6.mmessage_match_scope;
            if (r25 == null) goto L37;
            int r26 = MessageFilter.MatchScopeFilter.ADAPTER.encodedSizeWithTag(15, r25);
        L38:
            int r27 = r24 + r26;
            MessageFilter.ChatTypeFilter r28 = r6.mchat_type_filter;
            if (r28 == null) goto L41;
            int r29 = MessageFilter.ChatTypeFilter.ADAPTER.encodedSizeWithTag(16, r28);
        L42:
            int r30 = r27 + r29;
            MessageFilter.WithUserFilter r31 = r6.mmessage_with_user;
            if (r31 == null) goto L45;
            int r32 = MessageFilter.WithUserFilter.ADAPTER.encodedSizeWithTag(17, r31);
        L46:
            int r33 = r30 + r32;
            MessageFilter.AttachmentFilter r34 = r6.mmessage_attachment;
            if (r34 == null) goto L49;
            int r35 = MessageFilter.AttachmentFilter.ADAPTER.encodedSizeWithTag(18, r34);
        L50:
            int r36 = r33 + r35;
            GroupChatFilter.SearchTypeFilter r37 = r6.mgroup_chat_search_type;
            if (r37 == null) goto L53;
            int r38 = GroupChatFilter.SearchTypeFilter.ADAPTER.encodedSizeWithTag(21, r37);
        L54:
            int r39 = r36 + r38;
            GroupChatFilter.IncludeUserFilter r40 = r6.mgroup_chat_include_user;
            if (r40 == null) goto L57;
            int r41 = GroupChatFilter.IncludeUserFilter.ADAPTER.encodedSizeWithTag(22, r40);
        L58:
            int r42 = r39 + r41;
            GroupChatFilter.SortRuleFilter r43 = r6.mgroup_chat_sort_type;
            if (r43 == null) goto L61;
            int r44 = GroupChatFilter.SortRuleFilter.ADAPTER.encodedSizeWithTag(23, r43);
        L62:
            int r45 = r42 + r44;
            DocsFilter.FromUserFilter r46 = r6.mdocs_from_user;
            if (r46 == null) goto L65;
            int r47 = DocsFilter.FromUserFilter.ADAPTER.encodedSizeWithTag(31, r46);
        L66:
            int r48 = r45 + r47;
            DocsFilter.OwnerFilter r49 = r6.mdocs_owner;
            if (r49 == null) goto L69;
            int r50 = DocsFilter.OwnerFilter.ADAPTER.encodedSizeWithTag(32, r49);
        L70:
            int r51 = r48 + r50;
            DocsFilter.SharerFilter r52 = r6.mdocs_sharer;
            if (r52 == null) goto L73;
            int r53 = DocsFilter.SharerFilter.ADAPTER.encodedSizeWithTag(33, r52);
        L74:
            int r54 = r51 + r53;
            DocsFilter.ContainerTypeFilter r55 = r6.mdocs_container_type;
            if (r55 == null) goto L77;
            int r56 = DocsFilter.ContainerTypeFilter.ADAPTER.encodedSizeWithTag(34, r55);
        L78:
            int r57 = r54 + r56;
            DocsFilter.ObjectTypeFilter r58 = r6.mdocs_object_type;
            if (r58 == null) goto L81;
            int r59 = DocsFilter.ObjectTypeFilter.ADAPTER.encodedSizeWithTag(35, r58);
        L82:
            int r60 = r57 + r59;
            DocsFilter.OpenTimeRangeFilter r61 = r6.mdocs_open_time_range;
            if (r61 == null) goto L85;
            int r62 = DocsFilter.OpenTimeRangeFilter.ADAPTER.encodedSizeWithTag(36, r61);
        L86:
            int r63 = r60 + r62;
            DocsFilter.MatchTypeFilter r64 = r6.mdocs_match_type;
            if (r64 == null) goto L89;
            int r65 = DocsFilter.MatchTypeFilter.ADAPTER.encodedSizeWithTag(37, r64);
        L90:
            int r66 = r63 + r65;
            DocsFilter.InChatFilter r67 = r6.mdocs_in_chat;
            if (r67 == null) goto L93;
            int r68 = DocsFilter.InChatFilter.ADAPTER.encodedSizeWithTag(38, r67);
        L94:
            int r69 = r66 + r68;
            DocsFilter.Sorter r70 = r6.mdocs_sorter;
            if (r70 == null) goto L97;
            int r71 = DocsFilter.Sorter.ADAPTER.encodedSizeWithTag(39, r70);
        L98:
            int r72 = r69 + r71;
            DocsFilter.InFolderFilter r73 = r6.mdocs_in_folder;
            if (r73 == null) goto L101;
            int r74 = DocsFilter.InFolderFilter.ADAPTER.encodedSizeWithTag(40, r73);
        L102:
            int r75 = r72 + r74;
            DocsFilter.InWikiSpaceFilter r76 = r6.mwikis_in_wiki_space;
            if (r76 == null) goto L105;
            int r77 = DocsFilter.InWikiSpaceFilter.ADAPTER.encodedSizeWithTag(41, r76);
        L106:
            int r78 = r75 + r77;
            DocsFilter.EnableExtendedSearch r79 = r6.menable_extended_search;
            if (r79 == null) goto L109;
            int r80 = DocsFilter.EnableExtendedSearch.ADAPTER.encodedSizeWithTag(42, r79);
        L110:
            int r81 = r78 + r80;
            OpenSearchFilter.OpenSearchSortFilter r82 = r6.mopen_search_sort_filter;
            if (r82 == null) goto L114;
            r1 = OpenSearchFilter.OpenSearchSortFilter.ADAPTER.encodedSizeWithTag(44, r82);
        L114:
            return (r81 + r1) + r6.unknownFields().size();
        L109:
            r80 = 0;
            goto L110
        L105:
            r77 = 0;
            goto L106
        L101:
            r74 = 0;
            goto L102
        L97:
            r71 = 0;
            goto L98
        L93:
            r68 = 0;
            goto L94
        L89:
            r65 = 0;
            goto L90
        L85:
            r62 = 0;
            goto L86
        L81:
            r59 = 0;
            goto L82
        L77:
            r56 = 0;
            goto L78
        L73:
            r53 = 0;
            goto L74
        L69:
            r50 = 0;
            goto L70
        L65:
            r47 = 0;
            goto L66
        L61:
            r44 = 0;
            goto L62
        L57:
            r41 = 0;
            goto L58
        L53:
            r38 = 0;
            goto L54
        L49:
            r35 = 0;
            goto L50
        L45:
            r32 = 0;
            goto L46
        L41:
            r29 = 0;
            goto L42
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
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
        public /* bridge */ /* synthetic */ Object m2808decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SearchActionFilter) r1);
        }

        public void encode(ProtoWriter r4, SearchActionFilter r5) throws IOException {
            SmartSearchFilter.FromUserFilter r0 = r5.msmart_search_from_user;
            if (r0 == null) goto L5;
            SmartSearchFilter.FromUserFilter.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            SmartSearchFilter.InChatFilter r1 = r5.msmart_search_in_chat;
            if (r1 == null) goto L8;
            SmartSearchFilter.InChatFilter.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            SmartSearchFilter.TimeRangeFilter r2 = r5.msmart_search_time_range;
            if (r2 == null) goto L11;
            SmartSearchFilter.TimeRangeFilter.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            SmartSearchFilter.WithUserFilter r3 = r5.msmart_search_with_user;
            if (r3 == null) goto L14;
            SmartSearchFilter.WithUserFilter.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            MessageFilter.TimeFilter r6 = r5.mmessage_time_range;
            if (r6 == null) goto L17;
            MessageFilter.TimeFilter.ADAPTER.encodeWithTag(r4, 11, r6);
        L17:
            MessageFilter.FromUserFilter r7 = r5.mmessage_from_user;
            if (r7 == null) goto L20;
            MessageFilter.FromUserFilter.ADAPTER.encodeWithTag(r4, 12, r7);
        L20:
            MessageFilter.InChatFilter r8 = r5.mmessage_in_chat;
            if (r8 == null) goto L23;
            MessageFilter.InChatFilter.ADAPTER.encodeWithTag(r4, 13, r8);
        L23:
            MessageFilter.MessageTypeFilter r9 = r5.mmessage_type;
            if (r9 == null) goto L26;
            MessageFilter.MessageTypeFilter.ADAPTER.encodeWithTag(r4, 14, r9);
        L26:
            MessageFilter.MatchScopeFilter r10 = r5.mmessage_match_scope;
            if (r10 == null) goto L29;
            MessageFilter.MatchScopeFilter.ADAPTER.encodeWithTag(r4, 15, r10);
        L29:
            MessageFilter.ChatTypeFilter r11 = r5.mchat_type_filter;
            if (r11 == null) goto L32;
            MessageFilter.ChatTypeFilter.ADAPTER.encodeWithTag(r4, 16, r11);
        L32:
            MessageFilter.WithUserFilter r12 = r5.mmessage_with_user;
            if (r12 == null) goto L35;
            MessageFilter.WithUserFilter.ADAPTER.encodeWithTag(r4, 17, r12);
        L35:
            MessageFilter.AttachmentFilter r13 = r5.mmessage_attachment;
            if (r13 == null) goto L38;
            MessageFilter.AttachmentFilter.ADAPTER.encodeWithTag(r4, 18, r13);
        L38:
            GroupChatFilter.SearchTypeFilter r14 = r5.mgroup_chat_search_type;
            if (r14 == null) goto L41;
            GroupChatFilter.SearchTypeFilter.ADAPTER.encodeWithTag(r4, 21, r14);
        L41:
            GroupChatFilter.IncludeUserFilter r15 = r5.mgroup_chat_include_user;
            if (r15 == null) goto L44;
            GroupChatFilter.IncludeUserFilter.ADAPTER.encodeWithTag(r4, 22, r15);
        L44:
            GroupChatFilter.SortRuleFilter r16 = r5.mgroup_chat_sort_type;
            if (r16 == null) goto L47;
            GroupChatFilter.SortRuleFilter.ADAPTER.encodeWithTag(r4, 23, r16);
        L47:
            DocsFilter.FromUserFilter r17 = r5.mdocs_from_user;
            if (r17 == null) goto L50;
            DocsFilter.FromUserFilter.ADAPTER.encodeWithTag(r4, 31, r17);
        L50:
            DocsFilter.OwnerFilter r18 = r5.mdocs_owner;
            if (r18 == null) goto L53;
            DocsFilter.OwnerFilter.ADAPTER.encodeWithTag(r4, 32, r18);
        L53:
            DocsFilter.SharerFilter r19 = r5.mdocs_sharer;
            if (r19 == null) goto L56;
            DocsFilter.SharerFilter.ADAPTER.encodeWithTag(r4, 33, r19);
        L56:
            DocsFilter.ContainerTypeFilter r20 = r5.mdocs_container_type;
            if (r20 == null) goto L59;
            DocsFilter.ContainerTypeFilter.ADAPTER.encodeWithTag(r4, 34, r20);
        L59:
            DocsFilter.ObjectTypeFilter r21 = r5.mdocs_object_type;
            if (r21 == null) goto L62;
            DocsFilter.ObjectTypeFilter.ADAPTER.encodeWithTag(r4, 35, r21);
        L62:
            DocsFilter.OpenTimeRangeFilter r22 = r5.mdocs_open_time_range;
            if (r22 == null) goto L65;
            DocsFilter.OpenTimeRangeFilter.ADAPTER.encodeWithTag(r4, 36, r22);
        L65:
            DocsFilter.MatchTypeFilter r23 = r5.mdocs_match_type;
            if (r23 == null) goto L68;
            DocsFilter.MatchTypeFilter.ADAPTER.encodeWithTag(r4, 37, r23);
        L68:
            DocsFilter.InChatFilter r24 = r5.mdocs_in_chat;
            if (r24 == null) goto L71;
            DocsFilter.InChatFilter.ADAPTER.encodeWithTag(r4, 38, r24);
        L71:
            DocsFilter.Sorter r25 = r5.mdocs_sorter;
            if (r25 == null) goto L74;
            DocsFilter.Sorter.ADAPTER.encodeWithTag(r4, 39, r25);
        L74:
            DocsFilter.InFolderFilter r26 = r5.mdocs_in_folder;
            if (r26 == null) goto L77;
            DocsFilter.InFolderFilter.ADAPTER.encodeWithTag(r4, 40, r26);
        L77:
            DocsFilter.InWikiSpaceFilter r27 = r5.mwikis_in_wiki_space;
            if (r27 == null) goto L80;
            DocsFilter.InWikiSpaceFilter.ADAPTER.encodeWithTag(r4, 41, r27);
        L80:
            DocsFilter.EnableExtendedSearch r28 = r5.menable_extended_search;
            if (r28 == null) goto L83;
            DocsFilter.EnableExtendedSearch.ADAPTER.encodeWithTag(r4, 42, r28);
        L83:
            OpenSearchFilter.OpenSearchSortFilter r29 = r5.mopen_search_sort_filter;
            if (r29 == null) goto L86;
            OpenSearchFilter.OpenSearchSortFilter.ADAPTER.encodeWithTag(r4, 44, r29);
        L86:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SearchActionFilter) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchActionFilter();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2806newBuilder() {
        Builder r0 = new Builder();
        r0.msmart_search_from_user = this.msmart_search_from_user;
        r0.msmart_search_in_chat = this.msmart_search_in_chat;
        r0.msmart_search_time_range = this.msmart_search_time_range;
        r0.msmart_search_with_user = this.msmart_search_with_user;
        r0.mmessage_time_range = this.mmessage_time_range;
        r0.mmessage_from_user = this.mmessage_from_user;
        r0.mmessage_in_chat = this.mmessage_in_chat;
        r0.mmessage_type = this.mmessage_type;
        r0.mmessage_match_scope = this.mmessage_match_scope;
        r0.mchat_type_filter = this.mchat_type_filter;
        r0.mmessage_with_user = this.mmessage_with_user;
        r0.mmessage_attachment = this.mmessage_attachment;
        r0.mgroup_chat_search_type = this.mgroup_chat_search_type;
        r0.mgroup_chat_include_user = this.mgroup_chat_include_user;
        r0.mgroup_chat_sort_type = this.mgroup_chat_sort_type;
        r0.mdocs_from_user = this.mdocs_from_user;
        r0.mdocs_owner = this.mdocs_owner;
        r0.mdocs_sharer = this.mdocs_sharer;
        r0.mdocs_container_type = this.mdocs_container_type;
        r0.mdocs_object_type = this.mdocs_object_type;
        r0.mdocs_open_time_range = this.mdocs_open_time_range;
        r0.mdocs_match_type = this.mdocs_match_type;
        r0.mdocs_in_chat = this.mdocs_in_chat;
        r0.mdocs_sorter = this.mdocs_sorter;
        r0.mdocs_in_folder = this.mdocs_in_folder;
        r0.mwikis_in_wiki_space = this.mwikis_in_wiki_space;
        r0.menable_extended_search = this.menable_extended_search;
        r0.mopen_search_sort_filter = this.mopen_search_sort_filter;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SearchActionFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2806newBuilder();
    }

    public SearchActionFilter(SmartSearchFilter.FromUserFilter r31, SmartSearchFilter.InChatFilter r32, SmartSearchFilter.TimeRangeFilter r33, SmartSearchFilter.WithUserFilter r34, MessageFilter.TimeFilter r35, MessageFilter.FromUserFilter r36, MessageFilter.InChatFilter r37, MessageFilter.MessageTypeFilter r38, MessageFilter.MatchScopeFilter r39, MessageFilter.ChatTypeFilter r40, MessageFilter.WithUserFilter r41, MessageFilter.AttachmentFilter r42, GroupChatFilter.SearchTypeFilter r43, GroupChatFilter.IncludeUserFilter r44, GroupChatFilter.SortRuleFilter r45, DocsFilter.FromUserFilter r46, DocsFilter.OwnerFilter r47, DocsFilter.SharerFilter r48, DocsFilter.ContainerTypeFilter r49, DocsFilter.ObjectTypeFilter r50, DocsFilter.OpenTimeRangeFilter r51, DocsFilter.MatchTypeFilter r52, DocsFilter.InChatFilter r53, DocsFilter.Sorter r54, DocsFilter.InFolderFilter r55, DocsFilter.InWikiSpaceFilter r56, DocsFilter.EnableExtendedSearch r57, OpenSearchFilter.OpenSearchSortFilter r58) {
        this(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, ByteString.EMPTY);
    }

    public SearchActionFilter(SmartSearchFilter.FromUserFilter r18, SmartSearchFilter.InChatFilter r19, SmartSearchFilter.TimeRangeFilter r20, SmartSearchFilter.WithUserFilter r21, MessageFilter.TimeFilter r22, MessageFilter.FromUserFilter r23, MessageFilter.InChatFilter r24, MessageFilter.MessageTypeFilter r25, MessageFilter.MatchScopeFilter r26, MessageFilter.ChatTypeFilter r27, MessageFilter.WithUserFilter r28, MessageFilter.AttachmentFilter r29, GroupChatFilter.SearchTypeFilter r30, GroupChatFilter.IncludeUserFilter r31, GroupChatFilter.SortRuleFilter r32, DocsFilter.FromUserFilter r33, DocsFilter.OwnerFilter r34, DocsFilter.SharerFilter r35, DocsFilter.ContainerTypeFilter r36, DocsFilter.ObjectTypeFilter r37, DocsFilter.OpenTimeRangeFilter r38, DocsFilter.MatchTypeFilter r39, DocsFilter.InChatFilter r40, DocsFilter.Sorter r41, DocsFilter.InFolderFilter r42, DocsFilter.InWikiSpaceFilter r43, DocsFilter.EnableExtendedSearch r44, OpenSearchFilter.OpenSearchSortFilter r45, ByteString r46) {
        super(ADAPTER, r46);
        if (Internal.countNonNull(r18, r19, r20, r21, new Object[]{r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45}) > 1) goto L7;
        this.msmart_search_from_user = r18;
        this.msmart_search_in_chat = r19;
        this.msmart_search_time_range = r20;
        this.msmart_search_with_user = r21;
        this.mmessage_time_range = r22;
        this.mmessage_from_user = r23;
        this.mmessage_in_chat = r24;
        this.mmessage_type = r25;
        this.mmessage_match_scope = r26;
        this.mchat_type_filter = r27;
        this.mmessage_with_user = r28;
        this.mmessage_attachment = r29;
        this.mgroup_chat_search_type = r30;
        this.mgroup_chat_include_user = r31;
        this.mgroup_chat_sort_type = r32;
        this.mdocs_from_user = r33;
        this.mdocs_owner = r34;
        this.mdocs_sharer = r35;
        this.mdocs_container_type = r36;
        this.mdocs_object_type = r37;
        this.mdocs_open_time_range = r38;
        this.mdocs_match_type = r39;
        this.mdocs_in_chat = r40;
        this.mdocs_sorter = r41;
        this.mdocs_in_folder = r42;
        this.mwikis_in_wiki_space = r43;
        this.menable_extended_search = r44;
        this.mopen_search_sort_filter = r45;
        return;
    L7:
        throw new IllegalArgumentException("at most one of msmart_search_from_user, msmart_search_in_chat, msmart_search_time_range, msmart_search_with_user, mmessage_time_range, mmessage_from_user, mmessage_in_chat, mmessage_type, mmessage_match_scope, mchat_type_filter, mmessage_with_user, mmessage_attachment, mgroup_chat_search_type, mgroup_chat_include_user, mgroup_chat_sort_type, mdocs_from_user, mdocs_owner, mdocs_sharer, mdocs_container_type, mdocs_object_type, mdocs_open_time_range, mdocs_match_type, mdocs_in_chat, mdocs_sorter, mdocs_in_folder, mwikis_in_wiki_space, menable_extended_search, mopen_search_sort_filter may be non-null");
    }
}
