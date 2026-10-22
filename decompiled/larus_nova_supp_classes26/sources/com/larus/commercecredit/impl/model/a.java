package com.larus.commercecredit.impl.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final C0101a a = null;
    public static volatile a b;

    /* JADX INFO: renamed from: com.larus.commercecredit.impl.model.a$a, reason: collision with other inner class name */
    public static final class C0101a {
        public final void a() {
            if (a.b != null) goto L13;
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L6:
            if (a.b != null) goto L8;
            a.b = new a();     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
            return;
        }

        public C0101a() {
        }
    }

    static {
        a = new C0101a();
    }

    public a() {
    }
}
