package com.larksuite.component.ui.tag;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f {
    public static final /* synthetic */ int g = 0;
    public final a a;
    public final int b;
    public final int c;
    public final Function1<Context, String> d;
    public final Lambda e;
    public final Lambda f;

    public static final class a {
        public int a;
        public int b;
        public int c;
        public String d;
        public int e;
        public Integer f;
        public int g;
        public Integer h;

        public final f a() {
            return new f(this);
        }

        public a() {
            this.a = -1;
            this.b = 100;
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((f) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "TextTag(bd=" + this.a + ')';
    }

    public f(final a r2) {
        this.a = r2;
        this.b = r2.a;
        this.c = r2.b;
        this.d = new TextTag$Builder$text$1(r2);
        if (r2.f == null) goto L5;
        Function2<Context, DrawableStateSet, Integer> r0 = new TextTag$Builder$textColor$1(r2);
    L6:
        this.e = r0;
        if (r2.h == null) goto L9;
        Function2<Context, DrawableStateSet, Integer> r1 = new TextTag$Builder$bgColor$1(r2);
    L10:
        this.f = r1;
        return;
    L9:
        r1 = new TextTag$Builder$bgColor$2(r2);
        goto L10
    L5:
        r0 = new TextTag$Builder$textColor$2(r2);
        goto L6
    }
}
