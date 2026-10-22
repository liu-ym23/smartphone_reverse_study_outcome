package com.bytedance.android.livesdk.chatroom.vs_base.base.view;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements View.OnClickListener {
    public boolean a;
    public final a b;
    public final Function1<View, Unit> c;
    public final long d;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a = true;     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.a == true) goto L7;
        return;
    L7:
        this.a = false;
        r4.postDelayed(this.b, this.d);
        this.c.invoke(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super View, Unit> r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "onClickMethod");
        this.c = r2;
        this.d = r3;
        this.a = true;
        this.b = new a(this);
    }
}
