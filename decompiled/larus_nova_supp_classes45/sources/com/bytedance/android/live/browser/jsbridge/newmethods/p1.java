package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchCategoryEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.CategoryEffectModel;
import com.ss.android.ugc.effectmanager.effect.model.CategoryPageModel;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p1 implements IFetchCategoryEffectListener {
    public final /* synthetic */ o1 a;
    public final /* synthetic */ w20.t7 b;
    public final /* synthetic */ EffectManager c;

    public final void onFail(ExceptionResult r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        ALogger.e("CanLoadFromLokiMethod", "query effect error. msg=" + r3.getMsg(), r3.getException());
        o1.j(this.a, null);
    }

    public final void onSuccess(Object r6) {
        CategoryPageModel r7 = (CategoryPageModel) r6;
        Effect r0 = null;
        Object r1 = null;
        r0 = null;
        r0 = null;
        if (r7 == null) goto L22;
        CategoryEffectModel r8 = r7.getCategoryEffects();
        if (r8 == null) goto L22;
        List r9 = r8.getEffects();
        if (r9 == null) goto L22;
        Iterator r11 = r9.iterator();
    L10:
        if (r11.hasNext() == false) goto L21;
        Object r2 = r11.next();
        Effect r3 = (Effect) r2;
        if (Intrinsics.areEqual(r3.getName(), this.b.c()) == true) goto L14;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == false) goto L10;
        r1 = r2;
        goto L21
    L14:
        if (this.c.isEffectReady(r3) == false) goto L18;
        if (this.c.isEffectDownloaded(r3) == false) goto L18;
        r4 = true;
    L21:
        r0 = (Effect) r1;
    L22:
        o1.j(this.a, r0);
    }

    public p1(o1 r1, w20.t7 r2, EffectManager r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
