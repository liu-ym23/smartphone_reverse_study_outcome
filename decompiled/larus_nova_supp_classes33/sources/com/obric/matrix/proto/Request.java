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
public final class Request extends Message<Request, Builder> {
    public static final ProtoAdapter<Request> ADAPTER = null;
    public static final String DEFAULT_ACCESSTOKEN = "";
    public static final String DEFAULT_APPKEY = "";
    public static final String DEFAULT_APPPKG = "";
    public static final String DEFAULT_APPVERSIONCODE = "";
    public static final String DEFAULT_CHANNEL = "";
    public static final Integer DEFAULT_CMD = null;
    public static final String DEFAULT_DEVICEID = "";
    public static final String DEFAULT_SDKVERSION = "";
    public static final String DEFAULT_SEQUENCEID = "";
    private static final long serialVersionUID = 0;

    @SerializedName("accessToken")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String accessToken;

    @SerializedName("appKey")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String appKey;

    @SerializedName("appPkg")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String appPkg;

    @SerializedName("appVersionCode")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String appVersionCode;

    @SerializedName("body")
    @WireField(adapter = "com.obric.matrix.proto.RequestBody#ADAPTER", tag = 11)
    public final RequestBody body;

    @SerializedName("channel")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String channel;

    @SerializedName("cmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer cmd;

    @SerializedName("deviceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String deviceId;

    @SerializedName("extraParams")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final Map<String, String> extraParams;

    @SerializedName("monitorInfo")
    @WireField(adapter = "com.obric.matrix.proto.MonitorInfo#ADAPTER", tag = 13)
    public final MonitorInfo monitorInfo;

    @SerializedName("sdkVersion")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String sdkVersion;

    @SerializedName("sequenceId")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String sequenceId;

    public static final class Builder extends Message.Builder<Request, Builder> {
        public String accessToken;
        public String appKey;
        public String appPkg;
        public String appVersionCode;
        public RequestBody body;
        public String channel;
        public Integer cmd;
        public String deviceId;
        public Map<String, String> extraParams;
        public MonitorInfo monitorInfo;
        public String sdkVersion;
        public String sequenceId;

        public Request build() {
            return new Request(this.cmd, this.sequenceId, this.sdkVersion, this.appKey, this.deviceId, this.channel, this.appVersionCode, this.extraParams, this.appPkg, this.body, this.accessToken, this.monitorInfo, super.buildUnknownFields());
        }

        public Builder() {
            this.cmd = 0;
            this.sequenceId = "";
            this.sdkVersion = "";
            this.appKey = "";
            this.deviceId = "";
            this.channel = "";
            this.appVersionCode = "";
            this.appPkg = "";
            this.accessToken = "";
            this.extraParams = Internal.newMutableMap();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m149build() {
            return build();
        }

        public Builder accessToken(String r1) {
            this.accessToken = r1;
            return this;
        }

        public Builder appKey(String r1) {
            this.appKey = r1;
            return this;
        }

        public Builder appPkg(String r1) {
            this.appPkg = r1;
            return this;
        }

        public Builder appVersionCode(String r1) {
            this.appVersionCode = r1;
            return this;
        }

        public Builder body(RequestBody r1) {
            this.body = r1;
            return this;
        }

        public Builder channel(String r1) {
            this.channel = r1;
            return this;
        }

        public Builder cmd(Integer r1) {
            this.cmd = r1;
            return this;
        }

        public Builder deviceId(String r1) {
            this.deviceId = r1;
            return this;
        }

        public Builder extraParams(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.extraParams = r1;
            return this;
        }

        public Builder monitorInfo(MonitorInfo r1) {
            this.monitorInfo = r1;
            return this;
        }

        public Builder sdkVersion(String r1) {
            this.sdkVersion = r1;
            return this;
        }

        public Builder sequenceId(String r1) {
            this.sequenceId = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_Request extends ProtoAdapter<Request> {
        private final ProtoAdapter<Map<String, String>> extraParams;

        public ProtoAdapter_Request() {
            super(FieldEncoding.LENGTH_DELIMITED, Request.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.extraParams = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public Request decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L19;
            switch(r3) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L6;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L7:
            r0.monitorInfo((MonitorInfo) MonitorInfo.ADAPTER.decode(r7));
            goto L3
        L8:
            r0.accessToken((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L9:
            r0.body((RequestBody) RequestBody.ADAPTER.decode(r7));
            goto L3
        L10:
            r0.appPkg((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L11:
            r0.extraParams.putAll((Map) this.extraParams.decode(r7));
            goto L3
        L12:
            r0.appVersionCode((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L13:
            r0.channel((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L14:
            r0.deviceId((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L15:
            r0.appKey((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L16:
            r0.sdkVersion((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L17:
            r0.sequenceId((String) ProtoAdapter.STRING.decode(r7));
            goto L3
        L18:
            r0.cmd((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L19:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(Request r6) {
            int r0 = ProtoAdapter.INT32.encodedSizeWithTag(1, r6.cmd);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            return (((((((((((r0 + r1.encodedSizeWithTag(2, r6.sequenceId)) + r1.encodedSizeWithTag(3, r6.sdkVersion)) + r1.encodedSizeWithTag(4, r6.appKey)) + r1.encodedSizeWithTag(5, r6.deviceId)) + r1.encodedSizeWithTag(6, r6.channel)) + r1.encodedSizeWithTag(7, r6.appVersionCode)) + this.extraParams.encodedSizeWithTag(9, r6.extraParams)) + r1.encodedSizeWithTag(10, r6.appPkg)) + RequestBody.ADAPTER.encodedSizeWithTag(11, r6.body)) + r1.encodedSizeWithTag(12, r6.accessToken)) + MonitorInfo.ADAPTER.encodedSizeWithTag(13, r6.monitorInfo)) + r6.unknownFields().size();
        }

        public Request redact(Request r3) {
            Builder r4 = r3.newBuilder();
            RequestBody r0 = r4.body;
            if (r0 == null) goto L5;
            r4.body = (RequestBody) RequestBody.ADAPTER.redact(r0);
        L5:
            MonitorInfo r1 = r4.monitorInfo;
            if (r1 == null) goto L8;
            r4.monitorInfo = (MonitorInfo) MonitorInfo.ADAPTER.redact(r1);
        L8:
            r4.clearUnknownFields();
            return r4.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m150decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((Request) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((Request) r1);
        }

        public void encode(ProtoWriter r5, Request r6) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r5, 1, r6.cmd);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r5, 2, r6.sequenceId);
            r0.encodeWithTag(r5, 3, r6.sdkVersion);
            r0.encodeWithTag(r5, 4, r6.appKey);
            r0.encodeWithTag(r5, 5, r6.deviceId);
            r0.encodeWithTag(r5, 6, r6.channel);
            r0.encodeWithTag(r5, 7, r6.appVersionCode);
            this.extraParams.encodeWithTag(r5, 9, r6.extraParams);
            r0.encodeWithTag(r5, 10, r6.appPkg);
            RequestBody.ADAPTER.encodeWithTag(r5, 11, r6.body);
            r0.encodeWithTag(r5, 12, r6.accessToken);
            MonitorInfo.ADAPTER.encodeWithTag(r5, 13, r6.monitorInfo);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (Request) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Request();
        DEFAULT_CMD = 0;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L49;
        int r1 = unknownFields().hashCode() * 37;
        Integer r2 = this.cmd;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        String r6 = this.sequenceId;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.sdkVersion;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.appKey;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.deviceId;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.channel;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.appVersionCode;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (((r20 + r22) * 37) + this.extraParams.hashCode()) * 37;
        String r24 = this.appPkg;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        RequestBody r27 = this.body;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        String r30 = this.accessToken;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        MonitorInfo r33 = this.monitorInfo;
        if (r33 == null) goto L47;
        r3 = r33.hashCode();
    L47:
        int r34 = r32 + r3;
        ((Message) this).hashCode = r34;
        return r34;
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
    L49:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.cmd = this.cmd;
        r0.sequenceId = this.sequenceId;
        r0.sdkVersion = this.sdkVersion;
        r0.appKey = this.appKey;
        r0.deviceId = this.deviceId;
        r0.channel = this.channel;
        r0.appVersionCode = this.appVersionCode;
        r0.extraParams = Internal.copyOf("extraParams", this.extraParams);
        r0.appPkg = this.appPkg;
        r0.body = this.body;
        r0.accessToken = this.accessToken;
        r0.monitorInfo = this.monitorInfo;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.cmd == null) goto L6;
        r0.append(", cmd=");
        r0.append(this.cmd);
    L6:
        if (this.sequenceId == null) goto L9;
        r0.append(", sequenceId=");
        r0.append(this.sequenceId);
    L9:
        if (this.sdkVersion == null) goto L12;
        r0.append(", sdkVersion=");
        r0.append(this.sdkVersion);
    L12:
        if (this.appKey == null) goto L15;
        r0.append(", appKey=");
        r0.append(this.appKey);
    L15:
        if (this.deviceId == null) goto L18;
        r0.append(", deviceId=");
        r0.append(this.deviceId);
    L18:
        if (this.channel == null) goto L21;
        r0.append(", channel=");
        r0.append(this.channel);
    L21:
        if (this.appVersionCode == null) goto L23;
        r0.append(", appVersionCode=");
        r0.append(this.appVersionCode);
    L23:
        Map<String, String> r1 = this.extraParams;
        if (r1 == null) goto L29;
        if (r1.isEmpty() == true) goto L29;
        r0.append(", extraParams=");
        r0.append(this.extraParams);
    L29:
        if (this.appPkg == null) goto L32;
        r0.append(", appPkg=");
        r0.append(this.appPkg);
    L32:
        if (this.body == null) goto L35;
        r0.append(", body=");
        r0.append(this.body);
    L35:
        if (this.accessToken == null) goto L38;
        r0.append(", accessToken=");
        r0.append(this.accessToken);
    L38:
        if (this.monitorInfo == null) goto L40;
        r0.append(", monitorInfo=");
        r0.append(this.monitorInfo);
    L40:
        StringBuilder r2 = r0.replace(0, 2, "Request{");
        r2.append('}');
        return r2.toString();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m148newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Request) == true) goto L8;
        return false;
    L8:
        Request r6 = (Request) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L35:
        return false;
    L11:
        if (Internal.equals(this.cmd, r6.cmd) == false) goto L35;
        if (Internal.equals(this.sequenceId, r6.sequenceId) == false) goto L35;
        if (Internal.equals(this.sdkVersion, r6.sdkVersion) == false) goto L35;
        if (Internal.equals(this.appKey, r6.appKey) == false) goto L35;
        if (Internal.equals(this.deviceId, r6.deviceId) == false) goto L35;
        if (Internal.equals(this.channel, r6.channel) == false) goto L35;
        if (Internal.equals(this.appVersionCode, r6.appVersionCode) == false) goto L35;
        if (this.extraParams.equals(r6.extraParams) == false) goto L35;
        if (Internal.equals(this.appPkg, r6.appPkg) == false) goto L35;
        if (Internal.equals(this.body, r6.body) == false) goto L35;
        if (Internal.equals(this.accessToken, r6.accessToken) == false) goto L35;
        if (Internal.equals(this.monitorInfo, r6.monitorInfo) == false) goto L35;
        return true;
    }

    public Request(Integer r15, String r16, String r17, String r18, String r19, String r20, String r21, Map<String, String> r22, String r23, RequestBody r24, String r25, MonitorInfo r26) {
        this(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, ByteString.EMPTY);
    }

    public Request(Integer r2, String r3, String r4, String r5, String r6, String r7, String r8, Map<String, String> r9, String r10, RequestBody r11, String r12, MonitorInfo r13, ByteString r14) {
        super(ADAPTER, r14);
        this.cmd = r2;
        this.sequenceId = r3;
        this.sdkVersion = r4;
        this.appKey = r5;
        this.deviceId = r6;
        this.channel = r7;
        this.appVersionCode = r8;
        this.extraParams = Internal.immutableCopyOf("extraParams", r9);
        this.appPkg = r10;
        this.body = r11;
        this.accessToken = r12;
        this.monitorInfo = r13;
    }
}
