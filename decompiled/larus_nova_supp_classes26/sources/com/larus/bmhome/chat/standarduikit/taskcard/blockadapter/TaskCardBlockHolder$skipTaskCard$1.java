package com.larus.bmhome.chat.standarduikit.taskcard.blockadapter;

import com.larus.im.bean.message.block.ActionParams;
import com.larus.im.bean.message.block.ComputerBrowser;
import com.larus.im.bean.message.block.TaskCardBlock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.taskcard.blockadapter.TaskCardBlockHolder$skipTaskCard$1", f = "TaskCardBlockHolder.kt", i = {}, l = {262}, m = "invokeSuspend", n = {}, s = {})
final class TaskCardBlockHolder$skipTaskCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ vn8.a $vmData;
    int label;

    public TaskCardBlockHolder$skipTaskCard$1(vn8.a r1, Continuation<? super TaskCardBlockHolder$skipTaskCard$1> r2) {
        this.$vmData = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TaskCardBlockHolder$skipTaskCard$1(this.$vmData, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        int r5 = com.larus.bmhome.chat.standarduikit.browsercontrol.vm.e.a;
        TaskCardBlock r6 = this.$vmData.d;
        if (r6 == null) goto L16;
        ActionParams r7 = r6.actionParam;
        if (r7 == null) goto L16;
        ComputerBrowser r8 = r7.computerBrowser;
        if (r8 == null) goto L16;
        String r9 = r8.toolCallId;
        if (r9 == null) goto L16;
    L17:
        this.label = 1;
        if (com.larus.bmhome.chat.standarduikit.browsercontrol.vm.e.a(r9, this) != r0) goto L21;
        return r0;
    L16:
        r9 = "";
        goto L17
    }
}
