package com.ss.ugc.effectplatform;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.CategoryPageModel;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class EffectPlatform$d implements IEffectPlatformBaseListener<CategoryPageModel> {
    public final /* synthetic */ EffectPlatform a;
    public final /* synthetic */ IEffectPlatformBaseListener b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Map d;

    public final void onSuccess(Object r5) {
        EffectPlatform.access$getEffectListRepository$p(this.a).i(this.c, this.d, new b(this, (CategoryPageModel) r5));
    }

    public final void onFail(Object r2, ExceptionResult r3) {
        CategoryPageModel r4 = (CategoryPageModel) r2;
        IEffectPlatformBaseListener r0 = this.b;
        if (r0 == null) goto L6;
        r0.onFail(r4, r3);
        return;
    }

    public EffectPlatform$d(EffectPlatform r1, IEffectPlatformBaseListener r2, String r3, Map r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
