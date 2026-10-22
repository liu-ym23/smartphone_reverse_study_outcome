package com.ss.android.lark.flow.chat.mediapreview;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageLoadController$showPhotoCache$3", f = "FlowLargeImageLoadController.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
final class FlowLargeImageLoadController$showPhotoCache$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowLargeImageView.b $listener;
    final /* synthetic */ File $middleFile;
    final /* synthetic */ PhotoItem $photoItem;
    int label;
    final /* synthetic */ FlowLargeImageLoadController this$0;

    public FlowLargeImageLoadController$showPhotoCache$3(FlowLargeImageLoadController r1, PhotoItem r2, File r3, FlowLargeImageView.b r4, Continuation<? super FlowLargeImageLoadController$showPhotoCache$3> r5) {
        this.this$0 = r1;
        this.$photoItem = r2;
        this.$middleFile = r3;
        this.$listener = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new FlowLargeImageLoadController$showPhotoCache$3(this.this$0, this.$photoItem, this.$middleFile, this.$listener, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FlowLargeImageLoadController r7 = this.this$0;
        PhotoItem r2 = this.$photoItem;
        File r3 = this.$middleFile;
        FlowLargeImageView.b r4 = this.$listener;
        this.label = 1;
        if (r7.g(r2, r3, r4, this) != r0) goto L12;
        return r0;
    }
}
