package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class o extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f1802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f1803b;

    public static class a implements TextWatcher, SpanWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f1804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f1805b;

        public a(Object r8) {
            this.f1805b = new AtomicInteger(0);
            this.f1804a = r8;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r8) {
            ((TextWatcher) this.f1804a).afterTextChanged(r8);
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r8, int r10, int r11, int r12) {
            ((TextWatcher) this.f1804a).beforeTextChanged(r8, r10, r11, r12);
        }

        @Override // android.text.SpanWatcher
        public final void onSpanAdded(Spannable r8, Object r10, int r11, int r12) {
            if (this.f1805b.get() > 0) goto L5;
        L7:
            ((SpanWatcher) this.f1804a).onSpanAdded(r8, r10, r11, r12);
            return;
        L5:
            if ((r10 instanceof k) == false) goto L7;
        }

        @Override // android.text.SpanWatcher
        public final void onSpanChanged(Spannable r8, Object r10, int r11, int r12, int r13, int r14) {
            if (this.f1805b.get() > 0) goto L5;
        L7:
            ((SpanWatcher) this.f1804a).onSpanChanged(r8, r10, r11, r12, r13, r14);
            return;
        L5:
            if ((r10 instanceof k) == false) goto L7;
        }

        @Override // android.text.SpanWatcher
        public final void onSpanRemoved(Spannable r8, Object r10, int r11, int r12) {
            if (this.f1805b.get() > 0) goto L5;
        L7:
            ((SpanWatcher) this.f1804a).onSpanRemoved(r8, r10, r11, r12);
            return;
        L5:
            if ((r10 instanceof k) == false) goto L7;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r8, int r10, int r11, int r12) {
            ((TextWatcher) this.f1804a).onTextChanged(r8, r10, r11, r12);
        }
    }

    public o(CharSequence r8, Class r10) {
        super(r8);
        this.f1803b = new ArrayList();
        t2.b.n(r10, "watcherClass cannot be null");
        this.f1802a = r10;
    }

    public final void a() {
        int r8 = 0;
    L3:
        ArrayList r10 = this.f1803b;
        if (r8 >= r10.size()) goto L6;
        ((a) r10.get(r8)).f1805b.incrementAndGet();
        r8 = r8 + 1;
        goto L3
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(char r8) {
        super.append(r8);
        return this;
    }

    public final void b() {
        e();
        int r8 = 0;
    L3:
        ArrayList r10 = this.f1803b;
        if (r8 >= r10.size()) goto L6;
        ((a) r10.get(r8)).onTextChanged(this, 0, length(), length());
        r8 = r8 + 1;
        goto L3
    }

    public final a c(Object r8) {
        int r10 = 0;
    L3:
        ArrayList r11 = this.f1803b;
        if (r10 >= r11.size()) goto L9;
        a r12 = (a) r11.get(r10);
        if (r12.f1804a == r8) goto L7;
        r10 = r10 + 1;
        goto L3
    L7:
        return r12;
    L9:
        return null;
    }

    public final boolean d(Object r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        if (this.f1802a != r8.getClass()) goto L7;
        boolean r10 = true;
    L8:
        if (r10 == true) goto L10;
        return false;
    L10:
        return true;
    L7:
        r10 = false;
        goto L8
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final Editable delete(int r8, int r10) {
        super.delete(r8, r10);
        return this;
    }

    public final void e() {
        int r8 = 0;
    L3:
        ArrayList r10 = this.f1803b;
        if (r8 >= r10.size()) goto L6;
        ((a) r10.get(r8)).f1805b.decrementAndGet();
        r8 = r8 + 1;
        goto L3
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanEnd(Object r8) {
        if (d(r8) == false) goto L8;
        a r10 = c(r8);
        if (r10 == null) goto L8;
        r8 = r10;
    L8:
        return super.getSpanEnd(r8);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanFlags(Object r8) {
        if (d(r8) == false) goto L8;
        a r10 = c(r8);
        if (r10 == null) goto L8;
        r8 = r10;
    L8:
        return super.getSpanFlags(r8);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int getSpanStart(Object r8) {
        if (d(r8) == false) goto L8;
        a r10 = c(r8);
        if (r10 == null) goto L8;
        r8 = r10;
    L8:
        return super.getSpanStart(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    @SuppressLint({"UnknownNullness"})
    public final <T> T[] getSpans(int r8, int r10, Class<T> r11) {
        int r12 = 0;
        if (this.f1802a != r11) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L13;
        a[] r14 = (a[]) super.getSpans(r8, r10, a.class);
        T[] r15 = (T[]) ((Object[]) Array.newInstance(r11, r14.length));
    L9:
        if (r12 >= r14.length) goto L11;
        r15[r12] = r14[r12].f1804a;
        r12 = r12 + 1;
        goto L9
    L11:
        return r15;
    L13:
        return (T[]) super.getSpans(r8, r10, r11);
    L5:
        r13 = false;
        goto L6
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final Editable insert(int r8, CharSequence r10) {
        super.insert(r8, r10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public final int nextSpanTransition(int r8, int r10, Class r11) {
        if (r11 != null) goto L4;
    L8:
        r11 = a.class;
    L10:
        return super.nextSpanTransition(r8, r10, r11);
    L4:
        if (this.f1802a != r11) goto L6;
        boolean r12 = true;
    L7:
        if (r12 == false) goto L10;
    L6:
        r12 = false;
        goto L7
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void removeSpan(Object r8) {
        if (d(r8) == false) goto L7;
        a r10 = c(r8);
        if (r10 == null) goto L8;
        r8 = r10;
    L8:
        super.removeSpan(r8);
        if (r10 == null) goto L12;
        this.f1803b.remove(r10);
        return;
    L12:
        return;
    L7:
        r10 = null;
        goto L8
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final /* bridge */ /* synthetic */ Editable replace(int r8, int r10, CharSequence r11) {
        replace(r8, r10, r11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public final void setSpan(Object r8, int r10, int r11, int r12) {
        if (d(r8) == false) goto L5;
        a r13 = new a(r8);
        this.f1803b.add(r13);
        r8 = r13;
    L5:
        super.setSpan(r8, r10, r11, r12);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    @SuppressLint({"UnknownNullness"})
    public final CharSequence subSequence(int r8, int r10) {
        return new o(this.f1802a, this, r8, r10);
    }

    public o(Class<?> r8, CharSequence r10, int r11, int r12) {
        super(r10, r11, r12);
        this.f1803b = new ArrayList();
        t2.b.n(r8, "watcherClass cannot be null");
        this.f1802a = r8;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(@SuppressLint({"UnknownNullness"}) CharSequence r8) {
        super.append(r8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder delete(int r8, int r10) {
        super.delete(r8, r10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final Editable insert(int r8, CharSequence r10, int r11, int r12) {
        super.insert(r8, r10, r11, r12);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final /* bridge */ /* synthetic */ Editable replace(int r8, int r10, CharSequence r11, int r12, int r13) {
        replace(r8, r10, r11, r12, r13);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Editable append(@SuppressLint({"UnknownNullness"}) CharSequence r8, int r10, int r11) {
        super.append(r8, r10, r11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder insert(int r8, CharSequence r10) {
        super.insert(r8, r10);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder replace(int r8, int r10, CharSequence r11) {
        a();
        super.replace(r8, r10, r11);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(char r8) {
        super.append(r8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder insert(int r8, CharSequence r10, int r11, int r12) {
        super.insert(r8, r10, r11, r12);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder replace(int r8, int r10, CharSequence r11, int r12, int r13) {
        a();
        super.replace(r8, r10, r11, r12, r13);
        e();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence r8) {
        super.append(r8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence r8, int r10, int r11) {
        super.append(r8, r10, r11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    @SuppressLint({"UnknownNullness"})
    public final SpannableStringBuilder append(CharSequence r8, Object r10, int r11) {
        super.append(r8, r10, r11);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(char r8) {
        super.append(r8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(@SuppressLint({"UnknownNullness"}) CharSequence r8) {
        super.append(r8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public final Appendable append(@SuppressLint({"UnknownNullness"}) CharSequence r8, int r10, int r11) {
        super.append(r8, r10, r11);
        return this;
    }
}
