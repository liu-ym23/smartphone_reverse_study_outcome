package com.ss.android.lark.filedetail.impl.detail;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements Runnable {
    public final /* synthetic */ String a;

    public final void a() {
        Lazy r0 = FileHitPointUtil.a;
        FileHitPointUtil.a(this.a);
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

    public f(String r1, FileContent r2, String r3) {
        this.a = r1;
    }
}
