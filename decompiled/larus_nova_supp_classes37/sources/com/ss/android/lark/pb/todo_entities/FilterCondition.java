package com.ss.android.lark.pb.todo_entities;

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
public final class FilterCondition extends Message<FilterCondition, Builder> {
    public static final ProtoAdapter<FilterCondition> ADAPTER = null;
    public static final String DEFAULT_FIELD_KEY = "";
    private static final long serialVersionUID = 0;
    public final List<FieldFilterValue> mfield_filter_value;
    public final String mfield_key;
    public final Option moptions;
    public final FilterPredicate mpredicate;

    public static final class Builder extends Message.Builder<FilterCondition, Builder> {
        public List<FieldFilterValue> mfield_filter_value;
        public String mfield_key;
        public Option moptions;
        public FilterPredicate mpredicate;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public FilterCondition m2288build() {
            return new FilterCondition(this.mfield_key, this.mpredicate, this.mfield_filter_value, this.moptions, super.buildUnknownFields());
        }

        public Builder() {
            this.mfield_filter_value = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2288build();
        }

        public Builder field_filter_value(List<FieldFilterValue> r1) {
            Internal.checkElementsNotNull(r1);
            this.mfield_filter_value = r1;
            return this;
        }

        public Builder field_key(String r1) {
            this.mfield_key = r1;
            return this;
        }

        public Builder options(Option r1) {
            this.moptions = r1;
            return this;
        }

        public Builder predicate(FilterPredicate r1) {
            this.mpredicate = r1;
            return this;
        }
    }

    public static final class Option extends Message<Option, Builder> {
        public static final ProtoAdapter<Option> ADAPTER = null;
        public static final Boolean DEFAULT_NO_PROCESS_AS_DATE = null;
        private static final long serialVersionUID = 0;
        public final Boolean mno_process_as_date;

        public static final class Builder extends Message.Builder<Option, Builder> {
            public Boolean mno_process_as_date;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public Option m2290build() {
                return new Option(this.mno_process_as_date, super.buildUnknownFields());
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m2290build();
            }

            public Builder no_process_as_date(Boolean r1) {
                this.mno_process_as_date = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_Option extends ProtoAdapter<Option> {
            public ProtoAdapter_Option() {
                super(FieldEncoding.LENGTH_DELIMITED, Option.class);
            }

            public Option decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.mno_process_as_date = Boolean.FALSE;
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.mno_process_as_date = (Boolean) ProtoAdapter.BOOL.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m2290build();
            }

            public int encodedSize(Option r4) {
                Boolean r0 = r4.mno_process_as_date;
                if (r0 == null) goto L5;
                int r1 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
            L7:
                return r1 + r4.unknownFields().size();
            L5:
                r1 = 0;
                goto L7
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m2291decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((Option) r1);
            }

            public void encode(ProtoWriter r4, Option r5) throws IOException {
                Boolean r0 = r5.mno_process_as_date;
                if (r0 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
            L5:
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (Option) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Option();
            DEFAULT_NO_PROCESS_AS_DATE = Boolean.FALSE;
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m2289newBuilder() {
            Builder r0 = new Builder();
            r0.mno_process_as_date = this.mno_process_as_date;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return Option.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m2289newBuilder();
        }

        public Option(Boolean r2) {
            this(r2, ByteString.EMPTY);
        }

        public Option(Boolean r2, ByteString r3) {
            super(ADAPTER, r3);
            this.mno_process_as_date = r2;
        }
    }

    public static final class ProtoAdapter_FilterCondition extends ProtoAdapter<FilterCondition> {
        public ProtoAdapter_FilterCondition() {
            super(FieldEncoding.LENGTH_DELIMITED, FilterCondition.class);
        }

        public FilterCondition decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mfield_key = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mfield_key = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mpredicate = (FilterPredicate) FilterPredicate.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.mfield_filter_value.add((FieldFilterValue) FieldFilterValue.ADAPTER.decode(r9));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.moptions = (Option) Option.ADAPTER.decode(r9);
            goto L3
        L13:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m2288build();
        }

        public int encodedSize(FilterCondition r6) {
            String r0 = r6.mfield_key;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            FilterPredicate r3 = r6.mpredicate;
            if (r3 == null) goto L9;
            int r4 = FilterPredicate.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = (r2 + r4) + FieldFilterValue.ADAPTER.asRepeated().encodedSizeWithTag(3, r6.mfield_filter_value);
            Option r7 = r6.moptions;
            if (r7 == null) goto L14;
            r1 = Option.ADAPTER.encodedSizeWithTag(4, r7);
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
        public /* bridge */ /* synthetic */ Object m2292decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((FilterCondition) r1);
        }

        public void encode(ProtoWriter r4, FilterCondition r5) throws IOException {
            String r0 = r5.mfield_key;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            FilterPredicate r1 = r5.mpredicate;
            if (r1 == null) goto L8;
            FilterPredicate.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            FieldFilterValue.ADAPTER.asRepeated().encodeWithTag(r4, 3, r5.mfield_filter_value);
            Option r2 = r5.moptions;
            if (r2 == null) goto L11;
            Option.ADAPTER.encodeWithTag(r4, 4, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (FilterCondition) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FilterCondition();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2287newBuilder() {
        Builder r0 = new Builder();
        r0.mfield_key = this.mfield_key;
        r0.mpredicate = this.mpredicate;
        r0.mfield_filter_value = Internal.copyOf("mfield_filter_value", this.mfield_filter_value);
        r0.moptions = this.moptions;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return FilterCondition.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2287newBuilder();
    }

    public FilterCondition(String r7, FilterPredicate r8, List<FieldFilterValue> r9, Option r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public FilterCondition(String r2, FilterPredicate r3, List<FieldFilterValue> r4, Option r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mfield_key = r2;
        this.mpredicate = r3;
        this.mfield_filter_value = Internal.immutableCopyOf("mfield_filter_value", r4);
        this.moptions = r5;
    }
}
