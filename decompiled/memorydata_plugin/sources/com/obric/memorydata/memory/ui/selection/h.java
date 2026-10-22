package com.obric.memorydata.memory.ui.selection;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/memory/ui/selection/SelectionDividerDecoration;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ItemDecoration;", "provider", "Lcom/obric/memorydata/memory/ui/selection/DividerProvider;", "<init>", "(Lcom/obric/memorydata/memory/ui/selection/DividerProvider;)V", "paint", "Landroid/graphics/Paint;", "onDrawOver", "", "c", "Landroid/graphics/Canvas;", "parent", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "state", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$State;", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h extends RecyclerView.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f11397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f11398b;

    public h(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "provider");
        this.f11397a = r4;
        Paint r5 = new Paint();
        r5.setStyle(Paint.Style.FILL);
        this.f11398b = r5;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
    public void a(Canvas r17, RecyclerView r18, RecyclerView.s r19) {
        Intrinsics.checkNotNullParameter(r17, "c");
        Intrinsics.checkNotNullParameter(r18, "parent");
        Intrinsics.checkNotNullParameter(r19, "state");
        if (this.f11397a.a() == true) goto L5;
        return;
    L5:
        this.f11398b.setColor(this.f11397a.getDividerColor());
        Pair<Integer, Integer> r2 = this.f11397a.getDividerMargins();
        int r3 = ((Number) ZeusTransformUtils.preCheckCast(r2.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r2.component2(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r11 = this.f11397a.getDividerHeight();
        int r12 = r18.getPaddingLeft() + r3;
        int r5 = (r18.getWidth() - r18.getPaddingRight()) - r4;
        int r13 = r18.getChildCount() - 1;
        int r14 = 0;
    L6:
        if (r14 >= r13) goto L8;
        View r6 = r18.getChildAt(r14);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.RecyclerView.LayoutParams");
        int r8 = r6.getBottom() + ((RecyclerView.LayoutParams) ZeusTransformUtils.preCheckCast(r7, RecyclerView.LayoutParams.class, "com.obric.memorydata.plugin")).bottomMargin;
        r17.drawRect(r12, r8, r5, r8 + r11, this.f11398b);
        r14 = r14 + 1;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
    public void a(Rect r2, View r3, RecyclerView r4, RecyclerView.s r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        int r6 = r4.getChildAdapterPosition(r3);
        int r7 = r5.e();
        if (this.f11397a.a() == true) goto L5;
        return;
    L5:
        if (r6 >= (r7 - 1)) goto L9;
        r2.bottom = this.f11397a.getDividerHeight();
        return;
    }
}
