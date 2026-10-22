package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
public final class q implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Spannable f1807b;

    public static class a {
        public static IntStream a(Spannable r8) {
            return r8.chars();
        }

        public static IntStream b(Spannable r8) {
            return r8.codePoints();
        }
    }

    public q(Spannable r8) {
        this.f1806a = false;
        this.f1807b = r8;
    }

    public final void a() {
        Spannable r8 = this.f1807b;
        if (this.f1806a == false) goto L5;
    L13:
        this.f1806a = true;
        return;
    L5:
        if ((r8 instanceof PrecomputedText) == false) goto L7;
    L10:
        boolean r10 = true;
    L11:
        if (r10 == false) goto L13;
        this.f1807b = new SpannableString(r8);
        goto L13
    L7:
        if ((r8 instanceof h0.c) == true) goto L10;
        r10 = false;
        goto L11
    }

    @Override // java.lang.CharSequence
    public final char charAt(int r8) {
        return this.f1807b.charAt(r8);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return a.a(this.f1807b);
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return a.b(this.f1807b);
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object r8) {
        return this.f1807b.getSpanEnd(r8);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object r8) {
        return this.f1807b.getSpanFlags(r8);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object r8) {
        return this.f1807b.getSpanStart(r8);
    }

    @Override // android.text.Spanned
    public final <T> T[] getSpans(int r8, int r10, Class<T> r11) {
        return (T[]) this.f1807b.getSpans(r8, r10, r11);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f1807b.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int r8, int r10, Class r11) {
        return this.f1807b.nextSpanTransition(r8, r10, r11);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object r8) {
        a();
        this.f1807b.removeSpan(r8);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object r8, int r10, int r11, int r12) {
        a();
        this.f1807b.setSpan(r8, r10, r11, r12);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int r8, int r10) {
        return this.f1807b.subSequence(r8, r10);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f1807b.toString();
    }

    public q(CharSequence r8) {
        this.f1806a = false;
        this.f1807b = new SpannableString(r8);
    }
}
