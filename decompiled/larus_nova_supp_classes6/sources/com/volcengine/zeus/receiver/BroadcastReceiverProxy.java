package com.volcengine.zeus.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.plugin.Plugin;
import dqc.e;
import iqc.b;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class BroadcastReceiverProxy extends BroadcastReceiver {
    public final String a;

    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Intent b;

        @Override // java.lang.Runnable
        public final void run() {
            b.c().d(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(Context r1, Intent r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public BroadcastReceiverProxy(String r1) {
        this.a = r1;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r3, Intent r4) {
        Plugin r0 = Zeus.getPlugin(this.a);
        if (r0 == null) goto L5;
        r4.setExtrasClassLoader(r0.mClassLoader);
    L5:
        b r1 = b.c();
        int r2 = hashCode();
        Set r5 = r1.c;
        CopyOnWriteArraySet r6 = (CopyOnWriteArraySet) r5;
        if (r6.contains(Integer.valueOf(r2)) == false) goto L8;
        b.c().d(r3, r4);
        return;
    L8:
        a r7 = new a(r3, r4);
        Object r8 = e.b;
        monitor-enter(r8);
    L20:
        th = move-exception;
        throw th;
    L11:
        if (e.c != null) goto L13;
        e.c = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L20
    L13:
        Handler r9 = e.c;     // Catch: Throwable -> L20
        monitor-exit(r8);     // Catch: Throwable -> L20
        if (r9.getLooper() != Looper.myLooper()) goto L18;
        r7.run();
        return;
    L18:
        e.a().post(r7);
    }
}
