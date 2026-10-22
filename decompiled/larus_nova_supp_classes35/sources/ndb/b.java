package ndb;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Runnable {
    public final /* synthetic */ Set a;
    public final /* synthetic */ c b;

    public final void a() {
        c r0 = this.b;
        r0.c = FeatureGatingModule.getDependency().mc();
        c r1 = this.b;
        r1.d = FeatureGatingModule.getDependency().Ue();
        Iterator r2 = this.a.iterator();
    L4:
        if (r2.hasNext() == false) goto L16;
        d r3 = (d) r2.next();
        c r4 = this.b;
        r4.b(r3);
        if (((CopyOnWriteArraySet) r4.b).size() < r4.c) goto L4;
        Object r5 = r4.e;
        monitor-enter(r5);
        r4.c();     // Catch: Throwable -> L13
        monitor-exit(r5);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
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

    public b(c r1, Set r2) {
        this.b = r1;
        this.a = r2;
    }
}
