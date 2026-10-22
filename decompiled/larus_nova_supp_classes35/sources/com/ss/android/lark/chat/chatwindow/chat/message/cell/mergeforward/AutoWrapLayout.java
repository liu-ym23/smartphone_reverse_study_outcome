package com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0002-.B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014J(\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J0\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0014J\u0012\u0010(\u001a\u00020)2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0014J\b\u0010+\u001a\u00020)H\u0014J\u0012\u0010,\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010)H\u0014R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/AutoWrapLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gravity", "getGravity", "()I", "setGravity", "(I)V", "horizontalGap", "getHorizontalGap", "setHorizontalGap", "verticalGap", "getVerticalGap", "setVerticalGap", "lineHeights", BuildConfig.FLAVOR, "lineWidths", "onMeasure", BuildConfig.FLAVOR, "widthMeasureSpec", "heightMeasureSpec", "measureChildWrapper", "child", "Landroid/view/View;", "allowDrawWidth", "lineWidth", "onLayout", "changed", BuildConfig.FLAVOR, "l", "t", "r", "b", "generateLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "p", "generateDefaultLayoutParams", "checkLayoutParams", "Companion", "LayoutParams", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoWrapLayout extends ViewGroup {
    public int a;
    public int b;
    public int c;
    public final List<Integer> d;
    public final List<Integer> e;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0006\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u000fB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/AutoWrapLayout$LayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "width", BuildConfig.FLAVOR, "height", "(II)V", "source", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "(Lcom/ss/android/lark/chat/chatwindow/chat/message/cell/mergeforward/AutoWrapLayout$LayoutParams;)V", "allowNewLine", BuildConfig.FLAVOR, "getAllowNewLine", "()Z", "setAllowNewLine", "(Z)V", "isDivisionView", "setDivisionView", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LayoutParams extends ViewGroup.MarginLayoutParams {
        public final boolean a;
        public final boolean b;

        public LayoutParams() {
            super(-1, -1);
            this.a = true;
        }

        public LayoutParams(LayoutParams r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            super(r2);
            this.a = true;
            this.a = r2.a;
            this.b = r2.b;
        }

        public LayoutParams(ViewGroup.LayoutParams r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            super(r2);
            this.a = true;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            super(r2);
            this.a = true;
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            super(r3, r4);
            this.a = true;
            TypedArray r5 = r3.obtainStyledAttributes(r4, new int[]{2130968782, 2130970394});
            this.a = r5.getBoolean(0, true);
            this.b = r5.getBoolean(1, false);
            r5.recycle();
        }
    }

    public static final class a {
    }

    static {
    }

    public AutoWrapLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AutoWrapLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final int getGravity() {
        return this.a;
    }

    public final int getHorizontalGap() {
        return this.b;
    }

    public final int getVerticalGap() {
        return this.c;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        Intrinsics.checkNotNullParameter(r2, "p");
        if ((r2 instanceof LayoutParams) == false) goto L6;
        return new LayoutParams((LayoutParams) r2);
    L6:
        if ((r2 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r2);
    L9:
        return new LayoutParams(r2);
    }

    public final void setGravity(int r1) {
        this.a = r1;
    }

    public final void setHorizontalGap(int r1) {
        this.b = r1;
    }

    public final void setVerticalGap(int r1) {
        this.c = r1;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    @Override // android.view.View
    public final void onMeasure(int r26, int r27) {
        if (getChildCount() <= 0) goto L42;
        if (r26 == 0) goto L42;
        int r2 = View.MeasureSpec.getSize(r26);
        int r3 = View.MeasureSpec.getSize(r27);
        int r4 = View.MeasureSpec.getMode(r26);
        int r5 = View.MeasureSpec.getMode(r27);
        int r6 = (r2 - getPaddingStart()) - getPaddingEnd();
        int r7 = getChildCount();
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
        int r13 = 0;
    L7:
        if (r9 >= r7) goto L33;
        View r14 = getChildAt(r9);
        Intrinsics.checkNotNull(r14);
        if (com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.b(r14) == true) goto L13;
        if (r14.getVisibility() != 8) goto L13;
        r9 = r9 + 1;
    L13:
        a(r14, r27, r6, r11);
        int r15 = (r14.getMeasuredWidth() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r14)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.d(r14);
        int r16 = (r14.getMeasuredHeight() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r14)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.a(r14);
        if (com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.b(r14) == true) goto L16;
    L24:
        int r19 = r2;
        int r20 = r3;
        int r21 = r7;
    L25:
        int r8 = r16;
        boolean r17 = false;
    L26:
        if (r17 == false) goto L28;
    L31:
        int r18 = Math.max(r10, r11 - this.b);
        int r110 = r15 + this.b;
        r12 = r12 + (r13 + this.c);
        r13 = r8;
        r10 = r18;
        r11 = r110;
    L32:
        r9 = r9 + 1;
        r2 = r19;
        r3 = r20;
        r7 = r21;
        goto L7
    L28:
        if ((r11 + r15) > r6) goto L31;
        r11 = r11 + (r15 + this.b);
        r13 = Math.max(r13, r8);
        goto L32
    L16:
        if (r9 >= (r7 - 1)) goto L24;
        int r22 = r9 + 1;
        r19 = r2;
        View r23 = getChildAt(r22);
        r20 = r3;
        int r24 = r11 + r15;
        r21 = r7;
        int r25 = this.b + r24;
        Intrinsics.checkNotNull(r23);
        a(r23, r27, r6, r25);
        int r28 = (r23.getMeasuredWidth() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r23)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.d(r23);
        int r29 = (r23.getMeasuredHeight() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r23)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.a(r23);
        if (r24 <= r6) goto L20;
    L23:
        r14.setVisibility(8);
        r9 = r22;
        r15 = r28;
        r8 = r29;
        r17 = true;
        goto L26
    L20:
        if ((r25 + r28) > r6) goto L23;
        r14.setVisibility(0);
        goto L25
    L33:
        int r111 = r2;
        int r210 = r3;
        int r1 = Math.max(r10, r11 - this.b);
        int r112 = r12 + r13;
        if (r4 != 1073741824) goto L36;
        int r30 = r111;
    L37:
        if (r5 != 1073741824) goto L39;
        int r31 = r210;
    L40:
        setMeasuredDimension(r30, r31);
        return;
    L39:
        r31 = (r112 + getPaddingTop()) + getPaddingBottom();
        goto L40
    L36:
        r30 = (r1 + getPaddingStart()) + getPaddingEnd();
    L42:
        super.onMeasure(r26, r27);
    }

    public AutoWrapLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = 8388659;
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{R.attr.gravity, 2130970266, 2130975030});
        this.a = r5.getInt(0, this.a);
        this.b = r5.getDimensionPixelSize(1, 0);
        this.c = r5.getDimensionPixelSize(2, 0);
        r5.recycle();
        this.d = new ArrayList();
        this.e = new ArrayList();
    }

    public /* synthetic */ AutoWrapLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void a(View r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if ((r0 instanceof LayoutParams) == false) goto L5;
        LayoutParams r1 = (LayoutParams) r0;
    L6:
        if (r1 == null) goto L8;
        boolean r2 = r1.a;
    L9:
        if (r2 == true) goto L13;
        if (r5 <= r6) goto L13;
        r5 = r5 - r6;
    L13:
        int r7 = (r5 - com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r3)) - com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.d(r3);
        if (r3.getLayoutParams().width != (-2)) goto L16;
        int r8 = PluginList.LEVEL_NOT_SET;
    L17:
        measureChild(r3, View.MeasureSpec.makeMeasureSpec(r7, r8), r4);
        return;
    L16:
        r8 = 1073741824;
        goto L17
    L8:
        r2 = true;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        ((ArrayList) this.d).clear();
        ((ArrayList) this.e).clear();
        int r1 = getPaddingStart();
        int r2 = getWidth();
        int r3 = (r2 - r1) - getPaddingEnd();
        int r4 = getChildCount();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
    L3:
        int r9 = 8;
        int r10 = 1;
        if (r6 >= r4) goto L27;
        View r11 = getChildAt(r6);
        Intrinsics.checkNotNull(r11);
        if (com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.b(r11) == true) goto L10;
        if (r11.getVisibility() != 8) goto L10;
        r6 = r6 + 1;
    L10:
        int r12 = (r11.getMeasuredWidth() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r11)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.d(r11);
        int r13 = (r11.getMeasuredHeight() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r11)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.a(r11);
        if (com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.b(r11) == true) goto L13;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == false) goto L22;
    L25:
        ((ArrayList) this.d).add(Integer.valueOf(r7));
        ((ArrayList) this.e).add(Integer.valueOf(r8 - this.b));
        r8 = r12 + this.b;
        r7 = r13;
    L26:
        r6 = r6 + 1;
        goto L3
    L22:
        if ((r12 + r8) > r3) goto L25;
        r8 = r8 + (r12 + this.b);
        r7 = Math.max(r7, r13);
        goto L26
    L13:
        if (r6 >= (r4 - 1)) goto L19;
        int r14 = r6 + 1;
        View r15 = getChildAt(r14);
        int r16 = r15.getMeasuredWidth();
        Intrinsics.checkNotNull(r15);
        int r17 = (r16 + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r15)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.d(r15);
        int r110 = (r15.getMeasuredHeight() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r15)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.a(r15);
        int r111 = r8 + r12;
        if (r111 <= r3) goto L17;
    L18:
        r6 = r14;
        r12 = r17;
        r13 = r110;
        r5 = true;
        goto L20
    L17:
        if (((r111 + this.b) + r17) <= r3) goto L19;
    L27:
        ((ArrayList) this.d).add(Integer.valueOf(r7));
        ((ArrayList) this.e).add(Integer.valueOf(r8 - this.b));
        int r23 = this.a;
        int r24 = r23 & 7;
        int r25 = r23 & 112;
        int r26 = getPaddingTop();
        int r27 = ((ArrayList) this.d).size();
        int r112 = r26;
        int r28 = 0;
        int r29 = 0;
    L28:
        if (r28 >= r27) goto L57;
        int r113 = ((Number) ListProtector.get(this.d, r28)).intValue();
        int r114 = ((Number) ListProtector.get(this.e, r28)).intValue();
        if (r24 != r10) goto L32;
        int r115 = (r2 - r114) / 2;
    L36:
        int r116 = r115 + r1;
    L37:
        if (r29 >= r4) goto L56;
        if (r116 >= (r114 + r1)) goto L56;
        View r117 = getChildAt(r29);
        if (r117.getVisibility() != r9) goto L44;
        r29 = r29 + 1;
        goto L37
    L44:
        Intrinsics.checkNotNull(r117);
        int r118 = com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r117) + r116;
        if (r25 != 16) goto L47;
        int r30 = (((((r113 - r117.getMeasuredHeight()) - com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r117)) - com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.a(r117)) / 2) + r112) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r117);
    L55:
        r117.layout(r118, r30, r118 + r117.getMeasuredWidth(), r30 + r117.getMeasuredHeight());
        r116 = r116 + (((r117.getMeasuredWidth() + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.c(r117)) + com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.d(r117)) + this.b);
        r29 = r29 + 1;
        r1 = r1;
        r2 = r2;
        r9 = 8;
        goto L37
    L47:
        if (r25 != 48) goto L49;
        int r31 = com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r117);
    L53:
        r30 = r31 + r112;
        goto L55
    L49:
        if (r25 == 80) goto L51;
        r31 = com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.e(r117);
        goto L53
    L51:
        r31 = (r113 - r117.getMeasuredHeight()) - com.ss.android.lark.chat.chatwindow.chat.message.cell.mergeforward.a.a(r117);
    L56:
        r112 = r112 + (r113 + this.c);
        r28 = r28 + 1;
        r1 = r1;
        r2 = r2;
        r9 = 8;
        r10 = 1;
        goto L28
    L32:
        if (r24 == 8388613) goto L34;
        r116 = r1;
        goto L37
    L34:
        r115 = r2 - r114;
        goto L36
    }
}
