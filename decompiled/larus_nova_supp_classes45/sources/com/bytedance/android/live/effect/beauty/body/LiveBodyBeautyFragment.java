package com.bytedance.android.live.effect.beauty.body;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/body/LiveBodyBeautyFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBodyBeautyFragment extends BaseFragment {
    public static final /* synthetic */ int i = 0;
    public Map<Integer, View> d;
    public LiveEffectContextFactoryDelegate$Type e;
    public LiveBodyBeautyListFragment f;
    public boolean g;
    public boolean h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Map a;

        public b(Map r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (this.a.values().contains("livedigitavatar") == false) goto L6;
            f2.b(2131916360, 0);
            return;
        L6:
            if (this.a.values().contains(d0.c) == false) goto L10;
            f2.b(2131916432, 0);
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LiveBodyBeautyFragment a;

        public c(LiveBodyBeautyFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveBodyBeautyListFragment r0 = this.a.f;     // Catch: Throwable -> L11
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.n == true) goto L7;
            return;
        L7:
            if (r0.o == false) goto L9;
            LiveBodyBeautyAdapter r1 = r0.U90();     // Catch: Throwable -> L11
            r1.m = !r0.U90().m;     // Catch: Throwable -> L11
            r1.notifyItemChanged(0);     // Catch: Throwable -> L11
            r0.o = false;     // Catch: Throwable -> L11
        L9:
            r0.X90();     // Catch: Throwable -> L11
            r0.T90();     // Catch: Throwable -> L11
            r0.n = false;     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        }
    }

    static {
    }

    public LiveBodyBeautyFragment() {
        this.d = new LinkedHashMap();
        this.e = LiveEffectContextFactoryDelegate$Type.DEFAULT;
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

    public final void T90(boolean r6) {
        if (r6 == false) goto L5;
        List<String> r7 = LiveEffectContext.h;
        Map<Long, String> r8 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().N("livebody");
        S90(2131388958).setOnClickListener(new b(r8));
        S90(2131388958).setVisibility(0);
        ((FrameLayout) S90(2131364331)).setAlpha(0.5f);
        ((LinearLayout) S90(2131384420)).setAlpha(0.5f);
        return;
    L5:
        S90(2131388958).setVisibility(8);
        ((FrameLayout) S90(2131364331)).setAlpha(1.0f);
        LiveBodyBeautyListFragment r9 = this.f;
        if (r9 != null) goto L8;
        return;
    L8:
        if (r9.g != true) goto L13;
        ((LinearLayout) S90(2131384420)).setAlpha(1.0f);
        return;
    }

    public final void onHiddenChanged(boolean r2) {
        super.onHiddenChanged(r2);
        if (isViewValid() == true) goto L5;
        return;
    L5:
        if (r2 == true) goto L9;
        View r3 = getView();
        if (r3 == null) goto L9;
        r3.post(new c(this));
    L9:
        List<String> r4 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().U("livebody") <= 0) goto L12;
        boolean r5 = true;
    L13:
        T90(r5);
        return;
    L12:
        r5 = false;
        goto L13
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        boolean r13 = this.h;
        if (r13 == false) goto L5;
        int r14 = 2131565916;
    L6:
        if (r13 == false) goto L8;
        int r15 = 2131565912;
    L9:
        boolean r2 = false;
        if (this.g == false) goto L12;
        ((BeautifyAdjustPercentBar) S90(2131364333)).setVisibility(0);
        ((AdjustPercentBar) S90(2131364332)).setVisibility(8);
        r14 = 2131565897;
        r15 = 2131565898;
    L13:
        int r0 = LiveBodyBeautyListFragment.y;
        LiveEffectContextFactoryDelegate$Type r1 = this.e;
        View r6 = S90(2131384420);
        if (this.g == false) goto L16;
        View r3 = S90(2131364333);
    L17:
        q90.a r4 = new q90.a(r6, r3, r14, r15);
        boolean r5 = this.g;
        boolean r7 = this.h;
        Intrinsics.checkNotNullParameter(r1, "type");
        Intrinsics.checkNotNullParameter(r4, "beautyTemplate");
        LiveBodyBeautyListFragment r8 = new LiveBodyBeautyListFragment();
        r8.h = r6;
        r8.i = r3;
        r8.j = r14;
        r8.k = r15;
        r8.l = r1;
        r8.m = r5;
        r8.p = r7;
        this.f = r8;
        FragmentTransaction r16 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r16, r8, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131364331) == true) goto L21;
        r16 = r16.add(2131364331, r8);
    L21:
        r16.commitNowAllowingStateLoss();
        List<String> r17 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().U("livebody") <= 0) goto L24;
        r2 = true;
    L24:
        T90(r2);
        if (this.g == false) goto L28;
        a1.k(S90(2131364331), s1.f(102.0f));
        a1.l(S90(2131364331), s1.f(32.0f));
        a1.k(S90(2131384420), s1.f(17.0f));
        a1.l(S90(2131384420), s1.f(52.0f));
        a1.n(S90(2131384420), s1.f(16.0f));
        return;
    L28:
        return;
    L16:
        r3 = S90(2131364332);
        goto L17
    L12:
        ((BeautifyAdjustPercentBar) S90(2131364333)).setVisibility(8);
        ((AdjustPercentBar) S90(2131364332)).setVisibility(0);
        goto L13
    L8:
        r15 = 2131565911;
        goto L9
    L5:
        r14 = 2131565915;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.h == false) goto L5;
        int r5 = 2131565878;
    L7:
        return r2.inflate(r5, r3, false);
    L5:
        r5 = 2131565877;
        goto L7
    }
}
