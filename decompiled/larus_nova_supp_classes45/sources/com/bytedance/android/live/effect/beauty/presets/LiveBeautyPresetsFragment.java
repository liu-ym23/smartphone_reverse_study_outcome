package com.bytedance.android.live.effect.beauty.presets;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.template.BeautifyTemplate;
import com.bytedance.android.live.effect.utils.LivePresetsLogger;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.config.jq;
import com.bytedance.android.livesdk.config.n21;
import com.bytedance.android.livesdk.config.qb;
import com.bytedance.android.livesdk.h4;
import com.bytedance.android.livesdk.j4;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/LiveBeautyPresetsFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautyPresetsFragment extends BaseFragment {
    public static final /* synthetic */ int C = 0;
    public final Integer A;
    public final b B;
    public LiveEffectContextFactoryDelegate$Type d;
    public String e;
    public BeautifyTemplate f;
    public boolean g;
    public View h;
    public View i;
    public View j;
    public LoadingStatusView k;
    public RecyclerView l;
    public ConstraintLayout m;
    public ImageView n;
    public boolean o;
    public BeautifyPreset p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public TextView w;
    public final CompositeDisposable x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements q {
        public final /* synthetic */ LiveBeautyPresetsFragment a;

        public b(LiveBeautyPresetsFragment r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.beauty.presets.q
        public final void onError(String r4) {
            LiveBeautyPresetsFragment r0 = this.a;
            int r1 = LiveBeautyPresetsFragment.C;
            r0.T90().getClass();
            LiveBeautyPresetsHelper.n("beautyPresetsLoadCallback onError:" + r4);
            LoadingStatusView r5 = this.a.k;
            if (r5 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("loadingView");
        L5:
            r5.showError();
        }

        @Override // com.bytedance.android.live.effect.beauty.presets.q
        public final void onSuccess(List<BeautifyPreset> r9) {
            Intrinsics.checkNotNullParameter(r9, "presetList");
            StringBuilder r0 = new StringBuilder("beautyPresetsLoadCallback onSuccess:");
            ArrayList r11 = (ArrayList) r9;
            r0.append(r11.size());
            ALogger.e("LiveBeautyPresetsFragment", r0.toString());
            List<String> r1 = LiveEffectContext.h;
            if (LiveEffectContext.a.a(this.a.d).a().W() == false) goto L5;
            LiveBeautyPresetsFragment.S90(this.a, r11);
        L6:
            LiveBeautyPresetsHelper r2 = this.a.T90();
            String r12 = "beautyPresetsLoadCallback onSuccess:" + r11.size();
            r2.getClass();
            LiveBeautyPresetsHelper.n(r12);
            return;
        L5:
            LiveBeautyPresetsFragment r3 = this.a;
            r3.getClass();
            Ref.ObjectRef r4 = new Ref.ObjectRef();
            r4.element = new AtomicBoolean(false);
            LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1 r5 = new LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1(r3, r4, r11);
            LiveEffectContext.a.a(r3.d).a().f(r5);
            r3.x.add(Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(r3, r4, r11, r5)));
            goto L6
        }
    }

    static {
    }

    public final LiveBeautyPresetsHelper T90() {
        return (LiveBeautyPresetsHelper) this.z.getValue();
    }

    public final LiveBeautyPresetsAdapter U90() {
        return (LiveBeautyPresetsAdapter) this.y.getValue();
    }

    public final void V90() {
        this.t = m90.b.a.c(this.d).booleanValue();
        this.u = m90.b.j.c(this.d).booleanValue();
        LiveBeautyPresetsHelper r0 = T90();
        Map<String, ? extends List<PresetEffect>> r1 = r0.c;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        ALogger.e("LiveBeautyPresetsFragment", "handleState: isChange = " + r3);
        if (r3 == false) goto L12;
        T90().p("");
        U90().A2(T90().a, PresetOperationType.SELECT_PRESET, -1);
    L12:
        if (r3 == true) goto L14;
    L16:
        X90(r2);
        W90(!Intrinsics.areEqual(T90().j(), ""));
        return;
    L14:
        if (((ArrayList) T90().a).size() >= this.A.intValue()) goto L16;
        r2 = true;
        goto L16
    L5:
        if ((!Intrinsics.areEqual(LiveBeautyPresetsHelper.g(r1), LiveBeautyPresetsHelper.g(r0.f()))) == true) goto L8;
        r3 = false;
        goto L9
    }

    public LiveBeautyPresetsFragment() {
        this.d = LiveEffectContextFactoryDelegate$Type.DEFAULT;
        this.e = "";
        BeautifyTemplate r0 = new BeautifyTemplate(CollectionsKt.mutableListOf(new BeautifyTemplate.BeautifyContentType[]{BeautifyTemplate.BeautifyContentType.BEAUTY, BeautifyTemplate.BeautifyContentType.MAKEUPS, BeautifyTemplate.BeautifyContentType.FILTER}));
        int r1 = n21.a;
        if (n21.a.a() == false) goto L14;
        Integer r2 = (Integer) jq.a.getValue();
        if (r2.intValue() >= 0) goto L7;
    L8:
        r2 = Integer.valueOf(r0.b.size());
    L9:
        List<BeautifyTemplate.BeautifyContentType> r5 = r0.b;
        if (r5 == null) goto L13;
        ListProtector.add(TypeIntrinsics.asMutableList(r5), r2.intValue(), BeautifyTemplate.BeautifyContentType.BODY_BEAUTY);
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.bytedance.android.live.effect.template.BeautifyTemplate.BeautifyContentType>");
    L7:
        if (r2.intValue() <= r0.b.size()) goto L9;
    L14:
        Integer r3 = (Integer) qb.a.getValue();
        if (r3 != null) goto L18;
    L19:
        List<BeautifyTemplate.BeautifyContentType> r4 = r0.b;
        if (r4 == null) goto L23;
        TypeIntrinsics.asMutableList(r4).add(BeautifyTemplate.BeautifyContentType.AV_ADJUST);
    L25:
        if (((Boolean) h4.a.getValue()).booleanValue() == false) goto L31;
        List<BeautifyTemplate.BeautifyContentType> r6 = r0.b;
        if (r6 == null) goto L30;
        ListProtector.add(TypeIntrinsics.asMutableList(r6), 0, BeautifyTemplate.BeautifyContentType.PRESETS);
        goto L31
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.bytedance.android.live.effect.template.BeautifyTemplate.BeautifyContentType>");
    L31:
        this.f = r0;
        this.v = true;
        this.x = new CompositeDisposable();
        this.y = LazyKt.lazy(new LiveBeautyPresetsFragment$presetsAdapter$2(this));
        this.z = LazyKt.lazy(new LiveBeautyPresetsFragment$helper$2(this));
        this.A = (Integer) j4.a.getValue();
        this.B = new b(this);
        return;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableList<com.bytedance.android.live.effect.template.BeautifyTemplate.BeautifyContentType>");
    L18:
        if (r3.intValue() == 0) goto L25;
        goto L19
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onDestroy() {
        super.onDestroy();
        this.x.clear();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onPause() {
        super.onPause();
        Long r0 = LivePresetsLogger.a;
        LivePresetsLogger.c(((ArrayList) T90().a).size());
        U90().B2(false);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onResume() {
        super.onResume();
        Long r0 = LivePresetsLogger.a;
        LivePresetsLogger.a = Long.valueOf(System.currentTimeMillis());
    }

    public final void W90(boolean r4) {
        T90().getClass();
        LiveBeautyPresetsHelper.n("updateResetState:canReset:" + r4);
        if (r4 == false) goto L11;
        View r5 = this.i;
        if (r5 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("resetView");
    L7:
        r5.setClickable(true);
        View r6 = this.i;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("resetView");
    L10:
        r6.setAlpha(1.0f);
        return;
    L11:
        View r7 = this.i;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("resetView");
    L14:
        r7.setClickable(false);
        View r8 = this.i;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("resetView");
    L17:
        r8.setAlpha(0.5f);
    }

    public final void X90(boolean r4) {
        T90().getClass();
        LiveBeautyPresetsHelper.n("updateSaveState:canSave:" + r4);
        this.v = r4;
        ImageView r0 = this.n;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivSaveView");
    L5:
        if (r4 == false) goto L7;
        int r5 = 2131250491;
    L8:
        r0.setImageResource(r5);
        return;
    L7:
        r5 = 2131250490;
        goto L8
    }

    public final void onHiddenChanged(boolean r5) {
        super.onHiddenChanged(r5);
        if (r5 == false) goto L5;
        Long r0 = LivePresetsLogger.a;
        LivePresetsLogger.c(((ArrayList) T90().a).size());
    L7:
        if (this.o == true) goto L10;
        return;
    L10:
        if (r5 == true) goto L12;
        LiveBeautyPresetsHelper r1 = T90();
        String r6 = "onHiddenChanged:" + r5 + ",initialBeautySwitchState:" + this.t + ",initialBodyBeautySwitchState:" + this.u;
        r1.getClass();
        LiveBeautyPresetsHelper.n(r6);
        V90();
        return;
    L12:
        if (U90().c == false) goto L14;
        U90().B2(false);
    L14:
        LiveBeautyPresetsHelper r2 = T90();
        String r7 = "onHiddenChanged:" + r5 + ",selectedPreset:" + this.p + ",isReset:" + this.q + ",beautySwitchChanged:" + this.r + ",bodyBeautySwitchChanged:" + this.s;
        r2.getClass();
        LiveBeautyPresetsHelper.n(r7);
        if (this.p == null) goto L17;
    L18:
        xs2.b.a().post(new n90.b(d0.i, this.r));
        xs2.b.a().post(new n90.b("livebody", this.s));
    L19:
        this.q = false;
        this.r = false;
        this.s = false;
        return;
    L17:
        if (this.q == false) goto L19;
    L5:
        Long r3 = LivePresetsLogger.a;
        LivePresetsLogger.a = Long.valueOf(System.currentTimeMillis());
        goto L7
    }

    public static final void S90(LiveBeautyPresetsFragment r5, List r6) {
        r5.o = true;
        ConstraintLayout r0 = r5.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("savePresetView");
    L5:
        int r1 = 0;
        r0.setVisibility(0);
        View r2 = r5.i;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("resetView");
    L8:
        r2.setVisibility(0);
        LoadingStatusView r3 = r5.k;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L11:
        r3.setVisibility(8);
        r5.V90();
        r5.U90().A2(r6, PresetOperationType.INIT, -1);
        if (r6.isEmpty() == false) goto L17;
        r5.T90().getClass();
        LiveBeautyPresetsHelper.n("beautyPresetsLoadCallback onSuccess:presetList.isEmpty()");
        TextView r7 = r5.w;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("remindView");
    L16:
        r7.setVisibility(0);
        return;
    L17:
        Iterator r4 = r6.iterator();
    L19:
        if (r4.hasNext() == false) goto L24;
        if (Intrinsics.areEqual(((BeautifyPreset) r4.next()).getPresetId(), r5.T90().j()) == true) goto L25;
        r1 = r1 + 1;
    L25:
        if (r1 == (-1)) goto L38;
        RecyclerView r8 = r5.l;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L29:
        r8.scrollToPosition(r1);
        if (r1 != 0) goto L32;
        String r9 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L33:
        Long r11 = LivePresetsLogger.a;
        LivePresetsLogger.a(((BeautifyPreset) ListProtector.get(r6, r1)).getPresetName(), GsonProtectorUtils.toJson(GsonHelper.get(), ((BeautifyPreset) ListProtector.get(r6, r1)).getEffectsByPanel()), null, r9, 4);
        return;
    L32:
        r9 = "0";
        goto L33
    L38:
        return;
    L24:
        r1 = -1;
        goto L25
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super.onViewCreated(r6, r7);
        T90().getClass();
        LiveBeautyPresetsHelper.n("onViewCreated");
        this.i = r6.findViewById(2131384420);
        this.j = r6.findViewById(2131384418);
        TextView r8 = (TextView) r6.findViewById(2131384419);
        this.w = (TextView) r6.findViewById(2131391143);
        this.k = r6.findViewById(2131379091);
        View r9 = LayoutInflater.from(getContext()).inflate(2131565940, null);
        r9.setOnClickListener(new f(this));
        LoadingStatusView r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L5:
        r0.setBuilder(LoadingStatusView.Builder.createDefaultBuilder(getContext()).setErrorView(r9).setUseProgressBar(getResources().getDimensionPixelSize(2131168603)));
        LoadingStatusView r11 = this.k;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadingView");
    L8:
        r11.showLoading();
        RecyclerView r12 = r6.findViewById(2131382885);
        this.l = r12;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L11:
        r12.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView r13 = this.l;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L14:
        r13.setAdapter(U90());
        View r14 = this.i;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("resetView");
    L17:
        r14.setOnClickListener(new g(this));
        this.m = r6.findViewById(2131385110);
        this.n = (ImageView) r6.findViewById(2131376572);
        ConstraintLayout r15 = this.m;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("savePresetView");
    L20:
        r15.setOnClickListener(new h(this));
        final GestureDetector r16 = new GestureDetector(getContext(), new j(this));
        RecyclerView r17 = this.l;
        if (r17 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L23:
        r17.addOnItemTouchListener(new LiveBeautyPresetsFragment$initView$4(r16));
        View r18 = this.h;
        if (r18 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L26:
        r18.setOnClickListener(new i(this));
        LiveBeautyPresetsHelper r19 = T90();
        b r21 = this.B;
        r19.getClass();
        TTExecutors.getNormalExecutor().submit(new p(r19, r21));
        List<String> r22 = LiveEffectContext.h;
        if (((CopyOnWriteArrayList) LiveEffectContext.a.a(this.d).b().g().b).isEmpty() == false) goto L30;
        LiveSmallItemBeautyHelper r23 = LiveEffectContext.a.a(this.d).b().g();
        this.f.getClass();
        LiveSmallItemBeautyHelper.d(r23, null, 11);
    L30:
        if (((com.bytedance.android.live.effect.beauty.makeups.d) LiveEffectContext.a.a(this.d).b().f()).a.isEmpty() == false) goto L33;
        com.bytedance.android.live.effect.beauty.makeups.a r24 = LiveEffectContext.a.a(this.d).b().f();
        this.f.getClass();
        ((com.bytedance.android.live.effect.beauty.makeups.d) r24).b(null);
    L33:
        if (((ArrayList) LiveEffectContext.a.a(this.d).b().m().b).isEmpty() == false) goto L36;
        LiveEffectContext.a.a(this.d).b().m().d(null, this.e);
    L36:
        if (CollectionsKt.toList(LiveEffectContext.a.a(this.d).b().p().a).isEmpty() == false) goto L38;
        LiveEffectContext.a.a(this.d).b().p().b(null);
    L38:
        Integer r25 = (Integer) qb.a.getValue();
        if (r25 == null) goto L44;
        if (r25.intValue() != 0) goto L44;
        return;
    L44:
        if (((CopyOnWriteArrayList) LiveEffectContext.a.a(this.d).b().n().b).isEmpty() == false) goto L48;
        com.bytedance.android.live.effect.avadjust.l.b(LiveEffectContext.a.a(this.d).b().n(), null);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        if (this.g == false) goto L5;
        int r5 = 2131565871;
    L6:
        View r6 = r2.inflate(r5, r3, false);
        this.h = r6;
        if (r6 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L9:
        return r6;
    L5:
        r5 = 2131565870;
        goto L6
    }
}
