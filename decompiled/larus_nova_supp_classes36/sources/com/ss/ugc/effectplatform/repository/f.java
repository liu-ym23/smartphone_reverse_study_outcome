package com.ss.ugc.effectplatform.repository;

import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.CategoryPageModel;
import com.ss.ugc.effectplatform.model.ExceptionResult;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements IEffectPlatformBaseListener<CategoryPageModel> {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    public final void onSuccess(Object r2) {
        CategoryPageModel r3 = (CategoryPageModel) r2;
        IEffectPlatformBaseListener r0 = this.a.d;
        if (r0 == null) goto L6;
        r0.onSuccess(r3);
        return;
    }

    public final void onFail(Object r11, ExceptionResult r12) {
        CategoryPageModel r13 = (CategoryPageModel) r11;
        g r14 = this.a;
        r14.a.b(r14.b, r14.c, 0, 0, 0, "0", false, null, r14.d);
    }
}
