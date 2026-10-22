package com.bytedance.android.live.ktv.common.util;

import com.bytedance.android.livesdk.ktvapi.util.KtvCommonSettingHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements tb0.a {
    public tb0.c a;
    public final CopyOnWriteArrayList<m> b;

    @Override // tb0.a
    public final void onBizDestory() {
    }

    @Override // tb0.a
    public final void onBizEnterRoom() {
    }

    @Override // tb0.a
    public final void onBizHide() {
    }

    @Override // tb0.a
    public final void onBizLeaveRoom() {
    }

    @Override // tb0.a
    public final void onBizShow() {
    }

    public e() {
        this.a = tb0.c.C0281c.c;
        this.b = new CopyOnWriteArrayList();
    }

    public final void a(tb0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "lc");
        this.b.add(new d(r3));
    }

    public final void b(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "cb");
        if ((this.a instanceof tb0.c.b) == true) goto L5;
        Lazy r3 = KtvCommonSettingHelper.a;
        return;
    L5:
        r2.invoke();
    }

    public final void c(tb0.a r6) {
        Intrinsics.checkNotNullParameter(r6, "lc");
        CopyOnWriteArrayList<m> r0 = this.b;
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        Object r3 = r2.next();
        m r4 = (m) r3;
        if ((r4 instanceof d) == true) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        if (Intrinsics.areEqual(((d) r4).a, r6) == false) goto L10;
        r5 = true;
        goto L11
    L13:
        this.b.removeAll(r1);
    }

    public final void d(tb0.b r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        tb0.c r0 = this.a;
        if ((r5 instanceof tb0.b.a) == false) goto L6;
        this.a = new tb0.c.b(r5);
    L12:
        Iterator<m> r1 = this.b.iterator();
    L14:
        if (r1.hasNext() == false) goto L17;
        r1.next().a(r5, this.a);
        goto L14
    L17:
        if ((!Intrinsics.areEqual(r0.b, this.a.b)) == false) goto L22;
        Iterator<m> r6 = this.b.iterator();
    L20:
        if (r6.hasNext() == false) goto L25;
        r6.next().b(this.a);
        goto L20
    L25:
        return;
    L22:
        return;
    L6:
        if ((r5 instanceof tb0.b.C0280b) == false) goto L9;
        this.a = new tb0.c.a(r5);
        goto L12
    L9:
        if ((r5 instanceof tb0.b.e) == false) goto L11;
        this.a = tb0.c.C0281c.c;
        goto L12
    L11:
        r0.a = r5;
        goto L12
    }
}
