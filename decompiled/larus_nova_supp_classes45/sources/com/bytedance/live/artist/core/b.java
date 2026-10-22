package com.bytedance.live.artist.core;

import com.bytedance.live.artist.render.RenderEntity$prepareAsync$1;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final EntityManager a;
    public final CoreEngine b;

    public b(CoreEngine r1) {
        this.b = r1;
        this.a = new EntityManager(this);
    }

    public final void a(RenderEntity$prepareAsync$1.AnonymousClass1 r9) {
        CoreEngine r0 = this.b;
        if (r0.f == false) goto L7;
        BuildersKt.launch$default(r0.d, null, null, new CoreEngine$submitAsyncTask$1(r0, r9, null), 3, null);
        return;
    }
}
