package com.bytedance.android.live.effect.avadjust.lens;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/lens/LiveLensFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "i", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLensFragment extends BaseFragment {
    public static final /* synthetic */ int k = 0;
    public Map<Integer, View> d;
    public Sticker e;
    public final int f;
    public final Lazy g;
    public final List<LensTabItemView> h;
    public final LiveEffectContextFactoryDelegate$Type i;
    public final String j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onPause() {
        LiveLensAdapter r0 = (LiveLensAdapter) this.g.getValue();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContext.a.a(r0.h).b().g().e(r0.f);
        super.onPause();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onResume() {
        super.onResume();
        LiveLensAdapter r0 = (LiveLensAdapter) this.g.getValue();
        r0.getClass();
        List<String> r1 = LiveEffectContext.h;
        LiveEffectContext.a.a(r0.h).b().g().a(r0.f);
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.i;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroy() {
        super.onDestroy();
    }

    public LiveLensFragment(LiveEffectContextFactoryDelegate$Type r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(null, "eventPage");
        this.i = r3;
        this.j = null;
        this.d = new LinkedHashMap();
        this.f = 2131565886;
        this.g = LazyKt.lazy(new LiveLensFragment$lensAdapter$2(this));
        this.h = new ArrayList();
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

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        ((AdjustPercentBar) S90(2131367174)).c(s1.h(2131107407), s1.h(2131107403), s1.h(2131107402));
        ((AdjustPercentBar) S90(2131367174)).setOnLevelChangeListener(new c(this));
        S90(2131386948).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        S90(2131386948).setAdapter((LiveLensAdapter) this.g.getValue());
    }

    public final void T90(String r4, String r5, HashMap<String, String> r6) {
        List<String> r0 = LiveEffectContext.h;
        com.bytedance.android.live.effect.api.c r1 = LiveEffectContext.a.a(this.i).e();
        r6.put("event_page", this.j);
        r6.put("effect_name", r5);
        Unit r7 = Unit.INSTANCE;
        r1.sendLog(r4, r6);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565881, r3, false);
    }
}
