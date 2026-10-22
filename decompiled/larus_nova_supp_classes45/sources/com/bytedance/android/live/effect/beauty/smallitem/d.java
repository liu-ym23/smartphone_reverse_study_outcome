package com.bytedance.android.live.effect.beauty.smallitem;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdk.config.wc0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import com.ss.android.ugc.effectmanager.effect.model.PanelInfoModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final /* synthetic */ int e = 0;
    public final Map<String, List<EffectCategoryModel>> a;
    public final Map<String, Map<String, List<Sticker>>> b;
    public final Map<String, Map<String, List<Effect>>> c;
    public final LiveEffectContextFactoryDelegate$Type d;

    public static final class a {
        @JvmStatic
        public static void a(LiveEffectContextFactoryDelegate$Type r4) {
            Intrinsics.checkNotNullParameter(r4, "type");
            wc0 r1 = wc0.a;
            if (((Boolean) r1.getValue()).booleanValue() == false) goto L10;
            int r2 = com.bytedance.android.live.effect.beauty.newtemp.c.d;
            Intrinsics.checkNotNullParameter(r4, "type");
            if (((Boolean) r1.getValue()).booleanValue() == false) goto L14;
            m90.b.c.e(r4, -1);
            com.bytedance.android.live.effect.utils.k.b();
            return;
        L14:
            return;
        L10:
            if (LiveEffectSettings.LIVE_ENABLE_STICKER_BEAUTY_TEMPLATE.getValue().booleanValue() == true) goto L12;
            return;
        L12:
            m90.b.c.e(r4, -1);
            com.bytedance.android.live.effect.utils.k.b();
        }
    }

    public static final class b implements q {
        public final /* synthetic */ d a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.bytedance.android.live.effect.api.j c;
        public final /* synthetic */ Ref.IntRef d;
        public final /* synthetic */ List e;
        public final /* synthetic */ q f;

        @Override // com.bytedance.android.live.effect.beauty.smallitem.q
        public final void onError() {
            q r0 = this.f;
            if (r0 == null) goto L6;
            r0.onError();
            return;
        }

        @Override // com.bytedance.android.live.effect.beauty.smallitem.q
        public final void a(List<Sticker> r5, List<Integer> r6) {
            Intrinsics.checkNotNullParameter(r5, "stickerList");
            Ref.IntRef r7 = this.d;
            int r8 = r7.element + 1;
            r7.element = r8;
            if (r8 != this.e.size()) goto L35;
            ArrayList r9 = new ArrayList();
            ArrayList r11 = new ArrayList();
            ArrayList r0 = new ArrayList();
            Map<String, Map<String, List<Effect>>> r1 = this.a.c;
            LinkedHashMap r2 = (LinkedHashMap) r1;
            Map r3 = (Map) r2.get(this.b);
            if (r3 == null) goto L13;
            Collection r4 = r3.values();
            if (r4 == null) goto L13;
            Iterator r12 = r4.iterator();
        L10:
            if (r12.hasNext() == false) goto L13;
            r0.addAll((List) r12.next());
        L13:
            if (Intrinsics.areEqual(this.b, "beautyclassify") == false) goto L15;
            this.c.d().l(com.bytedance.android.live.effect.api.d0.i, r0);
        L15:
            Iterator r13 = this.e.iterator();
        L17:
            if (r13.hasNext() == false) goto L23;
            EffectCategoryModel r14 = (EffectCategoryModel) r13.next();
            Map<String, Map<String, List<Sticker>>> r15 = this.a.b;
            LinkedHashMap r16 = (LinkedHashMap) r15;
            Map r17 = (Map) r16.get(this.b);
            if (r17 == null) goto L17;
            List r18 = (List) r17.get(r14.getKey());
            if (r18 == null) goto L17;
            r9.addAll(r18);
            r11.add(Integer.valueOf(r18.size()));
            goto L17
        L23:
            q r19 = this.f;
            if (r19 == null) goto L36;
            r19.a(r9, r11);
            return;
        L36:
            return;
        }

        public b(d r1, String r2, com.bytedance.android.live.effect.api.j r3, Ref.IntRef r4, List r5, q r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class c implements com.bytedance.android.live.effect.api.k.d {
        public final /* synthetic */ d a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.bytedance.android.live.effect.api.j c;
        public final /* synthetic */ WeakReference d;

        @Override // com.bytedance.android.live.effect.api.k.d
        public final void onFetchFailed() {
            WeakReference r0 = this.d;
            if (r0 == null) goto L8;
            com.bytedance.android.live.effect.beauty.smallitem.b r1 = (com.bytedance.android.live.effect.beauty.smallitem.b) r0.get();
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
            ALogger.i("ttlive_anchor_effect_LiveBeautyMultiCategoryHelper", "on loadSmallItemBeautyData FetchSuccess");
            d r11 = this.a;
            String r1 = this.b;
            com.bytedance.android.live.effect.api.j r0 = this.c;
            WeakReference r2 = this.d;
            r11.getClass();
            if ((!r8.getCategory_list().isEmpty()) == false) goto L11;
            List<String> r3 = LiveEffectContext.h;
            EffectCategoryModel r12 = LiveEffectContext.a.a(r11.d).b().d().i(r1, r8);
            if (r12 != null) goto L10;
            if (r2 == null) goto L16;
            com.bytedance.android.live.effect.beauty.smallitem.b r13 = (com.bytedance.android.live.effect.beauty.smallitem.b) r2.get();
            if (r13 == null) goto L17;
            r13.onError();
            return;
        L17:
            return;
        L16:
            return;
        L10:
            r0.d().p(r1, r12.getKey(), r12.getChildren_categories(), true, new f(r11, r1, r0, r2));
            return;
        L11:
            if (r2 == null) goto L20;
            com.bytedance.android.live.effect.beauty.smallitem.b r14 = (com.bytedance.android.live.effect.beauty.smallitem.b) r2.get();
            if (r14 == null) goto L21;
            r14.onError();
            return;
        L21:
            return;
        }

        public c(d r1, String r2, com.bytedance.android.live.effect.api.j r3, WeakReference r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.d;
    }

    public d(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.d = r2;
        LiveEffectSettings.LIVE_EFFECT_BEAUTY_PANEL_UPGRADE_CONFIG.getValue().getClass();
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
    }

    public final void a(LiveEffectContextFactoryDelegate$Type r2, String r3, List<EffectCategoryModel> r4, q r5) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "panel");
        Intrinsics.checkNotNullParameter(r4, FileUtils.MODEL);
        List<String> r0 = LiveEffectContext.h;
        b(r3, r4, LiveEffectContext.a.a(r2).b(), r5);
    }

    public final void b(String r17, List<EffectCategoryModel> r18, com.bytedance.android.live.effect.api.j r19, q r21) {
        Intrinsics.checkNotNullParameter(r17, "panel");
        Intrinsics.checkNotNullParameter(r18, FileUtils.MODEL);
        Intrinsics.checkNotNullParameter(r19, "iLiveEffectService");
        y50.c.d.b("beauty_multi_load_effects");
        Ref.IntRef r11 = new Ref.IntRef();
        r11.element = 0;
        Iterator<T> r12 = r18.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        String r13 = ((EffectCategoryModel) r12.next()).getKey();
        b r14 = new b(this, r17, r19, r11, r18, r21);
        Map r0 = (Map) ((LinkedHashMap) this.b).get(r17);
        if (r0 == null) goto L10;
        List<Sticker> r1 = (List) r0.get(r13);
        if (r1 == null) goto L10;
        r14.a(r1, null);
    L10:
        r19.d().o(r17, r13, new e(this, r17, r13, r19, r14));
        goto L4
    L11:
        y50.c.d.a("beauty_multi_load_effects");
    }

    public final void c(String r2, LiveEffectContextFactoryDelegate$Type r3, WeakReference<com.bytedance.android.live.effect.beauty.smallitem.b> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "type");
        List<String> r0 = LiveEffectContext.h;
        com.bytedance.android.live.effect.api.j r6 = LiveEffectContext.a.a(r3).b();
        if (r5 == true) goto L12;
        List<EffectCategoryModel> r7 = (List) ((LinkedHashMap) this.a).get(r2);
        if (r7 == null) goto L12;
        if (r4 == null) goto L10;
        com.bytedance.android.live.effect.beauty.smallitem.b r8 = r4.get();
        if (r8 == null) goto L10;
        r8.onSuccess(r7);
    L10:
        b(r2, r7, r6, null);
        return;
    L12:
        r6.d().f(r2, new c(this, r2, r6, r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(d r0, String r1, LiveEffectContextFactoryDelegate$Type r2, WeakReference r3, int r4) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.c(r1, r2, r3, false);
    }
}
