package com.larus.bmhome.chat.manager;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.manager.ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1$actionBarItem$1", f = "ChatListScreenMenuManager.kt", i = {0}, l = {405, 424}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull"}, s = {"L$0"})
public final class ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1$actionBarItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super z0>, Object> {
    final /* synthetic */ Deferred<z0> $actionBarItemDeferred;
    final /* synthetic */ IActionBarService $actionBarService;
    final /* synthetic */ String $botId;
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements Function1<List<? extends z0>, Unit> {
        public final /* synthetic */ CompletableDeferred<z0> a;

        public a(CompletableDeferred<z0> r1) {
            this.a = r1;
        }

        public final Object invoke(Object r6) {
            List r7 = (List) r6;
            CompletableDeferred<z0> r0 = this.a;
            Object r1 = null;
            if (r7 == null) goto L19;
            Iterator r8 = r7.iterator();
        L6:
            if (r8.hasNext() == false) goto L18;
            Object r2 = r8.next();
            com.larus.bmhome.actionbar.model.p0 r3 = ((z0) r2).o;
            if (r3 == null) goto L15;
            Integer r4 = r3.a;
            int r5 = ActiveSwitchType.DEEPTHINK.getValue();
            if (r4 == null) goto L15;
            if (r4.intValue() != r5) goto L15;
            boolean r9 = true;
        L16:
            if (r9 == false) goto L6;
            r1 = r2;
        L15:
            r9 = false;
        L18:
            r1 = (z0) r1;
        L19:
            r0.complete(r1);
            return Unit.INSTANCE;
        }
    }

    public ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1$actionBarItem$1(Deferred<z0> r1, IActionBarService r2, LifecycleOwner r3, String r4, Continuation<? super ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1$actionBarItem$1> r5) {
        this.$actionBarItemDeferred = r1;
        this.$actionBarService = r2;
        this.$lifecycleOwner = r3;
        this.$botId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1$actionBarItem$1 r6 = new ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$1$1$actionBarItem$1(this.$actionBarItemDeferred, this.$actionBarService, this.$lifecycleOwner, this.$botId, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super z0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L25:
        return (z0) r8;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);
    L15:
        z0 r9 = (z0) r8;
        if (r9 != null) goto L26;
    L17:
        IActionBarService r10 = this.$actionBarService;
        LifecycleOwner r3 = this.$lifecycleOwner;
        String r4 = this.$botId;
        CompletableDeferred r5 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        if (r10 != null) goto L20;
        Boxing.boxBoolean(r5.complete(null));
    L21:
        this.L$0 = null;
        this.label = 2;
        r8 = r5.await(this);
        if (r8 != r0) goto L25;
        return r0;
    L20:
        r10.d(LifecycleOwnerKt.getLifecycleScope(r3), r4, new a(r5));
        goto L21
    L26:
        return r9;
    L10:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        Deferred<z0> r6 = this.$actionBarItemDeferred;
        if (r6 == null) goto L17;
        this.L$0 = r11;
        this.label = 1;
        r8 = r6.await(this);
        if (r8 != r0) goto L15;
        return r0;
    }
}
