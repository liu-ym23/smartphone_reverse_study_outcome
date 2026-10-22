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
public final class SdkAllConfig extends Message<SdkAllConfig, Builder> {
    public static final ProtoAdapter<SdkAllConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("otherConfig")
    @WireField(adapter = "com.obric.matrix.proto.SdkCommonConfig#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final Map<String, SdkCommonConfig> otherConfig;

    @SerializedName("sdkSendCmdConfig")
    @WireField(adapter = "com.obric.matrix.proto.SdkSendCmdConfig#ADAPTER", tag = 1)
    public final SdkSendCmdConfig sdkSendCmdConfig;

    public static final class Builder extends Message.Builder<SdkAllConfig, Builder> {
        public Map<String, SdkCommonConfig> otherConfig;
        public SdkSendCmdConfig sdkSendCmdConfig;

        public SdkAllConfig build() {
            return new SdkAllConfig(this.sdkSendCmdConfig, this.otherConfig, super.buildUnknownFields());
        }

        public Builder() {
            this.otherConfig = Internal.newMutableMap();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m161build() {
            return build();
        }

        public Builder otherConfig(Map<String, SdkCommonConfig> r1) {
            Internal.checkElementsNotNull(r1);
            this.otherConfig = r1;
            return this;
        }

        public Builder sdkSendCmdConfig(SdkSendCmdConfig r1) {
            this.sdkSendCmdConfig = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SdkAllConfig extends ProtoAdapter<SdkAllConfig> {
        private final ProtoAdapter<Map<String, SdkCommonConfig>> otherConfig;

        public ProtoAdapter_SdkAllConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkAllConfig.class);
            this.otherConfig = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, SdkCommonConfig.ADAPTER);
        }

        public SdkAllConfig decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.sdkSendCmdConfig((SdkSendCmdConfig) SdkSendCmdConfig.ADAPTER.decode(r7));
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.otherConfig.putAll((Map) this.otherConfig.decode(r7));
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SdkAllConfig r5) {
            return (SdkSendCmdConfig.ADAPTER.encodedSizeWithTag(1, r5.sdkSendCmdConfig) + this.otherConfig.encodedSizeWithTag(2, r5.otherConfig)) + r5.unknownFields().size();
        }

        public SdkAllConfig redact(SdkAllConfig r3) {
            Builder r4 = r3.newBuilder();
            SdkSendCmdConfig r0 = r4.sdkSendCmdConfig;
            if (r0 == null) goto L5;
            r4.sdkSendCmdConfig = (SdkSendCmdConfig) SdkSendCmdConfig.ADAPTER.redact(r0);
        L5:
            Internal.redactElements(r4.otherConfig, SdkCommonConfig.ADAPTER);
            r4.clearUnknownFields();
            return r4.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m162decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SdkAllConfig) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SdkAllConfig) r1);
        }

        public void encode(ProtoWriter r4, SdkAllConfig r5) throws IOException {
            SdkSendCmdConfig.ADAPTER.encodeWithTag(r4, 1, r5.sdkSendCmdConfig);
            this.otherConfig.encodeWithTag(r4, 2, r5.otherConfig);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SdkAllConfig) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SdkAllConfig();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L10;
        int r1 = unknownFields().hashCode() * 37;
        SdkSendCmdConfig r2 = this.sdkSendCmdConfig;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        int r4 = ((r1 + r3) * 37) + this.otherConfig.hashCode();
        ((Message) this).hashCode = r4;
        return r4;
    L7:
        r3 = 0;
        goto L8
    L10:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.sdkSendCmdConfig = this.sdkSendCmdConfig;
        r0.otherConfig = Internal.copyOf("otherConfig", this.otherConfig);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.sdkSendCmdConfig == null) goto L5;
        r0.append(", sdkSendCmdConfig=");
        r0.append(this.sdkSendCmdConfig);
    L5:
        Map<String, SdkCommonConfig> r1 = this.otherConfig;
        if (r1 != null) goto L8;
    L10:
        StringBuilder r2 = r0.replace(0, 2, "SdkAllConfig{");
        r2.append('}');
        return r2.toString();
    L8:
        if (r1.isEmpty() == true) goto L10;
        r0.append(", otherConfig=");
        r0.append(this.otherConfig);
        goto L10
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m160newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkAllConfig) == true) goto L8;
        return false;
    L8:
        SdkAllConfig r6 = (SdkAllConfig) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L15:
        return false;
    L11:
        if (Internal.equals(this.sdkSendCmdConfig, r6.sdkSendCmdConfig) == false) goto L15;
        if (this.otherConfig.equals(r6.otherConfig) == false) goto L15;
        return true;
    }

    public SdkAllConfig(SdkSendCmdConfig r2, Map<String, SdkCommonConfig> r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public SdkAllConfig(SdkSendCmdConfig r2, Map<String, SdkCommonConfig> r3, ByteString r4) {
        super(ADAPTER, r4);
        this.sdkSendCmdConfig = r2;
        this.otherConfig = Internal.immutableCopyOf("otherConfig", r3);
    }
}
