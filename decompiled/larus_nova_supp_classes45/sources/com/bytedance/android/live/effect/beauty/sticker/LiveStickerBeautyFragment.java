package com.bytedance.android.live.effect.beauty.sticker;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.sticker.api.AnchorEffectApi;
import com.bytedance.android.live.effect.sticker.k;
import com.bytedance.android.live.effect.sticker.m;
import com.bytedance.android.live.effect.sticker.n;
import com.bytedance.android.live.effect.sticker.presenter.o;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\b\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/sticker/LiveStickerBeautyFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "k", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "a", "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveStickerBeautyFragment extends BaseFragment {
    public static final /* synthetic */ int o = 0;
    public Map<Integer, View> d;
    public Sticker e;
    public final Lazy f;
    public final CompositeDisposable g;
    public k h;
    public final e i;
    public final com.bytedance.android.live.effect.beauty.sticker.a j;
    public final LiveEffectContextFactoryDelegate$Type k;
    public final String l;
    public final String m;
    public final long n;

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    static {
    }

    public final LiveStickerListAdapter U90() {
        return (LiveStickerListAdapter) this.f.getValue();
    }

    public final void T90() {
        List<String> r0 = LiveEffectContext.h;
        o.a.a(LiveEffectContext.a.a(this.k).b().d(), this.l, this.j, false, false, false, 48);
    }

    public final void V90() {
        List<String> r0 = LiveEffectContext.h;
        this.e = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(this.k).a().o(d0.c));
        LiveStickerListAdapter r1 = U90();
        Sticker r2 = this.e;
        if (r2 == null) goto L5;
        long r3 = r2.getId();
    L6:
        Sticker r4 = this.e;
        long r5 = r1.a;
        r1.a = r3;
        List<Long> r6 = r1.c;
        ArrayList r7 = (ArrayList) r6;
        int r8 = r7.indexOf(Long.valueOf(r3));
        if (r4 == null) goto L12;
        if (r8 < 0) goto L12;
        if (r8 >= ((ArrayList) r1.b).size()) goto L12;
        ListProtector.set(r1.b, r8, r4);
    L12:
        List<Long> r9 = r1.c;
        ArrayList r11 = (ArrayList) r9;
        if (r11.contains(Long.valueOf(r5)) == true) goto L15;
    L17:
        List<Long> r12 = r1.c;
        ArrayList r13 = (ArrayList) r12;
        if (r13.contains(Long.valueOf(r1.a)) == false) goto L21;
        r1.notifyItemChanged(r8, 1);
        return;
    L21:
        return;
    L15:
        if (r5 == r1.a) goto L17;
        List<Long> r14 = r1.c;
        ArrayList r15 = (ArrayList) r14;
        r1.notifyItemChanged(r15.indexOf(Long.valueOf(r5)), 1);
        goto L17
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.h == null) goto L5;
        k.k.getClass();
        k.j = 0;
        k.i = false;
    L5:
        this.g.clear();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.d.clear();
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.k;
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

    public final void onHiddenChanged(boolean r1) {
        super.onHiddenChanged(r1);
        if (r1 == true) goto L6;
        V90();
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        V90();
        LiveStickerListAdapter r9 = U90();
        com.bytedance.android.live.effect.beauty.sticker.b r11 = new com.bytedance.android.live.effect.beauty.sticker.b(this);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r11, "listener");
        r9.d = r11;
        LiveStickerListAdapter r12 = U90();
        c r13 = new c(this);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "listener");
        r12.e = r13;
        View r14 = LayoutInflater.from(getContext()).inflate(2131565849, null);
        r14.setOnClickListener(new d(this));
        Context r15 = getContext();
        if (r15 == null) goto L5;
        FrameLayout r1 = new LiveDoubleColorBallAnimationView(r15);
        int r16 = r1.getResources().getDimensionPixelSize(2131168603);
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(r16, r16);
        r2.gravity = 17;
        r1.setLayoutParams(r2);
    L6:
        LoadingStatusView r3 = S90(2131387337);
        if (r3 == null) goto L9;
        r3.setBuilder(new LoadingStatusView.Builder(getContext()).setErrorView(r14).setLoadingView(r1));
    L9:
        LoadingStatusView r17 = S90(2131387337);
        if (r17 == null) goto L12;
        r17.showLoading();
    L12:
        RecyclerView r18 = S90(2131387338);
        if (r18 == null) goto L15;
        r18.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
    L15:
        RecyclerView r19 = S90(2131387338);
        if (r19 == null) goto L18;
        r19.setAdapter(U90());
    L18:
        RecyclerView r21 = S90(2131387338);
        if (r21 == null) goto L21;
        r21.addItemDecoration(new LiveBeautyStickerItemDecoration());
    L21:
        RecyclerView r22 = S90(2131387338);
        if (r22 == null) goto L24;
        r22.setHasFixedSize(true);
    L24:
        T90();
        RxUtilKt.c(xs2.b.a().b(b.class).subscribe(new f(this)), this.g);
        long r4 = this.n;
        if (r4 <= 0) goto L33;
        k.a r23 = k.k;
        e r5 = this.i;
        String r6 = String.valueOf(r4);
        r23.getClass();
        Intrinsics.checkNotNullParameter(r5, "mOnMultiAnchorEffectLoadListener");
        Intrinsics.checkNotNullParameter(r6, "roomId");
        Intrinsics.checkNotNullParameter("", "anchorId");
        if (LiveEffectSettings.LIVE_ENABLE_MULTI_ANCHOR_EFFECT_SHARE.getValue().booleanValue() == false) goto L31;
        Long r24 = StringsKt.toLongOrNull(r6);
        if (r24 == null) goto L31;
        k r25 = new k(r5, r24.longValue(), "");
    L32:
        this.h = r25;
    L31:
        r25 = null;
    L33:
        k r26 = this.h;
        if (r26 == null) goto L44;
        k.k.getClass();
        k.j = 1;
        k.i = true;
        if (LiveEffectSettings.LIVE_ENABLE_DEFAULT_MULTI_ANCHOR_EFFECT_SHARE.getValue().booleanValue() == false) goto L38;
        ((Boolean) m90.b.x.getValue()).booleanValue();
    L39:
        List<String> r27 = LiveEffectContext.h;
        Sticker r28 = (Sticker) CollectionsKt.getOrNull(LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(d0.c), 0);
        r26.c.clear();
        if (k.i == false) goto L45;
        r26.b = null;
        r26.a = ((AnchorEffectApi) com.bytedance.android.live.network.c.b().e(AnchorEffectApi.class)).getMultiAnchorEffect(r26.g).observeOn(AndroidSchedulers.mainThread()).subscribe(new m(r26), new n(r26));
        return;
    L45:
        return;
    L38:
        ((Boolean) m90.b.w.getValue()).booleanValue();
        goto L39
    L44:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public LiveStickerBeautyFragment(LiveEffectContextFactoryDelegate$Type r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "panelValue");
        Intrinsics.checkNotNullParameter(r4, "eventPage");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = 0;
        this.d = new LinkedHashMap();
        this.f = LazyKt.lazy(new LiveStickerBeautyFragment$adapter$2(this));
        this.g = new CompositeDisposable();
        this.i = new e(this);
        this.j = new com.bytedance.android.live.effect.beauty.sticker.a(this);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565855, r3, false);
    }
}
