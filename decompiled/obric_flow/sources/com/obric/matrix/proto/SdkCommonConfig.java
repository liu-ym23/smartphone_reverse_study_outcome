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
public final class SdkCommonConfig extends Message<SdkCommonConfig, Builder> {
    public static final ProtoAdapter<SdkCommonConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("configs")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, String> configs;

    public static final class Builder extends Message.Builder<SdkCommonConfig, Builder> {
        public Map<String, String> configs;

        public Builder() {
            this.configs = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder configs(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.configs = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SdkCommonConfig build() {
            return new SdkCommonConfig(this.configs, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SdkCommonConfig extends ProtoAdapter<SdkCommonConfig> {
        private final ProtoAdapter<Map<String, String>> configs;

        public ProtoAdapter_SdkCommonConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkCommonConfig.class);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            this.configs = ProtoAdapter.newMapAdapter(r5, r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkCommonConfig decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, SdkCommonConfig r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkCommonConfig r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkCommonConfig redact(SdkCommonConfig r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkCommonConfig decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L9;
            if (r12 != 1) goto L7;
            r5.configs.putAll(this.configs.decode(r10));
            goto L3
        L7:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L9:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, SdkCommonConfig r10) throws IOException {
            this.configs.encodeWithTag(r5, 1, r10.configs);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SdkCommonConfig r5) {
            int r10 = this.configs.encodedSizeWithTag(1, r5.configs);
            return r5.unknownFields().size() + r10;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SdkCommonConfig redact2(SdkCommonConfig r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SdkCommonConfig();
    }

    public SdkCommonConfig(Map<String, String> r5) {
        this(r5, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkCommonConfig) == true) goto L8;
        return false;
    L8:
        SdkCommonConfig r10 = (SdkCommonConfig) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L14;
        if (this.configs.equals(r10.configs) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L6;
        int r10 = (unknownFields().hashCode() * 37) + this.configs.hashCode();
        this.hashCode = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        Map<String, String> r10 = this.configs;
        if (r10 == null) goto L8;
        if (r10.isEmpty() == true) goto L8;
        r5.append(", configs=");
        r5.append(this.configs);
    L8:
        return a.s(r5, 0, 2, "SdkCommonConfig{", '}');
    }

    public SdkCommonConfig(Map<String, String> r5, ByteString r10) {
        super(ADAPTER, r10);
        this.configs = Internal.immutableCopyOf("configs", r5);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.configs = Internal.copyOf("configs", this.configs);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
