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
public final class PlatformSearchFilter extends Message<PlatformSearchFilter, Builder> {
    public static final ProtoAdapter<PlatformSearchFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<PlatformSearchFilter, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PlatformSearchFilter m2123build() {
            return new PlatformSearchFilter(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2123build();
        }
    }

    public static final class CustomFilterInfo extends Message<CustomFilterInfo, Builder> {
        public static final ProtoAdapter<CustomFilterInfo> ADAPTER = null;
        public static final String DEFAULT_DEFAULT_CHECKED_ID = "";
        public static final Boolean DEFAULT_DISABLE_EMPTY_SEARCH_ONLY_CHECKED = null;
        public static final String DEFAULT_DISPLAY_NAME = "";
        public static final String DEFAULT_ID = "";
        public static final String DEFAULT_REFERENCE_APP_ID = "";
        public static final Boolean DEFAULT_SHOULD_REPORT = null;
        private static final long serialVersionUID = 0;
        public final FilterInTab massociated_smart_filter;
        public final String mdefault_checked_id;
        public final Boolean mdisable_empty_search_only_checked;
        public final String mdisplay_name;
        public final FilterType mfilter_type;
        public final String mid;
        public final OptionMode moption_mode;
        public final List<EnumValue> mpredefine_enum_values;
        public final String mreference_app_id;
        public final Boolean mshould_report;

        public static final class Builder extends Message.Builder<CustomFilterInfo, Builder> {
            public FilterInTab massociated_smart_filter;
            public String mdefault_checked_id;
            public Boolean mdisable_empty_search_only_checked;
            public String mdisplay_name;
            public FilterType mfilter_type;
            public String mid;
            public OptionMode moption_mode;
            public List<EnumValue> mpredefine_enum_values;
            public String mreference_app_id;
            public Boolean mshould_report;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public CustomFilterInfo m2125build() {
                String r0 = this.mid;
                if (r0 == null) goto L11;
                if (this.mdisplay_name == null) goto L11;
                if (this.mfilter_type == null) goto L11;
                return new CustomFilterInfo(this.mid, this.mdisplay_name, this.mfilter_type, this.mpredefine_enum_values, this.moption_mode, this.mreference_app_id, this.massociated_smart_filter, this.mdefault_checked_id, this.mshould_report, this.mdisable_empty_search_only_checked, super.buildUnknownFields());
            L11:
                throw Internal.missingRequiredFields(new Object[]{r0, "mid", this.mdisplay_name, "mdisplay_name", this.mfilter_type, "mfilter_type"});
            }

            public Builder() {
                this.mpredefine_enum_values = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2125build();
            }

            public Builder associated_smart_filter(FilterInTab r1) {
                this.massociated_smart_filter = r1;
                return this;
            }

            public Builder default_checked_id(String r1) {
                this.mdefault_checked_id = r1;
                return this;
            }

            public Builder disable_empty_search_only_checked(Boolean r1) {
                this.mdisable_empty_search_only_checked = r1;
                return this;
            }

            public Builder display_name(String r1) {
                this.mdisplay_name = r1;
                return this;
            }

            public Builder filter_type(FilterType r1) {
                this.mfilter_type = r1;
                return this;
            }

            public Builder id(String r1) {
                this.mid = r1;
                return this;
            }

            public Builder option_mode(OptionMode r1) {
                this.moption_mode = r1;
                return this;
            }

            public Builder predefine_enum_values(List<EnumValue> r1) {
                Internal.checkElementsNotNull(r1);
                this.mpredefine_enum_values = r1;
                return this;
            }

            public Builder reference_app_id(String r1) {
                this.mreference_app_id = r1;
                return this;
            }

            public Builder should_report(Boolean r1) {
                this.mshould_report = r1;
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
                r0.mreference_app_id = "";
                r0.mdefault_checked_id = "";
                Boolean r1 = Boolean.FALSE;
                r0.mshould_report = r1;
                r0.mdisable_empty_search_only_checked = r1;
                long r2 = r9.beginMessage();
            L3:
                int r3 = r9.nextTag();
                if (r3 == (-1)) goto L26;
                switch(r3) {
                    case 1: goto L25;
                    case 2: goto L24;
                    case 3: goto L30;
                    case 4: goto L19;
                    case 5: goto L32;
                    case 6: goto L14;
                    case 7: goto L28;
                    case 8: goto L9;
                    case 9: goto L8;
                    case 10: goto L7;
                    default: goto L6;
                };
            L28:
                r0.massociated_smart_filter = (FilterInTab) FilterInTab.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
            L12:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L30:
                r0.mfilter_type = (FilterType) FilterType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            L22:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L32:
                r0.moption_mode = (OptionMode) OptionMode.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                r0.mdisable_empty_search_only_checked = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L8:
                r0.mshould_report = (Boolean) ProtoAdapter.BOOL.decode(r9);
                goto L3
            L9:
                r0.mdefault_checked_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L14:
                r0.mreference_app_id = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L19:
                r0.mpredefine_enum_values.add((EnumValue) EnumValue.ADAPTER.decode(r9));
                goto L3
            L24:
                r0.mdisplay_name = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L25:
                r0.mid = (String) ProtoAdapter.STRING.decode(r9);
                goto L3
            L6:
                FieldEncoding r4 = r9.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
                goto L3
            L26:
                r9.endMessage(r2);
                return r0.m2125build();
            }

            public int encodedSize(CustomFilterInfo r7) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                int r1 = ((r0.encodedSizeWithTag(1, r7.mid) + r0.encodedSizeWithTag(2, r7.mdisplay_name)) + FilterType.ADAPTER.encodedSizeWithTag(3, r7.mfilter_type)) + EnumValue.ADAPTER.asRepeated().encodedSizeWithTag(4, r7.mpredefine_enum_values);
                OptionMode r2 = r7.moption_mode;
                int r3 = 0;
                if (r2 == null) goto L5;
                int r4 = OptionMode.ADAPTER.encodedSizeWithTag(5, r2);
            L6:
                int r5 = r1 + r4;
                String r6 = r7.mreference_app_id;
                if (r6 == null) goto L9;
                int r8 = r0.encodedSizeWithTag(6, r6);
            L10:
                int r9 = r5 + r8;
                FilterInTab r10 = r7.massociated_smart_filter;
                if (r10 == null) goto L13;
                int r11 = FilterInTab.ADAPTER.encodedSizeWithTag(7, r10);
            L14:
                int r12 = r9 + r11;
                String r13 = r7.mdefault_checked_id;
                if (r13 == null) goto L17;
                int r14 = r0.encodedSizeWithTag(8, r13);
            L18:
                int r15 = r12 + r14;
                Boolean r16 = r7.mshould_report;
                if (r16 == null) goto L21;
                int r17 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r16);
            L22:
                int r18 = r15 + r17;
                Boolean r19 = r7.mdisable_empty_search_only_checked;
                if (r19 == null) goto L26;
                r3 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r19);
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
            public /* bridge */ /* synthetic */ Object m2126decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((CustomFilterInfo) r1);
            }

            public void encode(ProtoWriter r5, CustomFilterInfo r6) throws IOException {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                r0.encodeWithTag(r5, 1, r6.mid);
                r0.encodeWithTag(r5, 2, r6.mdisplay_name);
                FilterType.ADAPTER.encodeWithTag(r5, 3, r6.mfilter_type);
                EnumValue.ADAPTER.asRepeated().encodeWithTag(r5, 4, r6.mpredefine_enum_values);
                OptionMode r1 = r6.moption_mode;
                if (r1 == null) goto L5;
                OptionMode.ADAPTER.encodeWithTag(r5, 5, r1);
            L5:
                String r2 = r6.mreference_app_id;
                if (r2 == null) goto L8;
                r0.encodeWithTag(r5, 6, r2);
            L8:
                FilterInTab r3 = r6.massociated_smart_filter;
                if (r3 == null) goto L11;
                FilterInTab.ADAPTER.encodeWithTag(r5, 7, r3);
            L11:
                String r4 = r6.mdefault_checked_id;
                if (r4 == null) goto L14;
                r0.encodeWithTag(r5, 8, r4);
            L14:
                Boolean r7 = r6.mshould_report;
                if (r7 == null) goto L17;
                ProtoAdapter.BOOL.encodeWithTag(r5, 9, r7);
            L17:
                Boolean r8 = r6.mdisable_empty_search_only_checked;
                if (r8 == null) goto L20;
                ProtoAdapter.BOOL.encodeWithTag(r5, 10, r8);
            L20:
                r5.writeBytes(r6.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (CustomFilterInfo) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CustomFilterInfo();
            Boolean r0 = Boolean.FALSE;
            DEFAULT_SHOULD_REPORT = r0;
            DEFAULT_DISABLE_EMPTY_SEARCH_ONLY_CHECKED = r0;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2124newBuilder() {
            Builder r0 = new Builder();
            r0.mid = this.mid;
            r0.mdisplay_name = this.mdisplay_name;
            r0.mfilter_type = this.mfilter_type;
            r0.mpredefine_enum_values = Internal.copyOf("mpredefine_enum_values", this.mpredefine_enum_values);
            r0.moption_mode = this.moption_mode;
            r0.mreference_app_id = this.mreference_app_id;
            r0.massociated_smart_filter = this.massociated_smart_filter;
            r0.mdefault_checked_id = this.mdefault_checked_id;
            r0.mshould_report = this.mshould_report;
            r0.mdisable_empty_search_only_checked = this.mdisable_empty_search_only_checked;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return CustomFilterInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2124newBuilder();
        }

        public CustomFilterInfo(String r13, String r14, FilterType r15, List<EnumValue> r16, OptionMode r17, String r18, FilterInTab r19, String r20, Boolean r21, Boolean r22) {
            this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
        }

        public CustomFilterInfo(String r2, String r3, FilterType r4, List<EnumValue> r5, OptionMode r6, String r7, FilterInTab r8, String r9, Boolean r10, Boolean r11, ByteString r12) {
            super(ADAPTER, r12);
            this.mid = r2;
            this.mdisplay_name = r3;
            this.mfilter_type = r4;
            this.mpredefine_enum_values = Internal.immutableCopyOf("mpredefine_enum_values", r5);
            this.moption_mode = r6;
            this.mreference_app_id = r7;
            this.massociated_smart_filter = r8;
            this.mdefault_checked_id = r9;
            this.mshould_report = r10;
            this.mdisable_empty_search_only_checked = r11;
        }
    }

    public static final class EnumValue extends Message<EnumValue, Builder> {
        public static final ProtoAdapter<EnumValue> ADAPTER = null;
        public static final String DEFAULT_DISPLAY_TEXT = "";
        public static final String DEFAULT_ID = "";
        private static final long serialVersionUID = 0;
        public final String mdisplay_text;
        public final String mid;

        public static final class Builder extends Message.Builder<EnumValue, Builder> {
            public String mdisplay_text;
            public String mid;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public EnumValue m2128build() {
                return new EnumValue(this.mid, this.mdisplay_text, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2128build();
            }

            public Builder display_text(String r1) {
                this.mdisplay_text = r1;
                return this;
            }

            public Builder id(String r1) {
                this.mid = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_EnumValue extends ProtoAdapter<EnumValue> {
            public ProtoAdapter_EnumValue() {
                super(FieldEncoding.LENGTH_DELIMITED, EnumValue.class);
            }

            public EnumValue decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mid = "";
                r0.mdisplay_text = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L12;
                if (r3 != 1) goto L8;
                r0.mid = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.mdisplay_text = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L9:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L12:
                r7.endMessage(r1);
                return r0.m2128build();
            }

            public int encodedSize(EnumValue r5) {
                String r0 = r5.mid;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
            L6:
                String r3 = r5.mdisplay_text;
                if (r3 == null) goto L10;
                r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
            L10:
                return (r2 + r1) + r5.unknownFields().size();
            L5:
                r2 = 0;
                goto L6
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2129decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((EnumValue) r1);
            }

            public void encode(ProtoWriter r4, EnumValue r5) throws IOException {
                String r0 = r5.mid;
                if (r0 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
            L5:
                String r1 = r5.mdisplay_text;
                if (r1 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
            L8:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (EnumValue) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EnumValue();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2127newBuilder() {
            Builder r0 = new Builder();
            r0.mid = this.mid;
            r0.mdisplay_text = this.mdisplay_text;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return EnumValue.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2127newBuilder();
        }

        public EnumValue(String r2, String r3) {
            this(r2, r3, ByteString.EMPTY);
        }

        public EnumValue(String r2, String r3, ByteString r4) {
            super(ADAPTER, r4);
            this.mid = r2;
            this.mdisplay_text = r3;
        }
    }

    public static final enum FilterType extends Enum<FilterType> implements WireEnum {
        private static final /* synthetic */ FilterType[] $VALUES = null;
        public static final ProtoAdapter<FilterType> ADAPTER = null;
        public static final FilterType CALENDAR_FILTER = null;
        public static final FilterType INPUT_TEXT_FILTER = null;
        public static final FilterType MAIL_USER = null;
        public static final FilterType PREDEFINE_ENUM_FILTER = null;
        public static final FilterType SEARCHABLE_FILTER = null;
        public static final FilterType TIME_FILTER = null;
        public static final FilterType USER_CHAT_FILTER = null;
        public static final FilterType USER_FILTER = null;
        private final int value;

        static {
            FilterType r0 = new FilterType("USER_FILTER", 0, 1);
            USER_FILTER = r0;
            FilterType r1 = new FilterType("TIME_FILTER", 1, 2);
            TIME_FILTER = r1;
            FilterType r4 = new FilterType("SEARCHABLE_FILTER", 2, 4);
            SEARCHABLE_FILTER = r4;
            FilterType r6 = new FilterType("PREDEFINE_ENUM_FILTER", 3, 5);
            PREDEFINE_ENUM_FILTER = r6;
            FilterType r8 = new FilterType("MAIL_USER", 4, 6);
            MAIL_USER = r8;
            FilterType r11 = new FilterType("INPUT_TEXT_FILTER", 5, 7);
            INPUT_TEXT_FILTER = r11;
            FilterType r13 = new FilterType("USER_CHAT_FILTER", 6, 8);
            USER_CHAT_FILTER = r13;
            FilterType r15 = new FilterType("CALENDAR_FILTER", 7, 9);
            CALENDAR_FILTER = r15;
            $VALUES = new FilterType[]{r0, r1, r4, r6, r8, r11, r13, r15};
            ADAPTER = ProtoAdapter.newEnumAdapter(FilterType.class);
        }

        public static FilterType[] values() {
            return (FilterType[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FilterType fromValue(int r0) {
            switch(r0) {
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L3;
                case 4: goto L16;
                case 5: goto L14;
                case 6: goto L12;
                case 7: goto L10;
                case 8: goto L8;
                case 9: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return CALENDAR_FILTER;
        L8:
            return USER_CHAT_FILTER;
        L10:
            return INPUT_TEXT_FILTER;
        L12:
            return MAIL_USER;
        L14:
            return PREDEFINE_ENUM_FILTER;
        L16:
            return SEARCHABLE_FILTER;
        L18:
            return TIME_FILTER;
        L20:
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

    public static final enum OptionMode extends Enum<OptionMode> implements WireEnum {
        private static final /* synthetic */ OptionMode[] $VALUES = null;
        public static final ProtoAdapter<OptionMode> ADAPTER = null;
        public static final OptionMode MULTIPLE = null;
        public static final OptionMode SINGLE = null;
        private final int value;

        static {
            OptionMode r0 = new OptionMode("SINGLE", 0, 1);
            SINGLE = r0;
            OptionMode r1 = new OptionMode("MULTIPLE", 1, 2);
            MULTIPLE = r1;
            $VALUES = new OptionMode[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(OptionMode.class);
        }

        public static OptionMode[] values() {
            return (OptionMode[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static OptionMode fromValue(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return null;
        L9:
            return MULTIPLE;
        L11:
            return SINGLE;
        }

        public static OptionMode valueOf(String r1) {
            return (OptionMode) a.a(OptionMode.class, r1);
        }

        private OptionMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_PlatformSearchFilter extends ProtoAdapter<PlatformSearchFilter> {
        public ProtoAdapter_PlatformSearchFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, PlatformSearchFilter.class);
        }

        public PlatformSearchFilter decode(ProtoReader r7) throws IOException {
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
            return r0.m2123build();
        }

        public int encodedSize(PlatformSearchFilter r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2130decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PlatformSearchFilter) r1);
        }

        public void encode(ProtoWriter r1, PlatformSearchFilter r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PlatformSearchFilter) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PlatformSearchFilter();
    }

    public PlatformSearchFilter() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2122newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PlatformSearchFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2122newBuilder();
    }

    public PlatformSearchFilter(ByteString r2) {
        super(ADAPTER, r2);
    }
}
