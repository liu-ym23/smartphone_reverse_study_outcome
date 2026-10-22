package com.ss.android.lark.keyboard_biz_emoji_office;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class c {
    public final String a;

    public static final class a extends c {
        public static final a b = null;

        static {
            b = new a();
        }

        public a() {
            super("custom_sticker");
        }
    }

    public static final class b extends c {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super("emoji");
        }
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public c(String r1) {
        this.a = r1;
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof c) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.a, ((c) r2).a);
    }
}
