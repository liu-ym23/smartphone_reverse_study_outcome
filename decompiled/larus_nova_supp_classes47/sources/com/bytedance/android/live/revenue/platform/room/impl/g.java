package com.bytedance.android.live.revenue.platform.room.impl;

import com.bytedance.android.live.core.utils.AnchorMainPostOptUtils;
import com.bytedance.android.livesdk.config.b0;
import com.bytedance.android.scope.o;
import com.bytedance.android.scope.r;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class g implements o, r, yz0.m {
    public final List<yz0.m> a;

    public static final class a implements Runnable {
        public final /* synthetic */ yz0.m a;

        public a(yz0.m r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.i();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void onStart() {
    }

    @Override // yz0.m
    public final void i() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        yz0.m r1 = (yz0.m) r0.next();
        if (b0.a() == true) goto L7;
        r1.i();
        goto L4
    L7:
        AnchorMainPostOptUtils.b("RevRoomReady", new a(r1));
        goto L4
    }

    public final void onStop() {
        ((ArrayList) this.a).clear();
    }

    @Override // yz0.m
    public final void onViewReady() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((yz0.m) r0.next()).onViewReady();
        goto L4
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((yz0.m) r0.next()).onWidgetLoaded();
        goto L4
    }

    @Override // yz0.m
    public final void x() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((yz0.m) r0.next()).x();
        goto L4
    }

    public g() {
        this.a = new ArrayList();
    }

    public final boolean c(com.bytedance.android.scope.j r3, com.bytedance.android.scope.j r4) {
        Intrinsics.checkNotNullParameter(r3, "parentScope");
        Intrinsics.checkNotNullParameter(r4, "childScope");
        Intrinsics.checkNotNullParameter(r3, "parentScope");
        Intrinsics.checkNotNullParameter(r4, "childScope");
        Intrinsics.checkNotNullParameter(r3, "parentScope");
        Intrinsics.checkNotNullParameter(r4, "childScope");
        return false;
    }

    public final <T extends o> T a(e33.l r2, T r3, com.bytedance.android.scope.e r4) {
        Intrinsics.checkNotNullParameter(r2, "serviceDesc");
        Intrinsics.checkNotNullParameter(r3, "serviceInst");
        Intrinsics.checkNotNullParameter(r4, "context");
        if ((r3 instanceof yz0.m) == false) goto L5;
        ((ArrayList) this.a).add(r3);
    L5:
        return r3;
    }
}
