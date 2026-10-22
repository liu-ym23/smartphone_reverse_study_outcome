package com.larus.bmhome.chat.model.strategy.block;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larus.audio.IFlowAsrClientService;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.ext.AudioTextExtra;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.chat.model.strategy.g0;
import com.larus.bmhome.chat.thinkmode.ConversationSource;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageRequestV2;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatBlockSendStrategy implements g0 {
    public static final /* synthetic */ int d = 0;
    public final ChatRepo a;
    public final CoroutineScope b;
    public final Lazy c;

    public static final class a {
    }

    public static final class b implements IIMCallback<List<? extends Message>> {
        public final /* synthetic */ long a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ ic8.w c;
        public final /* synthetic */ long d;
        public final /* synthetic */ Integer e;
        public final /* synthetic */ Function1<Message, Unit> f;

        public final boolean mustInMain() {
            return true;
        }

        public final void onFailure(IIMError r14) {
            Intrinsics.checkNotNullParameter(r14, "error");
            tx9.d.a(false, this.c.d().name(), this.d, Integer.valueOf(r14.getCode()), r14.getTips(), SystemClock.elapsedRealtime() - this.a, true, this.b, this.e, 512);
            FLogger.a.e("ChatBlockSendStrategy", "prepareMessage fail: " + r14);
        }

        public final void onSuccess(Object r18) {
            List r1 = (List) r18;
            Intrinsics.checkNotNullParameter(r1, "result");
            long r2 = SystemClock.elapsedRealtime() - this.a;
            FLogger.a.i("ChatBlockSendStrategy", "prepareMessage success, isImproveAsr:" + this.b + ",cost:" + r2);
            tx9.d.a(true, this.c.d().name(), this.d, null, null, SystemClock.elapsedRealtime() - this.a, true, this.b, this.e, 536);
            this.f.invoke(CollectionsKt.first(r1));
        }

        public b(long r1, boolean r3, ic8.w r4, long r5, Integer r7, Function1<? super Message, Unit> r8) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r7;
            this.f = r8;
        }
    }

    public static final class c implements IIMCallback<List<? extends Message>> {
        public final /* synthetic */ Function1<List<Message>, Unit> a;

        public final boolean mustInMain() {
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super List<Message>, Unit> r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("ChatBlockSendStrategy", "prepareMessages fail: " + r4);
        }

        public final void onSuccess(Object r2) {
            List r3 = (List) r2;
            Intrinsics.checkNotNullParameter(r3, "result");
            this.a.invoke(r3);
        }
    }

    public static final class d implements IIMCallback<Message> {
        public final /* synthetic */ Function2<Message, IIMError, Unit> a;

        public final boolean mustInMain() {
            return true;
        }

        public d(Function2<? super Message, ? super IIMError, Unit> r1) {
            this.a = r1;
        }

        public final void onFailure(IIMError r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            Intrinsics.checkNotNullParameter(r3, "error");
            Function2<Message, IIMError, Unit> r0 = this.a;
            if (r0 == null) goto L6;
            r0.invoke(null, r3);
            return;
        }

        public final void onSuccess(Object r3) {
            Message r4 = (Message) r3;
            Intrinsics.checkNotNullParameter(r4, "result");
            Function2<Message, IIMError, Unit> r0 = this.a;
            if (r0 == null) goto L6;
            r0.invoke(r4, null);
            return;
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    @Deprecated(message = "deprecated in social")
    public final void c(String r1, String r2, long r3, wc9.e r5, Function2<? super Message, ? super IIMError, Unit> r6) {
        Intrinsics.checkNotNullParameter(r1, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r2, "vid");
        Intrinsics.checkNotNullParameter(r5, "conversation");
    }

    public ChatBlockSendStrategy(ChatRepo r2) {
        Intrinsics.checkNotNullParameter(r2, "repo");
        this.a = r2;
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.c = LazyKt.lazy(new k());
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void streamAudioText(final Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        FLogger.a.i("ChatBlockSendStrategy", "streamAudioText " + r4.getLocalMessageId());
        NativeMessageServiceImpl r0 = com.larus.im.d.e();
        String r1 = r4.getLocalMessageId();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.x(r1, new e(r4), null);
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void submitAudioText(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        FLogger.a.i("ChatBlockSendStrategy", "submitAudioText " + r4.getLocalMessageId());
        NativeMessageServiceImpl r0 = com.larus.im.d.e();
        String r5 = r4.getLocalMessageId();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.x(r5, new g(), null);
    }

    public static void q(NestedFileContent r5, UplinkFileEntity r6) {
        List r7 = r5.getEntities();
        if (r7 != null) goto L5;
        return;
    L5:
        Iterator r0 = r7.iterator();
        int r1 = 0;
    L7:
        if (r0.hasNext() == false) goto L25;
        UplinkFileEntity r2 = (UplinkFileEntity) r0.next();
        UplinkEntityContent r3 = r6.getUplinkEntityContent();
        String r4 = null;
        if (r3 == null) goto L13;
        Image r8 = r3.getUplinkImageInfo();
        if (r8 == null) goto L13;
        String r9 = r8.identifier;
    L14:
        if (r9 == null) goto L21;
        UplinkEntityContent r10 = r2.getUplinkEntityContent();
        if (r10 == null) goto L20;
        Image r11 = r10.getUplinkImageInfo();
        if (r11 == null) goto L20;
        r4 = r11.identifier;
    L20:
        boolean r12 = Intrinsics.areEqual(r4, r9);
    L22:
        if (r12 == true) goto L26;
        r1 = r1 + 1;
    L26:
        if (r1 < 0) goto L31;
        ListProtector.set(r7, r1, r6);
        return;
    L31:
        return;
    L21:
        r12 = Intrinsics.areEqual(r2.getFileIdentifier(), r6.getFileIdentifier());
    L13:
        r9 = null;
        goto L14
    L25:
        r1 = -1;
        goto L26
    }

    public static final void k(ChatBlockSendStrategy r4, Map r5, ChatPageContext r6) {
        r4.getClass();
        Object r7 = null;
        boolean r0 = true;
        if (r6 == null) goto L12;
        Map<String, String> r1 = r6.getReqExt();
        if (r1 == null) goto L12;
        if ((!r1.isEmpty()) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        r5.putAll(r1);
    L12:
        if (r6 == null) goto L44;
        Map<String, String> r8 = r6.getReqHeaderMap();
        if (r8 != null) goto L16;
        return;
    L16:
        if ((!r8.isEmpty()) == true) goto L19;
        r8 = null;
    L19:
        if (r8 == null) goto L46;
        int r2 = ve8.e.a;
        String r3 = (String) r5.get("extra_header");
        if (r3 != null) goto L24;
    L27:
        if (r0 == false) goto L42;
        Map r9 = MapsKt.emptyMap();
    L40:
        r5.put("extra_header", ve8.e.a(MapsKt.plus(r8, r9)));
        return;
    L42:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L31
        ChatSendUtils.a.getClass();     // Catch: Throwable -> L31
        Object r11 = Result.constructor-impl((Map) ChatSendUtils.n().fromJson(r3, new p().getType()));     // Catch: Throwable -> L31
    L34:
        if (Result.isFailure-impl(r11) == true) goto L37;
        r7 = r11;
    L37:
        r9 = (Map) r7;
        if (r9 != null) goto L40;
        r9 = MapsKt.emptyMap();
    L31:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L34
    L24:
        if (r3.length() == 0) goto L27;
        r0 = false;
        goto L27
    L46:
        return;
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void a(Message r9, final String r10, final long r11) {
        Intrinsics.checkNotNullParameter(r9, "msg");
        Intrinsics.checkNotNullParameter(r10, "record");
        FLogger.a.i("ChatBlockSendStrategy", "failAudioTextNew " + r9.getLocalMessageId());
        Map r0 = r9.getBusinessExt();
        if (r0 == null) goto L5;
        String r1 = (String) r0.get("tag_audio_text_info");
    L6:
        if (r1 == null) goto L14;
        int r2 = ve8.e.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        Object r4 = Result.constructor-impl(new Gson().fromJson(r1, AudioTextExtra.class));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r4) == true) goto L14;
    L15:
        AudioTextExtra r5 = (AudioTextExtra) r4;
        if (r5 == null) goto L20;
        final AudioTextExtra r6 = AudioTextExtra.copy$default(r5, r10, null, null, 6, null);
        if (r6 == null) goto L20;
    L21:
        NativeMessageServiceImpl r7 = com.larus.im.d.e();
        String r12 = r9.getLocalMessageId();
        if (r12 != null) goto L24;
        r12 = "";
    L24:
        r7.x(r12, new com.larus.bmhome.chat.model.strategy.block.d(r6, r11, r10), null);
        return;
    L20:
        r6 = new AudioTextExtra(r10, null, null, 6, null);
    L10:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
    L14:
        r4 = null;
        goto L15
    L5:
        r1 = null;
        goto L6
    }

    public final void p(wc9.e r7, String r8, boolean r9) {
        if (r9 == true) goto L4;
        return;
    L4:
        ReplyOption r10 = com.larus.bmhome.instruction.c.a.a(r8, ActiveSwitchType.DEEPTHINK.getValue());
        ConversationSource.a r11 = ConversationSource.Companion;
        boolean r0 = ic8.n.v(r7);
        boolean r12 = ic8.n.r(r7);
        r11.getClass();
        if (r0 == false) goto L7;
        ConversationSource r13 = ConversationSource.MAIN_CONVERSATION;
    L10:
        Object r14 = com.larus.bmhome.view.actionbar.custom.cache.e.a;
        int r15 = com.larus.bmhome.view.actionbar.custom.cache.e.c(r10);
        BuildersKt.launch$default(this.b, null, null, new ChatBlockSendStrategy$reportThinkModeMemory$1(r10, r13, r15, null), 3, null);
        return;
    L7:
        if (r12 == false) goto L9;
        r13 = ConversationSource.NEW_CONVERSATION;
        goto L10
    L9:
        r13 = ConversationSource.UNKNOWN;
        goto L10
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void b(wc9.e r11, ic8.w r12, Function2<? super Message, ? super IIMError, Unit> r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "conversation");
        Intrinsics.checkNotNullParameter(r12, "strategy");
        ChatSendUtils.a.getClass();
        Map<String, String> r0 = ChatSendUtils.i(r11, r12);
        Map<String, String> r1 = r12.f();
        if (r1 == null) goto L6;
        Map<String, String> r2 = MapsKt.toMutableMap(r1);
        if (r2 == null) goto L6;
    L7:
        r2.put("is_real_audio_text", "1");
        j(r11, r12.c(r0, r2), new d(r13), r14, "sendAudioTextNew");
        return;
    L6:
        r2 = new LinkedHashMap();
        goto L7
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void f(String r4, NestedFileContent r5, Map<String, String> r6, IIMCallback<Message> r7) {
        Intrinsics.checkNotNullParameter(r4, "localMessageId");
        Intrinsics.checkNotNullParameter(r5, "content");
        Intrinsics.checkNotNullParameter(r6, "bizExt");
        Intrinsics.checkNotNullParameter(r7, "callback");
        com.larus.im.d.e().x(r4, new f(r5, r6, null), r7);
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void i(String r11, int r12, List<? extends ic8.w> r13, Function1<? super List<Message>, Unit> r14) {
        Intrinsics.checkNotNullParameter(r11, "cvsId");
        Intrinsics.checkNotNullParameter(r13, "strategies");
        Intrinsics.checkNotNullParameter(r14, "prepareResult");
        FLogger r0 = FLogger.a;
        StringBuilder r3 = new StringBuilder("prepareMessages ");
        List<? extends ic8.w> r4 = r13;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.add(((ic8.w) r6.next()).b());
        goto L4
    L6:
        r3.append(r5);
        r0.i("ChatBlockSendStrategy", r3.toString());
        MessageRequestV2 r1 = d0.n(d0.a, r11, r13, null, null, null, r12, null, true, 92);
        com.larus.im.d.e().c(false, r1, new c(r14));
    }

    public static /* synthetic */ void m(ChatBlockSendStrategy r7, wc9.e r8, List r9, boolean r10, Map r11) {
        r7.l(r8, r9, null, "reeditMessage", r10, r11);
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void h(wc9.e r9, List<? extends ic8.w> r10, IIMCallback<List<Message>> r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r9, "conversation");
        Intrinsics.checkNotNullParameter(r10, "strategies");
        Intrinsics.checkNotNullParameter(r12, "sendFuncChannel");
        l(r9, r10, r11, r12, r13, null);
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void j(wc9.e r18, ic8.w r19, IIMCallback<Message> r20, boolean r21, String r22) {
        Intrinsics.checkNotNullParameter(r18, "conversation");
        Intrinsics.checkNotNullParameter(r19, "strategy");
        Intrinsics.checkNotNullParameter(r22, "sendFuncChannel");
        FLogger.a.i("ChatBlockSendStrategy", "sendMessage start");
        String r0 = r19.b();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r6 = r0;
        if ((r19 instanceof ai8.f) == false) goto L8;
        ai8.f r1 = (ai8.f) r19;
    L9:
        if (r1 == null) goto L19;
        NestedFileContent r2 = r1.a;
        if (r2 == null) goto L19;
        List r3 = r2.getEntities();
        if (r3 == null) goto L19;
        ux9.a.a r4 = ux9.a.i;
        List r5 = r3;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r8 = r5.iterator();
    L16:
        if (r8.hasNext() == false) goto L18;
        r7.add(((UplinkFileEntity) r8.next()).getFileIdentifier());
        goto L16
    L18:
        r4.a(r7, r6);
    L19:
        List r9 = ux9.a.i.d(CollectionsKt.listOf(r6));
        ChatControlTrace.b.getClass();
        ChatControlTrace.X(r6);
        Map<String, String> r10 = r19.a();
        if (r10 == null) goto L22;
        String r11 = r10.get("action_bar_instruction_type");
    L23:
        ChatControlTrace.f0(r6, r11, null);
        BuildersKt.launch$default(this.b, null, null, new ChatBlockSendStrategy$sendMessage$2(r18, this, r19, r21, r9, r6, r20, r22, null), 3, null);
        return;
    L22:
        r11 = null;
        goto L23
    L8:
        r1 = null;
        goto L9
    }

    public final void o(wc9.e r14, Message r15, Message r16, String r17, ChatPageContext r18) {
        Intrinsics.checkNotNullParameter(r14, "conversation");
        Intrinsics.checkNotNullParameter(r15, "answer");
        BuildersKt.launch$default(this.b, null, null, new ChatBlockSendStrategy$regenMessage$1(r14, this, r15, r16, r17, r18, null), 3, null);
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void g(String r23, int r24, ic8.w r25, boolean r26, Integer r27, Function1<? super Message, Unit> r28) {
        Intrinsics.checkNotNullParameter(r23, "cvsId");
        Intrinsics.checkNotNullParameter(r25, "strategy");
        Intrinsics.checkNotNullParameter(r28, "prepareResult");
        String r0 = r25.b();
        FLogger.a.i("ChatBlockSendStrategy", "prepareMessage " + r0 + ", isImproveAsr:" + r26);
        if ((r25 instanceof ai8.b) == false) goto L16;
        boolean r2 = y0.d().D;
        IFlowAsrClientService.a.getClass();
        IFlowAsrClientService r5 = IFlowAsrClientService.a.a();
        if (r2 == false) goto L16;
        if (r0 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L16;
        if (r5.o().contains(r0) == false) goto L16;
        r5.j(r0);
        goto L16
    L8:
        if (r0.length() == 0) goto L11;
        r3 = false;
    L16:
        MessageRequestV2 r12 = d0.n(d0.a, r23, CollectionsKt.listOf(r25), null, null, null, r24, null, true, 92);
        long r1 = SystemClock.elapsedRealtime();
        long r13 = r1 - ((Number) AppHost.a.getAppStartTime().getFirst()).longValue();
        tx9.d.b(true, r13, r25.d().name(), r26, r27);
        com.larus.im.d.e().c(r26, r12, new b(r1, r26, r25, r13, r27, r28));
    }

    public final void l(wc9.e r16, List<? extends ic8.w> r17, IIMCallback<List<Message>> r18, String r19, boolean r20, Map<String, String> r21) {
        FLogger r0 = FLogger.a;
        r0.i("ChatBlockSendStrategy", "batchSendMessage start");
        if (r17.isEmpty() == false) goto L6;
        r0.e("ChatBlockSendStrategy", "batchSendMessage strategies is empty, Abort.");
        return;
    L6:
        List<? extends ic8.w> r1 = r17;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L23;
        ic8.w r3 = (ic8.w) r2.next();
        if ((r3 instanceof ai8.f) == false) goto L12;
        ai8.f r4 = (ai8.f) r3;
    L13:
        if (r4 == null) goto L8;
        NestedFileContent r5 = r4.a;
        if (r5 == null) goto L8;
        List r6 = r5.getEntities();
        if (r6 == null) goto L8;
        ux9.a.a r7 = ux9.a.i;
        List r8 = r6;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L20:
        if (r10.hasNext() == false) goto L22;
        r9.add(((UplinkFileEntity) r10.next()).getFileIdentifier());
        goto L20
    L22:
        r7.a(r9, ((ai8.f) r3).b);
        goto L8
    L12:
        r4 = null;
        goto L13
    L23:
        ux9.a.a r11 = ux9.a.i;
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r13 = r1.iterator();
    L25:
        if (r13.hasNext() == false) goto L27;
        r12.add(((ic8.w) r13.next()).b());
        goto L25
    L27:
        List r14 = r11.d(r12);
        Iterator<T> r15 = r1.iterator();
    L29:
        if (r15.hasNext() == false) goto L34;
        ic8.w r22 = (ic8.w) r15.next();
        ChatControlTrace r23 = ChatControlTrace.b;
        String r24 = r22.b();
        if (r24 != null) goto L33;
        r24 = "";
    L33:
        r23.getClass();
        ChatControlTrace.X(r24);
        goto L29
    L34:
        BuildersKt.launch$default(this.b, null, null, new ChatBlockSendStrategy$batchSendMessageInternal$3(r16, this, r21, r20, r17, r14, r18, r19, null), 3, null);
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void d(String r17, String r18, wc9.e r19, Map r20, MessageStatus r21, Function2 r22, boolean r23, ReferenceInfo r24, String r25, ChatPageContext r26) {
        Intrinsics.checkNotNullParameter(r18, "content");
        Intrinsics.checkNotNullParameter(r19, "conversation");
        Intrinsics.checkNotNullParameter(r25, "sendFuncChannel");
        ChatSendUtils.a.getClass();
        Map r7 = MapsKt.toMutableMap(ChatSendUtils.p(new Pair[0]));
        if (r20 != null) goto L5;
        Map r0 = MapsKt.emptyMap();
    L6:
        r7.putAll(r0);
        String r4 = "1";
        if (r19.i == false) goto L9;
        r7.put("tts", "1");
    L9:
        Pair[] r1 = new Pair[1];
        if (r20 == null) goto L12;
        r4 = ic8.j.g(r20);
    L12:
        r1[0] = TuplesKt.to("send_loading", r4);
        j(r19, new ai8.h(r18, r17, r21, r24, r7, MapsKt.mutableMapOf(r1), false, false, r26, null, 704), new w(r22), r23, r25);
        return;
    L5:
        r0 = r20;
        goto L6
    }

    public final void n(wc9.e r13, String r14, String r15, NestedFileContent r16, List r17, boolean r18, UplinkFileEntity r19, AtomicBoolean r20, Runnable r21, ChatBlockSendStrategy$observeNestedFileUploadAndSend$observer$1 r22, Map r23) {
        if (r19 == null) goto L15;
        q(r16, r19);
        if (r15 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == true) goto L15;
        if (Intrinsics.areEqual(r15, r14) == true) goto L15;
        NestedFileCacheManagerService.b.k(r15, r19);
        goto L15
    L7:
        if (StringsKt.isBlank(r15) == true) goto L10;
        r7 = false;
    L15:
        NestedFileContent r4 = NestedFileCacheManagerService.b.b6(r14);
        if (r4 != null) goto L18;
        r4 = r16;
    L18:
        List r5 = r4.getEntities();
        if (r5 == null) goto L34;
        Iterator r6 = r5.iterator();
    L22:
        if (r6.hasNext() == false) goto L34;
        UplinkFileEntity r8 = (UplinkFileEntity) r6.next();
        q(r16, r8);
        if (r15 != null) goto L26;
    L29:
        boolean r9 = true;
    L30:
        if (r9 == true) goto L22;
        if (Intrinsics.areEqual(r15, r14) == true) goto L22;
        NestedFileCacheManagerService.b.k(r15, r8);
        goto L22
    L26:
        if (StringsKt.isBlank(r15) == true) goto L29;
        r9 = false;
    L34:
        List r10 = r16.getEntities();
        if (r10 == null) goto L60;
        List r11 = r10;
        if ((r11 instanceof Collection) == true) goto L39;
    L41:
        Iterator r12 = r11.iterator();
    L43:
        if (r12.hasNext() == false) goto L59;
        UplinkFileEntity r24 = (UplinkFileEntity) r12.next();
        Integer r25 = r24.getUpLinkStatus();
        int r26 = UpLinkState.SUCCESS.getValue();
        if (r25 != null) goto L48;
    L49:
        Integer r27 = r24.getUpLinkStatus();
        int r28 = UpLinkState.FAIL.getValue();
        if (r27 != null) goto L53;
    L55:
        boolean r29 = false;
    L57:
        if (r29 == true) goto L43;
    L53:
        if (r27.intValue() != r28) goto L55;
    L56:
        r29 = true;
        goto L57
    L48:
        if (r25.intValue() == r26) goto L56;
    L59:
        boolean r30 = true;
    L61:
        List r31 = r16.getEntities();
        if (r31 == null) goto L81;
        List r32 = r31;
        if ((r32 instanceof Collection) == true) goto L66;
    L68:
        Iterator r33 = r32.iterator();
    L70:
        if (r33.hasNext() == false) goto L80;
        Integer r34 = ((UplinkFileEntity) r33.next()).getUpLinkStatus();
        int r35 = UpLinkState.SUCCESS.getValue();
        if (r34 != null) goto L75;
    L77:
        boolean r36 = false;
    L78:
        if (r36 == true) goto L70;
    L75:
        if (r34.intValue() != r35) goto L77;
        r36 = true;
    L80:
        boolean r37 = true;
    L82:
        List r38 = r16.getEntities();
        if (r38 == null) goto L101;
        List r39 = r38;
        if ((r39 instanceof Collection) == true) goto L87;
    L89:
        Iterator r40 = r39.iterator();
    L91:
        if (r40.hasNext() == false) goto L101;
        Integer r41 = ((UplinkFileEntity) r40.next()).getUpLinkStatus();
        int r110 = UpLinkState.FAIL.getValue();
        if (r41 != null) goto L96;
    L98:
        boolean r42 = false;
    L99:
        if (r42 == false) goto L91;
        boolean r43 = true;
    L102:
        FLogger.a.i("ChatBlockSendStrategy", "[reeditObserveUpload] UPDATE isReadyToRemoveObserver=" + r30 + ", isReadyToSend=" + r37 + ", hasFailedContent=" + r43);
        if (r30 == true) goto L105;
        return;
    L105:
        if (r20.compareAndSet(false, true) == true) goto L107;
        return;
    L107:
        com.larus.utils.y.a(r21);
        NestedFileCacheManagerService.b.g(r14).removeObserver(r22);
        if (r43 == false) goto L117;
        if (r15 != null) goto L111;
    L114:
        boolean r1 = true;
    L115:
        if (r1 == true) goto L117;
        f(r15, r16, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("send_loading", "0")}), new n());
        goto L117
    L111:
        if (StringsKt.isBlank(r15) == true) goto L114;
        r1 = false;
    L117:
        if (r37 == false) goto L143;
        m(this, r13, r17, r18, r23);
        return;
    L143:
        return;
    L96:
        if (r41.intValue() != r110) goto L98;
        r42 = true;
        goto L99
    L87:
        if (r39.isEmpty() == false) goto L89;
    L101:
        r43 = false;
        goto L102
    L66:
        if (r32.isEmpty() == false) goto L68;
    L81:
        r37 = false;
        goto L82
    L39:
        if (r11.isEmpty() == false) goto L41;
    L60:
        r30 = false;
        goto L61
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void e(wc9.e r20, Message r21, String r22, boolean r23, Map<String, String> r24, boolean r25, AttachmentInfo r26, NestedFileContent r27, String r28, String r29, ChatPageContext r30, Long r31) {
        Intrinsics.checkNotNullParameter(r20, "conversation");
        Intrinsics.checkNotNullParameter(r21, "message");
        BuildersKt.launch$default(this.b, null, null, new ChatBlockSendStrategy$reeditMessage$1(r21, r28, this, r20, r24, r22, r27, r26, r23, r30, r29, r31, null), 3, null);
    }
}
