package com.obric.cae.smartNetwork.fastReconnect;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CellNetworkInfo {
    private long mCellId;
    private List<String> mNetworkList;

    public CellNetworkInfo() {
    }

    public CellNetworkInfo(long r8, List<String> r10) {
        this.mCellId = r8;
        this.mNetworkList = r10;
    }

    public String addNetwork(String r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        if (this.mNetworkList.contains(r8) == true) goto L8;
        this.mNetworkList.add(r8);
    L8:
        return r8;
    }

    public long getCellId() {
        return this.mCellId;
    }

    public List<String> getNetworkList() {
        return this.mNetworkList;
    }

    public long setCellId(long r8) {
        this.mCellId = r8;
        return r8;
    }

    public List<String> setNetworkList(List<String> r8) {
        this.mNetworkList = r8;
        return r8;
    }
}
