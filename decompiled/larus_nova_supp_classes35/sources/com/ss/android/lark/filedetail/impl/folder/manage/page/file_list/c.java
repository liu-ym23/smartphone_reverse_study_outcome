package com.ss.android.lark.filedetail.impl.folder.manage.page.file_list;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.filedetail.impl.folder.manage.entity.FileType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ nfb.a b;

    public c(a r1, nfb.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r1 = false;
        a.H8(this.a).T3(false, true, false);     // Catch: Throwable -> L7
        j r0 = a.H8(this.a);     // Catch: Throwable -> L7
        if (this.b.getType() == FileType.FOLDER) goto L5;
        r1 = true;
    L5:
        r0.Q5(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
