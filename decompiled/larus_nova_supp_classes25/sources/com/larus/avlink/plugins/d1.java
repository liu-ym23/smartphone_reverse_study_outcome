package com.larus.avlink.plugins;

import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d1 implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ DoraIMPlugin a;
    public final /* synthetic */ wc9.e b;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r10) {
        Intrinsics.checkNotNullParameter(r10, "error");
        Intrinsics.checkNotNullParameter(r10, "error");
        String r11 = this.a.f;
        StringBuilder r0 = new StringBuilder("Pull message error, reportMessageDiffEvent, imAsrMsgNum=");
        r0.append(((CopyOnWriteArraySet) this.a.h).size());
        r0.append(", imTtsRealMsgNum=");
        r0.append(this.a.j.a.size());
        r0.append(", imTtsQueryMsgNum=");
        r0.append(((CopyOnWriteArraySet) this.a.i).size());
        r0.append(", vuiAsrMsgNum=");
        r0.append(((CopyOnWriteArraySet) this.a.k).size());
        r0.append(", vuiTtsRespMsgNum=0, vuiChatRespNum=");
        this.a.getClass();
        r0.append(((CopyOnWriteArraySet) this.a.l).size());
        com.larus.avlink.n1.d(r11, r0.toString());
        IRealtimeCallTracer r1 = ((n4) this.a.getContext()).k();
        int r2 = ((CopyOnWriteArraySet) this.a.h).size();
        int r3 = this.a.j.a.size();
        int r4 = ((CopyOnWriteArraySet) this.a.i).size();
        int r6 = ((CopyOnWriteArraySet) this.a.k).size();
        this.a.getClass();
        r1.r0(r2, r3, r4, 0, 0, r6, 0, ((CopyOnWriteArraySet) this.a.l).size());
        com.larus.im.d.e().unregisterOnMessageChangedObserver(this.b.a, this.a.o);
    }

    public final void onSuccess(Object r12) {
        List r13 = (List) r12;
        Intrinsics.checkNotNullParameter(r13, "result");
        HashSet r0 = new HashSet();
        HashSet r1 = new HashSet();
        wc9.e r2 = this.b;     // Catch: Exception -> L35
        DoraIMPlugin r3 = this.a;     // Catch: Exception -> L35
        Iterator r14 = r13.iterator();     // Catch: Exception -> L35
    L5:
        if (r14.hasNext() == false) goto L33;
        Message r4 = (Message) r14.next();     // Catch: Exception -> L35
        if (Intrinsics.areEqual(r4.getConversationId(), r2.a) == false) goto L5;
        Intrinsics.checkNotNullParameter(r4, "msg");     // Catch: Exception -> L35
        RealtimeCallUtil.a.getClass();     // Catch: Exception -> L35
        Intrinsics.checkNotNullParameter(r4, "msg");     // Catch: Exception -> L35
        String r6 = "";
        if (com.larus.bmhome.chat.bean.d.G0(r4) == false) goto L25;
        Map r5 = r4.getExt();     // Catch: Exception -> L35
        if (r5 == null) goto L14;
        String r7 = (String) r5.get("local_call_id");     // Catch: Exception -> L35
    L16:
        if (Intrinsics.areEqual(r7, ((n4) r3.getContext()).params().e) == false) goto L25;
        if (CollectionsKt.contains(r3.h, r4.getMessageId()) == true) goto L5;
        String r8 = r4.getMessageId();     // Catch: Exception -> L35
        if (r8 == null) goto L23;
        r6 = r8;
    L23:
        r0.add(r6);     // Catch: Exception -> L35
        goto L5
    L14:
        r7 = null;
    L25:
        if (CollectionsKt.contains(r0, r4.getReplyId()) == false) goto L5;
        if (CollectionsKt.contains(r3.i, r4.getMessageId()) == true) goto L5;
        String r9 = r4.getMessageId();     // Catch: Exception -> L35
        if (r9 == null) goto L32;
        r6 = r9;
    L32:
        r1.add(r6);     // Catch: Exception -> L35
        goto L5
    L33:
        String r15 = this.a.f;     // Catch: Exception -> L35
        StringBuilder r10 = new StringBuilder();     // Catch: Exception -> L35
        r10.append("reportMessageDiffEvent, imAsrMsgNum=");     // Catch: Exception -> L35
        r10.append(((CopyOnWriteArraySet) this.a.h).size());     // Catch: Exception -> L35
        r10.append(", imTtsRealMsgNum=");     // Catch: Exception -> L35
        r10.append(this.a.j.a.size());     // Catch: Exception -> L35
        r10.append(", imTtsQueryMsgNum=");     // Catch: Exception -> L35
        r10.append(((CopyOnWriteArraySet) this.a.i).size());     // Catch: Exception -> L35
        r10.append(", imPullAsrMsgIdSet=");     // Catch: Exception -> L35
        r10.append(r0.size());     // Catch: Exception -> L35
        r10.append(", imPullTtsMsgIdSet=");     // Catch: Exception -> L35
        r10.append(r1.size());     // Catch: Exception -> L35
        r10.append(", vuiAsrMsgNum=");     // Catch: Exception -> L35
        r10.append(((CopyOnWriteArraySet) this.a.k).size());     // Catch: Exception -> L35
        r10.append(", vuiTtsRespMsgNum=");     // Catch: Exception -> L35
        this.a.getClass();     // Catch: Exception -> L35
        r10.append(0);     // Catch: Exception -> L35
        r10.append(", vuiChatRespNum=");     // Catch: Exception -> L35
        r10.append(((CopyOnWriteArraySet) this.a.l).size());     // Catch: Exception -> L35
        com.larus.avlink.n1.d(r15, r10.toString());     // Catch: Exception -> L35
        IRealtimeCallTracer r11 = ((n4) this.a.getContext()).k();     // Catch: Exception -> L35
        int r16 = ((CopyOnWriteArraySet) this.a.h).size();     // Catch: Exception -> L35
        int r17 = this.a.j.a.size();     // Catch: Exception -> L35
        int r18 = ((CopyOnWriteArraySet) this.a.i).size();     // Catch: Exception -> L35
        int r19 = r0.size();     // Catch: Exception -> L35
        int r20 = r1.size();     // Catch: Exception -> L35
        int r21 = ((CopyOnWriteArraySet) this.a.k).size();     // Catch: Exception -> L35
        this.a.getClass();     // Catch: Exception -> L35
        r11.r0(r16, r17, r18, r19, r20, r21, 0, ((CopyOnWriteArraySet) this.a.l).size());     // Catch: Exception -> L35
    L37:
        com.larus.im.d.e().unregisterOnMessageChangedObserver(this.b.a, this.a.o);
        return;
    L35:
        e = move-exception;
        com.larus.avlink.n1.b(this.a.f, e.getMessage());
        goto L37
    }

    public d1(DoraIMPlugin r1, wc9.e r2) {
        this.a = r1;
        this.b = r2;
    }
}
