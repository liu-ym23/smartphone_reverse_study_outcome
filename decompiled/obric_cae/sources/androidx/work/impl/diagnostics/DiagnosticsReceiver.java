package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import androidx.work.m;
import androidx.work.o;
import j1.b0;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2893a = null;

    static {
        f2893a = m.f("DiagnosticsRcvr");
    }

    public DiagnosticsReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        m r11 = m.d();
        String r12 = f2893a;
        r11.a(r12, "Requesting diagnostics");
        b0 r13 = b0.f(r8);     // Catch: IllegalStateException -> L7
        o r14 = new o.a(DiagnosticsWorker.class).a();     // Catch: IllegalStateException -> L7
        r13.getClass();     // Catch: IllegalStateException -> L7
        r13.e(Collections.singletonList(r14));     // Catch: IllegalStateException -> L7
        return;
    L7:
        e = move-exception;
        m.d().c(r12, "WorkManager is not initialized", e);
    }
}
