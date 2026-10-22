package com.bytedance.android.live.effect.beauty;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.avadjust.LiveColorAdjustFragment;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.beauty.body.LiveBodyBeautyFragment;
import com.bytedance.android.live.effect.beauty.filter.LiveComposerFilterFragment;
import com.bytedance.android.live.effect.beauty.presets.LiveBeautyPresetsFragment;
import com.bytedance.android.live.effect.beauty.sticker.LiveStickerBeautyFragment;
import com.bytedance.android.live.effect.sticker.presenter.n;
import com.bytedance.android.live.effect.sticker.presenter.o;
import com.bytedance.android.live.effect.template.BeautifyTemplate;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.kg;
import com.bytedance.android.livesdk.config.ul;
import com.bytedance.android.livesdk.config.w1;
import com.bytedance.android.livesdk.config.yo0;
import com.bytedance.android.livesdk.h4;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/LiveBeautifyFragmentNew;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautifyFragmentNew extends Fragment {
    public static final Map<BeautifyTemplate.BeautifyContentType, Integer> A = null;
    public Map<Integer, View> d;
    public final String e;
    public boolean f;
    public final LiveEffectContextFactoryDelegate$Type g;
    public final Map<BeautifyTemplate.BeautifyContentType, Pair<BeautifyTabItemView, Fragment>> h;
    public final boolean i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final d t;
    public final BeautifyTemplate u;
    public BeautifyTemplate.BeautifyContentType v;
    public final String w;
    public final Boolean x;
    public final Lazy y;
    public final b z;

    public static final class a {
        public static String a(BeautifyTemplate.BeautifyContentType r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "beautifyContentType");
            int r3 = e.a[r1.ordinal()];
            if (r3 != 1) goto L5;
            if (r2 == false) goto L20;
            return "beautyclassify";
        L20:
            return d0.i;
        L5:
            if (r3 == 2) goto L25;
            if (r3 == 3) goto L24;
            if (r3 != 4) goto L11;
            return "live_adjustment";
        L11:
            if (r3 == 5) goto L13;
            return "";
        L13:
            return "livebody";
        L24:
            return d0.l;
        L25:
            return d0.k;
        }
    }

    public static final class b implements com.bytedance.android.live.effect.sticker.presenter.h {
        public final /* synthetic */ LiveBeautifyFragmentNew a;

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void a() {
        }

        @Override // com.bytedance.android.live.effect.sticker.presenter.h
        public final void onChange() {
            LiveBeautifyFragmentNew r0 = this.a;
            Iterator r1 = ((LinkedHashMap) r0.h).entrySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L17;
            Map.Entry r2 = (Map.Entry) r1.next();
            BeautifyTabItemView r3 = (BeautifyTabItemView) ((Pair) r2.getValue()).getFirst();
            Map<BeautifyTemplate.BeautifyContentType, Integer> r4 = LiveBeautifyFragmentNew.A;
            String r5 = a.a((BeautifyTemplate.BeautifyContentType) r2.getKey(), r0.i);
            n.a.getClass();
            if (n.a.a.contains(r5) == false) goto L13;
            List<String> r6 = LiveEffectContext.h;
            if (o.a.d(LiveEffectContext.a.a(r0.g).b().d(), r5) == LiveEffectContext.a.a(r0.g).b().d().m(r5)) goto L13;
            if (r3 == null) goto L4;
            View r7 = r3.f;
            if (r7 == null) goto L4;
            r7.setVisibility(0);
        L13:
            if (r3 == null) goto L4;
            View r8 = r3.f;
            if (r8 == null) goto L4;
            r8.setVisibility(4);
            goto L4
        L17:
            Iterator r9 = ((LinkedHashMap) this.a.h).entrySet().iterator();
        L19:
            if (r9.hasNext() == false) goto L37;
            Map.Entry r11 = (Map.Entry) r9.next();
            Map<BeautifyTemplate.BeautifyContentType, Integer> r12 = LiveBeautifyFragmentNew.A;
            String r13 = a.a((BeautifyTemplate.BeautifyContentType) r11.getKey(), this.a.i);
            List<String> r14 = LiveEffectContext.h;
            if (LiveEffectContext.a.a(this.a.g).b().h().b().contains(r13) == true) goto L19;
            String r15 = d0.i;
            if (Intrinsics.areEqual(r13, r15) == true) goto L24;
            if (Intrinsics.areEqual(r13, "beautyclassify") == true) goto L27;
            if (Intrinsics.areEqual(r13, d0.l) == true) goto L30;
            String r16 = d0.k;
            if (Intrinsics.areEqual(r13, r16) == true) goto L33;
            if (Intrinsics.areEqual(r13, "livebody") == false) goto L19;
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(this.a.g).a(), "livebody", "LiveBodyBeautyListFragment_onBeautyModeChange");
            LiveEffectContext.a.a(this.a.g).b().p().b(null);
            goto L19
        L33:
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(this.a.g).a(), r16, "LiveMakeupsBeautyFragment_onBeautyModeChange");
            ((com.bytedance.android.live.effect.beauty.makeups.d) LiveEffectContext.a.a(this.a.g).b().f()).b(null);
            goto L19
        L30:
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(this.a.g).a(), d0.a, "LiveMakeupsBeautyFragment_onBeautyModeChange");
            LiveEffectContext.a.a(this.a.g).b().m().d(null, this.a.e);
            goto L19
        L27:
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(this.a.g).a(), r15, "LiveBeautySecondLevelFragment_onBeautyModeChange");
            com.bytedance.android.live.effect.beauty.smallitem.d.d(LiveEffectContext.a.a(this.a.g).b().l(), "beautyclassify", this.a.g, null, 8);
            goto L19
        L24:
            ILiveEffectComposerManager.f.b(LiveEffectContext.a.a(this.a.g).a(), r15, "LiveSmallItemBeautyFragment_onBeautyModeChange");
            LiveEffectContext.a.a(this.a.g).b().g().c(null, r15, LiveEffectSettings.LIVE_EFFECT_BEAUTY_PANEL_UPGRADE_CONFIG.getValue().a());
            goto L19
        }

        public b(LiveBeautifyFragmentNew r1) {
            this.a = r1;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LiveBeautifyFragmentNew a;
        public final /* synthetic */ BeautifyTemplate.BeautifyContentType b;

        public c(LiveBeautifyFragmentNew r1, BeautifyTemplate.BeautifyContentType r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            LiveBeautifyFragmentNew r0 = this.a;     // Catch: Exception -> L26
            BeautifyTemplate.BeautifyContentType r1 = this.b;     // Catch: Exception -> L26
            Map<BeautifyTemplate.BeautifyContentType, Integer> r2 = LiveBeautifyFragmentNew.A;     // Catch: Exception -> L26
            Fragment r3 = r0.X90(r1);     // Catch: Exception -> L26
            if (Build.VERSION.SDK_INT >= 22) goto L5;
            return;
        L5:
            if (this.a.S90(2131388008) != null) goto L7;
            return;
        L7:
            if ((r3 instanceof PreViewBeautyFragment) == false) goto L34;
            int r4 = ((LinearLayout) this.a.S90(2131388008)).getChildCount();     // Catch: Exception -> L26
            int r5 = 0;
        L9:
            if (r5 >= r4) goto L17;
            View r6 = ((LinearLayout) this.a.S90(2131388008)).getChildAt(r5);     // Catch: Exception -> L26
            if (r6.getId() != (-1)) goto L13;
            r6.setId(View.generateViewId());     // Catch: Exception -> L26
        L13:
            if (r5 == 0) goto L15;
            ((LinearLayout) this.a.S90(2131388008)).getChildAt(r5 - 1).setAccessibilityTraversalBefore(r6.getId());     // Catch: Exception -> L26
        L15:
            r5 = r5 + 1;     // Catch: Exception -> L26
            goto L9
        L17:
            if (this.a.S90(2131388008) != null) goto L19;
            return;
        L19:
            if (((PreViewBeautyFragment) r3).getView() == null) goto L36;
            View r7 = (View) SequencesKt.last(UtilityKotlinExtentionsKt.g((ViewGroup) this.a.S90(2131388008)));     // Catch: Exception -> L26
            View r8 = ((PreViewBeautyFragment) r3).getView();     // Catch: Exception -> L26
            if (r8 == null) goto L23;
            View r9 = r8.findViewById(2131384420);     // Catch: Exception -> L26
        L24:
            r7.setAccessibilityTraversalBefore(((LinearLayout) r9).getId());     // Catch: Exception -> L26
            return;
        L23:
            r9 = null;
            goto L24
        L36:
            return;
        L34:
            return;
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

    public static final class d implements ILiveEffectComposerManager.d {
        public final /* synthetic */ LiveBeautifyFragmentNew a;

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
        public final void a(String r1, Sticker r2) {
        }

        public d(LiveBeautifyFragmentNew r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
        public final void b(boolean r2, String r3, Sticker r4) {
            if (r2 == false) goto L7;
            String r5 = d0.k;
            if (StringUtils.equal(r3, r5) == false) goto L8;
            LiveBeautifyFragmentNew r6 = this.a;
            Map<BeautifyTemplate.BeautifyContentType, Integer> r7 = LiveBeautifyFragmentNew.A;
            r6.getClass();
            List<String> r8 = LiveEffectContext.h;
            LiveEffectContext.a.a(r6.g).b().r().p(r5, new g(r6), true);
            return;
        L8:
            return;
        }
    }

    public final void onDestroyView() {
        this.f = false;
        List<String> r0 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.g).a().g(this.t);
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    static {
        A = MapsKt.mapOf(new Pair[]{TuplesKt.to(BeautifyTemplate.BeautifyContentType.BEAUTY_TEMPLATE, 2131916378), TuplesKt.to(BeautifyTemplate.BeautifyContentType.BEAUTY, 2131916379), TuplesKt.to(BeautifyTemplate.BeautifyContentType.MAKEUPS, 2131916370), TuplesKt.to(BeautifyTemplate.BeautifyContentType.FILTER, 2131916412), TuplesKt.to(BeautifyTemplate.BeautifyContentType.AV_ADJUST, 2131916368), TuplesKt.to(BeautifyTemplate.BeautifyContentType.BODY_BEAUTY, 2131916384), TuplesKt.to(BeautifyTemplate.BeautifyContentType.STICKER, 2131916414), TuplesKt.to(BeautifyTemplate.BeautifyContentType.PRESETS, 2131916373)});
    }

    public final void U90() {
        if (((Boolean) yo0.a.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        BeautifyTabItemView r0 = Y90(BeautifyTemplate.BeautifyContentType.BODY_BEAUTY);
        if (r0 == null) goto L9;
        r0.setDotVisibility(m90.b.k.c(this.g).booleanValue());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final void W90() {
        Iterator r0 = ((LinkedHashMap) this.h).keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L24;
        BeautifyTemplate.BeautifyContentType r1 = (BeautifyTemplate.BeautifyContentType) r0.next();
        BeautifyTabItemView r2 = Y90(r1);
        if (r2 == null) goto L4;
        if (this.v != r1) goto L10;
        ?? r3 = 1;
    L11:
        TextView r4 = r2.a;
        if (r4 == null) goto L17;
        if (r3 == 0) goto L15;
        int r5 = 2131107389;
    L16:
        r4.setTextColor(s1.h(r5));
        goto L17
    L15:
        r5 = 2131107390;
    L17:
        TextView r6 = r2.a;
        if (r6 == 0) goto L20;
        r6.setTypeface(Typeface.DEFAULT, r3);
    L20:
        View r7 = r2.c;
        if (r7 == null) goto L23;
        UtilityKotlinExtentionsKt.A(r7, r3);
    L23:
        r2.d = r3;
        goto L4
    L10:
        r3 = 0;
        goto L11
    }

    public final void onDestroy() {
        List<String> r0 = LiveEffectContext.h;
        n.b.b(LiveEffectContext.a.a(this.g).b().h(), this.z);
        super.onDestroy();
    }

    public LiveBeautifyFragmentNew() {
        this.d = new LinkedHashMap();
        this.e = "";
        this.g = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.h = new LinkedHashMap();
        this.i = LiveEffectSettings.LIVE_EFFECT_BEAUTY_PANEL_UPGRADE_CONFIG.getValue().a();
        this.j = LazyKt.lazy(LiveBeautifyFragmentNew$enableAvAdjustInBeautyPanel$2.INSTANCE);
        this.k = LazyKt.lazy(LiveBeautifyFragmentNew$enableAvAdjustTeaOpt$2.INSTANCE);
        this.l = LazyKt.lazy(new LiveBeautifyFragmentNew$presetsFragment$2(this));
        this.m = LazyKt.lazy(new LiveBeautifyFragmentNew$beautyFragment$2(this));
        this.n = LazyKt.lazy(new LiveBeautifyFragmentNew$beautyTemplateFragment$2(this));
        this.o = LazyKt.lazy(new LiveBeautifyFragmentNew$makeupsBeautyFragment$2(this));
        this.p = LazyKt.lazy(new LiveBeautifyFragmentNew$filterFragment$2(this));
        this.q = LazyKt.lazy(new LiveBeautifyFragmentNew$bodyBeautyFragment$2(this));
        this.r = LazyKt.lazy(new LiveBeautifyFragmentNew$stickerFragment$2(this));
        this.s = LazyKt.lazy(new LiveBeautifyFragmentNew$adjustFragment$2(this));
        this.t = new d(this);
        this.u = new BeautifyTemplate(CollectionsKt.listOf(BeautifyTemplate.BeautifyContentType.BEAUTY));
        this.w = d0.c;
        this.x = (Boolean) h4.a.getValue();
        this.y = LazyKt.lazy(new LiveBeautifyFragmentNew$enableBeautyMode$2(this));
        this.z = new b(this);
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void V90(BeautifyTemplate.BeautifyContentType r14) {
        BeautifyTemplate.BeautifyContentType r0 = BeautifyTemplate.BeautifyContentType.BODY_BEAUTY;
        if (r14 != r0) goto L5;
        int r3 = com.bytedance.android.live.effect.utils.a.a;
        int r4 = CollectionsKt.indexOf(((LinkedHashMap) this.h).keySet(), r14) + 1;
        HashMap r5 = new HashMap();
        r5.put("click_position", String.valueOf(r4));
        com.bytedance.android.live.effect.utils.c.a("livesdk_anchor_beautybody_icon_click", r5, "");
    L5:
        View r6 = getView();
        if (r6 == null) goto L9;
        r6.post(new c(this, r14));
    L9:
        if (this.v != r14) goto L11;
        return;
    L11:
        if (r14 != r0) goto L13;
        m90.b.k.e(this.g, Boolean.FALSE);
        U90();
    L13:
        BeautifyTemplate.BeautifyContentType r1 = BeautifyTemplate.BeautifyContentType.STICKER;
        if (r14 != r1) goto L18;
        m90.c<Boolean> r7 = m90.b.l;
        r7.e(this.g, Boolean.FALSE);
        BeautifyTabItemView r2 = Y90(r1);
        if (r2 == null) goto L18;
        r2.setDotVisibility(r7.c(this.g).booleanValue());
    L18:
        FragmentTransaction r8 = getChildFragmentManager().beginTransaction();
        Iterator r9 = ((LinkedHashMap) this.h).keySet().iterator();
    L20:
        if (r9.hasNext() == false) goto L26;
        BeautifyTemplate.BeautifyContentType r11 = (BeautifyTemplate.BeautifyContentType) r9.next();
        if (r14 == r11) goto L20;
        Fragment r12 = X90(r11);
        if (r12 == null) goto L20;
        r8.hide(r12);
        goto L20
    L26:
        Fragment r13 = X90(r14);
        View r15 = S90(2131367805);
        if (r15 == null) goto L29;
        r15.setVisibility(0);
    L29:
        FrameLayout r16 = (FrameLayout) S90(2131367833);
        if (r16 == null) goto L32;
        r16.setVisibility(0);
    L32:
        List<String> r17 = LiveEffectContext.h;
        com.bytedance.android.live.effect.api.c r18 = LiveEffectContext.a.a(this.g).e();
        Intrinsics.checkNotNullParameter(r14, "beautifyContentType");
        switch(e.b[r14.ordinal()]) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            default: goto L34;
        };
    L34:
        String r19 = "";
    L41:
        HashMap<String, String> r21 = new HashMap();
        r21.put("event_page", this.e);
        Intrinsics.checkNotNullParameter(r14, "beautifyContentType");
        int[] r22 = e.c;
        String r110 = "adjust";
        if (r22[r14.ordinal()] == 1) goto L44;
        Object r111 = null;
    L45:
        if (r111 == null) goto L56;
        Intrinsics.checkNotNullParameter(r14, "type");
        if (((Boolean) this.k.getValue()).booleanValue() == false) goto L54;
        Map<? extends String, ? extends String> r112 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r14, "beautifyContentType");
        if (r22[r14.ordinal()] == 1) goto L51;
        r110 = null;
    L51:
        if (r110 != null) goto L53;
        r110 = "";
    L53:
        r112.put("tab_name", r110);
        r112.put("live_type", "video_live");
        r112.put("anchor_id", jc1.k.n(IUserService.class).user().n());
        r112.put("room_id", "");
    L55:
        r21.putAll(r112);
        goto L56
    L54:
        r112 = MapsKt.emptyMap();
    L56:
        Unit r23 = Unit.INSTANCE;
        r18.sendLog(r19, r21);
        if (r13 == null) goto L67;
        if (r13.isAdded() == false) goto L62;
        r8.show(r13);
        goto L67
    L62:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r13, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131367833) == true) goto L65;
        r8.add(2131367833, r13);
    L65:
        r8.show(r13);
    L67:
        if (((Boolean) kg.a.getValue()).booleanValue() == false) goto L69;
        r8.commitAllowingStateLoss();
    L70:
        this.v = r14;
        return;
    L69:
        r8.commitNowAllowingStateLoss();
        goto L70
    L44:
        r111 = "adjust";
        goto L45
    L35:
        r19 = "livesdk_anchor_presets_tab_show";
        goto L41
    L36:
        r19 = "livesdk_anchor_beautybody_tab_show";
        goto L41
    L37:
        r19 = "livesdk_beauty_panel_tab_show";
        goto L41
    L38:
        r19 = "livesdk_filter_tab_show";
        goto L41
    L39:
        r19 = "livesdk_makeup_tab_show";
        goto L41
    L40:
        r19 = "livesdk_beauty_tab_show";
        goto L41
    }

    public final Fragment X90(BeautifyTemplate.BeautifyContentType r2) {
        Pair r3 = (Pair) ((LinkedHashMap) this.h).get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return (Fragment) r3.getSecond();
    }

    public final BeautifyTabItemView Y90(BeautifyTemplate.BeautifyContentType r2) {
        Pair r3 = (Pair) ((LinkedHashMap) this.h).get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return (BeautifyTabItemView) r3.getFirst();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.live.effect.beauty.BeautifyTabItemView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.view.ViewGroup, com.bytedance.android.live.effect.beauty.BeautifyTabItemView] */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.view.View, com.bytedance.android.live.effect.beauty.BeautifyTabItemView] */
    public final void onViewCreated(View r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r17, "view");
        super.onViewCreated(r17, r18);
        this.f = true;
        ViewGroup.LayoutParams r4 = S90(2131367805).getLayoutParams();
        r4.height = s1.f(150.0f);
        S90(2131367805).setLayoutParams(r4);
        if (this.i == false) goto L12;
        ViewGroup.LayoutParams r5 = S90(2131367805).getLayoutParams();
        r5.height = s1.f(218.0f);
        S90(2131367805).setLayoutParams(r5);
        a1.m(S90(2131388008), s1.f(6.0f));
        ViewGroup.LayoutParams r6 = ((LinearLayout) S90(2131388008)).getLayoutParams();
        r6.height = s1.f(44.0f);
        ((LinearLayout) S90(2131388008)).setLayoutParams(r6);
        ViewGroup.LayoutParams r7 = S90(2131377891).getLayoutParams();
        if ((r7 instanceof ConstraintLayout.LayoutParams) == true) goto L7;
        r7 = null;
    L7:
        ConstraintLayout.LayoutParams r8 = (ConstraintLayout.LayoutParams) r7;
        if (r8 == null) goto L10;
        ((ViewGroup.MarginLayoutParams) r8).topMargin = s1.f(44.0f);
    L10:
        ViewGroup.LayoutParams r9 = r17.getLayoutParams();
        r9.height = s1.f(324.0f);
        r17.setLayoutParams(r9);
    L12:
        if (this.i == false) goto L23;
        if (LiveEffectSettings.LIVE_ENABLE_STICKER_BEAUTY_TEMPLATE.getValue().booleanValue() == false) goto L23;
        BeautifyTemplate r1 = this.u;
        if (r1.a == false) goto L23;
        List<BeautifyTemplate.BeautifyContentType> r2 = r1.b;
        if (r2 == null) goto L21;
        ListProtector.add(TypeIntrinsics.asMutableList(r2), 0, BeautifyTemplate.BeautifyContentType.BEAUTY_TEMPLATE);
        goto L23
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.bytedance.android.live.effect.template.BeautifyTemplate.BeautifyContentType>");
    L23:
        if (this.i == false) goto L25;
    L37:
        int r3 = -1;
    L38:
        Iterator<BeautifyTemplate.BeautifyContentType> r11 = this.u.b.iterator();
    L40:
        if (r11.hasNext() == false) goto L119;
        BeautifyTemplate.BeautifyContentType r12 = r11.next();
        if (this.h.containsKey(r12) == false) goto L50;
        Pair r13 = (Pair) ((LinkedHashMap) this.h).get(r12);
        if (r13 == null) goto L57;
        ConstraintLayout r14 = (BeautifyTabItemView) r13.getFirst();
        if (r14 == null) goto L57;
        ViewGroup r15 = UtilityKotlinExtentionsKt.p(r14);
        ?? r16 = r14;
        if (r15 == null) goto L59;
        r15.removeView(r14);
        r16 = r14;
    L59:
        if (((Boolean) this.y.getValue()).booleanValue() == false) goto L85;
        String r19 = a.a(r12, this.i);
        n.a.getClass();
        if (n.a.a.contains(r19) == false) goto L68;
        List<String> r110 = LiveEffectContext.h;
        if (o.a.d(LiveEffectContext.a.a(this.g).b().d(), r19) == LiveEffectContext.a.a(this.g).b().d().m(r19)) goto L68;
        if (r16 == 0) goto L72;
        View r21 = r16.f;
        if (r21 == null) goto L72;
        r21.setVisibility(0);
    L72:
        LinearLayout r22 = (LinearLayout) S90(2131388008);
        if (r22 == null) goto L75;
        Integer r23 = Integer.valueOf(r22.getChildCount());
    L77:
        if (r23.intValue() != 0) goto L81;
        LinearLayout r24 = (LinearLayout) S90(2131388008);
        if (r24 == 0) goto L101;
        LinearLayout.LayoutParams r111 = new LinearLayout.LayoutParams(-2, -2);
        r111.leftMargin = s1.f(12.0f);
        Unit r112 = Unit.INSTANCE;
        r24.addView(r16, r111);
    L101:
        if (r3 == (-1)) goto L106;
        if (r16 == 0) goto L106;
        ViewGroup.LayoutParams r25 = r16.getLayoutParams();
        if (r25 == null) goto L106;
        r25.width = r3;
    L106:
        Map<BeautifyTemplate.BeautifyContentType, Pair<BeautifyTabItemView, Fragment>> r26 = this.h;
        switch(f.a[r12.ordinal()]) {
            case 1: goto L117;
            case 2: goto L116;
            case 3: goto L115;
            case 4: goto L114;
            case 5: goto L113;
            case 6: goto L112;
            case 7: goto L111;
            case 8: goto L110;
            default: goto L109;
        };
    L110:
        Object r113 = (LiveBeautyPresetsFragment) this.l.getValue();
    L118:
        r26.put(r12, new Pair(r16, r113));
        goto L40
    L111:
        r113 = (LiveStickerBeautyFragment) this.r.getValue();
        goto L118
    L112:
        r113 = (LiveBodyBeautyFragment) this.q.getValue();
        goto L118
    L113:
        r113 = (LiveColorAdjustFragment) this.s.getValue();
        goto L118
    L114:
        r113 = (LiveComposerFilterFragment) this.p.getValue();
        goto L118
    L115:
        r113 = (PreViewMakeupsBeautyFragment) this.o.getValue();
        goto L118
    L116:
        r113 = (PreViewBeautyFragment) this.m.getValue();
        goto L118
    L117:
        r113 = (LiveBeautyTemplateFragment) this.n.getValue();
        goto L118
    L109:
        throw new NoWhenBranchMatchedException();
    L81:
        LinearLayout r27 = (LinearLayout) S90(2131388008);
        if (r27 == 0) goto L101;
        r27.addView(r16);
        goto L101
    L75:
        r23 = null;
    L68:
        if (r16 == 0) goto L72;
        View r28 = r16.f;
        if (r28 == null) goto L72;
        r28.setVisibility(4);
        goto L72
    L85:
        if (this.i == false) goto L98;
        LinearLayout.LayoutParams r29 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout r114 = (LinearLayout) S90(2131388008);
        if (r114 == null) goto L89;
        Integer r115 = Integer.valueOf(r114.getChildCount());
    L91:
        if (r115.intValue() != 0) goto L95;
        LinearLayout r116 = (LinearLayout) S90(2131388008);
        if (r116 == 0) goto L101;
        r29.leftMargin = s1.f(12.0f);
        Unit r117 = Unit.INSTANCE;
        r116.addView(r16, r29);
        goto L101
    L95:
        LinearLayout r118 = (LinearLayout) S90(2131388008);
        if (r118 == 0) goto L101;
        r118.addView(r16, r29);
        goto L101
    L89:
        r115 = null;
        goto L91
    L98:
        LinearLayout r31 = (LinearLayout) S90(2131388008);
        if (r31 == 0) goto L101;
        r31.addView(r16);
    L57:
        r16 = 0;
        goto L59
    L50:
        Context r119 = getContext();
        if (r119 == null) goto L57;
        ?? r120 = new BeautifyTabItemView(r119, ((Boolean) this.y.getValue()).booleanValue(), this.i, 12);
        Integer r121 = A.get(r12);
        if (r121 == null) goto L55;
        int r122 = r121.intValue();
    L56:
        r120.setTabName(r122);
        r120.setOnClickListener(new h(this, r12));
        r16 = r120;
        goto L59
    L55:
        r122 = 2131916379;
        goto L56
    L119:
        S90(2131367805).setOnClickListener(i.a);
        BeautifyTemplate.BeautifyContentType r32 = this.v;
        this.v = null;
        if (this.x.booleanValue() == false) goto L124;
        List<BeautifyTemplate.BeautifyContentType> r33 = this.u.b;
        BeautifyTemplate.BeautifyContentType r34 = BeautifyTemplate.BeautifyContentType.BEAUTY;
        if (r33.contains(r34) == false) goto L124;
    L125:
        if (r32 != null) goto L127;
        r32 = r34;
    L127:
        V90(r32);
        W90();
        this.u.b.contains(BeautifyTemplate.BeautifyContentType.FILTER);
        if (this.u.b.contains(BeautifyTemplate.BeautifyContentType.MAKEUPS) == false) goto L131;
        List<String> r35 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.g).b().r().p(d0.k, new g(this), true);
    L131:
        if (this.u.b.contains(BeautifyTemplate.BeautifyContentType.BODY_BEAUTY) == false) goto L133;
        U90();
    L133:
        List<BeautifyTemplate.BeautifyContentType> r36 = this.u.b;
        BeautifyTemplate.BeautifyContentType r37 = BeautifyTemplate.BeautifyContentType.STICKER;
        if (r36.contains(r37) == false) goto L138;
        BeautifyTabItemView r38 = Y90(r37);
        if (r38 == null) goto L138;
        r38.setDotVisibility(m90.b.l.c(this.g).booleanValue());
    L138:
        Iterator r39 = ((LinkedHashMap) this.h).keySet().iterator();
    L140:
        if (r39.hasNext() == false) goto L142;
        final BeautifyTemplate.BeautifyContentType r41 = (BeautifyTemplate.BeautifyContentType) r39.next();
        final ?? r42 = Y90(r41);
        r3.e(r42, new LiveBeautifyFragmentNew$setAccessibility$1(r42, r41));
        goto L140
    L142:
        List<String> r43 = LiveEffectContext.h;
        LiveEffectContext.a.a(this.g).a().V(this.t);
        if (Intrinsics.areEqual(((w1) ul.a.getValue()).b(), Boolean.TRUE) == false) goto L148;
        if (m90.b.D.c(LiveEffectContextFactoryDelegate$Type.DEFAULT).booleanValue() == false) goto L148;
        f2.b(2131916338, 0);
    L148:
        if (((Boolean) this.y.getValue()).booleanValue() == false) goto L162;
        n.b.a(LiveEffectContext.a.a(this.g).b().h(), this.z);
        return;
    L162:
        return;
    L124:
        r34 = (BeautifyTemplate.BeautifyContentType) CollectionsKt.first(this.u.b);
        goto L125
    L25:
        if (this.x.booleanValue() == false) goto L29;
        if (this.u.b.contains(BeautifyTemplate.BeautifyContentType.PRESETS) == false) goto L29;
    L30:
        float r44 = 60.0f;
        if (((Boolean) this.j.getValue()).booleanValue() == true) goto L33;
        r3 = s1.f(60.0f);
        goto L38
    L33:
        if (this.u.b.size() <= 4) goto L35;
        r44 = 48.0f;
    L35:
        r3 = s1.f(r44);
    L29:
        if (this.u.b.contains(BeautifyTemplate.BeautifyContentType.AV_ADJUST) == false) goto L37;
        goto L30
    }

    public static final void T90(LiveBeautifyFragmentNew r4, EffectChannelResponse r5, int r6) {
        r4.getClass();
        boolean r1 = false;
        if (r6 >= r5.getAllCategoryEffects().size()) goto L17;
        if (r6 == 30) goto L17;
        List<String> r0 = LiveEffectContext.h;
        com.bytedance.android.live.effect.beauty.makeups.a r2 = LiveEffectContext.a.a(r4.g).b().f();
        Effect r3 = (Effect) ListProtector.get(r5.getAllCategoryEffects(), r6);
        ((com.bytedance.android.live.effect.beauty.makeups.d) r2).getClass();
        Intrinsics.checkNotNullParameter(r3, NewBroadcastMonitor.STAGE.EFFECT);
        List r7 = r3.getTags();
        List r8 = r7;
        if (r8 != null) goto L10;
    L11:
        r1 = true;
    L12:
        if (r1 == false) goto L14;
    L15:
        T90(r4, r5, r6 + 1);
        return;
    L14:
        if (r7.contains("new") == false) goto L15;
        return;
    L10:
        if (r8.isEmpty() == false) goto L12;
    L17:
        if (r4.f == false) goto L24;
        BeautifyTabItemView r9 = r4.Y90(BeautifyTemplate.BeautifyContentType.MAKEUPS);
        if (r9 == null) goto L25;
        r9.setDotVisibility(false);
        return;
    L25:
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565866, r3, false);
    }
}
