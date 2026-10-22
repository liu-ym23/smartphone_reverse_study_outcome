package com.larus.bmhome.chat.layout.item;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e3 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ c3 b;
    public final /* synthetic */ List<View> c;
    public final /* synthetic */ View d;

    public static final class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ c3 b;
        public final /* synthetic */ View c;
        public final /* synthetic */ View d;

        public a(int r1, c3 r2, View r3, View r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.a != this.b.e) goto L12;
            this.c.setAlpha(1.0f);     // Catch: Throwable -> L9
            this.c.setTranslationY(0.0f);     // Catch: Throwable -> L9
            if (Intrinsics.areEqual(this.c, this.d) == false) goto L16;
            c3 r0 = this.b;     // Catch: Throwable -> L9
            r0.f = CollectionsKt.emptyList();     // Catch: Throwable -> L9
            return;
        L16:
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e3(int r1, c3 r2, List<? extends View> r3, View r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        if (this.a == this.b.e) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.c.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((View) r0.next()).animate().cancel();
        goto L7
    L9:
        List<View> r1 = this.c;
        int r2 = this.a;
        c3 r3 = this.b;
        View r4 = this.d;
        Iterator<T> r5 = r1.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        View r6 = (View) r5.next();
        r6.animate().alpha(1.0f).translationY(0.0f).setStartDelay(80).setDuration(240).setInterpolator(c3.g).withEndAction(new a(r2, r3, r6, r4)).start();
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
