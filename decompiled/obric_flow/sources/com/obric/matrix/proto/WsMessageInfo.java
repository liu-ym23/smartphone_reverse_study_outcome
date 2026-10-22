package com.obric.matrix.proto;

import androidx.core.app.NotificationCompat;
import androidx.room.jarjarred.org.antlr.runtime.a;
import com.google.gson.annotations.SerializedName;
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

/* JADX INFO: loaded from: classes3.dex */
public final class WsMessageInfo extends Message<WsMessageInfo, Builder> {
    public static final ProtoAdapter<WsMessageInfo> ADAPTER = null;
    public static final Integer DEFAULT_CHANNELID = null;
    public static final Integer DEFAULT_CMD = null;
    public static final Long DEFAULT_LOGID = null;
    public static final Integer DEFAULT_METHOD = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_PAYLOADENCODING = "";
    public static final String DEFAULT_PAYLOADTYPE = "";
    public static final Long DEFAULT_SEQID = null;
    public static final Integer DEFAULT_SERVICE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("channelId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 10)
    public final Integer channelId;

    @SerializedName("cmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 9)
    public final Integer cmd;

    @SerializedName("headers")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final Map<String, String> headers;

    @SerializedName("logId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long logId;

    @SerializedName("method")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer method;

    @SerializedName("payload")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 8)
    public final ByteString payload;

    @SerializedName("payloadEncoding")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String payloadEncoding;

    @SerializedName("payloadType")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String payloadType;

    @SerializedName("seqId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long seqId;

    @SerializedName(NotificationCompat.CATEGORY_SERVICE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer service;

    public static final class Builder extends Message.Builder<WsMessageInfo, Builder> {
        public Integer channelId;
        public Integer cmd;
        public Map<String, String> headers;
        public Long logId;
        public Integer method;
        public ByteString payload;
        public String payloadEncoding;
        public String payloadType;
        public Long seqId;
        public Integer service;

        public Builder() {
            this.seqId = 0L;
            this.logId = 0L;
            this.service = 0;
            this.method = 0;
            this.payloadType = "";
            this.payloadEncoding = "";
            this.payload = ByteString.EMPTY;
            this.cmd = 0;
            this.channelId = 0;
            this.headers = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channelId(Integer r5) {
            this.channelId = r5;
            return this;
        }

        public Builder cmd(Integer r5) {
            this.cmd = r5;
            return this;
        }

        public Builder headers(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.headers = r5;
            return this;
        }

        public Builder logId(Long r5) {
            this.logId = r5;
            return this;
        }

        public Builder method(Integer r5) {
            this.method = r5;
            return this;
        }

        public Builder payload(ByteString r5) {
            this.payload = r5;
            return this;
        }

        public Builder payloadEncoding(String r5) {
            this.payloadEncoding = r5;
            return this;
        }

        public Builder payloadType(String r5) {
            this.payloadType = r5;
            return this;
        }

        public Builder seqId(Long r5) {
            this.seqId = r5;
            return this;
        }

        public Builder service(Integer r5) {
            this.service = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public WsMessageInfo build() {
            return new WsMessageInfo(this.seqId, this.logId, this.service, this.method, this.payloadType, this.payloadEncoding, this.payload, this.cmd, this.channelId, this.headers, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_WsMessageInfo extends ProtoAdapter<WsMessageInfo> {
        private final ProtoAdapter<Map<String, String>> headers;

        public ProtoAdapter_WsMessageInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, WsMessageInfo.class);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            this.headers = ProtoAdapter.newMapAdapter(r5, r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WsMessageInfo decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, WsMessageInfo r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WsMessageInfo r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WsMessageInfo redact(WsMessageInfo r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WsMessageInfo decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L17;
            switch(r12) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L6;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r5.headers.putAll(this.headers.decode(r10));
            goto L3
        L8:
            r5.channelId(ProtoAdapter.INT32.decode(r10));
            goto L3
        L9:
            r5.cmd(ProtoAdapter.INT32.decode(r10));
            goto L3
        L10:
            r5.payload(ProtoAdapter.BYTES.decode(r10));
            goto L3
        L11:
            r5.payloadEncoding(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            r5.payloadType(ProtoAdapter.STRING.decode(r10));
            goto L3
        L13:
            r5.method(ProtoAdapter.INT32.decode(r10));
            goto L3
        L14:
            r5.service(ProtoAdapter.INT32.decode(r10));
            goto L3
        L15:
            r5.logId(ProtoAdapter.INT64.decode(r10));
            goto L3
        L16:
            r5.seqId(ProtoAdapter.INT64.decode(r10));
            goto L3
        L6:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L17:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, WsMessageInfo r10) throws IOException {
            ProtoAdapter<Long> r11 = ProtoAdapter.INT64;
            r11.encodeWithTag(r5, 1, r10.seqId);
            r11.encodeWithTag(r5, 2, r10.logId);
            ProtoAdapter<Integer> r12 = ProtoAdapter.INT32;
            r12.encodeWithTag(r5, 3, r10.service);
            r12.encodeWithTag(r5, 4, r10.method);
            ProtoAdapter<String> r13 = ProtoAdapter.STRING;
            r13.encodeWithTag(r5, 6, r10.payloadType);
            r13.encodeWithTag(r5, 7, r10.payloadEncoding);
            ProtoAdapter.BYTES.encodeWithTag(r5, 8, r10.payload);
            r12.encodeWithTag(r5, 9, r10.cmd);
            r12.encodeWithTag(r5, 10, r10.channelId);
            this.headers.encodeWithTag(r5, 11, r10.headers);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(WsMessageInfo r10) {
            ProtoAdapter<Long> r5 = ProtoAdapter.INT64;
            int r11 = r5.encodedSizeWithTag(1, r10.seqId);
            int r12 = r5.encodedSizeWithTag(2, r10.logId) + r11;
            ProtoAdapter<Integer> r13 = ProtoAdapter.INT32;
            int r14 = r13.encodedSizeWithTag(3, r10.service) + r12;
            int r15 = r13.encodedSizeWithTag(4, r10.method) + r14;
            ProtoAdapter<String> r16 = ProtoAdapter.STRING;
            int r17 = r16.encodedSizeWithTag(6, r10.payloadType) + r15;
            int r18 = r16.encodedSizeWithTag(7, r10.payloadEncoding) + r17;
            int r19 = ProtoAdapter.BYTES.encodedSizeWithTag(8, r10.payload) + r18;
            int r20 = r13.encodedSizeWithTag(9, r10.cmd) + r19;
            int r21 = r13.encodedSizeWithTag(10, r10.channelId) + r20;
            int r22 = this.headers.encodedSizeWithTag(11, r10.headers) + r21;
            return r10.unknownFields().size() + r22;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public WsMessageInfo redact2(WsMessageInfo r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WsMessageInfo();
        DEFAULT_SEQID = 0L;
        DEFAULT_LOGID = 0L;
        DEFAULT_SERVICE = 0;
        DEFAULT_METHOD = 0;
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_CMD = 0;
        DEFAULT_CHANNELID = 0;
    }

    public WsMessageInfo(Long r13, Long r14, Integer r15, Integer r16, String r17, String r18, ByteString r19, Integer r20, Integer r21, Map<String, String> r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof WsMessageInfo) == true) goto L8;
        return false;
    L8:
        WsMessageInfo r10 = (WsMessageInfo) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L32;
        if (Internal.equals(this.seqId, r10.seqId) == false) goto L32;
        if (Internal.equals(this.logId, r10.logId) == false) goto L32;
        if (Internal.equals(this.service, r10.service) == false) goto L32;
        if (Internal.equals(this.method, r10.method) == false) goto L32;
        if (Internal.equals(this.payloadType, r10.payloadType) == false) goto L32;
        if (Internal.equals(this.payloadEncoding, r10.payloadEncoding) == false) goto L32;
        if (Internal.equals(this.payload, r10.payload) == false) goto L32;
        if (Internal.equals(this.cmd, r10.cmd) == false) goto L32;
        if (Internal.equals(this.channelId, r10.channelId) == false) goto L32;
        if (this.headers.equals(r10.headers) == false) goto L32;
        return true;
    L32:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L41;
        int r10 = unknownFields().hashCode() * 37;
        Long r11 = this.seqId;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Long r15 = this.logId;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        Integer r18 = this.service;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        Integer r21 = this.method;
        if (r21 == null) goto L19;
        int r22 = r21.hashCode();
    L20:
        int r23 = (r20 + r22) * 37;
        String r24 = this.payloadType;
        if (r24 == null) goto L23;
        int r25 = r24.hashCode();
    L24:
        int r26 = (r23 + r25) * 37;
        String r27 = this.payloadEncoding;
        if (r27 == null) goto L27;
        int r28 = r27.hashCode();
    L28:
        int r29 = (r26 + r28) * 37;
        ByteString r30 = this.payload;
        if (r30 == null) goto L31;
        int r31 = r30.hashCode();
    L32:
        int r32 = (r29 + r31) * 37;
        Integer r33 = this.cmd;
        if (r33 == null) goto L35;
        int r34 = r33.hashCode();
    L36:
        int r35 = (r32 + r34) * 37;
        Integer r36 = this.channelId;
        if (r36 == null) goto L39;
        r12 = r36.hashCode();
    L39:
        int r37 = ((r35 + r12) * 37) + this.headers.hashCode();
        this.hashCode = r37;
        return r37;
    L35:
        r34 = 0;
        goto L36
    L31:
        r31 = 0;
        goto L32
    L27:
        r28 = 0;
        goto L28
    L23:
        r25 = 0;
        goto L24
    L19:
        r22 = 0;
        goto L20
    L15:
        r19 = 0;
        goto L16
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L41:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.seqId == null) goto L6;
        r5.append(", seqId=");
        r5.append(this.seqId);
    L6:
        if (this.logId == null) goto L9;
        r5.append(", logId=");
        r5.append(this.logId);
    L9:
        if (this.service == null) goto L12;
        r5.append(", service=");
        r5.append(this.service);
    L12:
        if (this.method == null) goto L15;
        r5.append(", method=");
        r5.append(this.method);
    L15:
        if (this.payloadType == null) goto L18;
        r5.append(", payloadType=");
        r5.append(this.payloadType);
    L18:
        if (this.payloadEncoding == null) goto L21;
        r5.append(", payloadEncoding=");
        r5.append(this.payloadEncoding);
    L21:
        if (this.payload == null) goto L24;
        r5.append(", payload=");
        r5.append(this.payload);
    L24:
        if (this.cmd == null) goto L27;
        r5.append(", cmd=");
        r5.append(this.cmd);
    L27:
        if (this.channelId == null) goto L29;
        r5.append(", channelId=");
        r5.append(this.channelId);
    L29:
        Map<String, String> r10 = this.headers;
        if (r10 == null) goto L35;
        if (r10.isEmpty() == true) goto L35;
        r5.append(", headers=");
        r5.append(this.headers);
    L35:
        return a.s(r5, 0, 2, "WsMessageInfo{", '}');
    }

    public WsMessageInfo(Long r5, Long r10, Integer r11, Integer r12, String r13, String r14, ByteString r15, Integer r16, Integer r17, Map<String, String> r18, ByteString r19) {
        super(ADAPTER, r19);
        this.seqId = r5;
        this.logId = r10;
        this.service = r11;
        this.method = r12;
        this.payloadType = r13;
        this.payloadEncoding = r14;
        this.payload = r15;
        this.cmd = r16;
        this.channelId = r17;
        this.headers = Internal.immutableCopyOf("headers", r18);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.seqId = this.seqId;
        r5.logId = this.logId;
        r5.service = this.service;
        r5.method = this.method;
        r5.payloadType = this.payloadType;
        r5.payloadEncoding = this.payloadEncoding;
        r5.payload = this.payload;
        r5.cmd = this.cmd;
        r5.channelId = this.channelId;
        r5.headers = Internal.copyOf("headers", this.headers);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
