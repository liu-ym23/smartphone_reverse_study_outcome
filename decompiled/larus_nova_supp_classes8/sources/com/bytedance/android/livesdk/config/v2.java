package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class v2 {

    @SerializedName("cpuRate")
    public double cpuRate;

    @SerializedName("cpuRateAnchor")
    public double cpuRateAnchor;

    @SerializedName("cpuTotal")
    public double cpuTotal;

    @SerializedName("cpuTotalAnchor")
    public double cpuTotalAnchor;

    @SerializedName("dataCacheDuration")
    public long dataCacheDuration;

    @SerializedName("diagnoseDataSize")
    public int diagnoseDataSize;

    @SerializedName("diagnoseOnceDuration")
    public long diagnoseOnceDuration;

    @SerializedName("diagnoseTypeHot")
    public a diagnoseTypeHot;

    @SerializedName("diagnoseTypeStreamStall")
    public b diagnoseTypeStreamStall;

    @SerializedName("diagnoseTypeUIStall")
    public c diagnoseTypeUIStall;

    @SerializedName("gpu")
    public double gpu;

    @SerializedName("gpuAnchor")
    public double gpuAnchor;

    @SerializedName("netStatus")
    public int netStatus;

    @SerializedName("strategy")
    public int strategy;

    public static class a {

        @SerializedName("hotP0")
        public C0112a critical;

        @SerializedName("enable")
        public boolean enable;

        @SerializedName("granularity")
        public int granularity;

        @SerializedName("hotP2")
        public C0112a normal;

        @SerializedName("temperature")
        public double temperature;

        @SerializedName("temperatureAnchor")
        public double temperatureAnchor;

        @SerializedName("hotP1")
        public C0112a warning;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.config.v2$a$a, reason: collision with other inner class name */
        public static class C0112a {

            @SerializedName("temperatureAnchorLimit")
            public float temperatureAnchorLimit;

            @SerializedName("temperatureLimit")
            public float temperatureLimit;

            public C0112a() {
            }
        }

        public a() {
            this.enable = true;
            this.granularity = 0;
        }
    }

    public static class b {

        @SerializedName("streamP0")
        public a critical;

        @SerializedName("enable")
        public boolean enable;

        @SerializedName("granularity")
        public int granularity;

        @SerializedName("streamP2")
        public a normal;

        @SerializedName("previewFps")
        public double previewFps;

        @SerializedName("realFps")
        public double realFps;

        @SerializedName("renderFps")
        public double renderFps;

        @SerializedName("renderStallRate")
        public double renderStallRate;

        @SerializedName("streamP1")
        public a warning;

        public static class a {

            @SerializedName("previewFpsAnchorLimit")
            public double previewFpsAnchorLimit;

            @SerializedName("previewFpsLimit")
            public double previewFpsLimit;

            @SerializedName("realFpsAnchorLimit")
            public double realFpsAnchorLimit;

            @SerializedName("realFpsLimit")
            public double realFpsLimit;

            @SerializedName("renderStallCountLimit")
            public int renderStallCountLimit;

            public a() {
            }
        }

        public b() {
            this.enable = true;
            this.granularity = 0;
        }
    }

    public static class c {

        @SerializedName("uiP0")
        public a critical;

        @SerializedName("enable")
        public boolean enable;

        @SerializedName("fps")
        public double fps;

        @SerializedName("granularity")
        public int granularity;

        @SerializedName("hasStallCount")
        public int hasStallCount;

        @SerializedName("uiP2")
        public a normal;

        @SerializedName("uiStallRate")
        public double uiStallRate;

        @SerializedName("uiP1")
        public a warning;

        public static class a {

            @SerializedName("stallCountLimit")
            public int stallCountLimit;

            @SerializedName("totalDropTime")
            public long totalDropTime;

            @SerializedName("uiStallRateLimit")
            public double uiStallRateLimit;

            public a() {
            }
        }

        public c() {
            this.enable = true;
            this.granularity = 0;
        }
    }

    public v2() {
        this.dataCacheDuration = 300;
        this.diagnoseOnceDuration = 60;
        this.diagnoseDataSize = 6;
        this.netStatus = 5;
        this.diagnoseTypeUIStall = new c();
        this.diagnoseTypeStreamStall = new b();
        this.diagnoseTypeHot = new a();
    }
}
