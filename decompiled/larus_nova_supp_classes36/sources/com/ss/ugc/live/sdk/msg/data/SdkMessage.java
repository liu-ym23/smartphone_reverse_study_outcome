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
public final class SdkMessage extends AndroidMessage<SdkMessage, Builder> {
    public static final ProtoAdapter<SdkMessage> ADAPTER = null;
    public static final Parcelable.Creator<SdkMessage> CREATOR = null;
    public static final String DEFAULT_METHOD = "";
    public static final Long DEFAULT_MSG_ID = null;
    public static final Integer DEFAULT_MSG_TYPE = null;
    public static final Boolean DEFAULT_NEED_WRDS_STORE = null;
    public static final Long DEFAULT_OFFSET = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final String DEFAULT_TENANT_ID = "";
    public static final String DEFAULT_WRDS_SUB_KEY = "";
    public static final Long DEFAULT_WRDS_VERSION = null;
    private static final long serialVersionUID = 0;
    public transient boolean fromHttp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final Map<String, String> message_extra;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String method;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long msg_id;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer msg_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean need_wrds_store;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long offset;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", tag = 2)
    public final ByteString payload;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String tenant_id;
    public transient long timestamp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String wrds_sub_key;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 7)
    public final Long wrds_version;

    public static final class Builder extends Message.Builder<SdkMessage, Builder> {
        public Map<String, String> message_extra;
        public String method;
        public Long msg_id;
        public Integer msg_type;
        public Boolean need_wrds_store;
        public Long offset;
        public ByteString payload;
        public String tenant_id;
        public String wrds_sub_key;
        public Long wrds_version;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SdkMessage m1679build() {
            return new SdkMessage(this.method, this.payload, this.msg_id, this.msg_type, this.offset, this.need_wrds_store, this.wrds_version, this.wrds_sub_key, this.message_extra, this.tenant_id, super.buildUnknownFields());
        }

        public Builder() {
            this.method = "";
            this.payload = ByteString.EMPTY;
            this.msg_id = 0L;
            this.msg_type = 0;
            this.offset = 0L;
            this.need_wrds_store = Boolean.FALSE;
            this.wrds_version = 0L;
            this.wrds_sub_key = "";
            this.tenant_id = "";
            this.message_extra = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1679build();
        }

        public Builder message_extra(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.message_extra = r1;
            return this;
        }

        public Builder method(String r1) {
            this.method = r1;
            return this;
        }

        public Builder msg_id(Long r1) {
            this.msg_id = r1;
            return this;
        }

        public Builder msg_type(Integer r1) {
            this.msg_type = r1;
            return this;
        }

        public Builder need_wrds_store(Boolean r1) {
            this.need_wrds_store = r1;
            return this;
        }

        public Builder offset(Long r1) {
            this.offset = r1;
            return this;
        }

        public Builder payload(ByteString r1) {
            this.payload = r1;
            return this;
        }

        public Builder tenant_id(String r1) {
            this.tenant_id = r1;
            return this;
        }

        public Builder wrds_sub_key(String r1) {
            this.wrds_sub_key = r1;
            return this;
        }

        public Builder wrds_version(Long r1) {
            this.wrds_version = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SdkMessage extends ProtoAdapter<SdkMessage> {
        private final ProtoAdapter<Map<String, String>> message_extra;

        public ProtoAdapter_SdkMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkMessage.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.message_extra = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public SdkMessage decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L17;
            switch(r3) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r0.tenant_id((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            r0.message_extra.putAll((Map) this.message_extra.decode(r7));
            goto L3
        L9:
            r0.wrds_sub_key((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L10:
            r0.wrds_version((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L11:
            r0.need_wrds_store((Boolean) ProtoAdapter.BOOL.decode(r7));
            goto L3
        L12:
            r0.offset((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L13:
            r0.msg_type((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L14:
            r0.msg_id((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L15:
            r0.payload((ByteString) ProtoAdapter.BYTES.decode(r7));
            goto L3
        L16:
            r0.method((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L17:
            r7.endMessage(r1);
            return r0.m1679build();
        }

        public int encodedSize(SdkMessage r7) {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            int r1 = r0.encodedSizeWithTag(1, r7.method) + ProtoAdapter.BYTES.encodedSizeWithTag(2, r7.payload);
            ProtoAdapter r2 = ProtoAdapter.INT64;
            return ((((((((r1 + r2.encodedSizeWithTag(3, r7.msg_id)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r7.msg_type)) + r2.encodedSizeWithTag(5, r7.offset)) + ProtoAdapter.BOOL.encodedSizeWithTag(6, r7.need_wrds_store)) + r2.encodedSizeWithTag(7, r7.wrds_version)) + r0.encodedSizeWithTag(8, r7.wrds_sub_key)) + this.message_extra.encodedSizeWithTag(9, r7.message_extra)) + r0.encodedSizeWithTag(10, r7.tenant_id)) + r7.unknownFields().size();
        }

        public SdkMessage redact(SdkMessage r1) {
            Builder r2 = r1.m1678newBuilder();
            r2.clearUnknownFields();
            return r2.m1679build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1680decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SdkMessage) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SdkMessage) r1);
        }

        public void encode(ProtoWriter r6, SdkMessage r7) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r6, 1, r7.method);
            ProtoAdapter.BYTES.encodeWithTag(r6, 2, r7.payload);
            ProtoAdapter r1 = ProtoAdapter.INT64;
            r1.encodeWithTag(r6, 3, r7.msg_id);
            ProtoAdapter.INT32.encodeWithTag(r6, 4, r7.msg_type);
            r1.encodeWithTag(r6, 5, r7.offset);
            ProtoAdapter.BOOL.encodeWithTag(r6, 6, r7.need_wrds_store);
            r1.encodeWithTag(r6, 7, r7.wrds_version);
            r0.encodeWithTag(r6, 8, r7.wrds_sub_key);
            this.message_extra.encodeWithTag(r6, 9, r7.message_extra);
            r0.encodeWithTag(r6, 10, r7.tenant_id);
            r6.writeBytes(r7.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SdkMessage) r2);
        }
    }

    static {
        ProtoAdapter_SdkMessage r0 = new ProtoAdapter_SdkMessage();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_MSG_ID = 0L;
        DEFAULT_MSG_TYPE = 0;
        DEFAULT_OFFSET = 0L;
        DEFAULT_NEED_WRDS_STORE = Boolean.FALSE;
        DEFAULT_WRDS_VERSION = 0L;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L41;
        int r1 = unknownFields().hashCode() * 37;
        String r2 = this.method;
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
        Long r9 = this.msg_id;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.msg_type;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Long r15 = this.offset;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        Boolean r18 = this.need_wrds_store;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        Long r21 = this.wrds_version;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        String r24 = this.wrds_sub_key;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (((r23 + r25) * 37) + this.message_extra.hashCode()) * 37;
        String r27 = this.tenant_id;
        if (r27 == null) goto L39;
        r3 = r27.hashCode();
    L39:
        int r28 = r26 + r3;
        ((Message) this).hashCode = r28;
        return r28;
    L35:
        r25 = 0;
        goto L36
    L31:
        r22 = 0;
        goto L32
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
    L41:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1678newBuilder() {
        Builder r0 = new Builder();
        r0.method = this.method;
        r0.payload = this.payload;
        r0.msg_id = this.msg_id;
        r0.msg_type = this.msg_type;
        r0.offset = this.offset;
        r0.need_wrds_store = this.need_wrds_store;
        r0.wrds_version = this.wrds_version;
        r0.wrds_sub_key = this.wrds_sub_key;
        r0.message_extra = Internal.copyOf("message_extra", this.message_extra);
        r0.tenant_id = this.tenant_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.method == null) goto L6;
        r0.append(", method=");
        r0.append(this.method);
    L6:
        if (this.msg_id == null) goto L9;
        r0.append(", msg_id=");
        r0.append(this.msg_id);
    L9:
        if (this.msg_type == null) goto L12;
        r0.append(", msg_type=");
        r0.append(this.msg_type);
    L12:
        if (this.offset == null) goto L15;
        r0.append(", offset=");
        r0.append(this.offset);
    L15:
        if (this.need_wrds_store == null) goto L18;
        r0.append(", need_wrds_store=");
        r0.append(this.need_wrds_store);
    L18:
        if (this.wrds_version == null) goto L21;
        r0.append(", wrds_version=");
        r0.append(this.wrds_version);
    L21:
        if (this.wrds_sub_key == null) goto L23;
        r0.append(", wrds_sub_key=");
        r0.append(this.wrds_sub_key);
    L23:
        Map<String, String> r1 = this.message_extra;
        if (r1 == null) goto L29;
        if (r1.isEmpty() == true) goto L29;
        r0.append(", message_extra=");
        r0.append(this.message_extra);
    L29:
        if (this.tenant_id == null) goto L31;
        r0.append(", tenant_id=");
        r0.append(this.tenant_id);
    L31:
        StringBuilder r2 = r0.replace(0, 2, "SdkMessage{");
        r2.append('}');
        return r2.toString();
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1678newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkMessage) == true) goto L8;
        return false;
    L8:
        SdkMessage r6 = (SdkMessage) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L31:
        return false;
    L11:
        if (Internal.equals(this.method, r6.method) == false) goto L31;
        if (Internal.equals(this.payload, r6.payload) == false) goto L31;
        if (Internal.equals(this.msg_id, r6.msg_id) == false) goto L31;
        if (Internal.equals(this.msg_type, r6.msg_type) == false) goto L31;
        if (Internal.equals(this.offset, r6.offset) == false) goto L31;
        if (Internal.equals(this.need_wrds_store, r6.need_wrds_store) == false) goto L31;
        if (Internal.equals(this.wrds_version, r6.wrds_version) == false) goto L31;
        if (Internal.equals(this.wrds_sub_key, r6.wrds_sub_key) == false) goto L31;
        if (this.message_extra.equals(r6.message_extra) == false) goto L31;
        if (Internal.equals(this.tenant_id, r6.tenant_id) == false) goto L31;
        return true;
    }

    public SdkMessage(String r13, ByteString r14, Long r15, Integer r16, Long r17, Boolean r18, Long r19, String r20, Map<String, String> r21, String r22) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, ByteString.EMPTY);
    }

    public SdkMessage(String r2, ByteString r3, Long r4, Integer r5, Long r6, Boolean r7, Long r8, String r9, Map<String, String> r10, String r11, ByteString r12) {
        super(ADAPTER, r12);
        this.method = r2;
        this.payload = r3;
        this.msg_id = r4;
        this.msg_type = r5;
        this.offset = r6;
        this.need_wrds_store = r7;
        this.wrds_version = r8;
        this.wrds_sub_key = r9;
        this.message_extra = Internal.immutableCopyOf("message_extra", r10);
        this.tenant_id = r11;
    }
}
