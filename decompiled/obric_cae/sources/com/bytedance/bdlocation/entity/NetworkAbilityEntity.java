package com.bytedance.bdlocation.entity;

import ia.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NetworkAbilityEntity {

    @b("network_capabilities")
    public List<Integer> netCapabilityList;

    @b("network_transports")
    public List<Integer> netTransportList;

    public NetworkAbilityEntity() {
        this.netCapabilityList = new ArrayList();
        this.netTransportList = new ArrayList();
    }

    public void addNetCapability(int r8) {
        this.netCapabilityList.add(Integer.valueOf(r8));
    }

    public void addNetTransport(int r8) {
        this.netTransportList.add(Integer.valueOf(r8));
    }
}
