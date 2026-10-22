package com.ss.android.lark.pb.usearch;

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
public final class PutSearchSettingsResponse extends Message<PutSearchSettingsResponse, Builder> {
    public static final ProtoAdapter<PutSearchSettingsResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Status mstatus;

    public static final class Builder extends Message.Builder<PutSearchSettingsResponse, Builder> {
        public Status mstatus;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PutSearchSettingsResponse m2777build() {
            return new PutSearchSettingsResponse(this.mstatus, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2777build();
        }

        public Builder status(Status r1) {
            this.mstatus = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PutSearchSettingsResponse extends ProtoAdapter<PutSearchSettingsResponse> {
        public ProtoAdapter_PutSearchSettingsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutSearchSettingsResponse.class);
        }

        public PutSearchSettingsResponse decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L7;
            r0.mstatus = (Status) Status.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
            return r0.m2777build();
        }

        public int encodedSize(PutSearchSettingsResponse r4) {
            Status r0 = r4.mstatus;
            if (r0 == null) goto L5;
            int r1 = Status.ADAPTER.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2778decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PutSearchSettingsResponse) r1);
        }

        public void encode(ProtoWriter r4, PutSearchSettingsResponse r5) throws IOException {
            Status r0 = r5.mstatus;
            if (r0 == null) goto L5;
            Status.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PutSearchSettingsResponse) r2);
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status DEFAULT = null;
        public static final Status FAIL = null;
        public static final Status SUCCESS = null;
        private final int value;

        static {
            Status r0 = new Status("DEFAULT", 0, 0);
            DEFAULT = r0;
            Status r1 = new Status("SUCCESS", 1, 1);
            SUCCESS = r1;
            Status r3 = new Status("FAIL", 2, 2);
            FAIL = r3;
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
            return FAIL;
        L12:
            return SUCCESS;
        L14:
            return DEFAULT;
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
        ADAPTER = new ProtoAdapter_PutSearchSettingsResponse();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2776newBuilder() {
        Builder r0 = new Builder();
        r0.mstatus = this.mstatus;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PutSearchSettingsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2776newBuilder();
    }

    public PutSearchSettingsResponse(Status r2) {
        this(r2, ByteString.EMPTY);
    }

    public PutSearchSettingsResponse(Status r2, ByteString r3) {
        super(ADAPTER, r3);
        this.mstatus = r2;
    }
}
