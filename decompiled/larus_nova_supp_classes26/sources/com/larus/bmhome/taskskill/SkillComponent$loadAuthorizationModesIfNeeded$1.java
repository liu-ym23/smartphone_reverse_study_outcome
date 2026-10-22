package com.larus.bmhome.taskskill;

import com.larus.bmhome.taskskill.network.TaskSkillRepository;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$loadAuthorizationModesIfNeeded$1", f = "SkillComponent.kt", i = {}, l = {2995}, m = "invokeSuspend", n = {}, s = {})
public final class SkillComponent$loadAuthorizationModesIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $cacheKey;
    final /* synthetic */ String $remotePcDeviceId;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$loadAuthorizationModesIfNeeded$1(String r1, SkillComponent r2, a r3, Continuation<? super SkillComponent$loadAuthorizationModesIfNeeded$1> r4) {
        this.$remotePcDeviceId = r1;
        this.this$0 = r2;
        this.$cacheKey = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SkillComponent$loadAuthorizationModesIfNeeded$1(this.$remotePcDeviceId, this.this$0, this.$cacheKey, r5);
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L28
        Object r13 = ((Result) r12).unbox-impl();     // Catch: Throwable -> L28
    L13:
        SkillComponent r2 = this.this$0;     // Catch: Throwable -> L28
        a r3 = this.$cacheKey;     // Catch: Throwable -> L28
        String r4 = this.$remotePcDeviceId;     // Catch: Throwable -> L28
        if (Result.isSuccess-impl(r13) == false) goto L47;
        com.larus.bmhome.taskskill.network.g r5 = (com.larus.bmhome.taskskill.network.g) r13;     // Catch: Throwable -> L28
        if (Intrinsics.areEqual(r2.V, r3) == false) goto L47;
        if (Intrinsics.areEqual(r2.B3(r4), r3) == false) goto L47;
        if (Intrinsics.areEqual(r2.w5(), r4) == false) goto L47;
        List<Integer> r6 = r5.a;     // Catch: Throwable -> L28
        RemoteControlAuthorizationMode.a r7 = RemoteControlAuthorizationMode.Companion;     // Catch: Throwable -> L28
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L28
        Iterator<T> r9 = r6.iterator();     // Catch: Throwable -> L28
    L24:
        if (r9.hasNext() == false) goto L30;
        int r10 = ((Number) r9.next()).intValue();     // Catch: Throwable -> L28
        r7.getClass();     // Catch: Throwable -> L28
        RemoteControlAuthorizationMode r11 = RemoteControlAuthorizationMode.a.a(r10);     // Catch: Throwable -> L28
        if (r11 == null) goto L24;
        r8.add(r11);     // Catch: Throwable -> L28
        goto L24
    L30:
        List r14 = CollectionsKt.distinct(r8);     // Catch: Throwable -> L28
        RemoteControlAuthorizationMode.a r15 = RemoteControlAuthorizationMode.Companion;     // Catch: Throwable -> L28
        int r16 = r5.b;     // Catch: Throwable -> L28
        r15.getClass();     // Catch: Throwable -> L28
        RemoteControlAuthorizationMode r17 = RemoteControlAuthorizationMode.a.a(r16);     // Catch: Throwable -> L28
        if (r14.isEmpty() == true) goto L46;
        if (r17 == null) goto L46;
        if (r14.contains(r17) == false) goto L46;
        ConcurrentHashMap<a, RemoteControlAuthorizationMode> r18 = c.a;     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r3, "key");     // Catch: Throwable -> L28
        ConcurrentHashMap<a, RemoteControlAuthorizationMode> r19 = c.a;     // Catch: Throwable -> L28
        RemoteControlAuthorizationMode r20 = r19.get(r3);     // Catch: Throwable -> L28
        if (r20 != null) goto L40;
    L42:
        if (r20 == null) goto L44;
        Intrinsics.checkNotNullParameter(r3, "key");     // Catch: Throwable -> L28
        r19.remove(r3);     // Catch: Throwable -> L28
    L44:
        r20 = r17;
    L45:
        Intrinsics.checkNotNullParameter(r3, "key");     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r17, "mode");     // Catch: Throwable -> L28
        c.b.putIfAbsent(new b(r3.a, r3.b), r17);     // Catch: Throwable -> L28
        r2.W = r3;     // Catch: Throwable -> L28
        r2.X = new j(r14, r20, r4);     // Catch: Throwable -> L28
        r2.KY();     // Catch: Throwable -> L28
        goto L47
    L40:
        if (r14.contains(r20) == false) goto L42;
    L46:
        ConcurrentHashMap<a, RemoteControlAuthorizationMode> r21 = c.a;     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r3, "key");     // Catch: Throwable -> L28
        c.a.remove(r3);     // Catch: Throwable -> L28
        r2.W = null;     // Catch: Throwable -> L28
        r2.X = null;     // Catch: Throwable -> L28
        r2.KY();     // Catch: Throwable -> L28
    L47:
        SkillComponent r22 = this.this$0;     // Catch: Throwable -> L28
        a r23 = this.$cacheKey;     // Catch: Throwable -> L28
        String r24 = this.$remotePcDeviceId;     // Catch: Throwable -> L28
        Throwable r110 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L28
        if (r110 == null) goto L54;
        if (Intrinsics.areEqual(r22.V, r23) == false) goto L52;
        r22.W = null;     // Catch: Throwable -> L28
        r22.X = null;     // Catch: Throwable -> L28
    L52:
        FLogger.a.w("SkillComponent", "[loadAuthorizationModesIfNeeded] GET_META failed, deviceId=" + r24 + ", message=" + r110.getMessage());     // Catch: Throwable -> L28
    L54:
        if (Intrinsics.areEqual(this.this$0.V, this.$cacheKey) == false) goto L57;
        this.this$0.V = null;
    L57:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
        TaskSkillRepository r111 = TaskSkillRepository.a;     // Catch: Throwable -> L28
        String r25 = this.$remotePcDeviceId;     // Catch: Throwable -> L28
        this.label = 1;     // Catch: Throwable -> L28
        r13 = r111.s(r25, this);     // Catch: Throwable -> L28
        if (r13 != r0) goto L13;
        return r0;
    L28:
        th = move-exception;
        if (Intrinsics.areEqual(this.this$0.V, this.$cacheKey) == false) goto L61;
        this.this$0.V = null;
    L61:
        throw th;
    }
}
