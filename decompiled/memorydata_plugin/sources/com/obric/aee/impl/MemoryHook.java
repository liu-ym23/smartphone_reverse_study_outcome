package com.obric.aee.impl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0086 J\u0011\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0086 J\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\t\u0010\r\u001a\u00020\u000eH\u0086 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/aee/impl/MemoryHook;", "", "()V", "DOMAIN_MEM", "", "DOMAIN_OBJ", "DOMAIN_RAW", "getAllocatedBytes", "", "domain", "getAllocatedCount", "getVmAllocated", "getVmMemCount", "install", "", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MemoryHook {
    public static final MemoryHook INSTANCE = null;

    static {
        INSTANCE = new MemoryHook();
        System.loadLibrary("aee_core");
    }

    private MemoryHook() {
    }

    public final native long getAllocatedBytes(int r1);

    public final native long getAllocatedCount(int r1);

    public final native void install();
}
