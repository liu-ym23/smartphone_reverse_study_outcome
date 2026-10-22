package com.obric.audio.continuous_talk.session.impl.plugin;

import aha.s;
import com.larus.im.bean.message.Message;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt$observeAllStates$$inlined$map$1;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.session.impl.plugin.ObricContTalkPlugin$onStart$2", f = "ObricContTalkPlugin.kt", i = {}, l = {357}, m = "invokeSuspend", n = {}, s = {})
public final class ObricContTalkPlugin$onStart$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricContTalkPlugin this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricContTalkPlugin a;

        public a(ObricContTalkPlugin r1) {
            this.a = r1;
        }

        public final Object emit(Object r6, Continuation r7) {
            aha.q r8 = (aha.q) ((Pair) r6).component2();
            ObricContTalkPlugin r9 = this.a;
            r9.getClass();
            if ((r8 instanceof aha.q.a) == false) goto L36;
            aha.q.a r10 = (aha.q.a) r8;
            Message r0 = r10.g;
            if (r0 == null) goto L36;
            if (r9.j3(r10.d, r0) == false) goto L36;
            String r11 = r10.e;
            boolean r1 = true;
            if (r11 != null) goto L14;
        L17:
            boolean r3 = true;
        L18:
            String r4 = null;
            if (r3 == false) goto L22;
            r11 = null;
        L22:
            if (r11 != null) goto L34;
            String r12 = r0.getMessageId();
            if (r12 != null) goto L26;
        L29:
            if (r1 == true) goto L31;
            r4 = r12;
        L31:
            if (r4 == null) goto L36;
            r11 = r4;
            goto L34
        L26:
            if (r12.length() == 0) goto L29;
            r1 = false;
        L34:
            com.larus.audio.call.util.e.a.i(r9.f, "sync active continuous talk reply messageId: ".concat(r11));
            ((com.obric.audio.continuous_talk.session.impl.a) r9.getContext()).g(r11);
            goto L36
        L14:
            if (r11.length() == 0) goto L17;
            r3 = false;
        L36:
            return Unit.INSTANCE;
        }
    }

    public ObricContTalkPlugin$onStart$2(ObricContTalkPlugin r1, Continuation<? super ObricContTalkPlugin$onStart$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricContTalkPlugin$onStart$2(this.this$0, r3);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        s r6 = s.a;
        TaskFlowDslKt$observeAllStates$$inlined$map$1 r7 = TaskFlowDslKt.a();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
