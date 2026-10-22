package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements com.bytedance.android.live.effect.api.k.g {
    public final /* synthetic */ f.a a;
    public final /* synthetic */ Function1 b;

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void Z(String r1, Sticker r2) {
    }

    public g(f.a r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void O1(String r4, Sticker r5) {
        if (r5 != null) goto L7;
        ALogger.d("ttlive_anchor_effect_ResourceUtil", "sticker download fail response: sticker: null");
        f.a r6 = this.a;
        if (r6 == null) goto L11;
        r6.b(new ExceptionResult(new Exception("sticker is null")));
        return;
    L11:
        return;
    L7:
        ALogger.d("ttlive_anchor_effect_ResourceUtil", "sticker download success ^_^,response: sticker: " + r5.getId() + " path: " + r5.getUnzipPath());
        com.bytedance.android.live.effect.soundeffect.h.a(r5, LiveEffectContextFactoryDelegate$Type.DEFAULT);
        r5.setDownloading(false);
        r5.setDownloaded(true);
        f.a r7 = this.a;
        if (r7 == null) goto L13;
        r7.a(r5);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k.g
    public final void onProgress(int r1, long r2) {
        this.b.invoke(Integer.valueOf(r1));
    }

    @Override // com.bytedance.android.live.effect.api.k.f
    public final void z0(String r4, Sticker r5, ExceptionResult r6) {
        StringBuilder r7 = new StringBuilder("sticker download fail response: sticker: ");
        String r0 = null;
        if (r5 == null) goto L5;
        Long r1 = Long.valueOf(r5.getId());
    L6:
        r7.append(r1);
        r7.append(" path: ");
        if (r5 == null) goto L9;
        r0 = r5.getUnzipPath();
    L9:
        r7.append(r0);
        ALogger.d("ttlive_anchor_effect_ResourceUtil", r7.toString());
        if (r5 == null) goto L12;
        r5.setDownloading(false);
    L12:
        f.a r8 = this.a;
        if (r8 == null) goto L16;
        r8.b(r6);
        return;
    L16:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
