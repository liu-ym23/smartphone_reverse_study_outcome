package com.larus.bmhome.video.save_share;

import com.larus.platform.spi.IAIChatUgcAIGCService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.save_share.VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$1", f = "VideoGenerateSaver.kt", i = {}, l = {70, 84}, m = "invokeSuspend", n = {}, s = {})
public final class VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $subScene;
    final /* synthetic */ nr9.g $videoContent;
    Object L$0;
    int label;

    public VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$1(nr9.g r1, String r2, Continuation<? super VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$1> r3) {
        this.$videoContent = r1;
        this.$subScene = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$1(this.$videoContent, this.$subScene, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super String> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L70:
        return r8;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        nr9.g r2 = (nr9.g) this.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L40
    L16:
        nr9.g r9 = (nr9.g) r8;     // Catch: Throwable -> L40
        if (r9 == null) goto L26;
        String r5 = r9.b;     // Catch: Throwable -> L40
        if (r2 == null) goto L21;
        String r6 = r2.b;     // Catch: Throwable -> L40
    L23:
        if (Intrinsics.areEqual(r5, r6) == true) goto L26;
        if (r2 == null) goto L26;
        r2.b = r9.b;     // Catch: Throwable -> L40
        goto L26
    L21:
        r6 = null;
    L26:
        if (r9 == null) goto L35;
        String r7 = r9.d;     // Catch: Throwable -> L40
        if (r2 == null) goto L30;
        String r10 = r2.d;     // Catch: Throwable -> L40
    L32:
        if (Intrinsics.areEqual(r7, r10) == true) goto L35;
        if (r2 == null) goto L35;
        r2.d = r9.d;     // Catch: Throwable -> L40
        goto L35
    L30:
        r10 = null;
    L35:
        if (r9 == null) goto L37;
        String r11 = r9.c;     // Catch: Throwable -> L40
    L38:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L40
    L43:
        if (Result.isFailure-impl(r12) == false) goto L45;
        r12 = null;
    L45:
        String r13 = (String) r12;
        if (r13 != null) goto L48;
    L58:
        IAIChatUgcAIGCService.Companion r14 = IAIChatUgcAIGCService.a;
        nr9.g r4 = this.$videoContent;
        if (r4 == null) goto L61;
        String r15 = r4.c;
    L62:
        if (r15 != null) goto L64;
        r15 = "";
    L64:
        String r16 = this.$subScene;
        if (r16 != null) goto L67;
        r16 = "video";
    L67:
        this.L$0 = null;
        this.label = 2;
        r8 = IAIChatUgcAIGCService.a.d(r14, r15, "Creation", r16, this);
        if (r8 != r0) goto L70;
        return r0;
    L61:
        r15 = null;
        goto L62
    L48:
        if (r13.length() > 0) goto L51;
        r3 = false;
    L51:
        if (r3 == true) goto L54;
        r13 = null;
    L54:
        if (r13 == null) goto L58;
        nr9.g r17 = this.$videoContent;
        if (r17 == null) goto L58;
        r17.c = r13;
        goto L58
    L37:
        r11 = null;
        goto L38
    L12:
        ResultKt.throwOnFailure(r8);
        r2 = this.$videoContent;
        VideoGenerateSaver r18 = VideoGenerateSaver.a;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L40
        IAIChatUgcAIGCService.Companion r20 = IAIChatUgcAIGCService.a;     // Catch: Throwable -> L40
        this.L$0 = r2;     // Catch: Throwable -> L40
        this.label = 1;     // Catch: Throwable -> L40
        r8 = r20.L0(r2, "download_save", null, this);     // Catch: Throwable -> L40
        if (r8 != r0) goto L16;
        return r0;
    L40:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L43
    }
}
