package com.ss.android.lark.pb.todo_entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DatetimeFieldFilterValue extends Message<DatetimeFieldFilterValue, Builder> {
    public static final ProtoAdapter<DatetimeFieldFilterValue> ADAPTER = null;
    public static final String DEFAULT_DATETIME = "";
    private static final long serialVersionUID = 0;
    public final String mdatetime;
    public final Type mtype;

    public static final class Builder extends Message.Builder<DatetimeFieldFilterValue, Builder> {
        public String mdatetime;
        public Type mtype;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DatetimeFieldFilterValue m2279build() {
            return new DatetimeFieldFilterValue(this.mtype, this.mdatetime, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2279build();
        }

        public Builder datetime(String r1) {
            this.mdatetime = r1;
            return this;
        }

        public Builder type(Type r1) {
            this.mtype = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_DatetimeFieldFilterValue extends ProtoAdapter<DatetimeFieldFilterValue> {
        public ProtoAdapter_DatetimeFieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, DatetimeFieldFilterValue.class);
        }

        public DatetimeFieldFilterValue decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mdatetime = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.mtype = (Type) Type.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.mdatetime = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L9:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L15:
            r9.endMessage(r1);
            return r0.m2279build();
        }

        public int encodedSize(DatetimeFieldFilterValue r5) {
            Type r0 = r5.mtype;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = Type.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r5.mdatetime;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2280decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DatetimeFieldFilterValue) r1);
        }

        public void encode(ProtoWriter r4, DatetimeFieldFilterValue r5) throws IOException {
            Type r0 = r5.mtype;
            if (r0 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mdatetime;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DatetimeFieldFilterValue) r2);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type LAST_MONTH = null;
        public static final Type LAST_WEEK = null;
        public static final Type NEXT_MONTH = null;
        public static final Type NEXT_WEEK = null;
        public static final Type THIS_MONTH = null;
        public static final Type THIS_WEEK = null;
        public static final Type TIMESTAMP = null;
        public static final Type TODAY = null;
        public static final Type TOMORROW = null;
        public static final Type UNKNOWN = null;
        public static final Type YESTERDAY = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("TIMESTAMP", 1, 1);
            TIMESTAMP = r1;
            Type r3 = new Type("TODAY", 2, 2);
            TODAY = r3;
            Type r5 = new Type("YESTERDAY", 3, 3);
            YESTERDAY = r5;
            Type r7 = new Type("TOMORROW", 4, 4);
            TOMORROW = r7;
            Type r9 = new Type("THIS_WEEK", 5, 5);
            THIS_WEEK = r9;
            Type r11 = new Type("LAST_WEEK", 6, 6);
            LAST_WEEK = r11;
            Type r13 = new Type("NEXT_WEEK", 7, 7);
            NEXT_WEEK = r13;
            Type r15 = new Type("THIS_MONTH", 8, 8);
            THIS_MONTH = r15;
            Type r14 = new Type("LAST_MONTH", 9, 9);
            LAST_MONTH = r14;
            Type r12 = new Type("NEXT_MONTH", 10, 10);
            NEXT_MONTH = r12;
            $VALUES = new Type[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r0) {
            switch(r0) {
                case 0: goto L26;
                case 1: goto L24;
                case 2: goto L22;
                case 3: goto L20;
                case 4: goto L18;
                case 5: goto L16;
                case 6: goto L14;
                case 7: goto L12;
                case 8: goto L10;
                case 9: goto L8;
                case 10: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return NEXT_MONTH;
        L8:
            return LAST_MONTH;
        L10:
            return THIS_MONTH;
        L12:
            return NEXT_WEEK;
        L14:
            return LAST_WEEK;
        L16:
            return THIS_WEEK;
        L18:
            return TOMORROW;
        L20:
            return YESTERDAY;
        L22:
            return TODAY;
        L24:
            return TIMESTAMP;
        L26:
            return UNKNOWN;
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        private Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DatetimeFieldFilterValue();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2278newBuilder() {
        Builder r0 = new Builder();
        r0.mtype = this.mtype;
        r0.mdatetime = this.mdatetime;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DatetimeFieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2278newBuilder();
    }

    public DatetimeFieldFilterValue(Type r2, String r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public DatetimeFieldFilterValue(Type r2, String r3, ByteString r4) {
        super(ADAPTER, r4);
        this.mtype = r2;
        this.mdatetime = r3;
    }
}
