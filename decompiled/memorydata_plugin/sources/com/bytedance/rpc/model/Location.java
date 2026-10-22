package com.bytedance.rpc.model;

import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Location implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("AoiInfos")
    public List<C0978PoiInfo> aoiInfos;
    public City city;
    public Country country;
    public District district;
    public GPS gps;

    @SerializedName("LocateMethod")
    public String locateMethod;

    @SerializedName("PoiInfos")
    public List<C0978PoiInfo> poiInfos;
    public List<Subdivisions> subdivisions;

    @SerializedName("Timestamp")
    public long timestamp;
    public Town town;

    static {
        fieldTypeClassRef = FieldType.class;
    }

    public Location() {
    }
}
