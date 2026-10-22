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
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/LiveBeautyTemplateFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautyTemplateFragment extends BaseFragment {
    public static final /* synthetic */ int h = 0;
    public Map<Integer, View> d;
    public LiveEffectContextFactoryDelegate$Type e;
    public LiveBeautyTemplateDetailFragment f;
    public String g;

    public static final class a {
    }

    static {
    }

    public LiveBeautyTemplateFragment() {
        this.d = new LinkedHashMap();
        this.e = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.g = "";
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

    public final void onHiddenChanged(boolean r5) {
        super.onHiddenChanged(r5);
        if (isViewValid() == true) goto L5;
        return;
    L5:
        LiveBeautyTemplateDetailFragment r0 = this.f;
        if (r0 == null) goto L8;
        r0.onHiddenChanged(r5);
    L8:
        List<String> r6 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.e).a().U(d0.i) <= 0) goto L11;
    L14:
        S90(2131388958).setVisibility(0);
        ((FrameLayout) S90(2131364078)).setAlpha(0.5f);
        ((LinearLayout) S90(2131384420)).setAlpha(0.5f);
        return;
    L11:
        if (LiveEffectContext.a.a(this.e).a().U(d0.k) > 0) goto L14;
        S90(2131388958).setVisibility(8);
        ((FrameLayout) S90(2131364078)).setAlpha(1.0f);
        ((LinearLayout) S90(2131384420)).setAlpha(1.0f);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        LiveEffectContextFactoryDelegate$Type r11 = this.e;
        View r1 = S90(2131384420);
        View r3 = S90(2131386950);
        q90.a r12 = new q90.a(r1, r3, 2131565915, 2131565911);
        int r4 = LiveBeautyTemplateDetailFragment.r;
        String r5 = this.g;
        Intrinsics.checkNotNullParameter(r5, "eventPage");
        Intrinsics.checkNotNullParameter(r11, "type");
        Intrinsics.checkNotNullParameter(r12, "beautyTemplate");
        LiveBeautyTemplateDetailFragment r13 = new LiveBeautyTemplateDetailFragment();
        r13.i = r5;
        r13.f = r1;
        if ((r3 instanceof AdjustPercentBar) == true) goto L5;
        r3 = null;
    L5:
        r13.g = (AdjustPercentBar) r3;
        r13.h = r11;
        this.f = r13;
        FragmentTransaction r14 = getChildFragmentManager().beginTransaction();
        LiveBeautyTemplateDetailFragment r15 = this.f;
        Intrinsics.checkNotNull(r15);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r14, r15, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131364078) == true) goto L9;
        r14 = r14.add(2131364078, r15);
    L9:
        r14.commitNowAllowingStateLoss();
        List<String> r16 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.e).a().U(d0.i) <= 0) goto L12;
    L15:
        S90(2131388958).setVisibility(0);
        ((FrameLayout) S90(2131364078)).setAlpha(0.5f);
        ((LinearLayout) S90(2131384420)).setAlpha(0.5f);
    L16:
        S90(2131388958).setOnClickListener(k.a);
        a1.k(S90(2131364078), s1.f(140.0f));
        a1.l(S90(2131386950), s1.f(180.0f));
        a1.l(S90(2131364078), 0);
        a1.l(S90(2131384420), 0);
        Disposable r17 = com.bytedance.android.live.effect.utils.k.a;
        String r18 = this.g;
        Intrinsics.checkNotNullParameter(r18, "eventPage");
        HashMap r19 = new HashMap();
        r19.put("live_type", "video_live");
        com.bytedance.android.live.effect.utils.c.a("livesdk_beauty_model_tab_show", r19, r18);
        return;
    L12:
        if (LiveEffectContext.a.a(this.e).a().U(d0.k) > 0) goto L15;
        S90(2131388958).setVisibility(8);
        ((FrameLayout) S90(2131364078)).setAlpha(1.0f);
        ((LinearLayout) S90(2131384420)).setAlpha(1.0f);
        goto L16
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565884, r3, false);
    }
}
