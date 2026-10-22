package com.larus.chat.gallery.api.datasource;

import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.tips.GuideTipType;
import com.larus.chat.gallery.api.bean.GalleryChatType;
import com.larus.gallery.api.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageQueryRequest;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/gallery/api/LoadingState$Success;", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.api.datasource.BaseChatDataSource$loadMore$2", f = "BaseChatDataSource.kt", i = {0, 1}, l = {52, 80}, m = "invokeSuspend", n = {"$this$coroutineScope", "hasMore"}, s = {"L$0", "I$0"})
final class BaseChatDataSource$loadMore$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b0.b<List<Object>>>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseChatDataSource<Object> this$0;

    public BaseChatDataSource$loadMore$2(BaseChatDataSource<Object> r1, Continuation<? super BaseChatDataSource$loadMore$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BaseChatDataSource$loadMore$2 r0 = new BaseChatDataSource$loadMore$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super b0.b<List<Object>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [boolean, int] */
    public final Object invokeSuspend(Object r37) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r7 = true;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r37);
        Object r4 = r37;
        ?? r5 = r3;
    L152:
        List r6 = CollectionsKt.flatten((List) r4);
        FLogger.a.i(this.this$0.c, "loadMore, end");
        if (r5 == 0) goto L155;
        int r8 = 4;
    L157:
        return new b0.b(r6, r7, false, r8);
    L155:
        r8 = 4;
        r7 = false;
        goto L157
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r37);
        Object r10 = r37;
    L19:
        ty8.c r11 = (ty8.c) r10;
        if (r11 == null) goto L23;
        List<Message> r12 = r11.a;
        if (r12 == null) goto L23;
    L24:
        BaseChatDataSource<Object> r13 = this.this$0;
        FLogger.a.i(r13.c, "loadMore,filter serverMessageList size: " + r12.size() + " isFirstLoadMore: " + r13.d);
        if (r13.d == true) goto L27;
    L39:
        if (r11 == null) goto L41;
        ?? r14 = r11.b;
    L42:
        Message r15 = (Message) CollectionsKt.lastOrNull(r12);
        if (r15 == null) goto L45;
        this.this$0.f = r15;
    L45:
        FLogger r16 = FLogger.a;
        String r17 = this.this$0.c;
        ?? r18 = new StringBuilder("loadMore, hasMore: ");
        r18.append(r14);
        r18.append(", serverMessageList size: ");
        r18.append(r12.size());
        r18.append(", remoteNewestMessage: ");
        Message r19 = this.this$0.f;
        if (r19 == null) goto L48;
        String r110 = r19.getMessageId();
    L49:
        r18.append(r110);
        r18.append(' ');
        Message r111 = this.this$0.f;
        if (r111 == null) goto L52;
        String r112 = r111.getLocalMessageId();
    L53:
        r18.append(r112);
        r18.append(' ');
        Message r113 = this.this$0.f;
        if (r113 == null) goto L56;
        Long r114 = Boxing.boxLong(r113.getCreateTime());
    L57:
        r18.append(r114);
        r16.i(r17, r18.toString());
        if (r14 != 0) goto L144;
        BaseChatDataSource<Object> r115 = this.this$0;
        r115.getClass();
        List<Message> r116 = CollectionsKt.toMutableList(r12);
        int r117 = r115.l();
        List<Message> r118 = r115.m();
        if (r118 == null) goto L63;
        List r119 = CollectionsKt.toList(r118);
    L64:
        if (r119 == null) goto L66;
        int r120 = r119.size();
    L67:
        r16.i(r115.c, "checkIfNeedMergeLocal, list size: " + r12.size() + ", clickIndex:" + r117 + " localMessageListSize: " + r120);
        if (r117 < 0) goto L71;
        r120 = RangesKt.coerceAtMost(r117 + 1, r120);
    L71:
        if (r119 == null) goto L74;
        List r20 = r119.subList(0, r120);
        if (r20 == null) goto L74;
    L76:
        if (r20.isEmpty() == false) goto L78;
        r16.i(r115.c, "checkIfNeedMergeLocal, return 2 localMessageList is empty");
    L143:
        r12 = r116;
        goto L144
    L78:
        Message r21 = (Message) CollectionsKt.firstOrNull(r20);
        if (r21 == null) goto L81;
        String r22 = r21.getMessageId();
    L82:
        Message r23 = r115.f;
        if (r23 == null) goto L85;
        String r24 = r23.getMessageId();
    L87:
        if (Intrinsics.areEqual(r22, r24) == false) goto L89;
        r16.i(r115.c, "checkIfNeedMergeLocal, return 3 localMessageList first messageId is same as remoteNewestMessage");
        goto L143
    L89:
        ArrayList r25 = new ArrayList();
        Iterator r26 = r20.iterator();
    L91:
        if (r26.hasNext() == false) goto L140;
        Object r27 = r26.next();
        Message r28 = (Message) r27;
        long r121 = r28.getCreateTime();
        Message r122 = r115.f;
        if (r122 == null) goto L95;
        long r123 = r122.getCreateTime();
    L97:
        if (r121 <= r123) goto L136;
        Iterator r124 = r115.a.iterator();
    L100:
        if (r124.hasNext() == false) goto L133;
        String r125 = (String) r124.next();
        Intrinsics.checkNotNullParameter(r125, "<this>");
        Intrinsics.checkNotNullParameter(r28, "message");
        if (Intrinsics.areEqual(r125, GalleryChatType.CHAT_SEND) == false) goto L111;
        if (d.G0(r28) == true) goto L106;
    L130:
        boolean r126 = false;
    L131:
        if (r126 == false) goto L100;
        boolean r29 = true;
    L134:
        if (r29 == false) goto L136;
        boolean r30 = true;
    L137:
        if (r30 == false) goto L91;
        r25.add(r27);
        goto L91
    L106:
        if (r28.getContentType() != 6) goto L108;
    L129:
        r126 = true;
        goto L131
    L108:
        if (lr8.c.a(r28) == false) goto L130;
    L111:
        if (Intrinsics.areEqual(r125, GalleryChatType.CHAT_CREATION) == false) goto L130;
        if (d.G0(r28) == true) goto L130;
        if (CollectionsKt.listOf(new Integer[]{6, 2022, Integer.valueOf(GuideTipType.FORCE_SHOW), 2021}).contains(Integer.valueOf(r28.getContentType())) == false) goto L130;
        if (d.l0(r28) == true) goto L130;
        if (d.j1(r28) == true) goto L129;
        Map r127 = r28.getExt();
        if (r127 == null) goto L127;
        String r128 = (String) r127.get("creativity_scene");
        if (r128 == null) goto L127;
        if (o0.d(r128) != true) goto L127;
        boolean r129 = true;
    L128:
        if (r129 == false) goto L130;
    L127:
        r129 = false;
        goto L128
    L133:
        r29 = false;
    L136:
        r30 = false;
        goto L137
    L95:
        r123 = 0;
        goto L97
    L140:
        if (r25.isEmpty() == false) goto L142;
        FLogger.a.i(r115.c, "checkIfNeedMergeLocal, return 4 filterLocalMessageList is empty");
        goto L143
    L142:
        r116.addAll(CollectionsKt.reversed(r25));
        FLogger.a.i(r115.c, "checkIfNeedMergeLocal end, newList size: " + r116.size());
        goto L143
    L85:
        r24 = null;
        goto L87
    L81:
        r22 = null;
    L74:
        r20 = CollectionsKt.emptyList();
        goto L76
    L66:
        r120 = 0;
        goto L67
    L63:
        r119 = null;
    L144:
        List<Message> r31 = r12;
        BaseChatDataSource<Object> r32 = this.this$0;
        ArrayList r33 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r31, 10));
        Iterator r34 = r31.iterator();
    L146:
        if (r34.hasNext() == false) goto L148;
        r33.add(BuildersKt.async$default(r9, null, null, new BaseChatDataSource$loadMore$2$galleryDataLists$1$1(r32, (Message) r34.next(), null), 3, null));
        goto L146
    L148:
        this.L$0 = null;
        this.I$0 = r14;
        this.label = 2;
        r4 = AwaitKt.a(r33, this);
        if (r4 != r1) goto L151;
        return r1;
    L151:
        r5 = r14;
        goto L152
    L56:
        r114 = null;
        goto L57
    L52:
        r112 = null;
        goto L53
    L48:
        r110 = null;
        goto L49
    L41:
        r14 = 0;
        goto L42
    L27:
        if ((!r12.isEmpty()) == false) goto L39;
        r13.d = false;
        ArrayList r130 = new ArrayList();
        Iterator r35 = r12.iterator();
    L30:
        if (r35.hasNext() == false) goto L38;
        Object r131 = r35.next();
        String r132 = ((Message) r131).getMessageId();
        Message r133 = r13.b;
        if (r133 == null) goto L34;
        String r134 = r133.getMessageId();
    L36:
        if ((!Intrinsics.areEqual(r132, r134)) == false) goto L30;
        r130.add(r131);
        goto L30
    L34:
        r134 = null;
        goto L36
    L38:
        r12 = r130;
    L23:
        r12 = CollectionsKt.emptyList();
        goto L24
    L10:
        ResultKt.throwOnFailure(r37);
        r9 = (CoroutineScope) this.L$0;
        BaseChatDataSource<Object> r36 = this.this$0;
        a r38 = r36.h;
        int r39 = RangesKt.coerceAtMost(r36.g, 50);
        this.L$0 = r9;
        this.label = 1;
        r38.getClass();
        FLogger.a.i("GalleryMessageLoadProcessor", "loadMore, startTime: " + r38.c + ", pageSize: " + r39);
        SafeContinuation r135 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        Message r136 = r38.b;
        if (r136 == null) goto L13;
        String r137 = r136.getConversationId();
    L14:
        com.larus.im.d.e().u(new MessageQueryRequest(3, r137, 2, r38.c + 1, 0, r38.b(), r38.d, r39, 1, false, null, true, 0, null, 13328, null), new b(r38, r135));
        r10 = r135.getOrThrow();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(this);
    L17:
        if (r10 != r1) goto L19;
        return r1;
    L13:
        r137 = null;
        goto L14
    }
}
