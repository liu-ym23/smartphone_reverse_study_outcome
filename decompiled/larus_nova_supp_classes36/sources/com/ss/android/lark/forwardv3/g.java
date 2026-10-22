package com.ss.android.lark.forwardv3;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.forwardv3.data.ForwardErrorResultV3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements Runnable {
    public final /* synthetic */ ForwardNewFragment a;
    public final /* synthetic */ ErrorResult b;
    public final /* synthetic */ Ref.ObjectRef<String> c;
    public final /* synthetic */ ForwardErrorResultV3 d;

    public g(ForwardNewFragment r1, ErrorResult r2, Ref.ObjectRef<String> r3, ForwardErrorResultV3 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(this.a.requireContext(), this.b.getDisplayMsg((String) this.c.element));     // Catch: Throwable -> L6
        if (this.d.isWillClose() == false) goto L9;
        ForwardNewFragment r0 = this.a;     // Catch: Throwable -> L6
        int r1 = ForwardNewFragment.t;     // Catch: Throwable -> L6
        r0.X90(null, null);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
