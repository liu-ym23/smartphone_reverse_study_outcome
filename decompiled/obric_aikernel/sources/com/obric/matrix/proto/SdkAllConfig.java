package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import d6.c;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class SdkAllConfig extends Message<SdkAllConfig, a> {
    public static final ProtoAdapter<SdkAllConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.obric.matrix.proto.SdkCommonConfig#ADAPTER", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    @c("otherConfig")
    public final Map<String, SdkCommonConfig> otherConfig;

    @WireField(adapter = "com.obric.matrix.proto.SdkSendCmdConfig#ADAPTER", tag = 1)
    @c("sdkSendCmdConfig")
    public final SdkSendCmdConfig sdkSendCmdConfig;

    public static final class a extends Message.Builder<SdkAllConfig, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SdkSendCmdConfig f6072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, SdkCommonConfig> f6073b;

        public a() {
            this.f6073b = Internal.newMutableMap();
        }

        public SdkAllConfig a() {
            return new SdkAllConfig(this.f6072a, this.f6073b, super.buildUnknownFields());
        }

        public a b(SdkSendCmdConfig r10) {
            this.f6072a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<SdkAllConfig> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, SdkCommonConfig>> f6074a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkAllConfig.class);
            this.f6074a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, SdkCommonConfig.ADAPTER);
        }

        public SdkAllConfig a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L12;
            if (r13 != 1) goto L8;
            r11.b(SdkSendCmdConfig.ADAPTER.decode(r10));
            goto L3
        L8:
            if (r13 != 2) goto L9;
            r11.f6073b.putAll(this.f6074a.decode(r10));
            goto L3
        L9:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L12:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, SdkAllConfig r11) {
            SdkSendCmdConfig.ADAPTER.encodeWithTag(r10, 1, r11.sdkSendCmdConfig);
            this.f6074a.encodeWithTag(r10, 2, r11.otherConfig);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(SdkAllConfig r10) {
            return (SdkSendCmdConfig.ADAPTER.encodedSizeWithTag(1, r10.sdkSendCmdConfig) + this.f6074a.encodedSizeWithTag(2, r10.otherConfig)) + r10.unknownFields().size();
        }

        public SdkAllConfig d(SdkAllConfig r10) {
            a r11 = r10.newBuilder();
            SdkSendCmdConfig r12 = r11.f6072a;
            if (r12 == null) goto L5;
            r11.f6072a = SdkSendCmdConfig.ADAPTER.redact(r12);
        L5:
            Internal.redactElements(r11.f6073b, SdkCommonConfig.ADAPTER);
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkAllConfig decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, SdkAllConfig r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkAllConfig r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkAllConfig redact(SdkAllConfig r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public SdkAllConfig(SdkSendCmdConfig r10, Map<String, SdkCommonConfig> r11) {
        this(r10, r11, ByteString.EMPTY);
    }

    public SdkAllConfig(SdkSendCmdConfig r10, Map<String, SdkCommonConfig> r11, ByteString r12) {
        super(ADAPTER, r12);
        this.sdkSendCmdConfig = r10;
        this.otherConfig = Internal.immutableCopyOf("otherConfig", r11);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SdkAllConfig) == true) goto L8;
        return false;
    L8:
        SdkAllConfig r11 = (SdkAllConfig) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L16;
        if (Internal.equals(this.sdkSendCmdConfig, r11.sdkSendCmdConfig) == false) goto L16;
        if (this.otherConfig.equals(r11.otherConfig) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L10;
        int r11 = unknownFields().hashCode() * 37;
        SdkSendCmdConfig r12 = this.sdkSendCmdConfig;
        if (r12 == null) goto L7;
        int r13 = r12.hashCode();
    L8:
        int r14 = ((r11 + r13) * 37) + this.otherConfig.hashCode();
        this.hashCode = r14;
        return r14;
    L7:
        r13 = 0;
        goto L8
    L10:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f6072a = this.sdkSendCmdConfig;
        r10.f6073b = Internal.copyOf("otherConfig", this.otherConfig);
        r10.addUnknownFields(unknownFields());
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.sdkSendCmdConfig == null) goto L5;
        r10.append(", sdkSendCmdConfig=");
        r10.append(this.sdkSendCmdConfig);
    L5:
        Map<String, SdkCommonConfig> r11 = this.otherConfig;
        if (r11 != null) goto L8;
    L10:
        StringBuilder r12 = r10.replace(0, 2, "SdkAllConfig{");
        r12.append('}');
        return r12.toString();
    L8:
        if (r11.isEmpty() == true) goto L10;
        r10.append(", otherConfig=");
        r10.append(this.otherConfig);
        goto L10
    }
}
