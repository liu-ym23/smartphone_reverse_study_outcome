package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchCategoryEffectListener;
import com.ss.android.ugc.effectmanager.effect.model.CategoryEffectModel;
import com.ss.android.ugc.effectmanager.effect.model.CategoryPageModel;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0 implements IFetchCategoryEffectListener {
    public final /* synthetic */ LiveStickerDataManager a;
    public final /* synthetic */ com.bytedance.android.live.effect.api.k.b b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ LiveStickerDataManager$fetchManagerEffectByCategory$1 e;
    public final /* synthetic */ AtomicBoolean f;
    public final /* synthetic */ long g;

    public final void onFail(ExceptionResult r4) {
        com.bytedance.android.live.effect.api.k.b r0 = this.b;
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
        com.bytedance.android.live.effect.api.k.b r9 = this.b;
        if (r9 == null) goto L12;
        r9.onFetchFailed();
    L12:
        LiveEffectMonitor.b(this.c, this.d, 1000, "fetchCategoryEffect empty result");
        return;
    L13:
        CategoryEffectModel r2 = r8.getCategoryEffects();
        if (r2 == null) goto L19;
        List<? extends Effect> r3 = r2.getCollectEffects();
        List r4 = r2.getEffects();
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = r4.iterator();
    L17:
        if (r6.hasNext() == false) goto L19;
        Effect r11 = (Effect) r6.next();
        r5.add(LiveStickerDataManager$fetchManagerEffectByCategory$2.INSTANCE.invoke(r11, r3));
    L19:
        Map<String, Map<String, CategoryPageModel>> r12 = this.a.g;
        LinkedHashMap r13 = (LinkedHashMap) r12;
        if (r13.get(this.c) != null) goto L22;
        Map<String, Map<String, CategoryPageModel>> r14 = this.a.g;
        String r15 = this.c;
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put(this.d, r8);
        Unit r17 = Unit.INSTANCE;
        r14.put(r15, r16);
    L25:
        LiveStickerDataManager$fetchManagerEffectByCategory$1 r18 = this.e;
        if (this.f.get() == false) goto L28;
        EffectDataFetchCacheType r19 = EffectDataFetchCacheType.HitEPCache;
    L29:
        r18.invoke(r1, r19);
        LiveEffectMonitor.c(this.c, this.d, r1, System.currentTimeMillis() - this.g);
        return;
    L28:
        r19 = EffectDataFetchCacheType.NoCache;
        goto L29
    L22:
        Map<String, Map<String, CategoryPageModel>> r21 = this.a.g;
        LinkedHashMap r22 = (LinkedHashMap) r21;
        Map r23 = (Map) r22.get(this.c);
        if (r23 == null) goto L25;
        CategoryPageModel r24 = (CategoryPageModel) r23.put(this.d, r8);
    L7:
        r1 = null;
        goto L8
    }

    public d0(LiveStickerDataManager r1, e0 r2, String r3, String r4, LiveStickerDataManager$fetchManagerEffectByCategory$1 r5, AtomicBoolean r6, long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
