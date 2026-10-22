package com.ss.android.lark.feed.app.tablayout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public ViewGroup a;
    public final FeedSelectorConfig b;
    public final List<View> c;
    public final List<Integer> d;
    public final List<View> e;
    public final a f;
    public final b g;
    public int h;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r9) {
            int r0 = ((ArrayList) this.a.c).indexOf(r9);
            this.a.b.getClass();
            e r1 = this.a;
            List<View> r2 = r1.c;
            boolean r3 = true;
            if (r0 >= 0) goto L5;
        L7:
            boolean r5 = false;
        L8:
            if (r5 == false) goto L11;
            r3 = ((Boolean) r1.b.f.invoke(ListProtector.get(r2, r0), Integer.valueOf(r0), true, Boolean.TRUE)).booleanValue();
        L11:
            if (r3 == true) goto L17;
            e r4 = this.a;
            int r6 = ((ArrayList) r4.c).indexOf(r9);
            if ((r9 instanceof CompoundButton) == false) goto L15;
            this.a.b.getClass();
        L15:
            r4.d(r6, true, true, true, false);
            return;
        L17:
            return;
        L5:
            if (r0 >= ((ArrayList) r2).size()) goto L7;
            r5 = true;
            goto L8
        }
    }

    public static final class b implements View.OnLongClickListener {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r5) {
            int r6 = ((ArrayList) this.a.c).indexOf(r5);
            e r0 = this.a;
            List<View> r1 = r0.c;
            if (r6 >= 0) goto L5;
        L7:
            boolean r3 = false;
        L8:
            if (r3 == true) goto L11;
            return false;
        L11:
            return ((Boolean) r0.b.g.invoke(ListProtector.get(r1, r6), Integer.valueOf(r6))).booleanValue();
        L5:
            if (r6 >= ((ArrayList) r1).size()) goto L7;
            r3 = true;
            goto L8
        }
    }

    public final List<Integer> a() {
        ((ArrayList) this.d).clear();
        Iterator r0 = ((ArrayList) this.c).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (c((View) r2) == false) goto L11;
        List<Integer> r4 = this.d;
        ArrayList r5 = (ArrayList) r4;
        r5.add(Integer.valueOf(r1));
    L11:
        r1 = r3;
        goto L4
    L13:
        return this.d;
    }

    public final List<View> b() {
        ((ArrayList) this.e).clear();
        Iterator r0 = ((ArrayList) this.c).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L15;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r4 = (View) r2;
        if (c(r4) == false) goto L11;
    L12:
        ((ArrayList) this.e).add(r4);
    L13:
        r1 = r3;
        goto L4
    L11:
        if (r1 != this.h) goto L13;
    L15:
        return this.e;
    }

    public final void g() {
        ViewGroup r0 = this.a;
        if (r0 == null) goto L10;
        int r1 = r0.getChildCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L14;
        View r3 = r0.getChildAt(r2);
        if (r3 == null) goto L9;
        r3.setOnClickListener(this.f);
        r3.setOnLongClickListener(this.g);
    L9:
        r2 = r2 + 1;
        goto L5
    L14:
        return;
    }

    public final void h() {
        Iterator r0 = ((ArrayList) this.c).iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L16;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r5 = (View) r3;
        if (this.h != r2) goto L11;
    L14:
        boolean r6 = true;
    L15:
        this.b.c.invoke(r5, Integer.valueOf(r2), Boolean.valueOf(r6));
        r2 = r4;
        goto L4
    L11:
        if (c(r5) == true) goto L14;
        r6 = false;
        goto L15
    }

    public final void i() {
        ((ArrayList) this.c).clear();
        ViewGroup r0 = this.a;
        boolean r1 = false;
        if (r0 == null) goto L13;
        int r2 = r0.getChildCount();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L13;
        View r4 = r0.getChildAt(r3);
        if (r4 == null) goto L12;
        if (r4.getVisibility() != 0) goto L11;
        ((ArrayList) this.c).add(r4);
        goto L12
    L11:
        f(r4, false);
    L12:
        r3 = r3 + 1;
    L13:
        int r5 = ((ArrayList) this.c).size();
        int r6 = this.h;
        if (r6 < 0) goto L17;
        if (r6 >= r5) goto L17;
        r1 = true;
    L17:
        if (r1 == true) goto L19;
        this.h = -1;
        return;
    L19:
        if (c((View) ListProtector.get(this.c, r6)) == true) goto L27;
        f((View) ListProtector.get(this.c, this.h), true);
        return;
    }

    public e() {
        this.b = new FeedSelectorConfig();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new a(this);
        this.g = new b(this);
        this.h = -1;
    }

    public static boolean c(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r2.isSelected() == false) goto L5;
    L9:
        return true;
    L5:
        if ((r2 instanceof CompoundButton) == false) goto L7;
        boolean r3 = ((CompoundButton) r2).isChecked();
    L8:
        if (r3 == true) goto L9;
        return false;
    L7:
        r3 = false;
        goto L8
    }

    public static void f(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setSelected(r2);
        if ((r1 instanceof CompoundButton) == false) goto L6;
        ((CompoundButton) r1).setChecked(r2);
        return;
    }

    public final void d(int r17, boolean r18, boolean r19, boolean r20, boolean r21) {
        List<Integer> r3 = a();
        Integer r4 = (Integer) CollectionsKt.lastOrNull(r3);
        this.b.getClass();
        ArrayList r5 = (ArrayList) r3;
        boolean r6 = true;
        if ((!r5.isEmpty()) == true) goto L5;
    L7:
        boolean r7 = false;
    L8:
        List<View> r8 = this.c;
        if (r17 >= 0) goto L11;
    L13:
        boolean r9 = false;
    L14:
        if (r9 == true) goto L16;
        Intrinsics.checkNotNullParameter("index out of list.", "<this>");
        Log.i("FeedTabLayout", "index out of list.");
    L37:
        r6 = false;
    L47:
        if (r6 == true) goto L49;
        if (r21 == true) goto L49;
        return;
    L49:
        Integer r1 = (Integer) CollectionsKt.lastOrNull(a());
        int r2 = -1;
        if (r1 == null) goto L52;
        int r10 = r1.intValue();
    L53:
        this.h = r10;
        if (r19 == false) goto L72;
        if (r4 == null) goto L57;
        r2 = r4.intValue();
    L57:
        List<Integer> r11 = a();
        this.b.d.invoke(CollectionsKt.getOrNull(this.c, r2), b(), Boolean.valueOf(r7), Boolean.valueOf(r20));
        this.b.e.invoke(Integer.valueOf(r2), r11, Boolean.valueOf(r7), Boolean.valueOf(r20));
        return;
    L72:
        return;
    L52:
        r10 = -1;
        goto L53
    L16:
        List<Integer> r12 = a();
        List<View> r13 = b();
        ArrayList r14 = (ArrayList) r12;
        if ((!r14.isEmpty()) == false) goto L31;
        if (r18 == false) goto L29;
        this.b.getClass();
        Iterator r15 = r14.iterator();
    L21:
        if (r15.hasNext() == false) goto L26;
        int r16 = ((Number) r15.next()).intValue();
        if (r16 == r17) goto L21;
        f((View) ListProtector.get(r8, r16), false);
        goto L21
    L26:
        if (r14.contains(Integer.valueOf(r17)) == false) goto L31;
    L29:
        if (r14.contains(Integer.valueOf(r17)) == false) goto L37;
    L31:
        if (r18 == false) goto L36;
        if ((((ArrayList) r13).size() + 1) > this.b.b) goto L37;
    L38:
        View r22 = (View) ListProtector.get(r8, r17);
        f(r22, r18);
        this.b.getClass();
        Iterator r23 = ((ArrayList) r13).iterator();
    L40:
        if (r23.hasNext() == false) goto L46;
        View r110 = (View) r23.next();
        int r111 = ((ArrayList) r8).indexOf(r110);
        if (r111 == r17) goto L40;
        Function4<? super View, ? super Integer, ? super Boolean, ? super Boolean, Boolean> r112 = this.b.f;
        Integer r113 = Integer.valueOf(r111);
        Boolean r114 = Boolean.FALSE;
        if (((Boolean) r112.invoke(r110, r113, r114, Boolean.valueOf(r20))).booleanValue() == true) goto L40;
        f(r110, false);
        this.b.c.invoke(r110, Integer.valueOf(r111), r114);
        goto L40
    L46:
        this.b.c.invoke(r22, Integer.valueOf(r17), Boolean.valueOf(r18));
        goto L47
    L36:
        if ((((ArrayList) r13).size() - 1) >= this.b.a) goto L38;
    L11:
        if (r17 >= ((ArrayList) r8).size()) goto L13;
        r9 = true;
        goto L14
    L5:
        if (r5.contains(Integer.valueOf(r17)) == false) goto L7;
        r7 = true;
        goto L8
    }

    public static /* synthetic */ void e(e r8, int r9, boolean r10, boolean r11, boolean r12, int r13) {
        if ((r13 & 2) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r13 & 4) == 0) goto L9;
        boolean r5 = true;
    L11:
        if ((r13 & 8) == 0) goto L13;
        boolean r6 = false;
    L14:
        r8.d(r9, r4, r5, r6, false);
        return;
    L13:
        r6 = r12;
        goto L14
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }
}
