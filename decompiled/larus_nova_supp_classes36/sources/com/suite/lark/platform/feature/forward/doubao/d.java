package com.suite.lark.platform.feature.forward.doubao;

import androidx.fragment.app.FragmentActivity;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.forwardv3.data.ForwardErrorResultV3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ DoubaoForwardConfirmFragment a;
    public final /* synthetic */ ErrorResult b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ForwardErrorResultV3 d;

    public d(DoubaoForwardConfirmFragment r1, ErrorResult r2, String r3, ForwardErrorResultV3 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L11:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    L20:
        return;
    L3:
        if (this.a.isAdded() == false) goto L14;
        DoubaoForwardConfirmFragment r0 = this.a;     // Catch: Throwable -> L11
        String r1 = this.b.getDisplayMsg(this.c);     // Catch: Throwable -> L11
        int r2 = DoubaoForwardConfirmFragment.v;     // Catch: Throwable -> L11
        r0.getClass();     // Catch: Throwable -> L11
        UICallbackExecutor.execute(new f(r0, r1));     // Catch: Throwable -> L11
        if (this.d.isWillClose() == false) goto L18;
        FragmentActivity r3 = this.a.getActivity();     // Catch: Throwable -> L11
        if (r3 == null) goto L19;
        r3.finish();     // Catch: Throwable -> L11
        return;
    L19:
        return;
    L18:
        return;
    }
}
