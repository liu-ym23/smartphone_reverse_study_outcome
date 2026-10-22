package com.squareup.kotlinpoet;

import java.io.Closeable;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Regex f15185h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final char[] f15186i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Appendable f15187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15189c;
    public boolean d;
    public final List e;
    public int f;
    public String g;

    static {
        f15185h = new Regex("\\s*[-+].*");
        f15186i = " \n·".toCharArray();
    }

    public n(Appendable r5, String r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "out");
        Intrinsics.checkNotNullParameter(r10, "indent");
        this.f15187a = r5;
        this.f15188b = r10;
        this.f15189c = r11;
        this.e = CollectionsKt.mutableListOf(new String[]{""});
        this.f = -1;
        this.g = "";
    }

    public final void b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "s");
        if (this.d == true) goto L11;
        if (StringsKt.g(r5, "\n") == true) goto L9;
        List r10 = this.e;
        int r11 = r10.size() - 1;
        r10.set(r11, ((String) r10.get(r11)) + r5);
        return;
    L9:
        throw new IllegalArgumentException("Failed requirement.");
    L11:
        throw new IllegalStateException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        d();
        this.d = true;
    }

    public final void d() {
        int r5 = 1;
    L3:
        List r10 = this.e;
        if (r5 >= r10.size()) goto L11;
        if (f15185h.matches((String) r10.get(r5)) == true) goto L7;
        r5 = r5 + 1;
        goto L3
    L7:
        int r11 = r5 - 1;
        r10.set(r11, ((String) r10.get(r11)) + ' ' + ((String) r10.get(r5)));
        r10.remove(r5);
        if (r5 <= 1) goto L3;
        r5 = r5 - 1;
        goto L3
    L11:
        int r12 = 0;
        int r13 = ((String) r10.get(0)).length();
        int r14 = r10.size();
        int r15 = 1;
    L12:
        if (r15 >= r14) goto L18;
        String r16 = (String) r10.get(r15);
        int r17 = r16.length() + (r13 + 1);
        if (r17 <= this.f15189c) goto L16;
        e(r12, r15);
        r13 = (this.f15188b.length() * this.f) + r16.length();
        r12 = r15;
    L17:
        r15 = r15 + 1;
        goto L12
    L16:
        r13 = r17;
        goto L17
    L18:
        e(r12, r10.size());
        r10.clear();
        r10.add("");
    }

    public final void e(int r5, int r10) {
        Appendable r11 = this.f15187a;
        if (r5 <= 0) goto L8;
        r11.append("\n");
        int r12 = this.f;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        r11.append(this.f15188b);
        r13 = r13 + 1;
        goto L5
    L7:
        r11.append(this.g);
    L8:
        List r14 = this.e;
        r11.append((CharSequence) r14.get(r5));
    L9:
        r5 = r5 + 1;
        if (r5 >= r10) goto L12;
        r11.append(" ");
        r11.append((CharSequence) r14.get(r5));
        goto L9
    }
}
