package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.searches.FilterInTab;
import com.ss.android.lark.pb.searches.PlatformSearchFilter;
import com.ss.android.lark.pb.searches.SearchFilter;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class SearchTab extends Message<SearchTab, Builder> {
    public static final ProtoAdapter<SearchTab> ADAPTER = null;
    public static final String DEFAULT_APP_DESCRIPTION = "";
    public static final String DEFAULT_APP_ID = "";
    public static final Boolean DEFAULT_ENABLE_EMPTY_QUERY = null;
    public static final Boolean DEFAULT_ENABLE_HOVER_CHANGE = null;
    public static final String DEFAULT_ICON_URL = "";
    public static final Boolean DEFAULT_IS_INVISIBLE = null;
    public static final String DEFAULT_LABEL = "";
    public static final Integer DEFAULT_TOP_N_FILTERS = null;
    private static final long serialVersionUID = 0;
    public final List<AdvGrammarConf> madv_grammar_confs;
    public final String mapp_description;
    public final String mapp_id;
    public final BizKey mbiz_key;
    public final List<SearchFilter.CustomFilterInfo> mcustom_filters;
    public final Boolean menable_empty_query;
    public final Boolean menable_hover_change;
    public final List<FilterInTab> mfilters;
    public final List<NavigationAppPopup> mfrom_apps;
    public final List<CapsuleInfo> mhighlight_selected_capsules;
    public final String micon_url;
    public final Boolean mis_invisible;
    public final String mlabel;
    public final RequestParams mparams;
    public final List<PlatformSearchFilter.CustomFilterInfo> mplatform_custom_filters;
    public final ResultType mresult_type;
    public final Integer mtop_n_filters;
    public final com.ss.android.lark.pb.searches.SearchTabName mtype;

    public static final enum BizKey extends Enum<BizKey> implements WireEnum {
        private static final /* synthetic */ BizKey[] $VALUES = null;
        public static final ProtoAdapter<BizKey> ADAPTER = null;
        public static final BizKey AI_KNOWLEDGE = null;
        public static final BizKey CALENDAR = null;
        public static final BizKey EMAIL = null;
        public static final BizKey UNKNOWN = null;
        private final int value;

        static {
            BizKey r0 = new BizKey("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            BizKey r1 = new BizKey("EMAIL", 1, 1);
            EMAIL = r1;
            BizKey r3 = new BizKey("CALENDAR", 2, 2);
            CALENDAR = r3;
            BizKey r5 = new BizKey("AI_KNOWLEDGE", 3, 3);
            AI_KNOWLEDGE = r5;
            $VALUES = new BizKey[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(BizKey.class);
        }

        public static BizKey[] values() {
            return (BizKey[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static BizKey fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return AI_KNOWLEDGE;
        L14:
            return CALENDAR;
        L16:
            return EMAIL;
        L18:
            return UNKNOWN;
        }

        public static BizKey valueOf(String r1) {
            return (BizKey) a.a(BizKey.class, r1);
        }

        private BizKey(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends Message.Builder<SearchTab, Builder> {
        public List<AdvGrammarConf> madv_grammar_confs;
        public String mapp_description;
        public String mapp_id;
        public BizKey mbiz_key;
        public List<SearchFilter.CustomFilterInfo> mcustom_filters;
        public Boolean menable_empty_query;
        public Boolean menable_hover_change;
        public List<FilterInTab> mfilters;
        public List<NavigationAppPopup> mfrom_apps;
        public List<CapsuleInfo> mhighlight_selected_capsules;
        public String micon_url;
        public Boolean mis_invisible;
        public String mlabel;
        public RequestParams mparams;
        public List<PlatformSearchFilter.CustomFilterInfo> mplatform_custom_filters;
        public ResultType mresult_type;
        public Integer mtop_n_filters;
        public com.ss.android.lark.pb.searches.SearchTabName mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SearchTab m2834build() {
            String r1 = this.mlabel;
            if (r1 == null) goto L9;
            if (this.mtype == null) goto L9;
            return new SearchTab(this.mlabel, this.mtype, this.mapp_id, this.micon_url, this.mresult_type, this.mfilters, this.mtop_n_filters, this.mcustom_filters, this.mplatform_custom_filters, this.mbiz_key, this.mparams, this.mhighlight_selected_capsules, this.mfrom_apps, this.mapp_description, this.menable_empty_query, this.menable_hover_change, this.mis_invisible, this.madv_grammar_confs, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r1, "mlabel", this.mtype, "mtype"});
        }

        public Builder() {
            this.mfilters = Internal.newMutableList();
            this.mcustom_filters = Internal.newMutableList();
            this.mplatform_custom_filters = Internal.newMutableList();
            this.mhighlight_selected_capsules = Internal.newMutableList();
            this.mfrom_apps = Internal.newMutableList();
            this.madv_grammar_confs = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2834build();
        }

        public Builder adv_grammar_confs(List<AdvGrammarConf> r1) {
            Internal.checkElementsNotNull(r1);
            this.madv_grammar_confs = r1;
            return this;
        }

        public Builder app_description(String r1) {
            this.mapp_description = r1;
            return this;
        }

        public Builder app_id(String r1) {
            this.mapp_id = r1;
            return this;
        }

        public Builder biz_key(BizKey r1) {
            this.mbiz_key = r1;
            return this;
        }

        public Builder custom_filters(List<SearchFilter.CustomFilterInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mcustom_filters = r1;
            return this;
        }

        public Builder enable_empty_query(Boolean r1) {
            this.menable_empty_query = r1;
            return this;
        }

        public Builder enable_hover_change(Boolean r1) {
            this.menable_hover_change = r1;
            return this;
        }

        public Builder filters(List<FilterInTab> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfilters = r1;
            return this;
        }

        public Builder from_apps(List<NavigationAppPopup> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfrom_apps = r1;
            return this;
        }

        public Builder highlight_selected_capsules(List<CapsuleInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mhighlight_selected_capsules = r1;
            return this;
        }

        public Builder icon_url(String r1) {
            this.micon_url = r1;
            return this;
        }

        public Builder is_invisible(Boolean r1) {
            this.mis_invisible = r1;
            return this;
        }

        public Builder label(String r1) {
            this.mlabel = r1;
            return this;
        }

        public Builder params(RequestParams r1) {
            this.mparams = r1;
            return this;
        }

        public Builder platform_custom_filters(List<PlatformSearchFilter.CustomFilterInfo> r1) {
            Internal.checkElementsNotNull(r1);
            this.mplatform_custom_filters = r1;
            return this;
        }

        public Builder result_type(ResultType r1) {
            this.mresult_type = r1;
            return this;
        }

        public Builder top_n_filters(Integer r1) {
            this.mtop_n_filters = r1;
            return this;
        }

        public Builder type(com.ss.android.lark.pb.searches.SearchTabName r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchTab extends ProtoAdapter<SearchTab> {
        public ProtoAdapter_SearchTab() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchTab.class);
        }

        public SearchTab decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mlabel = "";
            r0.mapp_id = "";
            r0.micon_url = "";
            r0.mtop_n_filters = 0;
            r0.mapp_description = "";
            Boolean r1 = Boolean.FALSE;
            r0.menable_empty_query = r1;
            r0.menable_hover_change = r1;
            r0.mis_invisible = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L37;
            switch(r3) {
                case 1: goto L36;
                case 2: goto L39;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L41;
                case 6: goto L43;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L45;
                case 11: goto L14;
                case 12: goto L13;
                case 13: goto L12;
                case 14: goto L11;
                case 15: goto L10;
                case 16: goto L9;
                case 17: goto L8;
                case 18: goto L7;
                default: goto L6;
            };
        L39:
            r0.mtype = (com.ss.android.lark.pb.searches.SearchTabName) com.ss.android.lark.pb.searches.SearchTabName.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
        L34:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L41:
            r0.mresult_type = (ResultType) ResultType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
        L28:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L43:
            r0.mfilters.add((FilterInTab) FilterInTab.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L24
        L24:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L45:
            r0.mbiz_key = (BizKey) BizKey.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.madv_grammar_confs.add((AdvGrammarConf) AdvGrammarConf.ADAPTER.decode(r9));
            goto L3
        L8:
            r0.mis_invisible = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L9:
            r0.menable_hover_change = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L10:
            r0.menable_empty_query = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L11:
            r0.mapp_description = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            r0.mfrom_apps.add((NavigationAppPopup) NavigationAppPopup.ADAPTER.decode(r9));
            goto L3
        L13:
            r0.mhighlight_selected_capsules.add((CapsuleInfo) CapsuleInfo.ADAPTER.decode(r9));
            goto L3
        L14:
            r0.mparams = (RequestParams) RequestParams.ADAPTER.decode(r9);
            goto L3
        L19:
            r0.mplatform_custom_filters.add((PlatformSearchFilter.CustomFilterInfo) PlatformSearchFilter.CustomFilterInfo.ADAPTER.decode(r9));
            goto L3
        L20:
            r0.mcustom_filters.add((SearchFilter.CustomFilterInfo) SearchFilter.CustomFilterInfo.ADAPTER.decode(r9));
            goto L3
        L21:
            r0.mtop_n_filters = (Integer) ProtoAdapter.INT32.decode(r9);
            goto L3
        L30:
            r0.micon_url = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L31:
            r0.mapp_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L36:
            r0.mlabel = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L37:
            r9.endMessage(r2);
            return r0.m2834build();
        }

        public int encodedSize(SearchTab r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.mlabel) + com.ss.android.lark.pb.searches.SearchTabName.ADAPTER.encodedSizeWithTag(2, r7.mtype);
            String r2 = r7.mapp_id;
            int r3 = 0;
            if (r2 == null) goto L5;
            int r4 = r0.encodedSizeWithTag(3, r2);
        L6:
            int r5 = r1 + r4;
            String r6 = r7.micon_url;
            if (r6 == null) goto L9;
            int r8 = r0.encodedSizeWithTag(4, r6);
        L10:
            int r9 = r5 + r8;
            ResultType r10 = r7.mresult_type;
            if (r10 == null) goto L13;
            int r11 = ResultType.ADAPTER.encodedSizeWithTag(5, r10);
        L14:
            int r12 = (r9 + r11) + FilterInTab.ADAPTER.asRepeated().encodedSizeWithTag(6, r7.mfilters);
            Integer r13 = r7.mtop_n_filters;
            if (r13 == null) goto L17;
            int r14 = ProtoAdapter.INT32.encodedSizeWithTag(7, r13);
        L18:
            int r15 = ((r12 + r14) + SearchFilter.CustomFilterInfo.ADAPTER.asRepeated().encodedSizeWithTag(8, r7.mcustom_filters)) + PlatformSearchFilter.CustomFilterInfo.ADAPTER.asRepeated().encodedSizeWithTag(9, r7.mplatform_custom_filters);
            BizKey r16 = r7.mbiz_key;
            if (r16 == null) goto L21;
            int r17 = BizKey.ADAPTER.encodedSizeWithTag(10, r16);
        L22:
            int r18 = r15 + r17;
            RequestParams r19 = r7.mparams;
            if (r19 == null) goto L25;
            int r20 = RequestParams.ADAPTER.encodedSizeWithTag(11, r19);
        L26:
            int r21 = ((r18 + r20) + CapsuleInfo.ADAPTER.asRepeated().encodedSizeWithTag(12, r7.mhighlight_selected_capsules)) + NavigationAppPopup.ADAPTER.asRepeated().encodedSizeWithTag(13, r7.mfrom_apps);
            String r22 = r7.mapp_description;
            if (r22 == null) goto L29;
            int r23 = r0.encodedSizeWithTag(14, r22);
        L30:
            int r24 = r21 + r23;
            Boolean r25 = r7.menable_empty_query;
            if (r25 == null) goto L33;
            int r26 = ProtoAdapter.BOOL.encodedSizeWithTag(15, r25);
        L34:
            int r27 = r24 + r26;
            Boolean r28 = r7.menable_hover_change;
            if (r28 == null) goto L37;
            int r29 = ProtoAdapter.BOOL.encodedSizeWithTag(16, r28);
        L38:
            int r30 = r27 + r29;
            Boolean r31 = r7.mis_invisible;
            if (r31 == null) goto L42;
            r3 = ProtoAdapter.BOOL.encodedSizeWithTag(17, r31);
        L42:
            return ((r30 + r3) + AdvGrammarConf.ADAPTER.asRepeated().encodedSizeWithTag(18, r7.madv_grammar_confs)) + r7.unknownFields().size();
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
        public /* bridge */ /* synthetic */ Object m2835decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SearchTab) r1);
        }

        public void encode(ProtoWriter r5, SearchTab r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 1, r6.mlabel);
            com.ss.android.lark.pb.searches.SearchTabName.ADAPTER.encodeWithTag(r5, 2, r6.mtype);
            String r1 = r6.mapp_id;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r5, 3, r1);
        L5:
            String r2 = r6.micon_url;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r5, 4, r2);
        L8:
            ResultType r3 = r6.mresult_type;
            if (r3 == null) goto L11;
            ResultType.ADAPTER.encodeWithTag(r5, 5, r3);
        L11:
            FilterInTab.ADAPTER.asRepeated().encodeWithTag(r5, 6, r6.mfilters);
            Integer r4 = r6.mtop_n_filters;
            if (r4 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r5, 7, r4);
        L14:
            SearchFilter.CustomFilterInfo.ADAPTER.asRepeated().encodeWithTag(r5, 8, r6.mcustom_filters);
            PlatformSearchFilter.CustomFilterInfo.ADAPTER.asRepeated().encodeWithTag(r5, 9, r6.mplatform_custom_filters);
            BizKey r7 = r6.mbiz_key;
            if (r7 == null) goto L17;
            BizKey.ADAPTER.encodeWithTag(r5, 10, r7);
        L17:
            RequestParams r8 = r6.mparams;
            if (r8 == null) goto L20;
            RequestParams.ADAPTER.encodeWithTag(r5, 11, r8);
        L20:
            CapsuleInfo.ADAPTER.asRepeated().encodeWithTag(r5, 12, r6.mhighlight_selected_capsules);
            NavigationAppPopup.ADAPTER.asRepeated().encodeWithTag(r5, 13, r6.mfrom_apps);
            String r9 = r6.mapp_description;
            if (r9 == null) goto L23;
            r0.encodeWithTag(r5, 14, r9);
        L23:
            Boolean r10 = r6.menable_empty_query;
            if (r10 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r5, 15, r10);
        L26:
            Boolean r11 = r6.menable_hover_change;
            if (r11 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r5, 16, r11);
        L29:
            Boolean r12 = r6.mis_invisible;
            if (r12 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r5, 17, r12);
        L32:
            AdvGrammarConf.ADAPTER.asRepeated().encodeWithTag(r5, 18, r6.madv_grammar_confs);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SearchTab) r2);
        }
    }

    public static final class RequestParams extends Message<RequestParams, Builder> {
        public static final ProtoAdapter<RequestParams> ADAPTER = null;
        public static final Integer DEFAULT_PAGE_SIZE = null;
        private static final long serialVersionUID = 0;
        public final Mode mmode;
        public final Integer mpage_size;

        public static final class Builder extends Message.Builder<RequestParams, Builder> {
            public Mode mmode;
            public Integer mpage_size;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public RequestParams m2837build() {
                return new RequestParams(this.mmode, this.mpage_size, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2837build();
            }

            public Builder mode(Mode r1) {
                this.mmode = r1;
                return this;
            }

            public Builder page_size(Integer r1) {
                this.mpage_size = r1;
                return this;
            }
        }

        public static final enum Mode extends Enum<Mode> implements WireEnum {
            private static final /* synthetic */ Mode[] $VALUES = null;
            public static final ProtoAdapter<Mode> ADAPTER = null;
            public static final Mode NORMAL = null;
            public static final Mode NO_PAGE = null;
            public static final Mode UNKNOWN = null;
            private final int value;

            static {
                Mode r0 = new Mode("UNKNOWN", 0, 0);
                UNKNOWN = r0;
                Mode r1 = new Mode("NORMAL", 1, 1);
                NORMAL = r1;
                Mode r3 = new Mode("NO_PAGE", 2, 2);
                NO_PAGE = r3;
                $VALUES = new Mode[]{r0, r1, r3};
                ADAPTER = ProtoAdapter.newEnumAdapter(Mode.class);
            }

            public static Mode[] values() {
                return (Mode[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }

            public static Mode fromValue(int r1) {
                if (r1 == 0) goto L14;
                if (r1 == 1) goto L12;
                if (r1 == 2) goto L10;
                return null;
            L10:
                return NO_PAGE;
            L12:
                return NORMAL;
            L14:
                return UNKNOWN;
            }

            public static Mode valueOf(String r1) {
                return (Mode) a.a(Mode.class, r1);
            }

            private Mode(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class ProtoAdapter_RequestParams extends ProtoAdapter<RequestParams> {
            public ProtoAdapter_RequestParams() {
                super(FieldEncoding.LENGTH_DELIMITED, RequestParams.class);
            }

            public RequestParams decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mpage_size = 0;
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L15;
                if (r3 != 1) goto L8;
                r0.mmode = (Mode) Mode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mpage_size = (Integer) ProtoAdapter.INT32.decode(r9);
                goto L3
            L9:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L15:
                r9.endMessage(r1);
                return r0.m2837build();
            }

            public int encodedSize(RequestParams r5) {
                Mode r0 = r5.mmode;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = Mode.ADAPTER.encodedSizeWithTag(1, r0);
            L6:
                Integer r3 = r5.mpage_size;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.INT32.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2838decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((RequestParams) r1);
            }

            public void encode(ProtoWriter r4, RequestParams r5) throws IOException {
                Mode r0 = r5.mmode;
                if (r0 == null) goto L5;
                Mode.ADAPTER.encodeWithTag(r4, 1, r0);
            L5:
                Integer r1 = r5.mpage_size;
                if (r1 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (RequestParams) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RequestParams();
            DEFAULT_PAGE_SIZE = 0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2836newBuilder() {
            Builder r0 = new Builder();
            r0.mmode = this.mmode;
            r0.mpage_size = this.mpage_size;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return RequestParams.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2836newBuilder();
        }

        public RequestParams(Mode r2, Integer r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public RequestParams(Mode r2, Integer r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mmode = r2;
            this.mpage_size = r3;
        }
    }

    public static final enum ResultType extends Enum<ResultType> implements WireEnum {
        private static final /* synthetic */ ResultType[] $VALUES = null;
        public static final ProtoAdapter<ResultType> ADAPTER = null;
        public static final ResultType CUSTOMIZATION = null;
        public static final ResultType SLASH_COMMAND = null;
        private final int value;

        static {
            ResultType r0 = new ResultType("SLASH_COMMAND", 0, 0);
            SLASH_COMMAND = r0;
            ResultType r1 = new ResultType("CUSTOMIZATION", 1, 1);
            CUSTOMIZATION = r1;
            $VALUES = new ResultType[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(ResultType.class);
        }

        public static ResultType[] values() {
            return (ResultType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ResultType fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return CUSTOMIZATION;
        L10:
            return SLASH_COMMAND;
        }

        public static ResultType valueOf(String r1) {
            return (ResultType) a.a(ResultType.class, r1);
        }

        private ResultType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchTab();
        DEFAULT_TOP_N_FILTERS = 0;
        Boolean r0 = Boolean.FALSE;
        DEFAULT_ENABLE_EMPTY_QUERY = r0;
        DEFAULT_ENABLE_HOVER_CHANGE = r0;
        DEFAULT_IS_INVISIBLE = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2833newBuilder() {
        Builder r0 = new Builder();
        r0.mlabel = this.mlabel;
        r0.mtype = this.mtype;
        r0.mapp_id = this.mapp_id;
        r0.micon_url = this.micon_url;
        r0.mresult_type = this.mresult_type;
        r0.mfilters = Internal.copyOf("mfilters", this.mfilters);
        r0.mtop_n_filters = this.mtop_n_filters;
        r0.mcustom_filters = Internal.copyOf("mcustom_filters", this.mcustom_filters);
        r0.mplatform_custom_filters = Internal.copyOf("mplatform_custom_filters", this.mplatform_custom_filters);
        r0.mbiz_key = this.mbiz_key;
        r0.mparams = this.mparams;
        r0.mhighlight_selected_capsules = Internal.copyOf("mhighlight_selected_capsules", this.mhighlight_selected_capsules);
        r0.mfrom_apps = Internal.copyOf("mfrom_apps", this.mfrom_apps);
        r0.mapp_description = this.mapp_description;
        r0.menable_empty_query = this.menable_empty_query;
        r0.menable_hover_change = this.menable_hover_change;
        r0.mis_invisible = this.mis_invisible;
        r0.madv_grammar_confs = Internal.copyOf("madv_grammar_confs", this.madv_grammar_confs);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SearchTab.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2833newBuilder();
    }

    public SearchTab(String r21, com.ss.android.lark.pb.searches.SearchTabName r22, String r23, String r24, ResultType r25, List<FilterInTab> r26, Integer r27, List<SearchFilter.CustomFilterInfo> r28, List<PlatformSearchFilter.CustomFilterInfo> r29, BizKey r30, RequestParams r31, List<CapsuleInfo> r32, List<NavigationAppPopup> r33, String r34, Boolean r35, Boolean r36, Boolean r37, List<AdvGrammarConf> r38) {
        this(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, ByteString.EMPTY);
    }

    public SearchTab(String r4, com.ss.android.lark.pb.searches.SearchTabName r5, String r6, String r7, ResultType r8, List<FilterInTab> r9, Integer r10, List<SearchFilter.CustomFilterInfo> r11, List<PlatformSearchFilter.CustomFilterInfo> r12, BizKey r13, RequestParams r14, List<CapsuleInfo> r15, List<NavigationAppPopup> r16, String r17, Boolean r18, Boolean r19, Boolean r20, List<AdvGrammarConf> r21, ByteString r22) {
        super(ADAPTER, r22);
        this.mlabel = r4;
        this.mtype = r5;
        this.mapp_id = r6;
        this.micon_url = r7;
        this.mresult_type = r8;
        this.mfilters = Internal.immutableCopyOf("mfilters", r9);
        this.mtop_n_filters = r10;
        this.mcustom_filters = Internal.immutableCopyOf("mcustom_filters", r11);
        this.mplatform_custom_filters = Internal.immutableCopyOf("mplatform_custom_filters", r12);
        this.mbiz_key = r13;
        this.mparams = r14;
        this.mhighlight_selected_capsules = Internal.immutableCopyOf("mhighlight_selected_capsules", r15);
        this.mfrom_apps = Internal.immutableCopyOf("mfrom_apps", r16);
        this.mapp_description = r17;
        this.menable_empty_query = r18;
        this.menable_hover_change = r19;
        this.mis_invisible = r20;
        this.madv_grammar_confs = Internal.immutableCopyOf("madv_grammar_confs", r21);
    }
}
