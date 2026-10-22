package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SearchPlaceholder extends Message<SearchPlaceholder, Builder> {
    public static final ProtoAdapter<SearchPlaceholder> ADAPTER = null;
    public static final String DEFAULT_ANSWER = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_MARQUEE_TEXT = "";
    public static final String DEFAULT_QUERY = "";
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    public final String manswer;
    public final List<MarqueeFilter> mfilters;
    public final Map<String, String> mi18n_text;
    public final String mid;
    public final String mmarquee_text;
    public final String mquery;
    public final com.ss.android.lark.pb.searches.SearchTabName msearch_tab_name;
    public final String mtext;
    public final SearchResult muser_search_info;

    public static final class Builder extends Message.Builder<SearchPlaceholder, Builder> {
        public String manswer;
        public List<MarqueeFilter> mfilters;
        public Map<String, String> mi18n_text;
        public String mid;
        public String mmarquee_text;
        public String mquery;
        public com.ss.android.lark.pb.searches.SearchTabName msearch_tab_name;
        public String mtext;
        public SearchResult muser_search_info;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SearchPlaceholder m2828build() {
            String r0 = this.mtext;
            if (r0 == null) goto L7;
            return new SearchPlaceholder(this.mtext, this.mi18n_text, this.mquery, this.msearch_tab_name, this.mfilters, this.muser_search_info, this.mmarquee_text, this.mid, this.manswer, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mtext"});
        }

        public Builder() {
            this.mi18n_text = Internal.newMutableMap();
            this.mfilters = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2828build();
        }

        public Builder answer(String r1) {
            this.manswer = r1;
            return this;
        }

        public Builder filters(List<MarqueeFilter> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfilters = r1;
            return this;
        }

        public Builder i18n_text(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mi18n_text = r1;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder marquee_text(String r1) {
            this.mmarquee_text = r1;
            return this;
        }

        public Builder query(String r1) {
            this.mquery = r1;
            return this;
        }

        public Builder search_tab_name(com.ss.android.lark.pb.searches.SearchTabName r1) {
            this.msearch_tab_name = r1;
            return this;
        }

        public Builder text(String r1) {
            this.mtext = r1;
            return this;
        }

        public Builder user_search_info(SearchResult r1) {
            this.muser_search_info = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchPlaceholder extends ProtoAdapter<SearchPlaceholder> {
        private final ProtoAdapter<Map<String, String>> mi18n_text;

        public ProtoAdapter_SearchPlaceholder() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchPlaceholder.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mi18n_text = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public SearchPlaceholder decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mtext = "";
            r0.mquery = "";
            r0.mmarquee_text = "";
            r0.mid = "";
            r0.manswer = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L19;
            switch(r3) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L21;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L21:
            r0.msearch_tab_name = (com.ss.android.lark.pb.searches.SearchTabName) com.ss.android.lark.pb.searches.SearchTabName.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.manswer = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            r0.mmarquee_text = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            r0.muser_search_info = (SearchResult) SearchResult.ADAPTER.decode(r9);
            goto L3
        L11:
            r0.mfilters.add((MarqueeFilter) MarqueeFilter.ADAPTER.decode(r9));
            goto L3
        L16:
            r0.mquery = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L17:
            r0.mi18n_text.putAll((Map) this.mi18n_text.decode(r9));
            goto L3
        L18:
            r0.mtext = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L19:
            r9.endMessage(r1);
            return r0.m2828build();
        }

        public int encodedSize(SearchPlaceholder r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mtext) + this.mi18n_text.encodedSizeWithTag(2, r7.mi18n_text);
            String r2 = r7.mquery;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(3, r2);
        L6:
            int r5 = r1 + r4;
            com.ss.android.lark.pb.searches.SearchTabName r6 = r7.msearch_tab_name;
            if (r6 == null) goto L9;
            int r8 = com.ss.android.lark.pb.searches.SearchTabName.ADAPTER.encodedSizeWithTag(4, r6);
        L10:
            int r9 = (r5 + r8) + MarqueeFilter.ADAPTER.asRepeated().encodedSizeWithTag(5, r7.mfilters);
            SearchResult r10 = r7.muser_search_info;
            if (r10 == null) goto L13;
            int r11 = SearchResult.ADAPTER.encodedSizeWithTag(6, r10);
        L14:
            int r12 = r9 + r11;
            String r13 = r7.mmarquee_text;
            if (r13 == null) goto L17;
            int r14 = r0.encodedSizeWithTag(7, r13);
        L18:
            int r15 = r12 + r14;
            String r16 = r7.mid;
            if (r16 == null) goto L21;
            int r17 = r0.encodedSizeWithTag(8, r16);
        L22:
            int r18 = r15 + r17;
            String r19 = r7.manswer;
            if (r19 == null) goto L26;
            r3 = r0.encodedSizeWithTag(9, r19);
        L26:
            return (r18 + r3) + r7.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2829decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SearchPlaceholder) r1);
        }

        public void encode(ProtoWriter r5, SearchPlaceholder r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mtext);
            this.mi18n_text.encodeWithTag(r5, 2, r6.mi18n_text);
            String r1 = r6.mquery;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 3, r1);
        L5:
            com.ss.android.lark.pb.searches.SearchTabName r2 = r6.msearch_tab_name;
            if (r2 == null) goto L8;
            com.ss.android.lark.pb.searches.SearchTabName.ADAPTER.encodeWithTag(r5, 4, r2);
        L8:
            MarqueeFilter.ADAPTER.asRepeated().encodeWithTag(r5, 5, r6.mfilters);
            SearchResult r3 = r6.muser_search_info;
            if (r3 == null) goto L11;
            SearchResult.ADAPTER.encodeWithTag(r5, 6, r3);
        L11:
            String r4 = r6.mmarquee_text;
            if (r4 == null) goto L14;
            r0.encodeWithTag(r5, 7, r4);
        L14:
            String r7 = r6.mid;
            if (r7 == null) goto L17;
            r0.encodeWithTag(r5, 8, r7);
        L17:
            String r8 = r6.manswer;
            if (r8 == null) goto L20;
            r0.encodeWithTag(r5, 9, r8);
        L20:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SearchPlaceholder) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchPlaceholder();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2827newBuilder() {
        Builder r0 = new Builder();
        r0.mtext = this.mtext;
        r0.mi18n_text = Internal.copyOf("mi18n_text", this.mi18n_text);
        r0.mquery = this.mquery;
        r0.msearch_tab_name = this.msearch_tab_name;
        r0.mfilters = Internal.copyOf("mfilters", this.mfilters);
        r0.muser_search_info = this.muser_search_info;
        r0.mmarquee_text = this.mmarquee_text;
        r0.mid = this.mid;
        r0.manswer = this.manswer;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SearchPlaceholder.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2827newBuilder();
    }

    public SearchPlaceholder(String r12, Map<String, String> r13, String r14, com.ss.android.lark.pb.searches.SearchTabName r15, List<MarqueeFilter> r16, SearchResult r17, String r18, String r19, String r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public SearchPlaceholder(String r2, Map<String, String> r3, String r4, com.ss.android.lark.pb.searches.SearchTabName r5, List<MarqueeFilter> r6, SearchResult r7, String r8, String r9, String r10, ByteString r11) {
        super(ADAPTER, r11);
        this.mtext = r2;
        this.mi18n_text = Internal.immutableCopyOf("mi18n_text", r3);
        this.mquery = r4;
        this.msearch_tab_name = r5;
        this.mfilters = Internal.immutableCopyOf("mfilters", r6);
        this.muser_search_info = r7;
        this.mmarquee_text = r8;
        this.mid = r9;
        this.manswer = r10;
    }
}
