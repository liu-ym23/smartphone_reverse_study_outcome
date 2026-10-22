package com.bytedance.android.live.service.preinflate;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ ProfilePreInflateViewInfo b;

    public b(a r1, ProfilePreInflateViewInfo r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<String> r0 = ProfilePreInflateUtil.f;     // Catch: Throwable -> L4
        ArrayList r1 = (ArrayList) r0;     // Catch: Throwable -> L4
        r1.remove(this.b.getTag());     // Catch: Throwable -> L4
        ProfilePreInflateUtil.b(this.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
