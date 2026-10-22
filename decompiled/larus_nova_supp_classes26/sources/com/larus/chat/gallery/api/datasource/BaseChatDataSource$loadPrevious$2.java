package com.larus.chat.gallery.api.datasource;

import com.larus.gallery.api.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageQueryRequest;
import com.larus.im.d;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "com.larus.chat.gallery.api.datasource.BaseChatDataSource$loadPrevious$2", f = "BaseChatDataSource.kt", i = {0, 1}, l = {120, 137}, m = "invokeSuspend", n = {"$this$coroutineScope", "hasMore"}, s = {"L$0", "I$0"})
final class BaseChatDataSource$loadPrevious$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b0.b<List<Object>>>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseChatDataSource<Object> this$0;

    public BaseChatDataSource$loadPrevious$2(BaseChatDataSource<Object> r1, Continuation<? super BaseChatDataSource$loadPrevious$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BaseChatDataSource$loadPrevious$2 r0 = new BaseChatDataSource$loadPrevious$2(this.this$0, r4);
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
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [boolean, int] */
    public final Object invokeSuspend(Object r36) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r6 = true;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r36);
        Object r4 = r36;
        ?? r5 = r3;
    L50:
        List r7 = CollectionsKt.flatten((List) r4);
        FLogger.a.i(this.this$0.c, "loadPrevious, end");
        if (r5 != 0) goto L55;
        r6 = false;
    L55:
        return new b0.b(r7, false, r6, 2);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r36);
        Object r9 = r36;
    L19:
        ty8.c r10 = (ty8.c) r9;
        if (r10 == null) goto L23;
        List<Message> r11 = r10.a;
        if (r11 == null) goto L23;
    L24:
        BaseChatDataSource<Object> r12 = this.this$0;
        if (r12.e == true) goto L27;
    L39:
        if (r10 == null) goto L41;
        ?? r13 = r10.b;
    L42:
        FLogger.a.i(this.this$0.c, "loadPrevious, hasMore: " + r13 + ", serverMessageList size: " + r11.size());
        List<Message> r14 = r11;
        BaseChatDataSource<Object> r15 = this.this$0;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r17 = r14.iterator();
    L44:
        if (r17.hasNext() == false) goto L46;
        r16.add(BuildersKt.async$default(r8, null, null, new BaseChatDataSource$loadPrevious$2$galleryDataLists$1$1(r15, (Message) r17.next(), null), 3, null));
        goto L44
    L46:
        this.L$0 = null;
        this.I$0 = r13;
        this.label = 2;
        r4 = AwaitKt.a(r16, this);
        if (r4 != r1) goto L49;
        return r1;
    L49:
        r5 = r13;
        goto L50
    L41:
        r13 = 0;
        goto L42
    L27:
        if ((!r11.isEmpty()) == false) goto L39;
        r12.e = false;
        ArrayList r18 = new ArrayList();
        Iterator r19 = r11.iterator();
    L30:
        if (r19.hasNext() == false) goto L38;
        Object r110 = r19.next();
        String r111 = ((Message) r110).getMessageId();
        Message r112 = r12.b;
        if (r112 == null) goto L34;
        String r113 = r112.getMessageId();
    L36:
        if ((!Intrinsics.areEqual(r111, r113)) == false) goto L30;
        r18.add(r110);
        goto L30
    L34:
        r113 = null;
        goto L36
    L38:
        r11 = r18;
    L23:
        r11 = CollectionsKt.emptyList();
        goto L24
    L10:
        ResultKt.throwOnFailure(r36);
        r8 = (CoroutineScope) this.L$0;
        BaseChatDataSource<Object> r20 = this.this$0;
        a r21 = r20.h;
        int r22 = RangesKt.coerceAtMost(r20.g, 50);
        this.L$0 = r8;
        this.label = 1;
        r21.getClass();
        FLogger.a.i("GalleryMessageLoadProcessor", "loadPrevious, startTime: " + r21.c + ", pageSize: " + r22);
        SafeContinuation r23 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        Message r114 = r21.b;
        if (r114 == null) goto L13;
        String r115 = r114.getConversationId();
    L14:
        long r116 = r22;
        d.e().u(new MessageQueryRequest(3, r115, 1, RangesKt.coerceAtLeast(r21.c - 1, 0), 0, r21.b(), r21.e, r116, 1, false, null, true, 0, null, 13328, null), new c(r21, r23));
        r9 = r23.getOrThrow();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(this);
    L17:
        if (r9 != r1) goto L19;
        return r1;
    L13:
        r115 = null;
        goto L14
    }
}
