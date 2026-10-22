package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenIndividualPriorityState;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n;
import com.bytedance.android.livesdk.interactivity.api.settings.config.m;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.DoubleHitStrategy;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.FoldComposePriorityQueue;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.FoldStrategy;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.NormalStrategy;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.ScrollComposePriorityQueue;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.g;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.k;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import com.bytedance.android.livesdk.interactivity.textmessage.utils.j;
import com.bytedance.android.livesdk.interactivity.utils.PublicScreenMessageMonitor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.disposables.Disposable;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r52.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MultiQueueWaitMessageBufferV2 extends a {
    public final Queue<f<?>> c;
    public final boolean d;
    public final boolean e;
    public final Disposable f;
    public final ja2.a g;
    public final ScrollComposePriorityQueue h;
    public final NormalStrategy i;
    public final com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.f j;
    public final g k;
    public final DoubleHitStrategy l;
    public k m;
    public final FoldStrategy n;
    public final Queue<f<?>> o;
    public final Queue<f<?>> p;
    public final h q;
    public final int r;
    public final int s;
    public final boolean t;

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a, ja2.b
    public final void a() {
        this.h.e(MultiQueueWaitMessageBufferV2$clearRtcRoomMessage$1.INSTANCE);
        com.bytedance.android.livesdk.interactivity.common.utils.k.d(this.c, MultiQueueWaitMessageBufferV2$clearRtcRoomMessage$2.INSTANCE);
        com.bytedance.android.livesdk.interactivity.common.utils.k.d(this.o, MultiQueueWaitMessageBufferV2$clearRtcRoomMessage$3.INSTANCE);
        this.q.e(MultiQueueWaitMessageBufferV2$clearRtcRoomMessage$4.INSTANCE);
    }

    @Override // ja2.b
    public final int c() {
        if (this.t == false) goto L6;
        return 0;
    L6:
        return ((ArrayDeque) this.p).size();
    }

    @Override // ja2.b
    public final void clearAll() {
        this.q.clear();
        this.h.clear();
    }

    @Override // ja2.b
    public final int d() {
        if (this.t == false) goto L6;
        return 0;
    L6:
        return ((ArrayDeque) this.o).size();
    }

    @Override // ja2.b
    public final int g() {
        return (this.h.size() + ((ArrayDeque) this.c).size()) + this.q.size();
    }

    @Override // ja2.b
    public final int i() {
        return this.h.size() + ((ArrayDeque) this.c).size();
    }

    @Override // ja2.b
    public final long k() {
        ScrollComposePriorityQueue r0 = this.h;
        MultiQueueWaitMessageBufferV2$getFirstDelayTime$1 r1 = MultiQueueWaitMessageBufferV2$getFirstDelayTime$1.INSTANCE;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "predicate");
        Iterator<T> r2 = r0.a.iterator();
    L3:
        Object r4 = null;
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((Boolean) r1.invoke(r3)).booleanValue() == false) goto L3;
    L9:
        f r5 = (f) r3;
        Iterator r6 = ((ArrayDeque) r0.b).iterator();
    L11:
        if (r6.hasNext() == false) goto L15;
        Object r7 = r6.next();
        if (((Boolean) r1.invoke(r7)).booleanValue() == false) goto L11;
    L16:
        f r8 = (f) r7;
        Iterator r9 = ((ArrayDeque) r0.c).iterator();
    L18:
        if (r9.hasNext() == false) goto L22;
        Object r10 = r9.next();
        if (((Boolean) r1.invoke(r10)).booleanValue() == false) goto L18;
    L23:
        f r11 = (f) r10;
        Iterator r13 = ((ArrayDeque) r0.d).iterator();
    L25:
        if (r13.hasNext() == false) goto L29;
        Object r14 = r13.next();
        if (((Boolean) r1.invoke(r14)).booleanValue() == false) goto L25;
        r4 = r14;
    L29:
        ScrollComposePriorityQueue.c r15 = ScrollComposePriorityQueue.c.a;
        f r16 = (f) ComparisonsKt.minOf((f) ComparisonsKt.minOf(r5, r8, r15), (f) ComparisonsKt.minOf(r11, (f) r4, r15), r15);
        if (r16 != null) goto L46;
        return 0;
    L46:
        return System.currentTimeMillis() - r16.p().longValue();
    L22:
        r10 = null;
        goto L23
    L15:
        r7 = null;
        goto L16
    L8:
        r3 = null;
        goto L9
    }

    @Override // ja2.b
    public final void onUnload() {
        Disposable r0 = this.f;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    @Override // ja2.b
    public final f<?> b(Function1<? super f<?>, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r4, "predicate");
        f<?> r0 = this.q.a(r4);
        if (r0 != null) goto L5;
        r0 = this.h.a(r4);
    L5:
        if (r0 != null) goto L18;
        Iterator r1 = ((ArrayDeque) this.c).iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();
        if (((Boolean) r4.invoke(r2)).booleanValue() == false) goto L8;
    L14:
        return (f) r2;
    L12:
        r2 = null;
        goto L14
    L18:
        return r0;
    }

    @Override // ja2.b
    public final void e(Function1<? super f<?>, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "operation");
        ScrollComposePriorityQueue r1 = this.h;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "operation");
        Iterator<T> r0 = r1.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r4.invoke(r0.next());
        goto L4
    L6:
        Iterator r2 = ((ArrayDeque) r1.b).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r4.invoke(r2.next());
        goto L8
    L10:
        Iterator r3 = ((ArrayDeque) r1.c).iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        r4.invoke(r3.next());
        goto L12
    L14:
        Iterator r5 = ((ArrayDeque) r1.d).iterator();
    L16:
        if (r5.hasNext() == false) goto L18;
        r4.invoke(r5.next());
        goto L16
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a, ja2.b
    public final void f(PublicScreenIndividualPriorityState r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        if (this.d == false) goto L5;
        this.m = this.l;
        SimpleDateFormat r4 = PublicScreenMessageMonitor.a;
        PublicScreenMessageMonitor.u().c++;
        return;
    L5:
        int r5 = c.a[r3.ordinal()];
        if (r5 != 1) goto L8;
        SimpleDateFormat r6 = PublicScreenMessageMonitor.a;
        PublicScreenMessageMonitor.u().c++;
        n.b(MultiQueueWaitMessageBufferV2$updatePriorityStrategy$1.INSTANCE);
        k r7 = this.l;
    L15:
        this.m = r7;
        return;
    L8:
        if (r5 != 2) goto L10;
        SimpleDateFormat r8 = PublicScreenMessageMonitor.a;
        PublicScreenMessageMonitor.u().a++;
        r7 = this.j;
        goto L15
    L10:
        if (r5 == 3) goto L12;
        n.b(MultiQueueWaitMessageBufferV2$updatePriorityStrategy$2.INSTANCE);
        r7 = this.i;
        goto L15
    L12:
        SimpleDateFormat r9 = PublicScreenMessageMonitor.a;
        PublicScreenMessageMonitor.u().b++;
        r7 = this.k;
        goto L15
    }

    @Override // ja2.b
    public final void j(Function1<? super f<?>, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "predicate");
        Iterator<T> r0 = this.h.e(r3).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        q((f) r0.next());
        goto L4
    L6:
        Iterator r1 = ((ArrayList) com.bytedance.android.livesdk.interactivity.common.utils.k.d(this.c, r3)).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        q((f) r1.next());
        goto L8
    L10:
        Iterator<T> r4 = this.q.e(r3).iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        q((f) r4.next());
        goto L12
    }

    @Override // ja2.b
    public final List<f<?>> l(ka2.a r8) {
        Intrinsics.checkNotNullParameter(r8, "updateInfo");
        if (this.e == true) goto L5;
        final long r0 = System.currentTimeMillis() - ((long) 10000);
        this.q.b(new MultiQueueWaitMessageBufferV2$poll$1(r0));
    L5:
        int r1 = 0;
        if ((!((ArrayDeque) this.o).isEmpty()) == false) goto L17;
        if (r8.a == false) goto L17;
        ArrayList r9 = new ArrayList();
        int r2 = ((ArrayDeque) this.o).size();
    L10:
        if (r1 >= r2) goto L15;
        f r3 = (f) ((ArrayDeque) this.o).poll();
        if (r3 == null) goto L14;
        r9.add(r3);
    L14:
        r1 = r1 + 1;
        goto L10
    L15:
        return r9;
    L17:
        if ((!((ArrayDeque) this.p).isEmpty()) == false) goto L25;
        ArrayList r4 = new ArrayList();
        int r10 = Math.min(r8.c, ((ArrayDeque) this.p).size());
    L19:
        if (r1 >= r10) goto L24;
        f r5 = (f) ((ArrayDeque) this.p).poll();
        if (r5 == null) goto L23;
        r4.add(r5);
    L23:
        r1 = r1 + 1;
        goto L19
    L24:
        return r4;
    L25:
        int r6 = Math.min(r8.c, ((ArrayDeque) this.c).size());
        int r7 = Math.min(r8.c - r6, this.h.size());
        int r11 = Math.min(r8.d, this.q.size());
        ArrayList r13 = new ArrayList();
        if (r7 <= 0) goto L37;
        int r14 = 0;
    L28:
        if (r14 >= r7) goto L37;
        f<?> r15 = this.h.c(this.m, false);
        if (r15 == null) goto L36;
        r13.add(r15);
        if (r11 <= 0) goto L36;
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.k.a(r15) == false) goto L36;
        n.b(MultiQueueWaitMessageBufferV2$poll$4$1$1.INSTANCE);
        r11 = 0;
    L36:
        r14 = r14 + 1;
    L37:
        if (r6 <= 0) goto L44;
        int r16 = 0;
    L39:
        if (r16 >= r6) goto L44;
        f r17 = (f) ((ArrayDeque) this.c).poll();
        if (r17 == null) goto L43;
        r13.add(r17);
    L43:
        r16 = r16 + 1;
    L44:
        if (r11 <= 0) goto L51;
        int r18 = 0;
    L46:
        if (r18 >= r11) goto L51;
        f<?> r19 = this.q.c(this.n, false);
        if (r19 == null) goto L50;
        r13.add(r19);
    L50:
        r18 = r18 + 1;
    L51:
        return r13;
    }

    @Override // ja2.b
    public final void m(long r2) {
        ja2.a r0 = this.g;
        if (r0 == null) goto L6;
        r0.c = r2;
        return;
    }

    @Override // ja2.b
    public final void h(f<?> r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "message");
        if (a.n(r4) == false) goto L5;
        ((ArrayDeque) this.o).add(r4);
    L29:
        r4.u = System.nanoTime();
        return;
    L5:
        Intrinsics.checkNotNullParameter(r4, "message");
        c4 r0 = null;
        boolean r2 = false;
        if (r42.g.a(null, null) == true) goto L9;
        boolean r1 = false;
    L12:
        if (r1 == false) goto L14;
        ((ArrayDeque) this.p).add(r4);
        goto L29
    L14:
        if (r5 == false) goto L16;
        this.q.d(this.s, r4, new MultiQueueWaitMessageBufferV2$push$1(this));
        goto L29
    L16:
        if (r6 == false) goto L18;
        com.bytedance.android.livesdk.interactivity.common.utils.k.a(this.c, this.r, r4, new MultiQueueWaitMessageBufferV2$push$2(this));
        goto L29
    L18:
        c4 r7 = r4.b;
        if ((r7 instanceof c4) == false) goto L22;
        r0 = r7;
    L22:
        c4 r3 = r0;
        int r8 = j.a;
        if (r3 == null) goto L26;
        r2 = TextUtils.equals(r3.getBizScene(), "auction_msg");
    L26:
        if (r2 == false) goto L28;
        com.bytedance.android.livesdk.interactivity.common.utils.k.a(this.c, this.r, r4, new MultiQueueWaitMessageBufferV2$push$3(this));
        goto L29
    L28:
        this.h.d(this.r, r4, new MultiQueueWaitMessageBufferV2$push$4(this));
        goto L29
    L9:
        if ((r4 instanceof z) == false) goto L11;
        r1 = ((z) r4).H.a;
        goto L12
    L11:
        r1 = r4.b.isFromFirstRequest();
        goto L12
    }

    public MultiQueueWaitMessageBufferV2(int r3, int r4, IRoom r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "room");
        this.r = r3;
        this.s = r4;
        this.t = r6;
        this.c = new ArrayDeque();
        m r7 = PublicScreenABHelper.g(r6);
        if (PublicScreenABHelper.g(r6).enablePersonalizedChannel == true) goto L5;
    L7:
        boolean r8 = false;
    L8:
        this.d = r8;
        this.e = PublicScreenABHelper.g(r6).enablePersonalizedChannel;
        ss1.a r0 = (ss1.a) t.a.getValue();
        this.i = new NormalStrategy(r7);
        this.j = new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.f(r7);
        this.k = new g(r7);
        DoubleHitStrategy r1 = new DoubleHitStrategy(r7);
        this.l = r1;
        this.m = r1;
        this.n = new FoldStrategy(r7);
        this.o = new ArrayDeque();
        this.p = new ArrayDeque();
        if (r8 == false) goto L11;
        h r9 = new FoldComposePriorityQueue();
    L12:
        this.q = r9;
        Disposable r10 = null;
        if (r6 == false) goto L15;
    L20:
        this.g = null;
    L21:
        this.h = new ScrollComposePriorityQueue(r8, this.g);
        return;
    L15:
        if (r0.enableInOldBuffer == false) goto L20;
        this.g = new ja2.a(r0);
        IInteractivityInjectService r11 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r11 == null) goto L19;
        r10 = r11.subscribeSEITimePair(r5.getRoomId(), new AnonymousClass1(this));
    L19:
        this.f = r10;
        goto L21
    L11:
        r9 = new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.c();
        goto L12
    L5:
        if (PublicScreenABHelper.g(r6).enablePersonalizedInsert == false) goto L7;
        r8 = true;
        goto L8
    }
}
