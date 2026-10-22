package com.bytedance.android.anya.dsl;

import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.anya.AnyaDSL;
import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@AnyaDSL
public final class c<STATE extends MVIState<?>, ACTION extends p> {
    public final List<d<STATE, ?, ?>> a;

    public c() {
        this.a = new ArrayList();
    }

    public static void a(c r1, final BaseMVIView r10, Function2 r11, Function3 r12, ViewPager r13) {
        Function1 r0 = new MVIPagerAdapterDSLRegistry$register$1(r10);
        List<d<STATE, ?, ?>> r14 = r1.a;
        ArrayList r15 = (ArrayList) r14;
        r15.add(new d(r11, r12, r13, r0));
    }
}
