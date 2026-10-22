package com.larus.bmhome.video.save_share;

import android.graphics.Bitmap;
import com.larus.bmhome.music.save_video.q;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.save_share.VideoSRSaverHelper$hardWareEncode$2", f = "VideoSRSaverHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VideoSRSaverHelper$hardWareEncode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ List<Bitmap> $bitmaps;
    final /* synthetic */ q $muxerConfig;
    final /* synthetic */ String $tempPath;
    int label;
    final /* synthetic */ h this$0;

    public VideoSRSaverHelper$hardWareEncode$2(h r1, q r2, List<Bitmap> r3, String r4, Continuation<? super VideoSRSaverHelper$hardWareEncode$2> r5) {
        this.$muxerConfig = r2;
        this.$bitmaps = r3;
        this.$tempPath = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new VideoSRSaverHelper$hardWareEncode$2(null, this.$muxerConfig, this.$bitmaps, this.$tempPath, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<Object> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L5;
        ResultKt.throwOnFailure(r2);
        throw null;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
