package com.bytedance.android.live.revenuelink.multimsg;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.revenuelink.connect.LinkOutManager;
import com.bytedance.android.live.revenuelink.rtc.i;
import com.bytedance.android.livesdk.config.z51;
import com.bytedance.android.livesdk.link.model.bridge.h2;
import com.bytedance.android.livesdk.message.model.qj;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import yz0.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class a extends com.bytedance.android.live.revenuelink.rtc.e implements com.bytedance.android.live.revenuelink.multimsg.api.b {
    public static final /* synthetic */ int j = 0;
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final HashMap<String, Set<e>> d;
    public final CopyOnWriteArraySet<c> e;
    public final HashMap<String, CompositeDisposable> f;
    public final ConcurrentHashMap<Long, Integer> g;
    public final i h;
    public final yz0.f i;

    /* JADX INFO: renamed from: com.bytedance.android.live.revenuelink.multimsg.a$a, reason: collision with other inner class name */
    public static final class C0112a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.revenuelink.multimsg.api.b
    public final void f(com.bytedance.android.live.revenuelink.multimsg.api.e<?, ? extends Exception> r3) {
        Intrinsics.checkNotNullParameter(r3, "result");
        if ((r3 instanceof com.bytedance.android.live.revenuelink.multimsg.api.e.c) == false) goto L10;
        V r4 = ((com.bytedance.android.live.revenuelink.multimsg.api.e.c) r3).b;
        if ((r4 instanceof g) == false) goto L15;
        g r5 = (g) r4;
        yh6.c r0 = r5.b;
        if (r0 == null) goto L16;
        k(1, r0, r5.a);
        return;
    L16:
        return;
    L15:
        return;
    L10:
        if ((r3 instanceof com.bytedance.android.live.revenuelink.multimsg.api.e.b) == false) goto L14;
        ((com.bytedance.android.live.revenuelink.multimsg.api.e.b) r3).getClass();
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public a(i r6, yz0.f r7) {
        this.h = r6;
        this.i = r7;
        xa1.b r8 = xa1.b.d;
        r8.getClass();
        ReadOnlyProperty r9 = xa1.b.b;
        KProperty[] r0 = xa1.b.a;
        boolean r1 = false;
        z51 r2 = (z51) r9.getValue(r8, r0[0]);
        if (r2 == null) goto L9;
        Integer r3 = r2.L1();
        if (r3 == null) goto L9;
        if ((r3.intValue() & 2) != 2) goto L9;
        boolean r4 = true;
    L10:
        this.a = r4;
        z51 r5 = (z51) r9.getValue(r8, r0[0]);
        this.b = true;
        z51 r10 = (z51) r9.getValue(r8, r0[0]);
        if (r10 == null) goto L13;
        Integer r12 = r10.L1();
    L14:
        if (r12 != null) goto L17;
    L19:
        this.c = r1;
        this.d = new HashMap();
        this.e = new CopyOnWriteArraySet();
        this.f = new HashMap();
        this.g = new ConcurrentHashMap();
        return;
    L17:
        if (r12.intValue() != 3) goto L19;
        r1 = true;
        goto L19
    L13:
        r12 = null;
    L9:
        r4 = false;
        goto L10
    }

    public final void j(yh6.b r5, LinkOutManager r6) {
        Intrinsics.checkNotNullParameter(r5, "method");
        Intrinsics.checkNotNullParameter(r6, "listener");
        if (this.b == false) goto L14;
        yz0.f r0 = this.i;
        if (r0 == null) goto L14;
        Observable r1 = h.a.a(r0, r5, false, 6);
        if (r1 == null) goto L14;
        final BaseMultiMsgManager$addMessageListener$1 r2 = new BaseMultiMsgManager$addMessageListener$1(this);
        Disposable r3 = r1.subscribe(new b(r2));
        if (r3 == null) goto L14;
        HashMap<String, CompositeDisposable> r4 = this.f;
        String r7 = r5.getName();
        CompositeDisposable r8 = r4.get(r7);
        if (r8 != null) goto L13;
        r8 = new CompositeDisposable();
        r4.put(r7, r8);
    L13:
        com.bytedance.revenue.platform.api.core.rx.f.a(r3, r8);
    L14:
        Set<e> r9 = this.d.get(r5.getName());
        if (r9 != null) goto L17;
        r9 = new CopyOnWriteArraySet();
        this.d.put(r5.getName(), r9);
    L17:
        r9.add(r6);
    }

    public final void k(int r9, yh6.c r10, h2 r12) {
        String r0 = null;
        if (r10 == null) goto L5;
        Long r1 = qj.a(r10);
    L6:
        long r3 = 0;
        if (r9 != 1) goto L16;
        if (r1 != null) goto L10;
    L11:
        if (r12 == null) goto L15;
        h2.b r13 = r12.getHeader();
        if (r13 == null) goto L15;
        r1 = Long.valueOf(r13.getMsgId());
    L15:
        r1 = null;
        goto L16
    L10:
        if (r1.longValue() == 0) goto L11;
    L16:
        if (r1 == null) goto L18;
        r3 = r1.longValue();
    L18:
        Integer r14 = this.g.get(Long.valueOf(r3));
        boolean r2 = false;
        if (r14 != null) goto L21;
    L23:
        boolean r15 = false;
    L24:
        Iterator<c> r5 = this.e.iterator();
    L26:
        if (r5.hasNext() == false) goto L29;
        r5.next().a(r10, r15);
        goto L26
    L29:
        if (this.c == false) goto L45;
        Integer r16 = this.g.get(Long.valueOf(r3));
        if (r16 != null) goto L35;
    L38:
        if (r16 != null) goto L41;
    L44:
        this.g.put(Long.valueOf(r3), Integer.valueOf(r9));
        goto L45
    L41:
        if (r16.intValue() != 1) goto L44;
        if (r9 != 0) goto L46;
        this.g.remove(Long.valueOf(r3));
    L46:
        if (r2 == true) goto L48;
        return;
    L48:
        HashMap<String, Set<e>> r17 = this.d;
        if (r10 == null) goto L53;
        m0 r18 = r10.getCommonData();
        if (r18 == null) goto L53;
        r0 = r18.getMethod();
    L53:
        Set<e> r19 = r17.get(r0);
        if (r19 != null) goto L56;
        return;
    L56:
        if ((!r19.isEmpty()) == false) goto L64;
        Iterator<e> r20 = r19.iterator();
    L59:
        if (r20.hasNext() == false) goto L65;
        r20.next().a(r10);
        goto L59
    L65:
        return;
    L64:
        return;
    L35:
        if (r16.intValue() != 0) goto L38;
        if (r9 != 1) goto L46;
        this.g.remove(Long.valueOf(r3));
    L45:
        r2 = true;
        goto L46
    L21:
        if (r14.intValue() == r9) goto L23;
        r15 = true;
        goto L24
    L5:
        r1 = null;
        goto L6
    }
}
