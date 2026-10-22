package com.bytedance.android.live.effect.beauty.newtemp;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.j;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.beauty.smallitem.q;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import com.ss.android.ugc.effectmanager.effect.model.PanelInfoModel;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements k.d {
    public final /* synthetic */ c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ j c;
    public final /* synthetic */ WeakReference d;

    @Override // com.bytedance.android.live.effect.api.k.d
    public final void onFetchFailed() {
        WeakReference r0 = this.d;
        if (r0 == null) goto L8;
        q r1 = (q) r0.get();
        if (r1 == null) goto L9;
        r1.onError();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k.d
    public final void a(PanelInfoModel r8, EffectDataFetchCacheType r9) {
        Intrinsics.checkNotNullParameter(r8, "panelInfo");
        Intrinsics.checkNotNullParameter(r9, "cacheType");
        ALogger.i("ttlive_inspiration_panel", "on loadSmallItemBeautyData FetchSuccess");
        c r11 = this.a;
        String r0 = this.b;
        j r1 = this.c;
        WeakReference r2 = this.d;
        r11.getClass();
        if ((!r8.getCategory_list().isEmpty()) == false) goto L19;
        List<String> r3 = LiveEffectContext.h;
        EffectCategoryModel r12 = LiveEffectContext.a.a(r11.c).b().d().i(r0, r8);
        if (r12 != null) goto L11;
        if (r2 == null) goto L24;
        q r13 = (q) r2.get();
        if (r13 == null) goto L25;
        r13.onError();
        return;
    L25:
        return;
    L24:
        return;
    L11:
        if (r2 == null) goto L13;
        q r4 = (q) r2.get();
    L14:
        Intrinsics.checkNotNullParameter(r0, "panel");
        Intrinsics.checkNotNullParameter(r12, "model");
        Intrinsics.checkNotNullParameter(r1, "iLiveEffectService");
        y50.c r5 = y50.c.d;
        r5.b("beauty_multi_load_effects");
        String r14 = r12.getKey();
        e r6 = new e(r4);
        List<Sticker> r7 = (List) ((LinkedHashMap) r11.a).get(r0);
        if (r7 == null) goto L17;
        r6.a(r7, null);
    L18:
        r5.a("beauty_multi_load_effects");
        return;
    L17:
        r1.d().o(r0, r14, new d(r11, r0, r6));
        goto L18
    L13:
        r4 = null;
        goto L14
    L19:
        if (r2 == null) goto L28;
        q r15 = (q) r2.get();
        if (r15 == null) goto L29;
        r15.onError();
        return;
    L29:
        return;
    }

    public f(c r1, j r2, WeakReference r3) {
        this.a = r1;
        this.b = "inspiration_beautification";
        this.c = r2;
        this.d = r3;
    }
}
