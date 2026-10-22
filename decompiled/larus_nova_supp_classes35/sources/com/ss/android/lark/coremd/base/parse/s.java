package com.ss.android.lark.coremd.base.parse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface s {

    public static final class a {
        public static /* synthetic */ void a(s r2, int r3) {
            r2.h(r3, r2.length(), 0);
        }

        public static /* synthetic */ void b(s r1, int r2) {
            r1.i(r2, r1.length());
        }

        public static /* synthetic */ void c(s r1, int r2, int r3, int r4) {
            if ((r4 & 2) == 0) goto L6;
            r3 = r1.length();
        L6:
            if ((r4 & 4) == 0) goto L8;
            int r5 = 33;
        L9:
            r1.f(r2, r3, r5);
            return;
        L8:
            r5 = 0;
            goto L9
        }
    }

    com.ss.android.lark.coremd.impl.parse.n a();

    com.ss.android.lark.coremd.impl.parse.n b();

    String c(int r1, int r2);

    com.ss.android.lark.coremd.impl.parse.n d(CharSequence r1);

    void e(CharSequence r1, com.ss.android.lark.coremdbiz.facade.plugins.t r2);

    void f(int r1, int r2, int r3);

    com.ss.android.lark.coremd.impl.parse.n g(CharSequence r1);

    void h(int r1, int r2, int r3);

    void i(int r1, int r2);

    int length();

    void setSpan(Object r1, int r2, int r3, int r4);
}
