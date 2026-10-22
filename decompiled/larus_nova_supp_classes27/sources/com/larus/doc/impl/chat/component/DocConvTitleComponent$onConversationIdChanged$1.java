package com.larus.doc.impl.chat.component;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.utils.logger.FLogger;
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
import va8.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.chat.component.DocConvTitleComponent$onConversationIdChanged$1", f = "DocConvTitleComponent.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
public final class DocConvTitleComponent$onConversationIdChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $convId;
    int label;
    final /* synthetic */ DocConvTitleComponent this$0;

    public DocConvTitleComponent$onConversationIdChanged$1(String r1, DocConvTitleComponent r2, Continuation<? super DocConvTitleComponent$onConversationIdChanged$1> r3) {
        this.$convId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DocConvTitleComponent$onConversationIdChanged$1(this.$convId, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L14:
        wc9.e r11 = (wc9.e) r10;
        if (r11 == null) goto L28;
        String r12 = r11.c;
        if (r12 == null) goto L28;
        DocConvTitleComponent r2 = this.this$0;
        FLogger.a.i("DocConvTitleComponent", "onConversationIdChanged, conv name = ".concat(r12));
        r r3 = (r) r2.o.getValue();
        if (r3 == null) goto L21;
        String r4 = r3.WE();
    L23:
        if (Intrinsics.areEqual(r4, "doc_create_list") == true) goto L28;
        np8.a r5 = (np8.a) r2.m.getValue();
        if (r5 == null) goto L28;
        r5.setTitle(r12);
        goto L28
    L21:
        r4 = null;
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        IConversationRepoService r6 = RepoDispatcherDelegate.b.f();
        String r13 = this.$convId;
        if (r13 != null) goto L11;
        r13 = "";
    L11:
        this.label = 1;
        r10 = IConversationRepoService.a.c(r6, r13, false, null, this, 6);
        if (r10 != r0) goto L14;
        return r0;
    }
}
