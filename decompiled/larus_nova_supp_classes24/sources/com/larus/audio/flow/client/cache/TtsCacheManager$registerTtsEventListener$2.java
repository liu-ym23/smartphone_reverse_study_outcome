package com.larus.audio.flow.client.cache;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.audiov3.task.tts.TtsState;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.larus.audio.flow.client.cache.TtsCacheManager$registerTtsEventListener$2", f = "TtsCacheManager.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
final class TtsCacheManager$registerTtsEventListener$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public static final class a<T> implements FlowCollector {
        public static final a<T> a = null;

        /* JADX INFO: renamed from: com.larus.audio.flow.client.cache.TtsCacheManager$registerTtsEventListener$2$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0085a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TtsState.values().length];
                r0[TtsState.TTS_STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
            L4:
                a = r0;
            }
        }

        static {
            a = new a();
        }

        public a() {
        }

        public final Object emit(Object r2, Continuation r3) {
            TtsState r4 = (TtsState) r2;
            int r5 = c68.b.a;
            c68.b.a("TtsCacheManager", "ttsEventFlow = " + r4);
            if (C0085a.a[r4.ordinal()] != 1) goto L6;
            TtsCacheManager.a();
        L6:
            return Unit.INSTANCE;
        }
    }

    public TtsCacheManager$registerTtsEventListener$2(Continuation<? super TtsCacheManager$registerTtsEventListener$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new TtsCacheManager$registerTtsEventListener$2(r2);
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
        MutableSharedFlow<TtsState> r6 = f.b;
        FlowCollector r2 = a.a;
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
