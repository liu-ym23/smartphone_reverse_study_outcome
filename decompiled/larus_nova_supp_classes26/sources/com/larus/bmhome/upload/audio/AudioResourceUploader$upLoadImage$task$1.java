package com.larus.bmhome.upload.audio;

import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.audio.AudioResourceUploader$upLoadImage$task$1", f = "AudioResourceUploader.kt", i = {2}, l = {54, 69, 79}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
final class AudioResourceUploader$upLoadImage$task$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ List<b> $content;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Function1<Throwable, Unit> $onFail;
    final /* synthetic */ Function1<i, Unit> $onSuccess;
    final /* synthetic */ Function1<Float, Unit> $onUploadProgressChange;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AudioResourceUploader$upLoadImage$task$1(String r1, String r2, List<b> r3, Function1<? super Throwable, Unit> r4, Function1<? super Float, Unit> r5, Function1<? super i, Unit> r6, Continuation<? super AudioResourceUploader$upLoadImage$task$1> r7) {
        this.$botId = r1;
        this.$conversationId = r2;
        this.$content = r3;
        this.$onFail = r4;
        this.$onUploadProgressChange = r5;
        this.$onSuccess = r6;
        super(1, r7);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new AudioResourceUploader$upLoadImage$task$1(this.$botId, this.$conversationId, this.$content, this.$onFail, this.$onUploadProgressChange, this.$onSuccess, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [com.larus.bmhome.upload.audio.e] */
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        Throwable r2 = (Throwable) this.L$0;
        ResultKt.throwOnFailure(r13);
    L38:
        FLogger.a.e("AudioImageUploader", "catch err when upload img, msg=" + r2);
    L40:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L29
    L25:
        Unit r14 = (Unit) r13;     // Catch: Throwable -> L29
    L27:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L29
    L31:
        Function1<Throwable, Unit> r3 = this.$onFail;
        List<b> r4 = this.$content;
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L40;
        MainCoroutineDispatcher r5 = Dispatchers.getMain();
        AudioResourceUploader$upLoadImage$task$1$2$1 r7 = new AudioResourceUploader$upLoadImage$task$1$2$1(r3, r16, r4, null);
        this.L$0 = r16;
        this.label = 3;
        if (BuildersKt.withContext(r5, r7, this) != r0) goto L37;
        return r0;
    L37:
        r2 = r16;
        goto L38
    L12:
        Function1<i, Unit> r6 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L29
    L20:
        i r17 = (i) r13;     // Catch: Throwable -> L29
        if (r17 == null) goto L26;
        MainCoroutineDispatcher r8 = Dispatchers.getMain();     // Catch: Throwable -> L29
        AudioResourceUploader$upLoadImage$task$1$1$1 r9 = new AudioResourceUploader$upLoadImage$task$1$1$1(r6, r17, null);     // Catch: Throwable -> L29
        this.L$0 = null;     // Catch: Throwable -> L29
        this.label = 2;     // Catch: Throwable -> L29
        r13 = BuildersKt.withContext(r8, r9, this);     // Catch: Throwable -> L29
        if (r13 != r0) goto L25;
        return r0;
    L26:
        FLogger.a.e("AudioImageUploader", "on request err");     // Catch: Throwable -> L29
        r14 = Unit.INSTANCE;     // Catch: Throwable -> L29
        goto L27
    L15:
        ResultKt.throwOnFailure(r13);
        c r18 = new c(this.$botId, this.$conversationId, this.$content);
        g r10 = g.a;
        Function1<Throwable, Unit> r11 = this.$onFail;
        final List<b> r12 = this.$content;
        final Function1<Float, Unit> r19 = this.$onUploadProgressChange;
        Function1<i, Unit> r110 = this.$onSuccess;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L29
        AudioResourceUploader$upLoadImage$task$1$1$result$1 r112 = new AudioResourceUploader$upLoadImage$task$1$1$result$1(r11, r12, null);     // Catch: Throwable -> L29
        ?? r20 = new e(r12, r19);     // Catch: Throwable -> L29
        this.L$0 = r110;     // Catch: Throwable -> L29
        this.label = 1;     // Catch: Throwable -> L29
        r13 = g.a(r10, r18, r112, r20, this);     // Catch: Throwable -> L29
        if (r13 != r0) goto L19;
        return r0;
    L19:
        r6 = r110;
    L29:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    }
}
