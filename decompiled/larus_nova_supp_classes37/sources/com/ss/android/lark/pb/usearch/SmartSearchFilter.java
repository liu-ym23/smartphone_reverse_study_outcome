package com.ss.android.lark.pb.usearch;

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
public final class SmartSearchFilter extends Message<SmartSearchFilter, Builder> {
    public static final ProtoAdapter<SmartSearchFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<SmartSearchFilter, Builder> {
        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SmartSearchFilter m2855build() {
            return new SmartSearchFilter(super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2855build();
        }
    }

    public static final class FromUserFilter extends Message<FromUserFilter, Builder> {
        public static final ProtoAdapter<FromUserFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> muser_ids;

        public static final class Builder extends Message.Builder<FromUserFilter, Builder> {
            public List<String> muser_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public FromUserFilter m2857build() {
                return new FromUserFilter(this.muser_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.muser_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2857build();
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
                return r0.m2857build();
            }

            public int encodedSize(FromUserFilter r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.muser_ids) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2858decode(ProtoReader r1) throws IOException {
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
        public Builder m2856newBuilder() {
            Builder r0 = new Builder();
            r0.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return FromUserFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2856newBuilder();
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
            public InChatFilter m2860build() {
                return new InChatFilter(this.mgroup_chat_ids, this.mp2p_chatter_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mgroup_chat_ids = Internal.newMutableList();
                this.mp2p_chatter_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2860build();
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
                return r0.m2860build();
            }

            public int encodedSize(InChatFilter r5) {
                ProtoAdapter r0 = ProtoAdapter.STRING;
                return (r0.asRepeated().encodedSizeWithTag(1, r5.mgroup_chat_ids) + r0.asRepeated().encodedSizeWithTag(2, r5.mp2p_chatter_ids)) + r5.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2861decode(ProtoReader r1) throws IOException {
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
        public Builder m2859newBuilder() {
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
            return m2859newBuilder();
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

    public static final class ProtoAdapter_SmartSearchFilter extends ProtoAdapter<SmartSearchFilter> {
        public ProtoAdapter_SmartSearchFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, SmartSearchFilter.class);
        }

        public SmartSearchFilter decode(ProtoReader r7) throws IOException {
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
            return r0.m2855build();
        }

        public int encodedSize(SmartSearchFilter r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2862decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SmartSearchFilter) r1);
        }

        public void encode(ProtoWriter r1, SmartSearchFilter r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SmartSearchFilter) r2);
        }
    }

    public static final class TimeRangeFilter extends Message<TimeRangeFilter, Builder> {
        public static final ProtoAdapter<TimeRangeFilter> ADAPTER = null;
        public static final Long DEFAULT_CUSTOMIZED_END_TIME = null;
        public static final Long DEFAULT_CUSTOMIZED_START_TIME = null;
        private static final long serialVersionUID = 0;
        public final Long mcustomized_end_time;
        public final Long mcustomized_start_time;
        public final TimeRangeType mtime_range_type;

        public static final class Builder extends Message.Builder<TimeRangeFilter, Builder> {
            public Long mcustomized_end_time;
            public Long mcustomized_start_time;
            public TimeRangeType mtime_range_type;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public TimeRangeFilter m2864build() {
                return new TimeRangeFilter(this.mtime_range_type, this.mcustomized_start_time, this.mcustomized_end_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2864build();
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

        public static final class ProtoAdapter_TimeRangeFilter extends ProtoAdapter<TimeRangeFilter> {
            public ProtoAdapter_TimeRangeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, TimeRangeFilter.class);
            }

            public TimeRangeFilter decode(ProtoReader r9) throws IOException {
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
                return r0.m2864build();
            }

            public int encodedSize(TimeRangeFilter r6) {
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
            public /* bridge */ /* synthetic */ Object m2865decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((TimeRangeFilter) r1);
            }

            public void encode(ProtoWriter r4, TimeRangeFilter r5) throws IOException {
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
                encode(r1, (TimeRangeFilter) r2);
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
            ADAPTER = new ProtoAdapter_TimeRangeFilter();
            DEFAULT_CUSTOMIZED_START_TIME = 0L;
            DEFAULT_CUSTOMIZED_END_TIME = 0L;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2863newBuilder() {
            Builder r0 = new Builder();
            r0.mtime_range_type = this.mtime_range_type;
            r0.mcustomized_start_time = this.mcustomized_start_time;
            r0.mcustomized_end_time = this.mcustomized_end_time;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return TimeRangeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2863newBuilder();
        }

        public TimeRangeFilter(TimeRangeType r2, Long r3, Long r4) {
            this(r2, r3, r4, ByteString.EMPTY);
        }

        public TimeRangeFilter(TimeRangeType r2, Long r3, Long r4, ByteString r5) {
            super(ADAPTER, r5);
            this.mtime_range_type = r2;
            this.mcustomized_start_time = r3;
            this.mcustomized_end_time = r4;
        }
    }

    public static final class WithUserFilter extends Message<WithUserFilter, Builder> {
        public static final ProtoAdapter<WithUserFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> muser_ids;

        public static final class Builder extends Message.Builder<WithUserFilter, Builder> {
            public List<String> muser_ids;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public WithUserFilter m2867build() {
                return new WithUserFilter(this.muser_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.muser_ids = Internal.newMutableList();
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2867build();
            }

            public Builder user_ids(List<String> r1) {
                Internal.checkElementsNotNull(r1);
                this.muser_ids = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_WithUserFilter extends ProtoAdapter<WithUserFilter> {
            public ProtoAdapter_WithUserFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, WithUserFilter.class);
            }

            public WithUserFilter decode(ProtoReader r7) throws IOException {
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
                return r0.m2867build();
            }

            public int encodedSize(WithUserFilter r4) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r4.muser_ids) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2868decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((WithUserFilter) r1);
            }

            public void encode(ProtoWriter r4, WithUserFilter r5) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r4, 1, r5.muser_ids);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (WithUserFilter) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_WithUserFilter();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2866newBuilder() {
            Builder r0 = new Builder();
            r0.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return WithUserFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2866newBuilder();
        }

        public WithUserFilter(List<String> r2) {
            this(r2, ByteString.EMPTY);
        }

        public WithUserFilter(List<String> r2, ByteString r3) {
            super(ADAPTER, r3);
            this.muser_ids = Internal.immutableCopyOf("muser_ids", r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SmartSearchFilter();
    }

    public SmartSearchFilter() {
        this(ByteString.EMPTY);
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2854newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SmartSearchFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2854newBuilder();
    }

    public SmartSearchFilter(ByteString r2) {
        super(ADAPTER, r2);
    }
}
