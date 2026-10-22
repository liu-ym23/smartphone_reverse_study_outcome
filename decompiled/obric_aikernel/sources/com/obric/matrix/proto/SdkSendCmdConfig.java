package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import d6.c;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class SdkSendCmdConfig extends Message<SdkSendCmdConfig, a> {
    public static final ProtoAdapter<SdkSendCmdConfig> ADAPTER = null;
    public static final Boolean DEFAULT_ISALLUSEBIND = null;
    public static final Integer DEFAULT_MINSUPPORTINTENTSERVICEVERSION = null;
    public static final Integer DEFAULT_POLLINGINTERVAL = null;
    public static final Integer DEFAULT_SENDCMDTIMEOUT = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    @c("extraConfigs")
    public final Map<String, String> extraConfigs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 7)
    @c("forceUseOldBindCmd")
    public final List<Integer> forceUseOldBindCmd;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    @c("isAllUseBind")
    public final Boolean isAllUseBind;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    @c("minSupportIntentServiceVersion")
    public final Integer minSupportIntentServiceVersion;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    @c("pollingInterval")
    public final Integer pollingInterval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    @c("sendCmdTimeout")
    public final Integer sendCmdTimeout;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 3)
    @c("useBindCmd")
    public final List<Integer> useBindCmd;

    public static final class a extends Message.Builder<SdkSendCmdConfig, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f6084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f6085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<Integer> f6086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f6087d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f6088e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Map<String, String> f6089f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<Integer> f6090g;

        public a() {
            this.f6084a = Boolean.FALSE;
            this.f6085b = 0;
            this.f6087d = 0;
            this.f6088e = 0;
            this.f6086c = Internal.newMutableList();
            this.f6089f = Internal.newMutableMap();
            this.f6090g = Internal.newMutableList();
        }

        public SdkSendCmdConfig a() {
            return new SdkSendCmdConfig(this.f6084a, this.f6085b, this.f6086c, this.f6087d, this.f6088e, this.f6089f, this.f6090g, super.buildUnknownFields());
        }

        public a b(Boolean r10) {
            this.f6084a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r10) {
            this.f6085b = r10;
            return this;
        }

        public a d(Integer r10) {
            this.f6088e = r10;
            return this;
        }

        public a e(Integer r10) {
            this.f6087d = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<SdkSendCmdConfig> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f6091a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkSendCmdConfig.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f6091a = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public SdkSendCmdConfig a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L15;
            switch(r13) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            List<Integer> r14 = r11.f6090g;
        L12:
            r14.add(ProtoAdapter.INT32.decode(r10));
            goto L3
        L8:
            r11.f6089f.putAll(this.f6091a.decode(r10));
            goto L3
        L9:
            r11.d(ProtoAdapter.INT32.decode(r10));
            goto L3
        L10:
            r11.e(ProtoAdapter.INT32.decode(r10));
            goto L3
        L11:
            r14 = r11.f6086c;
            goto L12
        L13:
            r11.c(ProtoAdapter.INT32.decode(r10));
            goto L3
        L14:
            r11.b(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L6:
            FieldEncoding r15 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r15, r15.rawProtoAdapter().decode(r10));
            goto L3
        L15:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, SdkSendCmdConfig r11) {
            ProtoAdapter.BOOL.encodeWithTag(r10, 1, r11.isAllUseBind);
            ProtoAdapter<Integer> r12 = ProtoAdapter.INT32;
            r12.encodeWithTag(r10, 2, r11.minSupportIntentServiceVersion);
            r12.asRepeated().encodeWithTag(r10, 3, r11.useBindCmd);
            r12.encodeWithTag(r10, 4, r11.sendCmdTimeout);
            r12.encodeWithTag(r10, 5, r11.pollingInterval);
            this.f6091a.encodeWithTag(r10, 6, r11.extraConfigs);
            r12.asRepeated().encodeWithTag(r10, 7, r11.forceUseOldBindCmd);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(SdkSendCmdConfig r10) {
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r10.isAllUseBind);
            ProtoAdapter<Integer> r12 = ProtoAdapter.INT32;
            return ((((((r11 + r12.encodedSizeWithTag(2, r10.minSupportIntentServiceVersion)) + r12.asRepeated().encodedSizeWithTag(3, r10.useBindCmd)) + r12.encodedSizeWithTag(4, r10.sendCmdTimeout)) + r12.encodedSizeWithTag(5, r10.pollingInterval)) + this.f6091a.encodedSizeWithTag(6, r10.extraConfigs)) + r12.asRepeated().encodedSizeWithTag(7, r10.forceUseOldBindCmd)) + r10.unknownFields().size();
        }

        public SdkSendCmdConfig d(SdkSendCmdConfig r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkSendCmdConfig decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, SdkSendCmdConfig r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkSendCmdConfig r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkSendCmdConfig redact(SdkSendCmdConfig r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_ISALLUSEBIND = Boolean.FALSE;
        DEFAULT_MINSUPPORTINTENTSERVICEVERSION = 0;
        DEFAULT_SENDCMDTIMEOUT = 0;
        DEFAULT_POLLINGINTERVAL = 0;
    }

    public SdkSendCmdConfig(Boolean r10, Integer r11, List<Integer> r12, Integer r13, Integer r14, Map<String, String> r15, List<Integer> r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public SdkSendCmdConfig(Boolean r10, Integer r11, List<Integer> r12, Integer r13, Integer r14, Map<String, String> r15, List<Integer> r16, ByteString r17) {
        super(ADAPTER, r17);
        this.isAllUseBind = r10;
        this.minSupportIntentServiceVersion = r11;
        this.useBindCmd = Internal.immutableCopyOf("useBindCmd", r12);
        this.sendCmdTimeout = r13;
        this.pollingInterval = r14;
        this.extraConfigs = Internal.immutableCopyOf("extraConfigs", r15);
        this.forceUseOldBindCmd = Internal.immutableCopyOf("forceUseOldBindCmd", r16);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SdkSendCmdConfig) == true) goto L8;
        return false;
    L8:
        SdkSendCmdConfig r11 = (SdkSendCmdConfig) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L26;
        if (Internal.equals(this.isAllUseBind, r11.isAllUseBind) == false) goto L26;
        if (Internal.equals(this.minSupportIntentServiceVersion, r11.minSupportIntentServiceVersion) == false) goto L26;
        if (this.useBindCmd.equals(r11.useBindCmd) == false) goto L26;
        if (Internal.equals(this.sendCmdTimeout, r11.sendCmdTimeout) == false) goto L26;
        if (Internal.equals(this.pollingInterval, r11.pollingInterval) == false) goto L26;
        if (this.extraConfigs.equals(r11.extraConfigs) == false) goto L26;
        if (this.forceUseOldBindCmd.equals(r11.forceUseOldBindCmd) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L21;
        int r11 = unknownFields().hashCode() * 37;
        Boolean r12 = this.isAllUseBind;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (r11 + r14) * 37;
        Integer r16 = this.minSupportIntentServiceVersion;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (((r15 + r17) * 37) + this.useBindCmd.hashCode()) * 37;
        Integer r19 = this.sendCmdTimeout;
        if (r19 == null) goto L15;
        int r20 = r19.hashCode();
    L16:
        int r21 = (r18 + r20) * 37;
        Integer r22 = this.pollingInterval;
        if (r22 == null) goto L19;
        r13 = r22.hashCode();
    L19:
        int r23 = ((((r21 + r13) * 37) + this.extraConfigs.hashCode()) * 37) + this.forceUseOldBindCmd.hashCode();
        this.hashCode = r23;
        return r23;
    L15:
        r20 = 0;
        goto L16
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L21:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f6084a = this.isAllUseBind;
        r10.f6085b = this.minSupportIntentServiceVersion;
        r10.f6086c = Internal.copyOf("useBindCmd", this.useBindCmd);
        r10.f6087d = this.sendCmdTimeout;
        r10.f6088e = this.pollingInterval;
        r10.f6089f = Internal.copyOf("extraConfigs", this.extraConfigs);
        r10.f6090g = Internal.copyOf("forceUseOldBindCmd", this.forceUseOldBindCmd);
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
        if (this.isAllUseBind == null) goto L6;
        r10.append(", isAllUseBind=");
        r10.append(this.isAllUseBind);
    L6:
        if (this.minSupportIntentServiceVersion == null) goto L8;
        r10.append(", minSupportIntentServiceVersion=");
        r10.append(this.minSupportIntentServiceVersion);
    L8:
        List<Integer> r11 = this.useBindCmd;
        if (r11 == null) goto L14;
        if (r11.isEmpty() == true) goto L14;
        r10.append(", useBindCmd=");
        r10.append(this.useBindCmd);
    L14:
        if (this.sendCmdTimeout == null) goto L17;
        r10.append(", sendCmdTimeout=");
        r10.append(this.sendCmdTimeout);
    L17:
        if (this.pollingInterval == null) goto L19;
        r10.append(", pollingInterval=");
        r10.append(this.pollingInterval);
    L19:
        Map<String, String> r12 = this.extraConfigs;
        if (r12 != null) goto L22;
    L24:
        List<Integer> r13 = this.forceUseOldBindCmd;
        if (r13 != null) goto L27;
    L29:
        StringBuilder r14 = r10.replace(0, 2, "SdkSendCmdConfig{");
        r14.append('}');
        return r14.toString();
    L27:
        if (r13.isEmpty() == true) goto L29;
        r10.append(", forceUseOldBindCmd=");
        r10.append(this.forceUseOldBindCmd);
        goto L29
    L22:
        if (r12.isEmpty() == true) goto L24;
        r10.append(", extraConfigs=");
        r10.append(this.extraConfigs);
        goto L24
    }
}
