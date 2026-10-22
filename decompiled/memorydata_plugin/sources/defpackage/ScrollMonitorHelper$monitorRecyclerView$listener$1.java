package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"ScrollMonitorHelper$monitorRecyclerView$listener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "onScrollStateChanged", "newState", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrollMonitorHelper$monitorRecyclerView$listener$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ Ref.IntRef $currentScrollX;
    final /* synthetic */ Ref.IntRef $currentScrollY;
    final /* synthetic */ Function2<Integer, Integer, Unit> $onIdle;
    final /* synthetic */ Function2<Integer, Integer, Unit> $onScrolling;

    ScrollMonitorHelper$monitorRecyclerView$listener$1(Ref.IntRef r3, Ref.IntRef r4, Function2<? super Integer, ? super Integer, Unit> r5, Function2<? super Integer, ? super Integer, Unit> r6) {
        Function2<Integer, Integer, Unit> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        Function2<Integer, Integer, Unit> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r6, Function2.class, "com.obric.memorydata.plugin");
        this.$currentScrollX = r3;
        this.$currentScrollY = r4;
        this.$onIdle = r7;
        this.$onScrolling = r8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        if (r3 != 0) goto L5;
        Function2<Integer, Integer, Unit> r4 = this.$onIdle;
    L11:
        r4.invoke(Integer.valueOf(this.$currentScrollX.element), Integer.valueOf(this.$currentScrollY.element));
        return;
    L5:
        if (r3 != 1) goto L7;
    L9:
        r4 = this.$onScrolling;
        goto L11
    L7:
        if (r3 == 2) goto L9;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        Ref.IntRef r4 = this.$currentScrollX;
        r4.element = r1.computeHorizontalScrollOffset();
        Ref.IntRef r0 = this.$currentScrollY;
        r0.element = r1.computeVerticalScrollOffset();
    }
}
