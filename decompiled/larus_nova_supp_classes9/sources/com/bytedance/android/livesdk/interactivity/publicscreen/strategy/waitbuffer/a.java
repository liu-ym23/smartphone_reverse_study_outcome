package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer;

import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenIndividualPriorityState;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import r42.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class a implements ja2.b {
    public final List<ja2.b.a> a;
    public final List<ja2.b.a> b;

    @Override // ja2.b
    public void a() {
    }

    @Override // ja2.b
    public void f(PublicScreenIndividualPriorityState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // ja2.b
    public void onLoad() {
    }

    public a() {
        ArrayList r0 = new ArrayList();
        this.a = r0;
        this.b = r0;
    }

    public static boolean n(f r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        u3 r6 = r5.b;
        if ((r6 instanceof u3) == true) goto L5;
        r6 = null;
    L5:
        u3 r7 = r6;
        if (r7 == null) goto L24;
        IPublicAreaCommon r8 = r7.getOrInitPublicAreaCommon();
        if (r8 == null) goto L25;
        boolean r2 = r8.isFirstFetchBatchMsg();
        if (r8.isFirstAggregateHistoryMessage() == true) goto L12;
    L14:
        boolean r1 = false;
    L15:
        boolean r9 = !r8.isFirstAggregateHistoryMessage();
        if (r2 == false) goto L20;
        if (r1 == true) goto L19;
        if (r9 == false) goto L20;
    L19:
        boolean r10 = true;
    L21:
        if (r10 != true) goto L26;
        return true;
    L26:
        return false;
    L20:
        r10 = false;
        goto L21
    L12:
        if (g.a(null, null) == false) goto L14;
        r1 = true;
        goto L15
    L25:
        return false;
    L24:
        return false;
    }

    public final void o(f<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ja2.b.a) r0.next()).c(r3);
        goto L4
    }

    public final void p(f<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((ja2.b.a) r0.next()).a(r4, 2);
        goto L4
    }

    public final void q(f<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Iterator r3 = ((ArrayList) this.a).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ja2.b.a) r3.next()).b();
        goto L4
    }
}
