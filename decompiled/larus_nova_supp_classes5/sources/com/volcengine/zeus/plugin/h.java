package com.volcengine.zeus.plugin;

import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.PluginGroundProvider;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class h implements Runnable {
    public final /* synthetic */ boolean a;

    public h(boolean r1) {
        this.a = r1;
    }

    public final void a() {
        Set<String> r0 = i.a;
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        PluginGroundProvider r1 = GlobalParam.getInstance().getPluginGroundProvider();
        Iterator<String> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L23;
        String r3 = r2.next();
        boolean r4 = false;
        if (r1 == null) goto L11;
        boolean r5 = r1.isForeground(r3);
    L13:
        if (this.a == true) goto L15;
        if (r5 == false) goto L15;
    L16:
        ZeusLogger.d("Zeus/install_zeus", "PluginReloadManager checkAndReload: " + r3 + ", isForeground=" + r5 + ", shouldReload=" + r4);
        if (r4 == false) goto L7;
        i.a(r3);     // Catch: Exception -> L20
    L22:
        r2.remove();
    L20:
        e = move-exception;
        e.printStackTrace();
        ZeusLogger.w("Zeus/install_zeus", "PluginReloadManager force-stop app processes failed, plugin=" + r3, e);
    L15:
        r4 = true;
        goto L16
    L11:
        r5 = false;
        goto L13
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
