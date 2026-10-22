package com.ss.ugc.effectplatform;

import com.ss.ugc.effectplatform.cache.j;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.EffectCategoryResponse;
import com.ss.ugc.effectplatform.model.EffectChannelResponse;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements hlc.c<List<? extends Effect>> {
    public final a0.b<String> a;
    public final /* synthetic */ EffectPlatform$h b;
    public final /* synthetic */ EffectChannelResponse c;

    public final void onFinally() {
        String r0 = (String) this.a.a;
        if (r0 == null) goto L8;
        j r1 = (j) this.b.a.getEffectConfig().A.a;
        if (r1 == null) goto L9;
        int r2 = f.a;
        r1.save(f.k(this.b.a.getEffectConfig().e, this.c.getPanel()), r0);
        return;
    L9:
        return;
    }

    public final void onStart() {
        int r0 = f.a;
        String r1 = f.k(this.b.a.getEffectConfig().e, this.c.getPanel());
        j r2 = (j) this.b.a.getEffectConfig().A.a;
        if (r2 == null) goto L5;
        String r3 = r2.queryToValue(r1);
    L6:
        this.a.a = r3;
        j r4 = (j) this.b.a.getEffectConfig().A.a;
        if (r4 == null) goto L10;
        r4.remove(r1);
        return;
    L10:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onSuccess(Object r8) {
        List r9 = (List) r8;
        EffectChannelResponse r0 = this.c;
        r0.setAll_category_effects(r9);
        Iterator r1 = r0.getCategory_responses().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        EffectCategoryResponse r2 = (EffectCategoryResponse) r1.next();
        ArrayList r3 = new ArrayList();
        List r4 = r2.getTotal_effects();
        if (r4 == null) goto L13;
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        Effect r6 = (Effect) r5.next();
        if (r9.contains(r6) == false) goto L9;
        r3.add(r6);
    L13:
        r2.setTotal_effects(r3);
        goto L4
    L14:
        IEffectPlatformBaseListener r10 = this.b.c;
        if (r10 == null) goto L25;
        r10.onSuccess(r0);
        return;
    }

    public d(EffectPlatform$h r1, EffectChannelResponse r2) {
        this.b = r1;
        this.c = r2;
        this.a = new a0.b(null);
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        List r4 = (List) r2;
        IEffectPlatformBaseListener r5 = this.b.c;
        if (r5 == null) goto L6;
        r5.onFail(null, r3);
        return;
    }
}
