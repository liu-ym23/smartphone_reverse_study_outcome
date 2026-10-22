package com.ss.android.lark.feed.app.tablayout;

import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class FeedTabLayoutConfig extends FeedSelectorConfig {
    public final RefactoredFeedTabLayout h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public final h n;
    public int o;
    public final Function2<? super View, ? super Integer, ? extends TextView> p;
    public final Function3<? super Integer, ? super Integer, ? super Float, Integer> q;

    public FeedTabLayoutConfig(RefactoredFeedTabLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "tabLayout");
        this.h = r2;
        this.i = true;
        this.k = -1;
        this.l = ColorProtector.parseColor("#999999");
        this.n = new h();
        this.o = -1;
        this.p = new FeedTabLayoutConfig$onGetTextStyleView$1(this);
        this.q = new FeedTabLayoutConfig$onGetGradientIndicatorColor$1(this);
        Function3<View, Integer, Boolean, Unit> r3 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.c = r3;
        Function4<Integer, List<? extends Integer>, Boolean, Boolean, Unit> r4 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.e = r4;
    }
}
