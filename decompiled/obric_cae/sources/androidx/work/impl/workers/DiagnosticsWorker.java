package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.l;
import androidx.work.m;
import he.i;
import j1.b0;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import r1.j;
import r1.n;
import r1.u;
import r1.y;
import v1.b;

/* JADX INFO: loaded from: classes.dex */
public final class DiagnosticsWorker extends Worker {
    public DiagnosticsWorker(Context r8, WorkerParameters r10) {
        i.f(r8, "context");
        i.f(r10, "parameters");
        super(r8, r10);
    }

    @Override // androidx.work.Worker
    public final l.a doWork() {
        b0 r8 = b0.f(getApplicationContext());
        i.e(r8, "getInstance(applicationContext)");
        WorkDatabase r10 = r8.f8453c;
        i.e(r10, "workManager.workDatabase");
        u r11 = r10.f();
        n r12 = r10.d();
        y r13 = r10.g();
        j r14 = r10.c();
        ArrayList r15 = r11.c(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1));
        ArrayList r16 = r11.r();
        ArrayList r17 = r11.k();
        if ((!r15.isEmpty()) == false) goto L6;
        m r18 = m.d();
        String r19 = b.f12705a;
        r18.e(r19, "Recently completed work:\n\n");
        m.d().e(r19, b.a(r12, r13, r14, r15));
    L6:
        if ((!r16.isEmpty()) == false) goto L9;
        m r20 = m.d();
        String r21 = b.f12705a;
        r20.e(r21, "Running work:\n\n");
        m.d().e(r21, b.a(r12, r13, r14, r16));
    L9:
        if ((!r17.isEmpty()) == false) goto L12;
        m r22 = m.d();
        String r23 = b.f12705a;
        r22.e(r23, "Enqueued work:\n\n");
        m.d().e(r23, b.a(r12, r13, r14, r17));
    L12:
        return new l.a.c();
    }
}
