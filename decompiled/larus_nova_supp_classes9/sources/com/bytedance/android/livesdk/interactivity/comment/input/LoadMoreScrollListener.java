package com.bytedance.android.livesdk.interactivity.comment.input;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/LoadMoreScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LoadMoreScrollListener extends RecyclerView.OnScrollListener {
    public int a;
    public int b;
    public final LinearLayoutManager c;
    public final Function0<Unit> d;
    public final Function1<Integer, Unit> e;
    public final Function2<Integer, Integer, Unit> f;

    public static final class a {
    }

    static {
    }

    public final void onScrollStateChanged(RecyclerView r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super.onScrollStateChanged(r3, r4);
        if (r4 != 0) goto L9;
        int r5 = this.c.getItemCount();
        if (this.b != 0) goto L9;
        if (this.a != (r5 - 1)) goto L9;
        this.b = 1;
        this.d.invoke();
    L9:
        this.e.invoke(Integer.valueOf(r4));
    }

    public final void onScrolled(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        this.a = this.c.findLastVisibleItemPosition();
        int r5 = this.c.findFirstVisibleItemPosition();
        this.f.invoke(Integer.valueOf(r5), Integer.valueOf(this.a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LoadMoreScrollListener(LinearLayoutManager r2, Function0<Unit> r3, Function1<? super Integer, Unit> r4, Function2<? super Integer, ? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "layoutManager");
        Intrinsics.checkNotNullParameter(r3, "loadMore");
        Intrinsics.checkNotNullParameter(r4, "scrollStateChanged");
        Intrinsics.checkNotNullParameter(r5, "visibleRangeChange");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
