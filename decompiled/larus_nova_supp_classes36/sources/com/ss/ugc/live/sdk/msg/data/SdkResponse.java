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
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class SdkResponse extends AndroidMessage<SdkResponse, Builder> {
    public static final ProtoAdapter<SdkResponse> ADAPTER = null;
    public static final Parcelable.Creator<SdkResponse> CREATOR = null;
    public static final String DEFAULT_CURSOR = "";
    public static final Long DEFAULT_FETCH_INTERVAL = null;
    public static final Integer DEFAULT_FETCH_TYPE = null;
    public static final Long DEFAULT_HEARTBEAT_DURATION = null;
    public static final Boolean DEFAULT_HISTORY_NO_MORE = null;
    public static final String DEFAULT_INTERNAL_EXT = "";
    public static final String DEFAULT_LIVE_CURSOR = "";
    public static final Boolean DEFAULT_NEED_ACK = null;
    public static final Long DEFAULT_NOW = null;
    public static final String DEFAULT_PROXY_SERVER = "";
    public static final String DEFAULT_PUSH_SERVER = "";
    public static final String DEFAULT_PUSH_SERVER_V2 = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String cursor;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long fetch_interval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer fetch_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 8)
    public final Long heartbeat_duration;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 12)
    public final Boolean history_no_more;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String internal_ext;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String live_cursor;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.SdkMessage#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<SdkMessage> messages;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean need_ack;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long now;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String proxy_server;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String push_server;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final String push_server_v2;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final Map<String, String> route_params;

    public static final class Builder extends Message.Builder<SdkResponse, Builder> {
        public String cursor;
        public Long fetch_interval;
        public Integer fetch_type;
        public Long heartbeat_duration;
        public Boolean history_no_more;
        public String internal_ext;
        public String live_cursor;
        public List<SdkMessage> messages;
        public Boolean need_ack;
        public Long now;
        public String proxy_server;
        public String push_server;
        public String push_server_v2;
        public Map<String, String> route_params;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public SdkResponse m1682build() {
            return new SdkResponse(this.messages, this.cursor, this.fetch_interval, this.now, this.internal_ext, this.fetch_type, this.route_params, this.heartbeat_duration, this.need_ack, this.push_server, this.live_cursor, this.history_no_more, this.proxy_server, this.push_server_v2, super.buildUnknownFields());
        }

        public Builder() {
            this.cursor = "";
            this.fetch_interval = 0L;
            this.now = 0L;
            this.internal_ext = "";
            this.fetch_type = 0;
            this.heartbeat_duration = 0L;
            Boolean r1 = Boolean.FALSE;
            this.need_ack = r1;
            this.push_server = "";
            this.live_cursor = "";
            this.history_no_more = r1;
            this.proxy_server = "";
            this.push_server_v2 = "";
            this.messages = Internal.newMutableList();
            this.route_params = Internal.newMutableMap();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1682build();
        }

        public Builder cursor(String r1) {
            this.cursor = r1;
            return this;
        }

        public Builder fetch_interval(Long r1) {
            this.fetch_interval = r1;
            return this;
        }

        public Builder fetch_type(Integer r1) {
            this.fetch_type = r1;
            return this;
        }

        public Builder heartbeat_duration(Long r1) {
            this.heartbeat_duration = r1;
            return this;
        }

        public Builder history_no_more(Boolean r1) {
            this.history_no_more = r1;
            return this;
        }

        public Builder internal_ext(String r1) {
            this.internal_ext = r1;
            return this;
        }

        public Builder live_cursor(String r1) {
            this.live_cursor = r1;
            return this;
        }

        public Builder messages(List<SdkMessage> r1) {
            Internal.checkElementsNotNull(r1);
            this.messages = r1;
            return this;
        }

        public Builder need_ack(Boolean r1) {
            this.need_ack = r1;
            return this;
        }

        public Builder now(Long r1) {
            this.now = r1;
            return this;
        }

        public Builder proxy_server(String r1) {
            this.proxy_server = r1;
            return this;
        }

        public Builder push_server(String r1) {
            this.push_server = r1;
            return this;
        }

        public Builder push_server_v2(String r1) {
            this.push_server_v2 = r1;
            return this;
        }

        public Builder route_params(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.route_params = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SdkResponse extends ProtoAdapter<SdkResponse> {
        private final ProtoAdapter<Map<String, String>> route_params;

        public ProtoAdapter_SdkResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkResponse.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.route_params = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public SdkResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L21;
            switch(r3) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                case 11: goto L10;
                case 12: goto L9;
                case 13: goto L8;
                case 14: goto L7;
                default: goto L6;
            };
        L7:
            r0.push_server_v2((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L8:
            r0.proxy_server((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            r0.history_no_more((Boolean) ProtoAdapter.BOOL.decode(r7));
            goto L3
        L10:
            r0.live_cursor((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L11:
            r0.push_server((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            r0.need_ack((Boolean) ProtoAdapter.BOOL.decode(r7));
            goto L3
        L13:
            r0.heartbeat_duration((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L14:
            r0.route_params.putAll((Map) this.route_params.decode(r7));
            goto L3
        L15:
            r0.fetch_type((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L16:
            r0.internal_ext((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L17:
            r0.now((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L18:
            r0.fetch_interval((Long) ProtoAdapter.INT64.decode(r7));
            goto L3
        L19:
            r0.cursor((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L20:
            r0.messages.add((SdkMessage) SdkMessage.ADAPTER.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L21:
            r7.endMessage(r1);
            return r0.m1682build();
        }

        public int encodedSize(SdkResponse r7) {
            int r0 = SdkMessage.ADAPTER.asRepeated().encodedSizeWithTag(1, r7.messages);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            int r2 = r0 + r1.encodedSizeWithTag(2, r7.cursor);
            ProtoAdapter r3 = ProtoAdapter.INT64;
            int r4 = (((((r2 + r3.encodedSizeWithTag(3, r7.fetch_interval)) + r3.encodedSizeWithTag(4, r7.now)) + r1.encodedSizeWithTag(5, r7.internal_ext)) + ProtoAdapter.INT32.encodedSizeWithTag(6, r7.fetch_type)) + this.route_params.encodedSizeWithTag(7, r7.route_params)) + r3.encodedSizeWithTag(8, r7.heartbeat_duration);
            ProtoAdapter r5 = ProtoAdapter.BOOL;
            return ((((((r4 + r5.encodedSizeWithTag(9, r7.need_ack)) + r1.encodedSizeWithTag(10, r7.push_server)) + r1.encodedSizeWithTag(11, r7.live_cursor)) + r5.encodedSizeWithTag(12, r7.history_no_more)) + r1.encodedSizeWithTag(13, r7.proxy_server)) + r1.encodedSizeWithTag(14, r7.push_server_v2)) + r7.unknownFields().size();
        }

        public SdkResponse redact(SdkResponse r3) {
            Builder r4 = r3.m1681newBuilder();
            Internal.redactElements(r4.messages, SdkMessage.ADAPTER);
            r4.clearUnknownFields();
            return r4.m1682build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1683decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SdkResponse) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SdkResponse) r1);
        }

        public void encode(ProtoWriter r6, SdkResponse r7) throws IOException {
            SdkMessage.ADAPTER.asRepeated().encodeWithTag(r6, 1, r7.messages);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r6, 2, r7.cursor);
            ProtoAdapter r1 = ProtoAdapter.INT64;
            r1.encodeWithTag(r6, 3, r7.fetch_interval);
            r1.encodeWithTag(r6, 4, r7.now);
            r0.encodeWithTag(r6, 5, r7.internal_ext);
            ProtoAdapter.INT32.encodeWithTag(r6, 6, r7.fetch_type);
            this.route_params.encodeWithTag(r6, 7, r7.route_params);
            r1.encodeWithTag(r6, 8, r7.heartbeat_duration);
            ProtoAdapter r2 = ProtoAdapter.BOOL;
            r2.encodeWithTag(r6, 9, r7.need_ack);
            r0.encodeWithTag(r6, 10, r7.push_server);
            r0.encodeWithTag(r6, 11, r7.live_cursor);
            r2.encodeWithTag(r6, 12, r7.history_no_more);
            r0.encodeWithTag(r6, 13, r7.proxy_server);
            r0.encodeWithTag(r6, 14, r7.push_server_v2);
            r6.writeBytes(r7.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SdkResponse) r2);
        }
    }

    static {
        ProtoAdapter_SdkResponse r0 = new ProtoAdapter_SdkResponse();
        ADAPTER = r0;
        CREATOR = AndroidMessage.newCreator(r0);
        DEFAULT_FETCH_INTERVAL = 0L;
        DEFAULT_NOW = 0L;
        DEFAULT_FETCH_TYPE = 0;
        DEFAULT_HEARTBEAT_DURATION = 0L;
        Boolean r1 = Boolean.FALSE;
        DEFAULT_NEED_ACK = r1;
        DEFAULT_HISTORY_NO_MORE = r1;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L53;
        int r1 = ((unknownFields().hashCode() * 37) + this.messages.hashCode()) * 37;
        String r2 = this.cursor;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Long r6 = this.fetch_interval;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Long r9 = this.now;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.internal_ext;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        Integer r15 = this.fetch_type;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (((r14 + r16) * 37) + this.route_params.hashCode()) * 37;
        Long r18 = this.heartbeat_duration;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        Boolean r21 = this.need_ack;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        String r24 = this.push_server;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        String r27 = this.live_cursor;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        Boolean r30 = this.history_no_more;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        String r33 = this.proxy_server;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        String r36 = this.push_server_v2;
        if (r36 == null) goto L51;
        r3 = r36.hashCode();
    L51:
        int r37 = r35 + r3;
        ((Message) this).hashCode = r37;
        return r37;
    L47:
        r34 = 0;
        goto L48
    L43:
        r31 = 0;
        goto L44
    L39:
        r28 = 0;
        goto L40
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
    L53:
        return r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1681newBuilder() {
        Builder r0 = new Builder();
        r0.messages = Internal.copyOf("messages", this.messages);
        r0.cursor = this.cursor;
        r0.fetch_interval = this.fetch_interval;
        r0.now = this.now;
        r0.internal_ext = this.internal_ext;
        r0.fetch_type = this.fetch_type;
        r0.route_params = Internal.copyOf("route_params", this.route_params);
        r0.heartbeat_duration = this.heartbeat_duration;
        r0.need_ack = this.need_ack;
        r0.push_server = this.push_server;
        r0.live_cursor = this.live_cursor;
        r0.history_no_more = this.history_no_more;
        r0.proxy_server = this.proxy_server;
        r0.push_server_v2 = this.push_server_v2;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        List<SdkMessage> r1 = this.messages;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", messages=");
        r0.append(this.messages);
    L8:
        if (this.cursor == null) goto L11;
        r0.append(", cursor=");
        r0.append(this.cursor);
    L11:
        if (this.fetch_interval == null) goto L14;
        r0.append(", fetch_interval=");
        r0.append(this.fetch_interval);
    L14:
        if (this.now == null) goto L17;
        r0.append(", now=");
        r0.append(this.now);
    L17:
        if (this.internal_ext == null) goto L20;
        r0.append(", internal_ext=");
        r0.append(this.internal_ext);
    L20:
        if (this.fetch_type == null) goto L22;
        r0.append(", fetch_type=");
        r0.append(this.fetch_type);
    L22:
        Map<String, String> r2 = this.route_params;
        if (r2 == null) goto L28;
        if (r2.isEmpty() == true) goto L28;
        r0.append(", route_params=");
        r0.append(this.route_params);
    L28:
        if (this.heartbeat_duration == null) goto L31;
        r0.append(", heartbeat_duration=");
        r0.append(this.heartbeat_duration);
    L31:
        if (this.need_ack == null) goto L34;
        r0.append(", need_ack=");
        r0.append(this.need_ack);
    L34:
        if (this.push_server == null) goto L37;
        r0.append(", push_server=");
        r0.append(this.push_server);
    L37:
        if (this.live_cursor == null) goto L40;
        r0.append(", live_cursor=");
        r0.append(this.live_cursor);
    L40:
        if (this.history_no_more == null) goto L43;
        r0.append(", history_no_more=");
        r0.append(this.history_no_more);
    L43:
        if (this.proxy_server == null) goto L46;
        r0.append(", proxy_server=");
        r0.append(this.proxy_server);
    L46:
        if (this.push_server_v2 == null) goto L48;
        r0.append(", push_server_v2=");
        r0.append(this.push_server_v2);
    L48:
        StringBuilder r3 = r0.replace(0, 2, "SdkResponse{");
        r3.append('}');
        return r3.toString();
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1681newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkResponse) == true) goto L8;
        return false;
    L8:
        SdkResponse r6 = (SdkResponse) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L39:
        return false;
    L11:
        if (this.messages.equals(r6.messages) == false) goto L39;
        if (Internal.equals(this.cursor, r6.cursor) == false) goto L39;
        if (Internal.equals(this.fetch_interval, r6.fetch_interval) == false) goto L39;
        if (Internal.equals(this.now, r6.now) == false) goto L39;
        if (Internal.equals(this.internal_ext, r6.internal_ext) == false) goto L39;
        if (Internal.equals(this.fetch_type, r6.fetch_type) == false) goto L39;
        if (this.route_params.equals(r6.route_params) == false) goto L39;
        if (Internal.equals(this.heartbeat_duration, r6.heartbeat_duration) == false) goto L39;
        if (Internal.equals(this.need_ack, r6.need_ack) == false) goto L39;
        if (Internal.equals(this.push_server, r6.push_server) == false) goto L39;
        if (Internal.equals(this.live_cursor, r6.live_cursor) == false) goto L39;
        if (Internal.equals(this.history_no_more, r6.history_no_more) == false) goto L39;
        if (Internal.equals(this.proxy_server, r6.proxy_server) == false) goto L39;
        if (Internal.equals(this.push_server_v2, r6.push_server_v2) == false) goto L39;
        return true;
    }

    public SdkResponse(List<SdkMessage> r17, String r18, Long r19, Long r20, String r21, Integer r22, Map<String, String> r23, Long r24, Boolean r25, String r26, String r27, Boolean r28, String r29, String r30) {
        this(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, ByteString.EMPTY);
    }

    public SdkResponse(List<SdkMessage> r4, String r5, Long r6, Long r7, String r8, Integer r9, Map<String, String> r10, Long r11, Boolean r12, String r13, String r14, Boolean r15, String r16, String r17, ByteString r18) {
        super(ADAPTER, r18);
        this.messages = Internal.immutableCopyOf("messages", r4);
        this.cursor = r5;
        this.fetch_interval = r6;
        this.now = r7;
        this.internal_ext = r8;
        this.fetch_type = r9;
        this.route_params = Internal.immutableCopyOf("route_params", r10);
        this.heartbeat_duration = r11;
        this.need_ack = r12;
        this.push_server = r13;
        this.live_cursor = r14;
        this.history_no_more = r15;
        this.proxy_server = r16;
        this.push_server_v2 = r17;
    }
}
