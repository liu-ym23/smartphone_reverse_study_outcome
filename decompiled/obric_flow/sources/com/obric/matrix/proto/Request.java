package com.obric.matrix.proto;

import androidx.room.jarjarred.org.antlr.runtime.a;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
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

    @SerializedName(Constant.APPKEY)
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

    @SerializedName(LynxMonitorService.KEY_CHANNEL)
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

        public Builder accessToken(String r5) {
            this.accessToken = r5;
            return this;
        }

        public Builder appKey(String r5) {
            this.appKey = r5;
            return this;
        }

        public Builder appPkg(String r5) {
            this.appPkg = r5;
            return this;
        }

        public Builder appVersionCode(String r5) {
            this.appVersionCode = r5;
            return this;
        }

        public Builder body(RequestBody r5) {
            this.body = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel(String r5) {
            this.channel = r5;
            return this;
        }

        public Builder cmd(Integer r5) {
            this.cmd = r5;
            return this;
        }

        public Builder deviceId(String r5) {
            this.deviceId = r5;
            return this;
        }

        public Builder extraParams(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.extraParams = r5;
            return this;
        }

        public Builder monitorInfo(MonitorInfo r5) {
            this.monitorInfo = r5;
            return this;
        }

        public Builder sdkVersion(String r5) {
            this.sdkVersion = r5;
            return this;
        }

        public Builder sequenceId(String r5) {
            this.sequenceId = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public Request build() {
            return new Request(this.cmd, this.sequenceId, this.sdkVersion, this.appKey, this.deviceId, this.channel, this.appVersionCode, this.extraParams, this.appPkg, this.body, this.accessToken, this.monitorInfo, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Request extends ProtoAdapter<Request> {
        private final ProtoAdapter<Map<String, String>> extraParams;

        public ProtoAdapter_Request() {
            super(FieldEncoding.LENGTH_DELIMITED, Request.class);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            this.extraParams = ProtoAdapter.newMapAdapter(r5, r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Request decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, Request r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Request r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Request redact(Request r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Request decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L19;
            switch(r12) {
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
            r5.monitorInfo(MonitorInfo.ADAPTER.decode(r10));
            goto L3
        L8:
            r5.accessToken(ProtoAdapter.STRING.decode(r10));
            goto L3
        L9:
            r5.body(RequestBody.ADAPTER.decode(r10));
            goto L3
        L10:
            r5.appPkg(ProtoAdapter.STRING.decode(r10));
            goto L3
        L11:
            r5.extraParams.putAll(this.extraParams.decode(r10));
            goto L3
        L12:
            r5.appVersionCode(ProtoAdapter.STRING.decode(r10));
            goto L3
        L13:
            r5.channel(ProtoAdapter.STRING.decode(r10));
            goto L3
        L14:
            r5.deviceId(ProtoAdapter.STRING.decode(r10));
            goto L3
        L15:
            r5.appKey(ProtoAdapter.STRING.decode(r10));
            goto L3
        L16:
            r5.sdkVersion(ProtoAdapter.STRING.decode(r10));
            goto L3
        L17:
            r5.sequenceId(ProtoAdapter.STRING.decode(r10));
            goto L3
        L18:
            r5.cmd(ProtoAdapter.INT32.decode(r10));
            goto L3
        L6:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L19:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, Request r10) throws IOException {
            ProtoAdapter.INT32.encodeWithTag(r5, 1, r10.cmd);
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            r11.encodeWithTag(r5, 2, r10.sequenceId);
            r11.encodeWithTag(r5, 3, r10.sdkVersion);
            r11.encodeWithTag(r5, 4, r10.appKey);
            r11.encodeWithTag(r5, 5, r10.deviceId);
            r11.encodeWithTag(r5, 6, r10.channel);
            r11.encodeWithTag(r5, 7, r10.appVersionCode);
            this.extraParams.encodeWithTag(r5, 9, r10.extraParams);
            r11.encodeWithTag(r5, 10, r10.appPkg);
            RequestBody.ADAPTER.encodeWithTag(r5, 11, r10.body);
            r11.encodeWithTag(r5, 12, r10.accessToken);
            MonitorInfo.ADAPTER.encodeWithTag(r5, 13, r10.monitorInfo);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Request r5) {
            int r10 = ProtoAdapter.INT32.encodedSizeWithTag(1, r5.cmd);
            ProtoAdapter<String> r11 = ProtoAdapter.STRING;
            int r12 = r11.encodedSizeWithTag(2, r5.sequenceId) + r10;
            int r13 = r11.encodedSizeWithTag(3, r5.sdkVersion) + r12;
            int r14 = r11.encodedSizeWithTag(4, r5.appKey) + r13;
            int r15 = r11.encodedSizeWithTag(5, r5.deviceId) + r14;
            int r16 = r11.encodedSizeWithTag(6, r5.channel) + r15;
            int r17 = r11.encodedSizeWithTag(7, r5.appVersionCode) + r16;
            int r18 = this.extraParams.encodedSizeWithTag(9, r5.extraParams) + r17;
            int r19 = r11.encodedSizeWithTag(10, r5.appPkg) + r18;
            int r20 = RequestBody.ADAPTER.encodedSizeWithTag(11, r5.body) + r19;
            int r21 = r11.encodedSizeWithTag(12, r5.accessToken) + r20;
            int r22 = MonitorInfo.ADAPTER.encodedSizeWithTag(13, r5.monitorInfo) + r21;
            return r5.unknownFields().size() + r22;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public Request redact2(Request r5) {
            Builder r10 = r5.newBuilder();
            RequestBody r11 = r10.body;
            if (r11 == null) goto L5;
            r10.body = RequestBody.ADAPTER.redact(r11);
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
        ADAPTER = new ProtoAdapter_Request();
        DEFAULT_CMD = 0;
    }

    public Request(Integer r15, String r16, String r17, String r18, String r19, String r20, String r21, Map<String, String> r22, String r23, RequestBody r24, String r25, MonitorInfo r26) {
        this(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof Request) == true) goto L8;
        return false;
    L8:
        Request r10 = (Request) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L36;
        if (Internal.equals(this.cmd, r10.cmd) == false) goto L36;
        if (Internal.equals(this.sequenceId, r10.sequenceId) == false) goto L36;
        if (Internal.equals(this.sdkVersion, r10.sdkVersion) == false) goto L36;
        if (Internal.equals(this.appKey, r10.appKey) == false) goto L36;
        if (Internal.equals(this.deviceId, r10.deviceId) == false) goto L36;
        if (Internal.equals(this.channel, r10.channel) == false) goto L36;
        if (Internal.equals(this.appVersionCode, r10.appVersionCode) == false) goto L36;
        if (this.extraParams.equals(r10.extraParams) == false) goto L36;
        if (Internal.equals(this.appPkg, r10.appPkg) == false) goto L36;
        if (Internal.equals(this.body, r10.body) == false) goto L36;
        if (Internal.equals(this.accessToken, r10.accessToken) == false) goto L36;
        if (Internal.equals(this.monitorInfo, r10.monitorInfo) == false) goto L36;
        return true;
    L36:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L49;
        int r10 = unknownFields().hashCode() * 37;
        Integer r11 = this.cmd;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        String r15 = this.sequenceId;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        String r18 = this.sdkVersion;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        String r21 = this.appKey;
        if (r21 == null) goto L19;
        int r22 = r21.hashCode();
    L20:
        int r23 = (r20 + r22) * 37;
        String r24 = this.deviceId;
        if (r24 == null) goto L23;
        int r25 = r24.hashCode();
    L24:
        int r26 = (r23 + r25) * 37;
        String r27 = this.channel;
        if (r27 == null) goto L27;
        int r28 = r27.hashCode();
    L28:
        int r29 = (r26 + r28) * 37;
        String r30 = this.appVersionCode;
        if (r30 == null) goto L31;
        int r31 = r30.hashCode();
    L32:
        int r32 = (this.extraParams.hashCode() + ((r29 + r31) * 37)) * 37;
        String r33 = this.appPkg;
        if (r33 == null) goto L35;
        int r34 = r33.hashCode();
    L36:
        int r35 = (r32 + r34) * 37;
        RequestBody r36 = this.body;
        if (r36 == null) goto L39;
        int r37 = r36.hashCode();
    L40:
        int r38 = (r35 + r37) * 37;
        String r39 = this.accessToken;
        if (r39 == null) goto L43;
        int r40 = r39.hashCode();
    L44:
        int r41 = (r38 + r40) * 37;
        MonitorInfo r42 = this.monitorInfo;
        if (r42 == null) goto L47;
        r12 = r42.hashCode();
    L47:
        int r43 = r41 + r12;
        this.hashCode = r43;
        return r43;
    L43:
        r40 = 0;
        goto L44
    L39:
        r37 = 0;
        goto L40
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
    L49:
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
        if (this.sequenceId == null) goto L9;
        r5.append(", sequenceId=");
        r5.append(this.sequenceId);
    L9:
        if (this.sdkVersion == null) goto L12;
        r5.append(", sdkVersion=");
        r5.append(this.sdkVersion);
    L12:
        if (this.appKey == null) goto L15;
        r5.append(", appKey=");
        r5.append(this.appKey);
    L15:
        if (this.deviceId == null) goto L18;
        r5.append(", deviceId=");
        r5.append(this.deviceId);
    L18:
        if (this.channel == null) goto L21;
        r5.append(", channel=");
        r5.append(this.channel);
    L21:
        if (this.appVersionCode == null) goto L23;
        r5.append(", appVersionCode=");
        r5.append(this.appVersionCode);
    L23:
        Map<String, String> r10 = this.extraParams;
        if (r10 == null) goto L29;
        if (r10.isEmpty() == true) goto L29;
        r5.append(", extraParams=");
        r5.append(this.extraParams);
    L29:
        if (this.appPkg == null) goto L32;
        r5.append(", appPkg=");
        r5.append(this.appPkg);
    L32:
        if (this.body == null) goto L35;
        r5.append(", body=");
        r5.append(this.body);
    L35:
        if (this.accessToken == null) goto L38;
        r5.append(", accessToken=");
        r5.append(this.accessToken);
    L38:
        if (this.monitorInfo == null) goto L41;
        r5.append(", monitorInfo=");
        r5.append(this.monitorInfo);
    L41:
        return a.s(r5, 0, 2, "Request{", '}');
    }

    public Request(Integer r5, String r10, String r11, String r12, String r13, String r14, String r15, Map<String, String> r16, String r17, RequestBody r18, String r19, MonitorInfo r110, ByteString r111) {
        super(ADAPTER, r111);
        this.cmd = r5;
        this.sequenceId = r10;
        this.sdkVersion = r11;
        this.appKey = r12;
        this.deviceId = r13;
        this.channel = r14;
        this.appVersionCode = r15;
        this.extraParams = Internal.immutableCopyOf("extraParams", r16);
        this.appPkg = r17;
        this.body = r18;
        this.accessToken = r19;
        this.monitorInfo = r110;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.cmd = this.cmd;
        r5.sequenceId = this.sequenceId;
        r5.sdkVersion = this.sdkVersion;
        r5.appKey = this.appKey;
        r5.deviceId = this.deviceId;
        r5.channel = this.channel;
        r5.appVersionCode = this.appVersionCode;
        r5.extraParams = Internal.copyOf("extraParams", this.extraParams);
        r5.appPkg = this.appPkg;
        r5.body = this.body;
        r5.accessToken = this.accessToken;
        r5.monitorInfo = this.monitorInfo;
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
