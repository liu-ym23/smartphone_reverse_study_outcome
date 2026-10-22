package com.bytedance.android.anniex.engine;

import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public b(a r1, String r10, String r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WeakReference<AnnieXLynxView> r0 = this.a.i;     // Catch: Throwable -> L11
        if (r0 == null) goto L7;
        AnnieXLynxView r1 = r0.get();     // Catch: Throwable -> L11
        if (r1 == null) goto L7;
        String r10 = this.b;     // Catch: Throwable -> L11
        String r11 = this.c;     // Catch: Throwable -> L11
        LynxViewMonitor.b.getClass();     // Catch: Throwable -> L11
        LynxViewMonitor.g(r1, r10, r11);     // Catch: Throwable -> L11
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L8:
        if (r12 != null) goto L14;
        HybridLogger.i("AnnieXDefaultLynxEngineClient", "annieXLynxViewRef is null", null, 12);     // Catch: Throwable -> L11
        return;
    L14:
        return;
    L7:
        r12 = null;
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    }
}
