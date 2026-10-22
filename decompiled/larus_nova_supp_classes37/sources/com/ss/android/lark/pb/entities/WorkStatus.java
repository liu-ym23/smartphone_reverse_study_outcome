package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class WorkStatus extends com.squareup.wire.Message<WorkStatus, Builder> {
    public static final ProtoAdapter<WorkStatus> ADAPTER = null;
    public static final Long DEFAULT_END_TIME = null;
    public static final Long DEFAULT_START_TIME = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> mdescription_templates;
    public final Long mend_time;
    public final Long mstart_time;
    public final Status mstatus;

    public static final class Builder extends com.squareup.wire.Message.Builder<WorkStatus, Builder> {
        public Map<String, String> mdescription_templates;
        public Long mend_time;
        public Long mstart_time;
        public Status mstatus;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public WorkStatus m1688build() {
            return new WorkStatus(this.mstatus, this.mstart_time, this.mend_time, this.mdescription_templates, super.buildUnknownFields());
        }

        public Builder() {
            this.mdescription_templates = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1688build();
        }

        public Builder description_templates(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.mdescription_templates = r1;
            return this;
        }

        public Builder end_time(Long r1) {
            this.mend_time = r1;
            return this;
        }

        public Builder start_time(Long r1) {
            this.mstart_time = r1;
            return this;
        }

        public Builder status(Status r1) {
            this.mstatus = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_WorkStatus extends ProtoAdapter<WorkStatus> {
        private final ProtoAdapter<Map<String, String>> mdescription_templates;

        public ProtoAdapter_WorkStatus() {
            super(FieldEncoding.LENGTH_DELIMITED, WorkStatus.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.mdescription_templates = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public WorkStatus decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mstart_time = 0L;
            r0.mend_time = 0L;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L14;
            switch(r3) {
                case 7: goto L16;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L16:
            r0.mstatus = (Status) Status.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mdescription_templates.putAll((Map) this.mdescription_templates.decode(r9));
            goto L3
        L8:
            r0.mend_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L9:
            r0.mstart_time = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L14:
            r9.endMessage(r1);
            return r0.m1688build();
        }

        public int encodedSize(WorkStatus r6) {
            Status r0 = r6.mstatus;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = Status.ADAPTER.encodedSizeWithTag(7, r0);
        L6:
            Long r3 = r6.mstart_time;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.INT64.encodedSizeWithTag(8, r3);
        L10:
            int r5 = r2 + r4;
            Long r7 = r6.mend_time;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(9, r7);
        L14:
            return ((r5 + r1) + this.mdescription_templates.encodedSizeWithTag(10, r6.mdescription_templates)) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1689decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((WorkStatus) r1);
        }

        public void encode(ProtoWriter r4, WorkStatus r5) throws IOException {
            Status r0 = r5.mstatus;
            if (r0 == null) goto L5;
            Status.ADAPTER.encodeWithTag(r4, 7, r0);
        L5:
            Long r1 = r5.mstart_time;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 8, r1);
        L8:
            Long r2 = r5.mend_time;
            if (r2 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r4, 9, r2);
        L11:
            this.mdescription_templates.encodeWithTag(r4, 10, r5.mdescription_templates);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (WorkStatus) r2);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status ON_LEAVE = null;
        public static final Status ON_MEETING = null;
        public static final Status UNKNOWN = null;
        private final int value;

        static {
            Status r0 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Status r1 = new Status("ON_LEAVE", 1, 1);
            ON_LEAVE = r1;
            Status r3 = new Status("ON_MEETING", 2, 2);
            ON_MEETING = r3;
            $VALUES = new Status[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return ON_MEETING;
        L12:
            return ON_LEAVE;
        L14:
            return UNKNOWN;
        }

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        private Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WorkStatus();
        DEFAULT_START_TIME = 0L;
        DEFAULT_END_TIME = 0L;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1687newBuilder() {
        Builder r0 = new Builder();
        r0.mstatus = this.mstatus;
        r0.mstart_time = this.mstart_time;
        r0.mend_time = this.mend_time;
        r0.mdescription_templates = Internal.copyOf("mdescription_templates", this.mdescription_templates);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return WorkStatus.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1687newBuilder();
    }

    public WorkStatus(Status r7, Long r8, Long r9, Map<String, String> r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public WorkStatus(Status r2, Long r3, Long r4, Map<String, String> r5, ByteString r6) {
        super(ADAPTER, r6);
        this.mstatus = r2;
        this.mstart_time = r3;
        this.mend_time = r4;
        this.mdescription_templates = Internal.immutableCopyOf("mdescription_templates", r5);
    }
}
