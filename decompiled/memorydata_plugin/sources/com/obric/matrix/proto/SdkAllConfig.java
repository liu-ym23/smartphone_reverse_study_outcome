package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class SdkAllConfig extends Message<SdkAllConfig, a> {
    public static final ProtoAdapter<SdkAllConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("otherConfig")
    @WireField(adapter = "com.obric.matrix.proto.SdkCommonConfig#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, SdkCommonConfig> otherConfig;

    @SerializedName("sdkSendCmdConfig")
    @WireField(adapter = "com.obric.matrix.proto.SdkSendCmdConfig#ADAPTER", tag = 1)
    public final SdkSendCmdConfig sdkSendCmdConfig;

    public static final class a extends Message.Builder<SdkAllConfig, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SdkSendCmdConfig f8212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, SdkCommonConfig> f8213b;

        public a() {
            this.f8213b = Internal.newMutableMap();
        }

        public a a(SdkSendCmdConfig r1) {
            this.f8212a = r1;
            return this;
        }

        public SdkAllConfig a() {
            return new SdkAllConfig(this.f8212a, this.f8213b, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<SdkAllConfig> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, SdkCommonConfig>> f8214a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkAllConfig.class);
            this.f8214a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, SdkCommonConfig.ADAPTER);
        }

        public int a(SdkAllConfig r4) {
            return (SdkSendCmdConfig.ADAPTER.encodedSizeWithTag(1, r4.sdkSendCmdConfig) + this.f8214a.encodedSizeWithTag(2, r4.otherConfig)) + r4.unknownFields().size();
        }

        public SdkAllConfig a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.a((SdkSendCmdConfig) ZeusTransformUtils.preCheckCast(SdkSendCmdConfig.ADAPTER.decode(r8), SdkSendCmdConfig.class, "com.obric.memorydata.plugin"));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.f8213b.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8214a.decode(r8), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L12:
            r8.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, SdkAllConfig r5) {
            SdkSendCmdConfig.ADAPTER.encodeWithTag(r4, 1, r5.sdkSendCmdConfig);
            this.f8214a.encodeWithTag(r4, 2, r5.otherConfig);
            r4.writeBytes(r5.unknownFields());
        }

        public SdkAllConfig b(SdkAllConfig r3) {
            a r2 = r3.newBuilder();
            if (r2.f8212a == null) goto L5;
            r2.f8212a = (SdkSendCmdConfig) ZeusTransformUtils.preCheckCast(SdkSendCmdConfig.ADAPTER.redact(r2.f8212a), SdkSendCmdConfig.class, "com.obric.memorydata.plugin");
        L5:
            Internal.redactElements(r2.f8213b, SdkCommonConfig.ADAPTER);
            r2.clearUnknownFields();
            return r2.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SdkAllConfig decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, SdkAllConfig r4) {
            a(r3, (SdkAllConfig) ZeusTransformUtils.preCheckCast(r4, SdkAllConfig.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(SdkAllConfig r3) {
            return a((SdkAllConfig) ZeusTransformUtils.preCheckCast(r3, SdkAllConfig.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SdkAllConfig redact(SdkAllConfig r3) {
            return b((SdkAllConfig) ZeusTransformUtils.preCheckCast(r3, SdkAllConfig.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public SdkAllConfig(SdkSendCmdConfig r3, Map<String, SdkCommonConfig> r4) {
        this(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public SdkAllConfig(SdkSendCmdConfig r3, Map<String, SdkCommonConfig> r4, ByteString r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r5);
        this.sdkSendCmdConfig = r3;
        this.otherConfig = Internal.immutableCopyOf("otherConfig", r6);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SdkAllConfig.class) == true) goto L8;
        return false;
    L8:
        SdkAllConfig r6 = (SdkAllConfig) ZeusTransformUtils.preCheckCast(r5, SdkAllConfig.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L16;
        if (Internal.equals(this.sdkSendCmdConfig, r6.sdkSendCmdConfig) == false) goto L16;
        if (this.otherConfig.equals(r6.otherConfig) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        SdkSendCmdConfig r2 = this.sdkSendCmdConfig;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.otherConfig.hashCode();
        this.hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8212a = this.sdkSendCmdConfig;
        r0.f8213b = Internal.copyOf("otherConfig", this.otherConfig);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.sdkSendCmdConfig == null) goto L5;
        r0.append(", sdkSendCmdConfig=").append(this.sdkSendCmdConfig);
    L5:
        Map<String, SdkCommonConfig> r1 = this.otherConfig;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", otherConfig=").append(this.otherConfig);
    L11:
        return r0.replace(0, 2, "SdkAllConfig{").append('}').toString();
    }
}
