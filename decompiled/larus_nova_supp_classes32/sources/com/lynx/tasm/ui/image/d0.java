package com.lynx.tasm.ui.image;

import android.graphics.drawable.Drawable;
import android.os.Looper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.core.LynxThreadPool;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ e0.a b;

    public final void a() {
        e0 r0 = this.b.a;
        if (r0.C == true) goto L5;
        e0.c r1 = r0.q;
        if (r1 == null) goto L40;
        DH r2 = r0.M.c;
        if (r2 != 0) goto L38;
        Drawable r3 = null;
    L39:
        r1.onDrawableReady(r3);
        goto L40
    L38:
        r3 = r2.getTopLevelDrawable();
    L40:
        y<GenericDraweeHierarchy> r4 = this.b.a.N;
        if (r4 == null) goto L50;
        r4.b = false;
        if (r4.a == false) goto L49;
        r4.a = false;
        x r5 = new x(r4);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L48;
        r5.run();
        goto L49
    L48:
        LynxThreadPool.d().execute(r5);
    L49:
        this.b.a.N = null;
    L50:
        CloseableReference<?> r6 = this.b.a.a0;
        if (r6 == null) goto L59;
        CloseableReference.closeSafely(r6);
        this.b.a.a0 = null;
        return;
    L59:
        return;
    L5:
        if (r0.q == null) goto L19;
        boolean r7 = r0.O.containsKey(this.a);
        e0 r8 = this.b.a;
        y<GenericDraweeHierarchy> r9 = r8.M;
        if (r7 == false) goto L9;
        r9 = (y) ((LinkedHashMap) r8.O).get(this.a);
    L9:
        if (r9 == null) goto L19;
        if (((DraweeHierarchy) Preconditions.checkNotNull(r9.c)) == null) goto L19;
        if (((DraweeHierarchy) Preconditions.checkNotNull(r9.c)).hasImage() == false) goto L19;
        e0.c r10 = this.b.a.q;
        DH r11 = r9.c;
        if (r11 != 0) goto L17;
        Drawable r12 = null;
    L18:
        r10.onDrawableReady(r12);
        goto L19
    L17:
        r12 = r11.getTopLevelDrawable();
    L19:
        Iterator r13 = ((LinkedHashMap) this.b.a.O).entrySet().iterator();
    L21:
        if (r13.hasNext() == false) goto L50;
        Map.Entry r14 = (Map.Entry) r13.next();
        if (((String) r14.getKey()).equals(this.a) == true) goto L50;
        y r15 = (y) r14.getValue();
        r15.b = false;
        if (r15.a == false) goto L32;
        r15.a = false;
        x r16 = new x(r15);
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) == ThreadMethodProxy.currentThread()) goto L31;
        r16.run();
        goto L32
    L31:
        LynxThreadPool.d().execute(r16);
    L32:
        r13.remove();
        goto L21
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

    public d0(e0.a r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
