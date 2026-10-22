package com.larus.bmhome.view.actionbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.view.f2;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import rs8.e;
import rs8.g;
import rs8.h;
import rs8.s;
import rs8.t;
import rs8.u;
import rs8.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0015J\u0010\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u000fH\u0002J0\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bH\u0014J,\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\b2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000f03H\u0002J$\u00104\u001a\u00020#2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000f03H\u0002J7\u00107\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\f2\f\u00108\u001a\b\u0012\u0004\u0012\u00020 0\u001d2\b\u00109\u001a\u0004\u0018\u00010\f2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0002\u0010<J\u0016\u0010=\u001a\u00020#2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dH\u0016J\r\u0010?\u001a\u00020\bH\u0016¢\u0006\u0002\u0010@J\u001f\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020 2\b\u00109\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010CJ\n\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0010\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020HH\u0016J\u001c\u0010I\u001a\b\u0012\u0004\u0012\u00020 0\u001d2\f\u00108\u001a\b\u0012\u0004\u0012\u00020 0\u001dH\u0002J6\u0010J\u001a\u00020#2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020 0\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001d2\u0006\u00109\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u0010\u0010L\u001a\u00020#2\u0006\u0010M\u001a\u00020NH\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/larus/bmhome/view/actionbar/PriorityMessageActionBar;", "Landroid/view/ViewGroup;", "Lcom/larus/bmhome/view/actionbar/IMessageActionBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addReplaceRegen", "", "sortViewStackByPriority", "Lkotlin/collections/ArrayDeque;", "Landroid/view/View;", "getSortViewStackByPriority", "()Lkotlin/collections/ArrayDeque;", "sortViewStackByPriority$delegate", "Lkotlin/Lazy;", "topDividerPaint", "Landroid/graphics/Paint;", "getTopDividerPaint", "()Landroid/graphics/Paint;", "topDividerPaint$delegate", "actionbarRemovedPriorityIndex", "", "", "actionbarReservePriorityList", "", "oldActions", "", "Lcom/larus/bmhome/view/actionbar/IAction;", "compactActions", "initPriorityIndex", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "occupiedWidth", "v", "onLayout", "changed", "l", "t", "r", "b", "layoutLeftAnswerAction", "leftStart", "leftViews", "leftVisibleViewsSet", "", "layoutRightAnswerAction", "rightViews", "rightVisibleViewsSet", "refresh", "actions", "useSubscribedColor", "fragment", "Landroidx/fragment/app/Fragment;", "(ZLjava/util/List;Ljava/lang/Boolean;Landroidx/fragment/app/Fragment;)V", "setUpPriorityList", "priorityList", "requiredMinimumWidthToShowAllActions", "()Ljava/lang/Integer;", "update", "action", "(Lcom/larus/bmhome/view/actionbar/IAction;Ljava/lang/Boolean;)Z", "parentView", "Landroid/view/ViewParent;", "getViewGlobalVisibleRect", "rect", "Landroid/graphics/Rect;", "sortActionsByAlign", "calculateDiff", "newActions", "onDraw", "canvas", "Landroid/graphics/Canvas;", "UNSPECIFIED_MEASURE_SPEC", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PriorityMessageActionBar extends ViewGroup implements h {
    public static final Lazy<Integer> i = null;
    public boolean a;
    public final Lazy b;
    public final Lazy c;
    public final Map<String, Integer> d;
    public List<String> e;
    public final List<g> f;
    public boolean g;
    public final int h;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MessageActionBarAlign.values().length];
            r0[MessageActionBarAlign.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MessageActionBarAlign.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c<T> implements Comparator {
        public final /* synthetic */ PriorityMessageActionBar a;

        public c(PriorityMessageActionBar r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            g r6 = x.b((View) r5);
            String r0 = null;
            if (r6 == null) goto L5;
            String r7 = r6.a();
        L6:
            String r1 = "";
            if (r7 != null) goto L9;
            r7 = "";
        L9:
            Integer r8 = Integer.valueOf(x.c(r7, this.a.d));
            g r9 = x.b((View) r4);
            if (r9 == null) goto L12;
            r0 = r9.a();
        L12:
            if (r0 == null) goto L16;
            r1 = r0;
        L16:
            return ComparisonsKt.compareValues(r8, Integer.valueOf(x.c(r1, this.a.d)));
        L5:
            r7 = null;
            goto L6
        }
    }

    public PriorityMessageActionBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PriorityMessageActionBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        new a();
        i = LazyKt.lazy(new s());
    }

    private final ArrayDeque<View> getSortViewStackByPriority() {
        return (ArrayDeque) this.b.getValue();
    }

    private final Paint getTopDividerPaint() {
        return (Paint) this.c.getValue();
    }

    @Override // rs8.h
    public final ViewParent f5() {
        return getParent();
    }

    @Override // rs8.h
    public final Integer y3() {
        int r1 = 0;
        IntRange r0 = RangesKt.until(0, getChildCount());
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        IntIterator r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.add(getChildAt(r3.nextInt()));
        goto L4
    L6:
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L7:
        boolean r6 = true;
        if (r5.hasNext() == false) goto L16;
        Object r7 = r5.next();
        View r8 = (View) r7;
        Intrinsics.checkNotNull(r8);
        if (x.b(r8) != null) goto L13;
        r6 = false;
    L13:
        if (r6 == false) goto L7;
        r4.add(r7);
        goto L7
    L16:
        if (this.a == false) goto L29;
        ListIterator r9 = r4.listIterator(r4.size());
    L19:
        if (r9.hasPrevious() == false) goto L27;
        Object r10 = r9.previous();
        View r11 = (View) r10;
        Intrinsics.checkNotNull(r11);
        g r12 = x.b(r11);
        if (r12 == null) goto L23;
        String r13 = r12.a();
    L25:
        if (Intrinsics.areEqual(r13, "regenerate") == false) goto L19;
    L28:
        View r14 = (View) r10;
    L30:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r4.iterator();
    L32:
        if (r16.hasNext() == false) goto L40;
        Object r17 = r16.next();
        if (((View) r17) == r14) goto L36;
        boolean r18 = true;
    L37:
        if (r18 == false) goto L32;
        r15.add(r17);
        goto L32
    L36:
        r18 = false;
        goto L37
    L40:
        if (r15.isEmpty() == true) goto L55;
        Iterator r19 = r15.iterator();
    L44:
        if (r19.hasNext() == false) goto L55;
        View r20 = (View) r19.next();
        Intrinsics.checkNotNull(r20);
        g r21 = x.b(r20);
        if (r21 == null) goto L48;
        MessageActionBarAlign r22 = r21.b();
    L50:
        if (r22 == MessageActionBarAlign.END) goto L52;
        boolean r23 = true;
    L53:
        if (r23 == false) goto L44;
        boolean r24 = true;
    L57:
        if (r15.isEmpty() == true) goto L72;
        Iterator r25 = r15.iterator();
    L61:
        if (r25.hasNext() == false) goto L72;
        View r26 = (View) r25.next();
        Intrinsics.checkNotNull(r26);
        g r27 = x.b(r26);
        if (r27 == null) goto L65;
        MessageActionBarAlign r28 = r27.b();
    L67:
        if (r28 != MessageActionBarAlign.END) goto L69;
        boolean r29 = true;
    L70:
        if (r29 == false) goto L61;
    L73:
        Iterator r30 = r15.iterator();
        int r31 = 0;
    L75:
        if (r30.hasNext() == false) goto L77;
        View r32 = (View) r30.next();
        int r33 = this.h;
        r32.measure(r33, r33);
        Intrinsics.checkNotNull(r32);
        r31 = r31 + b(r32);
        goto L75
    L77:
        int r34 = (getPaddingLeft() + getPaddingRight()) + r31;
        if (r24 == false) goto L82;
        if (r6 == false) goto L82;
        r1 = ((Number) i.getValue()).intValue();
    L82:
        return Integer.valueOf(r34 + r1);
    L69:
        r29 = false;
        goto L70
    L65:
        r28 = null;
    L72:
        r6 = false;
        goto L73
    L52:
        r23 = false;
        goto L53
    L48:
        r22 = null;
    L55:
        r24 = false;
        goto L57
    L23:
        r13 = null;
        goto L25
    L27:
        r10 = null;
        goto L28
    L29:
        r14 = null;
        goto L30
    }

    public static Unit a(PriorityMessageActionBar r3) {
        ArrayDeque<View> r0 = r3.getSortViewStackByPriority();
        if (r0.size() <= 1) goto L6;
        CollectionsKt.sortWith(r0, new c(r3));
    L6:
        return Unit.INSTANCE;
    }

    public final int b(View r4) {
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        int r5 = r4.getMeasuredWidth();
        int r2 = 0;
        if (r1 == null) goto L9;
        int r3 = r1.leftMargin;
    L10:
        int r6 = r5 + r3;
        if (r1 == null) goto L14;
        r2 = r1.rightMargin;
    L14:
        return r6 + r2;
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // rs8.h
    public final boolean b0(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "rect");
        return getGlobalVisibleRect(r2);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super.onDraw(r9);
        int r0 = getPaddingLeft();
        int r1 = getWidth() - getPaddingRight();
        if (r1 <= r0) goto L6;
        r9.drawRect(r0, 0.0f, r1, 1.0f, getTopDividerPaint());
        return;
    }

    @Override // rs8.h
    public void setUpPriorityList(List<String> r5) {
        Intrinsics.checkNotNullParameter(r5, "priorityList");
        if ((!r5.isEmpty()) == false) goto L11;
        this.e = r5;
        ((LinkedHashMap) this.d).clear();
        Iterator<T> r6 = this.e.iterator();
        int r0 = 0;
    L6:
        if (r6.hasNext() == false) goto L15;
        Object r1 = r6.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        Integer r3 = Integer.valueOf(r0);
        this.d.put((String) r1, r3);
        r0 = r2;
        goto L6
    L15:
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r19, int r20) {
        System.currentTimeMillis();
        int r3 = View.MeasureSpec.getMode(r19);
        int r4 = View.MeasureSpec.getSize(r19);
        int r5 = View.MeasureSpec.getMode(r20);
        int r6 = View.MeasureSpec.getSize(r20);
        int r7 = getPaddingLeft() + getPaddingRight();
        int r8 = getPaddingLeft() + getPaddingRight();
        int r9 = getPaddingTop() + getPaddingBottom();
        int r10 = getChildCount();
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r12 >= r10) goto L26;
        View r15 = getChildAt(r12);
        int r16 = r10;
        if (r15.getVisibility() == 8) goto L25;
        ViewGroup.LayoutParams r11 = r15.getLayoutParams();
        r15.measure(ViewGroup.getChildMeasureSpec(r19, r8, r11.width), ViewGroup.getChildMeasureSpec(r20, r9, r11.height));
        if ((r11 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r11;
    L10:
        if (r17 == null) goto L12;
        int r18 = r17.leftMargin;
    L13:
        if (r17 == null) goto L15;
        int r110 = r17.rightMargin;
    L16:
        int r21 = r18 + r110;
        if (r17 == null) goto L19;
        int r111 = r17.topMargin;
    L20:
        if (r17 == null) goto L22;
        int r112 = r17.bottomMargin;
    L23:
        int r113 = r111 + r112;
        r7 = r7 + (r15.getMeasuredWidth() + r21);
        r13 = Math.max(r13, r15.getMeasuredHeight() + r113);
        r14 = View.combineMeasuredStates(r14, r15.getMeasuredState());
        goto L25
    L22:
        r112 = 0;
        goto L23
    L19:
        r111 = 0;
        goto L20
    L15:
        r110 = 0;
        goto L16
    L12:
        r18 = 0;
        goto L13
    L9:
        r17 = null;
    L25:
        r12 = r12 + 1;
        r10 = r16;
        r8 = r8;
        goto L3
    L26:
        int r22 = Math.max(r7, getSuggestedMinimumWidth());
        int r23 = Math.max((getPaddingTop() + getPaddingBottom()) + r13, getSuggestedMinimumHeight());
        if (r3 == Integer.MIN_VALUE) goto L30;
        if (r3 == 1073741824) goto L31;
        r4 = r22;
    L31:
        if (r5 == Integer.MIN_VALUE) goto L34;
        if (r5 == 1073741824) goto L35;
        r6 = r23;
    L35:
        setMeasuredDimension(View.resolveSizeAndState(r4, r19, r14), View.resolveSizeAndState(r6, r20, r14 << 16));
        return;
    L34:
        r6 = Math.min(r23, r6);
        goto L35
    L30:
        r4 = Math.min(r22, r4);
        goto L31
    }

    @Override // rs8.h
    public boolean update(g r5, Boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "action");
        View r0 = findViewById(r5.getId());
        f2 r2 = null;
        if ((r0 instanceof LinearLayout) == false) goto L5;
        LinearLayout r1 = (LinearLayout) r0;
    L6:
        boolean r3 = false;
        if (r1 != null) goto L10;
        return false;
    L10:
        if ((r1 instanceof f2) == false) goto L12;
        r2 = (f2) r1;
    L12:
        if (r2 != null) goto L14;
        return false;
    L14:
        if (r6 == null) goto L16;
        r3 = r6.booleanValue();
    L16:
        r2.a(r5, r3, this.g);
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public PriorityMessageActionBar(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = LazyKt.lazy(new t());
        setWillNotDraw(false);
        this.c = LazyKt.lazy(new u(r2));
        this.d = new LinkedHashMap();
        this.e = CollectionsKt.emptyList();
        this.f = new ArrayList();
        this.h = View.MeasureSpec.makeMeasureSpec(0, 0);
    }

    public /* synthetic */ PriorityMessageActionBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // rs8.h
    public final void q5(boolean r11, List<? extends g> r12, Boolean r13, Fragment r14) {
        Intrinsics.checkNotNullParameter(r12, "actions");
        this.a = r11;
        ArrayList r1 = new ArrayList();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        Iterator<? extends g> r5 = r12.iterator();
    L3:
        boolean r7 = true;
        if (r5.hasNext() == false) goto L12;
        g r6 = r5.next();
        MessageActionBarAlign r8 = r6.b();
        int r9 = b.a[r8.ordinal()];
        if (r9 != 1) goto L8;
        r1.add(r6);
        goto L3
    L8:
        if (r9 != 2) goto L9;
        r4.add(r6);
        goto L3
    L9:
        r3.add(r6);
        goto L3
    L12:
        List r10 = CollectionsKt.plus(CollectionsKt.plus(r1, r3), r4);
        if (r11 == true) goto L15;
    L31:
        int r0 = 0;
    L32:
        int r15 = RangesKt.coerceAtLeast(r12.size() - r0, 0);
        if (r12.isEmpty() == false) goto L35;
        int r16 = 0;
    L46:
        int r2 = RangesKt.coerceAtLeast(r16 - r0, 0);
        int r17 = e.a;
        if (r2 != 1) goto L49;
        int r18 = 1;
    L51:
        if ((r15 + r18) > 6) goto L54;
        r7 = false;
    L54:
        this.g = r7;
        List<g> r19 = this.f;
        if (r13 == null) goto L57;
        boolean r20 = r13.booleanValue();
    L58:
        x.a(true, getContext(), r10, r19, this, r20, this.g);
        ((ArrayList) this.f).clear();
        ArrayList r21 = (ArrayList) this.f;
        r21.addAll(r10);
        return;
    L57:
        r20 = false;
        goto L58
    L49:
        r18 = 0;
        goto L51
    L35:
        Iterator<T> r22 = r12.iterator();
        r16 = 0;
    L37:
        if (r22.hasNext() == false) goto L46;
        if (((g) r22.next()).b() != MessageActionBarAlign.END) goto L41;
        boolean r23 = true;
    L42:
        if (r23 == false) goto L37;
        r16 = r16 + 1;
        if (r16 >= 0) goto L37;
        CollectionsKt.throwCountOverflow();
        goto L37
    L41:
        r23 = false;
        goto L42
    L15:
        if (r12.isEmpty() == true) goto L28;
        Iterator<T> r24 = r12.iterator();
    L19:
        if (r24.hasNext() == false) goto L28;
        g r25 = (g) r24.next();
        if (Intrinsics.areEqual(r25.a(), "regenerate") == true) goto L23;
    L25:
        boolean r26 = false;
    L26:
        if (r26 == false) goto L19;
        boolean r27 = true;
    L29:
        if (r27 == false) goto L31;
        r0 = 1;
        goto L32
    L23:
        if (r25.b() != MessageActionBarAlign.END) goto L25;
        r26 = true;
    L28:
        r27 = false;
        goto L29
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        int r2 = getPaddingLeft();
        int r1 = (r20 - r18) - getPaddingRight();
        int r3 = ((Number) i.getValue()).intValue();
        IntRange r4 = RangesKt.until(0, getChildCount());
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        IntIterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r6.add(getChildAt(r5.nextInt()));
        goto L4
    L6:
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L7:
        boolean r9 = true;
        if (r8.hasNext() == false) goto L17;
        Object r10 = r8.next();
        View r11 = (View) r10;
        if (r11.getVisibility() == 8) goto L14;
        Intrinsics.checkNotNull(r11);
        if (x.b(r11) == null) goto L14;
    L15:
        if (r9 == false) goto L7;
        r7.add(r10);
    L14:
        r9 = false;
        goto L15
    L17:
        LinkedHashMap r12 = new LinkedHashMap();
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r14 = r7.iterator();
        View r15 = null;
    L19:
        if (r14.hasNext() == false) goto L42;
        View r16 = (View) r14.next();
        Intrinsics.checkNotNull(r16);
        g r110 = x.b(r16);
        if (this.a == false) goto L28;
        if (r110 == null) goto L24;
        String r111 = r110.a();
    L26:
        if (Intrinsics.areEqual(r111, "regenerate") == false) goto L28;
        r15 = r16;
        goto L19
    L24:
        r111 = null;
    L28:
        if (r110 == null) goto L30;
        MessageActionBarAlign r112 = r110.b();
    L31:
        MessageActionBarAlign r113 = MessageActionBarAlign.END;
        if (r112 == r113) goto L35;
        r113 = MessageActionBarAlign.START;
    L35:
        Object r114 = r12.get(r113);
        if (r114 != null) goto L38;
        r114 = new LinkedHashSet();
        r12.put(r113, r114);
    L38:
        ((Set) r114).add(r16);
        Object r115 = r13.get(r113);
        if (r115 != null) goto L41;
        r115 = new ArrayList();
        r13.put(r113, r115);
    L41:
        ((List) r115).add(r16);
        goto L19
    L30:
        r112 = null;
        goto L31
    L42:
        getSortViewStackByPriority().clear();
        ArrayDeque<View> r116 = getSortViewStackByPriority();
        ArrayList r117 = new ArrayList();
        Iterator r118 = r7.iterator();
    L44:
        if (r118.hasNext() == false) goto L52;
        Object r119 = r118.next();
        if (((View) r119) == r15) goto L48;
        boolean r22 = true;
    L49:
        if (r22 == false) goto L44;
        r117.add(r119);
        goto L44
    L48:
        r22 = false;
        goto L49
    L52:
        r116.addAll(r117);
        a(this);
        Iterator r23 = getSortViewStackByPriority().iterator();
        int r120 = 0;
    L54:
        if (r23.hasNext() == false) goto L56;
        r120 = r120 + b((View) r23.next());
        goto L54
    L56:
        Set r24 = (Set) r12.get(MessageActionBarAlign.END);
        if (r24 == null) goto L59;
        boolean r25 = !r24.isEmpty();
    L60:
        if (r25 == false) goto L67;
        Set r26 = (Set) r12.get(MessageActionBarAlign.START);
        if (r26 == null) goto L64;
        boolean r27 = !r26.isEmpty();
    L65:
        if (r27 == false) goto L67;
        boolean r28 = true;
    L68:
        if (r15 != null) goto L86;
        Iterator r29 = r7.iterator();
    L71:
        if (r29.hasNext() == false) goto L84;
        Object r121 = r29.next();
        View r122 = (View) r121;
        Intrinsics.checkNotNull(r122);
        g r123 = x.b(r122);
        if (r123 == null) goto L75;
        String r124 = r123.a();
    L77:
        if (Intrinsics.areEqual(r124, "regenerate") == true) goto L79;
    L81:
        boolean r125 = false;
    L82:
        if (r125 == false) goto L71;
    L85:
        r15 = (View) r121;
        goto L86
    L79:
        if (r123.b() != MessageActionBarAlign.END) goto L81;
        r125 = true;
        goto L82
    L75:
        r124 = null;
        goto L77
    L84:
        r121 = null;
    L86:
        boolean r30 = false;
    L87:
        int r126 = r1 - r2;
        if (r28 == false) goto L90;
        int r31 = r3;
    L92:
        if (r120 <= (r126 - r31)) goto L167;
        View r32 = (View) getSortViewStackByPriority().removeFirstOrNull();
        if (r32 == null) goto L167;
        g r127 = x.b(r32);
        if (r127 == null) goto L100;
        MessageActionBarAlign r128 = r127.b();
        if (r128 == null) goto L100;
    L101:
        r120 = r120 - b(r32);
        Set r129 = (Set) r12.get(r128);
        if (r129 == null) goto L104;
        r129.remove(r32);
    L104:
        int r33 = e.a;
        ArrayDeque<View> r34 = getSortViewStackByPriority();
        ArrayList r130 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r34, 10));
        Iterator r35 = r34.iterator();
    L106:
        if (r35.hasNext() == false) goto L112;
        g r131 = x.b((View) r35.next());
        if (r131 == null) goto L110;
        String r132 = r131.a();
    L111:
        r130.add(r132);
        goto L106
    L110:
        r132 = null;
        goto L111
    L112:
        if (r15 == null) goto L114;
        boolean r36 = true;
    L115:
        Intrinsics.checkNotNullParameter(r130, "remainingActionKeys");
        if (r36 == false) goto L137;
        if (r30 == true) goto L137;
        if (r130.isEmpty() == true) goto L136;
        Iterator r37 = r130.iterator();
    L124:
        if (r37.hasNext() == false) goto L136;
        String r133 = (String) r37.next();
        if (Intrinsics.areEqual(r133, "regen_prev") == false) goto L128;
    L133:
        boolean r134 = true;
    L134:
        if (r134 == false) goto L124;
    L128:
        if (Intrinsics.areEqual(r133, "regen_next") == true) goto L133;
        if (Intrinsics.areEqual(r133, "regenerate") == true) goto L133;
        r134 = false;
    L136:
        boolean r38 = true;
    L138:
        if (r38 == false) goto L155;
        if (r15 == null) goto L155;
        g r39 = x.b(r15);
        if (r39 == null) goto L144;
        MessageActionBarAlign r40 = r39.b();
        if (r40 == null) goto L144;
    L145:
        r120 = r120 + b(r15);
        Object r41 = r12.get(r40);
        if (r41 != null) goto L148;
        r41 = new LinkedHashSet();
        r12.put(r40, r41);
    L148:
        ((Set) r41).add(r15);
        Object r42 = r13.get(r40);
        if (r42 != null) goto L151;
        r42 = new ArrayList();
        r13.put(r40, r42);
    L151:
        List r43 = (List) r42;
        if (r43.contains(r15) == true) goto L154;
        r43.add(r15);
    L154:
        r30 = true;
    L144:
        r40 = MessageActionBarAlign.START;
    L155:
        Set r44 = (Set) r12.get(MessageActionBarAlign.END);
        if (r44 == null) goto L158;
        boolean r45 = !r44.isEmpty();
    L159:
        if (r45 == false) goto L166;
        Set r46 = (Set) r12.get(MessageActionBarAlign.START);
        if (r46 == null) goto L163;
        boolean r47 = !r46.isEmpty();
    L164:
        if (r47 == false) goto L166;
        r28 = true;
        goto L87
    L163:
        r47 = false;
    L166:
        r28 = false;
        goto L87
    L158:
        r45 = false;
    L137:
        r38 = false;
        goto L138
    L114:
        r36 = false;
    L100:
        r128 = MessageActionBarAlign.START;
    L167:
        MessageActionBarAlign r48 = MessageActionBarAlign.START;
        List r49 = (List) r13.get(r48);
        if (r49 != null) goto L170;
        r49 = CollectionsKt.emptyList();
    L170:
        Set r50 = (Set) r12.get(r48);
        if (r50 != null) goto L173;
        r50 = SetsKt.emptySet();
    L173:
        int r51 = 0;
        int r52 = getPaddingTop() + Math.max(0, (((getHeight() - getPaddingTop()) - getPaddingBottom()) - 0) / 2);
        Iterator r53 = r49.iterator();
    L175:
        if (r53.hasNext() == false) goto L193;
        View r54 = (View) r53.next();
        if (r50.contains(r54) == false) goto L178;
        ViewGroup.LayoutParams r55 = r54.getLayoutParams();
        if ((r55 instanceof ViewGroup.MarginLayoutParams) == false) goto L182;
        ViewGroup.MarginLayoutParams r56 = (ViewGroup.MarginLayoutParams) r55;
    L183:
        if (r56 == null) goto L185;
        int r57 = r56.leftMargin;
    L186:
        if (r56 == null) goto L188;
        int r135 = r56.rightMargin;
    L189:
        if (r56 == null) goto L191;
        int r58 = r56.topMargin;
    L192:
        int r136 = r54.getMeasuredWidth();
        int r137 = r54.getMeasuredHeight();
        int r59 = r2 + r57;
        int r138 = r136 + r59;
        int r60 = (r52 - (r137 / 2)) + r58;
        r54.layout(r59, r60, r138, r137 + r60);
        r2 = r138 + r135;
        r51 = 0;
        goto L175
    L191:
        r58 = 0;
        goto L192
    L188:
        r135 = 0;
        goto L189
    L185:
        r57 = 0;
        goto L186
    L182:
        r56 = null;
        goto L183
    L178:
        r54.layout(r51, r51, r51, r51);
        goto L175
    L193:
        MessageActionBarAlign r61 = MessageActionBarAlign.END;
        List r62 = (List) r13.get(r61);
        if (r62 != null) goto L196;
        r62 = CollectionsKt.emptyList();
    L196:
        Set r63 = (Set) r12.get(r61);
        if (r63 != null) goto L199;
        r63 = SetsKt.emptySet();
    L199:
        int r64 = getWidth() - getPaddingRight();
        int r65 = getPaddingTop() + Math.max(0, (((getHeight() - getPaddingTop()) - getPaddingBottom()) - 0) / 2);
        int r66 = r62.size() - 1;
        if (r66 < 0) goto L223;
    L201:
        int r67 = r66 - 1;
        View r68 = (View) ListProtector.get(r62, r66);
        if (r63.contains(r68) == true) goto L204;
        r68.layout(0, 0, 0, 0);
    L220:
        if (r67 < 0) goto L271;
        r66 = r67;
        goto L201
    L271:
        return;
    L204:
        ViewGroup.LayoutParams r69 = r68.getLayoutParams();
        if ((r69 instanceof ViewGroup.MarginLayoutParams) == false) goto L207;
        ViewGroup.MarginLayoutParams r70 = (ViewGroup.MarginLayoutParams) r69;
    L208:
        if (r70 == null) goto L210;
        int r71 = r70.leftMargin;
    L211:
        if (r70 == null) goto L213;
        int r139 = r70.rightMargin;
    L214:
        if (r70 == null) goto L216;
        int r72 = r70.topMargin;
    L217:
        int r140 = r68.getMeasuredWidth();
        int r141 = r68.getMeasuredHeight();
        int r73 = r64 - r139;
        int r142 = r73 - r140;
        int r143 = (r65 - (r141 / 2)) + r72;
        r68.layout(r142, r143, r73, r141 + r143);
        int r144 = r142 - r71;
        if (r144 <= getPaddingLeft()) goto L270;
        r64 = r144;
        goto L220
    L270:
        return;
    L216:
        r72 = 0;
        goto L217
    L213:
        r139 = 0;
        goto L214
    L210:
        r71 = 0;
        goto L211
    L207:
        r70 = null;
        goto L208
    L223:
        return;
    L90:
        r31 = 0;
        goto L92
    L64:
        r27 = false;
    L67:
        r28 = false;
        goto L68
    L59:
        r25 = false;
        goto L60
    }
}
