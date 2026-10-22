package com.bytedance.android.live.profit.livepet;

import android.graphics.Rect;
import android.view.ViewGroup;
import com.bytedance.android.live.profit.livepet.container.LivePetContainerWidget;
import com.bytedance.android.live.profit.livepet.container.LivePetGiftInterceptor;
import com.bytedance.android.live.profit.livepet.container.l;
import com.bytedance.android.live.profit.livepet.container.n;
import com.bytedance.android.livesdk.message.model.cb;
import com.bytedance.android.scope.m;
import com.bytedance.android.scope.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import pu0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements o, b {
    public final HashMap<Integer, ru0.a> a;
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.live.profit.livepet.b
    public final com.bytedance.android.live.profit.livepet.container.d l1() {
        if (this.b == true) goto L7;
        return null;
    L7:
        return com.bytedance.android.live.profit.livepet.container.d.c;
    }

    public d() {
        this.a = new HashMap();
        this.b = qu0.b.c.a().getEnabled();
    }

    @Override // com.bytedance.android.live.profit.livepet.b
    public final void E1(cb r5) {
        Intrinsics.checkNotNullParameter(r5, "petEffectInfo");
        Iterator<T> r0 = this.a.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        ru0.a r1 = (ru0.a) r0.next();
        LivePetMessageDispatcher r2 = (LivePetMessageDispatcher) m.e.d(r1, LivePetMessageDispatcher.class);
        if (r2 == null) goto L4;
        r2.a(r5, "SendGiftResponse");
        goto L4
    }

    @Override // com.bytedance.android.live.profit.livepet.b
    public final boolean G3(long r6) {
        if (this.b == true) goto L5;
        return false;
    L5:
        Collection<ru0.a> r0 = this.a.values();
        if ((r0 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L28;
        ru0.a r2 = (ru0.a) r1.next();
        LivePetGiftInterceptor r3 = (LivePetGiftInterceptor) m.e.d(r2, LivePetGiftInterceptor.class);
        if (r3 != null) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == false) goto L12;
        return true;
    L16:
        if (r3.a(r6) != true) goto L18;
        r4 = true;
        goto L19
    L28:
        return false;
    L8:
        if (r0.isEmpty() == false) goto L10;
        return false;
    }

    @Override // com.bytedance.android.live.profit.livepet.b
    public final void e3(com.bytedance.android.live.profit.livepet.a r9) {
        Intrinsics.checkNotNullParameter(r9, "location");
        Iterator<T> r1 = this.a.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        ru0.a r2 = (ru0.a) r1.next();
        m r3 = m.e;
        com.bytedance.android.live.profit.livepet.container.c r4 = (com.bytedance.android.live.profit.livepet.container.c) r3.d(r2, com.bytedance.android.live.profit.livepet.container.c.class);
        if (r4 == null) goto L4;
        LivePetContainerWidget r5 = r4.d;
        if (r5 == null) goto L4;
        Intrinsics.checkNotNullParameter(r9, "location");
        ViewGroup r6 = r5.b;
        if (r6 == null) goto L4;
        ru0.a r7 = r5.c;
        if (r7 == null) goto L4;
        e r8 = (e) r3.d(r7, e.class);
        if (r8 == null) goto L4;
        int[] r10 = new int[2];
        r6.getLocationOnScreen(r10);
        int r12 = -r10[0];
        int r13 = -r10[1];
        Intrinsics.checkNotNullParameter(r9, "location");
        n r14 = r8.d.c;
        Rect r15 = r9.b;
        l r16 = new l(r14);
        r16.a = r15.left + r12;
        r16.b = r15.top + r13;
        r16.c = r15.width();
        r16.d = r15.height();
        r8.a.b(TuplesKt.to(Long.valueOf(r9.a), r16));
        goto L4
    }

    @Override // com.bytedance.android.live.profit.livepet.b
    public final void V1(boolean r6, Long r7) {
        Iterator<T> r0 = this.a.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L17;
        ru0.a r1 = (ru0.a) r0.next();
        e r2 = (e) m.e.d(r1, e.class);
        if (r2 == null) goto L4;
        Long r3 = r2.c;
        if (r6 == true) goto L9;
        if (r3 == null) goto L16;
        r2.b.onNext(TuplesKt.to(Boolean.FALSE, r3));
    L16:
        r2.c = null;
        goto L4
    L9:
        if (r7 == null) goto L4;
        if (r3 == null) goto L13;
        r2.b.onNext(TuplesKt.to(Boolean.FALSE, r3));
    L13:
        r2.c = r7;
        r2.b.onNext(TuplesKt.to(Boolean.TRUE, r7));
        goto L4
    }
}
