package com.bytedance.android.live.effect.composer;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements Runnable {
    public final /* synthetic */ LiveComposerManagerB a;

    public h(LiveComposerManagerB r1) {
        this.a = r1;
    }

    public final void a() {
        Logger.w("LiveComposerManagerB", "restore complete now");
        if (this.a.z == true) goto L8;
        this.a.z = true;
        Logger.w("LiveComposerManagerB", "all restore complete!");
        LiveComposerManagerB r0 = this.a;
        r0.x = System.currentTimeMillis();
        Iterator<T> r1 = this.a.w.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((ILiveEffectComposerManager.j) r1.next()).a(this.a.x, MapsKt.emptyMap());
        goto L6
    L10:
        return;
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
