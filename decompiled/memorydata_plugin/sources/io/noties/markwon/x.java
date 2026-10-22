package io.noties.markwon;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class x implements Appendable, CharSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f16693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Deque<a> f16694b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f16695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f16696b;
        public int c;
        public final int d;

        a(Object r1, int r2, int r3, int r4) {
            this.f16695a = r1;
            this.f16696b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static class b extends SpannableStringBuilder {
        b(CharSequence r3) {
            super((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        }
    }

    public x() {
        this("");
    }

    public x(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.f16694b = new ArrayDeque(8);
        this.f16693a = new StringBuilder(r4);
        a(0, r4);
    }

    private void a(int r8, CharSequence r9) {
        CharSequence r10 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Spanned.class) == false) goto L15;
        Spanned r11 = (Spanned) ZeusTransformUtils.preCheckCast(r10, Spanned.class, "com.obric.memorydata.plugin");
        boolean r0 = ZeusTransformUtils.instanceOf(r11, b.class);
        int r3 = 0;
        Object[] r1 = r11.getSpans(0, r11.length(), Object.class);
        if (r1 == null) goto L7;
        int r2 = r1.length;
    L8:
        if (r2 <= 0) goto L18;
        if (r0 == false) goto L13;
        int r4 = r2 - 1;
    L11:
        if (r4 < 0) goto L19;
        Object r5 = r1[r4];
        a(r5, r11.getSpanStart(r5) + r8, r11.getSpanEnd(r5) + r8, r11.getSpanFlags(r5));
        r4 = r4 - 1;
        goto L11
    L19:
        return;
    L13:
        if (r3 >= r2) goto L20;
        Object r6 = r1[r3];
        a(r6, r11.getSpanStart(r6) + r8, r11.getSpanEnd(r6) + r8, r11.getSpanFlags(r6));
        r3 = r3 + 1;
        goto L13
    L20:
        return;
    L18:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public static void a(x r1, Object r2, int r3, int r4) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (a(r1.length(), r3, r4) == true) goto L6;
        return;
    L6:
        b(r1, r2, r3, r4);
    }

    static boolean a(int r0, int r1, int r2) {
        if (r2 <= r1) goto L6;
        if (r1 < 0) goto L6;
        if (r2 > r0) goto L6;
        return true;
    L6:
        return false;
    }

    private static void b(x r3, Object r4, int r5, int r6) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.getClass().isArray() == false) goto L8;
        Object[] r7 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.memorydata.plugin"), Object[].class, "com.obric.memorydata.plugin");
        int r0 = r7.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L12;
        b(r3, r7[r1], r5, r6);
        r1 = r1 + 1;
        goto L6
    L12:
        return;
    L8:
        r3.a(r4, r5, r6, 33);
    }

    public char a() {
        return this.f16693a.charAt(length() - 1);
    }

    public x a(char r2) {
        this.f16693a.append(r2);
        return this;
    }

    public x a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        a(length(), r4);
        this.f16693a.append(r4);
        return this;
    }

    public x a(CharSequence r3, int r4, int r5) {
        CharSequence r6 = ((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin")).subSequence(r4, r5);
        a(length(), r6);
        this.f16693a.append(r6);
        return this;
    }

    public x a(Object r2, int r3) {
        return a(r2, r3, length());
    }

    public x a(Object r2, int r3, int r4) {
        return a(r2, r3, r4, 33);
    }

    public x a(Object r3, int r4, int r5, int r6) {
        this.f16694b.push(new a(r3, r4, r5, r6));
        return this;
    }

    public x a(String r2) {
        this.f16693a.append(r2);
        return this;
    }

    public CharSequence a(int r8) {
        int r0 = length();
        b r1 = new b(this.f16693a.subSequence(r8, r0));
        Iterator<a> r2 = this.f16694b.iterator();
    L4:
        if (r2.hasNext() == false) goto L12;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L12;
        if (r3.f16696b < r8) goto L4;
        if (r3.c > r0) goto L4;
        r1.setSpan(r3.f16695a, r3.f16696b - r8, r3.c - r8, 33);
        r2.remove();
    L12:
        this.f16693a.replace(r8, r0, "");
        return r1;
    }

    public List<a> a(int r5, int r6) {
        int r0 = length();
        if (a(r0, r5, r6) == false) goto L5;
        if (r5 != 0) goto L10;
        if (r0 != r6) goto L10;
        ArrayList r7 = new ArrayList(this.f16694b);
        Collections.reverse(r7);
        return Collections.unmodifiableList(r7);
    L10:
        ArrayList r1 = new ArrayList(0);
        Iterator<a> r4 = this.f16694b.descendingIterator();
    L12:
        if (r4.hasNext() == false) goto L27;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin");
        if (r2.f16696b < r5) goto L18;
        if (r2.f16696b >= r6) goto L18;
    L25:
        r1.add(r2);
    L18:
        if (r2.c > r6) goto L22;
        if (r2.c > r5) goto L25;
    L22:
        if (r2.f16696b >= r5) goto L12;
        if (r2.c <= r6) goto L12;
    L27:
        return Collections.unmodifiableList(r1);
    L5:
        return Collections.emptyList();
    }

    @Override // java.lang.Appendable
    public /* synthetic */ Appendable append(char r1) {
        return a(r1);
    }

    @Override // java.lang.Appendable
    public /* synthetic */ Appendable append(CharSequence r3) {
        return a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.lang.Appendable
    public /* synthetic */ Appendable append(CharSequence r3, int r4, int r5) {
        return a((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public SpannableStringBuilder b() {
        b r0 = new b(this.f16693a);
        Iterator<a> r5 = this.f16694b.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r5.next(), a.class, "com.obric.memorydata.plugin");
        r0.setSpan(r1.f16695a, r1.f16696b, r1.c, r1.d);
        goto L4
    L6:
        return r0;
    }

    @Override // java.lang.CharSequence
    public char charAt(int r1) {
        return this.f16693a.charAt(r1);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f16693a.length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r6, int r7) {
        List<a> r0 = a(r6, r7);
        if (r0.isEmpty() == true) goto L12;
        SpannableStringBuilder r1 = new SpannableStringBuilder(this.f16693a.subSequence(r6, r7));
        int r5 = r1.length();
        Iterator<a> r8 = r0.iterator();
    L7:
        if (r8.hasNext() == false) goto L10;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.memorydata.plugin");
        int r3 = Math.max(0, r2.f16696b - r6);
        int r4 = Math.min(r5, (r2.c - r2.f16696b) + r3);
        r1.setSpan(r2.f16695a, r3, r4, r2.d);
        goto L7
    L10:
        return r1;
    L12:
        return this.f16693a.subSequence(r6, r7);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f16693a.toString();
    }
}
