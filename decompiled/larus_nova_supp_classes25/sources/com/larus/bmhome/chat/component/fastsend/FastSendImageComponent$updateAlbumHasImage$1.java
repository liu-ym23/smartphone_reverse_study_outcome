package com.larus.bmhome.chat.component.fastsend;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.fastsend.FastSendImageComponent$updateAlbumHasImage$1", f = "FastSendImageComponent.kt", i = {}, l = {339}, m = "invokeSuspend", n = {}, s = {})
final class FastSendImageComponent$updateAlbumHasImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onNext;
    int label;
    final /* synthetic */ FastSendImageComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.fastsend.FastSendImageComponent$updateAlbumHasImage$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.fastsend.FastSendImageComponent$updateAlbumHasImage$1$3", f = "FastSendImageComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onNext;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FastSendImageComponent this$0;

        public AnonymousClass3(FastSendImageComponent r1, Function0<Unit> r2, Continuation<? super AnonymousClass3> r3) {
            this.this$0 = r1;
            this.$onNext = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, this.$onNext, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L21;
            ResultKt.throwOnFailure(r5);
            CoroutineScope r6 = (CoroutineScope) this.L$0;
            FastSendImageComponent r7 = this.this$0;
            Function0<Unit> r1 = this.$onNext;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
            if (s1a.a.getActivity(r7).isFinishing() == false) goto L8;
        L10:
            FLogger.a.e("FastSendImageComponent", "[updateAlbumHasImage] onNext failed, illegal activity state");     // Catch: Throwable -> L13
        L11:
            Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
        L15:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L19;
            FLogger.a.e("FastSendImageComponent", "[updateAlbumHasImage] onNext failed, " + r9);
        L19:
            return Unit.INSTANCE;
        L8:
            if (s1a.a.getActivity(r7).isDestroyed() == true) goto L10;
            r1.invoke();     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            Result.Companion r3 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L15
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public FastSendImageComponent$updateAlbumHasImage$1(FastSendImageComponent r1, Function0<Unit> r2, Continuation<? super FastSendImageComponent$updateAlbumHasImage$1> r3) {
        this.this$0 = r1;
        this.$onNext = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new FastSendImageComponent$updateAlbumHasImage$1(this.this$0, this.$onNext, r4);
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
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FastSendImageComponent r8 = this.this$0;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r3 = Result.constructor-impl(FastSendImageComponent.F2(r8));     // Catch: Throwable -> L11
    L14:
        if (Result.exceptionOrNull-impl(r3) == null) goto L17;
        FLogger.a.d("FastSendImageComponent", "getLatestPhotoBitmap fail");
        r3 = null;
    L17:
        if (r3 == null) goto L19;
        boolean r4 = true;
    L20:
        r8.u = Boxing.boxBoolean(r4);
        MainCoroutineDispatcher r9 = Dispatchers.getMain();
        AnonymousClass3 r5 = new AnonymousClass3(this.this$0, this.$onNext, null);
        this.label = 1;
        if (BuildersKt.withContext(r9, r5, this) != r0) goto L24;
        return r0;
    L19:
        r4 = false;
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
