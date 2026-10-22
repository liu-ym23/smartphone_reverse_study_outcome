package com.larus.voicecall.impl.component.videosubtitle;

import com.larus.voicecall.impl.subtitle.q0;
import com.larus.voicecall.impl.subtitle.y0;
import com.lynx.tasm.LynxTemplateRender;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.component.videosubtitle.VideoSubtitleComponent$observeSubtitleData$1", f = "VideoSubtitleComponent.kt", i = {}, l = {247}, m = "invokeSuspend", n = {}, s = {})
final class VideoSubtitleComponent$observeSubtitleData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VideoSubtitleComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ VideoSubtitleComponent a;

        public a(VideoSubtitleComponent r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            y0 r4 = (y0) r2;
            VideoSubtitleComponent r5 = this.a;
            q0 r6 = (q0) r5.r.getValue();
            if (r6 == null) goto L13;
            ArrayList<com.larus.voicecall.impl.subtitle.c> r7 = r6.o;
            if (r7 == null) goto L13;
            int r8 = CollectionsKt.getLastIndex(r7);
            if (r8 < 0) goto L13;
            int r0 = r5.s;
            if (r0 < 0) goto L13;
            if (r8 > r0) goto L13;
            boolean r9 = true;
        L14:
            r5.m3(LynxTemplateRender.RENDER_PHASE_UPDATE, r9);
            return Unit.INSTANCE;
        L13:
            r9 = false;
            goto L14
        }
    }

    public VideoSubtitleComponent$observeSubtitleData$1(VideoSubtitleComponent r1, Continuation<? super VideoSubtitleComponent$observeSubtitleData$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new VideoSubtitleComponent$observeSubtitleData$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L28:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        VideoSubtitleComponent r6 = this.this$0;
        q0 r2 = (q0) r6.r.getValue();
        if (r2 == null) goto L19;
        ArrayList<com.larus.voicecall.impl.subtitle.c> r3 = r2.o;
        if (r3 == null) goto L19;
        int r4 = CollectionsKt.getLastIndex(r3);
        if (r4 < 0) goto L19;
        int r7 = r6.s;
        if (r7 < 0) goto L19;
        if (r4 > r7) goto L19;
        boolean r8 = true;
    L20:
        r6.m3("init", r8);
        q0 r9 = (q0) this.this$0.r.getValue();
        if (r9 == null) goto L30;
        MutableSharedFlow r10 = r9.i;
        if (r10 == null) goto L30;
        a r11 = new a(this.this$0);
        this.label = 1;
        if (r10.collect(r11, this) != r0) goto L28;
        return r0;
    L30:
        return Unit.INSTANCE;
    L19:
        r8 = false;
        goto L20
    }
}
