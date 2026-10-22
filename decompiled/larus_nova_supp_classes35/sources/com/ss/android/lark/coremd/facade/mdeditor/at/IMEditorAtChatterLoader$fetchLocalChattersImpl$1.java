package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.coremd.facade.mdeditor.at.IMEditorAtChatterLoader$fetchLocalChattersImpl$1", f = "IMEditorAtChatterLoader.kt", i = {0, 0}, l = {64}, m = "invokeSuspend", n = {"chatterIds", "chattersIdToRequestMap"}, s = {"L$0", "L$1"})
final class IMEditorAtChatterLoader$fetchLocalChattersImpl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ List<a.c> $requests;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ a this$0;

    public IMEditorAtChatterLoader$fetchLocalChattersImpl$1(List<a.c> r1, String r2, a r3, Continuation<? super IMEditorAtChatterLoader$fetchLocalChattersImpl$1> r4) {
        this.$requests = r1;
        this.$chatId = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new IMEditorAtChatterLoader$fetchLocalChattersImpl$1(this.$requests, this.$chatId, null, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Map r2 = (Map) this.L$1;
        List r3 = (List) this.L$0;
        ResultKt.throwOnFailure(r8);
    L16:
        Map r9 = (Map) r8;
        Iterator r4 = r3.iterator();
        if (r4.hasNext() == false) goto L28;
        String r5 = (String) r4.next();
        ChatChatter r10 = (ChatChatter) r9.get(r5);
        if (((a.c) r2.get(r5)) == null) goto L21;
        if (r10 != null) goto L25;
        new ErrorResult(BuildConfig.FLAVOR);
        throw null;
    L25:
        int r11 = a.a;
        throw null;
    L21:
        return Unit.INSTANCE;
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        List<a.c> r12 = this.$requests;
        r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
        if (r13.hasNext() == true) goto L31;
        List<a.c> r14 = this.$requests;
        LinkedHashMap r6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r14, 10)), 16));
        Iterator<T> r15 = r14.iterator();
        if (r15.hasNext() == true) goto L29;
        CoroutineDispatcher r16 = Dispatchers.getIO();
        IMEditorAtChatterLoader$fetchLocalChattersImpl$1$fetchedChatters$1 r7 = new IMEditorAtChatterLoader$fetchLocalChattersImpl$1$fetchedChatters$1(this.$chatId, r3, null);
        this.L$0 = r3;
        this.L$1 = r6;
        this.label = 1;
        r8 = BuildersKt.withContext(r16, r7, this);
        if (r8 != r0) goto L15;
        return r0;
    L15:
        r2 = r6;
        goto L16
    L29:
        ((a.c) r15.next()).getClass();
        throw null;
    L31:
        ((a.c) r13.next()).getClass();
        throw null;
    }
}
