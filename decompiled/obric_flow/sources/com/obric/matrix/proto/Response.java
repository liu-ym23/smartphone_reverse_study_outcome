package com.obric.matrix.proto;

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

        public Builder() {
            this.cmd = 0;
            this.statusCode = 0;
            this.errorMsg = "";
            this.logId = "";
            this.sequenceId = "";
            this.accessToken = "";
            this.extraParams = Internal.newMutableMap();
        }

        public Builder accessToken(String r5) {
            this.accessToken = r5;
            return this;
        }

        public Builder body(ResponseBody r5) {
            this.body = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cmd(Integer r5) {
            this.cmd = r5;
            return this;
        }

        public Builder errorMsg(String r5) {
            this.errorMsg = r5;
            return this;
        }

        public Builder extraParams(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.extraParams = r5;
            return this;
        }

        public Builder logId(String r5) {
            this.logId = r5;
            return this;
        }

        public Builder monitorInfo(MonitorInfo r5) {
            this.monitorInfo = r5;
            return this;
        }

        public Builder sequenceId(String r5) {
            this.sequenceId = r5;
            return this;
        }

        public Builder statusCode(Integer r5) {
            this.statusCode = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public Response build() {
            return new Response(this.cmd, this.statusCode, this.errorMsg, this.logId, this.sequenceId, this.body, this.accessToken, this.monitorInfo, this.extraParams, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Response extends ProtoAdapter<Response> {
        private final ProtoAdapter<Map<String, String>> extraParams;

        public ProtoAdapter_Response() {
            super(FieldEncoding.LENGTH_DELIMITED, Response.class);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            this.extraParams = ProtoAdapter.newMapAdapter(r5, r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Response decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, Response r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Response r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Response redact(Response r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Response decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L16;
            switch(r12) {
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
            r5.extraParams.putAll(this.extraParams.decode(r10));
            goto L3
        L8:
            r5.monitorInfo(MonitorInfo.ADAPTER.decode(r10));
            goto L3
        L9:
            r5.accessToken(ProtoAdapter.STRING.decode(r10));
            goto L3
        L10:
            r5.body(ResponseBody.ADAPTER.decode(r10));
            goto L3
        L11:
            r5.sequenceId(ProtoAdapter.STRING.decode(r10));
            goto L3
        L12:
            r5.logId(ProtoAdapter.STRING.decode(r10));
            goto L3
        L13:
            r5.errorMsg(ProtoAdapter.STRING.decode(r10));
            goto L3
        L14:
            r5.statusCode(ProtoAdapter.INT32.decode(r10));
            goto L3
        L15:
            r5.cmd(ProtoAdapter.INT32.decode(r10));
            goto L3
        L6:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L16:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, Response r10) throws IOException {
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            r11.encodeWithTag(r5, 1, r10.cmd);
            r11.encodeWithTag(r5, 2, r10.statusCode);
            ProtoAdapter<String> r12 = ProtoAdapter.STRING;
            r12.encodeWithTag(r5, 3, r10.errorMsg);
            r12.encodeWithTag(r5, 4, r10.logId);
            r12.encodeWithTag(r5, 6, r10.sequenceId);
            ResponseBody.ADAPTER.encodeWithTag(r5, 7, r10.body);
            r12.encodeWithTag(r5, 8, r10.accessToken);
            MonitorInfo.ADAPTER.encodeWithTag(r5, 9, r10.monitorInfo);
            this.extraParams.encodeWithTag(r5, 10, r10.extraParams);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Response r10) {
            ProtoAdapter<Integer> r5 = ProtoAdapter.INT32;
            int r11 = r5.encodedSizeWithTag(1, r10.cmd);
            int r12 = r5.encodedSizeWithTag(2, r10.statusCode) + r11;
            ProtoAdapter<String> r13 = ProtoAdapter.STRING;
            int r14 = r13.encodedSizeWithTag(3, r10.errorMsg) + r12;
            int r15 = r13.encodedSizeWithTag(4, r10.logId) + r14;
            int r16 = r13.encodedSizeWithTag(6, r10.sequenceId) + r15;
            int r17 = ResponseBody.ADAPTER.encodedSizeWithTag(7, r10.body) + r16;
            int r18 = r13.encodedSizeWithTag(8, r10.accessToken) + r17;
            int r19 = MonitorInfo.ADAPTER.encodedSizeWithTag(9, r10.monitorInfo) + r18;
            int r20 = this.extraParams.encodedSizeWithTag(10, r10.extraParams) + r19;
            return r10.unknownFields().size() + r20;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Response redact2(Response r5) {
            Builder r10 = r5.newBuilder();
            ResponseBody r11 = r10.body;
            if (r11 == null) goto L5;
            r10.body = ResponseBody.ADAPTER.redact(r11);
        L5:
            MonitorInfo r12 = r10.monitorInfo;
            if (r12 == null) goto L8;
            r10.monitorInfo = MonitorInfo.ADAPTER.redact(r12);
        L8:
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Response();
        DEFAULT_CMD = 0;
        DEFAULT_STATUSCODE = 0;
    }

    public Response(Integer r12, Integer r13, String r14, String r15, String r16, ResponseBody r17, String r18, MonitorInfo r19, Map<String, String> r20) {
        this(r12, r13, r14, r15, r16, r17, r18, r19, r20, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Response) == true) goto L8;
        return false;
    L8:
        Response r10 = (Response) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L30;
        if (Internal.equals(this.cmd, r10.cmd) == false) goto L30;
        if (Internal.equals(this.statusCode, r10.statusCode) == false) goto L30;
        if (Internal.equals(this.errorMsg, r10.errorMsg) == false) goto L30;
        if (Internal.equals(this.logId, r10.logId) == false) goto L30;
        if (Internal.equals(this.sequenceId, r10.sequenceId) == false) goto L30;
        if (Internal.equals(this.body, r10.body) == false) goto L30;
        if (Internal.equals(this.accessToken, r10.accessToken) == false) goto L30;
        if (Internal.equals(this.monitorInfo, r10.monitorInfo) == false) goto L30;
        if (this.extraParams.equals(r10.extraParams) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L37;
        int r10 = unknownFields().hashCode() * 37;
        Integer r11 = this.cmd;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Integer r15 = this.statusCode;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        String r18 = this.errorMsg;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        String r21 = this.logId;
        if (r21 == null) goto L19;
        int r22 = r21.hashCode();
    L20:
        int r23 = (r20 + r22) * 37;
        String r24 = this.sequenceId;
        if (r24 == null) goto L23;
        int r25 = r24.hashCode();
    L24:
        int r26 = (r23 + r25) * 37;
        ResponseBody r27 = this.body;
        if (r27 == null) goto L27;
        int r28 = r27.hashCode();
    L28:
        int r29 = (r26 + r28) * 37;
        String r30 = this.accessToken;
        if (r30 == null) goto L31;
        int r31 = r30.hashCode();
    L32:
        int r32 = (r29 + r31) * 37;
        MonitorInfo r33 = this.monitorInfo;
        if (r33 == null) goto L35;
        r12 = r33.hashCode();
    L35:
        int r34 = ((r32 + r12) * 37) + this.extraParams.hashCode();
        this.hashCode = r34;
        return r34;
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
    L37:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.cmd == null) goto L6;
        r5.append(", cmd=");
        r5.append(this.cmd);
    L6:
        if (this.statusCode == null) goto L9;
        r5.append(", statusCode=");
        r5.append(this.statusCode);
    L9:
        if (this.errorMsg == null) goto L12;
        r5.append(", errorMsg=");
        r5.append(this.errorMsg);
    L12:
        if (this.logId == null) goto L15;
        r5.append(", logId=");
        r5.append(this.logId);
    L15:
        if (this.sequenceId == null) goto L18;
        r5.append(", sequenceId=");
        r5.append(this.sequenceId);
    L18:
        if (this.body == null) goto L21;
        r5.append(", body=");
        r5.append(this.body);
    L21:
        if (this.accessToken == null) goto L24;
        r5.append(", accessToken=");
        r5.append(this.accessToken);
    L24:
        if (this.monitorInfo == null) goto L26;
        r5.append(", monitorInfo=");
        r5.append(this.monitorInfo);
    L26:
        Map<String, String> r10 = this.extraParams;
        if (r10 == null) goto L32;
        if (r10.isEmpty() == true) goto L32;
        r5.append(", extraParams=");
        r5.append(this.extraParams);
    L32:
        return a.s(r5, 0, 2, "Response{", '}');
    }

    public Response(Integer r5, Integer r10, String r11, String r12, String r13, ResponseBody r14, String r15, MonitorInfo r16, Map<String, String> r17, ByteString r18) {
        super(ADAPTER, r18);
        this.cmd = r5;
        this.statusCode = r10;
        this.errorMsg = r11;
        this.logId = r12;
        this.sequenceId = r13;
        this.body = r14;
        this.accessToken = r15;
        this.monitorInfo = r16;
        this.extraParams = Internal.immutableCopyOf("extraParams", r17);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.cmd = this.cmd;
        r5.statusCode = this.statusCode;
        r5.errorMsg = this.errorMsg;
        r5.logId = this.logId;
        r5.sequenceId = this.sequenceId;
        r5.body = this.body;
        r5.accessToken = this.accessToken;
        r5.monitorInfo = this.monitorInfo;
        r5.extraParams = Internal.copyOf("extraParams", this.extraParams);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
