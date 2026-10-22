package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.coremd.facade.mdeditor.at.IMEditorAtChatterLoader$fetchLocalChattersImpl$1$fetchedChatters$1", f = "IMEditorAtChatterLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class IMEditorAtChatterLoader$fetchLocalChattersImpl$1$fetchedChatters$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends ChatChatter>>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ List<String> $chatterIds;
    int label;

    public IMEditorAtChatterLoader$fetchLocalChattersImpl$1$fetchedChatters$1(String r1, List<String> r2, Continuation<? super IMEditorAtChatterLoader$fetchLocalChattersImpl$1$fetchedChatters$1> r3) {
        this.$chatId = r1;
        this.$chatterIds = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new IMEditorAtChatterLoader$fetchLocalChattersImpl$1$fetchedChatters$1(this.$chatId, this.$chatterIds, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Map<String, ? extends ChatChatter>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        return ImSdkService.d().I3(this.$chatId, this.$chatterIds);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
