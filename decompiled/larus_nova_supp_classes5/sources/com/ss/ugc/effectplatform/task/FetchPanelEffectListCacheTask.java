package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.io.file.b;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.cache.j;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.EffectChannelModel;
import com.ss.ugc.effectplatform.model.EffectChannelResponse;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.util.f;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class FetchPanelEffectListCacheTask extends BaseTask {
    public final EffectConfig g;
    public final String h;
    public final String i;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void a() {
        EffectConfig r1 = this.g;
        j r2 = (j) r1.A.a;
        EffectChannelModel r3 = null;
        if (r2 == null) goto L5;
        int r4 = f.a;
        b r5 = r2.queryToStream(f.k(r1.e, this.h));
    L7:
        if (r5 != null) goto L51;
        e(new onFail.1(this, new ExceptionResult(10004)));
        return;
    L51:
        String r6 = FileManager.a;     // Catch: Throwable -> L14
        String r7 = FileManager.h(r5);     // Catch: Throwable -> L14
        dlc.a r8 = this.g.t;     // Catch: Throwable -> L14
        if (r8 == null) goto L13;
        r3 = (EffectChannelModel) r8.a.convertJsonToObj(r7, EffectChannelModel.class);     // Catch: Throwable -> L14
    L13:
        FileManager.b(r5);
        if (r3 != null) goto L21;
    L44:
        e(new onFail.1(this, new ExceptionResult(10004)));
        return;
    L21:
        if (r3.checkValued() == false) goto L44;
        if (this.g.P == false) goto L43;
        List<Effect> r0 = r3.getEffect_list();
        if (r0 == null) goto L32;
        Iterator<T> r9 = r0.iterator();
    L28:
        if (r9.hasNext() == false) goto L32;
        if (com.ss.ugc.effectplatform.extension.b.a((Effect) r9.next()) == true) goto L28;
    L39:
        boolean r10 = false;
    L41:
        if (r10 == true) goto L43;
    L32:
        List<Effect> r11 = r3.getCollection_list();
        if (r11 == null) goto L40;
        Iterator<T> r12 = r11.iterator();
    L36:
        if (r12.hasNext() == false) goto L40;
        if (com.ss.ugc.effectplatform.extension.b.a((Effect) r12.next()) == true) goto L36;
    L40:
        r10 = true;
    L43:
        final EffectChannelResponse r13 = new jlc.a(this.h, this.g.i, true).a(r3);
        e(new FetchPanelEffectListCacheTask$onSuccess$1(this, r13));
        return;
    L14:
        th = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchPanelEffectListCacheTask", "Json Parse Exception: " + th, null, 4, null);     // Catch: Throwable -> L46
        EffectConfig r14 = this.g;     // Catch: Throwable -> L46
        j r15 = (j) r14.A.a;     // Catch: Throwable -> L46
        if (r15 == null) goto L18;
        int r16 = f.a;     // Catch: Throwable -> L46
        r15.remove(f.k(r14.e, this.h));     // Catch: Throwable -> L46
    L18:
        String r17 = FileManager.a;
    L46:
        th = move-exception;
        String r18 = FileManager.a;
        FileManager.b(r5);
        throw th;
    L5:
        r5 = null;
        goto L7
    }

    @Override // com.ss.ugc.effectplatform.task.BaseTask
    public final void b() {
        e(new onCancel.1(this));
    }

    public FetchPanelEffectListCacheTask(EffectConfig r2, String r3, String r4) {
        super(r4, null);
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }
}
