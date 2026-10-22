package com.bytedance.bdlocation.network.model;

import ia.b;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BaseStation {
    public long baseStationGap;

    @b("current")
    public BssInfo current;

    @b("neighboring")
    public List<BssInfo> neighboring;

    public BaseStation() {
    }
}
