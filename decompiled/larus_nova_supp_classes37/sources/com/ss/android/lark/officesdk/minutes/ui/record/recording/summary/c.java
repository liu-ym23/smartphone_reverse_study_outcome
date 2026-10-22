package com.ss.android.lark.officesdk.minutes.ui.record.recording.summary;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final Function0<Unit> a;
    public final Handler b;
    public int c;
    public boolean d;
    public final b e;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.d = false;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public c(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "onManualScroll");
        this.a = r2;
        this.b = new Handler(Looper.getMainLooper());
        this.e = new b(this);
    }

    public final void a(int r3, int r4) {
        if (r3 != r4) goto L5;
        return;
    L5:
        if (this.c <= 0) goto L8;
        return;
    L8:
        if (this.d == true) goto L10;
        this.d = true;
        this.a.invoke();
    L10:
        this.b.removeCallbacks(this.e);
        this.b.postDelayed(this.e, 200);
    }
}
