package com.larus.bmhome.chat.helper;

import android.app.Application;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.conversation.ConversationDeleteMode;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.helper.ConversationDeleteUndoHelper$fakeDelete$1$1", f = "ConversationDeleteUndoHelper.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
final class ConversationDeleteUndoHelper$fakeDelete$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationId;
    int label;

    public ConversationDeleteUndoHelper$fakeDelete$1$1(String r1, String r2, Continuation<? super ConversationDeleteUndoHelper$fakeDelete$1$1> r3) {
        this.$conversationId = r1;
        this.$botId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ConversationDeleteUndoHelper$fakeDelete$1$1(this.$conversationId, this.$botId, r4);
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r8);     // Catch: Exception -> L15
    L13:
        boolean r9 = ((Boolean) r8).booleanValue();     // Catch: Exception -> L15
    L17:
        FLogger.a.i("ConversationDeleteUndoHelper", "real delete finished conversationId=" + this.$conversationId + " succeeded=" + r9);
        Set<String> r2 = SetsKt.minus(f0.c, this.$conversationId);
        f0.c = r2;
        Iterator r3 = CollectionsKt.toList(f0.b.keySet()).iterator();
    L19:
        if (r3.hasNext() == false) goto L21;
        ((f0.a) r3.next()).a(r2);
        goto L19
    L21:
        if (r9 == true) goto L24;
        t19.s r10 = t19.s.a;
        Application r4 = AppHost.a.getApplication();
        r10.getClass();
        t19.s.b(r4, 2131908800, false);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
        IConversationRepoService r11 = RepoDispatcherDelegate.b.f();     // Catch: Exception -> L15
        String r5 = this.$conversationId;     // Catch: Exception -> L15
        ConversationDeleteMode r6 = ConversationDeleteMode.DeleteMode_RealDelete;     // Catch: Exception -> L15
        String r7 = this.$botId;     // Catch: Exception -> L15
        this.label = 1;     // Catch: Exception -> L15
        r8 = r11.l(r5, r6, r7, this);     // Catch: Exception -> L15
        if (r8 != r0) goto L13;
        return r0;
    L15:
        e = move-exception;
        FLogger.a.e("ConversationDeleteUndoHelper", "real delete failed, conversationId=" + this.$conversationId, e);
        r9 = false;
        goto L17
    }
}
