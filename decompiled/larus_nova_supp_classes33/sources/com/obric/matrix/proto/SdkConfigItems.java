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
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
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

        public SdkConfigItems build() {
            return new SdkConfigItems(this.isAllUseBind, this.useBindCmd, this.sendCmdTimeout, this.pollingInterval, this.extraConfigs, this.forceUseOldBindCmd, super.buildUnknownFields());
        }

        public Builder() {
            this.isAllUseBind = Boolean.FALSE;
            this.sendCmdTimeout = 0;
            this.pollingInterval = 0;
            this.useBindCmd = Internal.newMutableList();
            this.extraConfigs = Internal.newMutableMap();
            this.forceUseOldBindCmd = Internal.newMutableList();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m167build() {
            return build();
        }

        public Builder extraConfigs(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.extraConfigs = r1;
            return this;
        }

        public Builder forceUseOldBindCmd(List<Integer> r1) {
            Internal.checkElementsNotNull(r1);
            this.forceUseOldBindCmd = r1;
            return this;
        }

        public Builder isAllUseBind(Boolean r1) {
            this.isAllUseBind = r1;
            return this;
        }

        public Builder pollingInterval(Integer r1) {
            this.pollingInterval = r1;
            return this;
        }

        public Builder sendCmdTimeout(Integer r1) {
            this.sendCmdTimeout = r1;
            return this;
        }

        public Builder useBindCmd(List<Integer> r1) {
            Internal.checkElementsNotNull(r1);
            this.useBindCmd = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_SdkConfigItems extends ProtoAdapter<SdkConfigItems> {
        private final ProtoAdapter<Map<String, String>> extraConfigs;

        public ProtoAdapter_SdkConfigItems() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkConfigItems.class);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            this.extraConfigs = ProtoAdapter.newMapAdapter(r0, r0);
        }

        public SdkConfigItems decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.forceUseOldBindCmd.add((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            r0.extraConfigs.putAll((Map) this.extraConfigs.decode(r7));
            goto L3
        L9:
            r0.pollingInterval((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L10:
            r0.sendCmdTimeout((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L11:
            r0.useBindCmd.add((Integer) ProtoAdapter.INT32.decode(r7));
            goto L3
        L12:
            r0.isAllUseBind((Boolean) ProtoAdapter.BOOL.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SdkConfigItems r6) {
            int r0 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r6.isAllUseBind);
            ProtoAdapter r1 = ProtoAdapter.INT32;
            return (((((r0 + r1.asRepeated().encodedSizeWithTag(2, r6.useBindCmd)) + r1.encodedSizeWithTag(3, r6.sendCmdTimeout)) + r1.encodedSizeWithTag(4, r6.pollingInterval)) + this.extraConfigs.encodedSizeWithTag(5, r6.extraConfigs)) + r1.asRepeated().encodedSizeWithTag(6, r6.forceUseOldBindCmd)) + r6.unknownFields().size();
        }

        public SdkConfigItems redact(SdkConfigItems r1) {
            Builder r2 = r1.newBuilder();
            r2.clearUnknownFields();
            return r2.build();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m168decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SdkConfigItems) r1);
        }

        public /* bridge */ /* synthetic */ Object redact(Object r1) {
            return redact((SdkConfigItems) r1);
        }

        public void encode(ProtoWriter r5, SdkConfigItems r6) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r5, 1, r6.isAllUseBind);
            ProtoAdapter r0 = ProtoAdapter.INT32;
            r0.asRepeated().encodeWithTag(r5, 2, r6.useBindCmd);
            r0.encodeWithTag(r5, 3, r6.sendCmdTimeout);
            r0.encodeWithTag(r5, 4, r6.pollingInterval);
            this.extraConfigs.encodeWithTag(r5, 5, r6.extraConfigs);
            r0.asRepeated().encodeWithTag(r5, 6, r6.forceUseOldBindCmd);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SdkConfigItems) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SdkConfigItems();
        DEFAULT_ISALLUSEBIND = Boolean.FALSE;
        DEFAULT_SENDCMDTIMEOUT = 0;
        DEFAULT_POLLINGINTERVAL = 0;
    }

    public int hashCode() {
        int r0 = ((Message) this).hashCode;
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
        ((Message) this).hashCode = r10;
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

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.isAllUseBind = this.isAllUseBind;
        r0.useBindCmd = Internal.copyOf("useBindCmd", this.useBindCmd);
        r0.sendCmdTimeout = this.sendCmdTimeout;
        r0.pollingInterval = this.pollingInterval;
        r0.extraConfigs = Internal.copyOf("extraConfigs", this.extraConfigs);
        r0.forceUseOldBindCmd = Internal.copyOf("forceUseOldBindCmd", this.forceUseOldBindCmd);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.isAllUseBind == null) goto L5;
        r0.append(", isAllUseBind=");
        r0.append(this.isAllUseBind);
    L5:
        List<Integer> r1 = this.useBindCmd;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", useBindCmd=");
        r0.append(this.useBindCmd);
    L11:
        if (this.sendCmdTimeout == null) goto L14;
        r0.append(", sendCmdTimeout=");
        r0.append(this.sendCmdTimeout);
    L14:
        if (this.pollingInterval == null) goto L16;
        r0.append(", pollingInterval=");
        r0.append(this.pollingInterval);
    L16:
        Map<String, String> r2 = this.extraConfigs;
        if (r2 != null) goto L19;
    L21:
        List<Integer> r3 = this.forceUseOldBindCmd;
        if (r3 != null) goto L24;
    L26:
        StringBuilder r4 = r0.replace(0, 2, "SdkConfigItems{");
        r4.append('}');
        return r4.toString();
    L24:
        if (r3.isEmpty() == true) goto L26;
        r0.append(", forceUseOldBindCmd=");
        r0.append(this.forceUseOldBindCmd);
        goto L26
    L19:
        if (r2.isEmpty() == true) goto L21;
        r0.append(", extraConfigs=");
        r0.append(this.extraConfigs);
        goto L21
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m166newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkConfigItems) == true) goto L8;
        return false;
    L8:
        SdkConfigItems r6 = (SdkConfigItems) r5;
        if (unknownFields().equals(r6.unknownFields()) == true) goto L11;
    L23:
        return false;
    L11:
        if (Internal.equals(this.isAllUseBind, r6.isAllUseBind) == false) goto L23;
        if (this.useBindCmd.equals(r6.useBindCmd) == false) goto L23;
        if (Internal.equals(this.sendCmdTimeout, r6.sendCmdTimeout) == false) goto L23;
        if (Internal.equals(this.pollingInterval, r6.pollingInterval) == false) goto L23;
        if (this.extraConfigs.equals(r6.extraConfigs) == false) goto L23;
        if (this.forceUseOldBindCmd.equals(r6.forceUseOldBindCmd) == false) goto L23;
        return true;
    }

    public SdkConfigItems(Boolean r9, List<Integer> r10, Integer r11, Integer r12, Map<String, String> r13, List<Integer> r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public SdkConfigItems(Boolean r2, List<Integer> r3, Integer r4, Integer r5, Map<String, String> r6, List<Integer> r7, ByteString r8) {
        super(ADAPTER, r8);
        this.isAllUseBind = r2;
        this.useBindCmd = Internal.immutableCopyOf("useBindCmd", r3);
        this.sendCmdTimeout = r4;
        this.pollingInterval = r5;
        this.extraConfigs = Internal.immutableCopyOf("extraConfigs", r6);
        this.forceUseOldBindCmd = Internal.immutableCopyOf("forceUseOldBindCmd", r7);
    }
}
