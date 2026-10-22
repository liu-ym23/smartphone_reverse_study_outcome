package com.obric.flow.cardlistpage.mvi;

import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.q2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2 f11529a;

    public a(k r5) {
        Intrinsics.checkNotNullParameter(r5, "initialState");
        this.f11529a = kotlinx.coroutines.flow.i.b(r5);
    }

    public final void a(j r10) {
        Intrinsics.checkNotNullParameter(r10, "intent");
        String r5 = getClass().getSimpleName();
        q2 r11 = this.f11529a;
        k r12 = (k) r11.getValue();
        MutableSnapshot r13 = Snapshot.Companion.takeMutableSnapshot$default(Snapshot.Companion, null, null, 3, null);
        Snapshot r14 = r13.makeCurrent();     // Catch: Throwable -> L17
        k r15 = c(r12, r10);     // Catch: Throwable -> L19
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r13.restoreCurrent(r14);     // Catch: Throwable -> L17
        r13.apply().check();     // Catch: Throwable -> L17
        r13.dispose();
        if (r12 == r15) goto L9;
        r11.i(r15);
    L9:
        String r17 = r15.a();
        if (r17 != null) goto L12;
        r17 = r15.toString();
    L12:
        MviLogLevel r18 = h.f11535a;
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullParameter(r5, "storeName");
        Intrinsics.checkNotNullParameter(r10, "intent");
        Intrinsics.checkNotNullParameter(r17, "newStateLog");
        String r19 = r10.a();
        if (r19 != null) goto L15;
        r19 = r10.toString();
    L15:
        MviLogLevel r20 = r10.b();
        StringBuilder r21 = androidx.constraintlayout.motion.widget.a.y("[", r5, "] Intent: ", r19, " \n--> NewState: ");
        r21.append(r17);
        h.a(r20, r21.toString());
        return;
    L19:
        th = move-exception;
        r13.restoreCurrent(r14);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r13.dispose();
        throw th;
    }

    public final k b() {
        return (k) this.f11529a.getValue();
    }

    public abstract k c(k r5, j r10);
}
