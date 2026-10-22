package com.obric.assistant.remote_card_container.cache;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import p9a.b;
import p9a.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ String a;

    public /* synthetic */ g(String r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        PolarisFileWrapper r5 = new PolarisFileWrapper((File) i.c.getValue(), i.a.a(r0));     // Catch: Throwable -> L9
        if (r5.exists() == false) goto L6;
        r5.delete();     // Catch: Throwable -> L9
        e r1 = b.a;     // Catch: Throwable -> L9
        b.a("DiskCache", "deleted " + r5.getName());     // Catch: Throwable -> L9
    L7:
        Object r2 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L17;
        e r6 = b.a;
        b.c("DiskCache", "removeCache failed " + r3.getMessage(), r3);
        return;
    L17:
        return;
    L6:
        e r7 = b.a;     // Catch: Throwable -> L9
        b.a("DiskCache", "not exists " + r5.getName());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
