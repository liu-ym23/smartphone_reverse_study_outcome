package com.ss.android.lark.compose.chatterselector.card;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatterselector.card.FlowCardMemberPickerActivity$submitSelectedIds$1", f = "FlowCardMemberPickerActivity.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
final class FlowCardMemberPickerActivity$submitSelectedIds$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ String $key;
    final /* synthetic */ FlowCardMemberRepository $repository;
    final /* synthetic */ Set<String> $selectedIds;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FlowCardMemberPickerActivity this$0;

    public FlowCardMemberPickerActivity$submitSelectedIds$1(FlowCardMemberRepository r1, Set<String> r2, String r3, String r4, FlowCardMemberPickerActivity r5, Continuation<? super FlowCardMemberPickerActivity$submitSelectedIds$1> r6) {
        this.$repository = r1;
        this.$selectedIds = r2;
        this.$chatId = r3;
        this.$key = r4;
        this.this$0 = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        FlowCardMemberPickerActivity$submitSelectedIds$1 r7 = new FlowCardMemberPickerActivity$submitSelectedIds$1(this.$repository, this.$selectedIds, this.$chatId, this.$key, this.this$0, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L15
    L13:
        Object r7 = Result.constructor-impl((List) r6);     // Catch: Throwable -> L15
    L17:
        String r2 = this.$key;
        FlowCardMemberPickerActivity r3 = this.this$0;
        if (Result.isSuccess-impl(r7) == false) goto L23;
        List r4 = (List) r7;
        IGetDataCallback r5 = (IGetDataCallback) ((ConcurrentHashMap) FlowCardMemberPickerActivity.d).remove(r2);
        if (r5 == null) goto L22;
        r5.onSuccess(r4);
    L22:
        r3.finish();
    L23:
        String r8 = this.$key;
        FlowCardMemberPickerActivity r9 = this.this$0;
        ErrorResult r10 = Result.exceptionOrNull-impl(r7);
        if (r10 == null) goto L39;
        IGetDataCallback r11 = (IGetDataCallback) ((ConcurrentHashMap) FlowCardMemberPickerActivity.d).remove(r8);
        if (r11 == null) goto L37;
        r9.getClass();
        if ((r10 instanceof ErrorResult) == false) goto L30;
        ErrorResult r12 = r10;
    L31:
        if (r12 != null) goto L36;
        String r13 = r10.getMessage();
        if (r13 != null) goto L35;
        r13 = "pick member failed";
    L35:
        r12 = new ErrorResult(r13);
    L36:
        r11.onError(r12);
        goto L37
    L30:
        r12 = null;
    L37:
        r9.finish();
    L39:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        FlowCardMemberRepository r15 = this.$repository;
        Set<String> r16 = this.$selectedIds;
        String r17 = this.$chatId;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L15
        List<String> r19 = CollectionsKt.toList(r16);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r6 = r15.a(r19, r17, this);     // Catch: Throwable -> L15
        if (r6 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
