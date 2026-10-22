package com.larus.audio.flow.client.cache;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
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
@DebugMetadata(c = "com.larus.audio.flow.client.cache.TtsCacheManager$registerTtsEventListener$1", f = "TtsCacheManager.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
final class TtsCacheManager$registerTtsEventListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public static final class a<T> implements FlowCollector {
        public static final a<T> a = null;

        /* JADX INFO: renamed from: com.larus.audio.flow.client.cache.TtsCacheManager$registerTtsEventListener$1$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0084a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TtsEventEnum.values().length];
                r0[TtsEventEnum.TTS_SESSION_STARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r0[TtsEventEnum.TTS_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r0[TtsEventEnum.TTS_TASK_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r0[TtsEventEnum.TTS_SESSION_FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r0[TtsEventEnum.TTS_NETWORK_FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                a = r0;
            }
        }

        static {
            a = new a();
        }

        public a() {
        }

        public final Object emit(Object r3, Continuation r4) {
            TtsEventEnum r5 = (TtsEventEnum) r3;
            int r6 = c68.b.a;
            c68.b.a("TtsCacheManager", "ttsSamiEventFlow = " + r5);
            int r7 = C0084a.a[r5.ordinal()];
            if (r7 != 1) goto L5;
            Lazy r8 = TtsCacheManager.a;
            TtsCacheManager.h = false;
            int r9 = d.a;
            TtsCacheManager.i = d.a(TtsCacheManager.b, TtsCacheManager.c, TtsCacheManager.d, TtsCacheManager.e);
            com.larus.audio.flow.client.cache.a r10 = TtsCacheManager.d();
            String r11 = TtsCacheManager.i;
            if (r11 != null) goto L18;
            r11 = "";
        L18:
            r10.c(r11);
        L20:
            return Unit.INSTANCE;
        L5:
            if (r7 != 2) goto L7;
            Lazy r12 = TtsCacheManager.a;
            TtsCacheManager.h = true;
            TtsCacheManager.a();
            goto L20
        L7:
            if (r7 != 3) goto L9;
        L13:
            Lazy r13 = TtsCacheManager.a;
            TtsCacheManager.h = false;
            TtsCacheManager.a();
            goto L20
        L9:
            if (r7 == 4) goto L13;
            if (r7 == 5) goto L13;
            goto L13
        }
    }

    public TtsCacheManager$registerTtsEventListener$1(Continuation<? super TtsCacheManager$registerTtsEventListener$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new TtsCacheManager$registerTtsEventListener$1(r2);
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
        MutableSharedFlow<TtsEventEnum> r6 = f.a;
        FlowCollector r2 = a.a;
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
