package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final a a;
    public final Lifecycle b;
    public final Lifecycle.State c;
    public final b d;

    public static final class a implements LifecycleEventObserver {
        public final /* synthetic */ c a;
        public final /* synthetic */ Job b;

        public a(c r1, Job r10) {
            this.a = r1;
            this.b = r10;
        }

        public final void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            Intrinsics.checkNotNullParameter(r10, "source");
            Intrinsics.checkNotNullParameter(r11, "<anonymous parameter 1>");
            if (r10.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
            c r12 = this.a;
            Job.DefaultImpls.cancel$default(this.b, null, 1, null);
            r12.a();
            return;
        L6:
            if (r10.getLifecycle().getCurrentState().compareTo(this.a.c) >= 0) goto L8;
            this.a.d.a = true;
            return;
        L8:
            b r13 = this.a.d;
            if (r13.a == true) goto L12;
            return;
        L12:
            if ((!r13.b) == false) goto L16;
            r13.a = false;
            r13.a();
            return;
        L16:
            throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
        }
    }

    public final void a() {
        this.b.removeObserver(this.a);
        b r0 = this.d;
        r0.b = true;
        r0.a();
    }

    public c(Lifecycle r10, Lifecycle.State r11, b r12, Job r13) {
        Intrinsics.checkNotNullParameter(r10, "lifecycle");
        Intrinsics.checkNotNullParameter(r11, "minState");
        Intrinsics.checkNotNullParameter(r12, "dispatchQueue");
        Intrinsics.checkNotNullParameter(r13, "parentJob");
        this.b = r10;
        this.c = r11;
        this.d = r12;
        a r14 = new a(this, r13);
        this.a = r14;
        if (r10.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
        a();
        return;
    L5:
        r10.addObserver(r14);
    }
}
