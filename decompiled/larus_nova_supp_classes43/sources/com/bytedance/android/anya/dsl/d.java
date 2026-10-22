package com.bytedance.android.anya.dsl;

import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.MVIViewPagerAdapter;
import com.bytedance.android.anya.i0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.t0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d<SUPER_STATE extends MVIState<?>, PAGE_STATE extends MVIState<?>, PAGE_ACTION extends p> {
    public final Function2<i0<SUPER_STATE>, SUPER_STATE, t0<SUPER_STATE, PAGE_STATE>> a;
    public final Function3<ViewGroup, Integer, Integer, com.bytedance.android.anya.c<PAGE_STATE, PAGE_ACTION>> b;
    public final ViewPager c;
    public final Function1<Function3<? super ViewGroup, ? super Integer, ? super Integer, ? extends com.bytedance.android.anya.c<PAGE_STATE, PAGE_ACTION>>, MVIViewPagerAdapter<PAGE_STATE, PAGE_ACTION>> d;

    public d(Function2 r1, Function3 r10, ViewPager r11, Function1 r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
