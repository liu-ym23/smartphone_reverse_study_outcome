package com.larus.bmhome.chat.dora;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
@DebugMetadata(c = "com.larus.bmhome.chat.dora.VideoThumbnailHelper$getVideoThumbnailWithCacheFromLocal$2", f = "VideoThumbnailHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VideoThumbnailHelper$getVideoThumbnailWithCacheFromLocal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $videoPath;
    int label;

    public VideoThumbnailHelper$getVideoThumbnailWithCacheFromLocal$2(String r1, Context r2, Continuation<? super VideoThumbnailHelper$getVideoThumbnailWithCacheFromLocal$2> r3) {
        this.$videoPath = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VideoThumbnailHelper$getVideoThumbnailWithCacheFromLocal$2(this.$videoPath, this.$context, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r6);
    L20:
        e = move-exception;
        e.printStackTrace();
    L22:
        return null;
    L6:
        if (new PolarisFileWrapper(this.$videoPath).exists() == true) goto L8;
        return null;
    L8:
        PolarisFileWrapper r1 = new PolarisFileWrapper(this.$context.getCacheDir(), "video_thumb_" + this.$videoPath.hashCode() + ".jpg");     // Catch: Exception -> L20
        if (r1.exists() == true) goto L11;
        int r0 = VideoThumbnailHelper.a;     // Catch: Exception -> L20
        String r2 = this.$videoPath;     // Catch: Exception -> L20
        MediaMetadataRetriever r3 = new MediaMetadataRetriever();     // Catch: Exception -> L15
        r3.setDataSource(r2);     // Catch: Exception -> L15
        Bitmap r4 = r3.getFrameAtTime(0, 2);     // Catch: Exception -> L15
        r3.release();     // Catch: Exception -> L15
    L17:
        if (r4 == null) goto L22;
        VideoThumbnailHelper.c(r4, r1, 85);     // Catch: Exception -> L20
        return r1.getAbsolutePath();
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L20
        r4 = null;
        goto L17
    L11:
        return r1.getAbsolutePath();
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
