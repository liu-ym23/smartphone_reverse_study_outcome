package com.ss.android.lark.chat.cot.detail;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0001/B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J0\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0002J0\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u001bH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u00060"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/CotDotItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "commonLeftDp", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;F)V", "bottomSpace", BuildConfig.FLAVOR, "markerLineBreakTop", "markerLineBreakBottom", "lineLeft", "lineWidth", "linePaint", "Landroid/graphics/Paint;", "roundInterrupted", BuildConfig.FLAVOR, "getRoundInterrupted", "()Z", "setRoundInterrupted", "(Z)V", "getItemOffsets", BuildConfig.FLAVOR, "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "drawVerticalLine", "left", "right", "top", "bottom", "resolveLineBottom", "lm", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "adapter", "Lcom/ss/android/lark/chat/cot/detail/blueprint/CotDetailBlueprintAdapter;", "index", "child", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotDotItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final Paint f;

    public static final class a {
    }

    static {
    }

    public CotDotItemDecoration(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = MathKt.roundToInt(h18.d.a(r3, 12.0f));
        this.b = h18.d.a(r3, 1.0f);
        this.c = h18.d.a(r3, 25.0f);
        this.d = h18.d.a(r3, 7.5f);
        this.e = h18.d.a(r3, 1.0f);
        Paint r0 = new Paint(1);
        r0.setColor(UDColorUtils.getColor(r3, 2131103353));
        r0.setStyle(Paint.Style.FILL);
        this.f = r0;
    }

    public final void onDraw(Canvas r19, RecyclerView r20, RecyclerView.State r21) {
        Intrinsics.checkNotNullParameter(r19, "c");
        Intrinsics.checkNotNullParameter(r20, "parent");
        Intrinsics.checkNotNullParameter(r21, "state");
        RecyclerView.LayoutManager r2 = r20.getLayoutManager();
        if (r2 != null) goto L5;
        return;
    L5:
        CotDetailBlueprintAdapter r3 = r20.getAdapter();
        if ((r3 instanceof CotDetailBlueprintAdapter) == false) goto L8;
        CotDetailBlueprintAdapter r11 = r3;
    L9:
        if (r11 != null) goto L11;
        return;
    L11:
        int r12 = r20.getChildCount();
        int r13 = 0;
    L12:
        if (r13 >= r12) goto L40;
        View r4 = r20.getChildAt(r13);
        if (r4 == null) goto L39;
        int r5 = r20.getChildAdapterPosition(r4);
        k r6 = (k) CollectionsKt.getOrNull(r11.c.getCurrentList(), r5);
        if (r6 == null) goto L39;
        if (r6.b == CotDetailBlockType.STATUS) goto L39;
        float r14 = (r4.getLeft() + r4.getTranslationX()) + this.d;
        float r15 = r14 + this.e;
        float r7 = r2.getDecoratedTop(r4);
        View r8 = r20.getChildAt(r13 + 1);
        if (r8 == null) goto L24;
        k r9 = (k) CollectionsKt.getOrNull(r11.c.getCurrentList(), r2.getPosition(r8));
    L25:
        if (r8 == null) goto L28;
        if (r9 == null) goto L28;
        float r16 = (r8.getTop() + r8.getTranslationY()) + this.b;
    L29:
        float r10 = this.b + (r4.getTop() + r4.getTranslationY());
        float r17 = (r4.getTop() + r4.getTranslationY()) + this.c;
        if (r5 == 0) goto L36;
        if (r10 <= r7) goto L36;
        r19.drawRect(r14, r7, r15, r10, this.f);
    L36:
        if (r16 <= r17) goto L39;
        r19.drawRect(r14, r17, r15, r16, this.f);
    L28:
        r16 = r2.getDecoratedBottom(r4);
        goto L29
    L24:
        r9 = null;
    L39:
        r13 = r13 + 1;
        goto L12
    L40:
        return;
    L8:
        r11 = null;
        goto L9
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        CotDetailBlueprintAdapter r6 = r4.getAdapter();
        if ((r6 instanceof CotDetailBlueprintAdapter) == false) goto L5;
        CotDetailBlueprintAdapter r7 = r6;
    L6:
        if (r7 != null) goto L9;
        return;
    L9:
        if ((r7.getItemCount() - 1) != r4.getChildAdapterPosition(r3)) goto L11;
        return;
    L11:
        r2.bottom = this.a;
        return;
    L5:
        r7 = null;
        goto L6
    }
}
