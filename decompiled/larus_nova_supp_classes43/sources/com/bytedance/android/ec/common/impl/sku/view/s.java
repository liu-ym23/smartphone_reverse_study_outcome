package com.bytedance.android.ec.common.impl.sku.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.sku.SkuStatusDetail;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s extends FrameLayout implements SpecItemOptimizeGroupLayout.e, r {
    public final int a;
    public final int b;
    public final int c;
    public List<c> d;
    public c e;
    public boolean f;
    public int g;
    public int h;
    public GroupTitleOptimizeLayout i;
    public a j;
    public final SparseArray<List<View>> k;
    public final ArrayList<Integer> l;
    public final boolean m;

    public interface a {
        void a();

        void b(int r1);

        void c();

        void d(int r1, c r10, boolean r11);
    }

    public interface b {
        void a(boolean r1);
    }

    public static final class c {
        public boolean a;
        public SkuStatusDetail b;
        public final String c;
        public final String d;
        public final String e;
        public final boolean f;
        public final ECUrlModel g;
        public final Map<String, String> h;
        public final Map<String, String> i;

        public final c a() {
            c r10 = new c(this.c, this.d, this.e, this.f, this.g, this.h, this.i);
            r10.a = this.a;
            r10.b = this.b;
            return r10;
        }

        public final int hashCode() {
            int r0 = ((this.c.hashCode() * 31) + this.d.hashCode()) * 31;
            String r1 = this.e;
            int r10 = 0;
            if (r1 == null) goto L5;
            int r11 = r1.hashCode();
        L6:
            int r12 = (r0 + r11) * 31;
            int r13 = 1231;
            if (this.f == false) goto L9;
            int r14 = 1231;
        L10:
            int r15 = (r12 + r14) * 31;
            ECUrlModel r16 = this.g;
            if (r16 == null) goto L13;
            int r17 = r16.hashCode();
        L14:
            int r18 = (r15 + r17) * 31;
            if (this.a == true) goto L18;
            r13 = 1237;
        L18:
            int r19 = (r18 + r13) * 31;
            Map<String, String> r20 = this.h;
            if (r20 == null) goto L21;
            int r21 = r20.hashCode();
        L22:
            int r22 = (r19 + r21) * 31;
            Map<String, String> r23 = this.i;
            if (r23 == null) goto L25;
            int r24 = r23.hashCode();
        L26:
            int r25 = (r22 + r24) * 31;
            SkuStatusDetail r26 = this.b;
            if (r26 == null) goto L30;
            r10 = r26.hashCode();
        L30:
            return r25 + r10;
        L25:
            r24 = 0;
            goto L26
        L21:
            r21 = 0;
            goto L22
        L13:
            r17 = 0;
            goto L14
        L9:
            r14 = 1237;
            goto L10
        L5:
            r11 = 0;
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
            if (r10 == null) goto L42;
            c r12 = (c) r10;
            if ((!Intrinsics.areEqual(this.c, r12.c)) == false) goto L17;
            return false;
        L17:
            if (this.a == r12.a) goto L20;
            return false;
        L20:
            if ((!Intrinsics.areEqual(this.d, r12.d)) == false) goto L23;
            return false;
        L23:
            if ((!Intrinsics.areEqual(this.e, r12.e)) == false) goto L26;
            return false;
        L26:
            if (this.f == r12.f) goto L29;
            return false;
        L29:
            if ((!Intrinsics.areEqual(this.g, r12.g)) == false) goto L32;
            return false;
        L32:
            if ((!Intrinsics.areEqual(this.h, r12.h)) == false) goto L35;
            return false;
        L35:
            if ((!Intrinsics.areEqual(this.i, r12.i)) == false) goto L38;
            return false;
        L38:
            if ((!Intrinsics.areEqual(this.b, r12.b)) == false) goto L40;
            return false;
        L40:
            return true;
        L42:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeLayout.ItemViewInfoOptimize");
        L8:
            r11 = null;
            goto L10
        }

        public c(String r10, String r11, String r12, boolean r13, ECUrlModel r14, Map<String, String> r15, Map<String, String> r16) {
            Intrinsics.checkNotNullParameter(r10, "itemId");
            Intrinsics.checkNotNullParameter(r11, "text");
            this.c = r10;
            this.d = r11;
            this.e = r12;
            this.f = r13;
            this.g = r14;
            this.h = r15;
            this.i = r16;
            this.a = true;
        }
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeGroupLayout.e
    public c getCheckedItemViewInfo() {
        return this.e;
    }

    public s(Context r10) {
        this(r10, true);
    }

    @Override // com.bytedance.android.ec.common.impl.sku.view.r
    public final void a(c r10) {
        Intrinsics.checkNotNullParameter(r10, "itemViewInfo");
        if (this.m == true) goto L5;
        return;
    L5:
        if (r10.a == false) goto L35;
        c r0 = this.e;
        if (r0 == null) goto L13;
        Intrinsics.checkNotNull(r0);
        if (TextUtils.equals(r0.c, r10.c) == false) goto L13;
        this.e = null;
        this.f = false;
        c(null);
    L17:
        GroupTitleOptimizeLayout r11 = this.i;
        if (r11 == null) goto L20;
        r11.f.setVisibility(8);
    L20:
        a r12 = this.j;
        if (r12 == null) goto L23;
        r12.c();
    L23:
        a r13 = this.j;
        if (r13 == null) goto L27;
        r13.d(this.h, this.e, false);
    L27:
        if (this.e == null) goto L33;
        a r14 = this.j;
        if (r14 == null) goto L34;
        r14.a();
        return;
    L34:
        return;
    L33:
        return;
    L13:
        if (r10.a == false) goto L17;
        this.e = r10;
        this.f = true;
        Intrinsics.checkNotNull(r10);
        c(r10.c);
        a r15 = this.j;
        if (r15 == null) goto L17;
        r15.b(this.h);
        goto L17
    }

    public final void b(int r10) {
        if (r10 != 0) goto L7;
        c r11 = this.e;
        if (r11 == null) goto L17;
        a(r11);
        return;
    L17:
        return;
    L7:
        int r12 = r10 - 1;
        if (r12 < this.d.size()) goto L11;
        return;
    L11:
        if (this.e != null) goto L13;
    L15:
        a((c) ListProtector.get(this.d, r12));
        return;
    L13:
        if (Intrinsics.areEqual((c) ListProtector.get(this.d, r12), this.e) == false) goto L15;
    }

    public final void c(String r10) {
        int r0 = getChildCount();
        int r1 = this.g;
    L3:
        if (r1 >= r0) goto L12;
        Object r11 = getChildAt(r1);
        if (r11 == null) goto L11;
        SpecItemOptimizeView r12 = (SpecItemOptimizeView) r11;
        int r13 = r1 - this.g;
        if (r13 >= this.d.size()) goto L9;
        r12.S5((c) ListProtector.get(this.d, r13), r10);
    L9:
        r1 = r1 + 1;
        goto L3
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.common.impl.sku.view.SpecItemOptimizeView");
    }

    public void setCheckedId(String r10) {
        Intrinsics.checkNotNullParameter(r10, "itemId");
        Iterator<c> r0 = this.d.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        c r1 = r0.next();
        if (TextUtils.equals(r1.c, r10) == false) goto L4;
        this.e = r1;
        this.f = false;
        c(r10);
        return;
    }

    public final void setOnItemCheckedListener(a r10) {
        Intrinsics.checkNotNullParameter(r10, "onItemCheckedListener");
        this.j = r10;
    }

    public s(Context r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.m = r11;
        this.d = CollectionsKt.emptyList();
        this.h = -1;
        this.k = new SparseArray();
        this.l = new ArrayList();
        this.c = (int) UIUtils.dip2Px(getContext().getApplicationContext(), 0.0f);
        this.b = (int) UIUtils.dip2Px(getContext().getApplicationContext(), 4.0f);
        this.a = (int) UIUtils.dip2Px(getContext().getApplicationContext(), 4.0f);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r11, int r12) {
        super.onMeasure(r11, r12);
        int r13 = getChildCount();
        if (r13 != 0) goto L5;
        return;
    L5:
        this.k.clear();
        this.l.clear();
        int r14 = 0;
        int r0 = getChildAt(0).getMeasuredHeight();
        int r1 = getMeasuredWidth();
        int r10 = this.g;
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
        List<View> r21 = this.k.get(r17);
        if (r21 != null) goto L19;
        r21 = new ArrayList();
        this.k.put(r17, r21);
    L19:
        r21.add(r18);
        r16 = r16 + 1;
        r10 = r10 + 1;
        goto L7
    L13:
        r20 = false;
        goto L14
    L20:
        int r110 = this.k.size();
        int r22 = 0;
    L21:
        if (r22 >= r110) goto L27;
        Iterator<View> r23 = this.k.get(r22).iterator();
        int r24 = 0;
    L24:
        if (r23.hasNext() == false) goto L26;
        r24 = Math.max(r24, r23.next().getMeasuredHeight());
        goto L24
    L26:
        this.l.add(Integer.valueOf(r24));
        r22 = r22 + 1;
        goto L21
    L27:
        Iterator<Integer> r111 = this.l.iterator();
    L29:
        if (r111.hasNext() == false) goto L31;
        r14 = r14 + r111.next().intValue();
        goto L29
    L31:
        int r112 = this.k.size();
        setMeasuredDimension(r1, ((r0 + this.c) + r14) + ((r112 - 1) * this.a));
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
        int r18 = this.k.size();
        int r19 = 0;
        int r110 = 0;
    L6:
        if (r19 >= r18) goto L19;
        List<View> r0 = this.k.get(r19);
        int r1 = r0.size();
        if (r19 != 0) goto L10;
        int r20 = this.c + r17;
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
        r20 = ((Number) ListProtector.get(this.l, r19 - 1)).intValue() + this.a;
        goto L11
    }
}
