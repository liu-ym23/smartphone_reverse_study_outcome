package com.larus.slides.impl.chat.component;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import np8.a;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.chat.component.SlidesConvTitleComponent$onConversationIdChanged$1", f = "SlidesConvTitleComponent.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
public final class SlidesConvTitleComponent$onConversationIdChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $convId;
    int label;
    final /* synthetic */ SlidesConvTitleComponent this$0;

    public SlidesConvTitleComponent$onConversationIdChanged$1(String r1, SlidesConvTitleComponent r2, Continuation<? super SlidesConvTitleComponent$onConversationIdChanged$1> r3) {
        this.$convId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SlidesConvTitleComponent$onConversationIdChanged$1(this.$convId, this.this$0, r4);
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
    L11:
        e r11 = (e) r10;
        if (r11 == null) goto L19;
        String r12 = r11.c;
        if (r12 == null) goto L19;
        SlidesConvTitleComponent r2 = this.this$0;
        FLogger.a.i("SlidesConvTitleComponent", "onConversationIdChanged, conv name = ".concat(r12));
        int r3 = SlidesConvTitleComponent.p;
        a r4 = (a) r2.m.getValue();
        if (r4 == null) goto L19;
        r4.setTitle(r12);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        IConversationRepoService r5 = RepoDispatcherDelegate.b.f();
        String r6 = this.$convId;
        this.label = 1;
        r10 = IConversationRepoService.a.c(r5, r6, false, null, this, 6);
        if (r10 != r0) goto L11;
        return r0;
    }
}
