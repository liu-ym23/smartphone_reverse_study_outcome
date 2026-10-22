package com.larus.bmhome.chat.manager;

import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.manager.ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$actionBarItemDeferred$1", f = "ChatListScreenMenuManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$actionBarItemDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super z0>, Object> {
    final /* synthetic */ String $forkBotId;
    int label;

    public ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$actionBarItemDeferred$1(String r1, Continuation<? super ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$actionBarItemDeferred$1> r2) {
        this.$forkBotId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatListScreenMenuManager$showScreenMenu$3$2$1$1$1$actionBarItemDeferred$1(this.$forkBotId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super z0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r6);
        IActionBarService r7 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        Object r0 = null;
        if (r7 == null) goto L32;
        List r8 = r7.f(this.$forkBotId);
        if (r8 == null) goto L33;
        Iterator r9 = r8.iterator();
    L10:
        if (r9.hasNext() == false) goto L22;
        Object r1 = r9.next();
        com.larus.bmhome.actionbar.model.p0 r2 = ((z0) r1).o;
        boolean r3 = false;
        if (r2 == null) goto L19;
        Integer r4 = r2.a;
        int r5 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r4 == null) goto L19;
        if (r4.intValue() != r5) goto L19;
        r3 = true;
    L19:
        if (r3 == false) goto L10;
        r0 = r1;
    L22:
        return (z0) r0;
    L33:
        return null;
    L32:
        return null;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
