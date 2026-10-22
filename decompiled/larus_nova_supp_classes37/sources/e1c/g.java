package e1c;

import android.os.Handler;
import android.os.Message;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.preload.v2.condition.ConditionSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g implements Handler.Callback {
    public final /* synthetic */ d a;

    public g(d r1) {
        this.a = r1;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r14) {
        Intrinsics.checkNotNullParameter(r14, "msg");
        int r0 = r14.what;
        if (r0 != 1) goto L5;
        d r1 = this.a;
        Object r15 = r14.obj;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type kotlin.collections.Set<com.ss.android.lark.preload.v2.condition.ICondition<*>>");
        Set r16 = (Set) r15;
        r1.getClass();
        HashSet r17 = new HashSet();
        Iterator r2 = ((HashMap) r1.a).entrySet().iterator();
    L101:
        if (r2.hasNext() == false) goto L119;
        Map.Entry r4 = (Map.Entry) r2.next();
        if (((o1c.c) r4.getValue()).T0() == false) goto L108;
        if (r1.j.get() == true) goto L101;
    L108:
        if (d.m == false) goto L111;
        Log.i("PreloadTaskManager", "handleTrigger:" + r4.getValue() + '/' + ((o1c.c) r4.getValue()).p0() + '/' + ((o1c.c) r4.getValue()).p0().b() + '/' + ((o1c.c) r4.getValue()).R());
    L111:
        if (((o1c.c) r4.getValue()).p0().b() == false) goto L117;
        if (((o1c.c) r4.getValue()).R().a == false) goto L115;
        r17.add(r4.getValue());
        o1c.c r5 = (o1c.c) r4.getValue();
        r5.S(r5.f0() - 1);
        goto L117
    L115:
        r1.c((o1c.c) r4.getValue());
    L117:
        if (((o1c.c) r4.getValue()).f0() > 0) goto L101;
        r2.remove();
        goto L101
    L119:
        Iterator r3 = r17.iterator();
    L121:
        if (r3.hasNext() == false) goto L133;
        o1c.c r6 = (o1c.c) r3.next();
        if (r6.T0() == false) goto L125;
        n1c.a r7 = r1.h;
    L127:
        if (r6.L0() > 0) goto L128;
        r7.execute(r6);
        goto L121
    L128:
        Handler r8 = r1.k;
        if (r8 == null) goto L121;
        r8.postDelayed(new f(r7, r6), r6.L0());
        goto L121
    L125:
        r7 = r1.g;
        goto L127
    L133:
        if (d.m == false) goto L135;
        Log.i("PreloadTaskManager", "onTriggerConditionChanged:" + r17.size() + ", total size:" + ((HashMap) r1.a).size());
    L135:
        return true;
    L5:
        if (r0 != 2) goto L7;
        d r9 = this.a;
        Object r18 = r14.obj;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r19 = ((Boolean) r18).booleanValue();
        if (r19 == true) goto L67;
    L71:
        Iterator r10 = ((HashMap) r9.a).values().iterator();
    L73:
        if (r10.hasNext() == false) goto L97;
        o1c.c r11 = (o1c.c) r10.next();
        if (r11.isInterrupted() == true) goto L73;
        ConditionSet r12 = r11.w0();
        r12.c.clear();
        if (((ArrayList) r12.a).size() <= 0) goto L93;
        g1c.b r13 = (g1c.b) ListProtector.get(r12.a, 0);
        if ((r13 instanceof h1c.a) == false) goto L93;
        r12.c.add(Boolean.valueOf(((h1c.a) r13).isInterrupted()));
        int r20 = 1;
    L83:
        if (r20 >= ((ArrayList) r12.a).size()) goto L89;
        Object r110 = ListProtector.get(r12.a, r20);
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.ss.android.lark.preload.v2.condition.interrupt.IInterruptCondition");
        h1c.a r111 = (h1c.a) r110;
        if (ListProtector.get(r12.b, r20 - 1) != ConditionSet.Operator.OR) goto L87;
        r12.c.add(Boolean.valueOf(r111.isInterrupted()));
    L88:
        r20 = r20 + 1;
        goto L83
    L87:
        Boolean r112 = r12.c.pop();
        r12.c.add(Boolean.valueOf(r111.isInterrupted() & r112.booleanValue()));
        goto L88
    L89:
        boolean r21 = false;
    L91:
        if (r12.c.empty() == true) goto L94;
        r21 = r21 | r12.c.pop().booleanValue();
    L94:
        if (r21 == false) goto L73;
        r11.k(true);
    L93:
        r21 = false;
        goto L94
    L97:
        if (d.m == false) goto L135;
        Log.i("PreloadTaskManager", "handleInterrupt: needGlobalInterrupt = " + r19 + ", mInterrupted = " + r9.j.get());
        goto L135
    L67:
        if (r9.j.compareAndSet(false, true) == false) goto L71;
        ((ArrayList) r9.i).clear();
        List<Runnable> r22 = r9.h.shutdownNow();
        if (r22 == null) goto L71;
        ((ArrayList) r9.i).addAll(r22);
        goto L71
    L7:
        if (r0 != 3) goto L9;
        d r23 = this.a;
        Object r113 = r14.obj;
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type kotlin.Boolean");
        boolean r114 = ((Boolean) r113).booleanValue();
        if (r114 == true) goto L27;
    L33:
        Iterator r24 = ((HashMap) r23.a).values().iterator();
    L35:
        if (r24.hasNext() == false) goto L58;
        o1c.c r25 = (o1c.c) r24.next();
        if (r25.isInterrupted() == false) goto L35;
        ConditionSet r26 = r25.w0();
        r26.c.clear();
        if (((ArrayList) r26.a).size() <= 0) goto L55;
        g1c.b r27 = (g1c.b) ListProtector.get(r26.a, 0);
        if ((r27 instanceof h1c.a) == false) goto L55;
        r26.c.add(Boolean.valueOf(((h1c.a) r27).d()));
        int r28 = 1;
    L45:
        if (r28 >= ((ArrayList) r26.a).size()) goto L51;
        Object r115 = ListProtector.get(r26.a, r28);
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type com.ss.android.lark.preload.v2.condition.interrupt.IInterruptCondition");
        h1c.a r116 = (h1c.a) r115;
        if (ListProtector.get(r26.b, r28 - 1) != ConditionSet.Operator.OR) goto L49;
        r26.c.add(Boolean.valueOf(r116.d()));
    L50:
        r28 = r28 + 1;
        goto L45
    L49:
        Boolean r117 = r26.c.pop();
        r26.c.add(Boolean.valueOf(r116.d() & r117.booleanValue()));
        goto L50
    L51:
        boolean r29 = true;
    L53:
        if (r26.c.empty() == true) goto L56;
        r29 = r29 | r26.c.pop().booleanValue();
    L56:
        if (r29 == false) goto L35;
        r25.k(false);
    L55:
        r29 = true;
        goto L56
    L58:
        Handler r30 = r23.k;
        if (r30 == null) goto L62;
        d.o(r30, 1, new HashSet(), 100);
    L62:
        if (d.m == false) goto L135;
        Log.i("PreloadTaskManager", "handleRecover: needGlobalRecover = " + r114 + ", mInterrupted = " + r23.j.get());
        goto L135
    L27:
        if (r23.j.compareAndSet(true, false) == false) goto L33;
        Iterator r31 = ((ArrayList) r23.i).iterator();
    L30:
        if (r31.hasNext() == false) goto L32;
        r23.h.execute((Runnable) r31.next());
        goto L30
    L32:
        ((ArrayList) r23.i).clear();
        goto L33
    L9:
        if (r0 != 4) goto L135;
        d r32 = this.a;
        Object r118 = r14.obj;
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type kotlin.collections.Set<com.ss.android.lark.preload.v2.condition.ICondition<*>>");
        Set r119 = (Set) r118;
        r32.getClass();
        HashSet r120 = new HashSet();
        Iterator r33 = ((HashMap) r32.a).values().iterator();
    L13:
        if (r33.hasNext() == false) goto L19;
        o1c.c r34 = (o1c.c) r33.next();
        if (r34.C1().b() == false) goto L13;
        if (r34.R().a == false) goto L13;
        r120.add(r34);
        goto L13
    L19:
        Iterator r35 = r120.iterator();
    L21:
        if (r35.hasNext() == false) goto L23;
        ((o1c.c) r35.next()).s1();
        goto L21
    L23:
        Log.d("PreloadTaskManager", "onCleanConditionChanged:" + r120.size());
        goto L135
    }
}
