package com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Landroidx/lifecycle/LifecycleRegistry;", "a", "Lkotlin/Lazy;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Lbc0/a;", "e", "getTuningButtonInnerCallback", "()Lbc0/a;", "tuningButtonInnerCallback", "Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListAdapter;", "f", "getTuningButtonListAdapter", "()Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningbutton/view/TuningButtonListAdapter;", "tuningButtonListAdapter", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningButtonListView extends RecyclerView implements LifecycleOwnerCompat {
    public static final /* synthetic */ int h = 0;
    public final Lazy a;
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a b;
    public final ec0.a c;
    public final CompositeDisposable d;
    public final Lazy e;
    public final Lazy f;
    public final ac0.b g;

    public static final class a {
    }

    static {
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        return (LifecycleRegistry) this.a.getValue();
    }

    private final bc0.a getTuningButtonInnerCallback() {
        return (bc0.a) this.e.getValue();
    }

    private final TuningButtonListAdapter getTuningButtonListAdapter() {
        return (TuningButtonListAdapter) this.f.getValue();
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    public final void v() {
        ec0.a r0 = this.c;
        final Boolean r1 = null;
        if (r0 == null) goto L5;
        final Boolean r2 = Boolean.valueOf(r0.b());
    L6:
        ec0.a r3 = this.c;
        if (r3 == null) goto L9;
        r1 = Boolean.valueOf(r3.h());
    L9:
        getTuningButtonListAdapter().m2(new TuningButtonListView$handleScoreSwitchChanged$1(r2, r1), TuningButtonType.SCORE_ITEM, false);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public Lifecycle getLifecycleCompat() {
        return getLifecycleRegistry();
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getLifecycleRegistry().setCurrentState(Lifecycle.State.STARTED);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
        bc0.b r0 = this.g.f;
        if (r0 == null) goto L5;
        r0.clearData();
    L5:
        this.d.clear();
    }

    public final void u() {
        getTuningButtonListAdapter().m2(new TuningButtonListView$handleOriginSwitchChanged$1(this), TuningButtonType.ORIGIN_ITEM, false);
    }

    public static final /* synthetic */ bc0.a r(TuningButtonListView r0) {
        return r0.getTuningButtonInnerCallback();
    }

    public static final /* synthetic */ TuningButtonListAdapter t(TuningButtonListView r0) {
        return r0.getTuningButtonListAdapter();
    }

    public TuningButtonListView(ac0.b r23, Context r24) {
        Intrinsics.checkNotNullParameter(r23, "config");
        Intrinsics.checkNotNullParameter(r24, "context");
        super(r24);
        this.g = r23;
        this.a = LazyKt.lazy(new TuningButtonListView$lifecycleRegistry$2(this));
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r3 = r23.k;
        this.b = r3;
        ec0.a r4 = r23.l;
        this.c = r4;
        this.d = new CompositeDisposable();
        this.e = LazyKt.lazy(new TuningButtonListView$tuningButtonInnerCallback$2(this));
        this.f = LazyKt.lazy(new TuningButtonListView$tuningButtonListAdapter$2(this));
        getLifecycleRegistry().setCurrentState(Lifecycle.State.CREATED);
        bc0.b r5 = r23.f;
        if (r5 == null) goto L5;
        r5.b(this);
    L5:
        setAdapter(getTuningButtonListAdapter());
        bc0.b r6 = r23.f;
        if (r6 == null) goto L8;
        int r7 = r6.c();
    L9:
        GridLayoutManager r8 = new GridLayoutManager(r24, r7, 1, false);
        r8.setSpanSizeLookup(new AnonymousClass1(this));
        setLayoutManager(r8);
        bc0.b r9 = r23.f;
        if (r9 == null) goto L12;
        r9.a(getTuningButtonListAdapter());
    L16:
        bc0.b r1 = r23.f;
        if (r1 == null) goto L19;
        r1.d(getTuningButtonListAdapter(), new WeakReference(r24), this);
        return;
    L19:
        if (r3 == null) goto L21;
        r3.i();
    L21:
        u();
        if (r4 == null) goto L24;
        r4.f(this, new b(this));
    L24:
        v();
        if (r4 == null) goto L29;
        r4.r(this, new c(this));
        return;
    L29:
        return;
    L12:
        TuningButtonListAdapter r11 = getTuningButtonListAdapter();
        ArrayList r12 = new ArrayList();
        r12.add(new ac0.a(TuningButtonType.ORIGIN_ITEM, s1.B(2131918604), false, false, 0.0f, 60));
        r12.add(new ac0.a(TuningButtonType.SCORE_ITEM, s1.B(2131918335), false, false, 0.0f, 60));
        if (r3 == null) goto L15;
        r3.i();
    L15:
        Unit r13 = Unit.INSTANCE;
        r11.y2(r12);
        goto L16
    L8:
        r7 = 2;
        goto L9
    }
}
