package com.larus.feedback.api.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.utils.i;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0017\u0018\u0000 M2\u00020\u0001:\u0003KLMB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020&J\u001e\u0010.\u001a\u00020,2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0/2\b\b\u0002\u00100\u001a\u000201J\"\u00102\u001a\u00020,2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0/2\f\u00103\u001a\b\u0012\u0004\u0012\u00020104J\u0014\u00105\u001a\u00020,2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001c07J\u0006\u00108\u001a\u00020,J\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001c0/J\u001a\u0010:\u001a\u00020,2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(J0\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u0002012\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0014J\u0018\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0014J\u0010\u0010E\u001a\u00020,2\u0006\u0010F\u001a\u00020\u001cH\u0002J\b\u0010G\u001a\u00020,H\u0002J\b\u0010H\u001a\u00020,H\u0002J\u0010\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020)H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001ej\b\u0012\u0004\u0012\u00020\u001c`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\u0010!\u001a\u0004\u0018\u00010\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/larus/feedback/api/view/FlowTagLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "horSpace", "verSpace", "textHorPadding", "textVerPadding", "textSizePx", "", "textViewRadius", "textViewStrokeWidth", "textViewMinHeight", "textViewBcgNormalColor", "textViewBcgPressColor", "textViewBcgSelectedColor", "textViewStrokeColor", "textViewStrokeSelectColor", "textColor", "textSelectedColor", "tags", "", "Lcom/larus/feedback/api/view/FlowTagLayout$TagBean;", "selectedTagSet", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "nextChildIndex", "value", "curSelectedTagBean", "getCurSelectedTagBean", "()Lcom/larus/feedback/api/view/FlowTagLayout$TagBean;", "selectionMode", "Lcom/larus/feedback/api/view/FlowTagLayout$SelectionMode;", "providerTagView", "Lkotlin/Function1;", "", "Landroid/widget/TextView;", "setSelectionMode", "", "mode", "addTags", "", "enableClick", "", "addTagsInformSelected", "isSelected", "Landroidx/lifecycle/MutableLiveData;", "setSelectedTags", "selectedTags", "", "clearSelection", "getSelectedTagBeans", "setTagViewProvide", "provider", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTagClicked", "tagBean", "syncSelectionState", "updateSelectedStatus", "buildTextView", "text", "SelectionMode", "TagBean", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowTagLayout extends FrameLayout {
    public static final /* synthetic */ int v = 0;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final List<b> p;
    public final LinkedHashSet<b> q;
    public final List<Integer> r;
    public b s;
    public SelectionMode t;
    public Function1<? super String, ? extends TextView> u;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/feedback/api/view/FlowTagLayout$SelectionMode;", "", "<init>", "(Ljava/lang/String;I)V", "SINGLE", "MULTI", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SelectionMode extends Enum<SelectionMode> {
        public static final SelectionMode MULTI = null;
        public static final SelectionMode SINGLE = null;
        public static final /* synthetic */ SelectionMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<SelectionMode> getEntries() {
            return b;
        }

        static {
            SelectionMode r0 = new SelectionMode("SINGLE", 0);
            SINGLE = r0;
            SelectionMode r1 = new SelectionMode("MULTI", 1);
            MULTI = r1;
            SelectionMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static SelectionMode[] values() {
            return (SelectionMode[]) a.clone();
        }

        public static SelectionMode valueOf(String r1) {
            return (SelectionMode) r27.a.a(SelectionMode.class, r1);
        }

        public SelectionMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static int a(int r1, Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Resources r3 = r2.getResources();
            return (int) TypedValue.applyDimension(1, r1, WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()));
        }
    }

    public static final class b {
        public final String a;
        public final int b;
        public final Object c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            Object r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "TagBean(txt=" + this.a + ", tag=" + this.b + ", extra=" + this.c + ')';
        }

        public b(String r2, int r3, FeedbackMeta r4) {
            Intrinsics.checkNotNullParameter(r2, "txt");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SelectionMode.values().length];
            r0[SelectionMode.SINGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[SelectionMode.MULTI.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public FlowTagLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FlowTagLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        if (this.t != SelectionMode.SINGLE) goto L17;
        b r0 = (b) CollectionsKt.lastOrNull(this.q);
        if (r0 != null) goto L7;
        r0 = this.s;
    L7:
        this.q.clear();
        if (r0 != null) goto L10;
    L12:
        r0 = null;
    L13:
        this.s = r0;
        if (r0 == null) goto L19;
        this.q.add(r0);
        return;
    L19:
        return;
    L10:
        if (((ArrayList) this.p).contains(r0) == false) goto L12;
    L17:
        this.q.retainAll(CollectionsKt.toSet(this.p));
        this.s = (b) CollectionsKt.lastOrNull(this.q);
    }

    public final List<b> getSelectedTagBeans() {
        return CollectionsKt.toList(this.q);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.widget.TextView, com.larus.common_ui.widget.roundlayout.RoundTextView] */
    public final void b() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L17;
        Object r3 = getChildAt(r2);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundTextView");
        ?? r4 = (RoundTextView) r3;
        Object r5 = r4.getTag();
        if ((r5 instanceof b) == false) goto L7;
        b r6 = (b) r5;
    L8:
        if (r6 != null) goto L10;
    L12:
        boolean r7 = false;
    L13:
        if (r7 == false) goto L15;
        r4.setTextColor(this.o);
        c29.a r8 = r4.getDelegate();
        r8.i(this.g);
        r8.g(this.m);
        r8.a(this.k);
    L16:
        r2 = r2 + 1;
        goto L3
    L15:
        r4.setTextColor(this.n);
        c29.a r9 = r4.getDelegate();
        r9.i(this.g);
        r9.g(this.l);
        r9.a(this.i);
        goto L16
    L10:
        if (this.q.contains(r6) == false) goto L12;
        r7 = true;
        goto L13
    L7:
        r6 = null;
        goto L8
    }

    public final b getCurSelectedTagBean() {
        return this.s;
    }

    public final void setSelectedTags(Collection<b> r3) {
        Intrinsics.checkNotNullParameter(r3, "selectedTags");
        this.q.clear();
        SelectionMode r0 = this.t;
        int r1 = c.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        b r4 = (b) CollectionsKt.lastOrNull(r3);
        this.s = r4;
        if (r4 == null) goto L18;
        this.q.add(r4);
    L18:
        b();
        return;
    L5:
        if (r1 != 2) goto L14;
        Iterator<T> r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        b r2 = (b) r5.next();
        if (((ArrayList) this.p).contains(r2) == false) goto L8;
        this.q.add(r2);
        goto L8
    L12:
        this.s = (b) CollectionsKt.lastOrNull(this.q);
        goto L18
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void setSelectionMode(SelectionMode r2) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        this.t = r2;
        a();
        b();
    }

    public final void setTagViewProvide(Function1<? super String, ? extends TextView> r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.u = r2;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        ((ArrayList) this.r).clear();
        int r12 = View.MeasureSpec.getSize(r10);
        int r13 = getChildCount();
        int r1 = 0;
        int r2 = 0;
        float r3 = 0.0f;
    L3:
        boolean r4 = true;
        if (r2 >= r13) goto L34;
        View r5 = getChildAt(r2);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.TextView");
        TextView r6 = (TextView) r5;
        r6.setMaxWidth(r12);
        r6.measure(View.MeasureSpec.makeMeasureSpec(r12, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r7 = r6.getMeasuredWidth();
        if (r7 < r12) goto L15;
        int r8 = r2 - 1;
        if (r8 >= 0) goto L10;
    L14:
        ((ArrayList) this.r).add(Integer.valueOf(r2));
        r3 = 0.0f;
    L32:
        r2 = r2 + 1;
        goto L3
    L10:
        if (((ArrayList) this.r).isEmpty() == false) goto L12;
    L13:
        ((ArrayList) this.r).add(Integer.valueOf(r8));
        goto L14
    L12:
        if (((Number) CollectionsKt.last(this.r)).intValue() == r8) goto L14;
    L15:
        int r9 = this.a;
        float r14 = r7;
        if (((r9 + r3) + r14) <= r12) goto L26;
        int r15 = r2 - 1;
        if (r15 >= 0) goto L20;
    L24:
        r3 = r14;
        goto L32
    L20:
        if (((ArrayList) this.r).isEmpty() == false) goto L22;
    L23:
        ((ArrayList) this.r).add(Integer.valueOf(r15));
        goto L24
    L22:
        if (((Number) CollectionsKt.last(this.r)).intValue() == r15) goto L24;
    L26:
        if (r3 == 0.0f) goto L29;
        r4 = false;
    L29:
        if (r4 == true) goto L24;
        r14 = r14 + (r3 + r9);
        goto L24
    L34:
        if ((!this.p.isEmpty()) == false) goto L40;
        int r16 = CollectionsKt.getLastIndex(this.p);
        if (((ArrayList) this.r).isEmpty() == false) goto L38;
    L39:
        ((ArrayList) this.r).add(Integer.valueOf(r16));
        goto L40
    L38:
        if (((Number) CollectionsKt.last(this.r)).intValue() != r16) goto L39;
    L40:
        Iterator<T> r17 = this.r.iterator();
        int r0 = 0;
    L42:
        if (r17.hasNext() == false) goto L51;
        Object r18 = r17.next();
        int r20 = r0 + 1;
        if (r0 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        View r21 = getChildAt(((Number) r18).intValue());
        if (r0 != 0) goto L49;
        int r22 = r21.getMeasuredHeight();
    L50:
        r1 = r1 + r22;
        r0 = r20;
        goto L42
    L49:
        r22 = this.b + r21.getMeasuredHeight();
        goto L50
    L51:
        setMeasuredDimension(r12, r1);
    }

    public FlowTagLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = a.a(10, r2);
        this.b = a.a(8, r2);
        this.c = a.a(14, r2);
        this.d = a.a(9, r2);
        this.e = a.a(16, r2);
        this.f = a.a(12, r2);
        this.g = a.a(1, r2);
        this.h = a.a(36, r2);
        this.i = ContextCompat.getColor(r2, v19.c.b(2130970535, r2, 2131102548));
        this.j = ContextCompat.getColor(r2, v19.c.b(2130972118, r2, 2131103188));
        this.k = ContextCompat.getColor(r2, v19.c.b(2130972127, r2, 2131103215));
        this.l = ContextCompat.getColor(r2, v19.c.b(2130972087, r2, 2131103162));
        this.m = ContextCompat.getColor(r2, v19.c.b(2130972128, r2, 2131103218));
        this.n = ContextCompat.getColor(r2, v19.c.b(2130972079, r2, 2131103136));
        this.o = ContextCompat.getColor(r2, v19.c.b(2130972123, r2, 2131103203));
        this.p = new ArrayList();
        this.q = new LinkedHashSet();
        this.r = new ArrayList();
        this.t = SelectionMode.SINGLE;
    }

    public /* synthetic */ FlowTagLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = getChildCount();
        int r10 = 0;
        if (i.h(getContext()) == false) goto L12;
        int r11 = r7 - r5;
        int r12 = r11;
        int r13 = 0;
    L5:
        if (r10 >= r9) goto L11;
        View r0 = getChildAt(r10);
        r0.layout(r12 - r0.getMeasuredWidth(), r13, r12, r0.getMeasuredHeight() + r13);
        List<Integer> r1 = this.r;
        ArrayList r2 = (ArrayList) r1;
        if (r2.contains(Integer.valueOf(r10)) == false) goto L9;
        r13 = r13 + (this.b + r0.getMeasuredHeight());
        r12 = r11;
    L10:
        r10 = r10 + 1;
        goto L5
    L9:
        r12 = (r12 - this.a) - r0.getMeasuredWidth();
        goto L10
    L11:
        return;
    L12:
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L13:
        if (r14 >= r9) goto L19;
        View r3 = getChildAt(r14);
        r3.layout(r15, r16, r3.getMeasuredWidth() + r15, r3.getMeasuredHeight() + r16);
        List<Integer> r17 = this.r;
        ArrayList r18 = (ArrayList) r17;
        if (r18.contains(Integer.valueOf(r14)) == false) goto L17;
        r16 = r16 + (this.b + r3.getMeasuredHeight());
        r15 = 0;
    L18:
        r14 = r14 + 1;
        goto L13
    L17:
        r15 = r15 + (this.a + r3.getMeasuredWidth());
        goto L18
    }
}
