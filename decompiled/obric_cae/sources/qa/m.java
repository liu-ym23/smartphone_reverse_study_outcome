package qa;

import android.content.Context;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public final class m extends m1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f10796b;

    public m(Context r8) {
        this.f10796b = r8;
    }

    @Override // qa.m1
    public final void a() {
        Context r8 = this.f10796b;
        g1 r10 = new g1(s.f11003a);     // Catch: Throwable -> L5 RejectedExecutionException -> L8
        s.f11003a = false;     // Catch: Throwable -> L5 RejectedExecutionException -> L8
        Vector<s4> r11 = n.f10841b;     // Catch: Throwable -> L5 RejectedExecutionException -> L8
        l1 r12 = l1.f10784d;     // Catch: Throwable -> L5 RejectedExecutionException -> L8
        r12.a(new r(r8, r10, "c"));     // Catch: Throwable -> L5 RejectedExecutionException -> L8
        s.d(r8);     // Catch: Throwable -> L5 RejectedExecutionException -> L8
        s.c(r8);     // Catch: Throwable -> L5 RejectedExecutionException -> L8
        r12.a(new u0.a(r8, 3));     // Catch: Throwable -> L5 RejectedExecutionException -> L8
        r12.a(new s0.a(r8, 2));     // Catch: Throwable -> L5 RejectedExecutionException -> L8
        return;
    L5:
        th = move-exception;
        q.f("Lg", "proL", th);
        return;
    }
}
