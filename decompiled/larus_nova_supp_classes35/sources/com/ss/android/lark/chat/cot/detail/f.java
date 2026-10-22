package com.ss.android.lark.chat.cot.detail;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ c b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ q d;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.a(this.a, "submitList");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public f(boolean r1, c r2, boolean r3, q r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void a() {
        if (this.a == false) goto L7;
        c r0 = this.b;
        RecyclerView r1 = r0.g;
        if (r1 == null) goto L8;
        r1.post(new a(r0));
    L8:
        c r2 = this.b;
        r2.q = true;
        CotStepExposureTracker r3 = r2.n;
        if (r3 == null) goto L12;
        r3.a();
        return;
    L12:
        return;
    L7:
        com.ss.android.lark.chat.cot.f.c("detail_autoscroll", "skip scroll after submit, initial=" + this.c + ", status=" + this.d.c + ", followBottom=" + this.b.r);
        goto L8
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
