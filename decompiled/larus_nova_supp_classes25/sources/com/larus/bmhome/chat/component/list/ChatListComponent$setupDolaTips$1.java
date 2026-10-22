package com.larus.bmhome.chat.component.list;

import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.tips.IGuideTipsService;
import com.larus.bmhome.chat.tips.a;
import com.larus.common_ui.dialog.DolaTipsDialogFragment;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
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
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$setupDolaTips$1", f = "ChatListComponent.kt", i = {}, l = {2114, 2130}, m = "invokeSuspend", n = {}, s = {})
final class ChatListComponent$setupDolaTips$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $firstInstallTime;
    final /* synthetic */ long $lastUpdateTime;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public ChatListComponent$setupDolaTips$1(ChatListComponent r1, long r2, long r4, Continuation<? super ChatListComponent$setupDolaTips$1> r6) {
        this.this$0 = r1;
        this.$lastUpdateTime = r2;
        this.$firstInstallTime = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatListComponent$setupDolaTips$1(this.this$0, this.$lastUpdateTime, this.$firstInstallTime, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L35:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L18:
        if (((Boolean) r12).booleanValue() == false) goto L22;
        FLogger.a.i(this.this$0.n, "DolaTipsDialogFragment hasShow");
        return Unit.INSTANCE;
    L22:
        if (this.$lastUpdateTime == this.$firstInstallTime) goto L26;
        IGuideTipsService r13 = (IGuideTipsService) ServiceManager.get().getService(IGuideTipsService.class);
        if (r13 == null) goto L35;
        a r2 = new a(6, "", "");
        final ChatListComponent r3 = this.this$0;
        Boxing.boxBoolean(r13.g(r2, new m6(r3)));
        goto L35
    L26:
        FLogger.a.i(this.this$0.n, "restoreCheckStatus");
        DolaTipsDialogFragment.Companion r14 = DolaTipsDialogFragment.e;
        this.label = 2;
        ((Keva) DolaTipsDialogFragment.f.getValue()).storeBoolean("default", true);     // Catch: Exception -> L29
    L32:
        if (Unit.INSTANCE != r0) goto L35;
        return r0;
    L29:
        e = move-exception;
        FLogger.a.e("DolaTipsDialogFragment", "restoreCheckStatus exception: " + e);
        goto L32
    L10:
        ResultKt.throwOnFailure(r12);
        DolaTipsDialogFragment.Companion r15 = DolaTipsDialogFragment.e;
        this.label = 1;
        r12 = Boxing.boxBoolean(((Keva) DolaTipsDialogFragment.f.getValue()).getBoolean("default", false));     // Catch: Exception -> L13
    L15:
        if (r12 != r0) goto L18;
        return r0;
    L13:
        e = move-exception;
        FLogger.a.e("DolaTipsDialogFragment", "restoreCheckStatus exception: " + e);
        r12 = Boxing.boxBoolean(true);
        goto L15
    }
}
