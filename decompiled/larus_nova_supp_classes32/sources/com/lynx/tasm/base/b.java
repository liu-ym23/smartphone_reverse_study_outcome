package com.lynx.tasm.base;

import com.lynx.base.log.AbsBaseLogDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b extends AbsBaseLogDelegate {
    public static AbsLogDelegate a;
    public static volatile b b;

    public static b a() {
        if (b != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public b() {
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public final void d(String r2, String r3) {
        AbsLogDelegate r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.d(r2, r3);
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public final void e(String r2, String r3) {
        AbsLogDelegate r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.e(r2, r3);
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public final void i(String r2, String r3) {
        AbsLogDelegate r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.i(r2, r3);
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public final void v(String r2, String r3) {
        AbsLogDelegate r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.v(r2, r3);
    }

    @Override // com.lynx.base.log.AbsBaseLogDelegate
    public final void w(String r2, String r3) {
        AbsLogDelegate r0 = a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.w(r2, r3);
    }
}
