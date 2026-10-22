package com.larus.voicecall.impl.scene;

import com.larus.im.bean.bot.SceneModel;
import com.larus.utils.t0;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.scene.RealtimeCallSceneManager$1", f = "RealtimeCallSceneManager.kt", i = {}, l = {MessageContentType.EXPERT}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallSceneManager$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ k this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ k a;

        public a(k r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            int r8 = ((Number) r6).intValue();
            RealtimeCallUtil.a.getClass();
            if (RealtimeCallUtil.l == null) goto L52;
            Iterator<o> r9 = this.a.g.iterator();
        L7:
            if (r9.hasNext() == false) goto L35;
            o r0 = r9.next();
            r0.getClass();
            RealtimeCallUtil.a.getClass();
            o r1 = RealtimeCallUtil.l;
            boolean r2 = true;
            boolean r3 = false;
            if (r1 == null) goto L15;
            SceneModel r4 = r1.a;
            if (r4 == null) goto L15;
            if (r4.getId() != r0.a.getId()) goto L15;
            boolean r5 = true;
        L16:
            if (r5 == false) goto L7;
            if (r8 == 2) goto L20;
            if (r0.d == false) goto L7;
            if (r0.a.getTriggerContinueInterval() != 0) goto L32;
            r2 = false;
        L32:
            if (r2 == false) goto L7;
            t0.b.removeCallbacks(r0.c);
            r0.d = false;
            goto L7
        L20:
            if (r0.a.getTriggerContinueInterval() == 0) goto L22;
            r3 = true;
        L22:
            if (r3 == false) goto L7;
            if (r0.d == true) goto L7;
            r0.d = true;
            t0.b.postDelayed(r0.c, r0.a.getTriggerContinueInterval());
        L15:
            r5 = false;
            goto L16
        L35:
            return Unit.INSTANCE;
        L52:
            return Unit.INSTANCE;
        }
    }

    public RealtimeCallSceneManager$1(k r1, Continuation<? super RealtimeCallSceneManager$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new RealtimeCallSceneManager$1(this.this$0, r3);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MutableSharedFlow r6 = this.this$0.a.d();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
