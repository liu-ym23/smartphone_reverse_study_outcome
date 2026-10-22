package com.ss.android.lark.filedetail.impl.detail;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Runnable {
    public final /* synthetic */ String a;

    public a(String r1) {
        this.a = r1;
    }

    public final void a() {
        VFSFile r0 = sfb.c.b().i(this.a);
        if (r0.exists() == true) goto L11;
        Log.i("DecryptFileProcessor", "delete path: " + this.a + " failed for not exist");
        return;
    L11:
        r0.delete();     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        Log.e("DecryptFileProcessor", "delete path " + this.a + " failed for " + e.getMessage());
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
