package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c2 implements Runnable {
    public final /* synthetic */ d2 a;

    public c2(d2 r1) {
        this.a = r1;
    }

    public final void a() {
        t1.c r1 = this.a.a;
        r1.getClass();
        com.bytedance.android.livesdk.interactivity.api.h r0 = com.bytedance.android.livesdk.interactivity.api.q.g();
        if ((r0 instanceof InteractivityPlatformContext) == true) goto L5;
        r0 = null;
    L5:
        InteractivityPlatformContext r2 = (InteractivityPlatformContext) r0;
        if (r2 == null) goto L10;
        com.bytedance.live.datacontext.n<c32.c> r3 = r2.getWordAssociateResult();
        if (r3 == null) goto L10;
        c32.c r4 = (c32.c) r3.getValue();
    L11:
        if (r4 == null) goto L39;
        com.bytedance.android.livesdk.interactivity.api.h r5 = com.bytedance.android.livesdk.interactivity.api.q.g();
        if ((r5 instanceof InteractivityPlatformContext) == true) goto L15;
        r5 = null;
    L15:
        InteractivityPlatformContext r6 = (InteractivityPlatformContext) r5;
        if (r6 == null) goto L40;
        com.bytedance.live.datacontext.n<c32.c> r7 = r6.getWordAssociateResult();
        if (r7 == null) goto L41;
        c32.c r8 = (c32.c) r7.getValue();
        if (r8 == null) goto L44;
        List<c32.d> r9 = r8.results;
        if (r9 == null) goto L45;
        Iterator<c32.d> r10 = r9.iterator();
    L27:
        if (r10.hasNext() == false) goto L29;
        c32.d r11 = r10.next();
        r11.b = true;
        r11.c = r8.associationIdStr;
        goto L27
    L29:
        long r13 = System.currentTimeMillis();
        r8.a = r13;
        r1.j(r9, r13, true, r8.associationIdStr);
        com.bytedance.android.livesdk.interactivity.api.h r14 = com.bytedance.android.livesdk.interactivity.api.q.g();
        if ((r14 instanceof InteractivityPlatformContext) == true) goto L32;
        r14 = null;
    L32:
        InteractivityPlatformContext r15 = (InteractivityPlatformContext) r14;
        if (r15 == null) goto L42;
        com.bytedance.live.datacontext.n<c32.c> r16 = r15.getWordAssociateResult();
        if (r16 == null) goto L43;
        r16.setValue(null);
        return;
    L43:
        return;
    L42:
        return;
    L45:
        return;
    L44:
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L10:
        r4 = null;
        goto L11
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
