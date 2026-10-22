package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.PublishAction$setCreationPublic$2", f = "PublishAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PublishAction$setCreationPublic$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ l0 $context;
    final /* synthetic */ String $creationId;
    final /* synthetic */ Pair<Boolean, String> $result;
    int label;
    final /* synthetic */ PublishAction this$0;

    public PublishAction$setCreationPublic$2(Pair<Boolean, String> r1, l0 r2, PublishAction r3, String r4, Continuation<? super PublishAction$setCreationPublic$2> r5) {
        this.$result = r1;
        this.$context = r2;
        this.this$0 = r3;
        this.$creationId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new PublishAction$setCreationPublic$2(this.$result, this.$context, this.this$0, this.$creationId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L31;
        ResultKt.throwOnFailure(r7);
        Pair<Boolean, String> r8 = this.$result;
        boolean r0 = false;
        if (r8 != null) goto L7;
    L9:
        boolean r9 = false;
    L11:
        if (r9 == false) goto L13;
        FLogger.a.i("PublishAction", "setCreationPublic success");
        t19.s r10 = t19.s.a;
        Context r1 = this.$context.getContext();
        r10.getClass();
        t19.s.p(r1, "已发布");
        PublishAction.b(this.this$0, this.$context, this.$creationId);
    L29:
        return Unit.INSTANCE;
    L13:
        FLogger r11 = FLogger.a;
        StringBuilder r3 = new StringBuilder("setCreationPublic failed: ");
        Pair<Boolean, String> r4 = this.$result;
        String r5 = null;
        if (r4 == null) goto L16;
        String r6 = (String) r4.getSecond();
    L17:
        r3.append(r6);
        r11.w("PublishAction", r3.toString());
        Pair<Boolean, String> r12 = this.$result;
        if (r12 == null) goto L26;
        String r13 = (String) r12.getSecond();
        if (r13 == null) goto L26;
        if (r13.length() <= 0) goto L24;
        r0 = true;
    L24:
        if (r0 == false) goto L26;
        r5 = r13;
    L26:
        if (r5 == null) goto L29;
        t19.s r14 = t19.s.a;
        Context r2 = this.$context.getContext();
        r14.getClass();
        t19.s.t(r2, r5);
        goto L29
    L16:
        r6 = null;
        goto L17
    L7:
        if (((Boolean) r8.getFirst()).booleanValue() != true) goto L9;
        r9 = true;
        goto L11
    L31:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
