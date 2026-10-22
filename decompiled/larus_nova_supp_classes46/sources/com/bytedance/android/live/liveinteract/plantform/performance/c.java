package com.bytedance.android.live.liveinteract.plantform.performance;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    public final void a() {
        a r0 = this.a;
        Map<String, BehaviorSubject<d0>> r1 = r0.a;
        if (r1 != null) goto L5;
    L7:
        Disposable r2 = r0.b;
        if (r2 == null) goto L10;
        r2.dispose();
    L10:
        Map<String, BehaviorSubject<d0>> r3 = r0.a;
        if (r3 == null) goto L16;
        ArrayList r4 = new ArrayList(r3.size());
        Iterator<Map.Entry<String, BehaviorSubject<d0>>> r5 = r3.entrySet().iterator();
    L14:
        if (r5.hasNext() == false) goto L17;
        Map.Entry<String, BehaviorSubject<d0>> r6 = r5.next();
        String r7 = r6.getKey();
        r4.add(r6.getValue().distinctUntilChanged().map(new f(r7)));
    L17:
        r0.b = Observable.combineLatest(r4, d.a).debounce(500, TimeUnit.MILLISECONDS).subscribe(new e(r0));
        return;
    L16:
        r4 = null;
        goto L17
    L5:
        if (r1.isEmpty() != true) goto L7;
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
