package com.bytedance.forest.utils.io;

import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.q;
import com.bytedance.forest.model.w;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends b {
    @Override // com.bytedance.forest.utils.io.b, com.bytedance.forest.model.p
    public final InputStream provideInputStream(w r5) {
        if (r5.f4441q.getScene() != Scene.f4351k) goto L13;
        if (r5.f4441q.getStreamingLoad() == false) goto L13;
        if (isCacheReady$forest_release() == true) goto L13;
        if (q.initCache$forest_release$default(this, null, 1, null) == false) goto L13;
        r5.f4438n = true;
        d();
        return new e(this, r5);
    L13:
        return super.provideInputStream(r5);
    }
}
