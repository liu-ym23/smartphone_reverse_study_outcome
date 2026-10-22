package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Count implements Serializable {
    private int value;

    Count(int r1) {
        this.value = r1;
    }

    public void add(int r2) {
        this.value += r2;
    }

    public int addAndGet(int r2) {
        int r0 = this.value + r2;
        this.value = r0;
        return r0;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Count.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Count) ZeusTransformUtils.preCheckCast(r3, Count.class, "com.obric.memorydata.plugin")).value != this.value) goto L7;
        return true;
    }

    public int get() {
        return this.value;
    }

    public int getAndSet(int r2) {
        int r0 = this.value;
        this.value = r2;
        return r0;
    }

    public int hashCode() {
        return this.value;
    }

    public void set(int r1) {
        this.value = r1;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}
