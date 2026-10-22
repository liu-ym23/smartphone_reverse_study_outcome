package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.DocType;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DocsFilter extends Message<DocsFilter, Builder> {
    public static final ProtoAdapter<DocsFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<DocsFilter, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DocsFilter m2594build() {
            return new DocsFilter(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2594build();
        }
    }

    public static final class ContainerTypeFilter extends Message<ContainerTypeFilter, Builder> {
        public static final ProtoAdapter<ContainerTypeFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ContainerType mcontainer_type;

        public static final class Builder extends Message.Builder<ContainerTypeFilter, Builder> {
            public ContainerType mcontainer_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ContainerTypeFilter m2596build() {
                return new ContainerTypeFilter(this.mcontainer_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2596build();
            }

            public Builder container_type(ContainerType r1) {
                this.mcontainer_type = r1;
                return this;
            }
        }

        public static final enum ContainerType extends Enum<ContainerType> implements WireEnum {
            private static final /* synthetic */ ContainerType[] $VALUES = null;
            public static final ProtoAdapter<ContainerType> ADAPTER = null;
            public static final ContainerType DEFAULT = null;
            public static final ContainerType DOCS = null;
            public static final ContainerType WIKI = null;
            private final int value;

            static {
                ContainerType r0 = new ContainerType("DEFAULT", 0, 0);
                DEFAULT = r0;
                ContainerType r1 = new ContainerType("DOCS", 1, 1);
                DOCS = r1;
                ContainerType r3 = new ContainerType("WIKI", 2, 2);
                WIKI = r3;
                $VALUES = new ContainerType[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(ContainerType.class);
            }

            public static ContainerType[] values() {
                return (ContainerType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static ContainerType fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return WIKI;
            L12:
                return DOCS;
            L14:
                return DEFAULT;
            }

            public static ContainerType valueOf(String r1) {
                return (ContainerType) a.a(ContainerType.class, r1);
            }

            private ContainerType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_ContainerTypeFilter extends ProtoAdapter<ContainerTypeFilter> {
            public ProtoAdapter_ContainerTypeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, ContainerTypeFilter.class);
            }

            public ContainerTypeFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L7;
                r0.mcontainer_type = (ContainerType) ContainerType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
                return r0.m2596build();
            }

            public int encodedSize(ContainerTypeFilter r4) {
                ContainerType r0 = r4.mcontainer_type;
                if (r0 == null) goto L5;
                int r1 = ContainerType.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2597decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ContainerTypeFilter) r1);
            }

            public void encode(ProtoWriter r4, ContainerTypeFilter r5) throws IOException {
                ContainerType r0 = r5.mcontainer_type;
                if (r0 == null) goto L5;
                ContainerType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ContainerTypeFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ContainerTypeFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2595newBuilder() {
            Builder r0 = new Builder();
            r0.mcontainer_type = this.mcontainer_type;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ContainerTypeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2595newBuilder();
        }

        public ContainerTypeFilter(ContainerType r2) {
            this(r2, ByteString.EMPTY);
        }

        public ContainerTypeFilter(ContainerType r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mcontainer_type = r2;
        }
    }

    public static final class EnableExtendedSearch extends Message<EnableExtendedSearch, Builder> {
        public static final ProtoAdapter<EnableExtendedSearch> ADAPTER = null;
        public static final Boolean DEFAULT_ENABLE_EXTENDED_SEARCH = null;
        private static final long serialVersionUID = 0;
        public final Boolean menable_extended_search;

        public static final class Builder extends Message.Builder<EnableExtendedSearch, Builder> {
            public Boolean menable_extended_search;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public EnableExtendedSearch m2599build() {
                return new EnableExtendedSearch(this.menable_extended_search, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2599build();
            }

            public Builder enable_extended_search(Boolean r1) {
                this.menable_extended_search = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_EnableExtendedSearch extends ProtoAdapter<EnableExtendedSearch> {
            public ProtoAdapter_EnableExtendedSearch() {
                super(FieldEncoding.LENGTH_DELIMITED, EnableExtendedSearch.class);
            }

            public EnableExtendedSearch decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.menable_extended_search = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.menable_extended_search = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2599build();
            }

            public int encodedSize(EnableExtendedSearch r4) {
                Boolean r0 = r4.menable_extended_search;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2600decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((EnableExtendedSearch) r1);
            }

            public void encode(ProtoWriter r4, EnableExtendedSearch r5) throws IOException {
                Boolean r0 = r5.menable_extended_search;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (EnableExtendedSearch) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EnableExtendedSearch();
            DEFAULT_ENABLE_EXTENDED_SEARCH = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2598newBuilder() {
            Builder r0 = new Builder();
            r0.menable_extended_search = this.menable_extended_search;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return EnableExtendedSearch.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2598newBuilder();
        }

        public EnableExtendedSearch(Boolean r2) {
            this(r2, ByteString.EMPTY);
        }

        public EnableExtendedSearch(Boolean r2, ByteString r3) {
            super(ADAPTER, r3);
            this.menable_extended_search = r2;
        }
    }

    public static final class FromUserFilter extends Message<FromUserFilter, Builder> {
        public static final ProtoAdapter<FromUserFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> muser_ids;

        public static final class Builder extends Message.Builder<FromUserFilter, Builder> {
            public List<String> muser_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public FromUserFilter m2602build() {
                return new FromUserFilter(this.muser_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.muser_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2602build();
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
                return r0.m2602build();
            }

            public int encodedSize(FromUserFilter r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.muser_ids) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2603decode(ProtoReader r1) throws IOException {
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
        public Builder m2601newBuilder() {
            Builder r0 = new Builder();
            r0.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return FromUserFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2601newBuilder();
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
            public InChatFilter m2605build() {
                return new InChatFilter(this.mgroup_chat_ids, this.mp2p_chatter_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mgroup_chat_ids = Internal.newMutableList();
                this.mp2p_chatter_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2605build();
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
                return r0.m2605build();
            }

            public int encodedSize(InChatFilter r5) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                return (r0.asRepeated().encodedSizeWithTag(1, r5.mgroup_chat_ids) + r0.asRepeated().encodedSizeWithTag(2, r5.mp2p_chatter_ids)) + r5.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2606decode(ProtoReader r1) throws IOException {
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
        public Builder m2604newBuilder() {
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
            return m2604newBuilder();
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

    public static final class InFolderFilter extends Message<InFolderFilter, Builder> {
        public static final ProtoAdapter<InFolderFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mfolder_tokens;

        public static final class Builder extends Message.Builder<InFolderFilter, Builder> {
            public List<String> mfolder_tokens;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public InFolderFilter m2608build() {
                return new InFolderFilter(this.mfolder_tokens, super.buildUnknownFields());
            }

            public Builder() {
                this.mfolder_tokens = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2608build();
            }

            public Builder folder_tokens(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfolder_tokens = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_InFolderFilter extends ProtoAdapter<InFolderFilter> {
            public ProtoAdapter_InFolderFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, InFolderFilter.class);
            }

            public InFolderFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mfolder_tokens.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2608build();
            }

            public int encodedSize(InFolderFilter r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.mfolder_tokens) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2609decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((InFolderFilter) r1);
            }

            public void encode(ProtoWriter r4, InFolderFilter r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.mfolder_tokens);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (InFolderFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_InFolderFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2607newBuilder() {
            Builder r0 = new Builder();
            r0.mfolder_tokens = Internal.copyOf("mfolder_tokens", this.mfolder_tokens);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return InFolderFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2607newBuilder();
        }

        public InFolderFilter(List<String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public InFolderFilter(List<String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mfolder_tokens = Internal.immutableCopyOf("mfolder_tokens", r2);
        }
    }

    public static final class InWikiSpaceFilter extends Message<InWikiSpaceFilter, Builder> {
        public static final ProtoAdapter<InWikiSpaceFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mspace_ids;

        public static final class Builder extends Message.Builder<InWikiSpaceFilter, Builder> {
            public List<String> mspace_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public InWikiSpaceFilter m2611build() {
                return new InWikiSpaceFilter(this.mspace_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mspace_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2611build();
            }

            public Builder space_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.mspace_ids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_InWikiSpaceFilter extends ProtoAdapter<InWikiSpaceFilter> {
            public ProtoAdapter_InWikiSpaceFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, InWikiSpaceFilter.class);
            }

            public InWikiSpaceFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mspace_ids.add((String) ProtoAdapter.STRING.decode(r7));
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2611build();
            }

            public int encodedSize(InWikiSpaceFilter r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.mspace_ids) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2612decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((InWikiSpaceFilter) r1);
            }

            public void encode(ProtoWriter r4, InWikiSpaceFilter r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.mspace_ids);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (InWikiSpaceFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_InWikiSpaceFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2610newBuilder() {
            Builder r0 = new Builder();
            r0.mspace_ids = Internal.copyOf("mspace_ids", this.mspace_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return InWikiSpaceFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2610newBuilder();
        }

        public InWikiSpaceFilter(List<String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public InWikiSpaceFilter(List<String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mspace_ids = Internal.immutableCopyOf("mspace_ids", r2);
        }
    }

    public static final class MatchTypeFilter extends Message<MatchTypeFilter, Builder> {
        public static final ProtoAdapter<MatchTypeFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final MatchType mmatch_type;

        public static final class Builder extends Message.Builder<MatchTypeFilter, Builder> {
            public MatchType mmatch_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public MatchTypeFilter m2614build() {
                return new MatchTypeFilter(this.mmatch_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2614build();
            }

            public Builder match_type(MatchType r1) {
                this.mmatch_type = r1;
                return this;
            }
        }

        public static final enum MatchType extends Enum<MatchType> implements WireEnum {
            private static final /* synthetic */ MatchType[] $VALUES = null;
            public static final ProtoAdapter<MatchType> ADAPTER = null;
            public static final MatchType DEFAULT = null;
            public static final MatchType ONLY_COMMENT = null;
            public static final MatchType ONLY_TITLE = null;
            public static final MatchType TRANSLATE_EN_TO_CN = null;
            private final int value;

            static {
                MatchType r0 = new MatchType("DEFAULT", 0, 0);
                DEFAULT = r0;
                MatchType r1 = new MatchType("ONLY_TITLE", 1, 1);
                ONLY_TITLE = r1;
                MatchType r3 = new MatchType("ONLY_COMMENT", 2, 2);
                ONLY_COMMENT = r3;
                MatchType r5 = new MatchType("TRANSLATE_EN_TO_CN", 3, 3);
                TRANSLATE_EN_TO_CN = r5;
                $VALUES = new MatchType[]{r0, r1, r3, r5};
                ADAPTER = ProtoAdapter.newEnumAdapter(MatchType.class);
            }

            public static MatchType[] values() {
                return (MatchType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static MatchType fromValue(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return TRANSLATE_EN_TO_CN;
            L14:
                return ONLY_COMMENT;
            L16:
                return ONLY_TITLE;
            L18:
                return DEFAULT;
            }

            public static MatchType valueOf(String r1) {
                return (MatchType) a.a(MatchType.class, r1);
            }

            private MatchType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_MatchTypeFilter extends ProtoAdapter<MatchTypeFilter> {
            public ProtoAdapter_MatchTypeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, MatchTypeFilter.class);
            }

            public MatchTypeFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L7;
                r0.mmatch_type = (MatchType) MatchType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
                return r0.m2614build();
            }

            public int encodedSize(MatchTypeFilter r4) {
                MatchType r0 = r4.mmatch_type;
                if (r0 == null) goto L5;
                int r1 = MatchType.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2615decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((MatchTypeFilter) r1);
            }

            public void encode(ProtoWriter r4, MatchTypeFilter r5) throws IOException {
                MatchType r0 = r5.mmatch_type;
                if (r0 == null) goto L5;
                MatchType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (MatchTypeFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_MatchTypeFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2613newBuilder() {
            Builder r0 = new Builder();
            r0.mmatch_type = this.mmatch_type;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return MatchTypeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2613newBuilder();
        }

        public MatchTypeFilter(MatchType r2) {
            this(r2, ByteString.EMPTY);
        }

        public MatchTypeFilter(MatchType r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mmatch_type = r2;
        }
    }

    public static final class ObjectTypeFilter extends Message<ObjectTypeFilter, Builder> {
        public static final ProtoAdapter<ObjectTypeFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<DocType> mobject_types;

        public static final class Builder extends Message.Builder<ObjectTypeFilter, Builder> {
            public List<DocType> mobject_types;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ObjectTypeFilter m2617build() {
                return new ObjectTypeFilter(this.mobject_types, super.buildUnknownFields());
            }

            public Builder() {
                this.mobject_types = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2617build();
            }

            public Builder object_types(List<DocType> r1) {
                Internal.checkElementsNotNull(r1);
                this.mobject_types = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ObjectTypeFilter extends ProtoAdapter<ObjectTypeFilter> {
            public ProtoAdapter_ObjectTypeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, ObjectTypeFilter.class);
            }

            public ObjectTypeFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L7;
                r0.mobject_types.add((DocType) DocType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
                return r0.m2617build();
            }

            public int encodedSize(ObjectTypeFilter r4) {
                return DocType.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.mobject_types) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2618decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ObjectTypeFilter) r1);
            }

            public void encode(ProtoWriter r4, ObjectTypeFilter r5) throws IOException {
                DocType.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.mobject_types);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ObjectTypeFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ObjectTypeFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2616newBuilder() {
            Builder r0 = new Builder();
            r0.mobject_types = Internal.copyOf("mobject_types", this.mobject_types);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ObjectTypeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2616newBuilder();
        }

        public ObjectTypeFilter(List<DocType> r2) {
            this(r2, ByteString.EMPTY);
        }

        public ObjectTypeFilter(List<DocType> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mobject_types = Internal.immutableCopyOf("mobject_types", r2);
        }
    }

    public static final class OpenTimeRangeFilter extends Message<OpenTimeRangeFilter, Builder> {
        public static final ProtoAdapter<OpenTimeRangeFilter> ADAPTER = null;
        public static final Long DEFAULT_CUSTOMIZED_END_TIME = null;
        public static final Long DEFAULT_CUSTOMIZED_START_TIME = null;
        private static final long serialVersionUID = 0;
        public final Long mcustomized_end_time;
        public final Long mcustomized_start_time;
        public final TimeRangeType mtime_range_type;

        public static final class Builder extends Message.Builder<OpenTimeRangeFilter, Builder> {
            public Long mcustomized_end_time;
            public Long mcustomized_start_time;
            public TimeRangeType mtime_range_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public OpenTimeRangeFilter m2620build() {
                return new OpenTimeRangeFilter(this.mtime_range_type, this.mcustomized_start_time, this.mcustomized_end_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2620build();
            }

            public Builder customized_end_time(Long r1) {
                this.mcustomized_end_time = r1;
                return this;
            }

            public Builder customized_start_time(Long r1) {
                this.mcustomized_start_time = r1;
                return this;
            }

            public Builder time_range_type(TimeRangeType r1) {
                this.mtime_range_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_OpenTimeRangeFilter extends ProtoAdapter<OpenTimeRangeFilter> {
            public ProtoAdapter_OpenTimeRangeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, OpenTimeRangeFilter.class);
            }

            public OpenTimeRangeFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mcustomized_start_time = 0L;
                r0.mcustomized_end_time = 0L;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L18;
                if (r3 != 1) goto L8;
                r0.mtime_range_type = (TimeRangeType) TimeRangeType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
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
                return r0.m2620build();
            }

            public int encodedSize(OpenTimeRangeFilter r6) {
                TimeRangeType r0 = r6.mtime_range_type;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = TimeRangeType.ADAPTER.encodedSizeWithTag(1, r0);
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
            public /* bridge */ /* synthetic */ Object m2621decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((OpenTimeRangeFilter) r1);
            }

            public void encode(ProtoWriter r4, OpenTimeRangeFilter r5) throws IOException {
                TimeRangeType r0 = r5.mtime_range_type;
                if (r0 == null) goto L5;
                TimeRangeType.ADAPTER.encodeWithTag(r4, 1, r0);
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
                encode(r1, (OpenTimeRangeFilter) r2);
            }
        }

        public static final enum TimeRangeType extends Enum<TimeRangeType> implements WireEnum {
            private static final /* synthetic */ TimeRangeType[] $VALUES = null;
            public static final ProtoAdapter<TimeRangeType> ADAPTER = null;
            public static final TimeRangeType CUSTOMIZED = null;
            public static final TimeRangeType DEFAULT = null;
            public static final TimeRangeType LAST_ONE_DAY = null;
            public static final TimeRangeType LAST_ONE_MONTH = null;
            public static final TimeRangeType LAST_ONE_WEEK = null;
            public static final TimeRangeType LAST_THREE_MONTH = null;
            private final int value;

            static {
                TimeRangeType r0 = new TimeRangeType("DEFAULT", 0, 0);
                DEFAULT = r0;
                TimeRangeType r1 = new TimeRangeType("LAST_ONE_DAY", 1, 1);
                LAST_ONE_DAY = r1;
                TimeRangeType r3 = new TimeRangeType("LAST_ONE_WEEK", 2, 2);
                LAST_ONE_WEEK = r3;
                TimeRangeType r5 = new TimeRangeType("LAST_ONE_MONTH", 3, 3);
                LAST_ONE_MONTH = r5;
                TimeRangeType r7 = new TimeRangeType("LAST_THREE_MONTH", 4, 4);
                LAST_THREE_MONTH = r7;
                TimeRangeType r9 = new TimeRangeType("CUSTOMIZED", 5, 5);
                CUSTOMIZED = r9;
                $VALUES = new TimeRangeType[]{r0, r1, r3, r5, r7, r9};
                ADAPTER = ProtoAdapter.newEnumAdapter(TimeRangeType.class);
            }

            public static TimeRangeType[] values() {
                return (TimeRangeType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static TimeRangeType fromValue(int r1) {
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
                return LAST_THREE_MONTH;
            L20:
                return LAST_ONE_MONTH;
            L22:
                return LAST_ONE_WEEK;
            L24:
                return LAST_ONE_DAY;
            L26:
                return DEFAULT;
            }

            public static TimeRangeType valueOf(String r1) {
                return (TimeRangeType) a.a(TimeRangeType.class, r1);
            }

            private TimeRangeType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OpenTimeRangeFilter();
            DEFAULT_CUSTOMIZED_START_TIME = 0L;
            DEFAULT_CUSTOMIZED_END_TIME = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2619newBuilder() {
            Builder r0 = new Builder();
            r0.mtime_range_type = this.mtime_range_type;
            r0.mcustomized_start_time = this.mcustomized_start_time;
            r0.mcustomized_end_time = this.mcustomized_end_time;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return OpenTimeRangeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2619newBuilder();
        }

        public OpenTimeRangeFilter(TimeRangeType r2, Long r3, Long r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public OpenTimeRangeFilter(TimeRangeType r2, Long r3, Long r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mtime_range_type = r2;
            this.mcustomized_start_time = r3;
            this.mcustomized_end_time = r4;
        }
    }

    public static final class OwnerFilter extends Message<OwnerFilter, Builder> {
        public static final ProtoAdapter<OwnerFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> muser_ids;

        public static final class Builder extends Message.Builder<OwnerFilter, Builder> {
            public List<String> muser_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public OwnerFilter m2623build() {
                return new OwnerFilter(this.muser_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.muser_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2623build();
            }

            public Builder user_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.muser_ids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_OwnerFilter extends ProtoAdapter<OwnerFilter> {
            public ProtoAdapter_OwnerFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, OwnerFilter.class);
            }

            public OwnerFilter decode(ProtoReader r7) throws IOException {
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
                return r0.m2623build();
            }

            public int encodedSize(OwnerFilter r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.muser_ids) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2624decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((OwnerFilter) r1);
            }

            public void encode(ProtoWriter r4, OwnerFilter r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.muser_ids);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (OwnerFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OwnerFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2622newBuilder() {
            Builder r0 = new Builder();
            r0.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return OwnerFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2622newBuilder();
        }

        public OwnerFilter(List<String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public OwnerFilter(List<String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.muser_ids = Internal.immutableCopyOf("muser_ids", r2);
        }
    }

    public static final class ProtoAdapter_DocsFilter extends ProtoAdapter<DocsFilter> {
        public ProtoAdapter_DocsFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, DocsFilter.class);
        }

        public DocsFilter decode(ProtoReader r7) throws IOException {
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
            return r0.m2594build();
        }

        public int encodedSize(DocsFilter r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2625decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DocsFilter) r1);
        }

        public void encode(ProtoWriter r1, DocsFilter r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DocsFilter) r2);
        }
    }

    public static final class SharerFilter extends Message<SharerFilter, Builder> {
        public static final ProtoAdapter<SharerFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> muser_ids;

        public static final class Builder extends Message.Builder<SharerFilter, Builder> {
            public List<String> muser_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SharerFilter m2627build() {
                return new SharerFilter(this.muser_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.muser_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2627build();
            }

            public Builder user_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.muser_ids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SharerFilter extends ProtoAdapter<SharerFilter> {
            public ProtoAdapter_SharerFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, SharerFilter.class);
            }

            public SharerFilter decode(ProtoReader r7) throws IOException {
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
                return r0.m2627build();
            }

            public int encodedSize(SharerFilter r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.muser_ids) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2628decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SharerFilter) r1);
            }

            public void encode(ProtoWriter r4, SharerFilter r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.muser_ids);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SharerFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SharerFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2626newBuilder() {
            Builder r0 = new Builder();
            r0.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SharerFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2626newBuilder();
        }

        public SharerFilter(List<String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public SharerFilter(List<String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.muser_ids = Internal.immutableCopyOf("muser_ids", r2);
        }
    }

    public static final class Sorter extends Message<Sorter, Builder> {
        public static final ProtoAdapter<Sorter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final SortByField msort_by_field;

        public static final class Builder extends Message.Builder<Sorter, Builder> {
            public SortByField msort_by_field;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Sorter m2630build() {
                return new Sorter(this.msort_by_field, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2630build();
            }

            public Builder sort_by_field(SortByField r1) {
                this.msort_by_field = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Sorter extends ProtoAdapter<Sorter> {
            public ProtoAdapter_Sorter() {
                super(FieldEncoding.LENGTH_DELIMITED, Sorter.class);
            }

            public Sorter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L7;
                r0.msort_by_field = (SortByField) SortByField.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
                return r0.m2630build();
            }

            public int encodedSize(Sorter r4) {
                SortByField r0 = r4.msort_by_field;
                if (r0 == null) goto L5;
                int r1 = SortByField.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2631decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Sorter) r1);
            }

            public void encode(ProtoWriter r4, Sorter r5) throws IOException {
                SortByField r0 = r5.msort_by_field;
                if (r0 == null) goto L5;
                SortByField.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Sorter) r2);
            }
        }

        public static final enum SortByField extends Enum<SortByField> implements WireEnum {
            private static final /* synthetic */ SortByField[] $VALUES = null;
            public static final ProtoAdapter<SortByField> ADAPTER = null;
            public static final SortByField CREATE_TIME = null;
            public static final SortByField DEFAULT = null;
            public static final SortByField EDIT_TIME = null;
            public static final SortByField OPEN_TIME = null;
            private final int value;

            static {
                SortByField r0 = new SortByField("DEFAULT", 0, 0);
                DEFAULT = r0;
                SortByField r1 = new SortByField("OPEN_TIME", 1, 1);
                OPEN_TIME = r1;
                SortByField r3 = new SortByField("EDIT_TIME", 2, 2);
                EDIT_TIME = r3;
                SortByField r5 = new SortByField("CREATE_TIME", 3, 3);
                CREATE_TIME = r5;
                $VALUES = new SortByField[]{r0, r1, r3, r5};
                ADAPTER = ProtoAdapter.newEnumAdapter(SortByField.class);
            }

            public static SortByField[] values() {
                return (SortByField[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static SortByField fromValue(int r1) {
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L16;
                if (r1 == 2) goto L14;
                if (r1 == 3) goto L12;
                return null;
            L12:
                return CREATE_TIME;
            L14:
                return EDIT_TIME;
            L16:
                return OPEN_TIME;
            L18:
                return DEFAULT;
            }

            public static SortByField valueOf(String r1) {
                return (SortByField) a.a(SortByField.class, r1);
            }

            private SortByField(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Sorter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2629newBuilder() {
            Builder r0 = new Builder();
            r0.msort_by_field = this.msort_by_field;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Sorter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2629newBuilder();
        }

        public Sorter(SortByField r2) {
            this(r2, ByteString.EMPTY);
        }

        public Sorter(SortByField r2, ByteString r3) {
            super(ADAPTER, r3);
            this.msort_by_field = r2;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocsFilter();
    }

    public DocsFilter() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2593newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DocsFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2593newBuilder();
    }

    public DocsFilter(ByteString r2) {
        super(ADAPTER, r2);
    }
}
