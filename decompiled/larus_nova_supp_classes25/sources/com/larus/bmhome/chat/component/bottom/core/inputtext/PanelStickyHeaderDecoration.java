package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0018J\u001f\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/PanelStickyHeaderDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "headerTitleAt", "Lkotlin/Function1;", "", "", "createHeaderView", "Landroid/view/ViewGroup;", "Landroid/widget/TextView;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "headerView", "boundTitle", "", "onDrawOver", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "findHeaderPosition", "firstVisiblePosition", "(I)Ljava/lang/Integer;", "findNextHeaderTop", "currentHeaderPosition", "(Landroidx/recyclerview/widget/RecyclerView;I)Ljava/lang/Integer;", "layoutHeader", "header", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PanelStickyHeaderDecoration extends RecyclerView.ItemDecoration {
    public final Function1<Integer, CharSequence> a;
    public final Function1<ViewGroup, TextView> b;
    public TextView c;
    public String d;

    /* JADX WARN: Multi-variable type inference failed */
    public PanelStickyHeaderDecoration(Function1<? super Integer, ? extends CharSequence> r2, Function1<? super ViewGroup, ? extends TextView> r3) {
        Intrinsics.checkNotNullParameter(r2, "headerTitleAt");
        Intrinsics.checkNotNullParameter(r3, "createHeaderView");
        this.a = r2;
        this.b = r3;
    }

    public final void onDrawOver(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter(r12, "state");
        if (r12.isPreLayout() == false) goto L5;
        return;
    L5:
        if (r11.getChildCount() == 0) goto L71;
        LinearLayoutManager r13 = r11.getLayoutManager();
        Integer r1 = null;
        if ((r13 instanceof LinearLayoutManager) == false) goto L10;
        LinearLayoutManager r14 = r13;
    L11:
        if (r14 != null) goto L13;
        return;
    L13:
        int r0 = r14.findFirstVisibleItemPosition();
        if (r0 != (-1)) goto L16;
        return;
    L16:
        if ((-1) >= r0) goto L21;
        if (this.a.invoke(Integer.valueOf(r0)) != null) goto L19;
        r0 = r0 - 1;
        goto L16
    L19:
        Integer r2 = Integer.valueOf(r0);
    L22:
        if (r2 == null) goto L69;
        int r3 = r2.intValue();
        View r15 = r14.findViewByPosition(r3);
        if (r15 != null) goto L26;
    L28:
        CharSequence r16 = (CharSequence) this.a.invoke(Integer.valueOf(r3));
        if (r16 == null) goto L70;
        String r17 = r16.toString();
        if (r17 == null) goto L72;
        TextView r4 = this.c;
        if (r4 != null) goto L37;
        r4 = (TextView) this.b.invoke(r11);
        r4.setBackgroundColor(v19.c.a(2130970534, r11.getContext(), 2131102545));
        this.c = r4;
        nda.d.a().wa(r4);
    L37:
        if (Intrinsics.areEqual(this.d, r17) == true) goto L39;
        r4.setText(r17);
        this.d = r17;
    L39:
        int r18 = (r11.getWidth() - r11.getPaddingLeft()) - r11.getPaddingRight();
        int r5 = 0;
        if (r4.isLayoutRequested() == false) goto L42;
    L44:
        r4.measure(View.MeasureSpec.makeMeasureSpec(r18, 1073741824), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(r11.getHeight(), 1073741824), r11.getPaddingTop() + r11.getPaddingBottom(), r4.getLayoutParams().height));
        r4.layout(0, 0, r4.getMeasuredWidth(), r4.getMeasuredHeight());
    L45:
        int r19 = r11.getChildCount();
        int r6 = 0;
    L46:
        if (r6 >= r19) goto L57;
        View r7 = r11.getChildAt(r6);
        int r8 = r11.getChildAdapterPosition(r7);
        if (r8 == (-1)) goto L56;
        if (r8 <= r3) goto L56;
        if (this.a.invoke(Integer.valueOf(r8)) == null) goto L56;
        if (r1 == null) goto L54;
        int r9 = r1.intValue();
    L55:
        r1 = Integer.valueOf(Math.min(r9, r7.getTop()));
        goto L56
    L54:
        r9 = r7.getTop();
    L56:
        r6 = r6 + 1;
        goto L46
    L57:
        if (r1 == null) goto L59;
        r5 = Math.min(0, (r1.intValue() - r11.getPaddingTop()) - r4.getMeasuredHeight());
    L59:
        r10.save();
        r10.translate(r11.getPaddingLeft(), r11.getPaddingTop() + r5);
        r4.draw(r10);
        r10.restore();
        return;
    L42:
        if (r4.getWidth() != r18) goto L44;
    L72:
        return;
    L70:
        return;
    L26:
        if (r15.getTop() < r11.getPaddingTop()) goto L28;
        return;
    L69:
        return;
    L21:
        r2 = null;
        goto L22
    L10:
        r14 = null;
        goto L11
    }
}
