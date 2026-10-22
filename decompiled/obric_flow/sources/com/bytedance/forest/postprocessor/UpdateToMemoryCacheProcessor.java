package com.bytedance.forest.postprocessor;

import androidx.annotation.Keep;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.w;
import com.bytedance.forest.pollyfill.l;
import com.bytedance.forest.utils.j;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/forest/postprocessor/UpdateToMemoryCacheProcessor;", "Lcom/bytedance/forest/postprocessor/a;", "<init>", "()V", "Lcom/bytedance/forest/model/w;", "response", "", "onBuiltinProcess", "(Lcom/bytedance/forest/model/w;)V", "forest_release"}, k = 1, mv = {1, 4, 0})
public final class UpdateToMemoryCacheProcessor extends a {
    public UpdateToMemoryCacheProcessor() {
        super(true);
    }

    @Override // com.bytedance.forest.postprocessor.a
    public void onBuiltinProcess(w r5) {
        if ((r5 instanceof g) == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        ResourceFrom r11 = r5.f4444u;
        if (r11 == ResourceFrom.f4339b) goto L24;
        if (r10 == false) goto L12;
    L13:
        l r12 = r5.b();
        if (r12 != null) goto L16;
    L19:
        j r13 = r5.f4441q.getForest().getMemoryManager$forest_release();
        com.bytedance.forest.utils.h r14 = new com.bytedance.forest.utils.h(r5, null);
        r13.getClass();
        if (r5.f4441q.isPreload() == false) goto L22;
        r13.f4645b.a(r14);
        return;
    L22:
        r13.f4644a.a(r14);
        return;
    L16:
        if (r12.a() == true) goto L19;
        if (r5.f4441q.getCustomHttpMaxAge() > 0) goto L19;
        return;
    L12:
        if (r11 != ResourceFrom.d) goto L13;
        return;
    L24:
        return;
    L5:
        if (((g) r5).D == false) goto L7;
        r10 = true;
        goto L8
    }
}
