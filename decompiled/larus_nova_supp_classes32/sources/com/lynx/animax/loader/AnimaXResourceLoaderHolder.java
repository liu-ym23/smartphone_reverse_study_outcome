package com.lynx.animax.loader;

import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.animax.util.AnimaXLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u4a.c;
import u4a.d;
import u4a.k;
import w4a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AnimaXResourceLoaderHolder {
    public long a;
    public final List<AnimaXLoader> b;
    public final q4a.a c;

    public static class a implements Runnable {
        public long a;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        L14:
            return;
        L3:
            if (this.a == 0) goto L10;
            AnimaXLog.b("AnimaXResourceLoaderHolder", "Call nativeDestroy.");     // Catch: Throwable -> L7
            AnimaXResourceLoaderHolder.a(this.a);     // Catch: Throwable -> L7
            this.a = 0;     // Catch: Throwable -> L7
            return;
        }

        public a(long r1) {
            this.a = r1;
        }
    }

    private static native long nativeCreate();

    private static native void nativeDestroy(long r0);

    private static native void nativeRegisterLoaderForScheme(long r0, AnimaXLoader r2, int r3);

    public AnimaXResourceLoaderHolder(b r5) {
        this.b = new ArrayList();
        this.c = null;
        this.a = nativeCreate();
        this.c = new q4a.a(this, new a(this.a));
        b(new u4a.a());
        b(new d());
        b(new u4a.b());
        b(new c());
        if (r5 != null) goto L5;
        AnimaXLog.a("AnimaXResourceLoaderHolder", "resourceFactory is null");
        return;
    L5:
        List<k> r6 = r5.b();
        if (r6 != null) goto L8;
        AnimaXLog.a("AnimaXResourceLoaderHolder", "loaders is null");
        return;
    L8:
        Iterator<k> r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L15;
        b(r7.next());
        goto L10
    }

    public static /* synthetic */ void a(long r0) {
        nativeDestroy(r0);
    }

    public final void b(k r4) {
        AnimaXLoader r0 = AnimaXLoader.create(r4);
        this.b.add(r0);
        nativeRegisterLoaderForScheme(this.a, r0, r4.getScheme().ordinal());
    }
}
