package com.bytedance.android.live.effect.beauty.presets;

import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.utils.LivePresetsLogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements LiveBeautyPresetsAdapter.a {
    public final /* synthetic */ LiveBeautyPresetsFragment a;
    public final /* synthetic */ LiveBeautyPresetsAdapter b;

    public static final class a implements b {
        public final /* synthetic */ e a;
        public final /* synthetic */ BeautifyPreset b;

        @Override // com.bytedance.android.live.effect.beauty.presets.b
        public final void a(String r11) {
            Intrinsics.checkNotNullParameter(r11, "input");
            BeautifyPreset r12 = BeautifyPreset.copy$default(this.b, null, r11, false, false, null, 29, null);
            LiveBeautyPresetsFragment r0 = this.a.a;
            int r1 = LiveBeautyPresetsFragment.C;
            int r13 = r0.T90().q(r12);
            e r2 = this.a;
            r2.b.A2(r2.a.T90().a, PresetOperationType.RENAME_PRESET, r13);
            f2.c("预设已重命名", 0);
        }

        public a(e r1, BeautifyPreset r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.android.live.effect.beauty.presets.LiveBeautyPresetsAdapter.a
    public final void a(BeautifyPreset r7) {
        Intrinsics.checkNotNullParameter(r7, "preset");
        RenameInputDialog r0 = new RenameInputDialog();
        Long r1 = LivePresetsLogger.a;
        LivePresetsLogger.a(r7.getPresetName(), GsonProtectorUtils.toJson(GsonHelper.get(), r7.getEffectsByPanel()), LivePresetsLogger.BtnType.EDIT, null, 8);
        a r2 = new a(this, r7);
        Intrinsics.checkNotNullParameter(r2, "listener");
        r0.g = r2;
        FragmentManager r8 = this.a.getChildFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, "RenameInputDialog", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r0, r3) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r0.show(r8, "RenameInputDialog");
        return;
    }

    @Override // com.bytedance.android.live.effect.beauty.presets.LiveBeautyPresetsAdapter.a
    public final void b(BeautifyPreset r11) {
        Intrinsics.checkNotNullParameter(r11, "preset");
        Long r1 = LivePresetsLogger.a;
        LivePresetsLogger.a(r11.getPresetName(), GsonProtectorUtils.toJson(GsonHelper.get(), r11.getEffectsByPanel()), LivePresetsLogger.BtnType.DELETE, null, 8);
        LiveBeautyPresetsFragment r2 = this.a;
        int r3 = LiveBeautyPresetsFragment.C;
        boolean r4 = false;
        if (Intrinsics.areEqual(r2.T90().j(), r11.getPresetId()) == false) goto L5;
        this.a.X90(true);
        this.a.W90(false);
    L5:
        LiveBeautyPresetsHelper r5 = this.a.T90();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r11, "preset");
        Iterator r0 = ((ArrayList) r5.a).iterator();
        int r6 = 0;
    L7:
        if (r0.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(((BeautifyPreset) r0.next()).getPresetId(), r11.getPresetId()) == true) goto L13;
        r6 = r6 + 1;
    L13:
        if (r6 == (-1)) goto L16;
        ListProtector.remove(r5.a, r6);
    L16:
        if (Intrinsics.areEqual(r11.getPresetId(), r5.j()) == false) goto L18;
        r5.p("");
        r5.c = null;
    L18:
        r5.o();
        this.b.A2(this.a.T90().a, PresetOperationType.DELETE_PRESET, r6);
        f2.c(r11.getPresetName() + "已删除", 0);
        if (((ArrayList) this.a.T90().a).isEmpty() == false) goto L24;
        TextView r12 = this.a.w;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("remindView");
    L23:
        r12.setVisibility(0);
        this.a.X90(true);
        return;
    L24:
        LiveBeautyPresetsHelper r13 = this.a.T90();
        Map<String, ? extends List<PresetEffect>> r7 = r13.c;
        if (r7 != null) goto L27;
    L28:
        r4 = true;
    L29:
        if (r4 == true) goto L31;
        return;
    L31:
        if (((ArrayList) this.a.T90().a).size() >= this.a.A.intValue()) goto L38;
        this.a.X90(true);
        return;
    L38:
        return;
    L27:
        if ((!Intrinsics.areEqual(LiveBeautyPresetsHelper.g(r7), LiveBeautyPresetsHelper.g(r13.f()))) == false) goto L29;
    L12:
        r6 = -1;
        goto L13
    }

    @Override // com.bytedance.android.live.effect.beauty.presets.LiveBeautyPresetsAdapter.a
    public final void c(BeautifyPreset r31) {
        Intrinsics.checkNotNullParameter(r31, "preset");
        LiveBeautyPresetsFragment r11 = this.a;
        int r2 = LiveBeautyPresetsFragment.C;
        final LiveBeautyPresetsHelper r12 = r11.T90();
        String r13 = r11.e;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r31, "preset");
        Intrinsics.checkNotNullParameter(r13, "eventPage");
        Map<String, List<PresetEffect>> r0 = r31.getEffectsByPanel();
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator<Map.Entry<String, List<PresetEffect>>> r1 = r0.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Map.Entry<String, List<PresetEffect>> r3 = r1.next();
        if (r12.d.contains(r3.getKey()) == false) goto L4;
        r14.put(r3.getKey(), r3.getValue());
        goto L4
    L8:
        LinkedHashMap r4 = new LinkedHashMap();
        String r9 = "livebody";
        String r5 = "live_adjustment";
        Map r6 = MapsKt.mapOf(new Pair[]{TuplesKt.to(d0.i, new LiveBeautyPresetsHelper$applyPreset$panelStickerGetters$1(r12)), TuplesKt.to("livebody", new LiveBeautyPresetsHelper$applyPreset$panelStickerGetters$2(r12)), TuplesKt.to(d0.k, new LiveBeautyPresetsHelper$applyPreset$panelStickerGetters$3(r12)), TuplesKt.to(d0.a, new LiveBeautyPresetsHelper$applyPreset$panelStickerGetters$4(r12)), TuplesKt.to("live_adjustment", new LiveBeautyPresetsHelper$applyPreset$panelStickerGetters$5(r12))});
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r8 = r6.entrySet().iterator();
    L10:
        if (r8.hasNext() == false) goto L15;
        Map.Entry r15 = (Map.Entry) r8.next();
        if (r12.d.contains(r15.getKey()) == false) goto L10;
        r7.put(r15.getKey(), r15.getValue());
        goto L10
    L15:
        Iterator r16 = r7.entrySet().iterator();
        boolean r17 = false;
    L17:
        if (r16.hasNext() == false) goto L51;
        Map.Entry r18 = (Map.Entry) r16.next();
        String r19 = (String) r18.getKey();
        Function0 r21 = (Function0) r18.getValue();
        List r22 = (List) r14.get(r19);
        if (r22 != null) goto L22;
        r22 = CollectionsKt.emptyList();
    L22:
        if (r22.isEmpty() == false) goto L24;
        r4.put(r19, CollectionsKt.emptyList());
        Iterator r23 = r16;
    L50:
        r16 = r23;
        goto L17
    L24:
        List r24 = (List) r21.invoke();
        if (r24.isEmpty() == true) goto L26;
        ArrayList r110 = new ArrayList();
        Iterator r25 = r22.iterator();
    L29:
        if (r25.hasNext() == false) goto L46;
        Object r26 = r25.next();
        PresetEffect r111 = (PresetEffect) r26;
        Iterator r27 = r16;
        List r28 = r24;
        List r29 = r24;
        if ((r28 instanceof Collection) == true) goto L33;
    L35:
        Iterator r32 = r28.iterator();
    L37:
        if (r32.hasNext() == false) goto L42;
        Iterator r210 = r32;
        if (Intrinsics.areEqual(((Sticker) r32.next()).getEffectId(), r111.getEffectId()) == true) goto L40;
        r32 = r210;
        goto L37
    L40:
        boolean r33 = true;
    L43:
        if (r33 == false) goto L45;
        r110.add(r26);
    L45:
        r16 = r27;
        r24 = r29;
    L42:
        r33 = false;
        goto L43
    L33:
        if (r28.isEmpty() == false) goto L35;
    L46:
        r23 = r16;
        if (r110.size() >= r22.size()) goto L49;
        r17 = true;
    L49:
        r4.put(r19, r110);
        goto L50
    L26:
        com.bytedance.android.live.effect.beauty.presets.a r34 = new com.bytedance.android.live.effect.beauty.presets.a(ApplyStatus.PANEL_LOAD_FAILED, r31, r19);
        String r35 = "live_adjustment";
        String r112 = "livebody";
        String r36 = null;
    L130:
        int r37 = d.a[r34.a.ordinal()];
        if (r37 == 1) goto L155;
        if (r37 == 2) goto L155;
        if (r37 != 3) goto L173;
        String r38 = r34.c;
        if (Intrinsics.areEqual(r38, d0.i) == false) goto L141;
        String r39 = "美颜";
    L153:
        f2.c(r39.concat("列表加载失败，无法应用预设"), 0);
        goto L173
    L141:
        if (Intrinsics.areEqual(r38, r112) == false) goto L144;
        r39 = "美体";
        goto L153
    L144:
        if (Intrinsics.areEqual(r38, d0.k) == false) goto L147;
        r39 = "美妆";
        goto L153
    L147:
        if (Intrinsics.areEqual(r38, d0.a) == false) goto L150;
        r39 = "滤镜";
        goto L153
    L150:
        if (Intrinsics.areEqual(r38, r35) == false) goto L152;
        r39 = "调节";
        goto L153
    L152:
        r39 = "特效";
    L173:
        Long r41 = LivePresetsLogger.a;
        LivePresetsLogger.a(r31.getPresetName(), GsonProtectorUtils.toJson(GsonHelper.get(), r31.getEffectsByPanel()), LivePresetsLogger.BtnType.SELECT, r36, 8);
        this.a.W90(true);
        this.a.X90(false);
        return;
    L155:
        if (r34.a != ApplyStatus.MODIFIED) goto L157;
        f2.c("部分美颜效果已更新", 0);
    L158:
        BeautifyPreset r42 = r34.b;
        r11.p = r42;
        r11.q = false;
        m90.c<Boolean> r43 = m90.b.a;
        if (r11.t == r42.getBeautyEnabled()) goto L161;
        boolean r44 = true;
    L162:
        r11.r = r44;
        if ((!Intrinsics.areEqual(r43.c(r11.d), Boolean.valueOf(r34.b.getBeautyEnabled()))) == false) goto L165;
        r43.e(r11.d, Boolean.valueOf(r34.b.getBeautyEnabled()));
    L165:
        m90.c<Boolean> r45 = m90.b.j;
        if (r11.u == r34.b.getBodyEnabled()) goto L168;
        boolean r46 = true;
    L169:
        r11.s = r46;
        if ((!Intrinsics.areEqual(r45.c(r11.d), Boolean.valueOf(r34.b.getBodyEnabled()))) == false) goto L172;
        r45.e(r11.d, Boolean.valueOf(r34.b.getBodyEnabled()));
    L172:
        r11.T90().p(r34.b.getPresetId());
        r11.U90().A2(r11.T90().a, PresetOperationType.SELECT_PRESET, -1);
        List<String> r47 = LiveEffectContext.h;
        LiveEffectContext.a.a(r11.d).a().T("preset_apply", false);
        goto L173
    L168:
        r46 = false;
        goto L169
    L161:
        r44 = false;
        goto L162
    L157:
        f2.c(r34.b.getPresetName() + "已应用", 0);
        goto L158
    L51:
        if (r17 == false) goto L65;
        LinkedHashMap r48 = new LinkedHashMap(MapsKt.mapCapacity(r4.size()));
        Iterator r49 = r4.entrySet().iterator();
    L54:
        if (r49.hasNext() == false) goto L64;
        Map.Entry r51 = (Map.Entry) r49.next();
        Object r52 = r51.getKey();
        Iterable r53 = (Iterable) r51.getValue();
        int r54 = 10;
        ArrayList r55 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r53, 10));
        Iterator r56 = r53.iterator();
    L57:
        if (r56.hasNext() == false) goto L63;
        PresetEffect r113 = (PresetEffect) r56.next();
        List<EffectParameter> r114 = r113.getParameters();
        Iterator r211 = r49;
        ArrayList r57 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, r54));
        Iterator<T> r58 = r114.iterator();
    L60:
        if (r58.hasNext() == false) goto L62;
        r57.add(EffectParameter.copy$default((EffectParameter) r58.next(), null, 0.0f, 3, null));
        r9 = r9;
        r5 = r5;
        goto L60
    L62:
        r55.add(PresetEffect.copy$default(r113, null, null, null, r57, 7, null));
        r9 = r9;
        r49 = r211;
        r5 = r5;
        r54 = 10;
        goto L57
    L63:
        r48.put(r52, r55);
        r9 = r9;
        r5 = r5;
        goto L54
    L64:
        String r212 = r5;
        r112 = r9;
        BeautifyPreset r59 = BeautifyPreset.copy$default(r31, null, null, false, false, r48, 15, null);
        r12.q(r59);
        BeautifyPreset r61 = r59;
    L66:
        Map<String, List<PresetEffect>> r62 = r61.getEffectsByPanel();
        List<String> r63 = r12.d;
        String r64 = d0.i;
        if (r63.contains(r64) == true) goto L69;
    L78:
        List<String> r65 = r12.d;
        String r66 = d0.k;
        if (r65.contains(r66) == true) goto L81;
    L90:
        List<String> r67 = r12.d;
        String r68 = d0.a;
        if (r67.contains(r68) == false) goto L103;
        if (r12.i().U(r68) > 0) goto L103;
        List<PresetEffect> r69 = r62.get(r68);
        if (r69 != null) goto L183;
        r69 = CollectionsKt.emptyList();
    L183:
        r12.d((PresetEffect) CollectionsKt.firstOrNull(r69), r12.k().m().b, (Sticker) CollectionsKt.firstOrNull(r12.i().o(r68)), r13);     // Catch: Exception -> L100
    L100:
        e = move-exception;
        ALogger.e("LiveBeautyPresetsTrace", "applyFilterEffect failed, Exception = ", e);
    L103:
        if (r12.d.contains(r112) == true) goto L105;
    L114:
        r35 = r212;
        if (r12.d.contains(r35) == true) goto L117;
    L126:
        r12.c = r14;
        if (r17 == false) goto L129;
        r36 = null;
        r34 = new com.bytedance.android.live.effect.beauty.presets.a(ApplyStatus.MODIFIED, r61, null);
        goto L130
    L129:
        r36 = null;
        r34 = new com.bytedance.android.live.effect.beauty.presets.a(ApplyStatus.SUCCESS, r61, null);
        goto L130
    L117:
        if (r12.i().U(r35) > 0) goto L126;
        List<PresetEffect> r71 = r62.get(r35);
        if (r71 != null) goto L177;
        r71 = CollectionsKt.emptyList();
    L177:
        r12.a(r71, r12.k().n().b, r12.i().o(r35));     // Catch: Exception -> L124
    L124:
        e = move-exception;
        ALogger.e("LiveBeautyPresetsTrace", "applyAvAdjustEffect failed, Exception = ", e);
        goto L126
    L105:
        if (r12.i().U(r112) > 0) goto L114;
        List<PresetEffect> r72 = r62.get(r112);
        if (r72 != null) goto L175;
        r72 = CollectionsKt.emptyList();
    L175:
        r12.c(r72, CollectionsKt.toList(r12.k().p().a), r12.i().o(r112));     // Catch: Exception -> L112
    L112:
        e = move-exception;
        ALogger.e("LiveBeautyPresetsTrace", "applyBodyBeautyEffects failed, Exception = ", e);
        goto L114
    L81:
        if (r12.i().U(r66) > 0) goto L90;
        List<PresetEffect> r73 = r62.get(r66);
        if (r73 != null) goto L181;
        r73 = CollectionsKt.emptyList();
    L181:
        r12.e((PresetEffect) CollectionsKt.firstOrNull(r73), ((com.bytedance.android.live.effect.beauty.makeups.d) r12.k().f()).a, (Sticker) CollectionsKt.firstOrNull(r12.i().o(r66)));     // Catch: Exception -> L88
    L88:
        e = move-exception;
        ALogger.e("LiveBeautyPresetsTrace", "applyMakeupEffect failed, Exception = ", e);
        goto L90
    L69:
        if (r12.i().U(r64) > 0) goto L78;
        List<PresetEffect> r74 = r62.get(r64);
        if (r74 != null) goto L179;
        r74 = CollectionsKt.emptyList();
    L179:
        r12.b(r74, r12.k().g().b, r12.i().o(r64));     // Catch: Exception -> L76
    L76:
        e = move-exception;
        ALogger.e("LiveBeautyPresetsTrace", "applyBeautyEffects failed, Exception = ", e);
        goto L78
    L65:
        r212 = "live_adjustment";
        r112 = "livebody";
        r61 = r31;
        goto L66
    }

    public e(LiveBeautyPresetsFragment r1, LiveBeautyPresetsAdapter r2) {
        this.a = r1;
        this.b = r2;
    }
}
