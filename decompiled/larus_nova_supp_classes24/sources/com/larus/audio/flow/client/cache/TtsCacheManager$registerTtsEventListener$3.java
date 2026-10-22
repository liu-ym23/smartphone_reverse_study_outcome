package com.larus.audio.flow.client.cache;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.flow.client.cache.TtsCacheManager$registerTtsEventListener$3", f = "TtsCacheManager.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
final class TtsCacheManager$registerTtsEventListener$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public static final class a<T> implements FlowCollector {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object emit(Object r3, Continuation r4) {
            byte[] r5 = (byte[]) r3;
            int r6 = c68.b.a;
            c68.b.a("TtsCacheManager", "ttsContentData's size = " + r5.length);
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L9
            String r8 = TtsCacheManager.i;     // Catch: Throwable -> L9
            if (r8 == null) goto L6;
            Lazy r1 = TtsCacheManager.a;     // Catch: Throwable -> L9
            TtsCacheManager.d().b(r8, r5);     // Catch: Throwable -> L9
            Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L9
        L7:
            Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L9
        L11:
            Throwable r11 = Result.exceptionOrNull-impl(r10);
            if (r11 == null) goto L15;
            c68.b.c("TtsCacheManager", "ttsContentData error: ", r11);
        L15:
            return Unit.INSTANCE;
        L6:
            r9 = null;
        L9:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L11
        }
    }

    public TtsCacheManager$registerTtsEventListener$3(Continuation<? super TtsCacheManager$registerTtsEventListener$3> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new TtsCacheManager$registerTtsEventListener$3(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r4);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        MutableSharedFlow<TtsEventEnum> r5 = f.a;
        MutableSharedFlow<byte[]> r6 = f.c;
        FlowCollector r2 = a.a;
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
