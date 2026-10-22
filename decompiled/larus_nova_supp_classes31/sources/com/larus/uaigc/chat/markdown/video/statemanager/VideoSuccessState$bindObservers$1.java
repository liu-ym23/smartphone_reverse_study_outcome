package com.larus.uaigc.chat.markdown.video.statemanager;

import com.larus.common_ui.video.VideoPlayView;
import com.larus.platform.api.IVideoController;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationSingleVideoBinding;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.video.statemanager.VideoSuccessState$bindObservers$1", f = "VideoSuccessState.kt", i = {}, l = {504}, m = "invokeSuspend", n = {}, s = {})
final class VideoSuccessState$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ nr9.g $videoPlayData;
    int label;
    final /* synthetic */ i this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ nr9.g a;
        public final /* synthetic */ i b;

        public a(nr9.g r1, i r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r5, Continuation r6) {
            String r7 = (String) r5;
            if (Intrinsics.areEqual(r7, this.a.a) == true) goto L5;
        L23:
            LarusWidgetMarkdownCreationSingleVideoBinding r8 = this.b.d0();
            if (r8 == null) goto L29;
            VideoPlayView r9 = r8.i;
            if (r9 == null) goto L29;
            VideoPlayView.z(r9, 0, 2);
        L29:
            return Unit.INSTANCE;
        L5:
            if (this.b.g == true) goto L23;
            FLogger.a.i("VideoSuccessState", "auto play video, vid: " + r7);
            IVideoController.PlayType r10 = IVideoController.PlayType.PLAY;
            IVideoController r11 = this.b.j();
            if (r11 == null) goto L9;
            IVideoController.PlayType r12 = r11.d();
        L10:
            if (r10 == r12) goto L29;
            i r13 = this.b;
            if (r13.m == false) goto L18;
            LarusWidgetMarkdownCreationSingleVideoBinding r14 = r13.d0();
            if (r14 == null) goto L29;
            VideoPlayView r15 = r14.i;
            if (r15 == null) goto L29;
            VideoPlayView.H(r15, 0, 2);
            goto L29
        L18:
            LarusWidgetMarkdownCreationSingleVideoBinding r16 = r13.d0();
            if (r16 == null) goto L29;
            VideoPlayView r17 = r16.i;
            if (r17 == null) goto L29;
            r17.M();
            goto L29
        L9:
            r12 = null;
            goto L10
        }
    }

    public VideoSuccessState$bindObservers$1(i r1, nr9.g r2, Continuation<? super VideoSuccessState$bindObservers$1> r3) {
        this.this$0 = r1;
        this.$videoPlayData = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VideoSuccessState$bindObservers$1(this.this$0, this.$videoPlayData, r4);
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
        i r7 = this.this$0;
        int r2 = i.n;
        kh8.a r8 = r7.h();
        if (r8 == null) goto L18;
        MutableSharedFlow r9 = r8.h();
        if (r9 == null) goto L18;
        a r3 = new a(this.$videoPlayData, this.this$0);
        this.label = 1;
        if (r9.collect(r3, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
