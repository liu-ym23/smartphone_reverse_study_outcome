package com.ss.ugc.live.sdk.msg.unify.data.idl;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class UMGWDownlinkPacket extends AndroidMessage<UMGWDownlinkPacket, Builder> {
    public static final ProtoAdapter<UMGWDownlinkPacket> ADAPTER = null;
    public static final Parcelable.Creator<UMGWDownlinkPacket> CREATOR = null;
    public static final UMGWEventType DEFAULT_EVENT_TYPE = null;
    public static final Long DEFAULT_STATUS_CODE = null;
    public static final String DEFAULT_STATUS_MESSAGE = "";
    public static final Long DEFAULT_UNIQUE_ID = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWEventData#ADAPTER", tag = 5)
    public final UMGWEventData event_data;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWEventType#ADAPTER", tag = 4)
    public final UMGWEventType event_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long status_code;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String status_message;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long unique_id;

    public static final class Builder extends Message.Builder<UMGWDownlinkPacket, Builder> {
        public UMGWEventData event_data;
        public UMGWEventType event_type;
        public Long status_code;
        public String status_message;
        public Long unique_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UMGWDownlinkPacket m1694build() {
            return new UMGWDownlinkPacket(this.status_code, this.status_message, this.unique_id, this.event_type, this.event_data, super.buildUnknownFields());
        }

        public Builder() {
            this.status_code = 0L;
            this.status_message = "";
            this.unique_id = 0L;
            this.event_type = UMGWEventType.FETCH;
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1694build();
        }

        public Builder event_data(UMGWEventData r1) {
            this.event_data = r1;
            return this;
        }

        public Builder event_type(UMGWEventType r1) {
            this.event_type = r1;
            return this;
        }

        public Builder status_code(Long r1) {
            this.status_code = r1;
            return this;
        }

        public Builder status_message(String r1) {
            this.status_message = r1;
            return this;
        }

        public Builder unique_id(Long r1) {
            this.unique_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UMGWDownlinkPacket extends ProtoAdapter<UMGWDownlinkPacket> {
        public ProtoAdapter_UMGWDownlinkPacket() {
            super(FieldEncoding.LENGTH_DELIMITED, UMGWDownlinkPacket.class);
        }

        public UMGWDownlinkPacket decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L24;
            if (r3 != 1) goto L8;
            r0.status_code((Long) ProtoAdapter.INT64.decode(r9));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.status_message((String) ProtoAdapter.STRING.decode(r9));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.unique_id((Long) ProtoAdapter.INT64.decode(r9));
            goto L3
        L12:
            if (r3 != 4) goto L14;
            r0.event_type((UMGWEventType) UMGWEventType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r3 != 5) goto L15;
            r0.event_data((UMGWEventData) UMGWEventData.ADAPTER.decode(r9));
            goto L3
        L15:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L24:
            r9.endMessage(r1);
            return r0.m1694build();
        }

        public int encodedSize(UMGWDownlinkPacket r6) {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            return ((((r0.encodedSizeWithTag(1, r6.status_code) + ProtoAdapter.STRING.encodedSizeWithTag(2, r6.status_message)) + r0.encodedSizeWithTag(3, r6.unique_id)) + UMGWEventType.ADAPTER.encodedSizeWithTag(4, r6.event_type)) + UMGWEventData.ADAPTER.encodedSizeWithTag(5, r6.event_data)) + r6.unknownFields().size();
        }

        public UMGWDownlinkPacket redact(UMGWDownlinkPacket r3) {
            Builder r4 = r3.m1693newBuilder();
            UMGWEventData r0 = r4.event_data;
            if (r0 == null) goto L5;
            r4.event_data = (UMGWEventData) UMGWEventData.ADAPTER.redact(r0);
        L5:
            r4.clearUnknownFields();
            return r4.m1694build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1695decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UMGWDownlinkPacket) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((UMGWDownlinkPacket) r1);
        }

        public void encode(ProtoWriter r5, UMGWDownlinkPacket r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r5, 1, r6.status_code);
            ProtoAdapter.STRING.encodeWithTag(r5, 2, r6.status_message);
            r0.encodeWithTag(r5, 3, r6.unique_id);
            UMGWEventType.ADAPTER.encodeWithTag(r5, 4, r6.event_type);
            UMGWEventData.ADAPTER.encodeWithTag(r5, 5, r6.event_data);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UMGWDownlinkPacket) r2);
        }
    }

    static {
        ProtoAdapter_UMGWDownlinkPacket r0 = new ProtoAdapter_UMGWDownlinkPacket();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_STATUS_CODE = 0L;
        DEFAULT_UNIQUE_ID = 0L;
        DEFAULT_EVENT_TYPE = UMGWEventType.FETCH;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L25;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.status_code;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.status_message;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Long r9 = this.unique_id;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        UMGWEventType r12 = this.event_type;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        UMGWEventData r15 = this.event_data;
        if (r15 == null) goto L23;
        r3 = r15.hashCode();
    L23:
        int r16 = r14 + r3;
        ((Message) this).hashCode = r16;
        return r16;
    L19:
        r13 = 0;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L25:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1693newBuilder() {
        Builder r0 = new Builder();
        r0.status_code = this.status_code;
        r0.status_message = this.status_message;
        r0.unique_id = this.unique_id;
        r0.event_type = this.event_type;
        r0.event_data = this.event_data;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.status_code == null) goto L6;
        r0.append(", status_code=");
        r0.append(this.status_code);
    L6:
        if (this.status_message == null) goto L9;
        r0.append(", status_message=");
        r0.append(this.status_message);
    L9:
        if (this.unique_id == null) goto L12;
        r0.append(", unique_id=");
        r0.append(this.unique_id);
    L12:
        if (this.event_type == null) goto L15;
        r0.append(", event_type=");
        r0.append(this.event_type);
    L15:
        if (this.event_data == null) goto L17;
        r0.append(", event_data=");
        r0.append(this.event_data);
    L17:
        StringBuilder r1 = r0.replace(0, 2, "UMGWDownlinkPacket{");
        r1.append('}');
        return r1.toString();
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1693newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof UMGWDownlinkPacket) == true) goto L8;
        return false;
    L8:
        UMGWDownlinkPacket r6 = (UMGWDownlinkPacket) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L21:
        return false;
    L11:
        if (Internal.equals(this.status_code, r6.status_code) == false) goto L21;
        if (Internal.equals(this.status_message, r6.status_message) == false) goto L21;
        if (Internal.equals(this.unique_id, r6.unique_id) == false) goto L21;
        if (Internal.equals(this.event_type, r6.event_type) == false) goto L21;
        if (Internal.equals(this.event_data, r6.event_data) == false) goto L21;
        return true;
    }

    public UMGWDownlinkPacket(Long r8, String r9, Long r10, UMGWEventType r11, UMGWEventData r12) {
        this(r8, r9, r10, r11, r12, ByteString.EMPTY);
    }

    public UMGWDownlinkPacket(Long r2, String r3, Long r4, UMGWEventType r5, UMGWEventData r6, ByteString r7) {
        super(ADAPTER, r7);
        this.status_code = r2;
        this.status_message = r3;
        this.unique_id = r4;
        this.event_type = r5;
        this.event_data = r6;
    }
}
