package com.ss.ugc.live.sdk.message.wrsc.data;

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
public final class WebcastRoomDataSyncKeyValue extends AndroidMessage<WebcastRoomDataSyncKeyValue, Builder> {
    public static final ProtoAdapter<WebcastRoomDataSyncKeyValue> ADAPTER = null;
    public static final Parcelable.Creator<WebcastRoomDataSyncKeyValue> CREATOR = null;
    public static final String DEFAULT_BIZLOGID = "";
    public static final Long DEFAULT_MSGID = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String bizLogID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long msgID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 2)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long version;

    public static final class Builder extends Message.Builder<WebcastRoomDataSyncKeyValue, Builder> {
        public String bizLogID;
        public Long msgID;
        public ByteString payload;
        public Long version;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public WebcastRoomDataSyncKeyValue m1667build() {
            return new WebcastRoomDataSyncKeyValue(this.version, this.payload, this.msgID, this.bizLogID, super.buildUnknownFields());
        }

        public Builder() {
            this.version = 0L;
            this.payload = ByteString.EMPTY;
            this.msgID = 0L;
            this.bizLogID = "";
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1667build();
        }

        public Builder bizLogID(String r1) {
            this.bizLogID = r1;
            return this;
        }

        public Builder msgID(Long r1) {
            this.msgID = r1;
            return this;
        }

        public Builder payload(ByteString r1) {
            this.payload = r1;
            return this;
        }

        public Builder version(Long r1) {
            this.version = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_WebcastRoomDataSyncKeyValue extends ProtoAdapter<WebcastRoomDataSyncKeyValue> {
        public ProtoAdapter_WebcastRoomDataSyncKeyValue() {
            super(FieldEncoding.LENGTH_DELIMITED, WebcastRoomDataSyncKeyValue.class);
        }

        public WebcastRoomDataSyncKeyValue decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.version((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.payload((ByteString) ProtoAdapter.BYTES.decode(r7));
            goto L3
        L10:
            if (r3 != 3) goto L12;
            r0.msgID((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L12:
            if (r3 != 4) goto L13;
            r0.bizLogID((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L18:
            r7.endMessage(r1);
            return r0.m1667build();
        }

        public int encodedSize(WebcastRoomDataSyncKeyValue r6) {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            return (((r0.encodedSizeWithTag(1, r6.version) + ProtoAdapter.BYTES.encodedSizeWithTag(2, r6.payload)) + r0.encodedSizeWithTag(3, r6.msgID)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r6.bizLogID)) + r6.unknownFields().size();
        }

        public WebcastRoomDataSyncKeyValue redact(WebcastRoomDataSyncKeyValue r1) {
            Builder r2 = r1.m1666newBuilder();
            r2.clearUnknownFields();
            return r2.m1667build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1668decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((WebcastRoomDataSyncKeyValue) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((WebcastRoomDataSyncKeyValue) r1);
        }

        public void encode(ProtoWriter r5, WebcastRoomDataSyncKeyValue r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r5, 1, r6.version);
            ProtoAdapter.BYTES.encodeWithTag(r5, 2, r6.payload);
            r0.encodeWithTag(r5, 3, r6.msgID);
            ProtoAdapter.STRING.encodeWithTag(r5, 4, r6.bizLogID);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (WebcastRoomDataSyncKeyValue) r2);
        }
    }

    static {
        ProtoAdapter_WebcastRoomDataSyncKeyValue r0 = new ProtoAdapter_WebcastRoomDataSyncKeyValue();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_VERSION = 0L;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_MSGID = 0L;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.version;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        ByteString r6 = this.payload;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Long r9 = this.msgID;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.bizLogID;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = r11 + r3;
        ((Message) this).hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1666newBuilder() {
        Builder r0 = new Builder();
        r0.version = this.version;
        r0.payload = this.payload;
        r0.msgID = this.msgID;
        r0.bizLogID = this.bizLogID;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.version == null) goto L6;
        r0.append(", version=");
        r0.append(this.version);
    L6:
        if (this.msgID == null) goto L9;
        r0.append(", msgID=");
        r0.append(this.msgID);
    L9:
        if (this.bizLogID == null) goto L11;
        r0.append(", bizLogID=");
        r0.append(this.bizLogID);
    L11:
        StringBuilder r1 = r0.replace(0, 2, "WebcastRoomDataSyncKeyValue{");
        r1.append('}');
        return r1.toString();
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1666newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof WebcastRoomDataSyncKeyValue) == true) goto L8;
        return false;
    L8:
        WebcastRoomDataSyncKeyValue r6 = (WebcastRoomDataSyncKeyValue) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L19:
        return false;
    L11:
        if (Internal.equals(this.version, r6.version) == false) goto L19;
        if (Internal.equals(this.payload, r6.payload) == false) goto L19;
        if (Internal.equals(this.msgID, r6.msgID) == false) goto L19;
        if (Internal.equals(this.bizLogID, r6.bizLogID) == false) goto L19;
        return true;
    }

    public WebcastRoomDataSyncKeyValue(Long r7, ByteString r8, Long r9, String r10) {
        this(r7, r8, r9, r10, ByteString.EMPTY);
    }

    public WebcastRoomDataSyncKeyValue(Long r2, ByteString r3, Long r4, String r5, ByteString r6) {
        super(ADAPTER, r6);
        this.version = r2;
        this.payload = r3;
        this.msgID = r4;
        this.bizLogID = r5;
    }
}
