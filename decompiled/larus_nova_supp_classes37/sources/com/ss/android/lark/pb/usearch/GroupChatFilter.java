package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.GroupSortRuleType;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class GroupChatFilter extends Message<GroupChatFilter, Builder> {
    public static final ProtoAdapter<GroupChatFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<GroupChatFilter, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public GroupChatFilter m2657build() {
            return new GroupChatFilter(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2657build();
        }
    }

    public static final class IncludeUserFilter extends Message<IncludeUserFilter, Builder> {
        public static final ProtoAdapter<IncludeUserFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> muser_ids;

        public static final class Builder extends Message.Builder<IncludeUserFilter, Builder> {
            public List<String> muser_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public IncludeUserFilter m2659build() {
                return new IncludeUserFilter(this.muser_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.muser_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2659build();
            }

            public Builder user_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.muser_ids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_IncludeUserFilter extends ProtoAdapter<IncludeUserFilter> {
            public ProtoAdapter_IncludeUserFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, IncludeUserFilter.class);
            }

            public IncludeUserFilter decode(ProtoReader r7) throws IOException {
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
                return r0.m2659build();
            }

            public int encodedSize(IncludeUserFilter r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.muser_ids) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2660decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((IncludeUserFilter) r1);
            }

            public void encode(ProtoWriter r4, IncludeUserFilter r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.muser_ids);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (IncludeUserFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_IncludeUserFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2658newBuilder() {
            Builder r0 = new Builder();
            r0.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return IncludeUserFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2658newBuilder();
        }

        public IncludeUserFilter(List<String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public IncludeUserFilter(List<String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.muser_ids = Internal.immutableCopyOf("muser_ids", r2);
        }
    }

    public static final class ProtoAdapter_GroupChatFilter extends ProtoAdapter<GroupChatFilter> {
        public ProtoAdapter_GroupChatFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, GroupChatFilter.class);
        }

        public GroupChatFilter decode(ProtoReader r7) throws IOException {
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
            return r0.m2657build();
        }

        public int encodedSize(GroupChatFilter r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2661decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GroupChatFilter) r1);
        }

        public void encode(ProtoWriter r1, GroupChatFilter r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GroupChatFilter) r2);
        }
    }

    public static final class SearchTypeFilter extends Message<SearchTypeFilter, Builder> {
        public static final ProtoAdapter<SearchTypeFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<SearchType> msearch_type;

        public static final class Builder extends Message.Builder<SearchTypeFilter, Builder> {
            public List<SearchType> msearch_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SearchTypeFilter m2663build() {
                return new SearchTypeFilter(this.msearch_type, super.buildUnknownFields());
            }

            public Builder() {
                this.msearch_type = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2663build();
            }

            public Builder search_type(List<SearchType> r1) {
                Internal.checkElementsNotNull(r1);
                this.msearch_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SearchTypeFilter extends ProtoAdapter<SearchTypeFilter> {
            public ProtoAdapter_SearchTypeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, SearchTypeFilter.class);
            }

            public SearchTypeFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L7;
                r0.msearch_type.add((SearchType) SearchType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
                return r0.m2663build();
            }

            public int encodedSize(SearchTypeFilter r4) {
                return SearchType.ADAPTER.asRepeated().encodedSizeWithTag(1, r4.msearch_type) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2664decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SearchTypeFilter) r1);
            }

            public void encode(ProtoWriter r4, SearchTypeFilter r5) throws IOException {
                SearchType.ADAPTER.asRepeated().encodeWithTag(r4, 1, r5.msearch_type);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SearchTypeFilter) r2);
            }
        }

        public static final enum SearchType extends Enum<SearchType> implements WireEnum {
            private static final /* synthetic */ SearchType[] $VALUES = null;
            public static final ProtoAdapter<SearchType> ADAPTER = null;
            public static final SearchType CROSS_TENANT = null;
            public static final SearchType DEFAULT = null;
            public static final SearchType PRIVATE = null;
            public static final SearchType PUBLIC_JOINED = null;
            public static final SearchType PUBLIC_NOT_JOINED = null;
            private final int value;

            static {
                SearchType r0 = new SearchType("DEFAULT", 0, 0);
                DEFAULT = r0;
                SearchType r1 = new SearchType("PRIVATE", 1, 1);
                PRIVATE = r1;
                SearchType r3 = new SearchType("CROSS_TENANT", 2, 2);
                CROSS_TENANT = r3;
                SearchType r5 = new SearchType("PUBLIC_JOINED", 3, 3);
                PUBLIC_JOINED = r5;
                SearchType r7 = new SearchType("PUBLIC_NOT_JOINED", 4, 4);
                PUBLIC_NOT_JOINED = r7;
                $VALUES = new SearchType[]{r0, r1, r3, r5, r7};
                ADAPTER = ProtoAdapter.newEnumAdapter(SearchType.class);
            }

            public static SearchType[] values() {
                return (SearchType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static SearchType fromValue(int r1) {
                if (r1 == 0) goto L22;
                if (r1 == 1) goto L20;
                if (r1 == 2) goto L18;
                if (r1 == 3) goto L16;
                if (r1 == 4) goto L14;
                return null;
            L14:
                return PUBLIC_NOT_JOINED;
            L16:
                return PUBLIC_JOINED;
            L18:
                return CROSS_TENANT;
            L20:
                return PRIVATE;
            L22:
                return DEFAULT;
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
            ADAPTER = new ProtoAdapter_SearchTypeFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2662newBuilder() {
            Builder r0 = new Builder();
            r0.msearch_type = Internal.copyOf("msearch_type", this.msearch_type);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SearchTypeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2662newBuilder();
        }

        public SearchTypeFilter(List<SearchType> r2) {
            this(r2, ByteString.EMPTY);
        }

        public SearchTypeFilter(List<SearchType> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.msearch_type = Internal.immutableCopyOf("msearch_type", r2);
        }
    }

    public static final class SortRuleFilter extends Message<SortRuleFilter, Builder> {
        public static final ProtoAdapter<SortRuleFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final GroupSortRuleType msort_type;

        public static final class Builder extends Message.Builder<SortRuleFilter, Builder> {
            public GroupSortRuleType msort_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SortRuleFilter m2666build() {
                return new SortRuleFilter(this.msort_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2666build();
            }

            public Builder sort_type(GroupSortRuleType r1) {
                this.msort_type = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SortRuleFilter extends ProtoAdapter<SortRuleFilter> {
            public ProtoAdapter_SortRuleFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, SortRuleFilter.class);
            }

            public SortRuleFilter decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L7;
                r0.msort_type = (GroupSortRuleType) GroupSortRuleType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
                return r0.m2666build();
            }

            public int encodedSize(SortRuleFilter r4) {
                GroupSortRuleType r0 = r4.msort_type;
                if (r0 == null) goto L5;
                int r1 = GroupSortRuleType.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2667decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SortRuleFilter) r1);
            }

            public void encode(ProtoWriter r4, SortRuleFilter r5) throws IOException {
                GroupSortRuleType r0 = r5.msort_type;
                if (r0 == null) goto L5;
                GroupSortRuleType.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SortRuleFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SortRuleFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2665newBuilder() {
            Builder r0 = new Builder();
            r0.msort_type = this.msort_type;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SortRuleFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2665newBuilder();
        }

        public SortRuleFilter(GroupSortRuleType r2) {
            this(r2, ByteString.EMPTY);
        }

        public SortRuleFilter(GroupSortRuleType r2, ByteString r3) {
            super(ADAPTER, r3);
            this.msort_type = r2;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GroupChatFilter();
    }

    public GroupChatFilter() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2656newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GroupChatFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2656newBuilder();
    }

    public GroupChatFilter(ByteString r2) {
        super(ADAPTER, r2);
    }
}
