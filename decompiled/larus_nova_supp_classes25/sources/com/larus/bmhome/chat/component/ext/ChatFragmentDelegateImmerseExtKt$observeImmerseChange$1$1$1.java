package com.larus.bmhome.chat.component.ext;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import by7.h;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.f;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.ext.ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1$1$1", f = "ChatFragmentDelegateImmerseExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ WeakReference<ChatFragment> $fragmentRef;
    final /* synthetic */ nq9.b $it;
    final /* synthetic */ String $tag;
    int label;

    public ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1$1$1(String r1, WeakReference<ChatFragment> r2, String r3, nq9.b r4, Continuation<? super ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1$1$1> r5) {
        this.$tag = r1;
        this.$fragmentRef = r2;
        this.$conversationId = r3;
        this.$it = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatFragmentDelegateImmerseExtKt$observeImmerseChange$1$1$1(this.$tag, this.$fragmentRef, this.$conversationId, this.$it, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r5);
        FLogger.a.i(this.$tag, "switch to immersive, restart activity");
        ChatFragment r6 = this.$fragmentRef.get();
        if (r6 == null) goto L9;
        FragmentActivity r7 = r6.getActivity();
        if (r7 == null) goto L9;
        r7.finish();
    L9:
        ChatFragment r8 = this.$fragmentRef.get();
        if (r8 == null) goto L12;
        Context r9 = r8.getContext();
    L13:
        i r10 = SmartRouter.buildRoute(r9, "//flow/chat_page");
        Bundle r0 = f.c(new Pair[]{TuplesKt.to("argConversationId", this.$conversationId), TuplesKt.to("argBotId", this.$it.a), TuplesKt.to("argCvsBgImgUrl", this.$it.b), TuplesKt.to("argCvsBgImgColor", this.$it.c), TuplesKt.to("argCvsBgImgOpen", Boxing.boxBoolean(true)), TuplesKt.to("is_from_recreate", Boxing.boxBoolean(true))});
        ChatFragment r1 = this.$fragmentRef.get();
        if (r1 == null) goto L16;
        h.k(r0, r1);
    L16:
        r10.c.putExtras(r0);
        r10.d = 2130772399;
        r10.e = 2130772399;
        r10.d();
        return Unit.INSTANCE;
    L12:
        r9 = null;
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
