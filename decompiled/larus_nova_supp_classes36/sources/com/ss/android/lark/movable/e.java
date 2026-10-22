package com.ss.android.lark.movable;

import com.bytedance.lark.lark_markdown_render_android.MovableCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.movable.selection.MovableSelectionManager;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Runnable {
    public final /* synthetic */ MovableView a;
    public final /* synthetic */ MovableGlobalManager b;

    public e(MovableView r1, MovableGlobalManager r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        MovableView r0 = this.a.getRootMovableView();
        Collection<MovableGlobalManager.c> r1 = this.b.c.values();
        MovableGlobalManager r2 = this.b;
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L29;
        MovableGlobalManager.c r4 = (MovableGlobalManager.c) r3.next();
        MovableCallback r5 = r4.get();
        if ((r5 instanceof MovableView) == false) goto L8;
        MovableView r6 = (MovableView) r5;
    L9:
        if (r6 == null) goto L11;
        MovableView r7 = r6.getRootMovableView();
        if (r7 == r0) goto L4;
        MovableSelectionManager r8 = r7.getSelectionManager$movable_release();
        boolean r9 = false;
        if (r8 != null) goto L18;
    L25:
        if (r9 == false) goto L4;
        MovableSelectionManager r10 = r7.getRootMovableView().n;
        if (r10 == null) goto L4;
        r10.d();
        goto L4
    L18:
        if (r8.e(true) != null) goto L20;
    L22:
        boolean r11 = false;
    L23:
        if (r11 != true) goto L25;
        r9 = true;
        goto L25
    L20:
        if (r8.e(false) == null) goto L22;
        r11 = true;
        goto L23
    L11:
        if (r2.c.get(Integer.valueOf(r4.a)) != r4) goto L4;
        r2.c.remove(Integer.valueOf(r4.a));
        goto L4
    L8:
        r6 = null;
        goto L9
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
