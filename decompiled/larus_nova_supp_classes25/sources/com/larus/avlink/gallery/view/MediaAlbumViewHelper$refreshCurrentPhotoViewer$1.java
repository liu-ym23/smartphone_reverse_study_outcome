package com.larus.avlink.gallery.view;

import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.bmhome.bigimg.BigImageLocalPhotoViewerDialog;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.view.MediaAlbumViewHelper$refreshCurrentPhotoViewer$1", f = "MediaAlbumViewHelper.kt", i = {}, l = {694}, m = "invokeSuspend", n = {}, s = {})
final class MediaAlbumViewHelper$refreshCurrentPhotoViewer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $mediaId;
    final /* synthetic */ MediaMetadata $metadata;
    int label;
    final /* synthetic */ MediaAlbumViewHelper this$0;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.view.MediaAlbumViewHelper$refreshCurrentPhotoViewer$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.view.MediaAlbumViewHelper$refreshCurrentPhotoViewer$1$1", f = "MediaAlbumViewHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $mediaId;
        final /* synthetic */ com.larus.bmhome.bigimg.t1 $mediaItem;
        int label;
        final /* synthetic */ MediaAlbumViewHelper this$0;

        public AnonymousClass1(MediaAlbumViewHelper r1, String r2, com.larus.bmhome.bigimg.t1 r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$mediaId = r2;
            this.$mediaItem = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$mediaId, this.$mediaItem, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r4);
            BigImageLocalPhotoViewerDialog r5 = this.this$0.g;
            if (r5 == null) goto L8;
            r5.m(this.$mediaId, this.$mediaItem.getPath(), this.$mediaItem);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MediaAlbumViewHelper$refreshCurrentPhotoViewer$1(MediaMetadata r1, MediaAlbumViewHelper r2, String r3, Continuation<? super MediaAlbumViewHelper$refreshCurrentPhotoViewer$1> r4) {
        this.$metadata = r1;
        this.this$0 = r2;
        this.$mediaId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MediaAlbumViewHelper$refreshCurrentPhotoViewer$1(this.$metadata, this.this$0, this.$mediaId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        int r9 = com.larus.avlink.gallery.i.a;
        MediaMetadata r10 = this.$metadata;
        com.larus.bmhome.bigimg.t1 r11 = com.larus.avlink.gallery.i.b(r10, false, r98.c.a(r10));
        if (r11 == null) goto L11;
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, this.$mediaId, r11, null);
        this.label = 1;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L16;
        return r0;
    L11:
        return Unit.INSTANCE;
    }
}
