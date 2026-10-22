package com.larus.bmhome.upload.audio;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "e", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.audio.AudioResourceUploader$upLoadImage$task$1$1$result$1", f = "AudioResourceUploader.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
public final class AudioResourceUploader$upLoadImage$task$1$1$result$1 extends SuspendLambda implements Function2<Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<b> $content;
    final /* synthetic */ Function1<Throwable, Unit> $onFail;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.upload.audio.AudioResourceUploader$upLoadImage$task$1$1$result$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.upload.audio.AudioResourceUploader$upLoadImage$task$1$1$result$1$1", f = "AudioResourceUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<b> $content;
        final /* synthetic */ Throwable $e;
        final /* synthetic */ Function1<Throwable, Unit> $onFail;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Throwable, Unit> r1, Throwable r2, List<b> r3, Continuation<? super AnonymousClass1> r4) {
            this.$onFail = r1;
            this.$e = r2;
            this.$content = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$onFail, this.$e, this.$content, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r5);
            this.$onFail.invoke(this.$e);
            List<b> r6 = this.$content;
            Throwable r0 = this.$e;
            Iterator<T> r7 = r6.iterator();
        L6:
            if (r7.hasNext() == false) goto L14;
            b r1 = (b) r7.next();
            Map<String, l> r2 = g.b;
            String r3 = r1.a();
            if (r3 != null) goto L10;
            r3 = "";
        L10:
            l r4 = (l) ((LinkedHashMap) r2).get(r3);
            if (r4 == null) goto L6;
            r4.H0(r1, r0);
            goto L6
        L14:
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AudioResourceUploader$upLoadImage$task$1$1$result$1(Function1<? super Throwable, Unit> r1, List<b> r2, Continuation<? super AudioResourceUploader$upLoadImage$task$1$1$result$1> r3) {
        this.$onFail = r1;
        this.$content = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        AudioResourceUploader$upLoadImage$task$1$1$result$1 r0 = new AudioResourceUploader$upLoadImage$task$1$1$result$1(this.$onFail, this.$content, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Throwable) r1, (Continuation) r2);
    }

    public final Object invoke(Throwable r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        Throwable r9 = (Throwable) this.L$0;
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.$onFail, r9, this.$content, null);
        this.label = 1;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L12;
        return r0;
    }
}
