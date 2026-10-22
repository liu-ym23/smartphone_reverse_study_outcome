package com.lynx.tasm.ui.image;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f0 implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ e0.b.a b;

    public final void a() {
        e0 r0 = this.b.a.c;
        if (r0.C == true) goto L5;
        e0.c r1 = r0.q;
        if (r1 == null) goto L25;
        r1.onDrawableReady(r0.l.getTopLevelDrawable());
    L25:
        DraweeHolder<GenericDraweeHierarchy> r2 = this.b.a.c.m;
        if (r2 == null) goto L28;
        r2.onDetach();
        this.b.a.c.m = null;
    L28:
        n0 r3 = this.b.a.c.p;
        if (r3 == null) goto L34;
        r3.onDetach();
        this.b.a.c.p = null;
        return;
    L34:
        return;
    L5:
        if (r0.q == null) goto L15;
        boolean r4 = r0.n.containsKey(this.a);
        e0 r5 = this.b.a.c;
        DraweeHolder<GenericDraweeHierarchy> r6 = r5.l;
        if (r4 == false) goto L9;
        Map<String, DraweeHolder<GenericDraweeHierarchy>> r7 = r5.n;
        LinkedHashMap r8 = (LinkedHashMap) r7;
        r6 = (DraweeHolder) r8.get(this.a);
    L9:
        if (r6 == null) goto L15;
        if (r6.getHierarchy() == null) goto L15;
        if (r6.getHierarchy().hasImage() == false) goto L15;
        this.b.a.c.q.onDrawableReady(r6.getTopLevelDrawable());
    L15:
        Iterator r9 = ((LinkedHashMap) this.b.a.c.n).entrySet().iterator();
    L17:
        if (r9.hasNext() == false) goto L28;
        Map.Entry r10 = (Map.Entry) r9.next();
        if (((String) r10.getKey()).equals(this.a) == true) goto L28;
        ((DraweeHolder) r10.getValue()).onDetach();
        r9.remove();
        goto L17
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

    public f0(e0.b.a r1, String r2) {
        this.b = r1;
        this.a = r2;
    }
}
