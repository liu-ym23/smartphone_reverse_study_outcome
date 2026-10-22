package com.ss.ugc.effectplatform.task;

import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class y0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(EffectConfig r4, String r5, PanelInfoModel r6) {
        CategoryEffectModel r0 = r6.getCategory_effects();
        if (r0 == null) goto L12;
        com.ss.ugc.effectplatform.util.h r1 = com.ss.ugc.effectplatform.util.h.a;
        String r2 = r4.i;
        List<Effect> r3 = r0.getCategory_effects();
        r1.getClass();
        com.ss.ugc.effectplatform.util.h.d(r2, r5, r3);
        com.ss.ugc.effectplatform.util.h.d(r4.i, r5, r0.getCollection());
        com.ss.ugc.effectplatform.util.h.d(r4.i, r5, r0.getBind_effects());
        if (r4.s != 2) goto L13;
        com.ss.ugc.effectplatform.util.h.h(r6.getUrl_prefix(), r0.getCategory_effects());
        com.ss.ugc.effectplatform.util.h.h(r6.getUrl_prefix(), r0.getCollection());
        com.ss.ugc.effectplatform.util.h.h(r6.getUrl_prefix(), r0.getBind_effects());
        PanelInfoModel.Extra r7 = r6.getExtra();
        if (r7 == null) goto L14;
        String r8 = r7.getRec_id();
        if (r8 == null) goto L15;
        com.ss.ugc.effectplatform.util.h.f(r8, r0.getCategory_effects());
        com.ss.ugc.effectplatform.util.h.f(r8, r0.getCollection());
        com.ss.ugc.effectplatform.util.h.f(r8, r0.getBind_effects());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }
}
