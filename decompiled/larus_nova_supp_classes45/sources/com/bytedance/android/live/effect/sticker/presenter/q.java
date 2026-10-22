package com.bytedance.android.live.effect.sticker.presenter;

import android.util.Pair;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class q implements n {
    public boolean b;
    public boolean c;
    public boolean d;
    public final Map<String, BeautyModeInfo> e;
    public final Map<String, List<String>> f;
    public boolean g;
    public String h;
    public boolean i;
    public final List<h> j;
    public final a k;
    public final List<String> l;

    public static final class a implements ILiveEffectComposerManager.a {
        public final /* synthetic */ q a;

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.a
        public final void a() {
            q r0 = this.a;
            r0.i = false;
            Iterator r1 = ((ArrayList) r0.j).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((h) r1.next()).a();
            goto L4
        L6:
            f2.c("已切换为" + ((String) m90.b.F.c(LiveEffectContextFactoryDelegate$Type.DEFAULT).second), 0);
        }

        public a(q r1) {
            this.a = r1;
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/effect/sticker/presenter/q$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/live/effect/sticker/presenter/BeautyModeInfo;", "liveeffect-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<List<? extends BeautyModeInfo>> {
        public b() {
        }
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.n
    public final boolean c() {
        if (this.c == false) goto L6;
        return false;
    L6:
        if (this.b == true) goto L10;
        this.c = true;
        return false;
    L10:
        return this.d;
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.n
    public final boolean e() {
        if (this.g == false) goto L6;
        this.g = false;
        return true;
    L6:
        return false;
    }

    public q() {
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.h = "";
        this.j = new ArrayList();
        this.k = new a(this);
        this.l = new ArrayList();
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.n
    public final List<String> b() {
        return this.l;
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.n
    public final boolean d() {
        return this.i;
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.n
    public final String g() {
        return this.h;
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.n
    public final Map<String, BeautyModeInfo> i() {
        return this.e;
    }

    public final BeautyModeInfo j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "modeKey");
        return (BeautyModeInfo) ((LinkedHashMap) this.e).get(r2);
    }

    public final void k(LiveEffectContextFactoryDelegate$Type r9) {
        Intrinsics.checkNotNullParameter(r9, "type");
        if (this.b == false) goto L39;
        return;
    L39:
        Iterator r1 = ((List) GsonProtectorUtils.fromJson(GsonHelper.get(), GsonProtectorUtils.parse(new JsonParser(), LiveEffectSettings.LIVE_EFFECT_BEAUTY_MODE_CONFIG.getValue()).getAsJsonArray(), new b().getType())).iterator();     // Catch: Throwable -> L20
    L6:
        if (r1.hasNext() == false) goto L22;
        BeautyModeInfo r2 = (BeautyModeInfo) r1.next();     // Catch: Throwable -> L20
        if (Intrinsics.areEqual(r2.b(), "normal") == false) goto L14;
        r2.a().clear();     // Catch: Throwable -> L20
        n.a.getClass();     // Catch: Throwable -> L20
        Iterator<String> r3 = n.a.a.iterator();     // Catch: Throwable -> L20
    L12:
        if (r3.hasNext() == false) goto L14;
        String r4 = r3.next();     // Catch: Throwable -> L20
        List<i> r5 = r2.a();     // Catch: Throwable -> L20
        i r6 = new i();     // Catch: Throwable -> L20
        r6.d(r4);     // Catch: Throwable -> L20
        r6.c(com.bytedance.android.live.effect.api.u.b(r9).a().m(r4));     // Catch: Throwable -> L20
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r5.add(r6);     // Catch: Throwable -> L20
    L14:
        this.e.put(r2.b(), r2);     // Catch: Throwable -> L20
        Map<String, List<String>> r8 = this.f;     // Catch: Throwable -> L20
        String r11 = r2.b();     // Catch: Throwable -> L20
        List<i> r12 = r2.a();     // Catch: Throwable -> L20
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));     // Catch: Throwable -> L20
        Iterator<T> r14 = r12.iterator();     // Catch: Throwable -> L20
    L16:
        if (r14.hasNext() == false) goto L18;
        r13.add(((i) r14.next()).b());     // Catch: Throwable -> L20
        goto L16
    L18:
        r8.put(r11, r13);     // Catch: Throwable -> L20
    L22:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_BEAUTY_OUTER_TEST.getValue().booleanValue() == true) goto L24;
    L28:
        boolean r15 = false;
    L29:
        this.d = r15;
        m90.c<Pair<String, String>> r16 = m90.b.F;
        if (this.e.containsKey((String) r16.c(r9).first) == true) goto L37;
        this.h = (String) r16.c(r9).second;
        BeautyModeInfo r17 = (BeautyModeInfo) ((LinkedHashMap) this.e).get("normal");
        if (r17 == null) goto L35;
        String r18 = r17.c();
        if (r18 == null) goto L35;
    L36:
        r16.e(r9, new Pair("normal", r18));
        this.g = true;
    L35:
        r18 = "普通模式";
    L37:
        this.b = true;
        return;
    L24:
        if (r9 != LiveEffectContextFactoryDelegate$Type.DEFAULT) goto L28;
        if ((!this.e.isEmpty()) == false) goto L28;
        r15 = true;
        goto L29
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.n
    public final void a(h r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Intrinsics.checkNotNullParameter(r3, "panel");
        ((ArrayList) this.j).remove(r2);
        ((ArrayList) this.l).remove(r3);
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.n
    public final void f(h r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Intrinsics.checkNotNullParameter(r3, "panel");
        if (r3.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        ((ArrayList) this.j).add(r2);
        return;
    L8:
        if (((ArrayList) this.l).contains(r3) == true) goto L12;
        ((ArrayList) this.l).add(r3);
        ((ArrayList) this.j).add(r2);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.effect.sticker.presenter.n
    public final void h(String r9, String r11) {
        Intrinsics.checkNotNullParameter(r9, "newModeKey");
        Intrinsics.checkNotNullParameter(r11, "newModeName");
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r0 = com.bytedance.android.live.effect.api.u.a;
        LiveEffectContextFactoryDelegate$Type r1 = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        com.bytedance.android.live.effect.api.u.c(r1).L(r9);
        m90.c<Map<String, Double>> r2 = m90.b.d;
        Map r3 = r2.c(r1);
        m90.c<Pair<String, String>> r4 = m90.b.F;
        Object r5 = r4.c(r1).first;
        m90.c<Integer> r6 = m90.b.c;
        r3.put(r5, Double.valueOf(r6.c(r1).intValue()));
        r2.e(r1, (Map<String, Double>) r3);
        r4.e(r1, new Pair(r9, r11));
        this.i = true;
        Double r12 = r2.c(r1).get(r4.c(r1).first);
        if (r12 == null) goto L5;
        double r13 = r12.doubleValue();
    L6:
        r6.e(r1, Integer.valueOf((int) r13));
        com.bytedance.android.live.effect.api.u.c(r1).y(this.k);
        Iterator r14 = ((ArrayList) this.j).iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        ((h) r14.next()).onChange();
        goto L8
    L10:
        return;
    L5:
        r13 = 0.0d;
        goto L6
    }
}
