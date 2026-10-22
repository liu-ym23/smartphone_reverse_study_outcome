package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.v2.MessageListViewModelV2;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.chat.service.impl.k2;
import com.ss.android.lark.chat.utils.w0;
import com.ss.android.lark.chat.utils.x0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.perf.PerfMessageReceiveMonitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l0 implements c0.a {
    public final String a;
    public final String b;
    public volatile ThreadTopic c;
    public final o.d d;
    public final d e;
    public final o.c f;
    public final x0 g;
    public final m6b.u h;
    public final PerfMessageReceiveMonitor i;
    public final m6b.q j;
    public final x4b.d k;
    public AndroidThrottle<Chat> l;
    public final AndroidThrottle<ThreadTopic> m;
    public final a n;
    public final b o;
    public final c p;

    public class a extends aqb.k {
        public final ConcurrentHashMap<String, MessageInfo> a;
        public final /* synthetic */ l0 b;

        public a(l0 r1) {
            this.b = r1;
            this.a = new ConcurrentHashMap();
        }

        public final void a(Chat r5) {
            if (this.b.a.equals(r5.getId()) == false) goto L15;
            final l0 r0 = this.b;
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (r0.l != null) goto L9;
            AndroidThrottle.a r1 = new AndroidThrottle.a();     // Catch: Throwable -> L12
            r1.b = 300;     // Catch: Throwable -> L12
            r1.a = CoreThreadPool.getNonblockingHandler();     // Catch: Throwable -> L12
            r1.d = new com.ss.android.lark.chat.chatwindow.chat.model.push.a();     // Catch: Throwable -> L12
            r1.e = new f0(r0);     // Catch: Throwable -> L12
            r0.l = new AndroidThrottle(r1);     // Catch: Throwable -> L12
        L9:
            AndroidThrottle<Chat> r2 = r0.l;     // Catch: Throwable -> L12
            monitor-exit(r0);
            r2.d(r5);
            return;
        }

        public final void b(Chat r3) {
            if (com.ss.android.lark.chat.utils.h0.c(this.b.a, r3.getId()) == true) goto L5;
            return;
        L5:
            this.b.d.onPushChatRemoveMe(r3);
        }

        public final void d(g1 r7) {
            MessageInfo r0 = r7.a;
            h7b.l.e(r0);
            boolean r2 = true;
            if (this.b.a.equals(r0.getMessage().getChatId()) == false) goto L19;
            l0 r1 = this.b;
            String r3 = r0.getMessage().getThreadId();
            String r4 = r1.b;
            if (r4 == null) goto L7;
            boolean r5 = Objects.equals(r3, r4);
        L8:
            if (r5 == false) goto L19;
            if (this.b.d == null) goto L19;
            List<ReactionInfo> r6 = r0.getReactionInfoList();
            if (r6 == null) goto L14;
            int r8 = r6.size();
        L15:
            Log.i("ThreadDetailPushHandler", "onPushMessage id:" + r0.getId() + ",reactionCount:" + r8);
            this.a.put(r0.getId(), r0);
            ArrayList r9 = new ArrayList();
            r9.add(r0);
            Intrinsics.checkNotNullParameter(r0, "<this>");
            if (kkb.a.a(r0.getMessage()) == true) goto L18;
            this.b.i.a(r9);
        L18:
            this.b.d.onPushMessage(r9, false);
            CopyOnWriteArrayList r10 = com.ss.android.lark.statistics.perf.b.a;
            com.ss.android.lark.statistics.perf.b.a(this.b.a, r0, SystemClock.elapsedRealtime());
            goto L19
        L14:
            r8 = 0;
            goto L15
        L7:
            r5 = true;
        L19:
            ThreadTopic r11 = r7.c;
            if (r11 == null) goto L27;
            l0 r12 = this.b;
            String r13 = r11.getId();
            String r14 = r12.b;
            if (r14 == null) goto L24;
            r2 = Objects.equals(r13, r14);
        L24:
            if (r2 == false) goto L28;
            this.b.a(r11);
            return;
        L28:
            return;
        }

        public final void f(final PushMessageReactions r3) {
            if (com.ss.android.lark.chat.utils.h0.c(this.b.a, r3.chat_id) == true) goto L5;
            return;
        L5:
            CoreThreadPool.getBackgroundHandler().post(new h0(this, r3));
        }

        public final void g(final PushMessageReadStates r5) {
            CoreThreadPool.getBackgroundHandler().postDelayed(new i0(this, r5), 300);
        }

        public final void h(ThreadTopic r2) {
            this.b.a(r2);
        }

        public final void c(Chat r3, Map<String, ? extends Chatter> r4) {
            if (com.ss.android.lark.chat.utils.h0.c(this.b.a, r3.getId()) == true) goto L5;
            return;
        L5:
            this.b.d.onPushChatRemoveChatters(r3, r4);
        }
    }

    public class b implements k2.b {
        public final /* synthetic */ l0 a;

        public b(l0 r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.service.impl.k2.b
        public final void a(JSONObject r6) {
            final l0 r0 = this.a;
            r0.getClass();
            if (r6 == null) goto L31;
            final n5b.a r7 = (n5b.a) r6.get("thread_info");     // Catch: Exception -> L21 JSONException -> L23
            if (r7 == null) goto L26;
            ThreadTopic r3 = r7.b;     // Catch: Exception -> L21 JSONException -> L23
            if (r3 == null) goto L26;
            if (Objects.equals(r0.b, r3.getId()) == false) goto L26;
            Log.i("ThreadDetailPushHandler", "onPushThreads:" + r7.getId());     // Catch: Exception -> L21 JSONException -> L23
            if (r7.isNoTraceDelete() == false) goto L17;
            Log.i("ThreadDetailPushHandler", "get no trace delete push");     // Catch: Exception -> L21 JSONException -> L23
            goto L26
        L17:
            if (r0.c != null) goto L19;
            Log.i("ThreadDetailPushHandler", "origin thread is null");     // Catch: Exception -> L21 JSONException -> L23
            goto L26
        L19:
            r0.k.execute(new g0(r0, r7));     // Catch: Exception -> L21 JSONException -> L23
        L26:
            return;
        L23:
            e = move-exception;
            e.printStackTrace();
            return;
        L21:
            e = move-exception;
            e.printStackTrace();
            return;
        }
    }

    public class c implements com.ss.android.lark.chat.service.impl.g0 {
        public final /* synthetic */ l0 a;

        public c(l0 r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.service.impl.g0
        public final void c(MessageInfo r5) {
            l0 r0 = this.a;
            if (Objects.equals(r0.a, r5.getMessage().getChatId()) == false) goto L13;
            String r1 = r5.getMessage().getThreadId();
            String r2 = r0.b;
            if (r2 == null) goto L7;
            boolean r3 = Objects.equals(r1, r2);
        L8:
            if (r3 == true) goto L10;
            return;
        L10:
            if (r0.d == null) goto L15;
            ArrayList r4 = new ArrayList();
            r4.add(r5);
            r0.d.onPushMessage(r4, true);
            return;
        L15:
            return;
        L7:
            r3 = true;
            goto L8
        }
    }

    public interface d {
        MessageInfo getTopicMessageInfo();

        void onPushThreadTopic(ThreadTopic r1);

        void onPushUpdateThreadInfo(n5b.a r1);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        x0 r0 = this.g;
        String r1 = String.valueOf(hashCode());
        String r2 = this.a;
        a r3 = this.n;
        r0.a.W1(r1, r2, new w0(r3));
        this.h.K3(this.p);
        this.j.G1(this.o);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        x0 r0 = this.g;
        String r1 = String.valueOf(hashCode());
        String r2 = this.a;
        r0.a.V(r1, r2);
        this.h.kd(this.p);
        this.j.Ia(this.o);
        this.i.d.clear();
    }

    public final void a(final ThreadTopic r3) {
        if (TextUtils.equals(this.b, r3.getId()) == true) goto L5;
        return;
    L5:
        this.k.execute(new e0(this, r3));
    }

    public l0(Chat r2, ThreadTopic r3, x0 r4, m6b.u r5, m6b.q r6, x4b.d r7, o.d r8, d r9, MessageListViewModelV2.s r10) {
        this.n = new a(this);
        this.o = new b(this);
        this.p = new c(this);
        this.a = r2.getId();
        this.c = r3;
        if (r3 == null) goto L5;
        String r11 = r3.getId();
    L6:
        this.b = r11;
        this.g = r4;
        this.h = r5;
        this.j = r6;
        this.k = r7;
        this.d = r8;
        this.e = r9;
        this.f = r10;
        this.i = new PerfMessageReceiveMonitor(r2);
        AndroidThrottle.a r12 = new AndroidThrottle.a();
        r12.a = CoreThreadPool.getNonblockingHandler();
        r12.b = 100;
        r12.e = new d0(this);
        this.m = new AndroidThrottle(r12);
        return;
    L5:
        r11 = null;
        goto L6
    }
}
