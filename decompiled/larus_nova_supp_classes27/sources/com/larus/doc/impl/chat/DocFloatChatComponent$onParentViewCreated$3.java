package com.larus.doc.impl.chat;

import com.larus.bmhome.chat.component.list.u7;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import va8.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.chat.DocFloatChatComponent$onParentViewCreated$3", f = "DocFloatChatComponent.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
public final class DocFloatChatComponent$onParentViewCreated$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionBarScene;
    int label;
    final /* synthetic */ DocFloatChatComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DocFloatChatComponent a;
        public final /* synthetic */ String b;

        public a(DocFloatChatComponent r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r5, Continuation r6) {
            Pair r7 = (Pair) r5;
            FLogger r8 = FLogger.a;
            StringBuilder r0 = new StringBuilder("getFloatChatCloseStatus, close = ");
            r0.append(((Boolean) r7.getFirst()).booleanValue());
            r0.append(", pageToken = ");
            r0.append((String) r7.getSecond());
            r0.append(", curDocId = ");
            DocFloatChatComponent r1 = this.a;
            int r2 = DocFloatChatComponent.r;
            g39.a r3 = r1.F2();
            String r4 = null;
            if (r3 == null) goto L5;
            String r9 = r3.RR();
        L6:
            r0.append(r9);
            r0.append(", ddxmlEnabled=");
            z2 r10 = z2.a;
            r0.append(r10.getAiDocDdxmlConfig().a());
            r8.i("DocFloatChatComponent", r0.toString());
            if (r10.getAiDocDdxmlConfig().a() == false) goto L20;
            if (Intrinsics.areEqual(this.b, "doc_create_list") == true) goto L20;
            if (((Boolean) r7.getFirst()).booleanValue() == false) goto L20;
            Object r11 = r7.getSecond();
            g39.a r12 = this.a.F2();
            if (r12 == null) goto L15;
            String r13 = r12.RR();
        L17:
            if (Intrinsics.areEqual(r11, r13) == false) goto L20;
            return Unit.INSTANCE;
        L15:
            r13 = null;
        L20:
            if (((Boolean) r7.getFirst()).booleanValue() == false) goto L30;
            Object r14 = r7.getSecond();
            g39.a r15 = this.a.F2();
            if (r15 == null) goto L25;
            r4 = r15.RR();
        L25:
            if (Intrinsics.areEqual(r14, r4) == false) goto L30;
            g0 r16 = (g0) this.a.o.getValue();
            if (r16 == null) goto L30;
            r16.km("auto_jump");
        L30:
            return Unit.INSTANCE;
        L5:
            r9 = null;
            goto L6
        }
    }

    public DocFloatChatComponent$onParentViewCreated$3(DocFloatChatComponent r1, String r2, Continuation<? super DocFloatChatComponent$onParentViewCreated$3> r3) {
        this.this$0 = r1;
        this.$actionBarScene = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DocFloatChatComponent$onParentViewCreated$3(this.this$0, this.$actionBarScene, r4);
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
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        t1a.b r7 = s1a.a.g(s1a.a.c(this.this$0));
        if (r7 == null) goto L20;
        u7 r8 = r7.getAbility(u7.class);
        if (r8 == null) goto L20;
        StateFlowImpl r9 = r8.Le();
        if (r9 == null) goto L20;
        Flow r10 = e.o(r9, new b());
        if (r10 == null) goto L20;
        a r2 = new a(this.this$0, this.$actionBarScene);
        this.label = 1;
        if (r10.collect(r2, this) != r0) goto L20;
        return r0;
    }
}
