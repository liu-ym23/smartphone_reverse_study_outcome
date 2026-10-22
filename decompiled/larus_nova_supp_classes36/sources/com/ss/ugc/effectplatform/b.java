package com.ss.ugc.effectplatform;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.CategoryPageModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.net.QueryCustomizedEffectsData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements IEffectPlatformBaseListener<QueryCustomizedEffectsData> {
    public final /* synthetic */ EffectPlatform$d a;
    public final /* synthetic */ CategoryPageModel b;

    public final void onSuccess(Object r3) {
        QueryCustomizedEffectsData r4 = (QueryCustomizedEffectsData) r3;
        ArrayList r0 = new ArrayList();
        CategoryEffectModel r1 = this.b.getCategory_effects();
        if (r1 == null) goto L7;
        List<Effect> r2 = r1.getCategory_effects();
        if (r2 == null) goto L7;
        r0.addAll(r2);
    L7:
        List<Effect> r5 = r4.getEffects();
        if (r5 == null) goto L10;
        r0.addAll(r5);
    L10:
        CategoryEffectModel r6 = this.b.getCategory_effects();
        if (r6 == null) goto L13;
        r6.setCategory_effects(r0);
    L13:
        IEffectPlatformBaseListener r7 = this.a.b;
        if (r7 == null) goto L17;
        r7.onSuccess(this.b);
        return;
    }

    public b(EffectPlatform$d r1, CategoryPageModel r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFail(Object r1, ExceptionResult r2) {
        QueryCustomizedEffectsData r3 = (QueryCustomizedEffectsData) r1;
        IEffectPlatformBaseListener r4 = this.a.b;
        if (r4 == null) goto L6;
        r4.onSuccess(this.b);
        return;
    }
}
