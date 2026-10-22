package com.ss.android.lark.flow.threadwindow;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p implements Runnable {
    public final /* synthetic */ FlowThreadWindowMsgSender a;

    public p(FlowThreadWindowMsgSender r1) {
        this.a = r1;
    }

    public final void a() {
        final FlowThreadWindowMsgSender r0 = this.a;
        r0.l = false;
        FlowThreadWindowMsgSender.c r2 = r0.j;
        ArrayList r3 = new ArrayList(r0.k);
        r0.j = null;
        ((ArrayList) r0.k).clear();
        if (r2 == null) goto L5;
        FlowThreadWindowMsgSender.c r1 = r2;
        final List r4 = r3;
    L38:
        if (r1 != null) goto L41;
        Log.w("FlowThreadWindowMsgSender", "flush blocked: no root-capable item");
        r0.h.a();
        return;
    L41:
        if (r4.isEmpty() == false) goto L43;
        Log.i("FlowThreadWindowMsgSender", "[MessageBatch] flush single topic, type=" + r1.getType() + ", isLastInBatch=true");
        r0.z(r1, System.currentTimeMillis(), true, new FlowThreadWindowMsgSender$flush$2(r0));
        return;
    L43:
        final long r5 = System.currentTimeMillis();
        Log.i("FlowThreadWindowMsgSender", "[MessageBatch] flush topic batch, rootType=" + r1.getType() + ", replyCount=" + r4.size() + ", queueId=" + r5 + ", rootIsLastInBatch=false");
        r0.z(r1, r5, false, new FlowThreadWindowMsgSender$sendRootThenReplies$1(r0, r4, r5));
        return;
    L5:
        Iterator r6 = r3.iterator();
        int r7 = 0;
    L7:
        if (r6.hasNext() == false) goto L20;
        FlowThreadWindowMsgSender.c r8 = (FlowThreadWindowMsgSender.c) r6.next();
        if (r8.getType() != FlowThreadWindowMsgSender.MsgType.IMAGE) goto L11;
    L16:
        boolean r9 = true;
    L17:
        if (r9 == true) goto L21;
        r7 = r7 + 1;
    L21:
        if (r7 < 0) goto L36;
        FlowThreadWindowMsgSender.c r10 = (FlowThreadWindowMsgSender.c) ListProtector.get(r3, r7);
        ArrayList r11 = new ArrayList();
        Iterator r12 = r3.iterator();
        int r13 = 0;
    L24:
        if (r12.hasNext() == false) goto L35;
        Object r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        FlowThreadWindowMsgSender.c r16 = (FlowThreadWindowMsgSender.c) r14;
        if (r13 == r7) goto L31;
        boolean r17 = true;
    L32:
        if (r17 == false) goto L34;
        r11.add(r14);
    L34:
        r13 = r15;
        goto L24
    L31:
        r17 = false;
        goto L32
    L35:
        r1 = r10;
        r4 = r11;
        goto L38
    L36:
        r1 = null;
        r4 = CollectionsKt.emptyList();
        goto L38
    L11:
        if (r8.getType() == FlowThreadWindowMsgSender.MsgType.FILE) goto L16;
        if (r8.getType() == FlowThreadWindowMsgSender.MsgType.VIDEO) goto L16;
        r9 = false;
        goto L17
    L20:
        r7 = -1;
        goto L21
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
