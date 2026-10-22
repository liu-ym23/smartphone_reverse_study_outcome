package com.ss.android.lark.coremd.base.parse;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface f {

    public static final class a {
        public static void a(com.ss.android.lark.coremd.impl.parse.d r1, v7b.s r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "node");
        }

        public static void b(v7b.s r1, Spannable r2) {
            Intrinsics.checkNotNullParameter(r1, "node");
            Intrinsics.checkNotNullParameter(r2, "futureResult");
        }
    }

    void a(v7b.s r1, Spannable r2);

    void b(com.ss.android.lark.coremd.impl.parse.d r1, v7b.s r2);

    void d(com.ss.android.lark.coremd.impl.parse.k r1);

    void f(com.ss.android.lark.coremd.impl.parse.k r1);

    void g(com.ss.android.lark.coremd.impl.parse.d r1, SpannableStringBuilder r2);
}
