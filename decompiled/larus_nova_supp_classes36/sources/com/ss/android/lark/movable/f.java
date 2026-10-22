package com.ss.android.lark.movable;

import com.bytedance.lark.lark_markdown_render_android.MovableCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements Runnable {
    public final /* synthetic */ MovableGlobalManager.c a;
    public final /* synthetic */ MovableGlobalManager b;

    public f(MovableGlobalManager.c r1, MovableGlobalManager r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        MovableCallback r0 = this.a.get();
        if ((r0 instanceof MovableView) == false) goto L5;
        MovableView r1 = (MovableView) r0;
    L6:
        if (r1 == null) goto L8;
        r1.d();
    L8:
        MovableGlobalManager.c r2 = this.b.c.get(Integer.valueOf(this.a.a));
        MovableGlobalManager.c r3 = this.a;
        if (r2 != r3) goto L11;
        this.b.c.remove(Integer.valueOf(r3.a));
    L11:
        Log.i("RenderPoolFfi", "movable view weak reference recycled: " + this.a.a + ", global size: " + this.b.c.size());
        return;
    L5:
        r1 = null;
        goto L6
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
