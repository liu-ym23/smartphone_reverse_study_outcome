package com.ss.android.lark.feed.app.tablayout;

import android.view.View;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class FeedSelectorConfig {
    public final int a;
    public final int b;
    public Function3<? super View, ? super Integer, ? super Boolean, Unit> c;
    public Function4<? super View, ? super List<? extends View>, ? super Boolean, ? super Boolean, Unit> d;
    public Function4<? super Integer, ? super List<Integer>, ? super Boolean, ? super Boolean, Unit> e;
    public Function4<? super View, ? super Integer, ? super Boolean, ? super Boolean, Boolean> f;
    public Function2<? super View, ? super Integer, Boolean> g;

    public FeedSelectorConfig() {
        this.a = 1;
        this.b = Integer.MAX_VALUE;
        this.c = FeedSelectorConfig$onStyleItemView$1.INSTANCE;
        this.d = FeedSelectorConfig$onSelectViewChange$1.INSTANCE;
        this.e = FeedSelectorConfig$onSelectIndexChange$1.INSTANCE;
        this.f = FeedSelectorConfig$onSelectItemView$1.INSTANCE;
        this.g = FeedSelectorConfig$onItemViewLongClick$1.INSTANCE;
    }
}
