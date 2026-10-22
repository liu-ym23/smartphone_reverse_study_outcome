package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.CategoryInfoResponse;
import com.ss.ugc.effectplatform.model.EffectCategoryModelList;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FetchCategoryInfoCacheTask extends BaseTask {
    public final EffectConfig g;
    public final String h;
    public final String i;
    public final List<Integer> j;

    public static final class a {
    }

    static {
    }

    public final void a() {
        EffectConfig r1 = this.g;
        com.ss.ugc.effectplatform.cache.j r2 = (com.ss.ugc.effectplatform.cache.j) r1.A.a;
        CategoryInfoResponse r3 = null;
        if (r2 == null) goto L5;
        int r4 = com.ss.ugc.effectplatform.util.f.a;
        bytekn.foundation.io.file.b r5 = r2.queryToStream(com.ss.ugc.effectplatform.util.f.b(r1.e, this.h, this.j));
    L7:
        if (r5 != null) goto L30;
        f(new ExceptionResult(10004));
        return;
    L30:
        String r6 = FileManager.a;     // Catch: Throwable -> L14 Exception -> L16
        String r7 = FileManager.h(r5);     // Catch: Throwable -> L14 Exception -> L16
        dlc.a r8 = this.g.t;     // Catch: Throwable -> L14 Exception -> L16
        if (r8 == null) goto L13;
        r3 = (CategoryInfoResponse) r8.a.convertJsonToObj(r7, CategoryInfoResponse.class);     // Catch: Throwable -> L14 Exception -> L16
        goto L13
    L13:
        FileManager.b(r5);
        if (r3 != null) goto L21;
    L26:
        f(new ExceptionResult(10004));
        return;
    L21:
        if (r3.checkValue() == false) goto L26;
        final EffectCategoryModelList r0 = r3.getData();
        if (r0 == null) goto L34;
        e(new FetchCategoryInfoCacheTask$onSuccess$1(this, r0));
        return;
    L34:
        return;
    L16:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchCategoryInfoCacheTask", "Json Parse Exception: " + e, null, 4, null);     // Catch: Throwable -> L14
        String r9 = FileManager.a;
    L14:
        th = move-exception;
        String r10 = FileManager.a;
        FileManager.b(r5);
        throw th;
    L5:
        r5 = null;
        goto L7
    }

    public final void b() {
        e(new FetchCategoryInfoCacheTask$onCancel$1(this));
    }

    public final void f(final ExceptionResult r7) {
        Logger.e$default(Logger.INSTANCE, "FetchCategoryInfoCacheTask", "Failed: " + r7, null, 4, null);
        e(new FetchCategoryInfoCacheTask$onFail$1(this, r7));
    }

    public FetchCategoryInfoCacheTask(EffectConfig r2, String r3, String r4, List<Integer> r5) {
        super(r4, null);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
    }
}
