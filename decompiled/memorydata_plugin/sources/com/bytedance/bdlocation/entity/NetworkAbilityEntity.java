package com.bytedance.bdlocation.entity;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NetworkAbilityEntity {

    @SerializedName("network_capabilities")
    public List<Integer> netCapabilityList;

    @SerializedName("network_transports")
    public List<Integer> netTransportList;

    public NetworkAbilityEntity() {
        this.netCapabilityList = new ArrayList();
        this.netTransportList = new ArrayList();
    }

    public void addNetCapability(int r1) {
        this.netCapabilityList.add(Integer.valueOf(r1));
    }

    public void addNetTransport(int r1) {
        this.netTransportList.add(Integer.valueOf(r1));
    }
}
