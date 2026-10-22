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
public final class WebcastRoomDataSyncMessage extends AndroidMessage<WebcastRoomDataSyncMessage, Builder> {
    public static final ProtoAdapter<WebcastRoomDataSyncMessage> ADAPTER = null;
    public static final Parcelable.Creator<WebcastRoomDataSyncMessage> CREATOR = null;
    public static final String DEFAULT_BIZLOGID = "";
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final Long DEFAULT_ROOMID = null;
    public static final String DEFAULT_SYNCKEY = "";
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String bizLogID;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.Common#ADAPTER", tag = 1)
    public final Common common;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 5)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long roomID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String syncKey;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long version;

    public static final class Builder extends Message.Builder<WebcastRoomDataSyncMessage, Builder> {
        public String bizLogID;
        public Common common;
        public ByteString payload;
        public Long roomID;
        public String syncKey;
        public Long version;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public WebcastRoomDataSyncMessage m1670build() {
            return new WebcastRoomDataSyncMessage(this.common, this.roomID, this.syncKey, this.version, this.payload, this.bizLogID, super.buildUnknownFields());
        }

        public Builder() {
            this.roomID = 0L;
            this.syncKey = "";
            this.version = 0L;
            this.payload = ByteString.EMPTY;
            this.bizLogID = "";
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1670build();
        }

        public Builder bizLogID(String r1) {
            this.bizLogID = r1;
            return this;
        }

        public Builder common(Common r1) {
            this.common = r1;
            return this;
        }

        public Builder payload(ByteString r1) {
            this.payload = r1;
            return this;
        }

        public Builder roomID(Long r1) {
            this.roomID = r1;
            return this;
        }

        public Builder syncKey(String r1) {
            this.syncKey = r1;
            return this;
        }

        public Builder version(Long r1) {
            this.version = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_WebcastRoomDataSyncMessage extends ProtoAdapter<WebcastRoomDataSyncMessage> {
        public ProtoAdapter_WebcastRoomDataSyncMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, WebcastRoomDataSyncMessage.class);
        }

        public WebcastRoomDataSyncMessage decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.bizLogID((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            r0.payload((ByteString) ProtoAdapter.BYTES.decode(r7));
            goto L3
        L9:
            r0.version((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L10:
            r0.syncKey((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L11:
            r0.roomID((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L12:
            r0.common((Common) Common.ADAPTER.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.m1670build();
        }

        public int encodedSize(WebcastRoomDataSyncMessage r6) {
            int r0 = Common.ADAPTER.encodedSizeWithTag(1, r6.common);
            ProtoAdapter r1 = ProtoAdapter.INT64;
            int r2 = r0 + r1.encodedSizeWithTag(2, r6.roomID);
            ProtoAdapter r3 = ProtoAdapter.STRING;
            return ((((r2 + r3.encodedSizeWithTag(3, r6.syncKey)) + r1.encodedSizeWithTag(4, r6.version)) + ProtoAdapter.BYTES.encodedSizeWithTag(5, r6.payload)) + r3.encodedSizeWithTag(6, r6.bizLogID)) + r6.unknownFields().size();
        }

        public WebcastRoomDataSyncMessage redact(WebcastRoomDataSyncMessage r3) {
            Builder r4 = r3.m1669newBuilder();
            Common r0 = r4.common;
            if (r0 == null) goto L5;
            r4.common = (Common) Common.ADAPTER.redact(r0);
        L5:
            r4.clearUnknownFields();
            return r4.m1670build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1671decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((WebcastRoomDataSyncMessage) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((WebcastRoomDataSyncMessage) r1);
        }

        public void encode(ProtoWriter r5, WebcastRoomDataSyncMessage r6) throws IOException {
            Common.ADAPTER.encodeWithTag(r5, 1, r6.common);
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r5, 2, r6.roomID);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            r1.encodeWithTag(r5, 3, r6.syncKey);
            r0.encodeWithTag(r5, 4, r6.version);
            ProtoAdapter.BYTES.encodeWithTag(r5, 5, r6.payload);
            r1.encodeWithTag(r5, 6, r6.bizLogID);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (WebcastRoomDataSyncMessage) r2);
        }
    }

    static {
        ProtoAdapter_WebcastRoomDataSyncMessage r0 = new ProtoAdapter_WebcastRoomDataSyncMessage();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_ROOMID = 0L;
        DEFAULT_VERSION = 0L;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L29;
        int r1 = unknownFields().hashCode() * 37;
        Common r2 = this.common;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.roomID;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.syncKey;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Long r12 = this.version;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        ByteString r15 = this.payload;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.bizLogID;
        if (r18 == null) goto L27;
        r3 = r18.hashCode();
    L27:
        int r19 = r17 + r3;
        ((Message) this).hashCode = r19;
        return r19;
    L23:
        r16 = 0;
        goto L24
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
    L29:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1669newBuilder() {
        Builder r0 = new Builder();
        r0.common = this.common;
        r0.roomID = this.roomID;
        r0.syncKey = this.syncKey;
        r0.version = this.version;
        r0.payload = this.payload;
        r0.bizLogID = this.bizLogID;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.common == null) goto L6;
        r0.append(", common=");
        r0.append(this.common);
    L6:
        if (this.roomID == null) goto L9;
        r0.append(", roomID=");
        r0.append(this.roomID);
    L9:
        if (this.syncKey == null) goto L12;
        r0.append(", syncKey=");
        r0.append(this.syncKey);
    L12:
        if (this.version == null) goto L15;
        r0.append(", version=");
        r0.append(this.version);
    L15:
        if (this.bizLogID == null) goto L17;
        r0.append(", bizLogID=");
        r0.append(this.bizLogID);
    L17:
        StringBuilder r1 = r0.replace(0, 2, "WebcastRoomDataSyncMessage{");
        r1.append('}');
        return r1.toString();
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1669newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof WebcastRoomDataSyncMessage) == true) goto L8;
        return false;
    L8:
        WebcastRoomDataSyncMessage r6 = (WebcastRoomDataSyncMessage) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L23:
        return false;
    L11:
        if (Internal.equals(this.common, r6.common) == false) goto L23;
        if (Internal.equals(this.roomID, r6.roomID) == false) goto L23;
        if (Internal.equals(this.syncKey, r6.syncKey) == false) goto L23;
        if (Internal.equals(this.version, r6.version) == false) goto L23;
        if (Internal.equals(this.payload, r6.payload) == false) goto L23;
        if (Internal.equals(this.bizLogID, r6.bizLogID) == false) goto L23;
        return true;
    }

    public WebcastRoomDataSyncMessage(Common r9, Long r10, String r11, Long r12, ByteString r13, String r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public WebcastRoomDataSyncMessage(Common r2, Long r3, String r4, Long r5, ByteString r6, String r7, ByteString r8) {
        super(ADAPTER, r8);
        this.common = r2;
        this.roomID = r3;
        this.syncKey = r4;
        this.version = r5;
        this.payload = r6;
        this.bizLogID = r7;
    }
}
