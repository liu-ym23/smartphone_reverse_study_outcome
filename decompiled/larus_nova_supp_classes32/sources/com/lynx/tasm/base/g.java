package com.lynx.tasm.base;

import com.lynx.base.memory.MemoryPressureCallback;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public static final g b = null;
    public final CopyOnWriteArrayList<MemoryPressureCallback> a;

    static {
        b = new g();
    }

    public g() {
        this.a = new CopyOnWriteArrayList();
    }
}
