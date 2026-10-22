package com.ss.android.lark.pb.usearch;

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
public final class BannerAction extends Message<BannerAction, Builder> {
    public static final ProtoAdapter<BannerAction> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DisableFilterOption mdisable_filter_option;
    public final HighlightFilter mhighlight_filter;
    public final NoAction mno_action;
    public final ReSearch mre_search;
    public final RouteTo mroute_to;
    public final SelectFilterOption mselect_filter_option;

    public static final class Builder extends Message.Builder<BannerAction, Builder> {
        public DisableFilterOption mdisable_filter_option;
        public HighlightFilter mhighlight_filter;
        public NoAction mno_action;
        public ReSearch mre_search;
        public RouteTo mroute_to;
        public SelectFilterOption mselect_filter_option;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BannerAction m2522build() {
            return new BannerAction(this.mno_action, this.mhighlight_filter, this.mselect_filter_option, this.mdisable_filter_option, this.mre_search, this.mroute_to, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2522build();
        }

        public Builder disable_filter_option(DisableFilterOption r1) {
            this.mdisable_filter_option = r1;
            this.mno_action = null;
            this.mhighlight_filter = null;
            this.mselect_filter_option = null;
            this.mre_search = null;
            this.mroute_to = null;
            return this;
        }

        public Builder highlight_filter(HighlightFilter r1) {
            this.mhighlight_filter = r1;
            this.mno_action = null;
            this.mselect_filter_option = null;
            this.mdisable_filter_option = null;
            this.mre_search = null;
            this.mroute_to = null;
            return this;
        }

        public Builder no_action(NoAction r1) {
            this.mno_action = r1;
            this.mhighlight_filter = null;
            this.mselect_filter_option = null;
            this.mdisable_filter_option = null;
            this.mre_search = null;
            this.mroute_to = null;
            return this;
        }

        public Builder re_search(ReSearch r1) {
            this.mre_search = r1;
            this.mno_action = null;
            this.mhighlight_filter = null;
            this.mselect_filter_option = null;
            this.mdisable_filter_option = null;
            this.mroute_to = null;
            return this;
        }

        public Builder route_to(RouteTo r1) {
            this.mroute_to = r1;
            this.mno_action = null;
            this.mhighlight_filter = null;
            this.mselect_filter_option = null;
            this.mdisable_filter_option = null;
            this.mre_search = null;
            return this;
        }

        public Builder select_filter_option(SelectFilterOption r1) {
            this.mselect_filter_option = r1;
            this.mno_action = null;
            this.mhighlight_filter = null;
            this.mdisable_filter_option = null;
            this.mre_search = null;
            this.mroute_to = null;
            return this;
        }
    }

    public static final class DisableFilterOption extends Message<DisableFilterOption, Builder> {
        public static final ProtoAdapter<DisableFilterOption> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final SearchActionFilter mfilter_option;

        public static final class Builder extends Message.Builder<DisableFilterOption, Builder> {
            public SearchActionFilter mfilter_option;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public DisableFilterOption m2524build() {
                return new DisableFilterOption(this.mfilter_option, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2524build();
            }

            public Builder filter_option(SearchActionFilter r1) {
                this.mfilter_option = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_DisableFilterOption extends ProtoAdapter<DisableFilterOption> {
            public ProtoAdapter_DisableFilterOption() {
                super(FieldEncoding.LENGTH_DELIMITED, DisableFilterOption.class);
            }

            public DisableFilterOption decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mfilter_option = (SearchActionFilter) SearchActionFilter.ADAPTER.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2524build();
            }

            public int encodedSize(DisableFilterOption r4) {
                SearchActionFilter r0 = r4.mfilter_option;
                if (r0 == null) goto L5;
                int r1 = SearchActionFilter.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2525decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((DisableFilterOption) r1);
            }

            public void encode(ProtoWriter r4, DisableFilterOption r5) throws IOException {
                SearchActionFilter r0 = r5.mfilter_option;
                if (r0 == null) goto L5;
                SearchActionFilter.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (DisableFilterOption) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DisableFilterOption();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2523newBuilder() {
            Builder r0 = new Builder();
            r0.mfilter_option = this.mfilter_option;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return DisableFilterOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2523newBuilder();
        }

        public DisableFilterOption(SearchActionFilter r2) {
            this(r2, ByteString.EMPTY);
        }

        public DisableFilterOption(SearchActionFilter r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mfilter_option = r2;
        }
    }

    public static final class HighlightFilter extends Message<HighlightFilter, Builder> {
        public static final ProtoAdapter<HighlightFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final SearchActionFilter mfilter;

        public static final class Builder extends Message.Builder<HighlightFilter, Builder> {
            public SearchActionFilter mfilter;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public HighlightFilter m2527build() {
                return new HighlightFilter(this.mfilter, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2527build();
            }

            public Builder filter(SearchActionFilter r1) {
                this.mfilter = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_HighlightFilter extends ProtoAdapter<HighlightFilter> {
            public ProtoAdapter_HighlightFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, HighlightFilter.class);
            }

            public HighlightFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mfilter = (SearchActionFilter) SearchActionFilter.ADAPTER.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2527build();
            }

            public int encodedSize(HighlightFilter r4) {
                SearchActionFilter r0 = r4.mfilter;
                if (r0 == null) goto L5;
                int r1 = SearchActionFilter.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2528decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((HighlightFilter) r1);
            }

            public void encode(ProtoWriter r4, HighlightFilter r5) throws IOException {
                SearchActionFilter r0 = r5.mfilter;
                if (r0 == null) goto L5;
                SearchActionFilter.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (HighlightFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HighlightFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2526newBuilder() {
            Builder r0 = new Builder();
            r0.mfilter = this.mfilter;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return HighlightFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2526newBuilder();
        }

        public HighlightFilter(SearchActionFilter r2) {
            this(r2, ByteString.EMPTY);
        }

        public HighlightFilter(SearchActionFilter r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mfilter = r2;
        }
    }

    public static final class NoAction extends Message<NoAction, Builder> {
        public static final ProtoAdapter<NoAction> ADAPTER = null;
        private static final long serialVersionUID = 0;

        public static final class Builder extends Message.Builder<NoAction, Builder> {
            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public NoAction m2530build() {
                return new NoAction(super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2530build();
            }
        }

        public static final class ProtoAdapter_NoAction extends ProtoAdapter<NoAction> {
            public ProtoAdapter_NoAction() {
                super(FieldEncoding.LENGTH_DELIMITED, NoAction.class);
            }

            public NoAction decode(ProtoReader r7) throws IOException {
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
                return r0.m2530build();
            }

            public int encodedSize(NoAction r1) {
                return r1.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2531decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((NoAction) r1);
            }

            public void encode(ProtoWriter r1, NoAction r2) throws IOException {
                r1.writeBytes(r2.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (NoAction) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_NoAction();
        }

        public NoAction() {
            this(ByteString.EMPTY);
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2529newBuilder() {
            Builder r0 = new Builder();
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return NoAction.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2529newBuilder();
        }

        public NoAction(ByteString r2) {
            super(ADAPTER, r2);
        }
    }

    public static final class ProtoAdapter_BannerAction extends ProtoAdapter<BannerAction> {
        public ProtoAdapter_BannerAction() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerAction.class);
        }

        public BannerAction decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.route_to((RouteTo) RouteTo.ADAPTER.decode(r7));
            goto L3
        L8:
            r0.re_search((ReSearch) ReSearch.ADAPTER.decode(r7));
            goto L3
        L9:
            r0.disable_filter_option((DisableFilterOption) DisableFilterOption.ADAPTER.decode(r7));
            goto L3
        L10:
            r0.select_filter_option((SelectFilterOption) SelectFilterOption.ADAPTER.decode(r7));
            goto L3
        L11:
            r0.highlight_filter((HighlightFilter) HighlightFilter.ADAPTER.decode(r7));
            goto L3
        L12:
            r0.no_action((NoAction) NoAction.ADAPTER.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.m2522build();
        }

        public int encodedSize(BannerAction r6) {
            NoAction r0 = r6.mno_action;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = NoAction.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            HighlightFilter r3 = r6.mhighlight_filter;
            if (r3 == null) goto L9;
            int r4 = HighlightFilter.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            SelectFilterOption r7 = r6.mselect_filter_option;
            if (r7 == null) goto L13;
            int r8 = SelectFilterOption.ADAPTER.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            DisableFilterOption r10 = r6.mdisable_filter_option;
            if (r10 == null) goto L17;
            int r11 = DisableFilterOption.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            ReSearch r13 = r6.mre_search;
            if (r13 == null) goto L21;
            int r14 = ReSearch.ADAPTER.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            RouteTo r16 = r6.mroute_to;
            if (r16 == null) goto L26;
            r1 = RouteTo.ADAPTER.encodedSizeWithTag(6, r16);
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
        public /* bridge */ /* synthetic */ Object m2532decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BannerAction) r1);
        }

        public void encode(ProtoWriter r4, BannerAction r5) throws IOException {
            NoAction r0 = r5.mno_action;
            if (r0 == null) goto L5;
            NoAction.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            HighlightFilter r1 = r5.mhighlight_filter;
            if (r1 == null) goto L8;
            HighlightFilter.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            SelectFilterOption r2 = r5.mselect_filter_option;
            if (r2 == null) goto L11;
            SelectFilterOption.ADAPTER.encodeWithTag(r4, 3, r2);
        L11:
            DisableFilterOption r3 = r5.mdisable_filter_option;
            if (r3 == null) goto L14;
            DisableFilterOption.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            ReSearch r6 = r5.mre_search;
            if (r6 == null) goto L17;
            ReSearch.ADAPTER.encodeWithTag(r4, 5, r6);
        L17:
            RouteTo r7 = r5.mroute_to;
            if (r7 == null) goto L20;
            RouteTo.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BannerAction) r2);
        }
    }

    public static final class ReSearch extends Message<ReSearch, Builder> {
        public static final ProtoAdapter<ReSearch> ADAPTER = null;
        public static final String DEFAULT_QUERY = "";
        private static final long serialVersionUID = 0;
        public final List<SearchActionFilter> mfilters;
        public final String mquery;

        public static final class Builder extends Message.Builder<ReSearch, Builder> {
            public List<SearchActionFilter> mfilters;
            public String mquery;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public ReSearch m2534build() {
                return new ReSearch(this.mquery, this.mfilters, super.buildUnknownFields());
            }

            public Builder() {
                this.mfilters = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2534build();
            }

            public Builder filters(List<SearchActionFilter> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfilters = r1;
                return this;
            }

            public Builder query(String r1) {
                this.mquery = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_ReSearch extends ProtoAdapter<ReSearch> {
            public ProtoAdapter_ReSearch() {
                super(FieldEncoding.LENGTH_DELIMITED, ReSearch.class);
            }

            public ReSearch decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mquery = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mquery = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mfilters.add((SearchActionFilter) SearchActionFilter.ADAPTER.decode(r7));
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2534build();
            }

            public int encodedSize(ReSearch r5) {
                String r0 = r5.mquery;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L7:
                return (r1 + SearchActionFilter.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mfilters)) + r5.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2535decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((ReSearch) r1);
            }

            public void encode(ProtoWriter r4, ReSearch r5) throws IOException {
                String r0 = r5.mquery;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                SearchActionFilter.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mfilters);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (ReSearch) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ReSearch();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2533newBuilder() {
            Builder r0 = new Builder();
            r0.mquery = this.mquery;
            r0.mfilters = Internal.copyOf("mfilters", this.mfilters);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return ReSearch.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2533newBuilder();
        }

        public ReSearch(String r2, List<SearchActionFilter> r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public ReSearch(String r2, List<SearchActionFilter> r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mquery = r2;
            this.mfilters = Internal.immutableCopyOf("mfilters", r3);
        }
    }

    public static final class RouteTo extends Message<RouteTo, Builder> {
        public static final ProtoAdapter<RouteTo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final ShellApi mshell_api;

        public static final class Builder extends Message.Builder<RouteTo, Builder> {
            public ShellApi mshell_api;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public RouteTo m2537build() {
                return new RouteTo(this.mshell_api, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2537build();
            }

            public Builder shell_api(ShellApi r1) {
                this.mshell_api = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_RouteTo extends ProtoAdapter<RouteTo> {
            public ProtoAdapter_RouteTo() {
                super(FieldEncoding.LENGTH_DELIMITED, RouteTo.class);
            }

            public RouteTo decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mshell_api = (ShellApi) ShellApi.ADAPTER.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2537build();
            }

            public int encodedSize(RouteTo r4) {
                ShellApi r0 = r4.mshell_api;
                if (r0 == null) goto L5;
                int r1 = ShellApi.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2538decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((RouteTo) r1);
            }

            public void encode(ProtoWriter r4, RouteTo r5) throws IOException {
                ShellApi r0 = r5.mshell_api;
                if (r0 == null) goto L5;
                ShellApi.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (RouteTo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RouteTo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2536newBuilder() {
            Builder r0 = new Builder();
            r0.mshell_api = this.mshell_api;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return RouteTo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2536newBuilder();
        }

        public RouteTo(ShellApi r2) {
            this(r2, ByteString.EMPTY);
        }

        public RouteTo(ShellApi r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mshell_api = r2;
        }
    }

    public static final class SelectFilterOption extends Message<SelectFilterOption, Builder> {
        public static final ProtoAdapter<SelectFilterOption> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final SearchActionFilter mfilter_option;

        public static final class Builder extends Message.Builder<SelectFilterOption, Builder> {
            public SearchActionFilter mfilter_option;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SelectFilterOption m2540build() {
                return new SelectFilterOption(this.mfilter_option, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2540build();
            }

            public Builder filter_option(SearchActionFilter r1) {
                this.mfilter_option = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SelectFilterOption extends ProtoAdapter<SelectFilterOption> {
            public ProtoAdapter_SelectFilterOption() {
                super(FieldEncoding.LENGTH_DELIMITED, SelectFilterOption.class);
            }

            public SelectFilterOption decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mfilter_option = (SearchActionFilter) SearchActionFilter.ADAPTER.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2540build();
            }

            public int encodedSize(SelectFilterOption r4) {
                SearchActionFilter r0 = r4.mfilter_option;
                if (r0 == null) goto L5;
                int r1 = SearchActionFilter.ADAPTER.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2541decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SelectFilterOption) r1);
            }

            public void encode(ProtoWriter r4, SelectFilterOption r5) throws IOException {
                SearchActionFilter r0 = r5.mfilter_option;
                if (r0 == null) goto L5;
                SearchActionFilter.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SelectFilterOption) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SelectFilterOption();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2539newBuilder() {
            Builder r0 = new Builder();
            r0.mfilter_option = this.mfilter_option;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SelectFilterOption.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2539newBuilder();
        }

        public SelectFilterOption(SearchActionFilter r2) {
            this(r2, ByteString.EMPTY);
        }

        public SelectFilterOption(SearchActionFilter r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mfilter_option = r2;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerAction();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2521newBuilder() {
        Builder r0 = new Builder();
        r0.mno_action = this.mno_action;
        r0.mhighlight_filter = this.mhighlight_filter;
        r0.mselect_filter_option = this.mselect_filter_option;
        r0.mdisable_filter_option = this.mdisable_filter_option;
        r0.mre_search = this.mre_search;
        r0.mroute_to = this.mroute_to;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BannerAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2521newBuilder();
    }

    public BannerAction(NoAction r9, HighlightFilter r10, SelectFilterOption r11, DisableFilterOption r12, ReSearch r13, RouteTo r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public BannerAction(NoAction r2, HighlightFilter r3, SelectFilterOption r4, DisableFilterOption r5, ReSearch r6, RouteTo r7, ByteString r8) {
        super(ADAPTER, r8);
        if (Internal.countNonNull(r2, r3, r4, r5, new Object[]{r6, r7}) > 1) goto L7;
        this.mno_action = r2;
        this.mhighlight_filter = r3;
        this.mselect_filter_option = r4;
        this.mdisable_filter_option = r5;
        this.mre_search = r6;
        this.mroute_to = r7;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mno_action, mhighlight_filter, mselect_filter_option, mdisable_filter_option, mre_search, mroute_to may be non-null");
    }
}
