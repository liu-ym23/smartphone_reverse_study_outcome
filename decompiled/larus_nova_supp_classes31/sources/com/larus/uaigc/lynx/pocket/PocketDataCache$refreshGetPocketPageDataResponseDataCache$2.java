package com.larus.uaigc.lynx.pocket;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.network.FlowHttpConnection;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.lynx.pocket.PocketDataCache$refreshGetPocketPageDataResponseDataCache$2", f = "PocketDataCache.kt", i = {0, 0}, l = {85}, m = "invokeSuspend", n = {"$this$withContext", "requestStartTime"}, s = {"L$0", "J$0"})
public final class PocketDataCache$refreshGetPocketPageDataResponseDataCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $scene;
    final /* synthetic */ String $source;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    public PocketDataCache$refreshGetPocketPageDataResponseDataCache$2(int r1, String r2, Continuation<? super PocketDataCache$refreshGetPocketPageDataResponseDataCache$2> r3) {
        this.$scene = r1;
        this.$source = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        PocketDataCache$refreshGetPocketPageDataResponseDataCache$2 r0 = new PocketDataCache$refreshGetPocketPageDataResponseDataCache$2(this.$scene, this.$source, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r2 = this.J$0;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r20);
        long r4 = r2;
        Object r5 = r20;
    L15:
        dm9.a.b r6 = (dm9.a) r5;
        boolean r8 = false;
        if ((r6 instanceof dm9.a.b) == false) goto L48;
        dm9.a.b r7 = r6;
        if (r7.a.isSuccess() == true) goto L24;
        PocketDataCache r0 = PocketDataCache.a;
        int r9 = this.$scene;
        Integer r10 = Boxing.boxInt((int) r7.a.getCode());
        String r12 = r7.a.getMsg();
        if (r12 != null) goto L22;
        r12 = "";
    L22:
        PocketDataCache.a(r0, r9, r4, r10, r12);
        return Boxing.boxBoolean(false);
    L24:
        Ref.BooleanRef r13 = new Ref.BooleanRef();
        int r14 = this.$scene;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L41
        FLogger r16 = FLogger.a;     // Catch: Throwable -> L41
        r16.i("SpringMainVenueDataManager", "[refreshPocketPageCache] getPocketPageData success");     // Catch: Throwable -> L41
        PocketDataCache.a.getClass();     // Catch: Throwable -> L41
        String r17 = "pocket_page_online_data_".concat(o.a.getDeviceId());     // Catch: Throwable -> L41
        String r18 = ((Gson) PocketDataCache.d.getValue()).toJson(r6.a.getData());     // Catch: Throwable -> L41
        r16.i("SpringMainVenueDataManager", "[refreshPocketPageCache] getPocketPageData json = " + r18);     // Catch: Throwable -> L41
        ((Keva) PocketDataCache.b.getValue()).storeString(r17, r18);     // Catch: Throwable -> L41
        Map r19 = (Map) r6.a.getData();     // Catch: Throwable -> L41
        if (r19 == null) goto L39;
        ConcurrentHashMap<String, Object> r21 = PocketDataCache.c;     // Catch: Throwable -> L41
        r21.clear();     // Catch: Throwable -> L41
        LinkedHashMap r22 = new LinkedHashMap();     // Catch: Throwable -> L41
        Iterator r23 = r19.entrySet().iterator();     // Catch: Throwable -> L41
    L29:
        if (r23.hasNext() == false) goto L38;
        Map.Entry r24 = (Map.Entry) r23.next();     // Catch: Throwable -> L41
        if (r24.getKey() != null) goto L33;
    L35:
        boolean r25 = false;
    L36:
        if (r25 == false) goto L29;
        r22.put(r24.getKey(), r24.getValue());     // Catch: Throwable -> L41
        goto L29
    L33:
        if (r24.getValue() == null) goto L35;
        r25 = true;
        goto L36
    L38:
        r21.putAll(r22);     // Catch: Throwable -> L41
    L39:
        long r110 = System.currentTimeMillis() - r4;     // Catch: Throwable -> L41
        PocketDataCache.a.getClass();     // Catch: Throwable -> L41
        PocketDataCache.g(r14, r110, null, null, true);     // Catch: Throwable -> L41
        r13.element = true;     // Catch: Throwable -> L41
        Object r26 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L44:
        if (Result.exceptionOrNull-impl(r26) == null) goto L46;
        r13.element = false;
    L46:
        r8 = r13.element;
    L51:
        return Boxing.boxBoolean(r8);
    L41:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L44
    L48:
        if ((r6 instanceof dm9.a.a) == false) goto L53;
        dm9.a.a r28 = (dm9.a.a) r6;
        PocketDataCache.a(PocketDataCache.a, this.$scene, r4, Boxing.boxInt(r28.a), r28.b);
        goto L51
    L53:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        CoroutineScope r29 = (CoroutineScope) this.L$0;
        long r111 = System.currentTimeMillis();
        PocketApi.a r30 = PocketApi.a;
        PocketDataCache$refreshGetPocketPageDataResponseDataCache$2$result$1 r31 = new PocketDataCache$refreshGetPocketPageDataResponseDataCache$2$result$1(this.$source, null);
        this.L$0 = r29;
        this.J$0 = r111;
        this.label = 1;
        r30.getClass();
        FlowHttpConnection r32 = FlowHttpConnection.a;
        r5 = FlowHttpConnection.i("Social", PocketApi.class, r31, null, null, "https://activity-hd.doubao.com", this, 112);
        if (r5 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        r5 = (dm9.a) r5;
    L12:
        if (r5 != r11) goto L14;
        return r11;
    L14:
        r4 = r111;
        goto L15
    }
}
