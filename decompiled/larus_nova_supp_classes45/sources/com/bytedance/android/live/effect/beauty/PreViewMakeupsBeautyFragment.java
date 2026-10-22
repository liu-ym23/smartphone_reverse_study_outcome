package com.bytedance.android.live.effect.beauty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.beauty.makeups.LiveMakeupsBeautyFragment;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/PreViewMakeupsBeautyFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreViewMakeupsBeautyFragment extends BaseFragment {
    public static final /* synthetic */ int j = 0;
    public Map<Integer, View> d;
    public LiveEffectContextFactoryDelegate$Type e;
    public String f;
    public boolean g;
    public final Lazy h;
    public boolean i;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            f2.b(2131916433, 0);
        }
    }

    static {
    }

    public PreViewMakeupsBeautyFragment() {
        this.d = new LinkedHashMap();
        this.e = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.f = "";
        this.h = LazyKt.lazy(new PreViewMakeupsBeautyFragment$fragment$2(this));
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
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

    public final void T90(boolean r4) {
        if (r4 == false) goto L5;
        S90(2131388958).setOnClickListener(b.a);
        S90(2131388958).setVisibility(0);
        ((FrameLayout) S90(2131364078)).setAlpha(0.5f);
        return;
    L5:
        S90(2131388958).setVisibility(8);
        ((FrameLayout) S90(2131364078)).setAlpha(1.0f);
    }

    public final void onHiddenChanged(boolean r2) {
        super.onHiddenChanged(r2);
        ((LiveMakeupsBeautyFragment) this.h.getValue()).onHiddenChanged(r2);
        if (isViewValid() == false) goto L10;
        List<String> r3 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().U(d0.k) <= 0) goto L7;
        boolean r4 = true;
    L8:
        T90(r4);
        return;
    L7:
        r4 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        FragmentTransaction r6 = getChildFragmentManager().beginTransaction();
        LiveMakeupsBeautyFragment r7 = (LiveMakeupsBeautyFragment) this.h.getValue();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131364078) == true) goto L6;
        r6 = r6.add(2131364078, r7);
    L6:
        r6.commitNowAllowingStateLoss();
        List<String> r8 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().U(d0.k) <= 0) goto L9;
        boolean r9 = true;
    L10:
        T90(r9);
        return;
    L9:
        r9 = false;
        goto L10
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.i == false) goto L5;
        int r5 = 2131565883;
    L7:
        return r2.inflate(r5, r3, false);
    L5:
        r5 = 2131565882;
        goto L7
    }
}
