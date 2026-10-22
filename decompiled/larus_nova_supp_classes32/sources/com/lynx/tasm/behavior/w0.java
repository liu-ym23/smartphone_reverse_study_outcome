package com.lynx.tasm.behavior;

import android.util.SparseArray;
import com.lynx.tasm.behavior.shadow.ShadowNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w0 {
    public final SparseArray<ShadowNode> a;

    public w0() {
        this.a = new SparseArray();
    }

    public final ShadowNode a(int r2) {
        return this.a.get(r2);
    }
}
