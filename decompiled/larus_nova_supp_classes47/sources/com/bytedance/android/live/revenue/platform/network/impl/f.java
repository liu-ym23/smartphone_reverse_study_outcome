package com.bytedance.android.live.revenue.platform.network.impl;

import am3.g;
import am3.h;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.i;
import com.bytedance.android.scope.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements o {
    public final com.bytedance.android.livesdk.revenue.service.network.a a;

    public static final class a<T> implements am3.c<T> {
        public final Class<T> a;

        public a(Class<T> r2) {
            Intrinsics.checkNotNullParameter(r2, "type");
            this.a = r2;
        }

        public final T decode(g r5) {
            Intrinsics.checkNotNullParameter(r5, "reader");
            long r0 = r5.c();
        L4:
            if (r5.f() == (-1)) goto L5;
            h.e(r5);
            goto L4
        L5:
            r5.d(r0);
            Class<T> r6 = this.a;
            if (Intrinsics.areEqual(r6, Unit.class) == false) goto L9;
            return (T) Unit.INSTANCE;
        L9:
            if (Intrinsics.areEqual(r6, Object.class) == false) goto L12;
            return (T) new Object();
        L12:
            return r6.newInstance();
        }
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public f(com.bytedance.android.livesdk.revenue.service.network.a r2) {
        Intrinsics.checkNotNullParameter(r2, "networkService");
        this.a = r2;
    }

    public final <T> T a(g r2, Class<T> r3) {
        if (Intrinsics.areEqual(r3, Object.class) == false) goto L6;
        am3.c r4 = new a(Object.class);
    L10:
        return (T) r4.decode(r2);
    L6:
        if (Intrinsics.areEqual(r3, Unit.class) == false) goto L8;
        r4 = new a(Unit.class);
        goto L10
    L8:
        r4 = this.a.getProtoDecoder(r3);
        goto L10
    }

    public final <T extends Extra> T c(Extra r4, Class<T> r5) {
        Intrinsics.checkNotNullParameter(r4, "extra");
        Intrinsics.checkNotNullParameter(r5, "extraType");
        if ((r4 instanceof i) == false) goto L13;
        i r0 = (i) r4;
        byte[] r1 = r0.a;
        if (r1 == null) goto L13;
        if (r1.length != 0) goto L9;
        boolean r2 = true;
    L11:
        if ((!r2) != true) goto L13;
        g r3 = new g();
        r3.k(new am3.b(r0.a));
        T r6 = (T) a(r3, r5);
    L14:
        ((Extra) r6).now = r4.now;
        ((Extra) r6).hasMore = r4.hasMore;
        return r6;
    L9:
        r2 = false;
    L13:
        r6 = r5.newInstance();
        goto L14
    }
}
