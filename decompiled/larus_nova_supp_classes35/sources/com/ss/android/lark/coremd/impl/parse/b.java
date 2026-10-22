package com.ss.android.lark.coremd.impl.parse;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements com.ss.android.lark.coremd.base.parse.d {
    public final Context a;
    public final List<com.ss.android.lark.coremd.base.parse.g> b;
    public final com.ss.android.lark.coremd.base.parse.j c;
    public final List<com.ss.android.lark.coremd.base.parse.f> d;
    public l.a e;
    public j f;
    public g g;

    public static final class a implements com.ss.android.lark.coremd.base.parse.d {
        public final Context a;
        public final List<com.ss.android.lark.coremd.base.parse.g> b;
        public final com.ss.android.lark.coremd.base.parse.j c;
        public final List<com.ss.android.lark.coremd.base.parse.f> d;

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
            this.b = new ArrayList();
            this.c = com.ss.android.lark.coremd.base.parse.l.b();
            this.d = new ArrayList();
        }

        public final a b(com.ss.android.lark.coremd.base.parse.f r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            ((ArrayList) this.d).add(r2);
            return this;
        }

        public final a c(com.ss.android.lark.coremd.base.parse.j r2) {
            Intrinsics.checkNotNullParameter(r2, "theme");
            this.c.getValues().putAll(r2.getValues());
            return this;
        }

        public final CharSequence d(s r2) {
            Intrinsics.checkNotNullParameter(r2, "node");
            Intrinsics.checkNotNullParameter(r2, "node");
            return a(r2, com.ss.android.lark.coremd.base.parse.b.a);
        }

        public final a e(com.ss.android.lark.coremd.base.parse.g r2) {
            Intrinsics.checkNotNullParameter(r2, "plugin");
            ((ArrayList) this.b).add(r2);
            return this;
        }

        @Override // com.ss.android.lark.coremd.base.parse.d
        public final CharSequence a(s r2, com.ss.android.lark.coremd.base.parse.b r3) {
            Intrinsics.checkNotNullParameter(r2, "node");
            Intrinsics.checkNotNullParameter(r3, "markdownContext");
            return new b(this).a(r2, r3);
        }
    }

    public b(a r4) {
        this.a = r4.a;
        List<com.ss.android.lark.coremd.base.parse.g> r0 = r4.b;
        this.b = r0;
        this.c = r4.c;
        this.d = r4.d;
        this.g = new g();
        Iterator r5 = ((ArrayList) r0).iterator();
    L3:
        g r1 = null;
        if (r5.hasNext() == false) goto L10;
        com.ss.android.lark.coremd.base.parse.g r2 = (com.ss.android.lark.coremd.base.parse.g) r5.next();
        g r3 = this.g;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("clickRegistry");
    L9:
        r2.b(r1);
        goto L3
    L8:
        r1 = r3;
        goto L9
    L10:
        j.a r6 = new j.a();
        Iterator r7 = ((ArrayList) this.b).iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        ((com.ss.android.lark.coremd.base.parse.g) r7.next()).c(r6);
        goto L12
    L14:
        this.f = new j(r6.a);
        this.e = new l.a();
        Iterator r8 = ((ArrayList) this.b).iterator();
    L16:
        if (r8.hasNext() == false) goto L21;
        com.ss.android.lark.coremd.base.parse.g r9 = (com.ss.android.lark.coremd.base.parse.g) r8.next();
        l.a r10 = this.e;
        if (r10 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("visitorBuilder");
        r10 = null;
    L20:
        r9.a(r10);
        goto L16
    L21:
        c r11 = new c(this);
        Iterator r12 = ((ArrayList) this.b).iterator();
    L23:
        if (r12.hasNext() == false) goto L25;
        ((com.ss.android.lark.coremd.base.parse.g) r12.next()).d(r11);
        goto L23
    }

    @Override // com.ss.android.lark.coremd.base.parse.d
    public final CharSequence a(s r10, com.ss.android.lark.coremd.base.parse.b r11) {
        Intrinsics.checkNotNullParameter(r10, "node");
        Intrinsics.checkNotNullParameter(r11, "markdownContext");
        Context r3 = this.a;
        j r1 = this.f;
        l.a r8 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("spanFactory");
        j r4 = null;
    L6:
        g r2 = this.g;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("clickRegistry");
        g r5 = null;
    L10:
        d r0 = new d(r11, r3, r4, r5, this.c, this.d);
        l.a r12 = this.e;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("visitorBuilder");
    L14:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "context");
        l r13 = new l(r8.a, r0);
        Iterator r6 = ((ArrayList) this.d).iterator();
    L16:
        if (r6.hasNext() == false) goto L18;
        ((com.ss.android.lark.coremd.base.parse.f) r6.next()).b(r0, r10);
        goto L16
    L18:
        r13.a(r10);
        SpannableStringBuilder r14 = r13.e;
        int r15 = r14.length();
        Character r7 = StringsKt.lastOrNull(r14);
        if (r7 != null) goto L22;
    L31:
        Iterator r16 = ((ArrayList) this.d).iterator();
    L33:
        if (r16.hasNext() == false) goto L35;
        ((com.ss.android.lark.coremd.base.parse.f) r16.next()).g(r0, r14);
        goto L33
    L35:
        return r14;
    L22:
        if (r7.charValue() != '\n') goto L31;
        int r9 = r15 - 1;
        if (r14.getSpans(r9, r15, x9b.a.class).length != 0) goto L27;
        boolean r17 = true;
    L29:
        if ((!r17) == true) goto L31;
        r14.replace(r9, r15, BuildConfig.FLAVOR);
        goto L31
    L27:
        r17 = false;
        goto L29
    L13:
        r8 = r12;
        goto L14
    L9:
        r5 = r2;
        goto L10
    L5:
        r4 = r1;
        goto L6
    }
}
