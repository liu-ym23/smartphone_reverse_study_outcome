package com.obric.aee.impl;

/* JADX INFO: loaded from: classes2.dex */
public final class MemoryHook {
    public static final MemoryHook INSTANCE = null;

    static {
        INSTANCE = new MemoryHook();
        System.loadLibrary("aee_core");
    }

    private MemoryHook() {
    }

    public final native long getAllocatedBytes(int r10);

    public final native long getAllocatedCount(int r10);

    public final native void install();
}
