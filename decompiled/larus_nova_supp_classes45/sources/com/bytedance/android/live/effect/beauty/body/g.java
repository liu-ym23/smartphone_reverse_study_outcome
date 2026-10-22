package com.bytedance.android.live.effect.beauty.body;

import android.os.Looper;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public final List<Sticker> a;
    public final List<LiveSmallItemBeautyHelper.b> b;
    public final LiveEffectContextFactoryDelegate$Type c;

    public static final class a implements com.bytedance.android.live.effect.api.k.j {
        public final /* synthetic */ g a;
        public final /* synthetic */ LiveSmallItemBeautyHelper.c b;

        /* JADX INFO: renamed from: com.bytedance.android.live.effect.beauty.body.g$a$a, reason: collision with other inner class name */
        public static final class RunnableC0181a implements Runnable {
            public final /* synthetic */ a a;
            public final /* synthetic */ EffectChannelResponse b;

            public RunnableC0181a(a r1, EffectChannelResponse r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void a() {
                g r0 = this.a.a;
                List r1 = this.b.getAllCategoryEffects();
                LiveSmallItemBeautyHelper.c r2 = this.a.b;
                ((ArrayList) r0.a).clear();
                List r3 = r1;
                ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
                Iterator r5 = r3.iterator();
            L4:
                if (r5.hasNext() == false) goto L6;
                Sticker r6 = com.bytedance.android.live.effect.sticker.d.b((Effect) r5.next());
                g.c(r0, r6);
                r4.add(r6);
                goto L4
            L6:
                ArrayList r7 = new ArrayList();
                Iterator r8 = r4.iterator();
            L8:
                if (r8.hasNext() == false) goto L18;
                Object r9 = r8.next();
                Sticker r11 = (Sticker) r9;
                if (Lists.isEmpty(r11.getComposerConfigList()) == true) goto L12;
            L15:
                boolean r12 = true;
            L16:
                if (r12 == false) goto L8;
                r7.add(r9);
                goto L8
            L12:
                if (CollectionUtils.isEmpty(r11.getSubStickers()) == false) goto L15;
                r12 = false;
                goto L16
            L18:
                List r13 = CollectionsKt.toList(r7);
                if (Lists.isEmpty(r13) == false) goto L21;
                AndroidSchedulers.mainThread().scheduleDirect(new h(r2));
                return;
            L21:
                ArrayList r14 = (ArrayList) r0.a;
                r14.addAll(r13);
                AndroidSchedulers.mainThread().scheduleDirect(new i(r13, r2));
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

        public a(g r1, LiveSmallItemBeautyHelper.c r2) {
            this.a = r1;
            this.b = r2;
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
            TTExecutors.getNormalExecutor().submit(new RunnableC0181a(this, r2));
        }
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.c;
    }

    public g(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.c = r2;
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final void a(Sticker r9) {
        List<String> r0 = LiveEffectContext.h;
        ILiveEffectComposerManager r1 = LiveEffectContext.a.a(this.c).a();
        Iterator r2 = ((ArrayList) this.a).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((Sticker) r3).getResourceId(), r9.getResourceId()) == false) goto L4;
    L9:
        Sticker r4 = (Sticker) r3;
        if (r4 == null) goto L23;
        String r11 = r4.getEffectId();
        Sticker.ComposerConfig r5 = r4.getSmallItemConfig();
        if (r5 == null) goto L15;
        String r6 = r5.getTag();
        if (r6 == null) goto L15;
    L17:
        if (r1.G(r11, r6) != null) goto L24;
        ILiveEffectComposerManager.f.a(r1, "livebody", r4, "LiveBodyBeautyHelper_addSticker", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("is_restore", "")}), null, 48);
        return;
    L24:
        return;
    L15:
        r6 = "";
        goto L17
    L23:
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final void b(LiveSmallItemBeautyHelper.c r8) {
        a r2 = new a(this, r8);
        List<String> r9 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.c).b().h().c() == false) goto L5;
        com.bytedance.android.live.effect.sticker.presenter.o.a.a(LiveEffectContext.a.a(this.c).b().d(), "livebody", r2, true, true, true, 16);
        return;
    L5:
        LiveEffectContext.a.a(this.c).b().r().p("livebody", r2, true);
    }

    public static void c(g r4, Sticker r5) {
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "sticker");
        LiveBodyBeautyHelper$tryDownloadSticker$1 r1 = new LiveBodyBeautyHelper$tryDownloadSticker$1(Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())));
        List<String> r0 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(r4.c).b().r().q(r5) == false) goto L8;
        r4.a(r5);
        Iterator r6 = ((ArrayList) r4.b).iterator();
    L6:
        if (r6.hasNext() == false) goto L11;
        ((LiveSmallItemBeautyHelper.b) r6.next()).a(r5);
        goto L6
    L11:
        return;
    L8:
        LiveEffectContext.a.a(r4.c).b().r().g("livebody", r5, new j(r4, r1, null));
    }
}
