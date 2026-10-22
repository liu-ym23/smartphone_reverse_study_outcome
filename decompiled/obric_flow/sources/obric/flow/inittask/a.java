package obric.flow.inittask;

import android.content.Context;
import android.util.Log;
import kotlin.jvm.internal.Intrinsics;
import m.f0;
import obric.flow.app.FlowApplication;
import oo.j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static void a(final FlowApplication r5, final Context r10) {
        Intrinsics.checkNotNullParameter(r5, "application");
        Intrinsics.checkNotNullParameter(r10, "baseContext");
        if (su.a.f22013b == null) goto L10;
        return;
    L10:
        f0.n(new KoinInitHelper$init$1(r10, r5));     // Catch: Error -> L7
        return;
    L7:
        e = move-exception;
        Log.e("KoinInitHelper", "init koin error", e);
        j.h(e, "startKoin error");
    }
}
