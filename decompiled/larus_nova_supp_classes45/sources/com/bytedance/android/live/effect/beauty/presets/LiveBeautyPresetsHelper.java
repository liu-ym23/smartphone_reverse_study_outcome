package com.bytedance.android.live.effect.beauty.presets;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.beauty.filter.LiveComposerFilterHelper;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveBeautyPresetsHelper {
    public final List<BeautifyPreset> a;
    public LivePresetContainer b;
    public Map<String, ? extends List<PresetEffect>> c;
    public List<String> d;
    public final String e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final LiveEffectContextFactoryDelegate$Type i;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(((com.bytedance.android.live.effect.composer.p) r1).b, ((com.bytedance.android.live.effect.composer.p) r2).b);
        }
    }

    public static final class b {
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/live/effect/beauty/presets/LiveBeautyPresetsHelper$c", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/live/effect/beauty/presets/PresetSelectContainer;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c extends TypeToken<PresetSelectContainer> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/live/effect/beauty/presets/LiveBeautyPresetsHelper$d", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/live/effect/beauty/presets/LivePresetContainer;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d extends TypeToken<LivePresetContainer> {
        public d() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/android/live/effect/beauty/presets/LiveBeautyPresetsHelper$e", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/android/live/effect/beauty/presets/PresetSelectContainer;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class e extends TypeToken<PresetSelectContainer> {
        public e() {
        }
    }

    static {
    }

    public final ILiveEffectComposerManager i() {
        return (ILiveEffectComposerManager) this.f.getValue();
    }

    public final com.bytedance.android.live.effect.api.j k() {
        return (com.bytedance.android.live.effect.api.j) this.g.getValue();
    }

    public static String m() {
        return jc1.k.n(IUserService.class).user().n();
    }

    public final Map<String, List<PresetEffect>> f() {
        List<com.bytedance.android.live.effect.composer.n> r1 = i().e();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L13;
        Object r4 = r3.next();
        com.bytedance.android.live.effect.composer.n r6 = (com.bytedance.android.live.effect.composer.n) r4;
        if (r6.j == true) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        if (this.d.contains(r6.a) == false) goto L10;
        r5 = true;
        goto L11
    L13:
        ArrayList r7 = new ArrayList();
        r7.addAll(r2);
        List<com.bytedance.android.live.effect.composer.n> r8 = i().P();
        ArrayList r9 = new ArrayList();
        Iterator<T> r11 = r8.iterator();
    L15:
        if (r11.hasNext() == false) goto L19;
        Object r12 = r11.next();
        if (this.d.contains(((com.bytedance.android.live.effect.composer.n) r12).a) == false) goto L15;
        r9.add(r12);
        goto L15
    L19:
        r7.addAll(r9);
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r14 = r7.iterator();
    L21:
        if (r14.hasNext() == false) goto L26;
        Object r15 = r14.next();
        String r16 = ((com.bytedance.android.live.effect.composer.n) r15).a;
        Object r17 = r13.get(r16);
        if (r17 != null) goto L25;
        r17 = new ArrayList();
        r13.put(r16, r17);
    L25:
        ((List) r17).add(r15);
        goto L21
    L26:
        LinkedHashMap r18 = new LinkedHashMap(MapsKt.mapCapacity(r13.size()));
        Iterator r19 = r13.entrySet().iterator();
    L28:
        if (r19.hasNext() == false) goto L59;
        Map.Entry r21 = (Map.Entry) r19.next();
        Object r22 = r21.getKey();
        String r23 = (String) r21.getKey();
        List r24 = (List) r21.getValue();
        List<Sticker> r25 = i().o(r23);
        List r26 = r24;
        ArrayList r27 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r26, 10));
        Iterator r28 = r26.iterator();
    L31:
        if (r28.hasNext() == false) goto L58;
        com.bytedance.android.live.effect.composer.n r110 = (com.bytedance.android.live.effect.composer.n) r28.next();
        Iterator<T> r111 = r25.iterator();
    L34:
        if (r111.hasNext() == false) goto L38;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((Sticker) r112).getEffectId(), r110.b) == false) goto L34;
    L39:
        Sticker r113 = (Sticker) r112;
        List<com.bytedance.android.live.effect.composer.p> r114 = r110.i;
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r114.iterator();
    L41:
        if (r116.hasNext() == false) goto L48;
        Object r117 = r116.next();
        if (((com.bytedance.android.live.effect.composer.p) r117).a == null) goto L45;
        boolean r118 = true;
    L46:
        if (r118 == false) goto L41;
        r115.add(r117);
        goto L41
    L45:
        r118 = false;
        goto L46
    L48:
        List r119 = CollectionsKt.sortedWith(r115, new a());
        ArrayList r120 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r119, 10));
        Iterator r121 = r119.iterator();
    L50:
        if (r121.hasNext() == false) goto L52;
        com.bytedance.android.live.effect.composer.p r122 = (com.bytedance.android.live.effect.composer.p) r121.next();
        String r29 = r122.b;
        Float r123 = r122.a;
        Intrinsics.checkNotNull(r123);
        r120.add(new EffectParameter(r29, r123.floatValue()));
        goto L50
    L52:
        String r124 = r110.b;
        if (r113 == null) goto L56;
        String r125 = r113.getName();
        if (r125 == null) goto L56;
    L57:
        r27.add(new PresetEffect(r124, r125, r110.a, r120));
    L56:
        r125 = "未知特效";
        goto L57
    L38:
        r112 = null;
        goto L39
    L58:
        r18.put(r22, r27);
        goto L28
    L59:
        return r18;
    }

    public final String j() {
        String r2 = m90.b.u.c(this.i);
        if (r2.length() <= 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L20;
    L19:
        return "";
    L20:
        RoomPresetSelectContainer r4 = ((PresetSelectContainer) GsonHelper.get().fromJson(r2, new c().getType())).getSelectionsByUid().get(m());     // Catch: Exception -> L17
        if (r4 == null) goto L14;
        Map<String, String> r5 = r4.getSelectionsByRoom();     // Catch: Exception -> L17
        if (r5 == null) goto L14;
        String r6 = r5.get(this.e);     // Catch: Exception -> L17
        if (r6 == null) goto L14;
    L15:
        ALogger.e("LiveBeautyPresetsTrace", "getCurrentSelectPreset : ".concat(r6));     // Catch: Exception -> L17
        return r6;
    L14:
        r6 = "";
    L17:
        e = move-exception;
        ALogger.e("LiveBeautyPresetsTrace", "getCurrentSelectPreset failed: " + e.getMessage());
        goto L19
    L5:
        r3 = false;
        goto L7
    }

    public final List<BeautifyPreset> l() {
        String r0 = m90.b.t.c(this.i);
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L27;
        this.b = new LivePresetContainer(null, 1, null);
    L15:
        LivePresetContainer r2 = this.b;
        if (r2 == null) goto L26;
        Map<String, RoomPresetContainer> r3 = r2.getPresetGroupsByUid();
        if (r3 == null) goto L26;
        RoomPresetContainer r4 = r3.get(m());
        if (r4 == null) goto L26;
        Map<String, List<BeautifyPreset>> r5 = r4.getPresetListsByRoom();
        if (r5 == null) goto L26;
        List<BeautifyPreset> r6 = r5.get(this.e);
        if (r6 == null) goto L26;
        return r6;
    L26:
        return CollectionsKt.emptyList();
    L27:
        Type r7 = new d().getType();     // Catch: Exception -> L12
        LivePresetContainer r8 = (LivePresetContainer) GsonHelper.get().fromJson(r0, r7);     // Catch: Exception -> L12
        this.b = r8;     // Catch: Exception -> L12
        if (r8 != null) goto L15;
        this.b = new LivePresetContainer(null, 1, null);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        this.b = new LivePresetContainer(null, 1, null);
        ALogger.e("LiveBeautyPresetsTrace", "getPresetFromLocal error", e);
        goto L15
    L5:
        r1 = false;
        goto L7
    }

    public final void o() {
    L10:
        e = move-exception;
        ALogger.e("LiveBeautyPresetsTrace", "saveAllPresets error", e);
        return;
    L3:
        if (this.b != null) goto L5;
        this.b = new LivePresetContainer(null, 1, null);     // Catch: Exception -> L10
    L5:
        LivePresetContainer r0 = this.b;     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L10
        Map<String, RoomPresetContainer> r1 = r0.getPresetGroupsByUid();     // Catch: Exception -> L10
        String r3 = m();     // Catch: Exception -> L10
        RoomPresetContainer r4 = r1.get(r3);     // Catch: Exception -> L10
        if (r4 != null) goto L8;
        r4 = new RoomPresetContainer(null, 1, null);     // Catch: Exception -> L10
        r1.put(r3, r4);     // Catch: Exception -> L10
    L8:
        r4.getPresetListsByRoom().put(this.e, this.a);     // Catch: Exception -> L10
        String r2 = GsonHelper.get().toJson(this.b);     // Catch: Exception -> L10
        m90.b.t.e(this.i, r2);     // Catch: Exception -> L10
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.i;
    }

    public LiveBeautyPresetsHelper(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.i = r2;
        this.a = new ArrayList();
        this.d = CollectionsKt.emptyList();
        this.e = "room_template_default_id";
        this.f = LazyKt.lazy(new LiveBeautyPresetsHelper$composerManager$2(this));
        this.g = LazyKt.lazy(new LiveBeautyPresetsHelper$effectService$2(this));
        this.h = LazyKt.lazy(LiveBeautyPresetsHelper$enablePresetRepelOpt$2.INSTANCE);
    }

    public static Map g(Map r11) {
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r11.size()));
        Iterator r12 = r11.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L30;
        Map.Entry r1 = (Map.Entry) r12.next();
        Object r3 = r1.getKey();
        List r2 = (List) r1.getValue();
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L7:
        if (r5.hasNext() == false) goto L29;
        Object r6 = r5.next();
        PresetEffect r7 = (PresetEffect) r6;
        if (r7.getParameters().isEmpty() == true) goto L26;
        List<EffectParameter> r8 = r7.getParameters();
        boolean r9 = false;
        if ((r8 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r13 = r8.iterator();
    L17:
        if (r13.hasNext() == false) goto L24;
        if (((EffectParameter) r13.next()).getValue() == 0.0f) goto L21;
        boolean r14 = true;
    L22:
        if (r14 == false) goto L17;
        boolean r15 = true;
    L25:
        if (r15 == true) goto L26;
    L27:
        if (r9 == false) goto L7;
        r4.add(r6);
        goto L7
    L21:
        r14 = false;
    L24:
        r15 = false;
        goto L25
    L13:
        if (r8.isEmpty() == false) goto L15;
    L26:
        r9 = true;
        goto L27
    L29:
        r0.put(r3, r4);
        goto L4
    L30:
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator r17 = r0.entrySet().iterator();
    L32:
        if (r17.hasNext() == false) goto L36;
        Map.Entry r18 = (Map.Entry) r17.next();
        if ((!((List) r18.getValue()).isEmpty()) == false) goto L32;
        r16.put(r18.getKey(), r18.getValue());
        goto L32
    L36:
        return r16;
    }

    public static void n(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        ALogger.i("LiveBeautyPresetsTrace", r1);
    }

    public final Map<Long, String> h(BeautifyPreset r4) {
        Intrinsics.checkNotNullParameter(r4, "preset");
        Map<Long, String> r0 = MapsKt.emptyMap();
        if (((Boolean) this.h.getValue()).booleanValue() == true) goto L5;
        return r0;
    L5:
        Iterator<T> r5 = r4.getEffectsByPanel().entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) r5.next();
        String r2 = (String) r1.getKey();
        if ((!((List) r1.getValue()).isEmpty()) == false) goto L7;
        if (i().U(r2) <= 0) goto L7;
        r0 = i().N(r2);
        goto L7
    L13:
        return r0;
    }

    public final void p(String r11) {
        Intrinsics.checkNotNullParameter(r11, "presetId");
        ALogger.e("LiveBeautyPresetsTrace", "updateCurrentSelectPreset : " + r11);
        String r0 = m90.b.u.c(this.i);
        boolean r4 = false;
        if (r0.length() <= 0) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == true) goto L26;
    L12:
        PresetSelectContainer r1 = null;
    L13:
        if (r1 != null) goto L15;
        r1 = new PresetSelectContainer(null, 1, null);
    L15:
        Map<String, RoomPresetSelectContainer> r5 = r1.getSelectionsByUid();
        String r7 = m();
        RoomPresetSelectContainer r8 = r5.get(r7);
        if (r8 != null) goto L18;
        r8 = new RoomPresetSelectContainer(null, 1, null);
        r5.put(r7, r8);
    L18:
        RoomPresetSelectContainer r9 = r8;
        if (r11.length() != 0) goto L21;
        r4 = true;
    L21:
        if (r4 == false) goto L23;
        r9.getSelectionsByRoom().remove(this.e);
    L24:
        String r12 = GsonProtectorUtils.toJson(GsonHelper.get(), r1);
        ALogger.e("LiveBeautyPresetsTrace", "updateCurrentSelectPreset : " + r12);
        m90.b.u.e(this.i, r12);
        return;
    L23:
        r9.getSelectionsByRoom().put(this.e, r11);
        goto L24
    L26:
        r1 = (PresetSelectContainer) GsonHelper.get().fromJson(r0, new e().getType());     // Catch: Exception -> L10
    L10:
        e = move-exception;
        ALogger.e("LiveBeautyPresetsTrace", "updateCurrentSelectPreset failed: " + e.getMessage());
        goto L12
    L5:
        r3 = false;
        goto L7
    }

    public final int q(BeautifyPreset r6) {
        Intrinsics.checkNotNullParameter(r6, "updatedPreset");
        Iterator r0 = ((ArrayList) this.a).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((BeautifyPreset) r0.next()).getPresetId(), r6.getPresetId()) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 == (-1)) goto L12;
        ((BeautifyPreset) ListProtector.get(this.a, r1)).setPresetName(r6.getPresetName());
        ((BeautifyPreset) ListProtector.get(this.a, r1)).setEffectsByPanel(r6.getEffectsByPanel());
        o();
    L12:
        return r1;
    L9:
        r1 = -1;
        goto L10
    }

    public final void a(List<PresetEffect> r12, List<Sticker> r13, List<Sticker> r14) {
        Iterator<T> r15 = r13.iterator();
    L4:
        if (r15.hasNext() == false) goto L36;
        Sticker r0 = (Sticker) r15.next();
        Iterator<T> r1 = r12.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((PresetEffect) r2).getEffectId(), r0.getEffectId()) == false) goto L7;
    L12:
        PresetEffect r8 = (PresetEffect) r2;
        List<Sticker> r3 = r14;
        if ((r3 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r4 = r3.iterator();
    L19:
        if (r4.hasNext() == false) goto L23;
        if (Intrinsics.areEqual(((Sticker) r4.next()).getEffectId(), r0.getEffectId()) == false) goto L19;
        boolean r5 = true;
    L24:
        if (r8 != null) goto L25;
        Sticker.ComposerConfig r6 = r0.getSmallItemConfig();
        Intrinsics.checkNotNull(r6);
        float r7 = com.bytedance.android.live.effect.q.d(r0, r6.getDefaultValue());
        ILiveEffectComposerManager r9 = i();
        String r11 = r0.getEffectId();
        Sticker.ComposerConfig r16 = r0.getSmallItemConfig();
        Intrinsics.checkNotNull(r16);
        if ((!Intrinsics.areEqual(r9.G(r11, r16.getTag()), r7)) == false) goto L4;
        n("applyAvAdjustEffect reset , presetEffect = " + r8 + ", defaultValue = " + r7);
        ILiveEffectComposerManager r17 = i();
        Sticker.ComposerConfig r18 = r0.getSmallItemConfig();
        Intrinsics.checkNotNull(r18);
        ILiveEffectComposerManager.f.d(r17, "live_adjustment", r0, r18.getTag(), r7, null, 48);
        goto L4
    L25:
        if (r5 == true) goto L27;
        i().a("live_adjustment", r0, "LiveBeautyPresetsTrace_applyPreset");
    L27:
        Iterator<T> r19 = r8.getParameters().iterator();
    L29:
        if (r19.hasNext() == false) goto L4;
        EffectParameter r21 = (EffectParameter) r19.next();
        n("applyAvAdjustEffect apply, presetEffect = " + r8 + ", currentValue = " + i().G(r0.getEffectId(), r21.getTag()));
        if ((!Intrinsics.areEqual(i().G(r0.getEffectId(), r21.getTag()), r21.getValue())) == false) goto L29;
        ILiveEffectComposerManager.f.d(i(), "live_adjustment", r0, r21.getTag(), r21.getValue(), null, 48);
    L23:
        r5 = false;
        goto L24
    L15:
        if (r3.isEmpty() == false) goto L17;
    L11:
        r2 = null;
        goto L12
    }

    public final void b(List<PresetEffect> r11, List<Sticker> r12, List<Sticker> r13) {
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L43;
        Sticker r0 = (Sticker) r14.next();
        Iterator<T> r1 = r11.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((PresetEffect) r2).getEffectId(), r0.getEffectId()) == false) goto L7;
    L12:
        PresetEffect r3 = (PresetEffect) r2;
        List<Sticker> r4 = r13;
        if ((r4 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r5 = r4.iterator();
    L19:
        if (r5.hasNext() == false) goto L23;
        if (Intrinsics.areEqual(((Sticker) r5.next()).getEffectId(), r0.getEffectId()) == false) goto L19;
        boolean r6 = true;
    L25:
        if (r3 != null) goto L27;
        if (r0.isSubItem() == false) goto L40;
        if (r6 == false) goto L40;
        i().O(d0.i, r0, "LiveBeautyPresetsTrace_applyPreset");
    L40:
        Sticker.ComposerConfig r7 = r0.getSmallItemConfig();
        Intrinsics.checkNotNull(r7);
        float r8 = com.bytedance.android.live.effect.q.d(r0, r7.getDefaultValue());
        ILiveEffectComposerManager r9 = i();
        String r15 = r0.getEffectId();
        Sticker.ComposerConfig r16 = r0.getSmallItemConfig();
        Intrinsics.checkNotNull(r16);
        if ((!Intrinsics.areEqual(r9.G(r15, r16.getTag()), r8)) == false) goto L4;
        ILiveEffectComposerManager r17 = i();
        String r18 = d0.i;
        Sticker.ComposerConfig r19 = r0.getSmallItemConfig();
        Intrinsics.checkNotNull(r19);
        ILiveEffectComposerManager.f.d(r17, r18, r0, r19.getTag(), r8, null, 48);
        goto L4
    L27:
        if (r0.isSubItem() == false) goto L30;
        if (r6 == true) goto L30;
        i().a(d0.i, r0, "LiveBeautyPresetsTrace_applyPreset");
    L30:
        Iterator<T> r21 = r3.getParameters().iterator();
    L32:
        if (r21.hasNext() == false) goto L4;
        EffectParameter r22 = (EffectParameter) r21.next();
        if ((!Intrinsics.areEqual(i().G(r0.getEffectId(), r22.getTag()), r22.getValue())) == false) goto L32;
        ILiveEffectComposerManager.f.d(i(), d0.i, r0, r22.getTag(), r22.getValue(), null, 48);
    L23:
        r6 = false;
        goto L25
    L15:
        if (r4.isEmpty() == false) goto L17;
    L11:
        r2 = null;
        goto L12
    }

    public final void c(List<PresetEffect> r11, List<Sticker> r12, List<Sticker> r13) {
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L36;
        Sticker r0 = (Sticker) r14.next();
        Iterator<T> r1 = r11.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((PresetEffect) r2).getEffectId(), r0.getEffectId()) == false) goto L7;
    L12:
        PresetEffect r3 = (PresetEffect) r2;
        List<Sticker> r4 = r13;
        if ((r4 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r5 = r4.iterator();
    L19:
        if (r5.hasNext() == false) goto L23;
        if (Intrinsics.areEqual(((Sticker) r5.next()).getEffectId(), r0.getEffectId()) == false) goto L19;
        boolean r6 = true;
    L24:
        if (r3 != null) goto L25;
        Sticker.ComposerConfig r7 = r0.getSmallItemConfig();
        Intrinsics.checkNotNull(r7);
        float r8 = com.bytedance.android.live.effect.q.d(r0, r7.getDefaultValue());
        ILiveEffectComposerManager r9 = i();
        String r15 = r0.getEffectId();
        Sticker.ComposerConfig r16 = r0.getSmallItemConfig();
        Intrinsics.checkNotNull(r16);
        if ((!Intrinsics.areEqual(r9.G(r15, r16.getTag()), r8)) == false) goto L4;
        ILiveEffectComposerManager r17 = i();
        Sticker.ComposerConfig r18 = r0.getSmallItemConfig();
        Intrinsics.checkNotNull(r18);
        ILiveEffectComposerManager.f.d(r17, "livebody", r0, r18.getTag(), r8, null, 48);
        goto L4
    L25:
        if (r6 == true) goto L27;
        i().a("livebody", r0, "LiveBeautyPresetsHelper_applyPreset");
    L27:
        Iterator<T> r19 = r3.getParameters().iterator();
    L29:
        if (r19.hasNext() == false) goto L4;
        EffectParameter r21 = (EffectParameter) r19.next();
        if ((!Intrinsics.areEqual(i().G(r0.getEffectId(), r21.getTag()), r21.getValue())) == false) goto L29;
        ILiveEffectComposerManager.f.d(i(), "livebody", r0, r21.getTag(), r21.getValue(), null, 48);
    L23:
        r6 = false;
        goto L24
    L15:
        if (r4.isEmpty() == false) goto L17;
    L11:
        r2 = null;
        goto L12
    }

    public final void e(PresetEffect r11, List<Sticker> r12, Sticker r13) {
        String r0 = null;
        if (r11 == null) goto L12;
        Iterator<T> r14 = r12.iterator();
    L6:
        if (r14.hasNext() == false) goto L10;
        Object r1 = r14.next();
        if (Intrinsics.areEqual(((Sticker) r1).getEffectId(), r11.getEffectId()) == false) goto L6;
    L11:
        Sticker r2 = (Sticker) r1;
    L13:
        if (r13 == null) goto L15;
        String r15 = r13.getEffectId();
    L16:
        if (r2 == null) goto L19;
        r0 = r2.getEffectId();
    L19:
        if ((!Intrinsics.areEqual(r15, r0)) == false) goto L21;
        com.bytedance.android.live.effect.beauty.makeups.a.C0185a.a(k().f(), r2, "LiveBeautyPresetsTrace_applyPreset");
    L21:
        if (r2 == null) goto L28;
        Iterator<T> r16 = r11.getParameters().iterator();
    L24:
        if (r16.hasNext() == false) goto L37;
        EffectParameter r17 = (EffectParameter) r16.next();
        if ((!Intrinsics.areEqual(i().G(r2.getEffectId(), r17.getTag()), r17.getValue())) == false) goto L24;
        ILiveEffectComposerManager.f.d(i(), d0.k, r2, r17.getTag(), r17.getValue(), null, 48);
        goto L24
    L37:
        return;
    L28:
        return;
    L15:
        r15 = null;
        goto L16
    L10:
        r1 = null;
        goto L11
    L12:
        r2 = null;
        goto L13
    }

    public final void d(PresetEffect r11, List<Sticker> r12, Sticker r13, String r14) {
        String r0 = null;
        if (r11 == null) goto L12;
        Iterator<T> r15 = r12.iterator();
    L6:
        if (r15.hasNext() == false) goto L10;
        Object r1 = r15.next();
        if (Intrinsics.areEqual(((Sticker) r1).getEffectId(), r11.getEffectId()) == false) goto L6;
    L11:
        Sticker r2 = (Sticker) r1;
    L13:
        if (r13 == null) goto L15;
        String r16 = r13.getEffectId();
    L16:
        if (r2 == null) goto L19;
        r0 = r2.getEffectId();
    L19:
        if ((!Intrinsics.areEqual(r16, r0)) == false) goto L21;
        LiveComposerFilterHelper.a(k().m(), r2, "LiveBeautyPresetsTrace_applyPreset", r14, false, false, 56);
    L21:
        if (r2 == null) goto L28;
        Iterator<T> r17 = r11.getParameters().iterator();
    L24:
        if (r17.hasNext() == false) goto L37;
        EffectParameter r18 = (EffectParameter) r17.next();
        if ((!Intrinsics.areEqual(i().G(r2.getEffectId(), r18.getTag()), r18.getValue())) == false) goto L24;
        ILiveEffectComposerManager.f.d(i(), d0.a, r2, r18.getTag(), r18.getValue(), null, 48);
        goto L24
    L37:
        return;
    L28:
        return;
    L15:
        r16 = null;
        goto L16
    L10:
        r1 = null;
        goto L11
    L12:
        r2 = null;
        goto L13
    }
}
