package com.obric.matrix.proto;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class Response extends Message<Response, Builder> {
    public static final ProtoAdapter<Response> ADAPTER = null;
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final Integer DEFAULT_CMD = null;
    public static final String DEFAULT_ERRORMSG = "";
    public static final String DEFAULT_LOGID = "";
    public static final String DEFAULT_SEQUENCEID = "";
    public static final Integer DEFAULT_STATUSCODE = null;
    private static final long serialVersionUID = 0;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String accessToken;

    @SerializedName("body")
    @WireField(adapter = "com.obric.matrix.proto.ResponseBody#ADAPTER", tag = 7)
    public final ResponseBody body;

    @SerializedName("cmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer cmd;

    @SerializedName("errorMsg")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String errorMsg;

    @SerializedName("extraParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final Map<String, String> extraParams;

    @SerializedName("logId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String logId;

    @SerializedName("monitorInfo")
    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 9)
    public final MonitorInfo monitorInfo;

    @SerializedName("sequenceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String sequenceId;

    @SerializedName("statusCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer statusCode;

    public static final class Builder extends Message.Builder<Response, Builder> {
        public String accessToken;
        public ResponseBody body;
        public Integer cmd;
        public String errorMsg;
        public Map<String, String> extraParams;
        public String logId;
        public MonitorInfo monitorInfo;
        public String sequenceId;
        public Integer statusCode;

        public Response build() {
            return new Response(this.cmd, this.statusCode, this.errorMsg, this.logId, this.sequenceId, this.body, this.accessToken, this.monitorInfo, this.extraParams, super.buildUnknownFields());
        }

        public Builder() {
            this.cmd = 0;
            this.statusCode = 0;
            this.errorMsg = "";
            this.logId = "";
            this.sequenceId = "";
            this.accessToken = "";
            this.extraParams = Internal.newMutableMap();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m155build() {
            return build();
        }

        public Builder accessToken(String r1) {
            this.accessToken = r1;
            return this;
        }

        public Builder body(ResponseBody r1) {
            this.body = r1;
            return this;
        }

        public Builder cmd(Integer r1) {
            this.cmd = r1;
            return this;
        }

        public Builder errorMsg(String r1) {
            this.errorMsg = r1;
            return this;
        }

        public Builder extraParams(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.extraParams = r1;
            return this;
        }

        public Builder logId(String r1) {
            this.logId = r1;
            return this;
        }

        public Builder monitorInfo(MonitorInfo r1) {
            this.monitorInfo = r1;
            return this;
        }

        public Builder sequenceId(String r1) {
            this.sequenceId = r1;
            return this;
        }

        public Builder statusCode(Integer r1) {
            this.statusCode = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Response extends ProtoAdapter<Response> {
        private final ProtoAdapter<Map<String, String>> extraParams;

        public ProtoAdapter_Response() {
            super(FieldEncoding.LENGTH_DELIMITED, Response.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.extraParams = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public Response decode(ProtoReader r7) throws IOException {
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
                case 5: goto L6;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r0.extraParams.putAll((Map) this.extraParams.decode(r7));
            goto L3
        L8:
            r0.monitorInfo((MonitorInfo) MonitorInfo.ADAPTER.decode(r7));
            goto L3
        L9:
            r0.accessToken((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L10:
            r0.body((ResponseBody) ResponseBody.ADAPTER.decode(r7));
            goto L3
        L11:
            r0.sequenceId((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L12:
            r0.logId((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            r0.errorMsg((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L14:
            r0.statusCode((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L15:
            r0.cmd((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L16:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(Response r6) {
            ProtoAdapter r0 = ProtoAdapter.INT32;
            int r1 = r0.encodedSizeWithTag(1, r6.cmd) + r0.encodedSizeWithTag(2, r6.statusCode);
            ProtoAdapter r2 = ProtoAdapter.STRING;
            return (((((((r1 + r2.encodedSizeWithTag(3, r6.errorMsg)) + r2.encodedSizeWithTag(4, r6.logId)) + r2.encodedSizeWithTag(6, r6.sequenceId)) + ResponseBody.ADAPTER.encodedSizeWithTag(7, r6.body)) + r2.encodedSizeWithTag(8, r6.accessToken)) + MonitorInfo.ADAPTER.encodedSizeWithTag(9, r6.monitorInfo)) + this.extraParams.encodedSizeWithTag(10, r6.extraParams)) + r6.unknownFields().size();
        }

        public Response redact(Response r3) {
            Builder r4 = r3.newBuilder();
            ResponseBody r0 = r4.body;
            if (r0 == null) goto L5;
            r4.body = (ResponseBody) ResponseBody.ADAPTER.redact(r0);
        L5:
            MonitorInfo r1 = r4.monitorInfo;
            if (r1 == null) goto L8;
            r4.monitorInfo = (MonitorInfo) MonitorInfo.ADAPTER.redact(r1);
        L8:
            r4.clearUnknownFields();
            return r4.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m156decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Response) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((Response) r1);
        }

        public void encode(ProtoWriter r5, Response r6) throws IOException {
            ProtoAdapter r0 = ProtoAdapter.INT32;
            r0.encodeWithTag(r5, 1, r6.cmd);
            r0.encodeWithTag(r5, 2, r6.statusCode);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            r1.encodeWithTag(r5, 3, r6.errorMsg);
            r1.encodeWithTag(r5, 4, r6.logId);
            r1.encodeWithTag(r5, 6, r6.sequenceId);
            ResponseBody.ADAPTER.encodeWithTag(r5, 7, r6.body);
            r1.encodeWithTag(r5, 8, r6.accessToken);
            MonitorInfo.ADAPTER.encodeWithTag(r5, 9, r6.monitorInfo);
            this.extraParams.encodeWithTag(r5, 10, r6.extraParams);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Response) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Response();
        DEFAULT_CMD = 0;
        DEFAULT_STATUSCODE = 0;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L37;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.cmd;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.statusCode;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.errorMsg;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.logId;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.sequenceId;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        ResponseBody r18 = this.body;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.accessToken;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        MonitorInfo r24 = this.monitorInfo;
        if (r24 == null) goto L35;
        r3 = r24.hashCode();
    L35:
        int r25 = ((r23 + r3) * 37) + this.extraParams.hashCode();
        ((Message) this).hashCode = r25;
        return r25;
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
    L37:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.cmd = this.cmd;
        r0.statusCode = this.statusCode;
        r0.errorMsg = this.errorMsg;
        r0.logId = this.logId;
        r0.sequenceId = this.sequenceId;
        r0.body = this.body;
        r0.accessToken = this.accessToken;
        r0.monitorInfo = this.monitorInfo;
        r0.extraParams = Internal.copyOf("extraParams", this.extraParams);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.cmd == null) goto L6;
        r0.append(", cmd=");
        r0.append(this.cmd);
    L6:
        if (this.statusCode == null) goto L9;
        r0.append(", statusCode=");
        r0.append(this.statusCode);
    L9:
        if (this.errorMsg == null) goto L12;
        r0.append(", errorMsg=");
        r0.append(this.errorMsg);
    L12:
        if (this.logId == null) goto L15;
        r0.append(", logId=");
        r0.append(this.logId);
    L15:
        if (this.sequenceId == null) goto L18;
        r0.append(", sequenceId=");
        r0.append(this.sequenceId);
    L18:
        if (this.body == null) goto L21;
        r0.append(", body=");
        r0.append(this.body);
    L21:
        if (this.accessToken == null) goto L24;
        r0.append(", accessToken=");
        r0.append(this.accessToken);
    L24:
        if (this.monitorInfo == null) goto L26;
        r0.append(", monitorInfo=");
        r0.append(this.monitorInfo);
    L26:
        Map<String, String> r1 = this.extraParams;
        if (r1 != null) goto L29;
    L31:
        StringBuilder r2 = r0.replace(0, 2, "Response{");
        r2.append('}');
        return r2.toString();
    L29:
        if (r1.isEmpty() == true) goto L31;
        r0.append(", extraParams=");
        r0.append(this.extraParams);
        goto L31
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m154newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Response) == true) goto L8;
        return false;
    L8:
        Response r6 = (Response) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L29:
        return false;
    L11:
        if (Internal.equals(this.cmd, r6.cmd) == false) goto L29;
        if (Internal.equals(this.statusCode, r6.statusCode) == false) goto L29;
        if (Internal.equals(this.errorMsg, r6.errorMsg) == false) goto L29;
        if (Internal.equals(this.logId, r6.logId) == false) goto L29;
        if (Internal.equals(this.sequenceId, r6.sequenceId) == false) goto L29;
        if (Internal.equals(this.body, r6.body) == false) goto L29;
        if (Internal.equals(this.accessToken, r6.accessToken) == false) goto L29;
        if (Internal.equals(this.monitorInfo, r6.monitorInfo) == false) goto L29;
        if (this.extraParams.equals(r6.extraParams) == false) goto L29;
        return true;
    }

    public Response(Integer r12, Integer r13, String r14, String r15, String r16, ResponseBody r17, String r18, MonitorInfo r19, Map<String, String> r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public Response(Integer r2, Integer r3, String r4, String r5, String r6, ResponseBody r7, String r8, MonitorInfo r9, Map<String, String> r10, ByteString r11) {
        super(ADAPTER, r11);
        this.cmd = r2;
        this.statusCode = r3;
        this.errorMsg = r4;
        this.logId = r5;
        this.sequenceId = r6;
        this.body = r7;
        this.accessToken = r8;
        this.monitorInfo = r9;
        this.extraParams = Internal.immutableCopyOf("extraParams", r10);
    }
}
