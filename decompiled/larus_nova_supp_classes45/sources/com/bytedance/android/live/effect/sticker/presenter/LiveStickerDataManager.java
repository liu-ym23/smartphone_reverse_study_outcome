package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.EffectManager;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.ICheckChannelListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchCategoryInfoListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchEffectChannelListener;
import com.ss.android.ugc.effectmanager.effect.listener.IFetchPanelInfoListener;
import com.ss.android.ugc.effectmanager.effect.model.CategoryEffectModel;
import com.ss.android.ugc.effectmanager.effect.model.CategoryInfoModelList;
import com.ss.android.ugc.effectmanager.effect.model.CategoryPageModel;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryModel;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import com.ss.android.ugc.effectmanager.effect.model.PanelInfoModel;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveStickerDataManager implements o {
    public static final /* synthetic */ int m = 0;
    public final Map<String, EffectChannelResponse> a;
    public final Map<String, Integer> b;
    public final Map<String, EffectChannelResponse> c;
    public final Map<String, PanelInfoModel> d;
    public final Map<String, CopyOnWriteArrayList<o.d>> e;
    public final Map<String, Map<String, CategoryInfoModelList>> f;
    public final Map<String, Map<String, CategoryPageModel>> g;
    public final Map<String, List<Effect>> h;
    public final Map<String, Long> i;
    public final List<Long> j;
    public final Lazy k;
    public final LiveEffectContextFactoryDelegate$Type l;

    public static final class a {
    }

    public static final class b implements ICheckChannelListener {
        public final /* synthetic */ LiveStickerDataManager a;
        public final /* synthetic */ AtomicBoolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ c d;

        public final void checkChannelFailed(ExceptionResult r5) {
            this.a.q(this.b, this.c, this.d, true);
        }

        public final void checkChannelSuccess(boolean r5) {
            this.a.q(this.b, this.c, this.d, r5);
        }

        public b(LiveStickerDataManager r1, AtomicBoolean r2, String r3, c r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class c implements IFetchEffectChannelListener {
        public final /* synthetic */ LiveStickerDataManager a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ AtomicBoolean e;
        public final /* synthetic */ long f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ LiveStickerDataManager$fetchAllSticker$1 h;
        public final /* synthetic */ com.bytedance.android.live.effect.api.k.i i;

        public final void onFail(ExceptionResult r3) {
            String r0 = this.b;
            if (r3 == null) goto L5;
            int r1 = r3.getErrorCode();
        L6:
            if (r3 == null) goto L9;
            String r4 = r3.getMsg();
            if (r4 == null) goto L9;
        L10:
            LiveEffectMonitor.d(r0, r1, r4);
            com.bytedance.android.live.effect.api.k.i r5 = this.i;
            if (r5 == null) goto L14;
            r5.b();
            return;
        L14:
            return;
        L9:
            r4 = "";
            goto L10
        L5:
            r1 = -1;
            goto L6
        }

        public final void onSuccess(Object r7) {
            EffectChannelResponse r8 = (EffectChannelResponse) r7;
            if (r8 != null) goto L5;
        L28:
            LiveEffectMonitor.d(this.b, 1000, "Empty effect list");
            return;
        L5:
            if (r8.getCategoryResponseList().isEmpty() == false) goto L10;
            if (r8.getAllCategoryEffects().isEmpty() == true) goto L28;
        L10:
            if (this.c == true) goto L12;
        L17:
            this.a.a.put(this.b, r8);
            if (this.e.get() == false) goto L21;
            String r0 = this.b;
            long r1 = System.currentTimeMillis() - this.f;
            PthreadHandlerThreadV2 r3 = LiveEffectMonitor.a;
            Intrinsics.checkNotNullParameter(r0, "panel");
            NewBroadcastMonitor.a r4 = NewBroadcastMonitor.c(NewBroadcastMonitor.SERVICE.SERVICE_FETCH_EFFECT_LIST, null, null, 14);
            r4.l(0);
            r4.c(r0);
            r4.g("duration", r1);
            r4.a().report();
        L21:
            if (this.g == false) goto L23;
            Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r2 = com.bytedance.android.live.effect.api.u.a;
            com.bytedance.android.live.effect.api.u.c(this.a.getType()).d(this.b, r8.getAllCategoryEffects(), new LiveStickerDataManager$fetchAllSticker$fetchEffectChannelListener$1$onSuccess$1(this.a));
        L23:
            LiveStickerDataManager$fetchAllSticker$1 r5 = this.h;
            if (this.e.get() == false) goto L26;
            EffectDataFetchCacheType r6 = EffectDataFetchCacheType.NoCache;
        L27:
            r5.invoke(r8, r6);
            return;
        L26:
            r6 = EffectDataFetchCacheType.HitEPCache;
            goto L27
        L12:
            if (this.d == false) goto L14;
            this.a.c.put(this.b, r8);
            LiveStickerDataManager r9 = this.a;
            Map<String, Integer> r11 = r9.b;
            String r12 = this.b;
            r11.put(r12, Integer.valueOf(r9.j(r12, "")));
        L14:
            r8.setAllCategoryEffects(this.a.s(this.b, r8));
            if (r8.getAllCategoryEffects().isEmpty() == false) goto L17;
            LiveEffectMonitor.d(this.b, 1000, "Empty effect list after filter");
        }

        public c(LiveStickerDataManager r1, String r2, boolean r3, boolean r4, AtomicBoolean r5, long r6, boolean r8, LiveStickerDataManager$fetchAllSticker$1 r9, com.bytedance.android.live.effect.api.k.i r11) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r8;
            this.h = r9;
            this.i = r11;
        }
    }

    public static final class d implements IFetchCategoryInfoListener {
        public final /* synthetic */ LiveStickerDataManager a;
        public final /* synthetic */ com.bytedance.android.live.effect.api.k.c b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public final void onFail(ExceptionResult r3) {
            com.bytedance.android.live.effect.api.k.c r0 = this.b;
            if (r0 == null) goto L5;
            r0.onFetchFailed();
        L5:
            String r1 = this.c;
            if (r3 == null) goto L8;
            int r2 = r3.getErrorCode();
        L9:
            if (r3 == null) goto L11;
            String r4 = r3.getMsg();
        L12:
            LiveEffectMonitor.e(r1, r2, r4);
            return;
        L11:
            r4 = null;
            goto L12
        L8:
            r2 = -1;
            goto L9
        }

        public final void onSuccess(Object r4) {
            CategoryInfoModelList r5 = (CategoryInfoModelList) r4;
            if (r5 == null) goto L22;
            List r0 = r5.getCategoryList();
            if (r0 != null) goto L7;
        L10:
            boolean r1 = true;
        L11:
            if (r1 == true) goto L22;
            Map<String, Map<String, CategoryInfoModelList>> r2 = this.a.f;
            LinkedHashMap r3 = (LinkedHashMap) r2;
            if (r3.get(this.c) != null) goto L16;
            this.a.f.put(this.c, new LinkedHashMap());
        L16:
            Map<String, Map<String, CategoryInfoModelList>> r6 = this.a.f;
            LinkedHashMap r7 = (LinkedHashMap) r6;
            Map r8 = (Map) r7.get(this.c);
            if (r8 == null) goto L19;
            CategoryInfoModelList r9 = (CategoryInfoModelList) r8.put(this.d, r5);
        L19:
            com.bytedance.android.live.effect.api.k.c r11 = this.b;
            if (r11 == null) goto L26;
            r11.a(r5, EffectDataFetchCacheType.NoCache);
            return;
        L26:
            return;
        L7:
            if (r0.isEmpty() == true) goto L10;
            r1 = false;
        L22:
            com.bytedance.android.live.effect.api.k.c r12 = this.b;
            if (r12 == null) goto L28;
            r12.onFetchFailed();
            return;
        }

        public d(LiveStickerDataManager r1, com.bytedance.android.live.effect.api.k.c r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class e implements IFetchEffectChannelListener {
        public final /* synthetic */ LiveStickerDataManager a;
        public final /* synthetic */ IFetchEffectChannelListener b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ String d;

        public final void onFail(ExceptionResult r5) {
            this.a.q(this.c, this.d, this.b, true);
        }

        public final void onSuccess(Object r2) {
            IFetchEffectChannelListener r0 = this.b;
            r0.onSuccess((EffectChannelResponse) r2);
        }

        public e(LiveStickerDataManager r1, IFetchEffectChannelListener r2, AtomicBoolean r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class f implements o.b {
        public final /* synthetic */ o.b a;

        public f(o.b r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.o.b
        public final void a(boolean r2) {
            this.a.a(r2);
        }
    }

    public static final class g implements ICheckChannelListener {
        public final /* synthetic */ LiveStickerDataManager a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ AtomicBoolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ String f;
        public final /* synthetic */ int g;
        public final /* synthetic */ int h;
        public final /* synthetic */ h i;

        public final void checkChannelFailed(ExceptionResult r8) {
            this.c.set(false);
            this.a.t().fetchPanelInfo(this.d, this.e, this.f, this.g, this.h, this.i);
        }

        public final void checkChannelSuccess(boolean r11) {
            if (r11 == false) goto L4;
        L7:
            this.c.set(false);
            if (this.b == false) goto L10;
            this.a.t().fetchPanelInfo(this.d, this.e, this.f, this.g, this.h, true, null, this.i);
            return;
        L10:
            this.a.t().fetchPanelInfo(this.d, this.e, this.f, this.g, this.h, this.i);
            return;
        L4:
            if (this.b == true) goto L7;
            this.c.set(true);
            this.a.t().fetchPanelInfoFromCache(this.d, this.e, this.f, this.g, this.h, this.i);
        }

        public g(LiveStickerDataManager r1, boolean r2, AtomicBoolean r3, String r4, boolean r5, String r6, int r7, int r8, h r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }
    }

    public static final class h implements IFetchPanelInfoListener {
        public final /* synthetic */ LiveStickerDataManager a;
        public final /* synthetic */ com.bytedance.android.live.effect.api.k.d b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AtomicBoolean d;

        public final void onFail(ExceptionResult r3) {
            com.bytedance.android.live.effect.api.k.d r0 = this.b;
            if (r0 == null) goto L5;
            r0.onFetchFailed();
        L5:
            String r1 = this.c;
            if (r3 == null) goto L8;
            int r2 = r3.getErrorCode();
        L9:
            if (r3 == null) goto L11;
            String r4 = r3.getMsg();
        L12:
            LiveEffectMonitor.e(r1, r2, r4);
            return;
        L11:
            r4 = null;
            goto L12
        L8:
            r2 = -1;
            goto L9
        }

        public final void onSuccess(Object r3) {
            PanelInfoModel r4 = (PanelInfoModel) r3;
            if (r4 != null) goto L5;
        L25:
            com.bytedance.android.live.effect.api.k.d r5 = this.b;
            if (r5 == null) goto L28;
            r5.onFetchFailed();
        L28:
            LiveEffectMonitor.e(this.c, 1000, "fetchPanelInfo empty result");
            return;
        L5:
            if (r4.getCategoryList().isEmpty() == true) goto L25;
            this.a.d.put(this.c, r4);
            com.bytedance.android.live.effect.api.k.d r0 = this.b;
            if (r0 == null) goto L15;
            if (this.d.get() == false) goto L12;
            EffectDataFetchCacheType r1 = EffectDataFetchCacheType.HitEPCache;
        L13:
            r0.a(r4, r1);
            goto L15
        L12:
            r1 = EffectDataFetchCacheType.NoCache;
        L15:
            if (LiveEffectSettings.LIVE_EFFECT_ENABLE_PERMEATE_STICKER_STRATEGY_UPGRADE.getValue().booleanValue() == false) goto L24;
            Map<String, CopyOnWriteArrayList<o.d>> r2 = this.a.e;
            LinkedHashMap r6 = (LinkedHashMap) r2;
            List r7 = (CopyOnWriteArrayList) r6.get(this.c);
            if (r7 != null) goto L20;
            r7 = CollectionsKt.emptyList();
        L20:
            Iterator r8 = r7.iterator();
        L22:
            if (r8.hasNext() == false) goto L24;
            ((o.d) r8.next()).a(r4);
        L24:
            LiveEffectMonitor.f(this.c, r4.getCategoryList());
        }

        public h(LiveStickerDataManager r1, com.bytedance.android.live.effect.api.k.d r2, String r3, AtomicBoolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public final EffectManager t() {
        return (EffectManager) this.k.getValue();
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.l;
    }

    public LiveStickerDataManager(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.l = r2;
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
        this.j = new ArrayList();
        this.k = LazyKt.lazy(new LiveStickerDataManager$effectManager$2(this));
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final boolean b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        List r3 = (List) ((LinkedHashMap) this.h).get(r2);
        if (r3 != null) goto L5;
    L7:
        return false;
    L5:
        if ((!r3.isEmpty()) != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final List<Effect> c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        List<Effect> r3 = (List) ((LinkedHashMap) this.h).get(r2);
        if (r3 == null) goto L5;
        return r3;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final int m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        if (Intrinsics.areEqual(r2, com.bytedance.android.live.effect.api.d0.i) == true) goto L36;
        if (Intrinsics.areEqual(r2, FileUtils.BEAUTY) == true) goto L36;
        if (Intrinsics.areEqual(r2, "livebody") == false) goto L11;
        return LiveEffectSettings.LIVE_BODY_BEAUTY_AB_GROUP.getValue().intValue();
    L11:
        if (Intrinsics.areEqual(r2, com.bytedance.android.live.effect.api.d0.k) == false) goto L14;
        return LiveEffectSettings.LIVE_MAKEUP_AB_GROUP.getValue().intValue();
    L14:
        if (Intrinsics.areEqual(r2, com.bytedance.android.live.effect.api.d0.a) == true) goto L45;
        if (Intrinsics.areEqual(r2, com.bytedance.android.live.effect.api.d0.l) == true) goto L45;
        if (Intrinsics.areEqual(r2, "style") == false) goto L22;
        return LiveEffectSettings.LIVE_ANCHOR_BEAUTY_TEMPLATE_AB_GROUP.getValue().intValue();
    L22:
        if (Intrinsics.areEqual(r2, "inspiration_beautification") == false) goto L25;
        return LiveEffectSettings.LIVE_ANCHOR_ONE_TAP_BEAUTY_AB_GROUP.getValue().intValue();
    L25:
        if (Intrinsics.areEqual(r2, "beautyclassify") == false) goto L28;
        return LiveEffectSettings.LIVE_ANCHOR_CLASSIFY_BEAUTY_AB_GROUP.getValue().intValue();
    L28:
        if (Intrinsics.areEqual(r2, "live_adjustment") == false) goto L31;
        return LiveEffectSettings.LIVE_ANCHOR_AV_ADJUST_COLOR_AB_GROUP.getValue().intValue();
    L31:
        if (Intrinsics.areEqual(r2, "live_camera_move") == true) goto L43;
        return 0;
    L43:
        return LiveEffectSettings.LIVE_ANCHOR_CAMERA_MOVEMENT_AB_GROUP.getValue().intValue();
    L45:
        return LiveEffectSettings.LIVE_FILTER_AB_GROUP.getValue().intValue();
    L36:
        return LiveEffectSettings.LIVE_SMALL_BEAUTY_AB_GROUP.getValue().intValue();
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void f(String r11, com.bytedance.android.live.effect.api.k.d r12) {
        Intrinsics.checkNotNullParameter(r11, "panel");
        Intrinsics.checkNotNullParameter("", "category");
        this.d.containsKey(r11);
        b0 r8 = new b0(this, r12, r11);
        t().fetchPanelInfo(r11, false, "", 0, 0, true, null, r8);
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final EffectCategoryModel i(String r6, PanelInfoModel r7) {
        Intrinsics.checkNotNullParameter(r6, "panel");
        Intrinsics.checkNotNullParameter(r7, "panelInfo");
        int r8 = j(r6, "");
        Iterator r9 = r7.getCategoryList().iterator();
    L3:
        Integer r2 = null;
        if (r9.hasNext() == false) goto L21;
        EffectCategoryModel r1 = (EffectCategoryModel) r9.next();
        String r3 = r1.getExtra();
        if (r3 == null) goto L3;
        JsonElement r4 = GsonProtectorUtils.parse(new JsonParser(), r3).getAsJsonObject().get("ab_group");     // Catch: ClassCastException -> L15 IllegalStateException -> L17 JsonParseException -> L19
    L8:
        if (r4 == null) goto L10;
        r2 = Integer.valueOf(r4.getAsInt());     // Catch: ClassCastException -> L15 IllegalStateException -> L17 JsonParseException -> L19
    L10:
        if (r2 == null) goto L3;
        if (r2.intValue() != r8) goto L3;
        return r1;
    L15:
        e = move-exception;
        ALogger.e("LiveStickerDataManager", e);
    L17:
        e = move-exception;
        ALogger.e("LiveStickerDataManager", e);
    L19:
        e = move-exception;
        ALogger.e("LiveStickerDataManager", e);
        goto L3
    L21:
        return null;
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final int j(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "panel");
        Intrinsics.checkNotNullParameter(r5, "forceModeKey");
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r0 = com.bytedance.android.live.effect.api.u.a;
        if (com.bytedance.android.live.effect.api.u.b(this.l).e().c() == false) goto L54;
        boolean r1 = false;
        if (Intrinsics.areEqual(r4, com.bytedance.android.live.effect.api.d0.i) == false) goto L7;
    L37:
        Integer r2 = LiveEffectSettings.LIVE_SMALL_BEAUTY_AB_GROUP.getValue();
    L39:
        if (r5.length() <= 0) goto L41;
        r1 = true;
    L41:
        if (r1 == true) goto L44;
        r5 = (String) m90.b.F.c(LiveEffectContextFactoryDelegate$Type.DEFAULT).first;
    L44:
        BeautyModeInfo r6 = com.bytedance.android.live.effect.api.u.b(this.l).e().j(r5);
        if (r6 == null) goto L52;
        Map r7 = (Map) r6.a.getValue();
        if (r7 == null) goto L52;
        Integer r8 = (Integer) r7.get(r4);
        if (r8 == null) goto L52;
        return r8.intValue();
    L52:
        return r2.intValue();
    L7:
        if (Intrinsics.areEqual(r4, FileUtils.BEAUTY) == true) goto L37;
        if (Intrinsics.areEqual(r4, "livebody") == false) goto L13;
        r2 = LiveEffectSettings.LIVE_BODY_BEAUTY_AB_GROUP.getValue();
        goto L39
    L13:
        if (Intrinsics.areEqual(r4, com.bytedance.android.live.effect.api.d0.k) == false) goto L16;
        r2 = LiveEffectSettings.LIVE_MAKEUP_AB_GROUP.getValue();
        goto L39
    L16:
        if (Intrinsics.areEqual(r4, com.bytedance.android.live.effect.api.d0.a) == false) goto L18;
    L36:
        r2 = LiveEffectSettings.LIVE_FILTER_AB_GROUP.getValue();
        goto L39
    L18:
        if (Intrinsics.areEqual(r4, com.bytedance.android.live.effect.api.d0.l) == true) goto L36;
        if (Intrinsics.areEqual(r4, "style") == false) goto L24;
        r2 = LiveEffectSettings.LIVE_ANCHOR_BEAUTY_TEMPLATE_AB_GROUP.getValue();
        goto L39
    L24:
        if (Intrinsics.areEqual(r4, "inspiration_beautification") == false) goto L27;
        r2 = LiveEffectSettings.LIVE_ANCHOR_ONE_TAP_BEAUTY_AB_GROUP.getValue();
        goto L39
    L27:
        if (Intrinsics.areEqual(r4, "beautyclassify") == false) goto L30;
        r2 = LiveEffectSettings.LIVE_ANCHOR_CLASSIFY_BEAUTY_AB_GROUP.getValue();
        goto L39
    L30:
        if (Intrinsics.areEqual(r4, "live_adjustment") == false) goto L33;
        r2 = LiveEffectSettings.LIVE_ANCHOR_AV_ADJUST_COLOR_AB_GROUP.getValue();
        goto L39
    L33:
        if (Intrinsics.areEqual(r4, "live_camera_move") == false) goto L35;
        r2 = LiveEffectSettings.LIVE_ANCHOR_CAMERA_MOVEMENT_AB_GROUP.getValue();
        goto L39
    L35:
        r2 = 0;
        goto L39
    L54:
        return m(r4);
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void l(String r3, List<? extends Effect> r4) {
        Intrinsics.checkNotNullParameter(r3, "panel");
        Intrinsics.checkNotNullParameter(r4, "allSticker");
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r0 = com.bytedance.android.live.effect.api.u.a;
        com.bytedance.android.live.effect.api.u.c(this.l).d(r3, r4, new LiveStickerDataManager$restoreSaveNode$1(this));
    }

    public final List<Effect> s(String r8, EffectChannelResponse r9) {
        Intrinsics.checkNotNullParameter(r8, "panel");
        Intrinsics.checkNotNullParameter(r9, "response");
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        if (r9.getCategoryResponseList().isEmpty() == true) goto L5;
        Iterator r11 = r9.getCategoryResponseList().iterator();
    L7:
        int r4 = 0;
        if (r11.hasNext() == false) goto L30;
        EffectCategoryResponse r3 = (EffectCategoryResponse) r11.next();
        String r5 = r3.getExtra();
        if (r5 != null) goto L34;
    L21:
        if (r4 != 0) goto L26;
        if (r2.isEmpty() == false) goto L26;
        r2.addAll(r3.getTotalEffects());
    L26:
        if (r4 != j(r8, "")) goto L7;
        if (r1.isEmpty() == false) goto L7;
        r1.addAll(r3.getTotalEffects());
        r4 = 1;
        goto L30
    L34:
        JsonElement r6 = GsonProtectorUtils.parse(new JsonParser(), r5).getAsJsonObject().get("ab_group");     // Catch: ClassCastException -> L15 IllegalStateException -> L17 JsonParseException -> L19
        if (r6 == null) goto L21;
        r4 = r6.getAsInt();     // Catch: ClassCastException -> L15 IllegalStateException -> L17 JsonParseException -> L19
    L19:
        e = move-exception;
        ALogger.e("LiveStickerDataManager", e);
    L15:
        e = move-exception;
        ALogger.e("LiveStickerDataManager", e);
    L17:
        e = move-exception;
        ALogger.e("LiveStickerDataManager", e);
    L30:
        if (r4 == 0) goto L33;
        return r1;
    L33:
        return r2;
    L5:
        return r9.getAllCategoryEffects();
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void d(String r5, String r6, Sticker r7) {
        Intrinsics.checkNotNullParameter(r5, "panel");
        Intrinsics.checkNotNullParameter(r6, "category");
        Intrinsics.checkNotNullParameter(r7, "sticker");
        if (r7.getEffect() != null) goto L5;
        return;
    L5:
        Map r0 = (Map) ((LinkedHashMap) this.g).get(r5);
        if (r0 == null) goto L15;
        CategoryPageModel r1 = (CategoryPageModel) r0.get(r6);
        if (r1 == null) goto L15;
        CategoryEffectModel r2 = r1.getCategoryEffects();
        if (r2 == null) goto L15;
        List r3 = r2.getEffects();
        if (r3 == null) goto L15;
        List r4 = CollectionsKt.toMutableList(r3);
        if (r4 == null) goto L15;
    L16:
        List r8 = r4;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r11 = r8.iterator();
    L18:
        if (r11.hasNext() == false) goto L20;
        r9.add(((Effect) r11.next()).getEffect_id());
        goto L18
    L20:
        Effect r12 = r7.getEffect();
        if (r12 == null) goto L23;
        String r13 = r12.getEffect_id();
    L25:
        if (CollectionsKt.contains(r9, r13) == false) goto L27;
        return;
    L27:
        Effect r14 = r7.getEffect();
        Intrinsics.checkNotNull(r14);
        ListProtector.add(r4, 0, r14);
        Map r15 = (Map) ((LinkedHashMap) this.g).get(r5);
        if (r15 == null) goto L36;
        CategoryPageModel r16 = (CategoryPageModel) r15.get(r6);
        if (r16 == null) goto L37;
        CategoryEffectModel r17 = r16.getCategoryEffects();
        if (r17 == null) goto L38;
        r17.setEffects(r4);
        return;
    L38:
        return;
    L37:
        return;
    L36:
        return;
    L23:
        r13 = null;
    L15:
        r4 = new ArrayList();
        goto L16
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void g(Sticker r3, boolean r4, o.b r5) {
        Intrinsics.checkNotNullParameter(r3, "sticker");
        Intrinsics.checkNotNullParameter(r5, "listener");
        Effect r6 = r3.getEffect();
        f r1 = new f(r5);
        Intrinsics.checkNotNullParameter(r1, "listener");
        if (r6 != null) goto L5;
        r1.a(false);
        return;
    L5:
        Observable r7 = Observable.create(new i0(this, r6)).subscribeOn(Schedulers.io());
        if (r4 == false) goto L8;
        Scheduler r8 = AndroidSchedulers.mainThread();
    L9:
        r7.observeOn(r8).subscribe(new j0(r1));
        return;
    L8:
        r8 = Schedulers.io();
        goto L9
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void h(String r2, Sticker r3, com.bytedance.android.live.effect.sticker.chain.b.C0190b r4) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "sticker");
        g(r3, false, new a0(this, r4, r3, r2));
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void o(String r17, String r18, com.bytedance.android.live.effect.api.k.b r19) {
        Intrinsics.checkNotNullParameter(r17, "panel");
        Intrinsics.checkNotNullParameter(r18, "category");
        e0 r2 = new e0(r19);
        Intrinsics.checkNotNullParameter(r17, "panel");
        Intrinsics.checkNotNullParameter(r18, "category");
        Intrinsics.checkNotNullParameter("0", "version");
        LiveStickerDataManager$fetchManagerEffectByCategory$1 r5 = new LiveStickerDataManager$fetchManagerEffectByCategory$1(r2);
        LiveStickerDataManager$fetchManagerEffectByCategory$2 r0 = LiveStickerDataManager$fetchManagerEffectByCategory$2.INSTANCE;
        Map r1 = (Map) ((LinkedHashMap) this.g).get(r17);
        if (r1 == null) goto L9;
        CategoryPageModel r3 = (CategoryPageModel) r1.get(r18);
        if (r3 == null) goto L9;
        CategoryEffectModel r4 = r3.getCategoryEffects();
        if (r4 == null) goto L9;
        List<? extends Effect> r6 = r4.getEffects();
    L10:
        if (r6 == null) goto L12;
        r5.invoke(r6, EffectDataFetchCacheType.HitLiveCache);
        return;
    L12:
        long r7 = System.currentTimeMillis();
        AtomicBoolean r14 = new AtomicBoolean(false);
        d0 r15 = new d0(this, r2, r17, r18, r5, r14, r7);
        if (NetworkUtils.isNetworkAvailable(s1.getContext()) == false) goto L15;
        t().checkCategoryIsUpdate(r17, r18, new c0(this, r14, r17, r18, r15));
        return;
    L15:
        r14.set(true);
        t().fetchCategoryEffectFromCache(r17, r18, 0, 0, 0, "0", r15);
        return;
    L9:
        r6 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void k(String r2, String r3, int r4, com.bytedance.android.live.effect.api.k.a r5) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "category");
        r(r2, r3, r4, r5);
    }

    public final void q(AtomicBoolean r2, String r3, IFetchEffectChannelListener r4, boolean r5) {
        r2.set(r5);
        if (r5 == false) goto L5;
        t().fetchEffectList(r3, false, r4);
        return;
    L5:
        t().fetchEffectListFromCache(r3, new e(this, r4, r2, r3));
    }

    public final void r(String r18, String r19, int r21, com.bytedance.android.live.effect.api.k.a r22) {
        Intrinsics.checkNotNullParameter(r18, "panel");
        Intrinsics.checkNotNullParameter(r19, "category");
        Intrinsics.checkNotNullParameter("0", "version");
        LiveStickerDataManager$fetchStickerByCategory$1 r5 = new LiveStickerDataManager$fetchStickerByCategory$1(r22);
        Map r0 = (Map) ((LinkedHashMap) this.g).get(r18);
        if (r0 == null) goto L9;
        CategoryPageModel r1 = (CategoryPageModel) r0.get(r19);
        if (r1 == null) goto L9;
        CategoryEffectModel r2 = r1.getCategoryEffects();
        if (r2 == null) goto L9;
        List<? extends Effect> r3 = r2.getEffects();
    L10:
        if (r3 == null) goto L13;
        r5.invoke(r3, EffectDataFetchCacheType.HitLiveCache);
        return;
    L13:
        long r7 = System.currentTimeMillis();
        AtomicBoolean r15 = new AtomicBoolean(false);
        h0 r16 = new h0(this, r22, r18, r19, r5, r15, r7);
        if (NetworkUtils.isNetworkAvailable(s1.getContext()) == false) goto L16;
        t().checkCategoryIsUpdate(r18, r19, new g0(this, r15, r18, r19, r21, r16));
        return;
    L16:
        r15.set(true);
        t().fetchCategoryEffectFromCache(r18, r19, r21, 0, 0, "0", r16);
        return;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void p(String r3, String r4, List<Integer> r5, boolean r6, com.bytedance.android.live.effect.api.k.c r7) {
        Intrinsics.checkNotNullParameter(r3, "panel");
        Intrinsics.checkNotNullParameter(r4, "categoryKey");
        Intrinsics.checkNotNullParameter(r5, "categoryIds");
        if (this.f.containsKey(r3) == false) goto L15;
        Map r0 = (Map) ((LinkedHashMap) this.f).get(r3);
        if (r0 == null) goto L15;
        if (r0.containsKey(r4) != true) goto L15;
        if (r6 == true) goto L15;
        Map r8 = (Map) ((LinkedHashMap) this.f).get(r3);
        if (r8 == null) goto L17;
        CategoryInfoModelList r9 = (CategoryInfoModelList) r8.get(r4);
        if (r9 == null) goto L18;
        r7.a(r9, EffectDataFetchCacheType.HitLiveCache);
        return;
    L18:
        return;
    L17:
        return;
    L15:
        d r11 = new d(this, r7, r3, r4);
        t().fetchCategoryInfo(r3, r5, null, r11);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.live.effect.sticker.presenter.LiveStickerDataManager$fetchAllSticker$2] */
    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void a(final String r16, com.bytedance.android.live.effect.api.k.i r17, final boolean r18, boolean r19, boolean r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r16, "panel");
        final LiveStickerDataManager$fetchAllSticker$1 r9 = new LiveStickerDataManager$fetchAllSticker$1(r17);
        ?? r0 = new LiveStickerDataManager$fetchAllSticker$2(this, r16, r18, r9);
        if (r22 == false) goto L24;
        if (r21 == true) goto L24;
        if (this.a.containsKey(r16) == false) goto L28;
        int r1 = j(r16, "");
        Integer r2 = (Integer) ((LinkedHashMap) this.b).get(r16);
        if (r2 == null) goto L15;
        if (r2.intValue() != r1) goto L15;
        r0.m753invoke();
        return;
    L15:
        if (this.c.containsKey(r16) == false) goto L28;
        EffectChannelResponse r3 = (EffectChannelResponse) ((LinkedHashMap) this.c).get(r16);
        if (r3 == null) goto L21;
        EffectChannelResponse r4 = (EffectChannelResponse) ((LinkedHashMap) this.a).get(r16);
        if (r4 == null) goto L21;
        r4.setAllCategoryEffects(s(r16, r3));
    L21:
        this.b.put(r16, Integer.valueOf(r1));
        r0.m753invoke();
        return;
    L28:
        long r6 = System.currentTimeMillis();
        AtomicBoolean r13 = new AtomicBoolean();
        c r14 = new c(this, r16, r19, r22, r13, r6, r18, r9, r17);
        if (NetworkUtils.isNetworkAvailable(s1.getContext()) == false) goto L33;
        if (r21 == false) goto L32;
        q(r13, r16, r14, true);
        return;
    L32:
        t().checkedEffectListUpdate(r16, new b(this, r13, r16, r14));
        return;
    L33:
        q(r13, r16, r14, false);
        return;
    L24:
        if (this.a.containsKey(r16) == false) goto L28;
        if (r21 == true) goto L28;
        r0.m753invoke();
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void e(String r11, String r12, int r13, int r14, String r15, Map r16, com.bytedance.android.live.effect.api.k.e r17) {
        Intrinsics.checkNotNullParameter(r11, "panel");
        Intrinsics.checkNotNullParameter(r12, "categoryKey");
        Intrinsics.checkNotNullParameter(r15, "version");
        LiveStickerDataManager$fetchRewardEffectList$1 r2 = new LiveStickerDataManager$fetchRewardEffectList$1(r17);
        t().fetchCategoryEffect(r11, r12, 200, r13, r14, r15, r16, new f0(this, r11, r17, r2));
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.o
    public final void n(String r15, boolean r16, String r17, int r18, int r19, boolean r21, com.bytedance.android.live.effect.api.k.d r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r15, "panel");
        Intrinsics.checkNotNullParameter(r17, "category");
        if (this.d.containsKey(r15) == false) goto L20;
        if (r21 == true) goto L20;
        PanelInfoModel r1 = (PanelInfoModel) ((LinkedHashMap) this.d).get(r15);
        if (r1 == null) goto L19;
        if (r22 == null) goto L10;
        r22.a(r1, EffectDataFetchCacheType.HitLiveCache);
    L10:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_PERMEATE_STICKER_STRATEGY_UPGRADE.getValue().booleanValue() == false) goto L28;
        List r0 = (CopyOnWriteArrayList) ((LinkedHashMap) this.e).get(r15);
        if (r0 != null) goto L15;
        r0 = CollectionsKt.emptyList();
    L15:
        Iterator r2 = r0.iterator();
    L17:
        if (r2.hasNext() == false) goto L29;
        ((o.d) r2.next()).a(r1);
        goto L17
    L29:
        return;
    L28:
        return;
    L19:
        return;
    L20:
        AtomicBoolean r3 = new AtomicBoolean(false);
        h r9 = new h(this, r22, r15, r3);
        if (NetworkUtils.isNetworkAvailable(s1.getContext()) == false) goto L25;
        if (r21 == false) goto L24;
        r3.set(false);
        t().fetchPanelInfo(r15, r16, r17, r18, r19, r9);
        return;
    L24:
        t().checkPanelIsUpdate(r15, new g(this, r23, r3, r15, r16, r17, r18, r19, r9));
        return;
    L25:
        r3.set(true);
        t().fetchPanelInfoFromCache(r15, r16, r17, r18, r19, r9);
    }
}
