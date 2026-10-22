package w64;

import android.content.Context;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.collect.impl.monitor.NetworkStatusMonitor;
import com.bytedance.badger.collect.impl.pseudo.interfaces.IMobileResultCallback;
import com.bytedance.badger.collect.impl.pseudo.model.PseudoCodeResult;
import com.bytedance.badger.module.BadgerModuleBase;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements IMobileResultCallback {
    public final /* synthetic */ c a;
    public final /* synthetic */ AtomicInteger b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ BadgerModuleBase.BadgerRequestData e;
    public final /* synthetic */ long f;
    public final /* synthetic */ CountDownLatch g;

    public a(c r1, AtomicInteger r2, Ref.ObjectRef r3, Context r4, BadgerModuleBase.BadgerRequestData r5, long r6, CountDownLatch r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r8;
    }

    @Override // com.bytedance.badger.collect.impl.pseudo.interfaces.IMobileResultCallback
    public final void onComplete(Object r9) {
        PseudoCodeResult r4 = (PseudoCodeResult) r9;
    L13:
        th = move-exception;
        this.g.countDown();
        throw th;
    L4:
        if (this.b.compareAndSet(0, 1) == false) goto L10;
        com.bytedance.badger.e.f(Constants.TAGS.PSEUDO, "pseudo done, result=" + r4);     // Catch: Throwable -> L13
        Ref.ObjectRef r10 = this.c;     // Catch: Throwable -> L13
        c r1 = this.a;     // Catch: Throwable -> L13
        Context r2 = this.d;     // Catch: Throwable -> L13
        r1.getClass();     // Catch: Throwable -> L13
        r10.element = c.c(r4, r2);     // Catch: Throwable -> L13
        if (r4.enableSimCardListen == true) goto L8;
    L11:
        this.g.countDown();
        return;
    L8:
        if (NetworkStatusMonitor.isStarted() == true) goto L11;
        Context r3 = this.d;     // Catch: Throwable -> L13
        h r12 = new h(r3);     // Catch: Throwable -> L13
        NetworkStatusMonitor.getInstance(r3).setOnNetworkChangeListener(r12);     // Catch: Throwable -> L13
        NetworkStatusMonitor.getInstance(this.d).setOnSimCardChangeListener(r12);     // Catch: Throwable -> L13
        NetworkStatusMonitor.getInstance(this.d).start();     // Catch: Throwable -> L13
        com.bytedance.badger.e.f(Constants.TAGS.PSEUDO, "enable pseudo listener");     // Catch: Throwable -> L13
        goto L11
    L10:
        c.d(this.a, this.d, r4, this.e, this.f);     // Catch: Throwable -> L13
        goto L11
    }
}
