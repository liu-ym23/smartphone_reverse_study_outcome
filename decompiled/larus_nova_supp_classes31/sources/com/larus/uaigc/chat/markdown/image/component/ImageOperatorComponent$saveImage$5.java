package com.larus.uaigc.chat.markdown.image.component;

import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.uaigc.service.IUgcAIGCService;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.component.ImageOperatorComponent$saveImage$5", f = "ImageOperatorComponent.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
public final class ImageOperatorComponent$saveImage$5 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ ImageInfo $imageInfo;
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ String $subScene;
    int label;

    public ImageOperatorComponent$saveImage$5(String r1, String r2, ImageInfo r3, Continuation<? super ImageOperatorComponent$saveImage$5> r4) {
        this.$imageUrl = r1;
        this.$subScene = r2;
        this.$imageInfo = r3;
        super(1, r4);
    }

    public final Continuation<Unit> create(Continuation<?> r5) {
        return new ImageOperatorComponent$saveImage$5(this.$imageUrl, this.$subScene, this.$imageInfo, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super String> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L37:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        IUgcAIGCService.Companion r2 = IUgcAIGCService.a;
        String r12 = this.$imageUrl;
        String r4 = this.$subScene;
        ImageInfo r7 = this.$imageInfo;
        if (r7 == null) goto L16;
        Image r8 = r7.a;
        if (r8 == null) goto L16;
        String r9 = r8.e;
        if (r9 == null) goto L16;
    L15:
        String r10 = r9;
    L34:
        this.label = 1;
        r11 = r2.D(r12, "Creation", r4, "image", true, r10, this);
        if (r11 != r0) goto L37;
        return r0;
    L16:
        r9 = null;
        if (r7 == null) goto L21;
        Image r13 = r7.c;
        if (r13 == null) goto L21;
        String r14 = r13.e;
    L22:
        if (r14 != null) goto L33;
        if (r7 == null) goto L27;
        Image r15 = r7.b;
        if (r15 == null) goto L27;
        r14 = r15.e;
    L28:
        if (r14 != null) goto L33;
        if (r7 == null) goto L15;
        Image r16 = r7.i;
        if (r16 == null) goto L15;
        r10 = r16.e;
    L27:
        r14 = null;
    L33:
        r10 = r14;
    L21:
        r14 = null;
        goto L22
    }
}
