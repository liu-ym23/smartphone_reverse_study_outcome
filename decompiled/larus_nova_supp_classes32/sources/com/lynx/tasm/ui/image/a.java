package com.lynx.tasm.ui.image;

import com.facebook.drawee.components.DeferredReleaser;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static a c;
    public final Set<DeferredReleaser.Releasable> a;
    public final RunnableC0066a b;

    /* JADX INFO: renamed from: com.lynx.tasm.ui.image.a$a, reason: collision with other inner class name */
    public class RunnableC0066a implements Runnable {
        public final /* synthetic */ a a;

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<DeferredReleaser.Releasable> r0 = this.a.a.iterator();     // Catch: Throwable -> L8
        L4:
            if (r0.hasNext() == false) goto L6;
            r0.next().release();     // Catch: Throwable -> L8
            goto L4
        L6:
            this.a.a.clear();     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }

        public RunnableC0066a(a r1) {
            this.a = r1;
        }
    }

    public a() {
        this.b = new RunnableC0066a(this);
        this.a = Collections.newSetFromMap(new ConcurrentHashMap());
    }
}
