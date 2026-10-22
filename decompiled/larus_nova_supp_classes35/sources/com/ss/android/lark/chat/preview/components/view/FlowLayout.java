package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.chat.preview.components.a0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u0001:\u00039:;B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0014J\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\nJ0\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\nH\u0014JX\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0002J\u0014\u00103\u001a\u00020\u001c2\f\u00104\u001a\b\u0012\u0004\u0012\u00020605J\u000e\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\nR&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/ss/android/lark/chat/preview/components/view/FlowLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", BuildConfig.FLAVOR, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mChildrenPositionList", BuildConfig.FLAVOR, "Landroid/graphics/Rect;", "getMChildrenPositionList", "()Ljava/util/Map;", "setMChildrenPositionList", "(Ljava/util/Map;)V", "mMaxLines", "visibleItemCount", "getVisibleItemCount", "()I", "setVisibleItemCount", "(I)V", "widthAndHeight", BuildConfig.FLAVOR, "onMeasure", BuildConfig.FLAVOR, "widthMeasureSpec", "heightMeasureSpec", "measureWidthAndHeight", "widthSize", "onLayout", "changed", BuildConfig.FLAVOR, "l", "t", "r", "b", "saveChildrenPosition", "i", "maxWidth", "width", "height", "leftMargin", "topMargin", "rightMargin", "bottomMargin", "childWidth", "childHeight", "setAdapter", "adapter", "Lcom/ss/android/lark/chat/preview/components/view/FlowLayout$Adapter;", "Lcom/ss/android/lark/chat/preview/components/view/FlowLayout$ViewHolder;", "setMaxLines", "maxLines", "Adapter", "ViewHolder", "Companion", "chat-preview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowLayout extends ViewGroup {
    public Map<Integer, Rect> a;
    public int b;
    public int c;
    public final int[] d;

    public static abstract class a<VH extends c> {
        public a() {
        }

        public abstract int a();

        public abstract void b(VH r1, int r2, int r3);

        public abstract a0.a c(ViewGroup r1);
    }

    public static final class b {
    }

    public static abstract class c {
        public final View a;

        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            this.a = r2;
        }
    }

    static {
    }

    public final Map<Integer, Rect> getMChildrenPositionList() {
        return this.a;
    }

    public final int getVisibleItemCount() {
        return this.c;
    }

    public FlowLayout(Context r1) {
        super(r1);
        this.a = new LinkedHashMap();
        this.b = Integer.MAX_VALUE;
        this.d = new int[2];
    }

    public final void setAdapter(a<c> r7) {
        Intrinsics.checkNotNullParameter(r7, "adapter");
        removeAllViews();
        int r0 = r7.a();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        a0.a r3 = r7.c(this);
        if (r2 >= this.a.size()) goto L9;
        Rect r4 = this.a.get(Integer.valueOf(r2));
        if (r4 == null) goto L9;
        int r5 = r4.width();
    L10:
        r7.b(r3, r2, r5);
        addView(r3.a);
        r2 = r2 + 1;
    L9:
        r5 = 0;
        goto L10
    }

    public final void setMChildrenPositionList(Map<Integer, Rect> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setMaxLines(int r1) {
        if (r1 > 0) goto L5;
        r1 = Integer.MAX_VALUE;
    L5:
        this.b = r1;
    }

    public final void setVisibleItemCount(int r1) {
        this.c = r1;
    }

    public FlowLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = new LinkedHashMap();
        this.b = Integer.MAX_VALUE;
        this.d = new int[2];
    }

    @Override // android.view.View
    public final void onMeasure(int r28, int r29) {
        this.a.clear();
        measureChildren(r28, r29);
        int r12 = View.MeasureSpec.getSize(r28);
        int r13 = View.MeasureSpec.getMode(r28);
        int r14 = View.MeasureSpec.getSize(r29);
        int r15 = View.MeasureSpec.getMode(r29);
        int r0 = getPaddingLeft();
        int r1 = getPaddingTop();
        int r10 = getChildCount();
        int r3 = r0;
        int r18 = r1;
        int r2 = 0;
        int r4 = 1;
        int r9 = 0;
        boolean r19 = true;
    L3:
        if (r9 >= r10) goto L30;
        View r5 = getChildAt(r9);
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
    L8:
        if (r7 == null) goto L10;
        int r8 = r7.leftMargin;
    L11:
        if (r7 == null) goto L13;
        int r11 = r7.rightMargin;
    L14:
        if (r7 == null) goto L16;
        int r16 = r7.topMargin;
    L17:
        if (r7 == null) goto L19;
        int r17 = r7.bottomMargin;
    L20:
        int r20 = (r5.getMeasuredWidth() + r8) + r11;
        int r21 = (r5.getMeasuredHeight() + r16) + r17;
        int r22 = Math.max(r2, r21);
        int r23 = r3 + r20;
        if ((r23 + getPaddingRight()) <= r12) goto L28;
        int r24 = r4 + 1;
        if (r24 > this.b) goto L24;
        int r25 = r21;
        int r110 = getPaddingLeft();
        int r26 = r18 + r22;
        r22 = r25;
        boolean r27 = false;
        int r111 = r24;
    L29:
        int r210 = r10;
        a(r9, r12, r110, r26, r8, r16, r11, r17, r20, r25);
        r3 = r110 + r20;
        r9 = r9 + 1;
        r4 = r111;
        r2 = r22;
        r18 = r26;
        r19 = r27;
        r10 = r210;
        goto L3
    L24:
        if (r9 != 0) goto L26;
        a(r9, r12, r3, r18, r8, r16, r11, r17, r20, r21);
        r3 = r23;
    L26:
        r2 = r22;
        goto L30
    L28:
        r25 = r21;
        r26 = r18;
        r27 = r19;
        r111 = r4;
        r110 = r3;
        goto L29
    L19:
        r17 = 0;
        goto L20
    L16:
        r16 = 0;
        goto L17
    L13:
        r11 = 0;
        goto L14
    L10:
        r8 = 0;
        goto L11
    L7:
        r7 = null;
    L30:
        int[] r30 = this.d;
        if (r19 == false) goto L33;
        int r31 = getPaddingRight() + r3;
    L34:
        r30[0] = r31;
        this.d[1] = (r18 + r2) + getPaddingBottom();
        int[] r32 = this.d;
        if (r13 == 1073741824) goto L38;
        r12 = r32[0];
    L38:
        if (r15 == 1073741824) goto L41;
        r14 = r32[1];
    L41:
        setMeasuredDimension(r12, r14);
        return;
    L33:
        r31 = r12;
        goto L34
    }

    public FlowLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new LinkedHashMap();
        this.b = Integer.MAX_VALUE;
        this.d = new int[2];
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r8 = Math.min(getChildCount(), this.a.size());
        int r9 = 0;
    L3:
        if (r9 >= r8) goto L9;
        View r10 = getChildAt(r9);
        Rect r11 = this.a.get(Integer.valueOf(r9));
        if (r11 == null) goto L8;
        r10.layout(r11.left, r11.top, r11.right, r11.bottom);
    L8:
        r9 = r9 + 1;
        goto L3
    L9:
        this.c = r8;
    }

    public final void a(int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12) {
        Rect r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L5;
        r0 = new Rect();
    L5:
        r0.left = r7 + r5;
        r0.top = r8 + r6;
        if (r11 <= r4) goto L8;
        r0.right = r4 - r9;
    L9:
        r0.bottom = (r6 + r12) - r10;
        Integer r13 = Integer.valueOf(r3);
        this.a.put(r13, r0);
        return;
    L8:
        r0.right = (r5 + r11) - r9;
        goto L9
    }
}
