package com.bytedance.apm6.frequency;

/* JADX INFO: loaded from: classes.dex */
class Counter {
    private int count;

    Counter(int r1) {
        this.count = r1;
    }

    void addCount(int r2) {
        this.count += r2;
    }

    int getCount() {
        return this.count;
    }
}
