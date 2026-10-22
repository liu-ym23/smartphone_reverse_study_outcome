package com.bytedance.android.live.revlink.impl.multianchor.connect;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i {
    public Disposable a;
    public final a b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    public static final class a extends i11.c.a {
        public final /* synthetic */ i a;

        public a(i r1) {
            this.a = r1;
        }

        @Override // i11.c.a, i11.c.b
        public final void a(int r5, List r6) {
            Disposable r7 = this.a.a;
            if (r7 == null) goto L5;
            r7.dispose();
        L5:
            if (r6 != null) goto L7;
        L10:
            boolean r8 = true;
        L11:
            if (r8 == false) goto L13;
            return;
        L13:
            i r9 = this.a;
            List r10 = CollectionsKt.toList(r6);
            r9.getClass();
            Intrinsics.checkNotNullParameter(r10, "recordWaitingList");
            Disposable r0 = r9.a;
            if (r0 == null) goto L16;
            r0.dispose();
        L16:
            com.bytedance.revenue.platform.api.core.rx.l r1 = com.bytedance.revenue.platform.api.core.rx.l.a;
            int r2 = com.bytedance.revenue.platform.api.core.rx.p.a;
            r9.a = Observable.timer(30000, TimeUnit.MILLISECONDS, Schedulers.computation()).subscribe(new j(r9, r10));
            return;
        L7:
            if (r6.isEmpty() == true) goto L10;
            r8 = false;
            goto L11
        }
    }

    public final i11.b a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r1 = r0.R8();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getLinkUserCenter();
    L5:
        r1 = null;
        goto L6
    }

    public i(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.c = r1;
        this.b = new a(this);
    }
}
