package com.bytedance.android.live.revlink.link.core.service;

import com.bytedance.android.live.revlink.link.core.layoutstatus.LayoutSnapShotCollect;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements com.bytedance.android.scope.o, i {
    public final AnchorDynamicLayoutImpl a;
    public final NextLiveData<p> b;
    public final com.bytedance.android.live.revlink.link.infra.rtcbiz.b c;

    public final void onStart() {
        Iterator<T> r0 = this.a.b.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.live.revlink.link.core.layoutstatus.c) r0.next()).attach();
        goto L4
    }

    public final void onStop() {
        LayoutSnapShotCollect r0 = this.a.b;
        Iterator<T> r1 = r0.j.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((com.bytedance.android.live.revlink.link.core.layoutstatus.c) r1.next()).detach();
        goto L4
    L6:
        r0.a = null;
    }

    @Override // com.bytedance.android.live.revlink.link.core.service.i
    public final NextLiveData<p> getLayoutFrame() {
        return this.b;
    }

    public b(s r9, com.bytedance.android.live.revlink.link.infra.rtcbiz.b r10, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r12) {
        Intrinsics.checkNotNullParameter(r9, "dynamicLayoutClient");
        Intrinsics.checkNotNullParameter(r10, "rtcDataContext");
        Intrinsics.checkNotNullParameter(r12, "context");
        this.c = r10;
        AnchorLayoutDataContext r0 = new AnchorLayoutDataContext(r12);
        this.a = new AnchorDynamicLayoutImpl(r9, r10, r12.d.d, r0, r12);
        r0.getLayoutStates();
        this.b = r0.getLayoutFrame();
    }
}
