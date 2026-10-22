package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.net.Uri;
import com.larus.uaigc.helper.CreationImageUploadPolicy;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$onAlbumSelected$1$preprocessJob$1", f = "ImageSelectorComponent.kt", i = {}, l = {1697}, m = "invokeSuspend", n = {}, s = {})
public final class ImageSelectorComponent$onAlbumSelected$1$preprocessJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ic8.n0>, Object> {
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$onAlbumSelected$1$preprocessJob$1(Uri r1, ImageSelectorComponent r2, Continuation<? super ImageSelectorComponent$onAlbumSelected$1$preprocessJob$1> r3) {
        this.$uri = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ImageSelectorComponent$onAlbumSelected$1$preprocessJob$1(this.$uri, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ic8.n0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L20:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CreationImageUploadPolicy r7 = CreationImageUploadPolicy.a;
        Uri r2 = this.$uri;
        ImageSelectorComponent r3 = this.this$0;
        Lazy<Long> r4 = ImageSelectorComponent.X;
        ny9.s r5 = r3.G3();
        if (r5 != null) goto L11;
    L13:
        boolean r8 = false;
    L14:
        if (r8 == false) goto L16;
        String r9 = "ai_beautify";
    L17:
        this.label = 1;
        r6 = r7.a(r2, r9, null, this);
        if (r6 != r0) goto L20;
        return r0;
    L16:
        r9 = "video_gen";
        goto L17
    L11:
        if (r5.B() != true) goto L13;
        r8 = true;
        goto L14
    }
}
