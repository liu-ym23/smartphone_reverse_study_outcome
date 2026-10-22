package com.larus.chat.gallery.impl.providers;

import com.larus.chat.gallery.api.IFindSimilarAvailabilityChecker;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/chat/gallery/api/FindSimilarAvailability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.providers.FindSimilarProvider$applyVisibility$2$availability$1", f = "FindSimilarProvider.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
public final class FindSimilarProvider$applyVisibility$2$availability$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.chat.gallery.api.h>, Object> {
    final /* synthetic */ String $imageUri;
    int label;

    public FindSimilarProvider$applyVisibility$2$availability$1(String r1, Continuation<? super FindSimilarProvider$applyVisibility$2$availability$1> r2) {
        this.$imageUri = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FindSimilarProvider$applyVisibility$2$availability$1(this.$imageUri, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.chat.gallery.api.h> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        IFindSimilarAvailabilityChecker.Delegate r5 = IFindSimilarAvailabilityChecker.a;
        String r2 = this.$imageUri;
        this.label = 1;
        r4 = r5.a(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
