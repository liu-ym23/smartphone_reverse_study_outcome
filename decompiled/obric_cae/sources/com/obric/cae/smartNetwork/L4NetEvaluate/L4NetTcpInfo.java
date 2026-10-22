package com.obric.cae.smartNetwork.L4NetEvaluate;

import com.cae.caed.net.L4NetInfoParcel;

/* JADX INFO: loaded from: classes2.dex */
public class L4NetTcpInfo extends L4NetInfoParcel {
    public int lastUpdateTime;

    public L4NetTcpInfo() {
        this.ifName = "";
        this.srcIP = "";
        this.dstIP = "";
    }

    public L4NetTcpInfo(L4NetInfoParcel r8) {
        this.ifName = r8.ifName;
        this.family = r8.family;
        this.state = r8.state;
        this.srcIP = r8.srcIP;
        this.dstIP = r8.dstIP;
        this.srcPort = r8.srcPort;
        this.dstPort = r8.dstPort;
        this.uid = r8.uid;
        this.tcpSendBytes = r8.tcpSendBytes;
        this.tcpRecvBytes = r8.tcpRecvBytes;
        this.tcpRtt = r8.tcpRtt;
        this.tcpTotalRetrans = r8.tcpTotalRetrans;
        this.tcpTotalDataSegsOut = r8.tcpTotalDataSegsOut;
        this.tcpTotalDataSegsIn = r8.tcpTotalDataSegsIn;
        this.tcpiUnacked = r8.tcpiUnacked;
        this.tcpRecvOoopack = r8.tcpRecvOoopack;
        this.tcpTotalSegsOut = r8.tcpTotalSegsOut;
        this.tcpTotalSegsIn = r8.tcpTotalSegsIn;
        this.tcpSndSsthresh = r8.tcpSndSsthresh;
        this.tcpSndCwnd = r8.tcpSndCwnd;
        this.cookie = r8.cookie;
        this.lastUpdateTime = 0;
    }

    public L4NetTcpInfo(L4NetTcpInfo r8) {
        this.ifName = r8.ifName;
        this.family = r8.family;
        this.state = r8.state;
        this.srcIP = r8.srcIP;
        this.dstIP = r8.dstIP;
        this.srcPort = r8.srcPort;
        this.dstPort = r8.dstPort;
        this.uid = r8.uid;
        this.tcpSendBytes = r8.tcpSendBytes;
        this.tcpRecvBytes = r8.tcpRecvBytes;
        this.tcpRtt = r8.tcpRtt;
        this.tcpTotalRetrans = r8.tcpTotalRetrans;
        this.tcpTotalDataSegsOut = r8.tcpTotalDataSegsOut;
        this.tcpTotalDataSegsIn = r8.tcpTotalDataSegsIn;
        this.tcpiUnacked = r8.tcpiUnacked;
        this.tcpRecvOoopack = r8.tcpRecvOoopack;
        this.tcpTotalSegsOut = r8.tcpTotalSegsOut;
        this.tcpTotalSegsIn = r8.tcpTotalSegsIn;
        this.tcpSndSsthresh = r8.tcpSndSsthresh;
        this.tcpSndCwnd = r8.tcpSndCwnd;
        this.cookie = r8.cookie;
        this.lastUpdateTime = r8.lastUpdateTime;
    }
}
