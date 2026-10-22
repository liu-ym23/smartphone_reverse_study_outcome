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
public final class SdkConfigItems extends Message<SdkConfigItems, Builder> {
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

    public static final class Builder extends Message.Builder<SdkConfigItems, Builder> {
        public Map<String, String> extraConfigs;
        public List<Integer> forceUseOldBindCmd;
        public Boolean isAllUseBind;
        public Integer pollingInterval;
        public Integer sendCmdTimeout;
        public List<Integer> useBindCmd;

        public Builder() {
            this.isAllUseBind = Boolean.FALSE;
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
        public SdkConfigItems build() {
            return new SdkConfigItems(this.isAllUseBind, this.useBindCmd, this.sendCmdTimeout, this.pollingInterval, this.extraConfigs, this.forceUseOldBindCmd, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SdkConfigItems extends ProtoAdapter<SdkConfigItems> {
        private final ProtoAdapter<Map<String, String>> extraConfigs;

        public ProtoAdapter_SdkConfigItems() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkConfigItems.class);
            ProtoAdapter<String> r5 = ProtoAdapter.STRING;
            this.extraConfigs = ProtoAdapter.newMapAdapter(r5, r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkConfigItems decode(ProtoReader r5) throws IOException {
            return decode(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r5, SdkConfigItems r10) throws IOException {
            encode2(r5, r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkConfigItems r5) {
            return encodedSize2(r5);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkConfigItems redact(SdkConfigItems r5) {
            return redact2(r5);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkConfigItems decode(ProtoReader r10) throws IOException {
            Builder r5 = new Builder();
            long r11 = r10.beginMessage();
        L3:
            int r12 = r10.nextTag();
            if (r12 == (-1)) goto L13;
            switch(r12) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
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
            r5.isAllUseBind(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L6:
            FieldEncoding r13 = r10.peekFieldEncoding();
            r5.addUnknownField(r12, r13, r13.rawProtoAdapter().decode(r10));
            goto L3
        L13:
            r10.endMessage(r11);
            return r5.build();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r5, SdkConfigItems r10) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r5, 1, r10.isAllUseBind);
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            r11.asRepeated().encodeWithTag(r5, 2, r10.useBindCmd);
            r11.encodeWithTag(r5, 3, r10.sendCmdTimeout);
            r11.encodeWithTag(r5, 4, r10.pollingInterval);
            this.extraConfigs.encodeWithTag(r5, 5, r10.extraConfigs);
            r11.asRepeated().encodeWithTag(r5, 6, r10.forceUseOldBindCmd);
            r5.writeBytes(r10.unknownFields());
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SdkConfigItems r10) {
            int r5 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r10.isAllUseBind);
            ProtoAdapter<Integer> r11 = ProtoAdapter.INT32;
            int r12 = r11.asRepeated().encodedSizeWithTag(2, r10.useBindCmd) + r5;
            int r13 = r11.encodedSizeWithTag(3, r10.sendCmdTimeout) + r12;
            int r14 = r11.encodedSizeWithTag(4, r10.pollingInterval) + r13;
            int r15 = this.extraConfigs.encodedSizeWithTag(5, r10.extraConfigs) + r14;
            int r16 = r11.asRepeated().encodedSizeWithTag(6, r10.forceUseOldBindCmd) + r15;
            return r10.unknownFields().size() + r16;
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SdkConfigItems redact2(SdkConfigItems r5) {
            Builder r10 = r5.newBuilder();
            r10.clearUnknownFields();
            return r10.build();
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SdkConfigItems();
        DEFAULT_ISALLUSEBIND = Boolean.FALSE;
        DEFAULT_SENDCMDTIMEOUT = 0;
        DEFAULT_POLLINGINTERVAL = 0;
    }

    public SdkConfigItems(Boolean r10, List<Integer> r11, Integer r12, Integer r13, Map<String, String> r14, List<Integer> r15) {
        this(r10, r11, r12, r13, r14, r15, ByteString.EMPTY);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkConfigItems) == true) goto L8;
        return false;
    L8:
        SdkConfigItems r10 = (SdkConfigItems) r5;
        if (unknownFields().equals(r10.unknownFields()) == false) goto L24;
        if (Internal.equals(this.isAllUseBind, r10.isAllUseBind) == false) goto L24;
        if (this.useBindCmd.equals(r10.useBindCmd) == false) goto L24;
        if (Internal.equals(this.sendCmdTimeout, r10.sendCmdTimeout) == false) goto L24;
        if (Internal.equals(this.pollingInterval, r10.pollingInterval) == false) goto L24;
        if (this.extraConfigs.equals(r10.extraConfigs) == false) goto L24;
        if (this.forceUseOldBindCmd.equals(r10.forceUseOldBindCmd) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r5 = this.hashCode;
        if (r5 != 0) goto L17;
        int r10 = unknownFields().hashCode() * 37;
        Boolean r11 = this.isAllUseBind;
        int r12 = 0;
        if (r11 == null) goto L7;
        int r13 = r11.hashCode();
    L8:
        int r14 = (this.useBindCmd.hashCode() + ((r10 + r13) * 37)) * 37;
        Integer r15 = this.sendCmdTimeout;
        if (r15 == null) goto L11;
        int r16 = r15.hashCode();
    L12:
        int r17 = (r14 + r16) * 37;
        Integer r18 = this.pollingInterval;
        if (r18 == null) goto L15;
        r12 = r18.hashCode();
    L15:
        int r19 = ((this.extraConfigs.hashCode() + ((r17 + r12) * 37)) * 37) + this.forceUseOldBindCmd.hashCode();
        this.hashCode = r19;
        return r19;
    L11:
        r16 = 0;
        goto L12
    L7:
        r13 = 0;
        goto L8
    L17:
        return r5;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.isAllUseBind == null) goto L5;
        r5.append(", isAllUseBind=");
        r5.append(this.isAllUseBind);
    L5:
        List<Integer> r10 = this.useBindCmd;
        if (r10 == null) goto L11;
        if (r10.isEmpty() == true) goto L11;
        r5.append(", useBindCmd=");
        r5.append(this.useBindCmd);
    L11:
        if (this.sendCmdTimeout == null) goto L14;
        r5.append(", sendCmdTimeout=");
        r5.append(this.sendCmdTimeout);
    L14:
        if (this.pollingInterval == null) goto L16;
        r5.append(", pollingInterval=");
        r5.append(this.pollingInterval);
    L16:
        Map<String, String> r11 = this.extraConfigs;
        if (r11 != null) goto L19;
    L21:
        List<Integer> r12 = this.forceUseOldBindCmd;
        if (r12 == null) goto L27;
        if (r12.isEmpty() == true) goto L27;
        r5.append(", forceUseOldBindCmd=");
        r5.append(this.forceUseOldBindCmd);
    L27:
        return a.s(r5, 0, 2, "SdkConfigItems{", '}');
    L19:
        if (r11.isEmpty() == true) goto L21;
        r5.append(", extraConfigs=");
        r5.append(this.extraConfigs);
        goto L21
    }

    public SdkConfigItems(Boolean r5, List<Integer> r10, Integer r11, Integer r12, Map<String, String> r13, List<Integer> r14, ByteString r15) {
        super(ADAPTER, r15);
        this.isAllUseBind = r5;
        this.useBindCmd = Internal.immutableCopyOf("useBindCmd", r10);
        this.sendCmdTimeout = r11;
        this.pollingInterval = r12;
        this.extraConfigs = Internal.immutableCopyOf("extraConfigs", r13);
        this.forceUseOldBindCmd = Internal.immutableCopyOf("forceUseOldBindCmd", r14);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r5 = new Builder();
        r5.isAllUseBind = this.isAllUseBind;
        r5.useBindCmd = Internal.copyOf("useBindCmd", this.useBindCmd);
        r5.sendCmdTimeout = this.sendCmdTimeout;
        r5.pollingInterval = this.pollingInterval;
        r5.extraConfigs = Internal.copyOf("extraConfigs", this.extraConfigs);
        r5.forceUseOldBindCmd = Internal.copyOf("forceUseOldBindCmd", this.forceUseOldBindCmd);
        r5.addUnknownFields(unknownFields());
        return r5;
    }
}
