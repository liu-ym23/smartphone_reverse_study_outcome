package org.threeten.bp.zone;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class b {
    public static final AtomicBoolean a = null;
    public static final AtomicReference<b> b = null;

    public static class a extends b {
        @Override // org.threeten.bp.zone.b
        public final void a() {
        }

        public a() {
        }
    }

    public abstract void a();

    static {
        new a();
        a = new AtomicBoolean(false);
        b = new AtomicReference();
    }

    public b() {
    }
}
