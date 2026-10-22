package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TransExtra extends com.squareup.wire.Message<TransExtra, Builder> {
    public static final ProtoAdapter<TransExtra> ADAPTER = null;
    public static final String DEFAULT_RECEIVER_DEVICE_ID = "";
    public static final String DEFAULT_SENDER_DEVICE_ID = "";
    private static final long serialVersionUID = 0;
    public final String mreceiver_device_id;
    public final String msender_device_id;
    public final TransStatus mstatus;

    public static final class Builder extends com.squareup.wire.Message.Builder<TransExtra, Builder> {
        public String mreceiver_device_id;
        public String msender_device_id;
        public TransStatus mstatus;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public TransExtra m1568build() {
            return new TransExtra(this.mstatus, this.msender_device_id, this.mreceiver_device_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return m1568build();
        }

        public Builder receiver_device_id(String r1) {
            this.mreceiver_device_id = r1;
            return this;
        }

        public Builder sender_device_id(String r1) {
            this.msender_device_id = r1;
            return this;
        }

        public Builder status(TransStatus r1) {
            this.mstatus = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_TransExtra extends ProtoAdapter<TransExtra> {
        public ProtoAdapter_TransExtra() {
            super(FieldEncoding.LENGTH_DELIMITED, TransExtra.class);
        }

        public TransExtra decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.msender_device_id = "";
            r0.mreceiver_device_id = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mstatus = (TransStatus) TransStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.msender_device_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mreceiver_device_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m1568build();
        }

        public int encodedSize(TransExtra r6) {
            TransStatus r0 = r6.mstatus;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = TransStatus.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.msender_device_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mreceiver_device_id;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
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
        public /* bridge */ /* synthetic */ Object m1569decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((TransExtra) r1);
        }

        public void encode(ProtoWriter r4, TransExtra r5) throws IOException {
            TransStatus r0 = r5.mstatus;
            if (r0 == null) goto L5;
            TransStatus.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.msender_device_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mreceiver_device_id;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (TransExtra) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TransExtra();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1567newBuilder() {
        Builder r0 = new Builder();
        r0.mstatus = this.mstatus;
        r0.msender_device_id = this.msender_device_id;
        r0.mreceiver_device_id = this.mreceiver_device_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return TransExtra.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return m1567newBuilder();
    }

    public TransExtra(TransStatus r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public TransExtra(TransStatus r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mstatus = r2;
        this.msender_device_id = r3;
        this.mreceiver_device_id = r4;
    }
}
