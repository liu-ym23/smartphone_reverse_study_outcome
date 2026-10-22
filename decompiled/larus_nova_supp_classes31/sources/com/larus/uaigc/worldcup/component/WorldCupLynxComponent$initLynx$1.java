package com.larus.uaigc.worldcup.component;

import com.larus.platform.api.e4;
import com.larus.uaigc.lynx.pocket.PocketDataCache;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.worldcup.component.WorldCupLynxComponent$initLynx$1", f = "WorldCupLynxComponent.kt", i = {}, l = {372}, m = "invokeSuspend", n = {}, s = {})
final class WorldCupLynxComponent$initLynx$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $initPageDataJson;
    final /* synthetic */ int $inputBoxShowSetting;
    int label;
    final /* synthetic */ WorldCupLynxComponent this$0;

    public WorldCupLynxComponent$initLynx$1(WorldCupLynxComponent r1, int r2, String r3, Continuation<? super WorldCupLynxComponent$initLynx$1> r4) {
        this.this$0 = r1;
        this.$inputBoxShowSetting = r2;
        this.$initPageDataJson = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new WorldCupLynxComponent$initLynx$1(this.this$0, this.$inputBoxShowSetting, this.$initPageDataJson, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L17:
        if (((Boolean) r7).booleanValue() == false) goto L31;
        FLogger r8 = FLogger.a;
        r8.i(this.this$0.m, "[initLynx] valid: true, refresh pocketPageData success");
        PocketDataCache.a.getClass();
        Map<String, ? extends Object> r2 = PocketDataCache.c();
        if (r2 != null) goto L21;
    L24:
        boolean r3 = true;
    L25:
        if (r3 == false) goto L27;
        r8.i(this.this$0.m, "[initLynx] inValid: true, refresh pocketPageData generate fail, use FE default pocketPageData");
    L28:
        String r4 = this.this$0.z3(r2, false, 1, this.$inputBoxShowSetting);
        r8.i(this.this$0.m, "[initLynx] inValid: true, refresh pocketPageData flow success, update pageDataJson generate = " + r4 + ", isShowInputBox = " + this.$inputBoxShowSetting);
        e4 r9 = this.this$0.t;
        if (r9 == null) goto L35;
        r9.updateData(r4);
    L35:
        return Unit.INSTANCE;
    L27:
        WorldCupLynxComponent r5 = this.this$0;
        r5.z = r2;
        r8.i(r5.m, "[initLynx] inValid: true, refresh pocketPageData generate success, refreshPocketResponseDict.size = " + ((ConcurrentHashMap) r2).size());
        goto L28
    L21:
        if (((ConcurrentHashMap) r2).isEmpty() == true) goto L24;
        r3 = false;
        goto L25
    L31:
        FLogger.a.e(this.this$0.m, "[initLynx] inValid: true, refresh pocketPageData fail, use FE default pocketPageData");
        e4 r10 = this.this$0.t;
        if (r10 == null) goto L35;
        r10.updateData(this.$initPageDataJson);
        goto L35
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FLogger.a.e(this.this$0.m, "[initLynx] inValid: true, start to refresh pocketPageData");
        PocketDataCache r11 = PocketDataCache.a;
        a r6 = this.this$0.B3();
        if (r6 == null) goto L12;
        String r12 = r6.b();
        if (r12 == null) goto L12;
    L13:
        this.label = 1;
        r11.getClass();
        r7 = PocketDataCache.f(1, r12, this);
        if (r7 != r0) goto L17;
        return r0;
    L12:
        r12 = "";
        goto L13
    }
}
