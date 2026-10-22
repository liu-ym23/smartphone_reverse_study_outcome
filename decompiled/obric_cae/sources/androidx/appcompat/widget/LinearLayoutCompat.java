package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import com.ttnet.org.chromium.net.NetError;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1005b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1006m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1007n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1008o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1009p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f1010q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1011r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f1012s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int[] f1013t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Drawable f1014u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1015v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1016w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1017x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1018y;

    public static class a extends LinearLayout.LayoutParams {
    }

    public LinearLayoutCompat(Context r8) {
        this(r8, null);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r8) {
        return r8 instanceof a;
    }

    final void d(Canvas r8, int r10) {
        this.f1014u.setBounds(getPaddingLeft() + this.f1018y, r10, (getWidth() - getPaddingRight()) - this.f1018y, this.f1016w + r10);
        this.f1014u.draw(r8);
    }

    final void e(Canvas r8, int r10) {
        this.f1014u.setBounds(r10, getPaddingTop() + this.f1018y, this.f1015v + r10, (getHeight() - getPaddingBottom()) - this.f1018y);
        this.f1014u.draw(r8);
    }

    public a f() {
        int r8 = this.f1007n;
        if (r8 != 0) goto L7;
        return new a(-2, -2);
    L7:
        if (r8 == 1) goto L9;
        return null;
    L9:
        return new a(-1, -2);
    }

    public a g(AttributeSet r8) {
        return new a(getContext(), r8);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return f();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r8) {
        return g(r8);
    }

    @Override // android.view.View
    public int getBaseline() {
        if (this.f1005b < 0) goto L5;
        int r8 = getChildCount();
        int r10 = this.f1005b;
        if (r8 <= r10) goto L29;
        View r11 = getChildAt(r10);
        int r12 = r11.getBaseline();
        if (r12 == (-1)) goto L11;
        int r13 = this.f1006m;
        if (this.f1007n != 1) goto L27;
        int r14 = this.f1008o & BWDLInnerConstant.LINK_RECOVERY;
        if (r14 == 48) goto L27;
        if (r14 != 16) goto L22;
        r13 = r13 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1009p) / 2);
        goto L27
    L22:
        if (r14 != 80) goto L27;
        r13 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1009p;
    L27:
        return (r13 + ((LinearLayout.LayoutParams) ((a) r11.getLayoutParams())).topMargin) + r12;
    L11:
        if (this.f1005b != 0) goto L14;
        return -1;
    L14:
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    L29:
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    L5:
        return super.getBaseline();
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1005b;
    }

    public Drawable getDividerDrawable() {
        return this.f1014u;
    }

    public int getDividerPadding() {
        return this.f1018y;
    }

    public int getDividerWidth() {
        return this.f1015v;
    }

    public int getGravity() {
        return this.f1008o;
    }

    public int getOrientation() {
        return this.f1007n;
    }

    public int getShowDividers() {
        return this.f1017x;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1010q;
    }

    public a h(ViewGroup.LayoutParams r8) {
        return new a(r8);
    }

    public final boolean i(int r8) {
        if (r8 != 0) goto L9;
        if ((this.f1017x & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    L9:
        if (r8 != getChildCount()) goto L15;
        if ((this.f1017x & 4) != 0) goto L13;
        return false;
    L13:
        return true;
    L15:
        if ((this.f1017x & 2) == 0) goto L22;
        int r10 = r8 - 1;
    L17:
        if (r10 < 0) goto L28;
        if (getChildAt(r10).getVisibility() != 8) goto L27;
        r10 = r10 - 1;
        goto L17
    L27:
        return true;
    L28:
        return false;
    L22:
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r8) {
        if (this.f1014u != null) goto L5;
        return;
    L5:
        int r10 = 0;
        if (this.f1007n != 1) goto L24;
        int r11 = getVirtualChildCount();
    L8:
        if (r10 >= r11) goto L18;
        View r12 = getChildAt(r10);
        if (r12 == null) goto L16;
        if (r12.getVisibility() == 8) goto L16;
        if (i(r10) == false) goto L16;
        d(r8, (r12.getTop() - ((LinearLayout.LayoutParams) ((a) r12.getLayoutParams())).topMargin) - this.f1016w);
    L16:
        r10 = r10 + 1;
        goto L8
    L18:
        if (i(r11) == false) goto L62;
        View r13 = getChildAt(r11 - 1);
        if (r13 != null) goto L22;
        int r14 = (getHeight() - getPaddingBottom()) - this.f1016w;
    L23:
        d(r8, r14);
        return;
    L22:
        r14 = r13.getBottom() + ((LinearLayout.LayoutParams) ((a) r13.getLayoutParams())).bottomMargin;
        goto L23
    L62:
        return;
    L24:
        int r15 = getVirtualChildCount();
        boolean r16 = b1.a(this);
    L25:
        if (r10 >= r15) goto L39;
        View r17 = getChildAt(r10);
        if (r17 == null) goto L37;
        if (r17.getVisibility() == 8) goto L37;
        if (i(r10) == false) goto L37;
        a r18 = (a) r17.getLayoutParams();
        if (r16 == false) goto L35;
        int r19 = r17.getRight() + ((LinearLayout.LayoutParams) r18).rightMargin;
    L36:
        e(r8, r19);
        goto L37
    L35:
        r19 = (r17.getLeft() - ((LinearLayout.LayoutParams) r18).leftMargin) - this.f1015v;
    L37:
        r10 = r10 + 1;
        goto L25
    L39:
        if (i(r15) == false) goto L64;
        View r20 = getChildAt(r15 - 1);
        if (r20 != null) goto L45;
        if (r16 == false) goto L44;
        int r21 = getPaddingLeft();
    L50:
        e(r8, r21);
        return;
    L44:
        int r22 = getWidth();
        int r23 = getPaddingRight();
    L48:
        r21 = (r22 - r23) - this.f1015v;
        goto L50
    L45:
        a r24 = (a) r20.getLayoutParams();
        if (r16 == false) goto L49;
        r22 = r20.getLeft();
        r23 = ((LinearLayout.LayoutParams) r24).leftMargin;
        goto L48
    L49:
        r21 = r20.getRight() + ((LinearLayout.LayoutParams) r24).rightMargin;
        goto L50
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r8) {
        super.onInitializeAccessibilityEvent(r8);
        r8.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
        super.onInitializeAccessibilityNodeInfo(r8);
        r8.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r26, int r27, int r28, int r29, int r30) {
        int r8 = 8;
        int r10 = 5;
        if (this.f1007n != 1) goto L32;
        int r11 = getPaddingLeft();
        int r12 = r29 - r27;
        int r13 = r12 - getPaddingRight();
        int r14 = (r12 - r11) - getPaddingRight();
        int r15 = getVirtualChildCount();
        int r16 = this.f1008o;
        int r17 = r16 & BWDLInnerConstant.LINK_RECOVERY;
        int r18 = 8388615 & r16;
        if (r17 == 16) goto L9;
        if (r17 == 80) goto L8;
        int r19 = getPaddingTop();
    L10:
        int r20 = 0;
    L11:
        if (r20 >= r15) goto L80;
        View r110 = getChildAt(r20);
        if (r110 != null) goto L16;
        r19 = r19 + 0;
    L31:
        r20 = r20 + 1;
        r8 = 8;
        r10 = 5;
        goto L11
    L16:
        if (r110.getVisibility() == r8) goto L31;
        int r111 = r110.getMeasuredWidth();
        int r112 = r110.getMeasuredHeight();
        a r21 = (a) r110.getLayoutParams();
        int r22 = ((LinearLayout.LayoutParams) r21).gravity;
        if (r22 >= 0) goto L20;
        r22 = r18;
    L20:
        WeakHashMap<View, j0.h0> r113 = j0.w.f8437a;
        int r23 = Gravity.getAbsoluteGravity(r22, j0.w.e.d(this)) & 7;
        if (r23 == 1) goto L25;
        if (r23 == r10) goto L24;
        int r24 = ((LinearLayout.LayoutParams) r21).leftMargin + r11;
    L28:
        if (i(r20) == false) goto L30;
        r19 = r19 + this.f1016w;
    L30:
        int r25 = r19 + ((LinearLayout.LayoutParams) r21).topMargin;
        int r31 = r25 + 0;
        r110.layout(r24, r31, r111 + r24, r112 + r31);
        r20 = r20 + 0;
        r19 = ((r112 + ((LinearLayout.LayoutParams) r21).bottomMargin) + 0) + r25;
        goto L31
    L24:
        int r32 = r13 - r111;
    L26:
        r24 = r32 - ((LinearLayout.LayoutParams) r21).rightMargin;
        goto L28
    L25:
        r32 = (((r14 - r111) / 2) + r11) + ((LinearLayout.LayoutParams) r21).leftMargin;
        goto L26
    L80:
        return;
    L8:
        r19 = ((getPaddingTop() + r30) - r28) - this.f1009p;
        goto L10
    L9:
        r19 = getPaddingTop() + (((r30 - r28) - this.f1009p) / 2);
        goto L10
    L32:
        boolean r33 = b1.a(this);
        int r34 = getPaddingTop();
        int r35 = r30 - r28;
        int r36 = r35 - getPaddingBottom();
        int r37 = (r35 - r34) - getPaddingBottom();
        int r38 = getVirtualChildCount();
        int r114 = this.f1008o;
        int r39 = 8388615 & r114;
        int r115 = r114 & BWDLInnerConstant.LINK_RECOVERY;
        boolean r116 = this.f1004a;
        int[] r117 = this.f1012s;
        int[] r118 = this.f1013t;
        WeakHashMap<View, j0.h0> r119 = j0.w.f8437a;
        int r40 = Gravity.getAbsoluteGravity(r39, j0.w.e.d(this));
        if (r40 != 1) goto L35;
        int r41 = getPaddingLeft() + (((r29 - r27) - this.f1009p) / 2);
    L39:
        if (r33 == false) goto L41;
        int r42 = r38 - 1;
        int r120 = -1;
    L42:
        int r121 = r41;
        int r43 = 0;
    L43:
        if (r43 >= r38) goto L86;
        int r44 = (r120 * r43) + r42;
        View r45 = getChildAt(r44);
        if (r45 != null) goto L50;
        r121 = r121 + 0;
    L47:
        int r310 = r38;
    L79:
        r43 = r43 + 1;
        r42 = r42;
        r38 = r310;
        r115 = r115;
        goto L43
    L50:
        if (r45.getVisibility() == 8) goto L47;
        int r46 = r45.getMeasuredWidth();
        int r210 = r45.getMeasuredHeight();
        a r122 = (a) r45.getLayoutParams();
        if (r116 == false) goto L56;
        r310 = r38;
        if (((LinearLayout.LayoutParams) r122).height == (-1)) goto L57;
        int r47 = r45.getBaseline();
    L58:
        int r48 = ((LinearLayout.LayoutParams) r122).gravity;
        if (r48 >= 0) goto L61;
        r48 = r115;
    L61:
        int r49 = r48 & BWDLInnerConstant.LINK_RECOVERY;
        if (r49 != 16) goto L64;
        int r50 = ((((r37 - r210) / 2) + r34) + ((LinearLayout.LayoutParams) r122).topMargin) - ((LinearLayout.LayoutParams) r122).bottomMargin;
    L76:
        if (i(r44) == false) goto L78;
        r121 = r121 + this.f1015v;
    L78:
        int r123 = r121 + ((LinearLayout.LayoutParams) r122).leftMargin;
        int r51 = r123 + 0;
        r45.layout(r51, r50, r46 + r51, r210 + r50);
        r121 = ((r46 + ((LinearLayout.LayoutParams) r122).rightMargin) + 0) + r123;
        r43 = r43 + 0;
        goto L79
    L64:
        if (r49 != 48) goto L66;
        r50 = ((LinearLayout.LayoutParams) r122).topMargin + r34;
        if (r47 == (-1)) goto L76;
        r50 = (r117[1] - r47) + r50;
        goto L76
    L66:
        if (r49 == 80) goto L68;
        r50 = r34;
        goto L76
    L68:
        r50 = (r36 - r210) - ((LinearLayout.LayoutParams) r122).bottomMargin;
        if (r47 == (-1)) goto L76;
        r50 = r50 - (r118[2] - (r45.getMeasuredHeight() - r47));
    L57:
        r47 = -1;
        goto L58
    L56:
        r310 = r38;
        goto L57
    L86:
        return;
    L41:
        r120 = 1;
        r42 = 0;
        goto L42
    L35:
        if (r40 == 5) goto L37;
        r41 = getPaddingLeft();
        goto L39
    L37:
        r41 = ((getPaddingLeft() + r29) - r27) - this.f1009p;
        goto L39
    }

    @Override // android.view.View
    public void onMeasure(int r39, int r40) {
        int r10 = -2;
        int r11 = Integer.MIN_VALUE;
        int r12 = 8;
        int r14 = 1073741824;
        float r15 = 0.0f;
        int r8 = 0;
        boolean r13 = true;
        if (this.f1007n != 1) goto L172;
        this.f1009p = 0;
        int r16 = getVirtualChildCount();
        int r17 = View.MeasureSpec.getMode(r39);
        int r18 = View.MeasureSpec.getMode(r40);
        int r19 = this.f1005b;
        boolean r20 = this.f1011r;
        boolean r24 = true;
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        int r21 = 0;
        int r22 = 0;
        boolean r23 = false;
        boolean r25 = false;
        float r26 = 0.0f;
    L5:
        if (r110 >= r16) goto L75;
        View r27 = getChildAt(r110);
        if (r27 != null) goto L10;
        this.f1009p += r8;
    L12:
        r19 = r19;
        r18 = r18;
        int r28 = r17;
        r16 = r16;
        int r114 = r112;
        boolean r29 = true;
    L74:
        r110 = r110 + 1;
        r17 = r28;
        r19 = r19;
        r112 = r114;
        r13 = r29;
        r18 = r18;
        r16 = r16;
        r8 = 0;
        r10 = -2;
        r11 = Integer.MIN_VALUE;
        r12 = 8;
        r14 = 1073741824;
        r15 = 0.0f;
        goto L5
    L10:
        if (r27.getVisibility() != r12) goto L14;
        r110 = r110 + 0;
        goto L12
    L14:
        if (i(r110) == false) goto L16;
        this.f1009p += this.f1016w;
    L16:
        a r30 = (a) r27.getLayoutParams();
        float r31 = ((LinearLayout.LayoutParams) r30).weight;
        r26 = r26 + r31;
        if (r18 != r14) goto L24;
        if (((LinearLayout.LayoutParams) r30).height != 0) goto L24;
        if (r31 <= r15) goto L24;
        int r32 = this.f1009p;
        this.f1009p = Math.max(r32, (((LinearLayout.LayoutParams) r30).topMargin + r32) + ((LinearLayout.LayoutParams) r30).bottomMargin);
        a r115 = r30;
        boolean r33 = true;
        r29 = true;
    L40:
        if (r19 >= 0) goto L42;
    L44:
        if (r110 < r19) goto L46;
    L50:
        r28 = r17;
        if (r28 != 1073741824) goto L53;
    L55:
        boolean r34 = false;
    L56:
        int r35 = ((LinearLayout.LayoutParams) r115).leftMargin + ((LinearLayout.LayoutParams) r115).rightMargin;
        int r36 = r27.getMeasuredWidth() + r35;
        int r37 = Math.max(r22, r36);
        r114 = View.combineMeasuredStates(r112, r27.getMeasuredState());
        if (r24 == true) goto L59;
    L61:
        boolean r116 = false;
    L63:
        if (((LinearLayout.LayoutParams) r115).weight <= 0.0f) goto L68;
        if (r34 == true) goto L67;
        r35 = r36;
    L67:
        r21 = Math.max(r21, r35);
    L73:
        r110 = r110 + 0;
        r22 = r37;
        r23 = r33;
        r24 = r116;
        goto L74
    L68:
        int r117 = r21;
        if (r34 == true) goto L72;
        r35 = r36;
    L72:
        r111 = Math.max(r111, r35);
        r21 = r117;
        goto L73
    L59:
        if (((LinearLayout.LayoutParams) r115).width != (-1)) goto L61;
        r116 = r29;
        goto L63
    L53:
        if (((LinearLayout.LayoutParams) r115).width != (-1)) goto L55;
        r34 = r29;
        r25 = r34;
        goto L56
    L46:
        if (((LinearLayout.LayoutParams) r115).weight <= 0.0f) goto L50;
        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
    L42:
        if (r19 != (r110 + 1)) goto L44;
        this.f1006m = this.f1009p;
    L24:
        if (((LinearLayout.LayoutParams) r30).height == 0) goto L26;
    L28:
        int r118 = r11;
    L30:
        if (r26 != r15) goto L32;
        int r119 = this.f1009p;
    L33:
        r29 = true;
        r115 = r30;
        measureChildWithMargins(r27, r39, 0, r40, r119);
        if (r118 == r11) goto L36;
        ((LinearLayout.LayoutParams) r115).height = r118;
    L36:
        int r38 = r27.getMeasuredHeight();
        int r41 = this.f1009p;
        this.f1009p = Math.max(r41, (((r41 + r38) + ((LinearLayout.LayoutParams) r115).topMargin) + ((LinearLayout.LayoutParams) r115).bottomMargin) + 0);
        int r42 = r113;
        if (r20 == false) goto L39;
        r113 = Math.max(r38, r42);
    L39:
        r33 = r23;
        goto L40
    L32:
        r119 = 0;
        goto L33
    L26:
        if (r31 <= r15) goto L28;
        ((LinearLayout.LayoutParams) r30).height = r10;
        r118 = 0;
        goto L30
    L75:
        int r210 = r18;
        int r43 = r17;
        int r310 = r16;
        boolean r211 = r13;
        int r44 = r111;
        int r120 = r112;
        int r45 = r113;
        int r121 = r21;
        int r46 = r22;
        if (this.f1009p > 0) goto L78;
    L80:
        int r47 = r210;
        if (r20 == true) goto L83;
    L95:
        int r122 = (getPaddingBottom() + getPaddingTop()) + this.f1009p;
        this.f1009p = r122;
        int r48 = View.resolveSizeAndState(Math.max(r122, getSuggestedMinimumHeight()), r40, 0);
        int r123 = (16777215 & r48) - this.f1009p;
        if (r23 == true) goto L117;
        if (r123 != 0) goto L99;
    L101:
        r44 = Math.max(r44, r121);
        if (r20 == true) goto L104;
    L116:
        int r212 = r46;
        if (r24 == false) goto L159;
    L161:
        r44 = r212;
    L162:
        setMeasuredDimension(View.resolveSizeAndState(Math.max((getPaddingRight() + getPaddingLeft()) + r44, getSuggestedMinimumWidth()), r39, r120), r48);
        if (r25 == false) goto L398;
        int r49 = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int r50 = 0;
    L165:
        if (r50 >= r310) goto L440;
        View r51 = getChildAt(r50);
        if (r51.getVisibility() == 8) goto L171;
        a r124 = (a) r51.getLayoutParams();
        if (((LinearLayout.LayoutParams) r124).width != (-1)) goto L171;
        int r125 = ((LinearLayout.LayoutParams) r124).height;
        ((LinearLayout.LayoutParams) r124).height = r51.getMeasuredHeight();
        measureChildWithMargins(r51, r49, 0, r40, 0);
        ((LinearLayout.LayoutParams) r124).height = r125;
    L171:
        r50 = r50 + 1;
        goto L165
    L440:
        return;
    L398:
        return;
    L159:
        if (r43 == 1073741824) goto L161;
    L104:
        if (r47 == 1073741824) goto L116;
        int r52 = 0;
    L106:
        if (r52 >= r310) goto L116;
        View r53 = getChildAt(r52);
        if (r53 == null) goto L115;
        if (r53.getVisibility() == 8) goto L115;
        if (((LinearLayout.LayoutParams) ((a) r53.getLayoutParams())).weight <= 0.0f) goto L115;
        r53.measure(View.MeasureSpec.makeMeasureSpec(r53.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r45, 1073741824));
    L115:
        r52 = r52 + 1;
        goto L106
    L99:
        if (r26 <= 0.0f) goto L101;
    L117:
        float r54 = this.f1010q;
        if (r54 <= 0.0f) goto L120;
        r26 = r54;
    L120:
        this.f1009p = 0;
        int r55 = 0;
    L121:
        if (r55 >= r310) goto L156;
        View r56 = getChildAt(r55);
        if (r56.getVisibility() == 8) goto L155;
        a r126 = (a) r56.getLayoutParams();
        float r127 = ((LinearLayout.LayoutParams) r126).weight;
        if (r127 <= 0.0f) goto L138;
        int r128 = (int) ((r123 * r127) / r26);
        r26 = r26 - r127;
        int r129 = r123 - r128;
        int r130 = ViewGroup.getChildMeasureSpec(r39, ((getPaddingRight() + getPaddingLeft()) + ((LinearLayout.LayoutParams) r126).leftMargin) + ((LinearLayout.LayoutParams) r126).rightMargin, ((LinearLayout.LayoutParams) r126).width);
        if (((LinearLayout.LayoutParams) r126).height == 0) goto L130;
    L134:
        int r131 = r56.getMeasuredHeight() + r128;
        if (r131 >= 0) goto L137;
    L136:
        r131 = 0;
    L137:
        r56.measure(r130, View.MeasureSpec.makeMeasureSpec(r131, 1073741824));
        r120 = View.combineMeasuredStates(r120, r56.getMeasuredState() & (-256));
        r123 = r129;
        goto L138
    L130:
        if (r47 != 1073741824) goto L134;
        if (r128 <= 0) goto L136;
        r131 = r128;
    L138:
        int r132 = ((LinearLayout.LayoutParams) r126).leftMargin + ((LinearLayout.LayoutParams) r126).rightMargin;
        int r133 = r56.getMeasuredWidth() + r132;
        int r57 = Math.max(r46, r133);
        if (r43 == 1073741824) goto L143;
        int r134 = r57;
        int r58 = -1;
        if (((LinearLayout.LayoutParams) r126).width != (-1)) goto L144;
        boolean r59 = r211;
    L145:
        if (r59 == true) goto L148;
        r132 = r133;
    L148:
        int r60 = Math.max(r44, r132);
        if (r24 == true) goto L151;
    L153:
        boolean r61 = false;
    L154:
        int r62 = this.f1009p;
        this.f1009p = Math.max(r62, (((r56.getMeasuredHeight() + r62) + ((LinearLayout.LayoutParams) r126).topMargin) + ((LinearLayout.LayoutParams) r126).bottomMargin) + 0);
        r24 = r61;
        r46 = r134;
        r44 = r60;
        goto L155
    L151:
        if (((LinearLayout.LayoutParams) r126).width != r58) goto L153;
        r61 = r211;
    L144:
        r59 = false;
        goto L145
    L143:
        r134 = r57;
        r58 = -1;
    L155:
        r55 = r55 + 1;
        r47 = r47;
        goto L121
    L156:
        this.f1009p = (getPaddingBottom() + getPaddingTop()) + this.f1009p;
        goto L116
    L83:
        if (r47 == Integer.MIN_VALUE) goto L85;
        if (r47 != 0) goto L95;
    L85:
        int r63 = 0;
        this.f1009p = 0;
        int r135 = 0;
    L86:
        if (r135 >= r310) goto L95;
        View r136 = getChildAt(r135);
        if (r136 != null) goto L91;
        this.f1009p += r63;
    L94:
        r135 = r135 + 1;
        r63 = 0;
        goto L86
    L91:
        if (r136.getVisibility() != 8) goto L93;
        r135 = r135 + 0;
        goto L94
    L93:
        a r64 = (a) r136.getLayoutParams();
        int r137 = this.f1009p;
        this.f1009p = Math.max(r137, (((r137 + r45) + ((LinearLayout.LayoutParams) r64).topMargin) + ((LinearLayout.LayoutParams) r64).bottomMargin) + 0);
        goto L94
    L78:
        if (i(r310) == false) goto L80;
        this.f1009p += this.f1016w;
        goto L80
    L172:
        this.f1009p = 0;
        int r65 = getVirtualChildCount();
        int r138 = View.MeasureSpec.getMode(r39);
        int r139 = View.MeasureSpec.getMode(r40);
        if (this.f1012s != null) goto L175;
    L176:
        this.f1012s = new int[4];
        this.f1013t = new int[4];
    L177:
        int[] r140 = this.f1012s;
        int[] r141 = this.f1013t;
        r140[3] = -1;
        r140[2] = -1;
        r140[1] = -1;
        r140[0] = -1;
        r141[3] = -1;
        r141[2] = -1;
        r141[1] = -1;
        r141[0] = -1;
        boolean r66 = this.f1004a;
        boolean r67 = this.f1011r;
        if (r138 != 1073741824) goto L180;
        boolean r142 = true;
    L181:
        boolean r213 = true;
        int r68 = 0;
        float r69 = 0.0f;
        int r70 = 0;
        int r71 = 0;
        int r143 = 0;
        int r144 = 0;
        boolean r214 = false;
        boolean r215 = false;
        int r311 = 0;
    L182:
        if (r71 >= r65) goto L258;
        View r72 = getChildAt(r71);
        if (r72 != null) goto L186;
        this.f1009p += 0;
        int r216 = r68;
        int r217 = r70;
    L189:
        boolean r312 = r66;
        r68 = r216;
        r70 = r217;
        boolean r218 = r67;
    L257:
        r71 = r71 + 1;
        r67 = r218;
        r66 = r312;
        goto L182
    L186:
        r216 = r68;
        r217 = r70;
        if (r72.getVisibility() != 8) goto L191;
        r71 = r71 + 0;
        goto L189
    L191:
        if (i(r71) == false) goto L193;
        this.f1009p += this.f1015v;
    L193:
        a r73 = (a) r72.getLayoutParams();
        float r74 = ((LinearLayout.LayoutParams) r73).weight;
        float r219 = r69 + r74;
        if (r138 == 1073741824) goto L196;
    L205:
        int r313 = r71;
        if (((LinearLayout.LayoutParams) r73).width != 0) goto L210;
        float r75 = 0.0f;
        if (r74 <= 0.0f) goto L211;
        ((LinearLayout.LayoutParams) r73).width = -2;
        int r76 = 0;
    L213:
        if (r219 != r75) goto L215;
        int r314 = this.f1009p;
    L216:
        int r315 = r216;
        int r316 = r217;
        int r317 = r76;
        int r220 = r313;
        r218 = r67;
        r312 = r66;
        measureChildWithMargins(r72, r39, r314, r40, 0);
        if (r317 == Integer.MIN_VALUE) goto L219;
        a r77 = r73;
        ((LinearLayout.LayoutParams) r77).width = r317;
    L220:
        int r78 = r72.getMeasuredWidth();
        if (r142 == false) goto L223;
        this.f1009p = (((((LinearLayout.LayoutParams) r77).leftMargin + r78) + ((LinearLayout.LayoutParams) r77).rightMargin) + 0) + this.f1009p;
    L224:
        if (r218 == false) goto L226;
        r143 = Math.max(r78, r143);
    L226:
        boolean r79 = r214;
        int r80 = 1073741824;
    L227:
        if (r139 != r80) goto L229;
    L231:
        boolean r81 = false;
    L232:
        int r82 = ((LinearLayout.LayoutParams) r77).topMargin + ((LinearLayout.LayoutParams) r77).bottomMargin;
        int r83 = r72.getMeasuredHeight() + r82;
        int r84 = View.combineMeasuredStates(r144, r72.getMeasuredState());
        if (r312 == false) goto L241;
        int r85 = r72.getBaseline();
        if (r85 == (-1)) goto L241;
        int r145 = ((LinearLayout.LayoutParams) r77).gravity;
        if (r145 >= 0) goto L239;
        r145 = this.f1008o;
    L239:
        int r146 = (((r145 & BWDLInnerConstant.LINK_RECOVERY) >> 4) & (-2)) >> 1;
        r140[r146] = Math.max(r140[r146], r85);
        r141[r146] = Math.max(r141[r146], r83 - r85);
    L241:
        int r86 = Math.max(r311, r83);
        if (r213 == true) goto L244;
    L246:
        boolean r87 = false;
    L248:
        if (((LinearLayout.LayoutParams) r77).weight <= 0.0f) goto L252;
        if (r81 == false) goto L251;
        r83 = r82;
    L251:
        int r88 = Math.max(r316, r83);
        int r89 = r315;
    L256:
        r311 = r86;
        r68 = r89;
        r144 = r84;
        r214 = r79;
        r71 = r220 + 0;
        r213 = r87;
        r70 = r88;
        r69 = r219;
        goto L257
    L252:
        r88 = r316;
        if (r81 == false) goto L255;
        r83 = r82;
    L255:
        r89 = Math.max(r315, r83);
        goto L256
    L244:
        if (((LinearLayout.LayoutParams) r77).height != (-1)) goto L246;
        r87 = true;
        goto L248
    L229:
        if (((LinearLayout.LayoutParams) r77).height != (-1)) goto L231;
        r81 = true;
        r215 = true;
        goto L232
    L223:
        int r90 = this.f1009p;
        this.f1009p = Math.max(r90, (((r90 + r78) + ((LinearLayout.LayoutParams) r77).leftMargin) + ((LinearLayout.LayoutParams) r77).rightMargin) + 0);
        goto L224
    L219:
        r77 = r73;
        goto L220
    L215:
        r314 = 0;
    L211:
        r76 = Integer.MIN_VALUE;
        goto L213
    L210:
        r75 = 0.0f;
        goto L211
    L196:
        if (((LinearLayout.LayoutParams) r73).width != 0) goto L205;
        if (r74 <= 0.0f) goto L205;
        if (r142 == false) goto L201;
        this.f1009p = (((LinearLayout.LayoutParams) r73).leftMargin + ((LinearLayout.LayoutParams) r73).rightMargin) + this.f1009p;
    L202:
        if (r66 == false) goto L204;
        int r91 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r72.measure(r91, r91);
        r77 = r73;
        r315 = r216;
        r316 = r217;
        r220 = r71;
        r218 = r67;
        r312 = r66;
        goto L226
    L204:
        r77 = r73;
        r315 = r216;
        r316 = r217;
        r220 = r71;
        r80 = 1073741824;
        r218 = r67;
        r312 = r66;
        r79 = true;
        goto L227
    L201:
        int r92 = this.f1009p;
        this.f1009p = Math.max(r92, (((LinearLayout.LayoutParams) r73).leftMargin + r92) + ((LinearLayout.LayoutParams) r73).rightMargin);
        goto L202
    L258:
        boolean r221 = r67;
        boolean r318 = r66;
        int r93 = r68;
        int r94 = r311;
        if (this.f1009p > 0) goto L261;
    L263:
        int r95 = r140[1];
        int r222 = r144;
        if (r95 == (-1)) goto L266;
    L273:
        char r96 = 3;
    L274:
        int r319 = Math.max(r94, Math.max(r141[3], Math.max(r141[0], Math.max(r141[1], r141[2]))) + Math.max(r140[r96], Math.max(r140[0], Math.max(r95, r140[2]))));
    L275:
        if (r221 == true) goto L277;
    L292:
        int r97 = (getPaddingRight() + getPaddingLeft()) + this.f1009p;
        this.f1009p = r97;
        int r98 = View.resolveSizeAndState(Math.max(r97, getSuggestedMinimumWidth()), r39, 0);
        int r99 = (16777215 & r98) - this.f1009p;
        if (r214 == true) goto L314;
        if (r99 != 0) goto L296;
    L298:
        int r100 = Math.max(r93, r70);
        if (r221 == true) goto L301;
    L313:
        int r147 = r222;
        int r148 = r139;
        int r101 = 0;
    L382:
        if (r213 == false) goto L384;
    L386:
        r100 = r319;
    L387:
        setMeasuredDimension(r98 | ((-16777216) & r147), View.resolveSizeAndState(Math.max((getPaddingBottom() + getPaddingTop()) + r100, getSuggestedMinimumHeight()), r40, r147 << 16));
        if (r215 == false) goto L439;
        int r102 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    L390:
        if (r101 >= r65) goto L441;
        View r103 = getChildAt(r101);
        if (r103.getVisibility() == 8) goto L397;
        a r149 = (a) r103.getLayoutParams();
        if (((LinearLayout.LayoutParams) r149).height != (-1)) goto L397;
        int r150 = ((LinearLayout.LayoutParams) r149).width;
        ((LinearLayout.LayoutParams) r149).width = r103.getMeasuredWidth();
        measureChildWithMargins(r103, r39, 0, r102, 0);
        ((LinearLayout.LayoutParams) r149).width = r150;
    L397:
        r101 = r101 + 1;
        goto L390
    L441:
        return;
    L439:
        return;
    L384:
        if (r148 == 1073741824) goto L386;
    L301:
        if (r138 == 1073741824) goto L313;
        int r104 = 0;
    L303:
        if (r104 >= r65) goto L313;
        View r105 = getChildAt(r104);
        if (r105 == null) goto L312;
        if (r105.getVisibility() == 8) goto L312;
        if (((LinearLayout.LayoutParams) ((a) r105.getLayoutParams())).weight <= 0.0f) goto L312;
        r105.measure(View.MeasureSpec.makeMeasureSpec(r143, 1073741824), View.MeasureSpec.makeMeasureSpec(r105.getMeasuredHeight(), 1073741824));
    L312:
        r104 = r104 + 1;
        goto L303
    L296:
        if (r69 <= 0.0f) goto L298;
    L314:
        float r106 = this.f1010q;
        if (r106 <= 0.0f) goto L317;
        r69 = r106;
    L317:
        r140[3] = -1;
        r140[2] = -1;
        r140[1] = -1;
        r140[0] = -1;
        r141[3] = -1;
        r141[2] = -1;
        r141[1] = -1;
        r141[0] = -1;
        this.f1009p = 0;
        r147 = r222;
        int r107 = -1;
        int r108 = 0;
    L318:
        if (r108 >= r65) goto L369;
        View r151 = getChildAt(r108);
        if (r151 != null) goto L322;
    L367:
        int r109 = r99;
        int r152 = r139;
    L368:
        r108 = r108 + 1;
        r99 = r109;
        r139 = r152;
        r138 = r138;
        goto L318
    L322:
        if (r151.getVisibility() == 8) goto L367;
        a r153 = (a) r151.getLayoutParams();
        float r154 = ((LinearLayout.LayoutParams) r153).weight;
        if (r154 <= 0.0f) goto L337;
        int r155 = (int) ((r99 * r154) / r69);
        float r156 = r69 - r154;
        int r157 = r99 - r155;
        int r158 = ViewGroup.getChildMeasureSpec(r40, ((getPaddingBottom() + getPaddingTop()) + ((LinearLayout.LayoutParams) r153).topMargin) + ((LinearLayout.LayoutParams) r153).bottomMargin, ((LinearLayout.LayoutParams) r153).height);
        if (((LinearLayout.LayoutParams) r153).width == 0) goto L329;
    L333:
        r155 = r155 + r151.getMeasuredWidth();
        if (r155 >= 0) goto L336;
    L335:
        r155 = 0;
    L336:
        r151.measure(View.MeasureSpec.makeMeasureSpec(r155, 1073741824), r158);
        r147 = View.combineMeasuredStates(r147, r151.getMeasuredState() & (-16777216));
        r69 = r156;
        int r159 = r157;
    L338:
        if (r142 == false) goto L340;
        this.f1009p = (((r151.getMeasuredWidth() + ((LinearLayout.LayoutParams) r153).leftMargin) + ((LinearLayout.LayoutParams) r153).rightMargin) + 0) + this.f1009p;
    L341:
        r152 = r139;
        if (r152 != 1073741824) goto L344;
    L346:
        boolean r160 = false;
    L347:
        int r161 = ((LinearLayout.LayoutParams) r153).topMargin + ((LinearLayout.LayoutParams) r153).bottomMargin;
        int r162 = r151.getMeasuredHeight() + r161;
        r107 = Math.max(r107, r162);
        if (r160 == true) goto L351;
        r161 = r162;
    L351:
        int r163 = Math.max(r93, r161);
        if (r213 == false) goto L356;
        int r164 = -1;
        if (((LinearLayout.LayoutParams) r153).height != (-1)) goto L357;
        boolean r165 = true;
    L358:
        if (r318 == false) goto L366;
        int r166 = r151.getBaseline();
        if (r166 == r164) goto L366;
        int r167 = ((LinearLayout.LayoutParams) r153).gravity;
        if (r167 >= 0) goto L364;
        r167 = this.f1008o;
    L364:
        int r168 = (((r167 & BWDLInnerConstant.LINK_RECOVERY) >> 4) & (-2)) >> 1;
        r140[r168] = Math.max(r140[r168], r166);
        r141[r168] = Math.max(r141[r168], r162 - r166);
    L366:
        r213 = r165;
        r109 = r159;
        r93 = r163;
        r69 = r69;
    L357:
        r165 = false;
        goto L358
    L356:
        r164 = -1;
        goto L357
    L344:
        if (((LinearLayout.LayoutParams) r153).height != (-1)) goto L346;
        r160 = true;
        goto L347
    L340:
        int r169 = this.f1009p;
        this.f1009p = Math.max(r169, (((r151.getMeasuredWidth() + r169) + ((LinearLayout.LayoutParams) r153).leftMargin) + ((LinearLayout.LayoutParams) r153).rightMargin) + 0);
        goto L341
    L329:
        if (r138 != 1073741824) goto L333;
        if (r155 <= 0) goto L335;
    L337:
        r159 = r99;
        goto L338
    L369:
        r148 = r139;
        this.f1009p = (getPaddingRight() + getPaddingLeft()) + this.f1009p;
        int r170 = r140[1];
        if (r170 == (-1)) goto L372;
    L379:
        char r171 = 3;
    L380:
        r101 = 0;
        r319 = Math.max(r107, Math.max(r141[r171], Math.max(r141[0], Math.max(r141[1], r141[2]))) + Math.max(r140[r171], Math.max(r140[0], Math.max(r170, r140[2]))));
    L381:
        r100 = r93;
        goto L382
    L372:
        if (r140[0] != (-1)) goto L379;
        if (r140[2] != (-1)) goto L379;
        r171 = 3;
        if (r140[3] != (-1)) goto L380;
        r319 = r107;
        r101 = 0;
        goto L381
    L277:
        if (r138 == Integer.MIN_VALUE) goto L279;
        if (r138 != 0) goto L292;
    L279:
        int r172 = 0;
        this.f1009p = 0;
        int r173 = 0;
    L280:
        if (r173 >= r65) goto L292;
        View r174 = getChildAt(r173);
        if (r174 != null) goto L285;
        this.f1009p += r172;
    L291:
        r173 = r173 + 1;
        r172 = 0;
        goto L280
    L285:
        if (r174.getVisibility() != 8) goto L287;
        r173 = r173 + 0;
        goto L291
    L287:
        a r175 = (a) r174.getLayoutParams();
        if (r142 == false) goto L290;
        this.f1009p = (((((LinearLayout.LayoutParams) r175).leftMargin + r143) + ((LinearLayout.LayoutParams) r175).rightMargin) + 0) + this.f1009p;
        goto L291
    L290:
        int r176 = this.f1009p;
        this.f1009p = Math.max(r176, (((r176 + r143) + ((LinearLayout.LayoutParams) r175).leftMargin) + ((LinearLayout.LayoutParams) r175).rightMargin) + 0);
        goto L291
    L266:
        if (r140[0] != (-1)) goto L273;
        if (r140[2] != (-1)) goto L273;
        r96 = 3;
        if (r140[3] != (-1)) goto L274;
        r319 = r94;
        goto L275
    L261:
        if (i(r65) == false) goto L263;
        this.f1009p += this.f1015v;
        goto L263
    L180:
        r142 = false;
        goto L181
    L175:
        if (this.f1013t != null) goto L177;
        goto L176
    }

    public void setBaselineAligned(boolean r8) {
        this.f1004a = r8;
    }

    public void setBaselineAlignedChildIndex(int r8) {
        if (r8 < 0) goto L8;
        if (r8 >= getChildCount()) goto L8;
        this.f1005b = r8;
        return;
    L8:
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable r8) {
        if (r8 != this.f1014u) goto L5;
        return;
    L5:
        this.f1014u = r8;
        boolean r10 = false;
        if (r8 == null) goto L8;
        this.f1015v = r8.getIntrinsicWidth();
        this.f1016w = r8.getIntrinsicHeight();
    L9:
        if (r8 != null) goto L11;
        r10 = true;
    L11:
        setWillNotDraw(r10);
        requestLayout();
        return;
    L8:
        this.f1015v = 0;
        this.f1016w = 0;
        goto L9
    }

    public void setDividerPadding(int r8) {
        this.f1018y = r8;
    }

    public void setGravity(int r8) {
        if (this.f1008o != r8) goto L5;
        return;
    L5:
        if ((8388615 & r8) != 0) goto L8;
        r8 = r8 | 8388611;
    L8:
        if ((r8 & BWDLInnerConstant.LINK_RECOVERY) != 0) goto L10;
        r8 = r8 | 48;
    L10:
        this.f1008o = r8;
        requestLayout();
    }

    public void setHorizontalGravity(int r8) {
        int r10 = r8 & 8388615;
        int r11 = this.f1008o;
        if ((8388615 & r11) == r10) goto L6;
        this.f1008o = r10 | ((-8388616) & r11);
        requestLayout();
        return;
    }

    public void setMeasureWithLargestChildEnabled(boolean r8) {
        this.f1011r = r8;
    }

    public void setOrientation(int r8) {
        if (this.f1007n == r8) goto L6;
        this.f1007n = r8;
        requestLayout();
        return;
    }

    public void setShowDividers(int r8) {
        if (r8 == this.f1017x) goto L5;
        requestLayout();
    L5:
        this.f1017x = r8;
    }

    public void setVerticalGravity(int r8) {
        int r10 = r8 & BWDLInnerConstant.LINK_RECOVERY;
        int r11 = this.f1008o;
        if ((r11 & BWDLInnerConstant.LINK_RECOVERY) == r10) goto L6;
        this.f1008o = r10 | (r11 & NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH);
        requestLayout();
        return;
    }

    public void setWeightSum(float r8) {
        this.f1010q = Math.max(0.0f, r8);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context r8, AttributeSet r10) {
        this(r8, r10, 0);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r8) {
        return h(r8);
    }

    public LinearLayoutCompat(Context r13, AttributeSet r14, int r15) {
        super(r13, r14, r15);
        this.f1004a = true;
        this.f1005b = -1;
        this.f1006m = 0;
        this.f1008o = 8388659;
        int[] r8 = c.a.f3228n;
        TypedArray r11 = r13.obtainStyledAttributes(r14, r8, r15, 0);
        v0 r10 = new v0(r13, r11);
        WeakHashMap<View, j0.h0> r12 = j0.w.f8437a;
        j0.w.m.c(this, r13, r8, r14, r11, r15, 0);
        int r16 = r10.h(1, -1);
        if (r16 < 0) goto L5;
        setOrientation(r16);
    L5:
        int r17 = r10.h(0, -1);
        if (r17 < 0) goto L8;
        setGravity(r17);
    L8:
        boolean r18 = r10.a(2, true);
        if (r18 == true) goto L11;
        setBaselineAligned(r18);
    L11:
        this.f1010q = r11.getFloat(4, -1.0f);
        this.f1005b = r10.h(3, -1);
        this.f1011r = r10.a(7, false);
        setDividerDrawable(r10.e(5));
        this.f1017x = r10.h(8, 0);
        this.f1018y = r10.d(6, 0);
        r10.n();
    }
}
