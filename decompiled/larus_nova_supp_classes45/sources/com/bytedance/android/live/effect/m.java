package com.bytedance.android.live.effect;

import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m implements com.bytedance.android.live.effect.api.k.j {
    public final /* synthetic */ LiveSmallItemBeautyHelper a;
    public final /* synthetic */ LiveSmallItemBeautyHelper.c b;

    public static final class a implements Runnable {
        public final /* synthetic */ m a;
        public final /* synthetic */ EffectChannelResponse b;

        public a(m r1, EffectChannelResponse r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            LiveSmallItemBeautyHelper r1 = this.a.a;
            List r2 = this.b.getAllCategoryEffects();
            LiveSmallItemBeautyHelper.c r9 = this.a.b;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "list");
            ALogger.d("LiveUxTracer", "loadSmallItemBeautySuccess, " + System.currentTimeMillis());
            ((CopyOnWriteArrayList) r1.b).clear();
            ArrayList r11 = new ArrayList();
            List r3 = r2;
            ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
            Iterator r13 = r3.iterator();
        L4:
            if (r13.hasNext() == false) goto L51;
            Effect r15 = (Effect) r13.next();
            if (r15.getEffectType() == 1) goto L8;
        L10:
            boolean r16 = false;
        L11:
            ArrayList r8 = new ArrayList();
            if (r16 == false) goto L50;
            String r17 = r15.getResourceId();
            List r4 = r15.getChildEffects();
            if (r4 == null) goto L34;
            Iterator r5 = r4.iterator();
            int r6 = 0;
        L17:
            if (r5.hasNext() == false) goto L32;
            Effect r7 = (Effect) r5.next();
            List<String> r14 = LiveEffectContext.h;
            Iterator<T> r18 = LiveEffectContext.a.a(r1.g).a().o(d0.i).iterator();
        L20:
            if (r18.hasNext() == false) goto L25;
            Object r19 = r18.next();
            if (Intrinsics.areEqual(((Sticker) r19).getEffectId(), r7.getEffectId()) == false) goto L20;
        L26:
            if (r19 == null) goto L28;
            boolean r21 = true;
        L29:
            if (r21 == true) goto L33;
            r6 = r6 + 1;
        L33:
            Integer r22 = Integer.valueOf(r6);
        L35:
            int r23 = r22.intValue();
            if (r23 > 0) goto L38;
            int r110 = 0;
        L39:
            List r24 = r15.getChildEffects();
            if (r24 == null) goto L50;
            int r25 = r24.size();
            int r26 = 0;
        L42:
            if (r26 >= r25) goto L50;
            if (r26 != r110) goto L45;
            boolean r111 = true;
        L46:
            List<Sticker> r27 = r1.b;
            Effect r28 = (Effect) ListProtector.get(r24, r26);
            int r29 = r26;
            boolean r31 = r111;
            int r112 = r25;
            List r210 = r24;
            ArrayList r113 = r8;
            Sticker r32 = r1.b(r27, r28, r31, r17, false, false);
            if (r32.getSmallItemConfig() == null) goto L49;
            r113.add(r32);
        L49:
            r26 = r29 + 1;
            r8 = r113;
            r25 = r112;
            r24 = r210;
            goto L42
        L45:
            r111 = false;
            goto L46
        L38:
            r110 = r23;
            goto L39
        L28:
            r21 = false;
            goto L29
        L25:
            r19 = null;
            goto L26
        L32:
            r6 = -1;
            goto L33
        L34:
            r22 = null;
        L50:
            Sticker r33 = r1.b(r1.b, r15, !r16, null, false, false);
            r33.setSubStickers(r8);
            r12.add(r33);
            goto L4
        L8:
            if (CollectionUtils.isEmpty(r15.getChildEffects()) == true) goto L10;
            r16 = true;
            goto L11
        L51:
            r11.clear();
            r11.addAll(r12);
            if (r12.isEmpty() == false) goto L54;
            r1.d.l("empty beauty list");
            ALogger.e("LiveSmallItemBeautyDialogFragment", "empty beauty list: " + r11);
        L54:
            ArrayList r34 = new ArrayList();
            Iterator r35 = r12.iterator();
        L56:
            if (r35.hasNext() == false) goto L88;
            Object r36 = r35.next();
            Sticker r37 = (Sticker) r36;
            if (CollectionUtils.isEmpty(r37.getSubStickers()) == true) goto L63;
            List r38 = r37.getSubStickers();
            if (r38 == null) goto L63;
            Sticker r39 = (Sticker) ListProtector.get(r38, 0);
        L64:
            List r114 = r37.getSubStickers();
            if (r114 == null) goto L76;
            Iterator r115 = r114.iterator();
        L68:
            if (r115.hasNext() == false) goto L76;
            Sticker r116 = (Sticker) r115.next();
            Effect r117 = r37.getEffect();
            if (r117 == null) goto L72;
            String r118 = r117.getResourceId();
        L73:
            r116.setParentResId(r118);
            if (r116.getDefault() == false) goto L68;
            r39 = r116;
            goto L68
        L72:
            r118 = null;
        L76:
            if (r39 == null) goto L79;
            ((CopyOnWriteArrayList) r1.a).add(r39);
        L79:
            if (r37.getSmallItemConfig() == null) goto L81;
        L84:
            boolean r41 = true;
        L85:
            if (r41 == false) goto L56;
            r34.add(r36);
            goto L56
        L81:
            if (CollectionUtils.isEmpty(r37.getSubStickers()) == false) goto L84;
            r41 = false;
        L63:
            r39 = null;
            goto L64
        L88:
            if (r34.isEmpty() == false) goto L90;
            r1.d.l("beauty list cleared by filter1");
            ALogger.e("LiveSmallItemBeautyDialogFragment", "beauty list cleared by filter1: " + r11);
        L90:
            List<Sticker> r42 = CollectionsKt.toList(r34);
            if (r9 != null) goto L94;
            return;
        L94:
            if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L96;
            AndroidSchedulers.mainThread().scheduleDirect(new n(r42, r9));
            return;
        L96:
            List<Sticker> r43 = r42;
            if (r43 != null) goto L99;
        L102:
            boolean r119 = true;
        L103:
            if (r119 == false) goto L105;
            r9.onError();
            return;
        L105:
            r9.onSuccess(r42);
            return;
        L99:
            if (r43.isEmpty() == true) goto L102;
            r119 = false;
            goto L103
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

    public m(LiveSmallItemBeautyHelper r1, LiveSmallItemBeautyHelper.c r2) {
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
        TTExecutors.getNormalExecutor().submit(new a(this, r2));
    }
}
