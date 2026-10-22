package com.larus.bmhome.music.player;

import android.os.Looper;
import android.text.TextUtils;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.IVideoController;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.player.VideoEngineMusicPlayerViewImpl$bindData$1", f = "VideoEngineMusicPlayerBuilder.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
public final class VideoEngineMusicPlayerViewImpl$bindData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $bindSame;
    final /* synthetic */ j $musicPlayerData;
    final /* synthetic */ CoroutineScope $scope;
    int label;
    final /* synthetic */ VideoEngineMusicPlayerViewImpl this$0;

    public VideoEngineMusicPlayerViewImpl$bindData$1(VideoEngineMusicPlayerViewImpl r1, j r2, boolean r3, CoroutineScope r4, Continuation<? super VideoEngineMusicPlayerViewImpl$bindData$1> r5) {
        this.this$0 = r1;
        this.$musicPlayerData = r2;
        this.$bindSame = r3;
        this.$scope = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new VideoEngineMusicPlayerViewImpl$bindData$1(this.this$0, this.$musicPlayerData, this.$bindSame, this.$scope, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Boolean r2 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L16:
        VideoEngineMusicPlayerViewImpl r15 = this.this$0;
        boolean r3 = VideoEngineMusicPlayerViewImpl.I;
        if (r15.D() == true) goto L19;
    L21:
        this.this$0.Lr();
        this.this$0.H(false);
        IVideoController.PlayType r4 = IVideoController.PlayType.PLAY;
    L22:
        r15.y = r4;
        VideoEngineMusicPlayerViewImpl r16 = this.this$0;
        r16.getClass();
        FLogger r5 = FLogger.a;
        r5.d("SimpleMusicPlayerViewImpl", "[getVideoModelAndPlay] chatMessageId:" + r16.t() + ", vid:" + r16.x());
        IVideoController r6 = r16.w;
        if (r6 == null) goto L25;
        r6.q(r16.z, r16.t());
    L25:
        IVideoController r7 = r16.w;
        if (r7 == null) goto L28;
        String r8 = r7.getMediaId();
    L29:
        r5.d("SimpleMusicPlayerViewImpl", "[judgeIsNeedAutoPlay] chatMessageId:" + r16.t() + ", vid:" + r16.x() + ", mediaId:" + r8);
        StringBuilder r9 = new StringBuilder();
        j r10 = r16.c;
        if (r10 == null) goto L32;
        String r11 = r10.o();
    L33:
        r9.append(r11);
        r9.append(r16.t());
        if (Intrinsics.areEqual(r9.toString(), r8) == false) goto L42;
        IVideoController r12 = r16.w;
        if (r12 != null) goto L38;
    L40:
        boolean r13 = false;
    L41:
        if (r13 == true) goto L42;
    L78:
        return Unit.INSTANCE;
    L38:
        if (r12.p3() == true) goto L40;
        r13 = true;
    L42:
        boolean r17 = r16.D();
        boolean r18 = r16.E();
        r5.d("SimpleMusicPlayerViewImpl", "[judgeIsNeedAutoPlay] chatMessageId:" + r16.t() + ", vid:" + r16.x() + ", isSameMedia:" + r17 + ", isVideoPlaying:" + r18);
        if (r17 == false) goto L46;
        if (r18 == true) goto L78;
    L46:
        StringBuilder r19 = new StringBuilder("[judgeIsNeedAutoPlay] chatMessageId:");
        r19.append(r16.t());
        r19.append(", vid:");
        r19.append(r16.x());
        r19.append(", autoPlay:");
        j r20 = r16.c;
        if (r20 == null) goto L49;
        Boolean r21 = Boolean.valueOf(r20.b());
    L50:
        r19.append(r21);
        r19.append(", autoPlayMulti:");
        r19.append(r16.r());
        r5.d("SimpleMusicPlayerViewImpl", r19.toString());
        j r22 = r16.c;
        if (r22 == null) goto L53;
        Boolean r23 = Boolean.valueOf(r22.b());
    L54:
        Boolean r24 = Boolean.TRUE;
        if (Intrinsics.areEqual(r23, r24) == false) goto L63;
        String r25 = r16.t();
        Message r26 = IAIChatUgcAIGCService.a.b0().b();
        if (r26 == null) goto L59;
        String r27 = r26.getMessageId();
    L61:
        if (TextUtils.equals(r25, r27) == false) goto L63;
    L64:
        j r28 = r16.c;
        if (r28 == null) goto L68;
        r2 = Boolean.valueOf(r28.b());
    L68:
        if (Intrinsics.areEqual(r2, r24) == false) goto L70;
    L71:
        r5.d("SimpleMusicPlayerViewImpl", "[judgeIsNeedAutoPlay] chatMessageId:" + r16.t() + ", vid:" + r16.x() + ", need auto play");
        b.a.getClass();
        if (b.a.i == false) goto L74;
    L76:
        r16.z(true, false, false);
        goto L78
    L74:
        if (Intrinsics.areEqual(r16.r(), r24) == true) goto L76;
        IAIChatUgcAIGCService.a.b0().a();
        goto L78
    L70:
        if (Intrinsics.areEqual(r16.r(), r24) == false) goto L78;
    L59:
        r27 = null;
    L63:
        if (Intrinsics.areEqual(r16.r(), r24) == false) goto L78;
    L53:
        r23 = null;
        goto L54
    L49:
        r21 = null;
        goto L50
    L32:
        r11 = null;
        goto L33
    L28:
        r8 = null;
        goto L29
    L19:
        if (this.this$0.E() == false) goto L21;
        this.this$0.A();
        this.this$0.C();
        this.this$0.L();
        r4 = IVideoController.PlayType.PAUSE;
        goto L22
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        VideoEngineMusicPlayerViewImpl r110 = this.this$0;
        long r29 = this.$musicPlayerData.b;
        boolean r30 = VideoEngineMusicPlayerViewImpl.I;
        r110.getClass();
        FLogger.a.d("SimpleMusicPlayerViewImpl", "[initProgressHandler] chatMessageId:" + r110.t() + ", vid:" + r110.x());
        r110.i = new VideoEngineMusicPlayerViewImpl.d(r110, r110, r29);
        VideoEngineMusicPlayerViewImpl.c r31 = new VideoEngineMusicPlayerViewImpl.c(r110, Looper.getMainLooper());
        r110.h = r31;
        VideoEngineMusicPlayerViewImpl.d r111 = r110.i;
        if (r111 == null) goto L12;
        r111.c = r31;
    L12:
        if (this.$bindSame == true) goto L16;
        this.this$0.J(false);
        Job r112 = BuildersKt.launch$default(this.$scope, kr8.t.a, null, new VideoEngineMusicPlayerViewImpl$bindData$1$initJob$1(this.this$0, null), 2, null);
        this.label = 1;
        if (r112.join(this) != r0) goto L16;
        return r0;
    }
}
