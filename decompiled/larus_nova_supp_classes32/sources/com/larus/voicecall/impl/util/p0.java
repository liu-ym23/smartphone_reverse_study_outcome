package com.larus.voicecall.impl.util;

import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p0 implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ String a;
    public final /* synthetic */ CopyOnWriteArraySet<String> b;
    public final /* synthetic */ ConcurrentHashMap<String, String> c;
    public final /* synthetic */ CopyOnWriteArraySet<String> d;
    public final /* synthetic */ CopyOnWriteArraySet<String> e;
    public final /* synthetic */ int f;
    public final /* synthetic */ CopyOnWriteArraySet<String> g;
    public final /* synthetic */ Ref.ObjectRef<IRealtimeCallTracer> h;
    public final /* synthetic */ String i;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r10) {
        Intrinsics.checkNotNullParameter(r10, "error");
        Intrinsics.checkNotNullParameter(r10, "error");
        FLogger.a.i("RealtimeCallUtil", "Pull message error, reportMessageDiffEvent, imAsrMsgNum=" + this.b.size() + ", imTtsRealMsgNum=" + this.c.size() + ", imTtsQueryMsgNum=" + this.d.size() + ", vuiAsrMsgNum=" + this.e.size() + ", vuiTtsRespMsgNum=" + this.f + ", vuiChatRespNum=" + this.g.size());
        IRealtimeCallTracer r0 = (IRealtimeCallTracer) this.h.element;
        if (r0 == null) goto L5;
        r0.r0(this.b.size(), this.c.size(), this.d.size(), 0, 0, this.e.size(), this.f, this.g.size());
    L5:
        this.h.element = null;
    }

    public final void onSuccess(Object r14) {
        List r15 = (List) r14;
        Intrinsics.checkNotNullParameter(r15, "result");
        RealtimeCallUtil.a.getClass();
        IConversationRepoService r1 = (IConversationRepoService) RealtimeCallUtil.X.getValue();
        if (r1 == null) goto L5;
        r1.h(this.a, null);
    L5:
        HashSet r2 = new HashSet();
        HashSet r3 = new HashSet();
        String r4 = this.a;     // Catch: Exception -> L41
        String r5 = this.i;     // Catch: Exception -> L41
        CopyOnWriteArraySet<String> r6 = this.b;     // Catch: Exception -> L41
        CopyOnWriteArraySet<String> r7 = this.d;     // Catch: Exception -> L41
        Iterator r16 = r15.iterator();     // Catch: Exception -> L41
    L8:
        if (r16.hasNext() == false) goto L36;
        Message r8 = (Message) r16.next();     // Catch: Exception -> L41
        if (Intrinsics.areEqual(r8.getConversationId(), r4) == false) goto L8;
        RealtimeCallUtil.a.getClass();     // Catch: Exception -> L41
        Intrinsics.checkNotNullParameter(r8, "msg");     // Catch: Exception -> L41
        boolean r9 = d.G0(r8);     // Catch: Exception -> L41
        String r10 = NameKeys.UnloadStrategy_No_Strategy;
        if (r9 == false) goto L28;
        Map r11 = r8.getExt();     // Catch: Exception -> L41
        if (r11 == null) goto L17;
        String r12 = (String) r11.get("local_call_id");     // Catch: Exception -> L41
    L19:
        if (Intrinsics.areEqual(r12, r5) == false) goto L28;
        if (r6.contains(r8.getMessageId()) == true) goto L8;
        String r13 = r8.getMessageId();     // Catch: Exception -> L41
        if (r13 == null) goto L26;
        r10 = r13;
    L26:
        r2.add(r10);     // Catch: Exception -> L41
        goto L8
    L17:
        r12 = null;
    L28:
        if (CollectionsKt.contains(r2, r8.getReplyId()) == false) goto L8;
        if (r7.contains(r8.getMessageId()) == true) goto L8;
        String r17 = r8.getMessageId();     // Catch: Exception -> L41
        if (r17 == null) goto L35;
        r10 = r17;
    L35:
        r3.add(r10);     // Catch: Exception -> L41
        goto L8
    L36:
        FLogger.a.i("RealtimeCallUtil", "reportMessageDiffEvent, imAsrMsgNum=" + this.b.size() + ", imTtsRealMsgNum=" + this.c.size() + ", imTtsQueryMsgNum=" + this.d.size() + ", imPullAsrMsgIdSet=" + r2.size() + ", imPullTtsMsgIdSet=" + r3.size() + ", vuiAsrMsgNum=" + this.e.size() + ", vuiTtsRespMsgNum=" + this.f + ", vuiChatRespNum=" + this.g.size());     // Catch: Exception -> L41
        IRealtimeCallTracer r18 = (IRealtimeCallTracer) this.h.element;     // Catch: Exception -> L41
        if (r18 == null) goto L39;
        r18.r0(this.b.size(), this.c.size(), this.d.size(), r2.size(), r3.size(), this.e.size(), this.f, this.g.size());     // Catch: Exception -> L41
    L39:
        this.h.element = null;     // Catch: Exception -> L41
        return;
    L41:
        e = move-exception;
        FLogger.a.e("RealtimeCallUtil", e.getMessage());
    }

    public p0(String r1, CopyOnWriteArraySet<String> r2, ConcurrentHashMap<String, String> r3, CopyOnWriteArraySet<String> r4, CopyOnWriteArraySet<String> r5, int r6, CopyOnWriteArraySet<String> r7, Ref.ObjectRef<IRealtimeCallTracer> r8, String r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
