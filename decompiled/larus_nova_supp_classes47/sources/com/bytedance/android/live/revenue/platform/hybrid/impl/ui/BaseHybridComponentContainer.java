package com.bytedance.android.live.revenue.platform.hybrid.impl.ui;

import bz0.g;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.revenue.common.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class BaseHybridComponentContainer<T extends IHybridComponent> extends j implements zy0.c, IHybridComponent.a {
    public az0.a b;
    public final List<Function1<wy0.e, Unit>> c;
    public final T d;

    @Override // zy0.c
    public final xy0.a<?> g() {
        com.bytedance.android.live.revenue.platform.hybrid.impl.component.d.a r0 = com.bytedance.android.live.revenue.platform.hybrid.impl.component.d.d;
        T r1 = this.d;
        r0.getClass();
        return com.bytedance.android.live.revenue.platform.hybrid.impl.component.d.a.b(r1);
    }

    @Override // zy0.c
    public final xy0.a<?> w() {
        xy0.a<?> r0 = g();
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException(("hybrid component must not be null in container: " + this.d).toString());
    }

    @Override // zy0.c
    public final void l1(final Function1<? super wy0.e, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        az0.a r0 = this.b;
        if (r0 == null) goto L6;
        r3.invoke(r0);
        return;
    L6:
        List<Function1<wy0.e, Unit>> r1 = this.c;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new BaseHybridComponentContainer$awaitJsBridge$2(r3));
    }

    public final void onJSBridgeCreated(y6.c r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        az0.a r0 = new az0.a(r3);
        this.b = r0;
        Iterator<T> r4 = this.c.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((Function1) r4.next()).invoke(r0);
        goto L4
    L6:
        ((ArrayList) this.c).clear();
    }

    public BaseHybridComponentContainer(T r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "originalContainer");
        Intrinsics.checkNotNullParameter(r3, "model");
        this.d = r2;
        this.c = new ArrayList();
        r2.setJSBridgeListener(this);
    }
}
