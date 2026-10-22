package com.ss.android.lark.pb.searches;

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
public final class SearchFilter extends Message<SearchFilter, Builder> {
    public static final ProtoAdapter<SearchFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<SearchFilter, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SearchFilter m2132build() {
            return new SearchFilter(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2132build();
        }
    }

    public static final class CustomFilterInfo extends Message<CustomFilterInfo, Builder> {
        public static final ProtoAdapter<CustomFilterInfo> ADAPTER = null;
        public static final String DEFAULT_DISPLAY_NAME = "";
        public static final String DEFAULT_ID = "";
        private static final long serialVersionUID = 0;
        public final String mdisplay_name;
        public final String mid;
        public final List<String> moptions;
        public final FilterInTab msmart_tab_filter_type;
        public final FilterType mtype;

        public static final class Builder extends Message.Builder<CustomFilterInfo, Builder> {
            public String mdisplay_name;
            public String mid;
            public List<String> moptions;
            public FilterInTab msmart_tab_filter_type;
            public FilterType mtype;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CustomFilterInfo m2134build() {
                String r0 = this.mid;
                if (r0 == null) goto L11;
                if (this.mdisplay_name == null) goto L11;
                if (this.mtype == null) goto L11;
                return new CustomFilterInfo(this.mid, this.mdisplay_name, this.mtype, this.moptions, this.msmart_tab_filter_type, super.buildUnknownFields());
            L11:
                throw Internal.missingRequiredFields(new Object[]{r0, "mid", this.mdisplay_name, "mdisplay_name", this.mtype, "mtype"});
            }

            public Builder() {
                this.moptions = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2134build();
            }

            public Builder display_name(String r1) {
                this.mdisplay_name = r1;
                return this;
            }

            public Builder id(String r1) {
                this.mid = r1;
                return this;
            }

            public Builder options(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.moptions = r1;
                return this;
            }

            public Builder smart_tab_filter_type(FilterInTab r1) {
                this.msmart_tab_filter_type = r1;
                return this;
            }

            public Builder type(FilterType r1) {
                this.mtype = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_CustomFilterInfo extends ProtoAdapter<CustomFilterInfo> {
            public ProtoAdapter_CustomFilterInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, CustomFilterInfo.class);
            }

            public CustomFilterInfo decode(ProtoReader r9) throws IOException {
                Builder r0 = new Builder();
                r0.mid = "";
                r0.mdisplay_name = "";
                long r1 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L27;
                if (r3 != 1) goto L8;
                r0.mid = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.mdisplay_name = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.mtype = (FilterType) FilterType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
            L23:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r3 != 4) goto L14;
                r0.moptions.add((String) ProtoAdapter.STRING.decode(r9));
                goto L3
            L14:
                if (r3 != 5) goto L15;
                r0.msmart_tab_filter_type = (FilterInTab) FilterInTab.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
            L18:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L15:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L27:
                r9.endMessage(r1);
                return r0.m2134build();
            }

            public int encodedSize(CustomFilterInfo r6) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = ((r0.encodedSizeWithTag(1, r6.mid) + r0.encodedSizeWithTag(2, r6.mdisplay_name)) + FilterType.ADAPTER.encodedSizeWithTag(3, r6.mtype)) + r0.asRepeated().encodedSizeWithTag(4, r6.moptions);
                FilterInTab r2 = r6.msmart_tab_filter_type;
                if (r2 == null) goto L5;
                int r3 = FilterInTab.ADAPTER.encodedSizeWithTag(5, r2);
            L7:
                return (r1 + r3) + r6.unknownFields().size();
            L5:
                r3 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2135decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CustomFilterInfo) r1);
            }

            public void encode(ProtoWriter r5, CustomFilterInfo r6) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r5, 1, r6.mid);
                r0.encodeWithTag(r5, 2, r6.mdisplay_name);
                FilterType.ADAPTER.encodeWithTag(r5, 3, r6.mtype);
                r0.asRepeated().encodeWithTag(r5, 4, r6.moptions);
                FilterInTab r1 = r6.msmart_tab_filter_type;
                if (r1 == null) goto L5;
                FilterInTab.ADAPTER.encodeWithTag(r5, 5, r1);
            L5:
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CustomFilterInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomFilterInfo();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2133newBuilder() {
            Builder r0 = new Builder();
            r0.mid = this.mid;
            r0.mdisplay_name = this.mdisplay_name;
            r0.mtype = this.mtype;
            r0.moptions = Internal.copyOf("moptions", this.moptions);
            r0.msmart_tab_filter_type = this.msmart_tab_filter_type;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CustomFilterInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2133newBuilder();
        }

        public CustomFilterInfo(String r8, String r9, FilterType r10, List<String> r11, FilterInTab r12) {
            this(r8, r9, r10, r11, r12, ByteString.EMPTY);
        }

        public CustomFilterInfo(String r2, String r3, FilterType r4, List<String> r5, FilterInTab r6, ByteString r7) {
            super(ADAPTER, r7);
            this.mid = r2;
            this.mdisplay_name = r3;
            this.mtype = r4;
            this.moptions = Internal.immutableCopyOf("moptions", r5);
            this.msmart_tab_filter_type = r6;
        }
    }

    public static final enum FilterType extends Enum<FilterType> implements WireEnum {
        private static final /* synthetic */ FilterType[] $VALUES = null;
        public static final ProtoAdapter<FilterType> ADAPTER = null;
        public static final FilterType CHAT_FILTER = null;
        public static final FilterType DURATION_FILTER = null;
        public static final FilterType MULTIPLE_CHOICE_FILTER = null;
        public static final FilterType SINGLE_CHOICE_FILTER = null;
        public static final FilterType USER_FILTER = null;
        private final int value;

        static {
            FilterType r0 = new FilterType("USER_FILTER", 0, 1);
            USER_FILTER = r0;
            FilterType r1 = new FilterType("DURATION_FILTER", 1, 2);
            DURATION_FILTER = r1;
            FilterType r4 = new FilterType("SINGLE_CHOICE_FILTER", 2, 3);
            SINGLE_CHOICE_FILTER = r4;
            FilterType r6 = new FilterType("MULTIPLE_CHOICE_FILTER", 3, 4);
            MULTIPLE_CHOICE_FILTER = r6;
            FilterType r8 = new FilterType("CHAT_FILTER", 4, 5);
            CHAT_FILTER = r8;
            $VALUES = new FilterType[]{r0, r1, r4, r6, r8};
            ADAPTER = ProtoAdapter.newEnumAdapter(FilterType.class);
        }

        public static FilterType[] values() {
            return (FilterType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FilterType fromValue(int r1) {
            if (r1 == 1) goto L23;
            if (r1 == 2) goto L21;
            if (r1 == 3) goto L19;
            if (r1 == 4) goto L17;
            if (r1 == 5) goto L15;
            return null;
        L15:
            return CHAT_FILTER;
        L17:
            return MULTIPLE_CHOICE_FILTER;
        L19:
            return SINGLE_CHOICE_FILTER;
        L21:
            return DURATION_FILTER;
        L23:
            return USER_FILTER;
        }

        public static FilterType valueOf(String r1) {
            return (FilterType) a.a(FilterType.class, r1);
        }

        private FilterType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_SearchFilter extends ProtoAdapter<SearchFilter> {
        public ProtoAdapter_SearchFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchFilter.class);
        }

        public SearchFilter decode(ProtoReader r7) throws IOException {
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
            return r0.m2132build();
        }

        public int encodedSize(SearchFilter r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2136decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SearchFilter) r1);
        }

        public void encode(ProtoWriter r1, SearchFilter r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SearchFilter) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchFilter();
    }

    public SearchFilter() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2131newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SearchFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2131newBuilder();
    }

    public SearchFilter(ByteString r2) {
        super(ADAPTER, r2);
    }
}
