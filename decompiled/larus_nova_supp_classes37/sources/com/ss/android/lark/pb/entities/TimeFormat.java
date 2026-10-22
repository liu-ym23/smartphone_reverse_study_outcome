package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TimeFormat extends com.squareup.wire.Message<TimeFormat, Builder> {
    public static final ProtoAdapter<TimeFormat> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SHOW_TO_OTHERS = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_show_to_others;
    public final StartEndLayout mstart_end_layout;
    public final TimeUnit mtime_unit;

    public static final class Builder extends com.squareup.wire.Message.Builder<TimeFormat, Builder> {
        public Boolean mis_show_to_others;
        public StartEndLayout mstart_end_layout;
        public TimeUnit mtime_unit;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TimeFormat m1559build() {
            return new TimeFormat(this.mtime_unit, this.mstart_end_layout, this.mis_show_to_others, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1559build();
        }

        public Builder is_show_to_others(Boolean r1) {
            this.mis_show_to_others = r1;
            return this;
        }

        public Builder start_end_layout(StartEndLayout r1) {
            this.mstart_end_layout = r1;
            return this;
        }

        public Builder time_unit(TimeUnit r1) {
            this.mtime_unit = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TimeFormat extends ProtoAdapter<TimeFormat> {
        public ProtoAdapter_TimeFormat() {
            super(FieldEncoding.LENGTH_DELIMITED, TimeFormat.class);
        }

        public TimeFormat decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mis_show_to_others = Boolean.FALSE;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L21;
            if (r3 != 1) goto L8;
            r0.mtime_unit = (TimeUnit) TimeUnit.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mstart_end_layout = (StartEndLayout) StartEndLayout.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mis_show_to_others = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L21:
            r9.endMessage(r1);
            return r0.m1559build();
        }

        public int encodedSize(TimeFormat r6) {
            TimeUnit r0 = r6.mtime_unit;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = TimeUnit.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            StartEndLayout r3 = r6.mstart_end_layout;
            if (r3 == null) goto L9;
            int r4 = StartEndLayout.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.mis_show_to_others;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m1560decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TimeFormat) r1);
        }

        public void encode(ProtoWriter r4, TimeFormat r5) throws IOException {
            TimeUnit r0 = r5.mtime_unit;
            if (r0 == null) goto L5;
            TimeUnit.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            StartEndLayout r1 = r5.mstart_end_layout;
            if (r1 == null) goto L8;
            StartEndLayout.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.mis_show_to_others;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TimeFormat) r2);
        }
    }

    public static final enum StartEndLayout extends Enum<StartEndLayout> implements WireEnum {
        private static final /* synthetic */ StartEndLayout[] $VALUES = null;
        public static final ProtoAdapter<StartEndLayout> ADAPTER = null;
        public static final StartEndLayout END_ONLY = null;
        public static final StartEndLayout HIDE = null;
        public static final StartEndLayout NORMAL = null;
        public static final StartEndLayout START_ONLY = null;
        private final int value;

        static {
            StartEndLayout r0 = new StartEndLayout("HIDE", 0, 0);
            HIDE = r0;
            StartEndLayout r1 = new StartEndLayout("NORMAL", 1, 1);
            NORMAL = r1;
            StartEndLayout r3 = new StartEndLayout("START_ONLY", 2, 2);
            START_ONLY = r3;
            StartEndLayout r5 = new StartEndLayout("END_ONLY", 3, 3);
            END_ONLY = r5;
            $VALUES = new StartEndLayout[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(StartEndLayout.class);
        }

        public static StartEndLayout[] values() {
            return (StartEndLayout[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static StartEndLayout fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return END_ONLY;
        L14:
            return START_ONLY;
        L16:
            return NORMAL;
        L18:
            return HIDE;
        }

        public static StartEndLayout valueOf(String r1) {
            return (StartEndLayout) a.a(StartEndLayout.class, r1);
        }

        private StartEndLayout(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TimeFormat();
        DEFAULT_IS_SHOW_TO_OTHERS = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1558newBuilder() {
        Builder r0 = new Builder();
        r0.mtime_unit = this.mtime_unit;
        r0.mstart_end_layout = this.mstart_end_layout;
        r0.mis_show_to_others = this.mis_show_to_others;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TimeFormat.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1558newBuilder();
    }

    public TimeFormat(TimeUnit r2, StartEndLayout r3, Boolean r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public TimeFormat(TimeUnit r2, StartEndLayout r3, Boolean r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mtime_unit = r2;
        this.mstart_end_layout = r3;
        this.mis_show_to_others = r4;
    }
}
