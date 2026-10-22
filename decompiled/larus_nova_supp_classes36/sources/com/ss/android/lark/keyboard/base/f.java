package com.ss.android.lark.keyboard.base;

import com.ss.android.lark.widget.richtext.RichText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface f extends mob.a, b, c {
    public static final a I1 = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static final com.ss.android.lark.keyboard.event.d b = null;

        public a() {
        }

        static {
            a = new a();
            b = new com.ss.android.lark.keyboard.event.d();
        }
    }

    static {
        I1 = a.a;
    }

    void D();

    void E(l r1);

    void F(boolean r1, Long r2, boolean r3, String r4, r r5);

    void I(CharSequence r1);

    q N(boolean r1);

    void O(CharSequence r1, int r2);

    RichText getContent();

    void o(boolean r1);

    void p(l r1);
}
