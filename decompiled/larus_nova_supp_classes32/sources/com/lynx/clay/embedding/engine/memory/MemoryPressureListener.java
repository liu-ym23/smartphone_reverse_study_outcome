package com.lynx.clay.embedding.engine.memory;

import com.lynx.base.memory.MemoryPressureCallback;
import com.lynx.clay.util.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class MemoryPressureListener {
    public static ArrayList<MemoryPressureCallback> a;

    public MemoryPressureListener() {
    }

    private static native void nativeOnMemoryPressure(int r0);

    private static void addNativeCallback() {
        Object r0 = a.a;
        MemoryPressureCallback r1 = new d5a.a();
        if (a != null) goto L6;
        a = new ArrayList();
    L6:
        if (a.contains(r1) == true) goto L9;
        a.add(r1);
        return;
    }

    public static /* synthetic */ void a(int r0) {
        nativeOnMemoryPressure(r0);
    }
}
