package com.obric.assistant.block.base;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.adapter.i;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.d;
import com.larus.im.observer.MessageListState;
import com.larus.utils.logger.FLogger;
import ic8.v;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import jc8.a;
import jc8.e;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import va8.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class CheckLastMessageBlockHolder<T extends jc8.a> extends jc8.b<T> {
    public static final /* synthetic */ int o = 0;
    public final CoroutineScope d;
    public Job e;
    public final AtomicBoolean f;
    public Message g;
    public final StateFlowImpl h;
    public Job i;
    public Lifecycle j;
    public i<?> k;
    public m0 l;
    public final CheckLastMessageBlockHolder$lifecycleObserver$1 m;
    public final Lazy n;

    public static final class a {
    }

    public static final class b implements nf9.b {
        public final /* synthetic */ CheckLastMessageBlockHolder<T> a;

        public final void a(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void f(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public b(CheckLastMessageBlockHolder<T> r1) {
            this.a = r1;
        }

        public final void g(String r5) {
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("\n                    checkLastMessageState: isLastestMessage = ");
            r1.append(this.a.l());
            r1.append(", cid = ");
            r1.append(r5);
            r1.append(", curBlockMessage.conversationId = ");
            Message r2 = this.a.g;
            String r3 = null;
            if (r2 == null) goto L5;
            String r4 = r2.getConversationId();
        L6:
            r1.append(r4);
            r1.append("\n                ");
            r0.i("CheckLastMessageBlockHolder", StringsKt.trimIndent(r1.toString()));
            if (this.a.l() == false) goto L15;
            Message r6 = this.a.g;
            if (r6 == null) goto L12;
            r3 = r6.getConversationId();
        L12:
            if (Intrinsics.areEqual(r5, r3) == false) goto L16;
            this.a.k();
            return;
        L16:
            return;
        L15:
            return;
        L5:
            r4 = null;
            goto L6
        }

        public final void b(String r2, MessageListState r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "state");
            Intrinsics.checkNotNullParameter(r4, "msgList");
            FLogger.a.i("CheckLastMessageBlockHolder", "onMessageListChanged");
            g(r2);
        }

        public final void c(String r2, Message r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
            FLogger.a.i("CheckLastMessageBlockHolder", "onUpdateMessage");
            g(r2);
        }

        public final void e(String r2, Message r3, Map<String, String> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
            FLogger.a.i("CheckLastMessageBlockHolder", "onReceiveMessage");
            g(r2);
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
            FLogger.a.i("CheckLastMessageBlockHolder", "onMessageListReplaced");
            g(r2);
        }
    }

    static {
    }

    public String c() {
        return "CheckLastMessageBlockHolder";
    }

    public abstract void m(boolean r1);

    public void i() {
        FLogger r0 = FLogger.a;
        r0.i("CheckLastMessageBlockHolder", "onViewRecycled");
        if (this.f.compareAndSet(true, false) == false) goto L5;
        r0.i("CheckLastMessageBlockHolder", "unregisterOnGlobalMessageObserver");
        d.e().unregisterOnGlobalMessageObserver((b) this.n.getValue());
    L5:
        Lifecycle r1 = this.j;
        if (r1 == null) goto L8;
        r1.removeObserver(this.m);
    L8:
        Job r2 = this.i;
        if (r2 == null) goto L11;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L11:
        this.i = null;
        this.h.setValue(Boolean.TRUE);
    }

    public final void k() {
        Message r0 = this.g;
        if (r0 != null) goto L6;
        FLogger.a.i("CheckLastMessageBlockHolder", "checkLastMessage: blockMessage is null");
        return;
    L6:
        Job r1 = this.e;
        if (r1 == null) goto L9;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L9:
        this.e = BuildersKt.launch$default(this.d, null, null, new CheckLastMessageBlockHolder$checkLastMessage$1(this, r0, null), 3, null);
    }

    public final boolean l() {
        return ((Boolean) this.h.getValue()).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.assistant.block.base.CheckLastMessageBlockHolder$lifecycleObserver$1] */
    public CheckLastMessageBlockHolder() {
        this.d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.f = new AtomicBoolean(false);
        this.h = j1.a(Boolean.TRUE);
        this.m = new CheckLastMessageBlockHolder$lifecycleObserver$1(this);
        this.n = LazyKt.lazy(new com.obric.assistant.block.base.a(this));
    }

    public jc8.d f(T r2) {
        Intrinsics.checkNotNullParameter(r2, "blockModel");
        return e.d(r2);
    }

    public void g(T r11) {
        Intrinsics.checkNotNullParameter(r11, "blockModel");
        FLogger r0 = FLogger.a;
        r0.i("CheckLastMessageBlockHolder", "onBindBlockView");
        kc8.b r2 = jc8.c.a(this, kc8.b.class);
        if (r2 == null) goto L7;
        y r3 = r2.a;
        if (r3 == null) goto L7;
        Fragment r4 = r3.a;
    L8:
        if (r4 == null) goto L10;
        Lifecycle r5 = r4.getLifecycle();
    L11:
        this.j = r5;
        if (r4 == null) goto L14;
        t1a.b r6 = s1a.a.g(r4);
    L15:
        if (r6 == null) goto L19;
        u7 r7 = r6.getAbility(u7.class);
        if (r7 == null) goto L19;
        MessageAdapter r8 = r7.MF();
    L20:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.larus.bmhome.chat.adapter.IMessageListAdapter<*>");
        this.k = r8;
        if (r6 == null) goto L23;
        m0 r9 = (m0) r6.getAbility(m0.class);
    L24:
        this.l = r9;
        this.g = r11.j();
        Job r12 = this.i;
        if (r12 == null) goto L27;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L27:
        this.i = BuildersKt.launch$default(this.d, null, null, new CheckLastMessageBlockHolder$onBindBlockView$1(this, null), 3, null);
        if (this.f.compareAndSet(false, true) == false) goto L30;
        r0.i("CheckLastMessageBlockHolder", "registerOnGlobalMessageObserver");
        d.e().registerOnGlobalMessageObserver((b) this.n.getValue());
    L30:
        k();
        Lifecycle r13 = this.j;
        if (r13 == null) goto L34;
        r13.addObserver(this.m);
    L34:
        if (this.j != null) goto L37;
        r0.w("CheckLastMessageBlockHolder", "onBindBlockView: lifecycleOwner is null");
        return;
    L37:
        return;
    L23:
        r9 = null;
    L19:
        r8 = null;
        goto L20
    L14:
        r6 = null;
        goto L15
    L10:
        r5 = null;
    L7:
        r4 = null;
        goto L8
    }

    public static final Object j(CheckLastMessageBlockHolder r10, String r11, Continuation r12) {
        r10.getClass();
        if ((r12 instanceof CheckLastMessageBlockHolder$getLastMessage$1) == false) goto L7;
        CheckLastMessageBlockHolder$getLastMessage$1 r0 = (CheckLastMessageBlockHolder$getLastMessage$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L87:
        Message r4 = (Message) r13;
        if (r4 == null) goto L90;
        FLogger.a.i("CheckLastMessageBlockHolder", "getLastMessage from repo " + r4.getMessageId());
        return r4;
    L90:
        FLogger.a.i("CheckLastMessageBlockHolder", "getLastMessage: cvsId = " + r11 + ", not found");
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        i<?> r14 = r10.k;
        if (r14 == null) goto L81;
        List r15 = r14.getMessageList();
        if (r15 == null) goto L81;
        Iterator r16 = r15.iterator();
    L20:
        if (r16.hasNext() == false) goto L77;
        Object r5 = r16.next();
        Message r6 = ((v) r5).a();
        boolean r8 = false;
        if (com.larus.bmhome.chat.bean.d.i0(r6) == false) goto L27;
        if (com.larus.bmhome.chat.bean.d.w(r6) == true) goto L27;
    L46:
        boolean r7 = false;
    L47:
        if (r7 == false) goto L75;
        if (b0.f(r6) == true) goto L75;
        if (com.larus.bmhome.chat.bean.d.O0(r6) == false) goto L69;
        m0 r9 = r10.l;
        if (r9 == null) goto L56;
        int r17 = r9.pD();
    L57:
        if (r17 == 0) goto L72;
        if (r17 != 1) goto L60;
        boolean r18 = com.larus.bmhome.chat.bean.d.k0(r6);
    L73:
        if (r18 == true) goto L75;
        r8 = true;
        goto L75
    L60:
        if (r17 != 2) goto L62;
        r18 = com.larus.bmhome.chat.bean.d.W0(r6);
        goto L73
    L62:
        if (r17 != 3) goto L69;
        if (com.larus.bmhome.chat.bean.d.k0(r6) == true) goto L72;
        if (com.larus.bmhome.chat.bean.d.W0(r6) == false) goto L69;
    L72:
        r18 = true;
        goto L73
    L56:
        r17 = -1;
    L69:
        r18 = false;
    L75:
        if (r8 == false) goto L20;
    L78:
        v r19 = (v) r5;
        if (r19 == null) goto L81;
        Message r110 = r19.a();
    L82:
        if (r110 == null) goto L84;
        FLogger.a.i("CheckLastMessageBlockHolder", "getLastMessage from last message list " + r110.getMessageId());
        return r110;
    L84:
        IChatRepoService r111 = zh8.a.a;
        r0.L$0 = r11;
        r0.label = 1;
        r13 = r111.D1(r11, r0);
        if (r13 != r2) goto L87;
        return r2;
    L27:
        if (com.larus.bmhome.chat.bean.d.T(r6) == true) goto L46;
        if (com.larus.bmhome.chat.bean.d.p0(r6) == true) goto L46;
        if (com.larus.bmhome.chat.bean.d.C0(r6) == true) goto L34;
    L36:
        MessageStatus r20 = r6.getMessageStatus();
        if (r20 != null) goto L39;
    L41:
        boolean r21 = false;
    L42:
        if (r21 == false) goto L44;
    L45:
        r7 = true;
        goto L47
    L44:
        if (b0.f(r6) == false) goto L46;
    L39:
        if (r20.isVisible() != true) goto L41;
        r21 = true;
        goto L42
    L34:
        if (r6.getRegenVisible() == true) goto L36;
    L77:
        r5 = null;
    L81:
        r110 = null;
    L7:
        r0 = new CheckLastMessageBlockHolder$getLastMessage$1(r10, r12);
        goto L8
    }
}
