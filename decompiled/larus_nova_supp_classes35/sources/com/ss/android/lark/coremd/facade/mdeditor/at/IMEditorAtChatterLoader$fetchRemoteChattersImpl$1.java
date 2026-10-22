package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.RucketJob;
import com.larksuite.rucket.job.base.b;
import com.larksuite.rucket.job.compat.CallbackCompatRucketJob;
import com.larksuite.rucket.job.compat.f;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.coremd.facade.mdeditor.at.IMEditorAtChatterLoader$fetchRemoteChattersImpl$1", f = "IMEditorAtChatterLoader.kt", i = {0, 1}, l = {109, BubbleStyle.ColorType.VIOLET_HEADER_WHITE_BORDER}, m = "invokeSuspend", n = {"checkReq", "serverResp"}, s = {"L$0", "L$0"})
final class IMEditorAtChatterLoader$fetchRemoteChattersImpl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ List<String> $chatterIds;
    final /* synthetic */ Map<String, a.c> $chattersIdToRequestMap;
    final /* synthetic */ Map<String, ChatChatter> $fetchedChatters;
    final /* synthetic */ Map<String, Boolean> $inChatMap;
    Object L$0;
    int label;
    final /* synthetic */ a this$0;

    public IMEditorAtChatterLoader$fetchRemoteChattersImpl$1(Map<String, ChatChatter> r1, String r2, Map<String, Boolean> r3, List<String> r4, Map<String, a.c> r5, a r6, Continuation<? super IMEditorAtChatterLoader$fetchRemoteChattersImpl$1> r7) {
        this.$fetchedChatters = r1;
        this.$chatId = r2;
        this.$inChatMap = r3;
        this.$chatterIds = r4;
        this.$chattersIdToRequestMap = r5;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new IMEditorAtChatterLoader$fetchRemoteChattersImpl$1(this.$fetchedChatters, this.$chatId, this.$inChatMap, this.$chatterIds, this.$chattersIdToRequestMap, null, r10);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        b r2 = (b) this.L$0;
        ResultKt.throwOnFailure(r8);
    L17:
        b r9 = (b) r8;
        r2.getClass();
        if ((!(r2 instanceof b.b)) == false) goto L20;
        this.$fetchedChatters.putAll((Map) r2.b());
    L25:
        r9.getClass();
        if ((!(r9 instanceof b.b)) == false) goto L28;
        this.$inChatMap.putAll((Map) r9.b());
    L33:
        List<String> r10 = this.$chatterIds;
        Map<String, ChatChatter> r3 = this.$fetchedChatters;
        Map<String, a.c> r4 = this.$chattersIdToRequestMap;
        Iterator<T> r11 = r10.iterator();
    L35:
        if (r11.hasNext() == false) goto L45;
        String r5 = (String) r11.next();
        ChatChatter r6 = r3.get(r5);
        if (r4.get(r5) == null) goto L35;
        if (r6 != null) goto L42;
        new ErrorResult(BuildConfig.FLAVOR);
        throw null;
    L42:
        int r12 = a.a;
        throw null;
    L45:
        return Unit.INSTANCE;
    L28:
        StringBuilder r7 = new StringBuilder("check chatters in chat failed, chatId = ");
        r7.append(this.$chatId);
        r7.append(", error = ");
        ErrorResult r13 = r9.a();
        if (r13 == null) goto L31;
        String r14 = r13.getDisplayMsg();
    L32:
        r7.append(r14);
        Log.e("IMEditorChatterLoader", r7.toString());
        goto L33
    L31:
        r14 = null;
        goto L32
    L20:
        StringBuilder r15 = new StringBuilder("load chat chatters failed, chatId = ");
        r15.append(this.$chatId);
        r15.append(", error = ");
        ErrorResult r16 = r2.a();
        if (r16 == null) goto L23;
        String r17 = r16.getDisplayMsg();
    L24:
        r15.append(r17);
        Log.e("IMEditorChatterLoader", r15.toString());
        goto L25
    L23:
        r17 = null;
        goto L24
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        RucketJob r18 = (RucketJob) this.L$0;
        ResultKt.throwOnFailure(r8);
    L13:
        b r19 = (b) r8;
        this.L$0 = r19;
        this.label = 2;
        Object r20 = r18.awaitGet(this);
        if (r20 != r0) goto L16;
        return r0;
    L16:
        r2 = r19;
        r8 = r20;
        goto L17
    L10:
        ResultKt.throwOnFailure(r8);
        final String r21 = this.$chatId;
        final List<String> r22 = this.$chatterIds;
        CallbackCompatRucketJob r23 = f.a(new IMEditorAtChatterLoader$fetchRemoteChattersImpl$1$serverReq$1(r21, r22));
        final List<String> r24 = this.$chatterIds;
        final String r25 = this.$chatId;
        r18 = f.a(new IMEditorAtChatterLoader$fetchRemoteChattersImpl$1$checkReq$1(r24, r25));
        this.L$0 = r18;
        this.label = 1;
        r8 = r23.awaitGet(this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
