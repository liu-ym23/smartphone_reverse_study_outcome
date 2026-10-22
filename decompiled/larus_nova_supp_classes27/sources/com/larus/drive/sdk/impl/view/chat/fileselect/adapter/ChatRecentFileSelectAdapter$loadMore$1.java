package com.larus.drive.sdk.impl.view.chat.fileselect.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.drive.sdk.impl.view.chat.fileselect.data.ChatRecentFileLoadProcessor;
import com.larus.platform.api.u;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.adapter.ChatRecentFileSelectAdapter$loadMore$1", f = "ChatRecentFileSelectAdapter.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
public final class ChatRecentFileSelectAdapter$loadMore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatRecentFileSelectAdapter this$0;

    public ChatRecentFileSelectAdapter$loadMore$1(ChatRecentFileSelectAdapter r1, Continuation<? super ChatRecentFileSelectAdapter$loadMore$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatRecentFileSelectAdapter$loadMore$1 r0 = new ChatRecentFileSelectAdapter$loadMore$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        ChatRecentFileSelectAdapter r2 = (ChatRecentFileSelectAdapter) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L42
    L17:
        x79.c r16 = (x79.c) r15;     // Catch: Throwable -> L42
    L19:
        if (r16 == null) goto L22;
        List<x79.b> r3 = r16.a;     // Catch: Throwable -> L42
        if (r3 == null) goto L22;
    L23:
        int r5 = r2.l.size();     // Catch: Throwable -> L42
        Iterator<T> r6 = r3.iterator();     // Catch: Throwable -> L42
        int r7 = 0;
    L25:
        if (r6.hasNext() == false) goto L32;
        x79.b r8 = (x79.b) r6.next();     // Catch: Throwable -> L42
        u r9 = ChatRecentFileSelectAdapter.C2(r2, r8);     // Catch: Throwable -> L42
        String r10 = ChatRecentFileSelectAdapter.E2(r9.a);     // Catch: Throwable -> L42
        if (r10 == null) goto L28;
        if (r2.l.containsKey(r10) == true) goto L25;
        r2.l.put(r10, r9);     // Catch: Throwable -> L42
        r2.m.put(r10, Boxing.boxLong(r8.f));     // Catch: Throwable -> L42
        goto L25
    L28:
        r7 = r7 + 1;     // Catch: Throwable -> L42
        goto L25
    L32:
        if (r7 <= 0) goto L34;
        FLogger.a.w("ChatRecentFileSelectAdapter", "loadMore skipped files with empty resource token, count: " + r7);     // Catch: Throwable -> L42
    L34:
        int r11 = (r5 + (r3.size() - r7)) - r2.l.size();     // Catch: Throwable -> L42
        if (r16 != null) goto L37;
    L39:
        boolean r17 = false;
    L40:
        r2.j = r17;     // Catch: Throwable -> L42
        FLogger.a.i("ChatRecentFileSelectAdapter", "loadMore merged recent files, receivedCount: " + r3.size() + ", deduplicatedCount: " + r11 + ", uniqueTotal: " + r2.l.size() + ", hasMore: " + r2.j);     // Catch: Throwable -> L42
        r2.i = false;     // Catch: Throwable -> L42
        r2.F2(ChatRecentFileSelectAdapter.B2(r2));     // Catch: Throwable -> L42
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L44:
        ChatRecentFileSelectAdapter r4 = this.this$0;
        Throwable r110 = Result.exceptionOrNull-impl(r18);
        if (r110 == null) goto L47;
        FLogger.a.e("ChatRecentFileSelectAdapter", "loadMore failed", r110);
        r4.i = false;
        r4.F2(r4.getCurrentList());
    L47:
        ChatRecentFileSelectAdapter r111 = this.this$0;
        if (r111.k == false) goto L52;
        r111.k = false;
        ChatRecentFileSelectAdapter.b r12 = r111.e;
        if (r12 == null) goto L52;
        r12.b(!r111.l.isEmpty());
    L52:
        final ChatRecentFileSelectAdapter r112 = this.this$0;
        final RecyclerView r13 = r112.g;
        if (r13 == null) goto L62;
        if (r112.i == true) goto L62;
        if (r112.j == false) goto L62;
        r13.post(new g(r112, r13));
    L62:
        return Unit.INSTANCE;
    L37:
        if (r16.b != true) goto L39;
        r17 = true;
    L22:
        r3 = CollectionsKt.emptyList();     // Catch: Throwable -> L42
        goto L23
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r113 = (CoroutineScope) this.L$0;
        ChatRecentFileSelectAdapter r114 = this.this$0;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L42
        ChatRecentFileLoadProcessor r20 = r114.h;     // Catch: Throwable -> L42
        if (r20 == null) goto L18;
        this.L$0 = r114;     // Catch: Throwable -> L42
        this.label = 1;     // Catch: Throwable -> L42
        Object r21 = ChatRecentFileLoadProcessor.a(r20, this);     // Catch: Throwable -> L42
        if (r21 != r0) goto L16;
        return r0;
    L16:
        r2 = r114;
        r15 = r21;
        goto L17
    L18:
        r2 = r114;
        r16 = null;
    L42:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    }
}
