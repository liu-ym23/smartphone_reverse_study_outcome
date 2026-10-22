package com.obric.cae.libs.l4NetStatus;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class QoeStatus implements Parcelable {
    public static final Parcelable.Creator<QoeStatus> CREATOR = null;
    public String appPackageName;
    public int errBitMap;
    public String ifName;
    public int recvOooPercent;
    public int recvPackets;
    public int recvRate;
    public int rttAve;
    public int sendPackets;
    public int sendRate;
    public int sendRetrans;
    public int statSrcType;
    public int streamNum;
    public int tcpSndCwnd;
    public int tcpSndSsthresh;
    public long totalRecvBytes;
    public long totalRecvPackets;
    public long totalSegsIn;
    public long totalSegsOut;
    public long totalSendBytes;
    public long totalSendPackets;
    public int uid;
    public int unacked;

    public class a implements Parcelable.Creator<QoeStatus> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QoeStatus createFromParcel(Parcel r8) {
            return new QoeStatus(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final QoeStatus[] newArray(int r8) {
            return new QoeStatus[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public QoeStatus() {
        this.statSrcType = 0;
        this.appPackageName = "NULL";
        this.ifName = "NULL";
    }

    public void clear() {
        this.statSrcType = 0;
        this.uid = 0;
        this.appPackageName = "NULL";
        this.ifName = "NULL";
        this.streamNum = 0;
        this.rttAve = 0;
        this.totalSendPackets = 0;
        this.totalRecvPackets = 0;
        this.totalSegsOut = 0;
        this.totalSegsIn = 0;
        this.totalSendBytes = 0;
        this.totalRecvBytes = 0;
        this.sendPackets = 0;
        this.recvPackets = 0;
        this.sendRate = 0;
        this.recvRate = 0;
        this.sendRetrans = 0;
        this.recvOooPercent = 0;
        this.unacked = 0;
        this.tcpSndSsthresh = 0;
        this.tcpSndCwnd = 0;
        this.errBitMap = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public int getErrBitMap() {
        return this.errBitMap;
    }

    public String getIfName() {
        return this.ifName;
    }

    public int getRecvOooPercent() {
        return this.recvOooPercent;
    }

    public int getRecvPackets() {
        return this.recvPackets;
    }

    public int getRecvRate() {
        return this.recvRate;
    }

    public int getRttAve() {
        return this.rttAve;
    }

    public int getSendPackets() {
        return this.sendPackets;
    }

    public int getSendRate() {
        return this.sendRate;
    }

    public int getSendRetrans() {
        return this.sendRetrans;
    }

    public int getStatSrcType() {
        return this.statSrcType;
    }

    public int getStreamNum() {
        return this.streamNum;
    }

    public int getTcpSndCwnd() {
        return this.tcpSndCwnd;
    }

    public int getTcpSndSsthresh() {
        return this.tcpSndSsthresh;
    }

    public long getTotalRecvBytes() {
        return this.totalRecvBytes;
    }

    public long getTotalRecvPackets() {
        return this.totalRecvPackets;
    }

    public long getTotalSegsIn() {
        return this.totalSegsIn;
    }

    public long getTotalSegsOut() {
        return this.totalSegsOut;
    }

    public long getTotalSendBytes() {
        return this.totalSendBytes;
    }

    public long getTotalSendPackets() {
        return this.totalSendPackets;
    }

    public int getUid() {
        return this.uid;
    }

    public int getUnacked() {
        return this.unacked;
    }

    public void setAppPackageName(String r8) {
        this.appPackageName = r8;
    }

    public void setErrBitMap(int r8) {
        this.errBitMap = r8;
    }

    public void setIfName(String r8) {
        this.ifName = r8;
    }

    public void setRecvOooPercent(int r8) {
        this.recvOooPercent = r8;
    }

    public void setRecvPackets(int r8) {
        this.recvPackets = r8;
    }

    public void setRecvRate(int r8) {
        this.recvRate = r8;
    }

    public void setRttAve(int r8) {
        this.rttAve = r8;
    }

    public void setSendPackets(int r8) {
        this.sendPackets = r8;
    }

    public void setSendRate(int r8) {
        this.sendRate = r8;
    }

    public void setSendRetrans(int r8) {
        this.sendRetrans = r8;
    }

    public void setStatSrcType(int r8) {
        this.statSrcType = r8;
    }

    public void setStreamNum(int r8) {
        this.streamNum = r8;
    }

    public void setTcpSndCwnd(int r8) {
        this.tcpSndCwnd = r8;
    }

    public void setTcpSndSsthresh(int r8) {
        this.tcpSndSsthresh = r8;
    }

    public void setTotalRecvBytes(long r8) {
        this.totalRecvBytes = r8;
    }

    public void setTotalRecvPackets(long r8) {
        this.totalRecvPackets = r8;
    }

    public void setTotalSegsIn(long r8) {
        this.totalSegsIn = r8;
    }

    public void setTotalSegsOut(long r8) {
        this.totalSegsOut = r8;
    }

    public void setTotalSendBytes(long r8) {
        this.totalSendBytes = r8;
    }

    public void setTotalSendPackets(long r8) {
        this.totalSendPackets = r8;
    }

    public void setUid(int r8) {
        this.uid = r8;
    }

    public void setUnacked(int r8) {
        this.unacked = r8;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder("QoeStatus{statSrcType=");
        r8.append(this.statSrcType);
        r8.append(", uid=");
        r8.append(this.uid);
        r8.append(", appPackageName='");
        r8.append(this.appPackageName);
        r8.append("', ifName='");
        r8.append(this.ifName);
        r8.append("', streamNum=");
        r8.append(this.streamNum);
        r8.append(", rttAve=");
        r8.append(this.rttAve);
        r8.append(", totalSendPackets=");
        r8.append(this.totalSendPackets);
        r8.append(", totalRecvPackets=");
        r8.append(this.totalRecvPackets);
        r8.append(", totalSegsOut=");
        r8.append(this.totalSegsOut);
        r8.append(", totalSegsIn=");
        r8.append(this.totalSegsIn);
        r8.append(", totalSendBytes=");
        r8.append(this.totalSendBytes);
        r8.append(", totalRecvBytes=");
        r8.append(this.totalRecvBytes);
        r8.append(", sendPackets=");
        r8.append(this.sendPackets);
        r8.append(", recvPackets=");
        r8.append(this.recvPackets);
        r8.append(", sendRate=");
        r8.append(this.sendRate);
        r8.append(", recvRate=");
        r8.append(this.recvRate);
        r8.append(", sendRetrans=");
        r8.append(this.sendRetrans);
        r8.append(", recvOooPercent=");
        r8.append(this.recvOooPercent);
        r8.append(", unacked=");
        r8.append(this.unacked);
        r8.append(", errBitMap=");
        r8.append(this.errBitMap);
        r8.append(", tcpSndSsthresh=");
        r8.append(this.tcpSndSsthresh);
        r8.append(", tcpSndCwnd=");
        return android.aimedia.a.f(r8, this.tcpSndCwnd, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r8, int r10) {
        r8.writeInt(this.statSrcType);
        r8.writeInt(this.uid);
        r8.writeString(this.appPackageName);
        r8.writeString(this.ifName);
        r8.writeInt(this.streamNum);
        r8.writeInt(this.rttAve);
        r8.writeLong(this.totalSendPackets);
        r8.writeLong(this.totalRecvPackets);
        r8.writeLong(this.totalSegsOut);
        r8.writeLong(this.totalSegsIn);
        r8.writeLong(this.totalSendBytes);
        r8.writeLong(this.totalRecvBytes);
        r8.writeInt(this.sendPackets);
        r8.writeInt(this.recvPackets);
        r8.writeInt(this.sendRate);
        r8.writeInt(this.recvRate);
        r8.writeInt(this.sendRetrans);
        r8.writeInt(this.recvOooPercent);
        r8.writeInt(this.unacked);
        r8.writeInt(this.tcpSndSsthresh);
        r8.writeInt(this.tcpSndCwnd);
        r8.writeInt(this.errBitMap);
    }

    public QoeStatus(Parcel r8) {
        this.statSrcType = r8.readInt();
        this.uid = r8.readInt();
        this.appPackageName = r8.readString();
        this.ifName = r8.readString();
        this.streamNum = r8.readInt();
        this.rttAve = r8.readInt();
        this.totalSendPackets = r8.readLong();
        this.totalRecvPackets = r8.readLong();
        this.totalSegsOut = r8.readLong();
        this.totalSegsIn = r8.readLong();
        this.totalSendBytes = r8.readLong();
        this.totalRecvBytes = r8.readLong();
        this.sendPackets = r8.readInt();
        this.recvPackets = r8.readInt();
        this.sendRate = r8.readInt();
        this.recvRate = r8.readInt();
        this.sendRetrans = r8.readInt();
        this.recvOooPercent = r8.readInt();
        this.unacked = r8.readInt();
        this.tcpSndSsthresh = r8.readInt();
        this.tcpSndCwnd = r8.readInt();
        this.errBitMap = r8.readInt();
    }

    public QoeStatus(QoeStatus r8) {
        this.statSrcType = r8.statSrcType;
        this.uid = r8.uid;
        this.appPackageName = r8.appPackageName;
        this.ifName = r8.ifName;
        this.streamNum = r8.streamNum;
        this.rttAve = r8.rttAve;
        this.totalSendPackets = r8.totalSendPackets;
        this.totalRecvPackets = r8.totalRecvPackets;
        this.totalSegsOut = r8.totalSegsOut;
        this.totalSegsIn = r8.totalSegsIn;
        this.totalSendBytes = r8.totalSendBytes;
        this.totalRecvBytes = r8.totalRecvBytes;
        this.sendPackets = r8.sendPackets;
        this.recvPackets = r8.recvPackets;
        this.sendRate = r8.sendRate;
        this.recvRate = r8.recvRate;
        this.sendRetrans = r8.sendRetrans;
        this.recvOooPercent = r8.recvOooPercent;
        this.unacked = r8.unacked;
        this.tcpSndSsthresh = r8.tcpSndSsthresh;
        this.tcpSndCwnd = r8.tcpSndCwnd;
        this.errBitMap = r8.errBitMap;
    }
}
