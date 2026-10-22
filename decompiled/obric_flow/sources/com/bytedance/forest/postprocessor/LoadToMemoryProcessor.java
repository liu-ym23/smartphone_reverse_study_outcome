package com.bytedance.forest.postprocessor;

import androidx.annotation.Keep;
import com.bytedance.forest.model.w;
import com.bytedance.forest.utils.q;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/forest/postprocessor/LoadToMemoryProcessor;", "Lcom/bytedance/forest/postprocessor/a;", "", "allowIOOnMainThread", "<init>", "(Z)V", "Lcom/bytedance/forest/model/w;", "response", "", "onBuiltinProcess", "(Lcom/bytedance/forest/model/w;)V", "forest_release"}, k = 1, mv = {1, 4, 0})
public final class LoadToMemoryProcessor extends a {
    public LoadToMemoryProcessor(boolean r5) {
        super(r5);
    }

    @Override // com.bytedance.forest.postprocessor.a
    public void onBuiltinProcess(w r10) {
        r10.f4441q.isASync();
        if (q.b() == false) goto L5;
        com.bytedance.forest.utils.d.b(getContext().g, 5, "FOREST", "IO operation in UI thread", false, null, null, 56);
    L5:
        getContext().b(new String[]{"load_to_memory_start"});
        r10.j();
        getContext().b(new String[]{"load_to_memory_finish"});
    }
}
