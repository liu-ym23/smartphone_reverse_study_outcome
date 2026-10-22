package com.ss.android.lark.forwardv3;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements Runnable {
    public final /* synthetic */ ForwardNewFragment a;
    public final /* synthetic */ ErrorResult b;
    public final /* synthetic */ Ref.ObjectRef<String> c;

    public e(ForwardNewFragment r1, ErrorResult r2, Ref.ObjectRef<String> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(this.a.requireContext(), this.b.getDisplayMsg((String) this.c.element));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
