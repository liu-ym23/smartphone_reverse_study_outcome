package com.ss.android.account;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class f {
    public static volatile f b;
    public final a a;

    public class a extends com.bytedance.sdk.account.utils.i<xqa.b> {
        public final Object b() {
            return e.a();
        }

        public a() {
        }
    }

    public static f a() {
        if (b != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public f() {
        this.a = new a();
    }
}
