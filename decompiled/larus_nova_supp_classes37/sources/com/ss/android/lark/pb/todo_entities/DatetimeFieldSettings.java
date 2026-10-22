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
public final class DatetimeFieldSettings extends Message<DatetimeFieldSettings, Builder> {
    public static final ProtoAdapter<DatetimeFieldSettings> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DateFormat mformat;

    public static final class Builder extends Message.Builder<DatetimeFieldSettings, Builder> {
        public DateFormat mformat;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DatetimeFieldSettings m2282build() {
            return new DatetimeFieldSettings(this.mformat, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2282build();
        }

        public Builder format(DateFormat r1) {
            this.mformat = r1;
            return this;
        }
    }

    public static final enum DateFormat extends Enum<DateFormat> implements WireEnum {
        private static final /* synthetic */ DateFormat[] $VALUES = null;
        public static final ProtoAdapter<DateFormat> ADAPTER = null;
        public static final DateFormat DD_MM_YYYY_SLASH = null;
        public static final DateFormat DEFAULT = null;
        public static final DateFormat MM_DD_YYYY_SLASH = null;
        public static final DateFormat YYYY_MM_DD_DASH = null;
        public static final DateFormat YYYY_MM_DD_SLASH = null;
        private final int value;

        static {
            DateFormat r0 = new DateFormat("DEFAULT", 0, 0);
            DEFAULT = r0;
            DateFormat r1 = new DateFormat("YYYY_MM_DD_DASH", 1, 1);
            YYYY_MM_DD_DASH = r1;
            DateFormat r3 = new DateFormat("YYYY_MM_DD_SLASH", 2, 2);
            YYYY_MM_DD_SLASH = r3;
            DateFormat r5 = new DateFormat("MM_DD_YYYY_SLASH", 3, 3);
            MM_DD_YYYY_SLASH = r5;
            DateFormat r7 = new DateFormat("DD_MM_YYYY_SLASH", 4, 4);
            DD_MM_YYYY_SLASH = r7;
            $VALUES = new DateFormat[]{r0, r1, r3, r5, r7};
            ADAPTER = ProtoAdapter.newEnumAdapter(DateFormat.class);
        }

        public static DateFormat[] values() {
            return (DateFormat[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static DateFormat fromValue(int r1) {
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L20;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L16;
            if (r1 == 4) goto L14;
            return null;
        L14:
            return DD_MM_YYYY_SLASH;
        L16:
            return MM_DD_YYYY_SLASH;
        L18:
            return YYYY_MM_DD_SLASH;
        L20:
            return YYYY_MM_DD_DASH;
        L22:
            return DEFAULT;
        }

        public static DateFormat valueOf(String r1) {
            return (DateFormat) a.a(DateFormat.class, r1);
        }

        private DateFormat(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_DatetimeFieldSettings extends ProtoAdapter<DatetimeFieldSettings> {
        public ProtoAdapter_DatetimeFieldSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, DatetimeFieldSettings.class);
        }

        public DatetimeFieldSettings decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L7;
            r0.mformat = (DateFormat) DateFormat.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
            return r0.m2282build();
        }

        public int encodedSize(DatetimeFieldSettings r4) {
            DateFormat r0 = r4.mformat;
            if (r0 == null) goto L5;
            int r1 = DateFormat.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2283decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DatetimeFieldSettings) r1);
        }

        public void encode(ProtoWriter r4, DatetimeFieldSettings r5) throws IOException {
            DateFormat r0 = r5.mformat;
            if (r0 == null) goto L5;
            DateFormat.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DatetimeFieldSettings) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DatetimeFieldSettings();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2281newBuilder() {
        Builder r0 = new Builder();
        r0.mformat = this.mformat;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DatetimeFieldSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2281newBuilder();
    }

    public DatetimeFieldSettings(DateFormat r2) {
        this(r2, ByteString.EMPTY);
    }

    public DatetimeFieldSettings(DateFormat r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mformat = r2;
    }
}
