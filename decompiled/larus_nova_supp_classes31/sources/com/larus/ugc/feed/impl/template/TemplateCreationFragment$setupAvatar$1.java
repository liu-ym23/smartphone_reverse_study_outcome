package com.larus.ugc.feed.impl.template;

import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.template.TemplateCreationFragment$setupAvatar$1", f = "TemplateCreationFragment.kt", i = {}, l = {346}, m = "invokeSuspend", n = {}, s = {})
final class TemplateCreationFragment$setupAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TemplateCreationFragment this$0;

    public TemplateCreationFragment$setupAvatar$1(TemplateCreationFragment r1, String r2, Continuation<? super TemplateCreationFragment$setupAvatar$1> r3) {
        this.this$0 = r1;
        this.$userId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        TemplateCreationFragment$setupAvatar$1 r0 = new TemplateCreationFragment$setupAvatar$1(this.this$0, this.$userId, r5);
        r0.L$0 = r4;
        return r0;
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
        Object r2 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L15
    L13:
        Object r7 = Result.constructor-impl((String) r6);     // Catch: Throwable -> L15
    L18:
        if (Result.isFailure-impl(r7) == true) goto L21;
        r2 = r7;
    L21:
        String r3 = (String) r2;
        if (r3 == null) goto L24;
        SimpleDraweeView r8 = this.this$0.j;
        if (r8 == null) goto L29;
        ImageLoaderKt.u(r8, r3, "bot_ic_avatar_tag");
    L29:
        return Unit.INSTANCE;
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        String r10 = this.$userId;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L15
        CoroutineDispatcher r5 = Dispatchers.getIO();     // Catch: Throwable -> L15
        TemplateCreationFragment$setupAvatar$1$url$1$1 r11 = new TemplateCreationFragment$setupAvatar$1$url$1$1(r10, null);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r6 = BuildersKt.withContext(r5, r11, this);     // Catch: Throwable -> L15
        if (r6 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }
}
