package com.ss.ugc.live.sdk.msg.data;

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
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class SdkUplinkPacket extends AndroidMessage<SdkUplinkPacket, Builder> {
    public static final ProtoAdapter<SdkUplinkPacket> ADAPTER = null;
    public static final Parcelable.Creator<SdkUplinkPacket> CREATOR = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final Long DEFAULT_SERVICEID = null;
    public static final Integer DEFAULT_STATUSCODE = null;
    public static final String DEFAULT_STATUSMESSAGE = "";
    public static final Long DEFAULT_UNIQUEID = null;
    public static final Integer DEFAULT_UPLINKSTRATEGY = null;
    public static final String DEFAULT_URI = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, String> headers;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 6)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, String> queryParams;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long serviceID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer statusCode;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String statusMessage;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long uniqueID;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    public final Integer uplinkStrategy;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String uri;

    public static final class Builder extends Message.Builder<SdkUplinkPacket, Builder> {
        public Map<String, String> headers;
        public ByteString payload;
        public Map<String, String> queryParams;
        public Long serviceID;
        public Integer statusCode;
        public String statusMessage;
        public Long uniqueID;
        public Integer uplinkStrategy;
        public String uri;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SdkUplinkPacket m1685build() {
            return new SdkUplinkPacket(this.uniqueID, this.serviceID, this.queryParams, this.headers, this.uri, this.payload, this.statusCode, this.statusMessage, this.uplinkStrategy, super.buildUnknownFields());
        }

        public Builder() {
            this.uniqueID = 0L;
            this.serviceID = 0L;
            this.uri = "";
            this.payload = ByteString.EMPTY;
            this.statusCode = 0;
            this.statusMessage = "";
            this.uplinkStrategy = 0;
            this.queryParams = Internal.newMutableMap();
            this.headers = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1685build();
        }

        public Builder headers(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.headers = r1;
            return this;
        }

        public Builder payload(ByteString r1) {
            this.payload = r1;
            return this;
        }

        public Builder queryParams(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.queryParams = r1;
            return this;
        }

        public Builder serviceID(Long r1) {
            this.serviceID = r1;
            return this;
        }

        public Builder statusCode(Integer r1) {
            this.statusCode = r1;
            return this;
        }

        public Builder statusMessage(String r1) {
            this.statusMessage = r1;
            return this;
        }

        public Builder uniqueID(Long r1) {
            this.uniqueID = r1;
            return this;
        }

        public Builder uplinkStrategy(Integer r1) {
            this.uplinkStrategy = r1;
            return this;
        }

        public Builder uri(String r1) {
            this.uri = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SdkUplinkPacket extends ProtoAdapter<SdkUplinkPacket> {
        private final ProtoAdapter<Map<String, String>> headers;
        private final ProtoAdapter<Map<String, String>> queryParams;

        public ProtoAdapter_SdkUplinkPacket() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkUplinkPacket.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.queryParams = ProtoAdapter.newMapAdapter(r0, r0);
            this.headers = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public SdkUplinkPacket decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                default: goto L6;
            };
        L7:
            r0.uplinkStrategy((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            r0.statusMessage((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            r0.statusCode((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L10:
            r0.payload((ByteString) ProtoAdapter.BYTES.decode(r7));
            goto L3
        L11:
            r0.uri((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            r0.headers.putAll((Map) this.headers.decode(r7));
            goto L3
        L13:
            r0.queryParams.putAll((Map) this.queryParams.decode(r7));
            goto L3
        L14:
            r0.serviceID((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L15:
            r0.uniqueID((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L16:
            r7.endMessage(r1);
            return r0.m1685build();
        }

        public int encodedSize(SdkUplinkPacket r6) {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            int r1 = ((r0.encodedSizeWithTag(1, r6.uniqueID) + r0.encodedSizeWithTag(2, r6.serviceID)) + this.queryParams.encodedSizeWithTag(3, r6.queryParams)) + this.headers.encodedSizeWithTag(4, r6.headers);
            ProtoAdapter r2 = ProtoAdapter.STRING;
            int r3 = (r1 + r2.encodedSizeWithTag(5, r6.uri)) + ProtoAdapter.BYTES.encodedSizeWithTag(6, r6.payload);
            ProtoAdapter r4 = ProtoAdapter.INT32;
            return (((r3 + r4.encodedSizeWithTag(7, r6.statusCode)) + r2.encodedSizeWithTag(8, r6.statusMessage)) + r4.encodedSizeWithTag(9, r6.uplinkStrategy)) + r6.unknownFields().size();
        }

        public SdkUplinkPacket redact(SdkUplinkPacket r1) {
            Builder r2 = r1.m1684newBuilder();
            r2.clearUnknownFields();
            return r2.m1685build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1686decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SdkUplinkPacket) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SdkUplinkPacket) r1);
        }

        public void encode(ProtoWriter r5, SdkUplinkPacket r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT64;
            r0.encodeWithTag(r5, 1, r6.uniqueID);
            r0.encodeWithTag(r5, 2, r6.serviceID);
            this.queryParams.encodeWithTag(r5, 3, r6.queryParams);
            this.headers.encodeWithTag(r5, 4, r6.headers);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            r1.encodeWithTag(r5, 5, r6.uri);
            ProtoAdapter.BYTES.encodeWithTag(r5, 6, r6.payload);
            ProtoAdapter r2 = ProtoAdapter.INT32;
            r2.encodeWithTag(r5, 7, r6.statusCode);
            r1.encodeWithTag(r5, 8, r6.statusMessage);
            r2.encodeWithTag(r5, 9, r6.uplinkStrategy);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SdkUplinkPacket) r2);
        }
    }

    static {
        ProtoAdapter_SdkUplinkPacket r0 = new ProtoAdapter_SdkUplinkPacket();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_UNIQUEID = 0L;
        DEFAULT_SERVICEID = 0L;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_STATUSCODE = 0;
        DEFAULT_UPLINKSTRATEGY = 0;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L33;
        int r1 = unknownFields().hashCode() * 37;
        Long r2 = this.uniqueID;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.serviceID;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (((((r5 + r7) * 37) + this.queryParams.hashCode()) * 37) + this.headers.hashCode()) * 37;
        String r9 = this.uri;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        ByteString r12 = this.payload;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Integer r15 = this.statusCode;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.statusMessage;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        Integer r21 = this.uplinkStrategy;
        if (r21 == null) goto L31;
        r3 = r21.hashCode();
    L31:
        int r22 = r20 + r3;
        ((Message) this).hashCode = r22;
        return r22;
    L27:
        r19 = 0;
        goto L28
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
    L33:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1684newBuilder() {
        Builder r0 = new Builder();
        r0.uniqueID = this.uniqueID;
        r0.serviceID = this.serviceID;
        r0.queryParams = Internal.copyOf("queryParams", this.queryParams);
        r0.headers = Internal.copyOf("headers", this.headers);
        r0.uri = this.uri;
        r0.payload = this.payload;
        r0.statusCode = this.statusCode;
        r0.statusMessage = this.statusMessage;
        r0.uplinkStrategy = this.uplinkStrategy;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.uniqueID == null) goto L6;
        r0.append(", uniqueID=");
        r0.append(this.uniqueID);
    L6:
        if (this.serviceID == null) goto L8;
        r0.append(", serviceID=");
        r0.append(this.serviceID);
    L8:
        Map<String, String> r1 = this.queryParams;
        if (r1 != null) goto L11;
    L13:
        Map<String, String> r2 = this.headers;
        if (r2 == null) goto L19;
        if (r2.isEmpty() == true) goto L19;
        r0.append(", headers=");
        r0.append(this.headers);
    L19:
        if (this.uri == null) goto L22;
        r0.append(", uri=");
        r0.append(this.uri);
    L22:
        if (this.statusCode == null) goto L25;
        r0.append(", statusCode=");
        r0.append(this.statusCode);
    L25:
        if (this.statusMessage == null) goto L28;
        r0.append(", statusMessage=");
        r0.append(this.statusMessage);
    L28:
        if (this.uplinkStrategy == null) goto L30;
        r0.append(", uplinkStrategy=");
        r0.append(this.uplinkStrategy);
    L30:
        StringBuilder r3 = r0.replace(0, 2, "SdkUplinkPacket{");
        r3.append('}');
        return r3.toString();
    L11:
        if (r1.isEmpty() == true) goto L13;
        r0.append(", queryParams=");
        r0.append(this.queryParams);
        goto L13
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1684newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkUplinkPacket) == true) goto L8;
        return false;
    L8:
        SdkUplinkPacket r6 = (SdkUplinkPacket) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L29:
        return false;
    L11:
        if (Internal.equals(this.uniqueID, r6.uniqueID) == false) goto L29;
        if (Internal.equals(this.serviceID, r6.serviceID) == false) goto L29;
        if (this.queryParams.equals(r6.queryParams) == false) goto L29;
        if (this.headers.equals(r6.headers) == false) goto L29;
        if (Internal.equals(this.uri, r6.uri) == false) goto L29;
        if (Internal.equals(this.payload, r6.payload) == false) goto L29;
        if (Internal.equals(this.statusCode, r6.statusCode) == false) goto L29;
        if (Internal.equals(this.statusMessage, r6.statusMessage) == false) goto L29;
        if (Internal.equals(this.uplinkStrategy, r6.uplinkStrategy) == false) goto L29;
        return true;
    }

    public SdkUplinkPacket(Long r12, Long r13, Map<String, String> r14, Map<String, String> r15, String r16, ByteString r17, Integer r18, String r19, Integer r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public SdkUplinkPacket(Long r2, Long r3, Map<String, String> r4, Map<String, String> r5, String r6, ByteString r7, Integer r8, String r9, Integer r10, ByteString r11) {
        super(ADAPTER, r11);
        this.uniqueID = r2;
        this.serviceID = r3;
        this.queryParams = Internal.immutableCopyOf("queryParams", r4);
        this.headers = Internal.immutableCopyOf("headers", r5);
        this.uri = r6;
        this.payload = r7;
        this.statusCode = r8;
        this.statusMessage = r9;
        this.uplinkStrategy = r10;
    }
}
