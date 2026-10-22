package com.bytedance.android.ec.core.utils.font;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements Runnable {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        ECFontHelper.e.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
