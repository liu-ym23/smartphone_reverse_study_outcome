package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchCategoryEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.CategoryEffectModel;
import com.ss.android.ugc.effectmanager.effect.model.CategoryPageModel;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h0 implements IFetchCategoryEffectListener {
    public final /* synthetic */ LiveStickerDataManager a;
    public final /* synthetic */ com.bytedance.android.live.effect.api.k.a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ LiveStickerDataManager$fetchStickerByCategory$1 e;
    public final /* synthetic */ AtomicBoolean f;
    public final /* synthetic */ long g;

    public final void onFail(ExceptionResult r4) {
        com.bytedance.android.live.effect.api.k.a r0 = this.b;
        if (r0 == null) goto L5;
        r0.onFetchFailed();
    L5:
        String r1 = this.c;
        String r2 = this.d;
        if (r4 == null) goto L8;
        int r3 = r4.getErrorCode();
    L9:
        if (r4 == null) goto L11;
        String r5 = r4.getMsg();
    L12:
        LiveEffectMonitor.b(r1, r2, r3, r5);
        return;
    L11:
        r5 = null;
        goto L12
    L8:
        r3 = -1;
        goto L9
    }

    public final void onSuccess(Object r7) {
        CategoryPageModel r8 = (CategoryPageModel) r7;
        if (r8 == null) goto L7;
        CategoryEffectModel r0 = r8.getCategoryEffects();
        if (r0 == null) goto L7;
        List<? extends Effect> r1 = r0.getEffects();
    L8:
        if (r1 != null) goto L13;
        com.bytedance.android.live.effect.api.k.a r9 = this.b;
        if (r9 == null) goto L12;
        r9.onFetchFailed();
    L12:
        LiveEffectMonitor.b(this.c, this.d, 1000, "fetchCategoryEffect empty result");
        return;
    L13:
        Map<String, Map<String, CategoryPageModel>> r2 = this.a.g;
        LinkedHashMap r3 = (LinkedHashMap) r2;
        if (r3.get(this.c) != null) goto L16;
        Map<String, Map<String, CategoryPageModel>> r4 = this.a.g;
        String r5 = this.c;
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put(this.d, r8);
        Unit r11 = Unit.INSTANCE;
        r4.put(r5, r6);
    L19:
        LiveStickerDataManager$fetchStickerByCategory$1 r12 = this.e;
        if (this.f.get() == false) goto L22;
        EffectDataFetchCacheType r13 = EffectDataFetchCacheType.HitEPCache;
    L23:
        r12.invoke(r1, r13);
        LiveEffectMonitor.c(this.c, this.d, r1, System.currentTimeMillis() - this.g);
        return;
    L22:
        r13 = EffectDataFetchCacheType.NoCache;
        goto L23
    L16:
        Map<String, Map<String, CategoryPageModel>> r14 = this.a.g;
        LinkedHashMap r15 = (LinkedHashMap) r14;
        Map r16 = (Map) r15.get(this.c);
        if (r16 == null) goto L19;
        CategoryPageModel r17 = (CategoryPageModel) r16.put(this.d, r8);
    L7:
        r1 = null;
        goto L8
    }

    public h0(LiveStickerDataManager r1, com.bytedance.android.live.effect.api.k.a r2, String r3, String r4, LiveStickerDataManager$fetchStickerByCategory$1 r5, AtomicBoolean r6, long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
