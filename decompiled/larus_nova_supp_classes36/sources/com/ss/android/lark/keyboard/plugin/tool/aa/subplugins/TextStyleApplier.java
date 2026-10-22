package com.ss.android.lark.keyboard.plugin.tool.aa.subplugins;

import android.text.Editable;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class TextStyleApplier {
    public static final /* synthetic */ int m = 0;
    public final d<?> a;
    public final Lazy b;
    public boolean c;
    public final oob.d d;
    public int e;
    public final Function3<Editable, Integer, Integer, Unit> f;
    public final Function3<Editable, Integer, Integer, Unit> g;
    public final Function3<Editable, Integer, Integer, Unit> h;
    public Function3<? super Editable, ? super Integer, ? super Integer, Unit> i;
    public int j;
    public c k;
    public b l;

    public static final class a {
    }

    public interface b {
        void a(boolean r1);
    }

    public interface c {
        void b(Object r1);
    }

    public interface d<T> {
        T a();

        Class<T> b();
    }

    static {
    }

    public final Object b() {
        Object r0 = this.a.a();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void f() {
        oob.d r0 = this.d;
        int r1 = r0.a;
        if (r1 != (-1)) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L10;
        return;
    L10:
        boolean r5 = this.c;
        int r6 = r0.b;
        if ((r6 - r1) <= 0) goto L13;
        boolean r7 = true;
    L14:
        if (r7 == true) goto L29;
        if (r5 == true) goto L22;
        this.c = true;
        b r2 = this.l;
        if (r2 == null) goto L20;
        r2.a(true);
    L20:
        if (this.e != 0) goto L42;
        this.i = this.g;
        return;
    L42:
        return;
    L22:
        this.c = false;
        b r3 = this.l;
        if (r3 == null) goto L25;
        r3.a(false);
    L25:
        this.i = this.f;
        if (this.e == 0) goto L44;
        this.i = this.h;
        return;
    L44:
        return;
    L29:
        Editable r8 = r0.c;
        if (r8 != null) goto L32;
        return;
    L32:
        int r9 = this.e;
        if (r9 == 0) goto L39;
        if (r9 == 1) goto L39;
        if (r9 != 3) goto L40;
        d(r8, r1, r6);
    L40:
        oob.d r10 = this.d;
        c(r10.c, r10.a, r10.b);
        return;
    L39:
        e(r8, r1, r6);
        goto L40
    L13:
        r7 = false;
        goto L14
    L5:
        if (r0.b == (-1)) goto L7;
        r4 = true;
        goto L8
    }

    public TextStyleApplier(d<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "spanFactory");
        this.a = r2;
        this.b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new TextStyleApplier$spanClass$2(this));
        this.d = new oob.d();
        TextStyleApplier$emptyAction$1 r3 = TextStyleApplier$emptyAction$1.INSTANCE;
        this.f = r3;
        this.g = new TextStyleApplier$actionSetSpan$1(this);
        this.h = new TextStyleApplier$actionRemoveSpan$1(this);
        this.i = r3;
    }

    public final void a(Editable r11) {
        int r0 = this.j + 1;
        this.j = r0;
        if ((r0 % 10) <= 0) goto L5;
        return;
    L5:
        int r3 = 0;
        Object[] r1 = r11.getSpans(0, r11.length() - 1, (Class) this.b.getValue());
        boolean[] r2 = new boolean[r11.length() + 1];
        Intrinsics.checkNotNull(r1);
        int r4 = r1.length;
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L12;
        Object r6 = r1[r5];
        int r7 = r11.getSpanStart(r6);
        int r8 = r11.getSpanEnd(r6);
    L8:
        if (r7 > r8) goto L10;
        r2[r7] = true;
        r7 = r7 + 1;
        goto L8
    L10:
        r11.removeSpan(r6);
        r5 = r5 + 1;
    L12:
        if (r3 >= r11.length()) goto L23;
        if (r2[r3] == false) goto L22;
        int r9 = r3;
    L17:
        if (r9 >= r11.length()) goto L21;
        if (r2[r9] == false) goto L21;
        r9 = r9 + 1;
    L21:
        r11.setSpan(b(), r3, r9 - 1, 34);
        r3 = r9;
    L22:
        r3 = r3 + 1;
        goto L12
    }

    public final void c(Editable r11, int r12, int r13) {
        int r14 = r13 - r12;
        if (r11 == null) goto L52;
        if (r14 < 0) goto L56;
        this.e = 0;
        oob.d r1 = this.d;
        r1.c = r11;
        int r2 = r12 + r14;
        r1.a = r12;
        r1.b = r2;
        Object[] r3 = r11.getSpans(r12, r2, (Class) this.b.getValue());
        int r4 = r14 + 1;
        boolean[] r5 = new boolean[r4];
        Intrinsics.checkNotNull(r3);
        int r6 = r3.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L22;
        Object r8 = r3[r7];
        int r9 = r11.getSpanStart(r8);
        int r10 = r11.getSpanEnd(r8);
    L10:
        if (r9 > r10) goto L20;
        int r15 = r9 - r12;
        if (r15 <= r14) goto L14;
        r15 = r14;
    L14:
        if (r15 == 0) goto L19;
        if (r15 >= 0) goto L18;
        r15 = 0;
    L18:
        r5[r15] = true;
    L19:
        r9 = r9 + 1;
        goto L10
    L20:
        r7 = r7 + 1;
        goto L8
    L22:
        if (ArraysKt.contains(r5, true) == false) goto L24;
        this.e |= 1;
    L24:
        boolean r16 = !ArraysKt.contains(r5, false);
        if (r4 > 1) goto L27;
    L29:
        boolean r17 = false;
    L30:
        if (r16 == true) goto L32;
        if (r17 == true) goto L32;
    L34:
        if (this.e != 0) goto L40;
        this.c = false;
        b r18 = this.l;
        if (r18 == null) goto L38;
        r18.a(false);
    L38:
        this.i = this.f;
        return;
    L40:
        if (this.c == true) goto L54;
        this.c = true;
        b r19 = this.l;
        if (r19 == null) goto L45;
        r19.a(true);
    L45:
        if (this.e != 0) goto L55;
        this.i = this.g;
        return;
    L55:
        return;
    L54:
        return;
    L32:
        this.e |= 3;
        goto L34
    L27:
        if (ArraysKt.takeLast(r5, r14).contains(Boolean.FALSE) == true) goto L29;
        r17 = true;
        goto L30
    L56:
        return;
    }

    public final void d(Editable r10, int r11, int r12) {
        ArrayList r0 = new ArrayList();
        HashMap r1 = new HashMap();
        Object[] r2 = r10.getSpans(r11, r12, (Class) this.b.getValue());
        Intrinsics.checkNotNull(r2);
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L10;
        Object r5 = r2[r4];
        int r6 = r10.getSpanStart(r5);
        int r7 = r10.getSpanEnd(r5);
        if (r6 >= r11) goto L7;
        r1.put(TuplesKt.to(Integer.valueOf(r6), Integer.valueOf(r11)), b());
    L7:
        if (r7 <= r12) goto L9;
        r1.put(TuplesKt.to(Integer.valueOf(r12), Integer.valueOf(r7)), b());
    L9:
        Intrinsics.checkNotNull(r5);
        r0.add(r5);
        r4 = r4 + 1;
        goto L3
    L10:
        Pair r13 = TuplesKt.to(r0, r1);
        List r14 = (List) r13.component1();
        HashMap r15 = (HashMap) r13.component2();
        Iterator r16 = r14.iterator();     // Catch: Exception -> L16
    L13:
        if (r16.hasNext() == false) goto L18;
        r10.removeSpan(r16.next());     // Catch: Exception -> L16
    L18:
        Iterator r17 = r15.entrySet().iterator();
    L20:
        if (r17.hasNext() == false) goto L22;
        Map.Entry r18 = (Map.Entry) r17.next();
        Pair r8 = (Pair) r18.getKey();
        r10.setSpan(r18.getValue(), ((Number) r8.component1()).intValue(), ((Number) r8.component2()).intValue(), 34);
        goto L20
    L22:
        a(r10);
        return;
    L16:
        e = move-exception;
        Log.e("BaseTextStyleApplier", "removeSpanInner: There is something wrong with Editable#removeSpan, we catch and consume this exception to prevent crash. exception is " + ExceptionsKt.stackTraceToString(e));
        goto L18
    }

    public final void e(Editable r4, int r5, int r6) {
        Object r0 = b();
        Log.d("BaseTextStyleApplier", "setSpanInner: span is " + r0.getClass().getName() + ", start=" + r5 + ", end=" + r6);
        c r1 = this.k;
        if (r1 == null) goto L5;
        r1.b(r0);
    L5:
        r4.setSpan(b(), r5, r6, 34);
        a(r4);
    }
}
