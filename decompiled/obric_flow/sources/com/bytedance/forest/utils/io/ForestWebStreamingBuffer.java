package com.bytedance.forest.utils.io;

import androidx.annotation.Keep;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.model.q;
import com.bytedance.forest.model.w;
import java.io.InputStream;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/forest/utils/io/ForestWebStreamingBuffer;", "Lcom/bytedance/forest/model/ForestBuffer;", "Lcom/bytedance/forest/model/a;", "bytesProvider", "Lcom/bytedance/forest/utils/e;", "ctx", "<init>", "(Lcom/bytedance/forest/model/a;Lcom/bytedance/forest/utils/e;)V", "Lcom/bytedance/forest/model/w;", "response", "Ljava/io/InputStream;", "provideInputStream", "(Lcom/bytedance/forest/model/w;)Ljava/io/InputStream;", "forest_release"}, k = 1, mv = {1, 4, 0})
public final class ForestWebStreamingBuffer extends ForestBuffer {
    public ForestWebStreamingBuffer(com.bytedance.forest.model.a r5, com.bytedance.forest.utils.e r10) {
        super(r5, r10);
    }

    @Override // com.bytedance.forest.model.ForestBuffer, com.bytedance.forest.model.p
    public InputStream provideInputStream(w r5) {
        if (r5.f4441q.getScene() != Scene.f4351k) goto L13;
        if (r5.f4441q.getStreamingLoad() == false) goto L13;
        if (isCacheReady$forest_release() == true) goto L13;
        if (q.initCache$forest_release$default(this, null, 1, null) == false) goto L13;
        r5.f4438n = true;
        return new e(this, r5);
    L13:
        return super.provideInputStream(r5);
    }
}
