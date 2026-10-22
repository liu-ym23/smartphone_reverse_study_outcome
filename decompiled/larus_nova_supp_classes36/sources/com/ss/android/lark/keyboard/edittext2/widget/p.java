package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p extends SpannableStringBuilder {
    public static final /* synthetic */ int c = 0;
    public final HashSet<Class<?>> a;
    public final CopyOnWriteArrayList<b> b;

    public static final class a {
    }

    public static final class b implements TextWatcher, SpanWatcher {
        public final Object a;
        public final AtomicInteger b;

        public b(Object r2) {
            Intrinsics.checkNotNullParameter(r2, "origin");
            this.a = r2;
            this.b = new AtomicInteger(0);
        }

        public static boolean a(Object r3) {
            if (r3 != null) goto L5;
            return false;
        L5:
            h r1 = h.a;
            Intrinsics.checkNotNullParameter(r3, "span");
            Set<Class<? extends CharacterStyle>> r2 = h.b;
            if ((r2 instanceof Collection) == true) goto L8;
        L10:
            Iterator<T> r4 = r2.iterator();
        L12:
            if (r4.hasNext() == false) goto L21;
            if (((Class) r4.next()).isInstance(r3) == false) goto L12;
            return true;
        L21:
            return false;
        L8:
            if (r2.isEmpty() == false) goto L10;
            return false;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r3) {
            Log.d("SpannableBuilderCompat", "afterTextChanged: called");
            Object r0 = this.a;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.text.TextWatcher");
            ((TextWatcher) r0).afterTextChanged(r3);
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r3, int r4, int r5, int r6) {
            Log.d("SpannableBuilderCompat", "beforeTextChanged: called");
            Object r0 = this.a;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.text.TextWatcher");
            ((TextWatcher) r0).beforeTextChanged(r3, r4, r5, r6);
        }

        @Override // android.text.SpanWatcher
        public final void onSpanAdded(Spannable r3, Object r4, int r5, int r6) {
            if (this.b.get() > 0) goto L5;
        L7:
            Log.d("SpannableBuilderCompat", "onSpanAdded: called, span is " + r4);
            Object r0 = this.a;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.text.SpanWatcher");
            ((SpanWatcher) r0).onSpanAdded(r3, r4, r5, r6);
            return;
        L5:
            if (a(r4) == false) goto L7;
        }

        @Override // android.text.SpanWatcher
        public final void onSpanRemoved(Spannable r3, Object r4, int r5, int r6) {
            if (this.b.get() > 0) goto L5;
        L7:
            Log.d("SpannableBuilderCompat", "onSpanRemoved: called");
            Object r0 = this.a;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.text.SpanWatcher");
            ((SpanWatcher) r0).onSpanRemoved(r3, r4, r5, r6);
            return;
        L5:
            if (a(r4) == false) goto L7;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r3, int r4, int r5, int r6) {
            Log.d("SpannableBuilderCompat", "onTextChanged: called");
            Object r0 = this.a;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.text.TextWatcher");
            ((TextWatcher) r0).onTextChanged(r3, r4, r5, r6);
        }

        @Override // android.text.SpanWatcher
        public final void onSpanChanged(Spannable r10, Object r11, int r12, int r13, int r14, int r15) {
            if (this.b.get() > 0) goto L5;
        L7:
            Object r0 = this.a;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.text.SpanWatcher");
            ((SpanWatcher) r0).onSpanChanged(r10, r11, r12, r13, r14, r15);
            return;
        L5:
            if (a(r11) == false) goto L7;
        }
    }

    static {
    }

    public final void a() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).b.incrementAndGet();
        goto L4
    }

    public final void b() {
        Iterator<T> r0 = this.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).onTextChanged(this, 0, super.length(), super.length());
        goto L4
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final /* bridge */ int length() {
        return super.length();
    }

    public final Object c(Object r4) {
        if (r4 == null) goto L6;
        Class<?> r0 = r4.getClass();
        if (CollectionsKt.contains(this.a, r0) == false) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L9;
        return r4;
    L9:
        Iterator<b> r2 = this.b.iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        b r3 = r2.next();
        if (Intrinsics.areEqual(r3.a, r4) == false) goto L11;
    L16:
        b r5 = r3;
        if (r5 != null) goto L20;
        return r4;
    L20:
        return r5;
    L15:
        r3 = null;
    L6:
        r1 = false;
        goto L7
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final /* bridge */ char charAt(int r1) {
        return super.charAt(r1);
    }

    public final Object e(Object r3) {
        if (r3 == null) goto L6;
        Class<?> r0 = r3.getClass();
        if (CollectionsKt.contains(this.a, r0) == false) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L10;
        return r3;
    L10:
        if (r3 == null) goto L14;
        b r2 = new b(r3);
        this.b.add(r2);
        return r2;
    L14:
        throw new IllegalArgumentException("Required value was null.".toString());
    L6:
        r1 = false;
        goto L7
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object r1) {
        return super.getSpanEnd(c(r1));
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object r1) {
        return super.getSpanFlags(c(r1));
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object r1) {
        return super.getSpanStart(c(r1));
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object r2) {
        Object r0 = c(r2);
        if (Intrinsics.areEqual(r0, r2) == false) goto L5;
    L7:
        super.removeSpan(r0);
        return;
    L5:
        if ((r0 instanceof b) == false) goto L7;
        this.b.remove(r0);
        goto L7
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public final CharSequence subSequence(int r3, int r4) {
        return new p(this.a, this, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final <T> T[] getSpans(int r6, int r7, Class<T> r8) {
        if (CollectionsKt.contains(this.a, r8) == false) goto L15;
        Object[] r9 = super.getSpans(r6, r7, b.class);
        ArrayList r10 = new ArrayList();
        int r0 = r9.length;
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L10;
        Object r3 = r9[r2];
        if (Intrinsics.areEqual(((b) r3).a.getClass(), r8) == false) goto L9;
        r10.add(r3);
    L9:
        r2 = r2 + 1;
        goto L5
    L10:
        Object r11 = Array.newInstance(r8, r10.size());
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Array<T of com.ss.android.lark.keyboard.edittext2.widget.RichTextSpannableBuilder.getSpans>");
        T[] r12 = (T[]) ((Object[]) r11);
        int r13 = r10.size();
    L11:
        if (r1 >= r13) goto L13;
        r12[r1] = ((b) ListProtector.get(r10, r1)).a;
        r1 = r1 + 1;
        goto L11
    L13:
        return r12;
    L15:
        return (T[]) super.getSpans(r6, r7, r8);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int r2, int r3, Class<?> r4) {
        if (CollectionsKt.contains(this.a, r4) == false) goto L6;
        r4 = b.class;
    L6:
        return super.nextSpanTransition(r2, r3, r4);
    }

    public p(HashSet<Class<?>> r2, CharSequence r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "watcherClasses");
        Intrinsics.checkNotNullParameter(r3, "text");
        super(r3, r4, r5);
        this.a = r2;
        this.b = new CopyOnWriteArrayList();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object r4, int r5, int r6, int r7) {
        if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication()) == false) goto L11;
        super.setSpan(e(r4), r5, r6, r7);
        return;
    L11:
        super.setSpan(e(r4), r5, r6, r7);     // Catch: IndexOutOfBoundsException -> L8
        return;
    L8:
        e = move-exception;
        Log.e("SpannableBuilderCompat", "setSpan: failed: " + ExceptionsKt.stackTraceToString(e));
        Log.e("SpannableBuilderCompat", e, true);
        setSpan(r4, Math.min(Math.max(0, r5), super.length()), Math.max(Math.min(r6, super.length()), 0), r7);
    }

    public final void d(int r17, int r18, CharSequence r19, int r20, int r21) {
        Intrinsics.checkNotNullParameter(r19, "tb");
        a();
        if (Intrinsics.areEqual(r19, this) == true) goto L35;
        h r4 = h.a;
        Intrinsics.checkNotNullParameter(this, "spannable");
        ArrayList r5 = new ArrayList();
        long r6 = System.nanoTime();
        Object[] r7 = getSpans(r17, r18, Object.class);
        Intrinsics.checkNotNull(r7);
        int r8 = r7.length;
        int r10 = 0;
        boolean r11 = false;
    L5:
        boolean r12 = true;
        if (r10 >= r8) goto L30;
        Object r13 = r7[r10];
        Intrinsics.checkNotNull(r13);
        Set<Class<? extends Object>> r14 = h.d;
        if ((r14 instanceof Collection) == true) goto L10;
    L12:
        Iterator<T> r15 = r14.iterator();
    L14:
        if (r15.hasNext() == false) goto L18;
        if (((Class) r15.next()).isInstance(r13) == false) goto L14;
        boolean r16 = true;
    L19:
        if (r16 == false) goto L29;
        int r110 = getSpanStart(r13);
        int r111 = getSpanEnd(r13);
        if (r17 > r110) goto L25;
        if (r111 > r18) goto L25;
    L26:
        if (r12 == false) goto L28;
        r5.add(r13);
    L28:
        r11 = r11 & r12;
    L25:
        r12 = false;
    L29:
        r10 = r10 + 1;
    L18:
        r16 = false;
        goto L19
    L10:
        if (r14.isEmpty() == false) goto L12;
    L30:
        if (r11 == false) goto L33;
        Log.i("SpannableBuilderCompat", "removeSpanOnReplace: cost " + (System.nanoTime() - r6));
    L33:
        if ((!r5.isEmpty()) == false) goto L35;
        setSpan(new i(r5, this), 0, super.length(), 18);
    L35:
        super.replace(r17, r18, r19, r20, r21);
        Iterator<b> r1 = this.b.iterator();
    L37:
        if (r1.hasNext() == false) goto L39;
        r1.next().b.decrementAndGet();
        goto L37
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ Editable replace(int r1, int r2, CharSequence r3, int r4, int r5) {
        d(r1, r2, r3, r4, r5);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public final /* bridge */ /* synthetic */ SpannableStringBuilder replace(int r1, int r2, CharSequence r3, int r4, int r5) {
        d(r1, r2, r3, r4, r5);
        return this;
    }
}
