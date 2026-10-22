package com.larus.bmhome.chat.model.strategy;

import android.os.SystemClock;
import com.google.gson.Gson;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.ext.AudioTextExtra;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.AudioContent;
import com.larus.im.bean.message.AudioText;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatSendStrategy implements g0 {
    public static final /* synthetic */ int e = 0;
    public final ChatRepo a;
    public final Lazy b;
    public final CoroutineScope c;
    public final Lazy d;

    public static final class a {
    }

    public static final class b implements IIMCallback<Message> {
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
            tx9.d.a(false, this.c.d().name(), this.d, Integer.valueOf(r14.getCode()), r14.getTips(), SystemClock.elapsedRealtime() - this.a, false, this.b, this.e, 512);
            FLogger.a.e("ChatSendStrategy", "prepareMessage fail: " + r14);
        }

        public final void onSuccess(Object r18) {
            Message r1 = (Message) r18;
            Intrinsics.checkNotNullParameter(r1, "result");
            long r2 = SystemClock.elapsedRealtime() - this.a;
            FLogger.a.i("ChatSendStrategy", "prepareMessage success, isImproveAsr:" + this.b + ",cost:" + r2);
            tx9.d.a(true, this.c.d().name(), this.d, null, null, SystemClock.elapsedRealtime() - this.a, false, this.b, this.e, 536);
            this.f.invoke(r1);
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
            FLogger.a.e("ChatSendStrategy", "prepareMessages fail: " + r4);
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

        public final void onFailure(IIMError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            FLogger.a.e("ChatSendStrategy", "sendAudio fail: " + r4);
            Function2<Message, IIMError, Unit> r0 = this.a;
            if (r0 == null) goto L6;
            r0.invoke(null, r4);
            return;
        }

        public final void onSuccess(Object r4) {
            Message r5 = (Message) r4;
            Intrinsics.checkNotNullParameter(r5, "result");
            FLogger.a.i("ChatSendStrategy", "sendAudio success");
            Function2<Message, IIMError, Unit> r0 = this.a;
            if (r0 == null) goto L6;
            r0.invoke(r5, null);
            return;
        }
    }

    public static final class e implements IIMCallback<Message> {
        public final /* synthetic */ Function2<Message, IIMError, Unit> a;

        public final boolean mustInMain() {
            return true;
        }

        public e(Function2<? super Message, ? super IIMError, Unit> r1) {
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

    public ChatSendStrategy(ChatRepo r2) {
        Intrinsics.checkNotNullParameter(r2, "repo");
        this.a = r2;
        this.b = LazyKt.lazy(new w());
        this.c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.d = LazyKt.lazy(new x());
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void streamAudioText(final Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        FLogger.a.i("ChatSendStrategy", "streamAudioText " + r4.getLocalMessageId());
        NativeMessageServiceImpl r0 = com.larus.im.d.e();
        String r1 = r4.getLocalMessageId();
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.x(r1, new t(r4), null);
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void submitAudioText(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "msg");
        FLogger.a.i("ChatSendStrategy", "submitAudioText " + r4.getLocalMessageId());
        NativeMessageServiceImpl r0 = com.larus.im.d.e();
        String r5 = r4.getLocalMessageId();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.x(r5, new s(), null);
    }

    public static final void k(ChatSendStrategy r4, Map r5, ChatPageContext r6) {
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
        Object r11 = Result.constructor-impl((Map) ChatSendUtils.n().fromJson(r3, new z().getType()));     // Catch: Throwable -> L31
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
        FLogger.a.i("ChatSendStrategy", "failAudioTextNew " + r9.getLocalMessageId());
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
        r7.x(r12, new u(r6, r11, r10), null);
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
        j(r11, r12.c(r0, r2), new e(r13), r14, "sendAudioTextNew");
        return;
    L6:
        r2 = new LinkedHashMap();
        goto L7
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void f(String r3, final NestedFileContent r4, final Map<String, String> r5, IIMCallback<Message> r6) {
        Intrinsics.checkNotNullParameter(r3, "localMessageId");
        Intrinsics.checkNotNullParameter(r4, "content");
        Intrinsics.checkNotNullParameter(r5, "bizExt");
        Intrinsics.checkNotNullParameter(r6, "callback");
        com.larus.im.d.e().x(r3, new v(r5, r4), r6);
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void i(String r7, int r8, List<? extends ic8.w> r9, Function1<? super List<Message>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r7, "cvsId");
        Intrinsics.checkNotNullParameter(r9, "strategies");
        Intrinsics.checkNotNullParameter(r10, "prepareResult");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("prepareMessages ");
        List<? extends ic8.w> r11 = r9;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r4 = r11.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r2.add(((ic8.w) r4.next()).b());
        goto L4
    L6:
        r1.append(r2);
        r0.i("ChatSendStrategy", r1.toString());
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ic8.w r5 = (ic8.w) r12.next();
        com.larus.bmhome.chat.model.strategy.block.d0.a.getClass();
        r3.add(com.larus.bmhome.chat.model.strategy.block.d0.m(r5, r7, r8));
        goto L8
    L10:
        com.larus.im.d.e().batchAddMessage(r3, new c(r10));
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    @Deprecated(message = "deprecated in social")
    public final void c(String r10, String r11, long r12, wc9.e r14, Function2<? super Message, ? super IIMError, Unit> r15) {
        Intrinsics.checkNotNullParameter(r10, ChatDraftItem.TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r11, "vid");
        Intrinsics.checkNotNullParameter(r14, "conversation");
        g0.a.d(this, r14, new ai8.a(new AudioContent(r10, new AudioText(r11, r10, String.valueOf(RangesKt.coerceAtLeast(r12 / ((long) 1000), 1)))), null), new d(r15), false, "sendAudio", 8);
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void h(wc9.e r11, List<? extends ic8.w> r12, IIMCallback<List<Message>> r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r11, "conversation");
        Intrinsics.checkNotNullParameter(r12, "strategies");
        Intrinsics.checkNotNullParameter(r14, "sendFuncChannel");
        BuildersKt.launch$default(this.c, null, null, new ChatSendStrategy$batchSendMessage$1(r11, this, r12, r14, r13, null), 3, null);
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void j(wc9.e r16, ic8.w r17, IIMCallback<Message> r18, boolean r19, String r20) {
        Intrinsics.checkNotNullParameter(r16, "conversation");
        Intrinsics.checkNotNullParameter(r17, "strategy");
        Intrinsics.checkNotNullParameter(r20, "sendFuncChannel");
        com.larus.bmhome.chat.model.strategy.block.d0 r0 = com.larus.bmhome.chat.model.strategy.block.d0.a;
        String r2 = r16.a;
        r0.getClass();
        yc9.f0 r3 = com.larus.bmhome.chat.model.strategy.block.d0.m(r17, r2, -1);
        ChatControlTrace r1 = ChatControlTrace.b;
        String r4 = r3.i;
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r1.getClass();
        ChatControlTrace.X(r4);
        Integer r5 = ChatControlTrace.p(r3.r);
        String r6 = r3.i;
        Map r7 = r3.r;
        if (r7 == null) goto L8;
        String r8 = (String) r7.get("action_bar_instruction_type");
    L9:
        ChatControlTrace.f0(r6, r8, r5);
        BuildersKt.launch$default(this.c, null, null, new ChatSendStrategy$sendMessage$1(r16, this, r3, r20, r17, r18, null), 3, null);
        return;
    L8:
        r8 = null;
        goto L9
    }

    public final void l(wc9.e r14, Message r15, Message r16, String r17, ChatPageContext r18) {
        Intrinsics.checkNotNullParameter(r14, "conversation");
        Intrinsics.checkNotNullParameter(r15, "answer");
        BuildersKt.launch$default(this.c, null, null, new ChatSendStrategy$regenMessage$1(r14, this, r15, r16, r17, r18, null), 3, null);
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void g(String r17, int r18, ic8.w r19, boolean r20, Integer r21, Function1<? super Message, Unit> r22) {
        Intrinsics.checkNotNullParameter(r17, "cvsId");
        Intrinsics.checkNotNullParameter(r19, "strategy");
        Intrinsics.checkNotNullParameter(r22, "prepareResult");
        FLogger.a.i("ChatSendStrategy", "prepareMessage " + r19.b() + ", isImproveAsr:" + r20);
        com.larus.bmhome.chat.model.strategy.block.d0.a.getClass();
        yc9.f0 r15 = com.larus.bmhome.chat.model.strategy.block.d0.m(r19, r17, r18);
        long r1 = SystemClock.elapsedRealtime();
        long r5 = r1 - ((Number) AppHost.a.getAppStartTime().getFirst()).longValue();
        tx9.d.b(false, r5, r19.d().name(), r20, r21);
        com.larus.im.d.e().addMessage(r15, new b(r1, r20, r19, r5, r21, r22));
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
        j(r19, new ai8.h(r18, r17, r21, r24, r7, MapsKt.mutableMapOf(r1), false, false, r26, null, 704), new b0(r22), r23, r25);
        return;
    L5:
        r0 = r20;
        goto L6
    }

    @Override // com.larus.bmhome.chat.model.strategy.g0
    public final void e(wc9.e r18, Message r19, String r20, boolean r21, Map<String, String> r22, boolean r23, AttachmentInfo r24, NestedFileContent r25, String r26, String r27, ChatPageContext r28, Long r29) {
        Intrinsics.checkNotNullParameter(r18, "conversation");
        Intrinsics.checkNotNullParameter(r19, "message");
        BuildersKt.launch$default(this.c, null, null, new ChatSendStrategy$reeditMessage$1(r18, r19, r26, this, r22, r24, r20, r29, r23, r28, null), 3, null);
    }
}
