package com.obric.assistant.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001>B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010!\u001a\u00020\"2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0#2\b\b\u0002\u0010$\u001a\u00020%JF\u0010&\u001a\u00020\"2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0#2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020%0(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001c2\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\"\u0018\u00010+J\b\u0010,\u001a\u00020\"H\u0002J0\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0007H\u0014J\u0018\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0007H\u0014J\u001a\u0010:\u001a\u00020\"2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u0002090+J\u0010\u0010<\u001a\u0002092\u0006\u0010=\u001a\u000208H\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00107\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/obric/assistant/view/ObricFlowTagLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "horSpace", "verSpace", "textHorPadding", "textVerPadding", "textSizePx", "", "textViewRadius", "textViewStrokeWidth", "textColor", "textSelectedColor", "textViewStrokeColor", "textViewStrokeSelectColor", "textViewBcgNormalColor", "textViewBcgPressColor", "textViewBcgSelectedColor", "textViewMinHeight", "tags", "", "Lcom/obric/assistant/view/ObricFlowTagLayout$TagBean;", "value", "curSelectedTagBean", "getCurSelectedTagBean", "()Lcom/obric/assistant/view/ObricFlowTagLayout$TagBean;", "addTags", "", "", "enableClick", "", "addTagsInformSelected", "isSelected", "Landroidx/lifecycle/MutableLiveData;", "defaultSelectedTag", "onSelectedChanged", "Lkotlin/Function1;", "updateSelectedStatus", "onLayout", "changed", "left", "top", "right", "bottom", "nextChildIndex", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "providerTagView", "", "Landroid/widget/TextView;", "setTagViewProvide", "provider", "buildTextView", "text", "TagBean", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricFlowTagLayout extends FrameLayout {
    public static final /* synthetic */ int t = 0;
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
    public final List<a> p;
    public a q;
    public final List<Integer> r;
    public Function1<? super String, ? extends TextView> s;

    public static final class a {
        public final String a;
        public final int b;
        public final Object c;

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

        public a(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "txt");
            this.a = r2;
            this.b = r3;
            this.c = null;
        }
    }

    public ObricFlowTagLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ObricFlowTagLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void a() {
        int r0 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        RoundTextView r3 = getChildAt(r2);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.common_ui.widget.roundlayout.RoundTextView");
        RoundTextView r4 = r3;
        if (r4.getTag() != this.q) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
        r4.setTextColor(this.i);
        c29.a r6 = r4.getDelegate();
        r6.i(this.g);
        r6.g(this.k);
        r6.a(this.n);
    L11:
        r2 = r2 + 1;
        goto L3
    L10:
        r4.setTextColor(this.h);
        c29.a r7 = r4.getDelegate();
        r7.i(this.g);
        r7.g(this.j);
        r7.a(this.l);
        goto L11
    L7:
        r5 = false;
        goto L8
    }

    public final a getCurSelectedTagBean() {
        return this.q;
    }

    public final void setTagViewProvide(Function1<? super String, ? extends TextView> r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        this.s = r2;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r11, int r12) {
        super.onMeasure(r11, r12);
        ((ArrayList) this.r).clear();
        int r13 = View.MeasureSpec.getSize(r11);
        int r14 = getChildCount();
        int r2 = 0;
        float r3 = 0.0f;
    L3:
        boolean r4 = true;
        if (r2 >= r14) goto L34;
        View r5 = getChildAt(r2);
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.widget.TextView");
        TextView r6 = (TextView) r5;
        r6.setMaxWidth(r13);
        r6.measure(View.MeasureSpec.makeMeasureSpec(r13, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int r7 = r6.getMeasuredWidth();
        if (r7 < r13) goto L15;
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
        float r10 = r7;
        if (((r9 + r3) + r10) <= r13) goto L26;
        int r15 = r2 - 1;
        if (r15 >= 0) goto L20;
    L24:
        r3 = r10;
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
        r3 = r3 + (r9 + r7);
        goto L32
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
        int r18 = 0;
    L42:
        if (r17.hasNext() == false) goto L51;
        Object r19 = r17.next();
        int r20 = r18 + 1;
        if (r18 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        View r21 = getChildAt(((Number) r19).intValue());
        if (r4 == false) goto L49;
        r0 = r21.getMeasuredHeight();
    L50:
        r18 = r20;
        r4 = false;
        goto L42
    L49:
        r0 = r0 + (this.b + r21.getMeasuredHeight());
        goto L50
    L51:
        setMeasuredDimension(r13, r0);
    }

    public ObricFlowTagLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = r2.getResources().getDimensionPixelSize(v19.c.b(2130971139, r2, 2131166648));
        this.b = r2.getResources().getDimensionPixelSize(v19.c.b(2130971546, r2, 2131167462));
        this.c = r2.getResources().getDimensionPixelSize(v19.c.b(2130971186, r2, 2131166742));
        this.d = r2.getResources().getDimensionPixelSize(v19.c.b(2130971558, r2, 2131167486));
        this.f = r2.getResources().getDimensionPixelSize(v19.c.b(2130971163, r2, 2131166696));
        this.g = r2.getResources().getDimensionPixelSize(v19.c.b(2130971138, r2, 2131166647));
        this.o = r2.getResources().getDimensionPixelSize(v19.c.b(2130971435, r2, 2131167240));
        this.e = r2.getResources().getDimensionPixelSize(v19.c.b(2130971208, r2, 2131166786));
        this.l = ContextCompat.getColor(r2, v19.c.b(2130970535, r2, 2131102548));
        this.m = ContextCompat.getColor(r2, v19.c.b(2130972118, r2, 2131103188));
        this.n = ContextCompat.getColor(r2, v19.c.b(2130972127, r2, 2131103215));
        this.j = ContextCompat.getColor(r2, v19.c.b(2130972087, r2, 2131103162));
        this.k = ContextCompat.getColor(r2, v19.c.b(2130972128, r2, 2131103218));
        this.h = ContextCompat.getColor(r2, v19.c.b(2130972079, r2, 2131103136));
        this.i = ContextCompat.getColor(r2, v19.c.b(2130972123, r2, 2131103203));
        this.p = new ArrayList();
        this.r = new ArrayList();
    }

    public /* synthetic */ ObricFlowTagLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = getChildCount();
        int r10 = 0;
        if (com.larus.utils.i.h(getContext()) == false) goto L11;
        int r11 = r7 - r5;
        int r12 = r11;
        int r13 = 0;
    L5:
        if (r10 >= r9) goto L18;
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
    L18:
        return;
    L11:
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
    L12:
        if (r14 >= r9) goto L25;
        View r3 = getChildAt(r14);
        r3.layout(r15, r16, r3.getMeasuredWidth() + r15, r3.getMeasuredHeight() + r16);
        List<Integer> r17 = this.r;
        ArrayList r18 = (ArrayList) r17;
        if (r18.contains(Integer.valueOf(r14)) == false) goto L16;
        r16 = r16 + (this.b + r3.getMeasuredHeight());
        r15 = 0;
    L17:
        r14 = r14 + 1;
        goto L12
    L16:
        r15 = r15 + (this.a + r3.getMeasuredWidth());
        goto L17
    }
}
