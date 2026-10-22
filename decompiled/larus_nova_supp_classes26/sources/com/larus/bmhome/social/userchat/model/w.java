package com.larus.bmhome.social.userchat.model;

import com.larus.bmhome.chat.i1;
import com.larus.bmhome.social.page.datasource.event.ConflatedFlow;
import com.larus.bmhome.social.page.datasource.event.RefreshTraceSource;
import com.larus.bmhome.utils.t3;
import com.larus.bmhome.utils.v2;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallbackExt;
import com.larus.im.callback.IIMError;
import com.larus.platform.api.IAppLaunchReporter;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class w implements IIMCallbackExt<List<? extends Message>> {
    public boolean a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ ChatMessageReceiverModel d;
    public final /* synthetic */ long e;
    public final /* synthetic */ String f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ com.larus.bmhome.social.page.datasource.event.e h;
    public final /* synthetic */ ConflatedFlow<LoadState> i;
    public final /* synthetic */ long j;
    public final /* synthetic */ int k;
    public final /* synthetic */ vr8.b l;
    public final /* synthetic */ int m;
    public final /* synthetic */ long n;

    public final boolean mustInMain() {
        return false;
    }

    public final void onFailure(IIMError r6) {
        Intrinsics.checkNotNullParameter(r6, "error");
        if (this.e == this.d.z.get()) goto L10;
        FLogger.a.i(this.d.k, "skip stale message list failure: " + this.e);
        vr8.b r7 = this.l;
        if (r7 == null) goto L26;
        com.larus.bmhome.social.page.datasource.event.e r0 = this.h;
        if ((r0 instanceof com.larus.bmhome.social.page.datasource.event.e.a) == false) goto L27;
        r7.b((com.larus.bmhome.social.page.datasource.event.e.a) r0);
        return;
    L27:
        return;
    L26:
        return;
    L10:
        FLogger.a.i(this.d.k, "getMessageList failed, error:" + r6);
        IAppLaunchReporter r1 = (IAppLaunchReporter) ServiceManager.get().getService(IAppLaunchReporter.class);
        if (r1 == null) goto L13;
        r1.a("load_message_from_db", r6.getExt(), r6.getCode(), String.valueOf(r6.getTips()));
    L13:
        vr8.b r8 = this.l;
        if (r8 == null) goto L19;
        com.larus.bmhome.social.page.datasource.event.e r2 = this.h;
        if ((r2 instanceof com.larus.bmhome.social.page.datasource.event.e.a) == false) goto L19;
        r8.b((com.larus.bmhome.social.page.datasource.event.e.a) r2);
    L19:
        if (this.i.a() != LoadState.COMPLETE) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == true) goto L24;
        this.i.b(LoadState.READY_TO_LOAD);
    L24:
        this.d.N = true;
        this.d.s.complete(Unit.INSTANCE);
        return;
    L21:
        r9 = false;
        goto L22
    }

    public final void onLocalFinish(Object r22) {
        List r5 = (List) r22;
        Intrinsics.checkNotNullParameter(r5, "result");
        if (this.e == this.d.z.get()) goto L5;
        FLogger.a.i(this.d.k, "skip stale local message list callback: " + this.e);
        return;
    L5:
        FLogger.a.i(this.d.k, "onLocalFinish, result size:" + r5.size());
        String r6 = com.larus.bmhome.social.page.datasource.event.d.a(RefreshTraceSource.LOCAL);
        if (this.b == false) goto L37;
        i1 r1 = this.d.j;
        if (r1 == null) goto L37;
        long r2 = com.larus.bmhome.social.page.datasource.event.d.b(r6);
        int r0 = r5.size();
        List r4 = r5;
        boolean r9 = false;
        if ((r4 instanceof Collection) == true) goto L12;
    L14:
        Iterator r7 = r4.iterator();
        int r8 = 0;
    L16:
        if (r7.hasNext() == false) goto L22;
        if (com.larus.bmhome.chat.bean.d.W0((Message) r7.next()) == false) goto L16;
        r8 = r8 + 1;
        if (r8 >= 0) goto L16;
        CollectionsKt.throwCountOverflow();
    L22:
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter(r6, "refreshTraceId");     // Catch: Throwable -> L34
        if (r1.p == 0) goto L26;
    L32:
        monitor-exit(r1);
        goto L37
    L26:
        if (r6.length() <= 0) goto L28;
        r9 = true;
    L28:
        if (r9 == false) goto L32;
        if (r2 <= 0) goto L32;
        r1.u = r6;     // Catch: Throwable -> L34
        r1.p = r2;     // Catch: Throwable -> L34
        r1.z = r0;     // Catch: Throwable -> L34
        r1.B = r8;     // Catch: Throwable -> L34
        r1.a("localMsgListCallbackTime", r1.p);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    L12:
        if (r4.isEmpty() == false) goto L14;
        r8 = 0;
    L37:
        FLogger.a.i("MsgRefreshFlow_ChatMessageReceiverModel", "onLocalFinish rt=" + r6 + " cid=" + this.f + " size=" + r5.size() + " isFromInit=" + this.b);
        ChatMessageReceiverModel r3 = this.d;
        BuildersKt.launch$default(r3.a, r3.l, null, new ChatMessageReceiverModel$getMessageList$onlineTask$1$1$onLocalFinish$2(this.e, r3, r5, r6, this, this.g, this.h, this.i, this.b, this.f, this.c, this.j, this.k, null), 2, null);
    }

    public final void onSuccess(Object r27) {
        List r11 = (List) r27;
        Intrinsics.checkNotNullParameter(r11, "result");
        if (this.e == this.d.z.get()) goto L9;
        FLogger.a.i(this.d.k, "skip stale remote message list callback: " + this.e);
        vr8.b r0 = this.l;
        if (r0 == null) goto L45;
        com.larus.bmhome.social.page.datasource.event.e r1 = this.h;
        if ((r1 instanceof com.larus.bmhome.social.page.datasource.event.e.a) == false) goto L46;
        r0.b((com.larus.bmhome.social.page.datasource.event.e.a) r1);
        return;
    L46:
        return;
    L45:
        return;
    L9:
        FLogger r2 = FLogger.a;
        r2.i(this.d.k, "onSuccess, result size:" + r11.size());
        String r12 = com.larus.bmhome.social.page.datasource.event.d.a(RefreshTraceSource.REMOTE);
        if (this.b == false) goto L30;
        i1 r3 = this.d.j;
        if (r3 == null) goto L30;
        long r4 = com.larus.bmhome.social.page.datasource.event.d.b(r12);
        monitor-enter(r3);
        Intrinsics.checkNotNullParameter(r12, "refreshTraceId");     // Catch: Throwable -> L27
        if (r3.q == 0) goto L18;
    L25:
        monitor-exit(r3);
        goto L30
    L18:
        if (r12.length() <= 0) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == false) goto L25;
        if (r4 <= 0) goto L25;
        r3.v = r12;     // Catch: Throwable -> L27
        r3.q = r4;     // Catch: Throwable -> L27
        r3.a("remoteMsgListCallbackTime", r3.q);     // Catch: Throwable -> L27
        goto L25
    L20:
        r5 = false;
    L27:
        th = move-exception;
        throw th;
    L30:
        r2.i("MsgRefreshFlow_ChatMessageReceiverModel", "onSuccess rt=" + r12 + " cid=" + this.f + " size=" + r11.size());
        Iterator r6 = CollectionsKt.toList(v2.a).iterator();
    L32:
        if (r6.hasNext() == false) goto L36;
        Function2<String, List<Message>, Unit> r7 = ((t3) r6.next()).a;
        if (r7 == null) goto L32;
        r7.invoke(this.f, r11);
        goto L32
    L36:
        boolean r16 = r11.isEmpty();
        ChatMessageReceiverModel r8 = this.d;
        BuildersKt.launch$default(r8.a, r8.l, null, new ChatMessageReceiverModel$getMessageList$onlineTask$1$1$onSuccess$1(this.e, r8, this.l, this.h, this.c, this.j, this.k, r11, this, r12, this.f, this.m, r16, this.n, this.i, null), 2, null);
    }

    public static final void a(w r8, com.larus.bmhome.social.page.datasource.event.e r9, List r10) {
        if (r8.e == r8.d.z.get()) goto L5;
        FLogger.a.i(r8.d.k, "skip stale cursor update: " + r8.e);
        return;
    L5:
        boolean r0 = r9 instanceof com.larus.bmhome.social.page.datasource.event.e.b;
        Long r1 = null;
        if (r0 == false) goto L8;
    L9:
        Message r2 = (Message) CollectionsKt.lastOrNull(r10);
        if (r2 == null) goto L12;
        Long r3 = Long.valueOf(r2.getLocalIndex());
    L13:
        ChatMessageReceiverModel r4 = r8.d;
        Long r5 = r4.x;
        if (r3 != null) goto L16;
        r3 = r5;
    L19:
        r4.x = r3;
        FLogger.a.i(r8.d.k, "update append cursor: " + r8.d.x);
    L20:
        if (r0 == false) goto L22;
    L23:
        Message r11 = (Message) CollectionsKt.firstOrNull(r10);
        if (r11 == null) goto L26;
        r1 = Long.valueOf(r11.getLocalIndex());
    L26:
        ChatMessageReceiverModel r12 = r8.d;
        Long r13 = r12.w;
        if (r1 != null) goto L29;
        r1 = r13;
    L32:
        r12.w = r1;
        FLogger.a.i(r8.d.k, "update prepend cursor: " + r8.d.w);
        return;
    L29:
        if (r13 == null) goto L32;
        r1 = Long.valueOf(Math.max(r13.longValue(), r1.longValue()));
        goto L32
    L22:
        if ((r9 instanceof com.larus.bmhome.social.page.datasource.event.e.a.b) == true) goto L23;
        return;
    L16:
        if (r5 == null) goto L19;
        r3 = Long.valueOf(Math.min(r5.longValue(), r3.longValue()));
        goto L19
    L12:
        r3 = null;
        goto L13
    L8:
        if ((r9 instanceof com.larus.bmhome.social.page.datasource.event.e.a.C0035a) == false) goto L20;
        goto L9
    }

    public w(boolean r4, boolean r5, ChatMessageReceiverModel r6, long r7, String r9, boolean r10, com.larus.bmhome.social.page.datasource.event.e r11, ConflatedFlow<LoadState> r12, long r13, int r15, vr8.b r16, int r17, long r18) {
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r15;
        this.l = r16;
        this.m = r17;
        this.n = r18;
    }
}
