package com.larksuite.framework.utils;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g0 {

    public class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ View f;

        public final void a() {
            Rect r0 = new Rect();
            this.a.getHitRect(r0);
            r0.top -= this.b;
            r0.bottom += this.c;
            r0.left -= this.d;
            r0.right += this.e;
            this.f.setTouchDelegate(new TouchDelegate(r0, this.a));
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

        public a(View r1, int r2, int r3, int r4, int r5, View r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static void a(View r9, int r10, int r11, int r12, int r13) {
        if (r9 != null) goto L4;
        return;
    L4:
        View r0 = (View) r9.getParent();
        if (r0 == null) goto L9;
        r0.post(new a(r9, r10, r13, r11, r12, r0));
        return;
    L9:
        throw new RuntimeException("view set TouchDelegate must have parent view");
    }
}
