package com.obric.cae.network;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class SwitchNetworkData extends GeneratedMessageV3 implements SwitchNetworkDataOrBuilder {
    public static final int AFTER_CELLULAR_FIELD_NUMBER = 10;
    public static final int AFTER_WIFI_FIELD_NUMBER = 9;
    public static final int BEFORE_CELLULAR_FIELD_NUMBER = 8;
    public static final int BEFORE_WIFI_FIELD_NUMBER = 7;
    private static final SwitchNetworkData DEFAULT_INSTANCE = null;
    public static final int FAILED_REASON_FIELD_NUMBER = 5;
    public static final int FOREGROUND_APP_FIELD_NUMBER = 3;
    public static final int IS_SUCCESS_FIELD_NUMBER = 13;

    @Deprecated
    public static final Parser<SwitchNetworkData> PARSER = null;
    public static final int SOLUTION_TYPE_FIELD_NUMBER = 12;
    public static final int SWITCH_CONSUME_TIME_FIELD_NUMBER = 4;
    public static final int SWITCH_MODE_FIELD_NUMBER = 1;
    public static final int SWITCH_REASON_FIELD_NUMBER = 2;
    public static final int SWITCH_SUB_REASON_FIELD_NUMBER = 14;
    public static final int SWITCH_TAKE_TIME_FIELD_NUMBER = 15;
    public static final int SWITCH_TIMES_FIELD_NUMBER = 6;
    public static final int TIMESTAMP_FIELD_NUMBER = 11;
    private static final long serialVersionUID = 0;
    private int afterNetworkCase_;
    private Object afterNetwork_;
    private int beforeNetworkCase_;
    private Object beforeNetwork_;
    private int bitField0_;
    private int failedReason_;
    private volatile Object foregroundApp_;
    private boolean isSuccess_;
    private byte memoizedIsInitialized;
    private int solutionType_;
    private long switchConsumeTime_;
    private int switchMode_;
    private int switchReason_;
    private int switchSubReason_;
    private SwitchTakeTime switchTakeTime_;
    private int switchTimes_;
    private long timestamp_;

    /* JADX INFO: renamed from: com.obric.cae.network.SwitchNetworkData$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$network$SwitchNetworkData$AfterNetworkCase = null;
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$network$SwitchNetworkData$BeforeNetworkCase = null;

        static {
            int[] r8 = new int[AfterNetworkCase.values().length];
            $SwitchMap$com$obric$cae$network$SwitchNetworkData$AfterNetworkCase = r8;
            r8[AfterNetworkCase.AFTER_WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            $SwitchMap$com$obric$cae$network$SwitchNetworkData$AfterNetworkCase[AfterNetworkCase.AFTER_CELLULAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$com$obric$cae$network$SwitchNetworkData$AfterNetworkCase[AfterNetworkCase.AFTERNETWORK_NOT_SET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r10 = new int[BeforeNetworkCase.values().length];
            $SwitchMap$com$obric$cae$network$SwitchNetworkData$BeforeNetworkCase = r10;
            r10[BeforeNetworkCase.BEFORE_WIFI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$com$obric$cae$network$SwitchNetworkData$BeforeNetworkCase[BeforeNetworkCase.BEFORE_CELLULAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            $SwitchMap$com$obric$cae$network$SwitchNetworkData$BeforeNetworkCase[BeforeNetworkCase.BEFORENETWORK_NOT_SET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    public static final enum AfterNetworkCase extends Enum<AfterNetworkCase> implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        private static final /* synthetic */ AfterNetworkCase[] $VALUES = null;
        public static final AfterNetworkCase AFTERNETWORK_NOT_SET = null;
        public static final AfterNetworkCase AFTER_CELLULAR = null;
        public static final AfterNetworkCase AFTER_WIFI = null;
        private final int value;

        private static /* synthetic */ AfterNetworkCase[] $values() {
            return new AfterNetworkCase[]{AFTER_WIFI, AFTER_CELLULAR, AFTERNETWORK_NOT_SET};
        }

        static {
            AFTER_WIFI = new AfterNetworkCase("AFTER_WIFI", 0, 9);
            AFTER_CELLULAR = new AfterNetworkCase("AFTER_CELLULAR", 1, 10);
            AFTERNETWORK_NOT_SET = new AfterNetworkCase("AFTERNETWORK_NOT_SET", 2, 0);
            $VALUES = $values();
        }

        private AfterNetworkCase(String r8, int r10, int r11) {
            super(r8, r10);
            this.value = r11;
        }

        public static AfterNetworkCase forNumber(int r8) {
            if (r8 == 0) goto L14;
            if (r8 == 9) goto L12;
            if (r8 == 10) goto L10;
            return null;
        L10:
            return AFTER_CELLULAR;
        L12:
            return AFTER_WIFI;
        L14:
            return AFTERNETWORK_NOT_SET;
        }

        @Deprecated
        public static AfterNetworkCase valueOf(int r8) {
            return forNumber(r8);
        }

        public static AfterNetworkCase[] values() {
            return (AfterNetworkCase[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        public static AfterNetworkCase valueOf(String r8) {
            return (AfterNetworkCase) Enum.valueOf(AfterNetworkCase.class, r8);
        }
    }

    public static final enum BeforeNetworkCase extends Enum<BeforeNetworkCase> implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
        private static final /* synthetic */ BeforeNetworkCase[] $VALUES = null;
        public static final BeforeNetworkCase BEFORENETWORK_NOT_SET = null;
        public static final BeforeNetworkCase BEFORE_CELLULAR = null;
        public static final BeforeNetworkCase BEFORE_WIFI = null;
        private final int value;

        private static /* synthetic */ BeforeNetworkCase[] $values() {
            return new BeforeNetworkCase[]{BEFORE_WIFI, BEFORE_CELLULAR, BEFORENETWORK_NOT_SET};
        }

        static {
            BEFORE_WIFI = new BeforeNetworkCase("BEFORE_WIFI", 0, 7);
            BEFORE_CELLULAR = new BeforeNetworkCase("BEFORE_CELLULAR", 1, 8);
            BEFORENETWORK_NOT_SET = new BeforeNetworkCase("BEFORENETWORK_NOT_SET", 2, 0);
            $VALUES = $values();
        }

        private BeforeNetworkCase(String r8, int r10, int r11) {
            super(r8, r10);
            this.value = r11;
        }

        public static BeforeNetworkCase forNumber(int r8) {
            if (r8 == 0) goto L14;
            if (r8 == 7) goto L12;
            if (r8 == 8) goto L10;
            return null;
        L10:
            return BEFORE_CELLULAR;
        L12:
            return BEFORE_WIFI;
        L14:
            return BEFORENETWORK_NOT_SET;
        }

        @Deprecated
        public static BeforeNetworkCase valueOf(int r8) {
            return forNumber(r8);
        }

        public static BeforeNetworkCase[] values() {
            return (BeforeNetworkCase[]) $VALUES.clone();
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.value;
        }

        public static BeforeNetworkCase valueOf(String r8) {
            return (BeforeNetworkCase) Enum.valueOf(BeforeNetworkCase.class, r8);
        }
    }

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SwitchNetworkDataOrBuilder {
        private SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> afterCellularBuilder_;
        private int afterNetworkCase_;
        private Object afterNetwork_;
        private SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> afterWifiBuilder_;
        private SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> beforeCellularBuilder_;
        private int beforeNetworkCase_;
        private Object beforeNetwork_;
        private SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> beforeWifiBuilder_;
        private int bitField0_;
        private int failedReason_;
        private Object foregroundApp_;
        private boolean isSuccess_;
        private int solutionType_;
        private long switchConsumeTime_;
        private int switchMode_;
        private int switchReason_;
        private int switchSubReason_;
        private SingleFieldBuilderV3<SwitchTakeTime, SwitchTakeTime.Builder, SwitchTakeTimeOrBuilder> switchTakeTimeBuilder_;
        private SwitchTakeTime switchTakeTime_;
        private int switchTimes_;
        private long timestamp_;

        private Builder() {
            this.beforeNetworkCase_ = 0;
            this.afterNetworkCase_ = 0;
            this.foregroundApp_ = "";
            maybeForceBuilderInitialization();
        }

        private void buildPartial0(SwitchNetworkData r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L5;
            SwitchNetworkData.access$402(r8, this.switchMode_);
            int r11 = 1;
        L7:
            if ((r10 & 2) == 0) goto L10;
            SwitchNetworkData.access$502(r8, this.switchReason_);
            r11 = r11 | 2;
        L10:
            if ((r10 & 4) == 0) goto L13;
            SwitchNetworkData.access$602(r8, this.foregroundApp_);
            r11 = r11 | 4;
        L13:
            if ((r10 & 8) == 0) goto L16;
            SwitchNetworkData.access$702(r8, this.switchConsumeTime_);
            r11 = r11 | 8;
        L16:
            if ((r10 & 16) == 0) goto L19;
            SwitchNetworkData.access$802(r8, this.failedReason_);
            r11 = r11 | 16;
        L19:
            if ((r10 & 32) == 0) goto L22;
            SwitchNetworkData.access$902(r8, this.switchTimes_);
            r11 = r11 | 32;
        L22:
            if ((r10 & 1024) == 0) goto L25;
            SwitchNetworkData.access$1002(r8, this.timestamp_);
            r11 = r11 | 1024;
        L25:
            if ((r10 & 2048) == 0) goto L28;
            SwitchNetworkData.access$1102(r8, this.solutionType_);
            r11 = r11 | 2048;
        L28:
            if ((r10 & 4096) == 0) goto L31;
            SwitchNetworkData.access$1202(r8, this.isSuccess_);
            r11 = r11 | 4096;
        L31:
            if ((r10 & 8192) == 0) goto L34;
            SwitchNetworkData.access$1302(r8, this.switchSubReason_);
            r11 = r11 | 8192;
        L34:
            if ((r10 & 16384) == 0) goto L40;
            SingleFieldBuilderV3<SwitchTakeTime, SwitchTakeTime.Builder, SwitchTakeTimeOrBuilder> r12 = this.switchTakeTimeBuilder_;
            if (r12 != null) goto L38;
            SwitchTakeTime r13 = this.switchTakeTime_;
        L39:
            SwitchNetworkData.access$1402(r8, r13);
            r11 = r11 | 16384;
            goto L40
        L38:
            r13 = (SwitchTakeTime) r12.build();
        L40:
            SwitchNetworkData.access$1576(r8, r11);
            return;
        L5:
            r11 = 0;
            goto L7
        }

        private void buildPartialOneofs(SwitchNetworkData r8) {
            SwitchNetworkData.access$1602(r8, this.beforeNetworkCase_);
            SwitchNetworkData.access$1702(r8, this.beforeNetwork_);
            if (this.beforeNetworkCase_ != 7) goto L8;
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r10 = this.beforeWifiBuilder_;
            if (r10 == null) goto L8;
            SwitchNetworkData.access$1702(r8, r10.build());
        L8:
            if (this.beforeNetworkCase_ != 8) goto L12;
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r11 = this.beforeCellularBuilder_;
            if (r11 == null) goto L12;
            SwitchNetworkData.access$1702(r8, r11.build());
        L12:
            SwitchNetworkData.access$1802(r8, this.afterNetworkCase_);
            SwitchNetworkData.access$1902(r8, this.afterNetwork_);
            if (this.afterNetworkCase_ != 9) goto L18;
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r12 = this.afterWifiBuilder_;
            if (r12 == null) goto L18;
            SwitchNetworkData.access$1902(r8, r12.build());
        L18:
            if (this.afterNetworkCase_ != 10) goto L23;
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r13 = this.afterCellularBuilder_;
            if (r13 == null) goto L24;
            SwitchNetworkData.access$1902(r8, r13.build());
            return;
        L24:
            return;
        }

        private SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> getAfterCellularFieldBuilder() {
            if (this.afterCellularBuilder_ == null) goto L5;
        L8:
            this.afterNetworkCase_ = 10;
            onChanged();
            return this.afterCellularBuilder_;
        L5:
            if (this.afterNetworkCase_ == 10) goto L7;
            this.afterNetwork_ = CellularInfoData.getDefaultInstance();
        L7:
            this.afterCellularBuilder_ = new SingleFieldBuilderV3((CellularInfoData) this.afterNetwork_, getParentForChildren(), isClean());
            this.afterNetwork_ = null;
            goto L8
        }

        private SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> getAfterWifiFieldBuilder() {
            if (this.afterWifiBuilder_ == null) goto L5;
        L8:
            this.afterNetworkCase_ = 9;
            onChanged();
            return this.afterWifiBuilder_;
        L5:
            if (this.afterNetworkCase_ == 9) goto L7;
            this.afterNetwork_ = WifiInfoData.getDefaultInstance();
        L7:
            this.afterWifiBuilder_ = new SingleFieldBuilderV3((WifiInfoData) this.afterNetwork_, getParentForChildren(), isClean());
            this.afterNetwork_ = null;
            goto L8
        }

        private SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> getBeforeCellularFieldBuilder() {
            if (this.beforeCellularBuilder_ == null) goto L5;
        L8:
            this.beforeNetworkCase_ = 8;
            onChanged();
            return this.beforeCellularBuilder_;
        L5:
            if (this.beforeNetworkCase_ == 8) goto L7;
            this.beforeNetwork_ = CellularInfoData.getDefaultInstance();
        L7:
            this.beforeCellularBuilder_ = new SingleFieldBuilderV3((CellularInfoData) this.beforeNetwork_, getParentForChildren(), isClean());
            this.beforeNetwork_ = null;
            goto L8
        }

        private SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> getBeforeWifiFieldBuilder() {
            if (this.beforeWifiBuilder_ == null) goto L5;
        L8:
            this.beforeNetworkCase_ = 7;
            onChanged();
            return this.beforeWifiBuilder_;
        L5:
            if (this.beforeNetworkCase_ == 7) goto L7;
            this.beforeNetwork_ = WifiInfoData.getDefaultInstance();
        L7:
            this.beforeWifiBuilder_ = new SingleFieldBuilderV3((WifiInfoData) this.beforeNetwork_, getParentForChildren(), isClean());
            this.beforeNetwork_ = null;
            goto L8
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchNetworkData_descriptor;
        }

        private SingleFieldBuilderV3<SwitchTakeTime, SwitchTakeTime.Builder, SwitchTakeTimeOrBuilder> getSwitchTakeTimeFieldBuilder() {
            if (this.switchTakeTimeBuilder_ != null) goto L6;
            this.switchTakeTimeBuilder_ = new SingleFieldBuilderV3(getSwitchTakeTime(), getParentForChildren(), isClean());
            this.switchTakeTime_ = null;
        L6:
            return this.switchTakeTimeBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (SwitchNetworkData.access$200() == false) goto L6;
            getSwitchTakeTimeFieldBuilder();
            return;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public Builder clearAfterCellular() {
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r8 = this.afterCellularBuilder_;
            if (r8 != null) goto L8;
            if (this.afterNetworkCase_ != 10) goto L11;
            this.afterNetworkCase_ = 0;
            this.afterNetwork_ = null;
            onChanged();
        L11:
            return this;
        L8:
            if (this.afterNetworkCase_ != 10) goto L10;
            this.afterNetworkCase_ = 0;
            this.afterNetwork_ = null;
        L10:
            r8.clear();
            goto L11
        }

        public Builder clearAfterNetwork() {
            this.afterNetworkCase_ = 0;
            this.afterNetwork_ = null;
            onChanged();
            return this;
        }

        public Builder clearAfterWifi() {
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r8 = this.afterWifiBuilder_;
            if (r8 != null) goto L8;
            if (this.afterNetworkCase_ != 9) goto L11;
            this.afterNetworkCase_ = 0;
            this.afterNetwork_ = null;
            onChanged();
        L11:
            return this;
        L8:
            if (this.afterNetworkCase_ != 9) goto L10;
            this.afterNetworkCase_ = 0;
            this.afterNetwork_ = null;
        L10:
            r8.clear();
            goto L11
        }

        public Builder clearBeforeCellular() {
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r8 = this.beforeCellularBuilder_;
            if (r8 != null) goto L8;
            if (this.beforeNetworkCase_ != 8) goto L11;
            this.beforeNetworkCase_ = 0;
            this.beforeNetwork_ = null;
            onChanged();
        L11:
            return this;
        L8:
            if (this.beforeNetworkCase_ != 8) goto L10;
            this.beforeNetworkCase_ = 0;
            this.beforeNetwork_ = null;
        L10:
            r8.clear();
            goto L11
        }

        public Builder clearBeforeNetwork() {
            this.beforeNetworkCase_ = 0;
            this.beforeNetwork_ = null;
            onChanged();
            return this;
        }

        public Builder clearBeforeWifi() {
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r8 = this.beforeWifiBuilder_;
            if (r8 != null) goto L8;
            if (this.beforeNetworkCase_ != 7) goto L11;
            this.beforeNetworkCase_ = 0;
            this.beforeNetwork_ = null;
            onChanged();
        L11:
            return this;
        L8:
            if (this.beforeNetworkCase_ != 7) goto L10;
            this.beforeNetworkCase_ = 0;
            this.beforeNetwork_ = null;
        L10:
            r8.clear();
            goto L11
        }

        public Builder clearFailedReason() {
            this.bitField0_ &= -17;
            this.failedReason_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearForegroundApp() {
            this.foregroundApp_ = SwitchNetworkData.getDefaultInstance().getForegroundApp();
            this.bitField0_ &= -5;
            onChanged();
            return this;
        }

        public Builder clearIsSuccess() {
            this.bitField0_ &= -4097;
            this.isSuccess_ = false;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearSolutionType() {
            this.bitField0_ &= -2049;
            this.solutionType_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSwitchConsumeTime() {
            this.bitField0_ &= -9;
            this.switchConsumeTime_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSwitchMode() {
            this.bitField0_ &= -2;
            this.switchMode_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSwitchReason() {
            this.bitField0_ &= -3;
            this.switchReason_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSwitchSubReason() {
            this.bitField0_ &= -8193;
            this.switchSubReason_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSwitchTakeTime() {
            this.bitField0_ &= -16385;
            this.switchTakeTime_ = null;
            SingleFieldBuilderV3<SwitchTakeTime, SwitchTakeTime.Builder, SwitchTakeTimeOrBuilder> r8 = this.switchTakeTimeBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.switchTakeTimeBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearSwitchTimes() {
            this.bitField0_ &= -33;
            this.switchTimes_ = 0;
            onChanged();
            return this;
        }

        public Builder clearTimestamp() {
            this.bitField0_ &= -1025;
            this.timestamp_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public CellularInfoData getAfterCellular() {
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r8 = this.afterCellularBuilder_;
            if (r8 != null) goto L12;
            if (this.afterNetworkCase_ != 10) goto L10;
            Object r10 = this.afterNetwork_;
        L8:
            return (CellularInfoData) r10;
        L10:
            return CellularInfoData.getDefaultInstance();
        L12:
            if (this.afterNetworkCase_ != 10) goto L15;
            r10 = r8.getMessage();
            goto L8
        L15:
            return CellularInfoData.getDefaultInstance();
        }

        public CellularInfoData.Builder getAfterCellularBuilder() {
            return (CellularInfoData.Builder) getAfterCellularFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public CellularInfoDataOrBuilder getAfterCellularOrBuilder() {
            int r8 = this.afterNetworkCase_;
            if (r8 != 10) goto L8;
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r10 = this.afterCellularBuilder_;
            if (r10 == null) goto L8;
            return (CellularInfoDataOrBuilder) r10.getMessageOrBuilder();
        L8:
            if (r8 != 10) goto L12;
            return (CellularInfoData) this.afterNetwork_;
        L12:
            return CellularInfoData.getDefaultInstance();
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public AfterNetworkCase getAfterNetworkCase() {
            return AfterNetworkCase.forNumber(this.afterNetworkCase_);
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public WifiInfoData getAfterWifi() {
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r8 = this.afterWifiBuilder_;
            if (r8 != null) goto L12;
            if (this.afterNetworkCase_ != 9) goto L10;
            Object r10 = this.afterNetwork_;
        L8:
            return (WifiInfoData) r10;
        L10:
            return WifiInfoData.getDefaultInstance();
        L12:
            if (this.afterNetworkCase_ != 9) goto L15;
            r10 = r8.getMessage();
            goto L8
        L15:
            return WifiInfoData.getDefaultInstance();
        }

        public WifiInfoData.Builder getAfterWifiBuilder() {
            return (WifiInfoData.Builder) getAfterWifiFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public WifiInfoDataOrBuilder getAfterWifiOrBuilder() {
            int r8 = this.afterNetworkCase_;
            if (r8 != 9) goto L8;
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r10 = this.afterWifiBuilder_;
            if (r10 == null) goto L8;
            return (WifiInfoDataOrBuilder) r10.getMessageOrBuilder();
        L8:
            if (r8 != 9) goto L12;
            return (WifiInfoData) this.afterNetwork_;
        L12:
            return WifiInfoData.getDefaultInstance();
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public CellularInfoData getBeforeCellular() {
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r8 = this.beforeCellularBuilder_;
            if (r8 != null) goto L12;
            if (this.beforeNetworkCase_ != 8) goto L10;
            Object r10 = this.beforeNetwork_;
        L8:
            return (CellularInfoData) r10;
        L10:
            return CellularInfoData.getDefaultInstance();
        L12:
            if (this.beforeNetworkCase_ != 8) goto L15;
            r10 = r8.getMessage();
            goto L8
        L15:
            return CellularInfoData.getDefaultInstance();
        }

        public CellularInfoData.Builder getBeforeCellularBuilder() {
            return (CellularInfoData.Builder) getBeforeCellularFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public CellularInfoDataOrBuilder getBeforeCellularOrBuilder() {
            int r8 = this.beforeNetworkCase_;
            if (r8 != 8) goto L8;
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r10 = this.beforeCellularBuilder_;
            if (r10 == null) goto L8;
            return (CellularInfoDataOrBuilder) r10.getMessageOrBuilder();
        L8:
            if (r8 != 8) goto L12;
            return (CellularInfoData) this.beforeNetwork_;
        L12:
            return CellularInfoData.getDefaultInstance();
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public BeforeNetworkCase getBeforeNetworkCase() {
            return BeforeNetworkCase.forNumber(this.beforeNetworkCase_);
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public WifiInfoData getBeforeWifi() {
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r8 = this.beforeWifiBuilder_;
            if (r8 != null) goto L12;
            if (this.beforeNetworkCase_ != 7) goto L10;
            Object r10 = this.beforeNetwork_;
        L8:
            return (WifiInfoData) r10;
        L10:
            return WifiInfoData.getDefaultInstance();
        L12:
            if (this.beforeNetworkCase_ != 7) goto L15;
            r10 = r8.getMessage();
            goto L8
        L15:
            return WifiInfoData.getDefaultInstance();
        }

        public WifiInfoData.Builder getBeforeWifiBuilder() {
            return (WifiInfoData.Builder) getBeforeWifiFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public WifiInfoDataOrBuilder getBeforeWifiOrBuilder() {
            int r8 = this.beforeNetworkCase_;
            if (r8 != 7) goto L8;
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r10 = this.beforeWifiBuilder_;
            if (r10 == null) goto L8;
            return (WifiInfoDataOrBuilder) r10.getMessageOrBuilder();
        L8:
            if (r8 != 7) goto L12;
            return (WifiInfoData) this.beforeNetwork_;
        L12:
            return WifiInfoData.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchNetworkData_descriptor;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public int getFailedReason() {
            return this.failedReason_;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public String getForegroundApp() {
            Object r8 = this.foregroundApp_;
            if ((r8 instanceof String) == true) goto L9;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L7;
            this.foregroundApp_ = r11;
        L7:
            return r11;
        L9:
            return (String) r8;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public ByteString getForegroundAppBytes() {
            Object r8 = this.foregroundApp_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.foregroundApp_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean getIsSuccess() {
            return this.isSuccess_;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public int getSolutionType() {
            return this.solutionType_;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public long getSwitchConsumeTime() {
            return this.switchConsumeTime_;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public int getSwitchMode() {
            return this.switchMode_;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public int getSwitchReason() {
            return this.switchReason_;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public int getSwitchSubReason() {
            return this.switchSubReason_;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public SwitchTakeTime getSwitchTakeTime() {
            SingleFieldBuilderV3<SwitchTakeTime, SwitchTakeTime.Builder, SwitchTakeTimeOrBuilder> r8 = this.switchTakeTimeBuilder_;
            if (r8 != null) goto L9;
            SwitchTakeTime r10 = this.switchTakeTime_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return SwitchTakeTime.getDefaultInstance();
        L9:
            return (SwitchTakeTime) r8.getMessage();
        }

        public SwitchTakeTime.Builder getSwitchTakeTimeBuilder() {
            this.bitField0_ |= 16384;
            onChanged();
            return (SwitchTakeTime.Builder) getSwitchTakeTimeFieldBuilder().getBuilder();
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public SwitchTakeTimeOrBuilder getSwitchTakeTimeOrBuilder() {
            SingleFieldBuilderV3<SwitchTakeTime, SwitchTakeTime.Builder, SwitchTakeTimeOrBuilder> r8 = this.switchTakeTimeBuilder_;
            if (r8 != null) goto L5;
            SwitchTakeTime r10 = this.switchTakeTime_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return SwitchTakeTime.getDefaultInstance();
        L5:
            return (SwitchTakeTimeOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public int getSwitchTimes() {
            return this.switchTimes_;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasAfterCellular() {
            if (this.afterNetworkCase_ != 10) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasAfterWifi() {
            if (this.afterNetworkCase_ != 9) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasBeforeCellular() {
            if (this.beforeNetworkCase_ != 8) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasBeforeWifi() {
            if (this.beforeNetworkCase_ != 7) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasFailedReason() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasForegroundApp() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasIsSuccess() {
            if ((this.bitField0_ & 4096) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasSolutionType() {
            if ((this.bitField0_ & 2048) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasSwitchConsumeTime() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasSwitchMode() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasSwitchReason() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasSwitchSubReason() {
            if ((this.bitField0_ & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasSwitchTakeTime() {
            if ((this.bitField0_ & 16384) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasSwitchTimes() {
            if ((this.bitField0_ & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 1024) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetFieldAccessorTable();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeAfterCellular(CellularInfoData r8) {
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r10 = this.afterCellularBuilder_;
            if (r10 != null) goto L11;
            if (this.afterNetworkCase_ == 10) goto L7;
        L9:
            this.afterNetwork_ = r8;
            onChanged();
        L14:
            this.afterNetworkCase_ = 10;
            return this;
        L7:
            if (this.afterNetwork_ == CellularInfoData.getDefaultInstance()) goto L9;
            r8 = CellularInfoData.newBuilder((CellularInfoData) this.afterNetwork_).mergeFrom(r8).buildPartial();
            goto L9
        L11:
            if (this.afterNetworkCase_ != 10) goto L13;
            r10.mergeFrom(r8);
            goto L14
        L13:
            r10.setMessage(r8);
            goto L14
        }

        public Builder mergeAfterWifi(WifiInfoData r8) {
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r10 = this.afterWifiBuilder_;
            if (r10 != null) goto L11;
            if (this.afterNetworkCase_ == 9) goto L7;
        L9:
            this.afterNetwork_ = r8;
            onChanged();
        L14:
            this.afterNetworkCase_ = 9;
            return this;
        L7:
            if (this.afterNetwork_ == WifiInfoData.getDefaultInstance()) goto L9;
            r8 = WifiInfoData.newBuilder((WifiInfoData) this.afterNetwork_).mergeFrom(r8).buildPartial();
            goto L9
        L11:
            if (this.afterNetworkCase_ != 9) goto L13;
            r10.mergeFrom(r8);
            goto L14
        L13:
            r10.setMessage(r8);
            goto L14
        }

        public Builder mergeBeforeCellular(CellularInfoData r8) {
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r10 = this.beforeCellularBuilder_;
            if (r10 != null) goto L11;
            if (this.beforeNetworkCase_ == 8) goto L7;
        L9:
            this.beforeNetwork_ = r8;
            onChanged();
        L14:
            this.beforeNetworkCase_ = 8;
            return this;
        L7:
            if (this.beforeNetwork_ == CellularInfoData.getDefaultInstance()) goto L9;
            r8 = CellularInfoData.newBuilder((CellularInfoData) this.beforeNetwork_).mergeFrom(r8).buildPartial();
            goto L9
        L11:
            if (this.beforeNetworkCase_ != 8) goto L13;
            r10.mergeFrom(r8);
            goto L14
        L13:
            r10.setMessage(r8);
            goto L14
        }

        public Builder mergeBeforeWifi(WifiInfoData r8) {
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r10 = this.beforeWifiBuilder_;
            if (r10 != null) goto L11;
            if (this.beforeNetworkCase_ == 7) goto L7;
        L9:
            this.beforeNetwork_ = r8;
            onChanged();
        L14:
            this.beforeNetworkCase_ = 7;
            return this;
        L7:
            if (this.beforeNetwork_ == WifiInfoData.getDefaultInstance()) goto L9;
            r8 = WifiInfoData.newBuilder((WifiInfoData) this.beforeNetwork_).mergeFrom(r8).buildPartial();
            goto L9
        L11:
            if (this.beforeNetworkCase_ != 7) goto L13;
            r10.mergeFrom(r8);
            goto L14
        L13:
            r10.setMessage(r8);
            goto L14
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public Builder mergeSwitchTakeTime(SwitchTakeTime r8) {
            SingleFieldBuilderV3<SwitchTakeTime, SwitchTakeTime.Builder, SwitchTakeTimeOrBuilder> r10 = this.switchTakeTimeBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L13:
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        L5:
            if ((this.bitField0_ & 16384) == 0) goto L11;
            SwitchTakeTime r11 = this.switchTakeTime_;
            if (r11 == null) goto L11;
            if (r11 == SwitchTakeTime.getDefaultInstance()) goto L11;
            getSwitchTakeTimeBuilder().mergeFrom(r8);
        L11:
            this.switchTakeTime_ = r8;
            goto L13
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setAfterCellular(CellularInfoData.Builder r8) {
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r10 = this.afterCellularBuilder_;
            CellularInfoData r11 = r8.build();
            if (r10 != null) goto L5;
            this.afterNetwork_ = r11;
            onChanged();
        L6:
            this.afterNetworkCase_ = 10;
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setAfterWifi(WifiInfoData.Builder r8) {
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r10 = this.afterWifiBuilder_;
            WifiInfoData r11 = r8.build();
            if (r10 != null) goto L5;
            this.afterNetwork_ = r11;
            onChanged();
        L6:
            this.afterNetworkCase_ = 9;
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setBeforeCellular(CellularInfoData.Builder r8) {
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r10 = this.beforeCellularBuilder_;
            CellularInfoData r11 = r8.build();
            if (r10 != null) goto L5;
            this.beforeNetwork_ = r11;
            onChanged();
        L6:
            this.beforeNetworkCase_ = 8;
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setBeforeWifi(WifiInfoData.Builder r8) {
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r10 = this.beforeWifiBuilder_;
            WifiInfoData r11 = r8.build();
            if (r10 != null) goto L5;
            this.beforeNetwork_ = r11;
            onChanged();
        L6:
            this.beforeNetworkCase_ = 7;
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setFailedReason(int r8) {
            this.failedReason_ = r8;
            this.bitField0_ |= 16;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setForegroundApp(String r8) {
            if (r8 == null) goto L6;
            this.foregroundApp_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setForegroundAppBytes(ByteString r8) {
            if (r8 == null) goto L6;
            this.foregroundApp_ = r8;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setIsSuccess(boolean r8) {
            this.isSuccess_ = r8;
            this.bitField0_ |= 4096;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setSolutionType(int r8) {
            this.solutionType_ = r8;
            this.bitField0_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setSwitchConsumeTime(long r8) {
            this.switchConsumeTime_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setSwitchMode(int r8) {
            this.switchMode_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setSwitchReason(int r8) {
            this.switchReason_ = r8;
            this.bitField0_ |= 2;
            onChanged();
            return this;
        }

        public Builder setSwitchSubReason(int r8) {
            this.switchSubReason_ = r8;
            this.bitField0_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setSwitchTakeTime(SwitchTakeTime.Builder r8) {
            SingleFieldBuilderV3<SwitchTakeTime, SwitchTakeTime.Builder, SwitchTakeTimeOrBuilder> r10 = this.switchTakeTimeBuilder_;
            SwitchTakeTime r11 = r8.build();
            if (r10 != null) goto L5;
            this.switchTakeTime_ = r11;
        L6:
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setSwitchTimes(int r8) {
            this.switchTimes_ = r8;
            this.bitField0_ |= 32;
            onChanged();
            return this;
        }

        public Builder setTimestamp(long r8) {
            this.timestamp_ = r8;
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.beforeNetworkCase_ = 0;
            this.afterNetworkCase_ = 0;
            this.foregroundApp_ = "";
            maybeForceBuilderInitialization();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchNetworkData_fieldAccessorTable.ensureFieldAccessorsInitialized(SwitchNetworkData.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setAfterCellular(CellularInfoData r8) {
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r10 = this.afterCellularBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.afterNetwork_ = r8;
            onChanged();
        L9:
            this.afterNetworkCase_ = 10;
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setAfterWifi(WifiInfoData r8) {
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r10 = this.afterWifiBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.afterNetwork_ = r8;
            onChanged();
        L9:
            this.afterNetworkCase_ = 9;
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setBeforeCellular(CellularInfoData r8) {
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r10 = this.beforeCellularBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.beforeNetwork_ = r8;
            onChanged();
        L9:
            this.beforeNetworkCase_ = 8;
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        public Builder setBeforeWifi(WifiInfoData r8) {
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r10 = this.beforeWifiBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.beforeNetwork_ = r8;
            onChanged();
        L9:
            this.beforeNetworkCase_ = 7;
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setSwitchTakeTime(SwitchTakeTime r8) {
            SingleFieldBuilderV3<SwitchTakeTime, SwitchTakeTime.Builder, SwitchTakeTimeOrBuilder> r10 = this.switchTakeTimeBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.switchTakeTime_ = r8;
        L9:
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        L7:
            throw null;
        L8:
            r10.setMessage(r8);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SwitchNetworkData build() {
            SwitchNetworkData r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public SwitchNetworkData buildPartial() {
            SwitchNetworkData r8 = new SwitchNetworkData(this, null);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r8);
        L5:
            buildPartialOneofs(r8);
            onBuilt();
            return r8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public SwitchNetworkData getDefaultInstanceForType() {
            return SwitchNetworkData.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet r8) {
            return (Builder) super.setUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return (Builder) super.addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor r8) {
            return (Builder) super.clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return (Builder) super.clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r8) {
            return (Builder) super.mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return (Builder) super.setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return (Builder) super.setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.switchMode_ = 0;
            this.switchReason_ = 0;
            this.foregroundApp_ = "";
            this.switchConsumeTime_ = 0;
            this.failedReason_ = 0;
            this.switchTimes_ = 0;
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r8 = this.beforeWifiBuilder_;
            if (r8 == null) goto L5;
            r8.clear();
        L5:
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r10 = this.beforeCellularBuilder_;
            if (r10 == null) goto L8;
            r10.clear();
        L8:
            SingleFieldBuilderV3<WifiInfoData, WifiInfoData.Builder, WifiInfoDataOrBuilder> r11 = this.afterWifiBuilder_;
            if (r11 == null) goto L11;
            r11.clear();
        L11:
            SingleFieldBuilderV3<CellularInfoData, CellularInfoData.Builder, CellularInfoDataOrBuilder> r12 = this.afterCellularBuilder_;
            if (r12 == null) goto L14;
            r12.clear();
        L14:
            this.timestamp_ = 0;
            this.solutionType_ = 0;
            this.isSuccess_ = false;
            this.switchSubReason_ = 0;
            this.switchTakeTime_ = null;
            SingleFieldBuilderV3<SwitchTakeTime, SwitchTakeTime.Builder, SwitchTakeTimeOrBuilder> r13 = this.switchTakeTimeBuilder_;
            if (r13 == null) goto L17;
            r13.dispose();
            this.switchTakeTimeBuilder_ = null;
        L17:
            this.beforeNetworkCase_ = 0;
            this.beforeNetwork_ = null;
            this.afterNetworkCase_ = 0;
            this.afterNetwork_ = null;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L37;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L34;
            int r12 = r8.readTag();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            switch(r12) {
                case 0: goto L24;
                case 8: goto L22;
                case 16: goto L21;
                case 26: goto L20;
                case 32: goto L19;
                case 40: goto L18;
                case 48: goto L17;
                case 58: goto L16;
                case 66: goto L15;
                case 74: goto L14;
                case 82: goto L13;
                case 88: goto L12;
                case 96: goto L11;
                case 104: goto L10;
                case 112: goto L9;
                case 122: goto L8;
                default: goto L25;
            };     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
        L8:
            r8.readMessage(getSwitchTakeTimeFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 16384;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L9:
            this.switchSubReason_ = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 8192;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L10:
            this.isSuccess_ = r8.readBool();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 4096;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L11:
            this.solutionType_ = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 2048;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L12:
            this.timestamp_ = r8.readInt64();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 1024;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L13:
            r8.readMessage(getAfterCellularFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.afterNetworkCase_ = 10;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L14:
            r8.readMessage(getAfterWifiFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.afterNetworkCase_ = 9;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L15:
            r8.readMessage(getBeforeCellularFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.beforeNetworkCase_ = 8;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L16:
            r8.readMessage(getBeforeWifiFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.beforeNetworkCase_ = 7;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L17:
            this.switchTimes_ = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 32;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L18:
            this.failedReason_ = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 16;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L19:
            this.switchConsumeTime_ = r8.readInt64();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 8;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L20:
            this.foregroundApp_ = r8.readBytes();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 4;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L21:
            this.switchReason_ = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 2;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            goto L4
        L22:
            this.switchMode_ = r8.readInt32();     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
            this.bitField0_ |= 1;     // Catch: Throwable -> L27 InvalidProtocolBufferException -> L29
        L24:
            r11 = true;
            goto L4
        L25:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L27:
            th = move-exception;
            onChanged();
            throw th;
        L29:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L27
        L34:
            onChanged();
            return this;
        L37:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof SwitchNetworkData) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((SwitchNetworkData) r8);
        }

        public Builder mergeFrom(SwitchNetworkData r8) {
            if (r8 != SwitchNetworkData.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.hasSwitchMode() == false) goto L9;
            setSwitchMode(r8.getSwitchMode());
        L9:
            if (r8.hasSwitchReason() == false) goto L12;
            setSwitchReason(r8.getSwitchReason());
        L12:
            if (r8.hasForegroundApp() == false) goto L15;
            this.foregroundApp_ = SwitchNetworkData.access$600(r8);
            this.bitField0_ |= 4;
            onChanged();
        L15:
            if (r8.hasSwitchConsumeTime() == false) goto L18;
            setSwitchConsumeTime(r8.getSwitchConsumeTime());
        L18:
            if (r8.hasFailedReason() == false) goto L21;
            setFailedReason(r8.getFailedReason());
        L21:
            if (r8.hasSwitchTimes() == false) goto L24;
            setSwitchTimes(r8.getSwitchTimes());
        L24:
            if (r8.hasTimestamp() == false) goto L27;
            setTimestamp(r8.getTimestamp());
        L27:
            if (r8.hasSolutionType() == false) goto L30;
            setSolutionType(r8.getSolutionType());
        L30:
            if (r8.hasIsSuccess() == false) goto L33;
            setIsSuccess(r8.getIsSuccess());
        L33:
            if (r8.hasSwitchSubReason() == false) goto L36;
            setSwitchSubReason(r8.getSwitchSubReason());
        L36:
            if (r8.hasSwitchTakeTime() == false) goto L38;
            mergeSwitchTakeTime(r8.getSwitchTakeTime());
        L38:
            int r10 = AnonymousClass2.$SwitchMap$com$obric$cae$network$SwitchNetworkData$BeforeNetworkCase[r8.getBeforeNetworkCase().ordinal()];
            if (r10 == 1) goto L43;
            if (r10 != 2) goto L44;
            mergeBeforeCellular(r8.getBeforeCellular());
        L44:
            int r11 = AnonymousClass2.$SwitchMap$com$obric$cae$network$SwitchNetworkData$AfterNetworkCase[r8.getAfterNetworkCase().ordinal()];
            if (r11 == 1) goto L49;
            if (r11 != 2) goto L50;
            mergeAfterCellular(r8.getAfterCellular());
        L50:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L49:
            mergeAfterWifi(r8.getAfterWifi());
            goto L50
        L43:
            mergeBeforeWifi(r8.getBeforeWifi());
            goto L44
        }
    }

    static {
        DEFAULT_INSTANCE = new SwitchNetworkData();
        PARSER = new AnonymousClass1();
    }

    private SwitchNetworkData() {
        this.beforeNetworkCase_ = 0;
        this.afterNetworkCase_ = 0;
        this.switchMode_ = 0;
        this.switchReason_ = 0;
        this.foregroundApp_ = "";
        this.switchConsumeTime_ = 0;
        this.failedReason_ = 0;
        this.switchTimes_ = 0;
        this.timestamp_ = 0;
        this.solutionType_ = 0;
        this.isSuccess_ = false;
        this.switchSubReason_ = 0;
        this.memoizedIsInitialized = -1;
        this.foregroundApp_ = "";
    }

    public static /* synthetic */ long access$1002(SwitchNetworkData r8, long r10) {
        r8.timestamp_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1102(SwitchNetworkData r8, int r10) {
        r8.solutionType_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1202(SwitchNetworkData r8, boolean r10) {
        r8.isSuccess_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1302(SwitchNetworkData r8, int r10) {
        r8.switchSubReason_ = r10;
        return r10;
    }

    public static /* synthetic */ SwitchTakeTime access$1402(SwitchNetworkData r8, SwitchTakeTime r10) {
        r8.switchTakeTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1576(SwitchNetworkData r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ int access$1602(SwitchNetworkData r8, int r10) {
        r8.beforeNetworkCase_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1702(SwitchNetworkData r8, Object r10) {
        r8.beforeNetwork_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1802(SwitchNetworkData r8, int r10) {
        r8.afterNetworkCase_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$1902(SwitchNetworkData r8, Object r10) {
        r8.afterNetwork_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$200() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ int access$402(SwitchNetworkData r8, int r10) {
        r8.switchMode_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$502(SwitchNetworkData r8, int r10) {
        r8.switchReason_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$600(SwitchNetworkData r8) {
        return r8.foregroundApp_;
    }

    public static /* synthetic */ Object access$602(SwitchNetworkData r8, Object r10) {
        r8.foregroundApp_ = r10;
        return r10;
    }

    public static /* synthetic */ long access$702(SwitchNetworkData r8, long r10) {
        r8.switchConsumeTime_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(SwitchNetworkData r8, int r10) {
        r8.failedReason_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$902(SwitchNetworkData r8, int r10) {
        r8.switchTimes_ = r10;
        return r10;
    }

    public static SwitchNetworkData getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchNetworkData_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static SwitchNetworkData parseDelimitedFrom(InputStream r8) {
        return (SwitchNetworkData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static SwitchNetworkData parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<SwitchNetworkData> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof SwitchNetworkData) == false) goto L8;
        SwitchNetworkData r10 = (SwitchNetworkData) r8;
        if (hasSwitchMode() == r10.hasSwitchMode()) goto L13;
        return false;
    L13:
        if (hasSwitchMode() == false) goto L18;
        if (getSwitchMode() == r10.getSwitchMode()) goto L18;
        return false;
    L18:
        if (hasSwitchReason() == r10.hasSwitchReason()) goto L21;
        return false;
    L21:
        if (hasSwitchReason() == false) goto L26;
        if (getSwitchReason() == r10.getSwitchReason()) goto L26;
        return false;
    L26:
        if (hasForegroundApp() == r10.hasForegroundApp()) goto L29;
        return false;
    L29:
        if (hasForegroundApp() == false) goto L34;
        if (getForegroundApp().equals(r10.getForegroundApp()) == true) goto L34;
        return false;
    L34:
        if (hasSwitchConsumeTime() == r10.hasSwitchConsumeTime()) goto L37;
        return false;
    L37:
        if (hasSwitchConsumeTime() == false) goto L42;
        if (getSwitchConsumeTime() == r10.getSwitchConsumeTime()) goto L42;
        return false;
    L42:
        if (hasFailedReason() == r10.hasFailedReason()) goto L45;
        return false;
    L45:
        if (hasFailedReason() == false) goto L50;
        if (getFailedReason() == r10.getFailedReason()) goto L50;
        return false;
    L50:
        if (hasSwitchTimes() == r10.hasSwitchTimes()) goto L53;
        return false;
    L53:
        if (hasSwitchTimes() == false) goto L58;
        if (getSwitchTimes() == r10.getSwitchTimes()) goto L58;
        return false;
    L58:
        if (hasTimestamp() == r10.hasTimestamp()) goto L61;
        return false;
    L61:
        if (hasTimestamp() == false) goto L66;
        if (getTimestamp() == r10.getTimestamp()) goto L66;
        return false;
    L66:
        if (hasSolutionType() == r10.hasSolutionType()) goto L69;
        return false;
    L69:
        if (hasSolutionType() == false) goto L74;
        if (getSolutionType() == r10.getSolutionType()) goto L74;
        return false;
    L74:
        if (hasIsSuccess() == r10.hasIsSuccess()) goto L77;
        return false;
    L77:
        if (hasIsSuccess() == false) goto L82;
        if (getIsSuccess() == r10.getIsSuccess()) goto L82;
        return false;
    L82:
        if (hasSwitchSubReason() == r10.hasSwitchSubReason()) goto L85;
        return false;
    L85:
        if (hasSwitchSubReason() == false) goto L90;
        if (getSwitchSubReason() == r10.getSwitchSubReason()) goto L90;
        return false;
    L90:
        if (hasSwitchTakeTime() == r10.hasSwitchTakeTime()) goto L93;
        return false;
    L93:
        if (hasSwitchTakeTime() == false) goto L98;
        if (getSwitchTakeTime().equals(r10.getSwitchTakeTime()) == true) goto L98;
        return false;
    L98:
        if (getBeforeNetworkCase().equals(r10.getBeforeNetworkCase()) == true) goto L100;
        return false;
    L100:
        int r11 = this.beforeNetworkCase_;
        if (r11 == 7) goto L109;
        if (r11 != 8) goto L112;
        if (getBeforeCellular().equals(r10.getBeforeCellular()) == true) goto L112;
        return false;
    L112:
        if (getAfterNetworkCase().equals(r10.getAfterNetworkCase()) == true) goto L114;
        return false;
    L114:
        int r12 = this.afterNetworkCase_;
        if (r12 == 9) goto L123;
        if (r12 != 10) goto L126;
        if (getAfterCellular().equals(r10.getAfterCellular()) == true) goto L126;
        return false;
    L126:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L128;
        return false;
    L128:
        return true;
    L123:
        if (getAfterWifi().equals(r10.getAfterWifi()) == true) goto L126;
        return false;
    L109:
        if (getBeforeWifi().equals(r10.getBeforeWifi()) == true) goto L112;
        return false;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public CellularInfoData getAfterCellular() {
        if (this.afterNetworkCase_ != 10) goto L7;
        return (CellularInfoData) this.afterNetwork_;
    L7:
        return CellularInfoData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public CellularInfoDataOrBuilder getAfterCellularOrBuilder() {
        if (this.afterNetworkCase_ != 10) goto L7;
        return (CellularInfoData) this.afterNetwork_;
    L7:
        return CellularInfoData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public AfterNetworkCase getAfterNetworkCase() {
        return AfterNetworkCase.forNumber(this.afterNetworkCase_);
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public WifiInfoData getAfterWifi() {
        if (this.afterNetworkCase_ != 9) goto L7;
        return (WifiInfoData) this.afterNetwork_;
    L7:
        return WifiInfoData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public WifiInfoDataOrBuilder getAfterWifiOrBuilder() {
        if (this.afterNetworkCase_ != 9) goto L7;
        return (WifiInfoData) this.afterNetwork_;
    L7:
        return WifiInfoData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public CellularInfoData getBeforeCellular() {
        if (this.beforeNetworkCase_ != 8) goto L7;
        return (CellularInfoData) this.beforeNetwork_;
    L7:
        return CellularInfoData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public CellularInfoDataOrBuilder getBeforeCellularOrBuilder() {
        if (this.beforeNetworkCase_ != 8) goto L7;
        return (CellularInfoData) this.beforeNetwork_;
    L7:
        return CellularInfoData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public BeforeNetworkCase getBeforeNetworkCase() {
        return BeforeNetworkCase.forNumber(this.beforeNetworkCase_);
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public WifiInfoData getBeforeWifi() {
        if (this.beforeNetworkCase_ != 7) goto L7;
        return (WifiInfoData) this.beforeNetwork_;
    L7:
        return WifiInfoData.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public WifiInfoDataOrBuilder getBeforeWifiOrBuilder() {
        if (this.beforeNetworkCase_ != 7) goto L7;
        return (WifiInfoData) this.beforeNetwork_;
    L7:
        return WifiInfoData.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public int getFailedReason() {
        return this.failedReason_;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public String getForegroundApp() {
        Object r8 = this.foregroundApp_;
        if ((r8 instanceof String) == true) goto L5;
        ByteString r10 = (ByteString) r8;
        String r11 = r10.toStringUtf8();
        if (r10.isValidUtf8() == false) goto L9;
        this.foregroundApp_ = r11;
    L9:
        return r11;
    L5:
        return (String) r8;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public ByteString getForegroundAppBytes() {
        Object r8 = this.foregroundApp_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.foregroundApp_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean getIsSuccess() {
        return this.isSuccess_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<SwitchNetworkData> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if ((this.bitField0_ & 1) == 0) goto L9;
        r10 = 0 + CodedOutputStream.computeInt32Size(1, this.switchMode_);
    L9:
        if ((this.bitField0_ & 2) == 0) goto L12;
        r10 = r10 + CodedOutputStream.computeInt32Size(2, this.switchReason_);
    L12:
        if ((this.bitField0_ & 4) == 0) goto L15;
        r10 = r10 + GeneratedMessage.computeStringSize(3, this.foregroundApp_);
    L15:
        if ((this.bitField0_ & 8) == 0) goto L18;
        r10 = r10 + CodedOutputStream.computeInt64Size(4, this.switchConsumeTime_);
    L18:
        if ((this.bitField0_ & 16) == 0) goto L21;
        r10 = r10 + CodedOutputStream.computeInt32Size(5, this.failedReason_);
    L21:
        if ((this.bitField0_ & 32) == 0) goto L24;
        r10 = r10 + CodedOutputStream.computeInt32Size(6, this.switchTimes_);
    L24:
        if (this.beforeNetworkCase_ != 7) goto L27;
        r10 = r10 + CodedOutputStream.computeMessageSize(7, (WifiInfoData) this.beforeNetwork_);
    L27:
        if (this.beforeNetworkCase_ != 8) goto L30;
        r10 = r10 + CodedOutputStream.computeMessageSize(8, (CellularInfoData) this.beforeNetwork_);
    L30:
        if (this.afterNetworkCase_ != 9) goto L33;
        r10 = r10 + CodedOutputStream.computeMessageSize(9, (WifiInfoData) this.afterNetwork_);
    L33:
        if (this.afterNetworkCase_ != 10) goto L36;
        r10 = r10 + CodedOutputStream.computeMessageSize(10, (CellularInfoData) this.afterNetwork_);
    L36:
        if ((this.bitField0_ & 1024) == 0) goto L39;
        r10 = r10 + CodedOutputStream.computeInt64Size(11, this.timestamp_);
    L39:
        if ((this.bitField0_ & 2048) == 0) goto L42;
        r10 = r10 + CodedOutputStream.computeInt32Size(12, this.solutionType_);
    L42:
        if ((this.bitField0_ & 4096) == 0) goto L45;
        r10 = r10 + CodedOutputStream.computeBoolSize(13, this.isSuccess_);
    L45:
        if ((this.bitField0_ & 8192) == 0) goto L48;
        r10 = r10 + CodedOutputStream.computeInt32Size(14, this.switchSubReason_);
    L48:
        if ((this.bitField0_ & 16384) == 0) goto L50;
        r10 = r10 + CodedOutputStream.computeMessageSize(15, getSwitchTakeTime());
    L50:
        int r11 = getUnknownFields().getSerializedSize() + r10;
        this.memoizedSize = r11;
        return r11;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public int getSolutionType() {
        return this.solutionType_;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public long getSwitchConsumeTime() {
        return this.switchConsumeTime_;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public int getSwitchMode() {
        return this.switchMode_;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public int getSwitchReason() {
        return this.switchReason_;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public int getSwitchSubReason() {
        return this.switchSubReason_;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public SwitchTakeTime getSwitchTakeTime() {
        SwitchTakeTime r8 = this.switchTakeTime_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SwitchTakeTime.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public SwitchTakeTimeOrBuilder getSwitchTakeTimeOrBuilder() {
        SwitchTakeTime r8 = this.switchTakeTime_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SwitchTakeTime.getDefaultInstance();
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public int getSwitchTimes() {
        return this.switchTimes_;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public long getTimestamp() {
        return this.timestamp_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasAfterCellular() {
        if (this.afterNetworkCase_ != 10) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasAfterWifi() {
        if (this.afterNetworkCase_ != 9) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasBeforeCellular() {
        if (this.beforeNetworkCase_ != 8) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasBeforeWifi() {
        if (this.beforeNetworkCase_ != 7) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasFailedReason() {
        if ((this.bitField0_ & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasForegroundApp() {
        if ((this.bitField0_ & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasIsSuccess() {
        if ((this.bitField0_ & 4096) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasSolutionType() {
        if ((this.bitField0_ & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasSwitchConsumeTime() {
        if ((this.bitField0_ & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasSwitchMode() {
        if ((this.bitField0_ & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasSwitchReason() {
        if ((this.bitField0_ & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasSwitchSubReason() {
        if ((this.bitField0_ & 8192) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasSwitchTakeTime() {
        if ((this.bitField0_ & 16384) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasSwitchTimes() {
        if ((this.bitField0_ & 32) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.cae.network.SwitchNetworkDataOrBuilder
    public boolean hasTimestamp() {
        if ((this.bitField0_ & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
        if (hasSwitchMode() == false) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getSwitchMode();
    L9:
        if (hasSwitchReason() == false) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getSwitchReason();
    L12:
        if (hasForegroundApp() == false) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getForegroundApp().hashCode();
    L15:
        if (hasSwitchConsumeTime() == false) goto L18;
        r10 = b.a(r10, 37, 4, 53) + Internal.hashLong(getSwitchConsumeTime());
    L18:
        if (hasFailedReason() == false) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getFailedReason();
    L21:
        if (hasSwitchTimes() == false) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getSwitchTimes();
    L24:
        if (hasTimestamp() == false) goto L27;
        r10 = b.a(r10, 37, 11, 53) + Internal.hashLong(getTimestamp());
    L27:
        if (hasSolutionType() == false) goto L30;
        r10 = b.a(r10, 37, 12, 53) + getSolutionType();
    L30:
        if (hasIsSuccess() == false) goto L33;
        r10 = b.a(r10, 37, 13, 53) + Internal.hashBoolean(getIsSuccess());
    L33:
        if (hasSwitchSubReason() == false) goto L36;
        r10 = b.a(r10, 37, 14, 53) + getSwitchSubReason();
    L36:
        if (hasSwitchTakeTime() == false) goto L38;
        r10 = b.a(r10, 37, 15, 53) + getSwitchTakeTime().hashCode();
    L38:
        int r11 = this.beforeNetworkCase_;
        if (r11 != 7) goto L41;
        int r12 = b.a(r10, 37, 7, 53);
        int r13 = getBeforeWifi().hashCode();
    L45:
        r10 = r12 + r13;
    L46:
        int r14 = this.afterNetworkCase_;
        if (r14 != 9) goto L49;
        int r15 = b.a(r10, 37, 9, 53);
        int r16 = getAfterWifi().hashCode();
    L53:
        r10 = r15 + r16;
    L54:
        int r17 = getUnknownFields().hashCode();
        int r18 = r17 + (r10 * 29);
        this.memoizedHashCode = r18;
        return r18;
    L49:
        if (r14 != 10) goto L54;
        r15 = b.a(r10, 37, 10, 53);
        r16 = getAfterCellular().hashCode();
        goto L53
    L41:
        if (r11 != 8) goto L46;
        r12 = b.a(r10, 37, 8, 53);
        r13 = getBeforeCellular().hashCode();
        goto L45
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return internalGetFieldAccessorTable();
    }

    @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r8 = this.memoizedIsInitialized;
        if (r8 != 1) goto L5;
        return true;
    L5:
        if (r8 != 0) goto L8;
        return false;
    L8:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
        return new SwitchNetworkData();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if ((this.bitField0_ & 1) == 0) goto L6;
        r8.writeInt32(1, this.switchMode_);
    L6:
        if ((this.bitField0_ & 2) == 0) goto L9;
        r8.writeInt32(2, this.switchReason_);
    L9:
        if ((this.bitField0_ & 4) == 0) goto L12;
        GeneratedMessage.writeString(r8, 3, this.foregroundApp_);
    L12:
        if ((this.bitField0_ & 8) == 0) goto L15;
        r8.writeInt64(4, this.switchConsumeTime_);
    L15:
        if ((this.bitField0_ & 16) == 0) goto L18;
        r8.writeInt32(5, this.failedReason_);
    L18:
        if ((this.bitField0_ & 32) == 0) goto L21;
        r8.writeInt32(6, this.switchTimes_);
    L21:
        if (this.beforeNetworkCase_ != 7) goto L24;
        r8.writeMessage(7, (WifiInfoData) this.beforeNetwork_);
    L24:
        if (this.beforeNetworkCase_ != 8) goto L27;
        r8.writeMessage(8, (CellularInfoData) this.beforeNetwork_);
    L27:
        if (this.afterNetworkCase_ != 9) goto L30;
        r8.writeMessage(9, (WifiInfoData) this.afterNetwork_);
    L30:
        if (this.afterNetworkCase_ != 10) goto L33;
        r8.writeMessage(10, (CellularInfoData) this.afterNetwork_);
    L33:
        if ((this.bitField0_ & 1024) == 0) goto L36;
        r8.writeInt64(11, this.timestamp_);
    L36:
        if ((this.bitField0_ & 2048) == 0) goto L39;
        r8.writeInt32(12, this.solutionType_);
    L39:
        if ((this.bitField0_ & 4096) == 0) goto L42;
        r8.writeBool(13, this.isSuccess_);
    L42:
        if ((this.bitField0_ & 8192) == 0) goto L45;
        r8.writeInt32(14, this.switchSubReason_);
    L45:
        if ((this.bitField0_ & 16384) == 0) goto L47;
        r8.writeMessage(15, getSwitchTakeTime());
    L47:
        getUnknownFields().writeTo(r8);
    }

    private SwitchNetworkData(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.beforeNetworkCase_ = 0;
        this.afterNetworkCase_ = 0;
        this.switchMode_ = 0;
        this.switchReason_ = 0;
        this.foregroundApp_ = "";
        this.switchConsumeTime_ = 0;
        this.failedReason_ = 0;
        this.switchTimes_ = 0;
        this.timestamp_ = 0;
        this.solutionType_ = 0;
        this.isSuccess_ = false;
        this.switchSubReason_ = 0;
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(SwitchNetworkData r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static SwitchNetworkData parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (SwitchNetworkData) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static SwitchNetworkData parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetworkHandoverEvent.internal_static_com_obric_cae_network_SwitchNetworkData_fieldAccessorTable.ensureFieldAccessorsInitialized(SwitchNetworkData.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ SwitchNetworkData(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static SwitchNetworkData parseFrom(CodedInputStream r8) {
        return (SwitchNetworkData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public SwitchNetworkData getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r8 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r8);
    L6:
        return new Builder(r8).mergeFrom(this);
    }

    public static SwitchNetworkData parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (SwitchNetworkData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static SwitchNetworkData parseFrom(InputStream r8) {
        return (SwitchNetworkData) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static SwitchNetworkData parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (SwitchNetworkData) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static SwitchNetworkData parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static SwitchNetworkData parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static SwitchNetworkData parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static SwitchNetworkData parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
