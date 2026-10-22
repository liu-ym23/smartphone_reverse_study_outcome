package com.bytedance.android.live.effect.composer;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.c0;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.u;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k {
    public static final Map<String, List<String>> i = null;
    public Disposable a;
    public final Map<String, Integer> b;
    public final Map<String, Map<Long, String>> c;
    public final Map<String, Integer> d;
    public final Map<String, List<Long>> e;
    public int f;
    public int g;
    public final LiveEffectContextFactoryDelegate$Type h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ k a;
        public final /* synthetic */ int b;

        public b(k r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            k r5 = this.a;
            ((HashMap) r5.b).put(d0.i, Integer.valueOf(r5.f));
            this.a.f = 0;
            ALogger.e("ttlive_anchor_effect_LiveComposerRepelHelper", "SMALL_ITEM_BEAUTY stats: " + this.b);
            Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r6 = u.a;
            u.c(this.a.h).T("ttlive_anchor_effect_LiveComposerRepelHelper_postChangeBeauty", false);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            ALogger.e("ttlive_anchor_effect_LiveComposerRepelHelper", (Throwable) r2);
        }
    }

    public static final class d implements com.bytedance.android.live.core.log.c {
        public final /* synthetic */ k a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        public d(k r1, boolean r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return this.b + ' ' + this.c + " repel if need " + this.a.b;
        }
    }

    static {
        i = MapsKt.mapOf(new Pair[]{TuplesKt.to(d0.c, CollectionsKt.listOf("effect_gift")), TuplesKt.to("live_camera_move", CollectionsKt.listOf("effect_gift"))});
    }

    public final boolean b() {
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r0 = u.a;
        return u.c(this.h).p();
    }

    public k(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.h = r2;
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new HashMap();
    }

    public final int a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "panel");
        Integer r0 = (Integer) ((HashMap) this.b).get(r3);
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        ALogger.d("ttlive_anchor_effect_LiveComposerRepelHelper", r3 + " find repel stats " + r1);
        return r1;
    L5:
        r1 = 0;
        goto L6
    }

    public final void c(int r4) {
        this.f = r4;
        if (this.g <= 0) goto L6;
        ALogger.d("ttlive_anchor_effect_LiveComposerRepelHelper", "post change beauty interceptor stats:" + this.g);
        return;
    L6:
        if (r4 != 0) goto L9;
        ((HashMap) this.b).put(d0.i, Integer.valueOf(r4));
        ALogger.e("ttlive_anchor_effect_LiveComposerRepelHelper", "SMALL_ITEM_BEAUTY stats: " + this.f);
        return;
    L9:
        Disposable r0 = this.a;
        if (r0 != null) goto L12;
    L17:
        this.a = Observable.timer(1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r4), c.a);
        return;
    L12:
        if (r0.isDisposed() == true) goto L17;
        Disposable r1 = this.a;
        if (r1 == null) goto L16;
        r1.dispose();
    L16:
        this.a = null;
        goto L17
    }

    public final void d(boolean r21, String r22, Sticker r23) {
        Intrinsics.checkNotNullParameter(r22, "panel");
        Long r7 = null;
        int r8 = 0;
        if (Intrinsics.areEqual(r22, "livegame") == false) goto L37;
        if (r21 == false) goto L23;
        Map<String, Integer> r3 = this.b;
        String r9 = d0.k;
        Integer r4 = (Integer) ((HashMap) r3).get(r9);
        if (r4 == null) goto L8;
        int r5 = r4.intValue();
    L9:
        if (r23 == null) goto L11;
        int r11 = r23.getStickerFeature();
    L13:
        if ((r11 & 2) <= 0) goto L22;
        ((HashMap) this.b).put(r9, Integer.valueOf(r5 + 1));
        Map r6 = (Map) ((HashMap) this.c).get(r9);
        if (r6 != null) goto L17;
        r6 = new LinkedHashMap();
    L17:
        Map<String, Map<Long, String>> r12 = this.c;
        if (r23 == null) goto L20;
        long r13 = r23.getId();
    L21:
        r6.put(Long.valueOf(r13), r22);
        Unit r14 = Unit.INSTANCE;
        ((HashMap) r12).put(r9, r6);
        goto L22
    L20:
        r13 = 0;
    L22:
        Unit r15 = Unit.INSTANCE;
    L375:
        ALogger.d("ttlive_anchor_effect_LiveComposerRepelHelper", new d(this, r21, r22));
        if (r23 != null) goto L378;
        return;
    L378:
        if (r23.isHighCost() != true) goto L395;
        if (r21 == false) goto L387;
        Integer r1 = (Integer) ((HashMap) this.d).get(r22);
        if (r1 == null) goto L383;
        r8 = r1.intValue();
    L383:
        ((HashMap) this.d).put(r22, Integer.valueOf(r8 + 1));
        List r2 = (List) ((HashMap) this.e).get(r22);
        if (r2 != null) goto L386;
        r2 = new ArrayList();
    L386:
        Map<String, List<Long>> r16 = this.e;
        r2.add(Long.valueOf(r23.getId()));
        Unit r17 = Unit.INSTANCE;
        ((HashMap) r16).put(r22, r2);
        return;
    L387:
        Integer r18 = (Integer) ((HashMap) this.d).get(r22);
        if (r18 == null) goto L390;
        int r19 = r18.intValue();
        ((HashMap) this.d).put(r22, Integer.valueOf(r19 - 1));
    L390:
        List r24 = (List) ((HashMap) this.e).get(r22);
        if (r24 == null) goto L397;
        r24.remove(Long.valueOf(r23.getId()));
        return;
    L397:
        return;
    L395:
        return;
    L11:
        r11 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    L23:
        Map<String, Integer> r25 = this.b;
        String r26 = d0.k;
        Integer r27 = (Integer) ((HashMap) r25).get(r26);
        if (r27 == null) goto L375;
        int r28 = r27.intValue();
        if (r23 == null) goto L28;
        int r29 = r23.getStickerFeature();
    L30:
        if ((r29 & 2) <= 0) goto L36;
        ((HashMap) this.b).put(r26, Integer.valueOf(r28 - 1));
        Map r31 = (Map) ((HashMap) this.c).get(r26);
        if (r31 == null) goto L36;
        if (r23 == null) goto L35;
        r7 = Long.valueOf(r23.getId());
    L35:
        String r32 = (String) TypeIntrinsics.asMutableMap(r31).remove(r7);
    L36:
        Unit r33 = Unit.INSTANCE;
        goto L375
    L28:
        r29 = 0;
        goto L30
    L37:
        String r34 = d0.c;
        if (Intrinsics.areEqual(r22, r34) == false) goto L209;
        if (r21 == false) goto L127;
        Map<String, Integer> r35 = this.b;
        String r110 = d0.i;
        Integer r36 = (Integer) ((HashMap) r35).get(r110);
        if (r36 == null) goto L44;
        int r37 = r36.intValue();
    L45:
        if (r23 == null) goto L47;
        int r111 = r23.getStickerFeature();
    L49:
        if ((r111 & 4) <= 0) goto L58;
        c(r37 + 1);
        Map r38 = (Map) ((HashMap) this.c).get(r110);
        if (r38 != null) goto L53;
        r38 = new LinkedHashMap();
    L53:
        Map<String, Map<Long, String>> r112 = this.c;
        if (r23 == null) goto L56;
        long r113 = r23.getId();
    L57:
        r38.put(Long.valueOf(r113), r22);
        Unit r114 = Unit.INSTANCE;
        ((HashMap) r112).put(r110, r38);
        goto L58
    L56:
        r113 = 0;
    L58:
        Unit r39 = Unit.INSTANCE;
        Map<String, Integer> r41 = this.b;
        String r115 = d0.b;
        Integer r42 = (Integer) ((HashMap) r41).get(r115);
        if (r42 == null) goto L61;
        int r43 = r42.intValue();
    L62:
        if (r23 == null) goto L64;
        int r116 = r23.getStickerFeature();
    L66:
        if ((r116 & 8) <= 0) goto L75;
        ((HashMap) this.b).put(r115, Integer.valueOf(r43 + 1));
        Map r44 = (Map) ((HashMap) this.c).get(r115);
        if (r44 != null) goto L70;
        r44 = new LinkedHashMap();
    L70:
        Map<String, Map<Long, String>> r117 = this.c;
        if (r23 == null) goto L73;
        long r118 = r23.getId();
    L74:
        r44.put(Long.valueOf(r118), r22);
        ((HashMap) r117).put(r115, r44);
        goto L75
    L73:
        r118 = 0;
    L75:
        Map<String, Integer> r45 = this.b;
        String r119 = d0.a;
        Integer r46 = (Integer) ((HashMap) r45).get(r119);
        if (r46 == null) goto L78;
        int r47 = r46.intValue();
    L79:
        if (r23 == null) goto L81;
        int r120 = r23.getStickerFeature();
    L83:
        if ((r120 & 1) <= 0) goto L92;
        ((HashMap) this.b).put(r119, Integer.valueOf(r47 + 1));
        Map r48 = (Map) ((HashMap) this.c).get(r119);
        if (r48 != null) goto L87;
        r48 = new LinkedHashMap();
    L87:
        Map<String, Map<Long, String>> r121 = this.c;
        if (r23 == null) goto L90;
        long r49 = r23.getId();
    L91:
        r48.put(Long.valueOf(r49), r22);
        ((HashMap) r121).put(r119, r48);
        goto L92
    L90:
        r49 = 0;
    L92:
        if (r23 != null) goto L94;
    L103:
        if (r23 == null) goto L115;
        if ((r23.getStickerFeature() & 2) <= 0) goto L115;
        Map<String, Integer> r51 = this.b;
        String r52 = d0.k;
        Integer r53 = (Integer) ((HashMap) r51).get(r52);
        if (r53 == null) goto L109;
        int r54 = r53.intValue();
    L110:
        ((HashMap) this.b).put(r52, Integer.valueOf(r54 + 1));
        Map r55 = (Map) ((HashMap) this.c).get(r52);
        if (r55 != null) goto L113;
        r55 = new LinkedHashMap();
    L113:
        Map<String, Map<Long, String>> r56 = this.c;
        r55.put(Long.valueOf(r23.getId()), r22);
        ((HashMap) r56).put(r52, r55);
        goto L115
    L109:
        r54 = 0;
    L115:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_INDEPENDENT_CAMERA_MOVEMENT_PANEL.getValue().booleanValue() == false) goto L375;
        if (r23 == null) goto L375;
        if ((r23.getStickerFeature() & 128) <= 0) goto L375;
        Integer r57 = (Integer) ((HashMap) this.b).get("live_camera_move");
        if (r57 == null) goto L122;
        int r58 = r57.intValue();
    L123:
        ((HashMap) this.b).put("live_camera_move", Integer.valueOf(r58 + 1));
        Map r59 = (Map) ((HashMap) this.c).get("live_camera_move");
        if (r59 != null) goto L126;
        r59 = new LinkedHashMap();
    L126:
        Map<String, Map<Long, String>> r61 = this.c;
        r59.put(Long.valueOf(r23.getId()), r22);
        ((HashMap) r61).put("live_camera_move", r59);
        goto L375
    L122:
        r58 = 0;
        goto L123
    L94:
        if ((r23.getStickerFeature() & 16) <= 0) goto L103;
        Integer r62 = (Integer) ((HashMap) this.b).get("livebody");
        if (r62 == null) goto L98;
        int r63 = r62.intValue();
    L99:
        ((HashMap) this.b).put("livebody", Integer.valueOf(r63 + 1));
        Map r64 = (Map) ((HashMap) this.c).get("livebody");
        if (r64 != null) goto L102;
        r64 = new LinkedHashMap();
    L102:
        Map<String, Map<Long, String>> r65 = this.c;
        r64.put(Long.valueOf(r23.getId()), r22);
        ((HashMap) r65).put("livebody", r64);
        goto L103
    L98:
        r63 = 0;
        goto L99
    L81:
        r120 = 0;
        goto L83
    L78:
        r47 = 0;
        goto L79
    L64:
        r116 = 0;
        goto L66
    L61:
        r43 = 0;
        goto L62
    L47:
        r111 = 0;
        goto L49
    L44:
        r37 = 0;
        goto L45
    L127:
        Map<String, Integer> r66 = this.b;
        String r67 = d0.i;
        Integer r68 = (Integer) ((HashMap) r66).get(r67);
        if (r68 == null) goto L150;
        int r69 = r68.intValue();
        Disposable r122 = this.a;
        if (r122 != null) goto L132;
    L137:
        int r71 = r69 - 1;
        if (r23 == null) goto L140;
        int r123 = r23.getStickerFeature();
    L142:
        if ((r123 & 4) <= 0) goto L149;
        c(r71);
        Map r72 = (Map) ((HashMap) this.c).get(r67);
        if (r72 == null) goto L149;
        if (r23 == null) goto L147;
        Long r73 = Long.valueOf(r23.getId());
    L148:
        String r74 = (String) TypeIntrinsics.asMutableMap(r72).remove(r73);
        goto L149
    L147:
        r73 = null;
    L149:
        Unit r75 = Unit.INSTANCE;
        goto L150
    L140:
        r123 = 0;
        goto L142
    L132:
        if (r122.isDisposed() == true) goto L137;
        r69 = this.f;
        Disposable r124 = this.a;
        if (r124 == null) goto L136;
        r124.dispose();
        Unit r125 = Unit.INSTANCE;
    L136:
        this.a = null;
    L150:
        Map<String, Integer> r76 = this.b;
        String r77 = d0.b;
        Integer r78 = (Integer) ((HashMap) r76).get(r77);
        if (r78 == null) goto L165;
        int r79 = r78.intValue();
        if (r23 == null) goto L155;
        int r126 = r23.getStickerFeature();
    L157:
        if ((r126 & 8) <= 0) goto L164;
        ((HashMap) this.b).put(r77, Integer.valueOf(r79 - 1));
        Map r81 = (Map) ((HashMap) this.c).get(r77);
        if (r81 == null) goto L164;
        if (r23 == null) goto L162;
        Long r82 = Long.valueOf(r23.getId());
    L163:
        String r83 = (String) TypeIntrinsics.asMutableMap(r81).remove(r82);
        goto L164
    L162:
        r82 = null;
    L164:
        Unit r84 = Unit.INSTANCE;
        goto L165
    L155:
        r126 = 0;
    L165:
        Map<String, Integer> r85 = this.b;
        String r86 = d0.a;
        Integer r87 = (Integer) ((HashMap) r85).get(r86);
        if (r87 == null) goto L179;
        int r88 = r87.intValue();
        if (r23 == null) goto L170;
        int r127 = r23.getStickerFeature();
    L172:
        if ((r127 & 1) <= 0) goto L178;
        ((HashMap) this.b).put(r86, Integer.valueOf(r88 - 1));
        Map r89 = (Map) ((HashMap) this.c).get(r86);
        if (r89 == null) goto L178;
        if (r23 == null) goto L177;
        r7 = Long.valueOf(r23.getId());
    L177:
        String r91 = (String) TypeIntrinsics.asMutableMap(r89).remove(r7);
    L178:
        Unit r92 = Unit.INSTANCE;
        goto L179
    L170:
        r127 = 0;
    L179:
        if (r23 != null) goto L181;
    L188:
        if (r23 == null) goto L198;
        if ((r23.getStickerFeature() & 2) <= 0) goto L198;
        Map<String, Integer> r93 = this.b;
        String r94 = d0.k;
        Integer r95 = (Integer) ((HashMap) r93).get(r94);
        if (r95 == null) goto L194;
        int r96 = r95.intValue();
        ((HashMap) this.b).put(r94, Integer.valueOf(r96 - 1));
        Unit r97 = Unit.INSTANCE;
    L194:
        Map r98 = (Map) ((HashMap) this.c).get(r94);
        if (r98 == null) goto L198;
        String r99 = (String) r98.remove(Long.valueOf(r23.getId()));
    L198:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_INDEPENDENT_CAMERA_MOVEMENT_PANEL.getValue().booleanValue() == false) goto L375;
        if (r23 == null) goto L375;
        if ((r23.getStickerFeature() & 128) <= 0) goto L375;
        Integer r100 = (Integer) ((HashMap) this.b).get("live_camera_move");
        if (r100 == null) goto L205;
        int r101 = r100.intValue();
        ((HashMap) this.b).put("live_camera_move", Integer.valueOf(r101 - 1));
        Unit r102 = Unit.INSTANCE;
    L205:
        Map r103 = (Map) ((HashMap) this.c).get("live_camera_move");
        if (r103 == null) goto L375;
        String r104 = (String) r103.remove(Long.valueOf(r23.getId()));
        goto L375
    L181:
        if ((r23.getStickerFeature() & 16) <= 0) goto L188;
        Integer r105 = (Integer) ((HashMap) this.b).get("livebody");
        if (r105 == null) goto L185;
        int r106 = r105.intValue();
        ((HashMap) this.b).put("livebody", Integer.valueOf(r106 - 1));
        Unit r107 = Unit.INSTANCE;
    L185:
        Map r108 = (Map) ((HashMap) this.c).get("livebody");
        if (r108 == null) goto L188;
        String r109 = (String) r108.remove(Long.valueOf(r23.getId()));
        goto L188
    L209:
        if (Intrinsics.areEqual(r22, "effect_gift") == false) goto L222;
        if (r21 == false) goto L220;
        Disposable r128 = this.a;
        if (r128 != null) goto L214;
    L219:
        c(0);
        this.g++;
        goto L375
    L214:
        if (r128.isDisposed() == true) goto L219;
        Disposable r129 = this.a;
        if (r129 == null) goto L218;
        r129.dispose();
        Unit r130 = Unit.INSTANCE;
    L218:
        this.a = null;
        goto L219
    L220:
        this.g--;
        c(this.f);
        goto L375
    L222:
        if (Intrinsics.areEqual(r22, "livedigitavatar") == false) goto L300;
        if (r21 == false) goto L261;
        Integer r131 = (Integer) ((HashMap) this.b).get("livebody");
        if (r131 == null) goto L228;
        int r132 = r131.intValue();
    L229:
        ((HashMap) this.b).put("livebody", Integer.valueOf(r132 + 1));
        Unit r133 = Unit.INSTANCE;
        Integer r134 = (Integer) ((HashMap) this.b).get("theme_event");
        if (r134 == null) goto L232;
        int r135 = r134.intValue();
    L233:
        ((HashMap) this.b).put("theme_event", Integer.valueOf(r135 + 1));
        if (r23 == null) goto L239;
        Map r136 = (Map) ((HashMap) this.c).get("theme_event");
        if (r136 != null) goto L238;
        r136 = new LinkedHashMap();
    L238:
        Map<String, Map<Long, String>> r137 = this.c;
        r136.put(Long.valueOf(r23.getId()), r22);
        ((HashMap) r137).put("theme_event", r136);
    L239:
        if (r23 == null) goto L245;
        Map r138 = (Map) ((HashMap) this.c).get("livebody");
        if (r138 != null) goto L243;
        r138 = new LinkedHashMap();
    L243:
        Map<String, Map<Long, String>> r139 = this.c;
        r138.put(Long.valueOf(r23.getId()), r22);
        ((HashMap) r139).put("livebody", r138);
    L245:
        if (c0.c == false) goto L375;
        if (b() == false) goto L249;
        ALogger.i("ttlive_anchor_effect_LiveComposerRepelHelper", "repelIfNeed, isAdd = " + r21 + ", panel = " + r22 + ", isNoCameraRender == true，block repel");
        goto L375
    L249:
        Integer r140 = (Integer) ((HashMap) this.b).get(r34);
        if (r140 == null) goto L252;
        int r141 = r140.intValue();
    L253:
        ((HashMap) this.b).put(r34, Integer.valueOf(r141 + 1));
        Map r142 = (Map) ((HashMap) this.c).get(r34);
        if (r142 != null) goto L256;
        r142 = new LinkedHashMap();
    L256:
        Map<String, Map<Long, String>> r143 = this.c;
        if (r23 == null) goto L259;
        long r144 = r23.getId();
    L260:
        r142.put(Long.valueOf(r144), r22);
        ((HashMap) r143).put(r34, r142);
        goto L375
    L259:
        r144 = 0;
        goto L260
    L252:
        r141 = 0;
        goto L253
    L232:
        r135 = 0;
        goto L233
    L228:
        r132 = 0;
        goto L229
    L261:
        Integer r145 = (Integer) ((HashMap) this.b).get("livebody");
        if (r145 == null) goto L264;
        int r146 = r145.intValue();
        ((HashMap) this.b).put("livebody", Integer.valueOf(r146 - 1));
        Unit r147 = Unit.INSTANCE;
    L264:
        Integer r148 = (Integer) ((HashMap) this.b).get("theme_event");
        if (r148 == null) goto L267;
        int r149 = r148.intValue();
        ((HashMap) this.b).put("theme_event", Integer.valueOf(r149 - 1));
        Unit r150 = Unit.INSTANCE;
    L267:
        if (r23 == null) goto L271;
        Map r151 = (Map) ((HashMap) this.c).get("theme_event");
        if (r151 == null) goto L271;
        String r152 = (String) r151.remove(Long.valueOf(r23.getId()));
    L271:
        if (r23 == null) goto L276;
        Map r153 = (Map) ((HashMap) this.c).get("livebody");
        if (r153 == null) goto L276;
        String r154 = (String) r153.remove(Long.valueOf(r23.getId()));
    L276:
        if (c0.c == false) goto L375;
        if (b() == true) goto L280;
        Integer r155 = (Integer) ((HashMap) this.b).get(r34);
        if (r155 == null) goto L294;
        int r156 = r155.intValue();
        ((HashMap) this.b).put(r34, Integer.valueOf(r156 - 1));
        Unit r157 = Unit.INSTANCE;
    L294:
        Map r158 = (Map) ((HashMap) this.c).get(r34);
        if (r158 == null) goto L375;
        if (r23 == null) goto L298;
        r7 = Long.valueOf(r23.getId());
    L298:
        String r159 = (String) TypeIntrinsics.asMutableMap(r158).remove(r7);
        goto L375
    L280:
        if (LiveEffectSettings.LIVE_ANCHOR_REPEL_NO_CAMERA_FIX.getValue().booleanValue() == false) goto L290;
        Map r160 = (Map) ((HashMap) this.c).get(r34);
        if (r160 == null) goto L290;
        if (r23 == null) goto L286;
        r7 = Long.valueOf(r23.getId());
    L286:
        if (((String) TypeIntrinsics.asMutableMap(r160).remove(r7)) == null) goto L290;
        Integer r161 = (Integer) ((HashMap) this.b).get(r34);
        if (r161 == null) goto L290;
        int r162 = r161.intValue();
        ((HashMap) this.b).put(r34, Integer.valueOf(r162 - 1));
        Unit r163 = Unit.INSTANCE;
    L290:
        ALogger.i("ttlive_anchor_effect_LiveComposerRepelHelper", "repelIfNeed, isAdd = " + r21 + ", panel = " + r22 + ", isNoCameraRender == true，block repel");
        goto L375
    L300:
        if (Intrinsics.areEqual(r22, "zongyiyouxi") == false) goto L338;
        if (b() == false) goto L316;
        if (r21 == false) goto L306;
        ALogger.i("ttlive_anchor_effect_LiveComposerRepelHelper", "repelIfNeed, isAdd = " + r21 + ", panel = " + r22 + ", isNoCameraRender == true，block repel");
        goto L375
    L306:
        if (LiveEffectSettings.LIVE_ANCHOR_REPEL_NO_CAMERA_FIX.getValue().booleanValue() == false) goto L375;
        Map r164 = (Map) ((HashMap) this.c).get(r34);
        if (r164 == null) goto L375;
        if (r23 == null) goto L312;
        r7 = Long.valueOf(r23.getId());
    L312:
        if (((String) TypeIntrinsics.asMutableMap(r164).remove(r7)) == null) goto L375;
        Integer r165 = (Integer) ((HashMap) this.b).get(r34);
        if (r165 == null) goto L375;
        int r166 = r165.intValue();
        ((HashMap) this.b).put(r34, Integer.valueOf(r166 - 1));
        Unit r167 = Unit.INSTANCE;
        goto L375
    L316:
        if (r21 == false) goto L329;
        Integer r168 = (Integer) ((HashMap) this.b).get(r34);
        if (r168 == null) goto L320;
        int r169 = r168.intValue();
    L321:
        ((HashMap) this.b).put(r34, Integer.valueOf(r169 + 1));
        Unit r170 = Unit.INSTANCE;
        Map r171 = (Map) ((HashMap) this.c).get(r34);
        if (r171 != null) goto L324;
        r171 = new LinkedHashMap();
    L324:
        Map<String, Map<Long, String>> r172 = this.c;
        if (r23 == null) goto L327;
        long r173 = r23.getId();
    L328:
        r171.put(Long.valueOf(r173), r22);
        ((HashMap) r172).put(r34, r171);
        goto L375
    L327:
        r173 = 0;
        goto L328
    L320:
        r169 = 0;
        goto L321
    L329:
        Integer r174 = (Integer) ((HashMap) this.b).get(r34);
        if (r174 == null) goto L332;
        int r175 = r174.intValue();
        ((HashMap) this.b).put(r34, Integer.valueOf(r175 - 1));
        Unit r176 = Unit.INSTANCE;
    L332:
        Map r177 = (Map) ((HashMap) this.c).get(r34);
        if (r177 == null) goto L375;
        if (r23 == null) goto L336;
        r7 = Long.valueOf(r23.getId());
    L336:
        String r178 = (String) TypeIntrinsics.asMutableMap(r177).remove(r7);
        goto L375
    L338:
        if (Intrinsics.areEqual(r22, "effect_pk_interact_play") == false) goto L375;
        if (b() == false) goto L354;
        if (r21 == false) goto L344;
        ALogger.i("ttlive_anchor_effect_LiveComposerRepelHelper", "repelIfNeed, isAdd = " + r21 + ", panel = " + r22 + ", isNoCameraRender == true，block repel");
        goto L375
    L344:
        if (LiveEffectSettings.LIVE_ANCHOR_REPEL_NO_CAMERA_FIX.getValue().booleanValue() == false) goto L375;
        Map r179 = (Map) ((HashMap) this.c).get(r34);
        if (r179 == null) goto L375;
        if (r23 == null) goto L350;
        r7 = Long.valueOf(r23.getId());
    L350:
        if (((String) TypeIntrinsics.asMutableMap(r179).remove(r7)) == null) goto L375;
        Integer r180 = (Integer) ((HashMap) this.b).get(r34);
        if (r180 == null) goto L375;
        int r181 = r180.intValue();
        ((HashMap) this.b).put(r34, Integer.valueOf(r181 - 1));
        Unit r182 = Unit.INSTANCE;
        goto L375
    L354:
        if (r21 == false) goto L367;
        Integer r183 = (Integer) ((HashMap) this.b).get(r34);
        if (r183 == null) goto L358;
        int r184 = r183.intValue();
    L359:
        ((HashMap) this.b).put(r34, Integer.valueOf(r184 + 1));
        Unit r185 = Unit.INSTANCE;
        Map r186 = (Map) ((HashMap) this.c).get(r34);
        if (r186 != null) goto L362;
        r186 = new LinkedHashMap();
    L362:
        Map<String, Map<Long, String>> r187 = this.c;
        if (r23 == null) goto L365;
        long r188 = r23.getId();
    L366:
        r186.put(Long.valueOf(r188), r22);
        ((HashMap) r187).put(r34, r186);
        goto L375
    L365:
        r188 = 0;
        goto L366
    L358:
        r184 = 0;
        goto L359
    L367:
        Integer r189 = (Integer) ((HashMap) this.b).get(r34);
        if (r189 == null) goto L370;
        int r190 = r189.intValue();
        ((HashMap) this.b).put(r34, Integer.valueOf(r190 - 1));
        Unit r191 = Unit.INSTANCE;
    L370:
        Map r192 = (Map) ((HashMap) this.c).get(r34);
        if (r192 == null) goto L375;
        if (r23 == null) goto L374;
        r7 = Long.valueOf(r23.getId());
    L374:
        String r193 = (String) TypeIntrinsics.asMutableMap(r192).remove(r7);
        goto L375
    }
}
