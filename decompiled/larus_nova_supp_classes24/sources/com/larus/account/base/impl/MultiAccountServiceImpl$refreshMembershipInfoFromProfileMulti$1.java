package com.larus.account.base.impl;

import com.google.gson.Gson;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.account.base.multi.MultiAccountProfileRepository;
import com.larus.account.base.multi.d;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.account.base.impl.MultiAccountServiceImpl$refreshMembershipInfoFromProfileMulti$1", f = "MultiAccountServiceImpl.kt", i = {}, l = {445}, m = "invokeSuspend", n = {}, s = {})
final class MultiAccountServiceImpl$refreshMembershipInfoFromProfileMulti$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onFinish;
    final /* synthetic */ List<String> $visitIds;
    private /* synthetic */ Object L$0;
    int label;

    public MultiAccountServiceImpl$refreshMembershipInfoFromProfileMulti$1(Function0<Unit> r1, List<String> r2, Continuation<? super MultiAccountServiceImpl$refreshMembershipInfoFromProfileMulti$1> r3) {
        this.$onFinish = r1;
        this.$visitIds = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MultiAccountServiceImpl$refreshMembershipInfoFromProfileMulti$1 r0 = new MultiAccountServiceImpl$refreshMembershipInfoFromProfileMulti$1(this.$onFinish, this.$visitIds, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        List<String> r2 = (List) this.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L43
    L15:
        com.larus.account.base.multi.k r10 = (com.larus.account.base.multi.k) r9;     // Catch: Throwable -> L43
        if (r10 != null) goto L18;
        FLogger.a.e("MultiAccountServiceImpl", "refreshMembershipInfoFromProfileMulti empty response");     // Catch: Throwable -> L43
        Gson r11 = d.a;     // Catch: Throwable -> L43
        d.g(r2, MapsKt.emptyMap());     // Catch: Throwable -> L43
    L41:
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L43
    L45:
        List<String> r3 = this.$visitIds;
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L48;
        FLogger.a.e("MultiAccountServiceImpl", "refreshMembershipInfoFromProfileMulti exception: " + r13.getMessage());
        Gson r14 = d.a;
        d.g(r3, MapsKt.emptyMap());
    L48:
        this.$onFinish.invoke();
        return Unit.INSTANCE;
    L18:
        Map<String, com.larus.account.base.multi.j> r15 = r10.a();     // Catch: Throwable -> L43
        Map r4 = null;
        if (r15 == null) goto L38;
        LinkedHashMap r5 = new LinkedHashMap(MapsKt.mapCapacity(r15.size()));     // Catch: Throwable -> L43
        Iterator<T> r16 = r15.entrySet().iterator();     // Catch: Throwable -> L43
    L22:
        if (r16.hasNext() == false) goto L37;
        Object r6 = r16.next();     // Catch: Throwable -> L43
        Object r7 = ((Map.Entry) r6).getKey();     // Catch: Throwable -> L43
        com.larus.account.base.multi.j r8 = (com.larus.account.base.multi.j) ((Map.Entry) r6).getValue();     // Catch: Throwable -> L43
        if (r8 == null) goto L28;
        com.larus.account.base.multi.i r17 = r8.a();     // Catch: Throwable -> L43
        if (r17 == null) goto L28;
        com.larus.account.base.multi.g r19 = r17.a();     // Catch: Throwable -> L43
    L30:
        if (r19 == null) goto L32;
        Boolean r20 = r19.b();     // Catch: Throwable -> L43
    L33:
        if (r19 == null) goto L35;
        String r21 = r19.a();     // Catch: Throwable -> L43
    L36:
        r5.put(r7, new Pair(r20, r21));     // Catch: Throwable -> L43
        goto L22
    L35:
        r21 = null;
        goto L36
    L32:
        r20 = null;
    L28:
        r19 = null;
        goto L30
    L37:
        r4 = r5;
    L38:
        if (r4 != null) goto L40;
        r4 = MapsKt.emptyMap();     // Catch: Throwable -> L43
    L40:
        d.g(r2, r4);     // Catch: Throwable -> L43
        goto L41
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r9);
        CoroutineScope r22 = (CoroutineScope) this.L$0;
        List<String> r23 = this.$visitIds;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L43
        int r25 = MultiAccountProfileRepository.a;     // Catch: Throwable -> L43
        this.L$0 = r23;     // Catch: Throwable -> L43
        this.label = 1;     // Catch: Throwable -> L43
        Object r26 = MultiAccountProfileRepository.b(r23, this);     // Catch: Throwable -> L43
        if (r26 != r0) goto L14;
        return r0;
    L14:
        r2 = r23;
        r9 = r26;
    L43:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L45
    }
}
