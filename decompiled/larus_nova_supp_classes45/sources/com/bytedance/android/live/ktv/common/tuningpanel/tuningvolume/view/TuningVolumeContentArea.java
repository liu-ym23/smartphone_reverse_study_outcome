package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/tuningpanel/tuningvolume/view/TuningVolumeContentArea;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TuningVolumeContentArea extends LinearLayout implements LifecycleOwnerCompat {
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a a;
    public final Map<TuningVolumeType, View> b;
    public final LifecycleRegistry c;

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c.setCurrentState(Lifecycle.State.DESTROYED);
    }

    public Lifecycle getLifecycleCompat() {
        return this.c;
    }

    public final View b(TuningVolumeType r2) {
        Intrinsics.checkNotNullParameter(r2, "volumeType");
        return getChildAt(indexOfChild((View) ((LinkedHashMap) this.b).get(r2)));
    }

    public TuningVolumeContentArea(ac0.b r7, Context r8) {
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, null, 0);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = r7.k;
        this.a = r0;
        this.b = new LinkedHashMap();
        LifecycleRegistry r2 = new LifecycleRegistry(this);
        this.c = r2;
        r2.setCurrentState(Lifecycle.State.CREATED);
        gc0.d r3 = r7.g;
        if (r3 == null) goto L5;
        r3.b(this);
    L5:
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setVisibility(0);
        gc0.d r1 = r7.g;
        if (r1 == null) goto L8;
        r1.c(this, new WeakReference(r8));
    L9:
        gc0.d r9 = r7.g;
        if (r9 == null) goto L12;
        r9.a(this);
        return;
    L12:
        if (r0 == null) goto L16;
        MutableLiveData<Boolean> r11 = r0.F();
        if (r11 == null) goto L16;
        r11.observe(this, new d(this));
    L16:
        if (r0 == null) goto L20;
        r0.L();
        return;
    L20:
        return;
    L8:
        removeAllViews();
        a(TuningVolumeType.EAR_BACK_VOLUME, new j(new e(this), getContext(), r7.m, 12));
        a(TuningVolumeType.VOCAL_VOLUME, new j(new f(this), getContext(), r7.m, 12));
        a(TuningVolumeType.ACCOMPANIMENT_VOLUME, new j(new g(this), getContext(), r7.m, 12));
        a(TuningVolumeType.TONE_VOLUME, new c(new h(this), getContext(), r7.m, 12));
        goto L9
    }

    public final void a(TuningVolumeType r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "volumeType");
        Intrinsics.checkNotNullParameter(r3, "customView");
        removeView(r3);
        addView(r3);
        this.b.put(r2, r3);
    }
}
