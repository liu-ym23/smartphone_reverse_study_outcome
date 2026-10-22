package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dynamic/MultiDynamicLayoutManager$windowStatusObserver$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lf31/i;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiDynamicLayoutManager$windowStatusObserver$1 implements Observer<f31.i> {
    public final /* synthetic */ MultiDynamicLayoutManager a;

    public MultiDynamicLayoutManager$windowStatusObserver$1(MultiDynamicLayoutManager r1) {
        this.a = r1;
    }

    public final void a(f31.i r8) {
        jy0.b.c("MultiDynamicLayoutManager", "onWindowStatusChange " + r8, null, 4);
        if (r8 != null) goto L5;
        return;
    L5:
        List<f31.k> r0 = r8.a;
        i r9 = r8.c;
        List<f31.k> r4 = r0;
        if (r4 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == false) goto L14;
        return;
    L14:
        if (r9 != null) goto L16;
        r9 = new i(f31.l.e(r0), f31.l.a(r0), f31.l.c(r0), f31.l.d(r0));
    L16:
        MultiDynamicLayoutManager r1 = this.a;
        i r6 = r1.b;
        if (r6 != null) goto L19;
    L28:
        r1.b = r9;
        jy0.b.c("MultiDynamicLayoutManager", "update lynxContainer layout parameters " + this.a.b, null, 4);
        this.a.f.invoke();
        return;
    L19:
        if (r6.a != r9.a) goto L28;
        if (r6.b != r9.b) goto L28;
        if (r6.c != r9.c) goto L28;
        if (r6.d != r9.d) goto L28;
        jy0.b.d("MultiDynamicLayoutManager", "block windowStatus for same content");
        return;
    L8:
        if (r4.isEmpty() == true) goto L11;
        r5 = false;
        goto L12
    }

    public final /* bridge */ /* synthetic */ void onChanged(Object r1) {
        a((f31.i) r1);
    }
}
