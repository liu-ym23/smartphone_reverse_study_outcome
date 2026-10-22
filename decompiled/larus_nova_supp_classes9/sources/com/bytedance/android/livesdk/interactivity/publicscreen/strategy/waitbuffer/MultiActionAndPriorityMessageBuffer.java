package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer;

import com.bytedance.android.live.base.model.message.n0;
import com.bytedance.android.live.base.model.message.o;
import com.bytedance.android.live.base.model.message.r2;
import com.bytedance.android.live.base.model.message.u3;
import com.bytedance.android.live.base.model.message.w0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessagePriority;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.monitor.InteractivityMonitor;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.r;
import com.bytedance.android.livesdk.interactivity.api.settings.config.c0;
import com.bytedance.android.livesdk.interactivity.api.settings.config.d0;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.e;
import com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.i;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.MessageHeatUtil;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import com.bytedance.android.livesdk.message.model.w8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.Disposable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r52.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class MultiActionAndPriorityMessageBuffer extends com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a {
    public static final Lazy t = null;
    public final Queue<f<?>> c;
    public final i d;
    public final i e;
    public final i f;
    public final int g;
    public final List<i> h;
    public m<? extends PSMessageHeatState> i;
    public final Queue<f<?>> j;
    public final Queue<f<?>> k;
    public final Queue<f<?>> l;
    public final Queue<f<?>> m;
    public final boolean n;
    public final ss1.a o;
    public ja2.a p;
    public Disposable q;
    public final boolean r;
    public final IRoom s;

    public static final class a {
    }

    public static final class b<T> implements Comparator<T> {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Boolean.valueOf(((f) r1).y), Boolean.valueOf(((f) r2).y));
        }
    }

    public static final class c<T> implements Comparator<T> {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(((f) r1).p(), ((f) r2).p());
        }
    }

    static {
        t = LazyKt.lazy(MultiActionAndPriorityMessageBuffer$Companion$deniedMessages$2.INSTANCE);
    }

    @Override // ja2.b
    public final int c() {
        if (this.r == false) goto L6;
        return 0;
    L6:
        return ((ArrayDeque) this.k).size();
    }

    @Override // ja2.b
    public final void clearAll() {
        Iterator<T> r0 = this.h.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Iterator<T> r1 = ((i) r0.next()).d.iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        ((i.b) r1.next()).clear();
        goto L7
    L9:
        ((ArrayDeque) this.l).clear();
        ((ArrayDeque) this.m).clear();
    }

    @Override // ja2.b
    public final int d() {
        if (this.r == false) goto L6;
        return 0;
    L6:
        return ((ArrayDeque) this.j).size();
    }

    @Override // ja2.b
    public final int g() {
        Iterator<T> r0 = this.h.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L7;
        i r2 = (i) r0.next();
        r1 = r1 + ((r2.a.size() + r2.b.size()) + r2.c.size());
        goto L4
    L7:
        return ((((ArrayDeque) this.c).size() + ((ArrayDeque) this.l).size()) + ((ArrayDeque) this.m).size()) + r1;
    }

    @Override // ja2.b
    public final int i() {
        Iterator<T> r0 = this.h.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L13;
        i r3 = (i) r0.next();
        PSMessageHeatState r4 = r();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "heatState");
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m r5 = r3.f.a.a(r4);
        Iterator<T> r6 = r3.d.iterator();
        int r7 = 0;
    L7:
        if (r6.hasNext() == false) goto L11;
        i.b r8 = (i.b) r6.next();
        if (r5.b(r8.b) <= 0) goto L7;
        r7 = r7 + r8.size();
        goto L7
    L11:
        r2 = r2 + r7;
        goto L4
    L13:
        return (((ArrayDeque) this.l).size() + ((ArrayDeque) this.c).size()) + r2;
    }

    @Override // ja2.b
    public final long k() {
        if (((ArrayDeque) this.l).isEmpty() == false) goto L5;
        t(false);
    L5:
        long r0 = System.currentTimeMillis();
        f r2 = (f) ((ArrayDeque) this.l).peek();
        if (r2 == null) goto L10;
        Long r3 = r2.p();
        if (r3 == null) goto L10;
        long r4 = r3.longValue();
    L12:
        return r0 - r4;
    L10:
        r4 = r0;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a, ja2.b
    public final void onLoad() {
        if (this.r == false) goto L5;
        return;
    L5:
        if (this.o.enable == false) goto L17;
        this.p = new ja2.a(this.o);
        IInteractivityInjectService r0 = (IInteractivityInjectService) k.f(IInteractivityInjectService.class);
        if (r0 == null) goto L13;
        IRoom r1 = this.s;
        if (r1 == null) goto L11;
        long r2 = r1.getRoomId();
    L12:
        Disposable r3 = r0.subscribeSEITimePair(r2, new AnonymousClass1(this));
    L14:
        this.q = r3;
        return;
    L11:
        r2 = 0;
        goto L12
    L13:
        r3 = null;
        goto L14
    }

    @Override // ja2.b
    public final void onUnload() {
        Disposable r0 = this.q;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.q = null;
    }

    public final PSMessageHeatState r() {
        m<? extends PSMessageHeatState> r0 = this.i;
        if (r0 == null) goto L5;
        PSMessageHeatState r1 = (PSMessageHeatState) r0.getValue();
    L6:
        if (r1 != null) goto L9;
        int r2 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.a.a;
        ALogger.e("TAG", "state from heat source is null, use default state.");
        return PSMessageHeatState.NORMAL;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // ja2.b
    public final f<?> b(Function1<? super f<?>, Boolean> r8) {
        Intrinsics.checkNotNullParameter(r8, "predicate");
        Iterator r1 = ((ArrayDeque) this.l).iterator();
    L3:
        f<?> r3 = null;
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (((Boolean) r8.invoke(r2)).booleanValue() == false) goto L3;
    L9:
        f<?> r4 = (f) r2;
        if (r4 != null) goto L19;
        Iterator r5 = ((ArrayDeque) this.m).iterator();
    L13:
        if (r5.hasNext() == false) goto L17;
        Object r6 = r5.next();
        if (((Boolean) r8.invoke(r6)).booleanValue() == false) goto L13;
    L18:
        r4 = (f) r6;
        goto L19
    L17:
        r6 = null;
    L19:
        if (r4 != null) goto L28;
        Iterator r7 = ((ArrayDeque) this.c).iterator();
    L22:
        if (r7.hasNext() == false) goto L26;
        Object r9 = r7.next();
        if (((Boolean) r8.invoke(r9)).booleanValue() == false) goto L22;
    L27:
        r4 = (f) r9;
        goto L28
    L26:
        r9 = null;
    L28:
        if (r4 != null) goto L69;
        Iterator<T> r10 = this.h.iterator();
    L31:
        if (r10.hasNext() == false) goto L49;
        i r11 = (i) r10.next();
        r11.getClass();
        Intrinsics.checkNotNullParameter(r8, "predicate");
        Iterator<T> r13 = r11.d.iterator();
    L34:
        if (r13.hasNext() == false) goto L45;
        Iterator<f<?>> r14 = ((i.b) r13.next()).iterator();
    L37:
        if (r14.hasNext() == false) goto L41;
        f<?> r15 = r14.next();
        if (((Boolean) r8.invoke(r15)).booleanValue() == false) goto L37;
    L42:
        f<?> r16 = r15;
        if (r16 == null) goto L34;
    L46:
        if (r16 == null) goto L31;
        r3 = r16;
        goto L49
    L41:
        r15 = null;
        goto L42
    L45:
        r16 = null;
    L49:
        return r3;
    L69:
        return r4;
    L8:
        r2 = null;
        goto L9
    }

    @Override // ja2.b
    public final void e(Function1<? super f<?>, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "operation");
        Iterator r1 = ((ArrayDeque) this.c).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r6.invoke(r1.next());
        goto L4
    L6:
        Iterator<T> r2 = this.h.iterator();
    L8:
        if (r2.hasNext() == false) goto L16;
        i r3 = (i) r2.next();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "operation");
        Iterator<T> r4 = r3.d.iterator();
    L11:
        if (r4.hasNext() == false) goto L8;
        Iterator<f<?>> r5 = ((i.b) r4.next()).iterator();
    L14:
        if (r5.hasNext() == false) goto L11;
        r6.invoke(r5.next());
        goto L14
    L16:
        Iterator r0 = ((ArrayDeque) this.l).iterator();
    L18:
        if (r0.hasNext() == false) goto L20;
        r6.invoke(r0.next());
        goto L18
    }

    @Override // ja2.b
    public final void j(Function1<? super f<?>, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r6, "predicate");
        Iterator r1 = ((ArrayList) com.bytedance.android.livesdk.interactivity.common.utils.k.d(this.c, r6)).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        q((f) r1.next());
        goto L4
    L6:
        Iterator r2 = ((ArrayList) com.bytedance.android.livesdk.interactivity.common.utils.k.d(this.l, r6)).iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        q((f) r2.next());
        goto L8
    L10:
        Iterator r3 = ((ArrayList) com.bytedance.android.livesdk.interactivity.common.utils.k.d(this.m, r6)).iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        q((f) r3.next());
        goto L12
    L14:
        Iterator<T> r4 = this.h.iterator();
    L16:
        if (r4.hasNext() == false) goto L25;
        i r5 = (i) r4.next();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "predicate");
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r5.d.iterator();
    L19:
        if (r8.hasNext() == false) goto L21;
        r7.addAll(com.bytedance.android.livesdk.interactivity.common.utils.k.d((i.b) r8.next(), r6));
        goto L19
    L21:
        Iterator r9 = r7.iterator();
    L23:
        if (r9.hasNext() == false) goto L16;
        q((f) r9.next());
        goto L23
    }

    @Override // ja2.b
    public final List<f<?>> l(ka2.a r7) {
        Intrinsics.checkNotNullParameter(r7, "updateInfo");
        int r0 = r7.c;
        if (r0 > 0) goto L5;
        int r1 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.a.a;
        ALogger.e("MessageHeatStrategyLogger", "wrong scroll message size: " + r0);
    L5:
        ArrayList r2 = new ArrayList();
        if ((!((ArrayDeque) this.j).isEmpty()) == false) goto L12;
        if (r7.a == false) goto L12;
        Queue<f<?>> r8 = this.j;
        com.bytedance.android.livesdk.interactivity.common.utils.k.b(r8, ((ArrayDeque) r8).size(), r2);
        return r2;
    L12:
        if ((!((ArrayDeque) this.k).isEmpty()) == false) goto L15;
        com.bytedance.android.livesdk.interactivity.common.utils.k.b(this.k, r7.c, r2);
        return r2;
    L15:
        com.bytedance.android.livesdk.interactivity.common.utils.k.b(this.c, r7.c, r2);
        int r3 = 0;
        s(r7.c - r2.size(), r2, false);
        if (r2.size() <= 1) goto L18;
        CollectionsKt.sortWith(r2, new b());
    L18:
        Iterator r4 = r2.iterator();
    L20:
        if (r4.hasNext() == false) goto L24;
        Object r5 = r4.next();
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.k.a((f) r5) == false) goto L20;
    L25:
        if (r5 != null) goto L28;
        r3 = r7.d;
    L28:
        s(r3, r2, true);
        return r2;
    L24:
        r5 = null;
        goto L25
    }

    @Override // ja2.b
    public final void m(long r2) {
        ja2.a r0 = this.p;
        if (r0 == null) goto L6;
        r0.c = r2;
        return;
    }

    public final void t(boolean r6) {
        if (r6 == false) goto L4;
        Queue<f<?>> r0 = this.m;
    L5:
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = this.h.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        ((i) r2.next()).a(r1, r(), r6);
        goto L7
    L9:
        Iterator r3 = r1.iterator();
    L11:
        if (r3.hasNext() == false) goto L13;
        ((f) r3.next()).r = Boolean.valueOf(r6);
        goto L11
    L13:
        if (r6 == false) goto L15;
    L17:
        boolean r4 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a;
        PSMessageHeatState r5 = r();
        Intrinsics.checkNotNullParameter(r1, "supplyList");
        Intrinsics.checkNotNullParameter(r5, "heatState");
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a == true) goto L20;
    L26:
        r0.addAll(r1);
        return;
    L20:
        if (r1.isEmpty() == true) goto L26;
        if (r6 == false) goto L24;
        String r7 = "折叠";
    L25:
        ALogger.e("PS_BUFFER_POLL", "现在热度状态为" + r5.name() + ", 从一级缓存中取出" + r1.size() + 26465 + r7 + "消息：");
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.f(r1, PSMessageAction.CHAT);
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.f(r1, PSMessageAction.BUSINESS);
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.f(r1, PSMessageAction.BASIC);
        goto L26
    L24:
        r7 = "平铺";
        goto L25
    L15:
        if (r1.size() <= 1) goto L17;
        CollectionsKt.sortWith(r1, new c());
        goto L17
    L4:
        r0 = this.l;
        goto L5
    }

    @Override // ja2.b
    public final void h(final f<?> r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "message");
        if (com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a.n(r8) == false) goto L6;
        r8.r = Boolean.FALSE;
        ((ArrayDeque) this.j).offer(r8);
        return;
    L6:
        T r0 = r8.b;
        int r1 = r.a;
        boolean r2 = false;
        if (r0 == 0) goto L9;
        boolean r3 = r0.isFirstHistoryMessage();
    L10:
        if (r3 == false) goto L13;
        r8.r = Boolean.FALSE;
        ((ArrayDeque) this.k).offer(r8);
        return;
    L13:
        Long r4 = null;
        String r5 = null;
        if (r10 == false) goto L17;
        r8.A = PSMessageAction.SYSTEM;
    L38:
        PSMessageAction r11 = r8.A;
        PSMessageAction r6 = PSMessageAction.UNKNOW;
        if (r11 != r6) goto L72;
        if ((r8 instanceof z) == false) goto L44;
        boolean r13 = ((z) r8).H.a;
    L50:
        if (r13 == false) goto L56;
        boolean r14 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a;
        Intrinsics.checkNotNullParameter("首刷消息标记为系统行为", "message");
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a == false) goto L55;
        ALogger.e("PS_BUFFER_PUSH", "首刷消息标记为系统行为");
    L55:
        r8.A = PSMessageAction.SYSTEM;
        goto L72
    L56:
        T r15 = r8.b;
        if ((r15 instanceof n0) == false) goto L59;
    L70:
        r8.A = PSMessageAction.SYSTEM;
        goto L72
    L59:
        if ((r15 instanceof o) == true) goto L70;
        if ((r15 instanceof w0) == false) goto L64;
    L69:
        r8.A = PSMessageAction.BASIC;
        goto L72
    L64:
        if ((r15 instanceof r2) == true) goto L69;
        if ((r15 instanceof w8) == false) goto L72;
        r8.A = PSMessageAction.CHAT;
        goto L72
    L44:
        T r16 = r8.b;
        if (r16 != 0) goto L47;
    L49:
        r13 = false;
        goto L50
    L47:
        if (r16.isFromFirstRequest() != true) goto L49;
        r13 = true;
    L72:
        if (r8.A != r6) goto L103;
        T r17 = r8.b;
        if (r17 == 0) goto L79;
        String r18 = r17.getMessageMethod();
        if (r18 == null) goto L79;
        r2 = ((Set) t.getValue()).contains(r18);
    L79:
        if (r2 == false) goto L88;
        int r7 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.a.a;
        Intrinsics.checkNotNullParameter(r8, "message");
        ALogger.i("MessageHeatStrategyLogger", "message filter by black list，message type is " + MessageHeatUtil.b(r8));
        boolean r19 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a;
        Intrinsics.checkNotNullParameter(r8, "message");
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a == false) goto L114;
        StringBuilder r20 = new StringBuilder("消息被黑名单过滤，消息类型为");
        T r21 = r8.b;
        if (r21 == 0) goto L86;
        r5 = r21.getMessageMethod();
    L86:
        r20.append(r5);
        ALogger.e("PS_BUFFER_PUSH", r20.toString());
        return;
    L114:
        return;
    L88:
        String r23 = MessageHeatUtil.b(r8);
        int r24 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.a.a;
        Intrinsics.checkNotNullParameter(r8, "message");
        StringBuilder r25 = new StringBuilder("message action type is unexpected, message type is ");
        r25.append(MessageHeatUtil.b(r8));
        r25.append(", message id is ");
        T r26 = r8.b;
        if (r26 == 0) goto L91;
        Long r27 = Long.valueOf(r26.getMessageId());
    L92:
        r25.append(r27);
        ALogger.i("MessageHeatStrategyLogger", r25.toString());
        if (this.n == false) goto L99;
        LiveMonitor.a r28 = InteractivityMonitor.a(InteractivityMonitor.Event.PublicScreenMessageActionTypeUnexpected, this.s, null);
        r28.i("message_type", r23);
        T r110 = r8.b;
        if (r110 == 0) goto L97;
        r4 = Long.valueOf(r110.getMessageId());
    L97:
        r28.i("message_id", r4);
        r28.a().report();
    L99:
        if (com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.a == false) goto L102;
        ALogger.e("PS_BUFFER_PUSH", "触发端上兜底逻辑，按照中优评论处理");
    L102:
        r8.A = PSMessageAction.CHAT;
        r8.z = PSMessagePriority.NORMAL;
        goto L103
    L91:
        r27 = null;
    L103:
        int r29 = com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.b.a[r8.A.ordinal()];
        if (r29 != 1) goto L106;
        r8.r = Boolean.FALSE;
        com.bytedance.android.livesdk.interactivity.common.utils.k.a(this.c, this.g, r8, new MultiActionAndPriorityMessageBuffer$push$1(this, r8));
        return;
    L106:
        if (r29 != 2) goto L108;
        this.f.b(r8);
        return;
    L108:
        if (r29 == 3) goto L110;
        this.d.b(r8);
        return;
    L110:
        this.e.b(r8);
        return;
    L17:
        if ((r8 instanceof z) == false) goto L19;
        z r111 = (z) r8;
        r8.A = r111.H.a();
        r111.z = PSMessagePriority.NORMAL;
        goto L38
    L19:
        u3 r112 = r8.b;
        if (r112 == null) goto L38;
        if ((r112 instanceof u3) == true) goto L25;
        r112 = null;
    L25:
        u3 r113 = r112;
        if (r113 == null) goto L38;
        IPublicAreaCommon r114 = r113.getOrInitPublicAreaCommon();
        if (r114 == null) goto L38;
        r8.A = r.a(r114);
        Intrinsics.checkNotNullParameter(r114, "data");
        int r115 = r114.getIndividualPriority();
        if (r115 != 30) goto L33;
        PSMessagePriority r116 = PSMessagePriority.LOW;
    L37:
        r8.z = r116;
        goto L38
    L33:
        if (r115 == 80) goto L35;
        r116 = PSMessagePriority.NORMAL;
        goto L37
    L35:
        r116 = PSMessagePriority.HIGH;
        goto L37
    L9:
        r3 = false;
        goto L10
    }

    public final void s(int r5, List<f<?>> r6, boolean r7) {
        if (r7 == false) goto L4;
        Queue<f<?>> r0 = this.m;
    L6:
        if (r0.size() >= r5) goto L8;
        t(r7);
    L8:
        if (r7 == true) goto L19;
        ja2.a r8 = this.p;
        if (r8 == null) goto L19;
        if ((!r8.d) != true) goto L19;
        Intrinsics.checkNotNullParameter(r6, "pollList");
        Intrinsics.checkNotNullParameter(r0, "scrollQueue");
        int r1 = 0;
    L14:
        if (r1 >= r5) goto L24;
        f<?> r2 = r8.a(r0);
        if (r2 == null) goto L18;
        ((ArrayList) r6).add(r2);
    L18:
        r1 = r1 + 1;
        goto L14
    L24:
        return;
    L19:
        com.bytedance.android.livesdk.interactivity.common.utils.k.b(r0, r5, r6);
        return;
    L4:
        r0 = this.l;
        goto L6
    }

    public MultiActionAndPriorityMessageBuffer(d0 r9, c0 r10, boolean r11, IRoom r13) {
        Intrinsics.checkNotNullParameter(r9, "messageHeatStrategy");
        Intrinsics.checkNotNullParameter(r10, "messageBufferSizeConfig");
        this.r = r11;
        this.s = r13;
        this.c = new ArrayDeque();
        PSMessageAction r14 = PSMessageAction.CHAT;
        Lazy r0 = MessageHeatUtil.a;
        Intrinsics.checkNotNullParameter(r10, "bufferSizeConfig");
        e r1 = new e(new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.c().f()), new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.c().i()), new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.c().c()));
        com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m r3 = MessageHeatUtil.c;
        i r15 = new i(r14, new i.a(r1, new e(r3, r3, r3), new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.b(r10.c(), r10.i(), r10.f())), this.b, r9.messageValidTime);
        this.d = r15;
        PSMessageAction r2 = PSMessageAction.BUSINESS;
        Intrinsics.checkNotNullParameter(r10, "bufferSizeConfig");
        i r16 = new i(r2, new i.a(new e(new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.c().e()), new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.c().h()), new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.c().b())), new e(new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.a().d()), new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.a().f()), new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.a().b())), new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.b(r10.b(), r10.h(), r10.e())), this.b, r9.messageValidTime);
        this.e = r16;
        PSMessageAction r4 = PSMessageAction.BASIC;
        Intrinsics.checkNotNullParameter(r10, "bufferSizeConfig");
        i r5 = new i(r4, new i.a(new e(new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.c().d()), new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.c().g()), new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.c().a())), new e(new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.a().c()), new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.a().e()), new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.m(MessageHeatUtil.a().a())), new com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.b(r10.a(), r10.g(), r10.d())), this.b, r9.messageValidTime);
        this.f = r5;
        this.g = r10.j();
        this.h = CollectionsKt.listOf(new i[]{r15, r16, r5});
        this.j = new ArrayDeque();
        this.k = new ArrayDeque();
        this.l = new ArrayDeque();
        this.m = new ArrayDeque();
        this.n = r9.reportUnexpectedMessage;
        this.o = (ss1.a) t.a.getValue();
    }
}
