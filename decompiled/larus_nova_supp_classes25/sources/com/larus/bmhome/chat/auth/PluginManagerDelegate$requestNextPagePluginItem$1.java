package com.larus.bmhome.chat.auth;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.auth.PluginManagerDelegate$requestNextPagePluginItem$1", f = "PluginManagerDelegate.kt", i = {}, l = {MessageCellStateTransformerType.MSG_SEND_ENTITY}, m = "invokeSuspend", n = {}, s = {})
public final class PluginManagerDelegate$requestNextPagePluginItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Function1<List<PluginItem>, Unit> $callback;
    final /* synthetic */ DowngradeSource $downgradeSource;
    final /* synthetic */ boolean $updateFirstPage;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public PluginManagerDelegate$requestNextPagePluginItem$1(Function1<? super List<PluginItem>, Unit> r1, String r2, boolean r3, DowngradeSource r4, Continuation<? super PluginManagerDelegate$requestNextPagePluginItem$1> r5) {
        this.$callback = r1;
        this.$botId = r2;
        this.$updateFirstPage = r3;
        this.$downgradeSource = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new PluginManagerDelegate$requestNextPagePluginItem$1(this.$callback, this.$botId, this.$updateFirstPage, this.$downgradeSource, r8);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        Function1<List<PluginItem>, Unit> r2 = this.$callback;
        r2.invoke((List) r8);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        PluginManagerDelegate$requestNextPagePluginItem$1$response$1 r3 = new PluginManagerDelegate$requestNextPagePluginItem$1$response$1(this.$botId, this.$updateFirstPage, this.$downgradeSource, null);
        this.label = 1;
        r8 = BuildersKt.withContext(r9, r3, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
