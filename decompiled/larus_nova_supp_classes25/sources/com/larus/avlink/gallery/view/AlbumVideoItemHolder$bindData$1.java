package com.larus.avlink.gallery.view;

import android.content.Context;
import android.net.Uri;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.dora.VideoThumbnailHelper;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.larus.avlink.gallery.view.AlbumVideoItemHolder$bindData$1", f = "AlbumVideoItemHolder.kt", i = {}, l = {75, 81}, m = "invokeSuspend", n = {}, s = {})
final class AlbumVideoItemHolder$bindData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.larus.bmhome.bigimg.t1 $item;
    final /* synthetic */ String $mediaID;
    int label;
    final /* synthetic */ AlbumVideoItemHolder this$0;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.view.AlbumVideoItemHolder$bindData$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.view.AlbumVideoItemHolder$bindData$1$1", f = "AlbumVideoItemHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.bmhome.bigimg.t1 $item;
        final /* synthetic */ String $mediaID;
        final /* synthetic */ String $thumbnailPath;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AlbumVideoItemHolder this$0;

        public AnonymousClass1(String r1, String r2, AlbumVideoItemHolder r3, com.larus.bmhome.bigimg.t1 r4, Continuation<? super AnonymousClass1> r5) {
            this.$thumbnailPath = r1;
            this.$mediaID = r2;
            this.this$0 = r3;
            this.$item = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.$thumbnailPath, this.$mediaID, this.this$0, this.$item, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r10);
            CoroutineScope r11 = (CoroutineScope) this.L$0;
            String r12 = this.$thumbnailPath;
            if (r12 == null) goto L9;
            String r1 = this.$mediaID;
            AlbumVideoItemHolder r2 = this.this$0;
            FLogger.a.i("AlbumVideoItemHolder", "Thumbnail generated for mediaID: " + r1 + ", loading from: " + r12);
            int r0 = AlbumVideoItemHolder.k;
            ImageViewWithLastMotion r3 = r2.c;
            if (r3 == null) goto L11;
            ImageLoaderKt.x(r3, Uri.fromFile(new PolarisFileWrapper(r12)), null, null, new t(), 6);
        L11:
            return Unit.INSTANCE;
        L9:
            String r13 = this.$mediaID;
            com.larus.bmhome.bigimg.t1 r4 = this.$item;
            FLogger.a.w("AlbumVideoItemHolder", "Failed to generate thumbnail for mediaID: " + r13 + ", path: " + r4.getPath());
            goto L11
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AlbumVideoItemHolder$bindData$1(AlbumVideoItemHolder r1, String r2, com.larus.bmhome.bigimg.t1 r3, Continuation<? super AlbumVideoItemHolder$bindData$1> r4) {
        this.this$0 = r1;
        this.$mediaID = r2;
        this.$item = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AlbumVideoItemHolder$bindData$1(this.this$0, this.$mediaID, this.$item, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L19
    L22:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L19
    L16:
        String r4 = (String) r10;     // Catch: Exception -> L19
        MainCoroutineDispatcher r11 = Dispatchers.getMain();     // Catch: Exception -> L19
        AnonymousClass1 r2 = new AnonymousClass1(r4, this.$mediaID, this.this$0, this.$item, null);     // Catch: Exception -> L19
        this.label = 2;     // Catch: Exception -> L19
        if (BuildersKt.withContext(r11, r2, this) != r0) goto L22;
        return r0;
    L12:
        ResultKt.throwOnFailure(r10);
        int r12 = VideoThumbnailHelper.a;     // Catch: Exception -> L19
        Context r13 = ((RecyclerView.ViewHolder) this.this$0).itemView.getContext();     // Catch: Exception -> L19
        String r3 = this.$mediaID;     // Catch: Exception -> L19
        String r5 = this.$item.getPath();     // Catch: Exception -> L19
        this.label = 1;     // Catch: Exception -> L19
        r10 = VideoThumbnailHelper.a(r13, r3, r5, this);     // Catch: Exception -> L19
        if (r10 != r0) goto L16;
        return r0;
    L19:
        e = move-exception;
        FLogger.a.e("AlbumVideoItemHolder", "Error generating video thumbnail for mediaID: " + this.$mediaID + ", error: " + e.getMessage());
        goto L22
    }
}
