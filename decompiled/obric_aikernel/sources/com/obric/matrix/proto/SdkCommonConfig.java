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
public final class SdkCommonConfig extends Message<SdkCommonConfig, a> {
    public static final ProtoAdapter<SdkCommonConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    @c("configs")
    public final Map<String, String> configs;

    public static final class a extends Message.Builder<SdkCommonConfig, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, String> f6075a;

        public a() {
            this.f6075a = Internal.newMutableMap();
        }

        public SdkCommonConfig a() {
            return new SdkCommonConfig(this.f6075a, super.buildUnknownFields());
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<SdkCommonConfig> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f6076a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkCommonConfig.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f6076a = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public SdkCommonConfig a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L9;
            if (r13 != 1) goto L7;
            r11.f6075a.putAll(this.f6076a.decode(r10));
            goto L3
        L7:
            FieldEncoding r14 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r14, r14.rawProtoAdapter().decode(r10));
            goto L3
        L9:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, SdkCommonConfig r11) {
            this.f6076a.encodeWithTag(r10, 1, r11.configs);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(SdkCommonConfig r10) {
            return this.f6076a.encodedSizeWithTag(1, r10.configs) + r10.unknownFields().size();
        }

        public SdkCommonConfig d(SdkCommonConfig r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkCommonConfig decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, SdkCommonConfig r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkCommonConfig r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkCommonConfig redact(SdkCommonConfig r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
    }

    public SdkCommonConfig(Map<String, String> r10) {
        this(r10, ByteString.EMPTY);
    }

    public SdkCommonConfig(Map<String, String> r10, ByteString r11) {
        super(ADAPTER, r11);
        this.configs = Internal.immutableCopyOf("configs", r10);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SdkCommonConfig) == true) goto L8;
        return false;
    L8:
        SdkCommonConfig r11 = (SdkCommonConfig) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L14;
        if (this.configs.equals(r11.configs) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L6;
        int r11 = (unknownFields().hashCode() * 37) + this.configs.hashCode();
        this.hashCode = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f6075a = Internal.copyOf("configs", this.configs);
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
        Map<String, String> r11 = this.configs;
        if (r11 != null) goto L5;
    L7:
        StringBuilder r12 = r10.replace(0, 2, "SdkCommonConfig{");
        r12.append('}');
        return r12.toString();
    L5:
        if (r11.isEmpty() == true) goto L7;
        r10.append(", configs=");
        r10.append(this.configs);
        goto L7
    }
}
