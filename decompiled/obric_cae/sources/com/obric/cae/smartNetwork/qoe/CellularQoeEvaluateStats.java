package com.obric.cae.smartNetwork.qoe;

import android.aimedia.a;

/* JADX INFO: loaded from: classes2.dex */
public class CellularQoeEvaluateStats {
    public int errBitMap;
    public int ltePdcpLossRate;
    public int ltePdcpSendNum;
    public int ltePdcpTotalSendNum;
    public int lteRlfCauseType;
    public int nrPdcpLossRate;
    public int nrPdcpSendNum;
    public int nrPdcpTotalSendNum;
    public int nrRlfCauseType;
    public long recvBytes;
    public long recvRate;
    public long sendBytes;
    public long sendRate;
    public int slotId;

    public CellularQoeEvaluateStats() {
    }

    public CellularQoeEvaluateStats(CellularQoeEvaluateStats r8) {
        this.slotId = r8.slotId;
        this.lteRlfCauseType = r8.lteRlfCauseType;
        this.ltePdcpSendNum = r8.ltePdcpSendNum;
        this.ltePdcpTotalSendNum = r8.ltePdcpTotalSendNum;
        this.ltePdcpLossRate = r8.ltePdcpLossRate;
        this.nrRlfCauseType = r8.nrRlfCauseType;
        this.nrPdcpSendNum = r8.nrPdcpSendNum;
        this.nrPdcpTotalSendNum = r8.nrPdcpTotalSendNum;
        this.nrPdcpLossRate = r8.nrPdcpLossRate;
        this.sendBytes = r8.sendBytes;
        this.recvBytes = r8.recvBytes;
        this.sendRate = r8.sendRate;
        this.recvRate = r8.recvRate;
        this.errBitMap = r8.errBitMap;
    }

    public String toString() {
        StringBuilder r8 = new StringBuilder(" CellularQoeEvaluateStats{slotId=");
        r8.append(this.slotId);
        r8.append(", lteRlfCauseType=");
        r8.append(this.lteRlfCauseType);
        r8.append(", ltePdcpSendNum=");
        r8.append(this.ltePdcpSendNum);
        r8.append(", ltePdcpTotalSendNum=");
        r8.append(this.ltePdcpTotalSendNum);
        r8.append(", ltePdcpLossRate=");
        r8.append(this.ltePdcpLossRate);
        r8.append(", nrRlfCauseType=");
        r8.append(this.nrRlfCauseType);
        r8.append(", nrPdcpSendNum=");
        r8.append(this.nrPdcpSendNum);
        r8.append(", nrPdcpTotalSendNum=");
        r8.append(this.nrPdcpTotalSendNum);
        r8.append(", nrPdcpLossRate=");
        r8.append(this.nrPdcpLossRate);
        r8.append(", sendBytes=");
        r8.append(this.sendBytes);
        r8.append(", recvBytes=");
        r8.append(this.recvBytes);
        r8.append(", sendRate=");
        r8.append(this.sendRate);
        r8.append(", recvRate=");
        r8.append(this.recvRate);
        r8.append(", errBitMap=");
        return a.f(r8, this.errBitMap, '}');
    }
}
