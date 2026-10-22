package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements Runnable {
    public final /* synthetic */ a a;

    public d(a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.H8(this.a).Q5(true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
