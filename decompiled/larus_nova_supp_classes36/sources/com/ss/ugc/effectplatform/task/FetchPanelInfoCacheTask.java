package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import com.ss.ugc.effectplatform.model.net.PanelInfoResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FetchPanelInfoCacheTask extends BaseTask {
    public final EffectConfig g;
    public final String h;
    public final String i;
    public final boolean j;
    public final String k;
    public final int l;
    public final int m;

    public static final class a {
    }

    static {
    }

    public final void a() {
        EffectConfig r1 = this.g;
        com.ss.ugc.effectplatform.cache.j r2 = (com.ss.ugc.effectplatform.cache.j) r1.A.a;
        PanelInfoResponse r3 = null;
        if (r2 == null) goto L5;
        int r4 = com.ss.ugc.effectplatform.util.f.a;
        bytekn.foundation.io.file.b r5 = r2.queryToStream(com.ss.ugc.effectplatform.util.f.g(r1.e, this.h, this.j, this.k, this.m, this.l, r1.s));
    L7:
        if (r5 != null) goto L36;
        f(new ExceptionResult(10004));
        return;
    L36:
        String r6 = FileManager.a;     // Catch: Throwable -> L14
        String r7 = FileManager.h(r5);     // Catch: Throwable -> L14
        dlc.a r8 = this.g.t;     // Catch: Throwable -> L14
        if (r8 == null) goto L13;
        r3 = (PanelInfoResponse) r8.a.convertJsonToObj(r7, PanelInfoResponse.class);     // Catch: Throwable -> L14
    L13:
        FileManager.b(r5);
        if (r3 != null) goto L19;
    L31:
        f(new ExceptionResult(10004));
        return;
    L19:
        if (r3.checkValue() == false) goto L31;
        if (this.g.P == true) goto L23;
    L25:
        final PanelInfoModel r0 = r3.getData();
        if (r0 == null) goto L41;
        EffectConfig r9 = this.g;
        if (r9.W != 2) goto L30;
        int r10 = y0.a;
        y0.a(r9, this.h, r0);
    L30:
        e(new FetchPanelInfoCacheTask$onSuccess$1(this, r0));
        return;
    L41:
        return;
    L23:
        if (r3.verifySign() == true) goto L25;
    L14:
        th = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoCacheTask", "Json Parse Exception: " + th, null, 4, null);     // Catch: Throwable -> L33
        String r11 = FileManager.a;
    L33:
        th = move-exception;
        String r12 = FileManager.a;
        FileManager.b(r5);
        throw th;
    L5:
        r5 = null;
        goto L7
    }

    public final void b() {
        e(new FetchPanelInfoCacheTask$onCancel$1(this));
    }

    public final void f(final ExceptionResult r7) {
        Logger.e$default(Logger.INSTANCE, "FetchPanelInfoCacheTask", "Failed: " + r7, null, 4, null);
        e(new FetchPanelInfoCacheTask$onFail$1(this, r7));
    }

    public FetchPanelInfoCacheTask(EffectConfig r2, String r3, String r4, boolean r5, String r6, int r7, int r8) {
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
