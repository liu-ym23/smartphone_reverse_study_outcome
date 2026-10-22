package com.larus.bmhome.view.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import rs8.d;
import rs8.e;
import rs8.g;
import rs8.j;
import rs8.n;
import rs8.o;
import rs8.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0003+,-B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u000bH\u0014J,\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0018\u001a\u00020\u000bH\u0014J\r\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J\f\u0010\"\u001a\u00020\u0007*\u00020#H\u0002J\f\u0010$\u001a\u00020\u0007*\u00020#H\u0002J\f\u0010%\u001a\u00020\u0007*\u00020&H\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u0007H\u0002J\f\u0010)\u001a\u00020\u000b*\u00020*H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/bmhome/view/actionbar/AdaptiveMessageActionBar;", "Lcom/larus/bmhome/view/actionbar/NonPriorityMessageActionBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shouldRecalculateStartActionsVisibility", "", "lastWidthMeasureSpec", "lastLayoutSignature", "Lcom/larus/bmhome/view/actionbar/AdaptiveMessageActionBar$LayoutSignature;", "shouldUseCompactActions", "actions", "", "Lcom/larus/bmhome/view/actionbar/IAction;", "shouldSetActionTag", "onActionsRefreshed", "", "newStartActions", "newEndActions", "compactActions", "requiredMinimumWidthToShowAllActions", "()Ljava/lang/Integer;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetStartActionsVisibility", "applyStartActionsVisibility", "parentWidth", "calculateAvailableStartWidth", "occupiedWidth", "Landroid/view/View;", "horizontalMargins", "requiredChildrenWidth", "Landroid/view/ViewGroup;", "shouldReserveRegenerateAvoidWidth", "regenerateAvoidWidth", "hasRegenerateAction", "Landroid/widget/LinearLayout;", "Companion", "LayoutSignature", "ActionLayoutSignature", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdaptiveMessageActionBar extends NonPriorityMessageActionBar {
    public static final Lazy<Integer> k = null;
    public static final Lazy<Integer> l = null;
    public boolean h;
    public int i;
    public c j;

    public static final class a {
        public static final /* synthetic */ int h = 0;
        public final Class<? extends g> a;
        public final String b;
        public final ActionStyle c;
        public final Boolean d;
        public final String e;
        public final Boolean f;
        public final Boolean g;

        /* JADX INFO: renamed from: com.larus.bmhome.view.actionbar.AdaptiveMessageActionBar$a$a, reason: collision with other inner class name */
        public static final class C0045a {
            public static a a(g r10) {
                Intrinsics.checkNotNullParameter(r10, "action");
                Boolean r1 = null;
                if ((r10 instanceof j) == false) goto L5;
                j r0 = (j) r10;
            L7:
                if ((r10 instanceof o) == false) goto L9;
                o r2 = (o) r10;
            L10:
                Class<?> r4 = r10.getClass();
                String r5 = r10.getDescription().toString();
                ActionStyle r3 = r10.getStyle();
                int r6 = a.h;
                boolean r7 = false;
                if ((r10 instanceof j) == true) goto L15;
                if ((r10 instanceof n) == true) goto L15;
            L17:
                boolean r11 = false;
            L18:
                if (r11 == false) goto L20;
                ActionStyle r8 = r3;
            L21:
                if (r0 != null) goto L23;
            L39:
                Boolean r9 = null;
            L40:
                if (r2 == null) goto L42;
                Boolean r12 = Boolean.FALSE;
            L43:
                if (r2 == null) goto L46;
                r1 = Boolean.FALSE;
            L46:
                return new a(r4, r5, r8, r9, r12, r1);
            L42:
                r12 = null;
                goto L43
            L23:
                if ((!StringsKt.isBlank(r0.c)) == true) goto L26;
                r0 = null;
            L26:
                if (r0 == null) goto L39;
                if (r0.d != null) goto L37;
                String r13 = r0.e;
                if (r13 != null) goto L32;
            L35:
                boolean r14 = true;
            L36:
                if (r14 == false) goto L37;
            L38:
                r9 = Boolean.valueOf(r7);
                goto L40
            L32:
                if (r13.length() == 0) goto L35;
                r14 = false;
            L37:
                r7 = true;
                goto L38
            L20:
                r8 = null;
            L15:
                if ((!StringsKt.isBlank(r10.getDescription())) == false) goto L17;
                r11 = true;
                goto L18
            L9:
                r2 = null;
                goto L10
            L5:
                r0 = null;
                goto L7
            }
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            ActionStyle r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Boolean r5 = this.d;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.e;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Boolean r11 = this.f;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Boolean r14 = this.g;
            if (r14 == null) goto L23;
            r2 = r14.hashCode();
        L23:
            return r13 + r2;
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ActionLayoutSignature(type=" + this.a + ", description=" + this.b + ", style=" + this.c + ", imageActionHasVisibleIcon=" + this.d + ", multiSelectedText=" + this.e + ", multiSelectedUseNewStyle=" + this.f + ", multiSelectedHasIcon=" + this.g + ')';
        }

        public final Class<? extends g> getType() {
            return this.a;
        }

        public a(Class r2, String r3, ActionStyle r4, Boolean r5, Boolean r6, Boolean r7) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, "description");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = null;
            this.f = r6;
            this.g = r7;
        }
    }

    public static final class b {
    }

    public static final class c {
        public static final /* synthetic */ int e = 0;
        public final List<a> a;
        public final List<a> b;
        public final boolean c;
        public final boolean d;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            int r2 = 1231;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.d == true) goto L11;
            r2 = 1237;
        L11:
            return r3 + r2;
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "LayoutSignature(startActions=" + this.a + ", endActions=" + this.b + ", compactActions=" + this.c + ", reserveRegenerateAvoidWidth=" + this.d + ')';
        }

        public c(List<a> r2, List<a> r3, boolean r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "startActions");
            Intrinsics.checkNotNullParameter(r3, "endActions");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public AdaptiveMessageActionBar(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AdaptiveMessageActionBar(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        k = LazyKt.lazy(new rs8.b());
        l = LazyKt.lazy(new rs8.c());
    }

    public final int Z5() {
        if (getCompactActions() == false) goto L6;
        return ((Number) l.getValue()).intValue();
    L6:
        return ((Number) k.getValue()).intValue();
    }

    public final boolean c6() {
        LinearLayout r0 = getEndActionContainer();
        int r1 = r0.getChildCount();
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L13;
        g r5 = x.b(r0.getChildAt(r3));
        if (r5 == null) goto L8;
        String r6 = r5.a();
    L10:
        if (Intrinsics.areEqual(r6, "regenerate") == true) goto L11;
        r3 = r3 + 1;
        goto L4
    L11:
        boolean r2 = true;
    L14:
        int r4 = getEndActionContainer().getChildCount();
        int r7 = d.a;
        if (r2 == false) goto L21;
        if (r4 != 1) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L8:
        r6 = null;
        goto L10
    L13:
        r2 = false;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.view.actionbar.NonPriorityMessageActionBar, rs8.h
    public final Integer y3() {
        int r0 = b6(getStartActionContainer());
        int r2 = 0;
        if (getEndActionContainer().getChildCount() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        int r3 = b6(getEndActionContainer());
    L9:
        if (r1 == false) goto L11;
        int r4 = V5(getEndActionContainer());
    L13:
        if (c6() == false) goto L16;
        r2 = Z5();
    L16:
        return Integer.valueOf((((((getPaddingLeft() + getPaddingRight()) + V5(getStartActionContainer())) + r0) + r4) + r3) + r2);
    L11:
        r4 = 0;
        goto L13
    L8:
        r3 = 0;
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    public static int V5(View r2) {
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
    L6:
        int r0 = 0;
        if (r4 == null) goto L9;
        int r1 = r4.leftMargin;
    L10:
        if (r4 == null) goto L13;
        r0 = r4.rightMargin;
    L13:
        return r1 + r0;
    L9:
        r1 = 0;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.larus.bmhome.view.actionbar.NonPriorityMessageActionBar
    public final boolean U5(List<? extends g> r7) {
        Intrinsics.checkNotNullParameter(r7, "actions");
        if (r7.isEmpty() == false) goto L5;
        int r3 = 0;
    L16:
        int r0 = e.a;
        int r8 = r7.size();
        if (r3 != 1) goto L19;
        int r1 = 1;
    L21:
        if ((r8 + r1) > 6) goto L32;
        return false;
    L32:
        return true;
    L19:
        r1 = 0;
        goto L21
    L5:
        Iterator<T> r2 = r7.iterator();
        r3 = 0;
    L7:
        if (r2.hasNext() == false) goto L16;
        if (((g) r2.next()).b() == MessageActionBarAlign.START) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == false) goto L7;
        r3 = r3 + 1;
        if (r3 >= 0) goto L7;
        CollectionsKt.throwCountOverflow();
        goto L7
    L11:
        r4 = false;
        goto L12
    }

    public final int Y5(View r4) {
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

    public final int b6(ViewGroup r6) {
        int r0 = r6.getChildCount();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        View r3 = r6.getChildAt(r1);
        int r4 = d.a;
        r3.measure(r4, r4);
        Intrinsics.checkNotNull(r3);
        r2 = r2 + Y5(r3);
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r13, int r14) {
        if (this.h == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L16;
        int r3 = getStartActionContainer().getChildCount();
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L16;
        View r5 = getStartActionContainer().getChildAt(r4);
        if (r5.getVisibility() == 0) goto L15;
        r5.setVisibility(0);
    L15:
        r4 = r4 + 1;
    L16:
        super.onMeasure(r13, r14);
        if (r0 == false) goto L53;
        int r1 = getMeasuredWidth();
        int r6 = V5(getStartActionContainer());
        if (getEndActionContainer().getChildCount() == 0) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L24;
        int r8 = V5(getEndActionContainer());
    L26:
        if (getEndActionContainer().getChildCount() == 0) goto L28;
        boolean r9 = true;
    L29:
        if (r9 == false) goto L31;
        int r10 = getEndActionContainer().getMeasuredWidth();
    L32:
        int r2 = ((((r1 - getPaddingLeft()) - getPaddingRight()) - r6) - r8) - r10;
        if (c6() == false) goto L35;
        int r11 = Z5();
    L36:
        int r12 = RangesKt.coerceAtLeast(r2 - r11, 0);
        int r15 = getStartActionContainer().getChildCount();
        int r16 = 0;
        boolean r17 = false;
        int r18 = 0;
    L37:
        if (r16 >= r15) goto L51;
        View r19 = getStartActionContainer().getChildAt(r16);
        Intrinsics.checkNotNull(r19);
        int r20 = Y5(r19) + r18;
        if (r20 > r12) goto L41;
        boolean r21 = true;
    L42:
        if (r21 == false) goto L44;
        int r110 = 0;
    L46:
        if (r19.getVisibility() == r110) goto L48;
        r19.setVisibility(r110);
        r17 = true;
    L48:
        if (r21 == false) goto L50;
        r18 = r20;
    L50:
        r16 = r16 + 1;
        goto L37
    L44:
        r110 = 8;
        goto L46
    L41:
        r21 = false;
        goto L42
    L51:
        if (r17 == false) goto L53;
        super.onMeasure(r13, r14);
        goto L53
    L35:
        r11 = 0;
        goto L36
    L31:
        r10 = 0;
        goto L32
    L28:
        r9 = false;
        goto L29
    L24:
        r8 = 0;
        goto L26
    L21:
        r7 = false;
    L53:
        this.i = r13;
        this.h = false;
        return;
    L5:
        if (this.i != r13) goto L8;
        r0 = false;
        goto L9
    }

    public AdaptiveMessageActionBar(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.h = true;
    }

    @Override // com.larus.bmhome.view.actionbar.NonPriorityMessageActionBar
    public final void T5(List<? extends g> r7, List<? extends g> r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "newStartActions");
        Intrinsics.checkNotNullParameter(r8, "newEndActions");
        int r0 = c.e;
        Intrinsics.checkNotNullParameter(r7, "startActions");
        Intrinsics.checkNotNullParameter(r8, "endActions");
        List<? extends g> r10 = r7;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<T> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        g r2 = (g) r11.next();
        int r3 = a.h;
        r1.add(a.C0045a.a(r2));
        goto L4
    L6:
        List<? extends g> r12 = r8;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r5 = r12.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        g r6 = (g) r5.next();
        int r13 = a.h;
        r4.add(a.C0045a.a(r6));
        goto L8
    L10:
        int r14 = d.a;
        boolean r15 = false;
        if ((r12 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r16 = r12.iterator();
    L17:
        if (r16.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(((g) r16.next()).a(), "regenerate") == false) goto L17;
        boolean r17 = true;
    L22:
        int r18 = r8.size();
        if (r17 == false) goto L26;
        if (r18 != 1) goto L26;
        r15 = true;
    L26:
        c r19 = new c(r1, r4, r9, r15);
        if (Intrinsics.areEqual(this.j, r19) == false) goto L29;
        return;
    L29:
        this.j = r19;
        this.h = true;
        requestLayout();
        return;
    L21:
        r17 = false;
        goto L22
    L13:
        if (r12.isEmpty() == false) goto L15;
        goto L15
    }

    public /* synthetic */ AdaptiveMessageActionBar(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
