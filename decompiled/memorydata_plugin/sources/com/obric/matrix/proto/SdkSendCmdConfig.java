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
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class SdkSendCmdConfig extends Message<SdkSendCmdConfig, a> {
    public static final ProtoAdapter<SdkSendCmdConfig> ADAPTER = null;
    public static final Boolean DEFAULT_ISALLUSEBIND = null;
    public static final Integer DEFAULT_MINSUPPORTINTENTSERVICEVERSION = null;
    public static final Integer DEFAULT_POLLINGINTERVAL = null;
    public static final Integer DEFAULT_SENDCMDTIMEOUT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("extraConfigs")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final Map<String, String> extraConfigs;

    @SerializedName("forceUseOldBindCmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 7)
    public final List<Integer> forceUseOldBindCmd;

    @SerializedName("isAllUseBind")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean isAllUseBind;

    @SerializedName("minSupportIntentServiceVersion")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer minSupportIntentServiceVersion;

    @SerializedName("pollingInterval")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer pollingInterval;

    @SerializedName("sendCmdTimeout")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer sendCmdTimeout;

    @SerializedName("useBindCmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 3)
    public final List<Integer> useBindCmd;

    public static final class a extends Message.Builder<SdkSendCmdConfig, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f8220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f8221b;
        public List<Integer> c;
        public Integer d;
        public Integer e;
        public Map<String, String> f;
        public List<Integer> g;

        public a() {
            this.f8220a = false;
            this.f8221b = 0;
            this.d = 0;
            this.e = 0;
            this.c = Internal.newMutableList();
            this.f = Internal.newMutableMap();
            this.g = Internal.newMutableList();
        }

        public a a(Boolean r1) {
            this.f8220a = r1;
            return this;
        }

        public a a(Integer r1) {
            this.f8221b = r1;
            return this;
        }

        public SdkSendCmdConfig a() {
            return new SdkSendCmdConfig(this.f8220a, this.f8221b, this.c, this.d, this.e, this.f, this.g, super.buildUnknownFields());
        }

        public a b(Integer r1) {
            this.d = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r1) {
            this.e = r1;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<SdkSendCmdConfig> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8222a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkSendCmdConfig.class);
            this.f8222a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(SdkSendCmdConfig r5) {
            return ((((((ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.isAllUseBind) + ProtoAdapter.INT32.encodedSizeWithTag(2, r5.minSupportIntentServiceVersion)) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(3, r5.useBindCmd)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r5.sendCmdTimeout)) + ProtoAdapter.INT32.encodedSizeWithTag(5, r5.pollingInterval)) + this.f8222a.encodedSizeWithTag(6, r5.extraConfigs)) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(7, r5.forceUseOldBindCmd)) + r5.unknownFields().size();
        }

        public SdkSendCmdConfig a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L16;
            switch(r3) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                default: goto L7;
            };
        L8:
            List<Integer> r4 = r0.g;
        L13:
            r4.add((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            r0.f.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8222a.decode(r8), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            r0.c((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            r0.b((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            r4 = r0.c;
            goto L13
        L14:
            r0.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L15:
            r0.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r8), Boolean.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r5 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r5, r5.rawProtoAdapter().decode(r8));
            goto L3
        L16:
            r8.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, SdkSendCmdConfig r5) {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.isAllUseBind);
            ProtoAdapter.INT32.encodeWithTag(r4, 2, r5.minSupportIntentServiceVersion);
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r4, 3, r5.useBindCmd);
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r5.sendCmdTimeout);
            ProtoAdapter.INT32.encodeWithTag(r4, 5, r5.pollingInterval);
            this.f8222a.encodeWithTag(r4, 6, r5.extraConfigs);
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r4, 7, r5.forceUseOldBindCmd);
            r4.writeBytes(r5.unknownFields());
        }

        public SdkSendCmdConfig b(SdkSendCmdConfig r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SdkSendCmdConfig decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, SdkSendCmdConfig r4) {
            a(r3, (SdkSendCmdConfig) ZeusTransformUtils.preCheckCast(r4, SdkSendCmdConfig.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(SdkSendCmdConfig r3) {
            return a((SdkSendCmdConfig) ZeusTransformUtils.preCheckCast(r3, SdkSendCmdConfig.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SdkSendCmdConfig redact(SdkSendCmdConfig r3) {
            return b((SdkSendCmdConfig) ZeusTransformUtils.preCheckCast(r3, SdkSendCmdConfig.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_ISALLUSEBIND = false;
        DEFAULT_MINSUPPORTINTENTSERVICEVERSION = 0;
        DEFAULT_SENDCMDTIMEOUT = 0;
        DEFAULT_POLLINGINTERVAL = 0;
    }

    public SdkSendCmdConfig(Boolean r12, Integer r13, List<Integer> r14, Integer r15, Integer r16, Map<String, String> r17, List<Integer> r18) {
        this(r12, r13, (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin"), r15, r16, (Map) ZeusTransformUtils.wrapperContextForParams(r17, Map.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public SdkSendCmdConfig(Boolean r3, Integer r4, List<Integer> r5, Integer r6, Integer r7, Map<String, String> r8, List<Integer> r9, ByteString r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r10);
        this.isAllUseBind = r3;
        this.minSupportIntentServiceVersion = r4;
        this.useBindCmd = Internal.immutableCopyOf("useBindCmd", r11);
        this.sendCmdTimeout = r6;
        this.pollingInterval = r7;
        this.extraConfigs = Internal.immutableCopyOf("extraConfigs", r12);
        this.forceUseOldBindCmd = Internal.immutableCopyOf("forceUseOldBindCmd", r13);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SdkSendCmdConfig.class) == true) goto L8;
        return false;
    L8:
        SdkSendCmdConfig r6 = (SdkSendCmdConfig) ZeusTransformUtils.preCheckCast(r5, SdkSendCmdConfig.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L26;
        if (Internal.equals(this.isAllUseBind, r6.isAllUseBind) == false) goto L26;
        if (Internal.equals(this.minSupportIntentServiceVersion, r6.minSupportIntentServiceVersion) == false) goto L26;
        if (this.useBindCmd.equals(r6.useBindCmd) == false) goto L26;
        if (Internal.equals(this.sendCmdTimeout, r6.sendCmdTimeout) == false) goto L26;
        if (Internal.equals(this.pollingInterval, r6.pollingInterval) == false) goto L26;
        if (this.extraConfigs.equals(r6.extraConfigs) == false) goto L26;
        if (this.forceUseOldBindCmd.equals(r6.forceUseOldBindCmd) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L21;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.isAllUseBind;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Integer r6 = this.minSupportIntentServiceVersion;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (((r5 + r7) * 37) + this.useBindCmd.hashCode()) * 37;
        Integer r9 = this.sendCmdTimeout;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        Integer r12 = this.pollingInterval;
        if (r12 == null) goto L19;
        r3 = r12.hashCode();
    L19:
        int r13 = ((((r11 + r3) * 37) + this.extraConfigs.hashCode()) * 37) + this.forceUseOldBindCmd.hashCode();
        this.hashCode = r13;
        return r13;
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L21:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8220a = this.isAllUseBind;
        r0.f8221b = this.minSupportIntentServiceVersion;
        r0.c = Internal.copyOf("useBindCmd", this.useBindCmd);
        r0.d = this.sendCmdTimeout;
        r0.e = this.pollingInterval;
        r0.f = Internal.copyOf("extraConfigs", this.extraConfigs);
        r0.g = Internal.copyOf("forceUseOldBindCmd", this.forceUseOldBindCmd);
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
        if (this.isAllUseBind == null) goto L6;
        r0.append(", isAllUseBind=").append(this.isAllUseBind);
    L6:
        if (this.minSupportIntentServiceVersion == null) goto L8;
        r0.append(", minSupportIntentServiceVersion=").append(this.minSupportIntentServiceVersion);
    L8:
        List<Integer> r1 = this.useBindCmd;
        if (r1 == null) goto L14;
        if (r1.isEmpty() == true) goto L14;
        r0.append(", useBindCmd=").append(this.useBindCmd);
    L14:
        if (this.sendCmdTimeout == null) goto L17;
        r0.append(", sendCmdTimeout=").append(this.sendCmdTimeout);
    L17:
        if (this.pollingInterval == null) goto L19;
        r0.append(", pollingInterval=").append(this.pollingInterval);
    L19:
        Map<String, String> r2 = this.extraConfigs;
        if (r2 != null) goto L22;
    L24:
        List<Integer> r3 = this.forceUseOldBindCmd;
        if (r3 == null) goto L30;
        if (r3.isEmpty() == true) goto L30;
        r0.append(", forceUseOldBindCmd=").append(this.forceUseOldBindCmd);
    L30:
        return r0.replace(0, 2, "SdkSendCmdConfig{").append('}').toString();
    L22:
        if (r2.isEmpty() == true) goto L24;
        r0.append(", extraConfigs=").append(this.extraConfigs);
        goto L24
    }
}
