package com.obric.audio.enroll.sami;

import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SpeechFingerPrintEnrollService;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.sami.EnrollServiceImpl$startRecord$1", f = "EnrollServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EnrollServiceImpl$startRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.obric.audio.enroll.a $callback;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $wakeupId;
    int label;

    public EnrollServiceImpl$startRecord$1(String r1, String r2, com.obric.audio.enroll.a r3, Continuation<? super EnrollServiceImpl$startRecord$1> r4) {
        this.$taskId = r1;
        this.$wakeupId = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new EnrollServiceImpl$startRecord$1(this.$taskId, this.$wakeupId, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r11);
        SamiEnrollEngine r12 = SamiEnrollEngine.a;
        String r0 = this.$taskId;
        String r1 = this.$wakeupId;
        final com.obric.audio.enroll.a r2 = this.$callback;
        Function2<String, String, Unit> r3 = new a(r2);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r0, "taskId");
        Intrinsics.checkNotNullParameter(r3, "callback");
        FLogger r5 = FLogger.a;
        r5.i("SamiEnrollEngine", "startRecord begin taskId=" + r0);
        if (StringsKt.isBlank(r0) == true) goto L20;
        Set<String> r6 = SamiEnrollEngine.p;
        if (r6.add(r0) == true) goto L10;
        r5.i("SamiEnrollEngine", "startRecord ignored: already started taskId=" + r0);
        goto L20
    L10:
        ConcurrentHashMap<String, Function2<String, String, Unit>> r8 = SamiEnrollEngine.q;
        r8.put(r0, r3);
        ReentrantLock r4 = SamiEnrollEngine.e;
        r4.lock();
        SpeechFingerPrintEnrollService r9 = SamiEnrollEngine.d;     // Catch: Throwable -> L21
        if (r9 != null) goto L14;
        r5.e("SamiEnrollEngine", "startRecord failed: enrollService is null taskId=" + r0);     // Catch: Throwable -> L21
        r6.remove(r0);     // Catch: Throwable -> L21
        r8.remove(r0);     // Catch: Throwable -> L21
    L18:
        r4.unlock();
        goto L20
    L14:
        int r7 = r9.start(SamiEnrollEngine.h(r0, r1));     // Catch: Throwable -> L21
        if (r7 == 0) goto L17;
        r5.e("SamiEnrollEngine", "startRecord failed ret=" + r7 + " taskId=" + r0);     // Catch: Throwable -> L21
        r6.remove(r0);     // Catch: Throwable -> L21
        r8.remove(r0);     // Catch: Throwable -> L21
        SamiEnrollEngine.r.remove(r0);     // Catch: Throwable -> L21
    L17:
        r5.i("SamiEnrollEngine", "startRecord end taskId=" + r0 + " ret=" + r7);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        SamiEnrollEngine.e.unlock();
        throw th;
    L20:
        return Unit.INSTANCE;
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
