package com.larus.uaigc.chat.block.create;

import com.larus.common_ui.video.VideoPlayView;
import com.tencent.open.log.TraceLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.RichMediaCreationVideoPlaybackController$bindPlayObservers$2", f = "RichMediaCreationClickServiceImpl.kt", i = {}, l = {930}, m = "invokeSuspend", n = {}, s = {})
final class RichMediaCreationVideoPlaybackController$bindPlayObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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

        public final Object emit(Object r3, Continuation r4) {
            Pair r5 = (Pair) r3;
            String r6 = (String) r5.component1();
            boolean r7 = ((Boolean) r5.component2()).booleanValue();
            kh8.a r0 = this.a.c();
            if (r0 == null) goto L5;
            String r1 = r0.b();
        L7:
            if (Intrinsics.areEqual(r1, this.b) == false) goto L21;
            if (Intrinsics.areEqual(r6, this.b) == false) goto L21;
            RichMediaCreationVideoPlaybackController r8 = this.a;
            r8.l = !r7;
            if (r7 == false) goto L16;
            VideoPlayView r9 = r8.a;
            if (r9 == null) goto L22;
            VideoPlayView.H(r9, 0, 2);
        L22:
            return Unit.INSTANCE;
        L16:
            VideoPlayView r10 = r8.a;
            if (r10 == null) goto L22;
            VideoPlayView.z(r10, 0, 2);
        L21:
            return Unit.INSTANCE;
        L5:
            r1 = null;
            goto L7
        }
    }

    public RichMediaCreationVideoPlaybackController$bindPlayObservers$2(RichMediaCreationVideoPlaybackController r1, String r2, Continuation<? super RichMediaCreationVideoPlaybackController$bindPlayObservers$2> r3) {
        this.this$0 = r1;
        this.$vid = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RichMediaCreationVideoPlaybackController$bindPlayObservers$2(this.this$0, this.$vid, r4);
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
        MutableSharedFlow r8 = r7.i();
        if (r8 == null) goto L18;
        a r2 = new a(this.this$0, this.$vid);
        this.label = 1;
        if (r8.collect(r2, this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
