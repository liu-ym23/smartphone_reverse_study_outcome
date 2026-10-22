package com.bytedance.android.live.effect.utils;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveAnchorBeautifyLogHelper implements ILiveEffectComposerManager.e, ILiveEffectComposerManager.c {
    public final HashMap<String, Disposable> a;
    public final HashMap<String, Disposable> b;
    public final HashMap<String, Disposable> c;
    public final HashMap<String, Long> d;
    public final HashMap<String, HashMap<String, Float>> e;
    public final HashMap<String, Sticker> f;
    public final HashMap<String, HashMap<String, String>> g;
    public final Lazy h;
    public final String i;
    public final String j;
    public final LiveEffectContextFactoryDelegate$Type k;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R#\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/effect/utils/LiveAnchorBeautifyLogHelper$Companion$AnchorBeautifyLogEventType;", "", "", "", "keyMap", "Ljava/util/Map;", "getKeyMap", "()Ljava/util/Map;", "SELECT", "EFFECTIVE_USE", "USE_TIME", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum AnchorBeautifyLogEventType extends Enum<AnchorBeautifyLogEventType> {
            public static final AnchorBeautifyLogEventType EFFECTIVE_USE = null;
            public static final AnchorBeautifyLogEventType SELECT = null;
            public static final AnchorBeautifyLogEventType USE_TIME = null;
            public static final /* synthetic */ AnchorBeautifyLogEventType[] a = null;
            private final Map<String, String> keyMap;

            static {
                String r5 = d0.i;
                String r6 = d0.a;
                String r11 = d0.k;
                AnchorBeautifyLogEventType r2 = new AnchorBeautifyLogEventType("SELECT", 0, MapsKt.mapOf(new Pair[]{TuplesKt.to(r5, "livesdk_beauty_select"), TuplesKt.to("livebody", "livesdk_anchor_beautybody_select"), TuplesKt.to(r6, "livesdk_filter_select"), TuplesKt.to(r11, "livesdk_makeup_select"), TuplesKt.to("live_adjustment", "livesdk_beauty_panel_item_select"), TuplesKt.to("live_camera_move", "livesdk_camera_movement_effect_click")}));
                SELECT = r2;
                AnchorBeautifyLogEventType r3 = new AnchorBeautifyLogEventType("EFFECTIVE_USE", 1, MapsKt.mapOf(new Pair[]{TuplesKt.to(r5, "livesdk_live_take_beauty_effective_use"), TuplesKt.to("livebody", "livesdk_anchor_beautybody_select_effective_use"), TuplesKt.to(r6, "livesdk_live_take_filter_effective_use"), TuplesKt.to(r11, "livesdk_makeup_effective_use"), TuplesKt.to("live_camera_move", "livesdk_camera_movement_effect_effective_use"), TuplesKt.to("live_adjustment", "livesdk_beauty_panel_item_effective_use")}));
                EFFECTIVE_USE = r3;
                AnchorBeautifyLogEventType r4 = new AnchorBeautifyLogEventType("USE_TIME", 2, MapsKt.mapOf(new Pair[]{TuplesKt.to(r5, "livesdk_beauty_use_time"), TuplesKt.to("livebody", "livesdk_beautybody_use_time"), TuplesKt.to(r6, "livesdk_filter_use_time"), TuplesKt.to(r11, "livesdk_makeup_use_time"), TuplesKt.to("live_camera_move", "livesdk_camera_movement_effect_use_time"), TuplesKt.to("live_adjustment", "livesdk_beauty_panel_item_use_time")}));
                USE_TIME = r4;
                a = new AnchorBeautifyLogEventType[]{r2, r3, r4};
            }

            public static AnchorBeautifyLogEventType valueOf(String r1) {
                return (AnchorBeautifyLogEventType) r27.a.a(AnchorBeautifyLogEventType.class, r1);
            }

            public static AnchorBeautifyLogEventType[] values() {
                return (AnchorBeautifyLogEventType[]) a.clone();
            }

            public final Map<String, String> getKeyMap() {
                return this.keyMap;
            }

            public AnchorBeautifyLogEventType(String r1, int r2, Map r3) {
                super(r1, r2);
                this.keyMap = r3;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/utils/LiveAnchorBeautifyLogHelper$Companion$UseTimeTriggerType;", "", "ADD", "REMOVE", "CHANGE_VALUE", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum UseTimeTriggerType extends Enum<UseTimeTriggerType> {
            public static final UseTimeTriggerType ADD = null;
            public static final UseTimeTriggerType CHANGE_VALUE = null;
            public static final UseTimeTriggerType REMOVE = null;
            public static final /* synthetic */ UseTimeTriggerType[] a = null;

            static {
                UseTimeTriggerType r1 = new UseTimeTriggerType("ADD", 0);
                ADD = r1;
                UseTimeTriggerType r2 = new UseTimeTriggerType("REMOVE", 1);
                REMOVE = r2;
                UseTimeTriggerType r3 = new UseTimeTriggerType("CHANGE_VALUE", 2);
                CHANGE_VALUE = r3;
                a = new UseTimeTriggerType[]{r1, r2, r3};
            }

            public static UseTimeTriggerType valueOf(String r1) {
                return (UseTimeTriggerType) r27.a.a(UseTimeTriggerType.class, r1);
            }

            public static UseTimeTriggerType[] values() {
                return (UseTimeTriggerType[]) a.clone();
            }

            public UseTimeTriggerType(String r1, int r2) {
                super(r1, r2);
            }
        }
    }

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LiveAnchorBeautifyLogHelper a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Sticker c;
        public final /* synthetic */ HashMap d;
        public final /* synthetic */ long e;
        public final /* synthetic */ HashMap f;

        public a(LiveAnchorBeautifyLogHelper r1, String r2, Sticker r3, HashMap r4, long r5, HashMap r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r7;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            if (this.a.d.containsKey(this.b) == false) goto L6;
            this.a.n(this.b, this.c, this.d);
            this.a.d.remove(this.b);
        L6:
            if (this.a.g() == true) goto L8;
            return;
        L8:
            if (this.a.h(this.c) == false) goto L12;
            this.a.d.put(this.b, Long.valueOf(this.e));
            this.a.e.put(this.b, this.f);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveAnchorBeautifyLogHelper a;
        public final /* synthetic */ Sticker b;
        public final /* synthetic */ HashMap c;

        public b(LiveAnchorBeautifyLogHelper r1, Sticker r2, HashMap r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            LiveAnchorBeautifyLogHelper r6 = this.a;
            r6.o(Companion.AnchorBeautifyLogEventType.EFFECTIVE_USE, r6.j(this.b, this.c));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LiveAnchorBeautifyLogHelper a;
        public final /* synthetic */ Sticker b;
        public final /* synthetic */ HashMap c;

        public c(LiveAnchorBeautifyLogHelper r1, Sticker r2, HashMap r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            LiveAnchorBeautifyLogHelper r6 = this.a;
            r6.o(Companion.AnchorBeautifyLogEventType.SELECT, r6.j(this.b, this.c));
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r1, Sticker r2, String r3, float r4) {
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
    public final void a(String r1, Sticker r2) {
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
    public final void b(boolean r1, String r2, Sticker r3) {
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.e
    public final void e(String r1, Sticker r2) {
    }

    public final boolean g() {
        String r0 = this.i;
        if (Intrinsics.areEqual(r0, d0.i) == false) goto L6;
        return m90.b.a.c(this.k).booleanValue();
    L6:
        if (Intrinsics.areEqual(r0, "livebody") == false) goto L9;
        return m90.b.j.c(this.k).booleanValue();
    L9:
        if (Intrinsics.areEqual(r0, "live_adjustment") == true) goto L15;
        return true;
    L15:
        return m90.b.b.c(this.k).booleanValue();
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.k;
    }

    public final boolean h(Sticker r7) {
        List r0 = r7.getComposerConfigList();
        if (LiveEffectSettings.LIVE_SMALL_BEAUTY_ITEM_LOG_OPT.getValue().booleanValue() == false) goto L9;
        if (Intrinsics.areEqual(this.i, d0.i) == false) goto L9;
        return !r0.isEmpty();
    L9:
        if (r0.isEmpty() == false) goto L11;
        return false;
    L11:
        Iterator r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(((ILiveEffectComposerManager) this.h.getValue()).G(r7.getEffectId(), ((Sticker.ComposerConfig) r1.next()).getTag()), 0.0f) == false) goto L13;
        return false;
    L17:
        return true;
    }

    public final HashMap<String, Float> i(Sticker r7) {
        HashMap<String, Float> r0 = new HashMap();
        Iterator r1 = r7.getComposerConfigList().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Sticker.ComposerConfig r2 = (Sticker.ComposerConfig) r1.next();
        r0.put(r2.getTag(), ((ILiveEffectComposerManager) this.h.getValue()).G(r7.getEffectId(), r2.getTag()));
        goto L4
    L6:
        return r0;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.k
    public final void c(List<com.bytedance.android.live.effect.composer.n> r3, Map<String, ? extends List<Sticker>> r4) {
        Intrinsics.checkNotNullParameter(r3, "sortList");
        Intrinsics.checkNotNullParameter(r4, "allStickerList");
        Intrinsics.checkNotNullParameter(r3, "sortList");
        Intrinsics.checkNotNullParameter(r4, "allStickerList");
        Intrinsics.checkNotNullParameter(r3, "sortList");
        Intrinsics.checkNotNullParameter(r4, "allStickerList");
    }

    public final HashMap<String, String> j(Sticker r6, HashMap<String, String> r7) {
        HashMap<String, String> r0 = new HashMap();
        if (r7 != null) goto L5;
    L7:
        String r2 = "0";
    L8:
        r0.put("is_live_take_default", r2);
        String r3 = "";
        if (r7 != null) goto L11;
    L16:
        r0.put("effect_id", r6.getEffectId());
        String r8 = r6.getName();
        if (r8 == null) goto L20;
        r3 = r8;
    L20:
        r0.put("effect_name", r3);
        if (Intrinsics.areEqual(this.i, "live_adjustment") == true) goto L36;
    L34:
        f(r0, i(r6), r6);
        return r0;
    L36:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L32
        List<String> r11 = LiveEffectContext.h;     // Catch: Throwable -> L32
        Iterator r12 = ((CopyOnWriteArrayList) LiveEffectContext.a.a(this.k).b().n().b).iterator();     // Catch: Throwable -> L32
        int r1 = 0;
    L24:
        if (r12.hasNext() == false) goto L29;
        if (Intrinsics.areEqual(((Sticker) r12.next()).getEffectId(), r6.getEffectId()) == true) goto L30;
        r1 = r1 + 1;     // Catch: Throwable -> L32
    L30:
        r0.put("effect_order", String.valueOf(r1));     // Catch: Throwable -> L32
        r0.put("tab_name", "adjust");     // Catch: Throwable -> L32
        Result.constructor-impl(r0.put("live_type", "video_live"));     // Catch: Throwable -> L32
        goto L34
    L29:
        r1 = -1;
    L32:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L11:
        if (r7.containsKey("action_type") != true) goto L16;
        String r13 = r7.get("action_type");
        if (r13 != null) goto L15;
        r13 = "";
    L15:
        r0.put("action_type", r13);
        goto L16
    L5:
        if (r7.containsKey("is_restore") != true) goto L7;
        r2 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        goto L8
    }

    public final void o(Companion.AnchorBeautifyLogEventType r2, HashMap<String, String> r3) {
        String r4 = r2.getKeyMap().get(this.i);
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        if (r4.length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        com.bytedance.android.live.effect.utils.c.a(r4, r3, this.j);
        return;
    L8:
        r0 = false;
        goto L9
    }

    public LiveAnchorBeautifyLogHelper(String r2, String r3, LiveEffectContextFactoryDelegate$Type r4) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        Intrinsics.checkNotNullParameter(r3, "eventPage");
        Intrinsics.checkNotNullParameter(r4, "type");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        new CompositeDisposable();
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = LazyKt.lazy(new LiveAnchorBeautifyLogHelper$composerManager$2(this));
    }

    public final void f(HashMap<String, String> r17, HashMap<String, Float> r18, Sticker r19) {
        HashMap<String, Float> r1 = r18;
        List r2 = r19.getComposerConfigList();
        if (r2.size() != 1) goto L15;
        Sticker.ComposerConfig r3 = (Sticker.ComposerConfig) CollectionsKt.firstOrNull(r2);
        if (r3 != null) goto L7;
        return;
    L7:
        Float r4 = r1.get(r3.getTag());
        float r5 = com.bytedance.android.live.effect.q.c(r3, r3.getDefaultValue());
        if (Intrinsics.areEqual(this.i, "live_adjustment") == false) goto L13;
        if (r4 == null) goto L11;
        float r6 = r4.floatValue();
    L12:
        r17.put("effect_value", String.valueOf(com.bytedance.android.live.effect.q.a(r3, r6)));
        r17.put("default_value", String.valueOf(r3.getDefaultValue()));
    L14:
        boolean r7 = Intrinsics.areEqual(r4, r5);
    L23:
        if (r7 == false) goto L25;
        String r8 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L26:
        r17.put("is_default_value", r8);
        return;
    L25:
        r8 = "0";
        goto L26
    L11:
        r6 = 0.0f;
        goto L12
    L13:
        r17.put("effect_value", String.valueOf(r4));
        r17.put("default_value", String.valueOf(r5));
        goto L14
    L15:
        ArrayList r9 = new ArrayList();
        ArrayList r11 = new ArrayList();
        Iterator r12 = r2.iterator();
        boolean r13 = true;
    L17:
        if (r12.hasNext() == false) goto L22;
        Sticker.ComposerConfig r14 = (Sticker.ComposerConfig) r12.next();
        Float r15 = r1.get(r14.getTag());
        HashMap r16 = new HashMap();
        r16.put("type", r14.getTag());
        r16.put("name", r14.getName());
        r16.put("value", String.valueOf(r15));
        Unit r110 = Unit.INSTANCE;
        r9.add(r16);
        float r111 = com.bytedance.android.live.effect.q.c(r14, r14.getDefaultValue());
        HashMap r112 = new HashMap();
        r112.put("type", r14.getTag());
        r112.put("name", r14.getName());
        r112.put("value", String.valueOf(r111));
        r11.add(r112);
        if ((!Intrinsics.areEqual(r15, r111)) == false) goto L21;
        r13 = false;
    L21:
        r1 = r18;
        goto L17
    L22:
        r17.put("effect_value", GsonProtectorUtils.toJson(GsonHelper.get(), r9));
        r17.put("default_value", GsonProtectorUtils.toJson(GsonHelper.get(), r11));
        r7 = r13;
        goto L23
    }

    public final void l(String r5, Sticker r6, HashMap<String, String> r7) {
        Disposable r0 = this.a.remove(r5);
        if (r0 == null) goto L6;
        r0.dispose();
    L6:
        if (g() == true) goto L8;
        return;
    L8:
        if (h(r6) == false) goto L13;
        this.a.put(r5, Observable.timer(LiveEffectSettings.LIVE_FACE_STICKER_EFFECTIVELY_USE_TIME.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r6, r7)));
        return;
    }

    public final void m(String r5, Sticker r6, HashMap<String, String> r7) {
        Disposable r0 = this.b.remove(r5);
        if (r0 == null) goto L6;
        r0.dispose();
    L6:
        if (g() == true) goto L8;
        return;
    L8:
        if (h(r6) == false) goto L13;
        this.b.put(r5, Observable.timer(LiveEffectSettings.LIVE_BODY_BEAUTY_ADJUST_LOG_SQUASH_TIME.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r6, r7)));
        return;
    }

    public final void n(String r5, Sticker r6, HashMap<String, String> r7) {
        HashMap<String, String> r8 = j(r6, r7);
        long r0 = System.currentTimeMillis();
        Long r2 = this.d.get(r5);
        if (r2 != null) goto L5;
        r2 = 0L;
    L5:
        r8.put("use_time", String.valueOf((r0 - r2.longValue()) / ((long) 1000)));
        HashMap<String, Float> r9 = this.e.get(r5);
        if (r9 == null) goto L8;
        f(r8, r9, r6);
    L8:
        o(Companion.AnchorBeautifyLogEventType.USE_TIME, r8);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.e
    public final void d(boolean r8, String r9, Sticker r11, HashMap<String, String> r12) {
        if (Intrinsics.areEqual(r9, this.i) == false) goto L19;
        if (r12 != null) goto L6;
    L7:
        if (r11 == null) goto L21;
        String r2 = r11.getEffectId();
        if (r8 == false) goto L11;
        this.f.put(r2, r11);
        this.g.put(r2, r12);
        m(r2, r11, r12);
        l(r2, r11, r12);
        k(r2, r11, r12, Companion.UseTimeTriggerType.ADD, i(r11));
        return;
    L11:
        this.f.remove(r2);
        this.g.remove(r2);
        Disposable r13 = this.b.remove(r2);
        if (r13 == null) goto L14;
        r13.dispose();
    L14:
        Disposable r14 = this.a.remove(r2);
        if (r14 == null) goto L17;
        r14.dispose();
    L17:
        k(r2, r11, r12, Companion.UseTimeTriggerType.REMOVE, i(r11));
        return;
    L21:
        return;
    L6:
        if (r12.containsKey("is_not_in_use") != true) goto L7;
        return;
    }

    public final void k(String r11, Sticker r12, HashMap<String, String> r13, Companion.UseTimeTriggerType r14, HashMap<String, Float> r15) {
        Disposable r0 = this.c.remove(r11);
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        int r16 = h.a[r14.ordinal()];
        if (r16 != 1) goto L8;
    L15:
        long r5 = System.currentTimeMillis();
        this.c.put(r11, Observable.timer(LiveEffectSettings.LIVE_BODY_BEAUTY_ADJUST_LOG_SQUASH_TIME.getValue().longValue(), TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r11, r12, r13, r5, r15)));
        return;
    L8:
        if (r16 == 2) goto L15;
        if (r16 == 3) goto L13;
        return;
    L13:
        if (this.d.containsKey(r11) == false) goto L17;
        n(r11, r12, r13);
        this.d.remove(r11);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r7, Sticker r8, String r9, float r11, HashMap<String, String> r12) {
        if (Intrinsics.areEqual(r7, this.i) == false) goto L17;
        if (r12 != null) goto L6;
    L7:
        if (r8 == null) goto L19;
        String r1 = r8.getEffectId();
        this.f.put(r1, r8);
        this.g.put(r1, r12);
        HashMap<String, String> r13 = new HashMap();
        if (r12 == null) goto L11;
        HashMap<String, String> r14 = r12;
    L12:
        r13.putAll(r14);
        if (Intrinsics.areEqual(this.i, "live_adjustment") == false) goto L15;
        r13.put("action_type", "drag");
    L15:
        Unit r15 = Unit.INSTANCE;
        m(r1, r8, r13);
        l(r1, r8, r12);
        k(r1, r8, r12, Companion.UseTimeTriggerType.CHANGE_VALUE, i(r8));
        return;
    L11:
        r14 = new HashMap();
        goto L12
    L19:
        return;
    L6:
        if (r12.containsKey("is_not_in_use") != true) goto L7;
        return;
    }
}
