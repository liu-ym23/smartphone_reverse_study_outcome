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

        public Builder() {
            this.otherConfig = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder otherConfig(Map<String, SdkCommonConfig> r5) {
            Internal.checkElementsNotNull(r5);
            this.otherConfig = r5;
            return this;
        }

        public Builder sdkSendCmdConfig(SdkSendCmdConfig r5) {
            this.sdkSendCmdConfig = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SdkAllConfig build() {
            return new SdkAllConfig(this.sdkSendCmdConfig, this.otherConfig, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SdkAllConfig extends ProtoAdapter<SdkAllConfig> {
        private final ProtoAdapter<Map<String, SdkCommonConfig>> otherConfig;

        public ProtoAdapter_SdkAllConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkAllConfig.class);
            this.otherConfig = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, SdkCommonConfig.ADAPTER);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkAllConfig decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, SdkAllConfig r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkAllConfig r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkAllConfig redact(SdkAllConfig r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkAllConfig decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L12;
            if (r12 != 1) goto L8;
            r5.sdkSendCmdConfig(SdkSendCmdConfig.ADAPTER.decode(r10));
            goto L3
        L8:
            if (r12 != 2) goto L9;
            r5.otherConfig.putAll(this.otherConfig.decode(r10));
            goto L3
        L9:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L12:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, SdkAllConfig r10) throws IOException {
            SdkSendCmdConfig.ADAPTER.encodeWithTag(r5, 1, r10.sdkSendCmdConfig);
            this.otherConfig.encodeWithTag(r5, 2, r10.otherConfig);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SdkAllConfig r5) {
            int r10 = SdkSendCmdConfig.ADAPTER.encodedSizeWithTag(1, r5.sdkSendCmdConfig);
            int r11 = this.otherConfig.encodedSizeWithTag(2, r5.otherConfig) + r10;
            return r5.unknownFields().size() + r11;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SdkAllConfig redact2(SdkAllConfig r5) {
            Builder r10 = r5.newBuilder();
            SdkSendCmdConfig r11 = r10.sdkSendCmdConfig;
            if (r11 == null) goto L5;
            r10.sdkSendCmdConfig = SdkSendCmdConfig.ADAPTER.redact(r11);
        L5:
            Internal.redactElements(r10.otherConfig, SdkCommonConfig.ADAPTER);
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SdkAllConfig();
    }

    public SdkAllConfig(SdkSendCmdConfig r5, Map<String, SdkCommonConfig> r10) {
        this(r5, r10, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkAllConfig) == true) goto L8;
        return false;
    L8:
        SdkAllConfig r10 = (SdkAllConfig) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L16;
        if (Internal.equals(this.sdkSendCmdConfig, r10.sdkSendCmdConfig) == false) goto L16;
        if (this.otherConfig.equals(r10.otherConfig) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L10;
        int r10 = unknownFields().hashCode() * 37;
        SdkSendCmdConfig r11 = this.sdkSendCmdConfig;
        if (r11 == null) goto L7;
        int r12 = r11.hashCode();
    L8:
        int r13 = ((r10 + r12) * 37) + this.otherConfig.hashCode();
        this.hashCode = r13;
        return r13;
    L7:
        r12 = 0;
        goto L8
    L10:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.sdkSendCmdConfig == null) goto L5;
        r5.append(", sdkSendCmdConfig=");
        r5.append(this.sdkSendCmdConfig);
    L5:
        Map<String, SdkCommonConfig> r10 = this.otherConfig;
        if (r10 == null) goto L11;
        if (r10.isEmpty() == true) goto L11;
        r5.append(", otherConfig=");
        r5.append(this.otherConfig);
    L11:
        return a.s(r5, 0, 2, "SdkAllConfig{", '}');
    }

    public SdkAllConfig(SdkSendCmdConfig r5, Map<String, SdkCommonConfig> r10, ByteString r11) {
        super(ADAPTER, r11);
        this.sdkSendCmdConfig = r5;
        this.otherConfig = Internal.immutableCopyOf("otherConfig", r10);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.sdkSendCmdConfig = this.sdkSendCmdConfig;
        r5.otherConfig = Internal.copyOf("otherConfig", this.otherConfig);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
