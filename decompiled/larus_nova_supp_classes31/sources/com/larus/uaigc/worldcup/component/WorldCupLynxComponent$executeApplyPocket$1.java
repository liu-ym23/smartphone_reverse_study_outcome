package com.larus.uaigc.worldcup.component;

import com.larus.uaigc.lynx.pocket.Pocket;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.worldcup.component.WorldCupLynxComponent$executeApplyPocket$1", f = "WorldCupLynxComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class WorldCupLynxComponent$executeApplyPocket$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $extra;
    final /* synthetic */ boolean $isFromAvatarResult;
    final /* synthetic */ Map<String, Object> $originData;
    int label;
    final /* synthetic */ WorldCupLynxComponent this$0;

    public WorldCupLynxComponent$executeApplyPocket$1(Map<String, ? extends Object> r1, WorldCupLynxComponent r2, Map<String, ? extends Object> r3, boolean r4, Continuation<? super WorldCupLynxComponent$executeApplyPocket$1> r5) {
        this.$originData = r1;
        this.this$0 = r2;
        this.$extra = r3;
        this.$isFromAvatarResult = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new WorldCupLynxComponent$executeApplyPocket$1(this.$originData, this.this$0, this.$extra, this.$isFromAvatarResult, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L30;
        ResultKt.throwOnFailure(r10);
        Map<String, Object> r11 = this.$originData;
        WorldCupLynxComponent r1 = this.this$0;
        Map<String, Object> r2 = this.$extra;
        boolean r3 = this.$isFromAvatarResult;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L25
        Pocket r5 = com.larus.uaigc.lynx.pocket.d.e(r11);     // Catch: Throwable -> L25
        int r6 = WorldCupLynxComponent.E;     // Catch: Throwable -> L25
        r1.y = null;     // Catch: Throwable -> L25
        c0a.a r7 = (c0a.a) r1.s.getValue();     // Catch: Throwable -> L25
        if (r7 == null) goto L8;
        r7.O2(null);     // Catch: Throwable -> L25
    L8:
        FLogger r8 = FLogger.a;     // Catch: Throwable -> L25
        r8.i(r1.m, "[clearAlbumClickPocketInfo] finish, currClickPocketInfo = null");     // Catch: Throwable -> L25
        r8.i(r1.m, "[executeApplyPocket] pocketId = " + r5.getPocketId() + ", pocketType = " + r5.getPocketType());     // Catch: Throwable -> L25
        Integer r0 = r5.getPocketType();     // Catch: Throwable -> L25
        if (r0 == null) goto L18;
        boolean r9 = true;
        if (r0.intValue() != 1) goto L18;
        r1.x = null;     // Catch: Throwable -> L25
        r8.i(r1.m, "[clearCurrClickPocketInfo] finish, currClickPocketInfo = null");     // Catch: Throwable -> L25
        if (r3 == true) goto L17;
        r9 = false;
    L17:
        WorldCupLynxComponent.p3(r1, r5, r11, r2, r9);     // Catch: Throwable -> L25
    L23:
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Result.exceptionOrNull-impl(r12);
        return Unit.INSTANCE;
    L18:
        if (r0 == null) goto L23;
        if (r0.intValue() != 4) goto L23;
        WorldCupLynxComponent.m3(r1, r5, r11, r2);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L30:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
