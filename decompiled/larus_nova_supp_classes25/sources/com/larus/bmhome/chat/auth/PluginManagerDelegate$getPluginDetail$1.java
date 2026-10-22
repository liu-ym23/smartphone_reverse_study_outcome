package com.larus.bmhome.chat.auth;

import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.auth.PluginManagerDelegate$getPluginDetail$1", f = "PluginManagerDelegate.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
final class PluginManagerDelegate$getPluginDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Function1<PluginItem, Unit> $callback;
    final /* synthetic */ String $pluginId;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public PluginManagerDelegate$getPluginDetail$1(String r1, String r2, Function1<? super PluginItem, Unit> r3, Continuation<? super PluginManagerDelegate$getPluginDetail$1> r4) {
        this.$botId = r1;
        this.$pluginId = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new PluginManagerDelegate$getPluginDetail$1(this.$botId, this.$pluginId, this.$callback, r5);
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
        PluginItem r2 = null;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L22:
        PluginItem r9 = (PluginItem) r8;
        PluginManagerDelegate r4 = PluginManagerDelegate.a;
        String r5 = this.$botId;
        if (r9 == null) goto L42;
        ConcurrentHashMap<String, PluginManager> r6 = PluginManager.d;
        PluginItemPagingCache r7 = PluginManager.a.a(r5).a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r9, "pluginItem");
        Iterator<PluginItem> r10 = r7.d.iterator();
    L27:
        if (r10.hasNext() == false) goto L31;
        PluginItem r11 = r10.next();
        if (Intrinsics.areEqual(r11.pluginId, r9.pluginId) == false) goto L27;
        r2 = r11;
    L31:
        PluginItem r12 = r2;
        if (r12 == null) goto L41;
        CopyOnWriteArrayList<PluginItem> r13 = r7.d;
        int r14 = r13.indexOf(r12);
        if (r14 >= 0) goto L36;
    L38:
        r3 = false;
    L39:
        if (r3 == false) goto L42;
        r13.set(r14, r9);
        goto L42
    L36:
        if (r14 >= r7.d.size()) goto L38;
    L41:
        r7.d.add(r9);
    L42:
        this.$callback.invoke(r9);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        ConcurrentHashMap<String, PluginManager> r15 = PluginManager.d;
        PluginItemPagingCache r16 = PluginManager.a.a(this.$botId).a;
        String r17 = this.$pluginId;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "pluginId");
        Iterator<PluginItem> r18 = r16.d.iterator();
    L10:
        if (r18.hasNext() == false) goto L14;
        PluginItem r19 = r18.next();
        if (Intrinsics.areEqual(r19.pluginId, r17) == false) goto L10;
    L15:
        PluginItem r20 = r19;
        if (r20 == null) goto L19;
        this.$callback.invoke(r20);
        return Unit.INSTANCE;
    L19:
        CoroutineDispatcher r21 = Dispatchers.getIO();
        PluginManagerDelegate$getPluginDetail$1$response$1 r22 = new PluginManagerDelegate$getPluginDetail$1$response$1(this.$botId, this.$pluginId, null);
        this.label = 1;
        r8 = BuildersKt.withContext(r21, r22, this);
        if (r8 != r0) goto L22;
        return r0;
    L14:
        r19 = null;
        goto L15
    }
}
