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
public final class SdkConfigItems extends Message<SdkConfigItems, a> {
    public static final ProtoAdapter<SdkConfigItems> ADAPTER = null;
    public static final Boolean DEFAULT_ISALLUSEBIND = null;
    public static final Integer DEFAULT_POLLINGINTERVAL = null;
    public static final Integer DEFAULT_SENDCMDTIMEOUT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("extraConfigs")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final Map<String, String> extraConfigs;

    @SerializedName("forceUseOldBindCmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 6)
    public final List<Integer> forceUseOldBindCmd;

    @SerializedName("isAllUseBind")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean isAllUseBind;

    @SerializedName("pollingInterval")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer pollingInterval;

    @SerializedName("sendCmdTimeout")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer sendCmdTimeout;

    @SerializedName("useBindCmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 2)
    public final List<Integer> useBindCmd;

    public static final class a extends Message.Builder<SdkConfigItems, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f8217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Integer> f8218b;
        public Integer c;
        public Integer d;
        public Map<String, String> e;
        public List<Integer> f;

        public a() {
            this.f8217a = false;
            this.c = 0;
            this.d = 0;
            this.f8218b = Internal.newMutableList();
            this.e = Internal.newMutableMap();
            this.f = Internal.newMutableList();
        }

        public a a(Boolean r1) {
            this.f8217a = r1;
            return this;
        }

        public a a(Integer r1) {
            this.c = r1;
            return this;
        }

        public SdkConfigItems a() {
            return new SdkConfigItems(this.f8217a, this.f8218b, this.c, this.d, this.e, this.f, super.buildUnknownFields());
        }

        public a b(Integer r1) {
            this.d = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* synthetic */ Message build() {
            return a();
        }
    }

    private static final class b extends ProtoAdapter<SdkConfigItems> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f8219a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkConfigItems.class);
            this.f8219a = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        public int a(SdkConfigItems r5) {
            return (((((ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.isAllUseBind) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(2, r5.useBindCmd)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r5.sendCmdTimeout)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r5.pollingInterval)) + this.f8219a.encodedSizeWithTag(5, r5.extraConfigs)) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(6, r5.forceUseOldBindCmd)) + r5.unknownFields().size();
        }

        public SdkConfigItems a(ProtoReader r8) {
            a r0 = new a();
            long r1 = r8.beginMessage();
        L3:
            int r3 = r8.nextTag();
            if (r3 == (-1)) goto L15;
            switch(r3) {
                case 1: goto L14;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                default: goto L7;
            };
        L8:
            List<Integer> r4 = r0.f;
        L13:
            r4.add((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L9:
            r0.e.putAll((Map) ZeusTransformUtils.preCheckCast(this.f8219a.decode(r8), Map.class, "com.obric.memorydata.plugin"));
            goto L3
        L10:
            r0.b((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L11:
            r0.a((Integer) ZeusTransformUtils.preCheckCast(ProtoAdapter.INT32.decode(r8), Integer.class, "com.obric.memorydata.plugin"));
            goto L3
        L12:
            r4 = r0.f8218b;
            goto L13
        L14:
            r0.a((Boolean) ZeusTransformUtils.preCheckCast(ProtoAdapter.BOOL.decode(r8), Boolean.class, "com.obric.memorydata.plugin"));
            goto L3
        L7:
            FieldEncoding r5 = r8.peekFieldEncoding();
            r0.addUnknownField(r3, r5, r5.rawProtoAdapter().decode(r8));
            goto L3
        L15:
            r8.endMessage(r1);
            return r0.a();
        }

        public void a(ProtoWriter r4, SdkConfigItems r5) {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.isAllUseBind);
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r4, 2, r5.useBindCmd);
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r5.sendCmdTimeout);
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r5.pollingInterval);
            this.f8219a.encodeWithTag(r4, 5, r5.extraConfigs);
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r4, 6, r5.forceUseOldBindCmd);
            r4.writeBytes(r5.unknownFields());
        }

        public SdkConfigItems b(SdkConfigItems r1) {
            a r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SdkConfigItems decode(ProtoReader r1) {
            return a(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ void encode(ProtoWriter r3, SdkConfigItems r4) {
            a(r3, (SdkConfigItems) ZeusTransformUtils.preCheckCast(r4, SdkConfigItems.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ int encodedSize(SdkConfigItems r3) {
            return a((SdkConfigItems) ZeusTransformUtils.preCheckCast(r3, SdkConfigItems.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* synthetic */ SdkConfigItems redact(SdkConfigItems r3) {
            return b((SdkConfigItems) ZeusTransformUtils.preCheckCast(r3, SdkConfigItems.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_ISALLUSEBIND = false;
        DEFAULT_SENDCMDTIMEOUT = 0;
        DEFAULT_POLLINGINTERVAL = 0;
    }

    public SdkConfigItems(Boolean r11, List<Integer> r12, Integer r13, Integer r14, Map<String, String> r15, List<Integer> r16) {
        this(r11, (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"), r13, r14, (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin"), ByteString.EMPTY);
    }

    public SdkConfigItems(Boolean r3, List<Integer> r4, Integer r5, Integer r6, Map<String, String> r7, List<Integer> r8, ByteString r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        super(ADAPTER, r9);
        this.isAllUseBind = r3;
        this.useBindCmd = Internal.immutableCopyOf("useBindCmd", r10);
        this.sendCmdTimeout = r5;
        this.pollingInterval = r6;
        this.extraConfigs = Internal.immutableCopyOf("extraConfigs", r11);
        this.forceUseOldBindCmd = Internal.immutableCopyOf("forceUseOldBindCmd", r12);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SdkConfigItems.class) == true) goto L8;
        return false;
    L8:
        SdkConfigItems r6 = (SdkConfigItems) ZeusTransformUtils.preCheckCast(r5, SdkConfigItems.class, "com.obric.memorydata.plugin");
        if (unknownFields().equals(r6.unknownFields()) == false) goto L24;
        if (Internal.equals(this.isAllUseBind, r6.isAllUseBind) == false) goto L24;
        if (this.useBindCmd.equals(r6.useBindCmd) == false) goto L24;
        if (Internal.equals(this.sendCmdTimeout, r6.sendCmdTimeout) == false) goto L24;
        if (Internal.equals(this.pollingInterval, r6.pollingInterval) == false) goto L24;
        if (this.extraConfigs.equals(r6.extraConfigs) == false) goto L24;
        if (this.forceUseOldBindCmd.equals(r6.forceUseOldBindCmd) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.isAllUseBind;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (((r1 + r4) * 37) + this.useBindCmd.hashCode()) * 37;
        Integer r6 = this.sendCmdTimeout;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.pollingInterval;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = ((((r8 + r3) * 37) + this.extraConfigs.hashCode()) * 37) + this.forceUseOldBindCmd.hashCode();
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.f8217a = this.isAllUseBind;
        r0.f8218b = Internal.copyOf("useBindCmd", this.useBindCmd);
        r0.c = this.sendCmdTimeout;
        r0.d = this.pollingInterval;
        r0.e = Internal.copyOf("extraConfigs", this.extraConfigs);
        r0.f = Internal.copyOf("forceUseOldBindCmd", this.forceUseOldBindCmd);
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
        if (this.isAllUseBind == null) goto L5;
        r0.append(", isAllUseBind=").append(this.isAllUseBind);
    L5:
        List<Integer> r1 = this.useBindCmd;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", useBindCmd=").append(this.useBindCmd);
    L11:
        if (this.sendCmdTimeout == null) goto L14;
        r0.append(", sendCmdTimeout=").append(this.sendCmdTimeout);
    L14:
        if (this.pollingInterval == null) goto L16;
        r0.append(", pollingInterval=").append(this.pollingInterval);
    L16:
        Map<String, String> r2 = this.extraConfigs;
        if (r2 != null) goto L19;
    L21:
        List<Integer> r3 = this.forceUseOldBindCmd;
        if (r3 == null) goto L27;
        if (r3.isEmpty() == true) goto L27;
        r0.append(", forceUseOldBindCmd=").append(this.forceUseOldBindCmd);
    L27:
        return r0.replace(0, 2, "SdkConfigItems{").append('}').toString();
    L19:
        if (r2.isEmpty() == true) goto L21;
        r0.append(", extraConfigs=").append(this.extraConfigs);
        goto L21
    }
}
