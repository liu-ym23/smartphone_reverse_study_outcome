package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class x implements Runnable {
    public final /* synthetic */ PathEffectAnimationTasklet a;

    public x(PathEffectAnimationTasklet r1) {
        this.a = r1;
    }

    public final void a() {
        List<HSImageView> r0 = this.a.d;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        ((HSImageView) r2.next()).setController(null);
        r1.add(Unit.INSTANCE);
        goto L4
    L6:
        Iterator<T> r3 = this.a.d.iterator();
    L8:
        if (r3.hasNext() == false) goto L13;
        HSImageView r4 = (HSImageView) r3.next();
        FrameLayout r5 = this.a.h;
        if (r5 == null) goto L12;
        r5.removeView(r4);
    L12:
        this.a.o.a(r4);
        goto L8
    L13:
        ((ArrayList) this.a.d).clear();
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
