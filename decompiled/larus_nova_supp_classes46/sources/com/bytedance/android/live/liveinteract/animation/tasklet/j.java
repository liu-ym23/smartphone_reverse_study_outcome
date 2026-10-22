package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements Runnable {
    public final /* synthetic */ IconMoveAnimationTasklet a;
    public final /* synthetic */ FrameLayout b;

    public j(IconMoveAnimationTasklet r1, FrameLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Iterator<T> r0 = this.a.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        HSImageView r1 = (HSImageView) r0.next();
        this.b.removeView(r1);
        this.a.n.a(r1);
        goto L4
    L6:
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
