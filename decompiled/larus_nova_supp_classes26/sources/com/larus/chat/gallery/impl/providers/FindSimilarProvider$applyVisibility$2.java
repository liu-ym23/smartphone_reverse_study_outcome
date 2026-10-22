package com.larus.chat.gallery.impl.providers;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.providers.FindSimilarProvider$applyVisibility$2", f = "FindSimilarProvider.kt", i = {0}, l = {121}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class FindSimilarProvider$applyVisibility$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imageUri;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ i<Object> this$0;

    public FindSimilarProvider$applyVisibility$2(i<Object> r1, String r2, Continuation<? super FindSimilarProvider$applyVisibility$2> r3) {
        this.this$0 = r1;
        this.$imageUri = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        FindSimilarProvider$applyVisibility$2 r0 = new FindSimilarProvider$applyVisibility$2(this.this$0, this.$imageUri, r5);
        r0.L$0 = r4;
        return r0;
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
        String r3 = null;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L8 CancellationException -> L37
    L17:
        com.larus.chat.gallery.api.h r9 = (com.larus.chat.gallery.api.h) r8;     // Catch: Throwable -> L8 CancellationException -> L37
    L23:
        if (CoroutineScopeKt.isActive(r2) == false) goto L25;
        if (r9 != null) goto L29;
        i<Object> r10 = this.this$0;
        int r4 = i.n;
        r10.A();
        return Unit.INSTANCE;
    L29:
        ConcurrentHashMap<String, com.larus.chat.gallery.api.h> r5 = e.a;
        String r6 = this.$imageUri;
        Intrinsics.checkNotNullParameter(r6, "imageUri");
        Intrinsics.checkNotNullParameter(r9, "availability");
        e.a.put(r6, r9);
        f r7 = this.this$0.i;
        if (r7 == null) goto L33;
        r3 = r7.a;
    L33:
        if (Intrinsics.areEqual(r3, this.$imageUri) == false) goto L36;
        this.this$0.y(r9);
    L36:
        return Unit.INSTANCE;
    L25:
        return Unit.INSTANCE;
    L8:
        Throwable th = th;
    L21:
        FLogger.a.e("FindSimilarProvider", "checkAvailability error: " + th.getMessage());
        r9 = null;
        goto L23
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r8);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        CoroutineDispatcher r12 = Dispatchers.getIO();     // Catch: Throwable -> L19 CancellationException -> L37
        FindSimilarProvider$applyVisibility$2$availability$1 r13 = new FindSimilarProvider$applyVisibility$2$availability$1(this.$imageUri, null);     // Catch: Throwable -> L19 CancellationException -> L37
        this.L$0 = r11;     // Catch: Throwable -> L19 CancellationException -> L37
        this.label = 1;     // Catch: Throwable -> L19 CancellationException -> L37
        Object r14 = BuildersKt.withContext(r12, r13, this);     // Catch: Throwable -> L19 CancellationException -> L37
        if (r14 != r0) goto L16;
        return r0;
    L16:
        r2 = r11;
        r8 = r14;
    L19:
        th = move-exception;
        r2 = r11;
        th = th;
    L37:
        e = move-exception;
        throw e;
    }
}
