package com.larus.uaigc.nowatermark;

import com.larus.bmhome.chat.component.list.ChatMessageListUpdateObserver;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageContentData;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import td8.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0017\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001fH\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0 H\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u000eH\u0002J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010$\u001a\u00020\u000eH\u0002J\u0014\u0010&\u001a\u00020'*\u00020!2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\f\u0010(\u001a\u00020'*\u00020!H\u0002J\f\u0010)\u001a\u00020'*\u00020!H\u0002J\f\u0010*\u001a\u00020'*\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001b¨\u0006-"}, d2 = {"Lcom/larus/uaigc/nowatermark/CreationNoWatermarkMessageListObserver;", "Lcom/larus/bmhome/chat/component/list/ChatMessageListUpdateObserver;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "updateSignal", "Lkotlinx/coroutines/channels/Channel;", "", "pendingUpdateLock", "", "pendingUpdates", "Ljava/util/LinkedHashMap;", "", "Lcom/larus/uaigc/nowatermark/CreationNoWatermarkMessageListObserver$MessageListUpdate;", "Lkotlin/collections/LinkedHashMap;", "imageDataParser", "Lcom/larus/platform/spi/IAIChatUgcAIGCService;", "getImageDataParser", "()Lcom/larus/platform/spi/IAIChatUgcAIGCService;", "imageDataParser$delegate", "Lkotlin/Lazy;", "messageSnapshotCache", "com/larus/uaigc/nowatermark/CreationNoWatermarkMessageListObserver$messageSnapshotCache$1", "Lcom/larus/uaigc/nowatermark/CreationNoWatermarkMessageListObserver$messageSnapshotCache$1;", "snapshotGeneration", "", "Ljava/lang/Long;", "onMessageListChanged", "sourceKey", "messageListProvider", "Lkotlin/Function0;", "", "Lcom/larus/im/bean/message/Message;", "drainPendingUpdates", "prefetchChangedMessages", "update", "collectChangedMessages", "hasChangedSinceLastUpdate", "", "isNoWatermarkCandidate", "isBlockCandidate", "isImageCandidate", "Companion", "MessageListUpdate", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationNoWatermarkMessageListObserver implements ChatMessageListUpdateObserver {
    public static final /* synthetic */ int h = 0;
    public final CoroutineScope a;
    public final Channel<Unit> b;
    public final Object c;
    public final LinkedHashMap<String, b> d;
    public final Lazy e;
    public final CreationNoWatermarkMessageListObserver$messageSnapshotCache$1 f;
    public Long g;

    /* JADX INFO: renamed from: com.larus.uaigc.nowatermark.CreationNoWatermarkMessageListObserver$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.nowatermark.CreationNoWatermarkMessageListObserver$1", f = "CreationNoWatermarkMessageListObserver.kt", i = {0, 1}, l = {54, TraceLevel.ABOVE_DEBUG}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CreationNoWatermarkMessageListObserver this$0;

        public AnonymousClass1(CreationNoWatermarkMessageListObserver r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009c -> B:12:0x0031). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r11);
            CoroutineScope r12 = r2;
        L11:
            AnonymousClass1 r3 = this;
        L12:
            Channel<Unit> r4 = r3.this$0.b;
            r3.L$0 = r12;
            r3.label = 1;
            if (r4.receive(r3) != r0) goto L15;
            return r0;
        L15:
            CreationNoWatermarkMessageListObserver r5 = r3.this$0;
            Object r6 = r5.c;
            monitor-enter(r6);
            List r7 = CollectionsKt.toList(r5.d.values());     // Catch: Throwable -> L33
            r5.d.clear();     // Catch: Throwable -> L33
            monitor-exit(r6);
            CreationNoWatermarkMessageListObserver r8 = r3.this$0;
            Iterator r9 = r7.iterator();
        L21:
            if (r9.hasNext() == false) goto L30;
            b r10 = (b) r9.next();
            Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L25
            CreationNoWatermarkMessageListObserver.a(r8, r10);     // Catch: Throwable -> L25
            Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
        L27:
            Throwable r15 = Result.exceptionOrNull-impl(r14);
            if (r15 == null) goto L21;
            FLogger.a.e("NoWatermarkListObserver", "prefetch failed", r15);
        L25:
            th = move-exception;
            Result.Companion r16 = Result.Companion;
            r14 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L27
        L30:
            r3.L$0 = r12;
            r3.label = 2;
            if (DelayKt.delay(500, r3) != r0) goto L12;
            return r0;
        L33:
            th = move-exception;
            throw th;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            CoroutineScope r17 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r11);
            r12 = r17;
            r3 = this;
            goto L15
        L10:
            ResultKt.throwOnFailure(r11);
            r12 = (CoroutineScope) this.L$0;
            goto L11
        }
    }

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final Function0<List<Message>> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "MessageListUpdate(sourceKey=" + this.a + ", messageListProvider=" + this.b + ')';
        }

        public b(String r2, g r3) {
            Intrinsics.checkNotNullParameter(r2, "sourceKey");
            Intrinsics.checkNotNullParameter(r3, "messageListProvider");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.uaigc.nowatermark.CreationNoWatermarkMessageListObserver$messageSnapshotCache$1] */
    public CreationNoWatermarkMessageListObserver() {
        CoroutineScope r2 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.a = r2;
        this.b = ChannelKt.Channel$default(-1, null, null, 6, null);
        this.c = new Object();
        this.d = new LinkedHashMap();
        this.e = LazyKt.lazy(new e());
        this.f = new CreationNoWatermarkMessageListObserver$messageSnapshotCache$1();
        BuildersKt.launch$default(r2, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public static final void a(CreationNoWatermarkMessageListObserver r17, b r18) {
        r17.getClass();
        CreationNoWatermarkManager r2 = CreationNoWatermarkManager.a;
        r2.f();
        long r3 = CreationNoWatermarkManager.w;
        Long r5 = r17.g;
        if (r5 != null) goto L6;
    L7:
        r17.f.clear();
        r17.g = Long.valueOf(r3);
    L9:
        if (r2.j0() == false) goto L140;
        ArrayList r4 = new ArrayList(11);
        Iterator r6 = ((Iterable) r18.b.invoke()).iterator();
    L12:
        boolean r9 = true;
        if (r6.hasNext() == false) goto L71;
        Message r7 = (Message) r6.next();
        if (r7.getContentType() != 9999) goto L17;
    L22:
        boolean r8 = true;
    L23:
        if (r8 == false) goto L25;
    L33:
        boolean r10 = true;
    L34:
        if (r10 == false) goto L12;
        String r11 = r18.a;
        String r12 = r7.getMessageId();
        if (r12 != null) goto L39;
    L42:
        boolean r13 = true;
    L44:
        if (r13 == true) goto L46;
        String r14 = "server|" + r7.getMessageId();
    L56:
        String r15 = r11 + '|' + r14;
        int r16 = r7.getMessageStatusLocal() * 31;
        String r19 = r7.getContent();
        if (r19 == null) goto L59;
        int r20 = r19.hashCode();
    L60:
        int r21 = r16 + r20;
        Integer r22 = r17.f.put(r15, Integer.valueOf(r21));
        if (r22 != null) goto L64;
    L67:
        if (r9 == false) goto L12;
        if (r4.size() >= 11) goto L12;
        r4.add(r7);
        goto L12
    L64:
        if (r22.intValue() != r21) goto L67;
        r9 = false;
        goto L67
    L59:
        r20 = 0;
        goto L60
    L46:
        String r23 = r7.getLocalMessageId();
        if (r23 != null) goto L49;
    L52:
        boolean r24 = true;
    L53:
        if (r24 == true) goto L55;
        r14 = "local|" + r7.getLocalMessageId();
        goto L56
    L55:
        r14 = "index|" + r7.getServerIndex() + '|' + r7.getContentType();
        goto L56
    L49:
        if (StringsKt.isBlank(r23) == true) goto L52;
        r24 = false;
        goto L53
    L39:
        if (StringsKt.isBlank(r12) == true) goto L42;
        r13 = false;
        goto L44
    L25:
        if (r7.getContentType() == 6) goto L27;
    L29:
        boolean r25 = false;
    L30:
        if (r25 == true) goto L33;
        r10 = false;
        goto L34
    L27:
        if (r7.getUserType() != 2) goto L29;
        r25 = true;
        goto L30
    L17:
        if (r7.getContentType() == 1) goto L19;
    L21:
        r8 = false;
        goto L23
    L19:
        if (com.larus.im.bean.message.a.b0(r7) == false) goto L21;
    L71:
        ArrayList r1 = new ArrayList();
        Iterator r26 = r4.iterator();
    L73:
        if (r26.hasNext() == false) goto L86;
        Object r27 = r26.next();
        Message r28 = (Message) r27;
        if (r28.getContentType() != 9999) goto L77;
    L82:
        boolean r29 = true;
    L83:
        if (r29 == false) goto L73;
        r1.add(r27);
        goto L73
    L77:
        if (r28.getContentType() == 1) goto L79;
    L81:
        r29 = false;
        goto L83
    L79:
        if (com.larus.im.bean.message.a.b0(r28) == false) goto L81;
    L86:
        if ((!r1.isEmpty()) == false) goto L96;
        CreationNoWatermarkManager.a.getClass();
        Intrinsics.checkNotNullParameter("message_list_update", "scene");
        if (CreationNoWatermarkManager.i0().a() == false) goto L96;
        if (CreationNoWatermarkManager.v == true) goto L93;
    L95:
        BuildersKt.launch$default(CreationNoWatermarkManager.d, null, null, new CreationNoWatermarkManager$prefetchMessages$1(r1, "message_list_update", null), 3, null);
        goto L96
    L93:
        if (CreationNoWatermarkManager.u == true) goto L95;
    L96:
        ArrayList r30 = new ArrayList();
        Iterator r31 = r4.iterator();
    L98:
        if (r31.hasNext() == false) goto L107;
        Object r32 = r31.next();
        Message r33 = (Message) r32;
        if (r33.getContentType() == 6) goto L102;
    L104:
        boolean r34 = false;
    L105:
        if (r34 == false) goto L98;
        r30.add(r32);
        goto L98
    L102:
        if (r33.getUserType() != 2) goto L104;
        r34 = true;
        goto L105
    L107:
        Iterator r35 = r30.iterator();
    L109:
        if (r35.hasNext() == false) goto L177;
        Message r36 = (Message) r35.next();
        IAIChatUgcAIGCService r37 = (IAIChatUgcAIGCService) r17.e.getValue();
        if (r37 == null) goto L109;
        ImageContentData r38 = r37.d0(r36);
        if (r38 == null) goto L109;
        List r39 = r38.getImageList();
        if (r39 != null) goto L118;
        r39 = CollectionsKt.emptyList();
    L118:
        List r40 = r39;
        if ((r40 instanceof Collection) == true) goto L121;
    L123:
        Iterator r41 = r40.iterator();
    L125:
        if (r41.hasNext() == false) goto L129;
        if (df8.b.c((ImageItem) r41.next()) == false) goto L125;
        boolean r42 = false;
    L130:
        if (r42 == true) goto L109;
        CreationNoWatermarkManager.a.getClass();
        Intrinsics.checkNotNullParameter("message_list_update_image_explain", "scene");
        if (CreationNoWatermarkManager.i0().a() == false) goto L109;
        if (CreationNoWatermarkManager.v == false) goto L139;
        if (CreationNoWatermarkManager.u == false) goto L109;
    L139:
        BuildersKt.launch$default(CreationNoWatermarkManager.d, null, null, new CreationNoWatermarkManager$prefetchImageContentDataByExplainIfEnabled$1(r38, "message_list_update_image_explain", null), 3, null);
    L129:
        r42 = true;
        goto L130
    L121:
        if (r40.isEmpty() == false) goto L123;
    L177:
        return;
    L140:
        return;
    L6:
        if (r5.longValue() == r3) goto L9;
        goto L7
    }

    public final void b(String r3, g r4) {
        Intrinsics.checkNotNullParameter(r3, "sourceKey");
        Intrinsics.checkNotNullParameter(r4, "messageListProvider");
        b r0 = new b(r3, r4);
        Object r5 = this.c;
        monitor-enter(r5);
        this.d.put(r0.a, r0);     // Catch: Throwable -> L8
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r5);
        this.b.trySend-JP2dKIU(Unit.INSTANCE);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
