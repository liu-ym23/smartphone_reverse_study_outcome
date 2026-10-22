package org.threeten.bp.format;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.threeten.bp.temporal.g f21227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextStyle f21228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f21229c;
    public volatile j d;

    public n(org.threeten.bp.temporal.g r5, TextStyle r10, y r11) {
        this.f21227a = r5;
        this.f21228b = r10;
        this.f21229c = r11;
    }

    @Override // org.threeten.bp.format.g
    public final int parse(u r10, CharSequence r11, int r12) {
        int r5 = r11.length();
        if (r12 < 0) goto L27;
        if (r12 > r5) goto L27;
        if (r10.e == false) goto L8;
        TextStyle r13 = this.f21228b;
    L9:
        Iterator r14 = this.f21229c.b(this.f21227a, r13, r10.f21250a);
        if (r14 == null) goto L22;
    L12:
        if (r14.hasNext() == false) goto L18;
        Map.Entry r15 = (Map.Entry) r14.next();
        String r16 = (String) r15.getKey();
        if (r10.f(r16, 0, r11, r12, r16.length()) == false) goto L12;
        long r17 = ((Long) r15.getValue()).longValue();
        int r18 = r16.length() + r12;
        return r10.e(this.f21227a, r17, r12, r18);
    L18:
        if (r10.e == false) goto L22;
        return ~r12;
    L22:
        if (this.d != null) goto L25;
        this.d = new j(this.f21227a, 1, 19, SignStyle.NORMAL);
    L25:
        return this.d.parse(r10, r11, r12);
    L8:
        r13 = null;
    L27:
        throw new IndexOutOfBoundsException();
    }

    @Override // org.threeten.bp.format.g
    public final boolean print(w r10, StringBuilder r11) {
        Long r5 = r10.a(this.f21227a);
        if (r5 != null) goto L6;
        return false;
    L6:
        long r12 = r5.longValue();
        String r13 = this.f21229c.a(this.f21227a, r12, this.f21228b, r10.f21257b);
        if (r13 == null) goto L9;
        r11.append(r13);
        return true;
    L9:
        if (this.d != null) goto L12;
        this.d = new j(this.f21227a, 1, 19, SignStyle.NORMAL);
    L12:
        return this.d.print(r10, r11);
    }

    public final String toString() {
        TextStyle r5 = TextStyle.FULL;
        org.threeten.bp.temporal.g r10 = this.f21227a;
        TextStyle r11 = this.f21228b;
        if (r11 != r5) goto L7;
        return "Text(" + r10 + ")";
    L7:
        return "Text(" + r10 + "," + r11 + ")";
    }
}
