package com.larus.audio.audiov3.task.sami.v2;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.audiov3.task.tts.TtsEventEnum;
import com.larus.audio.flow.client.cache.TtsCacheManager;
import kotlin.Lazy;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.audiov3.task.sami.v2.TtsCacheTask$prepareData$1", f = "TtsCacheTask.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
public final class TtsCacheTask$prepareData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $bufferSize;
    int label;
    final /* synthetic */ TtsCacheTask this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ TtsCacheTask a;

        public a(TtsCacheTask r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            byte[] r4 = (byte[]) r2;
            int r5 = c68.b.a;
            this.a.getClass();
            c68.b.a("TtsCacheTask", "ttsContentData:" + r4.length);
            l68.b r6 = this.a.a;
            if (r6 == null) goto L6;
            r6.b(r4, true);
        L6:
            return Unit.INSTANCE;
        }
    }

    public TtsCacheTask$prepareData$1(TtsCacheTask r1, int r2, Continuation<? super TtsCacheTask$prepareData$1> r3) {
        this.this$0 = r1;
        this.$bufferSize = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TtsCacheTask$prepareData$1(this.this$0, this.$bufferSize, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L23:
        l68.b r2 = this.this$0.a;
        if (r2 == null) goto L30;
        l68.b.a.a(r2, TtsEventEnum.TTS_END, null, 0, null, null, 30);
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        Lazy r12 = TtsCacheManager.a;
        String r13 = this.this$0.e;
        if (r13 != null) goto L11;
        r13 = "";
    L11:
        int r3 = this.$bufferSize;
        Intrinsics.checkNotNullParameter(r13, "key");
        Flow<byte[]> r4 = TtsCacheManager.d().query(r13, r3);
        int r5 = c68.b.a;
        StringBuilder r6 = new StringBuilder("getTtsCacheData key = ");
        r6.append(r13);
        r6.append(", result is null = ");
        if (r4 != null) goto L14;
        boolean r14 = true;
    L15:
        r6.append(r14);
        c68.b.a("TtsCacheManager", r6.toString());
        if (r4 == null) goto L26;
        l68.b r7 = this.this$0.a;
        if (r7 == null) goto L20;
        l68.b.a.a(r7, TtsEventEnum.TTS_FIRST_PACKAGE, null, 0, null, null, 30);
    L20:
        a r15 = new a(this.this$0);
        this.label = 1;
        if (r4.collect(r15, this) != r0) goto L23;
        return r0;
    L26:
        l68.b r8 = this.this$0.a;
        if (r8 == null) goto L30;
        l68.b.a.a(r8, TtsEventEnum.TTS_TASK_FAILED, null, 0, null, null, 30);
        goto L30
    L14:
        r14 = false;
        goto L15
    }
}
