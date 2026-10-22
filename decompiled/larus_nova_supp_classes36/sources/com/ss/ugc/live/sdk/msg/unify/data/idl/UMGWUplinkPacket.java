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
public final class UMGWUplinkPacket extends AndroidMessage<UMGWUplinkPacket, Builder> {
    public static final ProtoAdapter<UMGWUplinkPacket> ADAPTER = null;
    public static final Parcelable.Creator<UMGWUplinkPacket> CREATOR = null;
    public static final UMGWEventType DEFAULT_EVENT_TYPE = null;
    public static final Long DEFAULT_UNIQUE_ID = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWEventData#ADAPTER", tag = 3)
    public final UMGWEventData event_data;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.UMGWEventType#ADAPTER", tag = 2)
    public final UMGWEventType event_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long unique_id;

    public static final class Builder extends Message.Builder<UMGWUplinkPacket, Builder> {
        public UMGWEventData event_data;
        public UMGWEventType event_type;
        public Long unique_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public UMGWUplinkPacket m1707build() {
            return new UMGWUplinkPacket(this.unique_id, this.event_type, this.event_data, super.buildUnknownFields());
        }

        public Builder() {
            this.unique_id = 0L;
            this.event_type = UMGWEventType.FETCH;
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1707build();
        }

        public Builder event_data(UMGWEventData r1) {
            this.event_data = r1;
            return this;
        }

        public Builder event_type(UMGWEventType r1) {
            this.event_type = r1;
            return this;
        }

        public Builder unique_id(Long r1) {
            this.unique_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_UMGWUplinkPacket extends ProtoAdapter<UMGWUplinkPacket> {
        public ProtoAdapter_UMGWUplinkPacket() {
            super(FieldEncoding.LENGTH_DELIMITED, UMGWUplinkPacket.class);
        }

        public UMGWUplinkPacket decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.unique_id((Long) ProtoAdapter.INT64.decode(r9));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.event_type((UMGWEventType) UMGWEventType.ADAPTER.decode(r9));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.event_data((UMGWEventData) UMGWEventData.ADAPTER.decode(r9));
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m1707build();
        }

        public int encodedSize(UMGWUplinkPacket r5) {
            return ((ProtoAdapter.INT64.encodedSizeWithTag(1, r5.unique_id) + UMGWEventType.ADAPTER.encodedSizeWithTag(2, r5.event_type)) + UMGWEventData.ADAPTER.encodedSizeWithTag(3, r5.event_data)) + r5.unknownFields().size();
        }

        public UMGWUplinkPacket redact(UMGWUplinkPacket r3) {
            Builder r4 = r3.m1706newBuilder();
            UMGWEventData r0 = r4.event_data;
            if (r0 == null) goto L5;
            r4.event_data = (UMGWEventData) UMGWEventData.ADAPTER.redact(r0);
        L5:
            r4.clearUnknownFields();
            return r4.m1707build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1708decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((UMGWUplinkPacket) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((UMGWUplinkPacket) r1);
        }

        public void encode(ProtoWriter r4, UMGWUplinkPacket r5) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r5.unique_id);
            UMGWEventType.ADAPTER.encodeWithTag(r4, 2, r5.event_type);
            UMGWEventData.ADAPTER.encodeWithTag(r4, 3, r5.event_data);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (UMGWUplinkPacket) r2);
        }
    }

    static {
        ProtoAdapter_UMGWUplinkPacket r0 = new ProtoAdapter_UMGWUplinkPacket();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_UNIQUE_ID = 0L;
        DEFAULT_EVENT_TYPE = UMGWEventType.FETCH;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.unique_id;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        UMGWEventType r6 = this.event_type;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        UMGWEventData r9 = this.event_data;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = r8 + r3;
        ((Message) this).hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1706newBuilder() {
        Builder r0 = new Builder();
        r0.unique_id = this.unique_id;
        r0.event_type = this.event_type;
        r0.event_data = this.event_data;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.unique_id == null) goto L6;
        r0.append(", unique_id=");
        r0.append(this.unique_id);
    L6:
        if (this.event_type == null) goto L9;
        r0.append(", event_type=");
        r0.append(this.event_type);
    L9:
        if (this.event_data == null) goto L11;
        r0.append(", event_data=");
        r0.append(this.event_data);
    L11:
        StringBuilder r1 = r0.replace(0, 2, "UMGWUplinkPacket{");
        r1.append('}');
        return r1.toString();
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1706newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof UMGWUplinkPacket) == true) goto L8;
        return false;
    L8:
        UMGWUplinkPacket r6 = (UMGWUplinkPacket) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L17:
        return false;
    L11:
        if (Internal.equals(this.unique_id, r6.unique_id) == false) goto L17;
        if (Internal.equals(this.event_type, r6.event_type) == false) goto L17;
        if (Internal.equals(this.event_data, r6.event_data) == false) goto L17;
        return true;
    }

    public UMGWUplinkPacket(Long r2, UMGWEventType r3, UMGWEventData r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public UMGWUplinkPacket(Long r2, UMGWEventType r3, UMGWEventData r4, ByteString r5) {
        super(ADAPTER, r5);
        this.unique_id = r2;
        this.event_type = r3;
        this.event_data = r4;
    }
}
