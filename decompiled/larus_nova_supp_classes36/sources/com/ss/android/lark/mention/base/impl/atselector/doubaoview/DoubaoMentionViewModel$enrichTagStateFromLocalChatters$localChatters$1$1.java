package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.service.ImSdkService;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.mention.base.impl.atselector.doubaoview.DoubaoMentionViewModel$enrichTagStateFromLocalChatters$localChatters$1$1", f = "DoubaoMentionViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoubaoMentionViewModel$enrichTagStateFromLocalChatters$localChatters$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends Chatter>>, Object> {
    final /* synthetic */ List<String> $chatterIds;
    int label;

    public DoubaoMentionViewModel$enrichTagStateFromLocalChatters$localChatters$1$1(List<String> r1, Continuation<? super DoubaoMentionViewModel$enrichTagStateFromLocalChatters$localChatters$1$1> r2) {
        this.$chatterIds = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoubaoMentionViewModel$enrichTagStateFromLocalChatters$localChatters$1$1(this.$chatterIds, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Map<String, ? extends Chatter>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        return ImSdkService.d().a0(this.$chatterIds);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
