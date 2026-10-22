package com.larus.bmhome.chat.auth;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/bmhome/chat/auth/model/PluginItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.auth.PluginManagerDelegate$requestNextPagePluginItem$1$response$1", f = "PluginManagerDelegate.kt", i = {}, l = {MessageCellStateTransformerType.DOWNLOAD_APP_V2_ENTITY}, m = "invokeSuspend", n = {}, s = {})
public final class PluginManagerDelegate$requestNextPagePluginItem$1$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PluginItem>>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ DowngradeSource $downgradeSource;
    final /* synthetic */ boolean $updateFirstPage;
    int label;

    public PluginManagerDelegate$requestNextPagePluginItem$1$response$1(String r1, boolean r2, DowngradeSource r3, Continuation<? super PluginManagerDelegate$requestNextPagePluginItem$1$response$1> r4) {
        this.$botId = r1;
        this.$updateFirstPage = r2;
        this.$downgradeSource = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new PluginManagerDelegate$requestNextPagePluginItem$1$response$1(this.$botId, this.$updateFirstPage, this.$downgradeSource, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<PluginItem>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        ConcurrentHashMap<String, PluginManager> r6 = PluginManager.d;
        PluginItemPagingCache r7 = PluginManager.a.a(this.$botId).a;
        boolean r2 = this.$updateFirstPage;
        DowngradeSource r3 = this.$downgradeSource;
        this.label = 1;
        r5 = r7.a(r2, r3, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
