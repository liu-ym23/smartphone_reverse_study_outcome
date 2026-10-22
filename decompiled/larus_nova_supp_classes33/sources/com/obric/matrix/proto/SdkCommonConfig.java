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
public final class SdkCommonConfig extends Message<SdkCommonConfig, Builder> {
    public static final ProtoAdapter<SdkCommonConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @SerializedName("configs")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final Map<String, String> configs;

    public static final class Builder extends Message.Builder<SdkCommonConfig, Builder> {
        public Map<String, String> configs;

        public SdkCommonConfig build() {
            return new SdkCommonConfig(this.configs, super.buildUnknownFields());
        }

        public Builder() {
            this.configs = Internal.newMutableMap();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m164build() {
            return build();
        }

        public Builder configs(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.configs = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SdkCommonConfig extends ProtoAdapter<SdkCommonConfig> {
        private final ProtoAdapter<Map<String, String>> configs;

        public ProtoAdapter_SdkCommonConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkCommonConfig.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.configs = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public SdkCommonConfig decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.configs.putAll((Map) this.configs.decode(r7));
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SdkCommonConfig r4) {
            return this.configs.encodedSizeWithTag(1, r4.configs) + r4.unknownFields().size();
        }

        public SdkCommonConfig redact(SdkCommonConfig r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m165decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SdkCommonConfig) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SdkCommonConfig) r1);
        }

        public void encode(ProtoWriter r4, SdkCommonConfig r5) throws IOException {
            this.configs.encodeWithTag(r4, 1, r5.configs);
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SdkCommonConfig) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SdkCommonConfig();
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
        if (r0 != 0) goto L6;
        int r1 = (unknownFields().hashCode() * 37) + this.configs.hashCode();
        ((Message) this).hashCode = r1;
        return r1;
    L6:
        return r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.configs = Internal.copyOf("configs", this.configs);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Map<String, String> r1 = this.configs;
        if (r1 != null) goto L5;
    L7:
        StringBuilder r2 = r0.replace(0, 2, "SdkCommonConfig{");
        r2.append('}');
        return r2.toString();
    L5:
        if (r1.isEmpty() == true) goto L7;
        r0.append(", configs=");
        r0.append(this.configs);
        goto L7
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m163newBuilder() {
        return newBuilder();
    }

    public SdkCommonConfig(Map<String, String> r2) {
        this(r2, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkCommonConfig) == true) goto L8;
        return false;
    L8:
        SdkCommonConfig r6 = (SdkCommonConfig) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.configs.equals(r6.configs) == false) goto L13;
        return true;
    }

    public SdkCommonConfig(Map<String, String> r2, ByteString r3) {
        super(ADAPTER, r3);
        this.configs = Internal.immutableCopyOf("configs", r2);
    }
}
