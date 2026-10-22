package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.file;

import android.content.Context;
import b3b.h;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import mya.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements Runnable {
    public final /* synthetic */ m2b.a a;
    public final /* synthetic */ y6b.a<FileContentVO> b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ a d;

    public d(m2b.a r1, y6b.a r2, Context r3, a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m r0 = this.a.j5().b(m.class);     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.f(this.b.getId(), this.c);     // Catch: Throwable -> L9
    L14:
        return;
    L5:
        h r1 = this.d.a;     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        r1.q(this.b.getId());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }
}
