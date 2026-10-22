package com.larus.uaigc.chat.block.create;

import com.larus.common_ui.video.VideoPlayView;
import com.larus.platform.api.IVideoController;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.RichMediaCreationVideoPlaybackController$bindPlayObservers$1", f = "RichMediaCreationClickServiceImpl.kt", i = {}, l = {918}, m = "invokeSuspend", n = {}, s = {})
final class RichMediaCreationVideoPlaybackController$bindPlayObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $vid;
    int label;
    final /* synthetic */ RichMediaCreationVideoPlaybackController this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ RichMediaCreationVideoPlaybackController a;
        public final /* synthetic */ String b;

        public a(RichMediaCreationVideoPlaybackController r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r8, Continuation r9) {
            String r10 = (String) r8;
            VideoPlayView r11 = this.a.a;
            if (r11 != null) goto L6;
            return Unit.INSTANCE;
        L6:
            if (Intrinsics.areEqual(r10, this.b) == false) goto L20;
            RichMediaCreationVideoPlaybackController r12 = this.a;
            if (r12.l == true) goto L20;
            IVideoController.PlayType r2 = IVideoController.PlayType.PLAY;
            String r13 = r12.i;
            IVideoController.PlayType r3 = null;
            if (r13 != null) goto L12;
            IVideoController r14 = null;
        L13:
            if (r14 == null) goto L15;
            r3 = r14.d();
        L15:
            if (r2 == r3) goto L22;
            if (this.a.m == false) goto L19;
            VideoPlayView.H(r11, 0, 2);
            goto L22
        L19:
            r11.M();
        L22:
            return Unit.INSTANCE;
        L12:
            r14 = IAIChatUgcAIGCService.a.L().a(r13, "ugc_video", "message_card");
        L20:
            VideoPlayView.z(r11, 0, 2);
            goto L22
        }
    }

    public RichMediaCreationVideoPlaybackController$bindPlayObservers$1(RichMediaCreationVideoPlaybackController r1, String r2, Continuation<? super RichMediaCreationVideoPlaybackController$bindPlayObservers$1> r3) {
        this.this$0 = r1;
        this.$vid = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RichMediaCreationVideoPlaybackController$bindPlayObservers$1(this.this$0, this.$vid, r4);
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
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        kh8.a r7 = this.this$0.c();
        if (r7 == null) goto L18;
        MutableSharedFlow r8 = r7.h();
        if (r8 == null) goto L18;
        a r2 = new a(this.this$0, this.$vid);
        this.label = 1;
        if (r8.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
