package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import com.ss.ugc.effectplatform.model.net.PanelInfoPagingCheckedResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FetchPanelInfoPagingCheckedCacheTask extends BaseTask {
    public final EffectConfig g;
    public final String h;
    public final String i;
    public final String j;
    public final int k;
    public final int l;
    public final int m;
    public final String n;

    public static final class a {
    }

    static {
    }

    public final void a() {
        EffectConfig r1 = this.g;
        com.ss.ugc.effectplatform.cache.j r2 = (com.ss.ugc.effectplatform.cache.j) r1.A.a;
        PanelInfoPagingCheckedResponse r3 = null;
        if (r2 == null) goto L5;
        int r4 = com.ss.ugc.effectplatform.util.f.a;
        bytekn.foundation.io.file.b r5 = r2.queryToStream(com.ss.ugc.effectplatform.util.f.h(r1.e, this.h, this.j, this.l, this.k, this.m, this.n));
    L7:
        if (r5 != null) goto L35;
        f(new ExceptionResult(10004));
        return;
    L35:
        String r6 = FileManager.a;     // Catch: Throwable -> L14
        String r7 = FileManager.h(r5);     // Catch: Throwable -> L14
        dlc.a r8 = this.g.t;     // Catch: Throwable -> L14
        if (r8 == null) goto L13;
        r3 = (PanelInfoPagingCheckedResponse) r8.a.convertJsonToObj(r7, PanelInfoPagingCheckedResponse.class);     // Catch: Throwable -> L14
    L13:
        FileManager.b(r5);
        if (r3 != null) goto L19;
    L28:
        f(new ExceptionResult(10004));
        return;
    L19:
        if (r3.checkValue() == false) goto L28;
        if (this.g.P == true) goto L23;
    L25:
        final PanelInfoModel r0 = r3.getResponseData();
        if (r0 == null) goto L38;
        e(new FetchPanelInfoPagingCheckedCacheTask$onSuccess$1(this, r0));
        return;
    L38:
        return;
    L23:
        if (r3.verifySign() == true) goto L25;
    L14:
        th = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoPagingCheckedCacheTask", "Json Parse Exception: " + th, null, 4, null);     // Catch: Throwable -> L30
        String r9 = FileManager.a;
    L30:
        th = move-exception;
        String r10 = FileManager.a;
        FileManager.b(r5);
        throw th;
    L5:
        r5 = null;
        goto L7
    }

    public final void b() {
        e(new FetchPanelInfoPagingCheckedCacheTask$onCancel$1(this));
    }

    public final void f(final ExceptionResult r7) {
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoPagingCheckedCacheTask", "Failed: " + r7, null, 4, null);
        e(new FetchPanelInfoPagingCheckedCacheTask$onFail$1(this, r7));
    }

    public FetchPanelInfoPagingCheckedCacheTask(EffectConfig r2, String r3, String r4, String r5, int r6, int r7, int r8, String r9) {
        super(r4, null);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.l = r7;
        this.m = r8;
        this.n = r9;
    }
}
