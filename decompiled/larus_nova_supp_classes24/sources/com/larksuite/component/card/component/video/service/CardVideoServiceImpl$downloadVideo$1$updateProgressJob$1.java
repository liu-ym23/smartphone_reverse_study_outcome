package com.larksuite.component.card.component.video.service;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.component.card.component.video.service.CardVideoServiceImpl$downloadVideo$1$updateProgressJob$1", f = "CardVideoServiceImpl.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, s = {})
public final class CardVideoServiceImpl$downloadVideo$1$updateProgressJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Integer> $downloadFlow;
    final /* synthetic */ String $sessionID;
    final /* synthetic */ com.ss.android.lark.widget.photo.preview.video.online.c $videoGalleryView;
    int label;

    /* JADX INFO: renamed from: com.larksuite.component.card.component.video.service.CardVideoServiceImpl$downloadVideo$1$updateProgressJob$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.component.card.component.video.service.CardVideoServiceImpl$downloadVideo$1$updateProgressJob$1$1", f = "CardVideoServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super Integer>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $sessionID;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(String r1, Continuation<? super AnonymousClass1> r2) {
            this.$sessionID = r1;
            super(3, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((FlowCollector) r1, (Throwable) r2, (Continuation) r3);
        }

        public final Object invoke(FlowCollector<? super Integer> r2, Throwable r3, Continuation<? super Unit> r4) {
            AnonymousClass1 r5 = new AnonymousClass1(this.$sessionID, r4);
            r5.L$0 = r3;
            return r5.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            if ((((Throwable) this.L$0) instanceof CancellationException) == false) goto L8;
            StringBuilder r3 = new StringBuilder();
            WeakReference<CardVideoServiceImpl> r0 = CardVideoServiceImpl.c;
            r3.append(CardVideoServiceImpl.a.a(this.$sessionID));
            r3.append(" download progress flow cancelled");
            Log.d("CardVideoService", r3.toString());
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ com.ss.android.lark.widget.photo.preview.video.online.c a;

        public a(com.ss.android.lark.widget.photo.preview.video.online.c r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            int r3 = ((Number) r1).intValue();
            com.ss.android.lark.widget.photo.preview.video.online.c r4 = this.a;
            if (r4 == null) goto L6;
            r4.f4(r3);
        L6:
            return Unit.INSTANCE;
        }
    }

    public CardVideoServiceImpl$downloadVideo$1$updateProgressJob$1(Flow<Integer> r1, String r2, com.ss.android.lark.widget.photo.preview.video.online.c r3, Continuation<? super CardVideoServiceImpl$downloadVideo$1$updateProgressJob$1> r4) {
        this.$downloadFlow = r1;
        this.$sessionID = r2;
        this.$videoGalleryView = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CardVideoServiceImpl$downloadVideo$1$updateProgressJob$1(this.$downloadFlow, this.$sessionID, this.$videoGalleryView, r5);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FlowKt__EmittersKt$onCompletion$.inlined.unsafeFlow.1 r3 = new FlowKt__EmittersKt$onCompletion$.inlined.unsafeFlow.1(this.$downloadFlow, new AnonymousClass1(this.$sessionID, null));
        a r7 = new a(this.$videoGalleryView);
        this.label = 1;
        if (r3.collect(r7, this) != r0) goto L12;
        return r0;
    }
}
