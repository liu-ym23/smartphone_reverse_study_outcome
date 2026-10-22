package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class BssInfo {

    @SerializedName("bid")
    public int bid;

    @SerializedName("bsss")
    public long bsss;

    @SerializedName("bw")
    public int bw;

    @SerializedName("ci")
    public int ci;

    @SerializedName("cid")
    public long cid;

    @SerializedName("cpid")
    public int cpid;

    @SerializedName("earfcn")
    public int earfcn;

    @SerializedName("is_registered")
    public boolean isRegistered;

    @SerializedName("lac")
    public long lac;

    @SerializedName("lat")
    public int lat;

    @SerializedName("longi")
    public int longi;

    @SerializedName("mcc")
    public long mcc;

    @SerializedName("mnc")
    public long mnc;

    @SerializedName("nci")
    public long nci;

    @SerializedName("nid")
    public int nid;

    @SerializedName("pci")
    public int pci;

    @SerializedName("psc")
    public long psc;

    @SerializedName("radio_type")
    public String radioType;

    @SerializedName("rssi")
    public long rssi;

    @SerializedName("sid")
    public int sid;

    @SerializedName("tac")
    public int tac;

    @SerializedName("timestamp")
    public long timestamp;

    public BssInfo() {
    }
}
