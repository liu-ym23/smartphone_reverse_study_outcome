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
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class SdkSendCmdConfig extends Message<SdkSendCmdConfig, Builder> {
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

    public static final class Builder extends Message.Builder<SdkSendCmdConfig, Builder> {
        public Map<String, String> extraConfigs;
        public List<Integer> forceUseOldBindCmd;
        public Boolean isAllUseBind;
        public Integer minSupportIntentServiceVersion;
        public Integer pollingInterval;
        public Integer sendCmdTimeout;
        public List<Integer> useBindCmd;

        public Builder() {
            this.isAllUseBind = Boolean.FALSE;
            this.minSupportIntentServiceVersion = 0;
            this.sendCmdTimeout = 0;
            this.pollingInterval = 0;
            this.useBindCmd = Internal.newMutableList();
            this.extraConfigs = Internal.newMutableMap();
            this.forceUseOldBindCmd = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder extraConfigs(Map<String, String> r5) {
            Internal.checkElementsNotNull(r5);
            this.extraConfigs = r5;
            return this;
        }

        public Builder forceUseOldBindCmd(List<Integer> r5) {
            Internal.checkElementsNotNull(r5);
            this.forceUseOldBindCmd = r5;
            return this;
        }

        public Builder isAllUseBind(Boolean r5) {
            this.isAllUseBind = r5;
            return this;
        }

        public Builder minSupportIntentServiceVersion(Integer r5) {
            this.minSupportIntentServiceVersion = r5;
            return this;
        }

        public Builder pollingInterval(Integer r5) {
            this.pollingInterval = r5;
            return this;
        }

        public Builder sendCmdTimeout(Integer r5) {
            this.sendCmdTimeout = r5;
            return this;
        }

        public Builder useBindCmd(List<Integer> r5) {
            Internal.checkElementsNotNull(r5);
            this.useBindCmd = r5;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SdkSendCmdConfig build() {
            return new SdkSendCmdConfig(this.isAllUseBind, this.minSupportIntentServiceVersion, this.useBindCmd, this.sendCmdTimeout, this.pollingInterval, this.extraConfigs, this.forceUseOldBindCmd, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SdkSendCmdConfig extends ProtoAdapter<SdkSendCmdConfig> {
        private final ProtoAdapter<Map<String, String>> extraConfigs;

        public ProtoAdapter_SdkSendCmdConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkSendCmdConfig.class);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            this.extraConfigs = ProtoAdapter.newMapAdapter(r5, r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkSendCmdConfig decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, SdkSendCmdConfig r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkSendCmdConfig r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkSendCmdConfig redact(SdkSendCmdConfig r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkSendCmdConfig decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L14;
            switch(r12) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r5.forceUseOldBindCmd.add(ProtoAdapter.INT32.decode(r10));
            goto L3
        L8:
            r5.extraConfigs.putAll(this.extraConfigs.decode(r10));
            goto L3
        L9:
            r5.pollingInterval(ProtoAdapter.INT32.decode(r10));
            goto L3
        L10:
            r5.sendCmdTimeout(ProtoAdapter.INT32.decode(r10));
            goto L3
        L11:
            r5.useBindCmd.add(ProtoAdapter.INT32.decode(r10));
            goto L3
        L12:
            r5.minSupportIntentServiceVersion(ProtoAdapter.INT32.decode(r10));
            goto L3
        L13:
            r5.isAllUseBind(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L6:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L14:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, SdkSendCmdConfig r10) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r5, 1, r10.isAllUseBind);
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            r11.encodeWithTag(r5, 2, r10.minSupportIntentServiceVersion);
            r11.asRepeated().encodeWithTag(r5, 3, r10.useBindCmd);
            r11.encodeWithTag(r5, 4, r10.sendCmdTimeout);
            r11.encodeWithTag(r5, 5, r10.pollingInterval);
            this.extraConfigs.encodeWithTag(r5, 6, r10.extraConfigs);
            r11.asRepeated().encodeWithTag(r5, 7, r10.forceUseOldBindCmd);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SdkSendCmdConfig r10) {
            int r5 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r10.isAllUseBind);
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            int r12 = r11.encodedSizeWithTag(2, r10.minSupportIntentServiceVersion) + r5;
            int r13 = r11.asRepeated().encodedSizeWithTag(3, r10.useBindCmd) + r12;
            int r14 = r11.encodedSizeWithTag(4, r10.sendCmdTimeout) + r13;
            int r15 = r11.encodedSizeWithTag(5, r10.pollingInterval) + r14;
            int r16 = this.extraConfigs.encodedSizeWithTag(6, r10.extraConfigs) + r15;
            int r17 = r11.asRepeated().encodedSizeWithTag(7, r10.forceUseOldBindCmd) + r16;
            return r10.unknownFields().size() + r17;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SdkSendCmdConfig redact2(SdkSendCmdConfig r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SdkSendCmdConfig();
        DEFAULT_ISALLUSEBIND = Boolean.FALSE;
        DEFAULT_MINSUPPORTINTENTSERVICEVERSION = 0;
        DEFAULT_SENDCMDTIMEOUT = 0;
        DEFAULT_POLLINGINTERVAL = 0;
    }

    public SdkSendCmdConfig(Boolean r10, Integer r11, List<Integer> r12, Integer r13, Integer r14, Map<String, String> r15, List<Integer> r16) {
        this(r10, r11, r12, r13, r14, r15, r16, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkSendCmdConfig) == true) goto L8;
        return false;
    L8:
        SdkSendCmdConfig r10 = (SdkSendCmdConfig) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L26;
        if (Internal.equals(this.isAllUseBind, r10.isAllUseBind) == false) goto L26;
        if (Internal.equals(this.minSupportIntentServiceVersion, r10.minSupportIntentServiceVersion) == false) goto L26;
        if (this.useBindCmd.equals(r10.useBindCmd) == false) goto L26;
        if (Internal.equals(this.sendCmdTimeout, r10.sendCmdTimeout) == false) goto L26;
        if (Internal.equals(this.pollingInterval, r10.pollingInterval) == false) goto L26;
        if (this.extraConfigs.equals(r10.extraConfigs) == false) goto L26;
        if (this.forceUseOldBindCmd.equals(r10.forceUseOldBindCmd) == false) goto L26;
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L21;
        int r10 = unknownFields().hashCode() * 37;
        Boolean r11 = this.isAllUseBind;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (r10 + r13) * 37;
        Integer r15 = this.minSupportIntentServiceVersion;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (this.useBindCmd.hashCode() + ((r14 + r16) * 37)) * 37;
        Integer r18 = this.sendCmdTimeout;
        if (r18 == null) goto L15;
        int r19 = r18.hashCode();
    L16:
        int r20 = (r17 + r19) * 37;
        Integer r21 = this.pollingInterval;
        if (r21 == null) goto L19;
        r12 = r21.hashCode();
    L19:
        int r22 = ((this.extraConfigs.hashCode() + ((r20 + r12) * 37)) * 37) + this.forceUseOldBindCmd.hashCode();
        this.hashCode = r22;
        return r22;
    L15:
        r19 = 0;
        goto L16
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L21:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.isAllUseBind == null) goto L6;
        r5.append(", isAllUseBind=");
        r5.append(this.isAllUseBind);
    L6:
        if (this.minSupportIntentServiceVersion == null) goto L8;
        r5.append(", minSupportIntentServiceVersion=");
        r5.append(this.minSupportIntentServiceVersion);
    L8:
        List<Integer> r10 = this.useBindCmd;
        if (r10 == null) goto L14;
        if (r10.isEmpty() == true) goto L14;
        r5.append(", useBindCmd=");
        r5.append(this.useBindCmd);
    L14:
        if (this.sendCmdTimeout == null) goto L17;
        r5.append(", sendCmdTimeout=");
        r5.append(this.sendCmdTimeout);
    L17:
        if (this.pollingInterval == null) goto L19;
        r5.append(", pollingInterval=");
        r5.append(this.pollingInterval);
    L19:
        Map<String, String> r11 = this.extraConfigs;
        if (r11 != null) goto L22;
    L24:
        List<Integer> r12 = this.forceUseOldBindCmd;
        if (r12 == null) goto L30;
        if (r12.isEmpty() == true) goto L30;
        r5.append(", forceUseOldBindCmd=");
        r5.append(this.forceUseOldBindCmd);
    L30:
        return a.s(r5, 0, 2, "SdkSendCmdConfig{", '}');
    L22:
        if (r11.isEmpty() == true) goto L24;
        r5.append(", extraConfigs=");
        r5.append(this.extraConfigs);
        goto L24
    }

    public SdkSendCmdConfig(Boolean r5, Integer r10, List<Integer> r11, Integer r12, Integer r13, Map<String, String> r14, List<Integer> r15, ByteString r16) {
        super(ADAPTER, r16);
        this.isAllUseBind = r5;
        this.minSupportIntentServiceVersion = r10;
        this.useBindCmd = Internal.immutableCopyOf("useBindCmd", r11);
        this.sendCmdTimeout = r12;
        this.pollingInterval = r13;
        this.extraConfigs = Internal.immutableCopyOf("extraConfigs", r14);
        this.forceUseOldBindCmd = Internal.immutableCopyOf("forceUseOldBindCmd", r15);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.isAllUseBind = this.isAllUseBind;
        r5.minSupportIntentServiceVersion = this.minSupportIntentServiceVersion;
        r5.useBindCmd = Internal.copyOf("useBindCmd", this.useBindCmd);
        r5.sendCmdTimeout = this.sendCmdTimeout;
        r5.pollingInterval = this.pollingInterval;
        r5.extraConfigs = Internal.copyOf("extraConfigs", this.extraConfigs);
        r5.forceUseOldBindCmd = Internal.copyOf("forceUseOldBindCmd", this.forceUseOldBindCmd);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
