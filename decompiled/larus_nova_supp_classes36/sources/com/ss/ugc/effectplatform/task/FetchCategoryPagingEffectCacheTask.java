package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.CategoryPageModel;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.CategoryEffectListResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FetchCategoryPagingEffectCacheTask extends BaseTask {
    public final EffectConfig g;
    public final String h;
    public final String i;
    public final String j;
    public final int k;
    public final int l;
    public final int m;

    public static final class a {
    }

    static {
    }

    public final void a() {
        com.ss.ugc.effectplatform.cache.j r1 = (com.ss.ugc.effectplatform.cache.j) this.g.A.a;
        CategoryEffectListResponse r2 = null;
        if (r1 == null) goto L5;
        int r3 = com.ss.ugc.effectplatform.util.f.a;
        bytekn.foundation.io.file.b r4 = r1.queryToStream(com.ss.ugc.effectplatform.util.f.c(this.h, this.j, this.k, this.l, this.m));
    L7:
        if (r4 != null) goto L36;
        final ExceptionResult r0 = new ExceptionResult(10004);
        e(new FetchCategoryPagingEffectCacheTask$onFail$1(this, r0));
        return;
    L36:
        String r5 = FileManager.a;     // Catch: Throwable -> L14
        String r6 = FileManager.h(r4);     // Catch: Throwable -> L14
        dlc.a r7 = this.g.t;     // Catch: Throwable -> L14
        if (r7 == null) goto L13;
        r2 = (CategoryEffectListResponse) r7.a.convertJsonToObj(r6, CategoryEffectListResponse.class);     // Catch: Throwable -> L14
    L13:
        FileManager.b(r4);
        if (r2 != null) goto L19;
    L31:
        final ExceptionResult r8 = new ExceptionResult(10004);
        e(new FetchCategoryPagingEffectCacheTask$onFail$1(this, r8));
        return;
    L19:
        if (r2.checkValue() == false) goto L31;
        if (this.g.P == true) goto L23;
    L25:
        final CategoryPageModel r9 = r2.getData();
        if (r9 == null) goto L41;
        CategoryEffectModel r10 = r9.getCategory_effects();
        if (r10 == null) goto L30;
        r10.setCache(true);
    L30:
        e(new FetchCategoryPagingEffectCacheTask$onSuccess$1(this, r9));
        return;
    L41:
        return;
    L23:
        if (r2.verifySign() == true) goto L25;
    L14:
        th = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchCategoryPagingEffectCacheTask", "Json Parse Exception: " + th, null, 4, null);     // Catch: Throwable -> L33
        String r11 = FileManager.a;
    L33:
        th = move-exception;
        String r12 = FileManager.a;
        FileManager.b(r4);
        throw th;
    L5:
        r4 = null;
        goto L7
    }

    public final void b() {
        e(new FetchCategoryPagingEffectCacheTask$onCancel$1(this));
    }

    public FetchCategoryPagingEffectCacheTask(EffectConfig r2, String r3, String r4, String r5, int r6, int r7, int r8) {
        super(r4, null);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.l = r7;
        this.m = r8;
    }
}
