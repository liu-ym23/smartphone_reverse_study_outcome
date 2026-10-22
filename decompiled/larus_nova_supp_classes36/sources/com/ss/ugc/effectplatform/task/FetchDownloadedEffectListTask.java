package com.ss.ugc.effectplatform.task;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.EffectCategoryModel;
import com.ss.ugc.effectplatform.model.EffectCategoryResponse;
import com.ss.ugc.effectplatform.model.EffectChannelModel;
import com.ss.ugc.effectplatform.model.EffectChannelResponse;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FetchDownloadedEffectListTask extends BaseTask {
    public final EffectConfig g;
    public final String h;
    public final String i;

    public static final class a {
    }

    static {
    }

    public final void a() {
        int r0 = com.ss.ugc.effectplatform.util.r.a;
        if (com.ss.ugc.effectplatform.util.r.b(this.h) == false) goto L6;
        final ExceptionResult r1 = new ExceptionResult(10007);
        e(new FetchDownloadedEffectListTask$onFail$1(this, r1));
        return;
    L6:
        EffectChannelModel r4 = null;
        final EffectChannelResponse r2 = new EffectChannelResponse(null, null, null, null, null, null, null, null, null, 511, null);
        EffectConfig r3 = this.g;
        com.ss.ugc.effectplatform.cache.j r5 = (com.ss.ugc.effectplatform.cache.j) r3.A.a;
        if (r5 == null) goto L9;
        int r6 = com.ss.ugc.effectplatform.util.f.a;
        String r7 = r5.queryToValue(com.ss.ugc.effectplatform.util.f.k(r3.e, this.h));
    L10:
        if (r7 != null) goto L57;
    L17:
        if (r4 != null) goto L19;
    L55:
        final ExceptionResult r8 = new ExceptionResult(10004);
        e(new FetchDownloadedEffectListTask$onFail$1(this, r8));
        return;
    L19:
        if (r4.checkValued() == false) goto L55;
        List r9 = r4.getEffect_list();
        ArrayList r10 = new ArrayList();
        if (r9 == null) goto L32;
        com.ss.ugc.effectplatform.cache.j r11 = (com.ss.ugc.effectplatform.cache.j) this.g.A.a;
        if (r11 == null) goto L32;
        Iterator r12 = r9.iterator();
    L27:
        if (r12.hasNext() == false) goto L32;
        Effect r13 = (Effect) r12.next();
        if (r11.has(r13.getId()) == false) goto L27;
        r10.add(r13);
    L32:
        if (r10.isEmpty() == false) goto L35;
        final EffectChannelResponse r14 = new EffectChannelResponse(this.h, null, null, null, null, null, null, null, null, 510, null);
        e(new FetchDownloadedEffectListTask$onSuccess$1(this, r14));
        return;
    L35:
        r2.setAll_category_effects(r10);
        List r15 = r4.getCategory_list();
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L37:
        if (r17.hasNext() == false) goto L53;
        EffectCategoryModel r18 = (EffectCategoryModel) r17.next();
        if (r18.checkValued() == false) goto L37;
        String r19 = r18.getId();
        String r110 = r18.getName();
        String r111 = r18.getKey();
        List r20 = r18.getEffects();
        ArrayList r112 = new ArrayList();
        if (r20 == null) goto L52;
        Iterator r21 = r20.iterator();
    L44:
        if (r21.hasNext() == false) goto L52;
        String r113 = (String) r21.next();
        Iterator r114 = r10.iterator();
    L47:
        if (r114.hasNext() == false) goto L44;
        Effect r115 = (Effect) r114.next();
        Iterator r24 = r17;
        if (Intrinsics.areEqual(r113, r115.getEffect_id()) == false) goto L51;
        r112.add(r115);
    L51:
        r17 = r24;
    L52:
        EffectCategoryResponse r22 = new EffectCategoryResponse(r19, r110, r111, null, null, null, null, r112, r18.getTags(), r18.getTags_updated_at(), null, false, null, 7288, null);
        r22.setCollection_effect(r4.getCollection_list());
        r22.set_default(r18.is_default());
        r22.setExtra(r18.getExtra());
        r16.add(r22);
        r17 = r17;
        goto L37
    L53:
        r2.setCategory_responses(r16);
        r2.setPanel(this.h);
        r2.setPanel_model(r4.getPanel_model());
        e(new FetchDownloadedEffectListTask$onSuccess$1(this, r2));
        return;
    L57:
        dlc.a r23 = this.g.t;     // Catch: Exception -> L15
        if (r23 == null) goto L17;
        r4 = (EffectChannelModel) r23.a.convertJsonToObj(r7, EffectChannelModel.class);     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Logger.e$default(Logger.INSTANCE, "FetchDownloadedEffectListTask", "Json Parse Exception: " + e, null, 4, null);
        goto L17
    L9:
        r7 = null;
        goto L10
    }

    public final void b() {
        e(new FetchDownloadedEffectListTask$onCancel$1(this));
    }

    public FetchDownloadedEffectListTask(EffectConfig r2, String r3, String r4) {
        super(r4, null);
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }
}
