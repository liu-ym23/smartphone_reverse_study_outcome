package com.bytedance.android.live.effect.beauty.filter;

import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.utils.n;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements k.j {
    public final /* synthetic */ LiveComposerFilterHelper a;
    public final /* synthetic */ LiveSmallItemBeautyHelper.c b;
    public final /* synthetic */ String c;

    public static final class a implements Runnable {
        public final /* synthetic */ e a;
        public final /* synthetic */ EffectChannelResponse b;

        public a(e r1, EffectChannelResponse r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            LiveComposerFilterHelper r0 = this.a.a;
            List r1 = this.b.getAllCategoryEffects();
            e r2 = this.a;
            LiveSmallItemBeautyHelper.c r3 = r2.b;
            String r4 = r2.c;
            ((ArrayList) r0.b).clear();
            List r5 = r1;
            ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
            Iterator r7 = r5.iterator();
        L4:
            if (r7.hasNext() == false) goto L7;
            Effect r8 = (Effect) r7.next();
            Sticker r9 = com.bytedance.android.live.effect.sticker.d.b(r8);
            n.c(r8, r9);
            r6.add(r9);
            goto L4
        L7:
            if (Lists.isEmpty(r6) == false) goto L9;
            AndroidSchedulers.mainThread().scheduleDirect(new f(r3));
            return;
        L9:
            List<Sticker> r11 = r0.b;
            ArrayList r12 = (ArrayList) r11;
            r12.add(new Sticker());
            ((ArrayList) r0.b).addAll(r6);
            r0.b().j(d0.a, new h(r0, r4));
            AndroidSchedulers.mainThread().scheduleDirect(new g(r0, r3));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.live.effect.api.k.i
    public final void a(EffectChannelResponse r1) {
    }

    @Override // com.bytedance.android.live.effect.api.k.i
    public final void b() {
        LiveSmallItemBeautyHelper.c r0 = this.b;
        if (r0 == null) goto L6;
        r0.onError();
        return;
    }

    @Override // com.bytedance.android.live.effect.api.k.j
    public final void c(EffectChannelResponse r2, EffectDataFetchCacheType r3) {
        Intrinsics.checkNotNullParameter(r3, "cacheType");
        if (r2 != null) goto L5;
    L9:
        LiveSmallItemBeautyHelper.c r4 = this.b;
        if (r4 == null) goto L13;
        r4.onError();
        return;
    L13:
        return;
    L5:
        if (Lists.isEmpty(r2.getAllCategoryEffects()) == true) goto L9;
        TTExecutors.getNormalExecutor().submit(new a(this, r2));
    }

    public e(LiveComposerFilterHelper r1, LiveComposerFilterFragment.c r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
