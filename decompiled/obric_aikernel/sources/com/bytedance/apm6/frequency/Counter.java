package com.bytedance.apm6.frequency;

/* JADX INFO: loaded from: classes.dex */
class Counter {
    private int count;

    Counter(int r10) {
        this.count = r10;
    }

    void addCount(int r10) {
        this.count += r10;
    }

    int getCount() {
        return this.count;
    }
}
