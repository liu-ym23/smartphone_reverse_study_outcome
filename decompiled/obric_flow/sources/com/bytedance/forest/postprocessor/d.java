package com.bytedance.forest.postprocessor;

import com.bytedance.forest.model.Status;
import com.bytedance.forest.model.s;
import com.bytedance.forest.model.w;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends s {
    @Override // com.bytedance.forest.model.s
    public final w a() {
        if (this.e == Status.f4356a) goto L6;
        return null;
    L6:
        this.e = Status.f4357b;
        return this.f4404c.fetchSyncWithProcessor$forest_release(this);
    }
}
