package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n extends FrameLayout implements SpecItemGroupLayout.e, k {
    public int a;
    public int b;
    public int c;
    public int d;
    public final int e;
    public List<c> f;
    public c g;
    public boolean h;
    public int i;
    public int j;
    public b k;
    public final SparseArray<List<View>> l;
    public final ArrayList<Integer> m;
    public GroupTitleLayout n;
    public final int o;
    public boolean p;

    public static final class a {
    }

    public interface b {
        void a();

        void b(int r1);

        void c();

        void d(int r1, c r10, boolean r11);
    }

    public static final class c {
        public boolean a;
        public final String b;
        public final String c;
        public final boolean d;
        public final ECUrlModel e;

        public final int hashCode() {
            int r0 = ((this.b.hashCode() * 31) + this.c.hashCode()) * 31;
            int r10 = 1231;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L6:
            int r11 = (r0 + r1) * 31;
            ECUrlModel r12 = this.e;
            if (r12 == null) goto L9;
            int r13 = r12.hashCode();
        L10:
            int r14 = (r11 + r13) * 31;
            if (this.a == true) goto L15;
            r10 = 1237;
        L15:
            return r14 + r10;
        L9:
            r13 = 0;
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (r10 == null) goto L8;
            Class<?> r11 = r10.getClass();
        L10:
            if ((!Intrinsics.areEqual(c.class, r11)) == false) goto L12;
            return false;
        L12:
            if (r10 == null) goto L30;
            c r12 = (c) r10;
            if ((!Intrinsics.areEqual(this.b, r12.b)) == false) goto L17;
            return false;
        L17:
            if (this.a == r12.a) goto L20;
            return false;
        L20:
            if ((!Intrinsics.areEqual(this.c, r12.c)) == false) goto L23;
            return false;
        L23:
            if (this.d == r12.d) goto L26;
            return false;
        L26:
            if ((!Intrinsics.areEqual(this.e, r12.e)) == false) goto L28;
            return false;
        L28:
            return true;
        L30:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.common.impl.sku.view.SpecItemLayout.ItemViewInfo");
        L8:
            r11 = null;
            goto L10
        }

        public c(String r10, String r11, boolean r12, ECUrlModel r13) {
            Intrinsics.checkNotNullParameter(r10, "itemId");
            Intrinsics.checkNotNullParameter(r11, "text");
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.a = true;
        }
    }

    static {
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemGroupLayout.e
    public c getCheckedItemViewInfo() {
        return this.g;
    }

    public final GroupTitleLayout getMGroupTitleLayout() {
        return this.n;
    }

    public n(Context r10) {
        this(r10, 4, true);
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.k
    public final void a(c r10) {
        Intrinsics.checkNotNullParameter(r10, "itemViewInfo");
        if (this.p == true) goto L5;
        return;
    L5:
        if (r10.a == false) goto L23;
        c r0 = this.g;
        if (r0 == null) goto L13;
        Intrinsics.checkNotNull(r0);
        if (TextUtils.equals(r0.b, r10.b) == false) goto L13;
        f(null);
        this.g = null;
    L17:
        b r11 = this.k;
        if (r11 == null) goto L22;
        r11.d(this.j, this.g, false);
        return;
    L22:
        return;
    L13:
        if (r10.a == false) goto L17;
        f(r10.b);
        this.g = r10;
        b r12 = this.k;
        if (r12 == null) goto L17;
        r12.b(this.j);
        goto L17
    }

    public final int c(float r10) {
        return (int) UIUtils.dip2Px(getContext().getApplicationContext(), r10);
    }

    public final void e(String r10) {
        int r0 = getChildCount();
        int r1 = this.i;
    L3:
        if (r1 >= r0) goto L12;
        View r11 = getChildAt(r1);
        if (r11 == null) goto L11;
        TextView r12 = (TextView) r11;
        int r13 = r1 - this.i;
        if (r13 >= this.f.size()) goto L9;
        b(r12, (c) ListProtector.get(this.f, r13), r10);
    L9:
        r1 = r1 + 1;
        goto L3
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    public final void f(String r10) {
        int r0 = getChildCount();
        int r1 = this.i;
    L3:
        if (r1 >= r0) goto L12;
        Object r11 = getChildAt(r1);
        if (r11 == null) goto L11;
        SpecItemView r12 = (SpecItemView) r11;
        int r13 = r1 - this.i;
        if (r13 >= this.f.size()) goto L9;
        r12.y((c) ListProtector.get(this.f, r13), r10);
    L9:
        r1 = r1 + 1;
        goto L3
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.common.impl.sku.view.SpecItemView");
    }

    public void setCheckedId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "itemId");
        Iterator<c> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        c r1 = r0.next();
        if (TextUtils.equals(r1.b, r10) == false) goto L4;
        this.g = r1;
        this.h = false;
        e(r10);
        return;
    }

    public final void setCheckedItemViewInfo(c r1) {
        this.g = r1;
    }

    public final void setMGroupTitleLayout(GroupTitleLayout r1) {
        this.n = r1;
    }

    public final void setOnItemCheckedListener(b r10) {
        Intrinsics.checkNotNullParameter(r10, "onItemCheckedListener");
        this.k = r10;
    }

    public final c d(String[] r10, cg.g r11) {
        Intrinsics.checkNotNullParameter(r10, "arrayOfStrings");
        Object r0 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        String[] r12 = (String[]) Arrays.copyOf(r10, r10.length);
        int r1 = this.f.size();
        int r13 = 0;
    L6:
        if (r13 >= r1) goto L22;
        c r14 = (c) ListProtector.get(this.f, r13);
        r12[this.j] = r14.b;
        if (r11.a(r12) != true) goto L10;
        boolean r15 = true;
    L11:
        r14.a = r15;
        if (r15 == true) goto L13;
        r13 = r13 + 1;
        goto L6
    L13:
        View r16 = getChildAt(r13 + 1);
        if ((r16 instanceof SpecItemView) == false) goto L17;
        r0 = r16;
    L17:
        SpecItemView r17 = (SpecItemView) r0;
        if (r17 == null) goto L20;
        r17.y(r14, r14.b);
        this.g = r14;
    L20:
        return r14;
    L10:
        r15 = false;
        goto L11
    L22:
        return null;
    }

    public final void g(String[] r10, cg.g r11) {
        Intrinsics.checkNotNullParameter(r10, "checkIdArray");
        String[] r0 = (String[]) Arrays.copyOf(r10, r10.length);
        int r1 = getChildCount();
        int r12 = this.i;
    L3:
        if (r12 >= r1) goto L24;
        int r13 = r12 - this.i;
        if (r11 == null) goto L23;
        if (r13 >= this.f.size()) goto L23;
        c r14 = (c) ListProtector.get(this.f, r13);
        r0[this.j] = r14.b;
        r14.a = r11.a(r0);
        Object r15 = getChildAt(r12);
        String r16 = null;
        if ((r15 instanceof SpecItemView) == true) goto L11;
        r15 = null;
    L11:
        SpecItemView r17 = (SpecItemView) r15;
        if (TextUtils.equals(r10[this.j], r14.b) == true) goto L14;
    L18:
        if (r17 == null) goto L23;
        c r18 = this.g;
        if (r18 == null) goto L22;
        r16 = r18.b;
    L22:
        r17.y(r14, r16);
        goto L23
    L14:
        if (r14.a == true) goto L18;
        if (r17 == null) goto L17;
        r17.y(r14, null);
    L17:
        this.g = null;
    L23:
        r12 = r12 + 1;
        goto L3
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r11, int r12) {
        super.onMeasure(r11, r12);
        int r13 = getChildCount();
        if (r13 != 0) goto L5;
        return;
    L5:
        this.l.clear();
        this.m.clear();
        int r14 = 0;
        int r0 = getChildAt(0).getMeasuredHeight();
        int r1 = getMeasuredWidth();
        int r10 = this.i;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
    L7:
        if (r10 >= r13) goto L20;
        View r18 = getChildAt(r10);
        int r19 = r18.getMeasuredWidth();
        r15 = r15 + r19;
        if (r16 <= 0) goto L11;
        r15 = r15 + this.b;
    L11:
        if (r15 <= r1) goto L13;
        boolean r20 = true;
    L14:
        if (r20 == false) goto L16;
        r17 = r17 + 1;
        r15 = r19;
        r16 = 0;
    L16:
        List<View> r21 = this.l.get(r17);
        if (r21 != null) goto L19;
        r21 = new ArrayList();
        this.l.put(r17, r21);
    L19:
        r21.add(r18);
        r16 = r16 + 1;
        r10 = r10 + 1;
        goto L7
    L13:
        r20 = false;
        goto L14
    L20:
        int r110 = this.l.size();
        int r22 = 0;
    L21:
        if (r22 >= r110) goto L27;
        Iterator<View> r23 = this.l.get(r22).iterator();
        int r24 = 0;
    L24:
        if (r23.hasNext() == false) goto L26;
        r24 = Math.max(r24, r23.next().getMeasuredHeight());
        goto L24
    L26:
        this.m.add(Integer.valueOf(r24));
        r22 = r22 + 1;
        goto L21
    L27:
        Iterator<Integer> r111 = this.m.iterator();
    L29:
        if (r111.hasNext() == false) goto L31;
        r14 = r14 + r111.next().intValue();
        goto L29
    L31:
        int r112 = this.l.size();
        setMeasuredDimension(r1, ((r0 + this.e) + r14) + ((r112 - 1) * this.a));
    }

    public n(Context r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.o = r11;
        this.p = r12;
        this.f = CollectionsKt.emptyList();
        this.j = -1;
        this.l = new SparseArray();
        this.m = new ArrayList();
        this.e = c(12.0f);
        if (r11 != 2) goto L5;
        this.d = (int) UIUtils.dip2Px(r10, 5.0f);
        th.a.a(r10, 2131106228);
        this.b = c(10.0f);
        this.c = c(10.0f);
        this.a = c(10.0f);
        return;
    L5:
        if (r11 != 3) goto L7;
        this.d = (int) UIUtils.dip2Px(r10, 7.0f);
        th.a.a(r10, 2131101247);
        this.b = c(10.0f);
        this.c = c(10.0f);
        this.a = c(10.0f);
        return;
    L7:
        if (r11 == 4) goto L9;
        this.d = (int) UIUtils.dip2Px(r10, 7.0f);
        th.a.a(r10, 2131106228);
        this.b = c(10.0f);
        this.c = c(10.0f);
        this.a = c(10.0f);
        return;
    L9:
        this.d = (int) UIUtils.dip2Px(r10, 6.0f);
        th.a.a(r10, 2131101245);
        this.b = c(8.0f);
        this.c = c(16.0f);
        this.a = c(8.0f);
    }

    public final void b(TextView r10, c r11, String r12) {
        if (this.p == false) goto L20;
        if (r11.a == false) goto L20;
        if (this.g == null) goto L16;
        if (TextUtils.equals(r12, r11.b) == false) goto L16;
        if (this.o != 4) goto L14;
        r10.setBackgroundResource(2131247936);
        r10.setTextColor(th.a.a(getContext(), 2131106181));
        return;
    L14:
        r10.setBackgroundResource(2131247918);
        r10.setTextColor(th.a.a(getContext(), 2131101133));
        return;
    L16:
        if (this.o != 4) goto L18;
        r10.setBackgroundResource(2131247938);
        r10.setTextColor(th.a.a(getContext(), 2131106227));
        return;
    L18:
        r10.setBackgroundResource(2131247942);
        r10.setTextColor(th.a.a(getContext(), 2131101247));
        return;
    L20:
        if (this.o != 4) goto L22;
        r10.setBackgroundResource(2131247938);
    L23:
        r10.setTextColor(th.a.a(getContext(), 2131106229));
        return;
    L22:
        r10.setBackgroundResource(2131247942);
        goto L23
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        View r15 = getChildAt(0);
        int r16 = r15.getMeasuredWidth();
        int r17 = r15.getMeasuredHeight();
        r15.layout(0, 0, r16, r17);
        int r18 = this.l.size();
        int r19 = 0;
        int r110 = 0;
    L6:
        if (r19 >= r18) goto L19;
        List<View> r0 = this.l.get(r19);
        int r1 = r0.size();
        if (r19 != 0) goto L10;
        int r20 = this.e + r17;
    L11:
        r110 = r110 + r20;
        int r21 = 0;
        int r22 = 0;
    L12:
        if (r21 >= r1) goto L18;
        View r23 = (View) ListProtector.get(r0, r21);
        int r24 = r23.getMeasuredWidth();
        int r25 = r23.getMeasuredHeight();
        if (r21 <= 0) goto L16;
        int r26 = (this.b * r21) + r22;
    L17:
        r23.layout(r26, r110, r24 + r26, r25 + r110);
        r22 = r22 + r24;
        r21 = r21 + 1;
        goto L12
    L16:
        r26 = 0;
        goto L17
    L18:
        r19 = r19 + 1;
        goto L6
    L10:
        r20 = ((Number) ListProtector.get(this.m, r19 - 1)).intValue() + this.a;
        goto L11
    }
}
