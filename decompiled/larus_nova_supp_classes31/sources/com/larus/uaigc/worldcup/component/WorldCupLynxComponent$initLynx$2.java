package com.larus.uaigc.worldcup.component;

import android.view.View;
import com.larus.uaigc.lynx.pocket.PocketDataCache;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.worldcup.component.WorldCupLynxComponent$initLynx$2", f = "WorldCupLynxComponent.kt", i = {}, l = {397}, m = "invokeSuspend", n = {}, s = {})
final class WorldCupLynxComponent$initLynx$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $containerView;
    int label;
    final /* synthetic */ WorldCupLynxComponent this$0;

    public WorldCupLynxComponent$initLynx$2(WorldCupLynxComponent r1, View r2, Continuation<? super WorldCupLynxComponent$initLynx$2> r3) {
        this.this$0 = r1;
        this.$containerView = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new WorldCupLynxComponent$initLynx$2(this.this$0, this.$containerView, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L17:
        if (((Boolean) r6).booleanValue() == false) goto L31;
        FLogger r7 = FLogger.a;
        r7.i(this.this$0.m, "[initLynx] inValid: false, refresh pocketPageData success");
        PocketDataCache.a.getClass();
        Map<String, ? extends Object> r3 = PocketDataCache.c();
        if (r3 != null) goto L21;
    L24:
        if (r2 == false) goto L26;
        r7.i(this.this$0.m, "[initLynx] inValid: false, refresh pocketPageData generate fail, use FE default pocketPageData");
    L27:
        this.this$0.getClass();
        WorldCupLynxComponent r4 = this.this$0;
        if (r3 != null) goto L30;
        r3 = MapsKt.emptyMap();
    L30:
        String r5 = r4.z3(r3, false, 0, 0);
        r7.i(this.this$0.m, "[initLynx] inValid: false, refresh pocketPageData flow success, init pageDataJson generate = " + r5 + ", inputBoxShowSetting = 0");
        this.this$0.D3(this.$containerView, r5, false);
    L33:
        return Unit.INSTANCE;
    L26:
        WorldCupLynxComponent r8 = this.this$0;
        r8.z = r3;
        r7.i(r8.m, "[initLynx] inValid: false, refresh pocketPageData generate success, refreshPocketResponseDict.size = " + ((ConcurrentHashMap) r3).size());
        goto L27
    L21:
        if (((ConcurrentHashMap) r3).isEmpty() == true) goto L24;
        r2 = false;
        goto L24
    L31:
        FLogger r9 = FLogger.a;
        r9.e(this.this$0.m, "[initLynx] inValid: false, refresh pocketPageData fail, use FE default pocketPageData");
        this.this$0.getClass();
        String r10 = this.this$0.z3(MapsKt.emptyMap(), false, 0, 0);
        r9.e(this.this$0.m, "[initLynx] inValid: false, refresh pocketPageData fail, empty pageDataJson generate = ".concat(r10));
        this.this$0.D3(this.$containerView, r10, false);
        goto L33
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FLogger.a.i(this.this$0.m, "[initLynx] inValid: false, start to refresh pocketPageData");
        PocketDataCache r11 = PocketDataCache.a;
        a r12 = this.this$0.B3();
        if (r12 == null) goto L12;
        String r13 = r12.b();
        if (r13 == null) goto L12;
    L13:
        this.label = 1;
        r11.getClass();
        r6 = PocketDataCache.f(1, r13, this);
        if (r6 != r0) goto L17;
        return r0;
    L12:
        r13 = "";
        goto L13
    }
}
