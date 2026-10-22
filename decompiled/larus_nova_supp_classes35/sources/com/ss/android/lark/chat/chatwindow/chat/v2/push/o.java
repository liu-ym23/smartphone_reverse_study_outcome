package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import android.os.SystemClock;
import com.bytedance.lark.pb.im.v1.PushMessageReactions;
import com.bytedance.lark.pb.im.v1.PushMessageReadStates;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.AndroidThrottle;
import com.ss.android.lark.biz.im.api.g1;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
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
public final class o implements c0.a {
    public final String a;
    public final d b;
    public final c c;
    public final x0 d;
    public final m6b.u e;
    public final PerfMessageReceiveMonitor f;
    public AndroidThrottle<Chat> g;
    public final a h;
    public final b i;

    public class a extends aqb.k {
        public final ConcurrentHashMap<String, MessageInfo> a;
        public final /* synthetic */ o b;

        public a(o r1) {
            this.b = r1;
            this.a = new ConcurrentHashMap();
        }

        public final void a(Chat r3) {
            if (this.b.a.equals(r3.getId()) == false) goto L6;
            o.a(this.b).d(r3);
            return;
        }

        public final void b(Chat r3) {
            if (com.ss.android.lark.chat.utils.h0.c(this.b.a, r3.getId()) == true) goto L5;
            return;
        L5:
            this.b.b.onPushChatRemoveMe(r3);
        }

        public final void d(g1 r7) {
            MessageInfo r0 = r7.a;
            h7b.l.e(r0);
            if (this.b.a.equals(r0.getMessage().getChatId()) == false) goto L15;
            if (this.b.b == null) goto L15;
            List<ReactionInfo> r1 = r0.getReactionInfoList();
            if (r1 == null) goto L9;
            int r2 = r1.size();
        L10:
            Log.i("ChatRelationPushHandler", "onPushMessage id:" + r0.getId() + ",reactionCount:" + r2);
            this.a.put(r0.getId(), r0);
            ArrayList r3 = new ArrayList();
            r3.add(r0);
            Intrinsics.checkNotNullParameter(r0, "<this>");
            if (kkb.a.a(r0.getMessage()) == true) goto L13;
            this.b.f.a(r3);
        L13:
            this.b.b.onPushMessage(r3, false);
            CopyOnWriteArrayList r4 = com.ss.android.lark.statistics.perf.b.a;
            com.ss.android.lark.statistics.perf.b.a(this.b.a, r0, SystemClock.elapsedRealtime());
            goto L15
        L9:
            r2 = 0;
        L15:
            if (r0.getMessage().getStreamStatus() == MessageStreamStatus.Transport) goto L17;
            o.a(this.b).d(r7.b);
            return;
        L17:
            Log.i("ChatRelationPushHandler", "message streaming, id:" + r0.getId());
            if ((r0.getMessage().getContent() instanceof PostContent) == false) goto L22;
            Log.i("ChatRelationPushHandler", "message streaming, RichText:" + com.ss.android.lark.widget.richtext.i.l(((PostContent) r0.getMessage().getContent()).getRichText()));
            return;
        }

        public final void f(final PushMessageReactions r3) {
            if (com.ss.android.lark.chat.utils.h0.c(this.b.a, r3.chat_id) == true) goto L5;
            return;
        L5:
            CoreThreadPool.getBackgroundHandler().post(new l(this, r3));
        }

        public final void g(final PushMessageReadStates r5) {
            CoreThreadPool.getBackgroundHandler().postDelayed(new k(this, r5), 300);
        }

        public final void c(Chat r3, Map<String, ? extends Chatter> r4) {
            if (com.ss.android.lark.chat.utils.h0.c(this.b.a, r3.getId()) == true) goto L5;
            return;
        L5:
            this.b.b.onPushChatRemoveChatters(r3, r4);
        }
    }

    public class b implements com.ss.android.lark.chat.service.impl.g0 {
        public final /* synthetic */ o a;

        public b(o r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chat.service.impl.g0
        public final void c(MessageInfo r4) {
            o r0 = this.a;
            if (Objects.equals(r0.a, r4.getMessage().getChatId()) == true) goto L5;
            return;
        L5:
            if (r0.b == null) goto L9;
            ArrayList r1 = new ArrayList();
            r1.add(r4);
            r0.b.onPushMessage(r1, true);
            return;
        }
    }

    public interface c {
        MessageInfo getMessageById(String r1);
    }

    public interface d {
        void onPushChat(Chat r1);

        void onPushChatRemoveChatters(Chat r1, Map<String, ? extends Chatter> r2);

        void onPushChatRemoveMe(Chat r1);

        void onPushMessage(List<MessageInfo> r1, boolean r2);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void register() {
        x0 r0 = this.d;
        String r1 = String.valueOf(hashCode());
        String r2 = this.a;
        a r3 = this.h;
        r0.a.W1(r1, r2, new w0(r3));
        this.e.K3(this.i);
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.c0.a
    public final void unRegister() {
        x0 r0 = this.d;
        String r1 = String.valueOf(hashCode());
        String r2 = this.a;
        r0.a.V(r1, r2);
        this.e.kd(this.i);
        this.f.d.clear();
    }

    public static AndroidThrottle a(final o r3) {
        monitor-enter(r3);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (r3.g != null) goto L6;
        AndroidThrottle.a r0 = new AndroidThrottle.a();     // Catch: Throwable -> L9
        r0.b = 300;     // Catch: Throwable -> L9
        r0.a = CoreThreadPool.getNonblockingHandler();     // Catch: Throwable -> L9
        r0.d = new com.ss.android.lark.chat.chatwindow.chat.model.push.a();     // Catch: Throwable -> L9
        r0.e = new j(r3);     // Catch: Throwable -> L9
        r3.g = r0.a();     // Catch: Throwable -> L9
    L6:
        AndroidThrottle<Chat> r1 = r3.g;     // Catch: Throwable -> L9
        monitor-exit(r3);
        return r1;
    }

    public o(Chat r2, x0 r3, m6b.u r4, d r5, c r6) {
        this.h = new a(this);
        this.i = new b(this);
        this.a = r2.getId();
        this.d = r3;
        this.e = r4;
        this.b = r5;
        this.c = r6;
        this.f = new PerfMessageReceiveMonitor(r2);
    }
}
