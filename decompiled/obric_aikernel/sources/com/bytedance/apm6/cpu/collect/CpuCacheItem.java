package com.bytedance.apm6.cpu.collect;

/* JADX INFO: loaded from: classes.dex */
public class CpuCacheItem {
    private long firstTs;
    private double metricCpuStats;
    private double metricMaxCpuStats;
    private double metricMaxRate;
    private double metricRate;
    private String sceneString;
    private int times;
    private CpuDataType type;

    public static final enum CpuDataType extends Enum<CpuDataType> {
        private static final /* synthetic */ CpuDataType[] $VALUES = null;
        public static final CpuDataType BACK = null;
        public static final CpuDataType FRONT = null;
        public static final CpuDataType MIX = null;

        static {
            CpuDataType r10 = new CpuDataType("MIX", 0);
            MIX = r10;
            CpuDataType r11 = new CpuDataType("FRONT", 1);
            FRONT = r11;
            CpuDataType r12 = new CpuDataType("BACK", 2);
            BACK = r12;
            $VALUES = new CpuDataType[]{r10, r11, r12};
        }

        private CpuDataType(String r10, int r11) {
            super(r10, r11);
        }

        public static CpuDataType valueOf(String r10) {
            return (CpuDataType) Enum.valueOf(CpuDataType.class, r10);
        }

        public static CpuDataType[] values() {
            return (CpuDataType[]) $VALUES.clone();
        }
    }

    public CpuCacheItem(CpuDataType r10, long r11) {
        this.times = 0;
        this.type = r10;
        this.firstTs = r11;
        this.times = 0;
    }

    public void addRate(double r10) {
        if (r10 >= 0.0d) goto L5;
        return;
    L5:
        this.metricRate += r10;
    }

    public void addSpeed(double r10) {
        if (r10 >= 0.0d) goto L5;
        return;
    L5:
        this.metricCpuStats += r10;
    }

    public void addTimes() {
        this.times++;
    }

    public long getFirstTs() {
        return this.firstTs;
    }

    public double getMetricCpuSpeed() {
        return this.metricCpuStats;
    }

    public double getMetricMaxCpuSpeed() {
        return this.metricMaxCpuStats;
    }

    public double getMetricMaxRate() {
        return this.metricMaxRate;
    }

    public double getMetricRate() {
        return this.metricRate;
    }

    public String getSceneString() {
        return this.sceneString;
    }

    public int getTimes() {
        return this.times;
    }

    public CpuDataType getType() {
        return this.type;
    }

    public CpuCacheItem injectScene(String r10) {
        this.sceneString = r10;
        return this;
    }

    public void refreshMaxRate(double r10) {
        if (this.metricMaxRate >= r10) goto L6;
        this.metricMaxRate = r10;
        return;
    }

    public void refreshMaxSpeed(double r10) {
        if (this.metricMaxCpuStats >= r10) goto L6;
        this.metricMaxCpuStats = r10;
        return;
    }

    public String toString() {
        return "CpuCacheItem{type=" + this.type + ", metricRate=" + this.metricRate + ", metricMaxRate=" + this.metricMaxRate + ", metricCpuStats=" + this.metricCpuStats + ", metricMaxCpuStats=" + this.metricMaxCpuStats + ", sceneString='" + this.sceneString + "', firstTs=" + this.firstTs + ", times=" + this.times + '}';
    }
}
