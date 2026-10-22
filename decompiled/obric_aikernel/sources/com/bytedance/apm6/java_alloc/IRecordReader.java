package com.bytedance.apm6.java_alloc;

/* JADX INFO: loaded from: classes.dex */
public interface IRecordReader {
    void onHeadInfo(String r10, long r11, long r12, int r13, JavaAllocConfig r14, long r15, long r16);

    boolean onItem(String r10, int r11, int r12, Trace r13, int r14);
}
