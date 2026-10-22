package com.bytedance.android.anya;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.internal.DelegatingMVIBindingImpl;
import com.bytedance.android.anya.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/anya/MVIViewPagerAdapter;", "Lcom/bytedance/android/anya/MVIState;", "STATE", "Lcom/bytedance/android/anya/p;", "ACTION", "Landroidx/viewpager/widget/PagerAdapter;", "runtime_release"}, k = 1, mv = {1, 4, 0})
public class MVIViewPagerAdapter<STATE extends MVIState<?>, ACTION extends p> extends PagerAdapter {
    public List<? extends STATE> a;
    public final Map<STATE, DelegatingMVIBindingImpl<STATE, ACTION, c<STATE, ACTION>>> b;
    public final BaseMVIView<?, ?> c;
    public final Function3<ViewGroup, Integer, Integer, c<STATE, ACTION>> d;

    public int f(int r1) {
        return 0;
    }

    public final int getCount() {
        return this.a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object g(r0 r1) {
        return ((com.bytedance.android.anya.internal.c) r1).c();
    }

    public int getItemPosition(Object r10) {
        h0 r11 = (h0) r10;
        Integer r0 = Integer.valueOf(CollectionsKt.indexOf(this.a, r11.e));
        if (r0.intValue() < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L15;
        int r12 = r0.intValue();
        if (f(r12) == r11.g) goto L14;
        return -2;
    L14:
        return r12;
    L15:
        return -2;
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MVIViewPagerAdapter(BaseMVIView<?, ?> r1, Function3<? super ViewGroup, ? super Integer, ? super Integer, ? extends c<STATE, ACTION>> r10) {
        this.c = r1;
        this.d = r10;
        this.a = CollectionsKt.emptyList();
        this.b = new LinkedHashMap();
    }

    public Object instantiateItem(final ViewGroup r10, final int r11) {
        final MVIState r0 = (MVIState) ListProtector.get(this.a, r11);
        com.bytedance.android.anya.internal.m<?, ACTION> r12 = this.c.b;
        if (r12 == null) goto L7;
        BaseMVIView r13 = (BaseMVIView) this.d.invoke(r10, Integer.valueOf(r11), Integer.valueOf(f(r11)));
        h0 r14 = new h0(r12, r13, r0, f(r11), new AnonymousClass1(r0, r11, r10));
        this.b.put((STATE) r0, r14);
        r14.a();
        ((c) r13).q(true);
        return r14;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.internal.MVIBindingExt<*, ACTION>");
    }

    public boolean isViewFromObject(View r1, Object r10) {
        VIEW r11 = ((DelegatingMVIBindingImpl) r10).d;
        if (r11 == 0) goto L10;
        if (((c) r11).k != r1) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.BaseMVIPagerItem<*, *>");
    }

    public void destroyItem(ViewGroup r10, int r11, Object r12) {
        DelegatingMVIBindingImpl r13 = (DelegatingMVIBindingImpl) r12;
        STATE r14 = r13.e;
        r13.unbind();
        Map<STATE, DelegatingMVIBindingImpl<STATE, ACTION, c<STATE, ACTION>>> r0 = this.b;
        if (r0 == null) goto L11;
        TypeIntrinsics.asMutableMap(r0).remove(r14);
        VIEW r15 = r13.d;
        if (r15 == 0) goto L9;
        r10.removeView(((c) r15).k);
        return;
    L9:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.android.anya.BaseMVIPagerItem<*, *>");
    L11:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }
}
