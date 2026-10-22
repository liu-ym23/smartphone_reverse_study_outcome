package com.obric.cae.smartNetwork.networkHandoverRL.feature;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class FeatureData implements Parcelable {
    public static final Parcelable.Creator<FeatureData> CREATOR = null;
    private int appCategory;
    private int appSpeedRate;
    private int cellL2State;
    private int cellRemainingTraffic;
    private int cellUsedTraffic;
    private int curLocation;
    private int d7CellAppUsed;
    private int d7CellTotalUsed;
    private int d7TrafficAppUsed;
    private long index;
    private String packageName;
    private long timeStamp;
    private int totalSpeedRate;
    private int wifiBand;
    private int wifiL2RxTput;
    private int wifiL2TxTput;
    private int wifiL4RecvOooRate;
    private int wifiL4RecvPkts;
    private int wifiL4RecvSpeed;
    private int wifiL4RetryRate;
    private int wifiL4Rtt;
    private int wifiL4SendPkts;
    private int wifiL4SendSpeed;
    private int wifiL4UnackPkts;
    private int wifiRssi;

    public static class Builder {
        private int appCategory;
        private int appSpeedRate;
        private int cellL2State;
        private int cellRemainingTraffic;
        private int cellUsedTraffic;
        private int curLocation;
        private int d7CellAppUsed;
        private int d7CellTotalUsed;
        private int d7TrafficAppUsed;
        private long index;
        private String packageName;
        private long timeStamp;
        private int totalSpeedRate;
        private int wifiBand;
        private int wifiL2RxTput;
        private int wifiL2TxTput;
        private int wifiL4RecvOooRate;
        private int wifiL4RecvPkts;
        private int wifiL4RecvSpeed;
        private int wifiL4RetryRate;
        private int wifiL4Rtt;
        private int wifiL4SendPkts;
        private int wifiL4SendSpeed;
        private int wifiL4UnackPkts;
        private int wifiRssi;

        public Builder() {
            this.cellUsedTraffic = 0;
            this.cellRemainingTraffic = 0;
            this.packageName = "";
            this.appCategory = 0;
            this.d7CellAppUsed = 0;
            this.d7CellTotalUsed = 0;
            this.d7TrafficAppUsed = 0;
            this.appSpeedRate = 0;
            this.totalSpeedRate = 0;
            this.curLocation = 0;
            this.wifiL2TxTput = 0;
            this.wifiL2RxTput = 0;
            this.wifiBand = 0;
            this.wifiRssi = 0;
            this.wifiL4Rtt = 0;
            this.wifiL4SendPkts = 0;
            this.wifiL4RecvPkts = 0;
            this.wifiL4RecvOooRate = 0;
            this.wifiL4UnackPkts = 0;
            this.wifiL4RetryRate = 0;
            this.wifiL4SendSpeed = 0;
            this.wifiL4RecvSpeed = 0;
            this.cellL2State = 0;
            this.index = 0;
            this.timeStamp = 0;
        }

        public static /* synthetic */ int access$000(Builder r8) {
            return r8.cellUsedTraffic;
        }

        public static /* synthetic */ int access$100(Builder r8) {
            return r8.cellRemainingTraffic;
        }

        public static /* synthetic */ int access$1000(Builder r8) {
            return r8.wifiL2TxTput;
        }

        public static /* synthetic */ int access$1100(Builder r8) {
            return r8.wifiL2RxTput;
        }

        public static /* synthetic */ int access$1200(Builder r8) {
            return r8.wifiBand;
        }

        public static /* synthetic */ int access$1300(Builder r8) {
            return r8.wifiRssi;
        }

        public static /* synthetic */ int access$1400(Builder r8) {
            return r8.wifiL4Rtt;
        }

        public static /* synthetic */ int access$1500(Builder r8) {
            return r8.wifiL4SendPkts;
        }

        public static /* synthetic */ int access$1600(Builder r8) {
            return r8.wifiL4RecvPkts;
        }

        public static /* synthetic */ int access$1700(Builder r8) {
            return r8.wifiL4RecvOooRate;
        }

        public static /* synthetic */ int access$1800(Builder r8) {
            return r8.wifiL4UnackPkts;
        }

        public static /* synthetic */ int access$1900(Builder r8) {
            return r8.wifiL4RetryRate;
        }

        public static /* synthetic */ String access$200(Builder r8) {
            return r8.packageName;
        }

        public static /* synthetic */ int access$2000(Builder r8) {
            return r8.wifiL4SendSpeed;
        }

        public static /* synthetic */ int access$2100(Builder r8) {
            return r8.wifiL4RecvSpeed;
        }

        public static /* synthetic */ int access$2200(Builder r8) {
            return r8.cellL2State;
        }

        public static /* synthetic */ long access$2300(Builder r8) {
            return r8.index;
        }

        public static /* synthetic */ long access$2400(Builder r8) {
            return r8.timeStamp;
        }

        public static /* synthetic */ int access$300(Builder r8) {
            return r8.appCategory;
        }

        public static /* synthetic */ int access$400(Builder r8) {
            return r8.d7CellAppUsed;
        }

        public static /* synthetic */ int access$500(Builder r8) {
            return r8.d7CellTotalUsed;
        }

        public static /* synthetic */ int access$600(Builder r8) {
            return r8.d7TrafficAppUsed;
        }

        public static /* synthetic */ int access$700(Builder r8) {
            return r8.appSpeedRate;
        }

        public static /* synthetic */ int access$800(Builder r8) {
            return r8.totalSpeedRate;
        }

        public static /* synthetic */ int access$900(Builder r8) {
            return r8.curLocation;
        }

        public FeatureData build() {
            return new FeatureData(this, null);
        }

        public Builder setAppCategory(int r8) {
            this.appCategory = r8;
            return this;
        }

        public Builder setAppSpeedRate(int r8) {
            this.appSpeedRate = r8;
            return this;
        }

        public Builder setCellL2State(int r8) {
            this.cellL2State = r8;
            return this;
        }

        public Builder setCellRemainingTraffic(int r8) {
            this.cellRemainingTraffic = r8;
            return this;
        }

        public Builder setCellUsedTraffic(int r8) {
            this.cellUsedTraffic = r8;
            return this;
        }

        public Builder setCurLocation(int r8) {
            this.curLocation = r8;
            return this;
        }

        public Builder setD7CellAppUsed(int r8) {
            this.d7CellAppUsed = r8;
            return this;
        }

        public Builder setD7CellTotalUsed(int r8) {
            this.d7CellTotalUsed = r8;
            return this;
        }

        public Builder setD7TrafficAppUsed(int r8) {
            this.d7TrafficAppUsed = r8;
            return this;
        }

        public Builder setIndex(long r8) {
            this.index = r8;
            return this;
        }

        public Builder setPackageName(String r8) {
            this.packageName = r8;
            return this;
        }

        public Builder setTimeStamp(long r8) {
            this.timeStamp = r8;
            return this;
        }

        public Builder setTotalSpeedRate(int r8) {
            this.totalSpeedRate = r8;
            return this;
        }

        public Builder setWifiBand(int r8) {
            this.wifiBand = r8;
            return this;
        }

        public Builder setWifiL2RxTput(int r8) {
            this.wifiL2RxTput = r8;
            return this;
        }

        public Builder setWifiL2TxTput(int r8) {
            this.wifiL2TxTput = r8;
            return this;
        }

        public Builder setWifiL4RecvOooRate(int r8) {
            this.wifiL4RecvOooRate = r8;
            return this;
        }

        public Builder setWifiL4RecvPkts(int r8) {
            this.wifiL4RecvPkts = r8;
            return this;
        }

        public Builder setWifiL4RecvSpeed(int r8) {
            this.wifiL4RecvSpeed = r8;
            return this;
        }

        public Builder setWifiL4RetryRate(int r8) {
            this.wifiL4RetryRate = r8;
            return this;
        }

        public Builder setWifiL4Rtt(int r8) {
            this.wifiL4Rtt = r8;
            return this;
        }

        public Builder setWifiL4SendPkts(int r8) {
            this.wifiL4SendPkts = r8;
            return this;
        }

        public Builder setWifiL4SendSpeed(int r8) {
            this.wifiL4SendSpeed = r8;
            return this;
        }

        public Builder setWifiL4UnackPkts(int r8) {
            this.wifiL4UnackPkts = r8;
            return this;
        }

        public Builder setWifiRssi(int r8) {
            this.wifiRssi = r8;
            return this;
        }
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public FeatureData(Parcel r8) {
        this.cellUsedTraffic = r8.readInt();
        this.cellRemainingTraffic = r8.readInt();
        this.packageName = r8.readString();
        this.appCategory = r8.readInt();
        this.d7CellAppUsed = r8.readInt();
        this.d7CellTotalUsed = r8.readInt();
        this.d7TrafficAppUsed = r8.readInt();
        this.appSpeedRate = r8.readInt();
        this.totalSpeedRate = r8.readInt();
        this.curLocation = r8.readInt();
        this.wifiL2TxTput = r8.readInt();
        this.wifiL2RxTput = r8.readInt();
        this.wifiBand = r8.readInt();
        this.wifiRssi = r8.readInt();
        this.wifiL4Rtt = r8.readInt();
        this.wifiL4SendPkts = r8.readInt();
        this.wifiL4RecvPkts = r8.readInt();
        this.wifiL4RecvOooRate = r8.readInt();
        this.wifiL4UnackPkts = r8.readInt();
        this.wifiL4RetryRate = r8.readInt();
        this.wifiL4SendSpeed = r8.readInt();
        this.wifiL4RecvSpeed = r8.readInt();
        this.cellL2State = r8.readInt();
        this.index = r8.readLong();
        this.timeStamp = r8.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAppCategory() {
        return this.appCategory;
    }

    public int getAppSpeedRate() {
        return this.appSpeedRate;
    }

    public int getCellL2State() {
        return this.cellL2State;
    }

    public int getCellRemainingTraffic() {
        return this.cellRemainingTraffic;
    }

    public int getCellUsedTraffic() {
        return this.cellUsedTraffic;
    }

    public int getCurLocation() {
        return this.curLocation;
    }

    public int getD7CellAppUsed() {
        return this.d7CellAppUsed;
    }

    public int getD7CellTotalUsed() {
        return this.d7CellTotalUsed;
    }

    public int getD7TrafficAppUsed() {
        return this.d7TrafficAppUsed;
    }

    public long getIndex() {
        return this.index;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public int getTotalSpeedRate() {
        return this.totalSpeedRate;
    }

    public int getWifiBand() {
        return this.wifiBand;
    }

    public int getWifiL2RxTput() {
        return this.wifiL2RxTput;
    }

    public int getWifiL2TxTput() {
        return this.wifiL2TxTput;
    }

    public int getWifiL4RecvOooRate() {
        return this.wifiL4RecvOooRate;
    }

    public int getWifiL4RecvPkts() {
        return this.wifiL4RecvPkts;
    }

    public int getWifiL4RecvSpeed() {
        return this.wifiL4RecvSpeed;
    }

    public int getWifiL4RetryRate() {
        return this.wifiL4RetryRate;
    }

    public int getWifiL4Rtt() {
        return this.wifiL4Rtt;
    }

    public int getWifiL4SendPkts() {
        return this.wifiL4SendPkts;
    }

    public int getWifiL4SendSpeed() {
        return this.wifiL4SendSpeed;
    }

    public int getWifiL4UnackPkts() {
        return this.wifiL4UnackPkts;
    }

    public int getWifiRssi() {
        return this.wifiRssi;
    }

    public String toString() {
        return "FeatureData{cellUsedTraffic=" + this.cellUsedTraffic + "MB, cellRemainingTraffic=" + this.cellRemainingTraffic + "MB, packageName=" + this.packageName + ", appCategory=" + this.appCategory + ", d7CellAppUsed=" + this.d7CellAppUsed + "MB, d7CellTotalUsed=" + this.d7CellTotalUsed + "MB, d7TrafficAppUsed=" + this.d7TrafficAppUsed + "MB, appSpeedRate=" + (this.appSpeedRate / 1024) + "KBps, totalSpeedRate=" + (this.totalSpeedRate / 1024) + "KBps, curLocation=" + this.curLocation + ", wifiL2TxTput=" + this.wifiL2TxTput + "Kbps, wifiL2RxTput=" + this.wifiL2RxTput + "Kbps, wifiBand=" + this.wifiBand + ", wifiRssi=" + this.wifiRssi + ", wifiL4Rtt=" + this.wifiL4Rtt + ", wifiL4SendPkts=" + this.wifiL4SendPkts + ", wifiL4RecvPkts=" + this.wifiL4RecvPkts + ", wifiL4RecvOooRate=" + this.wifiL4RecvOooRate + ", wifiL4UnackPkts=" + this.wifiL4UnackPkts + ", wifiL4RetryRate=" + this.wifiL4RetryRate + ", wifiL4SendSpeed=" + (this.wifiL4SendSpeed / 1024) + "KBps, wifiL4RecvSpeed=" + (this.wifiL4RecvSpeed / 1024) + "KBps, cellL2State=" + this.cellL2State + ", index=" + this.index + ", timeStamp=" + this.timeStamp + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeLong(this.cellUsedTraffic);
        r8.writeLong(this.cellRemainingTraffic);
        r8.writeString(this.packageName);
        r8.writeInt(this.appCategory);
        r8.writeLong(this.d7CellAppUsed);
        r8.writeLong(this.d7CellTotalUsed);
        r8.writeLong(this.d7TrafficAppUsed);
        r8.writeFloat(this.appSpeedRate);
        r8.writeFloat(this.totalSpeedRate);
        r8.writeInt(this.curLocation);
        r8.writeInt(this.wifiL2TxTput);
        r8.writeInt(this.wifiL2RxTput);
        r8.writeInt(this.wifiBand);
        r8.writeInt(this.wifiRssi);
        r8.writeInt(this.wifiL4Rtt);
        r8.writeInt(this.wifiL4SendPkts);
        r8.writeInt(this.wifiL4RecvPkts);
        r8.writeFloat(this.wifiL4RecvOooRate);
        r8.writeInt(this.wifiL4UnackPkts);
        r8.writeFloat(this.wifiL4RetryRate);
        r8.writeInt(this.wifiL4SendSpeed);
        r8.writeInt(this.wifiL4RecvSpeed);
        r8.writeInt(this.cellL2State);
        r8.writeLong(this.index);
        r8.writeLong(this.timeStamp);
    }

    private FeatureData(Builder r8) {
        this.cellUsedTraffic = Builder.access$000(r8);
        this.cellRemainingTraffic = Builder.access$100(r8);
        this.packageName = Builder.access$200(r8);
        this.appCategory = Builder.access$300(r8);
        this.d7CellAppUsed = Builder.access$400(r8);
        this.d7CellTotalUsed = Builder.access$500(r8);
        this.d7TrafficAppUsed = Builder.access$600(r8);
        this.appSpeedRate = Builder.access$700(r8);
        this.totalSpeedRate = Builder.access$800(r8);
        this.curLocation = Builder.access$900(r8);
        this.wifiL2TxTput = Builder.access$1000(r8);
        this.wifiL2RxTput = Builder.access$1100(r8);
        this.wifiBand = Builder.access$1200(r8);
        this.wifiRssi = Builder.access$1300(r8);
        this.wifiL4Rtt = Builder.access$1400(r8);
        this.wifiL4SendPkts = Builder.access$1500(r8);
        this.wifiL4RecvPkts = Builder.access$1600(r8);
        this.wifiL4RecvOooRate = Builder.access$1700(r8);
        this.wifiL4UnackPkts = Builder.access$1800(r8);
        this.wifiL4RetryRate = Builder.access$1900(r8);
        this.wifiL4SendSpeed = Builder.access$2000(r8);
        this.wifiL4RecvSpeed = Builder.access$2100(r8);
        this.cellL2State = Builder.access$2200(r8);
        this.index = Builder.access$2300(r8);
        this.timeStamp = Builder.access$2400(r8);
    }

    public /* synthetic */ FeatureData(Builder r8, AnonymousClass1 r10) {
        this(r8);
    }
}
