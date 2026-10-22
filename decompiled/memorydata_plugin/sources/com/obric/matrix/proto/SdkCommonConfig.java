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
public final class SdkCommonConfig extends Message<SdkCommonConfig, a> {
    public static final ProtoAdapter<SdkCommonConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("configs")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, String> configs;

    public static final class a extends Message.Builder<SdkCommonConfig, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, String> f8215a;

        public a() {
            this.f8215a = Internal.newMutableMap();
        }

        public SdkCommonConfig a() {
            return new SdkCommonConfig(this.f8215a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<SdkCommonConfig> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8216a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkCommonConfig.class);
            this.f8216a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(SdkCommonConfig r3) {
            return this.f8216a.encodedSizeWithTag(1, r3.configs) + r3.unknownFields().size();
        }

        public SdkCommonConfig a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.f8215a.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8216a.decode(r8), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r4 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r8));
            goto L3
        L9:
            r8.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r3, SdkCommonConfig r4) {
            this.f8216a.encodeWithTag(r3, 1, r4.configs);
            r3.writeBytes(r4.unknownFields());
        }

        public SdkCommonConfig b(SdkCommonConfig r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SdkCommonConfig decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, SdkCommonConfig r4) {
            a(r3, (SdkCommonConfig) ZeusTransformUtils.preCheckCast(r4, SdkCommonConfig.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(SdkCommonConfig r3) {
            return a((SdkCommonConfig) ZeusTransformUtils.preCheckCast(r3, SdkCommonConfig.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SdkCommonConfig redact(SdkCommonConfig r3) {
            return b((SdkCommonConfig) ZeusTransformUtils.preCheckCast(r3, SdkCommonConfig.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
    }

    public SdkCommonConfig(Map<String, String> r3) {
        this((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public SdkCommonConfig(Map<String, String> r3, ByteString r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r4);
        this.configs = Internal.immutableCopyOf("configs", r5);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SdkCommonConfig.class) == true) goto L8;
        return false;
    L8:
        SdkCommonConfig r6 = (SdkCommonConfig) ZeusTransformUtils.preCheckCast(r5, SdkCommonConfig.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L14;
        if (this.configs.equals(r6.configs) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.configs.hashCode();
        this.hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8215a = Internal.copyOf("configs", this.configs);
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
        Map<String, String> r1 = this.configs;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.append(", configs=").append(this.configs);
    L8:
        return r0.replace(0, 2, "SdkCommonConfig{").append('}').toString();
    }
}
