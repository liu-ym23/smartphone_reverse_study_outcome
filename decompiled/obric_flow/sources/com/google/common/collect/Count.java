package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Count implements Serializable {
    private int value;

    public Count(int r5) {
        this.value = r5;
    }

    public void add(int r5) {
        this.value += r5;
    }

    public int addAndGet(int r5) {
        int r10 = this.value + r5;
        this.value = r10;
        return r10;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof Count) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Count) r5).value != this.value) goto L7;
        return true;
    }

    public int get() {
        return this.value;
    }

    public int getAndSet(int r5) {
        int r10 = this.value;
        this.value = r5;
        return r10;
    }

    public int hashCode() {
        return this.value;
    }

    public void set(int r5) {
        this.value = r5;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
