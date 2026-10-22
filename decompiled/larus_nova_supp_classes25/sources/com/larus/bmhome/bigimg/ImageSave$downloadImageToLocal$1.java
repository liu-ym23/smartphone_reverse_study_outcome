package com.larus.bmhome.bigimg;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.bigimg.ImageSave$downloadImageToLocal$1", f = "ImageSave.kt", i = {}, l = {DoraCallStateCode.ENV_OBSERVE_END, DoraCallStateCode.ENV_OBSERVE_USER_TIMER_END}, m = "invokeSuspend", n = {}, s = {})
final class ImageSave$downloadImageToLocal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $callback;
    final /* synthetic */ Map<String, String> $exifMap;
    final /* synthetic */ String $fileName;
    final /* synthetic */ boolean $isAIGC;
    final /* synthetic */ Function1<Continuation<? super String>, Object> $onInterceptUrl;
    final /* synthetic */ String $url;
    Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.bigimg.ImageSave$downloadImageToLocal$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.bigimg.ImageSave$downloadImageToLocal$1$1", f = "ImageSave.kt", i = {}, l = {DoraCallStateCode.ENV_OBSERVE_AUTO_TIMER_ENTER_PAUSE}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $downloadUrl;
        final /* synthetic */ Map<String, String> $exifMap;
        final /* synthetic */ String $fileName;
        final /* synthetic */ boolean $isAIGC;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(String r1, String r2, Map<String, String> r3, boolean r4, Continuation<? super AnonymousClass1> r5) {
            this.$downloadUrl = r1;
            this.$fileName = r2;
            this.$exifMap = r3;
            this.$isAIGC = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.$downloadUrl, this.$fileName, this.$exifMap, this.$isAIGC, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L19
        L17:
            Object r11 = Result.constructor-impl((String) r10);     // Catch: Throwable -> L19
        L22:
            if (Result.isFailure-impl(r11) == false) goto L27;
            return null;
        L27:
            return r11;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
            CoroutineScope r12 = (CoroutineScope) this.L$0;
            String r4 = this.$downloadUrl;
            String r5 = this.$fileName;
            Map<String, String> r6 = this.$exifMap;
            boolean r13 = this.$isAIGC;
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L19
            ImageSave r3 = ImageSave.a;     // Catch: Throwable -> L19
            if (r13 == false) goto L13;
            boolean r7 = true;
        L14:
            this.label = 1;     // Catch: Throwable -> L19
            r10 = ImageSave.d(r3, r4, r5, r6, r7, this);     // Catch: Throwable -> L19
            if (r10 != r0) goto L17;
            return r0;
        L13:
            r7 = false;
        L19:
            th = move-exception;
            Result.Companion r8 = Result.Companion;
            r11 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L22
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImageSave$downloadImageToLocal$1(String r1, Function1<? super String, Unit> r2, Function1<? super Continuation<? super String>, ? extends Object> r3, String r4, Map<String, String> r5, boolean r6, Continuation<? super ImageSave$downloadImageToLocal$1> r7) {
        this.$url = r1;
        this.$callback = r2;
        this.$onInterceptUrl = r3;
        this.$fileName = r4;
        this.$exifMap = r5;
        this.$isAIGC = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ImageSave$downloadImageToLocal$1(this.$url, this.$callback, this.$onInterceptUrl, this.$fileName, this.$exifMap, this.$isAIGC, r10);
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
        Object r2 = null;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Function1<String, Unit> r3 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r11);
    L37:
        r3.invoke(r11);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L21
    L17:
        String r12 = (String) r11;     // Catch: Throwable -> L21
    L19:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L21
    L23:
        Throwable r4 = Result.exceptionOrNull-impl(r13);
        if (r4 == null) goto L27;
        FLogger.a.e("ImageSave [downloadImageToLocal]", "onInterceptUrl execute failed, " + r4);
    L27:
        if (Result.isFailure-impl(r13) == true) goto L30;
        r2 = r13;
    L30:
        String r5 = (String) r2;
        if (r5 != null) goto L33;
        r5 = this.$url;
    L33:
        Function1<String, Unit> r14 = this.$callback;
        CoroutineDispatcher r6 = Dispatchers.getIO();
        AnonymousClass1 r7 = new AnonymousClass1(r5, this.$fileName, this.$exifMap, this.$isAIGC, null);
        this.L$0 = r14;
        this.label = 2;
        Object r8 = BuildersKt.withContext(r6, r7, this);
        if (r8 != r0) goto L36;
        return r0;
    L36:
        r3 = r14;
        r11 = r8;
        goto L37
    L11:
        ResultKt.throwOnFailure(r11);
        Function1<Continuation<? super String>, Object> r15 = this.$onInterceptUrl;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L21
        if (r15 == null) goto L18;
        this.label = 1;     // Catch: Throwable -> L21
        r11 = r15.invoke(this);     // Catch: Throwable -> L21
        if (r11 != r0) goto L17;
        return r0;
    L18:
        r12 = null;
    L21:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
