package com.bytedance.android.live.effect.beauty.smallitem;

import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements com.bytedance.android.live.effect.api.k.b {
    public final /* synthetic */ d a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.bytedance.android.live.effect.api.j d;
    public final /* synthetic */ q e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            List<Sticker> r5 = (List) r4;
            e r0 = this.a;
            Map<String, Map<String, List<Sticker>>> r1 = r0.a.b;
            LinkedHashMap r2 = (LinkedHashMap) r1;
            if (r2.get(r0.b) != null) goto L5;
            e r3 = this.a;
            r3.a.b.put(r3.b, new LinkedHashMap());
        L5:
            e r6 = this.a;
            Map<String, Map<String, List<Sticker>>> r7 = r6.a.b;
            LinkedHashMap r8 = (LinkedHashMap) r7;
            Map r9 = (Map) r8.get(r6.b);
            if (r9 == null) goto L8;
            List r11 = (List) r9.put(this.a.c, r5);
        L8:
            q r12 = this.a.e;
            if (r12 == null) goto L12;
            r12.a(r5, null);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            q r3 = this.a.e;
            if (r3 == null) goto L6;
            r3.onError();
            return;
        }
    }

    @Override // com.bytedance.android.live.effect.api.k.b
    public final void onFetchFailed() {
        q r0 = this.e;
        if (r0 == null) goto L5;
        r0.onError();
    L5:
        ALogger.i("ttlive_anchor_effect_LiveBeautyMultiCategoryHelper", "on fetchCategoryEffect fail");
    }

    @Override // com.bytedance.android.live.effect.api.k.b
    public final void a(List<? extends Effect> r24, EffectDataFetchCacheType r25) {
        Intrinsics.checkNotNullParameter(r24, "effectList");
        Intrinsics.checkNotNullParameter(r25, "cacheType");
        if (((LinkedHashMap) this.a.c).get(this.b) != null) goto L5;
        this.a.c.put(this.b, new LinkedHashMap());
    L5:
        Map r2 = (Map) ((LinkedHashMap) this.a.c).get(this.b);
        if (r2 == null) goto L9;
        List r3 = (List) r2.put(this.c, r24);
    L9:
        if (Intrinsics.areEqual(this.b, "beautyclassify") == false) goto L101;
        d r4 = this.a;
        String r5 = this.b;
        String r6 = this.c;
        com.bytedance.android.live.effect.api.j r7 = this.d;
        q r8 = this.e;
        r4.getClass();
        LiveSmallItemBeautyHelper r9 = r7.g();
        g r14 = new g(r4, r5, r6, r8);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r24, "list");
        ALogger.d("LiveUxTracer", "loadSmallItemBeautySuccess, " + System.currentTimeMillis());
        ArrayList r11 = new ArrayList();
        List<? extends Effect> r1 = r24;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r13 = r1.iterator();
    L12:
        if (r13.hasNext() == false) goto L58;
        Effect r15 = (Effect) r13.next();
        if (r15.getEffectType() == 1) goto L16;
    L18:
        boolean r16 = false;
    L19:
        ArrayList r17 = new ArrayList();
        if (r16 == false) goto L57;
        String r18 = r15.getResourceId();
        List r19 = r15.getChildEffects();
        if (r19 == null) goto L42;
        Iterator r21 = r19.iterator();
        int r22 = 0;
    L25:
        if (r21.hasNext() == false) goto L40;
        Effect r23 = (Effect) r21.next();
        List<String> r110 = LiveEffectContext.h;
        Iterator<T> r111 = LiveEffectContext.a.a(r9.g).a().o(com.bytedance.android.live.effect.api.d0.i).iterator();
    L28:
        if (r111.hasNext() == false) goto L33;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((Sticker) r112).getEffectId(), r23.getEffectId()) == false) goto L28;
    L34:
        if (r112 == null) goto L36;
        boolean r26 = true;
    L37:
        if (r26 == true) goto L41;
        r22 = r22 + 1;
    L41:
        Integer r27 = Integer.valueOf(r22);
    L43:
        int r28 = r27.intValue();
        if (r28 > 0) goto L46;
        r28 = 0;
    L46:
        List r113 = r15.getChildEffects();
        if (r113 == null) goto L57;
        int r114 = r113.size();
        int r115 = 0;
    L49:
        if (r115 >= r114) goto L57;
        if (r115 != r28) goto L52;
        boolean r116 = true;
    L53:
        List<Sticker> r29 = r9.e;
        Effect r31 = (Effect) ListProtector.get(r113, r115);
        int r210 = r115;
        boolean r117 = r116;
        int r118 = r114;
        ArrayList r119 = r17;
        List r211 = r113;
        Sticker r32 = r9.b(r29, r31, r117, r18, true, true);
        if (r32.getSmallItemConfig() == null) goto L56;
        r119.add(r32);
    L56:
        r115 = r210 + 1;
        r17 = r119;
        r114 = r118;
        r113 = r211;
        goto L49
    L52:
        r116 = false;
        goto L53
    L36:
        r26 = false;
        goto L37
    L33:
        r112 = null;
        goto L34
    L40:
        r22 = -1;
        goto L41
    L42:
        r27 = null;
    L57:
        Sticker r33 = r9.b(r9.e, r15, !r16, null, true, true);
        r33.setSubStickers(r17);
        r12.add(r33);
        goto L12
    L16:
        if (CollectionUtils.isEmpty(r15.getChildEffects()) == true) goto L18;
        r16 = true;
        goto L19
    L58:
        r11.clear();
        r11.addAll(r12);
        if (r12.isEmpty() == false) goto L61;
        r9.d.l("empty beauty list");
        ALogger.e("LiveSmallItemBeautyDialogFragment", "empty beauty list: " + r11);
    L61:
        ArrayList r34 = new ArrayList();
        Iterator r35 = r12.iterator();
    L63:
        if (r35.hasNext() == false) goto L95;
        Object r36 = r35.next();
        Sticker r37 = (Sticker) r36;
        if (CollectionUtils.isEmpty(r37.getSubStickers()) == false) goto L67;
        Sticker r38 = null;
    L71:
        List r120 = r37.getSubStickers();
        if (r120 == null) goto L83;
        Iterator r121 = r120.iterator();
    L75:
        if (r121.hasNext() == false) goto L83;
        Sticker r122 = (Sticker) r121.next();
        Effect r123 = r37.getEffect();
        if (r123 == null) goto L79;
        String r124 = r123.getResourceId();
    L80:
        r122.setParentResId(r124);
        if (r122.getDefault() == false) goto L75;
        r38 = r122;
        goto L75
    L79:
        r124 = null;
    L83:
        if (r38 == null) goto L86;
        ((CopyOnWriteArrayList) r9.f).add(r38);
    L86:
        if (r37.getSmallItemConfig() == null) goto L88;
    L91:
        boolean r125 = true;
    L92:
        if (r125 == false) goto L63;
        r34.add(r36);
        goto L63
    L88:
        if (CollectionUtils.isEmpty(r37.getSubStickers()) == false) goto L91;
        r125 = false;
        goto L92
    L67:
        List r39 = r37.getSubStickers();
        if (r39 == null) goto L70;
        r38 = (Sticker) ListProtector.get(r39, 0);
        goto L71
    L70:
        r38 = null;
        goto L71
    L95:
        if (r34.isEmpty() == false) goto L97;
        r9.d.l("beauty list cleared by filter1");
        ALogger.e("LiveSmallItemBeautyDialogFragment", "beauty list cleared by filter1: " + r11);
    L97:
        List<Sticker> r41 = CollectionsKt.toList(r34);
        if ((!Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper()))) == false) goto L100;
        AndroidSchedulers.mainThread().scheduleDirect(new com.bytedance.android.live.effect.l(r41, r14));
        return;
    L100:
        r14.onSuccess(r41);
        return;
    L101:
        com.bytedance.android.live.effect.sticker.d.e(r24).subscribe(new a(this), new b(this));
    }

    public e(d r1, String r2, String r3, com.bytedance.android.live.effect.api.j r4, d.b r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
