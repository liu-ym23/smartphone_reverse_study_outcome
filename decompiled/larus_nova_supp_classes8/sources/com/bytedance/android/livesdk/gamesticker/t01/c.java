package com.bytedance.android.livesdk.gamesticker.t01;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ T01GameViewController a;
    public final /* synthetic */ List b;

    public c(T01GameViewController r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r11) {
        Long r12 = (Long) r11;
        this.a.getClass();
        T01GameViewController r0 = this.a;
        T01GameViewController.a r4 = null;
        if (r0.j == false) goto L23;
        r0.j = false;
        Iterator<T> r1 = this.b.iterator();
    L6:
        if (r1.hasNext() == false) goto L18;
        T r2 = r1.next();
        long r5 = ((T01GameViewController.a) r2).a;
        if (r12 != null) goto L11;
    L15:
        boolean r6 = false;
    L16:
        if (r6 == false) goto L6;
        r4 = r2;
        goto L18
    L11:
        if (r5 != r12.longValue()) goto L15;
        if (r12.longValue() == 0) goto L15;
        r6 = true;
    L18:
        T01GameViewController.a r7 = r4;
        if (r7 == null) goto L51;
        Function0<Unit> r13 = r7.c;
        if (r13 == null) goto L52;
        Unit r14 = (Unit) r13.invoke();
        return;
    L52:
        return;
    L51:
        return;
    L23:
        Iterator<T> r3 = this.b.iterator();
    L25:
        if (r3.hasNext() == false) goto L35;
        T r8 = r3.next();
        long r9 = ((T01GameViewController.a) r8).a;
        if (r12 != null) goto L30;
    L32:
        boolean r10 = false;
    L33:
        if (r10 == false) goto L25;
        r4 = r8;
        goto L35
    L30:
        if (r9 != r12.longValue()) goto L32;
        r10 = true;
    L35:
        T01GameViewController.a r15 = r4;
        if (r15 == null) goto L54;
        Function0<Unit> r16 = r15.c;
        if (r16 == null) goto L55;
        Unit r17 = (Unit) r16.invoke();
        return;
    L55:
        return;
    }
}
