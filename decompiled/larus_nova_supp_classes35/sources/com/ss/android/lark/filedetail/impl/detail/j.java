package com.ss.android.lark.filedetail.impl.detail;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements Runnable {
    public final /* synthetic */ FileContent a;
    public final /* synthetic */ File b;
    public final /* synthetic */ p c;

    @Override // java.lang.Runnable
    public final void run() {
        p.a(this.c, this.a, this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public j(p r1, FileContent r2, VFSFile r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
