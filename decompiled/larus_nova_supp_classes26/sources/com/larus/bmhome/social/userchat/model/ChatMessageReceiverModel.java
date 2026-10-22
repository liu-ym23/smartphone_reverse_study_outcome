package com.larus.bmhome.social.userchat.model;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.component.list.ChatListComponentViewModel;
import com.larus.bmhome.chat.i1;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.social.page.datasource.event.ConflatedFlow;
import com.larus.bmhome.social.page.datasource.event.RefreshTraceSource;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.ConversationType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.SuggestQuestion;
import com.larus.im.internal.core.conversation.ConversationReceiverServiceImpl;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.network.http.EvaluateData;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.IAppLaunchReporter;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ChatMessageReceiverModel implements c0 {
    public static final /* synthetic */ int P = 0;
    public final bi8.d.a A;
    public Long B;
    public vr8.g C;
    public boolean D;
    public final HashMap<String, Long> E;
    public final Lazy F;
    public final com.larus.platform.model.chat.c0 G;
    public final Lazy H;
    public final ChatMessageReceiverModel$streamObserver$1 I;
    public final u J;
    public final ChatMessageReceiverModel$messageObserver$1 K;
    public final ConflatedFlow<LoadState> L;
    public final ConflatedFlow<LoadState> M;
    public volatile boolean N;
    public vr8.b O;
    public final CoroutineScope a;
    public final String b;
    public final int c;
    public long d;
    public long e;
    public Function0<wc9.e> f;
    public Function0<BotModel> g;
    public final boolean h;
    public final boolean i;
    public final i1 j;
    public final String k;
    public final ExecutorCoroutineDispatcher l;
    public final NativeMessageServiceImpl m;
    public final CopyOnWriteArrayList<Message> n;
    public final HashMap<String, Message> o;
    public final ConcurrentHashMap<String, Message> p;
    public c q;
    public d r;
    public final CompletableDeferred<Unit> s;
    public final ConversationReceiverServiceImpl t;
    public final es8.c u;
    public final boolean v;
    public Long w;
    public Long x;
    public Long y;
    public final AtomicLong z;

    public static final class a {
        public static long a(List r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            Message r3 = (Message) CollectionsKt.firstOrNull(r2);
            if (r3 != null) goto L7;
            return 0;
        L7:
            return r3.getLocalIndex();
        }
    }

    public static final class b {
        public final long a;
        public final int b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b;
        }

        public final String toString() {
            return "InitialLoadRange(maxIndex=" + this.a + ", messageLimit=" + this.b + ')';
        }

        public b(long r1, int r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public interface c {

        public static final class a {
            public static /* synthetic */ void a(c r1, com.larus.bmhome.social.page.datasource.event.c r2) {
                r1.c(r2, "MessageListChangeListenerDefault");
            }
        }

        void a(boolean r1, List<Message> r2, long r3, boolean r5, Runnable r6, String r7, String r8);

        void b(Runnable r1);

        void c(com.larus.bmhome.social.page.datasource.event.c r1, String r2);
    }

    /* JADX INFO: renamed from: com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$clear$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$clear$1", f = "ChatMessageReceiverModel.kt", i = {}, l = {1720}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ChatMessageReceiverModel this$0;

        public AnonymousClass1(ChatMessageReceiverModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Iterator r2 = (Iterator) this.L$0;
            ResultKt.throwOnFailure(r7);
        L26:
            if (r2.hasNext() == false) goto L31;
            Message r3 = (Message) r2.next();
            IChatRepoService r4 = zh8.a.a;
            u1 r5 = zh8.a.a.u1();
            Intrinsics.checkNotNull(r3);
            this.L$0 = r2;
            this.label = 1;
            if (r5.n(r3, this) != r0) goto L26;
            return r0;
        L31:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CopyOnWriteArrayList<Message> r8 = this.this$0.n;
            ArrayList r6 = new ArrayList();
            Iterator<T> r9 = r8.iterator();
        L10:
            if (r9.hasNext() == false) goto L23;
            Object r10 = r9.next();
            Message r11 = (Message) r10;
            if (r11.getContentType() == 0) goto L14;
        L20:
            boolean r12 = false;
        L21:
            if (r12 == false) goto L10;
            r6.add(r10);
            goto L10
        L14:
            if (r11.getSourceFromAsr() == false) goto L20;
            if (r11.getMessageStatusLocal() != 0) goto L20;
            Intrinsics.checkNotNull(r11);
            if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.j(r11), "is_mock_sending") == false) goto L20;
            r12 = true;
            goto L21
        L23:
            r2 = r6.iterator();
            goto L26
        }
    }

    public interface d {
        void A5(boolean r1);

        void a(Message r1, TtsScene r2);
    }

    static {
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void clear() {
        m(false);
        if (z2.a.M2() == false) goto L5;
        BuildersKt.launch$default(this.a, this.l, null, new ChatMessageReceiverModel$clearMessageData$1(this, null), 2, null);
    L5:
        BuildersKt.launch$default(this.a, null, null, new AnonymousClass1(this, null), 3, null);
        NativeMessageServiceImpl r0 = this.m;
        if (r0 == null) goto L8;
        r0.unregisterOnMessageChangedObserver(this.b, this.K);
    L8:
        this.q = null;
        this.r = null;
        JobKt.cancel$default(this.l, null, 1, null);
        int r1 = com.larus.im.d.a;
        com.larus.im.internal.stream.b r2 = com.larus.im.internal.stream.b.a;
        FLogger.a.i(this.k, "[notifyListChange]: remove observer " + this.b + " model " + hashCode());
        ChatMessageReceiverModel$streamObserver$1 r3 = this.I;
        r2.e(r3.a, r3);
        this.t.unRegisterConversationChangeListener(this.b, this.J);
        this.O = null;
        this.f = null;
        this.g = null;
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final boolean a() {
        Long r0 = this.B;
        if (r0 == null) goto L63;
        long r2 = r0.longValue();
        int r1 = ra9.a.a;
        if (ga9.a.d("insert_visible_message_timestamp_interval", 900) <= 0) goto L62;
        Function0<wc9.e> r3 = this.f;
        Long r5 = null;
        if (r3 == null) goto L9;
        wc9.e r4 = (wc9.e) r3.invoke();
    L11:
        if (ic8.n.D(r4) == false) goto L62;
        if (this.i == true) goto L62;
        CopyOnWriteArrayList<Message> r6 = this.n;
        ListIterator<Message> r7 = r6.listIterator(r6.size());
    L17:
        if (r7.hasPrevious() == false) goto L51;
        Message r8 = r7.previous();
        Message r9 = r8;
        if (r9.getLocalIndex() <= 0) goto L48;
        Intrinsics.checkNotNull(r9);
        if (com.larus.bmhome.chat.bean.d.i0(r9) == false) goto L26;
        if (com.larus.bmhome.chat.bean.d.w(r9) == true) goto L26;
    L45:
        boolean r10 = false;
    L46:
        if (r10 == false) goto L48;
        boolean r11 = true;
    L49:
        if (r11 == false) goto L17;
    L52:
        Message r12 = r8;
        if (r12 == null) goto L55;
        r5 = Long.valueOf(r12.getLocalIndex());
    L55:
        if (r5 != null) goto L58;
    L59:
        m(true);
        return false;
    L58:
        if (r2 != r5.longValue()) goto L59;
        return true;
    L26:
        if (com.larus.bmhome.chat.bean.d.T(r9) == true) goto L45;
        if (com.larus.bmhome.chat.bean.d.p0(r9) == true) goto L45;
        if (com.larus.bmhome.chat.bean.d.C0(r9) == true) goto L33;
    L35:
        MessageStatus r13 = r9.getMessageStatus();
        if (r13 != null) goto L38;
    L40:
        boolean r14 = false;
    L41:
        if (r14 == false) goto L43;
    L44:
        r10 = true;
        goto L46
    L43:
        if (b0.f(r9) == false) goto L45;
    L38:
        if (r13.isVisible() != true) goto L40;
        r14 = true;
        goto L41
    L33:
        if (r9.getRegenVisible() == true) goto L35;
    L48:
        r11 = false;
        goto L49
    L51:
        r8 = null;
        goto L52
    L9:
        r4 = null;
    L62:
        m(true);
    L63:
        return false;
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void c() {
        Iterator<T> r0 = this.n.iterator();
    L4:
        if (r0.hasNext() == false) goto L42;
        Object r1 = r0.next();
        Message r2 = (Message) r1;
        Intrinsics.checkNotNull(r2);
        boolean r4 = true;
        if (com.larus.bmhome.chat.bean.d.i0(r2) == false) goto L11;
        if (com.larus.bmhome.chat.bean.d.w(r2) == true) goto L11;
    L30:
        boolean r3 = false;
    L31:
        if (r3 == true) goto L33;
    L39:
        r4 = false;
    L40:
        if (r4 == false) goto L4;
    L43:
        Message r5 = (Message) r1;
        if (r5 != null) goto L47;
        return;
    L47:
        if (com.larus.bmhome.chat.bean.d.G0(r5) == true) goto L49;
        return;
    L49:
        IChatRepoService r6 = RepoDispatcherDelegate.b.e();
        String r7 = r5.getLocalMessageId();
        if (r7 != null) goto L52;
        r7 = "";
    L52:
        r6.r1(r7, new s());
        return;
    L33:
        if (b0.f(r2) == true) goto L39;
        if (com.larus.bmhome.chat.bean.d.I0(r2) == true) goto L39;
        if (com.larus.bmhome.chat.bean.d.b0(r2) == true) goto L39;
    L11:
        if (com.larus.bmhome.chat.bean.d.T(r2) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.p0(r2) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.C0(r2) == true) goto L18;
    L20:
        MessageStatus r8 = r2.getMessageStatus();
        if (r8 != null) goto L23;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == false) goto L28;
    L29:
        r3 = true;
        goto L31
    L28:
        if (b0.f(r2) == false) goto L30;
    L23:
        if (r8.isVisible() != true) goto L25;
        r9 = true;
        goto L26
    L18:
        if (r2.getRegenVisible() == true) goto L20;
    L42:
        r1 = null;
        goto L43
    }

    public final void o() {
        if (this.p.isEmpty() == false) goto L5;
        return;
    L5:
        if (this.N == false) goto L22;
        com.larus.platform.api.e0 r0 = (com.larus.platform.api.e0) this.H.getValue();
        if (r0 == null) goto L10;
        r0.a();
        Boolean r1 = Boolean.FALSE;
    L12:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L17;
        Iterator<Map.Entry<String, Message>> r2 = this.p.entrySet().iterator();
    L15:
        if (r2.hasNext() == false) goto L18;
        Map.Entry<String, Message> r3 = r2.next();
        q("handlePendingMessage ", r3.getValue());
        i(this, r3.getValue(), "handlePendingMessage", null, null, 24);
    L18:
        this.p.clear();
        return;
    L17:
        FLogger.a.i(this.k, "handlePendingMessage consume = " + r1);
        goto L18
    L10:
        r1 = null;
        goto L12
    }

    public final String s() {
        Message[] r0 = (Message[]) this.n.toArray(new Message[0]);
        Message r1 = (Message) ArraysKt.firstOrNull(r0);
        Message r2 = (Message) ArraysKt.lastOrNull(r0);
        StringBuilder r3 = new StringBuilder("messageList: size=");
        r3.append(r0.length);
        r3.append(" serverIdx[");
        String r4 = null;
        if (r1 == null) goto L5;
        Long r5 = Long.valueOf(r1.getServerIndex());
    L6:
        r3.append(r5);
        r3.append(',');
        if (r2 == null) goto L9;
        Long r6 = Long.valueOf(r2.getServerIndex());
    L10:
        r3.append(r6);
        r3.append("] localIdx=[");
        if (r1 == null) goto L13;
        Long r7 = Long.valueOf(r1.getLocalIndex());
    L14:
        r3.append(r7);
        r3.append(',');
        if (r2 == null) goto L17;
        Long r8 = Long.valueOf(r2.getLocalIndex());
    L18:
        r3.append(r8);
        r3.append("] first=");
        if (r1 == null) goto L21;
        String r9 = r1.getMessageId();
    L22:
        r3.append(r9);
        r3.append(" last=");
        if (r2 == null) goto L25;
        r4 = r2.getMessageId();
    L25:
        r3.append(r4);
        return r3.toString();
    L21:
        r9 = null;
        goto L22
    L17:
        r8 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public static final void h(ChatMessageReceiverModel r5) {
        CopyOnWriteArrayList<Message> r0 = r5.n;
        ArrayList r1 = new ArrayList();
        Iterator<Message> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L15;
        Message r3 = r2.next();
        Message r4 = r3;
        Intrinsics.checkNotNull(r4);
        if (com.larus.bmhome.chat.bean.d.G0(r4) == false) goto L8;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        if (com.larus.im.bean.message.a.Z(r4) == false) goto L12;
        if (com.larus.im.bean.message.a.Y(r4) == false) goto L12;
        r6 = true;
        goto L13
    L15:
        Iterator r7 = r1.iterator();
    L17:
        if (r7.hasNext() == false) goto L22;
        Message r8 = (Message) r7.next();
        IChatRepoService r9 = zh8.a.a;
        String r10 = r8.getLocalMessageId();
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        r9.r1(r10, new j());
        goto L17
    L22:
        FLogger.a.i(r5.k, "checkAndUpdateAvatarBtnState targetMessages' size is " + r1.size());
    }

    public static long x(String r4) {
        long r0 = com.larus.bmhome.social.page.datasource.event.d.b(r4);
        if (r0 >= 0) goto L7;
        return -1;
    L7:
        return System.currentTimeMillis() - r0;
    }

    public static List y(Message r6) {
        String[] r0 = new String[2];
        String r1 = r6.getLocalMessageId();
        String r3 = null;
        boolean r4 = false;
        if (r1 != null) goto L5;
    L13:
        String r2 = null;
    L14:
        r0[0] = r2;
        String r7 = r6.getMessageId();
        if (r7 != null) goto L17;
    L24:
        r0[1] = r3;
        return CollectionsKt.listOfNotNull(r0);
    L17:
        if (r7.length() <= 0) goto L19;
        r4 = true;
    L19:
        if (r4 == true) goto L22;
        r7 = null;
    L22:
        if (r7 == null) goto L24;
        r3 = "server:".concat(r7);
        goto L24
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        r2 = "local:".concat(r1);
        goto L14
    L7:
        r5 = false;
        goto L8
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void E4(Message r8) {
        Intrinsics.checkNotNullParameter(r8, "msg");
        BuildersKt.launch$default(this.a, this.l, null, new ChatMessageReceiverModel$refreshExistedMessage$1(this, r8, null), 2, null);
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final boolean O7(String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return false;
    L12:
        if (this.o.containsKey(r5) == true) goto L31;
        CopyOnWriteArrayList<Message> r3 = this.n;
        if ((r3 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r4 = r3.iterator();
    L20:
        if (r4.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(((Message) r4.next()).getMessageId(), r5) == false) goto L20;
        boolean r6 = true;
    L24:
        if (r6 == true) goto L32;
        return false;
    L32:
        return true;
    L17:
        r6 = false;
        goto L24
    L16:
        if (r3.isEmpty() == false) goto L18;
    L31:
        return true;
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void d(vr8.b r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        if (this.M.a() != LoadState.COMPLETE) goto L7;
        FLogger.a.i("ChatMessageReceiverModel#prependLoad", "message repository is completed, interrupt");
        r10.a(com.larus.bmhome.social.page.datasource.event.e.a.b.a, this.n.size(), true);
        return;
    L7:
        if (this.M.a() != LoadState.LOADING) goto L10;
        FLogger.a.i("ChatMessageReceiverModel#prependLoad", "message repository is loading, interrupt");
        return;
    L10:
        FLogger.a.i("ChatMessageReceiverModel#prependLoad", "message repository try to load more messages");
        BuildersKt.launch$default(this.a, this.l, null, new ChatMessageReceiverModel$prependLoad$1(this, r10, null), 2, null);
    }

    public final boolean k(List<Message> r11) {
        final HashMap r0 = new HashMap();
        w(r0, r11);
        if (AppHost.a.isDebug() == false) goto L21;
        FLogger r1 = FLogger.a;
        String r3 = this.k;
        StringBuilder r4 = new StringBuilder("batchRemoveMessageFromList, removeMsgList ");
        List<Message> r6 = r11;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator<T> r8 = r6.iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        r7.add(((Message) r8.next()).getLocalMessageId());
        goto L6
    L8:
        r4.append(r7);
        r1.i(r3, r4.toString());
        FLogger r2 = FLogger.a;
        String r5 = this.k;
        StringBuilder r9 = new StringBuilder("batchRemoveMessageFromList, messageList ");
        CopyOnWriteArrayList<Message> r10 = this.n;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator<Message> r13 = r10.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        r12.add(r13.next().getLocalMessageId());
        goto L10
    L12:
        r9.append(r12);
        r2.i(r5, r9.toString());
        FLogger r14 = FLogger.a;
        String r15 = this.k;
        StringBuilder r16 = new StringBuilder("batchRemoveMessageFromList, removeMsgList ");
        CopyOnWriteArrayList<Message> r17 = this.n;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<Message> r19 = r17.iterator();
    L14:
        if (r19.hasNext() == false) goto L16;
        r18.add(r19.next().getMessageId());
        goto L14
    L16:
        r16.append(r18);
        r14.i(r15, r16.toString());
        FLogger r20 = FLogger.a;
        String r21 = this.k;
        StringBuilder r22 = new StringBuilder("batchRemoveMessageFromList, messageList ");
        CopyOnWriteArrayList<Message> r23 = this.n;
        ArrayList r24 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10));
        Iterator<Message> r25 = r23.iterator();
    L18:
        if (r25.hasNext() == false) goto L20;
        r24.add(r25.next().getMessageId());
        goto L18
    L20:
        r22.append(r24);
        r20.i(r21, r22.toString());
    L21:
        boolean r26 = CollectionsKt.removeAll(this.n, new n(r0));
        final HashMap r27 = new HashMap();
        List<Message> r110 = r11;
        LinkedHashMap r28 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r110, 10)), 16));
        Iterator<T> r111 = r110.iterator();
    L23:
        if (r111.hasNext() == false) goto L28;
        Message r29 = (Message) r111.next();
        String r30 = r29.getMessageId();
        if (r30 != null) goto L27;
        r30 = "";
    L27:
        r28.put(r30, r29);
        goto L23
    L28:
        r27.putAll(r28);
        boolean r112 = CollectionsKt.removeAll(this.n, new o(r27));
        if (r26 == true) goto L33;
        if (r112 == true) goto L33;
        return false;
    L33:
        return true;
    }

    public final void l(List<Message> r6) {
        if (((ArrayList) r6).size() < 2) goto L12;
        Message r0 = (Message) CollectionsKt.lastOrNull(r6);
        if (r0 == null) goto L7;
        long r1 = r0.getLocalIndex();
    L9:
        if (r1 <= a.a(r6)) goto L13;
        String r2 = this.k;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter("msgList order error", "errorMsg");
        FLogger.a.e(r2, "msgList order error");
        r("checkListOrder ", r6);
        return;
    L13:
        return;
    L7:
        r1 = 0;
        goto L9
    }

    public final void m(boolean r5) {
        Long r0 = this.B;
        vr8.g r1 = this.C;
        vr8.f r2 = null;
        this.B = null;
        this.C = null;
        if (r5 == false) goto L16;
        if (r0 == null) goto L17;
        if (r1 == null) goto L14;
        vr8.b r6 = r1.a.get();
        if ((r6 instanceof vr8.f) == false) goto L9;
        r2 = (vr8.f) r6;
    L9:
        if (r2 == null) goto L14;
        if (r2.d != 2) goto L14;
        r2.d = 0;
        FLogger.a.i("SimplePagingPrefetch", "resume append after visible history boundary invalidated");
    L14:
        FLogger.a.i(this.k, "clear visible history boundary and resume append, index=" + r0);
        return;
    L17:
        return;
    }

    public final boolean p(Message r9) {
        boolean r1 = false;
        if (this.E.isEmpty() == false) goto L5;
        return false;
    L5:
        List r10 = y(r9);
        if (r10.isEmpty() == false) goto L8;
        return false;
    L8:
        long r2 = SystemClock.elapsedRealtime();
        List r11 = r10;
        if ((r11 instanceof Collection) == true) goto L11;
    L13:
        Iterator r0 = r11.iterator();
    L15:
        if (r0.hasNext() == false) goto L26;
        String r4 = (String) r0.next();
        Long r5 = this.E.get(r4);
        if (r5 == null) goto L19;
        long r6 = r5.longValue();
    L21:
        if (r6 <= r2) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L15;
        r1 = true;
        goto L26
    L23:
        r7 = false;
        goto L24
    L19:
        r6 = 0;
    L26:
        if (r1 == true) goto L31;
        Iterator r12 = r11.iterator();
    L29:
        if (r12.hasNext() == false) goto L31;
        String r3 = (String) r12.next();
        this.E.remove(r3);
    L31:
        return r1;
    L11:
        if (r11.isEmpty() == false) goto L13;
        goto L13
    }

    public final Message v(Message r48) {
        HashMap<String, Message> r1 = this.o;
        String r2 = r48.getLocalMessageId();
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        Message r3 = r1.get(r2);
        String r4 = null;
        boolean r5 = false;
        if (r3 != null) goto L28;
        Iterator<T> r6 = this.n.iterator();
    L9:
        if (r6.hasNext() == false) goto L24;
        Object r7 = r6.next();
        Message r8 = (Message) r7;
        if (Intrinsics.areEqual(r8.getMessageId(), r48.getMessageId()) == false) goto L21;
        String r9 = r8.getMessageId();
        if (r9 != null) goto L15;
    L18:
        boolean r10 = true;
    L19:
        if (r10 == true) goto L21;
        boolean r11 = true;
    L22:
        if (r11 == false) goto L9;
    L25:
        r3 = (Message) r7;
        if (r3 != null) goto L28;
        return r48;
    L15:
        if (r9.length() == 0) goto L18;
        r10 = false;
    L21:
        r11 = false;
        goto L22
    L24:
        r7 = null;
    L28:
        int r12 = d0.a;
        String r13 = r48.getMessageId();
        if (r13 != null) goto L31;
    L34:
        boolean r14 = true;
    L35:
        if (r14 == false) goto L37;
    L41:
        boolean r15 = false;
    L42:
        Map r16 = r3.getBusinessExt();
        if (r16 == null) goto L47;
        String r17 = (String) r16.get("im_message_body_version");
        if (r17 == null) goto L47;
        Long r18 = StringsKt.toLongOrNull(r17);
    L48:
        Map r19 = r48.getBusinessExt();
        if (r19 == null) goto L53;
        String r20 = (String) r19.get("im_message_body_version");
        if (r20 == null) goto L53;
        Long r21 = StringsKt.toLongOrNull(r20);
    L54:
        Map r22 = r3.getExt();
        if (r22 == null) goto L57;
        String r23 = (String) r22.get("need_lazy_load");
    L58:
        Map r110 = r48.getExt();
        if (r110 == null) goto L62;
        r4 = (String) r110.get("need_lazy_load");
    L62:
        if (r15 == false) goto L86;
        if (r18 == null) goto L86;
        if (r21 == null) goto L86;
        if (r23 != null) goto L68;
    L73:
        boolean r24 = true;
    L75:
        if (Intrinsics.areEqual(r4, "1") == false) goto L77;
    L80:
        boolean r25 = true;
    L81:
        if (r24 == false) goto L86;
        if (r25 == false) goto L86;
        if (r21.longValue() > r18.longValue()) goto L86;
        r5 = true;
        goto L86
    L77:
        if (Intrinsics.areEqual(r4, "true") == true) goto L80;
        r25 = false;
        goto L81
    L68:
        if (Intrinsics.areEqual(r23, TriggerSendLoading.NO_LOADING) == true) goto L73;
        if (Intrinsics.areEqual(r23, "false") == true) goto L73;
        r24 = false;
    L86:
        if (r5 == true) goto L88;
        return r48;
    L88:
        String r111 = r3.getContent();
        List r112 = r3.getContentBlock();
        String r113 = r3.getThinkingContent();
        int r26 = r3.getContentType();
        boolean r27 = r3.isNewBlockType();
        ReferenceInfo r114 = r3.getReferenceInfo();
        List r40 = r3.getSubList();
        List r41 = r3.getSubListGroup();
        Map r28 = r48.getExt();
        if (r28 != null) goto L91;
        r28 = MapsKt.emptyMap();
    L91:
        Map r46 = MapsKt.plus(r28, TuplesKt.to("need_lazy_load", TriggerSendLoading.NO_LOADING));
        Map r29 = r48.getBusinessExt();
        if (r29 != null) goto L94;
        r29 = MapsKt.emptyMap();
    L94:
        Map r30 = r3.getBusinessExt();
        if (r30 != null) goto L98;
        r30 = MapsKt.emptyMap();
    L98:
        return Message.copy$default(r48, null, null, null, 0, 0, null, r26, r27, null, r111, r112, r113, r114, r46, null, null, 0, 0, false, null, null, null, MapsKt.toMutableMap(MapsKt.plus(r29, TuplesKt.to("im_message_body_version", MapsKt.getValue(r30, "im_message_body_version")))), null, null, 0, false, 0, null, null, false, null, null, 0, r40, r41, null, -4210369, 19, null);
    L57:
        r23 = null;
    L53:
        r21 = null;
    L47:
        r18 = null;
        goto L48
    L37:
        if (Intrinsics.areEqual(r3.getMessageId(), r48.getMessageId()) == false) goto L41;
        if (Intrinsics.areEqual(r3.getConversationId(), r48.getConversationId()) == false) goto L41;
        r15 = true;
        goto L42
    L31:
        if (r13.length() == 0) goto L34;
        r14 = false;
        goto L35
    }

    public final void z(String r6) {
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        int r1 = com.larus.im.d.a;
        com.larus.im.internal.stream.b r2 = com.larus.im.internal.stream.b.a;
        ChatMessageReceiverModel$streamObserver$1 r3 = this.I;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r3.a = r6;
        FLogger.a.i(this.k, "[notifyListChange]: add observer " + r6 + " model " + hashCode());
        r2.b(r6, this.I);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static final void g(ChatMessageReceiverModel r5, String r6) {
        CopyOnWriteArrayList<Message> r0 = r5.n;
        ArrayList r1 = new ArrayList();
        Iterator<Message> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L17;
        Message r3 = r2.next();
        Message r4 = r3;
        Intrinsics.checkNotNull(r4);
        if (com.larus.bmhome.chat.bean.d.G0(r4) == true) goto L14;
        Map r7 = r4.getBusinessExt();
        if (r7 == null) goto L10;
        String r8 = (String) r7.get("common_button_v2_scene_audio");
    L12:
        if (Intrinsics.areEqual(r8, "true") == false) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == false) goto L4;
        r1.add(r3);
        goto L4
    L10:
        r8 = null;
    L14:
        r9 = false;
        goto L15
    L17:
        Iterator r10 = r1.iterator();
    L19:
        if (r10.hasNext() == false) goto L24;
        Message r11 = (Message) r10.next();
        IChatRepoService r12 = zh8.a.a;
        String r13 = r11.getLocalMessageId();
        if (r13 != null) goto L23;
        r13 = "";
    L23:
        r12.r1(r13, new k());
        goto L19
    L24:
        FLogger.a.i(r5.k, "[checkAndUpdateAudioBtnLastMsgState] " + r6 + " targetMessages' size is " + r1.size());
    }

    public static void w(HashMap r3, List r4) {
        List r5 = r4;
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r5, 10)), 16));
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Message r0 = (Message) r6.next();
        String r2 = r0.getLocalMessageId();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r1.put(r2, r0);
        goto L4
    L9:
        r3.putAll(r1);
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void b(vr8.b r11, Integer r12) {
        Intrinsics.checkNotNullParameter(r11, "callback");
        FLogger r0 = FLogger.a;
        r0.i(this.k, "loadMore conversationId " + this.b + "  ");
        if (this.L.a() != LoadState.COMPLETE) goto L7;
        r0.i("ChatMessageReceiverModel#appendLoad", "message repository is completed, interrupt");
        r11.a(com.larus.bmhome.social.page.datasource.event.e.a.C0035a.a, this.n.size(), true);
        return;
    L7:
        if (this.L.a() != LoadState.LOADING) goto L10;
        r0.i("ChatMessageReceiverModel#appendLoad", "message repository is loading, interrupt");
        return;
    L10:
        r0.i("ChatMessageReceiverModel#appendLoad", "message repository try to load more messages, messageListSize: " + this.n.size());
        BuildersKt.launch$default(this.a, this.l, null, new ChatMessageReceiverModel$appendLoad$1(this, r11, r12, null), 2, null);
    }

    public final void q(String r8, Message r9) {
        FLogger r0 = FLogger.a;
        r0.i(this.k, r8 + " messageId=" + r9.getMessageId() + " localMessageId=" + r9.getLocalMessageId() + " localIndex=" + r9.getLocalIndex() + " contentType=" + r9.getContentType() + " messageStatusLocal=" + r9.getMessageStatusLocal());
        if (AppHost.a.isDebug() == false) goto L14;
        String r1 = this.k;
        StringBuilder r2 = new StringBuilder();
        r2.append(r8);
        r2.append(" localMessageContent   ");
        Intrinsics.checkNotNullParameter(r9, "<this>");
        r2.append(com.larus.im.internal.utils.l.d(r9.getContent()));
        r2.append("  ");
        r0.i(r1, r2.toString());
        r0.i(this.k, r8 + " ext   " + com.larus.bmhome.utils.f.a(r9) + "  ");
        String r3 = this.k;
        StringBuilder r4 = new StringBuilder();
        r4.append(r8);
        r4.append(" suggestquestions  ");
        List r5 = r9.getSuggestQuestions();
        if (r5 == null) goto L10;
        List r6 = r5;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r10 = r6.iterator();
    L8:
        if (r10.hasNext() == false) goto L11;
        SuggestQuestion r11 = (SuggestQuestion) r10.next();
        Intrinsics.checkNotNullParameter(r11, "<this>");
        r7.add(com.larus.im.internal.utils.l.c(r11.content));
    L11:
        r4.append(r7);
        r0.i(r3, r4.toString());
        FLogger.a.i(this.k, r8 + " businessExt  " + r9.getBusinessExt() + ' ');
        return;
    L10:
        r7 = null;
        goto L11
    }

    public final void r(String r10, List<Message> r11) {
        FLogger r0 = FLogger.a;
        r0.i(this.k, r10 + "  size " + r11.size() + ' ');
        String r1 = this.k;
        StringBuilder r2 = new StringBuilder();
        r2.append(r10);
        r2.append("  localMessageId ");
        List<Message> r12 = r11;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r6 = r12.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r4.add(((Message) r6.next()).getLocalMessageId());
        goto L4
    L6:
        r2.append(r4);
        r0.i(r1, r2.toString());
        FLogger r3 = FLogger.a;
        String r5 = this.k;
        StringBuilder r7 = new StringBuilder();
        r7.append(r10);
        r7.append("  messageId ");
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r9 = r12.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        r8.add(((Message) r9.next()).getMessageId());
        goto L8
    L10:
        r7.append(r8);
        r3.i(r5, r7.toString());
        FLogger r13 = FLogger.a;
        String r14 = this.k;
        StringBuilder r15 = new StringBuilder();
        r15.append(r10);
        r15.append(" localMessageIndex   ");
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r17 = r12.iterator();
    L12:
        if (r17.hasNext() == false) goto L14;
        r16.add(Long.valueOf(((Message) r17.next()).getLocalIndex()));
        goto L12
    L14:
        r15.append(r16);
        r13.i(r14, r15.toString());
        FLogger r18 = FLogger.a;
        String r19 = this.k;
        StringBuilder r20 = new StringBuilder();
        r20.append(r10);
        r20.append(" localMessageContentType   ");
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r22 = r12.iterator();
    L16:
        if (r22.hasNext() == false) goto L18;
        r21.add(Integer.valueOf(((Message) r22.next()).getContentType()));
        goto L16
    L18:
        r20.append(r21);
        r20.append(' ');
        r18.i(r19, r20.toString());
        if (AppHost.a.isDebug() == false) goto L46;
        FLogger r23 = FLogger.a;
        String r24 = this.k;
        StringBuilder r25 = new StringBuilder();
        r25.append(r10);
        r25.append(" localMessageContent   ");
        ArrayList r26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r27 = r12.iterator();
    L22:
        if (r27.hasNext() == false) goto L24;
        Message r28 = (Message) r27.next();
        Intrinsics.checkNotNullParameter(r28, "<this>");
        r26.add(com.larus.im.internal.utils.l.d(r28.getContent()));
        goto L22
    L24:
        r25.append(r26);
        r25.append(' ');
        r23.i(r24, r25.toString());
        FLogger r29 = FLogger.a;
        String r30 = this.k;
        StringBuilder r31 = new StringBuilder();
        r31.append(r10);
        r31.append(" ext  ");
        ArrayList r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r33 = r12.iterator();
    L26:
        if (r33.hasNext() == false) goto L28;
        r32.add(com.larus.bmhome.utils.f.a((Message) r33.next()));
        goto L26
    L28:
        r31.append(r32);
        r31.append(' ');
        r29.i(r30, r31.toString());
        FLogger r34 = FLogger.a;
        String r35 = this.k;
        StringBuilder r36 = new StringBuilder();
        r36.append(r10);
        r36.append(" suggestquestions  ");
        ArrayList r37 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r38 = r12.iterator();
    L30:
        if (r38.hasNext() == false) goto L32;
        r37.add(com.larus.im.internal.utils.l.h(((Message) r38.next()).getSuggestQuestions()));
        goto L30
    L32:
        r36.append(r37);
        r36.append(' ');
        r34.i(r35, r36.toString());
        FLogger r39 = FLogger.a;
        String r40 = this.k;
        StringBuilder r41 = new StringBuilder();
        r41.append(r10);
        r41.append(" businessExt  ");
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r111 = r12.iterator();
    L34:
        if (r111.hasNext() == false) goto L36;
        r110.add(((Message) r111.next()).getBusinessExt());
        goto L34
    L36:
        r41.append(r110);
        r41.append(' ');
        r39.i(r40, r41.toString());
        return;
    }

    public final boolean A(Message r9, RefreshTraceSource r10, String r11) {
        if (this.o.containsKey(r9.getLocalMessageId()) == false) goto L15;
        Iterator<Message> r0 = this.n.iterator();
        int r2 = 0;
    L6:
        if (r0.hasNext() == false) goto L11;
        if (Intrinsics.areEqual(r0.next().getLocalMessageId(), r9.getLocalMessageId()) == true) goto L12;
        r2 = r2 + 1;
    L12:
        if (r2 < 0) goto L15;
        this.n.remove(r2);
        HashMap<String, Message> r1 = this.o;
        String r12 = r9.getLocalMessageId();
        TypeIntrinsics.asMutableMap(r1).remove(r12);
        FLogger.a.v(this.k, "#removeMessage");
        u(this, null, "removeMessage", r11, r10, 3);
        return true;
    L11:
        r2 = -1;
    L15:
        return false;
    }

    public final boolean B(List<Message> r5, RefreshTraceSource r6, String r7) {
        if (r7.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r7 = com.larus.bmhome.social.page.datasource.event.d.a(r6);
    L8:
        Iterator<T> r8 = r5.iterator();
    L9:
        boolean r1 = false;
    L11:
        if (r8.hasNext() == false) goto L16;
        if (A((Message) r8.next(), r6, r7) == true) goto L15;
        if (r1 == false) goto L9;
    L15:
        r1 = true;
        goto L11
    L16:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.bmhome.social.userchat.model.c0
    public final void e(ChatListComponentViewModel.ChatListMessageChangeListener r24, d r25, long r26, CoroutineScope r28) {
        Intrinsics.checkNotNullParameter(r24, "listener");
        FLogger r3 = FLogger.a;
        String r4 = com.larus.network.http.d.a;
        r3.i("CloudTest", "cloudTestInit " + com.larus.network.http.d.a());
        String r6 = null;
        if (com.larus.network.http.d.a() == false) goto L37;
        Intrinsics.checkNotNullParameter(r24, "listener");
        this.q = r24;
        this.r = r25;
        EvaluateData r0 = (EvaluateData) GsonProtectorUtils.fromJson(HttpExtKt.f, com.larus.network.http.d.a, EvaluateData.class);
        StringBuilder r1 = new StringBuilder("DataPlaybackFetcher cloudTestInit messageList = ");
        if (r0 == null) goto L7;
        List r2 = r0.getEncryption_message_id_list();
    L8:
        if (r2 != null) goto L10;
        r2 = CollectionsKt.emptyList();
    L10:
        r1.append(r2);
        r1.append(" fromdate=");
        if (r0 == null) goto L13;
        String r5 = r0.getFrom_date();
    L14:
        r1.append(r5);
        r1.append(" todate=");
        if (r0 == null) goto L17;
        String r7 = r0.getTo_date();
    L18:
        r1.append(r7);
        r3.i("CloudTest", r1.toString());
        a0 r17 = new a0();
        if (r0 == null) goto L21;
        List r8 = r0.getEncryption_message_id_list();
    L22:
        if (r8 != null) goto L24;
        r8 = CollectionsKt.emptyList();
    L24:
        if (r0 == null) goto L26;
        String r9 = r0.getFrom_date();
    L27:
        String r10 = "";
        if (r9 != null) goto L30;
        r9 = "";
    L30:
        if (r0 == null) goto L32;
        r6 = r0.getTo_date();
    L32:
        if (r6 == null) goto L35;
        r10 = r6;
    L35:
        Function1 r11 = new t(this);
        Intrinsics.checkNotNullParameter(r8, "messageList");
        Intrinsics.checkNotNullParameter(r9, "fromDate");
        Intrinsics.checkNotNullParameter(r10, "toDate");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DataPlaybackFetcher$initMessageList$1(CollectionsKt.chunked(r8, 50), r17, r9, r10, new ArrayList(), r11, null), 2, null);
        z(this.b);
        this.t.registerConversationChangeListener(this.b, this.J);
        return;
    L26:
        r9 = null;
        goto L27
    L21:
        r8 = null;
        goto L22
    L17:
        r7 = null;
        goto L18
    L13:
        r5 = null;
        goto L14
    L7:
        r2 = null;
        goto L8
    L37:
        IAppLaunchReporter r12 = (IAppLaunchReporter) ServiceManager.get().getService(IAppLaunchReporter.class);
        if (r12 == null) goto L40;
        r12.c("load_message_from_db", null);
    L40:
        this.q = r24;
        this.r = r25;
        String r13 = this.b;
        NativeMessageServiceImpl r14 = this.m;
        if (r14 == null) goto L43;
        r14.registerOnMessageChangedObserver(r13, this.K);
    L43:
        z(this.b);
        if (r26 > 0) goto L46;
        b r15 = new b(Long.MAX_VALUE, RangesKt.coerceAtLeast((int) (this.d - this.e), this.G.a()));
    L47:
        if (r26 <= 0) goto L49;
        r3.i(this.k, "is local search model! anchor=" + r26 + " maxIndex=" + r15.a + " limit=" + r15.b);
    L49:
        String r16 = this.b;
        int r18 = this.c;
        long r19 = r15.a;
        if (r26 <= 0) goto L52;
        boolean r20 = true;
    L53:
        n(this, r16, r18, r19, r20, r15.b, r26, null, null, null, true, 448);
        this.t.registerConversationChangeListener(this.b, this.J);
        return;
    L52:
        r20 = false;
        goto L53
    L46:
        int r21 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(this.G.a(), 1) * 2, RangesKt.coerceAtLeast(this.G.c(), 1));
        r15 = new b((((long) (RangesKt.coerceAtLeast(r21 / 2, 1) + 1)) * 1000) + r26, r21);
        goto L47
    }

    public static final void f(ChatMessageReceiverModel r7, Message r8, String r9, RefreshTraceSource r10, String r11) {
        r7.getClass();
        dh8.b r0 = dh8.b.a;
        Iterator<Message> r1 = r7.n.iterator();
    L3:
        Boolean r3 = null;
        if (r1.hasNext() == false) goto L8;
        Message r2 = r1.next();
        if (Intrinsics.areEqual(r2.getLocalMessageId(), r8.getLocalMessageId()) == false) goto L3;
    L9:
        r0.getClass();
        dh8.b.l(r8, r2);
        if (r7.p(r8) == true) goto L35;
        com.larus.platform.api.e0 r4 = (com.larus.platform.api.e0) r7.H.getValue();
        if (r4 == null) goto L15;
        r4.c();
        r3 = Boolean.FALSE;
    L15:
        boolean r5 = true;
        if ((!r7.N) == true) goto L18;
    L29:
        r7.q(r9.concat("  "), r8);
        i(r7, r8, r9, r10, r11, 4);
        return;
    L18:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L29;
        r7.q(r9.concat(" pending "), r8);
        if (r11.length() > 0) goto L23;
        r5 = false;
    L23:
        if (r5 == false) goto L25;
        FLogger.a.w("MsgRefreshFlow_ChatMessageReceiverModel", "refreshTrace end=deferred rt=" + r11 + " source=" + r9 + " cost=" + x(r11));
    L25:
        ConcurrentHashMap<String, Message> r12 = r7.p;
        String r13 = r8.getLocalMessageId();
        if (r13 != null) goto L28;
        r13 = "";
    L28:
        r12.put(r13, r8);
        return;
    L35:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void t(boolean r10, Runnable r11, String r12, String r13, RefreshTraceSource r14) {
        if (r13.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r13 = com.larus.bmhome.social.page.datasource.event.d.a(r14);
    L8:
        String r1 = r13;
        BuildersKt.launch$default(this.a, this.l, null, new ChatMessageReceiverModel$notifyListChange$1(r1, this, r12, r10, r11, null), 2, null);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public static void i(ChatMessageReceiverModel r17, Message r18, String r19, RefreshTraceSource r20, String r21, int r22) {
        int r4 = 0;
        if ((r22 & 4) == 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r22 & 8) == 0) goto L9;
        RefreshTraceSource r5 = RefreshTraceSource.UNKNOWN;
    L10:
        String r7 = "";
        if ((r22 & 16) == 0) goto L13;
        String r6 = "";
    L14:
        Message r8 = r17.v(r18);
        int r10 = -1;
        if (r17.o.containsKey(r8.getLocalMessageId()) == false) goto L43;
        Message r9 = r17.o.get(r8.getLocalMessageId());
        if (r9 != null) goto L19;
    L21:
        boolean r11 = false;
    L22:
        if (r11 == false) goto L41;
        Iterator<Message> r3 = r17.n.iterator();
    L25:
        if (r3.hasNext() == false) goto L30;
        if (Intrinsics.areEqual(r3.next().getLocalMessageId(), r8.getLocalMessageId()) == true) goto L28;
        r4 = r4 + 1;
        goto L25
    L28:
        r10 = r4;
    L30:
        if (r10 >= 0) goto L32;
    L34:
        HashMap<String, Message> r12 = r17.o;
        String r13 = r8.getLocalMessageId();
        if (r13 == null) goto L38;
        r7 = r13;
    L38:
        r12.put(r7, r8);
        if (r2 == false) goto L115;
        u(r17, null, r19.concat("_addOrUpdateMessage in messageMap"), r6, r5, 3);
        return;
    L115:
        return;
    L32:
        if (r10 >= r17.n.size()) goto L34;
        r17.n.set(r10, r8);
        goto L34
    L41:
        r17.A(r8, r5, r6);
        goto L43
    L19:
        if (r9.getLocalIndex() != r8.getLocalIndex()) goto L21;
        r11 = true;
    L43:
        if (o0.d(r8.getMessageId()) == false) goto L71;
        HashMap<String, Message> r14 = r17.o;
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator<Map.Entry<String, Message>> r16 = r14.entrySet().iterator();
    L46:
        if (r16.hasNext() == false) goto L51;
        Map.Entry<String, Message> r110 = r16.next();
        if (Intrinsics.areEqual(r110.getValue().getMessageId(), r8.getMessageId()) == false) goto L46;
        r15.put(r110.getKey(), r110.getValue());
        goto L46
    L51:
        if (((Message) CollectionsKt.firstOrNull(r15.values())) == null) goto L71;
        Iterator<Message> r23 = r17.n.iterator();
    L54:
        if (r23.hasNext() == false) goto L59;
        if (Intrinsics.areEqual(r23.next().getMessageId(), r8.getMessageId()) == true) goto L57;
        r4 = r4 + 1;
        goto L54
    L57:
        r10 = r4;
    L59:
        if (r10 >= 0) goto L61;
    L63:
        HashMap<String, Message> r24 = r17.o;
        String r25 = r8.getLocalMessageId();
        if (r25 == null) goto L67;
        r7 = r25;
    L67:
        r24.put(r7, r8);
        if (r2 == false) goto L117;
        u(r17, null, r19.concat("saas_addOrUpdateMessage in messageMap"), r6, r5, 3);
        return;
    L117:
        return;
    L61:
        if (r10 >= r17.n.size()) goto L63;
        r17.n.set(r10, r8);
    L71:
        if (r17.n.isEmpty() == true) goto L96;
        long r111 = r8.getLocalIndex();
        Message r26 = (Message) CollectionsKt.firstOrNull(r17.n);
        if (r26 == null) goto L75;
        long r112 = r26.getLocalIndex();
    L77:
        if (r111 >= r112) goto L96;
        if (CollectionsKt.last(r17.n) != null) goto L82;
    L84:
        Iterator<Message> r27 = r17.n.iterator();
        int r113 = 0;
    L86:
        if (r27.hasNext() == false) goto L94;
        if (r27.next().getLocalIndex() >= r8.getLocalIndex()) goto L90;
        boolean r114 = true;
    L91:
        if (r114 == true) goto L92;
        r113 = r113 + 1;
        goto L86
    L92:
        r10 = r113;
        goto L94
    L90:
        r114 = false;
    L94:
        if (r10 < 0) goto L96;
        r4 = r10;
        goto L96
    L82:
        if (((Message) CollectionsKt.last(r17.n)).getLocalIndex() <= r8.getLocalIndex()) goto L84;
        r4 = r17.n.size();
        goto L96
    L75:
        r112 = -1;
    L96:
        r17.n.add(r4, r8);
        HashMap<String, Message> r28 = r17.o;
        String r29 = r8.getLocalMessageId();
        if (r29 == null) goto L100;
        r7 = r29;
    L100:
        r28.put(r7, r8);
        FLogger.a.i(r17.k, "addOrUpdateMessage source=" + r19 + " msg=" + r8.getMessageId() + " index=" + r8.getLocalIndex() + " newMsgIndex=" + r4 + " notify=" + r2 + ' ' + r17.s());
        IAIChatService.a.c8(r8.getLocalMessageId(), "start_notify_at_receiver_model", SystemClock.elapsedRealtime());
        if (r2 == false) goto L119;
        u(r17, null, r19.concat("_addOrUpdateMessage not in messageMap"), r6, r5, 3);
        return;
    L119:
        return;
    L13:
        r6 = r21;
        goto L14
    L9:
        r5 = r20;
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    public static /* synthetic */ void u(ChatMessageReceiverModel r4, Runnable r5, String r6, String r7, RefreshTraceSource r8, int r9) {
        if ((r9 & 2) == 0) goto L5;
        r5 = null;
    L5:
        Runnable r1 = r5;
        if ((r9 & 4) == 0) goto L8;
        r6 = "notifyListChangeDefault";
    L8:
        String r2 = r6;
        if ((r9 & 8) == 0) goto L11;
        r7 = "";
    L11:
        String r3 = r7;
        if ((r9 & 16) == 0) goto L14;
        r8 = RefreshTraceSource.UNKNOWN;
    L14:
        r4.t(false, r1, r2, r3, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel] */
    public static void j(ChatMessageReceiverModel r21, int r22, List r23, boolean r24, v r25, String r26, RefreshTraceSource r27, int r28) {
        int r3 = 0;
        if ((r28 & 4) == 0) goto L5;
        boolean r2 = false;
    L6:
        String r5 = null;
        if ((r28 & 8) == 0) goto L9;
        v r4 = null;
    L11:
        if ((r28 & 16) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r28 & 32) == 0) goto L17;
        RefreshTraceSource r8 = RefreshTraceSource.UNKNOWN;
    L19:
        if (r21.E.isEmpty() == false) goto L21;
        ?? r10 = r23;
    L27:
        Iterable r11 = (Iterable) r10;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r12 = r11.iterator();
    L29:
        if (r12.hasNext() == false) goto L31;
        r9.add(r21.v((Message) r12.next()));
        goto L29
    L31:
        r21.l(r9);
        if (r9.isEmpty() == false) goto L46;
        if (r2 == false) goto L43;
        if (r6.length() <= 0) goto L37;
        r3 = 1;
    L37:
        if (r3 == 0) goto L39;
        FLogger.a.w("MsgRefreshFlow_ChatMessageReceiverModel", "refreshTrace end=no_data_change rt=" + r6 + " source=" + r8 + " cost=" + x(r6));
    L39:
        c r0 = r21.q;
        if (r0 == null) goto L163;
        r0.b(r4);
        return;
    L163:
        return;
    L43:
        if (r21.a() == false) goto L165;
        u(r21, r4, "visibleHistoryBoundary", r6, r8, 1);
        return;
    L165:
        return;
    L46:
        if (r21.n.isEmpty() == false) goto L48;
        r21.u.d(r9);
        r21.n.addAll(r9);
        w(r21.o, r9);
        r21.o();
        r21.t(true, r4, "addOrUpdateMessageList", r6, r8);
        return;
    L48:
        if (r22 == 0) goto L79;
        if (r22 != 1) goto L169;
        r21.r("before remove msgList ", r21.n);
        boolean r1 = r21.k(r9);
        FLogger.a.i(r21.k, "addOrUpdateDiscreteMessageList hasItemRemoved " + r1);
        ArrayList r7 = new ArrayList();
        int r13 = 0;
    L53:
        if (r3 >= r21.n.size()) goto L61;
        if (r13 >= r9.size()) goto L61;
        if (r21.n.get(r3).getLocalIndex() > ((Message) ListProtector.get(r9, r13)).getLocalIndex()) goto L58;
        r7.add(ListProtector.get(r9, r13));
        r13 = r13 + 1;
        goto L53
    L58:
        r7.add(r21.n.get(r3));
        r3 = r3 + 1;
    L61:
        if (r3 >= r21.n.size()) goto L64;
        CopyOnWriteArrayList<Message> r14 = r21.n;
        r7.addAll(new ArrayList(r14.subList(r3, r14.size())));
    L64:
        if (r13 >= r9.size()) goto L67;
        r7.addAll(new ArrayList(r9.subList(r13, r9.size())));
    L67:
        if (ObricTtsControlDelegate.b.e() == false) goto L77;
        Message r15 = (Message) CollectionsKt.firstOrNull(r7);
        if (r15 == null) goto L74;
        Map r16 = r15.getExt();
        if (r16 == null) goto L74;
        r5 = (String) r16.get("o_task_type");
    L74:
        if (Intrinsics.areEqual(r5, "complex_task") == false) goto L76;
        FLogger.a.i(r21.k, "[TTS] skip updateTTSRecord for complex task with tts");
    L78:
        r21.n.clear();
        r21.n.addAll(r7);
        r21.r("after remove msgList ", r21.n);
        r21.o.clear();
        w(r21.o, r21.n);
        r21.o();
        u(r21, null, "addOrUpdateDiscreteMessageList", r6, r8, 3);
        return;
    L76:
        r21.u.d(r7);
        goto L78
    L77:
        r21.u.d(r7);
        goto L78
    L169:
        return;
    L79:
        boolean r17 = r21.k(r9);
        FLogger.a.v(r21.k, "addOrUpdateContinuousMessageList hasItemRemoved " + r17);
        r21.u.d(r9);
        Message r18 = (Message) CollectionsKt.lastOrNull(r9);
        long r19 = 0;
        if (r18 == null) goto L82;
        long r20 = r18.getLocalIndex();
    L83:
        long r110 = a.a(r9);
        Message r29 = (Message) CollectionsKt.lastOrNull(r21.n);
        if (r29 == null) goto L86;
        r19 = r29.getLocalIndex();
    L86:
        RefreshTraceSource r111 = r8;
        long r30 = a.a(r21.n);
        if (r110 >= r19) goto L90;
        r21.n.addAll(r9);
        w(r21.o, r9);
    L92:
        r30 = r30;
        r110 = r110;
    L141:
        r21.o();
        u(r21, r4, "addOrUpdateContinuousMessageList", r6, r111, 1);
        FLogger.a.i(r21.k, "#addOrUpdateContinuousMessageList  minIdx:" + r19 + "->" + r20 + " maxIdx:" + r30 + "->" + r110 + ' ' + r21.s());
        return;
    L90:
        if (r20 <= r30) goto L93;
        r21.n.addAll(0, r9);
        w(r21.o, r9);
        goto L92
    L93:
        Iterator<Message> r31 = r21.n.iterator();
        int r112 = 0;
    L94:
        int r113 = -1;
        if (r31.hasNext() == false) goto L103;
        if (r31.next().getLocalIndex() > r110) goto L99;
        boolean r114 = true;
    L100:
        if (r114 == true) goto L101;
        r112 = r112 + 1;
        goto L94
    L101:
        int r32 = r112;
    L104:
        CopyOnWriteArrayList<Message> r33 = r21.n;
        ListIterator<Message> r34 = r33.listIterator(r33.size());
    L106:
        if (r34.hasPrevious() == false) goto L113;
        if (r34.previous().getLocalIndex() < r20) goto L110;
        boolean r115 = true;
    L111:
        if (r115 == false) goto L106;
        r113 = r34.nextIndex();
        goto L113
    L110:
        r115 = false;
    L113:
        int r116 = r113 + 1;
        if (r32 > 0) goto L116;
    L118:
        Collection<? extends Message> r35 = CollectionsKt.emptyList();
    L119:
        if (r116 >= 0) goto L121;
    L123:
        Collection<? extends Message> r117 = CollectionsKt.emptyList();
    L125:
        if (AppHost.a.isDebug() == false) goto L140;
        if (r32 >= 0) goto L128;
    L130:
        boolean r36 = false;
    L131:
        if (r36 == false) goto L140;
        if (1 <= r116) goto L135;
    L137:
        boolean r118 = false;
    L138:
        if (r118 == false) goto L140;
        r21.r("oldReplaced ", new ArrayList(r21.n.subList(r32, r116)));
        r21.r("new msglist", r9);
        goto L140
    L135:
        if (r116 > r21.n.size()) goto L137;
        r118 = true;
        goto L138
    L128:
        if (r32 >= r21.n.size()) goto L130;
        r36 = true;
    L140:
        r21.n.clear();
        r21.n.addAll(r35);
        r21.n.addAll(r9);
        r21.n.addAll(r117);
        r21.o.clear();
        w(r21.o, r21.n);
        goto L141
    L121:
        if (r116 >= r21.n.size()) goto L123;
        CopyOnWriteArrayList<Message> r119 = r21.n;
        r117 = new ArrayList(r119.subList(r116, r119.size()));
        goto L125
    L116:
        if (r32 >= r21.n.size()) goto L118;
        r35 = new ArrayList(r21.n.subList(0, r32));
        goto L119
    L99:
        r114 = false;
        goto L100
    L103:
        r32 = -1;
        goto L104
    L82:
        r20 = 0;
        goto L83
    L21:
        r10 = new ArrayList();
        Iterator r37 = r23.iterator();
    L23:
        if (r37.hasNext() == false) goto L27;
        Object r120 = r37.next();
        if (r21.p((Message) r120) == true) goto L23;
        r10.add(r120);
        goto L23
    L17:
        r8 = r27;
        goto L19
    L13:
        r6 = r26;
        goto L15
    L9:
        r4 = r25;
        goto L11
    L5:
        r2 = r24;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v26, types: [com.larus.bmhome.social.userchat.model.ChatMessageReceiverModel$messageObserver$1] */
    public ChatMessageReceiverModel(CoroutineScope r2, String r3, @ConversationType int r4, long r5, long r7, Function0 r9, Function0 r10, boolean r11, boolean r12, i1 r13) {
        Intrinsics.checkNotNullParameter(r2, "viewModelScope");
        Intrinsics.checkNotNullParameter(r3, "conversationId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = "ChatMessageReceiverModel_" + hashCode();
        this.l = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new p()));
        NativeMessageServiceImpl r6 = com.larus.im.d.e();
        Intrinsics.checkNotNull(r6);
        this.m = r6;
        this.n = new CopyOnWriteArrayList();
        this.o = new HashMap();
        this.p = new ConcurrentHashMap();
        boolean r8 = true;
        this.s = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.t = com.larus.im.d.c();
        this.u = new es8.c();
        if (com.larus.platform.exp.h.a == true) goto L5;
    L7:
        r8 = false;
    L8:
        this.v = r8;
        this.z = new AtomicLong(0);
        this.A = new bi8.d.a();
        this.E = new HashMap();
        this.F = LazyKt.lazy(new q());
        this.G = z2.a.E();
        this.H = LazyKt.lazy(new r());
        this.I = new ChatMessageReceiverModel$streamObserver$1(this);
        this.J = new u(this);
        this.K = new ChatMessageReceiverModel$messageObserver$1(this);
        LoadState r14 = LoadState.READY_TO_LOAD;
        this.L = new ConflatedFlow(r14);
        this.M = new ConflatedFlow(r14);
        return;
    L5:
        if (z2.a.enableTtsWhenStreaming() == false) goto L7;
        goto L7
    }

    public static void n(final ChatMessageReceiverModel r29, final String r30, final int r31, final long r32, boolean r34, final int r35, long r36, com.larus.bmhome.social.page.datasource.event.e.a r38, vr8.b r39, ConflatedFlow r40, boolean r41, int r42) {
        if ((r42 & 8) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r42 & 32) == 0) goto L9;
        long r19 = -1;
    L11:
        if ((r42 & 64) == 0) goto L13;
        com.larus.bmhome.social.page.datasource.event.e r15 = new com.larus.bmhome.social.page.datasource.event.e.b(false);
    L15:
        if ((r42 & 128) == 0) goto L17;
        vr8.b r21 = null;
    L19:
        if ((r42 & 256) == 0) goto L21;
        ConflatedFlow r22 = r29.L;
    L23:
        if ((r42 & 512) == 0) goto L25;
        boolean r0 = false;
    L26:
        r29.getClass();
        if (r32 == Long.MAX_VALUE) goto L31;
        if (r1 == true) goto L31;
        boolean r23 = false;
    L32:
        if (r23 == true) goto L34;
        long r7 = r29.z.get();
    L38:
        final long r13 = r7;
        FLogger r5 = FLogger.a;
        r5.i(r29.k, "getMessageList, cvsId:" + r30 + ",maxIndex:" + r32 + ",isAnchorRoute:" + r1 + ",messageLimit:" + r35 + ",operation:" + r15 + ",isFromInit:" + r0 + ",cursorGeneration:" + r13 + "; " + r29.s());
        if (r35 <= r29.G.c()) goto L41;
        r5.i(r29.k, "current message limit exceed maxLimit");
        final int r6 = r29.G.c();
    L42:
        final com.larus.bmhome.social.page.datasource.event.e r28 = r15;
        final MessageListRequest r8 = new MessageListRequest(r30, r31, 0, r6, r32, null, !com.larus.platform.exp.c.f, 36, null);
        final boolean r9 = r0;
        final boolean r10 = r1;
        final boolean r12 = r23;
        final ConflatedFlow r14 = r22;
        final long r16 = r19;
        final vr8.b r17 = r21;
        Runnable r24 = new l(r28, r29, r32, r6, r9, r8, r10, r13, r30, r12, r14, r16, r35, r17, r31);
        if (r23 == false) goto L45;
        CompletableDeferred<Boolean> r2 = wr8.d.a;
        wr8.d.b.c("do not preload, invoke online task");
    L45:
        r24.run();
        return;
    L41:
        r6 = r35;
        goto L42
    L34:
        if (com.larus.platform.exp.p.e == false) goto L36;
        r29.y = null;
    L36:
        r29.x = null;
        r29.w = null;
        ConflatedFlow<LoadState> r11 = r29.L;
        LoadState r18 = LoadState.READY_TO_LOAD;
        r11.b(r18);
        r29.M.b(r18);
        r7 = r29.z.incrementAndGet();
    L31:
        r23 = true;
        goto L32
    L25:
        r0 = r41;
        goto L26
    L21:
        r22 = r40;
        goto L23
    L17:
        r21 = r39;
        goto L19
    L13:
        r15 = r38;
        goto L15
    L9:
        r19 = r36;
        goto L11
    L5:
        r1 = r34;
        goto L7
    }
}
