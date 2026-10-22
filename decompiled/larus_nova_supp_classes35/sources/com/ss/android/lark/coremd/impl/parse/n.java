package com.ss.android.lark.coremd.impl.parse;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.coremd.base.parse.TextFutureRunner;
import com.ss.android.lark.coremd.base.parse.s;
import com.ss.android.lark.coremd.base.parse.w;
import com.ss.android.lark.coremd.base.parse.x;
import com.ss.android.lark.coremd.base.parse.y;
import com.ss.android.lark.coremdbiz.facade.plugins.t;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements s {
    public final v7b.s a;
    public final SpannableStringBuilder b;
    public final w c;
    public final d d;

    public static final class a implements x.a {
        public final WeakReference<SpannableStringBuilder> a;
        public final y b;
        public final e c;
        public final List<com.ss.android.lark.coremd.base.parse.f> d;

        @Override // com.ss.android.lark.coremd.base.parse.x.a
        public final void a() {
            SpannableStringBuilder r0 = this.a.get();
            if (r0 == null) goto L6;
            r0.removeSpan(this.b);
            return;
        }

        @Override // com.ss.android.lark.coremd.base.parse.x.a
        public final void b(v7b.s r6, Spannable r7) {
            Intrinsics.checkNotNullParameter(r6, "node");
            Intrinsics.checkNotNullParameter(r7, "text");
            Iterator<T> r1 = this.d.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((com.ss.android.lark.coremd.base.parse.f) r1.next()).a(r6, r7);
            goto L4
        L6:
            e r8 = this.c;
            y r2 = this.b;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r2, "span");
            Intrinsics.checkNotNullParameter(r7, "text");
            List r0 = CollectionsKt.toList(r8.a.keySet());
            boolean r3 = false;
            if (r0.isEmpty() == false) goto L9;
            r8.b.put(r2, r7);
            boolean r9 = false;
        L14:
            if (r9 == false) goto L26;
            SpannableStringBuilder r10 = this.a.get();
            if (r10 == null) goto L27;
            int r4 = r10.getSpanStart(this.b);
            int r5 = r10.getSpanEnd(this.b);
            if (r4 < 0) goto L21;
            if (r4 > r5) goto L21;
            r3 = true;
        L21:
            if (r3 == false) goto L28;
            r10.replace(r4, r5, BuildConfig.FLAVOR);
            r10.insert(r4, r7);
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L9:
            Iterator r11 = r0.iterator();
        L11:
            if (r11.hasNext() == false) goto L13;
            ((e.a) r11.next()).b(r2, r7);
            goto L11
        L13:
            r9 = true;
            goto L14
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(WeakReference<SpannableStringBuilder> r2, y r3, e r4, List<? extends com.ss.android.lark.coremd.base.parse.f> r5) {
            Intrinsics.checkNotNullParameter(r2, "builderRef");
            Intrinsics.checkNotNullParameter(r3, "futureSpan");
            Intrinsics.checkNotNullParameter(r4, "nodeHandle");
            Intrinsics.checkNotNullParameter(r5, "parseListeners");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final n a() {
        boolean r2 = false;
        if (this.b.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return this;
    L8:
        Character r1 = StringsKt.lastOrNull(this.b);
        if (r1 != null) goto L12;
    L13:
        Intrinsics.checkNotNullParameter("\n", "text");
        this.b.append("\n");
        return this;
    L12:
        if (r1.charValue() != '\n') goto L13;
        int r3 = this.b.length();
        x9b.f[] r4 = (x9b.f[]) this.b.getSpans(r3, r3, x9b.f.class);
        Intrinsics.checkNotNull(r4);
        if (r4.length != 0) goto L19;
        r2 = true;
    L19:
        if ((!r2) == false) goto L21;
        Intrinsics.checkNotNullParameter("\n", "text");
        this.b.append("\n");
    L21:
        return this;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final n b() {
        this.b.append('\n');
        return this;
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final int length() {
        return this.b.length();
    }

    public final String toString() {
        return this.b.toString();
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final n d(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.b.append(r2);
        return this;
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final n g(CharSequence r4) {
        Intrinsics.checkNotNullParameter(r4, "text");
        int r0 = length();
        this.b.append(r4);
        this.c.c(this.b, r0, length());
        return this;
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final String c(int r2, int r3) {
        return this.b.subSequence(r2, r3).toString();
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final void e(CharSequence r8, t r9) {
        Intrinsics.checkNotNullParameter(r8, "text");
        Intrinsics.checkNotNullParameter(r9, "future");
        int r4 = this.b.length();
        this.b.append(r8);
        int r5 = this.b.length();
        y r10 = new y(new TextFutureRunner(r9));
        WeakReference r0 = new WeakReference(this.b);
        d r1 = this.d;
        a r11 = new a(r0, r10, r1.i, r1.h);
        this.c.a(this.b, r10, r4, r5, 33);
        Intrinsics.checkNotNullParameter(r11, "handle");
        TextFutureRunner r12 = r10.a;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r11, "handle");
        if (r12.b.compareTo(TextFutureRunner.State.IDLE) > 0) goto L7;
        r12.b = TextFutureRunner.State.RUNNING;
        r12.a.a(new TextFutureRunner.a(r12, r11));
        return;
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final void i(int r4, int r5) {
        w.a.a(this.c, this.b, this.a, r4, r5);
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final void f(int r7, int r8, int r9) {
        this.c.e(this.b, this.a, r7, r8, r9);
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final void h(int r7, int r8, int r9) {
        this.c.b(this.b, this.a, r7, r8, r9);
    }

    public n(v7b.s r2, SpannableStringBuilder r3, MarkdownSpanSetterImpl r4, d r5) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "spanSetter");
        Intrinsics.checkNotNullParameter(r5, "parseContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    @Override // com.ss.android.lark.coremd.base.parse.s
    public final void setSpan(Object r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "span");
        this.c.a(this.b, r8, r9, r10, r11);
    }
}
