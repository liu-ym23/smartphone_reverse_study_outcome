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
public final class BannerMeta extends Message<BannerMeta, Builder> {
    public static final ProtoAdapter<BannerMeta> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_TRACKING_KEY = "";
    private static final long serialVersionUID = 0;
    public final List<BannerElementArray> melements;
    public final HighlightTheFilter mhighlight_the_filter;
    public final String mid;
    public final SelectFilterOptions mselect_filter_options;
    public final BannerStyle mstyle;
    public final String mtracking_key;

    public static final class Builder extends Message.Builder<BannerMeta, Builder> {
        public List<BannerElementArray> melements;
        public HighlightTheFilter mhighlight_the_filter;
        public String mid;
        public SelectFilterOptions mselect_filter_options;
        public BannerStyle mstyle;
        public String mtracking_key;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public BannerMeta m2549build() {
            String r0 = this.mid;
            if (r0 == null) goto L7;
            return new BannerMeta(this.mid, this.melements, this.mstyle, this.mtracking_key, this.mhighlight_the_filter, this.mselect_filter_options, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "mid"});
        }

        public Builder() {
            this.melements = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2549build();
        }

        public Builder elements(List<BannerElementArray> r1) {
            Internal.checkElementsNotNull(r1);
            this.melements = r1;
            return this;
        }

        public Builder highlight_the_filter(HighlightTheFilter r1) {
            this.mhighlight_the_filter = r1;
            this.mselect_filter_options = null;
            return this;
        }

        public Builder id(String r1) {
            this.mid = r1;
            return this;
        }

        public Builder select_filter_options(SelectFilterOptions r1) {
            this.mselect_filter_options = r1;
            this.mhighlight_the_filter = null;
            return this;
        }

        public Builder style(BannerStyle r1) {
            this.mstyle = r1;
            return this;
        }

        public Builder tracking_key(String r1) {
            this.mtracking_key = r1;
            return this;
        }
    }

    public static final class HighlightTheFilter extends Message<HighlightTheFilter, Builder> {
        public static final ProtoAdapter<HighlightTheFilter> ADAPTER = null;
        public static final String DEFAULT_HIGHTLIGHT_SUMMARY = "";
        public static final String DEFAULT_INTRO = "";
        private static final long serialVersionUID = 0;
        public final SearchActionFilter mfilter;
        public final String mhightlight_summary;
        public final String mintro;

        public static final class Builder extends Message.Builder<HighlightTheFilter, Builder> {
            public SearchActionFilter mfilter;
            public String mhightlight_summary;
            public String mintro;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public HighlightTheFilter m2551build() {
                return new HighlightTheFilter(this.mintro, this.mhightlight_summary, this.mfilter, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2551build();
            }

            public Builder filter(SearchActionFilter r1) {
                this.mfilter = r1;
                return this;
            }

            public Builder hightlight_summary(String r1) {
                this.mhightlight_summary = r1;
                return this;
            }

            public Builder intro(String r1) {
                this.mintro = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_HighlightTheFilter extends ProtoAdapter<HighlightTheFilter> {
            public ProtoAdapter_HighlightTheFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, HighlightTheFilter.class);
            }

            public HighlightTheFilter decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mintro = "";
                r0.mhightlight_summary = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mintro = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mhightlight_summary = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.mfilter = (SearchActionFilter) SearchActionFilter.ADAPTER.decode(r7);
                goto L3
            L11:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L15:
                r7.endMessage(r1);
                return r0.m2551build();
            }

            public int encodedSize(HighlightTheFilter r6) {
                String r0 = r6.mintro;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r6.mhightlight_summary;
                if (r3 == null) goto L9;
                int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                int r5 = r2 + r4;
                SearchActionFilter r7 = r6.mfilter;
                if (r7 == null) goto L14;
                r1 = SearchActionFilter.ADAPTER.encodedSizeWithTag(3, r7);
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
            public /* bridge */ /* synthetic */ Object m2552decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((HighlightTheFilter) r1);
            }

            public void encode(ProtoWriter r4, HighlightTheFilter r5) throws IOException {
                String r0 = r5.mintro;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mhightlight_summary;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                SearchActionFilter r2 = r5.mfilter;
                if (r2 == null) goto L11;
                SearchActionFilter.ADAPTER.encodeWithTag(r4, 3, r2);
            L11:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (HighlightTheFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_HighlightTheFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2550newBuilder() {
            Builder r0 = new Builder();
            r0.mintro = this.mintro;
            r0.mhightlight_summary = this.mhightlight_summary;
            r0.mfilter = this.mfilter;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return HighlightTheFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2550newBuilder();
        }

        public HighlightTheFilter(String r2, String r3, SearchActionFilter r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public HighlightTheFilter(String r2, String r3, SearchActionFilter r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mintro = r2;
            this.mhightlight_summary = r3;
            this.mfilter = r4;
        }
    }

    public static final class ProtoAdapter_BannerMeta extends ProtoAdapter<BannerMeta> {
        public ProtoAdapter_BannerMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerMeta.class);
        }

        public BannerMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mid = "";
            r0.mtracking_key = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L18;
                case 6: goto L7;
                default: goto L6;
            };
        L18:
            r0.mstyle = (BannerStyle) BannerStyle.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mtracking_key = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            r0.melements.add((BannerElementArray) BannerElementArray.ADAPTER.decode(r9));
            goto L3
        L13:
            r0.select_filter_options((SelectFilterOptions) SelectFilterOptions.ADAPTER.decode(r9));
            goto L3
        L14:
            r0.highlight_the_filter((HighlightTheFilter) HighlightTheFilter.ADAPTER.decode(r9));
            goto L3
        L15:
            r0.mid = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L16:
            r9.endMessage(r1);
            return r0.m2549build();
        }

        public int encodedSize(BannerMeta r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mid) + BannerElementArray.ADAPTER.asRepeated().encodedSizeWithTag(4, r7.melements);
            BannerStyle r2 = r7.mstyle;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = BannerStyle.ADAPTER.encodedSizeWithTag(5, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.mtracking_key;
            if (r6 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(6, r6);
        L10:
            int r9 = r5 + r8;
            HighlightTheFilter r10 = r7.mhighlight_the_filter;
            if (r10 == null) goto L13;
            int r11 = HighlightTheFilter.ADAPTER.encodedSizeWithTag(2, r10);
        L14:
            int r12 = r9 + r11;
            SelectFilterOptions r13 = r7.mselect_filter_options;
            if (r13 == null) goto L18;
            r3 = SelectFilterOptions.ADAPTER.encodedSizeWithTag(3, r13);
        L18:
            return (r12 + r3) + r7.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2553decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((BannerMeta) r1);
        }

        public void encode(ProtoWriter r5, BannerMeta r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mid);
            BannerElementArray.ADAPTER.asRepeated().encodeWithTag(r5, 4, r6.melements);
            BannerStyle r1 = r6.mstyle;
            if (r1 == null) goto L5;
            BannerStyle.ADAPTER.encodeWithTag(r5, 5, r1);
        L5:
            String r2 = r6.mtracking_key;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 6, r2);
        L8:
            HighlightTheFilter r3 = r6.mhighlight_the_filter;
            if (r3 == null) goto L11;
            HighlightTheFilter.ADAPTER.encodeWithTag(r5, 2, r3);
        L11:
            SelectFilterOptions r4 = r6.mselect_filter_options;
            if (r4 == null) goto L14;
            SelectFilterOptions.ADAPTER.encodeWithTag(r5, 3, r4);
        L14:
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (BannerMeta) r2);
        }
    }

    public static final class SelectFilterOptions extends Message<SelectFilterOptions, Builder> {
        public static final ProtoAdapter<SelectFilterOptions> ADAPTER = null;
        public static final String DEFAULT_INTRO = "";
        private static final long serialVersionUID = 0;
        public final List<SearchActionFilter> mfilter_options;
        public final String mintro;

        public static final class Builder extends Message.Builder<SelectFilterOptions, Builder> {
            public List<SearchActionFilter> mfilter_options;
            public String mintro;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SelectFilterOptions m2555build() {
                return new SelectFilterOptions(this.mintro, this.mfilter_options, super.buildUnknownFields());
            }

            public Builder() {
                this.mfilter_options = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2555build();
            }

            public Builder filter_options(List<SearchActionFilter> r1) {
                Internal.checkElementsNotNull(r1);
                this.mfilter_options = r1;
                return this;
            }

            public Builder intro(String r1) {
                this.mintro = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SelectFilterOptions extends ProtoAdapter<SelectFilterOptions> {
            public ProtoAdapter_SelectFilterOptions() {
                super(FieldEncoding.LENGTH_DELIMITED, SelectFilterOptions.class);
            }

            public SelectFilterOptions decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mintro = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mintro = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mfilter_options.add((SearchActionFilter) SearchActionFilter.ADAPTER.decode(r7));
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2555build();
            }

            public int encodedSize(SelectFilterOptions r5) {
                String r0 = r5.mintro;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L7:
                return (r1 + SearchActionFilter.ADAPTER.asRepeated().encodedSizeWithTag(2, r5.mfilter_options)) + r5.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2556decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SelectFilterOptions) r1);
            }

            public void encode(ProtoWriter r4, SelectFilterOptions r5) throws IOException {
                String r0 = r5.mintro;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                SearchActionFilter.ADAPTER.asRepeated().encodeWithTag(r4, 2, r5.mfilter_options);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SelectFilterOptions) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SelectFilterOptions();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2554newBuilder() {
            Builder r0 = new Builder();
            r0.mintro = this.mintro;
            r0.mfilter_options = Internal.copyOf("mfilter_options", this.mfilter_options);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SelectFilterOptions.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2554newBuilder();
        }

        public SelectFilterOptions(String r2, List<SearchActionFilter> r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public SelectFilterOptions(String r2, List<SearchActionFilter> r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mintro = r2;
            this.mfilter_options = Internal.immutableCopyOf("mfilter_options", r3);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerMeta();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2548newBuilder() {
        Builder r0 = new Builder();
        r0.mid = this.mid;
        r0.melements = Internal.copyOf("melements", this.melements);
        r0.mstyle = this.mstyle;
        r0.mtracking_key = this.mtracking_key;
        r0.mhighlight_the_filter = this.mhighlight_the_filter;
        r0.mselect_filter_options = this.mselect_filter_options;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return BannerMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2548newBuilder();
    }

    public BannerMeta(String r9, List<BannerElementArray> r10, BannerStyle r11, String r12, HighlightTheFilter r13, SelectFilterOptions r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public BannerMeta(String r2, List<BannerElementArray> r3, BannerStyle r4, String r5, HighlightTheFilter r6, SelectFilterOptions r7, ByteString r8) {
        super(ADAPTER, r8);
        if (Internal.countNonNull(r6, r7) > 1) goto L7;
        this.mid = r2;
        this.melements = Internal.immutableCopyOf("melements", r3);
        this.mstyle = r4;
        this.mtracking_key = r5;
        this.mhighlight_the_filter = r6;
        this.mselect_filter_options = r7;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mhighlight_the_filter, mselect_filter_options may be non-null");
    }
}
