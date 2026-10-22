package com.bytedance.bdlocation.network.model;

import com.bytedance.bdinstall.Api;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class RegionInfo {

    @SerializedName("carrier_region")
    public String carrierRegion;

    @SerializedName("locale")
    public String locale;

    @SerializedName(Api.KEY_MCC_MNC)
    public String mccmnc;

    @SerializedName("network_sim_region")
    public String networkSimRegion;

    @SerializedName("system_language")
    public String systemLanguage;

    @SerializedName("system_region")
    public String systemRegion;

    public RegionInfo() {
    }
}
