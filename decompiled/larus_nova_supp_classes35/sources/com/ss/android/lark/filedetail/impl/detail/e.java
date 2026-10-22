package com.ss.android.lark.filedetail.impl.detail;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    public final void a() {
        Lazy r0 = FileHitPointUtil.a;
        if (FileHitPointUtil.b(this.a).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L10;
        FileHitPointUtil.a(this.b);
        return;
    L10:
        return;
    L5:
        r1 = false;
        goto L6
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

    public e(int r1, String r2, FileContent r3) {
        this.a = r1;
        this.b = r2;
    }
}
