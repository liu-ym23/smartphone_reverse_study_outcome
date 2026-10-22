package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$onAlbumPreprocessed$2$2", f = "ImageSelectorComponent.kt", i = {}, l = {1599}, m = "invokeSuspend", n = {}, s = {})
public final class ImageSelectorComponent$onAlbumPreprocessed$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ic8.m0 $fileInfo;
    final /* synthetic */ String $localFilePath;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$onAlbumPreprocessed$2$2(ImageSelectorComponent r1, String r2, ic8.m0 r3, Continuation<? super ImageSelectorComponent$onAlbumPreprocessed$2$2> r4) {
        this.this$0 = r1;
        this.$localFilePath = r2;
        this.$fileInfo = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ImageSelectorComponent$onAlbumPreprocessed$2$2(this.this$0, this.$localFilePath, this.$fileInfo, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        ImageSelectorComponent r16 = this.this$0;
        Lazy<Long> r2 = ImageSelectorComponent.X;
        r16.getClass();
        r16.V = new c0(r16);
        r16.W = new d0(r16);
        final ImageSelectorComponent r3 = this.this$0;
        final String r4 = this.$localFilePath;
        final ic8.m0 r7 = this.$fileInfo;
        Function1 r5 = new w0(r3, r7);
        Function1 r6 = new x0(r3, r7, r4);
        this.label = 1;
        if (ImageSelectorComponent.o5(r3, r4, r5, r6, r7, null, null, null, null, this, 496) != r0) goto L12;
        return r0;
    }
}
