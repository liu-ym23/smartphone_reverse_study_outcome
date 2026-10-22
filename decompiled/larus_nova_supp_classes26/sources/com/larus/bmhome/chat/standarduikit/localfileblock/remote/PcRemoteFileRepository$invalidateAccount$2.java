package com.larus.bmhome.chat.standarduikit.localfileblock.remote;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.localfileblock.remote.PcRemoteFileRepository$invalidateAccount$2", f = "PcRemoteFileRepository.kt", i = {1}, l = {264, 312}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class PcRemoteFileRepository$invalidateAccount$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $generation;
    long J$0;
    Object L$0;
    int label;

    public PcRemoteFileRepository$invalidateAccount$2(long r1, Continuation<? super PcRemoteFileRepository$invalidateAccount$2> r3) {
        this.$generation = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PcRemoteFileRepository$invalidateAccount$2(this.$generation, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        long r2 = this.J$0;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r11);
    L42:
        Set r12 = ((LinkedHashMap) PcRemoteFileRepository.f).keySet();     // Catch: Throwable -> L39
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L39
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L39
    L19:
        if (r13.hasNext() == false) goto L26;
        Object r6 = r13.next();     // Catch: Throwable -> L39
        if (((PcRemoteFileRepository.b) r6).b >= r2) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == false) goto L19;
        r5.add(r6);     // Catch: Throwable -> L39
        goto L19
    L23:
        r7 = false;
        goto L24
    L26:
        Iterator r14 = r5.iterator();     // Catch: Throwable -> L39
    L28:
        if (r14.hasNext() == false) goto L36;
        PcRemoteFileRepository.b r4 = (PcRemoteFileRepository.b) r14.next();     // Catch: Throwable -> L39
        PcRemoteFileRepository.a r8 = PcRemoteFileRepository.f.remove(r4);     // Catch: Throwable -> L39
        if (r8 == null) goto L28;
        File r9 = r8.a;     // Catch: Throwable -> L39
        if (r9 == null) goto L28;
        File r10 = r9.getParentFile();     // Catch: Throwable -> L39
        if (r10 == null) goto L28;
        PcRemoteFileRepository r15 = PcRemoteFileRepository.a;     // Catch: Throwable -> L39
        PcRemoteFileRepository.k(r10, "account_changed");     // Catch: Throwable -> L39
        goto L28
    L36:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L39
        r3.unlock(null);
        return Unit.INSTANCE;
    L39:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L13:
        kotlinx.coroutines.sync.a r17 = PcRemoteFileRepository.c;
        long r18 = this.$generation;
        this.L$0 = r17;
        this.J$0 = r18;
        this.label = 2;
        if (r17.a(null, this) != r0) goto L16;
        return r0;
    L16:
        r3 = r17;
        r2 = r18;
        goto L42
    L10:
        ResultKt.throwOnFailure(r11);
        PcRemoteFileRepository r19 = PcRemoteFileRepository.a;
        this.label = 1;
        if (PcRemoteFileRepository.d(this) != r0) goto L13;
        return r0;
    }
}
