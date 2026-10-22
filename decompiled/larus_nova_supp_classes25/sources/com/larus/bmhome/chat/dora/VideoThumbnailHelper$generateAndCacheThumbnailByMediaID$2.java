package com.larus.bmhome.chat.dora;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.dora.VideoThumbnailHelper$generateAndCacheThumbnailByMediaID$2", f = "VideoThumbnailHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VideoThumbnailHelper$generateAndCacheThumbnailByMediaID$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $mediaID;
    final /* synthetic */ String $videoPath;
    int label;

    public VideoThumbnailHelper$generateAndCacheThumbnailByMediaID$2(String r1, String r2, Context r3, Continuation<? super VideoThumbnailHelper$generateAndCacheThumbnailByMediaID$2> r4) {
        this.$videoPath = r1;
        this.$mediaID = r2;
        this.$context = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new VideoThumbnailHelper$generateAndCacheThumbnailByMediaID$2(this.$videoPath, this.$mediaID, this.$context, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r10);
    L23:
        e = move-exception;
        FLogger.a.e("VideoThumbnailHelper", "Error generating thumbnail for mediaID: " + this.$mediaID + ", error: " + e.getMessage());
        e.printStackTrace();
    L25:
        return null;
    L6:
        if (new PolarisFileWrapper(this.$videoPath).exists() == true) goto L9;
        FLogger.a.w("VideoThumbnailHelper", "Video file not exists: " + this.$videoPath);     // Catch: Exception -> L23
        return null;
    L9:
        PolarisFileWrapper r6 = new PolarisFileWrapper(this.$context.getCacheDir(), "video_thumb_" + this.$mediaID.hashCode() + ".jpg");     // Catch: Exception -> L23
        if (r6.exists() == false) goto L13;
        FLogger.a.i("VideoThumbnailHelper", "Thumbnail cache already exists for mediaID: " + this.$mediaID);     // Catch: Exception -> L23
        return r6.getAbsolutePath();
    L13:
        FLogger r3 = FLogger.a;     // Catch: Exception -> L23
        r3.i("VideoThumbnailHelper", "Generating thumbnail for mediaID: " + this.$mediaID + ", path: " + this.$videoPath);     // Catch: Exception -> L23
        int r4 = VideoThumbnailHelper.a;     // Catch: Exception -> L23
        String r5 = this.$videoPath;     // Catch: Exception -> L23
        MediaMetadataRetriever r7 = new MediaMetadataRetriever();     // Catch: Exception -> L16
        r7.setDataSource(r5);     // Catch: Exception -> L16
        Bitmap r8 = r7.getFrameAtTime(0, 2);     // Catch: Exception -> L16
        r7.release();     // Catch: Exception -> L16
    L18:
        if (r8 == null) goto L21;
        String r2 = this.$mediaID;     // Catch: Exception -> L23
        VideoThumbnailHelper.c(r8, r6, 20);     // Catch: Exception -> L23
        r3.i("VideoThumbnailHelper", "Thumbnail generated successfully for mediaID: " + r2);     // Catch: Exception -> L23
        return r6.getAbsolutePath();
    L21:
        r3.w("VideoThumbnailHelper", "Failed to extract thumbnail for mediaID: " + this.$mediaID);     // Catch: Exception -> L23
        goto L25
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L23
        r8 = null;
        goto L18
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
