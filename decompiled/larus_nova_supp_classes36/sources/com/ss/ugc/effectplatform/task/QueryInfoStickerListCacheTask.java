package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.InfoStickerEffect;
import com.ss.ugc.effectplatform.model.net.QueryInfoStickerListModel;
import com.ss.ugc.effectplatform.model.net.QueryInfoStickerResponse;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class QueryInfoStickerListCacheTask extends BaseTask {
    public final EffectConfig g;
    public final String h;
    public final Integer i;
    public final Integer j;
    public final String k;

    public final void a() {
        EffectConfig r1 = this.g;
        com.ss.ugc.effectplatform.cache.j r2 = (com.ss.ugc.effectplatform.cache.j) r1.A.a;
        List<InfoStickerEffect> r3 = null;
        if (r2 == null) goto L5;
        int r4 = com.ss.ugc.effectplatform.util.f.a;
        bytekn.foundation.io.file.b r5 = r2.queryToStream(com.ss.ugc.effectplatform.util.f.e(r1.e, this.h, this.i, this.j));
    L7:
        if (r5 != null) goto L35;
        final ExceptionResult r0 = new ExceptionResult(10004);
        e(new QueryInfoStickerListCacheTask$onFail$1(this, r0));
        return;
    L35:
        String r6 = FileManager.a;     // Catch: Throwable -> L15
        String r7 = FileManager.h(r5);     // Catch: Throwable -> L15
        dlc.a r8 = this.g.t;     // Catch: Throwable -> L15
        if (r8 == null) goto L13;
        final QueryInfoStickerResponse r9 = (QueryInfoStickerResponse) r8.a.convertJsonToObj(r7, QueryInfoStickerResponse.class);     // Catch: Throwable -> L15
    L14:
        FileManager.b(r5);
    L18:
        if (r9 != null) goto L20;
    L30:
        final ExceptionResult r10 = new ExceptionResult(10004);
        e(new QueryInfoStickerListCacheTask$onFail$1(this, r10));
        return;
    L20:
        if (r9.checkValue() == false) goto L30;
        com.ss.ugc.effectplatform.util.h r11 = com.ss.ugc.effectplatform.util.h.a;
        String r12 = this.g.i;
        QueryInfoStickerListModel r13 = r9.getData();
        if (r13 == null) goto L25;
        List<InfoStickerEffect> r14 = r13.getEffects();
    L26:
        r11.getClass();
        com.ss.ugc.effectplatform.util.h.g(r12, r14);
        String r15 = this.g.i;
        QueryInfoStickerListModel r16 = r9.getData();
        if (r16 == null) goto L29;
        r3 = r16.getCollection();
    L29:
        com.ss.ugc.effectplatform.util.h.g(r15, r3);
        e(new QueryInfoStickerListCacheTask$onSuccess$1(this, r9));
        return;
    L25:
        r14 = null;
        goto L26
    L13:
        r9 = null;
    L15:
        th = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchCategoryEffectCacheTask", "Json Parse Exception: " + th, null, 4, null);     // Catch: Throwable -> L32
        String r17 = FileManager.a;
        FileManager.b(r5);
        r9 = null;
    L32:
        th = move-exception;
        String r18 = FileManager.a;
        FileManager.b(r5);
        throw th;
    L5:
        r5 = null;
        goto L7
    }

    public final void b() {
        e(new QueryInfoStickerListCacheTask$onCancel$1(this));
    }

    public QueryInfoStickerListCacheTask(EffectConfig r2, String r3, Integer r4, Integer r5, String r6) {
        super(r6, null);
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
    }
}
