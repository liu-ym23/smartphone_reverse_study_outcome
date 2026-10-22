package com.bytedance.android.live.effect.beauty.makeups;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.utils.n;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.CollectionUtils;
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
    public final /* synthetic */ d a;
    public final /* synthetic */ com.bytedance.android.live.effect.beauty.makeups.a.c b;

    public static final class a implements Runnable {
        public final /* synthetic */ e a;
        public final /* synthetic */ EffectChannelResponse b;

        public a(e r1, EffectChannelResponse r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            d r0 = this.a.a;
            List r1 = this.b.getAllCategoryEffects();
            com.bytedance.android.live.effect.beauty.makeups.a.c r2 = this.a.b;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "list");
            r0.a.clear();
            List r3 = r1;
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator r5 = r3.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            Effect r6 = (Effect) r5.next();
            Sticker r7 = com.bytedance.android.live.effect.sticker.d.b(r6);
            n.c(r6, r7);
            r4.add(r7);
            goto L4
        L6:
            ArrayList r8 = new ArrayList();
            Iterator r9 = r4.iterator();
        L8:
            if (r9.hasNext() == false) goto L18;
            Object r11 = r9.next();
            Sticker r12 = (Sticker) r11;
            if (Lists.isEmpty(r12.getComposerConfigList()) == true) goto L12;
        L15:
            boolean r13 = true;
        L16:
            if (r13 == false) goto L8;
            r8.add(r11);
            goto L8
        L12:
            if (CollectionUtils.isEmpty(r12.getSubStickers()) == false) goto L15;
            r13 = false;
            goto L16
        L18:
            List r14 = CollectionsKt.toList(r8);
            if (Lists.isEmpty(r14) == false) goto L21;
            AndroidSchedulers.mainThread().scheduleDirect(new f(r2));
            return;
        L21:
            r0.a.addAll(r14);
            List<String> r15 = LiveEffectContext.h;
            LiveEffectContext.a.a(r0.c).a().j(d0.k, new h(r0));
            AndroidSchedulers.mainThread().scheduleDirect(new g(r14, r2));
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
        com.bytedance.android.live.effect.beauty.makeups.a.c r0 = this.b;
        if (r0 == null) goto L6;
        r0.onError();
        return;
    }

    public e(d r1, LiveMakeupsBeautyFragment.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.effect.api.k.j
    public final void c(EffectChannelResponse r2, EffectDataFetchCacheType r3) {
        Intrinsics.checkNotNullParameter(r3, "cacheType");
        if (r2 != null) goto L5;
    L9:
        com.bytedance.android.live.effect.beauty.makeups.a.c r4 = this.b;
        if (r4 == null) goto L13;
        r4.onError();
        return;
    L13:
        return;
    L5:
        if (Lists.isEmpty(r2.getAllCategoryEffects()) == true) goto L9;
        TTExecutors.getNormalExecutor().submit(new a(this, r2));
    }
}
