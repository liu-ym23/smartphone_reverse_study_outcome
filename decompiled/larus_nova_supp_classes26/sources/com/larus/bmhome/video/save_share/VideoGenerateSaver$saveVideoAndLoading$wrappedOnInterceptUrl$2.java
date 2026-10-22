package com.larus.bmhome.video.save_share;

import com.larus.platform.spi.IAIChatUgcAIGCService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.save_share.VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$2", f = "VideoGenerateSaver.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
public final class VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$2 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $subScene;
    final /* synthetic */ nr9.g $videoContent;
    int label;

    public VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$2(nr9.g r1, String r2, Continuation<? super VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$2> r3) {
        this.$videoContent = r1;
        this.$subScene = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new VideoGenerateSaver$saveVideoAndLoading$wrappedOnInterceptUrl$2(this.$videoContent, this.$subScene, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super String> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L20:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        IAIChatUgcAIGCService.Companion r6 = IAIChatUgcAIGCService.a;
        nr9.g r2 = this.$videoContent;
        if (r2 == null) goto L11;
        String r3 = r2.c;
    L12:
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        String r4 = this.$subScene;
        if (r4 != null) goto L17;
        r4 = "video";
    L17:
        this.label = 1;
        r5 = IAIChatUgcAIGCService.a.d(r6, r3, "Creation", r4, this);
        if (r5 != r0) goto L20;
        return r0;
    L11:
        r3 = null;
        goto L12
    }
}
