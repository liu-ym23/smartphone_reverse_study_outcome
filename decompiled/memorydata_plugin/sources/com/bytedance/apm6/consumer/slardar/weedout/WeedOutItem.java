package com.bytedance.apm6.consumer.slardar.weedout;

/* JADX INFO: loaded from: classes.dex */
public class WeedOutItem {
    private long afterSize;
    private long beforeSize;
    private String name;
    private boolean reachTopOfToday;

    public WeedOutItem() {
    }

    public long getAfterSize() {
        return this.afterSize;
    }

    public long getBeforeSize() {
        return this.beforeSize;
    }

    public String getName() {
        return this.name;
    }

    public boolean isReachTopOfToday() {
        return this.reachTopOfToday;
    }

    void setAfterSize(long r1) {
        this.afterSize = r1;
    }

    void setBeforeSize(long r1) {
        this.beforeSize = r1;
    }

    void setName(String r1) {
        this.name = r1;
    }

    public void setReachTopOfToday(boolean r1) {
        this.reachTopOfToday = r1;
    }
}
