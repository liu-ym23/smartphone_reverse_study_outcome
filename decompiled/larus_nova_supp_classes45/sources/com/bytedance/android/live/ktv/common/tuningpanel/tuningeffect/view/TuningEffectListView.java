package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0010\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000bJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\b\u0010\t\u001a\u00020\bH\u0016R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectListView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "", "Lcom/bytedance/android/live/ktv/common/model/bean/h;", "tuningList", "", "setDataAndNotify", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Landroidx/lifecycle/LifecycleRegistry;", "a", "Lkotlin/Lazy;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "com/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectListView$tuningEffectCallback$2$a", "c", "getTuningEffectCallback", "()Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectListView$tuningEffectCallback$2$a;", "tuningEffectCallback", "Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectAdapter;", "d", "getTuningEffectAdapter", "()Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningeffect/view/TuningEffectAdapter;", "tuningEffectAdapter", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningEffectListView extends RecyclerView implements LifecycleOwnerCompat {
    public final Lazy a;
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a b;
    public final Lazy c;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        return (LifecycleRegistry) this.a.getValue();
    }

    private final TuningEffectAdapter getTuningEffectAdapter() {
        return (TuningEffectAdapter) this.d.getValue();
    }

    private final TuningEffectListView$tuningEffectCallback$2.a getTuningEffectCallback() {
        return (TuningEffectListView$tuningEffectCallback$2.a) this.c.getValue();
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
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
    }

    public static final /* synthetic */ TuningEffectAdapter r(TuningEffectListView r0) {
        return r0.getTuningEffectAdapter();
    }

    public static final /* synthetic */ TuningEffectListView$tuningEffectCallback$2.a t(TuningEffectListView r0) {
        return r0.getTuningEffectCallback();
    }

    public final void setDataAndNotify(List<h> r7) {
        Intrinsics.checkNotNullParameter(r7, "tuningList");
        TuningEffectAdapter r1 = getTuningEffectAdapter();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "tuningList");
        if (((Boolean) KtvSettingHelper.v0.getValue()).booleanValue() == false) goto L13;
        ((ArrayList) r1.b).clear();
        List<h> r0 = r1.b;
        List<h> r2 = r1.a;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = ((ArrayList) r2).iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r3.add(h.a((h) r4.next()));
        goto L6
    L8:
        ((ArrayList) r0).addAll(r3);
        ((ArrayList) r1.a).clear();
        List<h> r5 = r1.a;
        List<h> r8 = r7;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        r6.add(h.a((h) r9.next()));
        goto L10
    L12:
        ((ArrayList) r5).addAll(r6);
        Single.create(new com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view.a(r1)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r1), c.a);
        return;
    L13:
        ((ArrayList) r1.a).clear();
        ArrayList r11 = (ArrayList) r1.a;
        r11.addAll(r7);
        r1.notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TuningEffectListView(final ac0.b r5, Context r6) {
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        this.a = LazyKt.lazy(new TuningEffectListView$lifecycleRegistry$2(this));
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = r5.k;
        this.b = r0;
        this.c = LazyKt.lazy(new TuningEffectListView$tuningEffectCallback$2(this, r5));
        this.d = LazyKt.lazy(new TuningEffectListView$tuningEffectAdapter$2(this, r5));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(s1.f(16.0f), s1.f(14.0f), s1.f(0.0f), s1.f(10.0f));
        getLifecycleRegistry().setCurrentState(Lifecycle.State.CREATED);
        setItemAnimator(null);
        setAdapter(getTuningEffectAdapter());
        setLayoutManager(new SSLinearLayoutManager(r6, 0));
        setItemViewCacheSize(8);
        if (r0 == null) goto L5;
        r0.t(this, new d(this));
    L5:
        if (r0 == null) goto L8;
        r0.x(this, new e(this));
        return;
    }
}
