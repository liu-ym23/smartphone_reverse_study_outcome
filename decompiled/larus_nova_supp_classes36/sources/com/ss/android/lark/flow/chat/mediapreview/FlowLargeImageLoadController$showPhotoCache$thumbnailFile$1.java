package com.ss.android.lark.flow.chat.mediapreview;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.widget.photo.preview.utils.PhotoItemImageType;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageLoadController$showPhotoCache$thumbnailFile$1", f = "FlowLargeImageLoadController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowLargeImageLoadController$showPhotoCache$thumbnailFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ IRequestCreator $imageLoader;
    final /* synthetic */ PhotoItem $photoItem;
    int label;
    final /* synthetic */ FlowLargeImageLoadController this$0;

    public FlowLargeImageLoadController$showPhotoCache$thumbnailFile$1(FlowLargeImageLoadController r1, IRequestCreator r2, PhotoItem r3, Continuation<? super FlowLargeImageLoadController$showPhotoCache$thumbnailFile$1> r4) {
        this.this$0 = r1;
        this.$imageLoader = r2;
        this.$photoItem = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowLargeImageLoadController$showPhotoCache$thumbnailFile$1(this.this$0, this.$imageLoader, this.$photoItem, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super File> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        PhotoUtilsNew r1 = PhotoUtilsNew.a;
        FlowLargeImageLoadController r9 = this.this$0;
        return r1.d(r9.a, this.$imageLoader, this.$photoItem, PhotoItemImageType.Thumbnail, r9.d);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
