package com.larus.doc.impl.chat;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.outerinput.OuterInputEventBus;
import com.larus.utils.logger.FLogger;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.chat.DocFloatChatComponent$onParentViewCreated$2", f = "DocFloatChatComponent.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
public final class DocFloatChatComponent$onParentViewCreated$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionBarScene;
    int label;
    final /* synthetic */ DocFloatChatComponent this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ String a;
        public final /* synthetic */ DocFloatChatComponent b;

        public a(String r1, DocFloatChatComponent r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r3, Continuation r4) {
            int r5 = ((Number) r3).intValue();
            FLogger.a.i("DocFloatChatComponent", "chatInputText statusChanged, newStatus = " + r5);
            Fragment r6 = com.larus.doc.impl.chat.a.a();
            if (r6 == null) goto L5;
            String r7 = r6.getTag();
        L7:
            if (Intrinsics.areEqual(r7, "tag_doc_chat_fragment") == true) goto L14;
            if (Intrinsics.areEqual(this.a, "doc_create_list") == false) goto L14;
            DocFloatChatComponent r8 = this.b;
            int r0 = DocFloatChatComponent.r;
            o r9 = (o) r8.l.getValue();
            if (r9 == null) goto L14;
            r9.B90(r5);
        L14:
            return Unit.INSTANCE;
        L5:
            r7 = null;
            goto L7
        }
    }

    public DocFloatChatComponent$onParentViewCreated$2(String r1, DocFloatChatComponent r2, Continuation<? super DocFloatChatComponent$onParentViewCreated$2> r3) {
        this.$actionBarScene = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DocFloatChatComponent$onParentViewCreated$2(this.$actionBarScene, this.this$0, r4);
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
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        MutableSharedFlow r7 = OuterInputEventBus.a;
        MutableSharedFlow r8 = OuterInputEventBus.a;
        a r2 = new a(this.$actionBarScene, this.this$0);
        this.label = 1;
        if (r8.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
