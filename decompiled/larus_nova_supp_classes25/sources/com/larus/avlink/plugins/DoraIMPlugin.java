package com.larus.avlink.plugins;

import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.avlink.platform.AndroidPlatformKt;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraIMPlugin extends com.larus.audio.call.arch.a<n4> implements e1 {
    public final String f;
    public String g;
    public final Set<String> h;
    public final Set<String> i;
    public final q68.a<String, String> j;
    public final Set<String> k;
    public final Set<String> l;
    public final q68.a<String, Long> m;
    public String n;
    public final b o;

    public static final class a extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ DoraIMPlugin b;

        public final String g() {
            return this.a;
        }

        public a(DoraIMPlugin r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void n(com.larus.im.service.audio.z0.a r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            if ((r10 instanceof pf9.z) == false) goto L9;
            DoraIMPlugin r0 = this.b;
            String r11 = ((pf9.z) r10).a;
            if (r11 != null) goto L7;
            r11 = "";
        L7:
            r0.n = r11;
            return;
        L9:
            if ((r10 instanceof pf9.a0) == false) goto L25;
            String r12 = this.b.n;
            if (r12.length() <= 0) goto L13;
            boolean r1 = true;
        L14:
            if (r1 == false) goto L26;
            ((CopyOnWriteArraySet) this.b.k).add(r12);
            q68.a<String, Long> r2 = this.b.m;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r12, "key");
            if (r2.a.get(r12) == null) goto L22;
            IRealtimeCallTracer r3 = ((n4) this.b.getContext()).k();
            q68.a<String, Long> r4 = this.b.m;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r12, "key");
            Long r5 = (Long) r4.a.get(r12);
            if (r5 == null) goto L20;
            long r6 = r5.longValue();
        L21:
            r3.h0(r6, System.currentTimeMillis(), ((n4) this.b.getContext()).params().o.a, ((n4) this.b.getContext()).params().k.t);
            q68.a<String, Long> r7 = this.b.m;
            r7.getClass();
            Intrinsics.checkNotNullParameter(r12, "key");
            r7.a.remove(r12);
            return;
        L20:
            r6 = 0;
            goto L21
        L22:
            q68.a<String, Long> r8 = this.b.m;
            Long r9 = Long.valueOf(System.currentTimeMillis());
            r8.getClass();
            Intrinsics.checkNotNullParameter(r12, "key");
            r8.a.put(r12, r9);
            return;
        L26:
            return;
        L13:
            r1 = false;
            goto L14
        }
    }

    public static final class b extends y4 {
        public final /* synthetic */ DoraIMPlugin a;

        public b(DoraIMPlugin r1) {
            this.a = r1;
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            DoraIMPlugin.j3(this.a, r1, r2);
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
            DoraIMPlugin.j3(this.a, r1, r2);
        }
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new a(this);
    }

    public final void b3() {
        com.larus.im.d.e().unregisterOnMessageChangedObserver(this.g, this.o);
    }

    public final void e3() {
        super.e3();
        String r0 = ((n4) getContext()).params().l.c;
        this.g = r0;
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        com.larus.im.d.e().registerOnMessageChangedObserver(this.g, this.o);
        return;
    L9:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void g3() {
        super.g3();
        CoroutineScope r1 = ((n4) getContext()).r();
        if (r1 == null) goto L6;
        BuildersKt.launch$default(r1, Dispatchers.getIO(), null, new DoraIMPlugin$onStop$1(this, null), 2, null);
        return;
    }

    public final String T2() {
        return this.f;
    }

    public DoraIMPlugin(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "DoraIMPlugin";
        this.g = "";
        this.h = new CopyOnWriteArraySet();
        this.i = new CopyOnWriteArraySet();
        this.j = new q68.a();
        this.k = new CopyOnWriteArraySet();
        this.l = new CopyOnWriteArraySet();
        this.m = new q68.a();
        this.n = "";
        this.o = new b(this);
    }

    @Override // com.larus.avlink.plugins.e1
    public final void v1(String r4) {
        if (com.flow.kmp.common.util.f.a(r4) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.g, r4) == false) goto L7;
        return;
    L7:
        if (this.g.length() <= 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        com.larus.im.d.e().unregisterOnMessageChangedObserver(this.g, this.o);
    L12:
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        this.g = r4;
        com.larus.im.d.e().registerOnMessageChangedObserver(this.g, this.o);
        return;
    L9:
        r0 = false;
        goto L10
    }

    public static final Object k3(DoraIMPlugin r4, Continuation r5) {
        r4.getClass();
        if ((r5 instanceof DoraIMPlugin$updateConversationInfo$1) == false) goto L7;
        DoraIMPlugin$updateConversationInfo$1 r0 = (DoraIMPlugin$updateConversationInfo$1) r5;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L17:
        wc9.e r7 = (wc9.e) r6;
        if (r7 == null) goto L21;
        com.larus.im.d.e().j(new uf9.a.a(r7.a, 50), new d1(r4, r7));
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        String r8 = r4.g;
        r0.label = 1;
        r6 = AndroidPlatformKt.b(r8, r0);
        if (r6 != r2) goto L17;
        return r2;
    L7:
        r0 = new DoraIMPlugin$updateConversationInfo$1(r4, r5);
        goto L8
    }

    public static final void j3(DoraIMPlugin r12, String r13, Message r14) {
        if (Intrinsics.areEqual(r13, r12.g) == false) goto L62;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r14, "msg");     // Catch: Throwable -> L54
        RealtimeCallUtil.a.getClass();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r14, "msg");     // Catch: Throwable -> L54
        String r4 = "";
        Object r5 = null;
        if (com.larus.bmhome.chat.bean.d.G0(r14) == false) goto L27;
        Map r16 = r14.getExt();     // Catch: Throwable -> L54
        if (r16 == null) goto L11;
        String r17 = (String) r16.get("local_call_id");     // Catch: Throwable -> L54
    L13:
        if (Intrinsics.areEqual(r17, ((n4) r12.getContext()).params().e) == false) goto L27;
        String r18 = r14.getMessageId();     // Catch: Throwable -> L54
        if (r18 == null) goto L18;
        r4 = r18;
    L18:
        com.larus.avlink.n1.d(r12.f, "Query msgId=" + r14.getMessageId());     // Catch: Throwable -> L54
        ((CopyOnWriteArraySet) r12.h).add(r4);     // Catch: Throwable -> L54
        q68.a<String, Long> r19 = r12.m;     // Catch: Throwable -> L54
        r19.getClass();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r4, "key");     // Catch: Throwable -> L54
        if (r19.a.get(r4) == null) goto L25;
        IRealtimeCallTracer r6 = ((n4) r12.getContext()).k();     // Catch: Throwable -> L54
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L54
        q68.a<String, Long> r110 = r12.m;     // Catch: Throwable -> L54
        r110.getClass();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r4, "key");     // Catch: Throwable -> L54
        Long r111 = (Long) r110.a.get(r4);     // Catch: Throwable -> L54
        if (r111 == null) goto L23;
        long r112 = r111.longValue();     // Catch: Throwable -> L54
    L24:
        r6.h0(r7, r112, ((n4) r12.getContext()).params().o.a, ((n4) r12.getContext()).params().k.t);     // Catch: Throwable -> L54
        q68.a<String, Long> r113 = r12.m;     // Catch: Throwable -> L54
        r113.getClass();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r4, "key");     // Catch: Throwable -> L54
        r5 = r113.a.remove(r4);     // Catch: Throwable -> L54
    L51:
        Object r114 = Result.constructor-impl(r5);     // Catch: Throwable -> L54
    L56:
        Throwable r115 = Result.exceptionOrNull-impl(r114);
        if (r115 == null) goto L61;
        com.larus.avlink.n1.b(r12.f, "onReceiveMessage error: " + r115.getMessage());
        return;
    L61:
        return;
    L23:
        r112 = 0;
        goto L24
    L25:
        q68.a<String, Long> r116 = r12.m;     // Catch: Throwable -> L54
        Long r117 = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L54
        r116.getClass();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r4, "key");     // Catch: Throwable -> L54
        r116.a.put(r4, r117);     // Catch: Throwable -> L54
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L54
        goto L51
    L11:
        r17 = null;
    L27:
        if (com.larus.im.bean.message.a.r0(r14) == false) goto L29;
    L52:
        com.larus.avlink.n1.d(r12.f, "msgStatusLocal=" + r14.getMessageStatusLocal() + ", isServerLoading=" + com.larus.im.bean.message.a.r0(r14) + ", msgStatus=" + r14.getMessageStatus());     // Catch: Throwable -> L54
        return;
    L29:
        if (r14.getMessageStatusLocal() == (-1)) goto L52;
        MessageStatus r118 = r14.getMessageStatus();     // Catch: Throwable -> L54
        if (r118 == null) goto L35;
        boolean r1 = true;
        if (r118.isVisible() != true) goto L35;
    L36:
        if (r1 == false) goto L52;
        if (CollectionsKt.contains(r12.h, r14.getReplyId()) == false) goto L50;
        com.larus.avlink.n1.d(r12.f, "msgId=" + r14.getMessageId() + ", replyId=" + r14.getReplyId() + ", state=" + r14.getMessageStatus());     // Catch: Throwable -> L54
        String r119 = r14.getMessageId();     // Catch: Throwable -> L54
        if (r119 == null) goto L43;
        ((CopyOnWriteArraySet) r12.i).add(r119);     // Catch: Throwable -> L54
    L43:
        String r120 = r14.getReplyId();     // Catch: Throwable -> L54
        if (r120 == null) goto L51;
        q68.a<String, String> r0 = r12.j;     // Catch: Throwable -> L54
        String r121 = r14.getMessageId();     // Catch: Throwable -> L54
        if (r121 == null) goto L49;
        r4 = r121;
    L49:
        r0.getClass();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r120, "key");     // Catch: Throwable -> L54
        r0.a.put(r120, r4);     // Catch: Throwable -> L54
    L50:
        r5 = Unit.INSTANCE;     // Catch: Throwable -> L54
    L35:
        r1 = false;
    L54:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r114 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    }
}
