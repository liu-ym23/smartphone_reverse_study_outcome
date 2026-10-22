package com.bytedance.bdlocation.network.model;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.location.database.StarCellDbManager;
import com.obric.cae.wifi.WiFiDBHelper;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class BssInfo {

    @b("bid")
    public int bid;

    @b("bsss")
    public long bsss;

    @b("bw")
    public int bw;

    @b("ci")
    public int ci;

    @b(StarCellDbManager.CellInfoEntry.CID)
    public long cid;

    @b("cpid")
    public int cpid;

    @b("earfcn")
    public int earfcn;

    @b("is_registered")
    public boolean isRegistered;

    @b(StarCellDbManager.CellInfoEntry.LAC)
    public long lac;

    @b("lat")
    public int lat;

    @b("longi")
    public int longi;

    @b(StarCellDbManager.CellInfoEntry.MCC)
    public long mcc;

    @b(StarCellDbManager.CellInfoEntry.MNC)
    public long mnc;

    @b("nci")
    public long nci;

    @b("nid")
    public int nid;

    @b("pci")
    public int pci;

    @b("psc")
    public long psc;

    @b("radio_type")
    public String radioType;

    @b(WiFiDBHelper.COL_RSSI)
    public long rssi;

    @b(WsConstants.KEY_SESSION_ID)
    public int sid;

    @b("tac")
    public int tac;

    @b("timestamp")
    public long timestamp;

    public BssInfo() {
    }
}
