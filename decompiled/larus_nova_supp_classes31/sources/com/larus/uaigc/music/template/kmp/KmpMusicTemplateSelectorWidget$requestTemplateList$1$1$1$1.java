package com.larus.uaigc.music.template.kmp;

import com.larus.uaigc.music.template.MusicTemplateRepository;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.template.kmp.KmpMusicTemplateSelectorWidget$requestTemplateList$1$1$1$1", f = "KmpMusicTemplateSelectorWidget.kt", i = {}, l = {256}, m = "invokeSuspend", n = {}, s = {})
public final class KmpMusicTemplateSelectorWidget$requestTemplateList$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ KmpMusicTemplateSelectorWidget this$0;

    public KmpMusicTemplateSelectorWidget$requestTemplateList$1$1$1$1(KmpMusicTemplateSelectorWidget r1, Continuation<? super KmpMusicTemplateSelectorWidget$requestTemplateList$1$1$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new KmpMusicTemplateSelectorWidget$requestTemplateList$1$1$1$1(this.this$0, r3);
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
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        KmpMusicTemplateSelectorWidget r5 = this.this$0;
        int r2 = KmpMusicTemplateSelectorWidget.l;
        r5.V5();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        MusicTemplateRepository r6 = MusicTemplateRepository.a;
        this.label = 1;
        if (r6.c(this) != r0) goto L11;
        return r0;
    }
}
