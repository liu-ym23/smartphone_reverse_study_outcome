package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.blueprint.l;
import com.ss.android.lark.blueprint.s;
import com.ss.android.lark.chameleon.container.webcontainer.plugin.core.ChameleonWebViewClient;
import com.ss.android.lark.chameleon.error.DocErrorCode;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0002&'B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0014J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\f\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J0\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J0\u0010$\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0003J0\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0002R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/message/cellv2/layout/slot/StackSlot;", "Lcom/larksuite/component/ui/layout/LKUIRoundLinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "spacing", "getSpacing", "()I", "setSpacing", "(I)V", "mCurrentGravity", "setGravity", BuildConfig.FLAVOR, "gravity", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "measureVertical", "measureHorizontal", "isSupportSpacing", BuildConfig.FLAVOR, "Landroid/view/View;", "resolveSpacing", "first", "second", "onLayout", "changed", "l", "t", "r", "b", "layoutVertical", "layoutHorizontal", "MatchSiblingLayoutOption", "SpacingLayoutOption", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackSlot extends LKUIRoundLinearLayout {
    public int r;
    public int s;

    public interface a extends s {
        public static final C0045a a = null;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot$a$a, reason: collision with other inner class name */
        public static final class C0045a {
            public static final /* synthetic */ C0045a a = null;
            public static final C0046a b = null;

            /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot$a$a$a, reason: collision with other inner class name */
            public static final class C0046a implements a {
                @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.slot.StackSlot.a
                public final void c() {
                }

                public C0046a() {
                }
            }

            public C0045a() {
            }

            static {
                a = new C0045a();
                b = new C0046a();
            }
        }

        static {
            a = C0045a.a;
        }

        void c();
    }

    public interface b extends s {

        public static final class a implements Comparable<a> {
            public final int a;
            public final int b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof a) == true) goto L8;
                return false;
            L8:
                a r6 = (a) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.a * 31) + this.b;
            }

            public final String toString() {
                return "SpacingConstraint(value=" + this.a + ", priority=" + this.b + ')';
            }

            public a(int r1) {
                this.a = r1;
                this.b = ChameleonWebViewClient.DEFAULT_SAFE_TIME;
            }

            @Override // java.lang.Comparable
            public final int compareTo(a r4) {
                a r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "other");
                return RangesKt.coerceIn(this.b, 1, DocErrorCode.ERRCODE_DEFAULT) - RangesKt.coerceIn(r5.b, 1, DocErrorCode.ERRCODE_DEFAULT);
            }
        }

        void a();

        a b();

        void f();

        void g();
    }

    public StackSlot(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public StackSlot(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final int getSpacing() {
        return this.r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean f(View r5) {
        if (getOrientation() != 1) goto L5;
        boolean r0 = true;
    L7:
        if (r5.getVisibility() != 0) goto L16;
        if (r0 == true) goto L10;
    L11:
        if (r0 == false) goto L13;
        return false;
    L13:
        if (r5.getMeasuredWidth() <= 0) goto L18;
    L14:
        return true;
    L18:
        return false;
    L10:
        if (r5.getMeasuredHeight() > 0) goto L14;
    L16:
        return false;
    L5:
        r0 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setGravity(int r1) {
        super/*android.widget.LinearLayout*/.setGravity(r1);
        this.s = r1;
    }

    public final void setSpacing(int r1) {
        this.r = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int g(View r4, View r5) {
        boolean r2 = true;
        if (getOrientation() == 1) goto L7;
        r2 = false;
    L7:
        if (r4.getVisibility() == 0) goto L9;
    L43:
        return 0;
    L9:
        if (r5.getVisibility() != 0) goto L43;
        if (r2 == true) goto L12;
    L15:
        if (r2 == false) goto L17;
    L21:
        s r6 = l.a(r4);
        b.a r1 = null;
        if ((r6 instanceof b) == false) goto L24;
        b r7 = (b) r6;
    L25:
        s r8 = l.a(r5);
        if ((r8 instanceof b) == false) goto L28;
        b r9 = (b) r8;
    L29:
        if (r2 == false) goto L32;
        if (r7 == null) goto L34;
        r7.g();
    L34:
        if (r2 == false) goto L37;
        if (r9 == null) goto L39;
        r1 = r9.b();
    L39:
        if (r1 == null) goto L42;
        return r1.a;
    L42:
        return this.r;
    L37:
        if (r9 == null) goto L39;
        r9.f();
        goto L39
    L32:
        if (r7 == null) goto L34;
        r7.a();
        goto L34
    L28:
        r9 = null;
        goto L29
    L24:
        r7 = null;
        goto L25
    L17:
        if (r4.getMeasuredWidth() == 0) goto L43;
        if (r5.getMeasuredWidth() != 0) goto L21;
    L12:
        if (r4.getMeasuredHeight() == 0) goto L43;
        if (r5.getMeasuredHeight() == 0) goto L43;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r18, int r19) {
        if (getOrientation() != 1) goto L45;
        int r3 = getChildCount();
        int r10 = 0;
        int r11 = 0;
        View r12 = null;
        int r13 = 0;
    L5:
        if (r10 >= r3) goto L19;
        View r14 = getChildAt(r10);
        Intrinsics.checkNotNull(r14);
        if (r14.getVisibility() != 8) goto L9;
        boolean r15 = true;
    L10:
        if (r15 == true) goto L18;
        measureChild(r14, r18, r19);
        r11 = r11 + r14.getMeasuredHeight();
        if (f(r14) == false) goto L17;
        if (r12 == null) goto L16;
        r11 = r11 + g(r12, r14);
    L16:
        r12 = r14;
    L17:
        r13 = RangesKt.coerceAtLeast(r13, r14.getMeasuredWidth());
    L18:
        r10 = r10 + 1;
        goto L5
    L9:
        r15 = false;
        goto L10
    L19:
        int r4 = getChildCount();
        int r16 = 0;
    L20:
        if (r16 >= r4) goto L38;
        View r17 = getChildAt(r16);
        Intrinsics.checkNotNull(r17);
        if (r17.getVisibility() != 8) goto L24;
        boolean r110 = true;
    L25:
        if (r110 == true) goto L37;
        s r111 = l.a(r17);
        if ((r111 instanceof a) == false) goto L30;
        a r112 = (a) r111;
    L31:
        if (r112 == null) goto L33;
        r112.c();
        boolean r113 = true;
    L34:
        if (r113 == false) goto L37;
        r17.measure(View.MeasureSpec.makeMeasureSpec(r13, 1073741824), LinearLayout.getChildMeasureSpec(r19, getPaddingTop() + getPaddingBottom(), r17.getLayoutParams().height));
        goto L37
    L33:
        r113 = false;
        goto L34
    L30:
        r112 = null;
    L37:
        r16 = r16 + 1;
        goto L20
    L24:
        r110 = false;
        goto L25
    L38:
        int r114 = r13 + (getPaddingLeft() + getPaddingRight());
        int r2 = View.MeasureSpec.getMode(r18);
        int r1 = View.MeasureSpec.getSize(r18);
        if (r2 == Integer.MIN_VALUE) goto L43;
        if (r2 != 1073741824) goto L44;
        r114 = r1;
    L44:
        setMeasuredDimension(r114, (r11 + getPaddingTop()) + getPaddingBottom());
        return;
    L43:
        r114 = RangesKt.coerceAtMost(r114, r1);
        goto L44
    L45:
        int r5 = getChildCount();
        int r6 = 0;
        int r115 = 0;
        View r116 = null;
        int r117 = 0;
    L46:
        if (r6 >= r5) goto L60;
        View r118 = getChildAt(r6);
        Intrinsics.checkNotNull(r118);
        if (r118.getVisibility() != 8) goto L50;
        boolean r119 = true;
    L51:
        if (r119 == true) goto L59;
        measureChild(r118, r18, r19);
        r115 = r115 + r118.getMeasuredWidth();
        if (f(r118) == false) goto L58;
        if (r116 == null) goto L57;
        r115 = r115 + g(r116, r118);
    L57:
        r116 = r118;
    L58:
        r117 = RangesKt.coerceAtLeast(r117, r118.getMeasuredHeight());
    L59:
        r6 = r6 + 1;
        goto L46
    L50:
        r119 = false;
        goto L51
    L60:
        int r7 = getChildCount();
        int r8 = 0;
    L61:
        if (r8 >= r7) goto L79;
        View r120 = getChildAt(r8);
        Intrinsics.checkNotNull(r120);
        if (r120.getVisibility() != 8) goto L65;
        boolean r121 = true;
    L66:
        if (r121 == true) goto L78;
        s r122 = l.a(r120);
        if ((r122 instanceof a) == false) goto L71;
        a r123 = (a) r122;
    L72:
        if (r123 == null) goto L74;
        r123.c();
        boolean r124 = true;
    L75:
        if (r124 == false) goto L78;
        r120.measure(LinearLayout.getChildMeasureSpec(r18, getPaddingLeft() + getPaddingRight(), r120.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(r117, 1073741824));
        goto L78
    L74:
        r124 = false;
        goto L75
    L71:
        r123 = null;
    L78:
        r8 = r8 + 1;
        goto L61
    L65:
        r121 = false;
        goto L66
    L79:
        int r125 = r117 + (getPaddingTop() + getPaddingBottom());
        int r9 = View.MeasureSpec.getMode(r19);
        int r20 = View.MeasureSpec.getSize(r19);
        if (r9 == Integer.MIN_VALUE) goto L84;
        if (r9 != 1073741824) goto L85;
        r125 = r20;
    L85:
        setMeasuredDimension((r115 + getPaddingLeft()) + getPaddingRight(), r125);
        return;
    L84:
        r125 = RangesKt.coerceAtMost(r125, r20);
        goto L85
    }

    public StackSlot(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.r = UIUtils.dp2px(r2, 8.0f);
        this.s = 8388659;
    }

    public /* synthetic */ StackSlot(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        View r14 = null;
        if (getOrientation() != 1) goto L26;
        int r15 = getPaddingTop();
        int r0 = getPaddingLeft();
        if ((Gravity.getAbsoluteGravity(this.s, getLayoutDirection()) & 7) != 5) goto L7;
        boolean r1 = true;
    L8:
        int r2 = getChildCount();
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L41;
        View r4 = getChildAt(r3);
        Intrinsics.checkNotNull(r4);
        if (r4.getVisibility() != 8) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == true) goto L25;
        if (f(r4) == false) goto L21;
        if (r14 == null) goto L20;
        r15 = r15 + g(r14, r4);
    L20:
        r14 = r4;
    L21:
        if (r1 == false) goto L23;
        r4.layout(getMeasuredWidth() - r4.getMeasuredWidth(), r15, getMeasuredWidth(), r4.getMeasuredHeight() + r15);
    L24:
        r15 = r15 + r4.getMeasuredHeight();
        goto L25
    L23:
        r4.layout(r0, r15, r4.getMeasuredWidth() + r0, r4.getMeasuredHeight() + r15);
    L25:
        r3 = r3 + 1;
        goto L9
    L13:
        r5 = false;
        goto L14
    L41:
        return;
    L7:
        r1 = false;
        goto L8
    L26:
        int r16 = getPaddingLeft();
        int r6 = getPaddingTop();
        int r7 = getChildCount();
        int r8 = 0;
    L27:
        if (r8 >= r7) goto L48;
        View r17 = getChildAt(r8);
        Intrinsics.checkNotNull(r17);
        if (r17.getVisibility() != 8) goto L31;
        boolean r18 = true;
    L32:
        if (r18 == true) goto L40;
        if (f(r17) == false) goto L39;
        if (r14 == null) goto L38;
        r16 = r16 + g(r14, r17);
    L38:
        r14 = r17;
    L39:
        r17.layout(r16, r6, r17.getMeasuredWidth() + r16, r17.getMeasuredHeight() + r6);
        r16 = r16 + r17.getMeasuredWidth();
    L40:
        r8 = r8 + 1;
        goto L27
    L31:
        r18 = false;
        goto L32
    }
}
