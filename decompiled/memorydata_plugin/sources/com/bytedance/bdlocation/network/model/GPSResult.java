package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class GPSResult {

    @SerializedName("Accuracy")
    public double accuracy;

    @SerializedName("Altitude")
    public String altitude;

    @SerializedName("AltitudeAccurary")
    public String altitudeAccurary;

    @SerializedName("CoordinateSystem")
    public String coordinateSystem;

    @SerializedName("Latitude")
    public double latitude;

    @SerializedName("Source")
    public int locateType;

    @SerializedName("Longitude")
    public double longitude;

    @SerializedName("Timestamp")
    public long timestamp;

    public GPSResult() {
    }

    public String toString() {
        return "GPSResult{accuracy='" + this.accuracy + "', altitude='" + this.altitude + "', altitudeAccurary='" + this.altitudeAccurary + "', timestamp='" + this.timestamp + "', coordinateSystem='" + this.coordinateSystem + "', locateType='" + this.locateType + "'}";
    }
}
