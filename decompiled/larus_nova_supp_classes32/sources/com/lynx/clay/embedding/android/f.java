package com.lynx.clay.embedding.android;

import com.lynx.base.memory.MemoryPressureCallback;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class f implements MemoryPressureCallback {
    public /* synthetic */ f() {
    }

    @Override // com.lynx.base.memory.MemoryPressureCallback
    public final void onPressure(int r2) {
        if (r2 != 2) goto L6;
        ((ArrayList) d.C0034d.a).clear();
        return;
    }
}
