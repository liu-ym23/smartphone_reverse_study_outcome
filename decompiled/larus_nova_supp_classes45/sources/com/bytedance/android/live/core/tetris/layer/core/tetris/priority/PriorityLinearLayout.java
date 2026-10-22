package com.bytedance.android.live.core.tetris.layer.core.tetris.priority;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002CDB'\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010@\u001a\u00020\u0007¢\u0006\u0004\bA\u0010BJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR.\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00070\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R.\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020+0\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001e\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R.\u00103\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R$\u0010;\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006E"}, d2 = {"Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityLinearLayout;", "Landroid/widget/LinearLayout;", "", "Lu70/a;", "mutexSet", "", "setMutexList", "", "c", "I", "getMaxVisibleCount", "()I", "setMaxVisibleCount", "(I)V", "maxVisibleCount", "", "d", "Z", "getAutoDismissChildViewWhenWidthLimit", "()Z", "setAutoDismissChildViewWhenWidthLimit", "(Z)V", "autoDismissChildViewWhenWidthLimit", "e", "getSpaceMargin", "setSpaceMargin", "spaceMargin", "", "Landroid/view/View;", "f", "Ljava/util/Map;", "getPriorityMap", "()Ljava/util/Map;", "setPriorityMap", "(Ljava/util/Map;)V", "priorityMap", "g", "Ljava/util/Set;", "getMutexPairSet", "()Ljava/util/Set;", "setMutexPairSet", "(Ljava/util/Set;)V", "mutexPairSet", "", "h", "getViewToIdentifyMap", "setViewToIdentifyMap", "viewToIdentifyMap", "i", "getIdentifyToViewMap", "setIdentifyToViewMap", "identifyToViewMap", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityLinearLayout$b;", "j", "Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityLinearLayout$b;", "getChangeListener", "()Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityLinearLayout$b;", "setChangeListener", "(Lcom/bytedance/android/live/core/tetris/layer/core/tetris/priority/PriorityLinearLayout$b;)V", "changeListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "tetris_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PriorityLinearLayout extends LinearLayout {
    public final List<View> a;
    public final List<View> b;
    public int c;
    public boolean d;
    public int e;
    public Map<View, Integer> f;
    public Set<u70.a> g;
    public Map<View, String> h;
    public Map<String, View> i;
    public b j;

    public static final class a {
    }

    public interface b {
        void a(List<? extends View> r1, List<? extends View> r2, List<? extends View> r3);
    }

    public static final class c<T> implements Comparator<T> {
        public final /* synthetic */ PriorityLinearLayout a;

        public c(PriorityLinearLayout r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            Map<View, Integer> r0 = this.a.getPriorityMap();
            Integer r4 = r0.get((View) r3);
            Map<View, Integer> r1 = this.a.getPriorityMap();
            return ComparisonsKt.compareValues(r4, r1.get((View) r2));
        }
    }

    static {
    }

    public PriorityLinearLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PriorityLinearLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        if (this.c != (-1)) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        r0.addAll(this.a);
        ((ArrayList) this.b).clear();
        ((ArrayList) this.a).clear();
        int r1 = getChildCount();
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L15;
        View r4 = super.getChildAt(r3);
        if (r4.getMeasuredWidth() <= 0) goto L14;
        if (r4.getMeasuredHeight() <= 0) goto L14;
        if (a(r4) == false) goto L14;
        ((ArrayList) this.a).add(r4);
    L14:
        r3 = r3 + 1;
        goto L6
    L15:
        ArrayList r2 = (ArrayList) this.a;
        if (r2.size() <= 1) goto L18;
        CollectionsKt.sortWith(r2, new c(this));
    L18:
        Iterator r5 = ((ArrayList) this.a).iterator();
    L20:
        if (r5.hasNext() == false) goto L32;
        View r6 = (View) r5.next();
        String r7 = this.h.get(r6);
        Intrinsics.checkNotNull(r7);
        String r8 = r7;
        Iterator<T> r9 = this.g.iterator();
    L23:
        if (r9.hasNext() == false) goto L20;
        u70.a r11 = (u70.a) r9.next();
        if (Intrinsics.areEqual(r11.b, r8) == false) goto L23;
        View r12 = this.i.get(r11.a);
        if (CollectionsKt.contains(this.a, r12) == false) goto L23;
        Integer r13 = this.f.get(r12);
        Intrinsics.checkNotNull(r13);
        int r14 = r13.intValue();
        Integer r15 = this.f.get(r6);
        Intrinsics.checkNotNull(r15);
        if (r14 <= r15.intValue()) goto L23;
        r5.remove();
    L32:
        if (((ArrayList) this.a).size() <= this.c) goto L35;
        List<View> r16 = this.a;
        ListProtector.remove(r16, ((ArrayList) r16).size() - 1);
        goto L32
    L35:
        if (this.d == false) goto L47;
        Iterator r17 = ((ArrayList) this.a).iterator();
        int r18 = 0;
    L38:
        if (r17.hasNext() == false) goto L47;
        View r19 = (View) r17.next();
        ViewGroup.LayoutParams r21 = r19.getLayoutParams();
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == true) goto L42;
        r21 = null;
    L42:
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
        if (r22 == null) goto L38;
        r18 = r18 + ((r19.getMeasuredWidth() + r22.leftMargin) + r22.rightMargin);
        if (r18 <= getWidth()) goto L38;
        r17.remove();
    L47:
        List<View> r23 = this.b;
        ArrayList r24 = (ArrayList) r23;
        r24.addAll(this.a);
        int r25 = getChildCount();
        int r26 = 0;
    L48:
        if (r26 >= r25) goto L53;
        View r27 = super.getChildAt(r26);
        if (((ArrayList) this.b).contains(r27) == true) goto L52;
        ((ArrayList) this.b).add(r27);
    L52:
        r26 = r26 + 1;
        goto L48
    L53:
        ArrayList r28 = new ArrayList();
        Iterator r29 = r0.iterator();
    L55:
        if (r29.hasNext() == false) goto L59;
        View r31 = (View) r29.next();
        if (((ArrayList) this.a).contains(r31) == true) goto L55;
        r28.add(r31);
        goto L55
    L59:
        ArrayList r32 = new ArrayList();
        Iterator r33 = ((ArrayList) this.a).iterator();
    L61:
        if (r33.hasNext() == false) goto L65;
        View r34 = (View) r33.next();
        if (r0.contains(r34) == true) goto L61;
        r32.add(r34);
        goto L61
    L65:
        b r35 = this.j;
        if (r35 == null) goto L68;
        r35.a(this.a, r28, r32);
    L68:
        int r36 = ((ArrayList) this.a).size();
        int r37 = 0;
    L69:
        if (r37 >= r36) goto L95;
        View r38 = getChildAt(r37);
        if (r38 == null) goto L94;
        ViewGroup.LayoutParams r39 = r38.getLayoutParams();
        if (r39 == null) goto L93;
        LinearLayout.LayoutParams r41 = (LinearLayout.LayoutParams) r39;
        if (getOrientation() != 1) goto L84;
        if (r37 == 0) goto L78;
    L80:
        if (r37 == 0) goto L94;
        if (r41.topMargin != 0) goto L94;
        r41.topMargin = this.e;
        r38.setLayoutParams(r41);
        goto L94
    L78:
        if (r41.topMargin == 0) goto L80;
        r41.topMargin = 0;
        r38.setLayoutParams(r41);
        goto L80
    L84:
        if (r37 == 0) goto L86;
    L88:
        if (r37 == 0) goto L94;
        if (r41.leftMargin != 0) goto L94;
        r41.leftMargin = this.e;
        r38.setLayoutParams(r41);
        goto L94
    L86:
        if (r41.leftMargin == 0) goto L88;
        r41.leftMargin = 0;
        r38.setLayoutParams(r41);
        goto L88
    L93:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L94:
        r37 = r37 + 1;
        goto L69
    }

    public final boolean getAutoDismissChildViewWhenWidthLimit() {
        return this.d;
    }

    public final b getChangeListener() {
        return this.j;
    }

    public final Map<String, View> getIdentifyToViewMap() {
        return this.i;
    }

    public final int getMaxVisibleCount() {
        return this.c;
    }

    public final Set<u70.a> getMutexPairSet() {
        return this.g;
    }

    public final Map<View, Integer> getPriorityMap() {
        return this.f;
    }

    public final int getSpaceMargin() {
        return this.e;
    }

    public final Map<View, String> getViewToIdentifyMap() {
        return this.h;
    }

    public static boolean a(View r6) {
        if ((r6 instanceof ViewGroup) == false) goto L5;
        ViewGroup r7 = (ViewGroup) r6;
        if (r7.getVisibility() == 0) goto L13;
        return false;
    L13:
        if (r7.getChildCount() != 0) goto L15;
        return true;
    L15:
        int r0 = r7.getChildCount();
        int r3 = 0;
    L16:
        if (r3 >= r0) goto L23;
        View r4 = r7.getChildAt(r3);
        if (r4.getVisibility() != 0) goto L22;
        if (a(r4) == false) goto L22;
        return true;
    L22:
        r3 = r3 + 1;
        goto L16
    L23:
        return false;
    L5:
        if (r6.getVisibility() == 0) goto L28;
        return false;
    L28:
        return true;
    }

    @Override // android.view.ViewGroup
    public final View getChildAt(int r3) {
        if (this.c == (-1)) goto L10;
        if (r3 >= ((ArrayList) this.b).size()) goto L10;
        return (View) ListProtector.get(this.b, r3);
    L10:
        return super.getChildAt(r3);
    }

    public final void setAutoDismissChildViewWhenWidthLimit(boolean r1) {
        this.d = r1;
    }

    public final void setChangeListener(b r1) {
        this.j = r1;
    }

    public final void setIdentifyToViewMap(Map<String, View> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    public final void setMaxVisibleCount(int r1) {
        this.c = r1;
    }

    public final void setMutexList(Set<u70.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "mutexSet");
        this.g = r2;
        invalidate();
    }

    public final void setMutexPairSet(Set<u70.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
    }

    public final void setPriorityMap(Map<View, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }

    public final void setSpaceMargin(int r1) {
        this.e = r1;
    }

    public final void setViewToIdentifyMap(Map<View, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.h = r2;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r17, int r18) {
        int r9 = 0;
        if (getOrientation() != 1) goto L25;
        int r11 = View.MeasureSpec.getMode(r17);
        int r12 = View.MeasureSpec.getMode(r18);
        int r13 = View.MeasureSpec.getSize(r17);
        int r14 = View.MeasureSpec.getSize(r18);
        int r15 = ((ArrayList) this.b).size();
        int r16 = 0;
    L5:
        if (r16 >= r15) goto L7;
        measureChildWithMargins((View) ListProtector.get(this.b, r16), r17, 0, r18, 0);
        r16 = r16 + 1;
        goto L5
    L7:
        b();
        int r0 = ((ArrayList) this.a).size();
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r9 >= r0) goto L17;
        View r3 = (View) ListProtector.get(this.a, r9);
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 == null) goto L16;
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        r1 = r1 + ((r3.getMeasuredHeight() + r5.topMargin) + r5.bottomMargin);
        if (r2 >= r3.getMeasuredWidth()) goto L14;
        r2 = r3.getMeasuredWidth();
    L14:
        r9 = r9 + 1;
        goto L8
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L17:
        int r6 = r1 + (getPaddingTop() + getPaddingBottom());
        int r7 = r2 + (getPaddingRight() + getPaddingLeft());
        if (r12 == 1073741824) goto L21;
        r14 = r6;
    L21:
        if (r11 == 1073741824) goto L24;
        r13 = r7;
    L24:
        setMeasuredDimension(r13, r14);
        return;
    L25:
        int r19 = View.MeasureSpec.getMode(r17);
        int r110 = View.MeasureSpec.getMode(r18);
        int r111 = View.MeasureSpec.getSize(r17);
        int r112 = View.MeasureSpec.getSize(r18);
        int r113 = getChildCount();
        int r114 = 0;
    L26:
        if (r114 >= r113) goto L28;
        measureChildWithMargins(super.getChildAt(r114), r17, 0, r18, 0);
        r114 = r114 + 1;
        goto L26
    L28:
        b();
        int r8 = ((ArrayList) this.a).size();
        int r21 = 0;
        int r22 = 0;
    L29:
        if (r9 >= r8) goto L38;
        View r23 = (View) ListProtector.get(this.a, r9);
        ViewGroup.LayoutParams r24 = r23.getLayoutParams();
        if (r24 == null) goto L37;
        ViewGroup.MarginLayoutParams r25 = (ViewGroup.MarginLayoutParams) r24;
        r21 = r21 + ((r23.getMeasuredWidth() + r25.leftMargin) + r25.rightMargin);
        if (r22 >= r23.getMeasuredHeight()) goto L35;
        r22 = r23.getMeasuredHeight();
    L35:
        r9 = r9 + 1;
        goto L29
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L38:
        int r26 = r21 + (getPaddingLeft() + getPaddingRight());
        int r27 = r22 + (getPaddingTop() + getPaddingBottom());
        if (r110 == 1073741824) goto L42;
        r112 = r27;
    L42:
        if (r19 == 1073741824) goto L45;
        r111 = r26;
    L45:
        setMeasuredDimension(r111, r112);
    }

    public PriorityLinearLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = -1;
        this.f = new LinkedHashMap();
        this.g = SetsKt.emptySet();
        this.h = new LinkedHashMap();
        this.i = new LinkedHashMap();
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r2, View r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (CollectionsKt.contains(this.a, r3) == true) goto L7;
        return false;
    L7:
        return super.drawChild(r2, r3, r4);
    }

    public /* synthetic */ PriorityLinearLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
