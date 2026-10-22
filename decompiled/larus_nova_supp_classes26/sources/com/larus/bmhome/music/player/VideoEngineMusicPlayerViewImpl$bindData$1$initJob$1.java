package com.larus.bmhome.music.player;

import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.player.VideoEngineMusicPlayerViewImpl$bindData$1$initJob$1", f = "VideoEngineMusicPlayerBuilder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VideoEngineMusicPlayerViewImpl$bindData$1$initJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VideoEngineMusicPlayerViewImpl this$0;

    public VideoEngineMusicPlayerViewImpl$bindData$1$initJob$1(VideoEngineMusicPlayerViewImpl r1, Continuation<? super VideoEngineMusicPlayerViewImpl$bindData$1$initJob$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VideoEngineMusicPlayerViewImpl$bindData$1$initJob$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r3);
        VideoEngineMusicPlayerViewImpl r4 = this.this$0;
        boolean r0 = VideoEngineMusicPlayerViewImpl.I;
        if (r4.o == false) goto L16;
        if (r4.p == true) goto L16;
        if (TextUtils.isEmpty(r4.y()) == true) goto L16;
        List r1 = e2a.e.a;
        VideoEngineMusicPlayerViewImpl.g r5 = r4.E;
        if (r5 == null) goto L16;
        CopyOnWriteArrayList r2 = (CopyOnWriteArrayList) e2a.e.a;
        if (r2.contains(r5) == true) goto L16;
        r2.add(r5);
    L16:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
