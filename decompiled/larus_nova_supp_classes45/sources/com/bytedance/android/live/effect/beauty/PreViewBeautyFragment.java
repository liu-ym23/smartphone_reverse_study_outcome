package com.bytedance.android.live.effect.beauty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
import com.bytedance.android.live.effect.beauty.smallitem.LiveBeautySecondLevelFragment;
import com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyAdapter;
import com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/PreViewBeautyFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreViewBeautyFragment extends BaseFragment {
    public static final /* synthetic */ int j = 0;
    public Map<Integer, View> d;
    public LiveEffectContextFactoryDelegate$Type e;
    public String f;
    public BaseFragment g;
    public boolean h;
    public boolean i;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PreViewBeautyFragment a;

        public b(PreViewBeautyFragment r1) {
            this.a = r1;
        }

        public final void a() {
            BaseFragment r0 = this.a.g;
            if (r0 == null) goto L12;
            LiveSmallItemBeautyFragment r1 = (LiveSmallItemBeautyFragment) r0;
            if (r1.m == true) goto L7;
            return;
        L7:
            if (r1.n == false) goto L9;
            LiveSmallItemBeautyAdapter r2 = r1.T90();
            r2.l = !r1.T90().l;
            r2.notifyItemChanged(0);
            r1.n = false;
        L9:
            r1.V90("ttlive_anchor_effect_LiveSmallItemBeautyFragment_beautyPresetOperate");
            r1.m = false;
            return;
        L12:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyFragment");
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

    static {
    }

    public final void T90() {
        List<String> r0 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().U(d0.i) <= 0) goto L5;
        S90(2131388958).setVisibility(0);
        ((FrameLayout) S90(2131364078)).setAlpha(0.5f);
        ((LinearLayout) S90(2131384420)).setAlpha(0.5f);
        return;
    L5:
        S90(2131388958).setVisibility(8);
        ((FrameLayout) S90(2131364078)).setAlpha(1.0f);
        if (this.h == false) goto L16;
        BaseFragment r1 = this.g;
        boolean r2 = r1 instanceof LiveBeautySecondLevelFragment;
        if (r2 == false) goto L16;
        if (r2 == true) goto L11;
        r1 = null;
    L11:
        LiveBeautySecondLevelFragment r3 = (LiveBeautySecondLevelFragment) r1;
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.g != true) goto L20;
        ((LinearLayout) S90(2131384420)).setAlpha(1.0f);
        return;
    L20:
        return;
    L16:
        ((LinearLayout) S90(2131384420)).setAlpha(1.0f);
    }

    public PreViewBeautyFragment() {
        this.d = new LinkedHashMap();
        this.e = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.f = "";
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
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

    public final void onHiddenChanged(boolean r2) {
        super.onHiddenChanged(r2);
        if (isViewValid() == true) goto L6;
        return;
    L6:
        if (this.h == false) goto L10;
        BaseFragment r0 = this.g;
        if (r0 == null) goto L10;
        r0.onHiddenChanged(r2);
    L10:
        if (r2 == false) goto L12;
    L16:
        T90();
        return;
    L12:
        if ((this.g instanceof LiveSmallItemBeautyFragment) == false) goto L16;
        View r3 = getView();
        if (r3 == null) goto L16;
        r3.post(new b(this));
        goto L16
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        if (this.h == false) goto L5;
        ((BeautifyAdjustPercentBar) S90(2131386951)).setVisibility(0);
        ((AdjustPercentBar) S90(2131386950)).setVisibility(8);
    L6:
        LiveEffectContextFactoryDelegate$Type r13 = this.e;
        View r3 = S90(2131384420);
        if (this.h == false) goto L9;
        View r1 = S90(2131386951);
    L10:
        boolean r2 = this.i;
        if (r2 == false) goto L13;
        int r4 = 2131565916;
    L14:
        if (r2 == false) goto L16;
        int r5 = 2131565912;
    L17:
        q90.a r14 = new q90.a(r3, r1, r4, r5);
        if (this.h == false) goto L20;
        int r6 = LiveBeautySecondLevelFragment.C;
        String r7 = this.f;
        Intrinsics.checkNotNullParameter(r7, "eventPage");
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "beautyTemplate");
        LiveBeautySecondLevelFragment r15 = new LiveBeautySecondLevelFragment();
        r15.f = r3;
        r15.h = r1;
        r15.m = r7;
        r15.k = r13;
        BaseFragment r16 = r15;
    L24:
        this.g = r16;
        FragmentTransaction r17 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r17, r16, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131364078) == true) goto L28;
        r17 = r17.add(2131364078, r16);
    L28:
        r17.commitNowAllowingStateLoss();
        T90();
        S90(2131388958).setOnClickListener(l.a);
        if (this.h == false) goto L32;
        a1.k(S90(2131364078), s1.f(150.0f));
        a1.l(S90(2131364078), s1.f(24.0f));
        a1.k(S90(2131384420), s1.f(17.0f));
        a1.l(S90(2131384420), s1.f(12.0f));
        a1.n(S90(2131384420), s1.f(16.0f));
        return;
    L32:
        return;
    L20:
        int r8 = LiveSmallItemBeautyFragment.y;
        Intrinsics.checkNotNullParameter(r13, "type");
        Intrinsics.checkNotNullParameter(r14, "beautyTemplate");
        LiveSmallItemBeautyFragment r18 = new LiveSmallItemBeautyFragment();
        r18.g = r3;
        if ((r1 instanceof AdjustPercentBar) == true) goto L23;
        r1 = null;
    L23:
        r18.h = (AdjustPercentBar) r1;
        r18.i = r4;
        r18.j = r5;
        r18.k = r13;
        r18.o = r2;
        r16 = r18;
        goto L24
    L16:
        r5 = 2131565911;
        goto L17
    L13:
        r4 = 2131565915;
        goto L14
    L9:
        r1 = S90(2131386950);
        goto L10
    L5:
        ((BeautifyAdjustPercentBar) S90(2131386951)).setVisibility(8);
        ((AdjustPercentBar) S90(2131386950)).setVisibility(0);
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.i == false) goto L5;
        int r5 = 2131565885;
    L7:
        return r2.inflate(r5, r3, false);
    L5:
        r5 = 2131565884;
        goto L7
    }
}
