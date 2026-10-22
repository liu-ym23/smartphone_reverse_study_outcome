package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements Runnable {
    public final /* synthetic */ h a;
    public final /* synthetic */ Effect b;

    public g(h r1, Effect r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Sticker r0 = d.d(this.b, this.a.c);
        com.bytedance.android.live.effect.api.l.b r1 = this.a.d;
        if (r1 == null) goto L5;
        r1.a(r0);
    L5:
        Iterator r2 = ((ArrayList) this.a.b.b).iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        ((com.bytedance.android.live.effect.api.l.b) r2.next()).a(r0);
        goto L7
    L9:
        h r3 = this.a;
        List<String> r4 = r3.b.c;
        ArrayList r5 = (ArrayList) r4;
        r5.remove(r3.a.getEffectId());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
