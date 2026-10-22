package com.larus.dora.impl.feedback;

import android.net.Uri;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.platform.spi.IAIChatUploadMediaService;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackImage$compressImage$2$compressionJob$1", f = "DoraGFeedbackViewModel.kt", i = {0}, l = {781, 806}, m = "invokeSuspend", n = {"videoPath"}, s = {"L$0"})
final class DoraFeedbackImage$compressImage$2$compressionJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.i<String> $continuation;
    Object L$0;
    int label;
    final /* synthetic */ g this$0;

    public static final class a implements Function1<Integer, Unit> {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        public final Object invoke(Object r3) {
            int r4 = ((Number) r3).intValue();
            i r0 = this.a.c.a.getImageSubmitCallback();
            if (r0 == null) goto L6;
            r0.c(this.a.b, r4);
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DoraFeedbackImage$compressImage$2$compressionJob$1(g r1, kotlinx.coroutines.i<? super String> r2, Continuation<? super DoraFeedbackImage$compressImage$2$compressionJob$1> r3) {
        this.this$0 = r1;
        this.$continuation = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraFeedbackImage$compressImage$2$compressionJob$1(this.this$0, this.$continuation, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = this.label;
        if (r6 == 0) goto L15;
        if (r6 == 1) goto L10;
        if (r6 != 2) goto L9;
        ResultKt.throwOnFailure(r23);     // Catch: Exception -> L80
        Object r1 = r23;
    L64:
        ic8.n0 r2 = (ic8.n0) r1;     // Catch: Exception -> L80
        ProcessFileResultCode r3 = r2.b;     // Catch: Exception -> L80
        if (r3 != null) goto L67;
    L69:
        boolean r13 = false;
    L70:
        if (r13 == true) goto L79;
        ic8.m0 r4 = r2.a;     // Catch: Exception -> L80
        if (r4 == null) goto L74;
        String r12 = r4.e;     // Catch: Exception -> L80
    L75:
        if (r12 != null) goto L77;
        r12 = "";
    L77:
        pk4.j.d("DoraGFeedbackViewModel", "compressedImagePath = ".concat(r12));     // Catch: Exception -> L80
        this.$continuation.resumeWith(Result.constructor-impl(r12));     // Catch: Exception -> L80
    L83:
        return Unit.INSTANCE;
    L74:
        r12 = null;
        goto L75
    L79:
        throw new IOException("Compression failed");     // Catch: Exception -> L80
    L67:
        if (r3.isSuccess() == true) goto L69;
        r13 = true;
        goto L70
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r23);     // Catch: Exception -> L13
        Object r0 = ((Result) r23).unbox-impl();     // Catch: Exception -> L13
    L33:
        if (Result.isFailure-impl(r0) == false) goto L35;
        r0 = null;
    L35:
        String r7 = (String) r0;     // Catch: Exception -> L13
        if (r7 != null) goto L84;
    L43:
        boolean r8 = true;
    L44:
        if (r8 == false) goto L51;
        pk4.j.f("DoraGFeedbackViewModel", "compress video failed, will upload uncompressed local file. uri = " + this.this$0.a);     // Catch: Exception -> L41
    L41:
        e = e;
        String r14 = r7;
    L50:
        pk4.j.g("DoraGFeedbackViewModel", "compress video error, will upload uncompressed local file. uri = " + this.this$0.a, e);     // Catch: Exception -> L80
        r7 = r14;
    L51:
        this.this$0.j = false;     // Catch: Exception -> L80
        if (r7 != null) goto L54;
    L57:
        boolean r15 = true;
    L58:
        if (r15 == true) goto L60;
        pk4.j.d("DoraGFeedbackViewModel", "upload compressed video path = " + r7);     // Catch: Exception -> L80
        this.$continuation.resumeWith(Result.constructor-impl(r7));     // Catch: Exception -> L80
        goto L83
    L60:
        pk4.j.d("DoraGFeedbackViewModel", "upload uncompressed local video path = " + r5);     // Catch: Exception -> L80
        this.$continuation.resumeWith(Result.constructor-impl(r5));     // Catch: Exception -> L80
        goto L83
    L54:
        if (r7.length() == 0) goto L57;
        r15 = false;
        goto L58
    L84:
        if (r7.length() == 0) goto L43;
        r8 = false;
    L13:
        e = e;
    L14:
        r14 = null;
        goto L50
    L15:
        ResultKt.throwOnFailure(r23);
        g r9 = this.this$0;     // Catch: Exception -> L80
        if (r9.f == false) goto L61;
        int r11 = s0.a;     // Catch: Exception -> L80
        String r16 = s0.a(g.a(r9), this.this$0.a);     // Catch: Exception -> L80
        if (r16 != null) goto L21;
    L24:
        boolean r17 = true;
    L25:
        if (r17 == false) goto L86;
        kotlinx.coroutines.i<String> r18 = this.$continuation;     // Catch: Exception -> L80
        Result.Companion r20 = Result.Companion;     // Catch: Exception -> L80
        r18.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IOException("无法读取视频文件，请重新选择"))));     // Catch: Exception -> L80
        return Unit.INSTANCE;
    L86:
        t0 r21 = t0.a;     // Catch: Exception -> L48
        String r22 = "compressed_video_" + System.currentTimeMillis();     // Catch: Exception -> L48
        a r24 = new a(this.this$0);     // Catch: Exception -> L48
        this.L$0 = r16;     // Catch: Exception -> L48
        this.label = 1;     // Catch: Exception -> L48
        r0 = r21.a(r16, r22, r24, this);     // Catch: Exception -> L48
        if (r0 != r10) goto L31;
        return r10;
    L31:
        r5 = r16;
    L48:
        e = e;
        r5 = r16;
        goto L14
    L21:
        if (r16.length() == 0) goto L24;
        r17 = false;
        goto L25
    L61:
        ns8.a r25 = new ns8.a(Boxing.boxInt(1080), null, Boxing.boxInt(80), null, false, 232);     // Catch: Exception -> L80
        IAIChatUploadMediaService.Companion r26 = IAIChatUploadMediaService.a;     // Catch: Exception -> L80
        Uri r27 = this.this$0.a;     // Catch: Exception -> L80
        this.label = 2;     // Catch: Exception -> L80
        r1 = IAIChatUploadMediaService.a.a(r26, r27, r25, false, false, null, this, 56);     // Catch: Exception -> L80
        if (r1 != r10) goto L64;
        return r10;
    L80:
        e = move-exception;
        kotlinx.coroutines.i<String> r28 = this.$continuation;
        Result.Companion r30 = Result.Companion;
        r28.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
        goto L83
    }
}
