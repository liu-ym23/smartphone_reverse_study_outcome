package com.obric.assistant.card;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.card.layout.viewholder.AlbumGridViewHolder;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.card.ShowAllDialogFragment$prefetchFirstScreenPhotos$1", f = "ShowAllDialogFragment.kt", i = {}, l = {503}, m = "invokeSuspend", n = {}, s = {})
final class ShowAllDialogFragment$prefetchFirstScreenPhotos$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PhotoEntity> $photos;
    final /* synthetic */ int $sizePx;
    int label;

    /* JADX INFO: renamed from: com.obric.assistant.card.ShowAllDialogFragment$prefetchFirstScreenPhotos$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.card.ShowAllDialogFragment$prefetchFirstScreenPhotos$1$1", f = "ShowAllDialogFragment.kt", i = {}, l = {504}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<PhotoEntity> $photos;
        final /* synthetic */ int $sizePx;
        int label;

        public AnonymousClass1(int r1, List<PhotoEntity> r2, Continuation<? super AnonymousClass1> r3) {
            this.$sizePx = r1;
            this.$photos = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$sizePx, this.$photos, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            AlbumGridViewHolder.Companion r6 = AlbumGridViewHolder.p;
            int r2 = this.$sizePx;
            List<PhotoEntity> r3 = this.$photos;
            this.label = 1;
            if (r6.c(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    public ShowAllDialogFragment$prefetchFirstScreenPhotos$1(int r1, List<PhotoEntity> r2, Continuation<? super ShowAllDialogFragment$prefetchFirstScreenPhotos$1> r3) {
        this.$sizePx = r1;
        this.$photos = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ShowAllDialogFragment$prefetchFirstScreenPhotos$1(this.$sizePx, this.$photos, r4);
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
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L12;
        ResultKt.throwOnFailure(r7);     // Catch: Exception -> L7 CancellationException -> L9
    L21:
    L19:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r8 = Dispatchers.getIO();     // Catch: Exception -> L7 CancellationException -> L9
        AnonymousClass1 r2 = new AnonymousClass1(this.$sizePx, this.$photos, null);     // Catch: Exception -> L7 CancellationException -> L9
        this.label = 1;     // Catch: Exception -> L7 CancellationException -> L9
        if (BuildersKt.withContext(r8, r2, this) != r0) goto L21;
        return r0;
    L9:
        e = move-exception;
        throw e;
    L7:
        e = move-exception;
        FLogger.a.w("ShowAllDialogFragment", "prefetchFirstScreenPhotos failed: " + e.getMessage(), e);
        goto L19
    }
}
