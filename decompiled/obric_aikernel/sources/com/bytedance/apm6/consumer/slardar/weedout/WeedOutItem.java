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

    void setAfterSize(long r10) {
        this.afterSize = r10;
    }

    void setBeforeSize(long r10) {
        this.beforeSize = r10;
    }

    void setName(String r10) {
        this.name = r10;
    }

    public void setReachTopOfToday(boolean r10) {
        this.reachTopOfToday = r10;
    }
}
